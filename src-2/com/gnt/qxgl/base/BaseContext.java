package com.gnt.qxgl.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Constants;

public class BaseContext {
	static public String SESSION_USER_ID = "sessionid";

	private static ThreadLocal<BaseContext> a  = new ThreadLocal<BaseContext>();
	
	static synchronized public void setCurrentContext(
			HttpServletRequest request,HttpServletResponse response) 
	{
		BaseContext c = getContext();
		if (c == null) {
			c = new BaseContext(request, response);
			a.set(c);
		} else {
			c.setRequest(request);
			c.setResponse(response);
		}
	}
	
	public static BaseContext getContext() {
		return (BaseContext) a.get();
	}

	public static void unregisterContext() {
		a.set(null);
	}
	
	private HttpServletRequest request;
	private HttpServletResponse response;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	private BaseContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public static BaseUser getBaseUser(){
		try{
			BaseUser u = (BaseUser)BaseContext.getContext().getRequest().getAttribute(Constants.USER_ATTRNAME);
			return u;
		}catch(Exception e){
				return null;
		}
	}
	
	public static String getUserCode() {
		BaseUser u = getBaseUser();
		if(u==null)
			return null;
		
		return u.getUser().getDlm();
	}

	public static void registerContext(BaseContext context) {
		a.set(context);
	}

	public Object getSessionAttribute(String name) {
		if(request==null || request.getSession()==null)
			return null;
		
		return request.getSession().getAttribute(name);
	}

	public void setSessionAttribute(String name, Object obj) {
		request.getSession().setAttribute(name, obj);
	}

	public void removeSessionAttribute(String name) {
		request.getSession().removeAttribute(name);
	}

    public ServletContext getServletContext() {
        HttpSession session = this.getSession();
        return session.getServletContext();
    }

    public HttpSession getSession() {
        return request.getSession();
    }
    
    public Object getContextAttribute(String attr) {
        ServletContext sc = this.getServletContext();
        return sc.getAttribute(attr);
    }

    public void setContextAttribute(String attr, Object value) {
        ServletContext sc = this.getServletContext();
        sc.setAttribute(attr, value);
    }

    public Object getRequestAttribute(String attr) {
        return request.getAttribute(attr);
    }

    public void setRequestAttribute(String attr, Object value) {
        request.setAttribute(attr, value);
    }
}