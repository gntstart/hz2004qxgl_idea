
var SPLID_FLAG="<!---FLAG:NEWLINE--->";
Contain_ItemNum_CONTAIN_YCTZ=parseInt(Frm_Renyuan.yctzCount.value);
Contain_ItemNum_CONTAIN_TBBJ=parseInt(Frm_Renyuan.tbbjCount.value);
Contain_ItemNum_CONTAIN_ZAGJ=parseInt(Frm_Renyuan.zagjCount.value);
Contain_ItemNum_CONTAIN_JDXX=parseInt(Frm_Renyuan.jdxxCount.value);
//private
function setCount(){    
        Frm_Renyuan.tbbjCount.value= Contain_ItemNum_CONTAIN_TBBJ;  
        Frm_Renyuan.zagjCount.value= Contain_ItemNum_CONTAIN_ZAGJ;  
        Frm_Renyuan.jdxxCount.value= Contain_ItemNum_CONTAIN_JDXX;
        Frm_Renyuan.yctzCount.value= Contain_ItemNum_CONTAIN_YCTZ;  
  
}

//在明细栏中增加一栏
function addLine(frm,CTName) {
    //alert(Contain_ItemNum_CONTAIN_TBBJ);
    //检验数据的正确性
    if(!contain_item_validate(frm,CTName)) return;
    
	var container,content;
    var strTmp,j;

	container = findObj(CTName);
	//container.innerHTML='';
	container.isContainer = true;

    var myNum=parseInt(eval("Contain_ItemNum_"+CTName));//已有行数
    
    //alert(myNum);
	content=container.innerHTML;     

	if(""==content){
		content+="<table width=\"100%\" border=\"0\" cellspacing=\"1\" class=\"GNTTD\" style=\"table-layout:fixed;word-break: break-all; word-wrap: break-word;\">";
		strTmp=eval("writeHeadLine_"+CTName+"()");
		//alert("head:"+strTmp);
		content+=strTmp;
	}  
	    strTmp=container.innerHTML;
		strTmp=strTmp.toString();

		//strTmp="asdsd</table>  assdfdf</table>";
		//alert(strTmp.substr(strTmp.length-10,10));
		myre=/(<\/table>\w*)$/i;
		j=strTmp.search(myre);
		//myre.exec(strTmp);
		//if(RegExp.$1) alert("ok");
		//alert(j);
		if(j>0)  content= strTmp.substring(0,j);
		
        myNum++;//增加一行
        //alert(frm);
		strTmp=eval("writeContentTR_"+CTName+"(frm,0,"+myNum+")");
		content+=strTmp;
		
		content+="</table>";
	    container.innerHTML=content;	

        eval("Contain_ItemNum_"+CTName+"=myNum");//栏数目增加   栏编号从1开始
        setCount();
        //alert(Frm_Renyuan.bjllCount.value);
}

function updateLind(frm,CTName){
    Item=parseInt(eval(frm.name+"."+CTName+"_UpdateItemNo.value"));
    //alert(Item);return;
    var myNum=parseInt(eval("Contain_ItemNum_"+CTName));//已有行数
    if(myNum<parseInt(Item)){
        alert("没有找到第"+Item+"项!该项已删除！");   
        return;
    }
 
 	var container,content;
    var strTmp,j;
	container = findObj(CTName);
	container.isContainer = true;
	content="";//container.innerHTML; 
    
    strTmp=container.innerHTML;
	strTmp=strTmp.toString();
	if(""==strTmp) return;
	
    myLine=strTmp.split(SPLID_FLAG);

	for(i=0;i<myLine.length;i++){
	    //alert(myLine[i]);
        if(""==content) {
            content=myLine[i];	            
            continue;
        }
    
        if(i==Item){
            strTmp=eval("writeContentTR_"+CTName+"(frm,"+0+","+i+")");
            content+=strTmp;       
        }else{
            content+=SPLID_FLAG+myLine[i];        
        }
	}
	if(myNum==Item)
	    content+="</table>";
	//alert(content);
    container.innerHTML=content;
    
}

