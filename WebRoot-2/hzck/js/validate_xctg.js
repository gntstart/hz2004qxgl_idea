function of_Validator_Create(f){
    //alert("asdf");
    if(!validateDocument())  return false;    
    _disabledSubmit(f);    
    return true;
}

function of_Validator_Disabled(f){    
    if(confirm("��ȷʵҪɾ����")){        
        f.action='disabledXctgDetailAction.jsp';
        f.submit();
        return true;
    }
    return false;
}

function _disabledSubmit(f){
  	f.btnSubmit.disabled=true;
	f.btnReset.disabled=true;  
}
