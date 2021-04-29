var pagesize=20;
var selRes = null;
var _postParams = null;
var qcryGrid = null;
var fnQueryFs = null;
var czrkGrid = null;
var jtcyGrid = null;
var tabs = null;
var dqbm = null;

function closeActiveWorkSpace(jsonData, tab_key){
	var tab = tab_key?tabs.getItem(tab_key):tabs.getActiveTab();
	if(tab)
		tabs.remove( tab );
	
	if(jsonData && jsonData.list){
		var data = jsonData.list[0];
		var url = "yw/qcnext.jsp?hjywid=" + data.hjywid  + "&qwdq=" + data.qwdq + "&qcdq=" + data.qcdq;
		
		openWorkSpaceBeforeClose(tabs, true, url, "跨地市迁入审批", "kdsqccl_next");
	}else if(jsonData){
		var url = "yw/qcnext.jsp?hjywid=" + jsonData.hjywid + "&qcdq=" + jsonData.qcdq;
		openWorkSpaceBeforeClose(tabs, true, url, "跨地市迁入审批", "kdsqccl_next");
	}
}

Ext.onReady(function(){
	Ext.QuickTips.init();
	
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
						name:'dqbm2',
						hiddenName:'dqbm',
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
							qcryGrid.store.removeAll();
							jtcyGrid.store.removeAll();
							
							selRes = null;
							
							var p = fnQueryFs.getForm().getValues();

							_postParams = p;
							dqbm = p.dqbm;
							
							czrkGrid.loadData(p);
						}
				}),
				new Ext.Button({
					text:'待迁入列表',
					minWidth:75,
					id:'queryBtn2',
					tooltip:'已做迁出处理，但是未成功进行迁入的人员列表',
					handler:function(){
						openWorkSpaceBeforeClose(tabs, true, "yw/qcnext-query.jsp", "待迁入列表", "qcnext-query");
					}
			})
		]
	});
	
	czrkGrid = new Gnt.ux.CzrkGrid({
    	region:'center',
    	id:'czrkGrid',
    	title: '查询结果信息',
    	height:200,
    	showPaging:true,
    	pagesize:pagesize,
    	listeners:{
    		rowclick:function(g, rowIndex, e){

    		},
    		rowdblclick:function(g, rowIndex, e){
    			selRes = g.store.getAt(rowIndex);
    			
    			jtcyGrid.store.removeAll();
				qcryGrid.store.removeAll();
				
    			var p = {hh:selRes.data.hh}
				_postParams = p;
    			jtcyGrid.loadData(p);
    		}
    	},
    	url:'yw/kdqqy.do?method=queryCzrkjbxx'
    });
	
	jtcyGrid = new Gnt.ux.CzrkGrid({
    	region:'west',
    	title: '户成员列表',
    	width:800,
    	showPaging:true,
    	pagesize:50,
    	cm: new Ext.grid.ColumnModel([{
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
			},{
			     header: "性别",
			     dataIndex: "xb",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
						return Gnt.ux.Dict.getDictLable('CS_XB', value);
				 }
			 },{
				    header: "公民身份号码",
				    dataIndex: "gmsfhm",	
				    sortable: true,
				    width: 100
			 },{
			     header: "民族",
			     dataIndex: "mz",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
						return Gnt.ux.Dict.getDictLable('CS_MZ', value);
				 }
			 },{
			     header: "婚姻状况",
			     dataIndex: "hyzk",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
						return Gnt.ux.Dict.getDictLable('CS_HYZK', value);
				 }
			 },{
			     header: "血型",
			     dataIndex: "xx",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
						return Gnt.ux.Dict.getDictLable('CS_XX', value);
				 }
			 },{
				    header: "联系电话",
				    dataIndex: "dhhm",	
				    sortable: true,
				    width: 80
			 }
		 ]),
		 view: new Ext.grid.GridView({
				forceFit:false,
				autoFill:false,
				enableRowBody:true
		 }),
    	listeners:{
    		rowclick:function(g, rowIndex, e){

    		},
    		rowdblclick:function(g, rowIndex, e){
    			var r = g.store.getAt(rowIndex);
    			
    			if(qcryGrid.store.getById(r.data.rynbid)){
    				Ext.Msg.alert("提示", "此人员已添加！");
    				return;
    			}
    			
    			g.store.remove(r);
    			qcryGrid.store.add([r]);
    		}
    	},
    	url:'yw/kdqqy.do?method=queryCzrkjbxx'
    });
	
	qcryGrid = new Gnt.ux.CzrkGrid({
    	region:'center',
    	title: '已选迁出人员',
    	width:800,
    	showPaging:false,
    	cm: new Ext.grid.ColumnModel([{
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
			},{
			     header: "性别",
			     dataIndex: "xb",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
						return Gnt.ux.Dict.getDictLable('CS_XB', value);
				 }
			 },{
				    header: "公民身份号码",
				    dataIndex: "gmsfhm",	
				    sortable: true,
				    width: 100
			 },{
			     header: "民族",
			     dataIndex: "mz",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
						return Gnt.ux.Dict.getDictLable('CS_MZ', value);
				 }
			 },{
			     header: "婚姻状况",
			     dataIndex: "hyzk",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
						return Gnt.ux.Dict.getDictLable('CS_HYZK', value);
				 }
			 },{
			     header: "血型",
			     dataIndex: "xx",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
						return Gnt.ux.Dict.getDictLable('CS_XX', value);
				 }
			 },{
				    header: "联系电话",
				    dataIndex: "dhhm",	
				    sortable: true,
				    width: 80
			 }
		 ]),
		 view: new Ext.grid.GridView({
				forceFit:false,
				autoFill:false,
				enableRowBody:true
		 }),
    	listeners:{
    		rowclick:function(g, rowIndex, e){

    		},
    		rowdblclick:function(g, rowIndex, e){
    				var r = g.store.getAt(rowIndex);
    				g.store.remove(r);
    				jtcyGrid.store.add([r]);
    		}
    	},
    	url:'yw/kdqqy.do?method=queryCzrkjbxx',
    	buttons:[
 				new Ext.Button({
 						text:'确定迁出',
 						minWidth:75,
 						id:'queryBtn',
 						handler:function(){
 								if(qcryGrid.store.getCount()<=0){
 									Ext.Msg.alert("提示","必须选择迁出人员！");
 									return;
 								}
 								
 								openWorkSpaceBeforeClose(tabs, true, "yw/qc.jsp?formdq=" + dqbm, "跨地市迁出处理", "kdsqccl");
 						}
 				}),
 				new Ext.Button({
						text:'迁入测试',
						minWidth:75,
						id:'queryBtn',
						handler:function(){
							
							//alert(fnQueryFs.getForm().getValues().dqbm);
							//alert(qcryGrid.store);
							
							
							
							var url = "yw/qcnext.jsp?hjywid=3407000001002268666&qwdq="+fnQueryFs.getForm().getValues().dqbm+"&qcdq=3407";
							
							
							openWorkSpaceBeforeClose(tabs, true, url, "跨地市迁入审批", "kdsqccl_next");
						}
				})
 		]
    });
	
	//定义分页面板
    tabs = new Ext.TabPanel({
    	id:'tabs',
        activeTab: 0,
        width:500,
        height:250,
        resizeTabs:false, 
        enableTabScroll:true,
        plain:false,
        listeners:{
        	//在关闭分页的时候，调用函数释放iframe占用资源
        	beforeremove:fixIFrame.createDelegate(this)
        },
        defaults:{
        	autoScroll: false,
        	frame: false,
        	shim: false,
        	xtype: 'panel'
        },
        items:[{
        	//本页不允许关闭
        	closable: false,
            title: '跨地区迁出',
            layout:'border',
            tabTip:'',
            items:[
				fnQueryFs,
				czrkGrid,
				{
				     region:'south',
				     height:300,
				     layout:'border',
				     items:[
				            jtcyGrid, {
						            layout:'border',
						            region:'center',
						            items:[
						                   qcryGrid,
						                   {
						                	   region:'west',
						                	   html:'<table border=0 width=100% height=100%><tr><td style="text-align:center">' +
						                		   '<input style="width:30px;height:30px" type="button" value=">>" onclick="oprecord(0)"/><br/>' +
						                		   '<input style="width:30px;height:30px" type="button" value="<<" onclick="oprecord(1)"/><br/>' +
						                		   '<input style="width:30px;height:30px" type="button" value=">" onclick="oprecord(2)"/><br/>' +
						                		   '<input style="width:30px;height:30px" type="button" value="<" onclick="oprecord(3)"/><br/>' +
						                		   		'</td></tr></table>',
						                	   width:50
						                   }
						            ]
				            }
				     ]
				}
            ]
        }]
    });
	
	new Ext.Viewport({
        layout:'fit',
        id:'vp',
        items:[
               tabs
        ]
    });
});

