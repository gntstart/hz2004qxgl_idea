function inijccode(mhFn){
	//var mhFn=args[0];////DIV ÔªËØ  
  var _attrib=mhFn.getAttribute("attrib");
  if(_attrib!="jccode" ) return;
  if(mhFn.visiontype  ==undefined) return;
  var _OUTPUT_FIELD=mhFn.output_field;
  var _OUTPUT_CODENAME=mhFn.output_codename;
  var _OUTPUT_PARENTCODENAME=mhFn.output_parentcodename;
  var _OUTPUT_PARENTCODEVALUE=mhFn.output_parentcodevalue;
  var width=145;
  var height=19;
  var rootcode=mhFn.visiontype ;
  var showtype=1;
  var multiselect=0;
  var isinputtext=0;
  var oldshow=0;
  var isshowcodevalue=0;
  var showcaption="´úÂëÑ¡Ôñ";
  var textbackcolor='&HFFFFFF';
  var selbackcolor='&HFF0000';
  var _fontcolor='&H000000';
  var parentgrade="0";
  
  if(mhFn.width!=undefined)width=mhFn.width;
  if(mhFn.height!=undefined)height=mhFn.height;
  if(mhFn.rootcode!=undefined)rootcode=mhFn.rootcode;
  
  if(mhFn.showtype!=undefined)showtype=mhFn.showtype;
  if(mhFn.multiselect!=undefined)multiselect=mhFn.multiselect;
  if(mhFn.isinputtext!=undefined)isinputtext=mhFn.isinputtext;
  if(mhFn.oldshow!=undefined)oldshow=mhFn.oldshow;
  if(mhFn.isshowcodevalue!=undefined)isshowcodevalue=mhFn.isshowcodevalue;
  if(mhFn.showcaption!=undefined)showcaption=mhFn.showcaption;
  if(mhFn.textbackcolor!=undefined)textbackcolor=mhFn.textbackcolor;
  if(mhFn.selbackcolor!=undefined)selbackcolor=mhFn.selbackcolor;
  if(mhFn.fontcolor!=undefined)_fontcolor=mhFn.fontcolor;
  if(mhFn.parentgrade!=undefined)parentgrade=mhFn.parentgrade;
	var str="<OBJECT ID='jccode_"+_OUTPUT_FIELD+"'CLASSID='CLSID:0E30B704-4BC9-4E92-8787-1F0893E5E330' width='"+width+"' height='"+height+"'  >";
	str+="<param name='RootCode' value='"+rootcode+"'>";
	str+="<param name='VisionType' value='"+mhFn.visiontype+"'>";
	str+="<param name='ShowType' value='"+showtype+"'>";
	str+="<param name='MultiSelect' value='"+multiselect+"'>";
	str+="<param name='IsInputText' value='"+isinputtext+"'>";
  if(mhFn.selectedcode!=undefined)
		str+="<param name='SelectedCode' value='"+mhFn.selectedcode+"'>";
	if(mhFn.expandcode!=undefined)
		str+="<param name='ExpandCode' value='"+mhFn.expandcode+"'>";
	if(mhFn.showleafnodeofcode!=undefined)
		str+="<param name='ShowLeafNodeOfCode' value='"+mhFn.showleafnodeofcode+"'>";
	if(mhFn.maxtextlength!=undefined)
		str+="<param name='MaxTextLength' value='"+mhFn.maxtextlength+"'>";
	if(mhFn.notexpandandselectedcode!=undefined)
		str+="<param name='NotExpandAndSelectedCode' value='"+mhFn.notexpandandselectedcode+"'>";
	if(mhFn.notexpandcode!=undefined)
		str+="<param name='NotExpandCode' value='"+mhFn.notexpandcode+"'>";
	if(mhFn.disablecode!=undefined)
		str+="<param name='DisableCode' value='"+mhFn.disablecode+"'>";
	
	str+="<param name='OldShow' value='"+oldshow+"'>";
	str+="<param name='IsShowCodeValue' value='"+isshowcodevalue+"'>";
	str+="<param name='ShowCaption' value='"+showcaption+"'>";
	str+="<param name='TextBackColor' value='"+textbackcolor+"'>";
	str+="<param name='SelBackColor' value='"+selbackcolor+"'>";
	str+="<param name='FontColor' value='"+_fontcolor+"'>";
	str+="<param name='ParentGrade' value='"+parentgrade+"'>";
 
  str+="</OBJECT>";
  str+="<SCRIPT LANGUAGE=javascript FOR='jccode_"+_OUTPUT_FIELD+"' EVENT='CompleteSelect'>";
	str+="_setValue('"+_OUTPUT_FIELD+"','"+_OUTPUT_CODENAME+"','"+_OUTPUT_PARENTCODEVALUE+"','"+_OUTPUT_PARENTCODENAME+"');";  
	str+="</script>";
	mhFn.innerHTML = str;
	if(mhFn.selectedcode!=undefined&&mhFn.selectedcode!='')
		eval("document.all."+_OUTPUT_FIELD+".value='"+mhFn.selectedcode+"'");
	//findObj(_OUTPUT_FIELD).value=mhFn.selectedcode;
	c=findObj('jccode_'+_OUTPUT_FIELD);
	c.onchange=mhFn.onchange;
	c.onchangefun=mhFn.onchangefun;
}

function _setValue(obj,codename,pcode,pname){
	var ctl=findObj("jccode_"+obj);
	var codenameobj = findObj(codename);
	if(codenameobj){
		codenameobj.value=ctl.CodeName;
	}
	var pcodeobj = findObj(pcode);
	if(pcodeobj){
		pcodeobj.value=ctl.ParentCode;
	}
	var pnameobj = findObj(pname);
	if(pnameobj){
		pnameobj.value=ctl.ParentName;
	}
	//if(ctl.IsSelectOK=='1'){
			findObj(obj).value=ctl.CodeValue;
			if(ctl.onchange!=undefined)window[ctl.onchange](ctl);
			if(ctl.onchangefun!=undefined)eval(ctl.onchangefun);
	//}
}
function findObj(theObj)
{
  var p, i, foundObj;
  var theDoc;
  theDoc = document;
 // if(!(foundObj = theDoc[theObj]) && theDoc.all) foundObj = theDoc.all[theObj];
  var _len=theDoc.forms.length;
  for (i=0; !foundObj && i <_len ; i++){
   if(theDoc.forms[i].name=="pageNav")continue; 
  	foundObj = theDoc.forms[i][theObj];
  }
  for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++){ 
    foundObj = findObj(theObj,theDoc.layers[i].document);
    }
  if(!foundObj && document.getElementById) foundObj =document.getElementById(theObj);
  return foundObj;
}