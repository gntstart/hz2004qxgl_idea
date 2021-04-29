<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>出现错误</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	-->
	</style>
	</head>
	<body>
		<table width="100%" border="0" align="right" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" bgcolor="#ffffff"
					style="border-bottom: #E6E6E6 solid 1px; border-left: #E6E6E6 solid 1px; border-right: #E6E6E6 solid 1px; padding: 0px;">
					<table width="98%" border="0" align="center" cellpadding="2"
						cellspacing="0" bordercolor="#DBDBDB" style="font-size: 2px;"
						bordercolordark="#ffffff">
						<tr>
							<th width="100%" height="96" align="center"
								style="text-align: center;">
								&nbsp;
							</th>
						</tr>
					</table>
					<table width="80%" border="0" align="center"
						style="font-size: 12px; line-height: 150%;border: #C6DCE7 solid 1px; border-left-style: dashed; border-right-style: dashed; border-top-style: dashed; border-bottom-style: dashed; background-color: #F1F7FA; padding-top: 50px; padding-bottom: 20px;">
						<tr>
							<td width="73%" height="73" align="center">
								<span class="title">服务器出现错误，请重试！</span>
								<br/>错误信息如下：<br>
								<%@ include file="/common/viewMsg.jsp"%>
							</td>
							<td width="27%" rowspan="2"
								style="padding-top: 10px; padding-bottom: 10px; padding-right: 20px;">
								
							</td>
						</tr>
						<tr>
							<td align="center"></td>
						</tr>
					</table>
					<table width="98%" border="0" align="center" cellpadding="2"
						cellspacing="0" bordercolor="#DBDBDB" style="font-size: 2px;"
						bordercolordark="#ffffff">
						<tr>
							<th width="100%" height="96" align="center"
								style="text-align: center;">
								&nbsp;
							</th>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
