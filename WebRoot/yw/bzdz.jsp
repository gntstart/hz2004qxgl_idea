<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "../config.jsp"%>
<%
String bzdz = com.gnt.qxgl.common.dict.DQDictDataShare.getKzcs("10006").getBz();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
正在打开标准地址：<%=bzdz %>，请稍候...
<form name="form1" method="POST" action="<%=bzdz%>">
<%
for(Object obj:request.getParameterMap().keySet()){
	String value = request.getParameter(obj.toString());
	value = new String(value.getBytes("iso-8859-1"),"UTF-8");
	System.out.println(obj + "=" + value);
	out.println("<input type='hidden' value='" + value + "'/>");
}
%>
</form>
<Script Language="JavaScript">
	document.form1.submit();
</Script>
  </body>
</html>
