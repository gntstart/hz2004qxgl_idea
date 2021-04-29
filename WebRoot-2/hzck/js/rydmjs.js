////////////////////////////////////////////人员代码树选择
function SelCode(a,b){	
var codetype = dmcodetype;
var targetcode;
var targetname;
if("TSTZ" ==codetype ){
   targetcode = document.all.tmtz;
   targetname = document.all.tmtzname;
}else
if("ZASD" ==codetype ){
   targetcode = document.all.zasd;
   targetname = document.all.zasdname;
}else
if("AJLX" ==codetype ){
   targetcode = document.all.ajlx;
   targetname = document.all.ajlxname;
}else
if("TMTZJTYC" ==codetype ){
   targetcode = document.all.dmyctz_0;
   targetname = document.all.nayctz_0;
}else
if("ZYTC" ==codetype ){
   targetcode = document.all.zytc;
   targetname = document.all.zytcname;
}else
if("ZZJG" ==codetype || "ZZJY" ==codetype){
   targetcode = document.getElementById(zdm);
   targetname = document.getElementById(zdm+"name");
}else{
   targetcode = document.getElementById(zdm);
   targetname = document.getElementById(zdm+"name");
}
     targetcode.value=a;
     targetname.value=b;
 if("ZZJG" ==codetype || "ZZJY" ==codetype ||"ZY"==codetype ||"WHCD"==codetype||"MZ"==codetype||"GJ"==codetype||"SAZM"==codetype){
 	 //targetname.value=b.replace(/,,,/g,";");
 	 return;
 }
 if("ZAGTRS" ==codetype || "ZAXZSJ" ==codetype|| "ZAXZDX" ==codetype|| "ZAXZCS" ==codetype
 		|| "SAWPGJ" ==codetype|| "ZAJK" ==codetype|| "ZACK" ==codetype|| "ZAYYDJ" ==codetype
 		|| "ZAYYYS" ==codetype|| "ZATD" ==codetype|| "SAWP" ==codetype|| "KYYJ" ==codetype){
 	 targetname.value=b.replace(/,,,/g,";");
 	 return;
 }
     var temp = new Array();
     dmarr = temp;
     index = 0;
     var a1 =a.split(",,,");
     var b1 =b.split(",,,");
     for(i=0;i<a1.length;i++){
        var a11=a1[i].split(";");
        buildmar(a11[0],"",b1[i],codetype);
     }
     writedmtmtz(codetype);
     
 }
function writeHtmlDmTree(obj){
	var codetype=obj.VisionType;
	var code=obj.ParentCode;
	var codename=obj.CodeName;
	var temp = new Array();
     	dmarr = temp;
     	index = 0;
	writHtmlDm(codetype,code,codename);
}
function writHtmlDm(codetype,code,codename){
	if(code==null||""==code){
		code="";
	};
	var a1 =code.split(",");
     	var b1 =codename.split(",");
     	for(i=0;i<a1.length;i++){
     		if(code=='')continue;
        	buildmar(a1[i],"",b1[i],codetype);
     	}
     	writedmtmtz(codetype);
}
 function optree(codetype,selcode,fieldname,singleflag,expandcode){
 //alert(codetype)
  var selectflag = "";
  selectflag = singleflag;
  zdm = fieldname;
  var targetname = document.getElementById(fieldname);
  if("TSTZ" ==codetype ){
    selcode = document.all.tmtz.value;
  }else
  if("ZASD" ==codetype ){
    selcode = document.all.zasd.value;
  }else
  if("AJLX" ==codetype ){
    selcode = document.all.ajlx.value;
    //selectflag = "single";
  }else
  if("XZQH" ==codetype ){
    selcode = targetname.value;
    if("single"==singleflag)selectflag = "single";
  }else
  if("TMTZJTYC" ==codetype || "ZAGTRS" ==codetype ){
    selcode = document.all.dmyctz_0.value;
    selectflag = "single";
  }else
  if("ZYTC" ==codetype ){
    selcode = document.all.zytc.value;
  }else
  if("ZZJG" ==codetype ||"ZZJY" ==codetype || "ZY"==codetype ||"WHCD"==codetype||"MZ"==codetype||"GJ"==codetype||"SAZM"==codetype){
    selcode = targetname.value;
    selectflag = "single";
    if(("ZZJG"==codetype||"ZZJY"==codetype)&&!(""==selcode||";"==selcode||"ZZJY;"==codetype||"ZZJG;"==codetype)){
  		expandcode="";
  	}
  }else if("KYYJ"==codetype){
     selcode = targetname.value;	
     //alert('as:'+selcode)
  }else{
  	selcode = targetname.value;
   
  } 
 dmcodetype = codetype;
 window.open("../../../comm/SelectTree.jsp?codetype="+codetype+"&selectflag="+selectflag+"&expandcode="+expandcode+"&selectcode="+selcode,'SELECTTREE',"top=0,left=500,width=700,height=600,scrollbars=yes,toolbar=no,menubar=no");   
}
function runoptree(codetype,selcode,fieldname){
  dmcodetype = codetype;
  zdm = fieldname;
  window.open("../../../comm/runSelectTree.jsp?codetype="+codetype+"&fieldname="+fieldname,'SELECTTREE',"top=0,left=500,width=400,height=400,scrollbars=no,toolbar=no,menubar=no");   
}
function dmarray(codetype,code,codename){
 this.codename=codename;
 this.code=code;
 this.codetype=codetype;
 return this;
}
var dmarr = new Array();
var dmarr0 =new Array();
var index = 0;
var dmcodetype ="";
var zdm ="";
function buildmar(a,b,c,d){
  //a: codetype  b: code  c:codename d : CodeType
  
  if("AJLX"==d)
    aviewtpye = "ajlx";
  else
  if("TMTZJTYC"==d)
    aviewtpye = "yctz";
  else
  if("ZYTC"==d)
    aviewtpye = "zytc";
  else
    aviewtpye = getViewtype(a);
  if(dmarr[aviewtpye]==null){
    
    dmarr[aviewtpye] = new dmarray(a,b,c)
    dmarr0[index] = dmarr[aviewtpye];
    index++;
  }else{
    dmarr[aviewtpye].codename =dmarr[aviewtpye].codename+";"+c;
  }
}
function prdmar(){
  for(i=0;i<dmarr0.length;i++){
    alert(dmarr0[i].code);
     //alert(dmarr0.length);
  }
}
function writedmtmtz(codetype){
var htmlst="<table width='100%' border='0' cellspacing='1' bgcolor='#618DBE' >";
var htmlst2=""; 
 for(i=0;i<dmarr0.length;i++){
     if("AJLX"==codetype||"ZYTC"==codetype||"XZQH"==codetype)
       htmlst2 +=dmarr0[i].codename
     else
     if("TMTZJTYC"==codetype)
       htmlst +=dmarr0[i].codename
     else
       htmlst +="<tr><td class='TD2' width='100'>"
						+getViewName(dmarr0[i].codetype)+"："
						+"</td><td class='TD2' >"
						+dmarr0[i].codename
						+"</td></tr>";
 }
dmarr0=new Array();
htmlst+="</table>";

if("TSTZ" ==codetype ){
   dmtmtz.innerHTML=htmlst;
}
if("ZASD" ==codetype ){
   dmzasd.innerHTML=htmlst;
}
if("AJLX" ==codetype ){
   dmajlx.innerHTML=htmlst2;
}
if("ZYTC" ==codetype ){
   dmzytc.innerHTML=htmlst2;
   
}
if("XZQH" ==codetype ){
   dmkyxzqh.innerHTML=htmlst2;
   
}
}



