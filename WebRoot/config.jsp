<%@page trimDirectiveWhitespaces="true" %>
<%@page import="java.util.*"%>
<%@page import="java.net.*"%>
<%@page import="com.gnt.qxgl.service.*"%>
<%@page import="com.gnt.qxgl.hz2004.entity.*"%>
<%@page import="com.gnt.qxgl.bean.*"%>
<%@page import="com.gnt.qxgl.base.*"%>
<%@page import="com.gnt.qxgl.base.util.*"%>
<%@page import="com.gnt.qxgl.common.util.*"%>
<%@page import="com.gnt.qxgl.common.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ path+"/";
	String sysDate = DateHelper.getMonthEndDate2();
%>