//在明细栏中删除指定的一行
function deleteLine(frm,CTName,Item) {
  
    var myNum=parseInt(eval("Contain_ItemNum_"+CTName));//已有行数
    if(myNum<parseInt(Item)){
        //alert("Cannot find No."+Item);   
        alert("没有找到第"+Item+"项!该项已删除！");   
        return;
    }
 
 	var container,content;
    var strTmp,j;
	container = findObj(CTName);
	container.isContainer = true;
	content="";//container.innerHTML; 
    
    strTmp=container.innerHTML;
	strTmp=strTmp.toString();
	if(""==strTmp) return;
	
    myLine=strTmp.split(SPLID_FLAG);

	for(i=0;i<myLine.length-1;i++){
	    if(i<Item){
	        if(""==content){
                content=myLine[i];	            
	        }else{
	            content+=SPLID_FLAG+myLine[i];
	        }
	    }else{
	         j=i+1;
	         strTmp=eval("writeContentTR_"+CTName+"(frm,"+j+","+i+")");
	         content+=strTmp;
	    }
	}
	content+="</table>";
	//alert(content);
    container.innerHTML=content;		
    
    myNum--;  //item num --
    eval("Contain_ItemNum_"+CTName+"=myNum");
    setCount();   
 
}
//YCTZ
function writeHeadLine_CONTAIN_YCTZ(){
    
    
    strHtml="";   
    strHtml+="<tr > ";
    
    strHtml+="<td  width=\"10%\"  class=\"TD2\"><div align=\"center\">方位</div></td>";
    strHtml+="<td  width=\"10%\" class=\"TD2\"><div align=\"center\">齿位</div></td>";
    strHtml+="<td  width=\"10%\" class=\"TD2\"><div align=\"center\">特征</div></td>";
    strHtml+="<td  width=\"55%\" class=\"TD2\"><div align=\"center\">描述</div></td>";
    strHtml+="<td  width=\"15%\" class=\"TD2\"><div align=\"center\">&nbsp;</div></td>";
    strHtml+="</tr>";  
    return strHtml;      
}
//TBBJ
function writeHeadLine_CONTAIN_TBBJ(){
    
    
    strHtml="";   
    strHtml+="<tr > ";
    strHtml+="<td width=\"10%\"  class=\"TD2\"><div align=\"center\">部位</div></td>";
    strHtml+="<td width=\"5%\"  class=\"TD2\"><div align=\"center\">方位</div></td>";
    strHtml+="<td width=\"10%\"  class=\"TD2\"><div align=\"center\">数量</div></td>";
    strHtml+="<td width=\"10%\"  class=\"TD2\"><div align=\"center\">名称</div></td>";
    strHtml+="<td width=\"55%\"  class=\"TD2\"><div align=\"center\">描述</div></td>";
    strHtml+="<td width=\"10%\"  class=\"TD2\"><div align=\"center\">&nbsp;</div></td>";
    strHtml+="</tr>";  
    return strHtml;      
}
/*
    取WebCode的Text
*/
function getCodeName(str){
    return eval("document.all."+str+"[document.all."+str+".selectedIndex].text");
}

function writeContentTR_CONTAIN_YCTZ(frm,SourceNo,TargetNo){//牙齿特征
        //alert("SourceNo:"+SourceNo+"TargetNo:"+TargetNo); 
        SourceNo=parseInt(SourceNo);       
        TargetNo=parseInt(TargetNo);
        strHtml="";    
        strHtml+="<tr>";
        if(SourceNo==0){
          strHtml+="<td class=\"TD2\">"+TargetNo+"."+document.all.dmycfw_0name.value+"<input name=\"dmycfw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmycfw_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_dmycfw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+document.all.dmycfw_0name.value+"\"></td>";
          strHtml+="<td class=\"TD2\">"+document.all.dmyccw_0name.value+"<input name=\"dmyccw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmyccw_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_dmyccw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+document.all.dmyccw_0name.value+"\"></td>";
        }else{	
          strHtml+="<td class=\"TD2\">"+TargetNo+"."+eval("frm.N_dmycfw_"+SourceNo+".value")+"<input name=\"dmycfw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmycfw_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_dmycfw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_dmycfw_"+SourceNo+".value")+"\"></td>";
          strHtml+="<td class=\"TD2\">"+eval("frm.N_dmyccw_"+SourceNo+".value")+"<input name=\"dmyccw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmyccw_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_dmyccw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_dmyccw_"+SourceNo+".value")+"\"></td>";
        }
        strHtml+="<td  class=\"TD2\">"+eval("frm.nayctz_"+SourceNo+".value")+"<input name=\"dmyctz"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmyctz_"+SourceNo+".value")+"\"></td>";
        strHtml+="<input name=\"nayctz"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.nayctz_"+SourceNo+".value")+"\"></td>";
        strHtml+="<td class=\"TD2\">"+eval("frm.ycms_"+SourceNo+".value")+"<input name=\"ycms"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.ycms_"+SourceNo+".value")+"\"></td>";
        

        strHtml+="<td class=\"TD2\">";
        strHtml+="<input name=\"ycId"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.ycId_"+SourceNo+".value")+"\">";
        strHtml+="<input type=\"button\" class=\"button_light\" name=\"btnDel\" value=\"删除\" onclick=\"deleteLine("+frm.name+",'CONTAIN_YCTZ','"+TargetNo+"');\" >";
         
        strHtml+="</td>";
        strHtml+="</tr>";
        
        //alert(strHtml);          
        return SPLID_FLAG+strHtml;
}



