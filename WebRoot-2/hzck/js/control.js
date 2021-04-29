var _activeElement=null;
var _activeEditor=null;
var _dropdown_window=null;
var _document_loading=false;
var _skip_activeChanged=false;

var constErrType = "错误类型";
var constErrDescription = "错误描述";
var constErrUnknown = "未知错误！";
var constErrDataType = "数据超长或类型不匹配！";

var constErrTypeInt = "您输入的值[%s]不是一个有效的整数！";
var constErrTypeNumber = "您输入的值[%s]不是一个有效的数字！";
var constErrTypeDate = "您输入的值[%s]不是一个有效的日期型值！"; 
var constErrTypeDateTime = "您输入的值[%s]不是一个有效的日期+时间型值！";
var constErrTypeTime = "您输入的值[%s]不是一个有效的时间型值！";
var constErrTypeIDCard = "您输入的值[%s]不是一个有效的公民身份证号码！"
var constErrOutOfDropDownList = "您输入了无效的值！";
var ConstErrNotNull = "项目: [%s] 为必填项，请填写！";
var ConstErrMaxLength = "项目: [%s] ，数据超长，请重新填写！";

var constJanuary = "一月";
var constFebrary = "二月";
var constMarch = "三月";
var constApril = "四月";
var constMay = "五月";
var constJune = "六月";
var constJuly = "七月";
var constAugust = "八月";
var constSeptember = "九月";
var constOctober= "十月";
var constNovember = "十一月";
var constDecember = "十二月";

var constMonday = "一";
var constTuesday = "二";
var constWednesday = "三";
var constThursday = "四";
var constFriday = "五";
var constSaturday = "六";
var constSunday = "日";

var constLastYear = "上一年";
var constNextYear = "下一年";
var constLastMonth = "上个月";
var constNextMonth = "下个月";
var constToday = "今天";

var web_list=new Array(0);
function TimeChange(time){//时间格式转化
  var today = new Date(time);
  var strMonth = today.getMonth()+1;
  var strDate = today.getDate();
  var strDay = today.getYear()+((strMonth < 10) ? "/0" : "/")+strMonth+((strDate < 10) ? "/0" : "/")+strDate;
  var strHour = today.getHours();
  var strMinutes = today.getMinutes()+5;
  var strToday = strDay+" "+((strHour < 10) ? "0" : "")+strHour+((strMinutes < 10) ? ":0" : ":")+strMinutes;
 // alert(new Date());
  return  strToday;
}
function findMaxTime(time1,time2){//比较时间
   if(time1 != "" && time1 != ""){
   	var t1=TimeChange(time1);
   	var t2=TimeChange(time2);
	   if( t1> t2){
	   	//alert('');	  
		return true;
	  }
  }
  return false;
}
function getIEVersion(){
	var index=window.clientInformation.userAgent.indexOf("MSIE");
	if (index<0){
		return "";
	}
	else{
		return window.clientInformation.userAgent.substring(index+5, index+8);
	}
}

/*
 * @return true -- all the editors are legal; false -- one of the editors is illegal.
 */
function validateDocument(){
	return validateElements(document.body);
}
function validateElements(element){
	var rt = true;
	if (!validateElement(element)) {
		rt = false;
	}

	for (var i=0; i<element.children.length; i++){
		if (!validateElements(element.children[i])) {
		    rt = false;
		    break;
		}
	}
	return rt;
}

