<!--
function backData(frm)
{
    var myStr_SelectValue="";
    var myStr_SelectValue_SHOW="";
    var container;
        
    //alert("传回数据");  

   for(i=0;i<myLenth;i++){
        if(frm.SEL_ITEM_CODE[i].checked){
          //  alert(Frm_commZagljsd.SEL_ITEM[i].value);
            if(myStr_SelectValue.length>0)  myStr_SelectValue+=",";
            if(myStr_SelectValue_SHOW.length>0)  myStr_SelectValue_SHOW+=",";
            myStr_SelectValue+=frm.SEL_ITEM_CODE[i].value;
            myStr_SelectValue_SHOW+=frm.SEL_ITEM_TITLE[i].value;
        }
    }
    //alert("2"); 

    container = findOpenerObj(FldName);
    container.value=myStr_SelectValue;
    
    var FldName_SHOW="SHOW_"+FldName;
    //alert("3");      
    container = findOpenerObj(FldName_SHOW);
    container.isContainer = true;
    container.innerHTML=myStr_SelectValue_SHOW;   
         
    self.close();
    window.opener.focus();
}
-->