function writeContentTR_CONTAIN_TBBJ(frm,SourceNo,TargetNo){
        //alert("SourceNo:"+SourceNo+"TargetNo:"+TargetNo); 
        SourceNo=parseInt(SourceNo);       
        TargetNo=parseInt(TargetNo);
        strHtml="";    
        strHtml+="<tr>";
        if(SourceNo==0){
          strHtml+="<td class=\"TD2\">"+TargetNo+"."+document.all.dmTbtzbw_0name.value+"<input name=\"dmTbtzbw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmTbtzbw_"+SourceNo+".value")+"\"></td>";
          strHtml+="<input name=\"N_dmTbtzbw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+document.all.dmTbtzbw_0name.value+"\"></td>";
          strHtml+="<td class=\"TD2\">"+document.all.dmTbtzfw_0name.value+"<input name=\"dmTbtzfw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmTbtzfw_"+SourceNo+".value")+"\"></td>";
          strHtml+="<input name=\"N_dmTbtzfw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+document.all.dmTbtzfw_0name.value+"\"></td>";
          strHtml+="<td  class=\"TD2\">"+document.all.tbtzsl_0name.value+"<input name=\"tbtzsl"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.tbtzsl_"+SourceNo+".value")+"\"></td>";
          strHtml+="<input name=\"N_tbtzsl"+"_"+TargetNo+"\" type=\"hidden\" value=\""+document.all.tbtzsl_0name.value+"\"></td>";
          strHtml+="<td class=\"TD2\">"+document.all.dmTbtzmc_0name.value+"<input name=\"dmTbtzmc"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmTbtzmc_"+SourceNo+".value")+"\"></td>";
          strHtml+="<input name=\"N_dmTbtzmc"+"_"+TargetNo+"\" type=\"hidden\" value=\""+document.all.dmTbtzmc_0name.value+"\"></td>";
        }else{
          strHtml+="<td class=\"TD2\">"+TargetNo+"."+eval("frm.N_dmTbtzbw_"+SourceNo+".value")+"<input name=\"dmTbtzbw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmTbtzbw_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_dmTbtzbw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_dmTbtzbw_"+SourceNo+".value")+"\"></td>";
          strHtml+="<td class=\"TD2\">"+eval("frm.N_dmTbtzfw_"+SourceNo+".value")+"<input name=\"dmTbtzfw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmTbtzfw_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_dmTbtzfw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_dmTbtzfw_"+SourceNo+".value")+"\"></td>";
          strHtml+="<td class=\"TD2\">"+eval("frm.N_tbtzsl_"+SourceNo+".value")+"<input name=\"tbtzsl"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.tbtzsl_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_tbtzsl"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_tbtzsl_"+SourceNo+".value")+"\"></td>";
          strHtml+="<td class=\"TD2\">"+eval("frm.N_dmTbtzmc_"+SourceNo+".value")+"<input name=\"dmTbtzmc"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmTbtzmc_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_dmTbtzmc"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_dmTbtzmc_"+SourceNo+".value")+"\"></td>";
        }
        strHtml+="<td class=\"TD2\">"+eval("frm.tbtzms_"+SourceNo+".value")+"<input name=\"tbtzms"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.tbtzms_"+SourceNo+".value")+"\"></td>";
       

        strHtml+="<td class=\"TD2\">";
        strHtml+="<input name=\"tbbjId"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.tbbjId_"+SourceNo+".value")+"\">";
        //strHtml+="<a onclick=\"deleteLine("+frm.name+",'CONTAIN_TBBJ','"+TargetNo+"');\" style=\"cursor:hand\" >删除</a>&nbsp;";
       // strHtml+="<a onclick=\"set_CONTAIN_TBBJ("+frm.name+",'"+TargetNo+"');\">修改</a>";
       strHtml+="<input type=\"button\" class=\"button_light\" name=\"btnDel\" value=\"删除\" onclick=\"deleteLine("+frm.name+",'CONTAIN_TBBJ','"+TargetNo+"');\" >";
         
        strHtml+="</td>";
        strHtml+="</tr>";
        
        //alert(strHtml);          
        return SPLID_FLAG+strHtml;
}

