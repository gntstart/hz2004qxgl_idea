/**
 * 长三角第三方准迁证信息 弹窗查看数据
 *
 */
Gnt.ux.SelectZjywZqzxxModify = Ext.extend(Ext.Window, {
    title: '',
    closeAction: 'hide',
    // closable: false,
    resizable: false,
    modal: true,
    width: 1000,
    height: 550,
    margins: '5',
    layout: 'border',
    pageSize:.50,
//	autoScroll:true,
    show: function () {
        this.zqzPanel.getForm().reset();
        Gnt.ux.SelectZjywZqzxxModify.superclass.show.call(this);
    },
    resetData: function () {

    },
    setSelRes: function (data) {
        this.zqzPanel.getForm().setValues(data);
        Ext.getCmp('qcd_hkdjjg_gajgjgdm').setValue(data.qcd_hkdjjg_gajgjgdm.substring(0,9));
    	var store = this.zqrSqrxxGrid.store;
    	store.baseParams = {
    			ywlsh:data.ywlsh,
    			start:0,
    			limit:20
    	};
    	store.load();
    },
    initComponent: function () {
        var returnTitleText = this.returnTitleText;
        if (!returnTitleText || returnTitleText == "") returnTitleText = "省外迁出详细数据";

        this.returnTitleText = returnTitleText;

        this.setTitle(returnTitleText);
        var data = this.data;
        this.data = data;
        var win = this;
        this.zqzPanel = new Gnt.ux.GntForm({
            closeAction: 'hide',
            modal: true,
            autoScroll: true,
//	        height: 100,
            region: 'center',
            anchor: '100% 100%',
            buttonAlign: 'right',
            labelAlign: 'right',
            title: '',
            frame: true,
            border: false,
            fileUpload: true,
            margins: '0',
            layout: 'form',
            labelWidth: 120,
            items: [{
                layout: 'column',
                frame: false,
                border: false,
                defaults: {
                    border: false,
                    frame: false
                },
                items: [{
                    name: 'ywlsh',
                    xtype: 'hidden'
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'zqzbh',
                        fieldLabel: '准迁证编号'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqr_gmsfhm',
                        fieldLabel: '申请人身份证'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqr_xm',
                        fieldLabel: '申请人姓名'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqr_lxdh',
                        fieldLabel: '申请人电话'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        columnWidth:0.25,
                        xtype:'tree_comboBox',
                        dict:'VisionType=XZQHBNEW',
                        dsname:'XZQHBNEW',
                        anchor:'100%',
                        name:'sqr_zz_ssxqdm',
                        dm:'dm',
                        allowBlank:false,
                        fieldLabel:'申请人省市县区',
                        searchUrl:'tj/rktj.do?method=searchXzqh'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqr_hkdjjg_gajgmc',
                        fieldLabel: '申请人户口登记机关'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqr_zz_qhnxxdz',
                        fieldLabel: '申请人详址'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        columnWidth:0.33,
                        xtype:'tree_comboBox',
                        dict:'VisionType=XZQHBNEW',
                        dsname:'XZQHBNEW',
                        anchor:'100%',
                        name:'qcd_ssxqdm',
                        allowBlank:false,
                        fieldLabel:'迁出地省市县区',
                        searchUrl:'tj/rktj.do?method=searchXzqh'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        columnWidth:0.33,
                        xtype:'tree_comboBox',
                        dict:'VisionType=DWXXB',
                        dsname:'DWXXB',
                        anchor:'100%',
                        id:'qcd_hkdjjg_gajgjgdm',
                        name:'qcd_hkdjjg_gajgjgdm',
                        allowBlank:false,
                        fieldLabel:'迁出地户口登记机关',
                        searchUrl:'yw/dqdict.do?method=searchXxb&visiontype=DWXXB'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        columnWidth:0.33,
                        xtype:'tree_comboBox',
                        dict:'VisionType=XZQHBNEW',
                        dsname:'XZQHBNEW',
                        anchor:'100%',
                        name:'qrd_ssxqdm',
                        allowBlank:false,
                        fieldLabel:'迁入地省市县区',
                        searchUrl:'tj/rktj.do?method=searchXzqh'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'qcd_qhnxxdz',
                        fieldLabel: '迁出地详址'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'qrd_qhnxxdz',
                        fieldLabel: '迁入地详址'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'qrd_hkdjjg_gajgmc',
                        fieldLabel: '迁入地户口登记机关'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'qfjg_gajgmc',
                        fieldLabel: '签发机关'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'cbr_xm',
                        fieldLabel: '承办人姓名'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'qfrq',
                        fieldLabel: '签发日期'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                    	anchor:'100%',
						xtype:'dict_combox',
						dict:'VisionType=CS_QYLDYY',
						value:"",
						name:'qyldyymc',
						maxLength:40,
						hiddenName:'qyldyydm',
						allowBlank:false,
						fieldLabel:'迁移（流动）原因'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'yxqjzrq',
                        fieldLabel: '有效期截止日期'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                    	anchor:'100%',
						xtype:'dict_combox',
						dict:'VisionType=CS_BDFW',
						value:"",
						name:'qyfwdm',
						maxLength:40,
						hiddenName:'qyfwdm',
						fieldLabel:'区域范围'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sldw_gajgmc',
                        fieldLabel: '受理单位'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sldw_lxdh',
                        fieldLabel: '受理单位电话'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'slr_xm',
                        fieldLabel: '受理人姓名'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'slsj',
                        fieldLabel: '受理时间'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sjgsdwmc',
                        fieldLabel: '数据归属单位'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
						hiddenName:'isstatus',
						anchor:'100%',
						xtype:'combo',
						fieldLabel:'是否报送',
						mode: 'local',
            			triggerAction: 'all',
						valueField:"code",
      					displayField:"name",
						selectOnFocus:true,
						emptyText : '请选择',
						typeAhead: true,  
						editable:false,
						forceSelection: true,
    					blankText:'请选择',
            			lazyRender:true,
            			value:'0',
            			store:new Ext.data.SimpleStore({
            				id:0,
            				fields:[{name: 'code', mapping: 0},{name: 'name', mapping: 1}],
            			   	data:[['0','未报送'],['1','已报送'],['3','注销']]
            			})
                    
//                        xtype: 'textfield',
//                        anchor: '100%',
//                        name: 'isstatus',
//                        fieldLabel: '是否报送',
//                        renderer:function(value){
//                            if(value == "0"){
//                                return "未报送"
//                            }
//                            if(value == "1"){
//                                return "已报送"
//                            }
//                            if(value == "3"){
//                                return "注销"
//                            }
//                        }
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                    	hiddenName:'sfbj',
						anchor:'100%',
						xtype:'combo',
						fieldLabel:'是否办结',
						mode: 'local',
            			triggerAction: 'all',
						valueField:"code",
      					displayField:"name",
						selectOnFocus:true,
						emptyText : '请选择',
						typeAhead: true,  
						editable:false,
						forceSelection: true,
    					blankText:'请选择',
            			lazyRender:true,
            			value:'0',
            			store:new Ext.data.SimpleStore({
            				id:0,
            				fields:[{name: 'code', mapping: 0},{name: 'name', mapping: 1}],
            			   	data:[['0','未办结'],['1','已办结']]
            			})
                    
//                        xtype: 'textfield',
//                        anchor: '100%',
//                        name: 'sfbj',
//                        fieldLabel: '是否办结',
//                        renderer:function(value){
//                            if(value == "0"){
//                                return "未办结"
//                            }
//                            if(value == "1"){
//                                return "已办结"
//                            }
//                        }
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 50,
                        anchor: '100%',
                        name: 'zxyy',
                        fieldLabel: '注销原因'
                    }]
                }
                ]
            }]
        });
        var csm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
    	var colModel = new Ext.grid.ColumnModel([
    		{
    			header: "准迁证编号",
    	        dataIndex: "zqzbh",
    	        sortable: true,
    			width: 120
    		},{
    	        header: "与申请人关系_家庭关系",
    	        dataIndex: "ysqrgx_jtgxdm",
    	        sortable: true,
    			width: 120
    	    },{
    			header: "公民身份号码",
    	        dataIndex: "gmsfhm",
    	        sortable: true,
    			width: 120
    		},{
    			header: "姓名",
    	        dataIndex: "xm",
    	        sortable: true,
    			width: 120
    		},{//grid增加电话号码列   20210220
    			header: "性别",
    	        dataIndex: "xbdm",
    	        sortable: true,
    			width: 120
    		},{
    	        header: "出生日期",
    	        dataIndex: "csrq",
    	        sortable: true,
    			width: 120
    	    }
    	]);
     	var myuserStore = new Ext.data.JsonStore({
     		proxy: new Ext.data.HttpProxy({
     			url: 'yw/kdqqy.do?method=queryKdsQcSqrxx',//yw/hjyw/hzywcl/queryHzywcl
    			method: "POST",
    			disableCaching: true
    	    }),
            root: 'list',
            id:'id',
            totalProperty:'totalCount',
            fields: [
            	"zqzbh",
    			"ysqrgx_jtgxdm",
    			"gmsfhm",
    			"xm",
    			"xbdm",//grid增加电话号码赋值   20210220
    			"csrq"
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
     	
     	this.zqrSqrxxGrid = new Ext.grid.GridPanel({
            store: myuserStore,
            height:180,
            region: 'south',
            view:new Ext.grid.GridView({
    				//forceFit:true,
    				//autoFill:true,
    				enableRowBody:true
    		}),
    		stripeRows: true,
            cm: colModel,
            sm:csm,
    		loadMask: {msg:'正在加载数据，请稍侯……'},
    		bodyStyle:'width:80%',
            border:true,
            anchor:'100% 100%',
    	    margins: '0 0 0 0',
    		cmargins: '0 0 0 0',        
            frame:false,
    		iconCls:'icon-grid',
            title:'',
            listeners:{
            	rowclick:function(g, rowIndex, e){
            		selectedSelRes = g.store.getAt(rowIndex);
            	},
    			rowdblclick:function(g, rowIndex, e){
    				selectedSelRes = g.store.getAt(rowIndex);
    			}
    		},
            bbar: new Ext.PagingToolbar({
    				pageSize: 20,
    				store: myuserStore,
    				displayInfo: true
    		}),
            buttons: [
                /*new Ext.Button({
                    text: '保存修改',
                    minWidth: 75,
                    id: 'saveBtn_xj',
                    handler: function () {
                        var rootWin = this.findParentByType("rkpcModify_window");
                        var form = rootWin.zqzPanel;
                        if (!form.getForm().isValid()) {
                            Ext.Msg.alert("提示", "数据校验没有通过，请检查！");
                            return;
                        }
                        var xgzl = form.getForm().getValues();
                        if (rootWin.callback) {
                            rootWin.callback('xgzl', xgzl);
                        }
                    }
                }),*/
                new Ext.Button({
                    text: '关闭',
                    minWidth: 75,
                    handler: function () {
                        win.hide();
                        var rootWin = this.findParentByType("ZjywZqzxx_Modify_window");
                        if (rootWin.callback) {
                            rootWin.callback('gb', null);
                        }
                    }
                })
            ]
        });
        this.items = [this.zqzPanel, this.zqrSqrxxGrid];
        Gnt.ux.SelectZjywZqzxxModify.superclass.initComponent.call(this);
    }
});
Ext.reg('ZjywZqzxx_Modify_window', Gnt.ux.SelectZjywZqzxxModify);