function of_Validator_Upload(f){
	
	_disabledSubmit(f);
	return true; 
}

function of_Validator_Create_QTRY(f){
    //alert("asdf");
    if(!validateDocument())  return false;
    if(!check_string(f.xm,"姓名",15,1,"",0)) return false;    
    
    if(!checkIDCard2InRenyuan(f.sfzh.value,f.csrq1.value,f.dmXb.value))  return false;
    
    _disabledSubmit(f);    
    return true;
}


function of_Validator_Create_WMST(f){    
    if(!validateDocument())  return false;
    
    switchLab(1,6);    
    if(!check_string(f.xm,"姓名",15,1,"",0)) return false;    
    if(!check_email(f.email,"Email","如：tech@gnt.com.cn")) return false;    

    if(!checkIDCard2InRenyuan(f.sfzh.value,f.csrq1.value,f.dmXb.value))  return false;
        
    _disabledSubmit(f);
    return true;
}
function of_Validator_Create(f){
    if(!validateDocument())  return false;
    //switchLab(1,2);
    //if(!check_string(f.xm,"姓名",15,1,"",0)) return false;   
    if(!check_email(f.email,"Email","如：tech@gnt.com.cn")) {
    	return false;    
    }
    if(!checkIDCard2InRenyuan(f.sfzh.value,f.csrq1.value,f.dmXb.value))  return false;
   
    _disabledSubmit(f); 
	return true;     
}
/*
function of_Validator_Update(f){
    
    if(!validateDocument())  return false;
    switchLab(1,9);
    if(!check_string(f.xm,"姓名",15,1,"",0)) return false;
    if(!check_email(f.email,"Email","如：tech@gnt.com.cn")) return false;    
    
	_disabledSubmit(f);
	return true;      
}
*/
function of_Validator_Disabled(f){    
	f.delete_button.disabled="true";
    if(confirm("你确定要删除吗？")){        
        f.action='disabledRenyuanDetailAction.jsp';
        f.submit();
        return true;
    }else{
    	f.delete_button.disabled="";	
    }
    return false;
}


function _disabledSubmit(f){
  	f.btnSubmit.disabled=true;
	f.btnReset.disabled=true;  
}

function checkIDCard2InRenyuan(IdCardNo,Birth,Sex){
    //alert(IdCardNo+" "+Birth+" "+Sex);
    if(IdCardNo.length==0)return true;//身份证号未填时不作检验
    
    //身份证与出生日期
    var vBirth=Birth.substring(0,4)+Birth.substring(5,7)+Birth.substring(8,10);

    if((!checkIDCardBirth(IdCardNo,vBirth))|(!checkIDCardSex(IdCardNo,Sex))){
        if(!confirm("您是否要忽略身份证与其他项目的不匹配? ")) return false;
    }
    return true;
}


function SyncLXR(f){
    f.lxr2.value=f.lxr.value;
}
function SynclLXRTel(f){
    f.lxdh2.value=f.lxdh.value
}

//onBlur="SynclCsrq(Frm_Renyuan)"
function SynclCsrq(f){
    IdCardNo=f.sfzh.value;
    vBirth="";
    switch (IdCardNo.length){
        case 15:{            
            vBirth="19"+IdCardNo.substring(6,12);
            break;
            }
        case 18:{            
            vBirth=IdCardNo.substring(6,14);            
            break;
            }
    }
    
    if(vBirth!="")
        f.csrq1.value=fomatRJ(vBirth);
          
}
function setXb(obj){
    var IdCardNo=obj.value;
    if(IdCardNo!=""){
        /*
        buildson("","div_dmXb");
        document.all.select_div_dmXb.value=IdCardNo.substring(16,17)%2==0?"2":"1";
        document.all.dmXb.value=IdCardNo.substring(16,17)%2==0?"2":"1";
        */
        if(document.all.jccode_dmXb){
	        var xb = IdCardNo.substring(16,17)%2==0?"2":"1";
	        document.all.jccode_dmXb.SelectedCode = xb;// 
		document.all.jccode_dmXb.initAgainBySelectedCode(0);//
	}
    }
    
}
function fomatRJ(Birth){
    vBirth="";
    vBirth=Birth.substring(0,4)+"/"+Birth.substring(4,6)+"/"+Birth.substring(6,8);
    return vBirth;
}


//重新给jccode赋值
function initJcCode(name,value){ 
  var jcobj = document.getElementById("jccode_"+name);
  if(jcobj){
  	jcobj.SelectedCode = value;// 
	jcobj.initAgainBySelectedCode(0);//
   }
}

