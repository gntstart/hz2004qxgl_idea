<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../config.jsp" %>
<%
    BaseUser u = BaseContext.getBaseUser();
    String rkurl = request.getParameter("rkurl");
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
    var rkurl = "<%=rkurl%>";
    var user = {
            usercode:'<%=u.getUser().getDlm()%>',
            yhid:'<%=u.getUser().getYhid()%>',
            dwdm:'<%=u.getUser().getSsdwjgdm()%>',
            glylx:'1',
            glyxm:'<%=u.getUser().getXm()%>',
            dlsj:'<%=u.getLoginTime()%>',
        };
    var qcdqbm = user.dwdm.substr(0,4);
</Script>
<body>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="js/commFrames.js"></script>
    <script type="text/javascript" src="js/lodop/CheckActivX.js"></script>
    <script type="text/javascript" src="js/KdqHjspywStore.js"></script>
    <script type="text/javascript" src="js/KdqHjspywGrid.js"></script>
    <script type="text/javascript" src="js/KdqqrHjspywStore.js"></script>
    <script type="text/javascript" src="js/KdqqrHjspywGrid.js"></script>
    <script type="text/javascript" src="js/ZyqrHjspywStore.js"></script>
    <script type="text/javascript" src="js/ZyqrHjspywGrid.js"></script>
    <script type="text/javascript" src="js/DzyxqrHjspywStore.js"></script>
    <script type="text/javascript" src="js/DzyxqrHjspywGrid.js"></script>
    <script type="text/javascript" src="yw/SelectZjywZqzxxModify.js"></script>
	<script type="text/javascript" src="yw/SelectZjywQyzxxModify.js"></script>
	<script type="text/javascript" src="yw/SelectKjZqzxxModify.js"></script>
    <script type="text/javascript" src="yw/SelectSjZqzxxUpdateModify.js"></script>
    <script type="text/javascript" src="yw/SelectDzyxqrZqzxxAdd.js"></script>
    <script type="text/javascript" src="yw/SelectDzyxqrZqzxxModify.js"></script>
    <script type="text/javascript" src="yw/SelectDzyxqrZqzxxInfo.js"></script>
    <script type="text/javascript" src="yw/yzsydqc.js"></script>
    <object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0></object>
	<div id="div1"></div>
</body>
</html>
