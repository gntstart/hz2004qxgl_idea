/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.KdqHjspywStore = function(c){
	Gnt.store.KdqHjspywStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'rynbid',
			totalProperty:'totalCount',
			fields: [
"ywlsh","postid","zqzbh","sqr_gmsfhm","sqr_xm","sqr_zz_ssxqdm","sqr_zz_qhnxxdz","sqr_hkdjjg_gajgjgdm","sqr_hkdjjg_gajgmc","qcd_ssxqdm","qcd_qhnxxdz","qcd_hkdjjg_gajgjgdm",
"qcd_hkdjjg_gajgmc","qrd_ssxqdm","qrd_qhnxxdz","qrd_hkdjjg_gajgjgdm","qrd_hkdjjg_gajgmc","qfjg_gajgjgdm","qfjg_gajgmc","cbr_xm","qfrq","bz","qyldyydm","yxqjzrq","qyfwdm",
"sldw_gajgjgdm","sldw_gajgmc","slr_xm","slsj","sjgsdwdm","sjgsdwmc","sldw_lxdh","sqr_lxdh","isstatus","sfbj","zxyy","cjsj"],
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
Ext.extend(Gnt.store.KdqHjspywStore, Ext.data.JsonStore);
