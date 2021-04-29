<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "../config.jsp"%>
<%
	String ywid = request.getParameter("ywid");
	System.out.println("ywid=" + ywid);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    	<title>迁入业务</title>
	<link rel="stylesheet" type="text/css" href="css/report_style.css">
    	<link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
    	<link rel="stylesheet" type="text/css" href="js/ext/css/xtheme-gray.css">
  </head>
  <body>
    <script Language="JavaScript">
    	var ywid = "<%=ywid%>";
    </script>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/commFrames.js"></script>
    <script type="text/javascript" src="js/SelectBzdz.js"></script>
    <script type="text/javascript" src="js/HcyGrid.js"></script>
    <script type="text/javascript" src="js/SelectRh.js"></script>
    <script type="text/javascript" src="yw/ryqr.js"></script>
  </body>
</html>
