/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.ux.HcyGrid = Ext.extend(Ext.grid.GridPanel, {
	title:'人员基本信息',
	height:200,
	stripeRows: true,
    loadMask: {msg:'正在加载数据，请稍侯……'},
    border:false,
    margins:'0 0 0 5',
	frame:false,
    border:true,
    frame:true,
    getPostParams:function(){
    	return {};
    },
    loadData:function(){
    	var data = this.getPostParams();
    	
    	this.store.baseParams = data;
		this.store.load({params:{start:0, limit:9999}});
    },
	initComponent: function() {
		this.store=new Ext.data.JsonStore({
			url:this.url,
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
				"yhkxzmc","yhkxzsj","bzdz","bzdzid","bzdzx","bzdzy","bzdzst","cxfldm"],
	        listeners:{
	        	load:function(store,res){

	        	},
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
	    });
		this.cm=new Ext.grid.ColumnModel([{
		    header: "姓名",
		    dataIndex: "xm",	
		    sortable: true,
		    width: 80
		 },{
		     header: "与户主关系",
		     dataIndex: "yhzgx",	
		     sortable: true,
		     width: 120,
			renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
				return Gnt.ux.Dict.getDictLable('CS_JTGX', value);
			}
		}]);
		
		if(this.showPaging==undefined || this.showPaging==true){
			this.bbar=new Ext.PagingToolbar({
				pageSize: 20,
				store: this.store,
				displayInfo: true
			});
		}
		
		//这个必须放store定义后，否则不可预料
		this.view=new Ext.grid.GridView({
			forceFit:true,
			autoFill:false,
			enableRowBody:true
	    });
		
		Gnt.ux.HcyGrid.superclass.initComponent.call(this);
	}
});
Ext.reg('hcy_grid', Gnt.ux.HcyGrid);
