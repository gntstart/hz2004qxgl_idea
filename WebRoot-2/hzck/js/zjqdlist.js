var wplist=new Array();
var wpcolsize=6;
function creatQdmc(){
	 xm="";
	 if(document.formwpqd.bcfrxm!=null&&document.formwpqd.bcfrxm.value!=null)xm=document.formwpqd.bcfrxm.value;
	if(document.formwpqd.qdmc.value==null||document.formwpqd.qdmc.value==''){
		if(document.formwpqd.ywlx.value=='CYQZZJQD'){//����ȡ֤֤���嵥
			document.formwpqd.qdmc.value="��"+xm+"����ȡ֤�嵥";
		}
		else if(document.formwpqd.ywlx.value=="XXDJBCZJQD"){//���еǼǱ���֤���嵥
			document.formwpqd.qdmc.value="��"+xm+"���еǼǱ���֤���嵥";
		}else if(document.formwpqd.ywlx.value=="DQZJQD"){//��ȡ֤���嵥
			document.formwpqd.qdmc.value="��"+xm+"��ȡ֤���嵥";
		}else if(document.formwpqd.ywlx.value=="THKYYJDBQD"){//�˻ؿ�Ѻ�ʼ����籨�嵥
			document.formwpqd.qdmc.value="��"+xm+"�˻ؿ�Ѻ�ʼ����籨�嵥";	
		}
	}
}
function xzwp(xh,mc,tz,bz,sl,sldw,gg,id){
	this.xh=xh;
	this.mc=mc;
	this.tz=tz;
	this.bz=bz;
	this.sl=sl;
	this.sldw=sldw;
	this.gg=gg;
	this.id=id;
}
function addzj(){
	var tem=new xzwp(wplist.length,'','','','','','','-1');
	wplist[wplist.length]=tem;
 	writetable();

}
function delzj(xh){
	wplist.splice(xh,1);
 	writetable();

}
function writetable(){
	
	var tab=document.getElementById('xzwplb');
	var str="<table width='100%' border='0' cellspacing='1'  class='GNTTD' >";
	str=str	+" <tr class='TD3'>";
	str=str	+"<td>���</td>";
	str=str +"<td >����</td>";
	if(wpcolsize==6){
		str=str +" <td>���</td>";
	}
	str=str +" <td>����</td>";
	str=str +" <td >����</td>";
	str=str +" <td >��ע</td>";
	str=str +" <td >����</td>";
	str=str	+"</tr>";
	document.formwpqd.wplength.value=wplist.length;
	for(var i=0;i<wplist.length;i++){
		str=str+"<tr height='25'><td class='TD2'>"+(i+1)+"<input type='hidden' name='xh_"+(i+1)+"' value='"+wplist[i].id+"' ></td>";
 		str=str+"<td class='TD2'><input attrib='editor' label='����"+(i+1)+"' max_length='24' class='input' type='text' name='mc_"+(i+1)+"' value='"+wplist[i].mc+"' onchange='wplist["+i+"].mc=this.value'></td>";
 		if(wpcolsize==6){
			str=str+"<td class='TD2'><input attrib='editor' label='���"+(i+1)+"' max_length='32' class='input' type='text' name='gg_"+(i+1)+"' value='"+wplist[i].gg+"' size='20' onchange='wplist["+i+"].gg=this.value'></td>";
		}
 		str=str+"<td class='TD2'><input attrib='editor' label='����"+(i+1)+"' max_length='6' dataType='number' attrib='editor'  class='input' type='text' name='sl_"+(i+1)+"' value='"+wplist[i].sl+"' size='5' onchange='wplist["+i+"].sl=this.value'><input attrib='editor' label='������λ"+(i+1)+"' class='input' type='text' name='sldw_"+(i+1)+"' value='"+wplist[i].sldw+"' max_length='10' size='8' onchange='wplist["+i+"].sldw=this.value'></td>";
 		str=str+"<td class='TD2'><input attrib='editor' label='����"+(i+1)+"' max_length='36' class='input' type='text' name='tz_"+(i+1)+"' value='"+wplist[i].tz+"' size='20' onchange='wplist["+i+"].tz=this.value'></td>";
 		str=str+"<td class='TD2'><input attrib='editor' label='��ע"+(i+1)+"' max_length='24' class='input' type='text' name='bz_"+(i+1)+"' value='"+wplist[i].bz+"' onchange='wplist["+i+"].bz=this.value'></td>";	
		str=str +" <td class='TD2'><input class='button_light' type='button'  name='delwp"+i+"' value='ɾ��' onclick='delzj("+i+")'></td>";
		str+="</tr>";
	}
	str+="</table> ";	
	tab.innerHTML=str;

	_initElements(tab);	
}