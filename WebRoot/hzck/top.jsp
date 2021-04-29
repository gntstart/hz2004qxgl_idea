<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="./css/Container.css">
<title>户政窗口标题</title>
</head>
<body>
<table width="100%" height="129"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	    <table width="100%" height="99" border="0" cellpadding="0" cellspacing="0" background="./images/banner_bg.gif" class="banner-table">
	      <tr>
	        <td width="39%" valign="top" class="banner-table-jd-left">
		        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="627" height="80">
		          <param name="movie" value="./images/flash/fla.swf">
		          <param name="quality" value="high">
		          <param name="wmode" value="transparent">
		          <embed src="./images/flash/fla.swf" width="627" height="80" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="transparent"></embed>
		        </object>
	        </td>
	        <td width="28%" valign="top" background="./images/banner_bg.gif" class="banner-table-right">
		        <table width="270" height="82" border="0" align="right" cellpadding="0" cellspacing="0">
		        </table>
	        </td>
	      </tr>
	    </table>
    </td>
  </tr>
  <tr>
    <td>
<table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0" class="nav_menu">
  <tr>
	<td width="18%" class="time"> <div id="dateName"></div></td>
    <td width="63%" height="28" align="center" valign="middle" class="nav_menu_td" >
	<div id="tabs4" style="position:absolute;top:72%;left:15%">
   
    </div>
	</td>
    <td width="7%" align="center" valign="middle" ><table width="50"  border="0" align="right" cellpadding="0" cellspacing="0">
      <tr align="center">
        <td width="24"><a href="./zs.jsp" target="mainFrame" ><img src="./images/undo.gif" name="Image6" width="30" height="30" border="0"></a></td>
      </tr>
    </table></td>
  </tr>
</table></td>
</tr>
</table>
</body></div>
<script language="javascript">
    setInterval("dateName.innerHTML=new Date().toLocaleDateString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000)
</script>
</body>
</html>