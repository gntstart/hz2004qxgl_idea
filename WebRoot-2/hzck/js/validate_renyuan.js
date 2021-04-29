function of_Validator_Upload(f){
	
	_disabledSubmit(f);
	return true; 
}

function of_Validator_Create_QTRY(f){
    //alert("asdf");
    if(!validateDocument())  return false;
    if(!check_string(f.xm,"����",15,1,"",0)) return false;    
    
    if(!checkIDCard2InRenyuan(f.sfzh.value,f.csrq1.value,f.dmXb.value))  return false;
    
    _disabledSubmit(f);    
    return true;
}


function of_Validator_Create_WMST(f){    
    if(!validateDocument())  return false;
    
    switchLab(1,6);    
    if(!check_string(f.xm,"����",15,1,"",0)) return false;    
    if(!check_email(f.email,"Email","�磺tech@gnt.com.cn")) return false;    

    if(!checkIDCard2InRenyuan(f.sfzh.value,f.csrq1.value,f.dmXb.value))  return false;
        
    _disabledSubmit(f);
    return true;
}
function of_Validator_Create(f){
    if(!validateDocument())  return false;
    //switchLab(1,2);
    //if(!check_string(f.xm,"����",15,1,"",0)) return false;   
    if(!check_email(f.email,"Email","�磺tech@gnt.com.cn")) {
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
    if(!check_string(f.xm,"����",15,1,"",0)) return false;
    if(!check_email(f.email,"Email","�磺tech@gnt.com.cn")) return false;    
    
	_disabledSubmit(f);
	return true;      
}
*/
function of_Validator_Disabled(f){    
	f.delete_button.disabled="true";
    if(confirm("��ȷ��Ҫɾ����")){        
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
    if(IdCardNo.length==0)return true;//���֤��δ��ʱ��������
    
    //���֤���������
    var vBirth=Birth.substring(0,4)+Birth.substring(5,7)+Birth.substring(8,10);

    if((!checkIDCardBirth(IdCardNo,vBirth))|(!checkIDCardSex(IdCardNo,Sex))){
        if(!confirm("���Ƿ�Ҫ�������֤��������Ŀ�Ĳ�ƥ��? ")) return false;
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


//���¸�jccode��ֵ
function initJcCode(name,value){ 
  var jcobj = document.getElementById("jccode_"+name);
  if(jcobj){
  	jcobj.SelectedCode = value;// 
	jcobj.initAgainBySelectedCode(0);//
   }
}

//�����ֵ�code���Ա��ֵ�ؼ��������ֵ�
function getJCCodeName(code,codetype){
	return document.all.jccode_dmXb.transValueToName(code,codetype);
}
//��ȡ�����������
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
/*****ƴװ�������������
����������{����},{�Ա�},{��������}�������䣺{����}�꣩,�������֤��ţ�{���֤���},{����},
�������ڵ�Ϊ{��������}{������ϸ��ַ},��ס{��סַ����}{��סַ��ַ},{������λΪ{������λ}��
{�Ļ��̶�}��{����}
*/
function getFzxyrQk(obj){
	if(obj.value==""||trimStr(obj.value)==""){
		var xyrqk = "����������";
		//����	
		if(document.all.xm.value!="") xyrqk+=(document.all.xm.value);
		//�Ա�
		if(document.all.dmXb.value!="") xyrqk+=("��"+getJCCodeName(document.all.dmXb.value,"XB"));
		
		var nl;//
		//��������
		if(document.all.csrq1.value!=""){
			 xyrqk+=("��"+document.all.csrq1.value+"����");
			 nl = getXyrNlBySr(document.all.csrq1.value);
		}else{
			nl="";	
		}
		//����
		if(document.all.nl&&document.all.nl.value!=""){
			 xyrqk+=("�����䣺"+document.all.nl.value+"�꣩");
		}else{
			if(nl!=""){
				xyrqk+=("�����䣺"+nl+"�꣩");	
			}	
		}
		
		//���֤��
		if(document.all.sfzh.value!="") xyrqk+=("���������֤��ţ�"+document.all.sfzh.value);
		//����
		if(document.all.dmMz.value!="") xyrqk+=("��"+getJCCodeName(document.all.dmMz.value,"MZ"));
		//��������
		if(document.all.dmXzqhHj.value!="") xyrqk+=("���������ڵ�Ϊ"+getJCCodeName(document.all.dmXzqhHj.value,"XZQH"));
		//������ַ
		if(document.all.xxdzHj.value!="") xyrqk+=(document.all.xxdzHj.value);
		//��������
		if(document.all.dmXzqhZj.value!="") xyrqk+=("����ס"+getJCCodeName(document.all.dmXzqhZj.value,"XZQH"));
		//������ַ
		if(document.all.xxdzZj.value!="") xyrqk+=(document.all.xxdzZj.value);
		//������λ
		if(document.all.gzdw.value!="") xyrqk+=("��������λΪ"+document.all.gzdw.value);
		//�Ļ��̶�
		if(document.all.dmWhcd.value!="") xyrqk+=("��"+getJCCodeName(document.all.dmWhcd.value,"WHCD"));
		xyrqk+="��";
		//����
		if(document.all.jlqk.value!="") xyrqk+=(""+document.all.jlqk.value+"��");
		document.all.xyrqk.value = xyrqk;
	}
}

/*****ƴװΥ�����������
{����}��{�Ա�}��{��������}������{֤�����}��{֤������}����סַ��{��סַ}��������λ��{������λ}��
�����أ�{������}��Υ�������¼��{Υ�������¼}��
*/
function getWfxyrQk(obj){
	if(obj.value==""||trimStr(obj.value)==""){
		var xyrqk = "";
		//����	
		if(document.all.xm.value!="") xyrqk+=(document.all.xm.value);
		//�Ա�
		if(document.all.dmXb.value!="") xyrqk+=("��"+getJCCodeName(document.all.dmXb.value,"XB"));
		//��������
		if(document.all.csrq1.value!="") xyrqk+=("��"+document.all.csrq1.value+"����");
		//���֤��
		if(document.all.sfzh.value!="") xyrqk+=("���������֤��ţ�"+document.all.sfzh.value);
		//��������
		if(document.all.dmXzqhZj.value!="") xyrqk+=("����סַ��"+getJCCodeName(document.all.dmXzqhZj.value,"XZQH"));
		//������ַ
		if(document.all.xxdzZj.value!="") xyrqk+=(document.all.xxdzZj.value);
		//������λ
		if(document.all.gzdw.value!="") xyrqk+=("��������λ��"+document.all.gzdw.value);
		//��������
		if(document.all.dmXzqhHj.value!="") xyrqk+=("�������أ�"+getJCCodeName(document.all.dmXzqhHj.value,"XZQH"));
		//������ַ
		if(document.all.xxdzHj.value!="") xyrqk+=(document.all.xxdzHj.value);
		//����
		if(document.all.jlqk.value!="") xyrqk+=("��Υ�������¼��"+document.all.jlqk.value+"��");
		document.all.xyrqk.value = xyrqk;
	}
}


/*****�ܺ��˼�Ҫ���
{����},{�Ա�},{��������}�������䣺{����}�꣩,�������֤��ţ�{���֤���},{����},
�������ڵ�Ϊ{��������}{������ϸ��ַ},��ס{��סַ����}{��סַ��ַ}, {������λ}+ְҵ��
*/
function getShrQk(obj){
	if(obj.value==""||trimStr(obj.value)==""){
		var xyrqk = "";
		//����	
		if(document.all.xm.value!="") xyrqk+=(document.all.xm.value);
		//�Ա�
		if(document.all.dmXb.value!="") xyrqk+=("��"+getJCCodeName(document.all.dmXb.value,"XB"));
		var nl;//
		//��������
		if(document.all.csrq1.value!=""){
			 xyrqk+=("��"+document.all.csrq1.value+"����");
			 nl = getXyrNlBySr(document.all.csrq1.value);
		}else{
			nl="";	
		}
		//����
		if(document.all.nl&&document.all.nl.value!=""){
			 xyrqk+=("�����䣺"+document.all.nl.value+"�꣩");
		}else{
			if(nl!=""){
				xyrqk+=("�����䣺"+nl+"�꣩");	
			}	
		}
		//���֤��
		if(document.all.sfzh.value!="") xyrqk+=("���������֤��ţ�"+document.all.sfzh.value);
		//����
		if(document.all.dmMz.value!="") xyrqk+=("��"+getJCCodeName(document.all.dmMz.value,"MZ"));
		//��������
		if(document.all.dmXzqhHj.value!="") xyrqk+=("���������ڵ�Ϊ"+getJCCodeName(document.all.dmXzqhHj.value,"XZQH"));
		//������ַ
		if(document.all.xxdzHj.value!="") xyrqk+=(document.all.xxdzHj.value);
		//��������
		if(document.all.dmXzqhZj.value!="") xyrqk+=("����ס"+getJCCodeName(document.all.dmXzqhZj.value,"XZQH"));
		//������ַ
		if(document.all.xxdzZj.value!="") xyrqk+=(document.all.xxdzZj.value);
		//������λ
		if(document.all.gzdw.value!="") xyrqk+=("��"+document.all.gzdw.value);
		//ְҵ
		if(document.all.dmZy.value!="") xyrqk+=("��"+document.all.dmZy.value+"��");
		document.all.xyrqk.value = xyrqk;
	}
}

/*****������Ա��Ҫ���
{����},{�Ա�},{��������}�������䣺{����}�꣩,�������֤��ţ�{���֤���},
��ס{��סַ����}{��סַ��ַ}, {������λ}+ְҵ��
*/
function getQtryQk(obj){
	if(obj.value==""||trimStr(obj.value)==""){
		var xyrqk = "";
		//����	
		if(document.all.xm.value!="") xyrqk+=(document.all.xm.value);
		//�Ա�
		if(document.all.dmXb.value!="") xyrqk+=("��"+getJCCodeName(document.all.dmXb.value,"XB"));
		var nl;//
		//��������
		if(document.all.csrq1.value!=""){
			 xyrqk+=("��"+document.all.csrq1.value+"����");
			 nl = getXyrNlBySr(document.all.csrq1.value);
		}else{
			nl="";	
		}
		//����
		if(document.all.nl&&document.all.nl.value!=""){
			 xyrqk+=("�����䣺"+document.all.nl.value+"�꣩");
		}else{
			if(nl!=""){
				xyrqk+=("�����䣺"+nl+"�꣩");	
			}	
		}
		//���֤��
		if(document.all.sfzh.value!="") xyrqk+=("���������֤��ţ�"+document.all.sfzh.value);
		//��������
		if(document.all.dmXzqhZj.value!="") xyrqk+=("����ס"+getJCCodeName(document.all.dmXzqhZj.value,"XZQH"));
		//������ַ
		if(document.all.xxdzZj.value!="") xyrqk+=(document.all.xxdzZj.value);
		//������λ
		if(document.all.gzdw.value!="") xyrqk+=("��"+document.all.gzdw.value);
		//ְҵ
		if(document.all.dmZy.value!="") xyrqk+=("��"+document.all.dmZy.value+"��");
		document.all.xyrqk.value = xyrqk;
	}
}