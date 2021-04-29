package com.gnt.qxgl.job;

import com.gnt.qxgl.base.encoders.ImageToPdf;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXx;
import com.gnt.qxgl.service.YwtbService;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import net.sf.json.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 只在外网是有效、内网是不进行推送的
 * 互联网前置机报送到政务网反馈信息推送
 * <p>
 * 外网推送到长三角一体化
 * <p>
 * 查询数据推送的状态 不等于1时  就是不等于成功时 并且判断办理结果要通过
 */
public class JobTaskPush {

    private JobTaskPush() {
        System.out.println("一网通办 JobTaskPush 长三角一体化推送服务初始化了");
    }

    public void taskPush() {
        String isYwtb = SystemConfig.getSystemConfig("isYwtb");
        if ("true".equals(isYwtb)) {
            System.out.println("一网通办 开始执行TaskPush 推送数据");
            YwtbService ywtbService = (YwtbService) SpringContainer.getObject("ywtbService");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("isstatus", "3");
            Page page = ywtbService.queryYwtbXxJob(map, 1, 100);
            List<YwtbXx> list = page.getList();
            System.out.println("开始执行TaskPush数量："+list.size());
            for (int i = 0; i < list.size(); i++) {
                YwtbXx ywtbXx = list.get(i);
                // 请求url
                String ywtbUrl = SystemConfig.getSystemConfig("ywtbUrl");
                System.out.println("请求ywtbUrl地址："+ywtbUrl);
                //封装参数
                Map<String, Object> requestDate = sendYwtbMap(ywtbXx);
                if (null != requestDate) {
                	System.out.println("开始推送发送一网通办");
                    String s = sendPost(ywtbUrl, requestDate);
                    System.out.println("返回参数：" + s);
                    JSONObject json = JSONObject.fromObject(s);
                    boolean success = new Boolean((Boolean) json.get("isSuccess"));
                    if (success) {
                        ywtbXx.setIsstatus("4");//0是从政务网接收1是从互联网前置机推送到公安网2是公安网办结3是公安网推送到互联网前置机4是互联网推送到政务网 5是推送失败
                        ywtbService.updateYwtbXx(ywtbXx);
                    } else {
                        ywtbXx.setIsstatus("5");
                        ywtbService.updateYwtbXx(ywtbXx);
                    }
                }
            }
        }
    }


