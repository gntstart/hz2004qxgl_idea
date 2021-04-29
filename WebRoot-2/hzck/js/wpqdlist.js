var wplist=new Array();
var wpcolsize=6;
var wplbzd="";
var ajmc="";
var xsqdlx=false;
var clqklb="处理情况";
function getMaxlength(lb){
	if(lb=="mc"){
		if(xsqdlx)return 36;
		else return 24;
	}
	if(lb=="bz"){
		if(xsqdlx)return 20;
		else return 24;
	}
	if(lb=="clqk"){
		if(clqklb=="处理情况")return 28;
		else return 24;
	}
}
function creatQdmc(){
	if(document.formwpqd.qdmc.value==null||document.formwpqd.qdmc.value==''){
		if(document.formwpqd.ywlx.value=='XSFHWP'){//发还物品文件清单
			document.formwpqd.qdmc.value="发还"+document.formwpqd.qtr.value+"清单";
		}
		else if(document.formwpqd.ywlx.value=="XSXHWP"){//销毁物品
			document.formwpqd.qdmc.value="销毁";
			if(wplist.length>0)document.formwpqd.qdmc.value+=wplist[0].mc;
			if(wplist.length>1)document.formwpqd.qdmc.value+=","+wplist[1].mc;
			document.formwpqd.qdmc.value+="等物品清单";
		}else if(document.formwpqd.ywlx.value=="XSYJWP"){//移交物品
			document.formwpqd.qdmc.value="移交"+document.formwpqd.jsdw.value+"物品清单";
		}else if(document.formwpqd.ywlx.value=="XSCLWP"){//处理物品
			document.formwpqd.qdmc.value=ajmc+"处理物品清单";	
		}else if(document.formwpqd.ywlx.value=="XSKYWP"){//扣押物品
			var bcfrxm="";
			if(document.formwpqd.bcfrxm)bcfrxm=document.formwpqd.bcfrxm.value;
			document.formwpqd.qdmc.value="对"+bcfrxm+"扣押物品、文件清单";	
		}else if(document.formwpqd.ywlx.value=="MS"){//没收物品 
			var bcfrxm="";
			if(document.formwpqd.bcfrxm)bcfrxm=document.formwpqd.bcfrxm.value;
			document.formwpqd.qdmc.value="没收"+bcfrxm+"物品清单";	
		}else if(document.formwpqd.ywlx.value=="SJZJ"){//对{物品持有人}+收缴/追缴清单
			var bcfrxm="";
			if(document.formwpqd.bcfrxm)bcfrxm=document.formwpqd.bcfrxm.value;
			document.formwpqd.qdmc.value="对"+bcfrxm+"收缴/追缴清单";	
		}else if(document.formwpqd.ywlx.value=="KY"){//对{物品持有人}+收缴/追缴清单
			var bcfrxm="";
			if(document.formwpqd.bcfrxm)bcfrxm=document.formwpqd.bcfrxm.value;
			document.formwpqd.qdmc.value="对"+bcfrxm+"扣押清单";	
		}
	}
}
function xzwp(id,xh,mc,tz,bz,sl,sldw,wply,clqk,gg){
	this.id=id;
	this.xh=xh;
	this.mc=mc;
	this.tz=tz;
	this.bz=bz;
	this.sl=sl;
	this.sldw=sldw;
	this.wply=wply;
	this.clqk=clqk;
	this.gg=gg;
}
function docheckwp(index){
	
 	if(document.formwpqd['c'+index].checked){
 		var id=document.formwpqd['c'+index].value;
		var xh=wplist.length;
		var mc=document.formwpqd['cmc_'+index].value;
		var tz=document.formwpqd['ctz_'+index].value;
		var bz=document.formwpqd['cbz_'+index].value;
		var sl=document.formwpqd['csl_'+index].value;
		var gg="";
		if(document.formwpqd['cgg_'+index])gg=document.formwpqd['cgg_'+index].value;
		var sldw="";
		if(document.formwpqd['csldw_'+index])sldw=document.formwpqd['csldw_'+index].value;
		var wply="";
		if(document.formwpqd['cwply_'+index])wply=document.formwpqd['cwply_'+index].value;
		var clqk="";
		if(document.formwpqd['cclqk_'+index])clqk=document.formwpqd['cclqk_'+index].value; 
 		var tem=new xzwp(id,xh,mc,tz,bz,sl,sldw,wply,clqk,gg);
		wplist[wplist.length]=tem;
 	}else{
		for(var i=0;i<wplist.length;i++){
			if( wplist[i].id==document.formwpqd['c'+index].value){
				wplist.splice(i,1);
				break;
			}
		}
 	}
 	writetable();

}
function writetable(){
	
	var tab=document.getElementById('xzwplb');
	var str="<table width='102%' border='0' cellspacing='1'  class='GNTTD' >";
	str=str	+"<tr class='TD2'>";
	str=str +"<td colspan='"+wpcolsize+"' width='70%'>已选物品列表</td>";
	str=str	+"</tr>";
	str=str	+" <tr class='TD3'>";
	str=str	+"<td>序号</td>";
	str=str +"<td >名称</td>";
	if(wpcolsize<=6&&!xsqdlx){
		str=str +" <td>规格</td>";
	}
	str=str +" <td>数量</td>";
	str=str +" <td >特征</td>";
	if(wpcolsize!=5||xsqdlx){
		if(document.formwpqd.ywlx.value!="XSCLWP")
		str=str +" <td >备注</td>";
	}
	str=str+wplbzd;
	str=str	+"</tr>";
	document.formwpqd.wplength.value=wplist.length;
	for(var i=0;i<wplist.length;i++){
		wplist[i].xh=i;
		str=str+"<tr height='25'><td class='TD2'>"+(i+1)+"<input type='hidden' name='xh_"+(i+1)+"' value='"+wplist[i].id+"' ></td>";
 		str=str+"<td class='TD2'><input attrib='editor' label='名称"+(i+1)+"' max_length='"+getMaxlength('mc')+"' class='input' type='text' name='mc_"+(i+1)+"' value='"+wplist[i].mc+"' onchange='wplist["+i+"].mc=this.value'></td>";
 		if(wpcolsize<=6&&!xsqdlx){
			str=str+"<td class='TD2'><input attrib='editor' max_length='32' label='规格"+(i+1)+"' class='input' type='text' name='gg_"+(i+1)+"' value='"+wplist[i].gg+"' size='20' onchange='wplist["+i+"].gg=this.value'></td>";
		}
 		str=str+"<td class='TD2'><input attrib='editor' label='数量"+(i+1)+"' max_length='6' dataType='number' attrib='editor'  class='input' type='text' name='sl_"+(i+1)+"' value='"+wplist[i].sl+"' size='5' onchange='wplist["+i+"].sl=this.value'><input attrib='editor' label='数量单位"+(i+1)+"' class='input' type='text' name='sldw_"+(i+1)+"' value='"+wplist[i].sldw+"' max_length='10' size='8' onchange='wplist["+i+"].sldw=this.value'></td>";
 		str=str+"<td class='TD2'><input attrib='editor' label='特征"+(i+1)+"' max_length='36' class='input' type='text' name='tz_"+(i+1)+"' value='"+wplist[i].tz+"' size='20' onchange='wplist["+i+"].tz=this.value'></td>";
 		if(wpcolsize!=5||xsqdlx){
 		 if(document.formwpqd.ywlx.value!="XSCLWP")
 			str=str+"<td class='TD2'><input attrib='editor' label='备注"+(i+1)+"' max_length='"+getMaxlength('bz')+"' class='input' type='text' name='bz_"+(i+1)+"' value='"+wplist[i].bz+"' onchange='wplist["+i+"].bz=this.value'></td>";	
		}
		if(wpcolsize==7||document.formwpqd.ywlx.value=="XSCLWP"){
			str=str+"<td class='TD2'><input attrib='editor' label='物品来源"+(i+1)+"' max_length='24' class='input' type='text' name='wply_"+(i+1)+"' value='"+wplist[i].wply+"' size='20' onchange='wplist["+i+"].wply=this.value'></td>";
 			str=str+"<td class='TD2'><input attrib='editor' label='"+clqklb+(i+1)+"' max_length='"+getMaxlength('clqk')+"' class='input' type='text' name='clqk_"+(i+1)+"' value='"+wplist[i].clqk+"' onchange='wplist["+i+"].clqk=this.value'></td>";	
		}
		str+="</tr>";
	}
	str+="</table> ";	
	tab.innerHTML=str;
	_initElements(tab);	

}