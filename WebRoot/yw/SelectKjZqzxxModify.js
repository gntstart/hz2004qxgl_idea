/**
 * 安徽开具准迁证信息 弹窗查看数据
 *
 */
Gnt.ux.SelectKjZqzxxModify = Ext.extend(Ext.Window, {
    title: '',
    closeAction: 'hide',
    // closable: false,
    resizable: false,
    modal: true,
    width: 1000,
    height: 500,
    margins: '5',
    layout: 'border',
    pageSize:.50,
//	autoScroll:true,
    show: function () {
        this.kjZqzxxPanel.getForm().reset();
        Gnt.ux.SelectKjZqzxxModify.superclass.show.call(this);
    },
    resetData: function () {

    },
    setSelRes: function (data) {
        this.kjZqzxxPanel.getForm().setValues(data);
        var store = this.kjSqrxxGrid.store;
        if(data){
        	if(data.qyrxm1){
        		var data1 = {xm:data.qyrxm1,xb:data.qyrxb1,gmsfhm:data.qyrgmsfhm1,qyrysqrgx:data.qyrysqrgx1};
        		var rr1 = new store.reader.recordType(data1, 1);
        		store.add([rr1]);
        	}
			if(data.qyrxm2){
				var data2 = {xm:data.qyrxm2,xb:data.qyrxb2,gmsfhm:data.qyrgmsfhm2,qyrysqrgx:data.qyrysqrgx2}
				var rr2 = new store.reader.recordType(data2, 2);
				store.add([rr2]);    		
        	}
			if(data.qyrxm3){
				var data3 = {xm:data.qyrxm3,xb:data.qyrxb3,gmsfhm:data.qyrgmsfhm3,qyrysqrgx:data.qyrysqrgx3}
				var rr3 = new store.reader.recordType(data3, 3);
				store.add([rr3]);
			}
			if(data.qyrxm4){
				var data4 = {xm:data.qyrxm4,xb:data.qyrxb4,gmsfhm:data.qyrgmsfhm4,qyrysqrgx:data.qyrysqrgx4}
				var rr4 = new store.reader.recordType(data4, 4);
				store.add([rr4]);
			}
        }
    },
    initComponent: function () {
        var returnTitleText = this.returnTitleText;
        if (!returnTitleText || returnTitleText == "") returnTitleText = "安徽开具准迁证详情";
        this.returnTitleText = returnTitleText;
        this.setTitle(returnTitleText);
        var data = this.data;
        this.data = data;
        var win = this;
        this.kjZqzxxPanel = new Gnt.ux.GntForm({
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
                        name: 'sqrxm',
                        fieldLabel: '申请人姓名'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqrgmsfhm',
                        fieldLabel: '申请人身份号码'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'zjbh',
                        fieldLabel: '准迁证编号'
                    }]
                },
                {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqrzzxz',
                        fieldLabel: '申请人详细地址'
                    }]
                },{
                    columnWidth: 0.3,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        columnWidth:0.33,
                        xtype:'tree_comboBox',
                        dict:'VisionType=XZQHBNEW',
                        dsname:'XZQHBNEW',
                        anchor:'100%',
                        name:'sqrzzssxq',
                        allowBlank:false,
                        fieldLabel:'去往地',
                        searchUrl:'tj/rktj.do?method=searchXzqh'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                    	columnWidth: 0.33,
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqrhkdjjg',
                        fieldLabel: '申请人户口登记机关'
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
                        name:'qrdssxq',
                        dm:'dm',
                        allowBlank:false,
                        fieldLabel:'迁入省市县区',
                        searchUrl:'tj/rktj.do?method=searchXzqh'
                    }]
                },  {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        columnWidth:0.33,
                        xtype:'tree_comboBox',
                        dict:'VisionType=DWXXB',
                        dsname:'DWXXB',
                        anchor:'100%',
                        name:'qrdhkdjjg',
                        allowBlank:false,
                        fieldLabel:'迁入户口登记机关',
                        searchUrl:'yw/dqdict.do?method=searchXxb&visiontype=DWXXB'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'pzjg',
                        fieldLabel: '批准机关'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'cbr',
                        fieldLabel: '承办人'
                    }]
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'qfrq',
                        fieldLabel: '签发日期'
                    }]
                },{
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
                }
                ]
            }],
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
        var csm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
    	var colModel = new Ext.grid.ColumnModel([
    		{
    			header: "姓名",
    	        dataIndex: "xm",
    	        sortable: true,
    			width: 60
    		},{
    			header: "性别",
    	        dataIndex: "xb",
    	        sortable: true,
    			width: 60,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('CS_XB', value);
				}
    		},{
    			header: "公民身份号码",
    	        dataIndex: "gmsfhm",
    	        sortable: true,
    			width: 120
    		},{
    			header: "与申请人关系",
    	        dataIndex: "qyrysqrgx",
    	        sortable: true,
    			width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return Gnt.ux.Dict.getDictLable('CS_JTGX', value);
				}
    		}
    	]);
        var kjStore = new Ext.data.JsonStore({
     		proxy: new Ext.data.HttpProxy({
     			url: 'yw/kdqqy.do?method=queryKdsQrSqrxx',//yw/hjyw/hzywcl/queryHzywcl
    			method: "POST",
    			disableCaching: true
    	    }),
            root: 'list',
            id:'id',
            totalProperty:'totalCount',
            fields: [
            	"xm",
            	"xb",
            	"gmsfhm",
    			"qyrysqrgx"
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
        this.kjSqrxxGrid = new Ext.grid.GridPanel({
            store: kjStore,
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
    				pageSize: 4,
    				store: kjStore,
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
        this.items = [this.kjZqzxxPanel,this.kjSqrxxGrid];
        Gnt.ux.SelectKjZqzxxModify.superclass.initComponent.call(this);
    }
});
Ext.reg('KjZqzxx_Modify', Gnt.ux.SelectKjZqzxxModify);