    public static String sendPost(String urlStr, Map<String, Object> requestParams) {
        System.out.println("请求Url:{}" + urlStr);
        String result = "";
        try {
            // 创建连接
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

//            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
//            conn.setRequestMethod("POST");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            conn.setConnectTimeout(1000 * 5);
//            conn.getOutputStream().write(params.getBytes("utf8"));
//            conn.getOutputStream().flush();
//            conn.getOutputStream().close();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(1000 * 5);
            JSONObject args = JSONObject.fromObject(requestParams);
            connection.getOutputStream().write(args.toString().getBytes("utf8"));
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            byte[] buffer = new byte[1024];
            StringBuffer sb = new StringBuffer();
            InputStream in = connection.getInputStream();
            int httpCode = connection.getResponseCode();
            System.out.println(in.available());
            while(in.read(buffer,0,1024) != -1) {
                sb.append(new String(buffer, "utf-8"));
            }
            System.out.println("sb:" + sb.toString());
            result = sb.toString();
            in.close();
            System.out.println(httpCode);

//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            connection.setRequestMethod("POST");
//            connection.setUseCaches(false);
//            connection.setInstanceFollowRedirects(true);
//            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//            connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
//            connection.setRequestProperty("Charset", "UTF-8");
//            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//            // 服务器的安全设置不接受Java程序作为客户端访问
//            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            // POST请求
//            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//            String parm = URLEncoder.encode(requestParams.toString(), "utf-8");
//            out.write(getParams(requestParams).getBytes("UTF-8"));// 这样可以处理中文乱码问题
//            JSONObject args = JSONObject.fromObject(requestParams);
//            JSONObject jsonObject = JSONObject.fromObject(body);
//            String data1 ="{'data':{'applyNo':'统一审批编码','result':'不通过','suggestion':'你申请的信息不符合开具证明的条件','sldwCode':'310101490000','sldwName':'上海市公安局黄浦分局半淞园派出所','receiveApplyTime':'2020-05-09 23:31:22','Finishtime':'2020-05-09 23:31:22'},'filedata':{'documentType':'1','file':'/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wgARCAAvAEEDASIAAhEBAxEB/8QAFgABAQEAAAAAAAAAAAAAAAAAAQAC/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEF/9oADAMBAAIQAxAAAAHC2zgC0EoTBMCyCyi0FqM2oyqmVVyrBalzaj//xAAUEAEAAAAAAAAAAAAAAAAAAABQ/9oACAEBAAEFAlv/xAAUEQEAAAAAAAAAAAAAAAAAAAAw/9oACAEDAQE/AX//xAAUEQEAAAAAAAAAAAAAAAAAAAAw/9oACAECAQE/AX//xAAUEAEAAAAAAAAAAAAAAAAAAABQ/9oACAEBAAY/Alv/xAAYEAEAAwEAAAAAAAAAAAAAAAARECAwQP/aAAgBAQABPyHnNDAqST//2gAMAwEAAgADAAAAEJJmzTZ5Jkca6KwAP//EABYRAAMAAAAAAAAAAAAAAAAAAAEgMP/aAAgBAwEBPxCYT//EABYRAQEBAAAAAAAAAAAAAAAAAAARIP/aAAgBAgEBPxDVVVVVVX//xAAXEAEBAQEAAAAAAAAAAAAAAAAAAREQ/9oACAEBAAE/EJGMYkYxjIkYxiRjGMSJGMZxjGJGJGMSMY0kSJEiRIk4xIkScSJOMY//2Q=='}}";
//            String data2 ="{'data':{'applyNo':'统一审批编码','result':'不通过','suggestion':'你申请的信息不符合开具证明的条件','opDepartCode':'310101490000','opDepartName':'上海市公安局黄浦分局半淞园派出所','receiveApplyTime':'2020-05-09 23:31:22','Finishtime':'2020-05-09 23:31:22'},'filedata':{'documentType':'1','file':'/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wgARCAAvAEEDASIAAhEBAxEB/8QAFgABAQEAAAAAAAAAAAAAAAAAAQAC/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEF/9oADAMBAAIQAxAAAAHC2zgC0EoTBMCyCyi0FqM2oyqmVVyrBalzaj//xAAUEAEAAAAAAAAAAAAAAAAAAABQ/9oACAEBAAEFAlv/xAAUEQEAAAAAAAAAAAAAAAAAAAAw/9oACAEDAQE/AX//xAAUEQEAAAAAAAAAAAAAAAAAAAAw/9oACAECAQE/AX//xAAUEAEAAAAAAAAAAAAAAAAAAABQ/9oACAEBAAY/Alv/xAAYEAEAAwEAAAAAAAAAAAAAAAARECAwQP/aAAgBAQABPyHnNDAqST//2gAMAwEAAgADAAAAEJJmzTZ5Jkca6KwAP//EABYRAAMAAAAAAAAAAAAAAAAAAAEgMP/aAAgBAwEBPxCYT//EABYRAQEBAAAAAAAAAAAAAAAAAAARIP/aAAgBAgEBPxDVVVVVVX//xAAXEAEBAQEAAAAAAAAAAAAAAAAAAREQ/9oACAEBAAE/EJGMYkYxjIkYxiRjGMSJGMZxjGJGJGMSMY0kSJEiRIk4xIkScSJOMY//2Q=='}}";
//            out.writeBytes(args.toString());
//            connection.getOutputStream().write(args.toString().getBytes("utf8"));
//            connection.connect();
//            System.out.println("开始POST请求");
//            out.flush();
//            out.close();
            // 读取响应
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String lines;
//            StringBuffer sb = new StringBuffer("");
//            while ((lines = reader.readLine()) != null) {
//                //lines = new String(lines.getBytes(), "utf-8");
//                sb.append(lines);
//            }
//            result = sb.toString();
//            reader.close();
//            // 断开连接
//            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    private static String getParams(Map<String, String> requestParams) {
        StringBuilder params = new StringBuilder(100);
        if (MapUtils.isNotEmpty(requestParams)) {
            for (String key : requestParams.keySet()) {
                String value = requestParams.get(key);
                if (StringUtils.isNotEmpty(value)) {
                    params.append(key);
                    params.append("=");
//                    params.append(URLEncoder.encode(value, "UTF-8"));
                    params.append(value);
                    params.append("&");
                }
            }

        }
        return params.toString();
    }


    private Map<String, Object> sendYwtbMap(YwtbXx ywtbXx) {
    	JSONObject dataParams = new JSONObject();
    	JSONObject filedataParams = new JSONObject();
        Map<String, Object> requestParams = new HashMap<String, Object>();
        if (ywtbXx != null) {
            dataParams.put("applyNo", ywtbXx.getApplyno());

            String bljg = ywtbXx.getBljg();
            if (bljg == null) {
                return null;
//                throw new ServiceException("未对一网通数据进行处理，无法推送");
            }
            byte[] blFile = ywtbXx.getBlFile();
            if (blFile == null) {
                return null;
//                throw new ServiceException("未对一网通数据进行,出具证明上传，无法推送");
            }
            // 0 通过 、1 不通过
            if ("0".equals(bljg)) {
                dataParams.put("result", "通过");
                filedataParams.put("documentType", "1");//户籍证明
                filedataParams.put("fileName", "户籍证明.jpg");//户籍证明
            } else {
                dataParams.put("result", "不通过");
                filedataParams.put("documentType", "2");//不予出具告知书
                filedataParams.put("fileName", "不予出具证明告知书.jpg");//户籍证明
            }
            String suggestion = ywtbXx.getBlyj();
            dataParams.put("suggestion", suggestion);
            dataParams.put("sldwCode", ywtbXx.getSldwcode());
            dataParams.put("sldwName", ywtbXx.getSldwname());
            dataParams.put("receiveApplyTime", ywtbXx.getCjsj().toString());

            //创建SimpleDateFormat对象，指定样式    2019-05-13 22:39:30
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dataParams.put("Finishtime", sdf1.format(new Date()));
            //将图片的byte数组 转为pdf byte数组  2021-4-2 孔庆涛 注释 不需要pdf转换base64 互转
           // byte[] bytes = ImageToPdf.generatePDF(ywtbXx.getBlFile());
            byte[] bytes = ywtbXx.getBlFile();
            //ImageToPdf.conserveFile("test1.pdf",bytes);
            filedataParams.put("documentType", "1");
            BASE64Encoder encode = new BASE64Encoder();
            filedataParams.put("file", encode.encode(bytes).trim().replaceAll("\r\n", ""));
            requestParams.put("data", dataParams);
            requestParams.put("filedata", filedataParams);
            return requestParams;
        }
        return null;

    }


    private String sendYwtbJson(YwtbXx ywtbXx) {

        JSONObject jsonObj = new JSONObject();
        if (ywtbXx != null) {
            jsonObj.put("applyno", ywtbXx.getApplyno());
            String bljg = ywtbXx.getBljg();
            if (bljg == null) {
                throw new ServiceException("未对一网通数据进行处理，无法推送");
            }
            byte[] blFile = ywtbXx.getBlFile();
            if (blFile == null) {
                throw new ServiceException("未对一网通数据进行,出具证明上传，无法推送");
            }
            // 0 通过 、1 不通过
            if ("0".equals(bljg)) {
                jsonObj.put("result", "通过");
                jsonObj.put("documentType", "1");
            } else {
                jsonObj.put("result", "不通过");
                jsonObj.put("documentType", "2");
            }
            String suggestion = ywtbXx.getBlyj();
            jsonObj.put("suggestion", suggestion);
            jsonObj.put("opDepartCode", ywtbXx.getBlBmcode());
            jsonObj.put("opDepartName", ywtbXx.getBlBmName());
            jsonObj.put("receiveApplyTime", ywtbXx.getCjsj());
            jsonObj.put("finishtime", new Date());

            //将图片的byte数组 转为pdf byte数组
            byte[] bytes = ImageToPdf.generatePDF(ywtbXx.getBlFile());

            //ImageToPdf.conserveFile("test1.pdf",bytes);
            jsonObj.put("file", Base64.encode(bytes).trim());

            return jsonObj.toString();
        }
        return null;

    }

//    public static void main(String[] args) {
//        String urlStr = "http://223.244.92.53:8090/api-v3.2/djz-sz-csj-hjzm-rest/api/hjzmFk";
//        String requestParams = "{\"data\":{\"applyNo\":\"CSJ202008115000504\",\"result\":\"不通过\",\"suggestion\":\"你申请的信息不符合开具证明的条件\",\"sldwCode\":\"340100000000\",\"sldwName\":\"上海市公安局黄浦分局半淞园派出所\",\"receiveApplyTime\":\"2021-03-19 16:49:13.0\",\"Finishtime\":\"2021-03-30 14:49:30\"},\"filedata\":{\"documentType\":\"1\",\"file\":\"\"}}";
//
//        String body = HttpRequest.post(urlStr)
//                .body(requestParams)
//                .execute().body();
//        System.out.println(body);
//
//    }
    public static void main(String[] args) {
        String urlString = "http://223.244.92.53:8090/api-v3.2/djz-sz-csj-hjzm-rest/api/hjzmFk";
        String params = "{\"data\":{\"applyNo\":\"CSJ202008115000504\",\"result\":\"不通过\",\"suggestion\":\"你申请的信息不符合开具证明的条件\",\"sldwCode\":\"340100000000\",\"sldwName\":\"上海市公安局黄浦分局半淞园派出所\",\"receiveApplyTime\":\"2021-03-19 16:49:13.0\",\"Finishtime\":\"2021-03-30 14:49:30\"},\"filedata\":{\"documentType\":\"1\",\"file\":\"\"}}";
        URL url;
        try {
            url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(1000 * 5);
            conn.getOutputStream().write(params.getBytes("utf8"));
            conn.getOutputStream().flush();
            conn.getOutputStream().close();

            byte[] buffer = new byte[1024];
            StringBuffer sb = new StringBuffer();
            InputStream in = conn.getInputStream();
            int httpCode = conn.getResponseCode();
            System.out.println(in.available());
            while(in.read(buffer,0,1024) != -1) {
                sb.append(new String(buffer));
            }
            System.out.println("sb:" + sb.toString());
            in.close();
            System.out.println(httpCode);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
