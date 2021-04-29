function SelCode(a,b){
target = document.getElementById(zdm);
targetname = document.getElementById(zdm+"name");
     target.value=a;
     targetname.value=b.replace(/,,,/g,",");
 }
var zdm = "" ;
function optree(codetype,selcode,fieldname,expandcode){
  zdm = fieldname;
  var selectflag = "";
  selcode = document.getElementById(fieldname).value;
  //alert(selcode);
  selectflag = "single";
  if(("ZZJG"==codetype||"ZZJY"==codetype)&&!(""==selcode||";"==selcode||"ZZJY;"==codetype||"ZZJG;"==codetype)){
  	expandcode="";
  }
 window.open("../../../comm/SelectTree.jsp?codetype="+codetype+"&expandcode="+expandcode+"&selectflag="+selectflag+"&selectflag="+selectflag+"&selectcode="+selcode,'SELECTTREE',"top=0,left=500,width=500,height=600,scrollbars=yes,toolbar=no,menubar=no");   
 }