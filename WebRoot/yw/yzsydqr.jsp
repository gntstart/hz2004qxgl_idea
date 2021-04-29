<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../config.jsp" %>
<%
    BaseUser u = BaseContext.getBaseUser();
    String rkurl = request.getParameter("rkurl");	//迁入地审批业务ID
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
    <base href="<%=basePath%>">
    <title>跨地市迁出</title>
    <link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
    <link rel="stylesheet" type="text/css" href="js/ext/css/xtheme-gray.css">
</head>
<Script Lanaguage="JavaScript">
    var cfWin = null;
    var basePath='<%=basePath%>';
    var rkurl = rkurl;
    var user = {
            usercode:'<%=u.getUser().getDlm()%>',
            yhid:'<%=u.getUser().getYhid()%>',
            dwdm:'<%=u.getUser().getSsdwjgdm()%>',
            glylx:'1',
            glyxm:'<%=u.getUser().getXm()%>',
            dlsj:'<%=u.getLoginTime()%>',
        }
</Script>
<body>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/commFrames.js"></script>
    <script type="text/javascript" src="js/KdqqrHjspywStore.js"></script>
    <script type="text/javascript" src="js/KdqqrHjspywGrid.js"></script>
    <script type="text/javascript" src="yw/yzsydqr.js"></script>
<div id="div1"></div>
</body>
</html>
