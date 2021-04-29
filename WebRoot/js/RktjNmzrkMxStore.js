/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.RktjNmzrkMxStore = function(c){
	Gnt.store.RktjNmzrkMxStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'rynbid',
			totalProperty:'totalCount',
			fields: [
			         	/**
			         		常住人口
			         	 */
						"czrk.nbsfzid","czrk.qfjg","czrk.yxqxqsrq","czrk.yxqxjzrq","czrk.swzxrq","czrk.fqxm","czrk.fqgmsfhm","czrk.mqxm","czrk.mqgmsfhm"
						,"czrk.poxm","czrk.pogmsfhm","czrk.jggjdq","czrk.jgssxq","czrk.zjxy","czrk.whcd","czrk.hyzk","czrk.byzk","czrk.sg","czrk.xx"
						,"czrk.zy","czrk.zylb","czrk.fwcs","czrk.xxjb","czrk.hsql","czrk.hyql","czrk.hgjdqql","czrk.hssxqql","czrk.hxzql","czrk.hslbz"
						,"czrk.hylbz","czrk.hgjdqlbz","czrk.hsssqlbz","czrk.hxzlbz","czrk.swrq","czrk.swzxlb","czrk.qcrq","czrk.qczxlb","czrk.qwdgjdq"
						,"czrk.qwdssxq","czrk.qwdxz","czrk.cszmbh","czrk.cszqfrq","czrk.hylb","czrk.qtssxq","czrk.qtzz","czrk.rylb","czrk.hb","czrk.yhzgx"
						,"czrk.ryzt","czrk.rysdzt","czrk.lxdbid","czrk.bz","czrk.jlbz","czrk.ywnr","czrk.cjhjywid","czrk.cchjywid","czrk.qysj","czrk.jssj"
						,"czrk.cxbz","czrk.rynbid","czrk.ryid","czrk.hhnbid","czrk.mlpnbid","czrk.zpid","czrk.gmsfhm","czrk.xm","czrk.cym","czrk.xmpy"
						,"czrk.cympy","czrk.xb","czrk.mz","czrk.csrq","czrk.cssj","czrk.csdgjdq","czrk.csdssxq","czrk.csdxz","czrk.dhhm","czrk.dhhm2"
						,"czrk.jhryxm","czrk.jhrygmsfhm","czrk.jhryjhgx","czrk.jhrexm","czrk.jhregmsfhm","czrk.jhrejhgx","czrk.zjlb","czrk.ssxq","czrk.jlx"
						,"czrk.mlph","czrk.mlxz","czrk.pcs","czrk.zrq","czrk.xzjd","czrk.jcwh","czrk.pxh","czrk.hh","czrk.hlx","czrk.bdfw","czrk.hhid"
						,"czrk.mlpid","czrk.xxqysj","czrk.xmx","czrk.xmm","czrk.jgxz","czrk.jhryzjzl","czrk.jhryzjhm","czrk.jhrywwx","czrk.jhrywwm"
						,"czrk.jhrylxdh","czrk.jhrezjzl","czrk.jhrezjhm","czrk.jhrewwx","czrk.jhrewwm","czrk.jhrelxdh","czrk.fqzjzl","czrk.fqzjhm"
						,"czrk.fqwwx","czrk.fqwwm","czrk.mqzjzl","czrk.mqzjhm","czrk.mqwwx","czrk.mqwwm","czrk.pozjzl","czrk.pozjhm","czrk.powwx"
						,"czrk.powwm","czrk.qyldyy","czrk.yhkxzmc","czrk.yhkxzsj","czrk.bzdz","czrk.bzdzid","czrk.bzdzx","czrk.bzdzy","czrk.bzdzst"
						,"czrk.cxfldm","czrk.jlx_text","czrk.jwh_text"
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
Ext.extend(Gnt.store.RktjNmzrkMxStore, Ext.data.JsonStore);
