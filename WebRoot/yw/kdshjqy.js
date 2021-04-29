var pagesize=20;
var selRes = null;
var xx = {};

Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var clbsStore = new Ext.data.SimpleStore({
		id:0,
		fields:[{name: 'code', mapping: 0},{name: 'name', mapping: 1}],
	   	data:[['0','未处理'],['1','已处理'],['2','已作废']]
	});
	
	var fnQueryFs = new Gnt.ux.GntForm({
	    title:'',
    	height: 125,
    	region: 'north',
        fields:[{
	        	    	columnWidth:.25,
						xtype:'datefield',
						anchor:'100%',
						format:'Y-m-d',
						name:'to_startdate_czsj',
						fieldLabel:'申请时间起'
				},{
	        	    	columnWidth:.25,
						xtype:'datefield',
						format:'Y-m-d',
						anchor:'100%',
						name:'to_enddate_czsj',
						fieldLabel:'申请时间止'
				},{
        	       		columnWidth:.25,
						xtype:'textfield',
						anchor:'100%',
						name:'bsqrsfz',
						fieldLabel:'被申请人身份证'
				},{
        	       		columnWidth:.25,
						xtype:'textfield',
						anchor:'100%',
						name:'bsqrxm',
						fieldLabel:'被申请人姓名'
				},{
        	       		columnWidth:.25,
						xtype:'textfield',
						anchor:'100%',
						name:'lhsfz',
						fieldLabel:'落户身份证'
				},{
        	       		columnWidth:.25,
						xtype:'textfield',
						anchor:'100%',
						name:'pch',
						fieldLabel:'批次号'
				},{
        	       		columnWidth:.25,
						xtype:'textfield',
						anchor:'100%',
						name:'bsqrsjhm',
						fieldLabel:'被申请人手机号'
				},{
	        	    	columnWidth:.25,
						xtype:'datefield',
						anchor:'100%',
						format:'Y-m-d',
						name:'to_startdate_clsj',
						fieldLabel:'处理时间起'
				},{
	        	    	columnWidth:.25,
						xtype:'datefield',
						format:'Y-m-d',
						anchor:'100%',
						name:'to_enddate_clsj',
						fieldLabel:'处理时间止'
				},{
        	       		columnWidth:.25,
						hiddenName:'clbs',
						anchor:'100%',
						xtype:'combo',
						fieldLabel:'处理状态',
						mode: 'local',
            			triggerAction: 'all',
						valueField:"code",
      					displayField:"name",
						selectOnFocus:true,
						emptyText : '请选择',
						typeAhead: true,  
						editable:false,
						forceSelection: true,
			    		forceSelection: true, 
    					blankText:'请选择',
            			lazyRender:true,
            			value:'0',
            			store:clbsStore
		}],
		buttons:[
				new Ext.Button({
						text:'查询',
						minWidth:75,
						id:'queryBtn',
						handler:function(){
							if(!fnQueryFs.getForm().isValid()){
								Ext.Msg.alert("提示","数据校验没有通过，请检查！");
								return;
							}
							
							hzywStore.removeAll();
							selRes = null;
							
							var p = fnQueryFs.getForm().getValues();

							hzywStore.baseParams = p;
							hzywStore.load({params:{start:0, limit:pagesize}})
						}
				}),
				new Ext.Button({
					text:'作废',
					minWidth:75,
					handler:function(){
						openWorkSpace(tabs, close, "kdshjgy2.jsp","跨地市户籍迁移","跨地市户籍迁移")
					}
			})
		]
	});
	
	var hzywStore = new Ext.data.JsonStore({
        url: 'yw/kdqqy.do?method=queryKdqqy',
        root: 'list',
        id:'id',
        totalProperty:'totalCount',
        fields: ["id","sqrxm","sqrsfz","sqrlxdh","sqrlxdz","ywlb","bsqrxm","bsqrsfz","czdw","czyh",
                 "czsj","lhbs","lhsfz","lhdz","sbzt","clbs","clsj","pch","ywlbm","nbgxm","cym","csyxzmbh",
                 "bsqrxb","bsqrmz","bsqrcsrq","btkrgx","bsqrsjhm","zxyy","qcdbm"],
        listeners:{
			loadexception:function(mystore,options,response,error){
				if(error){
					var json = Ext.decode(response.responseText);
					if(json.messages)
						Ext.Msg.alert("提示",json.messages[0]);
					else
						Ext.Msg.alert("提示",error.message);
				}else{
					Ext.Msg.alert("提示",response.responseText);
				}
			}
        }
    });
    
	hzywCsm = new Ext.grid.CheckboxSelectionModel({singleSelect:true});
	var hzywColModel = new Ext.grid.ColumnModel([
		hzywCsm,{
	        header: "操作时间",
	        dataIndex: "czsj",	
	        //renderer: setcolor,
	        sortable: true,
	        width: 120
	    },{
	        header: "操作警员",
	        dataIndex: "czyh",	
	        //renderer: setcolor,
	        sortable: true,
	        width: 80
	    },{
	        header: "申请人姓名",
	        //renderer: setcolor,
	        dataIndex: "sqrxm"
	    },{
	        header: "申请人身份证",
	        //renderer: setcolor,
	        dataIndex: "sqrsfz",
	        width: 160
	    },{
	        header: "申请人电话",
	        //renderer: setcolor,
	        dataIndex: "sqrlxdh"
	    }, {
	        header: "被申请人",
	        //renderer: setcolor,
	        dataIndex: "bsqrxm"
	    }, {
	        header: "被申请人身份证",
	        width: 120,
	        //renderer: setcolor,
	        dataIndex: "bsqrsfz"
	    }, {
	        header: "被申请人电话",
	        //renderer: setcolor,
	        width: 100,
	        dataIndex: "bsqrsjhm"
	    }, {
	        header: "落户身份证",
	        //renderer: setcolor,
	        dataIndex: "lhsfz"
	    }, {
	        header: "落户详细地址",
	        //renderer: setcolor,
	        width: 200,
	        dataIndex: "lhdz"
	    }, {
	        header: "批次号",
	        //renderer: setcolor,
	        dataIndex: "pch"
	    },{
	        header: "用户状态",
	        dataIndex: "clbs",
	        renderer:function(value){
	        	//处理标识 0-未处理 1-处理成功, 2 忽略不处理
	        	if(value=="0")
	        		return "未处理";
	        	else if(value=="1")
	        		return "已处理";
	        	else
	        		return "<span style='color:red'>已作废</span>";
	        }
	    }
	]);
	
	var hzywGrid = new Ext.grid.GridPanel({
        store: hzywStore,
        region: 'center',
        view:new Ext.grid.GridView({
			forceFit:false,
			autoFill:false,
			enableRowBody:true
        }),
		stripeRows: true,
        cm: hzywColModel,
        sm: hzywCsm,
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
				selRes = g.store.getAt(rowIndex);
				var data = selRes.data;
				var url = "yw/ryqr.jsp?ywid=" + data.id;
				openWorkSpace(tabs, true, url, "跨地市迁入：" + data.bsqrxm, "qc-" + data.id);
			}
		},
        title:'',
        bbar: new Ext.PagingToolbar({
				pageSize: pagesize,
				store: hzywStore,
				displayInfo: true
		})
    });	
	
	//定义分页面板
    var tabs = new Ext.TabPanel({
    	id:'tabs',
        activeTab: 0,
        width:500,
        height:250,
        resizeTabs:false, 
        enableTabScroll:true,
        plain:false,
        listeners:{
        	//在关闭分页的时候，调用函数释放iframe占用资源
        	beforeremove:fixIFrame.createDelegate(this)
        },
        defaults:{
        	autoScroll: false,
        	frame: false,
        	shim: false,
        	xtype: 'panel'
        },
        items:[{
        	//本页不允许关闭
        	closable: false,
            title: '跨地区迁入',
            layout:'border',
            tabTip:'',
            items:[
                   fnQueryFs,hzywGrid
            ]
        },{
        	//本页不允许关闭
        	closable: false,
            title: '跨地区迁出',
            tabTip:'',
            html: ''
        }]
    });
  
	new Ext.Viewport({
        layout:'border',
        id:'vp',
        items:[{
            region:'center',
            id:'portal_home',
            //禁止横向滚动条
            layout:'fit',
            border:false,
            frame:false,
           	bodyStyle:'overflow:scroll;overflow-x:hidden',
            margins:'0',
            autoScroll:true,
            items:[tabs]
        }]
    });
	
	//openWorkSpace(tabs, true, url, "跨地市迁出", "qc-" + data.id);
});
