package com.gnt.qxgl.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.service.ZzjyManagerService;

public class ChangeJyzt extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ZzjyManagerService zzjyManagerService = (ZzjyManagerService) SpringContainer
				.getObject("zzjyManagerService");
		try {

			request.setCharacterEncoding("UTF-8");
			int size = request.getContentLength();
			System.out.println(size);

			InputStream is = request.getInputStream();

			byte[] reqBodyBytes = readBytes(is, size);

			String res = new String(reqBodyBytes);
		
			JSONArray array = JSONArray.fromObject(res);
			System.out.println(res);
			if (array.size() < 1) {

				throw new Exception("JSON格式错误，请查看后台信息！");
			}
			JSONObject object = JSONObject.fromObject(array.get(0));

			
			String dqbm=(String)object.getString("dqbm");
			String yhzt=(String)object.getString("yhzt");
		    String key=(String)object.getString("key");
		    if(!"DJIEAIFH124".equals(key)){
		    	System.out.println("当前KEY没有通过验证！");
		    	String res2 = "[ {\"resultCode\":\"2\"}]";
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getOutputStream().write(res2.getBytes("utf-8"));
				response.flushBuffer();
				return ;
		    	
		    }
			String images = object.getString("yhids");
			Map zpMap = new HashMap();
			JSONArray imagesAyy = JSONArray.fromObject(images);
			String ids="";
			if (imagesAyy.size() > 0) {
				for (int i = 0; i < imagesAyy.size(); i++) {
					JSONObject image = imagesAyy.getJSONObject(i);
					String uid = image.getString("uid");
					ids+=uid+",";
					}
			}
			if(ids.length()>0){
				ids=ids.substring(0,ids.length()-1);
			}
		
			
			zzjyManagerService.changeZzjyZt(dqbm, ids, yhzt);
			
			System.out.println("执行成功！");
			res = "[ {\"resultCode\":\"1\"}]";
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getOutputStream().write(res.getBytes("utf-8"));

			response.flushBuffer();
			
			
		} catch (Exception e) {
			System.out.println("执行失败！");
			e.printStackTrace();
			String res2 = "[ {\"resultCode\":\"0\"}]";
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getOutputStream().write(res2.getBytes("utf-8"));
			response.flushBuffer();
		}

	}
	
	
	public static final byte[] readBytes(InputStream is, int contentLen) {
		if (contentLen > 0) {
			int readLen = 0;
			int readLengthThisTime = 0;
			byte[] message = new byte[contentLen];
			try {

				while (readLen != contentLen) {
					readLengthThisTime = is.read(message, readLen, contentLen
							- readLen);
					if (readLengthThisTime == -1) {// Should not happen.break;
					}
					readLen += readLengthThisTime;
				}
				return message;
			} catch (IOException e) {
				// Ignore
				e.printStackTrace();
			}
		}
		return new byte[] {};
	}

	
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	
	

}