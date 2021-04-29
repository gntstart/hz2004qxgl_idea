/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.YwpmMxStore = function(c){
	Gnt.store.YwpmMxStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'id',
			totalProperty:'totalCount',
			fields: [
			         	"dsdm","dsmc","pcsdm","pcsmc","ywsl","ywfl","tjsj","xq"
			         ],
			listeners:{
				loadexception:function(mystore,options,response,error){
					if(error){
						var json = Ext.decode(response.responseText);
						if(json.messages){
							Ext.Msg.alert("提示",json.messages[0]);
						}else{
							Ext.Msg.alert("提示",error.message);
						}
					}else{
						Ext.Msg.alert("提示",response.responseText);
					}
					
					if(this.error_callback){
						this.error_callback(mystore);
					}
				},
				load:function(mystore,res){
					if(this.success_callback){
						this.success_callback(mystore, res);
					}
				}
			}
    }));
};
Ext.extend(Gnt.store.YwpmMxStore, Ext.data.JsonStore);