function validateElement(element){
   
	var validateChildren=true;
	var label = "";
	var _attrib=element.getAttribute("attrib");
	if (_attrib){
		switch (_attrib){
		   case "editor":{
	                if (element.notnull == "true")
	                {						
	                    if ((element.value == null) || (trimStr(element.value) == "")) {

							if (element.label != null){
								label = element.label;
							} else if(element.id != null){
	                            label = element.id;
	                        } else {
	                            label = element.name;
	                        }	
	                        
							//马骥修改，增加文本输入框的warning_head属性
							if(element.warning_head)
								alert(element.warning_head + " " + ConstErrNotNull.replace("%s", label));
							else
								alert(ConstErrNotNull.replace("%s", label));
							//alert(ConstErrNotNull.replace("%s", label));
							validateChildren = false;   
	                    }
	                }
					
	                 //alert(element.name);
	                // alert(element.name+" value.length="+element.value.length+" maxlength="+element.maxlength+" value="+element.value);
	                // alert(element.name+" max len"+element.len);
	                if ((element.maxlength != null) && (trimStr(element.maxlength) != "")) {                    
	                    if(strlen(element.value)>element.maxlength){
	                       // alert(element.maxlength);
	                        if (element.label != null) {
	                            label = element.label;
	                        } else if(element.id != null){
	                            label = element.id;
	                        } else {
	                            label = element.name;
	                        }	
							//马骥修改，增加文本输入框的warning_head属性  
							if(element.warning_head)
								alert(element.warning_head + " " + ConstErrMaxLength.replace("%s", label));
							else
								alert(ConstErrMaxLength.replace("%s", label));                      
	                        //alert(ConstErrMaxLength.replace("%s", label));
	                        validateChildren = false;   	                        
	                    }
	                }
	                 var max_length=element.getAttribute("max_length");
	                if ((max_length != null) && (trimStr(max_length) != "")) {
	                	//alert(max_length+":"+element.label+":"+strlen(element.value));                    
	                    if(strlen(element.value)>max_length){
	                        if (element.label != null) {
	                            label = element.label;
	                        } else if(element.id != null){
	                            label = element.id;
	                        } else {
	                            label = element.name;
	                        }		                        
	                        alert(ConstErrMaxLength.replace("%s", label)+"允许长度：字符"+max_length+"个，一个汉字为2个字符。");
	                        validateChildren = false;   	                        
	                    }
	                }
                	break;
		   }	
		   default:{
		   	break;
		   }
		}
	}
	return validateChildren;
}


//转换提示消息(马骥)
//obj - 一个人员对应的业务表单所在的表格(必填)
//xm - 要追加的人员姓名(必填)
//type - 嫌疑人 或 涉案人 
function convertWarning(obj,xm,type)
{
    //替换input的提示消息
	var objs = obj.getElementsByTagName("input");
	for(var i = 0;i < objs.length;i ++)
	{
	     if(objs[i].attrib == "editor" && objs[i].label != null && objs[i].warning == null)
	     {	     	  
	          objs[i].warning_head = xm;
	          if(type)
	          	objs[i].warning_head = type + " " + objs[i].warning_head;
	          //移除label属性        
	          //objs[i].removeAttribute("label");
	     }
	}
	
    //替换textarea的提示消息
	objs = obj.getElementsByTagName("textarea");
	for(var i = 0;i < objs.length;i ++)
	{
	     if(objs[i].attrib=="editor" && objs[i].label != null && objs[i].warning == null)
	     {
	          objs[i].warning_head = xm;
	          if(type)
	          	objs[i].warning_head = type + " " + objs[i].warning_head;    
	          //移除label属性             
	          //objs[i].removeAttribute("label");
	     }
	}
}


/**
 *判断中文字是2位
 */
function strlen(str)
{
var len;
var i;
len = 0;
for (i=0;i<str.length;i++)
{
if (str.charCodeAt(i)>255) len+=2; else len++;
}
return len;
}
function _initElements(element){
	_document_loading=true;
	try{
		initElements(element);
	} finally{
		_document_loading=false;
	}
}
function initDocument(){
	_document_loading=true;
	try{
		initElements(document.body);

		document.language="javascript";
		document.onpropertychange=_document_onpropertychange;		
	} finally{
		_document_loading=false;
	}
}
function initElements(element){
	if (!initElement(element)) {
		return;
	}

	for (var i=0; i<element.children.length; i++){
		initElements(element.children[i]);
	}
}

