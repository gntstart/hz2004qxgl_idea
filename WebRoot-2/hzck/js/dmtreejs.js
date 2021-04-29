
var lbarr= new Array();

function destroylbarr(){
   lbarr = null;
}

 function lbarray(codetype,codev){
   this.codetype=codetype;
   this.codev=codev;
   return this;
}

function getViewName(a){
	if(lbarr[a]==null)
	  return "ÆäËü"
  return lbarr[a].codev;
}

function getViewtype(a){
	if(lbarr[a]==null)
	  return "QT"
  return lbarr[a].codetype;
}