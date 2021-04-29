var pagesize=20;
var selRes = null;
var _postParams = null;
var qcryGrid = null;
var fnQueryFs = null;
var czrkGrid = null;
var dqbm = null;

function closeActiveWorkSpace(jsonData){
	var tab = tabs.getActiveTab();
	if(tab)
		tabs.remove( tab );
	
	if(jsonData){
		var data = jsonData.list[0];
		var url = "yw/qcnext.jsp?hjywid=" + data.hjywid  + "&qwdq=" + data.qwdq + "&qcdq=" + data.qcdq;
		
		openWorkSpaceBeforeClose(tabs, true, url, "跨地市迁入审批", "kdsqccl_next");
	}
}

Ext.onReady(function(){
	Ext.QuickTips.init();
	
	//首先以AJAX同步的方式获取页面需要的配置，然后从本地进行渲染界面
	if(!Gnt.loadSjpzb("20004",function(){}))
		return;
	
	Gnt.ux.Dict.loadDict(['CS_HLX','CS_XB','CS_JTGX','CS_MZ','CS_HYZK','CS_XX'],function(){

	});
	
	fnQueryFs = new Gnt.ux.GntForm({
	    title:'迁出人员查询',
    	height: 100,
    	region: 'north',
    	frame:false,
        fields:[{
						columnWidth:.25, 
						dict:"methodName=listYwDqbm&def=4&ignore=false&config=dqlist",
						fieldLabel:'迁出地',
						name:'qcdq',
						hiddenName:'qcdq',
						allowBlank:false,
						xtype:'dict_combox'
				}, {
        	       		columnWidth:.25,
						xtype:'textfield',
						anchor:'100%',
						name:'gmsfhm',
						fieldLabel:'公民身份证号'
				},{
        	       		columnWidth:.25,
						xtype:'textfield',
						anchor:'100%',
						name:'hh',
						fieldLabel:'户号'
				},{
        	       		columnWidth:.25,
						xtype:'textfield',
						anchor:'100%',
						name:'xm',
						fieldLabel:'姓名'
				}
		],
		buttons:[
				new Ext.Button({
						text:'查询',
						minWidth:75,
						id:'queryBtn',
						tooltip:'异地迁出处理查询',
						handler:function(){
							if(!fnQueryFs.getForm().isValid()){
								Ext.Msg.alert("提示","数据校验没有通过，请检查！");
								return;
							}
							
							czrkGrid.store.removeAll();
							
							
							selRes = null;
							
							var p = fnQueryFs.getForm().getValues();

							_postParams = p;
							dqbm = p.qcdq;
							
							czrkGrid.loadData(p);
						}
				})
		]
	});
	
	czrkGrid = new Gnt.ux.GntGrid({
		region:'center',
		width:200,
		title:'跨地市迁出注销信息',
		pk:"ryid",
		showPaging:false,
		url: "yw/kdqqy.do?method=queryKdsQczxxx",
		pzlb:'20004',
        listeners:{
    		rowDblclick:function(g, rowIndex, e){
    			var res = g.store.getAt(rowIndex);
    			var data = res.data;
    			data.qcdq = dqbm;
    			if(parent.closeActiveWorkSpace){
					parent.closeActiveWorkSpace(data, "kdsqccl_next");
    			}
     		}
        },
        loadCallback:function(store,res){
        }
	});
	
	new Ext.Viewport({
        layout:'border',
        id:'vp',
        items:[
               fnQueryFs,czrkGrid
        ]
    });
});