//根据字典code用性别字典控件来翻译字典
function getJCCodeName(code,codetype){
	return document.all.jccode_dmXb.transValueToName(code,codetype);
}
//获取年龄根据生日
function getXyrNlBySr(csrq){
	if(csrq==null||csrq==""||csrq.length<9){
		return "";	
	}
	var today = new Date();  
	nl=today.getYear()*1-csrq.substr(0,4)*1;
	if(nl==0)nl=1;
	if(nl<0)nl=0;
	return nl;
}
/*****拼装犯罪嫌疑人情况
犯罪嫌疑人{姓名},{性别},{出生日期}生（年龄：{年龄}岁）,居民身份证编号：{身份证编号},{民族},
户籍所在地为{户籍区划}{户籍详细地址},现住{现住址区划}{现住址详址},{工作单位为{工作单位}，
{文化程度}＋{简历}
*/
function getFzxyrQk(obj){
	if(obj.value==""||trimStr(obj.value)==""){
		var xyrqk = "犯罪嫌疑人";
		//姓名	
		if(document.all.xm.value!="") xyrqk+=(document.all.xm.value);
		//性别
		if(document.all.dmXb.value!="") xyrqk+=("，"+getJCCodeName(document.all.dmXb.value,"XB"));
		
		var nl;//
		//出身日期
		if(document.all.csrq1.value!=""){
			 xyrqk+=("，"+document.all.csrq1.value+"出生");
			 nl = getXyrNlBySr(document.all.csrq1.value);
		}else{
			nl="";	
		}
		//年龄
		if(document.all.nl&&document.all.nl.value!=""){
			 xyrqk+=("（年龄："+document.all.nl.value+"岁）");
		}else{
			if(nl!=""){
				xyrqk+=("（年龄："+nl+"岁）");	
			}	
		}
		
		//身份证号
		if(document.all.sfzh.value!="") xyrqk+=("，居民身份证编号："+document.all.sfzh.value);
		//民族
		if(document.all.dmMz.value!="") xyrqk+=("，"+getJCCodeName(document.all.dmMz.value,"MZ"));
		//户籍区划
		if(document.all.dmXzqhHj.value!="") xyrqk+=("，户籍所在地为"+getJCCodeName(document.all.dmXzqhHj.value,"XZQH"));
		//户籍祥址
		if(document.all.xxdzHj.value!="") xyrqk+=(document.all.xxdzHj.value);
		//现在区划
		if(document.all.dmXzqhZj.value!="") xyrqk+=("，现住"+getJCCodeName(document.all.dmXzqhZj.value,"XZQH"));
		//现在祥址
		if(document.all.xxdzZj.value!="") xyrqk+=(document.all.xxdzZj.value);
		//工作单位
		if(document.all.gzdw.value!="") xyrqk+=("，工作单位为"+document.all.gzdw.value);
		//文化程度
		if(document.all.dmWhcd.value!="") xyrqk+=("，"+getJCCodeName(document.all.dmWhcd.value,"WHCD"));
		xyrqk+="。";
		//简历
		if(document.all.jlqk.value!="") xyrqk+=(""+document.all.jlqk.value+"。");
		document.all.xyrqk.value = xyrqk;
	}
}

/*****拼装违法嫌疑人情况
{姓名}，{性别}，{出生日期}出生，{证件类别}：{证件号码}，现住址：{现住址}，工作单位：{工作单位}，
户籍地：{户籍地}，违法犯罪记录：{违法犯罪记录}；
*/
function getWfxyrQk(obj){
	if(obj.value==""||trimStr(obj.value)==""){
		var xyrqk = "";
		//姓名	
		if(document.all.xm.value!="") xyrqk+=(document.all.xm.value);
		//性别
		if(document.all.dmXb.value!="") xyrqk+=("，"+getJCCodeName(document.all.dmXb.value,"XB"));
		//出身日期
		if(document.all.csrq1.value!="") xyrqk+=("，"+document.all.csrq1.value+"出生");
		//身份证号
		if(document.all.sfzh.value!="") xyrqk+=("，居民身份证编号："+document.all.sfzh.value);
		//现在区划
		if(document.all.dmXzqhZj.value!="") xyrqk+=("，现住址："+getJCCodeName(document.all.dmXzqhZj.value,"XZQH"));
		//现在祥址
		if(document.all.xxdzZj.value!="") xyrqk+=(document.all.xxdzZj.value);
		//工作单位
		if(document.all.gzdw.value!="") xyrqk+=("，工作单位："+document.all.gzdw.value);
		//户籍区划
		if(document.all.dmXzqhHj.value!="") xyrqk+=("，户籍地："+getJCCodeName(document.all.dmXzqhHj.value,"XZQH"));
		//户籍祥址
		if(document.all.xxdzHj.value!="") xyrqk+=(document.all.xxdzHj.value);
		//简历
		if(document.all.jlqk.value!="") xyrqk+=("，违法犯罪记录："+document.all.jlqk.value+"。");
		document.all.xyrqk.value = xyrqk;
	}
}


