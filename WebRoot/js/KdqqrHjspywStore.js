/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.KdqqrHjspywStore = function(c){
	Gnt.store.KdqqrHjspywStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'spywid',
			totalProperty:'totalCount',
			fields: [
"ywlsh","qyzbh","czr_gmsfhm","czr_xm","yzz_ssxqdm","yzz_qhnxxdz","yzz_cxfldm","qwd_ssxqdm","qwd_qhnxxdz","qfjg_gajgjgdm","qfjg_gajgmc","qfrq",
"yxqjzrq","cbr_xm","bz","zqzbh","qyfwdm","sldw_gajgjgdm","sldw_gajgmc","slr_xm","slsj","sjgsdwdm","sjgsdwmc","isstatus","hkdjpcs","sfbj","cjsj"],
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
Ext.extend(Gnt.store.KdqqrHjspywStore, Ext.data.JsonStore);
