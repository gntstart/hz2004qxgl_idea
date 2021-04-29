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
			alert("请录入正确的"+fn_cn+"!"+exp);
			//fn.focus();
			return (false);           
    }
    return true;
}
    
//必选 :radio checkbox
function check_radio(fn,fn_cn) {

	i_HasSelected=0;//未选择

	mLen=fn.length;
	for(i=0;i<mLen;i++){
		if ((fn[i].checked)&&(fn[i].value!="")) {
			i_HasSelected=1;
			break;
		}
	}//End for

	if(!i_HasSelected){
		alert("请选择一个"+fn_cn+"!!");
		return(false);
	}
	return true;
}

//必选
function check_selected(fn,fn_cn) {

	i_HasSelected=0;//未选择

	mLen=fn.length;
	for(i=0;i<mLen;i++){
		if ((fn[i].selected)&&(fn[i].value!="")) {
			i_HasSelected=1;
			break;
		}
	}//End for

	if(!i_HasSelected){
		alert("请选择一个"+fn_cn+"!!");
		return(false);
	}
	return true;
}   


/*检验指定长度的纯数字字符串： method 1:必填 EXP为例如*/
function check_string_nums(fn,fn_cn,len,method,exp){

	if(1==method){
		if (fn.value == "")
		{
			alert("请录入"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}
	if (fn.value!= "")
	{
		if (fn.value.length!=len) {
		  alert("请录入正确的"+fn_cn+"!"+fn_cn+"必须是"+len+"位的!"+exp);
		  try{
			fn.focus();
		  }catch(e){}
		  return(false);
		}

		vstrPattern = /[^0-9]/;
		if(vstrPattern.exec(fn.value)!= null){
			alert("请录入正确的"+fn_cn+"!"+fn_cn+"只能由数字组成!"+exp);
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}

	return true;
} 


/*检验字符串长度 method 1:必填*/
function check_string(fn,fn_cn,len,method,exp,NoFocus){
   // alert("asdf");
	if(1==method){
		if (fn.value == "")
		{
			alert("请录入"+fn_cn+"!");
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
			alert(""+fn_cn+"最多"+len+"个字符!"+exp);
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


/*检验字符串长度 method 1:必填*/
function check_string_mask(fn,fn_cn,len,method,exp,mask){

	if(1==method){
		if (fn.value == "")
		{
			alert("请录入"+fn_cn+"!");
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
			alert(""+fn_cn+"最多"+len+"个字符!"+exp);
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
		
		
		vstrPattern=mask;///[^0-9()_-]/;;
		if(vstrPattern.exec(fn.value)!= null){
			//alert("[2]请录入正确的"+fn_cn+"!"+exp);
			alert("请录入正确格式的"+fn_cn+"!"+exp);
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}

	return true;
}

/*检验电话号码  method=1表示必填*/
function check_telephone(fn,fn_cn,len,method,exp){

	if(1==method){
		if (fn.value == "")
		{
			alert("请录入"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}
	
	if (fn.value!= "")
	{
		if (fn.value.length>len) {
		  alert("请录入正确的"+fn_cn+"!"+fn_cn+"不能超过"+len+"位!"+exp);
		  try{
		  	fn.focus();
		  }catch(e){}
		  return(false);
		}

		vstrPattern=/[^0-9()_-]/;;
		if(vstrPattern.exec(fn.value)!= null){
			//alert("[2]请录入正确的"+fn_cn+"!"+exp);
			alert("请录入正确的"+fn_cn+"!"+fn_cn+"只能由0-9()_-组成!"+exp);
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}

	return true;
}



/*检验数字的大小*/
function check_value(fn,fn_cn,minv,maxv,method){

	if(1==method){
		if (fn.value == "")
		{
			alert("请录入"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
		
		vstrPattern = /[^0-9]/;
		if(vstrPattern.exec(fn.value)!= null){
			alert("请录入正确的"+fn_cn+"!"+fn_cn+"只能由数字组成!");
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
			alert(""+fn_cn+"只能在"+minv+"到"+maxv+"之间");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}

	return true;
}


/*检验数字： method 1:必填 EXP为例如*/
function check_nums(fn,fn_cn,MaxValue,method,exp){

	if(1==method){
		if (fn.value == "")
		{
			alert("请录入"+fn_cn+"!");
			try{
				fn.focus();
			}catch(e){}
			return (false);
		}
	}
	if (fn.value!= "")
	{

		if(isNaN(fn.value)){
			alert("请录入正确的"+fn_cn+"!"+fn_cn+"必须是数字!");
			try{
				fn.focus();
			}catch(e){}
			return(false);
		}
		if(parseFloat(fn.value)>parseFloat(MaxValue)){
			alert("请填入正确的"+fn_cn+"!"+fn_cn+"不能大于"+MaxValue);
			try{
				fn.focus();
			}catch(e){}
			return(false);
	
		}
		if(parseFloat(fn.value)<-1){
			alert("请填入正确的"+fn_cn+"!"+fn_cn+"不能小于-1");
			try{
				fn.focus();
			}catch(e){}
			return(false);
	
		}	
				

	}

	return true;
}

//IdCardNo 身份证号码支持15位与18位长度的身份证号
//birth  出生日期，格式：年年年年月月日日
function checkIDCardBirth(IdCardNo,Birth){
    var vBirth="";
    
    //出生日期格式检查
    var vDay=Birth.substring(6,8);
    var vMonth=Birth.substring(4,6);
    var vYear=Birth.substring(0,4);
    //alert(vDay+ " "+vMonth+" "+ vYear);
    if(!isValidDate(vDay, vMonth, vYear)){
        alert("出生日期格式不正确!");
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
		   	alert("身份证号码格式不正确!");
		   	return false;
		   }
    }    
    
    if(vBirth!=Birth){
        alert("身份证号码与出生日期不匹配!");
        return false;   
    }

    //alert("IdCardNo:"+IdCardNo+",Birth:"+Birth+",Sex:"+Sex);
    //alert("vBirth:"+vBirth+",vSex:"+vSex);
    return true;
}
//IdCardNo 身份证号码支持15位与18位长度的身份证号
//sex:1:男 2女
function checkIDCardSex(IdCardNo,Sex){
    //sex:1:男 2女
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
		   	alert("身份证号码格式不正确!");
		   	return false;
		   }
    }    
    if((vSex%2)==0) vSex=2;
    else vSex=1;  

    if(vSex!=Sex){
        alert("身份证号码与性别不匹配!");
        return false;   
    } 
    //alert("IdCardNo:"+IdCardNo+",Birth:"+Birth+",Sex:"+Sex);
    //alert("vBirth:"+vBirth+",vSex:"+vSex);
    return true;
}