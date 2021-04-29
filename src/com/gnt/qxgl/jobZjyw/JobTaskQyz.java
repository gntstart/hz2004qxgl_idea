package com.gnt.qxgl.jobZjyw;

import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.hz2004.entity.HJXX_CZRKJBXXB;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_QYZXXB;
import com.gnt.qxgl.hz2004.entity.SJ_HJYW_QCZXXXB;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzQyrxx;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzqyzresult;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzxx;
import com.gnt.qxgl.service.Hz2004Service;
import com.hzjc.hz2004.po.PoHJXX_RYZPXXB;
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
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <功能概述>
 * 进行长三角一体化 准迁证推送
 *
 * @author: 杨冬冬
 * @className: JobTaskQyzZqz
 * @package: com.gnt.qxgl.jobZjyw
 * @description: 介绍
 * @date: 2021-01-28 9:55
 */
public class JobTaskQyz {

    private static String postUrl = "";
    //迁移证
    private static String qyzSjblx = "010124";
    //准迁证
    private static String zqzSjblx = "010122";
    Hz2004Service apiService = null;

    public JobTaskQyz() {
        postUrl = SystemConfig.getSystemConfig("receiveZqzQyzUrl");
    }

    /**
     * 推送迁移证方法
     */
    public void TackJobQyz() {
        String isQyzStatus = SystemConfig.getSystemConfig("isQyzStatus");
        System.out.println("-----JobTaskQyz 长三角一体化-----迁移证----是否推送------" + isQyzStatus);
        String QyzStatus = "true";
        //当状态为true的时候 才进入业务逻辑处理代码块
        if (QyzStatus.equals(isQyzStatus)) {
            //获取到ywtbService
            apiService = (Hz2004Service) SpringContainer.getObject("hz2004Service");
            Map<String, Object> map = new HashMap<>();
            map.put("isstatus", "5");
            map.put("sfbj", "1");
            //查询第三方推送过来的准迁证
            Page page = apiService.queryZqzXx(map, 1, 10);
            System.out.println("迁移证数据开始推送：数量" + page.getList().size());
            if(null!=page) {
                       
            List<ZjywZqzxx> zqzxxList = page.getList();
            //循环遍历没有进行报送的迁移证
            for (ZjywZqzxx zjywZqzxx : zqzxxList) {
                System.out.println("根据准迁证号码查询SJ_HJYW_QCZXXXB表中的数据：" + zjywZqzxx.getZqzbh());

                SJ_HJYW_QCZXXXB sj_hjyw_qczxxxb = apiService.queryQczxxxb("", "", zjywZqzxx.getZqzbh());

                if (null != sj_hjyw_qczxxxb) {
                    //根据准迁证sfz号码查询 SJ_HJSP_QYZXXB表中的CZRGMSFHM（持证人公民身份号码）迁移人信息
                    Map<String, Object> qyrxxMap = new HashMap<>();
                    qyrxxMap.put("qyzbh", sj_hjyw_qczxxxb.getQyzbh().substring(1));//去掉皖 字
                    
                    //add by zjm 增加过滤条件，查询一个月内数据
                    Calendar now = Calendar.getInstance();
                    now.add(Calendar.DAY_OF_MONTH, -30);
                    String endDate = new SimpleDateFormat("yyyyMMddHHmmss").format(now.getTime());
                    System.out.println(endDate);
                    qyrxxMap.put("yyzqsj",endDate);
                    Page pageQyrxx = apiService.querySJ_HJSP_QYZXXB(qyrxxMap, 1, 10);
                    if(null!=pageQyrxx) {
                    	                 
                    List<SJ_HJSP_QYZXXB> zqzQyrxxList = pageQyrxx.getList();
                  

                    SJ_HJSP_QYZXXB sj_hjsp_qyzxxb = zqzQyrxxList.get(0);

                    //得到迁移证信息，进行xml封装
                    String qyzxxXml = getQyzxxXml(apiService, zjywZqzxx, sj_hjsp_qyzxxb);

                    System.out.println("推送迁移证xml数据：" + qyzxxXml);

                    String result = sendPost_httpClient(qyzxxXml);
                    System.out.println("迁移证响应内容为:" + result);
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
                        zqzqyzresult.setMsg("推送到第三方迁移证反馈信息：------" + zqzqyzresult.getMsg());
                        zqzqyzresult.setCjsj(new Date());
                        apiService.saveZjywZqzqyzresult(zqzqyzresult);

                        //获取head节点属性对象
                        Element codeElem = headElem.element("code");
                        String conTxt = codeElem.getStringValue();
                        if (conTxt.equals("00")) {
                            zjywZqzxx.setIsstatus("1");
                            apiService.updateZjywZqzxx(zjywZqzxx);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
        String result = null;
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                //System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
                result = EntityUtils.toString(responseEntity);
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
        return result;
    }

    /**
     * 根据身份证号码到地市库查询常驻人口基本信息1q2w3e!Q1
     *
     * @param sfz
     * @return
     */
    public HJXX_CZRKJBXXB queryCzrkjbxxb(String sfz, String yzzssxq) {
        String w1 = "";
        if (!"".equals(sfz)) {
            w1 += " a.gmsfhm='" + sfz + "'";
        }
        String qcrSQL = "from HJXX_CZRKJBXXB a "
                + " where a.ryzt = '2' and a.cxbz = '0' and a.jlbz = '1' and (" + w1 + ") ";// 20210307 kqt 删除这个and dsgxsj is not null order by dsgxsj desc 条件
        System.out.println("qcrSQL:" + qcrSQL);
        System.out.println("查询的地市代码：" + yzzssxq.substring(0, 4));
        Session session_form = HibernateUtil.getSystemSessionFactory(yzzssxq.substring(0, 4)).openSession();
        List<HJXX_CZRKJBXXB> qcrList = HibernateUtil.getObjectList(session_form, qcrSQL, new Object[]{});
        //根据上面条件查询得到唯一的一条数据
        HJXX_CZRKJBXXB hjxx_czrkjbxxb = null;
        if (qcrList.size() > 0) {
            hjxx_czrkjbxxb = qcrList.get(0);
            System.out.println("姓名：" + hjxx_czrkjbxxb.getXm());
        }
        return hjxx_czrkjbxxb;
    }


    /**
     * 封装迁移证XML信息
     *
     * @param zjywZqzxx
     * @param sj_hjsp_qyzxxb
     */
    private String getQyzxxXml(Hz2004Service apiService, ZjywZqzxx zjywZqzxx, SJ_HJSP_QYZXXB sj_hjsp_qyzxxb) {
        System.out.println("开始拼接xml数据");
        try {
            // 创建文档。
            Document document = DocumentHelper.createDocument();
            // 文档增加节点，即根节点，一个文档只能有一个根节点，多加出错
            Element root = document.addElement("root");
            // 根节点下添加节点head
            Element head = root.addElement("head");
            // 节点添加属性
            //数据包类型
            head.addElement("sjblx").setText(qyzSjblx);
            //业务流水号
            head.addElement("ywlsh").setText(zjywZqzxx.getYwlsh());
            head.addElement("zqzbh").setText(zjywZqzxx.getZqzbh());
            if (sj_hjsp_qyzxxb.getQyzbh().indexOf("皖") >= 0) {
                head.addElement("qyzbh").setText(sj_hjsp_qyzxxb.getQyzbh());
            } else {
                head.addElement("qyzbh").setText("皖" + sj_hjsp_qyzxxb.getQyzbh());
            }

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
            body.addElement("ywlsh").setText(zjywZqzxx.getYwlsh() == null ? "" : zjywZqzxx.getYwlsh());
            if (sj_hjsp_qyzxxb.getQyzbh().indexOf("皖") >= 0) {
                body.addElement("qyzbh").setText(sj_hjsp_qyzxxb.getQyzbh());
            } else {
                body.addElement("qyzbh").setText("皖" + sj_hjsp_qyzxxb.getQyzbh());
            }

            // 查询准迁证迁移人第一个人信息  作为主信息
            Map<String, Object> map = new HashMap<>();
            map.put("ywlsh", zjywZqzxx.getYwlsh());
            Page page = apiService.queryZqzQyrxx(map, 1, 10);
            List<ZjywZqzQyrxx> list = page.getList();
            ZjywZqzQyrxx zjywZqzQyrxx1 = list.get(0);
            //根据sfz号码查询人口信息
            System.out.println("根据身份证号码地市查询HJXX_CZRKJBXXB表中的数据：" + zjywZqzQyrxx1.getGmsfhm());
            HJXX_CZRKJBXXB hjxx_czrkjbxxb = queryCzrkjbxxb(zjywZqzQyrxx1.getGmsfhm(), zjywZqzxx.getQcd_hkdjjg_gajgjgdm());
            if (null != hjxx_czrkjbxxb) {

                System.out.println("查询到数据:" + hjxx_czrkjbxxb.getGmsfhm());

                body.addElement("czr_gmsfhm").setText(sj_hjsp_qyzxxb.getCzrgmsfhm() == null ? "" : sj_hjsp_qyzxxb.getCzrgmsfhm());
                body.addElement("czr_xm").setText(sj_hjsp_qyzxxb.getXm() == null ? "" : sj_hjsp_qyzxxb.getXm());
                //原住址省市县区代码
                body.addElement("yzz_ssxqdm").setText(sj_hjsp_qyzxxb.getYzzssxq() == null ? "" : sj_hjsp_qyzxxb.getYzzssxq());
                //原住址详地址
                body.addElement("yzz_qhnxxdz").setText(sj_hjsp_qyzxxb.getYzzxz() == null ? "" : sj_hjsp_qyzxxb.getYzzxz());
                
                /*
            	 * add by zjm 
            	 * 20210305
            	 * 迁移证报送的城乡属性取sj_hjyw_qczxxxb里面的CXFLDM这个字段
            	 */
                SJ_HJYW_QCZXXXB sj_hjyw_qczxxxbT = apiService.queryQczxxxb(zjywZqzQyrxx1.getGmsfhm(), sj_hjsp_qyzxxb.getQyzbh(), "");
                body.addElement("yzz_cxfldm").setText(sj_hjyw_qczxxxbT.getCxfldm() == null ? "" : sj_hjyw_qczxxxbT.getCxfldm());

                body.addElement("qwd_ssxqdm").setText(sj_hjsp_qyzxxb.getQwdssxq() == null ? "" : sj_hjsp_qyzxxb.getQwdssxq());
                body.addElement("qwd_qhnxxdz").setText(sj_hjsp_qyzxxb.getQwdxz() == null ? "" : sj_hjsp_qyzxxb.getQwdxz());
                //------待确认
                //机构翻译
                XtDwxxb sqrhkdjjg = apiService.queryXtDwxxbDm(hjxx_czrkjbxxb.getPcs(), hjxx_czrkjbxxb.getSsxq());
                body.addElement("qfjg_gajgjgdm").setText(hjxx_czrkjbxxb.getPcs());
                body.addElement("qfjg_gajgmc").setText(sqrhkdjjg.getMc());

                body.addElement("qfrq").setText(sj_hjsp_qyzxxb.getQfrq() == null ? "" : sj_hjsp_qyzxxb.getQfrq());
                body.addElement("yxqjzrq").setText(sj_hjsp_qyzxxb.getYxqxjzrq() == null ? "" : sj_hjsp_qyzxxb.getYxqxjzrq());
                body.addElement("cbr_xm").setText(sj_hjsp_qyzxxb.getCbr() == null ? "" : sj_hjsp_qyzxxb.getCbr());
                body.addElement("bz").setText(sj_hjsp_qyzxxb.getBz() == null ? "" : sj_hjsp_qyzxxb.getBz());
                body.addElement("zqzbh").setText(zjywZqzxx.getZqzbh() == null ? "" : zjywZqzxx.getZqzbh());
                body.addElement("qyfwdm").setText(hjxx_czrkjbxxb.getBdfw() == null ? "" : hjxx_czrkjbxxb.getBdfw());

                //待确认
                body.addElement("sldw_gajgjgdm").setText(hjxx_czrkjbxxb.getPcs() == null ? "" : hjxx_czrkjbxxb.getPcs());
                body.addElement("sldw_gajgmc").setText(sqrhkdjjg.getMc() == null ? "" : sqrhkdjjg.getMc());

                body.addElement("slr_xm").setText(sj_hjsp_qyzxxb.getCbr() == null ? "" : sj_hjsp_qyzxxb.getCbr());

                body.addElement("slsj").setText(sj_hjsp_qyzxxb.getDsgxsj() == null ? "" : sj_hjsp_qyzxxb.getDsgxsj());
                //待确认
                body.addElement("sjgsdwdm").setText(hjxx_czrkjbxxb.getPcs() == null ? "" : hjxx_czrkjbxxb.getPcs());
                body.addElement("sjgsdwmc").setText(sqrhkdjjg.getMc() == null ? "" : sqrhkdjjg.getMc());


                // 如果迁移人1 不为空 那么在 body节点下添加节点qyr
                if (list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
                        ZjywZqzQyrxx zjywZqzQyrxx = list.get(i);
                        //
                        System.out.println("查询迁出注销信息表sfz：" + zjywZqzQyrxx.getGmsfhm());
                        SJ_HJYW_QCZXXXB sj_hjyw_qczxxxb = apiService.queryQczxxxb(zjywZqzQyrxx.getGmsfhm(), sj_hjsp_qyzxxb.getQyzbh(), "");

                        System.out.println("已经查询到查询迁出注销信息表sfz：" + sj_hjyw_qczxxxb.getGmsfhm());
                        if (i == 0) {
                            //根据sfz号码查询人口信息
                            HJXX_CZRKJBXXB hjxx_czrkjbxxb1 = queryCzrkjbxxb(zjywZqzQyrxx.getGmsfhm(), sj_hjyw_qczxxxb.getPcs());
                            System.out.println("根据sfz号码查询人口信息1：" + zjywZqzQyrxx.getGmsfhm());
                            Element qyr = body.addElement("qyr");
                            qyr.addAttribute("no", "1");
                            qyr.addElement("qyzbh").setText(sj_hjyw_qczxxxb.getQyzbh());
                            qyr.addElement("yczrgx_jtgxdm").setText(sj_hjyw_qczxxxb.getSbrjtgx()== null ? sj_hjyw_qczxxxb.getYhzgx() : sj_hjyw_qczxxxb.getSbrjtgx());
                            qyr.addElement("gmsfhm").setText(sj_hjyw_qczxxxb.getGmsfhm() == null ? "" : sj_hjyw_qczxxxb.getGmsfhm());
                            qyr.addElement("xm").setText(sj_hjyw_qczxxxb.getXm() == null ? "" : sj_hjyw_qczxxxb.getXm());
                            qyr.addElement("cym").setText(null == hjxx_czrkjbxxb1.getCym() ? "" : hjxx_czrkjbxxb1.getCym());
                            qyr.addElement("xbdm").setText(sj_hjyw_qczxxxb.getXb() == null ? "" : sj_hjyw_qczxxxb.getXb());
                            qyr.addElement("mzdm").setText(sj_hjyw_qczxxxb.getMz() == null ? "" : sj_hjyw_qczxxxb.getMz());
                            qyr.addElement("csrq").setText(sj_hjyw_qczxxxb.getCsrq() == null ? "" : sj_hjyw_qczxxxb.getCsrq());
                            qyr.addElement("csd_gjhdqdm").setText("");
                            qyr.addElement("csd_ssxqdm").setText(sj_hjyw_qczxxxb.getCsdssxq() == null ? "" : sj_hjyw_qczxxxb.getCsdssxq());
                            qyr.addElement("csd_qhnxxdz").setText("");
                            qyr.addElement("jg_gjhdqdm").setText(null == hjxx_czrkjbxxb1.getJggjdq() ? "" : hjxx_czrkjbxxb1.getJggjdq());
                            qyr.addElement("jg_ssxqdm").setText(null == hjxx_czrkjbxxb1.getJgssxq() ? "" : hjxx_czrkjbxxb1.getJgssxq());
                            qyr.addElement("jg_qhnxxdz").setText(null == hjxx_czrkjbxxb1.getJgxz() ? "" : hjxx_czrkjbxxb1.getJgxz());
                            qyr.addElement("xldm").setText(null == hjxx_czrkjbxxb1.getWhcd() ? "" : hjxx_czrkjbxxb1.getWhcd());
                            qyr.addElement("hyzkdm").setText(null == hjxx_czrkjbxxb1.getHyzk() ? "" : hjxx_czrkjbxxb1.getHyzk());
                            qyr.addElement("zy").setText(null == hjxx_czrkjbxxb1.getZy() ? "" : hjxx_czrkjbxxb1.getZy());

                            //迁移（流动）原因代码
                            qyr.addElement("qyldyydm").setText(zjywZqzxx.getQyldyydm() == null ? "" : zjywZqzxx.getQyldyydm());
                            //迁移流动原因名称（内部） 汉字
                            qyr.addElement("qyldyymc_nb").setText(zjywZqzxx.getQyldyymc_nb() == null ? "" : zjywZqzxx.getQyldyymc_nb());
                            Map<String, Object> qyrMap = new HashMap<>();
                            qyrMap.put("gmsfhm", zjywZqzQyrxx.getGmsfhm());
                            qyrMap.put("dqbm", hjxx_czrkjbxxb1.getPcs());
                            PoHJXX_RYZPXXB poHJXX_ryzpxxb = apiService.queryZp(qyrMap);
                            //对字节数组Base64编码
                            BASE64Encoder encoder = new BASE64Encoder();
                            String base64 = "";
                            if (poHJXX_ryzpxxb != null) {
                                //返回Base64编码过的字节数组字符串
                                base64 = encoder.encode(poHJXX_ryzpxxb.getZp());
                            }
                            //相片 BASE64字符串
                            String strZp = base64.replaceAll("\r\n", "");
                            qyr.addElement("xp").setText(strZp);
                            //居民身份证签发机关
                            qyr.addElement("jmsfz_qfjg").setText(null == hjxx_czrkjbxxb1.getQfjg() ? "" : hjxx_czrkjbxxb1.getQfjg());
                            //有效期限起始日期
                            qyr.addElement("jmsfz_yxqxqsrq").setText(null == hjxx_czrkjbxxb1.getYxqxqsrq() ? "" : hjxx_czrkjbxxb1.getYxqxqsrq());
                            //有效期限截止日期
                            qyr.addElement("jmsfz_yxqxjzrq").setText(null == hjxx_czrkjbxxb1.getYxqxjzrq() ? "" : hjxx_czrkjbxxb1.getYxqxjzrq());
                            System.out.println("迁出注销1配置完毕");
                        }

                        // 如果迁移人2 不为空 那么在 body节点下添加节点qyr
                        if (i == 1) {
                            System.out.println("根据sfz号码查询人口信息2：" + zjywZqzQyrxx.getGmsfhm());
                            //根据sfz号码查询人口信息
                            HJXX_CZRKJBXXB hjxx_czrkjbxxb2 = queryCzrkjbxxb(zjywZqzQyrxx.getGmsfhm(), sj_hjyw_qczxxxb.getPcs());

                            Element qyr = body.addElement("qyr");
                            qyr.addAttribute("no", "2");
                            qyr.addElement("qyzbh").setText(sj_hjyw_qczxxxb.getQyzbh());
                            qyr.addElement("yczrgx_jtgxdm").setText(sj_hjyw_qczxxxb.getSbrjtgx()== null ? sj_hjyw_qczxxxb.getYhzgx() : sj_hjyw_qczxxxb.getSbrjtgx());
                            qyr.addElement("gmsfhm").setText(sj_hjyw_qczxxxb.getGmsfhm() == null ? "" : sj_hjyw_qczxxxb.getGmsfhm());
                            qyr.addElement("xm").setText(sj_hjyw_qczxxxb.getXm() == null ? "" : sj_hjyw_qczxxxb.getXm());
                            qyr.addElement("cym").setText(null == hjxx_czrkjbxxb2.getCym() ? "" : hjxx_czrkjbxxb2.getCym());
                            qyr.addElement("xbdm").setText(sj_hjyw_qczxxxb.getXb() == null ? "" : sj_hjyw_qczxxxb.getXb());
                            qyr.addElement("mzdm").setText(sj_hjyw_qczxxxb.getMz() == null ? "" : sj_hjyw_qczxxxb.getMz());
                            qyr.addElement("csrq").setText(sj_hjyw_qczxxxb.getCsrq() == null ? "" : sj_hjyw_qczxxxb.getCsrq());
                            qyr.addElement("csd_gjhdqdm").setText("");
                            qyr.addElement("csd_ssxqdm").setText(sj_hjyw_qczxxxb.getCsdssxq() == null ? "" : sj_hjyw_qczxxxb.getCsdssxq());
                            qyr.addElement("csd_qhnxxdz").setText("");
                            qyr.addElement("jg_gjhdqdm").setText(null == hjxx_czrkjbxxb2.getJggjdq() ? "" : hjxx_czrkjbxxb2.getJggjdq());
                            qyr.addElement("jg_ssxqdm").setText(null == hjxx_czrkjbxxb2.getJgssxq() ? "" : hjxx_czrkjbxxb2.getJgssxq());
                            qyr.addElement("jg_qhnxxdz").setText(null == hjxx_czrkjbxxb2.getJgxz() ? "" : hjxx_czrkjbxxb2.getJgxz());
                            qyr.addElement("xldm").setText(null == hjxx_czrkjbxxb2.getWhcd() ? "" : hjxx_czrkjbxxb2.getWhcd());
                            qyr.addElement("hyzkdm").setText(null == hjxx_czrkjbxxb2.getHyzk() ? "" : hjxx_czrkjbxxb2.getHyzk());
                            qyr.addElement("zy").setText(null == hjxx_czrkjbxxb2.getZy() ? "" : hjxx_czrkjbxxb2.getZy());

                            //迁移（流动）原因代码
                            qyr.addElement("qyldyydm").setText(zjywZqzxx.getQyldyydm() == null ? "" : zjywZqzxx.getQyldyydm());
                            //迁移流动原因名称（内部） 汉字
                            qyr.addElement("qyldyymc_nb").setText(zjywZqzxx.getQyldyymc_nb() == null ? "" : zjywZqzxx.getQyldyymc_nb());
                            Map<String, Object> qyrMap = new HashMap<>();
                            qyrMap.put("gmsfhm", zjywZqzQyrxx.getGmsfhm());
                            qyrMap.put("dqbm", hjxx_czrkjbxxb2.getPcs());
                            PoHJXX_RYZPXXB poHJXX_ryzpxxb = apiService.queryZp(qyrMap);
                            //对字节数组Base64编码
                            BASE64Encoder encoder = new BASE64Encoder();
                            String base64 = "";
                            if (poHJXX_ryzpxxb != null) {
                                //返回Base64编码过的字节数组字符串
                                base64 = encoder.encode(poHJXX_ryzpxxb.getZp());
                            }
                            //相片 BASE64字符串
                            String strZp = base64.replaceAll("\r\n", "");
                            qyr.addElement("xp").setText(strZp);
                            //居民身份证签发机关
                            qyr.addElement("jmsfz_qfjg").setText(null == hjxx_czrkjbxxb2.getQfjg() ? "" : hjxx_czrkjbxxb2.getQfjg());
                            //有效期限起始日期
                            qyr.addElement("jmsfz_yxqxqsrq").setText(null == hjxx_czrkjbxxb2.getYxqxqsrq() ? "" : hjxx_czrkjbxxb2.getYxqxqsrq());
                            //有效期限截止日期
                            qyr.addElement("jmsfz_yxqxjzrq").setText(null == hjxx_czrkjbxxb2.getYxqxjzrq() ? "" : hjxx_czrkjbxxb2.getYxqxjzrq());
                            System.out.println("迁出注销2配置完毕");
                        }

                        // 如果迁移人3 不为空 那么在 body节点下添加节点qyr
                        if (i == 2) {
                            System.out.println("根据sfz号码查询人口信息3：" + zjywZqzQyrxx.getGmsfhm());
                            //根据sfz号码查询人口信息
                            HJXX_CZRKJBXXB hjxx_czrkjbxxb3 = queryCzrkjbxxb(zjywZqzQyrxx.getGmsfhm(), sj_hjyw_qczxxxb.getPcs());

                            Element qyr = body.addElement("qyr");
                            qyr.addAttribute("no", "3");
                            qyr.addElement("qyzbh").setText(sj_hjyw_qczxxxb.getQyzbh());
                            qyr.addElement("yczrgx_jtgxdm").setText(sj_hjyw_qczxxxb.getSbrjtgx()== null ? sj_hjyw_qczxxxb.getYhzgx() : sj_hjyw_qczxxxb.getSbrjtgx());
                            qyr.addElement("gmsfhm").setText(sj_hjyw_qczxxxb.getGmsfhm() == null ? "" : sj_hjyw_qczxxxb.getGmsfhm());
                            qyr.addElement("xm").setText(sj_hjyw_qczxxxb.getXm() == null ? "" : sj_hjyw_qczxxxb.getXm());
                            qyr.addElement("cym").setText(null == hjxx_czrkjbxxb3.getCym() ? "" : hjxx_czrkjbxxb3.getCym());
                            qyr.addElement("xbdm").setText(sj_hjyw_qczxxxb.getXb() == null ? "" : sj_hjyw_qczxxxb.getXb());
                            qyr.addElement("mzdm").setText(sj_hjyw_qczxxxb.getMz() == null ? "" : sj_hjyw_qczxxxb.getMz());
                            qyr.addElement("csrq").setText(sj_hjyw_qczxxxb.getCsrq() == null ? "" : sj_hjyw_qczxxxb.getCsrq());
                            qyr.addElement("csd_gjhdqdm").setText("");
                            qyr.addElement("csd_ssxqdm").setText(sj_hjyw_qczxxxb.getCsdssxq() == null ? "" : sj_hjyw_qczxxxb.getCsdssxq());
                            qyr.addElement("csd_qhnxxdz").setText("");
                            qyr.addElement("jg_gjhdqdm").setText(null == hjxx_czrkjbxxb3.getJggjdq() ? "" : hjxx_czrkjbxxb3.getJggjdq());
                            qyr.addElement("jg_ssxqdm").setText(null == hjxx_czrkjbxxb3.getJgssxq() ? "" : hjxx_czrkjbxxb3.getJgssxq());
                            qyr.addElement("jg_qhnxxdz").setText(null == hjxx_czrkjbxxb3.getJgxz() ? "" : hjxx_czrkjbxxb3.getJgxz());
                            qyr.addElement("xldm").setText(null == hjxx_czrkjbxxb3.getWhcd() ? "" : hjxx_czrkjbxxb3.getWhcd());
                            qyr.addElement("hyzkdm").setText(null == hjxx_czrkjbxxb3.getHyzk() ? "" : hjxx_czrkjbxxb3.getHyzk());
                            qyr.addElement("zy").setText(null == hjxx_czrkjbxxb3.getZy() ? "" : hjxx_czrkjbxxb3.getZy());

                            //迁移（流动）原因代码
                            qyr.addElement("qyldyydm").setText(zjywZqzxx.getQyldyydm() == null ? "" : zjywZqzxx.getQyldyydm());
                            //迁移流动原因名称（内部） 汉字
                            qyr.addElement("qyldyymc_nb").setText(zjywZqzxx.getQyldyymc_nb() == null ? "" : zjywZqzxx.getQyldyymc_nb());

                            Map<String, Object> qyrMap = new HashMap<>();
                            qyrMap.put("gmsfhm", zjywZqzQyrxx.getGmsfhm());
                            qyrMap.put("dqbm", hjxx_czrkjbxxb3.getPcs());
                            PoHJXX_RYZPXXB poHJXX_ryzpxxb = apiService.queryZp(qyrMap);
                            //对字节数组Base64编码
                            BASE64Encoder encoder = new BASE64Encoder();
                            String base64 = "";
                            if (poHJXX_ryzpxxb != null) {
                                //返回Base64编码过的字节数组字符串
                                base64 = encoder.encode(poHJXX_ryzpxxb.getZp());
                            }
                            //相片 BASE64字符串
                            String strZp = base64.replaceAll("\r\n", "");
                            qyr.addElement("xp").setText(strZp);
                            //居民身份证签发机关
                            qyr.addElement("jmsfz_qfjg").setText(null == hjxx_czrkjbxxb3.getQfjg() ? "" : hjxx_czrkjbxxb3.getQfjg());
                            //有效期限起始日期
                            qyr.addElement("jmsfz_yxqxqsrq").setText(null == hjxx_czrkjbxxb3.getYxqxqsrq() ? "" : hjxx_czrkjbxxb3.getYxqxqsrq());
                            //有效期限截止日期
                            qyr.addElement("jmsfz_yxqxjzrq").setText(null == hjxx_czrkjbxxb3.getYxqxjzrq() ? "" : hjxx_czrkjbxxb3.getYxqxjzrq());
                            System.out.println("迁出注销3配置完毕");
                        }
                        // 如果迁移人4 不为空 那么在 body节点下添加节点qyr
                        if (i == 3) {
                            System.out.println("根据sfz号码查询人口信息4：" + zjywZqzQyrxx.getGmsfhm());
                            //根据sfz号码查询人口信息
                            HJXX_CZRKJBXXB hjxx_czrkjbxxb4 = queryCzrkjbxxb(zjywZqzQyrxx.getGmsfhm(), sj_hjyw_qczxxxb.getPcs());

                            Element qyr = body.addElement("qyr");
                            qyr.addAttribute("no", "3");
                            qyr.addElement("qyzbh").setText(sj_hjyw_qczxxxb.getQyzbh());
                            qyr.addElement("yczrgx_jtgxdm").setText(sj_hjyw_qczxxxb.getSbrjtgx()== null ? sj_hjyw_qczxxxb.getYhzgx() : sj_hjyw_qczxxxb.getSbrjtgx());
                            qyr.addElement("gmsfhm").setText(sj_hjyw_qczxxxb.getGmsfhm() == null ? "" : sj_hjyw_qczxxxb.getGmsfhm());
                            qyr.addElement("xm").setText(sj_hjyw_qczxxxb.getXm() == null ? "" : sj_hjyw_qczxxxb.getXm());
                            qyr.addElement("cym").setText(null == hjxx_czrkjbxxb4.getCym() ? "" : hjxx_czrkjbxxb4.getCym());
                            qyr.addElement("xbdm").setText(sj_hjyw_qczxxxb.getXb() == null ? "" : sj_hjyw_qczxxxb.getXb());
                            qyr.addElement("mzdm").setText(sj_hjyw_qczxxxb.getMz() == null ? "" : sj_hjyw_qczxxxb.getMz());
                            qyr.addElement("csrq").setText(sj_hjyw_qczxxxb.getCsrq() == null ? "" : sj_hjyw_qczxxxb.getCsrq());
                            qyr.addElement("csd_gjhdqdm").setText("");
                            qyr.addElement("csd_ssxqdm").setText(sj_hjyw_qczxxxb.getCsdssxq() == null ? "" : sj_hjyw_qczxxxb.getCsdssxq());
                            qyr.addElement("csd_qhnxxdz").setText("");
                            qyr.addElement("jg_gjhdqdm").setText(null == hjxx_czrkjbxxb4.getJggjdq() ? "" : hjxx_czrkjbxxb4.getJggjdq());
                            qyr.addElement("jg_ssxqdm").setText(null == hjxx_czrkjbxxb4.getJgssxq() ? "" : hjxx_czrkjbxxb4.getJgssxq());
                            qyr.addElement("jg_qhnxxdz").setText(null == hjxx_czrkjbxxb4.getJgxz() ? "" : hjxx_czrkjbxxb4.getJgxz());
                            qyr.addElement("xldm").setText(null == hjxx_czrkjbxxb4.getWhcd() ? "" : hjxx_czrkjbxxb4.getWhcd());
                            qyr.addElement("hyzkdm").setText(null == hjxx_czrkjbxxb4.getHyzk() ? "" : hjxx_czrkjbxxb4.getHyzk());
                            qyr.addElement("zy").setText(null == hjxx_czrkjbxxb4.getZy() ? "" : hjxx_czrkjbxxb4.getZy());

                            //迁移（流动）原因代码
                            qyr.addElement("qyldyydm").setText(zjywZqzxx.getQyldyydm() == null ? "" : zjywZqzxx.getQyldyydm());
                            //迁移流动原因名称（内部） 汉字
                            qyr.addElement("qyldyymc_nb").setText(zjywZqzxx.getQyldyymc_nb() == null ? "" : zjywZqzxx.getQyldyymc_nb());

                            Map<String, Object> qyrMap = new HashMap<>();
                            qyrMap.put("gmsfhm", zjywZqzQyrxx.getGmsfhm());
                            qyrMap.put("dqbm", hjxx_czrkjbxxb4.getPcs());
                            PoHJXX_RYZPXXB poHJXX_ryzpxxb = apiService.queryZp(qyrMap);
                            //对字节数组Base64编码
                            BASE64Encoder encoder = new BASE64Encoder();
                            String base64 = "";
                            if (poHJXX_ryzpxxb != null) {
                                //返回Base64编码过的字节数组字符串
                                base64 = encoder.encode(poHJXX_ryzpxxb.getZp());
                            }
                            //相片 BASE64字符串
                            String strZp = base64.replaceAll("\r\n", "");
                            qyr.addElement("xp").setText(strZp);
                            //居民身份证签发机关
                            qyr.addElement("jmsfz_qfjg").setText(null == hjxx_czrkjbxxb4.getQfjg() ? "" : hjxx_czrkjbxxb4.getQfjg());
                            //有效期限起始日期
                            qyr.addElement("jmsfz_yxqxqsrq").setText(null == hjxx_czrkjbxxb4.getYxqxqsrq() ? "" : hjxx_czrkjbxxb4.getYxqxqsrq());
                            //有效期限截止日期
                            qyr.addElement("jmsfz_yxqxjzrq").setText(null == hjxx_czrkjbxxb4.getYxqxjzrq() ? "" : hjxx_czrkjbxxb4.getYxqxjzrq());
                            System.out.println("迁出注销4配置完毕");
                        }
                    }
                }
                String qyzXml = document.asXML();
                System.out.println(qyzXml);
                return qyzXml;
            } else {
                System.out.println("查询不到数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
