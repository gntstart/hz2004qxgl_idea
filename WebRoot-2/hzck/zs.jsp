<%@ page import="com.gnt.qxgl.base.util.SpringContainer" %>
<%@ page import="com.gnt.qxgl.struts.action.HzckAction"%>
<%@ page import="com.gnt.qxgl.hz2004.entity.XtHzck"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript"> 
function myrefresh() 
{ 
window.location.reload(); 
} 
setTimeout('myrefresh()',600000); //指定10分种刷新一次 
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>窗口列表</title>
<style type="text/css">
<!--
.style1 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
<style>
<%
	HzckAction hzckAction = (HzckAction)SpringContainer.getObject("hzckAction");

	List<XtHzck> result = hzckAction.queryHzck();
%>
</style>
<!-- 
<link type="text/css" rel="stylesheet" href="./css/Container.css">
 -->
</head>

<body>
<table width="100%" height="100%"  border="0" >
	<%
		if(result != null && result.size() > 0){
		int i = 1;
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			XtHzck vo = (XtHzck) iterator.next();
			if(i == 1){
	%>
	<tr height="25%" >
	<% 
				}
				
	%>
		<td width="25%" >
			<table width="98%" height="100%"  border="0" cellpadding="0" cellspacing="0" >
				<tr>
					<TD height="32" background="./images/gztx_bg.gif">
						<table width="100%" height="32" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="20%" background="./images/gztx_left.gif" style="font-size:15px; color:#FFFFFF; padding-bottom:6px; padding-left:6px; text-align:left; font-family:'幼圆'; font-weight:bold; background-repeat:no-repeat;">
									<%= vo.getTitle() %>
								</td>
								<td width="5%" align="right">
									<img src="images/gztx_right.gif">
								</td>
							</tr>
	                    </table>
	                </TD>
				</tr>
				<tr>
					<td height="100%" align="center" background="./images/right3.gif" style="background-size:100% 100%;border:#CCCCCC solid 1px; border-top:none;" >
						<table width="95%" height="110" border="0" align="center" cellpadding="0" cellspacing="0" style="font-size:12px; color:#000000;" >
						  <tr>
							<td width="100%" height="24" style="border-bottom:#C0C0C0 solid 1px; border-bottom-style:dashed; font-size:12px;">
								<div align="left">
									<img src="./images/qx.gif" width="15" height="15" align="absmiddle" /> 4区 4县 108窗口 
								</div>
							</td>
						  </tr>
						  <tr>
							<td height="24" style="border-bottom:#C0C0C0 solid 1px; border-bottom-style:dashed; font-size:12px;">
								<div align="left">
									<img src="./images/hzdt.gif" width="15" height="15" align="absmiddle">
										 户办大厅:
										<a href="./mx/hzck_mx.jsp?dsdm=<%= vo.getDqbm() %>&yhlx=2" >
											<%= vo.getHbdt() %>&nbsp;<img src="./images/ren.gif" width="15" height="15" align="absmiddle" border="0" /> 在线
										</a> 
								</div>
							</td>
						  </tr>
						  <tr>
							<td height="24" style="border-bottom:#C0C0C0 solid 1px; border-bottom-style:dashed; font-size:12px;">
								<div align="left">
									<img src="./images/pcs.gif" width="15" height="15" align="absmiddle">
										 派出所:
										<a href="./mx/hzck_mx.jsp?dsdm=<%= vo.getDqbm() %>&yhlx=1" >
											<%= vo.getPcsck() %>&nbsp;<img src="./images/ren.gif" width="15" height="15" align="absmiddle" border="0" /> 在线
										</a> 
								</div>
							</td>
						  </tr>
						  <tr>
							<td height="24"  style="border-bottom:#C0C0C0 solid 1px; border-bottom-style:dashed; font-size:12px;">
								<div align="left"><img src="./images/zxl.gif" width="15" height="15" align="absmiddle">
									 在线率 <%= vo.getZxl() %> 
								</div>
							</td>
						  </tr>
						  <!-- 
						  	2017.04.20
						  	新增	刁杰
						  	需要新增'最新同步时间'行
						   -->
						  <tr>
							<td height="24"  style="border-bottom:#C0C0C0 solid 1px; border-bottom-style:dashed; font-size:12px;">
								<div align="left"><img src="./images/zxl.gif" width="15" height="15" align="absmiddle">
									 最新同步时间  
								</div>
							</td>
						  </tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	<% 
	
				
				
				
				if(i == 4){
	%>
	</tr>
	<% 
					i = 0;
				}
	
				i ++ ;
				
			}
		}
	%>
</table>
</body>
</html>