function oprecord(type){
	if(type==0){
		//添加所有
		if(jtcyGrid.store.getCount()>0){
			jtcyGrid.store.each(
					function(rec){
						qcryGrid.store.add(rec);
					}
			);
			jtcyGrid.store.removeAll();
		}
	}
	if(type==1){
		//删除所有
		if(qcryGrid.store.getCount()>0){
			qcryGrid.store.each(
					function(rec){
						jtcyGrid.store.add(rec);
					}
			);
			qcryGrid.store.removeAll();
		}
	}
	if(type==2){
		//添加选择的行
		var res = jtcyGrid.getSelectionModel().getSelections();
		if(res.length>0){
			qcryGrid.store.add(res);
			for(var i=0;i<res.length;i++)
				jtcyGrid.store.remove(res[i]);
		}
	}
	if(type==3){
		//删除选择的行
		var res = qcryGrid.getSelectionModel().getSelections();
		if(res.length>0){
			jtcyGrid.store.add(res);
			for(var i=0;i<res.length;i++)
				qcryGrid.store.remove(res[i]);
		}
	}
}

function getAll(){
	var res = new Array();
	qcryGrid.store.each(
			function(rec){
				rec.data.qcflag = '1';
				res.push(rec);
			}
	);
	
	jtcyGrid.store.each(
			function(rec){
				rec.data.qcflag = '0';
				res.push(rec);
			}
	);

	return res;
}
