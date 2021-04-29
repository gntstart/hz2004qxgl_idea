var curCcm = "";
var pageSize = 15;

//当前人员
var ryQueryFs = null;
var curRy = null;
var ryCommonStore2 = null;
var ryCommonStore = null;

var jzCommonStore = null;
var rymxFs = null;
var rymxWin = null;
var saveusid = null;
var isinit = false;
var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"操作执行中，请等待..."});
var selnode = null;
var ryCsm = null;
var tabwin = null;
var initData = {};
var seluid = null;

//定义控制菜单
var menu,menu2;
var mynode;

var moveWin = null;
var moveryFs = null;
var jzWin = null;
var queryDwCommonStore = null;

function setcolor(value, metaData, record, rowIndex, colIndex, store){
    	if(value==null)
    		value = "";
    		
    	var d = record.data;
    	if(d.yhzt=="2")
    		return "<span style='color:red'>" + value + "</span>";
    	
    	return value;
}

function changejy(yhzt){
	var res = ryCsm.getSelections();
	if(res.length==0){
		Ext.Msg.alert("提示","必须选择需要操作的用户！");
		return;
	}
	
	var optype = (yhzt=="0"?"恢复":"删除");
	Ext.Msg.show({
	   title:'提示',
	   msg: '确认要' + optype  +  '选择的用户吗？',
	   buttons: Ext.Msg.YESNO,
	   fn: function(btn,text){
	  		if(btn=="yes"){
	 			var ids = "";
	 			var dwbm = "";
	   			for(var i=0;i<res.length;i++){
	   				ids += res[i].data.yhid + ",";
	   				dwbm = res[i].data.dwdm;
	   			}

				//删除
				Ext.Msg.wait("正在" + optype + "选择的警员，请稍后...", "等待");
				
				Ext.Ajax.request({
					url:'zzjy.do?method=changeZzjyZt',
					method:'POST', 
					params:{ids:ids,yhzt:yhzt,dwbm:dwbm.substring(0,4)},
					success:function(result,request){ 
						Ext.Msg.hide();
						var jsonData = Ext.util.JSON.decode(result.responseText);
						if(jsonData.success){
							var res = ryCsm.getSelections();
							Ext.each(res,function(r){
								r.set("yhzt", yhzt);
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

function initpwd(usid,xm){
	Ext.Msg.wait("正在初始化[" + xm + "]的密码，请稍后...", "等待");
	Ext.Ajax.request({
		url:'zzjy.do?method=initPassword',
		method:'POST', 
		params:{id:usid},
		success:function(result,request){ 
			Ext.Msg.hide();
			//alert(result.responseText);
			var jsonData = Ext.util.JSON.decode(result.responseText);
			if(jsonData.success){
				if(jsonData.messages && jsonData.messages.length>0){
					Ext.Msg.alert("提示",jsonData.messages[0]);
				}else{
					Ext.Msg.alert("提示","操作执行成功！");
				}
			}
		}, 
		failure: function ( result, request) {
			Ext.Msg.hide();
			showError(result.responseText); 
		} 
	}); 
}

function save(){
	if(!rymxFs.getForm().isValid()){
		Ext.Msg.alert("提示","数据校验没有通过，请检查！");
		return;
	}
	
	var data = rymxFs.getForm().getValues();

	//if(!isIDCard2(data.gmsfhm)){
	//	Ext.Msg.alert("提示","必须输入合法身份证号！");
	//	return;
	//}

	//if(data.yhxb!=null && data.yhxb!=""){
	//	var xb = getIDCardSex(data.gmsfhm);
	//	if(xb.length<=2 && xb!=data.yhxb){
	//		Ext.Msg.alert("提示","身份证号码和性别不符！");
	//		return;
	//	}
	//}
	
	if(data.yhid && data.yhid.length>=1){
		//修改
		if(data.editpwd=='1'){
			//修改密码
			if(!data.dlkl || data.dlkl.length<1){
				Ext.Msg.alert("提示","必须输入登录口令！");
				return;
			}
		}
	}else{
		//新增
		if(!data.dlkl || data.dlkl.length<1){
			Ext.Msg.alert("提示","新建用户必须输入登录口令！");
			return;
		}
	}
	
	Ext.Msg.wait("正在保存，请稍后...");
	Ext.Ajax.request({
		url:'zzjy.do?method=saveZzjy',
		method:'POST', 
		params:data,
		success:function(result,request){ 
			Ext.Msg.hide();
			
			var jsonData = Ext.util.JSON.decode(result.responseText);
			if(jsonData.success){
				if(jsonData.messages && jsonData.messages.length>0){
					Ext.Msg.alert("提示",jsonData.messages[0]);
				}else{
					Ext.Msg.alert("提示","操作执行成功！");
				}
				
				var data = jsonData.list[0];
				
				var r= ryCommonStore.getById(data.yhid);
				if(r){
					for(var pname in data){
						r.set(pname,data[pname]);
					}
				}else{
					var r1 = new ryCommonStore.reader.recordType(data,data.yhid);
					ryCommonStore.insert(0, [r1]);
					curRy = r1;
					
					editry(r1.data.yhid);
					rymxFs.getForm().setValues(data);
					tabwin.setTitle("修改人员资料");
					
					Ext.getCmp("gridip").setDisabled(false);
					Ext.getCmp("gridsjfw").setDisabled(false);
					Ext.getCmp("gridtdqx").setDisabled(false);
					Ext.getCmp("gridddqx").setDisabled(false);
				}
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

var isnewry = true;

function editry(yhid){
	rymxFs.getForm().reset();
	var cmp = Ext.getCmp("yhdlm");
	
	if(yhid!=""){
		isnewry = false;
		
		saveusid = yhid;
		Ext.getCmp("saveBtn").setDisabled(true);
		Ext.getCmp("sqBtn").setDisabled(true);
		Ext.getCmp("saveDwBtn").setDisabled(true);
        
		if(jy_xm_edit=="0"){
			Ext.getCmp("_xm_").setDisabled(true);
			Ext.getCmp("_jh_").setDisabled(true);
		}else{
			Ext.getCmp("_xm_").setDisabled(false);
			Ext.getCmp("_jh_").setDisabled(false);
		}
		//Ext.getCmp("gmsfhm").setDisabled(true);
		//cmp.setDisabled(true);
		cmp.allowBlank = true;
						
		myMask.show();
		
		var r = ryCommonStore.getById(yhid);
		ryCommonStore2.load({params:{start:0, limit:pageSize,yhid:yhid,dwdm:r.data.dwdm}})
		tabwin.setTitle("修改人员资料");
	}else{
		saveusid = "";
		isnewry = true;
              //  Ext.getCmp("_xm_").setDisabled(true);
		//Ext.getCmp("yhdlm").setDisabled(true);
		//Ext.getCmp("gmsfhm").setDisabled(true);
		//Ext.getCmp("_jh_").setDisabled(true);
		//cmp.allowBlank = false;
		
		Ext.getCmp("saveBtn").setDisabled(false);
		Ext.getCmp("sqBtn").setDisabled(true);
		Ext.getCmp("saveDwBtn").setDisabled(true);
		var jg = selnode.attributes.dw;
		
		rymxFs.getForm().setValues({dwmc:jg.mc,dwdm: jg.dm});
		tabwin.setTitle("新增人员");
	}
	initDict();
	tabwin.show();

	if(isnewry){
		jzWin.show();
		queryDwCommonStore.baseParams = {newuserflag:"1",dwdm: selnode.attributes.dw.dm};
		queryDwCommonStore.load({params:{start:0, limit:20}})
	}
	
	if(!isinit){
		isinit = true;
		initDict();
	}
}

function movery(zzjy){
	moveWin.setTitle("移动警员：" + zzjy.xm);
	moveWin.show();
	
	moveryFs.getForm().reset();
	moveryFs.getForm().setValues({usid:zzjy.usid,organizePath:zzjy.organizePath,oldOrgBm:zzjy.organizeBm});
}

function queryry(){
	var p = ryQueryFs.getForm().getValues();
	ryCommonStore.baseParams = p;
	ryCommonStore.load({params:{start:0, limit:pageSize}})
}

Ext.onReady( function() {
    Ext.QuickTips.init();
    
	var moveDict = "vid=movetoOrgBm&tid=movetoOrgBmname&VisionType=DW&ignore=false";
	if(window._isAdmin && window._isAdmin!="1"){
		moveDict += "&sjfw=" + window._sjfw;
	}


	/********************************人员查询和列表*******************************/
 	ryCommonStore2 = new Ext.data.JsonStore({
	        url: 'zzjy.do?method=queryZzjyById',
	        root: 'list',
	        id:'yhid',
	        totalProperty:'totalCount',
	        fields: [
				"yhid","uid","yhdlm","jyh","dwdm","yhxm","yhxb","yhzw","dlkl","yhmj","czmj","yhzt","gmsfhm","dwmc","lxdh","zwmc"
	        ],
	        listeners:{
	        	load:function(mystore,res){
	        		myMask.hide();
	        		if(res.length>0){
	        			
	        			Ext.getCmp("saveBtn").setDisabled(false);
	        			Ext.getCmp("sqBtn").setDisabled(false);
	        			Ext.getCmp("saveDwBtn").setDisabled(false);
	        			rymxFs.getForm().setValues(res[0].data);
	        			//alert(Ext.encode(res[0].data));
	        			curRy = res[0];
	        			
	        			var data = res[0].data;
	        			if(data.czmj){
	        				for(var i=0;i<data.czmj.length;i++){
	        					var val = data.czmj.charAt(i);
	        					if(val=="1"){
	        						Ext.getCmp("czmj" + (i+1)).setValue(true);
	        					}
	        				}
	        			}
	        		}
	        	},
			loadexception:function(mystore,options,response,error){
				myMask.hide();
				if(error){
					var json = Ext.decode(response.responseText);
					Ext.Msg.alert("提示",json.messages[0]);
				}else{
					Ext.Msg.alert("提示",response.responseText);
				}
			}
        	}
    	});
    
 	ryCommonStore = new Ext.data.JsonStore({
	        url: 'zzjy.do?method=queryZzjy',
	        root: 'list',
	        id:'yhid',
	        totalProperty:'totalCount',
	        fields: ["yhid","uid","yhdlm","jyh","dwdm","yhxm","yhxb","yhzw","dlkl","yhmj","czmj","yhzt","gmsfhm","dwmc","lxdh","zwmc"],
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
    
	ryCsm = new Ext.grid.CheckboxSelectionModel({singleSelect:true});
	var ryColModel = new Ext.grid.ColumnModel([
		ryCsm,{
	        header: "用户登录名",
	        dataIndex: "yhdlm",
	        renderer: setcolor,
	        sortable: true,
			width: 80
	    },{
	        header: "姓名",
	        dataIndex: "yhxm",	
	        renderer: setcolor,
	        sortable: true,
		width: 80
	    },{
	        header: "警号",
	        dataIndex: "jyh",	
	        renderer: setcolor,
	        sortable: true,
		width: 80
	    },{
	        header: "身份证号",
	        renderer: setcolor,
	        dataIndex: "gmsfhm"
	    },{
	        header: "联系电话",
	        renderer: setcolor,
	        dataIndex: "lxdh"
	    },{
	        header: "职位",
	        renderer: setcolor,
	        dataIndex: "zwmc"
	    }, {
	        header: "单位",
	        renderer: setcolor,
	        dataIndex: "dwmc"
	    },{
	        header: "用户状态",
	        dataIndex: "yhzt",
	        renderer:function(value){
	        	if(value=="0")
	        		return "正常";
	        	else
	        		return "<span style='color:red'>已删除</span>";
	        }
	    }
	]);
	
	 ryQueryFs = new Ext.form.FormPanel({
	    title:'用户列表',
    	height: 130,
    	region: 'north',
    	anchor:'100% 100%',
    	buttonAlign:'right',
    	labelAlign:'right',
    	frame:true,
    	border:false,
    	margins:'0',
        layout:'form',
        labelWidth:100,
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
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'gmsfhm',
						fieldLabel:'身份证号码'
					}]
		},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'lxdh',
						fieldLabel:'联系电话'
					}]
		}, {
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'yhxm',
						fieldLabel:'姓名'
					}]
				},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'yhdlm',
						fieldLabel:'用户登录名'
					}]
				},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'jyh',
						fieldLabel:'警号'
					}]
				},{
	                columnWidth:.5,
    	           	layout: 'form',
    	           	bodyStyle:'padding:5 15 0 0',
        	       	items: [{
						xtype:'checkbox',
						name:'yhzt',
						inputValue:'1',
						fieldLabel:'显示删除用户',
						listeners:{
							check :function (chk,  checked){
								queryry();
							}
						}
					}]
				}
			]
		}],
		buttons:[
			new Ext.Button({
				text:'查询用户',
				minWidth:75,
				id:'queryBtn',
				handler:function(){
					if(selnode==null || !selnode.attributes.dw){
						Ext.Msg.alert("提示","必须先在右边树中选择单位！");
						return;
					}
					queryry();
				}
			}),
			new Ext.Button({
				text:'新增用户',
				minWidth:75,
				handler:function(){
					if(selnode==null || !selnode.attributes.dw){
						Ext.Msg.alert("提示","新增人员，必须先在右边树中选择地区单位！");
						return;
					}

					if(selnode.attributes.dw.dm=='340000000000'){
						Ext.Msg.alert("提示","不能在省厅下面添加用户，必须先在右边树中选择地区单位！");
						return;
					}
					
					editry("");
				}
			}),
			new Ext.Button({
				text:'修改用户',
				minWidth:75,
				handler:function(){
					var res = ryCsm.getSelections();
					if(res.length<=0){
						Ext.Msg.alert("提示","请直接双击人员或者只选择一个需要修改的人员！");
						return;
					}
					
					var jy = res[0].data;
					editry(jy.yhid);
				}
			}),
			new Ext.Button({
				text:'删除用户',
				minWidth:75,
				handler:function(){
					changejy('2');
				}
			}),
			new Ext.Button({
				text:'恢复用户',
				id:'yhryBtn',
				minWidth:75,
				handler:function(){
					changejy('0');
				}
			})
		]
	});
	
	var res = null;

	var ryGrid = new Ext.grid.GridPanel({
	        store: ryCommonStore,
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
				var r = g.store.getAt(rowIndex);
				if(r.data.yhzt=='0')
					Ext.getCmp("yhryBtn").setDisabled(true);
				else
					Ext.getCmp("yhryBtn").setDisabled(false);
			},
			rowdblclick:function(g, rowIndex, e){
				curRy = g.store.getAt(rowIndex);
				editry(curRy.data.yhid);
			}
		},
	        title:'',
	        bbar: new Ext.PagingToolbar({
					pageSize: pageSize,
					store: ryCommonStore,
					displayInfo: true
			})
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
	            	split:true,
           		splitTip: "拖动来改变尺寸.",	//SplitRegion的构造参数
            		collapsibleSplitTip:'拖动来改变尺寸. 双击隐藏',
			collapseMode:'mini',//SplitRegion的构造参数
	            	//title:'选择单位或者用户',
	           	 width:300,
	           	 items:[
	           	 	_UserTree
	           	 ]
	        }]
	});
		
	//绑定单击事件
	_UserTree.on("click", function(node,e) {
			if(node.attributes.dw && !node.attributes.zzjy){
				var ccm = node.attributes.dw.dm;
				if(curCcm==ccm)
					return;
					
				curCcm = ccm;
				
				Ext.getCmp("ccm").setValue(ccm);
				
				selnode = node;
				
				queryry();
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
	
	var sjfwDict = "vid=sjfw&tid=sjfwname&VisionType=CCM&ignore=false&postDetailOnlyOne=1&postDetail=" + defSjfw;
	if(window._isAdmin && window._isAdmin!="1"){
		sjfwDict += "&sjfw=" + window._sjfw;
	}
	
	rymxFs = new Ext.form.FormPanel({
	    	height: 100,
	    	region: 'north',
	    	anchor:'100% 100%',
	    	buttonAlign:'right',
	    	labelAlign:'right',
	    	title:'用户资料',
	    	frame:true,
	    	border:false,
	    	fileUpload: true, 
	    	margins:'0',
	        layout:'form',
	        labelWidth:100,
	       	items:[{
        		layout:'column',
    			frame:false,
    			border:false,
        		defaults:{
        			border:false,
        			frame:false
        		},
	            	items:[{
	            		name:'dwdm',
	            		xtype:'hidden'
	            	},{
	            		name:'yhid',
	            		xtype:'hidden'
	            	},{
	            		name:'sjfw',
	            		id:'sjfw',
	            		xtype:'hidden'
	            	},{
		                columnWidth:.5,
	    	           	layout: 'form',
	    	           	bodyStyle:'padding:5 0 0 0',
	        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						allowBlank:false,
						readOnly:true,
						name:'gmsfhm',
						id:'gmsfhm',
						fieldLabel:'身份证号<span style="color:red">*</span>'
						/*
						 * listeners:{
							blur:function(f){
								var sfz = f.getValue();
								if(sfz && sfz!=""){
									var xb = getIDCardSex(sfz);
									if(xb.length>2){
										Ext.Msg.alert("提示",xb);
										return;
									}
									
									rymxFs.getForm().setValues({yhxb:xb});
								}
								
								if(sfz!=null &&  sfz!="" && isnewry){
									//getXtYhksjg
									Ext.Ajax.request({
										url:'zzjy.do?method=getXtYhksjg',
										method:'POST', 
										params:{sfzh:sfz},
										success:function(result,request){ 
											Ext.Msg.hide();
											var jsonData = Ext.util.JSON.decode(result.responseText);
											if(jsonData.success && jsonData.list.length==1){
												var data = jsonData.list[0];
												var newdata = {yhdlm:data.yhm,jyh:data.jh,yhxm:data.yhm};
												rymxFs.getForm().setValues(newdata);
											}
										}, 
										failure: function ( result, request) {
											Ext.Msg.hide();
											showError(result.responseText); 
										} 
									}); 
								}
							}
						}
						 * */
					}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 15 0 0',
		        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'yhdlm',
						id:'yhdlm',
						allowBlank:false,
						readOnly:true,
						fieldLabel:'<span style="color:red">*</span>用户登录名'
					}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 0 0 0',
		        	       	items: [{
								name:'jyh',
								id:'_jh_',
								anchor:'100%',
								xtype:'textfield',
								allowBlank:false,
								readOnly:true,
								fieldLabel:'<span style="color:red">*</span>警员号'
					}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 15 0 0',
		        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'yhxm',
						allowBlank:false,
					readOnly:true,
						id:'_xm_',
						fieldLabel:'<span style="color:red">*</span>姓名'
					}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 0 0 0',
		        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'lxdh',
						allowBlank:false,
						fieldLabel:'<span style="color:red">*</span>联系电话'
					}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 15 0 0 ',
		        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						disabled:true,
						name:'dwmc',
						fieldLabel:'所属单位'
					}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 0 0 0',
		        	       	items: [{
								hiddenName:'yhxb',
								anchor:'100%',
								xtype:'DictComboBox',
								dict:"VisionType=CS_XB&def=4&ignore=false",
								fieldLabel:'性别'
						}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 15 0 0',
		        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'dlkl',
						fieldLabel:'登录口令'
					}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 0 0 0',
		        	       	items: [{
						xtype:'checkbox',
						name:'editpwd',
						inputValue:'1',
						fieldLabel:'修改口令'
					}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 15 0 0',
		        	       	items: [{
								hiddenName:'yhzw',
								anchor:'100%',
								xtype:'DictComboBox',
								dict:"VisionType=CS_YHZW&def=1&ignore=true",
								fieldLabel:'职务'
						}]
				},{
			                columnWidth:.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:5 0 0 0',
		        	       	items: [{
								hiddenName:'yhmj',
								anchor:'100%',
								xtype:'DictComboBox',
								dict:"VisionType=CS_YHMJ&ignore=false",
								value:"5",
								fieldLabel:'用户密级'
						}]
				}
			]},{
				xtype:'checkboxgroup',
				/*form布局，这里不能使用100%，否则看不到复选项，此外也必须保持
				右边足够多的空间以显示side校验信息*/
				anchor:'95%',
				fieldLabel:'操作密级（WEB专用）',
				name:'lrb',
				msgTarget:'under',
				vertical:true, 
				columns: 1,
				items:[ 
		        		{boxLabel: '系统管理员', name: 'czmj1', id:'czmj1', inputValue:"1"},
		            		{boxLabel: '上报数据专管员', name: 'czmj2', id:'czmj2',inputValue:"2"},
		            		{boxLabel: '制证专管员', name: 'czmj3', id:'czmj3',inputValue:"3"},
		            		{boxLabel: '一般用户', name: 'czmj4', id:'czmj4',inputValue:"4",checked:true}
				]
			}
		],
		buttons:[
			new Ext.Button({
				text:'保存用户资料',
				minWidth:75,
				id:'saveBtn',
				handler:function(){
					save();
				}
			}),
			new Ext.Button({
				text:'用户角色授权',
				minWidth:75,
				id:'sqBtn',
				handler:function(){
					_openSQ(curRy.data.yhid, curRy.data.yhdlm, curRy.data.dwdm);
				}
			}),
			new Ext.Button({
				text:'改变用户单位',
				minWidth:75,
				id:'saveDwBtn',
				handler:function(){
					selectDw();
				}
			})
		]
	});
	
	rymxWin = new Ext.Window({
		title:'修改',
		closeAction:'hide',
		modal:true,
		width:800,
		height:460,
		margins:'5',
		layout:'fit',
		items:rymxFs,
		listeners:{
			show:function(){
				
			}
		}
	});
	
	
	/**********************************************************************************/
	var ipform = new Ext.form.FormPanel({
		id : 'ipform',
		title : '',
		anchor : '100% 100%',
		buttonAlign : 'right',
		height : 80,
		labelAlign : 'right',
		frame : true,
		border : false,
		layout : 'form',
		labelWidth : 75,
		items:[{
			xtype:'fieldset',
			collapsible: true,
	            	title: '单IP',
	            	autoHeight:true,
	            	defaults: {width: 210},
	            	defaultType: 'textfield',
	            	collapsed: false,
	            	anchor:'100%',
	            	bodyStyle:"width:100%",
	            	layout:'form',
    	    		items:[
	     			{
					xtype:'textfield',
					anchor:'99%',
					name:'ipdz',
					fieldLabel:'单IP地址'
				}]
			},{
	           		xtype:'fieldset',
	          		collapsible: true,
	            		title: 'IP地址段',
	            		autoHeight:true,
	            		defaults: {width: 210},
	            		defaultType: 'textfield',
	            		collapsed: false,
	            		anchor:'100%',
	           	 	bodyStyle:"width:100%",
	           	 	items:[{
						anchor:'99%',
						xtype:'textfield',
						name:'startip',
						fieldLabel:'起始IP地址'
					},{
						anchor:'99%',
						xtype:'textfield',
						name:'endip',
						fieldLabel:'结束IP地址'
					}
				]
			}
		],
		buttons : [new Ext.Button({
			text : '保存设置',
			minWidth : 75,
			handler : function() {
				if (!ipform.getForm().isValid()) {
					Ext.Msg.alert("提示", "数据校验没有通过，请检查！");
					return;
				}
				
				var data = ipform.getForm().getValues();
				if(!data.ipdz && !data.startip && !data.endip){
					Ext.Msg.alert("提示","必须输入IP信息！");
					return;
				}
				
				if(data.ipdz && data.ipdz.value!=""){
					if(data.startip || data.startip){
						Ext.Msg.alert("提示","输入了单IP，那么不允许输入IP段信息！");
						return;
					}
				}else{
					if(!data.startip || !data.endip){
						Ext.Msg.alert("提示","必须同时输入IP段信息！");
						return;
					}
				}
				
				saveIPSet(data);
			}
		}), new Ext.Button({
			text : '取消',
			minWidth : 75,
			handler : function() {
				ipwin.hide();
			}
		})]
	});
	
	ipwin = new Ext.Window({
		title : 'IP地址设置',
		closeAction : 'hide',
		modal : true,
		width : 500,
		height : 280,
		layout : 'fit',
		items : ipform,
		listeners : {
			show : function(d) {
				
			}
		}
	});
	
	function addIP(){
		ipwin.show();
	}
	
	function saveIPSet(data){
		data.yhid = curRy.data.yhid;
		data.dwdm = curRy.data.dwdm;
		
		Ext.Msg.wait("正在删除，请稍后...", "等待");
		
		Ext.Ajax.request({
			url:'zzjy.do?method=createIPXZ',
			method:'POST', 
			params:data,
			success:function(result,request){ 
				Ext.Msg.hide();
				var jsonData = Ext.util.JSON.decode(result.responseText);

				if(jsonData.success){
					Ext.Msg.alert("提示",jsonData.messages[0]);
					IPStore.removeAll();
					IPStore.load({params:{start:0, limit:20}})
					
					ipwin.hide();
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
	
	function deleteIP(){
		var res = csmIP.getSelections();
		if(res.length==0){
			Ext.Msg.alert("提示","必须选择需要删除的IP！");
			return;
		}
		
		Ext.Msg.show({
		   title:'提示',
		   msg: '确认要删除选择的IP吗？',
		   buttons: Ext.Msg.YESNO,
		   fn: function(btn,text){
		  		if(btn=="yes"){
		 			var ids = "";
		   			for(var i=0;i<res.length;i++)
		   				ids += res[i].data.ipyxid + ",";
					
					//删除
					Ext.Msg.wait("正在删除，请稍后...", "等待");
					
					Ext.Ajax.request({
						url:'zzjy.do?method=deleteIPXZ',
						method:'POST', 
						params:{ids:ids, dwdm: curRy.data.dwdm},
						success:function(result,request){ 
							Ext.Msg.hide();
							var jsonData = Ext.util.JSON.decode(result.responseText);
							if(jsonData.success){
								var res = csmIP.getSelections();
								Ext.each(res,function(r){
									Ext.getCmp("gridip").store.remove(r);
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

	var IPStore = new Ext.data.JsonStore({
		  url: 'zzjy.do?method=getIPXZ',
		  root: 'list',
		  id:'ipyxid',
		  totalProperty:'totalCount',
		  fields: [
			"ipyxid","yhid","ipdz","cjrid","cjsj","dqbm","yhxm","yhdlm","cjrxm"
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
	
	var csmIP = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var colModelIP = new Ext.grid.ColumnModel([csmIP,{
	        header: "用户姓名",
	        dataIndex: "yhxm",	
	        sortable: true,
		width: 100
	     },{
	        header: "用户登录名",
	        dataIndex: "yhdlm",
	        sortable: true,
		width: 100
	    },{
	        header: "允许IP地址",
	        dataIndex: "ipdz",	
	        sortable: true,
		width: 80,
		renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			return value;
		}
	    },{
	        header: "创建人姓名",
	        dataIndex: "cjrxm",	
	        sortable: true,
		width: 80
	    },{
	        header: "创建时间",
	        dataIndex: "cjsj",	
	        sortable: true,
		width: 80
	    }
	]);
	var gridIP = new Ext.grid.GridPanel({
	        store: IPStore,
	        region: 'center',
	        view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		stripeRows: true,
		id:'gridip',
	        cm: colModelIP,
	        sm:csmIP,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
	        border:true,
	        anchor:'100% 100%',
	    	margins: '0 0 0 0',
		cmargins: '0 0 0 0',        
        	frame:false,
		iconCls:'icon-grid',
        	title:'	IP允许设置',
        	bbar: [
        		new Ext.PagingToolbar({
				pageSize: 20,
				width:200,
				hideLabel: true,
				store: IPStore,
				displayInfo: false
			}),
			'->',
			new Ext.Button({
				text:'添加用户IP',
				minWidth:75,
				handler:function(){
					addIP();
				}
			}),
			new Ext.Button({
				text:'删除用户IP',
				minWidth:75,
				handler:function(){
					deleteIP();
				}
			})
		]
    	});
    	
    	function deleteSJFW(){
		var res = csmSJFW.getSelections();
		if(res.length==0){
			Ext.Msg.alert("提示","必须选择需要删除的数据范围！");
			return;
		}
		
		Ext.Msg.show({
		   title:'提示',
		   msg: '确认要删除选择的数据范围吗？',
		   buttons: Ext.Msg.YESNO,
		   fn: function(btn,text){
		  		if(btn=="yes"){
		 			var ids = "";
		   			for(var i=0;i<res.length;i++)
		   				ids += res[i].data.sjfwid + ",";
					
					//删除
					Ext.Msg.wait("正在删除，请稍后...", "等待");
					
					Ext.Ajax.request({
						url:'zzjy.do?method=deleteSJFW',
						method:'POST', 
						params:{ids:ids,dwdm:curRy.data.dwdm},
						success:function(result,request){ 
							Ext.Msg.hide();
							var jsonData = Ext.util.JSON.decode(result.responseText);
							if(jsonData.success){
								var res = csmSJFW.getSelections();
								Ext.each(res,function(r){
									Ext.getCmp("gridsjfw").store.remove(r);
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
	
    	function addSJFW(){
    		_selectSjfw(curRy.data.dwdm, function(xqlx, sjfw){
    			var data = {
    				xqlx: xqlx,
    				sjfw: sjfw,
    				dwdm: curRy.data.dwdm,
    				yhid: curRy.data.yhid
    			};
			Ext.Msg.wait("正在保存，请稍后...", "等待");
			
			Ext.Ajax.request({
				url:'zzjy.do?method=createSJFW',
				method:'POST', 
				params:data,
				success:function(result,request){ 
					Ext.Msg.hide();
					var jsonData = Ext.util.JSON.decode(result.responseText);
	
					if(jsonData.success){
						Ext.Msg.alert("提示",jsonData.messages[0]);
						SJFWStore.removeAll();
						SJFWStore.load({params:{start:0, limit:20}})
					}else{
						showError(jsonData.messages[0]);
					}
				}, 
				failure: function ( result, request) {
					Ext.Msg.hide();
					showError(result.responseText); 
				}
			}); 
    		});
    	}
    	
    	var SJFWStore = new Ext.data.JsonStore({
		  url: 'zzjy.do?method=getSJFW',
		  root: 'list',
		  id:'sjfwid',
		  totalProperty:'totalCount',
		  fields: [
			"sjfwid","yhid","xqlx","sjfw","dqbm","yhxm","yhdlm"
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
	var csmSJFW = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var colModelSJFW = new Ext.grid.ColumnModel([csmSJFW,{
	        header: "用户登录名",
	        dataIndex: "yhdlm",	
	        sortable: true,
		width: 80
	     },{
	        header: "用户姓名",
	        dataIndex: "yhxm",
	        sortable: true,
		width: 80
	    },{
	        header: "辖区类型",
	        dataIndex: "xqlx",	
	        sortable: true,
		width: 80,
		renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			if(value=="1") return "辖区内";
			if(value=="2") return "辖区外";
		}
	    },{
	        header: "数据范围",
	        dataIndex: "sjfw",	
	        sortable: true,
		width: 150
	    }
	]);
	var gridSJFW = new Ext.grid.GridPanel({
	        store: SJFWStore,
	        region: 'center',
	        view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		stripeRows: true,
		id:'gridsjfw',
	        cm: colModelSJFW,
	        sm:csmSJFW,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
	        border:true,
	        anchor:'100% 100%',
	    	margins: '0 0 0 0',
		cmargins: '0 0 0 0',        
        	frame:false,
		iconCls:'icon-grid',
        	title:'	用户数据范围设置',
        	bbar: [
        		new Ext.PagingToolbar({
				pageSize: 20,
				width:200,
				hideLabel: true,
				store: SJFWStore,
				displayInfo: false
			}),
			'->',
			new Ext.Button({
				text:'添加数据范围',
				minWidth:75,
				handler:function(){
					addSJFW();
				}
			}),
			new Ext.Button({
				text:'删除数据范围',
				minWidth:75,
				handler:function(){
					deleteSJFW();
				}
			})
		]
    	});
    	
    	var treeSelectWin = new Ext.Window({
		title:'选择等同',
		closeAction:'hide',
		modal:true,
		width:400,
		height:400,
		margins:'5',
		layout:'fit',
		items:new gnt.com.ux.DictTree({
			xtype:'DictTree',
			id:'dttree',
			dict:'VisionType=RY&mselect=false&showchecked=true&serviceName=zzjyManagerService&serviceMethod=queryDwxxTree'
		}),
		listeners:{
			show:function(){
				
			}
		}
	});
	
	function deleteTDQX(){
		var res = csmTDQX.getSelections();
		if(res.length==0){
			Ext.Msg.alert("提示","必须选择需要删除的等同权限！");
			return;
		}
		
		Ext.Msg.show({
		   title:'提示',
		   msg: '确认要删除选择的等同权限吗？',
		   buttons: Ext.Msg.YESNO,
		   fn: function(btn,text){
		  		if(btn=="yes"){
		 			var ids = "";
		   			for(var i=0;i<res.length;i++)
		   				ids += res[i].data.dtqxid + ",";
					
					//删除
					Ext.Msg.wait("正在删除，请稍后...", "等待");
					
					Ext.Ajax.request({
						url:'zzjy.do?method=deleteDTQX',
						method:'POST', 
						params:{ids:ids,dwdm:curRy.data.dwdm},
						success:function(result,request){ 
							Ext.Msg.hide();
							var jsonData = Ext.util.JSON.decode(result.responseText);
							if(jsonData.success){
								var res = csmTDQX.getSelections();
								Ext.each(res,function(r){
									TDQXStore.remove(r);
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
	
    	function addTDQX(){
    		var dw = curRy.data.dwdm;
    		treeSelectWin.setTitle("添加等同权限");
    		treeSelectWin.show();
    		treeSelectWin.items.first().loadData(
    			"serviceName=zzjyManagerService&serviceMethod=queryDwxxRyTree&VisionType=RY&mselect=true&showchecked=true&postDetail=" + dw.substring(0,4),
    			function(idlist){
    				Ext.Msg.wait("正在保存，请稍后...", "等待");
			
				Ext.Ajax.request({
					url:'zzjy.do?method=createDTQX',
					method:'POST', 
					params:{
						yhid:curRy.data.yhid,
						dwdm:curRy.data.dwdm,
						ids: idlist
					},
					success:function(result,request){ 
						Ext.Msg.hide();
						var jsonData = Ext.util.JSON.decode(result.responseText);
		
						if(jsonData.success){
							Ext.Msg.alert("提示",jsonData.messages[0]);
							TDQXStore.removeAll();
							TDQXStore.load({params:{start:0, limit:20}})
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
    		);
    	}
    	
    	var TDQXStore = new Ext.data.JsonStore({
		  url: 'zzjy.do?method=getDTQX',
		  root: 'list',
		  id:'dtqxid',
		  totalProperty:'totalCount',
		  fields: [
			"dtqxid","yhid","dtyhid","dqbm","dtyhxm","dtyhdlm","yhxm","yhdlm"
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
	var csmTDQX = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var colModelTDQX = new Ext.grid.ColumnModel([csmTDQX,{
	        header: "用户登录名",
	        dataIndex: "yhdlm",	
	        sortable: true,
		width: 100
	     },{
	        header: "用户姓名",
	        dataIndex: "yhxm",
	        sortable: true,
		width: 100
	    },{
	        header: "等同用户登录名",
	        dataIndex: "dtyhdlm",	
	        sortable: true,
		width: 80
	    },{
	        header: "等同用户姓名",
	        dataIndex: "dtyhxm",	
	        sortable: true,
		width: 80
	    }
	]);
	var gridTDQX = new Ext.grid.GridPanel({
	        store: TDQXStore,
	        region: 'center',
	        view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		stripeRows: true,
		id:'gridtdqx',
	        cm: colModelTDQX,
	        sm:csmTDQX,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
	        border:true,
	        anchor:'100% 100%',
	    	margins: '0 0 0 0',
		cmargins: '0 0 0 0',        
        	frame:false,
		iconCls:'icon-grid',
        	title:'	用户同等权限设置',
        	bbar: [
        		new Ext.PagingToolbar({
				pageSize: 20,
				width:200,
				hideLabel: true,
				store: TDQXStore,
				displayInfo: false
			}),
			'->',
			new Ext.Button({
				text:'添加等同权限',
				minWidth:75,
				handler:function(){
					addTDQX();
				}
			}),
			new Ext.Button({
				text:'删除等同权限',
				minWidth:75,
				handler:function(){
					deleteTDQX();
				}
			})
		]
    	});

	function addDDQX(){
    		var dict = "serviceName=zzjyManagerService&serviceMethod=getDDTree&yhid=" + curRy.data.yhid + "&dwdm=" + curRy.data.dwdm;
    		treeSelectWin.setTitle("动作权限设置"); 
    		treeSelectWin.show();
    		treeSelectWin.items.first().loadData(
    			dict,
    			function(idlist){
    				Ext.Msg.wait("正在保存，请稍后...", "等待");
				Ext.Ajax.request({
					url:'zzjy.do?method=createDZQX',
					method:'POST', 
					params:{
						yhid:curRy.data.yhid,
						dwdm:curRy.data.dwdm,
						ids: idlist
					},
					success:function(result,request){ 
						Ext.Msg.hide();
						var jsonData = Ext.util.JSON.decode(result.responseText);
		
						if(jsonData.success){
							Ext.Msg.alert("提示",jsonData.messages[0]);
							DDQXStore.removeAll();
							DDQXStore.load({params:{start:0, limit:20}})
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
    		);
	}
	
	function deleteDDQX(){
		var res = csmDDQX.getSelections();
		if(res.length==0){
			Ext.Msg.alert("提示","必须选择需要删除的动作权限！");
			return;
		}
		
		Ext.Msg.show({
		   title:'提示',
		   msg: '确认要删除选择的动作权限吗？',
		   buttons: Ext.Msg.YESNO,
		   fn: function(btn,text){
		  		if(btn=="yes"){
		 			var ids = "";
		   			for(var i=0;i<res.length;i++)
		   				ids += res[i].data.dzqxid + ",";
					
					//删除
					Ext.Msg.wait("正在删除，请稍后...", "等待");
					
					Ext.Ajax.request({
						url:'zzjy.do?method=deleteDZQX',
						method:'POST', 
						params:{ids:ids,dwdm:curRy.data.dwdm},
						success:function(result,request){ 
							Ext.Msg.hide();
							var jsonData = Ext.util.JSON.decode(result.responseText);
							if(jsonData.success){
								var res = csmDDQX.getSelections();
								Ext.each(res,function(r){
									DDQXStore.remove(r);
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
	
    	var DDQXStore = new Ext.data.JsonStore({
		  url: 'zzjy.do?method=getDZQX',
		  root: 'list',
		  id:'dzqxid',
		  totalProperty:'totalCount',
		  fields: [
			"dzqxid","yhid","dzid","dqbm","dzmc","dzms","yhdlm","yhxm"
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
	var csmDDQX = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var colModelDDQX = new Ext.grid.ColumnModel([csmDDQX,{
	        header: "用户登录名",
	        dataIndex: "yhdlm",	
	        sortable: true,
		width: 80
	     },{
	        header: "用户姓名",
	        dataIndex: "yhxm",
	        sortable: true,
		width: 80
	    },{
	        header: "动作名称",
	        dataIndex: "dzmc",	
	        sortable: true,
		width: 80
	    },{
	        header: "动作描述",
	        dataIndex: "dzms",	
	        sortable: true,
		width: 180
	    }
	]);
	var gridDDQX = new Ext.grid.GridPanel({
	        store: DDQXStore,
	        region: 'center',
	        view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		stripeRows: true,
		id:'gridddqx',
	        cm: colModelDDQX,
	        sm:csmDDQX,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
	        border:true,
	        anchor:'100% 100%',
	    	margins: '0 0 0 0',
		cmargins: '0 0 0 0',        
        	frame:false,
		iconCls:'icon-grid',
        	title:'	用户动作权限设置',
        	bbar: [
        		new Ext.PagingToolbar({
				pageSize: 20,
				width:200,
				hideLabel: true,
				store: DDQXStore,
				displayInfo: false
			}),
			'->',
			new Ext.Button({
				text:'添加动作权限',
				minWidth:75,
				handler:function(){
					addDDQX();
				}
			}),
			new Ext.Button({
				text:'删除动作权限',
				minWidth:75,
				handler:function(){
					deleteDDQX();
				}
			})
		]
    	});
    	
	var tabs = new Ext.TabPanel({
	        activeTab: 0,
	        width:600,
	        height:250,
	        plain:true,
	        defaults:{
	        	autoScroll: true,
	        	frame: false,
	        	shim: true
	        },
	        listeners:{
	        	tabchange:function(tabPanel , tab){
	        		if(tab.id=="gridip" && !initData.gridip){
	        			initData.gridip = "1";
	        			loadDataIP();
	        		}
	        		
	        		if(tab.id=="gridsjfw" && !initData.gridsjfw){
	        			initData.gridsjfw = "1";
	        			loadDataSJFW();
	        		}
	        		
	        		if(tab.id=="gridtdqx" && !initData.gridtdqx){
	        			initData.gridtdqx = "1";
	        			loadDataDTQX();
	        		}
	        		
	        		if(tab.id=="gridddqx" && !initData.gridddqx){
	        			initData.gridddqx = "1";
	        			loadDataDDQX();
	        		}
	        	} 
	        },
	        items:[
	        	rymxFs, gridIP, gridSJFW, gridTDQX, gridDDQX
		]
	});
	
	function loadDataIP(){
		IPStore.baseParams = {
			yhid:curRy.data.yhid,
			dwdm:curRy.data.dwdm
		};
		IPStore.load({params:{start:0, limit:20}})
	}
	
	function loadDataSJFW(){
		SJFWStore.baseParams = {
			yhid:curRy.data.yhid,
			dwdm:curRy.data.dwdm
		};
		SJFWStore.load({params:{start:0, limit:20}})
	}
	
	function loadDataDTQX(){
		TDQXStore.baseParams = {
			yhid:curRy.data.yhid,
			dwdm:curRy.data.dwdm
		};
		TDQXStore.load({params:{start:0, limit:20}})
	}
	
	function loadDataDDQX(){
		DDQXStore.baseParams = {
			yhid:curRy.data.yhid,
			dwdm:curRy.data.dwdm
		};
		DDQXStore.load({params:{start:0, limit:20}})
	}
	
	tabwin = new Ext.Window({
		title:'VIP资料一览',
		closeAction:'hide',
		modal:true,
		width:740,
		height:475,
		layout:'fit',
		autoScroll:true,
		items:tabs,
		listeners:{
			show:function(){
				if(!isnewry){
					Ext.getCmp("gridip").setDisabled(false);
					Ext.getCmp("gridsjfw").setDisabled(false);
					Ext.getCmp("gridtdqx").setDisabled(false);
					Ext.getCmp("gridddqx").setDisabled(false);
				}else{
					Ext.getCmp("gridip").setDisabled(true);
					Ext.getCmp("gridsjfw").setDisabled(true);
					Ext.getCmp("gridtdqx").setDisabled(true);
					Ext.getCmp("gridddqx").setDisabled(true);
				}
				
				if(!curRy){
					Ext.getCmp("gridip").store.removeAll();
					Ext.getCmp("gridsjfw").store.removeAll();
					Ext.getCmp("gridtdqx").store.removeAll();
					Ext.getCmp("gridddqx").store.removeAll();
					tabs.setActiveTab(0);
				
					return;
				}
				
				var data = curRy.data;
				if(seluid==data.yhid){
					return;
				}
				
				Ext.getCmp("gridip").store.removeAll();
				Ext.getCmp("gridsjfw").store.removeAll();
				Ext.getCmp("gridtdqx").store.removeAll();
				Ext.getCmp("gridddqx").store.removeAll();
				tabs.setActiveTab(0);
				
				initData = {};
				seluid = data.yhid;
			}
		},
		buttons:[ {
			text:'关闭',
			handler:function(){
				tabwin.hide();
			}
		}]
	});
	tabwin.show();
	tabwin.hide();
	
	//jgmxWin.show();
	//jgmxWin.hide();
	
	//rymxWin.show();
	//rymxWin.hide();
	
	//moveWin.show();
	//moveWin.hide();
	
	if(!isinit){
		isinit = true;
		initDict();
	}
	
	/************************************兼职设置*********************************************/
 	queryDwCommonStore = new Ext.data.JsonStore({
	        url: 'zzjy.do?method=queryKhjg',
	        root: 'list',
	        id:'id',
	        totalProperty:'totalCount',
	        fields: ["id","yhm","sfzh","dwdm","jh","fs","flag","bz"],
	        listeners:{
	        	beforeload:function(store, options ){
	        		Ext.Msg.wait("正在查询，请稍后...");
	        	},
	        	load:function(st,res){
	        		Ext.Msg.hide();
	        		if(res.length>0){
	        		}
	        	},
			loadexception:function(mystore,options,response,error){
				Ext.Msg.hide();
				if(error){
					var json = Ext.decode(response.responseText);
					if(json.messages)
						Ext.Msg.alert("提示",json.messages[0]);
				}else{
					Ext.Msg.alert("提示",response.responseText);
				}
			}
	        }
	});
    
	var queryDwColModel = new Ext.grid.ColumnModel([{
	        header: "姓名",
	        dataIndex: "yhm",	
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
	        header: "身份证号",
	        dataIndex: "sfzh",	
	        sortable: true,
			width: 100,
			renderer:function(value){
				return value;
			}
	    }
	]);
	
	var queryDwGrid = new Ext.grid.GridPanel({
	        store: queryDwCommonStore,
	        region: 'center',
	        view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		stripeRows: true,
        	cm: queryDwColModel,
		bodyStyle:'width:100%',
	        border:true,
	        anchor:'100% 100%',
	    	margins: '5 0 0 0',  
        	frame:false,
        	autoScroll:true,
	    	collapsible:true,
	    	split:true,
		iconCls:'icon-grid',
		width:400,
		bbar: new Ext.PagingToolbar({
				pageSize: 20,
				width:200,
				hideLabel: true,
				store: queryDwCommonStore,
				displayInfo: false
		}),
		listeners:{
			rowclick:function(g, rowIndex, e){

			},
			rowdblclick:function(g, rowIndex, e){
				var r1 = g.store.getAt(rowIndex);
				
				var data = r1.data;
				var newdata = {yhdlm:data.yhm,jyh:data.jh,gmsfhm:data.sfzh,yhxm:data.yhm};
				rymxFs.getForm().setValues(newdata);
				jzWin.hide();
			}
		},
        	title:''
    	});	
    
   	var dwQueryFs = new Ext.form.FormPanel({
		title:'',
	    	height: 80,
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
		                columnWidth:0.5,
	    	           	layout: 'form',
	    	           	bodyStyle:'padding:0 0 0 0',
	        	       	items: [{
							xtype:'textfield',
							anchor:'100%',
							name:'yhm',
							fieldLabel:'姓名'
					}]
				},{
			                columnWidth:0.5,
		    	           	layout: 'form',
		    	           	bodyStyle:'padding:0 0 0 0',
		        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'sfzh',
						fieldLabel:'身份证号'
					}]
				}
			]
		}],
		buttons:[
			new Ext.Button({
				text:'查询合格警员',
				minWidth:75,
				id:'queryDwBtn',
				handler:function(){
					var p = dwQueryFs.getForm().getValues();
					p.newuserflag = "1";
					p.dwdm = selnode.attributes.dw.dm.substring(0,4);
					
					queryDwCommonStore.baseParams = p;
					queryDwCommonStore.load({params:{start:0, limit:20}})
				}
			}),
			new Ext.Button({
				text:'新登记用户',
				minWidth:75,
				id:'queryDwBtn2',
				handler:function(){
					jzWin.hide();
				}
			})
		]
	});
	
	jzWin = new Ext.Window({
		title:'新增用户-选择考核合格人员',
		closeAction:'hide',
		modal:true,
		width:850,
		height:400,
		margins:'5',
		layout:'border',
		items:[queryDwGrid,dwQueryFs],
		listeners:{
			show:function(){
			}
		}
	});
	
	queryDwCommonStore.baseParams = {newuserflag:"1"};
	
	function selectDw(){
		var dw = curRy.data.dwdm;
    		treeSelectWin.setTitle("选择变动单位");
    		treeSelectWin.show();
    		treeSelectWin.items.first().loadData(
    			"serviceName=zzjyManagerService&serviceMethod=queryDwxxRyTree&VisionType=DW&mselect=false&showchecked=true&postDetail=" + dw.substring(0,4),
    			function(idlist,list){
    				if(list.length==1){
    					//alert(Ext.encode(list[0]));
    					rymxFs.getForm().setValues({dwmc:list[0].mc,dwdm:list[0].dm});
    				}
    			}
    		);
	}
});