/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.RktjBndbdSwMxStore = function(c){
	Gnt.store.RktjBndbdSwMxStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'rynbid',
			totalProperty:'totalCount',
			fields: [
			         	/**
			         		死亡人口
			         	 */
			         	"sw.swzxid","sw.rynbid","sw.swrq","sw.swnl","sw.swzmbh","sw.swzxlb","sw.hjywid","sw.cxbz","sw.cxsj"
			         	,"sw.cxrid","sw.cxhjywid","sw.tbbz","sw.bwbh","sw.sbsj","sw.sbryxm","sw.sbrgmsfhm","sw.slsj","sw.sldw"
			         	,"sw.slrid","sw.ywlx","sw.czsm","sw.xm","sw.gmsfhm","sw.mz","sw.xb","sw.csrq","sw.cssj","sw.csdssxq"
			         	,"sw.ryid","sw.hhnbid","sw.ssxq","sw.jlx","sw.mlph","sw.mlxz","sw.pcs","sw.zrq","sw.xzjd","sw.jcwh"
			         	,"sw.pxh","sw.mlpnbid","sw.hb","sw.yhzgx","sw.hzxm","sw.hzgmsfhm","sw.hhid","sw.mlpid","sw.sbrjtgx","sw.swyy"
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
Ext.extend(Gnt.store.RktjBndbdSwMxStore, Ext.data.JsonStore);
