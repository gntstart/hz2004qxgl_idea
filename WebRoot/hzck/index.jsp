<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>监督窗口</title>
</head>
	<!-- frame页面是不需要body体的 -->
	<frameset rows="140,570,50" cols="*" framespacing="0" frameborder="no" border="0" name="allframe" >
	    <frame src="./top.jsp" name="topFrame" scrolling="NO" noresize>
	  	
	    <frameset cols="415,*" frameborder="NO" border="0" framespacing="0" name="allmainframe" >
			<frame src="./map.jsp" name="leftmenu" scrolling="no" id="leftmenu">
			<frame src="./zs.jsp" name="mainFrame" id="mainFrame">
		</frameset>
		
		<frame src="./bottom.jsp" name="topFrame" scrolling="NO" >
	</frameset>
</html>