var ops_nr=new Array();
ops_nr['clob']='7,9,10,13';
ops_nr['date']='0,1,2,3,4,5,6,9,10';  
ops_nr['datetime']='0,1,2,3,4,5,6,9,10';  
ops_nr['number']='0,1,2,3,4,5,6,9,10';  
ops_nr['r_datetime']='0,1,2,3,4,5,6,9,10';  
ops_nr['string']='0,1,2,3,4,5,6,7,8,9,10,11,12,13';
ops_nr['zd']='0,9,10,11,12';
ops_nr['zdstr']='0,5,7,8,9,10,13';

function lbtm(lb,ar,xh,ljgx){
	this.xh=xh;
	this.lb=lb;
	this.ar=ar;
	this.ljgx=ljgx;
	
	this.clone=function(){
		return new lbtm(this.lb,new Array(),this.xh,this.ljgx); 	
	}
	return this;
}
function cbazd(node,id,name,mc,type,zd,tabname,lb,isline,visiontype){//记录左边的一个字段信息
	this.id=id;
	this.name=name;
	this.mc=mc;
	this.type=type;
	this.zd=zd;
	this.tabname=tabname;
	this.isline=isline;
	this.lb=lb;
	if(visiontype!=null)
	 this.visiontype=visiontype;
	else
	 this.visiontype=zd;	 
	//this.node=node;
	if(node!=null)
	  node.add(mc,"ball1").obj=this;
	
	this.clone=function(){
		return new cbazd(null,this.id,this.name,this.mc,this.type,this.zd,this.tabname,this.lb,this.isline,this.visiontype); 	
	}
	return this;
}
function jgzd(cbazd){
	this.cbazd=cbazd;
	this.sorttype=0;//0不排序，1顺序，2逆序
	}
