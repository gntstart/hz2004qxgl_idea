/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.RktjBndbdQcMxStore = function(c){
	Gnt.store.RktjBndbdQcMxStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'rynbid',
			totalProperty:'totalCount',
			fields: [
			         	/**
			         		迁出人口
			         	 */
			         	"qc.qczxid","qc.rynbid","qc.qclb","qc.qcrq","qc.qwdgjdq","qc.qwdssxq","qc.qwdpcs","qc.qwdxzjd","qc.qwdjwh"
			         	,"qc.qwdjlx","qc.qwdjwzrq","qc.qwdmlph","qc.qwdxz","qc.qyzbh","qc.zqzbh","qc.bdfw","qc.hjywid","qc.cxbz"
			         	,"qc.cxsj","qc.cxrid","qc.cxhjywid","qc.tbbz","qc.bwbh","qc.sbsj","qc.sbryxm","qc.sbrgmsfhm","qc.slsj"
			         	,"qc.sldw","qc.slrid","qc.ywlx","qc.czsm","qc.hhid","qc.xm","qc.gmsfhm","qc.mz","qc.xb","qc.csrq","qc.cssj"
			         	,"qc.csdssxq","qc.ryid","qc.hhnbid","qc.ssxq","qc.jlx","qc.mlph","qc.mlxz","qc.pcs","qc.zrq","qc.xzjd","qc.jcwh"
			         	,"qc.pxh","qc.mlpnbid","qc.hb","qc.yhzgx","qc.hzxm","qc.hzgmsfhm","qc.mlpid","qc.bz","qc.sbrjtgx","qc.ydblbs"
			         	,"qc.qhtzbs","qc.zqzhyxx","qc.cxfldm","qc.kdqqy_cgbz","qc.kdqqy_qrdqbm","qc.kdqqy_dqbm","qc.kdqqy_yhid","qc.kdqqy_yhm"
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
Ext.extend(Gnt.store.RktjBndbdQcMxStore, Ext.data.JsonStore);