function initElement(element){
	var initChildren=true;
	var _attrib=element.getAttribute("attrib");
	if (_attrib){
		switch (_attrib){
			case "menubar":{
				if (!element.className) {
					element.className=_attrib;
				}
				if ((element.id!="undefined")&& (element.id!="")) {
					var menuModel = new MenuBarModel(element.id, element);
					menuModel.init();
				}
				break;				
			}
			case "dockmenu":{
				if (!element.className) {
					element.className=_attrib;
				}
				if ((element.id!="undefined")&& (element.id!="")) {
					var menuModel = new DockMenuModel(element.id, element);
					menuModel.init();
				}
				break;				
			}
			case "editor":{
				if (!element.className) {
					element.className=_attrib;
				}

				with (element){
					language="javascript";
					onkeypress=_editor_onkeypress;
				}
				break;
			}	
			case "button":{
				if (!element.className) {
					element.className=_attrib;
				}

				element.hideFocus=true;
				setButtonDown(element, element.getAttribute("down"))
				element.onmouseover=_button_onmouseover;
				element.onmouseout=_button_onmouseout;
				break;
			}	
        	case "webcode":{ //    add by Jing Wu  for webcode    
				if (!element.className) {
					element.className=_attrib;
				} 
				web_list[element.name]=element;   				
				_wc_initList(element);
				break;
        	}	
	        case "jccode":{//zlong 06/11/08
	        	if (!element.className) {
			   element.className=_attrib;
						} 
	        		inijccode(element);
	        		break;
	        }										
			default:{
				if (element.className &&_attrib) {
					element.className=_attrib;
				}				
				break;
			}
		}

		element.window=window;
	}
	return initChildren;
}

function _document_onpropertychange() {
	if (event.propertyName=="activeElement") {
		processActiveElementChanged(document.activeElement);
	}
}


function processActiveElementChanged(activeElement) {

	function set_activeEditor(editor){
		if (_activeEditor!=editor){
			if (_activeEditor){
				if (needUpdateEditor){
					if (_activeEditor.window==window) {
						updateEditorInput(_activeEditor);
					} else {
						_activeEditor.window.updateEditorInput(_activeEditor);
					}
				}
				if (typeof(hideDropDownBtn)!="undefined") {
					hideDropDownBtn();
				}
				
				switch (_activeEditor.getAttribute("attrib")){
					case "editor":{
						//_activeEditor.className="editor"; //Canceled by Albert on 2007-03-13
						//Added by Albert on 2007-03-13
						if(_activeEditor.className != "fullTextarea"){
							_activeEditor.className="editor";
						}
						//End of addition
						break;
					}
			    }
				refreshElementValue(_activeEditor);
			}

			if (editor && !editor.readOnly){

				if (editor.getAttribute("attrib")=="editor"){
					//editor.className="active_editor"; //Canceled by Albert on 2007-03-13
					//Added by Albert on 2007-03-13
					if(editor.className != "fullTextarea"){
						editor.className="active_editor";
					}
					//End of addition
				}

				if (editor.getAttribute("dataType")=="date" || editor.getAttribute("dataType")=="datetime") {
					editor.dropDown_mode="date";
				}

				editor.contentEditable=(!isTrue(editor.getAttribute("dropDown_fixed")));

				editor.use_keyField=true;
				refreshElementValue(editor);

				if (!isTrue(editor.getAttribute("dropDown_fixed")) && !compareText(editor.type, "checkbox")) {
					editor.select();
				}
				if (typeof(showDropDownBtn)!="undefined"){
					if (editor.getAttribute("dataType")=="date" || editor.getAttribute("dataType")=="datetime") {
						showDropDownBtn(editor);
					}
					if (isTrue(editor.getAttribute("autoDropDown"))){
						showDropDownBox(editor);
					}
				}
			}

			_activeEditor=editor;
		}
	}

	function processElementBlur(){
		var doblur=(activeElement!=_activeEditor);
			
		if (_activeElement){
			if (typeof(_dropdown_btn)!="undefined" && _dropdown_btn){
				doblur=doblur && (_activeElement!=_dropdown_btn) &&
					(activeElement!=_dropdown_btn);
			}

			if (typeof(_dropdown_box)!="undefined" && _dropdown_box){
				var editor=_dropdown_box.editor;
				doblur=doblur && (activeElement!=editor) &&
					(!isChild(activeElement, _dropdown_box));
			}

			if (doblur){
				if (_activeEditor && _activeEditor.dropDown_visible){
					if (typeof(hideDropDownBox)!="undefined") {
						hideDropDownBox();
					}
				}		
				set_activeEditor(null);
			}			
		}
		else{
			doblur=false;
		}

		if (activeElement==document.body && _skip_activeChanged){
			_skip_activeChanged=false;
			return;
		}
	}

    try{
		if (window.closed) {
			return;
		}
		if (activeElement != null) {
    		if ((getReal(activeElement, "attrib", "menu").getAttribute("attrib") != "menu") && 
    			(getReal(activeElement, "attrib", "dockmenu").getAttribute("attrib") != "dockmenu")) {
    			hideMenus();			
    		}
        }		
		if (activeElement==_activeElement) {
			// return;
		}

		if (activeElement){
			processElementBlur();

			switch (activeElement.getAttribute("attrib")){
			case "editor":{
					set_activeEditor(activeElement);
					break;
				}
			}
		}
		_activeElement=activeElement;
	} catch(e){
		processException(e);
	}
}

