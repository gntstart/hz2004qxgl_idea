package com.gnt.qxgl.webservice;

import com.gnt.qxgl.base.encoders.Hex;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxxQyrxx;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzQyrxx;
import com.gnt.qxgl.webservice.bean.ZjywQyzQyryxxBean;
import com.gnt.qxgl.webservice.bean.ZjywReturnBean;
import com.gnt.qxgl.webservice.bean.ZjywZqzQyryxxBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.*;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WebServiceTest {


    private static final javax.servlet.http.HttpServletRequest HttpServletRequest = null;
    private static final javax.servlet.http.HttpServletResponse HttpServletResponse = null;
    static String usercode2 = "001";
    static String pwd2 = "123456";
    static String url2 = "http://127.0.0.1:8080/hz2004query/services/zjywWebService";


    public static void main(String[] args) throws Exception {
//        parse2Document("F:\\test\\1.xml");
      test_postZjywZqzQyrxx();
//		test_postZjywQyzQyrxx();


/*
        Document document = parse2Document("F:/test/1.xml");
        InputSource source = new InputSource(new StringReader(document.asXML()));
        SAXReader reader = new SAXReader();
        Document document1 = null;
        try {
            document1 = reader.read(source);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //获取根节点属性对象
        Element rootElem = document1.getRootElement();
        //显示根节点的名字
        System.out.println("节点名字"+rootElem.getName());
        //获取head节点属性对象
        Element headElem = rootElem.element("head");
        String zqzbh = null;
        String qyzbh = null;
        List<Element> elements = headElem.elements();
        for(Iterator<Element> it = elements.iterator();it.hasNext();){
            Element element = it.next();
            String conAttrName = element.getName();
            if(conAttrName == "zqzbh"){
                String conTxt = element.getStringValue();
                System.out.println(conAttrName+" = "+conTxt);
                zqzbh = conTxt;
            }
            if(conAttrName == "qyzbh"){
                String conTxt = element.getStringValue();
                System.out.println(conAttrName+" = "+conTxt);
                qyzbh = conTxt;

            }
        }
        //获取body节点属性对象 准迁证信息
        Element bodyElem = rootElem.element("body");
        List<Element> bodyElements = bodyElem.elements();
        for(Iterator<Element> it = bodyElements.iterator();it.hasNext();){
            Element element = it.next();
            String conAttrName = element.getName();
            if("ywlsh".equals(conAttrName)){

            }
            String conTxt = element.getStringValue();
            System.out.println(conAttrName+" = "+conTxt);
        }
        //遍历qyr节点的所有属性  迁移人
        List<Element> qyrElem= bodyElem.elements("qyr");
        for(Iterator<Element> it = qyrElem.iterator();it.hasNext();){
            Element element = it.next();
            //遍历某个节点的所有属性
            String qyrzqzbh = element.element("zqzbh").getText().trim();
            String ysqrgx_jtgxdm = element.element("ysqrgx_jtgxdm").getText().trim();
            String gmsfhm = element.element("gmsfhm").getText().trim();

            String xm = element.element("xm").getText().trim();
            String xbdm = element.element("xbdm").getText().trim();
            String csrq = element.element("csrq").getText().trim();
            System.out.println("准迁证-"+qyrzqzbh+"家庭关系-"+ysqrgx_jtgxdm+"身份证-"+gmsfhm+"姓名-"+xm+"性别-"+xbdm+"出生日期-"+csrq);
        }*/

    }

    public static String parseXml() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("F:\\test\\1.xml"); // 内容是：abc
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            //当temp等于-1时，表示已经到了文件结尾，停止读取
            while ((temp = fis.read()) != -1) {
                sb.append((char) temp);
            }
            System.out.println(sb);
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //这种写法，保证了即使遇到异常情况，也会关闭流对象。
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取指定xml文档的Document对象,xml文件必须在classpath中可以找到
     *
     * @param xmlFilePath xml文件路径
     * @return Document对象
     */
    public static Document parse2Document(String xmlFilePath) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new FileInputStream(xmlFilePath));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("读取classpath下xmlFileName文件发生异常，请检查CLASSPATH和文件名是否存在！");
            e.printStackTrace();
        }
        return document;
    }


    public static void test_postZjywZqzQyrxx() throws Exception {
        String pcsbm = "001";
        String sbh = "001";
        String pwd = "123456";
        String url = "http://127.0.0.1:8090/hz2004qxgl/services/ywtbWebService";


        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] buff = m.digest(pwd.getBytes());
        String md5 = new String(Hex.encode(buff));

        org.apache.axis.client.Call call2 = new org.apache.axis.client.Call(url);
        call2.setOperationName("postZqzxxRecrod");

        //测试内宾登记（创建一个内宾对象）