function cxtj(cbazd){//对象,用于记录一个表达式
	this.clone=function(){
		var rt=new cxtj(cbazd.clone());
		rt.op=this.op;
		rt.value=this.value; 
		rt.xsvalue=this.xsvalue
		rt.request=this.request
		rt.power=this.power; 
		rt.group=this.group; 
		rt.cpvalue=this.cpvalue
		rt.value1=this.value1;
		rt.readonly=this.readonly;
		return rt; 	
	}
	this.cbazd=cbazd;
	this.op="";
	this.value="";
	this.xsvalue="";
	this.request=true;
	this.power=1;
	this.group=0;
	this.cpvalue="";
	this.value1="";
	//zlong -- 20060706 默认条件不能修改
	this.readonly=false;
	//zlong --end
	this.getValue=function(){
		if(this.value==null)return "";
		else return this.value;
	}
	this.getOp=function(lb,i,index,nn){
		var ro="";
		
		var rt= "<SELECT   name='"+nn+"_op' onblur='updateop(\""+lb+"\","+i+","+index+",this.value)'>";
		var _setd;
		var _setdpyty='';
		if(this.op==""){
			if(this.cbazd.type=="clob"||this.cbazd.type=="string"||this.cbazd.type=="zdstr")this.op="like";
			else if(this.cbazd.type=="zd")this.op="in";
			else this.op="between";
			
		}
		 
		var temop=ops_nr[this.cbazd.type].split(",");
		for(i=0;i<temop.length;i++){
			if(this.readonly){
				if(ops[temop[i]][0]==this.op){
					_setd=" selected ";
					rt+="<OPTION "+_setd+" VALUE='"+ops[temop[i]][0]+"'>"+ops[temop[i]][1]+"</option>";
				}
			}else{
				if(ops[temop[i]][0]==this.op)_setd=" selected ";
				else _setd="";
				rt+="<OPTION "+_setd+" VALUE='"+ops[temop[i]][0]+"'>"+ops[temop[i]][1]+"</option>";
			}
		}
		if('pyty'==this.op)_setdpyty=' selected ';
		if(this.cbazd.isline=='4')rt+="<OPTION "+_setdpyty+" VALUE='"+ops[14][0]+"'>"+ops[14][1]+"</option>";
		rt+="</SELECT>";
		return rt;	
	}
	this.getText=function(lb,i,index,nn){
		var tt="";
		var ro="";
		size=55;
		if(this.readonly)ro=" readonly='true' ";
		if(this.cbazd.type=="zd"||this.cbazd.type=="zdstr"){
			if(this.readonly==false){
				tt="<span onchangefun='updatevalue(\""+lb+"\","+i+","+index+",this.value)' width='250'  attrib='jccode' oldshow='1' output_field='"+nn+"_value' output_codename='"+nn+"_xsvalue' rootcode='"+this.cbazd.zd+"' visiontype='"+this.cbazd.visiontype+"' multiselect='1' showtype='1' selectedcode='"+this.value+"' ></span>";
				tt+="<input  type='hidden' name='"+nn+"_xsvalue' size='"+size+"' value='"+this.xsvalue+"' attrib='editor' >";	
				tt+="<input type='hidden' name='"+nn+"_value' size='30%' value='"+this.value+"' attrib='editor'  >";
			}else{
				tt="<input readonly='true'  type='text' name='"+nn+"_xsvalue' size='55' value='"+this.xsvalue+"' attrib='editor'  >";	
				tt+="<input type='hidden' name='"+nn+"_value' size='30%' value='"+this.value+"' attrib='editor' >";
			}	
		}
		else{
			if(this.cbazd.type=="number")tt="dataType='number'";
			if(this.cbazd.type=="date")tt="dataType='date' dropdown_mode='date' autoDropDown='true'";
			if(this.cbazd.type=="datetime"||this.cbazd.type=="r_datetime")tt="dataType='datetime' dropdown_mode='date' autoDropDown='true' ";
			var _15to18="";
			if("身份证号"==this.cbazd.mc){
				_15to18="javascript:if((this.value).length==15){this.value=id15to18(this.value); }";
			}
			
			if(this.op=="between")size=25;
			if(this.cbazd.isline=='3')size=25;
			tt="<input "+ro+"   type='text' name='"+nn+"_xsvalue' size='"+size+"' value='"+this.xsvalue+"' attrib='editor'  "+tt+" class='input' onblur='"+_15to18+"updatevalue(\""+lb+"\","+i+","+index+",this.value)'>";	
			tt+="<input type='hidden' name='"+nn+"_value' size='30%' value='"+this.value+"' attrib='editor' >";
			tt+="<input type='hidden' name='"+nn+"_cpvalue' size='30%' value='"+this.cpvalue+"' attrib='editor' >";
			if(this.op=="between"){
				var tt1="";
				if(this.cbazd.type=="number")tt1="dataType='number'";
				if(this.cbazd.type=="date")tt1="dataType='date' dropdown_mode='date' autoDropDown='true'";
				if(this.cbazd.type=="datetime"||this.cbazd.type=="r_datetime")tt1="dataType='datetime' dropdown_mode='date' autoDropDown='true' ";
				tt1="<input "+ro+" type='text' "+tt1+" name='"+nn+"_value1' size='25' value='"+this.value1+"' attrib='editor' class='input' onblur='updatevalue(\""+lb+"\","+i+","+index+",this.value,\"true\")'>";
				tt+=" ~ "+tt1;
			}
			
		}
		if(this.cbazd.isline=='3')
			   	tt+="&nbsp;组:<input type='text' name='"+nn+"_group' size='5' value='"+this.group+"' attrib='editor' dataType='number'  class='input' onblur='updategroup(\""+lb+"\","+i+","+index+",this.value)'>";
		return tt;
		}

	this.getDel=function(lb,i,index){
		if(this.readonly) return "";
		else
			return "<INPUT TYPE='button' class='button_light' value='删除' onclick='deletecba(\""+lb+"\","+i+","+index+")'>";	
	}
	this.getTr=function(lb,i,index,rec){
		nn=rec.xh;
		nn+="_"+index;
		return "<td class='TD2' width='15%'>"
		+this.cbazd.mc+"<input type='hidden' name='"+nn+"_id' value='"+this.cbazd.id+"'><input type='hidden' name='"+nn+"_name' value='"+this.cbazd.name+"'></td><td class='TD2' width='15%'>"
		+this.getOp(lb,i,index,nn)
		+"</td ><td class='TD2' width='60%'>"
		+this.getText(lb,i,index,nn)
		+"</td ><td class='TD2' width='10%'>"+this.getDel(lb,i,index)+"</td>"
		+"<input type='hidden'  name='"+nn+"_index' value='"+tj_index+"'  >";
	}
	this.getTrjd=function(lb,i,index,rec){
		nn=rec.xh;
		nn+="_"+index;
		rt="<td class='TD2' width='12%'>"
		+this.cbazd.mc+"<input type='hidden' name='"+nn+"_id' value='"+this.cbazd.id+"'><input type='hidden' name='"+nn+"_name' value='"+this.cbazd.name+"'>"
		+"<input type='hidden' name='"+nn+"_op' value='"+this.op+"'>"
		+"</td ><td class='TD2' width='38%'>"
		+this.getText(lb,i,index,nn)
		+"</td >"
		+"<input type='hidden'  name='"+nn+"_index' value='"+tj_index+"'  >";
		return rt;
	}
	return this;
}
function openurl(url){
 window.open(url);	
}