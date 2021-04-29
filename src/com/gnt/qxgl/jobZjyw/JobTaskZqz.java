package com.gnt.qxgl.jobZjyw;

import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.hz2004.entity.HJXX_CZRKJBXXB;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_HJSPSQB;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_ZQZXXB;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzqyzresult;
import com.gnt.qxgl.service.Hz2004Service;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.Session;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * <功能概述>
 * 进行长三角一体化迁移证推送
 *
 * @author: 杨冬冬
 * @className: JobTaskZqzQyz
 * @package: com.gnt.qxgl.jobZjyw
 * @description: 介绍
 * @date: 2021-01-27 10:10
 */
public class JobTaskZqz {
    private static String postUrl = "";
    //迁移证
    private static String qyzSjblx = "010124";
    //准迁证
    private static String zqzSjblx = "010122";

    public JobTaskZqz() {
        postUrl = SystemConfig.getSystemConfig("receiveZqzQyzUrl");
    }

    /**
     * 推送准迁证方法
     */
    public void TackJobZqz() {
        String isZqzStatus = SystemConfig.getSystemConfig("isZqzStatus");
        System.out.println("-----JobTaskZqzQyz 长三角一体化----准迁证-----是否推送------" + isZqzStatus);
        String ZqzStatus = "true";
        //当状态为true的时候 才进入业务逻辑处理代码块
        if (ZqzStatus.equals(isZqzStatus)) {
            //获取到hz2004Service
            Hz2004Service apiService = (Hz2004Service) SpringContainer.getObject("hz2004Service");
            //根据配置文件中配置的省份查询准迁证信息
            String zqzQhdm = SystemConfig.getSystemConfig("zqzQhdm");

            String zqzIsstatus = SystemConfig.getSystemConfig("zqzIsstatus");

            List list = apiService.querySJ_HJSP_ZQZXXB(zqzIsstatus, zqzQhdm, 1, 10);
            System.out.println("待拼接准迁证数据有"+list.size()+"条!");
            //循环遍历没有进行报送的迁移证
            for (Object o : list) {
                SJ_HJSP_ZQZXXB hjsp_zqzxxb = (SJ_HJSP_ZQZXXB) o;
                //根据sfz号码查询人口信息
                HJXX_CZRKJBXXB hjxx_czrkjbxxb = null;
                //暂时没有用到
                //HJXX_CZRKJBXXB hjxx_czrkjbxxb = queryCzrkjbxxb(hjsp_zqzxxb.getSqrgmsfhm());
                String qyzxxXml = getZqzxxXml(apiService, hjsp_zqzxxb, hjxx_czrkjbxxb);
                System.out.println("推送准迁证xml:" + qyzxxXml);
                String result = sendPost_httpClient(qyzxxXml);
                System.out.println("准迁证响应内容为:" + result);

                InputSource source = new InputSource(new StringReader(result));
                SAXReader reader = new SAXReader();
                Document document1 = null;
                try {
                    document1 = reader.read(source);
                    //获取根节点属性对象
                    Element rootElem = document1.getRootElement();


                    //显示根节点的名字
                    System.out.println("节点名字" + rootElem.getName());
                    //获取head节点属性对象
                    Element headElem = rootElem.element("head");
                    List<Element> elements = headElem.elements();
                    //1.反射，得到类的引用
                    Class zjywZqzqyzresult = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzqyzresult");
                    //通过类的引用，得到类的对象
                    Object stuInstance = zjywZqzqyzresult.newInstance();
                    for (Iterator<Element> it = elements.iterator(); it.hasNext(); ) {
                        Element element = it.next();
                        //循环获取属性名
                        String conAttrName = element.getName();
                        if (conAttrName.equals("license")) {
                            continue;
                        }
                        //分别每个节点的值内容
                        String conTxt = element.getStringValue();
                        //通过elemetname得到对应的get set方法，先拼接出方法名，比如 name--setName
                        String funName = "set" + (conAttrName.charAt(0) + "").toUpperCase() + conAttrName.substring(1);
                        //通过方法名反射出方法对象
                        Method method1 = zjywZqzqyzresult.getDeclaredMethod(funName, String.class);
                        //通过反射调用方法，调用stuInstance对象的method方法，参数为stuData---给各属性赋值
                        method1.invoke(stuInstance, conTxt);
                    }
                    ZjywZqzqyzresult zqzqyzresult = (ZjywZqzqyzresult) stuInstance;
                    zqzqyzresult.setZqzbh(hjsp_zqzxxb.getZjbh());
                    zqzqyzresult.setYwlsh(hjsp_zqzxxb.getZqid());
                    zqzqyzresult.setMsg("推送到第三方准迁证反馈信息：------"+zqzqyzresult.getMsg());
                    zqzqyzresult.setCjsj(new Date());
                    apiService.saveZjywZqzqyzresult(zqzqyzresult);

                    //获取head节点属性对象
                    Element codeElem = headElem.element("code");
                    String conTxt = codeElem.getStringValue();
                    if (conTxt.equals("00")) {
                        hjsp_zqzxxb.setIsstatus("1");
                        apiService.updateSJ_HJSP_ZQZXXB(hjsp_zqzxxb);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
           /* Map<String, Object> qyrxxMap = new HashMap<>();
            qyrxxMap.put("ywlsh", zjywZqzxx.getYwlsh());
            Page pageQyrxx = apiService.queryZqzQyrxx(qyrxxMap, 1, 10);
            List<ZjywZqzQyrxx> zqzQyrxxList = pageQyrxx.getList();
            for (ZjywZqzQyrxx zjywZqzQyrxx : zqzQyrxxList) {
                //根据身份证号码查询迁移证信息
            }*/
        }
    }

    public static String sendPost_httpClient(String data) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Post请求
        HttpPost httpPost = new HttpPost(postUrl);
        StringEntity entity = new StringEntity(data, "UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/xml");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {

                return EntityUtils.toString(responseEntity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 根据身份证号码需要从HJSP_HJSPSQB 这个表取联系电话
     *
     * @param sfz
     * @return
     */
    public HJXX_CZRKJBXXB queryhjspHjspsqb(String sfz) {
        String w1 = "";
        if (!"".equals(sfz)) {
            w1 += " a.gmsfhm='" + sfz + "'";
        }
        String qcrSQL = "from HJXX_CZRKJBXXB a "
                + " where a.ryzt = '0' and a.cxbz = '0' and a.jlbz = '1' and (" + w1 + ")";
        Session session_form = HibernateUtil.getSystemSessionFactory(sfz.substring(0, 4)).openSession();
        List<HJXX_CZRKJBXXB> qcrList = HibernateUtil.getObjectList(session_form, qcrSQL, new Object[]{});
        //根据上面条件查询得到唯一的一条数据
        HJXX_CZRKJBXXB hjxx_czrkjbxxb = qcrList.get(0);
        return hjxx_czrkjbxxb;
    }

    /**
     * 查询地市单位信息表
     *
     * @param pzjg
     * @param ssxq
     * @return
     */
    public XtDwxxb getDwxxb(String pzjg, String ssxq) {
        String qcrSQL = "from XtDwxxb a where a.mc like'%" + pzjg + "%' and a.qhdm = '" + ssxq + "' order by dwjgdm ASC";
        Session session_form = HibernateUtil.getSystemSessionFactory(ssxq.substring(0, 4)).openSession();
        XtDwxxb xtDwxxb = (XtDwxxb) HibernateUtil.getObject(session_form, qcrSQL, null);
        return xtDwxxb;
    }

    /**
     * 封装准迁证XML信息
     *
     * @param hjsp_zqzxxb
     * @param hjxx_czrkjbxxb
     */
    private String getZqzxxXml(Hz2004Service apiService, SJ_HJSP_ZQZXXB hjsp_zqzxxb, HJXX_CZRKJBXXB hjxx_czrkjbxxb) {
        // 创建文档。
        Document document = DocumentHelper.createDocument();
        // 文档增加节点，即根节点，一个文档只能有一个根节点，多加出错
        Element root = document.addElement("root");
        // 根节点下添加节点head
        Element head = root.addElement("head");
        // 节点添加属性
        //数据包类型
        head.addElement("sjblx").setText(zqzSjblx);
        //业务流水号
        head.addElement("ywlsh").setText(hjsp_zqzxxb.getZqid());
        head.addElement("zqzbh").setText(hjsp_zqzxxb.getZjbh());
        head.addElement("qyzbh").setText("");
        //授权码 随机生成32位或者36位字符串
        String license = UUID.randomUUID().toString();
        head.addElement("license").setText(license);
        //信息代码
        head.addElement("code").setText("00");
        //信息描述
        head.addElement("msg").setText("业务");
        // 根节点下添加节点head
        Element body = root.addElement("body");
        //业务流水号
        body.addElement("ywlsh").setText(hjsp_zqzxxb.getZqid() == null ? "" : hjsp_zqzxxb.getZqid());
        body.addElement("zqzbh").setText(hjsp_zqzxxb.getZjbh() == null ? "" : hjsp_zqzxxb.getZjbh());
        body.addElement("sqr_gmsfhm").setText(hjsp_zqzxxb.getSqrgmsfhm() == null ? "" : hjsp_zqzxxb.getSqrgmsfhm());
        body.addElement("sqr_xm").setText(hjsp_zqzxxb.getSqrxm() == null ? "" : hjsp_zqzxxb.getSqrxm());

        //根据审批业务ID 查询准迁证审批申请表
        SJ_HJSP_HJSPSQB sj_hjsp_hjspsqb = apiService.querySJ_HJSP_HJSPSQB(hjsp_zqzxxb.getSpywid());
        if (null != sj_hjsp_hjspsqb) {
            body.addElement("sqr_lxdh").setText(null == sj_hjsp_hjspsqb.getLxdh() ? "无" : sj_hjsp_hjspsqb.getLxdh());
        } else {
            body.addElement("sqr_lxdh").setText("无");
        }

        body.addElement("sqr_zz_ssxqdm").setText(hjsp_zqzxxb.getSqrzzssxq() == null ? "" : hjsp_zqzxxb.getSqrzzssxq());
        body.addElement("sqr_zz_qhnxxdz").setText(hjsp_zqzxxb.getSqrzzxz() == null ? "" : hjsp_zqzxxb.getSqrzzxz());

        //可以为空
        body.addElement("sqr_hkdjjg_gajgjgdm").setText("");
        //申请人_户口登记机关_公安机关名称
        body.addElement("sqr_hkdjjg_gajgmc").setText(hjsp_zqzxxb.getSqrhkdjjg());

        body.addElement("qcd_ssxqdm").setText(hjsp_zqzxxb.getQyrzzssxq() == null ? "" :hjsp_zqzxxb.getQyrzzssxq());
        body.addElement("qcd_qhnxxdz").setText(hjsp_zqzxxb.getQyrzzxz() == null ? "" : hjsp_zqzxxb.getQyrzzxz());


        body.addElement("qcd_hkdjjg_gajgjgdm").setText("");
        //迁出地_户口登记机关_公安机关名称
        body.addElement("qcd_hkdjjg_gajgmc").setText(hjsp_zqzxxb.getQyrhkdjjg());//20210312 孔庆涛 修改 原来 取值错误

        body.addElement("qrd_ssxqdm").setText(hjsp_zqzxxb.getQrdssxq() == null ? "" : hjsp_zqzxxb.getQrdssxq());
        body.addElement("qrd_qhnxxdz").setText(hjsp_zqzxxb.getQrdxz() == null ? "" : hjsp_zqzxxb.getQrdxz());

        //待确认
        body.addElement("qrd_hkdjjg_gajgjgdm").setText(hjsp_zqzxxb.getQrdhkdjjg() == null ? "" : hjsp_zqzxxb.getQrdhkdjjg());
        body.addElement("qrd_hkdjjg_gajgmc").setText(hjsp_zqzxxb.getPzjg() == null ? "" : hjsp_zqzxxb.getPzjg());
        //待确认
        body.addElement("qfjg_gajgjgdm").setText(hjsp_zqzxxb.getQrdhkdjjg() == null ? "" : hjsp_zqzxxb.getQrdhkdjjg());
        body.addElement("qfjg_gajgmc").setText(hjsp_zqzxxb.getPzjg() == null ? "" : hjsp_zqzxxb.getPzjg());

        body.addElement("cbr_xm").setText(hjsp_zqzxxb.getCbr() == null ? "" : hjsp_zqzxxb.getCbr());
        body.addElement("qfrq").setText(hjsp_zqzxxb.getQfrq() == null ? "" : hjsp_zqzxxb.getQfrq());
        body.addElement("bz").setText(hjsp_zqzxxb.getBz() == null ? "" : hjsp_zqzxxb.getBz());

        //待确认
        body.addElement("qyldyydm").setText(hjsp_zqzxxb.getQyyy() == null ? "" : hjsp_zqzxxb.getQyyy());
        //CS_QYLDYY  CS_QRLB
        String cs_qrlb = DictData.getCodeName("CS_QYLDYY", hjsp_zqzxxb.getQyyy());

        body.addElement("qyldyymc_nb").setText(cs_qrlb == null ? "" : cs_qrlb);

        body.addElement("yxqjzrq").setText(hjsp_zqzxxb.getYxqjzrq() == null ? "" : hjsp_zqzxxb.getYxqjzrq());
        body.addElement("qyfwdm").setText(hjsp_zqzxxb.getQyfw() == null ? "" : hjsp_zqzxxb.getQyfw());

        body.addElement("sldw_gajgjgdm").setText(hjsp_zqzxxb.getQrdhkdjjg() == null ? "" : hjsp_zqzxxb.getQrdhkdjjg());
        body.addElement("sldw_gajgmc").setText(hjsp_zqzxxb.getPzjg() == null ? "" : hjsp_zqzxxb.getPzjg());
        //机构翻译
        XtDwxxb sqrhkdjjg = getDwxxb(hjsp_zqzxxb.getPzjg(), hjsp_zqzxxb.getQrdssxq());
        //需要在人口系统的单位信息表中增加联系电话
        if (null != sqrhkdjjg) {
            body.addElement("sldw_lxdh").setText(sqrhkdjjg.getDhhm() == null ? "无" : sqrhkdjjg.getDhhm());
        } else {
            body.addElement("sldw_lxdh").setText("无");
        }
        body.addElement("slr_xm").setText(hjsp_zqzxxb.getCbr() == null ? "" : hjsp_zqzxxb.getCbr());
        body.addElement("slsj").setText(hjsp_zqzxxb.getDsgxsj() == null ? "" : hjsp_zqzxxb.getDsgxsj());

        body.addElement("sjgsdwdm").setText(hjsp_zqzxxb.getQrdhkdjjg() == null ? "" : hjsp_zqzxxb.getQrdhkdjjg());
        body.addElement("sjgsdwmc").setText(hjsp_zqzxxb.getPzjg() == null ? "" : hjsp_zqzxxb.getPzjg());

        // 如果迁移人1 不为空 那么在 body节点下添加节点qyr
        if (null != hjsp_zqzxxb.getQyrgmsfhm1()) {
            Element qyr = body.addElement("qyr");
            qyr.addAttribute("no", "1");
            qyr.addElement("zqzbh").setText(hjsp_zqzxxb.getZjbh());
            qyr.addElement("ysqrgx_jtgxdm").setText(hjsp_zqzxxb.getQyrysqrgx1() == null ? "" : hjsp_zqzxxb.getQyrysqrgx1());
            qyr.addElement("gmsfhm").setText(hjsp_zqzxxb.getQyrgmsfhm1() == null ? "" : hjsp_zqzxxb.getQyrgmsfhm1());
            qyr.addElement("xm").setText(hjsp_zqzxxb.getQyrxm1() == null ? "" : hjsp_zqzxxb.getQyrxm1());
            qyr.addElement("xbdm").setText(hjsp_zqzxxb.getQyrxb1() == null ? "" : hjsp_zqzxxb.getQyrxb1());
            qyr.addElement("csrq").setText(hjsp_zqzxxb.getQyrcsrq1() == null ? "" : hjsp_zqzxxb.getQyrcsrq1());
        }

        // 如果迁移人2 不为空 那么在 body节点下添加节点qyr
        if (null != hjsp_zqzxxb.getQyrgmsfhm2()) {
            Element qyr = body.addElement("qyr");
            qyr.addAttribute("no", "2");
            qyr.addElement("zqzbh").setText(hjsp_zqzxxb.getZjbh());
            qyr.addElement("ysqrgx_jtgxdm").setText(hjsp_zqzxxb.getQyrysqrgx2() == null ? "" : hjsp_zqzxxb.getQyrysqrgx2());
            qyr.addElement("gmsfhm").setText(hjsp_zqzxxb.getQyrgmsfhm2() == null ? "" : hjsp_zqzxxb.getQyrgmsfhm2());
            qyr.addElement("xm").setText(hjsp_zqzxxb.getQyrxm2() == null ? "" : hjsp_zqzxxb.getQyrxm2());
            qyr.addElement("xbdm").setText(hjsp_zqzxxb.getQyrxb2() == null ? "" : hjsp_zqzxxb.getQyrxb2());
            qyr.addElement("csrq").setText(hjsp_zqzxxb.getQyrcsrq2() == null ? "" : hjsp_zqzxxb.getQyrcsrq2());
        }

        // 如果迁移人3 不为空 那么在 body节点下添加节点qyr
        if (null != hjsp_zqzxxb.getQyrgmsfhm3()) {
            Element qyr = body.addElement("qyr");
            qyr.addAttribute("no", "3");
            qyr.addElement("zqzbh").setText(hjsp_zqzxxb.getZjbh());
            qyr.addElement("ysqrgx_jtgxdm").setText(hjsp_zqzxxb.getQyrysqrgx3() == null ? "" : hjsp_zqzxxb.getQyrysqrgx3());
            qyr.addElement("gmsfhm").setText(hjsp_zqzxxb.getQyrgmsfhm3() == null ? "" : hjsp_zqzxxb.getQyrgmsfhm3());
            qyr.addElement("xm").setText(hjsp_zqzxxb.getQyrxm3() == null ? "" : hjsp_zqzxxb.getQyrxm3());
            qyr.addElement("xbdm").setText(hjsp_zqzxxb.getQyrxb3() == null ? "" : hjsp_zqzxxb.getQyrxb3());
            qyr.addElement("csrq").setText(hjsp_zqzxxb.getQyrcsrq3() == null ? "" : hjsp_zqzxxb.getQyrcsrq3());
        }

        // 如果迁移人4 不为空 那么在 body节点下添加节点qyr
        if (null != hjsp_zqzxxb.getQyrgmsfhm4()) {
            Element qyr = body.addElement("qyr");
            qyr.addAttribute("no", "4");
            qyr.addElement("zqzbh").setText(hjsp_zqzxxb.getZjbh());
            qyr.addElement("ysqrgx_jtgxdm").setText(hjsp_zqzxxb.getQyrysqrgx4() == null ? "" : hjsp_zqzxxb.getQyrysqrgx4());
            qyr.addElement("gmsfhm").setText(hjsp_zqzxxb.getQyrgmsfhm4() == null ? "" : hjsp_zqzxxb.getQyrgmsfhm4());
            qyr.addElement("xm").setText(hjsp_zqzxxb.getQyrxm4() == null ? "" : hjsp_zqzxxb.getQyrxm4());
            qyr.addElement("xbdm").setText(hjsp_zqzxxb.getQyrxb4() == null ? "" : hjsp_zqzxxb.getQyrxb4());
            qyr.addElement("csrq").setText(hjsp_zqzxxb.getQyrcsrq4() == null ? "" : hjsp_zqzxxb.getQyrcsrq4());
        }
        String zqzXml = document.asXML();
        //System.out.println(qyzXml);
        return zqzXml;
    }

    public static void main(String[] args) {
        String a = UUID.randomUUID().toString();
        System.out.println(a.length());
    }
}
