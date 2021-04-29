package com.gnt.qxgl.base;

import com.gnt.qxgl.common.util.DateHelper;
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
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <功能概述>
 * 长三角跨省户口网上迁移
 * 准迁证，迁移证信息测试发送
 *
 * @author: 杨冬冬
 * @className: ReceiveZqzQyzTest
 * @package: com.gnt.qxgl.base
 * @description: 介绍
 * @date: 2020-12-25 8:54
 */
public class ReceiveZqzQyzTest {

    private static String url = "http://127.0.0.1:8090/hz2004qxgl/receive/receiveZqzQyz";

    public static void main(String[] args) {
        System.out.println(DateHelper.formateDate("MM"));
//        System.out.println(a.indexOf("皖"));
//
//        //定义参数XML数据
//        Document document = parse2Document("F:/test/4.xml");
//        //调用方法
//        sendPost_httpClient(url, document.asXML(), "application/xml");
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
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
            System.out.println("读取classpath下xmlFileName文件发生异常，请检查CLASSPATH和文件名是否存在！");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static String sendPost_httpClient (String url, String data, String contenttype){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Post请求
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(data, "UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);
        if (contenttype != null) {
            httpPost.setHeader("Content-Type", contenttype);
        }
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
                return responseEntity.getContent().toString();
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
}
