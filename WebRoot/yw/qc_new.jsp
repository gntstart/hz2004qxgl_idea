<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "../config.jsp"%>
<%
	String formdq=request.getParameter("formdq");	//迁出地区
	String todq=request.getParameter("todq");		//迁入地区
	String spywid = request.getParameter("spywid");	//迁入地审批业务ID
	
	if(formdq==null) formdq = "";
	if(todq==null) todq="";
	if(spywid==null) spywid="";
	
	if(formdq.length()>4) formdq = formdq.substring(0,4);
	if(todq.length()>4) todq = todq.substring(0,4);
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
    	var spywid = "<%=spywid%>";	
    </script>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/commFrames.js"></script>
    <script type="text/javascript" src="js/CzrkStore.js"></script>
    <script type="text/javascript" src="js/CzrkGrid.js"></script>
    <script type="text/javascript" src="js/SjpzStore.js"></script>
    <script type="text/javascript" src="js/BggzStore.js"></script>
    <script type="text/javascript" src="js/BggzGrid.js"></script>
    <script type="text/javascript" src="yw/qc_new.js"></script>
    <div id="div1"></div>
  </body>
</html>
