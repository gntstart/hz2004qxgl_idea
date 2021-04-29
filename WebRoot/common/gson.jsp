<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" language="java" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@page import="java.util.Enumeration"%>
<%@page import="com.gnt.qxgl.common.struts.form.*"%>
<%@page import="com.gnt.qxgl.common.struts.action.*"%>
<%@page import="com.gnt.qxgl.common.util.*"%>
<%@page import="com.gnt.qxgl.bean.SimpleJson"%>
<%
	Object sampleJson = request.getAttribute(ExtCommonAction.JSON);
	if(sampleJson!=null){
		if(sampleJson instanceof SimpleJson){
			out.println(ExtUtils.getJsonData(sampleJson));
		}else{
			String str = sampleJson.toString();
			if(CommonUtil.isNotEmpty(str)){
				out.print(str);
			}
		}

		return;
	}
	
	for(Enumeration e=request.getAttributeNames();e.hasMoreElements();){
		Object obj = request.getAttribute((String)e.nextElement());
		
		if(obj instanceof ExtCommonForm){
			ExtCommonForm form = (ExtCommonForm)obj;
			String jsonstr = form.getJson(); 
			out.println(jsonstr);
			return;
		}
	}
%>
