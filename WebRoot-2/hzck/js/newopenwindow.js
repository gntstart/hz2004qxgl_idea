function ViewDetail(view){
window.open(view,'',"top=100,left=100,width=646,height=450,scrollbars=yes,toolbar=no,menubar=no");
}
function SubViewDetail(subview){
	if(subview.indexOf("viewBeizhu.jsp")!=-1){
		window.open(subview,"subdetail","top=200,left=200,width=646,height=450,scrollbars=no,toolbar=no,menubar=no");
	}else{
		window.open(subview,"subdetail","top=200,left=200,width=646,height=450,scrollbars=yes,toolbar=no,menubar=no");
	}
}
function openWindow(vUrl,vWindowName){
    window.open(vUrl,"vWindowName","top=200,left=200,width=550,height=300,scrollbars=yes,toolbar=no,menubar=no");
}
function newOpenDelete(module){
    if(confirm("你确定要删除吗？")){
        location.href=module;
    }
}

function winOpen_CODEMENU(vURL,vCodetype,vFrmFN,vFrmName){
//showModalDialog(view, window, 'Dialogwidth:600px;Dialogheight:500px;status:yes;help:yes;resizable:yes');
//alert(vFrmName+vFrmFN);

    var args = winOpen_CODEMENU.arguments;
    if(args.length<=3) vFrmName='Frm_Renyuan';      
    //alert(vFrmName);
    var vSelectedCode=eval(vFrmName+"."+vFrmFN+".value");
    //alert(vSelectedCode);
    window.open(vURL+"?CODETYPE="+vCodetype+"&FrmFN="+vFrmFN+"&DefCode="+vSelectedCode,'CODEMENU',"top=100,left=100,width=646,height=450,scrollbars=yes,toolbar=no,menubar=no");
}

function goBack(vFlag){
    //alert(vFlag);
    if(vFlag=="true"){
        location.href="/zfyw/back.jsp";
    }else{
        history.back(-1);
    }
}
function WinGoBack(){
    //alert("hi");
    history.back(-1);
}

//关闭自身，焦点至父窗口
function backFWin(){
	window.opener.focus();
	window.close();

}

function showModal(vUrl,vs){
    
    showModalDialog(vUrl, window, 'Dialogwidth:600px;Dialogheight:500px;status:yes;help:yes;resizable:yes');    
}

function openSelcode(codetype,selcode,selectflag,expandcode){
   window.open("../comm/SelectTree.jsp?codetype="+codetype+"&selectcode="+selcode+"&selectflag="+selectflag+"&expandcode="+expandcode,'SELECTTREE');   
}

/*
呈请报告打印
path:相对路径
cqbgid 呈请报告id
lx: 1为预览,0或其它值为打印
*/
function printGaywCqbg(path,cqbgid,lx){
	var temp = showModalDialog(path+"flws/bzckgx/printCqbg.jsp?cqbgid="+cqbgid+"&lx="+lx,"","dialogWidth=300px;dialogHeight=120px;center=true;help=no;scroll=no;status=no");	 	
	//var temp = window.open(path+"flws/bzckgx/printCqbg.jsp?cqbgid="+cqbgid+"&lx="+lx,"printwindow","width=300px;height=200px;center=true;help=no;scroll=no;status=no");	 	
}
/*
审批表打印
path:相对路径
cqbgid 呈请报告id
lx: 1为预览,0或其它值为打印
*/
function printGaywSpb(path,cqbgid,lx){
	var temp = showModalDialog(path+"flws/bzckgx/printSpb.jsp?cqbgid="+cqbgid+"&lx="+lx,"","dialogWidth=300px;dialogHeight=120px;center=true;help=no;scroll=no;status=no");	 	
	//var temp = window.open(path+"flws/bzckgx/printSpb.jsp?cqbgid="+cqbgid+"&lx="+lx,"printwindow","width=300px;height=200px;center=true;help=no;scroll=no;status=no");	 	
}