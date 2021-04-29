<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "../config.jsp"%>
<%
	String formdq=request.getParameter("formdq");	//迁出地区
	String todq=request.getParameter("todq");		//迁入地区
	String sqr_gmsfhm = request.getParameter("sqr_gmsfhm");	//迁入地审批业务ID
    String ywlsh = request.getParameter("ywlsh");
    String rkurl = request.getParameter("rkurl");	//迁入地审批业务ID

    String qyzDbJump=request.getParameter("qyzDbJump");//迁移证跳转随机值
    String qyzDbGmsfhm=request.getParameter("qyzDbGmsfhm");//迁移证跳转sfz

    if(qyzDbJump==null) qyzDbJump = "";

	if(formdq==null) formdq = "";
	if(todq==null) todq="";
	if(sqr_gmsfhm==null) sqr_gmsfhm="";
	
	if(formdq.length()>4) formdq = formdq.substring(0,4);
	if(todq.length()>4) todq = todq.substring(0,4);
	String zqzhyUrl = SystemConfig.getSystemConfig("zqzhyUrl");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
  	<base href="<%=basePath%>">
    	<title>迁出业务</title>
    	<link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
    	<link rel="stylesheet" type="text/css" href="js/ext/css/xtheme-gray.css">
  </head>
  <style type="text/css">
	  .changeplus
	{
	    background-color: #f00000;
	}
	.changediv
	{
	    background-color: #F79709;
	}
  </style>
  <body>
    <script type="text/javascript">
    	var formdq = "<%=formdq%>";
    	var todq = "<%=todq%>";
    	var sqr_gmsfhm = "<%=sqr_gmsfhm%>";
        var ywlsh = "<%=ywlsh%>";
        var rkurl = "<%=rkurl%>";
        var zqzhyUrl ="<%=zqzhyUrl%>";
        var qyzDbJump = "<%=qyzDbJump%>";
        var qyzDbGmsfhm = "<%=qyzDbGmsfhm%>";
    </script>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/commFrames.js"></script>
    <script type="text/javascript" src="js/CzrkStore.js"></script>
    <script type="text/javascript" src="js/CzrkGrid.js"></script>
    <script type="text/javascript" src="js/SjpzStore.js"></script>
    <script type="text/javascript" src="js/BggzStore.js"></script>
    <script type="text/javascript" src="js/BggzGrid.js"></script>
    <script type="text/javascript" src="yw/qc_new1.js"></script>
    <div id="div1"></div>
  </body>
</html>
