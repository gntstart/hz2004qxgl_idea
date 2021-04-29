/*
 * 转换包含特殊字符的输入框内容，替换输入控件的value、textarea、option中的内容
 */
function convertInput(s)
{
	if(typeof(s)=="undefined" || s=="")
		return "";
	var sTemp="";
	var sRet="";
	var len = s.length;
	for(var i=0; i<len; i++)
	{
		sTemp=s.substr(i, 1);
		/*
		 * &"'<>
		 * &amp;&quot;&#039;&lt;&gt;
		 */
		if(sTemp=="&")
			sRet+="&amp;";
		else if("\""==sTemp)
			sRet+="&quot;";
		else if("'"==sTemp)
			sRet+="&#039;";
		else if("<"==sTemp)
			sRet+="&lt;";
		else if(">"==sTemp)
			sRet+="&gt;";
		else
			sRet+=sTemp;
	}
	return sRet;
}

/*
 * 转换包含特殊字符成为普通网页文本
 */
function convertHtml(s)
{
	if(typeof(s)=="undefined" || s=="")
		return "";
	var sTemp="";
	var sRet="";
	var len = s.length;
	for(var i=0; i<len; i++)
	{
		sTemp=s.substr(i, 1);
		/*
		 * &"'<>\r\n\t[space]
		 * &amp;&quot;&#039;&lt;&gt;blank<br>space(4)&nbsp;
		 */
		if("&"==sTemp)
			sRet+="&amp;";
		else if("\""==sTemp)
			sRet+="&quot;";
		else if("'"==sTemp)
			sRet+="&#039;";
		else if("<"==sTemp)
			sRet+="&lt;";
		else if(">"==sTemp)
			sRet+="&gt;";
		else if("\r"==sTemp)
			;
		else if("\n"==sTemp)
			sRet+="<br>";
		else if("\t"==sTemp)
			sRet+="&nbsp;&nbsp;&nbsp;&nbsp;";
		else if(" "==sTemp)
			sRet+="&nbsp;";
		else
			sRet+=sTemp;
	}
	return sRet;
}
/*
 * 转换Tab键为4个空格, 防止和打印参数分隔符冲突
 */
function convertTabKey(s)
{
	if(s==null || s=="")
		return "";
	var sRet=s.replace(/\x09/ig, "    ");
	return sRet;
}