/*****受害人简要情况
{姓名},{性别},{出生日期}生（年龄：{年龄}岁）,居民身份证编号：{身份证编号},{民族},
户籍所在地为{户籍区划}{户籍详细地址},现住{现住址区划}{现住址详址}, {工作单位}+职业。
*/
function getShrQk(obj){
	if(obj.value==""||trimStr(obj.value)==""){
		var xyrqk = "";
		//姓名	
		if(document.all.xm.value!="") xyrqk+=(document.all.xm.value);
		//性别
		if(document.all.dmXb.value!="") xyrqk+=("，"+getJCCodeName(document.all.dmXb.value,"XB"));
		var nl;//
		//出身日期
		if(document.all.csrq1.value!=""){
			 xyrqk+=("，"+document.all.csrq1.value+"出生");
			 nl = getXyrNlBySr(document.all.csrq1.value);
		}else{
			nl="";	
		}
		//年龄
		if(document.all.nl&&document.all.nl.value!=""){
			 xyrqk+=("（年龄："+document.all.nl.value+"岁）");
		}else{
			if(nl!=""){
				xyrqk+=("（年龄："+nl+"岁）");	
			}	
		}
		//身份证号
		if(document.all.sfzh.value!="") xyrqk+=("，居民身份证编号："+document.all.sfzh.value);
		//民族
		if(document.all.dmMz.value!="") xyrqk+=("，"+getJCCodeName(document.all.dmMz.value,"MZ"));
		//户籍区划
		if(document.all.dmXzqhHj.value!="") xyrqk+=("，户籍所在地为"+getJCCodeName(document.all.dmXzqhHj.value,"XZQH"));
		//户籍祥址
		if(document.all.xxdzHj.value!="") xyrqk+=(document.all.xxdzHj.value);
		//现在区划
		if(document.all.dmXzqhZj.value!="") xyrqk+=("，现住"+getJCCodeName(document.all.dmXzqhZj.value,"XZQH"));
		//现在祥址
		if(document.all.xxdzZj.value!="") xyrqk+=(document.all.xxdzZj.value);
		//工作单位
		if(document.all.gzdw.value!="") xyrqk+=("，"+document.all.gzdw.value);
		//职业
		if(document.all.dmZy.value!="") xyrqk+=("，"+document.all.dmZy.value+"。");
		document.all.xyrqk.value = xyrqk;
	}
}

/*****其他人员简要情况
{姓名},{性别},{出生日期}生（年龄：{年龄}岁）,居民身份证编号：{身份证编号},
现住{现住址区划}{现住址详址}, {工作单位}+职业。
*/
function getQtryQk(obj){
	if(obj.value==""||trimStr(obj.value)==""){
		var xyrqk = "";
		//姓名	
		if(document.all.xm.value!="") xyrqk+=(document.all.xm.value);
		//性别
		if(document.all.dmXb.value!="") xyrqk+=("，"+getJCCodeName(document.all.dmXb.value,"XB"));
		var nl;//
		//出身日期
		if(document.all.csrq1.value!=""){
			 xyrqk+=("，"+document.all.csrq1.value+"出生");
			 nl = getXyrNlBySr(document.all.csrq1.value);
		}else{
			nl="";	
		}
		//年龄
		if(document.all.nl&&document.all.nl.value!=""){
			 xyrqk+=("（年龄："+document.all.nl.value+"岁）");
		}else{
			if(nl!=""){
				xyrqk+=("（年龄："+nl+"岁）");	
			}	
		}
		//身份证号
		if(document.all.sfzh.value!="") xyrqk+=("，居民身份证编号："+document.all.sfzh.value);
		//现在区划
		if(document.all.dmXzqhZj.value!="") xyrqk+=("，现住"+getJCCodeName(document.all.dmXzqhZj.value,"XZQH"));
		//现在祥址
		if(document.all.xxdzZj.value!="") xyrqk+=(document.all.xxdzZj.value);
		//工作单位
		if(document.all.gzdw.value!="") xyrqk+=("，"+document.all.gzdw.value);
		//职业
		if(document.all.dmZy.value!="") xyrqk+=("，"+document.all.dmZy.value+"。");
		document.all.xyrqk.value = xyrqk;
	}
}