function refreshElementValue(element){
		element.old_value=getElementValue(element);
		element.modified=false;
}

function getElementValue(element){

	switch (element.getAttribute("attrib")){
		case "editor":{
            return element.value;
			break;
		}
		default:{
			return element.value;
			break;
		}
	}
}

function setElementValue(element, value){

	function getEditorValue(element, value){
		return getValidStr(value);
	}

	switch (element.getAttribute("attrib")){
		case "editor":{
			switch (element.type.toLowerCase()){
				case "checkbox":{
					element.checked=isTrue(value);
					break;
				}
				default:{
					element.value=getEditorValue(element, value);
					break;
				}
			}
			break;
		}
		default:{
			element.value=value;
		}
	}
}

function isDropdownBoxVisible(){
	if (typeof(_dropdown_box)!="undefined" && _dropdown_box) {
		return (_dropdown_box.style.visibility=="visible")
	} else {
		return false;
	}
}

function getAbsPosition(obj, offsetObj){
	var _offsetObj=(offsetObj)?offsetObj:document.body;
	var x=obj.offsetLeft;
	var y=obj.offsetTop;
	var tmpObj=obj.offsetParent;

	while ((tmpObj!=_offsetObj) && tmpObj){
		x+=tmpObj.offsetLeft+tmpObj.clientLeft-tmpObj.scrollLeft;
		y+=tmpObj.offsetTop+tmpObj.clientTop-tmpObj.scrollTop;
		tmpObj=tmpObj.offsetParent;
	}
	return ([x, y]);
}

function isChild(obj, parentObj) {
	var tmpObj=obj;
	var result=false;
	if (parentObj) {
		while (tmpObj) {
			if (tmpObj==parentObj){
				result=true;
				break;
			}
			tmpObj=tmpObj.parentElement;
		}
	}
	return result;
}
function refreshButtonColor(button){
	if (isTrue(button.getAttribute("down"))){
		button.className="button_down";
		button.style.backgroundColor="#f7f7f7";
		button.style.borderTop="#636563 1px ";
		button.style.borderLeft="#636563 1px ";
		button.style.borderBottom="#636563 1px ";
		button.style.borderRight="#636563 1px ";
	}
	else{
		button.className="button";
		button.style.backgroundColor="#d4d0c8";
		button.style.borderTop="darkgray 1px solid";
		button.style.borderLeft="darkgray 1px solid";
		button.style.borderBottom="darkgray 1px solid";
		button.style.borderRight="darkgray 1px solid";
	}
}

