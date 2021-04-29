package com.gnt.qxgl.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gnt.qxgl.common.BaseUser;

public class BaseLogin implements LocationLogin{
	public String Login(HttpServletRequest request, HttpServletResponse response,  BaseUser user) {
		HttpSession session = request.getSession(true);
        session.setAttribute(BaseUser.SESSION_USER,user);
        
        return null;
	}
	
	public static boolean isBasePage(String url,String pageurl){
		if(url==null || "".equals(url) || pageurl==null || "".equals(pageurl))
			return true;
		
		if(pageurl.indexOf(".jsp")>0){
			int seek = pageurl.lastIndexOf("/");
			pageurl = pageurl.substring(0,seek);
		}
		if(!pageurl.endsWith("/")) pageurl += "/";
		
		return url.startsWith(pageurl);
	}
}
