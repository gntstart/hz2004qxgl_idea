<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file = "config.jsp"%>
<%
String gotourl = request.getParameter("gotourl");
if(gotourl==null)
	gotourl = "";

String op = request.getParameter("op");
if(op!=null && op.equals("logout")){
	request.getSession().invalidate();
}

//支持第三方自动登录
String uid = request.getParameter("uid");
String pwd = request.getParameter("pwd");
String error = null;
if(CommonUtil.isNotEmpty(uid) && CommonUtil.isNotEmpty(pwd)){
	//第三方
	LoginService loginService = (LoginService)SpringContainer.getObject("loginService");
	try{
		loginService.login(uid,pwd);
		
		//登录成功，如果证件号码不为空，哪么需要隐藏菜单栏
		if(gotourl==""){
			gotourl = "index.jsp";
		}

		response.sendRedirect(gotourl);
		return;
	}catch(Exception e){
		error = CommonUtil.getExceptionMesssage(e);
	}
}
%>
<html>
	<head>
		<title>常住人口统一用户管理系统</title>
		<link rel="stylesheet" type="text/css" href="css/report_style.css">
    	<link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
    	<link rel="stylesheet" type="text/css" href="<%=SystemConfig.getSystemConfig("default_css")%>">
    	<Script Language="JavaScript">
    		var gotourl = "<%=gotourl%>";
    		var error = "<%=(error==null?"":error)%>";
    	</Script>
	</head>
	<body >	
		<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		  <tr>
		    <td height="28" align="center" background="images/bg.jpg">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="399" align="center" background="images/bg.jpg"><table width="882" height="399" border="0" cellpadding="0" cellspacing="0">
		      <tr>
		        <td width="910" valign="top" background="images/login_ima.jpg"><table width="881" border="0" cellpadding="0" cellspacing="0">
		          <tr>
		            <td height="186">&nbsp;</td>
		            <td width="416">&nbsp;</td>
		            <td width="247">&nbsp;</td>
		          </tr>
		          <tr>
		            <td width="247" height="169">&nbsp;</td>
		            <td width="416" align="center" valign="middle"><div id="gui" align="center"> </div></td>
		            <td width="247">&nbsp;</td>
		          </tr>
		          <tr>
		            <td height="76">&nbsp;</td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
		          </tr>
		        </table></td>
		      </tr>
		    </table></td>
		  </tr>
		  <tr>
		    <td height="30" align="center" class="login-line"></td>
		  </tr>
		  <tr>
		    <td><table width="500" border="0" align="center">
		      <tr align="center">
		        <td valign="bottom" class="nav">说明：地市管理员用户HZADMIN+前4位区号，如合肥用HZADMIN3401 <br>
		        </td>
		      </tr>
		    </table></td>
		  </tr>
		</table>
		<div id="gui" align="center"> </div>
	</body>
	
   <!-- Include Ext and app-specific scripts: -->
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="login.js"></script>	
</html>