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
    	<style type="text/css">
	.otherfile {
	    background-image:url(images/3.gif) !important;
	    
	    
	    .x-grid3-header-offset {
		    width: auto;
		}
		.ux-grid-hd-group-cell {
		    background: url(../resources/images/default/grid/grid3-hrow.gif) repeat-x bottom;
		}
	}
	</style>
  </head>
  <body>
   	<!-- Include Ext and app-specific scripts: -->
   	<Script Lanaguage="JavaScript">
   		var contextPath = "<%=path%>";
   	</Script>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/ext/ColumnHeaderGroup.js"></script>
    <script type="text/javascript" src="js/ext/GroupHeaderPlugin.js"></script>
    <script type="text/javascript" src="js/commFrames2.js"></script>
    <script type="text/javascript" src="js/RktjBndbdQrMxStore.js"></script>
    <script type="text/javascript" src="js/RktjBndbdQrMxGrid.js"></script>
    <script type="text/javascript" src="js/ExtExport.js"></script>
    <script type="text/javascript" src="tj/rktjBndbdQrMx.js"></script>
  </body>
</html>
