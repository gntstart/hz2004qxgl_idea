package com.gnt.qxgl.base;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.SystemConfig;

public class LoginFilter implements Filter {
	public static String loginFlag = "sessionid";
	public static String CharSet = "UTF-8";
	
	static Logger logger = Logger.getLogger(LoginFilter.class);

	public void destroy() {
	}

	/**
	 * 判断需要跳转的URL是不是本地地址
	 * 
	 * @param request
	 * @param gotourl
	 * @return
	 */
	public static boolean isLocationURL(HttpServletRequest request,
			String gotourl) {
		if ("".equals(gotourl))
			return true;

		String baseURL = getBaseURL(request) + request.getContextPath();
		return gotourl.startsWith(baseURL);
	}

	/**
	 * 获取一个不带上下文的请求地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getJSP(HttpServletRequest request) {
		String jsp = request.getRequestURI();
		String contextPath = request.getContextPath();
		if ("/".equals(contextPath))
			contextPath = "";

		if (!"".equals(contextPath)) {
			int seek = jsp.indexOf(contextPath);
			if (seek == 0)
				jsp = jsp.substring(contextPath.length());
		}
		return jsp;
	}

	/**
	 * 获取一个基本URL
	 * 
	 * @param request
	 * @return
	 */
	public static String getBaseURL(HttpServletRequest request) {
		int port = request.getServerPort();
		String url = "";
		if (port == 80) {
			url = request.getScheme() + "://" + request.getServerName();
		} else {
			url = request.getScheme() + "://" + request.getServerName() + ":"
					+ request.getServerPort();
		}

		return url;
	}

	/**
	 * 获取一个完整的URL
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestURL(HttpServletRequest request) {
		String url = getBaseURL(request) + request.getRequestURI();

		Map map = request.getParameterMap();
		if (map != null && map.size() > 0) {
			url += "?";
			for (Iterator it = map.keySet().iterator(); it.hasNext();) {
				String name = (String) it.next();
				String value = ((String[]) map.get(name))[0];
				// sessionid过滤
				if (name.equals(loginFlag) || name.equals("errmsg"))
					continue;

				url += name + "=" + value + "&";
			}
		}
		return url;
	}
	
	public String getParameter(HttpServletRequest httpRequest,String name){
		String value = httpRequest.getParameter(name);
		if(value==null || "".equals(value))
			value = (String)httpRequest.getAttribute(name);
		
		return value;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest httpRequest = (HttpServletRequest) (request);
		HttpServletResponse httpResponse = (HttpServletResponse) (response);
		
		String uri = httpRequest.getRequestURI();

		boolean isjsp = uri.endsWith(".jsp") 
						|| uri.endsWith("/") || uri.endsWith("/upfile")
							|| uri.endsWith(".do") || uri.endsWith(".dwr");
		
		//if (isjsp) {
			try {
				httpRequest.setCharacterEncoding(CharSet);
				httpResponse.setCharacterEncoding(CharSet);
			} catch (Exception e) {
				logger.info("设置输出字符集失败，encoding=" + CharSet, e);
			}finally{
				BaseContext.setCurrentContext(httpRequest, httpResponse);				
			}
		//}else{
			;//System.out.println(uri);
		//}

		if (isjsp) {
			//如果已经登录，哪么返回
			if(httpRequest.getSession().getAttribute(BaseUser.SESSION_USER)!=null){
				chain.doFilter(request, response);
				return;
			}
			
			//如果用户登录超时，并且是ajax请求(JsonStore查询请求)
			String method = httpRequest.getParameter("method");
			if(method==null)
				method = "";
			if(uri.endsWith(".do") && (!uri.endsWith("login.do") || (uri.endsWith("login.do") && !method.equals("changePwd")) )){
				chain.doFilter(request, response);
				return;
			}
			
			// 从当前session中活动登录用户对象信息。
			HttpSession httpSession = httpRequest.getSession();
			
			//获取登陆优先级别
			String yxj = getParameter(httpRequest,"yxj");
			if(yxj==null) yxj="0";
		
			String sessionid = null;
			//如果为1，那么优先从session读取（当外部隐含登陆访问系统的时候采用该方式，防止频繁登陆）
			if(yxj.equals("1"))
				sessionid = (String)httpSession.getAttribute(loginFlag);
			
			//从上下文中读取
			if(sessionid==null || "".equals(sessionid))
				sessionid=getParameter(httpRequest,loginFlag);
			
			boolean isLogin = false;
			
			//如果上下文不带sessionid，那么表示普通页面跳转
			if (sessionid == null || "".equals(sessionid)) {
				Object obj = httpSession.getAttribute(loginFlag);
				if (obj != null){
					isLogin = true;
				}
			}

			/**
			 * 如果用户没有登陆，或者需要重新登陆 如果上下文中的sessionid参数不为空，那么表示需要本地重新登陆
			 * 如果上下文中的sessionid参数为空，并且session也没有该对象，那么表示需要到统一登陆页面登录
			 */

			if (!isLogin
					&& !SystemConfig.exclude_url.contains(getJSP(httpRequest))) {
				String url = getRequestURL(httpRequest);
				String errmsg = "";

				url = java.net.URLEncoder.encode(url, "UTF-8");
				String loginurl = SystemConfig.getSystemConfig("login_url");
				if(loginurl.indexOf("?")<0)
					loginurl += "?";
				else
					loginurl += "&";
				
				url = loginurl + "gotourl="
						+ url + "&errmsg="
						+ java.net.URLEncoder.encode(errmsg, "UTF-8") + "&_dc=" + new Date().getTime();
				
				httpResponse.sendRedirect(url);
				return;
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
