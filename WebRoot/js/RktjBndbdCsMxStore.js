/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.RktjBndbdCsMxStore = function(c){
	Gnt.store.RktjBndbdCsMxStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'rynbid',
			totalProperty:'totalCount',
			fields: [
			         	/**
			         		出生人口
			         	 */
			         	"cs.csdjid","cs.rynbid","cs.cszmbh","cs.csdjlb","cs.hjywid","cs.cxbz","cs.cxsj","cs.cxrid","cs.cxhjywid","cs.tbbz"
			         	,"cs.bwbh","cs.sbsj","cs.sbryxm","cs.sbrgmsfhm","cs.slsj","cs.sldw","cs.slrid","cs.ywlx","cs.czsm","cs.hlx","cs.hh"
			         	,"cs.csdxz","cs.xx","cs.hb","cs.csdgjdq","cs.jhryxm","cs.jhrygmsfhm","cs.jhryjhgx","cs.jhrexm","cs.jhregmsfhm"
			         	,"cs.jhrejhgx","cs.fqxm","cs.fqgmsfhm","cs.mqxm","cs.mqgmsfhm","cs.jggjdq","cs.jgssxq","cs.xm","cs.gmsfhm","cs.mz"
			         	,"cs.xb","cs.csrq","cs.cssj","cs.csdssxq","cs.ryid","cs.hhnbid","cs.ssxq","cs.jlx","cs.mlph","cs.mlxz","cs.pcs"
			         	,"cs.zrq","cs.xzjd","cs.jcwh","cs.pxh","cs.mlpnbid","cs.yhzgx","cs.hzxm","cs.hzgmsfhm","cs.hhid","cs.mlpid","cs.sbrjtgx"
						/**
							行政区划
						 */
						,"xzqh.dm","xzqh.mc","xzqh.zwpy","xzqh.wbpy","xzqh.bz","xzqh.qybz","xzqh.bdlx","xzqh.bdsj"
						/**
							门楼牌
						 */
						,"mlp.mlpnbid","mlp.mlpid","mlp.ssxq","mlp.jlx","mlp.mlph","mlp.mlxz","mlp.pcs"
						,"mlp.zrq","mlp.xzjd","mlp.jcwh","mlp.jdlb","mlp.cdlb","mlp.jdsj","mlp.cdsj"
						,"mlp.cjhjywid","mlp.cchjywid","mlp.mlpzt","mlp.lxdbid","mlp.jlbz","mlp.qysj"
						,"mlp.jssj","mlp.pxh","mlp.bzdz","mlp.bzdzid","mlp.bzdzx","mlp.bzdzy","mlp.bzdzst"
						/**
							居委会
						 */
						,"jwh.dm","jwh.mc","jwh.zwpy","jwh.wbpy","jwh.dwdm","jwh.xzjddm"
						,"jwh.bz","jwh.qybz","jwh.bdlx","jwh.bdsj","jwh.cxfldm","jwh.cxflmc"
						,"jwh.tjdm","jwh.tjmc","jwh.dwdm_name","jwh.xzjddm_name","jwh.dwdm_bz"
						/**
							单位
						 */
						,"dw.dm","dw.mc","dw.zwpy","dw.wbpy","dw.dwjgdm","dw.qhdm","dw.dwjb"
						,"dw.bz","dw.qybz","dw.bdlx","dw.bdsj","dw.fjjgdm","dw.fjjgmc"
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
Ext.extend(Gnt.store.RktjBndbdCsMxStore, Ext.data.JsonStore);
