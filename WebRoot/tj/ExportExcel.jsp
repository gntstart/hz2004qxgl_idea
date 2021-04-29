<%@ page language="java" pageEncoding="UTF-8"%>   
<%
	//request.setCharacterEncoding("GBK");   
	String workbook = request.getParameter("exportWorkbook");
	String worksheet = request.getParameter("exportWorksheet");
	String fileName = request.getParameter("filename");
	workbook = new String(workbook.getBytes("iso8859_1"), "utf-8");
	worksheet = new String(worksheet.getBytes("iso8859_1"), "utf-8");
	//fileName = new String(fileName.getBytes("iso8859_1"), "utf-8");
	//String os = System.getProperty("os.name");   
	//content = new String(content.getBytes("ISO8859_1"));//WINDOWS 下需要进行转码，AIX下不需要转码  
	response.setCharacterEncoding("UTF-8");
	response.setHeader("Content-Type", "application/force-download");
	response.setHeader("Content-Type", "application/vnd.ms-excel");
	//System.out.println(fileName);
	response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
	out.print(workbook + worksheet);
	
	//System.out.println("*****************" + workbook + worksheet);
	
%> 