/**
 * 数据配置Store
 * 
 * pzlb 			配置类别，来自数据配置表
 * pkname		主键字段，必须位于pzlb之中
 * 
 */
Gnt.store.SjpzStore = function(c){
	if(!c.pkname || c.pkname==""){
		alert("必须提供pkname指定主键！");
	}
	
	var pzlb = c.pzlb;
	var ary = Gnt.ux.Dict.getSjpzData(pzlb);
	var items = new Array();
	var ex = false;
	
	if(ary instanceof Array){
		for(var i=0;i<ary.length;i++){
			items.push(Gnt.getRecordField(ary[i], c));
			if(ary[i].fieldname==c.pkname)
				ex = true;
		}
	}else{
		alert("配置" + pzlb + "本地缓存不存在！");
	}
	
	if(!ex){
		alert(c.pkname + "不存在配置" + pzlb + "！");
	}
	
	Gnt.store.SjpzStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id: c.pkname,
			totalProperty:'totalCount',
			fields: items,
			listeners:{
				loadexception:function(mystore,options,response,error){
					if(error){
						var json = Ext.decode(response.responseText);
						if(json.messages)
							Ext.Msg.alert("提示",json.messages[0]);
						else
							Ext.Msg.alert("提示",error.message);
					}else{
						Ext.Msg.alert("提示",response.responseText);
					}
				}
			}
    }));
};
Ext.extend(Gnt.store.SjpzStore, Ext.data.JsonStore);
