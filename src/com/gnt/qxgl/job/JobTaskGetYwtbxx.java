package com.gnt.qxgl.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gnt.qxgl.base.encoders.Hex;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXx;
import com.gnt.qxgl.service.YwtbService;
import com.iflytek.ursp.client.GsbService;
import com.iflytek.ursp.client.endpoint.ServiceEndPoint;
import com.iflytek.ursp.client.exception.UrspClientException;
import com.iflytek.ursp.client.message.GsbDataType;
import com.iflytek.ursp.client.message.GsbParameter;
import com.iflytek.ursp.client.message.GsbResponse;
import com.iflytek.ursp.client.security.Algorithm;
import com.iflytek.ursp.client.session.ServiceSessionFactory;
import com.iflytek.ursp.client.session.Session;
import com.iflytek.ursp.client.transport.ITransport;
import org.apache.axis.client.Call;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * <功能概述>
 *
 * @author: 杨冬冬
 * @className: JobTaskGetYwtbxx
 * @package: com.gnt.qxgl.job
 * @description: 介绍
 * @date: 2020-09-28 10:31
 */
public class JobTaskGetYwtbxx {

    private static String GetYwtbGaUrl = "https://wj.ahga.gov.cn/gsb";

    private static String usercode = "001";

    private static String pwd = "123456";

    private static String md5 = "";

    /**
     * 正式环境
     */
    public static final ServiceEndPoint serviceEndPoint = new ServiceEndPoint(GetYwtbGaUrl);

    private static final String applicationId = "3400-0024";

    private static final String authCode = "ba32cc7a400d6ef562034dca9257b4f8";

    private static final String securityCode = "IzB7kXtv";

    /**
     * 用表格里的应用授权信息进行替换
     */
    public static final ServiceSessionFactory serviceFactory = new ServiceSessionFactory(applicationId,
            authCode, securityCode, serviceEndPoint);

    public static void main(String[] args) {
        new JobTaskGetYwtbxx();
        System.out.println(md5);
//        taskGetYwtbxx();
    }

