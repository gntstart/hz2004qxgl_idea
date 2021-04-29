var isinit = false;

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
	
	//绑定单击事件
	projectTree.on("click", function(node,e) {
			if(node.attributes.code){
				xmFs.getForm().reset();
				xmFs.show();
				var xmbm = node.attributes.code.code;
				xmCommonStore.load({params:{start:0, limit:10,xmbm:xmbm}})
			}else{
			  xmFs.hide();
			}
		},projectTree
	);
	
	xmFs = new Ext.form.FormPanel({
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
            		name:'xmgly',
            		id:'xmgly',
            		xtype:'hidden'
            	},{
	                columnWidth:.33,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'xmbm',
									allowBlank:false,
									readOnly:true,
									fieldLabel:'项目编码'
								}]
							},{
	                columnWidth:.33,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'xmmc',
									maxLength:20,
									allowBlank:false,
									fieldLabel:'<span style="color:red">*</span>项目名称'
								}]
							},{
	                columnWidth:.33,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									hiddenName:'zxbz',
									anchor:'100%',
									allowBlank:false,
									xtype:'DictComboBox',
									dict:"VisionType=ZXBZ&ignore=false",
									fieldLabel:'<span style="color:red">*</span>注销标志'
								}]
							},{
	                columnWidth:1,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'textfield',
									anchor:'100%',
									name:'xmsm',
									maxLength:40,
									fieldLabel:'项目描述'
								}]
							},{
	                columnWidth:1,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 0 0 0',
        	       	items: [{
									xtype:'DictTextField',
									id:'xmglyxm',
									anchor:'100%',
									dict:"vid=xmgly&tid=xmglyxm&VisionType=RY&mselect=true",
									name:'xmglyxm',
									fieldLabel:'项目管理员'
								}]
							}
			],buttons:[
				new Ext.Button({
				text:'保存',
				minWidth:75,
				id:'saveBtnJG',
				handler:function(){
					saveXm();
				}
			})
		]
		}]
	});
	
	
	xmCommonStore = new Ext.data.JsonStore({
        url: 'xm.do?method=queryXmByBm',
        root: 'list',
        id:'usid',
        totalProperty:'totalCount',
        fields: [
								"xmbm",
								"xmmc",
								"xmsm",
								"cjsj",
								"zxbz",
								"xmgly",
								"xmglyxm"
				],
        listeners:{
        	load:function(mystore,res){
        		if(res.length>0){
        			xmFs.getForm().setValues(res[0].data);
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
    
	function saveXm(){
		if(!xmFs.getForm().isValid()){
			Ext.Msg.alert("提示","数据校验没有通过，请检查！");
			return;
		}
		
		Ext.Msg.wait("正在保存信息，请稍后...", "等待");
		
	    xmFs.getForm().submit({
	       	url:"xm.do?method=saveXm",
	       	method:'POST',
	       	success:function(form,action){
						Ext.Msg.hide();
						if(action.result && action.result.message)
		    			Ext.Msg.alert("保存成功",action.result.message);
		    		else
		    			Ext.Msg.alert("保存成功","操作执行成功");
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
	            //html:'ttt'
	            items				:[xmFs]
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
	
	xmFs.hide();
	if(!isinit){
		isinit = true;
		initDict();
	}
	
});