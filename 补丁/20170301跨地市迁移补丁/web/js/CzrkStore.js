/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.store.CzrkStore = function(c){
	Gnt.store.CzrkStore.superclass.constructor.call(this, Ext.apply(c, {
			root: 'list',
			id:'rynbid',
			totalProperty:'totalCount',
			fields: [
				"nbsfzid","qfjg","yxqxqsrq","yxqxjzrq","swzxrq","fqxm","fqgmsfhm","mqxm","mqgmsfhm","poxm","pogmsfhm","jggjdq","jgssxq",
				"zjxy","whcd","hyzk","byzk","sg","xx","zy","zylb","fwcs","xxjb","hsql","hyql","hgjdqql","hssxqql","hxzql","hslbz","hylbz","hgjdqlbz",
				"hsssqlbz","hxzlbz","swrq","swzxlb","qcrq","qczxlb","qwdgjdq","qwdssxq","qwdxz","cszmbh","cszqfrq","hylb","qtssxq","qtzz","rylb",
				"hb","yhzgx","ryzt","rysdzt","lxdbid","bz","jlbz","ywnr","cjhjywid","cchjywid","qysj","jssj","cxbz","rynbid","ryid","hhnbid","mlpnbid",
				"zpid","gmsfhm","xm","cym","xmpy","cympy","xb","mz","csrq","cssj","csdgjdq","csdssxq","csdxz","dhhm","dhhm2","jhryxm","jhrygmsfhm",
				"jhryjhgx","jhrexm","jhregmsfhm","jhrejhgx","zjlb","ssxq","jlx","mlph","mlxz","pcs","zrq","xzjd","jcwh","pxh","hh","hlx","bdfw","hhid",
				"mlpid","xxqysj","xmx","xmm","jgxz","jhryzjzl","jhryzjhm","jhrywwx","jhrywwm","jhrylxdh","jhrezjzl","jhrezjhm","jhrewwx","jhrewwm",
				"jhrelxdh","fqzjzl","fqzjhm","fqwwx","fqwwm","mqzjzl","mqzjhm","mqwwx","mqwwm","pozjzl","pozjhm","powwx","powwm","qyldyy",
				"yhkxzmc","yhkxzsj","bzdz","bzdzid","bzdzx","bzdzy","bzdzst","cxfldm","jlx_text","jwh_text"],
			listeners:{
				loadexception:function(mystore,options,response,error){
					if(error){
						var json = Ext.decode(response.responseText);
						if(json.messages)
							Ext.Msg.alert("提示",json.messages[0]);
						else
							Ext.Msg.alert("提示",error.message);
					}else{
						Ext.Msg.alert("提示",response.responseText);
					}
				}
			}
    }));
};
Ext.extend(Gnt.store.CzrkStore, Ext.data.JsonStore);