function set_CONTAIN_TBBJ(frm,SourceNo){
       
        frm.tbbjId_0.value=eval("frm.tbbjId_"+SourceNo+".value");
        frm.dmTbtzmc_0.value=eval("frm.dmTbtzmc_"+SourceNo+".value");
        frm.dmTbtzbw_0.value=eval("frm.dmTbtzbw_"+SourceNo+".value");
        frm.dmTbtzfw_0.value=eval("frm.dmTbtzfw_"+SourceNo+".value");
        frm.tbtzsl_0.value=eval("frm.tbtzsl_"+SourceNo+".value");
        frm.tbtzms_0.value=eval("frm.tbtzms_"+SourceNo+".value");

        //frm.tbtzsl_0.focus();
        
       // frm.CONTAIN_TBBJ_UpdateItemNo.value=SourceNo;
       // frm.CONTAIN_TBBJ_BUTTON_UPDATE.value="修改("+SourceNo+")";
       // frm.CONTAIN_TBBJ_BUTTON_UPDATE.disabled=false;
}

function reset_TBBJ(frm){
        
        frm.tbbjId_0.value="";
        frm.dmTbtzmc_0.value="";
        frm.dmTbtzbw_0.value="";
        frm.dmTbtzfw_0.value="";
        frm.tbtzsl_0.value="";
        frm.tbtzms_0.value="";
      
        //frm.tbtzsl_0.focus();

        //frm.CONTAIN_TBBJ_BUTTON_UPDATE.value="修改";
        //frm.CONTAIN_TBBJ_BUTTON_UPDATE.disabled=true;
}


//ZAGJ
function writeHeadLine_CONTAIN_ZAGJ(){    
    strHtml="";   
    strHtml+="<tr > ";
    strHtml+="<td align=\"right\"  class=\"TD2\"><div align=\"center\">工具名称</div></td>";
    strHtml+="<td class=\"TD2\"><div align=\"center\">使用方法</div></td>";
    strHtml+="<td  class=\"TD2\"><div align=\"center\">作用部位</div></td>";
    strHtml+="<td class=\"TD2\"><div align=\"center\">&nbsp;</div></td>";
    strHtml+="</tr>";  
    return strHtml;      
}


function writeContentTR_CONTAIN_ZAGJ(frm,SourceNo,TargetNo){
        //alert("SourceNo:"+SourceNo+"TargetNo:"+TargetNo); 
        SourceNo=parseInt(SourceNo);       
        TargetNo=parseInt(TargetNo);
        strHtml="";    

        strHtml+="<tr>";
       if(SourceNo==0){
        strHtml+="<td  align=\"left\"  class=\"TD2\">"+TargetNo+"."+getCodeName("select_div_dmZagj_0")+"<input name=\"dmZagj"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmZagj_"+SourceNo+".value")+"\"></td>";
        strHtml+="<input name=\"N_dmZagj"+"_"+TargetNo+"\" type=\"hidden\" value=\""+getCodeName("select_div_dmZagj_0")+"\"></td>";
        strHtml+="<td class=\"TD2\">"+getCodeName("select_div_gjsyff_0")+"<input name=\"gjsyff"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.gjsyff_"+SourceNo+".value")+"\"></td>";
        strHtml+="<input name=\"N_gjsyff"+"_"+TargetNo+"\" type=\"hidden\" value=\""+getCodeName("select_div_gjsyff_0")+"\"></td>";
        strHtml+="<td  class=\"TD2\">"+getCodeName("select_div_gjsybw_0")+"<input name=\"gjsybw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.gjsybw_"+SourceNo+".value")+"\"></td>";
        strHtml+="<input name=\"N_gjsybw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+getCodeName("select_div_gjsybw_0")+"\"></td>";
       }else{
          strHtml+="<td class=\"TD2\">"+TargetNo+"."+eval("frm.N_dmZagj_"+SourceNo+".value")+"<input name=\"dmZagj"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmZagj_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_dmZagj"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_dmZagj_"+SourceNo+".value")+"\"></td>";
          strHtml+="<td class=\"TD2\">"+eval("frm.N_gjsyff_"+SourceNo+".value")+"<input name=\"gjsyff"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.gjsyff_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_gjsyff"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_gjsyff_"+SourceNo+".value")+"\"></td>";
          strHtml+="<td class=\"TD2\">"+TargetNo+"."+eval("frm.N_gjsybw_"+SourceNo+".value")+"<input name=\"gjsybw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.gjsybw_"+SourceNo+".value")+"\">";
          strHtml+="<input name=\"N_gjsybw"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.N_gjsybw_"+SourceNo+".value")+"\"></td>";
       } 
        strHtml+="<td class=\"TD2\">";
        strHtml+="<input name=\"zagjId"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.zagjId_"+SourceNo+".value")+"\">";
        //strHtml+="<a onclick=\"deleteLine("+frm.name+",'CONTAIN_ZAGJ','"+TargetNo+"');\" style=\"cursor:hand\" >删除</a>&nbsp;";
        //strHtml+="<a onclick=\"set_CONTAIN_ZAGJ("+frm.name+",'"+TargetNo+"');\">修改</a>";
        strHtml+="<input type=\"button\" class=\"button_light\" name=\"btnDel\" value=\"删除\"  onclick=\"deleteLine("+frm.name+",'CONTAIN_ZAGJ','"+TargetNo+"');\" >";
         
        strHtml+="</td>";
        strHtml+="</tr>";
        
        //alert(strHtml);          
        return SPLID_FLAG+strHtml;
}

