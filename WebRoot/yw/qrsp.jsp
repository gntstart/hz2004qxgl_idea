<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../config.jsp" %>
<%
    BaseUser u = BaseContext.getBaseUser();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
    <base href="<%=basePath%>">
    <title>安徽长三角户口跨省网上迁移情况</title>
    <link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
</head>
<Script Lanaguage="JavaScript">
    var cfWin = null;
    var basePath='<%=basePath%>';
    var sysDate = '<%=sysDate%>';
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
<script type="text/javascript" src="js/pub.js"></script>
<script type="text/javascript" src="js/commFrames.js"></script>
<script type="text/javascript" src="js/SjpzStore.js"></script>
<script type="text/javascript" src="js/SjpzGrid.js"></script>
<script type="text/javascript" src="js/SjpzForm.js"></script>
<script type="text/javascript" src="js/yw/SelectQsryxx.js"></script>
<script type="text/javascript" src="js/yw/SelectRh.js"></script>
<script type="text/javascript" src="js/yw/SelectSprh.js"></script>
<script type="text/javascript" src="js/yw/QrspChDialog.js"></script>
<script type="text/javascript" src="js/yw/SpclDialog.js"></script>
<script type="text/javascript" src="yw/qrsp.js"></script>
</body>
</html>
