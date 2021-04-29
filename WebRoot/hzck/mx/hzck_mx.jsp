<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "/config.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>户办窗口-明细</title>
	<link rel="stylesheet" type="text/css" href="css/report_style.css">
	<link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
	<link rel="stylesheet" type="text/css" href="<%=SystemConfig.getSystemConfig("default_css")%>">
</head>
<body>
<Script Langguage="JavaScript">
	
	var dsdm = "<%=request.getParameter("dsdm")%>";
	var yhlx = "<%=request.getParameter("yhlx")%>";
	var sj = '<%=DateHelper.formateDate(new Date(),DateHelper.CN_MINUTE_STYLE)%>';
	
</Script>
<script type="text/javascript" src="js/ext/ext.js"></script>
<script type="text/javascript" src="js/pub.js"></script>
<script type="text/javascript" src="js/rydwtree.js"></script>
<script type="text/javascript" src="js/xzqhtree.js"></script>
<script type="text/javascript" src="hzck/mx/hzck_mx.js"></script>
</body>
</html>