function setButtonDown(button, down){
	button.down=isTrue(down);
	refreshButtonColor(button);
}

function _button_onmouseover(){
	try{
		var button=event.srcElement;
		if (button.disabled) {
			return;
		}
	
		button.style.backgroundColor="#ADAED6";
		button.style.borderTop="#636563 1px solid";
		button.style.borderLeft="#636563 1px solid";
		button.style.borderBottom="#636563 1px solid";
		button.style.borderRight="#636563 1px solid";
	}
	catch(e){
		//do nothing
	}
}

function _button_onmouseout(){
	try{
		var button=event.srcElement;
		if (button.disabled) {
			return;
		}
		refreshButtonColor(button);
	}
	catch(e){
		//do nothing
	}
}

function isFunctionDefined(function_name){
	if (function_name=="") {
		return false;
	}
	var result;
	eval("result=(typeof("+function_name+")!=\"undefined\");");
	return result;
} 

function textCounter(txt, maxlength) {
if(txt.value.length > maxlength){
	txt.value = txt.value.substring(0, maxlength);
	alert("允许最大长度为"+maxlength);
}
}
//实现报告正文OnClick放大且定位效果
function bgzwOnClick(obj){
	obj.style.width="100%";
	obj.style.height="500px";
	window.location = "#"+obj.name;
}
//实现报告正文OnBlur复原效果
function bgzwOnBlur(obj){
	obj.style.width=null;
	obj.style.height=null;
}
//自动调节iframe高度
/*
conobj    包含iframe对象的对象ID
iframeobj  iframe对象ID
*/
function autoFrameHeight(conobj,iframeobj){
	conobj.height=iframeobj.document.body.scrollHeight+3;
}
/*
隐藏显示对象,带有隐藏显示图片的地方用
oimg:图片对象
otemp:要隐藏的对象
path:相对路径
*/
function hidden_changeimg(oimg,otemp,path){
   //var otemp=document.getElementById(b);
   //var oimg=document.getElementById(a);
   if(otemp.style.display==''){
      otemp.style.display = "none";
      oimg.src=path+"image/hide1.gif";
      oimg.title="显示";
   }else{
      otemp.style.display = "";
      oimg.src=path+"image/unwrap1.gif";
      oimg.title="隐藏";
   } 
}
//保存时显示DIV
function setDialogShow()
{
 var pWin = window;
 while(pWin)
 {  
  if(pWin.document.body.scrollTop > 0)
  	pWin.scrollTo(0,0); 
  if(pWin == pWin.parent)
  	break;
  else
  	pWin = pWin.parent;  
 } 
  
 if(!window.dialogDiv)
 {
  if(document.dialogFrame)
  {
   alert("页面中不允许有dialogFrame对象.");
   return false;
  }
  
  var _div = document.createElement("<div id=\"dialogDiv\"></div>");
  document.body.appendChild(_div);
  //_div.style.height = window.screen.height;
  _div.style.height = document.body.scrollHeight;
  _div.style.width = document.body.scrollWidth;  
  var _html = "";  
  _html += "<table width=\"100%\" height=\"100%\" border=\"0\"><tr><td align=\"center\" valign=\"top\" style=\"padding-top:100px\">";
  _html += "<iframe name=\"dialogFrame\" width=\"400\" height=\"150\" frameborder=\"0\"></iframe>";
  _html += "</td></tr></table>";  
  _div.innerHTML = _html; 
  
  _html = "";
  var _links = document.getElementsByTagName("link");
  for(var i = 0;_links != null && i < _links.length;i ++)
  { 
   _html += document.getElementsByTagName("link")[i].outerHTML;
  }  
  _html += "<body style=\"overflow:hidden;margin:0px;\"><table id=\"dialogTable\">";
  _html += "<thead><tr><td>[系统提示]</td></tr></thead>";
  _html += "<tbody><tr><td id=\"dialogTd\">数据保存中.</td></tr></tbody>";
  _html += "<tfoot><tr><td>上海金铖科技公司</td></tr></tfoot>";
  _html += "</table></body>";
  _html = _html.replace(/\"/gi,"");
  document.frames['dialogFrame'].document.write(_html);
 }
} 
//创建关闭父窗口的数据保存对话框
function setDialogClose()
{
	if(document.all.dialogDiv)
	{
		document.body.removeChild(document.all.dialogDiv);
		document.onmousewheel = null;
		document.onselect = null; 
		document.onmouseup = null; 
		document.body.style.overflow = "auto";
		document.body.style.cursor = "normal";
	}
}
//操作成功提示信息
function setDialogSuccess(msg)
{
	if(!msg)
		msg = "保存成功.";
	if(document.frames['dialogFrame'] && document.frames['dialogFrame'].document.all.dialogTd)
	{
		document.frames['dialogFrame'].document.all.dialogTd.innerHTML = ("<p>"+msg+"</p>");
	 	document.body.style.cursor = "normal";
	}
}
//操作失败提示信息
function setDialogMessage(msg)
{
	if(!msg)
		msg = "操作错误.";
	if(document.frames['dialogFrame'] && document.frames['dialogFrame'].document.all.dialogTd)
	{
		document.frames['dialogFrame'].document.all.dialogTd.innerHTML = "<p>"+msg+"</p><input type='button' value='确 定' onClick='window.parent.setDialogClose()' class='button_light' />";
		document.body.style.cursor = "normal";
	}
}
//没有权限时调用此方法
function returnRoleDialogMessagte(msg){
	var pWin = window;
	var flag = false;
	while(pWin){  
	  if(pWin == pWin.parent)
	  	break;
	  else
	  	if(pWin.dialogDiv){
			setDialogMessage(msg);
			flag = true;
			break;
		}
		pWin = pWin.parent;    
	}
	if(!flag){
		alert(msg);	
		//pWin.history.back();
	}
	
}

/*
时间运算
sj: 要运算的时间 格式 :yyyy/mm/dd hh:mm:ss
addvalue: 要相加的值
lx: year年份相加;month:月份相加;day:天数相加;hour:小时相加
return 运算后的时间字符串 
*/
function addDatefuntion(sj,addvalue,lx){
	if(sj==""||addvalue==""||lx=="")return "";
	var year = sj.substring(0,4);
	var month = sj.substring(5,7);
	var day = sj.substring(8,10);
	var hour = sj.substring(11,13);
	var other = sj.substring(13,sj.lenght);
	var jsday=new Date(year,month-1,day);
	var jshour =hour;
	if("hour"==lx){
		jsday.setHours(parseInt(hour)+parseInt(addvalue));
		jshour =(jsday.getHours())+"";
		if(jshour.length<2)jshour ="0"+jshour;
	}
	if("day"==lx){
		jsday.setDate(jsday.getDate()+parseInt(addvalue));
	}
	var jsdate =(jsday.getDate())+"";
	if(jsdate.length<2)jsdate ="0"+jsdate;
	if("month"==lx){
		jsday.setMonth(jsday.getMonth()+parseInt(addvalue));
	}
	var jsmonth =(jsday.getMonth()+1)+"";
	if(jsmonth.length<2)jsmonth ="0"+jsmonth;
	if("year"==lx){
		jsday.setYear(jsday.getYear()+parseInt(addvalue));
	}
	var jsyear =(jsday.getYear())+"";
	var jssj = jsyear+"/"+jsmonth+"/"+jsdate+" "+jshour+other;
  	return jssj;
}

//打开帮助系统
function openHelpWindow(key)
{
	var imageHelp = document.getElementById("imgHelp");
	if(!imageHelp)
	{
		alert("错误,无法找到ID为imgHelp的帮助图标!");
		return;
	}
	else
	{
		var src = imageHelp.src;
		var url = src.replace("image/help.gif","help/index.jsp?code="+key);
		window.open(url,"帮助系统");
	}
}