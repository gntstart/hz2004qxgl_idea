var curCcm = "";
var pageSize = 15;

//当前人员
var curRy = null;
var ryCommonStore = null;
var saveusid = null;
var isinit = false;
var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"操作执行中，请等待..."});
var selnode = null;
var ryCsm = null;
var xmbm = null;

var jsGrid = null;jsGrid2 = null;
  //
  function setChk(obj,rid){
		var r = jsGrid.store.getById(rid);
		if(obj.checked){
			r.set("zfpq","1");
		}else{
			r.set("zfpq","0");
		}
	}
	//
	function after_userjs(){
		jsGrid.store.load();
	}
	
Ext.onReady( function() {
    Ext.QuickTips.init();
    
    function queryJs(){
		if(xmbm!=null && curRy!=null && ryCsm.getSelections().length>0){
			var data = {xmbm:xmbm,loginName:curRy.data.loginName};
			jsStore.baseParams = data;
			jsStore.load({params:{start:0, limit:pageSize}})
			
			Ext.getCmp("b1").setDisabled(false);
		}
	}

	var xmStore = new Ext.data.JsonStore({
				url : 'sq.do?method=queryProject',
				root : 'list',
				id : 'xmbm',
				totalProperty : 'totalCount',
				fields : ['xmbm','xmmc','cjsj'],
				listeners:{
					load:function(mystore,res){
						if(res.length>0){
							xmbm = res[0].data.xmbm;
							Ext.getCmp("xm").setValue(xmbm);
						}
					},
					loadexception:function(mystore,options,response,error){
						if(error){
							var json = Ext.decode(response.responseText);
							Ext.Msg.alert("提示",json.messages[0]);
						}else{
							Ext.Msg.alert("提示",response.responseText);
						}
					}
       		 	}
			});
	
	//角色
 	var jsStore = new Ext.data.JsonStore({
        	url: 'sq.do?method=queryUserJs',
        	root: 'list',
       		id:'jsid',
        	totalProperty:'totalCount',
        	fields: ["gxid","roleBm","roleName","zfpq","zfpq_opener"],
        	listeners:{
        		load:function(mystore,res){
				jsStore2.baseParams = jsStore.baseParams;
				jsStore2.load({params:{start:0, limit:pageSize}})
        		},
			loadexception:function(mystore,options,response,error){
				if(error){
					var json = Ext.decode(response.responseText);
					Ext.Msg.alert("提示",json.messages[0]);
				}else{
					Ext.Msg.alert("提示",response.responseText);
				}
			}
        	}
    	}
    );
  
	//角色
 	var jsStore2 = new Ext.data.JsonStore({
        	url: 'sq.do?method=queryUserJs&optype=FPQX',
        	root: 'list',
       		id:'jsid',
        	totalProperty:'totalCount',
        	fields: ["gxid","roleBm","roleName","zfpq","zfpq_opener"],
        	listeners:{
        		load:function(mystore,res){

        		},
			loadexception:function(mystore,options,response,error){
				if(error){
					var json = Ext.decode(response.responseText);
					Ext.Msg.alert("提示",json.messages[0]);
				}else{
					Ext.Msg.alert("提示",response.responseText);
				}
			}
        	}
    	}
    );
	
  	function showCheck1(value, cellmeta, record, rowIndex, columnIndex, store){
		var iskey = value=="1"?"checked":"";
		var disstr = ("1"==record.data.zfpq_opener || "1"==_isAdmin)?"":"disabled";
		return "<input type=checkbox style='height:10' onclick='setChk(this,"+record.id+")' "+disstr+" name='c_"+columnIndex+"' " + iskey + ">";
	}
	//
	var jsCsm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var jsColModel = new Ext.grid.ColumnModel([
		//jsCsm,
		{
	        header: "角色名称",
	        dataIndex: "roleName",
	        sortable: true,
			width: 100
	    },{
	        header: "角色编码",
	        dataIndex: "roleBm",	
	        sortable: true,
			width: 100,
			renderer:function(value){
				return value;
			}
	    }/*,{
	        header: "分配权",
	        dataIndex: "zfpq",	
	        sortable: true,
					width: 60,
					renderer: showCheck1
	    }*/
	]);

	jsGrid = new Ext.grid.GridPanel({
        	store: jsStore,
        	region: 'center',
        	view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		title:'用户权限',
		stripeRows: true,
        	cm: jsColModel,
        	sm: jsCsm,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
        	border:true,
        	anchor:'100% 100%',
       		width:250,
	    	margins: '5 0 0 0',  
        	frame:false,
		listeners:{
			rowclick:function(g, rowIndex, e){
			},
			rowdblclick:function(g, rowIndex, e){
			}
		},
        	id:'jsGrid'
    });	
  
	jsGrid2 = new Ext.grid.GridPanel({
        	store: jsStore2,
        	region: 'south',
        	height:250,
        	view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		title:'用户可分配权限',
		stripeRows: true,
        	cm: jsColModel,
        	sm: jsCsm,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
        	border:true,
        	anchor:'100% 100%',
       		width:250,
	    	margins: '0 0 0 0',  
        	frame:false,
		listeners:{
			rowclick:function(g, rowIndex, e){
			},
			rowdblclick:function(g, rowIndex, e){
			}
		},
        	id:'jsGrid2',
		bbar:[
			new Ext.Button({
				text:'用户授权',
				minWidth:75,
				id:'b1',
				handler:function(){
					_openSQ(curRy.data.loginName,curRy.data.xm);
				}
			}),
			new Ext.Button({
				text:'用户可分配权',
				minWidth:75,
				id:'b1',
				handler:function(){
					_openSQ(curRy.data.loginName,curRy.data.xm,"","queryProjectJSTreeFP");
					return;
				}
			})
		]
    });	
    
 	ryCommonStore = new Ext.data.JsonStore({
        url: 'zzjy.do?method=queryZzjy',
        root: 'list',
        id:'usid',
        totalProperty:'totalCount',
        fields: [
			"usid",
			"xm",
			"loginName",
			"loginPassword",
			"zxbz",
			"email",
			"mobile",
			"telephoneNumber",
			"sex",
			"lastLoginTime",
			"msn",
			"idcard",
			"ywxtfl",
			"pyt",
			"sjfw",
			"gwlb",
			"jmLoginName",
			"jmLoginPassword",
			"lastLoginStatus",
			"lastLoginXmbm",
			"rankCode",
			"nfxgmm",
			"organizePath",
			"organizeBm",
			"zwm",
			"cjsj",
			"bz"
        ],
        listeners:{
        	load:function(){
        		jsStore.removeAll();
        		jsStore2.removeAll();
        	},
			loadexception:function(mystore,options,response,error){
				if(error){
					var json = Ext.decode(response.responseText);
					Ext.Msg.alert("提示",json.messages[0]);
				}else{
					Ext.Msg.alert("提示",response.responseText);
				}
			}
        }
    });
    
	ryCsm = new Ext.grid.CheckboxSelectionModel({
		singleSelect:true,
		listeners:{
			rowselect:function(sm, rowIndex, r){
				curRy = r;
				queryJs();
			} 
		}
	});
	var ryColModel = new Ext.grid.ColumnModel([
		{
	        header: "登录名",
	        dataIndex: "loginName",
	        sortable: true,
			width: 100
	    },{
	        header: "姓名",
	        dataIndex: "xm",	
	        sortable: true,
			width: 100,
			renderer:function(value){
				return value;
			}
	    },{
	        header: "邮件",
	        dataIndex: "email",	
	        sortable: true,
			width: 200,
			renderer:function(value){
				return value;
			}
	    },{
	        header: "主单位",
	        dataIndex: "organizePath",	
	        sortable: true,
			width: 200
	    },{
	        header: "最后登录时间",
	        dataIndex: "lastLoginTime",	
	        sortable: true,
			width: 80
	    }
	]);
	
	var ryQueryFs = new Ext.form.FormPanel({
	    title:'用户列表',
    	height: 70,
    	region: 'north',
    	anchor:'100% 100%',
    	buttonAlign:'right',
    	labelAlign:'right',
    	frame:true,
    	border:false,
    	margins:'0',
        layout:'form',
        labelWidth:75,
       	items:[{
        		layout:'column',
    			frame:false,
    			border:false,
        		defaults:{
        			border:false,
        			frame:false
        		},
            	items:[{
            		id:'ccm',
            		name:'ccm',
            		xtype:'hidden'
            	},{
	                columnWidth:.5,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 5 0 0',
        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'queryKey',
						fieldLabel:'关键字'
					}]
				},{
	                columnWidth:.5,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [
        	       		new Ext.Button({
							text:'查询',
							minWidth:75,
							id:'queryBtn',
							handler:function(){
								if(selnode==null || !selnode.attributes.zzjg){
									Ext.Msg.alert("提示","必须先在右边树中选择单位！");
									return;
								}
								
								Ext.getCmp("b1").setDisabled(true);
								
								var p = ryQueryFs.getForm().getValues();
								ryCommonStore.baseParams = p;
								ryCommonStore.load({params:{start:0, limit:pageSize}})
							}
						})
					]
				}
			]
		}]
	});

	var ryGrid = new Ext.grid.GridPanel({
        store: ryCommonStore,
        //plugins: new Ext.ux.CellContextMenu(),
        region: 'center',
        view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		stripeRows: true,
        cm: ryColModel,
        sm: ryCsm,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
        border:true,
        anchor:'100% 100%',
	    margins: '5 0 0 0',  
        frame:false,
		iconCls:'icon-grid',
		listeners:{
			rowclick:function(g, rowIndex, e){
				curRy = g.store.getAt(rowIndex);
			},
			rowdblclick:function(g, rowIndex, e){
				
			}
		},
        title:'',
        bbar: new Ext.PagingToolbar({
				pageSize: pageSize,
				store: ryCommonStore,
				displayInfo: true
		})
    });	

	var xmQueryFs = new Ext.form.FormPanel({
	    title:'',
    	height: 70,
    	region: 'north',
    	anchor:'100% 100%',
    	buttonAlign:'right',
    	labelAlign:'right',
    	frame:true,
    	border:false,
    	margins:'0',
        title:'用户角色列表',
        layout:'form',
        labelWidth:55,
       	items:[{
        		layout:'column',
    			frame:false,
    			border:false,
        		defaults:{
        			border:false,
        			frame:false
        		},
            	items:[{
	                columnWidth:1,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
						hiddenName : 'xmbm',
						anchor : '100%',
						xtype : 'combo',
						fieldLabel : '项目',
						mode : 'local',
						triggerAction : 'all',
						id:'xm',
						valueField : "xmbm",
						displayField : "xmmc",
						selectOnFocus : true,
						emptyText : '请选择',
						typeAhead : true,
						forceSelection : true,
						forceSelection : true,
						blankText : '请选择',
						lazyRender : true,
						store : xmStore,
						value:'',
						listeners:{
							select:function(combo, record, index ){
								xmbm = record.data.xmbm;
								queryJs();
							} 
						}
					}]
				}
			]
		}]
	});
	
	new Ext.Viewport({
	       layout:'border',
	       id:'vp',
	       items:[{
	            region:'center',
	            //禁止横向滚动条
	            layout:'fit',
	            border:false,
	            frame:false,
	           	//bodyStyle:'overflow:scroll;overflow-x:hidden',
	            margins:'5 0 5 0',
	            autoScroll:true,
	            items:[{
	            	layout:'border',
	            	frame:false,
	            	border:false,
	            	margins: '0',
	            	items:[
	            		ryGrid,ryQueryFs
	            	]
	            }]
	        },{
	            	region:'west',
	            	//禁止横向滚动条
	           	layout:'fit',
	           	border:false,
	            	frame:false,
	           	bodyStyle:'overflow:scroll;overflow-x:hidden',
	            	margins:'5 0 5 5',
	            	autoScroll:true,
	            	collapsible:true,
           		splitTip: "拖动来改变尺寸.",	//SplitRegion的构造参数
            		collapsibleSplitTip:'拖动来改变尺寸. 双击隐藏',
	            	split:true,
			collapseMode:'mini',//SplitRegion的构造参数
	            	//title:'选择单位或者用户',
	            	width:300,
	            	items:[_UserTree]
	        },{
	            	region:'east',
	            	//禁止横向滚动条
	           	layout:'border',
	            	border:false,
	            	frame:false,
	            	width:300,
	           	collapsible:true,
           		splitTip: "拖动来改变尺寸.",	//SplitRegion的构造参数
            		collapsibleSplitTip:'拖动来改变尺寸. 双击隐藏',
	            	split:true,
			collapseMode:'mini',//SplitRegion的构造参数
	          	 //bodyStyle:'overflow:scroll;overflow-x:hidden',
	            	margins:'5 5 5 0',
	            	items:[jsGrid,xmQueryFs,jsGrid2]
	        }]
	});
		
	//绑定单击事件
	_UserTree.on("click", function(node,e) {
			if(node.attributes.zzjg && !node.attributes.zzjy){
				var ccm = node.attributes.zzjg.ccm;
				if(curCcm==ccm)
					return;
					
				curCcm = ccm;
				
				ryQueryFs.getForm().reset();
				Ext.getCmp("ccm").setValue(ccm);
				
				selnode = node;
				
				Ext.getCmp("b1").setDisabled(true);
								
				ryCommonStore.baseParams = {ccm:ccm};
				ryCommonStore.load({params:{start:0, limit:pageSize}})
			}
		}, 
		_UserTree
	);
	
	new Ext.KeyMap(ryQueryFs.el, {
	    	key:13,
	    	fn:function(key,keyEvent){
	    		//注意，对话框通过回车无法关闭，因为会反复触发该事件
	    		Ext.getCmp("queryBtn").handler.call();
	    	}
	});
	
	xmStore.load({});

	Ext.getCmp("b1").setDisabled(true);
		
	if(!isinit){
		isinit = true;
		initDict();
	}
});