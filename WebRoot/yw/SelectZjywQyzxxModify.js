/**
 * 长三角第三方准迁证信息 弹窗查看数据
 *
 */
Gnt.ux.SelectZjywQyzxxModify = Ext.extend(Ext.Window, {
    title: '',
    closeAction: 'hide',
    // closable: false,
    resizable: false,
    modal: true,
    width: 1000,
    height: 450,
    margins: '5',
    layout: 'border',
    pageSize:.50,
//	autoScroll:true,
    show: function () {
        this.zqzPanel.getForm().reset();
        Gnt.ux.SelectZjywQyzxxModify.superclass.show.call(this);
    },
    resetData: function () {

    },
    setSelRes: function (data) {
        this.zqzPanel.getForm().setValues(data);
    	var store = this.qyzSqrxxGrid.store;
    	store.baseParams = {
    			ywlsh:data.ywlsh,
    			start:0,
    			limit:20
    	};
    	store.load();
    },
    initComponent: function () {
        var returnTitleText = this.returnTitleText;
        if (!returnTitleText || returnTitleText == "") returnTitleText = "省外迁入详细数据";
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
            labelWidth: 100,
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
                        name: 'czr_xm',
                        fieldLabel: '持证人姓名'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'czr_gmsfhm',
                        fieldLabel: '公民身份号码'
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
                        name:'qwd_ssxqdm',
                        allowBlank:false,
                        fieldLabel:'去往地',
                        searchUrl:'tj/rktj.do?method=searchXzqh'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                    	columnWidth:0.33,
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'qwd_qhnxxdz',
                        fieldLabel: '去往地详细地址'
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
                        name:'hkdjpcs',
                        allowBlank:false,
                        fieldLabel:'户口登记机关',
                        searchUrl:'yw/dqdict.do?method=searchXxb&visiontype=DWXXB'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'qyzbh',
                        fieldLabel: '迁移证编号'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'zqzbh',
                        fieldLabel: '准迁证编号'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'yxqjzrq',
                        fieldLabel: '有效截止日期'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'slr_xm',
                        fieldLabel: '受理人'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sldw_gajgmc',
                        fieldLabel: '受理单位'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'slsj',
                        fieldLabel: '受理日期'
                    }]
                }
                ]
            }]
        });
        var csm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
    	var colModel = new Ext.grid.ColumnModel([
    		{
    			header: "迁移证编号",
    	        dataIndex: "qyzbh",
    	        sortable: true,
    			width: 120
    		},{
    			header: "与持证人关系_家庭关系",
    	        dataIndex: "yczrgx_jtgxdm",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('CS_JTGX', value);
				}
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
    		},{
    			header: "曾用名",
    	        dataIndex: "cym",
    	        sortable: true,
    			width: 120
    		},{
    			header: "性别",
    	        dataIndex: "xbdm",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('CS_XB', value);
				}
    		},{
    			header: "民族",
    	        dataIndex: "mzdm",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('CS_MZ', value);
				}
    		},{
    			header: "出生日期",
    	        dataIndex: "csrq",
    	        sortable: true,
    			width: 120
    		},{
    			header: "出生地_国家（地区）",
    	        dataIndex: "csd_gjhdqdm",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('XZQHB', value);
				}
    		},{
    			header: "出生地_省市县（区）",
    	        dataIndex: "csd_ssxqdm",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('XZQHB', value);
				}
    		},{
    	        header: "出生地_区划内详细地址",
    	        dataIndex: "csd_qhnxxdz",
    	        sortable: true,
    			width: 120
    	    },{
    			header: "籍贯_国家（地区）",
    	        dataIndex: "jg_gjhdqdm",
    	        sortable: true,
    			width: 120
    		},{
    			header: "籍贯_省市县（区）",
    	        dataIndex: "jg_ssxqdm",
    	        sortable: true,
    			width: 120
    		},{
    	        header: "籍贯_区划内详细地址",
    	        dataIndex: "jg_qhnxxdz",
    	        sortable: true,
    			width: 120
    	    },{
    			header: "文化程度",
    	        dataIndex: "xldm",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('CS_WHCD', value);
				}
    		},{
    			header: "婚姻状况",
    	        dataIndex: "hyzkdm",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('CS_HYZK', value);
				}
    		},{
    	        header: "职业",
    	        dataIndex: "zy",
    	        sortable: true,
    			width: 120
    	    },{
    			header: "迁移（流动）原因",
    	        dataIndex: "qyldyydm",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('CS_QYLDYY', value);
				}
    		},{
    			header: "居民身份证签发机关",
    	        dataIndex: "jmsfz_qfjg",
    	        sortable: true,
    			width: 120
    		},{
    	        header: "有效期限起始日期",
    	        dataIndex: "jmsfz_yxqxqsrq",
    	        sortable: true,
    			width: 120
    	    },{
    			header: "有效期限截止日期",
    	        dataIndex: "jmsfz_yxqxjzrq",
    	        sortable: true,
    			width: 120
    		}
    	]);
     	var myuserStore = new Ext.data.JsonStore({
     		proxy: new Ext.data.HttpProxy({
     			url: 'yw/kdqqy.do?method=queryKdsQrSqrxx',//yw/hjyw/hzywcl/queryHzywcl
    			method: "POST",
    			disableCaching: true
    	    }),
            root: 'list',
            id:'id',
            totalProperty:'totalCount',
            fields: [
            	"qyzbh",
    			"yczrgx_jtgxdm",
    			"gmsfhm",
    			"xm",
    			"cym",
    			"xbdm",//grid增加电话号码赋值   20210220
    			"mzdm",
    			"csrq",
    			"csd_gjhdqdm",
    			"csd_ssxqdm",
    			"csd_qhnxxdz",
    			"jg_gjhdqdm",
    			"jg_ssxqdm",
    			"jg_qhnxxdz",
    			"xldm",
    			"hyzkdm",
    			"zy",
    			"qyldyydm",
    			"jmsfz_qfjg",
    			"jmsfz_yxqxqsrq",
    			"jmsfz_yxqxjzrq"
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
     	
     	this.qyzSqrxxGrid = new Ext.grid.GridPanel({
            store: myuserStore,
            height:200,
            region: 'south',
            view:new Ext.grid.GridView({
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
                new Ext.Button({
                    text: '关闭',
                    minWidth: 75,
                    handler: function () {
                        win.hide();
                    }
                })
            ]
        });
        this.items = [this.zqzPanel, this.qyzSqrxxGrid];
        Gnt.ux.SelectZjywQyzxxModify.superclass.initComponent.call(this);
    }
});
Ext.reg('ZjywQyzxx_Modify_window', Gnt.ux.SelectZjywQyzxxModify);