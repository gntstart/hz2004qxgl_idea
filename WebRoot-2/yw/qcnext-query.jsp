<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "../config.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    	<title>跨地市迁出</title>
	<link rel="stylesheet" type="text/css" href="css/report_style.css">
    	<link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
    	<link rel="stylesheet" type="text/css" href="js/ext/css/xtheme-gray.css">
    	<style type="text/css">
	.otherfile {
	    background-image:url(images/3.gif) !important;
	}
	</style>
  </head>
  <body>
   	<!-- Include Ext and app-specific scripts: -->
   	<Script Lanaguage="JavaScript">
   		var contextPath = "<%=path%>";
   	</Script>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/commFrames.js"></script>
    <script type="text/javascript" src="js/CzrkStore.js"></script>
    <script type="text/javascript" src="js/CzrkGrid.js"></script>
    <script type="text/javascript" src="yw/qcnext-query.js"></script>	
  </body>
</html>