function set_CONTAIN_ZAGJ(frm,SourceNo){

        frm.zagjId_0.value=eval("frm.zagjId_"+SourceNo+".value");
        frm.dmZagj_0.value=eval("frm.dmZagj_"+SourceNo+".value");
        frm.gjsyff_0.value=eval("frm.gjsyff_"+SourceNo+".value");
        frm.gjsybw_0.value=eval("frm.gjsybw_"+SourceNo+".value");

        //frm.tbtzsl_0.focus();        
        frm.CONTAIN_ZAGJ_UpdateItemNo.value=SourceNo;
        //frm.CONTAIN_ZAGJ_BUTTON_UPDATE.value="修改("+SourceNo+")";
        //frm.CONTAIN_ZAGJ_BUTTON_UPDATE.disabled=false;
}

function reset_ZAGJ(frm){

        frm.zagjId_0.value="";
        frm.dmZagj_0.value="";
        frm.gjsyff_0.value="";
        frm.gjsybw_0.value="";
      
        //frm.tbtzsl_0.focus();

        //frm.CONTAIN_ZAGJ_BUTTON_UPDATE.value="修改";
        //frm.CONTAIN_ZAGJ_BUTTON_UPDATE.disabled=true;
}


//JDXX
function validate__JDXX(){
    return true;
}
function writeHeadLine_CONTAIN_JDXX(){    
    strHtml="";   
    strHtml+="<tr > ";


    strHtml+="<td align=\"right\"  class=\"TD2\"><div align=\"center\">戒毒类别</div></td>";
    strHtml+="<td class=\"TD2\"><div align=\"center\">解毒机构</div></td>";
    strHtml+="<td  class=\"TD2\"><div align=\"center\">戒毒起时间</div></td>";
    strHtml+="<td  class=\"TD2\"><div align=\"center\">戒毒止时间</div></td>";
    strHtml+="<td  class=\"TD2\"><div align=\"center\">经办人</div></td>";
    strHtml+="<td  class=\"TD2\"><div align=\"center\">经办时间</div></td>";
    strHtml+="<td class=\"TD2\"><div align=\"center\">&nbsp;</div></td>";
    strHtml+="</tr>";  
    return strHtml;      
}


