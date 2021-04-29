var isinit = false;
var pageSize = 15;
var selnode = null;
var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"操作执行中，请等待..."});
var saveusid = null;
var _jsStr = null;
var _xmbm = null;
var _initload = false;

Ext.onReady( function() {
    Ext.QuickTips.init();
	
	var projectTreeNode = new Ext.tree.AsyncTreeNode({
		text:'根'
	});
	
	var projectTreeLoader = new Ext.tree.TreeLoader({
		dataUrl		: 'xm.do?method=queryProjectTree',
		listeners	:{
			loadexception:function(tree,node,response){
				Ext.Msg.alert("提示","项目树加载失败：" + response.responseText);
			}
		}
	});
	
	projectTreeLoader.on("load", function(treeLoader, node, response) {
			//在beforeload事件中每次动态传递点击的节点的value属性作为参数
			var o = Ext.decode(response.responseText);
			if(o.messages && o.messages.length>0){
				Ext.Msg.alert("提示",o.messages[0]);
			}
		}, 
		projectTreeLoader
	);
	
	var projectTree = new Ext.tree.TreePanel({
	   	autoScroll:true,
	   	root			:projectTreeNode,
	   	rootVisible 	:false,
	   	region          :'west',
	   	loader			:projectTreeLoader,
	   	width			:300,
	   	height			:400
	});
	
	
	////////////////////////////////////
	
	//打开对角色窗口
	function _openSQ(jsStr){
		_jsStr = fnFs.getForm().findField("funrole").getValue();
		
		_ProjectJSWin.show();
		
		if(_initload){
			_ProjectJSTreeLoaderRoot.reload();
		}
	}

	var _ProjectJSTreeLoader = new Ext.tree.TreeLoader({
		dataUrl		: 'xm.do?method=queryProjectJSTree',
		listeners	:{
			loadexception:function(tree,node,response){
				Ext.Msg.alert("加载失败",response.responseText);
			}
		}
	});

	_ProjectJSTreeLoader.on("beforeload", function(treeLoader, node) {
			//在beforeload事件中每次动态传递点击的节点的value属性作为参数
	       	this.baseParams = {jsStr:_jsStr,xmbm:_xmbm};
		}, 
		_ProjectJSTreeLoader
	);

	_ProjectJSTreeLoader.on("load", function(treeLoader, node, response) {
			_initload = true;
			
			var o = Ext.decode(response.responseText);
			if(o.messages && o.messages.length>0){
				Ext.Msg.alert("提示",o.messages[0]);
			}
		}, 
		_ProjectJSTreeLoader
	);
	
	var _ProjectJSTreeLoaderRoot = new Ext.tree.AsyncTreeNode({
		text:'根'
	});
	
	var __ProjectJSTree = new Ext.tree.TreePanel({
	   	autoScroll:true,
	   	root			:_ProjectJSTreeLoaderRoot,
	   	rootVisible 	:false,
	   	region          :'west',
	   	loader			:_ProjectJSTreeLoader,
	   	width			:300,
	   	height			:400
	});
	
	var _ProjectJSWin = new Ext.Window({
		title:'选择角色',
		closeAction:'hide',
		modal:true,
		width:400,
		height:400,
		margins:'5',
		layout:'fit',
		items:__ProjectJSTree,
		listeners:{
			show:function(){
				
			}
		},
		buttons:[
			new Ext.Button({
				text:'确定',
				minWidth:75,
				handler:function(){
					//授权
					var root = _ProjectJSTreeLoaderRoot;
					for(i=0;i<root.childNodes.length;i++){
						var xmmc = root.childNodes[i].text;
						var xmbm = root.childNodes[i].attributes.code.code;
						var jslist = "";
						var jslistxm = "";
						
						var child = root.childNodes[i].childNodes;
						if(child && child.length>0){
							for(j=0;j<child.length;j++){
								if(child[j].getUI().isChecked()){
									var js = child[j].attributes.js;
									if(jslist==""){
										jslist = js.roleBm;
										jslistxm= js.roleName;
									}else{
										jslist += "," + js.roleBm;
										jslistxm+= "," + js.roleName;
									}
								}
							}
						}
						//
					}
					
					fnFs.getForm().findField("funrolexm").setValue(jslistxm);
					fnFs.getForm().findField("funrole").setValue(jslist);
					_ProjectJSWin.hide();
				}
			}),
			new Ext.Button({
				text:'关闭',
				minWidth:75,
				handler:function(){
					_ProjectJSWin.hide();
				}
			})
		]
	});
	////////////////////////////////////
	
	//绑定单击事件
	projectTree.on("click", function(node,e) {
			if(node.attributes.code){
				
				//fnQueryFs.getForm().reset();
				if(selnode != node){
					fnCommonStore.removeAll();
				}
				selnode = node;
				_xmbm = node.attributes.code.code;
				
				fnQueryFs.setTitle("功能点列表【"+node.attributes.code.name+"】");
				Ext.getCmp("xmbm").setValue(_xmbm);
				Ext.getCmp("xmbm2").setValue(_xmbm);
				Ext.getCmp("but_add").setDisabled(false);
				Ext.getCmp("but_query").setDisabled(false);
				
				//initDict();
			}
		},projectTree
	);
	
	fnFs = new Ext.form.FormPanel({
    	height: 100,
    	region: 'north',
    	anchor:'100% 100%',
    	buttonAlign:'right',
    	labelAlign:'right',
    	frame:true,
    	border:false,
    	fileUpload: true, 
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
            		name:'xmbm2',
            		id:'xmbm2',
            		xtype:'hidden'
            	},{
            		name:'funid',
            		id:'funid',
            		xtype:'hidden'
            	},{
            		name:'funrole',
            		id:'funrole',
            		xtype:'hidden'
            	},{
	                columnWidth:.5,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'xmmc',
									id:'xmmc',
									disabled:true,
									maxLength:40,
									allowBlank:false,
									fieldLabel:'项目名称'
								}]
							},{
	                columnWidth:.5,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'functionBm',
									id:'functionBm',
									maxLength:40,
									allowBlank:false,
									//readOnly:true,
									fieldLabel:'<span style="color:red">*</span>功能点编码'
								}]
							},{
	                columnWidth:.5,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'functionName',
									maxLength:20,
									allowBlank:false,
									fieldLabel:'<span style="color:red">*</span>功能点名称'
								}]
							},{
	                columnWidth:.5,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'numberfield',
									maxLength:4,
									anchor:'100%',
									name:'functionOrder',
									fieldLabel:'排序'
								}]
							},{
	                columnWidth:1,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'functionUrl',
									maxLength:40,
									fieldLabel:'功能点URL'
								}]
							},{
	                columnWidth:1,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'functionDesc',
									maxLength:20,
									fieldLabel:'功能点描述'
								}]
							},{
	                columnWidth:1,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									id:'funrolexm',
									anchor:'100%',
									name:'funrolexm',
									style: 'background-image: url("");background-color: #F0F0F0;',
									fieldLabel:'关联角色',
									listeners:{
										render:function(p){
											p.getEl().on('dblclick',function(p){
												_openSQ('');
											})
										}
									}
									
								}]
							}
			],buttons:[
				new Ext.Button({
				text:'保存',
				minWidth:75,
				id:'saveBtnFn',
				handler:function(){
					saveFn();
				}
			}),
			new Ext.Button({
				text:'关闭',
				minWidth:75,
				id:'closeBtnMove',
				handler:function(){
					fnmxWin.hide();
				}
			})
		]
		}]
	});
	
	
	fnCommonStore = new Ext.data.JsonStore({
        url: 'xm.do?method=queryFn',
        root: 'list',
        id:'id_fnst',
        totalProperty:'totalCount',
        fields: [
								"funid",
								"functionBm",
								"functionName",
								"functionDesc",
								"functionUrl",
								"functionOrder"
				],
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
    });
    
  	fnCommonStore2 = new Ext.data.JsonStore({
        url: 'xm.do?method=queryFnByBm',
        root: 'list',
        id:'id_fnst2',
        totalProperty:'totalCount',
        fields: [
								"funid",
								"functionBm",
								"functionName",
								"functionDesc",
								"functionUrl",
								"functionOrder",
								"funrole",
								"funrolexm"
				],
        listeners:{
        	load:function(mystore,res){
        		myMask.hide();
        		if(res.length>0){
        			Ext.getCmp("saveBtnFn").setDisabled(false);
        			fnFs.getForm().setValues(res[0].data);
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
    
	function saveFn(){
		if(!fnFs.getForm().isValid()){
			Ext.Msg.alert("提示","数据校验没有通过，请检查！");
			return;
		}
		
		Ext.Msg.wait("正在保存信息，请稍后...", "等待");
		
	    fnFs.getForm().submit({
	       	url:"xm.do?method=saveFn",
	       	method:'POST',
	       	success:function(form,action){
						Ext.Msg.hide();
						if(action.result && action.result.message)
		    			Ext.Msg.alert("保存成功",action.result.message);
		    		else
		    			Ext.Msg.alert("保存成功","操作执行成功");
		    			
		    		if(saveusid==""){
							fnFs.getForm().reset();
		    		}else{
							if(action.result){
								var data = Ext.decode(action.result.result);
								if(data){
									var r = fnCommonStore.getById(saveusid);
									if(r)
										for(o in data)
											r.set(o,data[o]);
								}
							}
						}
					fnCommonStore.reload();
					},
					failure:function(form,action){
						Ext.Msg.hide();
						
						if(action.result && action.result.message)
							showError(action.result.message);
						else
							showError(action.response.responseText);
					}
		});
	}
	
	var fnCsm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var fnColModel = new Ext.grid.ColumnModel([
		fnCsm,{
	        header: "功能点编码",
	        dataIndex: "functionBm",
	        sortable: true,
			width: 100
	    },{
	        header: "功能点名称",
	        dataIndex: "functionName",	
	        sortable: true,
			width: 100,
			renderer:function(value){
				return value;
			}
	    },{
	        header: "功能点URL",
	        dataIndex: "functionUrl",	
	        sortable: true,
			width: 200,
			renderer:function(value){
				return value;
			}
	    },{
	        header: "功能点描述",
	        dataIndex: "functionDesc",	
	        sortable: true,
			width: 200
	    }
	]);
	var fnGrid = new Ext.grid.GridPanel({
        store: fnCommonStore,
        region: 'center',
        view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		stripeRows: true,
        cm: fnColModel,
        sm: fnCsm,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
        border:true,
        anchor:'100% 100%',
	    margins: '5 0 0 0',  
        frame:false,
		iconCls:'icon-grid',
		listeners:{
			rowclick:function(g, rowIndex, e){
				
			},
			rowdblclick:function(g, rowIndex, e){
				curRy = g.store.getAt(rowIndex);
				editfn(curRy.data.funid);
			}
		},
        title:'',
        bbar: new Ext.PagingToolbar({
				pageSize: pageSize,
				store: fnCommonStore,
				displayInfo: true
		})
    });	
    
	var fnQueryFs = new Ext.form.FormPanel({
	    title:'功能点列表',
    	height: 100,
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
            		id:'xmbm',
            		name:'xmbm',
            		xtype:'hidden'
            	},{
	                columnWidth:.33,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'functionBm',
									fieldLabel:'功能点编码'
								}]
							},{
	                columnWidth:.33,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'functionName',
									fieldLabel:'功能点名称'
								}]
							},{
	                columnWidth:.34,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'functionUrl',
									fieldLabel:'功能点URL'
								}]
							}
						]
					}],
					buttons:[
						new Ext.Button({
							id:'but_query',
							text:'查询',
							tooltip:'需在右边树中选择项目后再查询',
							disabled:'true',
							minWidth:75,
							handler:function(){
								var p = fnQueryFs.getForm().getValues();
								fnCommonStore.baseParams = p;
								fnCommonStore.load({params:{start:0, limit:pageSize}})
							}
						}),
						new Ext.Button({
							id:'but_add',
							text:'新增',
							tooltip:'需在右边树中选择项目后再新增',
							disabled:'true',
							minWidth:75,
							handler:function(){
								if(selnode==null || !selnode.attributes.code){
									Ext.Msg.alert("提示","新增功能点，必须先在右边树中选择一个项目！");
									return;
								}
								editfn("");
							}
						}),
						new Ext.Button({
							text:'删除',
							minWidth:75,
							handler:function(){
								deleteFn();
							}
						})
					]
				});
	
	//删除功能点			
	function deleteFn(){
		
		var res = fnCsm.getSelections();
		if(res.length==0){
			Ext.Msg.alert("提示","必须选择需要删除的功能点！");
			return;
		}
		
		Ext.Msg.show({
		   title:'提示',
		   msg: '确认要删除选择的功能点吗？',
		   buttons: Ext.Msg.YESNO,
		   fn: function(btn,text){
		  		if(btn=="yes"){
		 			var ids = "";
		   			for(var i=0;i<res.length;i++)
		   				ids += res[i].data.funid + ",";
					
					//删除
					Ext.Msg.wait("正在删除选择的功能点，请稍后...", "等待");
					
					Ext.Ajax.request({
						url:'xm.do?method=deleteFn',
						method:'POST', 
						params:{ids:ids},
						success:function(result,request){ 
							Ext.Msg.hide();
							var jsonData = Ext.util.JSON.decode(result.responseText);
							if(jsonData.success){
								var res = fnCsm.getSelections();
								Ext.each(res,function(r){
									fnCommonStore.remove(r);
								});
								Ext.Msg.alert("提示",jsonData.messages[0]);
							}else{
								showError(jsonData.messages[0]);
							}
						}, 
						failure: function ( result, request) {
							Ext.Msg.hide();
							showError(result.responseText); 
						}
					}); 
		  		}
		   },
		   icon: Ext.MessageBox.QUESTION
		});
	}
	
	function editfn(usid){
		fnmxWin.show();
		
		fnFs.getForm().reset();
		fnFs.getForm().findField('xmmc').setValue(selnode.attributes.code.name);
		
		if(usid!=""){
			saveusid = usid;
			Ext.getCmp("saveBtnFn").setDisabled(true);
			
			myMask.show();
			fnCommonStore2.load({params:{funid:usid}});
			fnmxWin.setTitle("修改功能点");
			//功能点编码不允许变更，如果变更，则需要添加关联表更新逻辑
      fnFs.getForm().findField("functionBm").getEl().dom.readOnly=true;
      fnFs.getForm().findField("functionBm").toolTip="asdf";
			
		}else{
			saveusid = "";
			Ext.getCmp("saveBtnFn").setDisabled(false);
			fnmxWin.setTitle("新增功能点");
			fnFs.getForm().findField("functionBm").getEl().dom.readOnly=false;
		}
		
		
		//if(!isinit){
			//isinit = true;
			initDict();
		//}
	}
	
	
	var fnmxWin = new Ext.Window({
		title:'修改',
		closeAction:'hide',
		modal:true,
		width:600,
		height:300,
		margins:'5',
		layout:'fit',
		items:fnFs
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
	            margins:'5 5 5 0',
	            autoScroll:true,
	            items:[{
	            	layout:'border',
	            	frame:false,
	            	border:false,
	            	margins: '0',
	            	items:[
	            		fnQueryFs,fnGrid
	            	]
	            }]
	        },{
	            region				:'west',
	            layout				:'fit',
	            border				:false,
	            frame				:false,
	           	bodyStyle			:'overflow:scroll;overflow-x:hidden',
	            margins				:'5 0 5 5',
	            autoScroll			:true,
	            collapsible			:true,
           		splitTip			: "拖动来改变尺寸.",	//SplitRegion的构造参数
            	collapsibleSplitTip	:'拖动来改变尺寸. 双击隐藏',
	            split				:true,
				collapseMode		:'mini',//SplitRegion的构造参数
	            width				:300,
	            items				:[projectTree]
	        }]
	});
	
	
	//fnmxWin.show();
	//fnmxWin.hide();
	
	if(!isinit){
		isinit = true;
		initDict();
	}
	
});