    public JobTaskGetYwtbxx() {
        System.out.println("外网一网通办--JobTaskGetYwtbxx 获取公安内网--一网通办--数据定时任务初始化了");
        GetYwtbGaUrl = SystemConfig.getSystemConfig("pushYwtbGaUrl");
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
            byte[] buff = m.digest(pwd.getBytes());
            md5 = new String(Hex.encode(buff));
            System.out.println(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void taskGetYwtbxx() {
        //System.out.println("外网获取公安内网长三角一体化数据定时任务");
        String isGetYwtb = SystemConfig.getSystemConfig("isGetYwtb");
        if ("true".equals(isGetYwtb)) {
            System.out.println("JobTaskGetYwtbxx 获取公安内网------" + isGetYwtb);
            Session session = null;
            try {
                session = serviceFactory.openSession(new GsbService("3400-0024-1-00000001", 1, "getYwtbXx"));
                // 默认不加密，可以指定加密算法，必须指定安全码
                session.setEncrypt(Algorithm.NONE);
                session.setProperty(ITransport.TIME_OUT, 1000 * 30);
                //初始化查询参数Json
                GsbResponse response = session.request(
                        new GsbParameter("pcsbm", usercode),
                        new GsbParameter("md5", md5),
                        new GsbParameter("bljg", ""),
                        new GsbParameter("isstatus", "2"),//0是从政务网接收1是从互联网前置机推送到公安网2是公安网办结3是公安网推送到互联网前置机4是互联网推送到政务网 5是推送失败
                        new GsbParameter("pageIndex", GsbDataType.GsbInt, 1),
                        new GsbParameter("pageSize", GsbDataType.GsbInt, 50)
                );
                String responseText = response.getResponseText();

                int errorCode = response.getErrorCode();
                if (errorCode == 200) {
                    //解析返回的json数据
                    System.out.println(response.getResponseText());
                    JSONObject jsonObj = JSON.parseObject(responseText);
                    String list2 = jsonObj.getString("list");
                    //获取到success
                    boolean formData = jsonObj.getBoolean("success");
                    if (formData) {
                        //获取附件材料
                        List<JSONObject> ywtbXxJob = JSONObject.parseObject(list2, List.class);
                        for (int i = 0; i < ywtbXxJob.size(); i++) {
                            JSONObject ywtbxxObj = (JSONObject) ywtbXxJob.get(i);
                            String applyno = ywtbxxObj.getString("applyno");
                            System.out.println("外网获取公安内网一网通办数据 applyno------" + applyno);
                            //根据applyNo查询数据
//                            //获取到ywtbService
                            YwtbService apiService = (YwtbService) SpringContainer.getObject("ywtbService");
                            YwtbXx ywtbXx = apiService.getYwtbXx2(applyno,"4");//20210403 孔庆涛 需要过滤已经推送的数据，避免重复更新，推送给政务网 查询不等于4、3的，bljg为空的
                            if(ywtbXx!=null){
                                String bljg = ywtbxxObj.getString("bljg");
                                ywtbXx.setBljg(bljg);
                                String blyj = ywtbxxObj.getString("blyj");
                                ywtbXx.setBlyj(blyj);
                                ywtbXx.setIsstatus("3");//0是从政务网接收1是从互联网前置机推送到公安网2是公安网办结3是公安网推送到互联网前置机4是互联网推送到政务网 5是推送失败
                                String blBmcode = ywtbxxObj.getString("blBmcode");
                                ywtbXx.setBlBmcode(blBmcode);
                                String blBmName = ywtbxxObj.getString("blBmName");
                                ywtbXx.setBlBmName(blBmName);

                                String blFile = ywtbxxObj.getString("blFile");
                                if (null != blFile || !"".equals(blFile)){
                                    ywtbXx.setBlFile(blFile.getBytes());
                                }
                                //执行修改审核
                                apiService.updateYwtbXx(ywtbXx);
                            }
                        }
                    }
                }
                if (errorCode == 600) {
                    printfDebugMsg("外网获取公安内网一网通办数据", response);
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

        }
    }

    /**
     * 测试获取外网数据
     */
    public void testGetYwtbxx() {
        //String GetYwtbGaUrl = "http://223.247.130.138:5001/hz2004qxgl/services/ywtbWebService";
        String GetYwtbGaUrl = "http://127.0.0.1:8090/hz2004qxgl/services/ywtbWebService";
        Call call2 = null;
        try {
            call2 = new Call(GetYwtbGaUrl);
            call2.setOperationName("getYwtbXx");
            String re = (String) call2.invoke(new Object[]{usercode, md5, "1", "1", 1, 20});
            //解析返回的json数据
            JSONObject jsonObj = JSON.parseObject(re);
            String list2 = jsonObj.getString("list");
            //获取到success
            boolean formData = jsonObj.getBoolean("success");
            if (formData) {
                //获取附件材料
                List<JSONObject> ywtbXxJob = JSONObject.parseObject(list2, List.class);
                for (int i = 0; i < ywtbXxJob.size(); i++) {
                    JSONObject ywtbxxObj = (JSONObject) ywtbXxJob.get(i);
                    String applyno = ywtbxxObj.getString("applyno");
                    //根据applyNo查询数据
                    //获取到ywtbService
                    YwtbService apiService = (YwtbService) SpringContainer.getObject("ywtbService");
                    YwtbXx ywtbXx = apiService.getYwtbXx(applyno);
                    String bljg = ywtbxxObj.getString("bljg");
                    ywtbXx.setBljg(bljg);
                    String blyj = ywtbxxObj.getString("blyj");
                    ywtbXx.setBlyj(blyj);
                    String blBmcode = ywtbxxObj.getString("blBmcode");
                    ywtbXx.setBlBmcode(blBmcode);
                    String blBmName = ywtbxxObj.getString("blBmName");
                    ywtbXx.setBlBmName(blBmName);

                    String blFile = ywtbxxObj.getString("blFile");

                    ywtbXx.setBlFile(blFile.getBytes());
                    //执行修改审核
                    apiService.updateYwtbXx(ywtbXx);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
