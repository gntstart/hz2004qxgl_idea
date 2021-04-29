var pagesize=1000;
var selRes = null;
var _postParams = null;
var fnQueryFs = null;
var rktjGrid = null;
var tabs = null;
var dqbm = null;

function closeActiveWorkSpace(jsonData, tab_key){
	
}

Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	Gnt.ux.Dict.loadDict(['CS_HLX','CS_XB','CS_JTGX','CS_MZ','CS_HYZK','CS_XX'],function(){
			
	});
	
	fnQueryFs = new Gnt.ux.GntForm({
	    title:'查询',
    	height: 100,
    	region: 'north',
    	frame:false,
        fields:[{
					columnWidth:.25, 
					dict:"methodName=listYwDqbm&def=4&ignore=false&config=rktjlist",
					fieldLabel:'统计类型',
					name:'fw2',
					hiddenName:'fw',
					allowBlank:false,
					xtype:'dict_combox'
		        },{
    	       		columnWidth:.25,
					xtype:'tree_comboBox',
					dict:'VisionType=XZQHBNEW',
					dsname:'XZQHBNEW',
					anchor:'100%',
					name:'dq',
					allowBlank:false,
					fieldLabel:'地区',
					searchUrl:'tj/rktj.do?method=searchXzqh',
					treeUrl:'tj/rktj.do?method=searchTreeXzqh1',
					listeners:{
			    		change:function(field, newValue, oldValue){
			    			dqbm = newValue;
			    		}
			    	}
		        },{
					columnWidth:.25,
					xtype:'datefield',
					anchor:'100%',
					format:'Y-m-d',
					name:'startDate',
					allowBlank:false,
					fieldLabel:'统计时间起'
				},{
					columnWidth:.25,
					xtype:'datefield',
					anchor:'100%',
					format:'Y-m-d',
					name:'endDate',
					allowBlank:false,
					fieldLabel:'统计时间止'
				}
		],
		buttons:[
				new Ext.Button({
						text:'查询',
						minWidth:75,
						id:'queryBtn',
						tooltip:'人口统计查询',
						handler:function(){
							if(!fnQueryFs.getForm().isValid()){
								Ext.Msg.alert("提示","数据校验没有通过，请检查！");
								return;
							}
							
							var p = fnQueryFs.getForm().getValues();

							/**
								类型选择地市时不能直接选择省，会导致合计数值的明细查询为空
								是根据选择的地市代码来查询的
								
							 */
							if(p.fw == 0){
								if((p.dq.lastIndexOf("省") + 1) != p.dq.length ){
									Ext.Msg.alert("提示","请选择省！");
									return;
								}
							}else if(p.fw == 1){
								if((p.dq.lastIndexOf("省") + 1) == p.dq.length || 
										(p.dq.lastIndexOf("区") + 1) == p.dq.length || 
										(p.dq.lastIndexOf("县") + 1) == p.dq.length ||
										(p.dq.lastIndexOf("局") + 1) == p.dq.length ||
										(p.dq.lastIndexOf("所") + 1) == p.dq.length){
									Ext.Msg.alert("提示","请选择地市！");
									return;
								}
							}else if(p.fw == 2){
								if((p.dq.lastIndexOf("区") + 1) != p.dq.length && 
										(p.dq.lastIndexOf("县") + 1) != p.dq.length && 
										(p.dq.lastIndexOf("局") + 1) != p.dq.length){
									Ext.Msg.alert("提示","请选择区县！");
									return;
								}
							}else if(p.fw == 3){
								if((p.dq.lastIndexOf("派出所") + 3) != p.dq.length){
									Ext.Msg.alert("提示","请选择派出所！");
									return;
								}
							}
							
							rktjGrid.store.removeAll();
							
							selRes = null;
							
							_postParams = p;
							
							rktjGrid.loadData(p);
						}
				})
				,
				new Ext.Button({
					text:'导出',
					minWidth:75,
					id:'expBtn',
					tooltip:'人口统计导出',
					handler:function(){
						
						
						if(rktjGrid.getStore().getCount() == 0){
//							Ext.Msg.alert("提示","无数据，请先执行查询！");
//							return;
						}
						
						/**
							执行导出
						 */
						Ext.Msg.wait("正在导出，请稍后...");
						
						ExcelExport(fnQueryFs.getForm().getValues());
						
						Ext.Msg.hide();
						
					}
				})
		]
	});
	
	rktjGrid = new Gnt.ux.Rktj58Grid({
    	region:'center',
    	id:'rktjGrid',
    	title: '查询结果信息',
    	height:200,
    	showPaging:true,
    	pagesize:pagesize,
    	listeners:{
    		rowclick:function(g, rowIndex, e){
    			
    		},
    		rowdblclick:function(g, rowIndex, e){
    			selRes = g.store.getAt(rowIndex);
    		}
    	},
    	url:'tj/rktj.do?method=queryRktj&table=58&PROCEDURE=p_rpt_hjfnyrkzjqktj&colLength=30'
    });
	
	//定义分页面板
    tabs = new Ext.TabPanel({
    	id:'tabs',
        activeTab: 0,
        width:500,
        height:250,
        resizeTabs:false, 
        enableTabScroll:true,
        doubleHead:true,
        rowSpan:true,
        plain:false,
        listeners:{
        	//在关闭分页的时候，调用函数释放iframe占用资源
        	beforeremove:fixIFrame.createDelegate(this)
        },
        sm: new Ext.grid.RowSelectionModel(),
        plugins:[new Ext.ux.plugins.GroupHeaderGrid()],
        defaults:{
        	autoScroll: false,
        	frame: false,
        	shim: false,
        	xtype: 'panel'
        },
        items:[{
        	closable: true,
            title: '统计',
            layout:'border',
            tabTip:'',
            items:[
				fnQueryFs,
				rktjGrid
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


function gotoMx(url){
	/**
		跳转至明细
		参数设置在RktjServiceImpl中
	 */
	openWorkSpaceBeforeClose(tabs, true, url, "人口统计明细", "rktjmx");
	
}

function ExcelExport(values) {
	var vExportWorkbook = rktjGrid.getExcelXml(); // 获取数据
	var vExportWorksheet = rktjGrid.createWorksheet(null,values).xml; // 获取数据
	if (Ext.isIE8 || Ext.isIE6 || Ext.isIE7 || Ext.isSafari || Ext.isSafari2 || Ext.isSafari3) { // 判断浏览器
		var fd = Ext.get('frmDummy');
		if (!fd) {
			fd = Ext.DomHelper.append(Ext.getBody(), {
				tag : 'form',
				method : 'post',
				id : 'frmDummy',
				action : 'tj/ExportExcel.jsp',
				target : '_blank',
				name : 'frmDummy',
				cls : 'x-hidden',
				cn : [{
						tag : 'input',
						name : 'exportWorkbook',
						id : 'exportWorkbook',
						type : 'hidden'
				},{
					tag : 'input',
					name : 'exportWorksheet',
					id : 'exportWorksheet',
					type : 'hidden'
				},{
					tag : 'input',
					name : 'filename',
					id : 'filename',
					value : dqbm + '_58',
					type : 'hidden'
				}]
			}, true);
		}
		fd.child('#exportWorkbook').set({
			value : vExportWorkbook
		});
		fd.child('#exportWorksheet').set({
			value : vExportWorksheet
		});
		fd.dom.submit();
	} else {
		document.location = 'data:application/vnd.ms-excel;base64,'+ Base64.encode(vExportWorkbook) + Base64.encode(vExportWorksheet);
	}
}

