var wplist=new Array();
var wpcolsize=6;
function creatQdmc(){
	 xm="";
	 if(document.formwpqd.bcfrxm!=null&&document.formwpqd.bcfrxm.value!=null)xm=document.formwpqd.bcfrxm.value;
	if(document.formwpqd.qdmc.value==null||document.formwpqd.qdmc.value==''){
		if(document.formwpqd.ywlx.value=='CYQZZJQD'){//抽样取证证据清单
			document.formwpqd.qdmc.value="对"+xm+"抽样取证清单";
		}
		else if(document.formwpqd.ywlx.value=="XXDJBCZJQD"){//先行登记保存证据清单
			document.formwpqd.qdmc.value="对"+xm+"先行登记保存证据清单";
		}else if(document.formwpqd.ywlx.value=="DQZJQD"){//调取证据清单
			document.formwpqd.qdmc.value="对"+xm+"调取证据清单";
		}else if(document.formwpqd.ywlx.value=="THKYYJDBQD"){//退回扣押邮件、电报清单
			document.formwpqd.qdmc.value="对"+xm+"退回扣押邮件、电报清单";	
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
	str=str	+"<td>序号</td>";
	str=str +"<td >名称</td>";
	if(wpcolsize==6){
		str=str +" <td>规格</td>";
	}
	str=str +" <td>数量</td>";
	str=str +" <td >特征</td>";
	str=str +" <td >备注</td>";
	str=str +" <td >操作</td>";
	str=str	+"</tr>";
	document.formwpqd.wplength.value=wplist.length;
	for(var i=0;i<wplist.length;i++){
		str=str+"<tr height='25'><td class='TD2'>"+(i+1)+"<input type='hidden' name='xh_"+(i+1)+"' value='"+wplist[i].id+"' ></td>";
 		str=str+"<td class='TD2'><input attrib='editor' label='名称"+(i+1)+"' max_length='24' class='input' type='text' name='mc_"+(i+1)+"' value='"+wplist[i].mc+"' onchange='wplist["+i+"].mc=this.value'></td>";
 		if(wpcolsize==6){
			str=str+"<td class='TD2'><input attrib='editor' label='规格"+(i+1)+"' max_length='32' class='input' type='text' name='gg_"+(i+1)+"' value='"+wplist[i].gg+"' size='20' onchange='wplist["+i+"].gg=this.value'></td>";
		}
 		str=str+"<td class='TD2'><input attrib='editor' label='数量"+(i+1)+"' max_length='6' dataType='number' attrib='editor'  class='input' type='text' name='sl_"+(i+1)+"' value='"+wplist[i].sl+"' size='5' onchange='wplist["+i+"].sl=this.value'><input attrib='editor' label='数量单位"+(i+1)+"' class='input' type='text' name='sldw_"+(i+1)+"' value='"+wplist[i].sldw+"' max_length='10' size='8' onchange='wplist["+i+"].sldw=this.value'></td>";
 		str=str+"<td class='TD2'><input attrib='editor' label='特征"+(i+1)+"' max_length='36' class='input' type='text' name='tz_"+(i+1)+"' value='"+wplist[i].tz+"' size='20' onchange='wplist["+i+"].tz=this.value'></td>";
 		str=str+"<td class='TD2'><input attrib='editor' label='备注"+(i+1)+"' max_length='24' class='input' type='text' name='bz_"+(i+1)+"' value='"+wplist[i].bz+"' onchange='wplist["+i+"].bz=this.value'></td>";	
		str=str +" <td class='TD2'><input class='button_light' type='button'  name='delwp"+i+"' value='删除' onclick='delzj("+i+")'></td>";
		str+="</tr>";
	}
	str+="</table> ";	
	tab.innerHTML=str;

	_initElements(tab);	
}