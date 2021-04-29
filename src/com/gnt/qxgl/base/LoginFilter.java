package com.gnt.qxgl.base;

import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.*;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.service.LoginService;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

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
            for (Iterator it = map.keySet().iterator(); it.hasNext(); ) {
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

    public String getParameter(HttpServletRequest httpRequest, String name) {
        String value = httpRequest.getParameter(name);
        if (value == null || "".equals(value))
            value = (String) httpRequest.getAttribute(name);

        return value;
    }

    public static String getRequestPath(HttpServletRequest request) {
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

    public String getParamsByISO(ServletRequest request, String name) {
        String str = null;
        try {
            String value = request.getParameter(name);
            if (value == null)
                return value;

            str = new String(value.getBytes("iso-8859-1"), "UTF-8");
        } catch (Exception e) {
            ;
        }

        return str;
    }

    /**
     * 获取SID
     *
     * @param request
     * @return
     */
    static public String getSID(HttpServletRequest request, HttpServletResponse response) {
        String sid = request.getParameter(Constants.COOKIE_SID);
        if (CommonUtil.isNotEmpty(sid))
            return sid;

        sid = (String) request.getAttribute(Constants.COOKIE_SID);
        if (CommonUtil.isNotEmpty(sid))
            return sid;

        //没有，从cookies里面取
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (Constants.COOKIE_SID.equals(cookies[i].getName())) {
                    sid = cookies[i].getValue();
                    break;
                }
            }
        }

        if (CommonUtil.isEmpty(sid)) {
            sid = HSession.createSID();
            Cookie c1 = new Cookie(Constants.COOKIE_SID, sid);
            //c1.setPath("/");
            //不能将localhost写到domain中，可为127.0.0.1
            //if(!Constants.APP_DOMAIN.equals("localhost"))
            //	c1.setDomain(Constants.APP_DOMAIN);
            //c1.setMaxAge(Constants.cookieMaxAge);
            response.addCookie(c1);
            request.setAttribute(Constants.COOKIE_SID, sid);
            //写入地区Cookies
            //Cookie dq = new Cookie(Constants.COOKIE_SID, sid);
            //dq.setPath("/");
            //dq.setDomain("192.168.2.146");
            //dq.setMaxAge(Constants.cookieMaxAge);

            //response.addCookie(dq);
        }

        return sid;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) (request);
        HttpServletResponse httpResponse = (HttpServletResponse) (response);

        String uri = httpRequest.getRequestURI();
        long time1 = System.currentTimeMillis();

        boolean isjsp = uri.endsWith(".jsp")
                || uri.endsWith("/") || uri.endsWith("/upfile") || uri.endsWith("/util/dict")
                || uri.endsWith(".do") || uri.endsWith(".dwr") || uri.endsWith("/receive/receiveZqzQyz");

        try {
            httpRequest.setCharacterEncoding(CharSet);
            httpResponse.setCharacterEncoding(CharSet);
        } catch (Exception e) {
            logger.info("设置输出字符集失败，encoding=" + CharSet, e);
        } finally {
            BaseContext.setCurrentContext(httpRequest, httpResponse);
        }

        //获取COOKIE_SID
        String COOKIE_SID = getSID((HttpServletRequest) request, httpResponse);
        if (isjsp) {
            //如果用户登录超时，并且是ajax请求(JsonStore查询请求)
            String method = httpRequest.getParameter("method");
            if (method == null)
                method = "";

            //特殊情况1，有可能需要重新登录
            String jsp = getRequestPath((HttpServletRequest) request);
            if (jsp.startsWith("/receive/receiveZqzQyz")) {
                //特殊业务
                httpResponse.setContentType("application/json; charset=utf-8");
                chain.doFilter(request, httpResponse);
                return;
            }
            if (jsp.startsWith("/util/upfile")) {
                //上传文件
//                httpResponse.setContentType("application/json; charset=utf-8");
                chain.doFilter(request, httpResponse);
                return;
            }
            if (jsp.startsWith("/yw/")) {
                if (method.equals("requestXLH") || method.startsWith("requestDqbm")) {
                    //特殊业务
                    chain.doFilter(request, response);
                    return;
                }

                //此开头URL，特殊处理，自动以管理员登录
                if (CommonUtil.isNotEmpty(request.getParameter("authToken"))) {
                    String authToken = getParamsByISO(request, "authToken");
                    //kdshjqy.jsp?authToken=1&dwdm=340102
                    if (CommonUtil.isNotEmpty(authToken)) {
                        String sfzh = getParamsByISO(request, "sfzh");
                        String yhxm = getParamsByISO(request, "yhxm");
                        String yhid = getParamsByISO(request, "yhid");
                        String dwdm = getParamsByISO(request, "dwdm");
                        String yhdlm = getParamsByISO(request, "yhdlm");
                        String isAdmin = getParamsByISO(request, "isAdmin");

                        ExtMap<String, Object> params = new ExtMap<String, Object>();
                        params.put("authToken", authToken);
                        params.put("sfzh", sfzh);
                        params.put("yhxm", yhxm);
                        params.put("yhid", yhid);
                        params.put("dwdm", dwdm);
                        params.put("yhdlm", yhdlm);
                        params.put("isAdmin", isAdmin == null ? "false" : isAdmin);
                        String login_user = SystemConfig.getSystemConfig("user_prefix", "HZADMIN") + dwdm.substring(0, 4);
                        LoginService service = (LoginService) SpringContainer.getObject("loginService");
                        try {
                            service.loginByYhm(login_user, params);
                        } catch (Exception e) {
                            response.getOutputStream().println(new String(e.getMessage().getBytes("UTF-8"), "ISO-8859-1"));
                            return;
                        }
                        BaseUser u = BaseUser.getCurrent();
                        u.setYwdq(dwdm);
                    }
                } else {
                    if (HSession.getBaseUser(COOKIE_SID) == null) {
//						ExtMap<String,Object> params = new ExtMap<String,Object>();
//						params.put("authToken", "");
//						params.put("sfzh", "430521197306235736");
//						params.put("yhxm", "管理员");
//						//用户ID决定数据范围，重要
//						params.put("yhid", "3407000001000001262");
//						params.put("dwdm", "3401001100");
//						params.put("yhdlm", "hzadmin");
//						
//						String login_user = SystemConfig.getSystemConfig("user_prefix", "HZADMIN") + params.getString("dwdm").substring(0, 4);
//						LoginService service = (LoginService)SpringContainer.getObject("loginService");
//						try{
//							service.loginByYhm(login_user, params);
//						}catch(Exception e){
//							
//						}
//						BaseUser u = BaseUser.getCurrent();
//						u.setYwdq(params.getString("dwdm"));
                        //response.getOutputStream().println(new String("用户身份已失效，请重新登录！".getBytes("UTF-8"), "ISO-8859-1"));
                        String s = new String("用户身份已失效，请重新登录！");
                        httpResponse.getOutputStream().println(s);
                        return;
                    }
                }
            }

            //特殊情况2，有可能需要重新登录
            String yhm = "";
            String mysid = "";
            if (jsp.equals("/echartsZlNew.jsp")) {
                BaseUser u = new BaseUser();
                String login_user = "ahjc";
                LoginService service = (LoginService) SpringContainer.getObject("loginService");
                try {
                    u = service.loginByYhm(login_user, null);
                } catch (Exception e) {
                    response.getOutputStream().println(new String(e.getMessage().getBytes("UTF-8"), "ISO-8859-1"));
                    return;
                }
                yhm = u.getUser().getDlm();
                mysid = u.getUser().getDlsid();
            } else {
                yhm = request.getParameter("yhm");
                mysid = request.getParameter("sid");
                if (CommonUtil.isNotEmpty(yhm) && CommonUtil.isNotEmpty(mysid)) {
                    //自动登录
                    LoginService service = (LoginService) SpringContainer.getObject("loginService");
                    service.loginBYSID(yhm, mysid);
                }
            }

            BaseUser user = HSession.getBaseUser(COOKIE_SID);
            if (user != null)
                request.setAttribute(Constants.USER_ATTRNAME, user);

            //如果已经登录，哪么返回
            if (user != null) {
                chain.doFilter(request, response);
                System.out.println(uri + "\t" + (System.currentTimeMillis() - time1) + "毫秒");
                return;
            }

            /**
             * 如果用户没有登陆，或者需要重新登陆 如果上下文中的sessionid参数不为空，那么表示需要本地重新登陆
             * 如果上下文中的sessionid参数为空，并且session也没有该对象，那么表示需要到统一登陆页面登录
             */
            String s = getJSP(httpRequest);
            if (user == null
                    && !SystemConfig.exclude_url.contains(getJSP(httpRequest))) {
//				
//				if(uri.endsWith(".do") && (!uri.endsWith("login.do") || (uri.endsWith("login.do") && !method.equals("changePwd")) )){
//					chain.doFilter(request, response);
//					return;
//				}
//				
                String url = getRequestURL(httpRequest);
                String errmsg = "";

                url = java.net.URLEncoder.encode(url, "UTF-8");
                String loginurl = SystemConfig.getSystemConfig("login_url");
                if (loginurl.indexOf("?") < 0)
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
        System.out.println(uri + "\t" + (System.currentTimeMillis() - time1) + "毫秒");
    }

    public void init(FilterConfig arg0) throws ServletException {
    }
}
