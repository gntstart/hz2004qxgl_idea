var wmstGls = new Array();

function wmstObj(wmstid,bh,bw,xb,ryId){
	this.wmstid=wmstid;
	this.bw=bw;
	this.bh=bh;
	this.xb=xb;
	this.ryId=ryId;
}

//-----------方法----------
function writeWmst(){
	var content = "";
	if(wmstGls.length>0){
		content="<table bgcolor=\"#618DBE\" width=\"100%\" border=\"0\" cellspacing=\"1\">";
		content += writeWmstHead();
		content += writeWmstContent();
		content+="</table>";
	}
	CONTAIN_WMSTGL.innerHTML=content;
}

function writeWmstHead(){
	var str="";
	str+="<tr class=\"TD3\">";
	str+="<td width=\"25%\">编号</td>";
	str+="<td width=\"25%\">尸体部位</td>";
	str+="<td width=\"25%\">性别</td>";
	str+="<td width=\"25%\"></td>";
	str+="</tr>";
	
	return str;
}

function writeWmstContent(){
	var str="";
	for(var i=0;i<wmstGls.length;i++){
		str += "<tr class=\"TD2\">";
		str += "<td>"+"<a href=\"#\" onclick=\"ViewDetail('queryRenyuanDetail.jsp?command=query&clientcontrol=false&rylb=wmst&ryId="+wmstGls[i].ryId+"');\">"+wmstGls[i].bh+"</a>";
		str += "<input type='hidden' name='wmstid' value='"+wmstGls[i].wmstid+"'/>";
		str += "</td>";
		str += "<td>"+wmstGls[i].bw+"</td>";
		str += "<td>"+wmstGls[i].xb+"</td>";
		str += "<td>"+"<input type='button' name='btn_del' value='删除' class='button_light' onclick='deleteWmst("+i+")';>"+"</td>";
		str += "</tr>";
	}

	return str;
}

function addWmst(wmstid,bh,bw,xb,ryId){
	wmstGls.splice(wmstGls.length,0,new wmstObj(wmstid,bh,bw,xb,ryId));
	writeWmst();
}

function deleteWmst(num){
	wmstGls.splice(num,1);
	writeWmst();
}

function initWmstGls(){
	wmstGls = new Array();
}