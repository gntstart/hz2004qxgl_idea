/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.RktjBndbdQrMxStore = function(c){
	Gnt.store.RktjBndbdQrMxStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'rynbid',
			totalProperty:'totalCount',
			fields: [
			         	/**
			         		迁入人口
			         	 */
			         	"qr.qrdjid","qr.rynbid","qr.qrqhb","qr.qrlb","qr.qrrq","qr.qcdgjdq","qr.qcdssxq","qr.qcdpcs","qr.qcdxzjd"
			         	,"qr.qcdjwh","qr.qcdjlx","qr.qcdjwzrq","qr.qcdmlph","qr.qcdxz","qr.qyzbh","qr.zqzbh","qr.nbsfzid","qr.bdfw"
			         	,"qr.hjywid","qr.cxbz","qr.cxsj","qr.cxrid","qr.cxhjywid","qr.tbbz","qr.bwbh","qr.sbsj","qr.sbryxm","qr.sbrgmsfhm"
			         	,"qr.slsj","qr.sldw","qr.slrid","qr.ywlx","qr.czsm","qr.hb","qr.jhryxm","qr.jhrygmsfhm","qr.jhryjhgx","qr.jhrexm"
			         	,"qr.jhregmsfhm","qr.jhrejhgx","qr.fqxm","qr.fqgmsfhm","qr.mqxm","qr.mqgmsfhm","qr.poxm","qr.pogmsfhm","qr.jggjdq"
			         	,"qr.jgssxq","qr.zjxy","qr.whcd","qr.hyzk","qr.byzk","qr.sg","qr.xx","qr.zy","qr.zylb","qr.fwcs","qr.xxjb"
			         	,"qr.zjlb","qr.qfjg","qr.yxqxqsrq","qr.yxqxjzrq","qr.dhhm","qr.qtssxq","qr.bz","qr.qtzz","qr.csdxz","qr.csdgjdq"
			         	,"qr.xm","qr.cym","qr.gmsfhm","qr.mz","qr.xb","qr.csrq","qr.cssj","qr.csdssxq","qr.ryid","qr.hhnbid","qr.ssxq"
			         	,"qr.jlx","qr.mlph","qr.mlxz","qr.pcs","qr.zrq","qr.xzjd","qr.jcwh","qr.pxh","qr.mlpnbid","qr.yhzgx","qr.hhid"
			         	,"qr.mlpid","qr.hzxm","qr.hzgmsfhm","qr.ydblbs","qr.qhtzbs","qr.sbrjtgx","qr.ycyzjzl","qr.ycyzjhm","qr.qyzhyxx","qr.cxfldm"
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
Ext.extend(Gnt.store.RktjBndbdQrMxStore, Ext.data.JsonStore);
