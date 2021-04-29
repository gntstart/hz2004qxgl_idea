package com.gnt.qxgl.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gnt.qxgl.base.encoders.Hex;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbFjcl;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXx;
import com.gnt.qxgl.service.YwtbService;
import com.iflytek.ursp.client.GsbService;
import com.iflytek.ursp.client.endpoint.ServiceEndPoint;
import com.iflytek.ursp.client.exception.UrspClientException;
import com.iflytek.ursp.client.message.GsbParameter;
import com.iflytek.ursp.client.message.GsbResponse;
import com.iflytek.ursp.client.security.Algorithm;
import com.iflytek.ursp.client.session.ServiceSessionFactory;
import com.iflytek.ursp.client.session.Session;
import com.iflytek.ursp.client.transport.ITransport;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <功能概述>
 * 定时任务
 * 将外网服务数据库的信息，推送到公安内网
 *
 * @author: 杨冬冬
 * @className: JobTaskPostYwtbxx
 * @package: com.gnt.qxgl.job
 * @description: 介绍
 * @date: 2020-09-28 10:47
 */
public class JobTaskPushYwtbxx {

    //http://223.247.130.138:5001/hz2004qxgl/services/ywtbWebService
    private static String pushYwtbGaUrl = "https://wj.ahga.gov.cn/gsb";

    private static String usercode = "001";

    private static String pwd = "123456";

    private static String md5 = "";


    /**
     * 正式环境
     */
    public static final ServiceEndPoint serviceEndPoint = new ServiceEndPoint(pushYwtbGaUrl);

    private static final String applicationId = "3400-0024";

    private static final String authCode = "ba32cc7a400d6ef562034dca9257b4f8";

    private static final String securityCode = "IzB7kXtv";

    /**
     * 用表格里的应用授权信息进行替换
     */
    public static final ServiceSessionFactory serviceFactory = new ServiceSessionFactory(applicationId,
            authCode, securityCode, serviceEndPoint);

