
var pageSize = 15;
var selnode = null;
var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"操作执行中，请等待..."});
var _dwcode = null;
var t_dataUrl ="";
var t_sjfw ="";


Ext.onReady( function() {
    Ext.QuickTips.init();
	
	var projectTreeNode = new Ext.tree.AsyncTreeNode({
		text:'根'
	});
	
	t_dataUrl='jgryhf.do?method=queryZzjgJyTree';
	if(window._isAdmin && window._isAdmin!="1"){
		t_dataUrl='jgryhf.do?method=queryZzjgJyTree&sjfw=' + window._sjfw;
		t_sjfw=window._sjfw;
	}
		
	var projectTreeLoader = new Ext.tree.TreeLoader({
		dataUrl		: t_dataUrl,
		listeners	:{
			loadexception:function(tree,node,response){
				Ext.Msg.alert("提示","项目树加载失败：" + response.responseText);
			}
		}
	});
	
	projectTreeLoader.on("beforeload", function(treeLoader, node) {
			//在beforeload事件中每次动态传递点击的节点的value属性作为参数
			
			if(node.attributes.code){
				this.dataUrl ="jgryhf.do?method=queryZzjgJyTree&organizeBm=" + node.attributes.code.code;
	    }
		}, 
		projectTreeLoader
	);
	
	projectTreeLoader.on("load", function(treeLoader, node, response) {
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
	

	

	
	////////////////////////////////////
	
	//绑定单击事件
	projectTree.on("click", function(node,e) {
			if(node.attributes.code){
				
				//fnQueryFs.getForm().reset();
				if(selnode != node){
					fnCommonStore.removeAll();
				}
				selnode = node;
				_dwcode = node.attributes.code.code;
				
				fnQueryFs.setTitle("已删除用户列表【"+node.attributes.code.name+"】");
				fnQueryFs.getForm().findField("organizeBm").setValue(_dwcode);
				
			}
		},projectTree
	);
	
	
	
	fnCommonStore = new Ext.data.JsonStore({
        url: 'jgryhf.do?method=queryZzjy',
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
			"bz",
			"jh"
        ],
        listeners:{
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
    
	
	var fnCsm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var fnColModel = new Ext.grid.ColumnModel([
		fnCsm,{
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
	        header: "警号",
	        dataIndex: "jh",	
	        sortable: true,
			width: 100,
			renderer:function(value){
				return value;
			}
	    },{
	        header: "身份证",
	        dataIndex: "idcard",	
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
	    title:'已删除用户列表',
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
            		id:'organizeBm',
            		name:'organizeBm',
            		xtype:'hidden'
            	},{
            		id:'zxbz',
            		name:'zxbz',
            		value:'1',
            		xtype:'hidden'
            	},{
            		id:'ccm',
            		name:'ccm',
            		value:t_sjfw,
            		xtype:'hidden'
            	},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'loginName',
									fieldLabel:'登录名'
								}]
							},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'xm',
									fieldLabel:'姓名'
								}]
							},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'jh',
						fieldLabel:'警号'
					}]
				},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'idcard',
									fieldLabel:'身份证号码'
								}]
							}
						]
					}],
					buttons:[
						new Ext.Button({
							text:'查询',
							minWidth:75,
							id:'queryBtn',
							handler:function(){
								var p = fnQueryFs.getForm().getValues();
								fnCommonStore.baseParams = p;
								fnCommonStore.load({params:{start:0, limit:pageSize}})
							}
						}),
						new Ext.Button({
							text:'恢复',
							minWidth:75,
							handler:function(){
								recoverRy();
							}
						})
					]
				});
	
	//恢复人员			
	function recoverRy(){
		
		var res = fnCsm.getSelections();
		if(res.length==0){
			Ext.Msg.alert("提示","必须选择需要恢复的人员！");
			return;
		}
		
		Ext.Msg.show({
		   title:'提示',
		   msg: '确认要恢复已选择的人员吗？',
		   buttons: Ext.Msg.YESNO,
		   fn: function(btn,text){
		  		if(btn=="yes"){
		 			var ids = "";
		   			for(var i=0;i<res.length;i++)
		   				ids += res[i].data.usid + ",";
					
					//恢复
					Ext.Msg.wait("正在恢复选择的人员，请稍后...", "等待");
					
					Ext.Ajax.request({
						url:'jgryhf.do?method=recoverRy',
						method:'POST', 
						params:{ids:ids},
						success:function(result,request){ 
							Ext.Msg.hide();
							var jsonData = Ext.util.JSON.decode(result.responseText);
							if(jsonData.success){
								var box = Ext.MessageBox.alert(
									'提示', 
									jsonData.messages[0] + " 关闭对话框刷新页面！",
									function(btnType){
										window.document.location.reload();
									},
									window
								);	
								/*
								var res = fnCsm.getSelections();
								Ext.each(res,function(r){
									fnCommonStore.remove(r);
								});
								Ext.Msg.alert("提示",jsonData.messages[0]);
								*/
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
	
	
	
	
});