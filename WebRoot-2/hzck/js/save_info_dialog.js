var modaldialog = 9 ;//0 表示提交成功  1 表示提交失败

function showSavedialog(path){
	var temp = showModelessDialog(path+"comm/saveInfoDialog.htm",window,"dialogWidth=300px;dialogHeight=200px;center=true;help=no;scroll=no;status=no");	 	
}

function setSavestate(flag){
	modaldialog=flag;
}

function activebutton(buttonname){
	if(modaldialog=='1'){
		var buttonobj=document.getElementById(buttonname);
  		if(buttonobj){
  			buttonobj.disabled=false;
  		}
  	}
}