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
        fields: ["yhid" ,"yhxm" ,"yhdlm" ,"jyh" ,"gmsfhm" ,"yhlx" ,"yhIP" ,"dwdm" ,"dwmc" ,"qhdm" ,"szqx" ,"dlsj" ,"yhzt" ,"dsdm" ,"yhzt"],
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
	
	var yhlxStore = new Ext.data.SimpleStore({
		id: 'id_yhlxStore',
		fields: [ "code","name"],
		data: [
			['','　'],
			['2', '户办大厅'],
			['1', '派出所']
		]
	});
	
	/**
	 	显示列
	 */
	var ryColModel = new Ext.grid.ColumnModel([
		//yhid ,yhxm ,yhdlm ,jyh ,gmsfhm ,yhlx ,yhIP ,dwdm ,dwmc ,qhdm ,substr(xzqh.qhmc,instr(xzqh.qhmc,'市')+1)
		ryCsm,{
	        header: "用户名",
	        dataIndex: "yhdlm",
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
					xtype:'hidden',
					name:'dwmc'
				},{
					columnWidth:.25,
					layout: 'form',
					bodyStyle:'padding:0 0 0 0',
					items: [{
						xtype:'textfield',
						anchor:'100%',
						name:'yhdlm',
						fieldLabel:'用户名'
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
						xtype:'DictTextField',
						allowBlank :true,
						dict:"VisionType=DW&tid=_qx_&vid=szqx&rtype=&mselect=true",
						fieldLabel:'所在区县',
						anchor:'100%'
					}]
				},{
					columnWidth:.25,
					layout: 'form',
					bodyStyle:'padding:0 0 0 0',
					items: [{
						id:'_pcs_',
						xtype:'DictTextField',
						allowBlank :true,
						dict:"VisionType=RY&tid=_pcs_&vid=dwmc&rtype=&mselect=true",
						fieldLabel:'所在派出所',
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
						anchor:'99%',
						xtype:'combo',
						fieldLabel:'用户类型',
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
			    		value:yhlx,
			    		store:yhlxStore,
			    		ignore: true
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
		]
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
	
});