//        ZjywZqzQyryxxBean nb = getTestZjywZqz();
        Document document = parse2Document("F:/test/1.xml");
//        String s = parseXml();
        //String s = "<request> <param name='service' ID='tt'>single_trade_query </param><param name='_input_charset'>utf-8 </param><param name='partner'>2088001513232645 </param><param name='out_trade_no'>20090422577264 </param></request>";
        //将内宾对象转换为JSON字符串表示
//        GsonBuilder build = new GsonBuilder();
//        Gson gson = build.create();
//        String json = gson.toJson(nb);
        //提交内宾住宿信息，并且获取调用结果的json表示 String pcsbm,String sbh, String md5, String type, String json
        String re = (String) call2.invoke(new Object[]{pcsbm, md5, "1", document.asXML()});
        //System.out.println(re);
    }


    public static void test_postZjywQyzQyrxx() throws Exception {
        String pcsbm = "001";
        String sbh = "001";
        String pwd = "123456";
        String url = "http://192.168.0.23:8080/hz2004qxgl/services/ywtbWebService";

        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] buff = m.digest(pwd.getBytes());
        String md5 = new String(Hex.encode(buff));

        org.apache.axis.client.Call call2 = new org.apache.axis.client.Call(url);
        call2.setOperationName("postQyzxxRecrod");

        //测试内宾登记（创建一个内宾对象）
        ZjywQyzQyryxxBean nb = getTestZjywQyz();

        //将内宾对象转换为JSON字符串表示
        GsonBuilder build = new GsonBuilder();
        Gson gson = build.create();
        String json = gson.toJson(nb);

        //提交内宾住宿信息，并且获取调用结果的json表示 String pcsbm,String sbh, String md5, String type, String json
        String re = (String) call2.invoke(new Object[]{pcsbm, sbh, md5, "1", json});


        ZjywReturnBean rb = WebServiceTest.getJsonData(ZjywReturnBean.class, re);

        //
        System.out.println(re);


    }

    public static ZjywZqzQyryxxBean getTestZjywZqz() {
        ZjywZqzQyryxxBean nb = new ZjywZqzQyryxxBean();
        nb.setPostid("21341231276712");
        nb.setYwlsh("");
        nb.setZqzbh("皖00000000");
        nb.setSqr_gmsfhm("340721197104050628");
        nb.setSqr_xm("zhangsan");
        nb.setSqr_zz_ssxqdm("23423");
        nb.setSqr_zz_qhnxxdz("北京111");
        nb.setSqr_hkdjjg_gajgjgdm("3243");
        nb.setSqr_hkdjjg_gajgmc("合肥11");
        nb.setQcd_ssxqdm("23423");
        nb.setQcd_qhnxxdz("合肥市xxx县xxx街道");
        nb.setQcd_hkdjjg_gajgjgdm("232");
        nb.setQcd_hkdjjg_gajgmc("合肥市xx县公安局");

        nb.setQrd_ssxqdm("809");
        nb.setQrd_qhnxxdz("上海");
        nb.setQrd_hkdjjg_gajgjgdm("2342");
        nb.setQrd_hkdjjg_gajgmc("浙江");
        nb.setQfjg_gajgjgdm("1111");
        nb.setQfjg_gajgmc("1112");

        nb.setCbr_xm("杨冬冬");
        nb.setQfrq("2019-12-20");
        nb.setSldw_gajgjgdm("22222");
        nb.setSldw_gajgmc("哈哈");

        ZjywZqzQyrxx zqz = new ZjywZqzQyrxx();
        zqz.setZqzbh("皖00000000");
        zqz.setYsqrgx_jtgxdm("02");
        zqz.setGmsfhm("342422198408056750");

        List<ZjywZqzQyrxx> list = new ArrayList<ZjywZqzQyrxx>();
        list.add(zqz);
        nb.setQyrxx(list);
        return nb;
    }


    public static ZjywQyzQyryxxBean getTestZjywQyz() {
        ZjywQyzQyryxxBean nb = new ZjywQyzQyryxxBean();
//		nb.setYwlsh("3401040135201912200020");
        nb.setQyzbh("012345678910");
        nb.setCzr_gmsfhm("342422198408056750");
        nb.setCzr_xm("哈哈");
        nb.setYzz_ssxqdm("78");
        nb.setYzz_qhnxxdz("安徽省xx市xx县");
        nb.setYzz_cxfldm("05");
        nb.setQwd_ssxqdm("56");
        nb.setQwd_qhnxxdz("上海市普陀区");

        nb.setQfjg_gajgjgdm("1111");
        nb.setQfjg_gajgmc("1112");
        nb.setSldw_gajgjgdm("10");
        nb.setSldw_gajgmc("合肥市公安局");
        nb.setSlr_xm("杨冬冬1111");
        nb.setSlsj("20191220");

        nb.setCbr_xm("杨冬冬1111");
        nb.setQfrq("20191220");
        nb.setSjgsdwdm("10");
        nb.setSjgsdwmc("合肥市公安局");

        ZjywQyzxxQyrxx zqz = new ZjywQyzxxQyrxx();
        zqz.setQyzbh("123456789");
        zqz.setYczrgx_jtgxdm("02");
        zqz.setGmsfhm("342422198408056750");
        zqz.setXm("哈哈");
        zqz.setXbdm("01");
        zqz.setMzdm("23");
        zqz.setCsrq("19980213");
        zqz.setQyldyydm("fdjajslkdjflsjlkd");

        List<ZjywQyzxxQyrxx> list = new ArrayList<ZjywQyzxxQyrxx>();
        list.add(zqz);
        nb.setQyrxx(list);
        return nb;
    }

    public static void print(String[] re) {
        if (re == null)
            System.out.println("null");

        for (int i = 0; i < re.length; i++) {
            String v = re[i];
            System.out.print("re[" + i + "]=" + v);
        }
    }

    public static void print(String[][] re) {
        if (re == null)
            System.out.println("null");

        for (int i = 0; i < re.length; i++) {
            String[] rows = re[i];
            System.out.print("{");
            for (int j = 0; j < rows.length; j++) {
                if (j > 0)
                    System.out.print(";");

                System.out.print(rows[j]);
            }
            System.out.println("}");
        }
    }

    /**
     * 对象---》字符串
     *
     * @param src
     * @return
     */
    static public String toJson(Object src) {
        GsonBuilder build = new GsonBuilder();
        Gson gson = build.create();
        //net.sf.cglib.proxy.CallbackFilter a;
        return gson.toJson(src);
    }

    /**
     * 对象转换：字符串---》对象
     *
     * @param classOfT
     * @param data
     * @return
     */
    static public <T> T getJsonData(Class<T> classOfT, String data) {
        GsonBuilder build = new GsonBuilder();
        //if(this.dateStyle != null) {
        //	build.setDateFormat(this.dateStyle);
        //}
        //javax.activation.DataHandler
        //javax.mail.internet.MimeMultipart;

        Gson gson = build.create();
        return gson.fromJson(data, classOfT);
    }
}
