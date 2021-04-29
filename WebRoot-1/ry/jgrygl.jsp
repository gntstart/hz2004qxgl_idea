<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "/config.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	BaseUser u = BaseContext.getBaseUser();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>权限管理首页</title>
	<link rel="stylesheet" type="text/css" href="css/report_style.css">
    <link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
    <link rel="stylesheet" type="text/css" href="<%=SystemConfig.getSystemConfig("default_css")%>">
  </head>
  <body>
	<Script Langguage="JavaScript">
			window._isAdmin = "<%=com.gnt.qxgl.common.base.TemplateUtil.isAdmin()?"1":"0"%>";
			window._sjfw = "<%=com.gnt.qxgl.common.base.TemplateUtil.getSjfw()%>";
			var jy_xm_edit = "<%=(SystemConfig.getSystemConfig("jy_xm_edit")==null?"1:":SystemConfig.getSystemConfig("jy_xm_edit"))%>";
			var defSjfw = "<%=u.getSjfw()%>";
  	</Script>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/pub.js"></script>
    <script type="text/javascript" src="js/rydwtree.js"></script>
    <script type="text/javascript" src="js/projectjs.js"></script>
    <script type="text/javascript" src="js/xzqhtree.js"></script>
    <script type="text/javascript" src="js/sfz.js"></script>
    <script type="text/javascript" src="ry/jgrygl.js"></script>
  </body>
</html>