function writeContentTR_CONTAIN_JDXX(frm,SourceNo,TargetNo){
        //alert("SourceNo:"+SourceNo+"TargetNo:"+TargetNo); 
        SourceNo=parseInt(SourceNo);       
        TargetNo=parseInt(TargetNo);
        strHtml="";    

        strHtml+="<tr>";
        strHtml+="<td  align=\"right\"  class=\"TD2\">"+TargetNo+"."+document.all.dmJdls_0name.value+"<input name=\"dmJdls"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.dmJdls_"+SourceNo+".value")+"\"></td>";
        strHtml+="<td class=\"TD2\">"+eval("frm.jdjg_"+SourceNo+".value")+"<input name=\"jdjg"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.jdjg_"+SourceNo+".value")+"\"></td>";
        strHtml+="<td  class=\"TD2\">"+eval("frm.ksrq_"+SourceNo+".value")+"<input name=\"ksrq"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.ksrq_"+SourceNo+".value")+"\"></td>";
        strHtml+="<td     class=\"TD2\">"+eval("frm.jsrq_"+SourceNo+".value")+"<input name=\"jsrq"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.jsrq_"+SourceNo+".value")+"\"></td>";
        strHtml+="<td class=\"TD2\">"+eval("frm.jbr_tempname.value")+"<input name=\"jbr"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.jbr_"+SourceNo+".value")+"\"></td>";
        strHtml+="<td  class=\"TD2\">"+eval("frm.jbsj_"+SourceNo+".value")+"<input name=\"jbsj"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.jbsj_"+SourceNo+".value")+"\"></td>";
        
        strHtml+="<td class=\"TD2\">";
        strHtml+="<input name=\"jdxxId"+"_"+TargetNo+"\" type=\"hidden\" value=\""+eval("frm.jdxxId_"+SourceNo+".value")+"\">";
        //strHtml+="<a onclick=\"deleteLine("+frm.name+",'CONTAIN_JDXX','"+TargetNo+"');\" style=\"cursor:hand\" >删除</a>&nbsp;";
       // strHtml+="<a onclick=\"set_CONTAIN_JDXX("+frm.name+",'"+TargetNo+"');\">修改</a>";
        strHtml+="<input type=\"button\" class=\"button_light\" name=\"btnDel\" value=\"删除\"  onclick=\"deleteLine("+frm.name+",'CONTAIN_JDXX','"+TargetNo+"');\" >";
        
        strHtml+="</td>";
        strHtml+="</tr>";
        
        //alert(strHtml);          
        return SPLID_FLAG+strHtml;
}

function set_CONTAIN_JDXX(frm,SourceNo){

        frm.jdxxId_0.value=eval("frm.jdxxId_"+SourceNo+".value");
        frm.dmJdls_0.value=eval("frm.dmJdls_"+SourceNo+".value");
        frm.jdjg_0.value=eval("frm.jdjg_"+SourceNo+".value");
        frm.ksrq_0.value=eval("frm.ksrq_"+SourceNo+".value");
        
        frm.jsrq_0.value=eval("frm.jsrq_"+SourceNo+".value");
        frm.jbr_0.value=eval("frm.jbr_"+SourceNo+".value");
        frm.jbsj_0.value=eval("frm.jbsj_"+SourceNo+".value");

        //frm.tbtzsl_0.focus();        
        frm.CONTAIN_JDXX_UpdateItemNo.value=SourceNo;
        //frm.CONTAIN_JDXX_BUTTON_UPDATE.value="修改("+SourceNo+")";
        //frm.CONTAIN_JDXX_BUTTON_UPDATE.disabled=false;
}

function reset_JDXX(frm){

        frm.jdxxId_0.value="";
        frm.dmJdls_0.value="";
        frm.jdjg_0.value="";
        frm.ksrq_0.value="";
        
        frm.jsrq_0.value="";
        frm.jbr_0.value="";
        frm.jbsj_0.value="";
        //frm.tbtzsl_0.focus();

        //frm.CONTAIN_JDXX_BUTTON_UPDATE.value="修改";
        //frm.CONTAIN_JDXX_BUTTON_UPDATE.disabled=true;
}


//检验
function contain_item_validate(frm,CTName){
    //alert("ddd"+CTName);
    if(CTName=="CONTAIN_JDXX") 
        return ciValidate_JDXX(frm);
    else
        return true;
}
function ciValidate_JDXX(f){
    // function check_string(fn,fn_cn,len,method,exp,NoFocus)NoFocus:1 no focuse;0 focus()
    if(!check_string(f.dmJdls_0,"戒毒类别",10,1,"",0)) return false;    
    if(!check_string(f.jdjg_0,"戒毒机构",50,0,"",0)) return false;    
    if(!check_string(f.ksrq_0,"戒毒起时间",10,1,"",0)) return false;    
    if(!check_string(f.jbr_0,"经办人",10,1,"",0)) return false;    
    if(!check_string(f.jbsj_0,"经办时间",19,1,"",0)) return false;    
    
    return true;
}
function xdjbr(){
  var jbr =document.all.jbr_temp.value;
  if(jbr!=null&&""!=jbr)
  document.all.jbr_0.value = jbr.split(";")[1];
}