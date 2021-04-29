var needUpdateEditor=true;

function setEditorReadonly(editor, _readOnly){
	with (editor){
		if (_readOnly){
			editor.readOnly=true;
			style.color="dimgray";
			style.backgroundColor="whitesmoke";
		}
		else{
			editor.readOnly=false;
			style.color="black";
			style.backgroundColor="";
		}
	}
}

function validEditorInput(editor){
    if ((editor.value==null)|| (editor.value==""))
        return;
        
	switch (editor.getAttribute("dataType")){
		case "number":;
		case "int":{
			if (isNaN(editor.value))
				throw constErrTypeInt.replace("%s", editor.value);
			if(!editor.value.indexOf("-"))throw "输入的数字不能为负数";
			break;
		}
		case "float":{
			if (isNaN(editor.value))
				throw constErrTypeNumber.replace("%s", editor.value);
			if(!editor.value.indexOf("-"))throw "输入的数字不能为负数";
			break;
		}
		case "date":{
			var _date=new Date(editor.value);
			if (isNaN(_date))
				throw constErrTypeDate.replace("%s", editor.value);
			else{
				editor.value=formatDateTime(_date, "date");
			}
			break;
		}
		case "datetime":{
			var _date=new Date(editor.value);
			if (isNaN(_date))
				throw constErrTypeDateTime.replace("%s", editor.value);
			else{
				editor.value=formatDateTime(_date, "datetime");
			}
			break;
		}
		case "time":{
			var _date=new Date("1900/1/1 "+editor.value);
			if (isNaN(_date))
				throw constErrTypeTime.replace("%s", editor.value);
			else{
				editor.value=formatDateTime(_date, "time");
			}
			break;
		}
		case "idcard": {
		    if (!isIDCard(editor))
		        throw constErrTypeIDCard.replace("%s", editor.value);
		    break;
		}
	}
}

function updateEditorInput(editor){
	try{
		if (window.closed) return;
		validEditorInput(editor);
		editor.dropDown_selectedValue=editor.value;
	}
	catch(e){
		processException(e);
		refreshElementValue(editor);
		editor.focus();
		throw "abort";
	}
}

function _editor_onkeypress() {
	if (event.srcElement.readOnly){
		event.returnValue=false;
		return;
	}

	var result=true;
	switch (event.srcElement.getAttribute("dataType")){
		case "number":{// only "0-9"
			result=(event.keyCode>=48 && event.keyCode<=57);
			break;
		}
		case "int":{// only and "0-9" //"-" delete by zzg event.keyCode == 45 || 
			result=((event.keyCode>=48 && event.keyCode<=57));
			break;
		}
		case "float":{// only  "." and "0-9" //"-" delete by zzg event.keyCode == 45 || 
			result=(event.keyCode == 46 || (event.keyCode>=48 && event.keyCode<=57));
			break;
		}
		case "date":{// only "/" and "0-9"
			result=(event.keyCode == 47 || (event.keyCode>=48 && event.keyCode<=57));
			break;
		}
		case "datetime":{// only "/", ":", space and "0-9"
			result=(event.keyCode == 47 || event.keyCode == 58 || event.keyCode == 32 || (event.keyCode>=48 && event.keyCode<=57));
			break;
		}
		case "time":{// only ":" and "0-9"
			result=(event.keyCode == 58 || (event.keyCode>=48 && event.keyCode<=57));
			break;
		}
		case "idcard": { // only "X" and "0-9"
		    result=(event.keyCode == 88 || (event.keyCode>=48 && event.keyCode<=57));
		    break;
		}
	}
	event.returnValue=result;
} 

function isIDCard(editor) {
    var num = editor.value;
    var len = num.length;
    var re = null;
    
    if (len == 15) {
        if (isNaN(num)) {
            alert("输入的不是数字！");
            return false;
        }
        re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);        
    } else if (len == 18) {
        if (isNaN(num)) {
            if (isNaN(num.substr(0,17))) {
                alert("输入的不是数字！");
                return false;
            }
        }
        re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
    } else {
        alert ("输入的数字位数不对！"); 
        return false;   
    }
    
    var a = num.match(re);
    if (a != null)    {
        if (len==15)      {
            var D = new Date("19"+a[3]+"/"+a[4]+"/"+a[5]);
            var B = D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
        } else {
            var D = new Date(a[3]+"/"+a[4]+"/"+a[5]);
            var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];

        }
        if (!B) {
            alert("输入的身份证号 "+ a[0] +" 里出生日期不对！"); 
            return false;
        }
    }
    
    if (len == 18) {
        if (!isCheckCode(num)) {
            alert("输入的身份证号与校验码不符！ ");
            return false;
        }        
    }
    return true;
}

function isCheckCode(num) {
    var checkCodes =  new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var mulFactors =  new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var iPtr = null;
    
    var i=0;
    
    for (i=0; i<17; i++) {
        iPtr = iPtr + parseInt(num.substr(i,1))*parseInt(mulFactors[i]);
    }
    iPtr = iPtr%11;
    
    if (checkCodes[iPtr] != num.substr(17,1)) {
        return false;
    }
    
    return true;
} 