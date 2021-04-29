<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "../config.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    	<title>统计</title>
	<link rel="stylesheet" type="text/css" href="css/report_style.css">
    	<link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
    	<link rel="stylesheet" type="text/css" href="js/ext/css/xtheme-gray.css">
		<link rel="stylesheet" type="text/css" href="ywpm/css/style.css">
  </head>
  <body>
   	<!-- Include Ext and app-specific scripts: -->
   	<Script Lanaguage="JavaScript">
   		var contextPath = "<%=path%>";
   	</Script>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/commFrames.js"></script>
    <script type="text/javascript" src="ywpm/js/YwpmMxStore.js"></script>
    <script type="text/javascript" src="ywpm/js/YwpmMxGrid.js"></script>
    <script type="text/javascript" src="ywpm/js/ywpmMx.js"></script>
  </body>
</html>