    private JobTaskPushYwtbxx() {
        System.out.println("外网一网通办 JobTaskPushYwtbxx 推送到公安内网一网通办数据定时任务初始化了");
        pushYwtbGaUrl = SystemConfig.getSystemConfig("pushYwtbGaUrl");
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
            byte[] buff = m.digest(pwd.getBytes());
            md5 = new String(Hex.encode(buff));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 推送到公安内网长三角一体化
     * 数据定时任务
     * 查询 gaisstatus 状态！= 1的数据 0 未推送到公安内网的
     * 如果推送成功则修改当前数据的状态
     * 0是从政务网接收1是从互联网前置机推送到公安网2是公安网办结3是公安网推送到互联网前置机4是互联网推送到政务网 5是推送失败
     */
    public void taskPushYwtbxx() {
        //System.out.println("推送到公安内网长三角一体化数据定时任务");
        String isPushYwtb = SystemConfig.getSystemConfig("isPushYwtb");
        if ("true".equals(isPushYwtb)) {
            //获取到ywtbService
            YwtbService ywtbService = (YwtbService) SpringContainer.getObject("ywtbService");
            Map<String, Object> map = new HashMap<String, Object>();
            //isstatus 0代表未推送 1已推送
            map.put("isstatus", "0");
            //查询当前表里未推送到公安内网的
            Page page = ywtbService.queryYwtbXxJob(map, 1, 50);
            List<YwtbXx> list = page.getList();
            System.out.println("推送内网数据数目："+list.size());
            for (YwtbXx ywtbXx : list) {
                //查询到当前YwtbXx 附件材料
                Map<String, Object> fjclMap = new HashMap<String, Object>();
                fjclMap.put("applyno", ywtbXx.getApplyno());
                Page pageFjcl = ywtbService.queryYwtbFjclGa(map, 1, 10);
                List<YwtbFjcl> fjclList = pageFjcl.getList();
                JSONObject ywtbxxJson = getYwtbxxJson(ywtbXx, fjclList);


                Session session = null;
                try {
                    session = serviceFactory.openSession(new GsbService("3400-0024-1-00000001", 1, "postYwtbHjzm"));
                    // 默认不加密，可以指定加密算法，必须指定安全码
                    session.setEncrypt(Algorithm.NONE);
                    session.setProperty(ITransport.TIME_OUT, 1000 * 30);
                    //初始化查询参数Json
                    GsbResponse response = session.request(
                            new GsbParameter("pcsbm", usercode),
                            new GsbParameter("md5", md5),
                            new GsbParameter("type", "1"),
                            new GsbParameter("json", ywtbxxJson.toString())
                    );
                    int errorCode = response.getErrorCode();
                    System.out.println("状态码errorCode："+errorCode);
                    if (errorCode == 200) {
                        String responseText = response.getResponseText();
                        //解析返回的json数据
                        JSONObject jsonObj = JSON.parseObject(responseText);
                        //获取到success
                        boolean formData = jsonObj.getBoolean("success");
                        System.out.println("formData："+jsonObj.toString());
                        if(formData){
                            //修改推送到公安内网的状态
                            ywtbXx.setGaisstatus("1");
                            ywtbXx.setIsstatus("1");//0是从政务网接收1是从互联网前置机推送到公安网2是公安网办结3是公安网推送到互联网前置机4是互联网推送到政务网 5是推送失败
                            ywtbService.updateYwtbXx(ywtbXx);
                        }
                        System.out.println(responseText);
                    }
                    if (errorCode == 600) {
                        printfDebugMsg("外网推送一网通数据到公安内网", response);
                    }
                } catch (UrspClientException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                //测试模拟提交叫外网服务器程序
            /*try {
                Call call2 = new Call(pushYwtbGaUrl);
                call2.setOperationName("postYwtbHjzm");
                String re = (String) call2.invoke(new Object[]{usercode, md5, "1", ywtbxxJson.toString()});
                //解析json数据
                JSONObject jsonObj = JSON.parseObject(re);
                //获取到success
                boolean formData = jsonObj.getBoolean("success");
                //推送到公安内网成功则修改数据库状态   失败不做任何操作
                if (formData) {
                    ywtbXx.setGaisstatus("1");
                    ywtbService.updateYwtbXx(ywtbXx);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }*/
            }
        }
    }


    /**
     * 将数据库查询出来的信息
     * 进行Json封装
     *
     * @param ywtbXx
     * @return
     */
    public static JSONObject getYwtbxxJson(YwtbXx ywtbXx, List<YwtbFjcl> fjclList) {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("applyNo", ywtbXx.getApplyno());
        jsonObj.put("beginTime", ywtbXx.getBegintime());
        jsonObj.put("sjrUsername", ywtbXx.getSjrusername());
        jsonObj.put("content", ywtbXx.getContent());
        jsonObj.put("username", ywtbXx.getUsername());
        jsonObj.put("licenseNo", ywtbXx.getLicenseno());
        jsonObj.put("sldwName", ywtbXx.getSldwname());
        jsonObj.put("sjrMobile", ywtbXx.getSjrmobile());
        jsonObj.put("sldwCode", ywtbXx.getSldwcode());
        jsonObj.put("sjrAddress", ywtbXx.getSjraddress());
        jsonObj.put("mobile", ywtbXx.getMobile());
//        jsonObj.put("itemName", ywtbXx.getItemname());
        //开具的范围
        JSONObject kjfw = new JSONObject();
        String cs_kjfw = DictData.getCodeName("CS_KJFW", ywtbXx.getKjfw());
        kjfw.put("name", cs_kjfw);
        kjfw.put("value", ywtbXx.getKjfw());
        jsonObj.put("kjfw", kjfw);
        //领取方式
        JSONObject lqfs = new JSONObject();
        String cs_lqfs = DictData.getCodeName("CS_LQFS", ywtbXx.getLqfs());
        lqfs.put("name", cs_lqfs);
        lqfs.put("value", ywtbXx.getLqfs());
        jsonObj.put("lqfs", lqfs);

        

        //开始封装附件材料
        if (fjclList.size() != 0) {
            List<JSONObject> list = new ArrayList<JSONObject>();
            for (int i = 0; i < fjclList.size(); i++) {
                YwtbFjcl ywtbFjcl = fjclList.get(i);
                //对字节数组Base64编码
                BASE64Encoder encoder = new BASE64Encoder();
                //返回Base64编码过的字节数组字符串
                String base64 = encoder.encode(ywtbFjcl.getStufffile());
                //材料
                JSONObject archivesdata = new JSONObject();
                archivesdata.put("stuffcode", ywtbFjcl.getStuffcode());
                archivesdata.put("needflag", ywtbFjcl.getNeedflag());
                archivesdata.put("stuffname", ywtbFjcl.getStuffname());
                archivesdata.put("filetype", ywtbFjcl.getFiletype());
                archivesdata.put("stufffile", base64);

                list.add(archivesdata);
            }
            jsonObj.put("archivesdata", list);
        }
        JSONObject json1 = new JSONObject();
        json1.put("formdata", jsonObj);
        return json1;
    }

    /**
     * 返回结果输出
     */
    public static void printfDebugMsg(String tip, GsbResponse response) throws Exception {
        if (response != null) {
            System.out.println(String.format(MessageTemplet, tip, response.getErrorCode(), response.getErrorMsg(),
                    response.getResponseText(), response.getExceptionDetail()));
        } else {
            System.err.println("response is null");
        }
    }
    /**
     * 消息模板
     */
    public final static String MessageTemplet = "%s errCode=%d,errMsg=%s,data=%s,exceptionDatail=%s";
}
