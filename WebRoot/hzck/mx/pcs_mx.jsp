<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
body {
	margin-top: 2px;
	margin-left: 2px;
	margin-right: 2px;
	margin-bottom: 2px;
}
.tab_down {
    font-size:12px;
	color:#FFFFFF;
}
.tab_up {
    font-size:12px;
	color:#000000;
}
.style3 {color: #FF6600}
-->
</style>
<title>户政窗口明细</title>
</head>
<body>
<table width="100%" height="27" border="0" align="center" cellpadding="0" cellspacing="0" style="border:solid #CAD9EA 1px;">
<input type=hidden name=weburl id=weburl >
  <tr>
    <td bgcolor="#F7FCFE" style="font-size:12px; padding-left:5px; padding-top:3px;"> <img src="../images/icon1.gif" width="6" height="9"> 明细</td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="../images/tm.gif" width="5" height="5"></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:#AACCEE solid 1px;">
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><img src="../images/tm.gif" width="5" height="5"></td>
  </tr>
  <tr>
    <td><table width="100%"  border="1" align="center" cellpadding="2" cellspacing="0" bordercolor="#CAD9EA" class="form" style="font-size:12px; line-height:150%;" bordercolordark="#ffffff">
      <tr background="../images/lb_bg.gif">
        <td background="../images/lb_bg.gif" width="2%" height="23" align="center" style="text-align:left;"><input type="checkbox" name="checkbox" value="checkbox"></td>
        <td width="12%" height="23" align="center" valign="middle" background="../images/lb_bg.gif">用户名<img src="../images/xb_ima.gif" width="10" height="12" hspace="2" align="absmiddle"></td>
        <td width="9%" align="center" valign="middle" background="../images/lb_bg.gif">所在区县<img src="../images/sb_ima.gif" width="10" height="12" hspace="2" align="absmiddle"></td>
     
        <td background="../images/lb_bg.gif" width="19%" align="left" valign="middle" style="text-align:center;">所在派出所</td>
        <td background="../images/lb_bg.gif" width="19%" align="left" valign="middle" style="text-align:center;">身份证号码</td>
		<td width="11%" align="center" valign="middle" background="../images/lb_bg.gif">登录时间</td>
        <td width="8%" height="23" align="left" valign="middle" background="../images/lb_bg.gif" style="text-align:center;">用户状态</td>
        <td background="../images/lb_bg.gif" width="20%" align="left" valign="middle" style="text-align:center;">登录IP</td>
      </tr>
      <tr>
        <td height="22" align="center" bgcolor="#FFFFFF" style="text-align:left;"><input type="checkbox" name="checkbox2" value="checkbox"></td>
        <td align="center" valign="center" bgcolor="#FFFFFF" style="padding-left:3px;">jj34010020001</td>
        <td align="center" valign="center" bgcolor="#FFFFFF" style="padding-left:3px;">辖瑶海区</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">测试派出所</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">1111111111111111</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">2008-01-25</td>
        <td align="center" valign="center" bgcolor="#FFFFFF" style="padding-left:3px;">在线</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">192.168.0.1</td>
      </tr>
      <tr bgcolor="#F7FCFE">
        <td height="22" align="center" style="text-align:left;"><input type="checkbox" name="checkbox3" value="checkbox"></td>
        <td align="center" valign="center" style="padding-left:3px;">jj3401220002</td>
        <td align="center" valign="center" style="padding-left:3px;">庐阳区</td>
        <td align="center" valign="center">测试派出所</td>
        <td align="center" valign="center">1111111111111111</td>
        <td align="center" valign="center">2008-01-25</td>
        <td align="center" valign="center" style="padding-left:3px;">在线</td>
        <td align="center" valign="center">192.168.0.2</td>
      </tr>
      <tr>
        <td height="22" align="center" bgcolor="#FFFFFF" style="text-align:left;"><input type="checkbox" name="checkbox4" value="checkbox"></td>
        <td align="center" valign="center" bgcolor="#FFFFFF">jj3401000003</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">包河区</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">测试派出所</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">1111111111111111</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">2008-01-25</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">在线</td>
        <td align="center" valign="center" bgcolor="#FFFFFF">192.168.0.5</td>
      </tr>
      <tr bgcolor="#F7FCFE">
        <td height="22" align="center" style="text-align:left;"><input type="checkbox" name="checkbox5" value="checkbox"></td>
        <td align="center" valign="center">jj34010004</td>
        <td align="center" valign="center">长丰县</td>
        <td align="center" valign="center">测试派出所</td>
        <td align="center" valign="center">1111111111111111</td>
        <td align="center" valign="center">2008-01-25</td>
        <td align="center" valign="center">在线</td>
        <td align="center" valign="center">192.168.0.10</td>
      </tr>
      <tr>
        <td height="28" colspan="8" align="center" bgcolor="#FFFFFF" style="text-align:center;">共3条 每页10条 共1页 当前第1页 [ 1 ] 转到
            <input type="text" name="textfield322" style="width:18px; height:15px;">
      <img src="../images/undo.gif" width="16" height="16" hspace="2" align="absmiddle"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>