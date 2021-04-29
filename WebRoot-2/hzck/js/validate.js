function isValidDate(day, month, year) {
	if(day.length<1 && month.length <1 && year.length<1) return true;

    if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) &&
            (day == 31)) {
            return false;
        }
        if (month == 2) {
            var leap = (year % 4 == 0 &&
                       (year % 100 != 0 || year % 400 == 0));
            if (day>29 || (day == 29 && !leap)) {
                return false;
            }
        }
        return true;
}

function checkEmail(emailStr) {
   if (emailStr.length == 0) {
       return true;
   }
   var emailPat=/^(.+)@(.+)$/;
   var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
   var validChars="\[^\\s" + specialChars + "\]";
   var quotedUser="(\"[^\"]*\")";
   var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
   var atom=validChars + '+';
   var word="(" + atom + "|" + quotedUser + ")";
   var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
   var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
   var matchArray=emailStr.match(emailPat);
   if (matchArray == null) {
       return false;
   }
   var user=matchArray[1];
   var domain=matchArray[2];
   if (user.match(userPat) == null) {
       return false;
   }
   var IPArray = domain.match(ipDomainPat);
   if (IPArray != null) {
       for (var i = 1; i <= 4; i++) {
          if (IPArray[i] > 255) {
             return false;
          }
       }
       return true;
   }
   var domainArray=domain.match(domainPat);
   if (domainArray == null) {
       return false;
   }
   var atomPat=new RegExp(atom,"g");
   var domArr=domain.match(atomPat);
   var len=domArr.length;
   if ((domArr[domArr.length-1].length < 2) ||
       (domArr[domArr.length-1].length > 3)) {
       return false;
   }
   if (len < 2) {
       return false;
   }
   return true;
}

function check_email(fn,fn_cn,exp){
   
    if(!checkEmail(fn.value)){
			alert("��¼����ȷ��"+fn_cn+"!"+exp);
			//fn.focus();
			return (false);           
    }
    return true;
}
    
//��ѡ :radio checkbox
function check_radio(fn,fn_cn) {

	i_HasSelected=0;//δѡ��

	mLen=fn.length;
	for(i=0;i<mLen;i++){
		if ((fn[i].checked)&&(fn[i].value!="")) {
			i_HasSelected=1;
			break;
		}
	}//End for

	if(!i_HasSelected){
		alert("��ѡ��һ��"+fn_cn+"!!");
		return(false);
	}
	return true;
}

//��ѡ
function check_selected(fn,fn_cn) {

	i_HasSelected=0;//δѡ��

	mLen=fn.length;
	for(i=0;i<mLen;i++){
		if ((fn[i].selected)&&(fn[i].value!="")) {
			i_HasSelected=1;
			break;
		}
	}//End for

	if(!i_HasSelected){
		alert("��ѡ��һ��"+fn_cn+"!!");
		return(false);
	}
	return true;
}   