function seetreezasd(){
     var a = document.all.zasdtree.value;
     var b = document.all.zasdnametree.value;
     if(a=="")
       return;
     var temp = new Array();
     dmarr = temp;
     index = 0;
     var a1 =a.split(",,,");
     var b1 =b.split(",,,");
     for(i=0;i<a1.length;i++){
        var a11=a1[i].split(";");
        buildmar(a11[0],"",b1[i],"");
     }
     writedmtmtz("ZASD");
     
 }
function seetreetmtz(){
     var a = document.all.tmtztree.value;
     var b = document.all.tmtznametree.value;
     if(a=="")
       return;
     var temp = new Array();
     dmarr = temp;
     index = 0;
     var a1 =a.split(",,,");
     var b1 =b.split(",,,");
     for(i=0;i<a1.length;i++){
        var a11=a1[i].split(";");
        buildmar(a11[0],"",b1[i],"");
     }
     writedmtmtz("TSTZ");
     
 }
 function seetreetmtz_lxtx(){
     var a = document.all.tmtz.value;
     var b = document.all.tmtzname.value;
     if(a=="")
       return;
     var temp = new Array();
     dmarr = temp;
     index = 0;
     var a1 =a.split(",,,");
     var b1 =b.split(",,,");
     for(i=0;i<a1.length;i++){
        var a11=a1[i].split(";");
        buildmar(a11[0],"",b1[i],"");
     }
   var tmtz_lx="";
   var tmtz_tx="";
   for(i=0;i<dmarr0.length;i++){
      if("TMTZJTTX"==getViewtype(dmarr0[i].codetype)){
       tmtz_tx +=dmarr0[i].codename;
     }
     if("TMTZJTLX"==getViewtype(dmarr0[i].codetype)){
       tmtz_lx +=dmarr0[i].codename;
     }
     
   }
    dmarr0=new Array();

   htmtmtz_lx.innerHTML=tmtz_lx;
   htmtmtz_tx.innerHTML=tmtz_tx;
     
 }
 function seetreeajlx(){
     var a = document.all.ajlx.value;
     var b = document.all.ajlxname.value;
     if(a=="")
       return;
     var temp = new Array();
     dmarr = temp;
     index = 0;
     var a1 =a.split(",,,");
     var b1 =b.split(",,,");
     for(i=0;i<a1.length;i++){
        var a11=a1[i].split(";");
        buildmar(a11[0],"",b1[i],"AJLX");
     }
     writedmtmtz("AJLX");
     
 }
function seetreerydm(){
	//seetreeajlx();
	seetreetmtz();
	seetreezasd();
	}

function writetbtzms(obj){
  if(""==obj.value){
    //obj.value=getCodeName("select_div_dmTbtzbw_0")+getCodeName("select_div_dmTbtzfw_0")+
    //"方有"+getCodeName("select_div_tbtzsl_0")+"个"+getCodeName("select_div_dmTbtzmc_0")+"";
    obj.value=document.all.dmTbtzbw_0name.value+document.all.dmTbtzfw_0name.value+
    	"方有"+document.all.tbtzsl_0name.value+"个"+document.all.dmTbtzmc_0name.value+"";
  }  
}

function writeyctzms(obj){
  if(""==obj.value){
    obj.value=document.all.dmycfw_0name.value+"方"+document.all.dmyccw_0name.value+
    "牙齿是"+document.all.nayctz_0.value+"";
  }  
}