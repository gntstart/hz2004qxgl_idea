var curCcm = "";
var pageSize = 15;

var curRy = null;
var ryCommonStore = null;

var jzCommonStore = null;
var rymxFs = null;
var rymxWin = null;
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

var isnewry = true;

function queryry(){
	var p = ryQueryFs.getForm().getValues();
	ryCommonStore.baseParams = p;
	ryCommonStore.load(
		{
			params:{
				start:0 , 
				limit:pageSize 
			}
		}
	)
}

Ext.onReady( function() {
	
	Ext.QuickTips.init();
	
	ryCommonStore = new Ext.data.JsonStore({
        url: 'hzck.do?method=queryMx',
        root: 'list',
        id:'ryCom',
        totalProperty:'totalCount',
        fields: ["yhid" ,"yhxm" ,"yhdlm" ,"jyh" ,"gmsfhm" ,"yhlx" ,"yhIP" ,"dwdm" ,"dwmc" ,"qhdm" ,"szqx" ,"dlsj" ,"yhzt" ,"dsdm" ,"yhzt" ,"cxlx"],
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
	
	var yhztStore = new Ext.data.SimpleStore({
		id: 'id_yhztStore',
		fields: [ "code","name"],
		data: [
			['','　'],
			['0', '在线'],
			['1', '离线']
		]
	});
	
	/**
	 	显示列
	 */
	var ryColModel = new Ext.grid.ColumnModel([
		//yhid ,yhxm ,yhdlm ,jyh ,gmsfhm ,yhlx ,yhIP ,dwdm ,dwmc ,qhdm ,substr(xzqh.qhmc,instr(xzqh.qhmc,'市')+1)
		ryCsm,{
	        header: "用户姓名",
	        dataIndex: "yhxm",
	        renderer: setcolor,
	        sortable: true,
			width: 50
	    }/*,{
	        header: "姓名",
	        dataIndex: "yhxm",
	        renderer: setcolor,
	        sortable: true,
	        width: 80
	    }*/,{
	        header: "所在区县",
	        dataIndex: "szqx",
	        renderer: setcolor,
	        sortable: true,
	        width: 40
	    },{
	        header: "所在派出所",
	        dataIndex: "dwmc",
	        renderer: setcolor,
	        sortable: true,
	        width: 60
	    },{
	        header: "身份证号码",
	        dataIndex: "gmsfhm",
	        renderer: setcolor,
	        sortable: true,
	        width: 60
	    },{
	        header: "登录时间",
	        dataIndex: "dlsj",
	        renderer: setcolor,
	        sortable: true,
	        width: 60
	    },{
	    	header: "用户状态",
	    	dataIndex: "yhzt",
	    	renderer: setcolor,
	    	sortable: true,
	    	width: 40
	    },{
	        header: "登录IP",
	        dataIndex: "yhIP",
	        renderer: setcolor,
	        sortable: true,
	        width: 60
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
			items:[
				{
					id:'yhid',
					name:'yhid',
					xtype:'hidden'
				},{
					xtype:'hidden',
					name:'szqx'
				},{
					xtype:'hidden',
					name:'dsdm',
					value:dsdm
				},{
					id:'dwdm',
					name:'dwdm',
					xtype:'hidden'
				},{
					xtype:'hidden',
					name:'cxlx'
				},{
					columnWidth:.25,
					layout: 'form',
					bodyStyle:'padding:0 0 0 0',
					items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'yhxm',
						fieldLabel:'用户姓名'
					}]
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
						id:'_qx_',
						xtype:'textfield',
						allowBlank :true,
						/*dict:"VisionType=CS_QXDYQFJG&tid=_qx_&vid=szqx&rtype=&mselect=true",*/
						/*dict:"VisionType=CS_YHZW&def=1&ignore=true",*/
						readonly:true,
						fieldLabel:'所在区县',
						anchor:'100%'
					}]
				},{
					columnWidth:.25,
					layout: 'form',
					bodyStyle:'padding:0 0 0 0',
					items: [{
						id:'dwmc',
						xtype:'DictTextField',
						/*dict:"VisionType=DW&mselect=true&vid=dwdm&event=ajax&tid=dwmc&postDetail=" + dsdm ,*/
						dict:"VisionType=DW&mselect=true&vid=dwdm&tid=dwmc&postDetail=" + dsdm ,
						/*dict:"VisionType=DW&mselect=true&tid=dwdm&postDetail=" + dsdm ,*/
						allowBlank :true,
						fieldLabel:'所在派出所',
						name:'dwmc',
						selectOnFocus:true,
						emptyText: '请选择',
						typeAhead: true,
						forceSelection: true,
    					blankText:'请选择',
            			lazyRender:true,
						anchor:'100%'
					}]
				},{
					columnWidth:.25,
					layout: 'form',
					bodyStyle:'padding:0 0 0 0',
					items: [{
						hiddenName:'yhzt',
						anchor:'99%',
						xtype:'combo',
						fieldLabel:'用户状态',
						mode: 'local',
						triggerAction: 'all',
						valueField:"code",
						displayField:"name",
						selectOnFocus:true,
						emptyText : '请选择',
						typeAhead: true,  
						forceSelection: true,
						blankText:'请选择',
						lazyRender:true,
//			    		value:'1',
						store:yhztStore,
						ignore: true
					}]
				},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [{
						hiddenName:'yhlx',
						fieldLabel:'用户类型',
						anchor:'99%',
						xtype:'DictComboBox',
						dict:"VisionType=CS_YHLX&ignore=false",
						selectOnFocus:true,
						emptyText : '请选择',
						typeAhead: true,
						forceSelection: true,
						blankText:'请选择'
						//,value:yhlx
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
					queryry();
				}
			})
			/*,new Ext.Button({
				text:'选择区县',
				minWidth:75,
				id:'saveDwBtn',
				handler:function(){
					selectQx();
				}
			})*/
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
				
			},
			rowdblclick:function(g, rowIndex, e){
				/*
				curRy = g.store.getAt(rowIndex);
				editry(curRy.data.yhid);
				*/
			}
		},
		title:'',
		bbar: new Ext.PagingToolbar({
			pageSize: pageSize,
			store: ryCommonStore,
			displayInfo: false
		})
	});
	
	new Ext.Viewport({
		layout:'border',
		id:'vp',
		items:[{
			region:'center',
			layout:'fit',
			border:false,
			frame:false,
			//禁止横向滚动条
			//bodyStyle:'overflow:scroll;overflow-x:hidden',
			margins:'5 5 5 0',
			autoScroll:true,
			items:[{
            	layout:'border',
            	frame:false,
            	border:false,
            	margins: '0',
            	items:[
            		ryQueryFs,ryGrid
            	]
            }]
		}]
	});
	
	new Ext.KeyMap(ryQueryFs.el, {
		key:13,
		fn:function(key,keyEvent){
			//注意，对话框通过回车无法关闭，因为会反复触发该事件
			Ext.getCmp("queryBtn").handler.call();
		}
	});

	if(!isinit){
		isinit = true;
		initDict();
	}
	
	/**
	 	自动加载
	 */
	queryry();
	
	function selectQx(){
		
		alert(dsdm);
		
		_selectSjfw(dsdm, function(xqlx, sjfw){
			var data = {
				xqlx: xqlx,
				sjfw: sjfw,
				xzqh: dsdm,
				dwdm: dsdm
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
		
		
		/*
    		treeSelectWin.setTitle("选择变动单位");
    		treeSelectWin.show();
    		treeSelectWin.items.first().loadData(
    			"serviceName=zzjyManagerService&serviceMethod=queryDwxxRyTree&VisionType=DW&mselect=false&showchecked=true&postDetail=" + dsdm ,
    			function(idlist,list){
    				if(list.length==1){
    					//alert(Ext.encode(list[0]));
    					rymxFs.getForm().setValues({dwmc:list[0].mc,dwdm:list[0].dm});
    				}
    			}
    		);
    		*/
	}
});