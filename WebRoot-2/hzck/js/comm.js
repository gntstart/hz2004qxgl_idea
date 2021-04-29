
//VidwJjDetail(cd.jsp?caseid=90398)
function ViewJjDetail(url){
    window.open(url+'&moduleid=jcj&command=query&moduleid2=&reportState=2',"detail","top=100,left=100,width=646,height=450,scrollbars=yes,toolbar=no,menubar=no");
}


//VidwJjDetail(cd.jsp?caseid=90398&moduleid=jcj)
function ViewAjDetail(url){
    window.open(url+'&command=query&moduleid2=&reportState=2',"detail","top=100,left=100,width=646,height=450,scrollbars=yes,toolbar=no,menubar=no");
}


//getURLforName(str)
function getURLforName(param){
var str = window.location.toString(); 
if(str.indexOf("?")>0){
    var urlstr = str.substring(str.indexOf("?")+1);
    var urlArray = urlstr.split("&");
    //alert(urlArray.length);
    for(i=0;i<urlArray.length;i++)
        { 
            if(urlArray[i].indexOf(param)>=0)
                return  urlArray[i].substring(urlArray[i].indexOf("=")+1);  
        }
    }
    return "";
}

function getURLforName2(param){
var str = parent.window.location.toString(); 
if(str.indexOf("?")>0){
    var urlstr = str.substring(str.indexOf("?")+1);
    var urlArray = urlstr.split("&");
    //alert(urlArray.length);
    for(i=0;i<urlArray.length;i++)
        { 
            if(urlArray[i].indexOf(param)>=0)
                return  urlArray[i].substring(urlArray[i].indexOf("=")+1);  
        }
    }
    return "";
}
function processSubmit(obj){
  obj.disabled=true;  
  if(validateDocument()){ 
    obj.form.submit();

  }else {
    obj.disabled=false;
  }
}

 
if (window.event) 
 document.captureEvents(event.MOUSEUP); 
 
function nocontextmenu() {
 event.cancelBubble = true
 event.returnvalue = false;
 return false;
}
 
function norightclick(e) {
 if (window.event) {
if(e.which==2||e.which==3){
return false;
}else if(event.button==2||event.button==3){
event.cancelBubble=true;
event.returnvalue=false;
return false; 
 }
}
} 
//document.oncontextmenu = nocontextmenu; // for IE5+
//document.onmousedown = norightclick;  // for all others 
//document.onkeydown=KeyDown;

function KeyDown(){ 
    
    if ((window.event.altKey)&&
        ((window.event.keyCode==37)|| // Alt+ <-
        (window.event.keyCode==39))){ // Alt+ ->
            alert("不准你使用ALT+方向键前进或后退网页！");
            event.returnValue=false;
    }



if ((event.keyCode==8) || //
    (event.keyCode==116)|| // F5 
    (event.ctrlKey && event.keyCode==82)){ //Ctrl + R  
        event.keyCode=0; 
        event.returnValue=false; 

}
if ((event.ctrlKey)&&(event.keyCode==78)) // Ctrl+n
    event.returnValue=false;
if ((event.shiftKey)&&(event.keyCode==121)) // shift+F10
    event.returnValue=false;


if ((window.event.srcElement.tagName == "A") && window.event.shiftKey){ 
    event.keyCode=0; 
    event.returnValue=false;
    alert("不能用Shift来打开窗口！"); 
    return false;
} 
    
if ((window.event.altKey)&&(window.event.keyCode==115)){ //Alt+F4
    window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px");
    return false;
}
}

function getIDLastCode(num) {
    var checkCodes =  new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var mulFactors =  new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var iPtr = null;
    
    var i=0;
    
    for (i=0; i<17; i++) {
        iPtr = iPtr + parseInt(num.substr(i,1))*parseInt(mulFactors[i]);
    }
    iPtr = iPtr%11; 
    
    return checkCodes[iPtr];
} 

function id15to18(num){
    if(num.length==15){
       var id17=num.substring(0,6)+"19"+num.substring(6,12)+num.substring(12,15);
       return id17+getIDLastCode(id17);
    }
    else{
       return num; 
    }    

}

function valSz() {//
if((window.event.keyCode>=48 && window.event.keyCode<=57)||(window.event.keyCode>=96 && window.event.keyCode<=105))
{
window.event.returnValue="";
}
}