/*����ָ�����ȵĴ������ַ����� method 1:���� EXPΪ����*/
function check_string_nums(fn,fn_cn,len,method,exp){

	if(1==method){
		if (fn.value == "")
		{
			alert("��¼��"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}
	if (fn.value!= "")
	{
		if (fn.value.length!=len) {
		  alert("��¼����ȷ��"+fn_cn+"!"+fn_cn+"������"+len+"λ��!"+exp);
		  try{
			fn.focus();
		  }catch(e){}
		  return(false);
		}

		vstrPattern = /[^0-9]/;
		if(vstrPattern.exec(fn.value)!= null){
			alert("��¼����ȷ��"+fn_cn+"!"+fn_cn+"ֻ�����������!"+exp);
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}

	return true;
} 


/*�����ַ������� method 1:����*/
function check_string(fn,fn_cn,len,method,exp,NoFocus){
   // alert("asdf");
	if(1==method){
		if (fn.value == "")
		{
			alert("��¼��"+fn_cn+"!");
			if(NoFocus){
			}else{
				try{
			    		fn.focus();
				}catch(e){}
			}			
			return (false);
		}
	}


	if (fn.value!= "")
	{
		if (fn.value.length > len)
		{
			alert(""+fn_cn+"���"+len+"���ַ�!"+exp);
			if(NoFocus){
			}else{
			    try{
				fn.focus();
			    }catch(e){}
			}	
			return (false);
		}
	}

	return true;
}


/*�����ַ������� method 1:����*/
function check_string_mask(fn,fn_cn,len,method,exp,mask){

	if(1==method){
		if (fn.value == "")
		{
			alert("��¼��"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}


	if (fn.value!= "")
	{
		if (fn.value.length > len)
		{
			alert(""+fn_cn+"���"+len+"���ַ�!"+exp);
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
		
		
		vstrPattern=mask;///[^0-9()_-]/;;
		if(vstrPattern.exec(fn.value)!= null){
			//alert("[2]��¼����ȷ��"+fn_cn+"!"+exp);
			alert("��¼����ȷ��ʽ��"+fn_cn+"!"+exp);
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}

	return true;
}

/*����绰����  method=1��ʾ����*/
function check_telephone(fn,fn_cn,len,method,exp){

	if(1==method){
		if (fn.value == "")
		{
			alert("��¼��"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}
	
	if (fn.value!= "")
	{
		if (fn.value.length>len) {
		  alert("��¼����ȷ��"+fn_cn+"!"+fn_cn+"���ܳ���"+len+"λ!"+exp);
		  try{
		  	fn.focus();
		  }catch(e){}
		  return(false);
		}

		vstrPattern=/[^0-9()_-]/;;
		if(vstrPattern.exec(fn.value)!= null){
			//alert("[2]��¼����ȷ��"+fn_cn+"!"+exp);
			alert("��¼����ȷ��"+fn_cn+"!"+fn_cn+"ֻ����0-9()_-���!"+exp);
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}

	return true;
}



/*�������ֵĴ�С*/
function check_value(fn,fn_cn,minv,maxv,method){

	if(1==method){
		if (fn.value == "")
		{
			alert("��¼��"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
		
		vstrPattern = /[^0-9]/;
		if(vstrPattern.exec(fn.value)!= null){
			alert("��¼����ȷ��"+fn_cn+"!"+fn_cn+"ֻ�����������!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}		
	}


	if (fn.value!= "")
	{
		if((fn.value > maxv)||(fn.value<minv))
		{
			alert(""+fn_cn+"ֻ����"+minv+"��"+maxv+"֮��");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}

	return true;
}


/*�������֣� method 1:���� EXPΪ����*/
function check_nums(fn,fn_cn,MaxValue,method,exp){

	if(1==method){
		if (fn.value == "")
		{
			alert("��¼��"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}
	if (fn.value!= "")
	{

		if(isNaN(fn.value)){
			alert("��¼����ȷ��"+fn_cn+"!"+fn_cn+"����������!");
			try{
				fn.focus();
			}catch(e){}
			return(false);
		}
		if(parseFloat(fn.value)>parseFloat(MaxValue)){
			alert("��������ȷ��"+fn_cn+"!"+fn_cn+"���ܴ���"+MaxValue);
			try{
				fn.focus();
			}catch(e){}
			return(false);
	
		}
		if(parseFloat(fn.value)<-1){
			alert("��������ȷ��"+fn_cn+"!"+fn_cn+"����С��-1");
			try{
				fn.focus();
			}catch(e){}
			return(false);
	
		}	
				

	}

	return true;
}

//IdCardNo ���֤����֧��15λ��18λ���ȵ����֤��
//birth  �������ڣ���ʽ������������������
function checkIDCardBirth(IdCardNo,Birth){
    var vBirth="";
    
    //�������ڸ�ʽ���
    var vDay=Birth.substring(6,8);
    var vMonth=Birth.substring(4,6);
    var vYear=Birth.substring(0,4);
    //alert(vDay+ " "+vMonth+" "+ vYear);
    if(!isValidDate(vDay, vMonth, vYear)){
        alert("�������ڸ�ʽ����ȷ!");
		return false;
    }
        
    switch (IdCardNo.length){
        case 15:{            
            vBirth="19"+IdCardNo.substring(6,12);
            break;
            }
        case 18:{            
            vBirth=IdCardNo.substring(6,14);            
            break;
            }
	    default:{
		   	alert("���֤�����ʽ����ȷ!");
		   	return false;
		   }
    }    
    
    if(vBirth!=Birth){
        alert("���֤������������ڲ�ƥ��!");
        return false;   
    }

    //alert("IdCardNo:"+IdCardNo+",Birth:"+Birth+",Sex:"+Sex);
    //alert("vBirth:"+vBirth+",vSex:"+vSex);
    return true;
}
//IdCardNo ���֤����֧��15λ��18λ���ȵ����֤��
//sex:1:�� 2Ů
function checkIDCardSex(IdCardNo,Sex){
    //sex:1:�� 2Ů
    var vSex="";
    
    switch (IdCardNo.length){
        case 15:{
            vSex=IdCardNo.substring(IdCardNo.length-1);
            break;
            }
        case 18:{
            vSex=IdCardNo.substring(IdCardNo.length-2,IdCardNo.length-1);       
            break;
            }
	    default:{
		   	alert("���֤�����ʽ����ȷ!");
		   	return false;
		   }
    }    
    if((vSex%2)==0) vSex=2;
    else vSex=1;  

    if(vSex!=Sex){
        alert("���֤�������Ա�ƥ��!");
        return false;   
    } 
    //alert("IdCardNo:"+IdCardNo+",Birth:"+Birth+",Sex:"+Sex);
    //alert("vBirth:"+vBirth+",vSex:"+vSex);
    return true;
}