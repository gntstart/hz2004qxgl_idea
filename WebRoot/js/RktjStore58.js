/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.Rktj58Store = function(c){
	Gnt.store.Rktj58Store.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'rynbid',
			totalProperty:'totalCount',
			fields: [
			         	"code","a1","a2Str","a3Str","a4Str","a5Str","a6Str","a7Str","a8Str","a9Str","a10Str"
			         	,"a11Str","a12Str","a13Str","a14Str","a15Str","a16Str","a17Str","a18Str","a19Str","a20Str"
			         	,"a21Str","a22Str","a23Str","a24Str","a25Str","a26Str","a27Str","a28Str","a29Str","a30Str"
			         	,"a31Str","a32Str","a33Str","a34Str","a35Str","a36Str","a37Str","a38Str","a39Str","a40Str"
			         	,"a41Str","a42Str","a43Str","a44Str","a45Str","a46Str"
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
Ext.extend(Gnt.store.Rktj58Store, Ext.data.JsonStore);
