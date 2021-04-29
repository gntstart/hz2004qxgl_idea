package com.gnt.qxgl.base;

import com.gnt.qxgl.base.encoders.Base64;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_ZQZXXB;
import com.gnt.qxgl.hz2004.entity.XX_CZRK;
import com.gnt.qxgl.hz2004.entity.zjyw.*;
import com.gnt.qxgl.service.Hz2004Service;
import com.gnt.qxgl.service.yw.KdqqyService;
import com.gnt.qxgl.webservice.bean.ZjywReturnBean;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <功能概述>
 * 长三角跨省户口网上迁移
 * 准迁证，迁移证信息接收
 *
 * @author: 杨冬冬
 * @className: ReceiveZqzQyzController
 * @package: com.gnt.qxgl.base
 * @description: 介绍
 * @date: 2020-12-24 16:08
 */
public class ReceiveZqzQyzController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SAXReader saxReader = new SAXReader();
        Document doc;
        //获取到第三方传过来流
        ServletInputStream inputStream = req.getInputStream();
        //post方式解决中文乱码
        //req.setCharacterEncoding("UTF-8");
        try {
            String dataFromRequst = getDataFromRequst(req);
            ByteArrayInputStream bais = new ByteArrayInputStream(dataFromRequst
                    .getBytes("UTF-8"));
            doc = saxReader.read(bais);
            System.out.println("第三方传过来的数据：" + doc.asXML());
            //获取根节点属性对象
            Element rootElem = doc.getRootElement();
            //显示根节点的名字
            //System.out.println("节点名字" + rootElem.getName());
            //获取head节点属性对象
            Element headElem = rootElem.element("head");
            List<Element> elements = headElem.elements();
            String zqzbh = null;
            String qyzbh = null;
            String ywlsh = null;
            String code = null;

            for (Iterator<Element> it = elements.iterator(); it.hasNext(); ) {
                Element element = it.next();
                //循环获取属性名
                String conAttrName = element.getName();
                String conTxt = element.getStringValue();
                //判断是准迁证还是迁移证
                if (conAttrName == "zqzbh") {
                    //获取改属性的值
                    //System.out.println(conAttrName + " = " + conTxt);
                    zqzbh = conTxt;
                }
                if (conAttrName == "qyzbh") {
                    //System.out.println(conAttrName + " = " + conTxt);
                    qyzbh = conTxt;

                }
                if (conAttrName == "ywlsh") {
                    //System.out.println(conAttrName + " = " + conTxt);
                    ywlsh = conTxt;

                }
                if (conAttrName == "code") {
                    //System.out.println(conAttrName + " = " + conTxt);
                    code = conTxt;
                }

            }

            Hz2004Service nwbService = (Hz2004Service) SpringContainer.getObject("hz2004Service");
            if (code.equals("00")) {

                Class zqzQyzxx = null;
                Object stuInstance = null;
                Class qyrXx = null;
                Object qyrxxInstance = null;
                List qyrxx = new ArrayList();
                //判断准迁证和迁移证哪个不为空，则创建哪个实体类的实例
                if (!zqzbh.equals("")) {
                    //1.反射，得到类的引用
                    zqzQyzxx = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzxx");
                    //通过类的引用，得到类的对象
                    stuInstance = zqzQyzxx.newInstance();

                    //1.反射，得到类的引用
                    qyrXx = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzQyrxx");

                }
                if (!qyzbh.equals("")) {
                    //1.反射，得到类的引用
                    zqzQyzxx = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxx");
                    //通过类的引用，得到类的对象
                    stuInstance = zqzQyzxx.newInstance();

                    //1.反射，得到类的引用
                    qyrXx = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxxQyrxx");
                }

                //获取body节点属性对象 准迁证信息
                Element bodyElem = rootElem.element("body");
                List<Element> bodyElements = bodyElem.elements();
                for (Iterator<Element> it = bodyElements.iterator(); it.hasNext(); ) {
                    Element element = it.next();
                    //分别每个节点的名字
                    String conAttrName = element.getName();
                    if ("qyr".equals(conAttrName)) {
                        continue;
                    }
                    //分别每个节点的值内容
                    String conTxt = element.getStringValue();
                    //通过elemetname得到对应的get set方法，先拼接出方法名，比如 name--setName
                    String funName = "set" + (conAttrName.charAt(0) + "").toUpperCase() + conAttrName.substring(1);
                    //通过方法名反射出方法对象
                    Method method1 = zqzQyzxx.getDeclaredMethod(funName, String.class);
                    //通过反射调用方法，调用stuInstance对象的method方法，参数为stuData---给各属性赋值
                    method1.invoke(stuInstance, conTxt);
                }
                //遍历qyr节点的所有属性  迁移人
                List<Element> qyrElem = bodyElem.elements("qyr");
                for (Iterator<Element> it = qyrElem.iterator(); it.hasNext(); ) {
                    Element element = it.next();
                    List<Element> qyrElements = element.elements();
                    //通过类的引用，得到类的对象
                    qyrxxInstance = qyrXx.newInstance();

                    for (Element qyrElement : qyrElements) {
                        //遍历某个节点的所有属性
                        String conAttrName = qyrElement.getName();
                        //分别获取每个节点的值内容
                        String conTxt = qyrElement.getStringValue();
                        //System.out.println(conAttrName + " = " + conTxt);
                        //通过elemetname得到对应的get set方法，先拼接出方法名，比如 name--setName
                        String funName = "set" + (conAttrName.charAt(0) + "").toUpperCase() + conAttrName.substring(1);
                        Method method1 = null;
                        if ("setXp".equals(funName)) {
                            //通过方法名反射出方法对象
                            method1 = qyrXx.getDeclaredMethod(funName, byte[].class);
                            //通过反射调用方法，调用stuInstance对象的method方法，参数为stuData---给各属性赋值
                            byte[] zp = null;
                            if(conTxt!= ""){
                                zp = Base64.decode(conTxt);
                            }

                            method1.invoke(qyrxxInstance, zp);
                        } else {
                            //通过方法名反射出方法对象
                            method1 = qyrXx.getDeclaredMethod(funName, String.class);
                            //通过反射调用方法，调用stuInstance对象的method方法，参数为stuData---给各属性赋值
                            method1.invoke(qyrxxInstance, conTxt);
                        }


                    }
                    //添加到集合中
                    qyrxx.add(qyrxxInstance);
                }

                ZjywReturnBean re = null;
                // 创建文档。
                Document document = DocumentHelper.createDocument();
                // 文档增加节点，即根节点，一个文档只能有一个根节点，多加出错
                Element root = document.addElement("root");
                // 根节点下添加节点head
                Element head = root.addElement("head");
                //业务流水号
                head.addElement("ywlsh").setText(ywlsh);

                //授权码 随机生成32位或者36位字符串
                String license = UUID.randomUUID().toString();
                head.addElement("license").setText(license);
                if (zqzbh != "" && qyzbh == "") {
                    re = postZqzxxRecrods((ZjywZqzxx) stuInstance, qyrxx);
                    // 节点添加属性 010122准迁证 010124迁移证
                    head.addElement("sjblx").setText("010122");
                    head.addElement("zqzbh").setText(zqzbh);
                    //日志
                    ZjywZqzqyzresult zqzqyzresult = new ZjywZqzqyzresult();
                    zqzqyzresult.setYwlsh(ywlsh);
                    zqzqyzresult.setSjblx("010124");
                    zqzqyzresult.setZqzbh(zqzbh);
                    if (re.isSuccess()) {
                        head.addElement("code").setText("00");
                        head.addElement("msg").setText("成功");
                    } else {
                        head.addElement("code").setText("99");
                        head.addElement("msg").setText("失败" + re.getMessage());
                        zqzqyzresult.setCode("99");
                        zqzqyzresult.setMsg("第三方准迁证数据接收失败异常：-------" + re.getMessage());
                    }
                    zqzqyzresult.setCjsj(new Date());
                    nwbService.saveZjywZqzqyzresult(zqzqyzresult);
                }

                if (qyzbh != "") {
                	
                	re = postQyzxxRecrods((ZjywQyzxx) stuInstance, qyrxx);
                    // 节点添加属性  010122准迁证 010124迁移证
                    head.addElement("sjblx").setText("010124");
                    head.addElement("qyzbh").setText(qyzbh);
                    //日志
                    ZjywZqzqyzresult zqzqyzresult = new ZjywZqzqyzresult();
                    zqzqyzresult.setYwlsh(ywlsh);
                    zqzqyzresult.setSjblx("010124");
                    zqzqyzresult.setQyzbh(qyzbh);
                    if (re.isSuccess()) {
                        head.addElement("code").setText("00");
                        head.addElement("msg").setText("成功");
                        zqzqyzresult.setCode("11");
                        zqzqyzresult.setMsg("接收成功");
                    } else {
                        head.addElement("code").setText("99");
                        head.addElement("msg").setText("失败" + re.getMessage());

                        zqzqyzresult.setCode("99");
                        zqzqyzresult.setMsg("第三方迁移证数据接收失败异常：-------" + re.getMessage());
                    }
                    zqzqyzresult.setCjsj(new Date());
                    nwbService.saveZjywZqzqyzresult(zqzqyzresult);
                }
                String result = document.asXML();
                System.out.println(result);
                PrintWriter out = resp.getWriter();
                out.print(result);
            } else {
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

                //存日志
                ZjywZqzqyzresult zqzqyzresult = (ZjywZqzqyzresult) stuInstance;
                zqzqyzresult.setMsg("第三方系统推送到对应长山角省级反馈状态：------" + zqzqyzresult.getMsg());
                zqzqyzresult.setCjsj(new Date());
                nwbService.saveZjywZqzqyzresult(zqzqyzresult);


                // 创建文档。 反馈信息
                Document document = DocumentHelper.createDocument();
                // 文档增加节点，即根节点，一个文档只能有一个根节点，多加出错
                Element root = document.addElement("root");
                // 根节点下添加节点head
                Element head = root.addElement("head");
                head.addElement("code").setText("00");
                head.addElement("msg").setText("成功");
                String result = document.asXML();
                System.out.println(result);
                PrintWriter out = resp.getWriter();
                out.print(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 读取数据xml
     *
     * @param request
     * @return
     */
    public static String getDataFromRequst(HttpServletRequest request) {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    /**
     * 准迁证信息接收
     * 准迁证迁移人信息接收
     * 保存或者修改的通用方法
     *
     * @param zjywZqzxx
     * @param zqzQyrxxList
     * @return
     */
    private ZjywReturnBean postZqzxxRecrods(ZjywZqzxx zjywZqzxx, List zqzQyrxxList) {
        Hz2004Service nwbService = (Hz2004Service) SpringContainer.getObject("hz2004Service");
        String ywlsh = null;
        ZjywReturnBean re = new ZjywReturnBean();
        try {
            ywlsh = zjywZqzxx.getYwlsh();

            //下面模拟nwbaction里面的流程，保持nwbservice的业务流程不变
            boolean c_u = true;
            //判断数据库是否已经记录过此记录KEY
            ZjywZqzxx zjywZqzxx1 = nwbService.queryZjywZqzxxByPostid(ywlsh);
            if (zjywZqzxx1 != null) {
                //如果有，那么修改原记录(用户不带，那么智能判断)
                c_u = false;
            }
            if (c_u) {
                KdqqyService kdqqyService = (KdqqyService) SpringContainer.getObject("kdqqyService");
                /*
                 * add by zjm
                 * 20210218
                 * 取hjxx_czrk  czrkpcsmc czrkpcsjgdm赋值给ZjywZqzxx中qcd_hkdjjg_gajgjgdm qcd_hkdjjg_gajgmc
                 */
                ExtMap<String, Object> params = new ExtMap<String, Object>();
                params.put("gmsfhm", ((ZjywZqzQyrxx) zqzQyrxxList.get(0)).getGmsfhm());
                List<XX_CZRK> xx_czrklist = kdqqyService.requestDqbmAndCzrkjbxx(params);//lk.getSqr_gmsfhm()
//                if (xx_czrklist.size() == 0) {
//                    throw new Exception("身份号码为：" + ((ZjywZqzQyrxx) zqzQyrxxList.get(0)).getGmsfhm() + "人员不存在！");
//                } else {
//                    XX_CZRK xx_czrk = xx_czrklist.get(0);
//                    if (CommonUtil.isNotEmpty(xx_czrk.getCzrkpcsmc())) {
//                        zjywZqzxx.setQcd_hkdjjg_gajgmc(xx_czrk.getCzrkpcsmc());
//                    }
//                    if (CommonUtil.isNotEmpty(xx_czrk.getCzrkpcsjgdm())) {
//                        zjywZqzxx.setQcd_hkdjjg_gajgjgdm(xx_czrk.getCzrkpcsjgdm());
//                    }
//                }

                nwbService.saveZjywZqzxx(zjywZqzxx, "");
                //执行for循环
                for (Object obj : zqzQyrxxList) {
                    ZjywZqzQyrxx zqz = (ZjywZqzQyrxx) obj;
                    zqz.setYwlsh(ywlsh);
                    nwbService.saveZjywZqzQyrxx(zqz);
                }
                re.setSuccess(true);
                re.setMessage("已收到");
            } else {
//                ZjywZqzxx oldnb = nwbService.queryZjywZqzxxByPostid(ywlsh);
//                if (oldnb == null) {
//                    throw new Exception("业务流水号[" + zjywZqzxx.getPostid() + "]不存在！");
//                }
//
//                nwbService.updateZjywZqzxx(zjywZqzxx);
                re.setMessage("数据重复退回" + ywlsh);
                re.setSuccess(false);
            }
        } catch (Exception e) {
            re.setMessage(e.getMessage());
        }
        re.setYwlsh(ywlsh);
        return re;
    }


    /**
     * 准迁证信息接收
     * 准迁证迁移人信息接收
     * 保存或者修改的通用方法
     *
     * @param zjywQyzxx
     * @param zqzQyrxxList
     * @return
     */
    private ZjywReturnBean postQyzxxRecrods(ZjywQyzxx zjywQyzxx, List zqzQyrxxList) {
        Hz2004Service nwbService = (Hz2004Service) SpringContainer.getObject("hz2004Service");
        String ywlsh = null;
        ZjywReturnBean re = new ZjywReturnBean();
        try {
            ywlsh = zjywQyzxx.getYwlsh();

            //下面模拟nwbaction里面的流程，保持nwbservice的业务流程不变
            boolean c_u = true;
            //判断数据库是否已经记录过此记录KEY
            ZjywQyzxx zjywQyzxx1 = nwbService.queryZjywQyzxxByPostid(ywlsh);
            if (zjywQyzxx1 != null) {
                //如果有，那么修改原记录(用户不带，那么智能判断)
                c_u = false;
            }

            if (c_u) {
                SJ_HJSP_ZQZXXB hjsp_zqzxxb = nwbService.querySJ_HJSP_ZQZXXB(zjywQyzxx.getZqzbh());
                zjywQyzxx.setHkdjpcs(hjsp_zqzxxb.getQrdhkdjjg());
                nwbService.saveZjywQyzxx(zjywQyzxx, "");
                //执行for循环
                for (Object obj : zqzQyrxxList) {
                    ZjywQyzxxQyrxx qyz = (ZjywQyzxxQyrxx) obj;
                    qyz.setGmsfhm(qyz.getGmsfhm().trim());
                    qyz.setYwlsh(zjywQyzxx.getYwlsh());
                    nwbService.saveZjywQyzQyrxx(qyz);
                }
                re.setSuccess(true);
            } else {
//                ZjywQyzxx oldnb = nwbService.queryZjywQyzxxByPostid(ywlsh);
//                if (oldnb == null) {
//                    throw new Exception("业务流水号[" + zjywZqzxx1.getPostid() + "]不存在！");
//                }
//                nwbService.updateZjywQyzxx(zjywQyzxx);
                re.setMessage("数据重复退回" + ywlsh);
                re.setSuccess(false);
            }
        } catch (Exception e) {
            re.setSuccess(false);
            re.setMessage(e.getMessage());
        }
        re.setYwlsh(ywlsh);
        return re;
    }
}
