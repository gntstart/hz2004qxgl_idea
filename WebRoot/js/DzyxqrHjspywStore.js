/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.DzyxqrHjspywStore = function(c){
	Gnt.store.DzyxqrHjspywStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'spywid',
			totalProperty:'totalCount',
			fields: [
"zqid","zjbh","sqrgmsfhm","sqrxm","sqrzzssxq","sqrzzxz","sqrhkdjjg","qrdssxq","qrdxz","qrdhkdjjg","zqyy","pzjg",
"cbr","qfrq","qcbldw","qcbldwdm","qcblsj","qcblr","yxqjzrq","isstatus","dsgxsj","qyrxm1","qyrxm2","qyrxm3",
"qyrxm4","qyrxb1","qyrxb2","qyrxb3","qyrxb4","qyrgmsfhm1","qyrgmsfhm2","qyrgmsfhm3","qyrgmsfhm4","qyrysqrgx1",
"qyrysqrgx2","qyrysqrgx3","qyrysqrgx4","sfqyz","qyzbh","sfbj","qyrzzssxq","qyrhkdjjg","sfcsjtb","qyyy","qyrzzxz","spywid","qyrcsrq1"/**/],
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
Ext.extend(Gnt.store.DzyxqrHjspywStore, Ext.data.JsonStore);
