function SelCode(a,b){
var codetype = dmcodetype;
 var targetcode;
 var targetname;
 targetcode = document.getElementById(zdm);
 targetname = document.getElementById(zdm+"name");
 
   targetcode.value=a;
   targetname.value=b.replace(/,,,/g,";");
   if("ZASD"==codetype){
   
     targetname.value=b;
     var temp = new Array();
     dmarr = temp;
     index = 0;
     var a1 =a.split(",,,");
     var b1 =b.split(",,,");
     for(i=0;i<a1.length;i++){
        var a11=a1[i].split(";");
        buildmar(a11[0],"",b1[i],codetype);
     }
     writedmhtml(codetype);
     
   }
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
	if(code==null||""==code)return;
	var a1 =code.split(",");
     	var b1 =codename.split(",");
     	for(i=0;i<a1.length;i++){
     		//alert(i);
        	buildmar(a1[i],"",b1[i],codetype);
     	}
     	writedmhtml(codetype);
}
function dmarray(codetype,code,codename,ind){
if(codename.indexOf("¡ù¡ò¡ù")>0){
	  this.codename ="<input type=\"checkbox\" name=\"checkboxzasds\" value="+codename.split("¡ù¡ò¡ù")[0]+" checked>"+codename.split("¡ù¡ò¡ù")[1];
	}else{
	  this.codename=codename;
  }
 this.code=code;
 this.codetype=codetype;
 this.ind=ind;
 return this;
}
var dmarr = new Array();
var dmarr0 =new Array();
var zasdcheckb = new Array();
var zasdindex = 0;
var fxcount=0;
var index = 0;
var dmcodetype ="";
var zdm="";
function buildmar(a,b,c,d){
  //a: codetype  b: code  c:codename d : CodeType
  aviewtpye = getViewtype(a);
  
  if(dmarr[aviewtpye]==null){
    
    dmarr[aviewtpye] = new dmarray(a,b,c)
    dmarr0[index] = dmarr[aviewtpye];
    if(c.indexOf("¡ù¡ò¡ù")>0){
    	dmarr[aviewtpye].ind=zasdindex;
    	zasdcheckb[zasdindex] = 1;
      fxcount++;
      zasdindex++;
    }
    index++;
  }else{
    if(c.indexOf("¡ù¡ò¡ù")>0){
    	zasdcheckb[dmarr[aviewtpye].ind]=zasdcheckb[dmarr[aviewtpye].ind]+1;
    	fxcount++;
    	dmarr[aviewtpye].codename =dmarr[aviewtpye].codename+";"+"<input type=\"checkbox\" name=\"checkboxzasds\" value="+c.split("¡ù¡ò¡ù")[0]+" checked>"+c.split("¡ù¡ò¡ù")[1];
    }else{
      dmarr[aviewtpye].codename =dmarr[aviewtpye].codename+";"+c;
    }
  }
}
function writedmhtml(codetype){
 var htmlst="<table width='100%' border='0' cellspacing='1' bgcolor='#618DBE' >";

 for(i=0;i<dmarr0.length;i++){
 	 if(fxcount>0){
 	 	 htmlst +="<tr><td class='TD2' width='100'>"+"<input type=\"checkbox\" onclick=\"checdzasdf(this,"+i+")\" name=\"checkboxzasdf\" value=\"\" checked>"
						+getViewName(dmarr0[i].codetype)+"£º"
						+"</td><td class='TD2' >"
						+dmarr0[i].codename
						+"</td></tr>";
 	 }else{
     htmlst +="<tr><td class='TD2' width='100'>"
						+getViewName(dmarr0[i].codetype)+"£º"
						+"</td><td class='TD2' >"
						+dmarr0[i].codename
						+"</td></tr>";
	 }
 }
 htmlst+="</table>";
 document.getElementById("dm"+codetype.toLowerCase()).innerHTML=htmlst;
 dmarr0=new Array();
}
 function optree(codetype,selcode,fieldname,singleflag){
 	dmcodetype = codetype;
  var selectflag = "";
  if("single"==singleflag)selectflag = "single";
  zdm = fieldname;
  if(singleflag==""||(typeof(singleflag)=="undefined")){
  	if("SAWP"==codetype||"XCWZWLWZ"==codetype ||"ZAGTRS" ==codetype)
    	selectflag = "single";
  	//var target =document.CaseAnalyseForm[codetype.toLowerCase()];
  	if("ZZJY"==codetype||"ZZJG"==codetype)
  		selectflag = "single";
  }
  var targetcode =document.getElementById(fieldname);
  //var target =document.getElementById(codetype.toLowerCase());
  selcode = targetcode.value;
  window.open("../../comm/SelectTree.jsp?codetype="+codetype+"&selectflag="+selectflag+"&selectcode="+selcode,'SELECTTREE',"top=0,left=500,width=500,height=600,scrollbars=yes,toolbar=no,menubar=no");   
 }

function runoptree(codetype,selcode,fieldname){
  dmcodetype = codetype;
  zdm = fieldname;
  window.open("../../comm/runSelectTree.jsp?codetype="+codetype+"&fieldname="+fieldname,'SELECTTREE',"top=0,left=500,width=400,height=400,scrollbars=no,toolbar=no,menubar=no");   
}

function seetree(){
    seetreefx();
     
 }
 function seetreefx(){
 	 var a = document.all.zasd.value;
     var b = document.all.zasdname.value;
     if(a=="")
       return;
     var temp = new Array();
     dmarr = temp;
     index = 0;
     var a1 =a.split(",,,");
     var b1 =b.split(",,,");
     for(i=0;i<a1.length;i++){
        var a11=a1[i].split(";");
        buildmar(a11[0],"",b1[i],"ZASD");
     }
     var temp=0;
     for(i=0;i<zasdcheckb.length;i++){
     	  var nub = zasdcheckb[i];
     	  
     	  zasdcheckb[i]="";
     	  for(j=1;j<=nub;j++){
     	  	zasdcheckb[i]=zasdcheckb[i]+temp+"¡ò"
     	  	temp ++;
     	  }	
     }
     writedmhtml("ZASD");
}

 
