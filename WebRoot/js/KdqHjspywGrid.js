/**
 * 常住人口store，必须先加载commFrames.js,CzrkStore.js
 */
Gnt.ux.KdqHjspywGrid = Ext.extend(Ext.grid.GridPanel, {
	title:'人员基本信息',
	height:200,
	stripeRows: true,
    loadMask: {msg:'正在加载数据，请稍侯……'},
    margins:'0 0 0 5',
    border:true,
    frame:true,
    getPostParams:function(){
    	return {};
    },
    loadData:function(data, success_callback, error_callback){
    	this.store.success_callback = success_callback;
    	this.store.error_callback = error_callback;

    	this.store.baseParams = data;
		this.store.load({params:{start:0, limit:this.pagesize}});
    },
	initComponent: function() {
		this.store=new Gnt.store.KdqHjspywStore({
			error_callback:function(){
			},
			success_callback:function(){
				
			},
			url:this.url
	    });
		
		if(!this.cm){
			this.cm=new Ext.grid.ColumnModel([
				new Ext.grid.CheckboxSelectionModel(),
				new Ext.grid.RowNumberer(),
				 {
					    header: "申请人姓名",
					    dataIndex: "sqr_xm",
					    sortable: true,
					    width: 80
				 },{
					    header: "申请人身份证号码",
					    dataIndex: "sqr_gmsfhm",
					    sortable: true,
					    width: 120
				 },{
					    header: "是否推送",
					    dataIndex: "isstatus",
					    sortable: true,
					    width: 60,
	    				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
	    					if(value==0){
	    						return '1-待办结';
	    					}else if(value==1){
	    						return '4-已报送';
	    					}else if(value==2){
	    						return '已注销';
	    					}else if(value==3){
								return '2-待报送';
							}else if(value==4){
								return '异常待处理';
							}else if(value==5){
								return '3-报送中';
							}
	    				}
				 },{
					    header: "是否办结",
					    dataIndex: "sfbj",
					    sortable: true,
					    width: 60,
	    				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
	    					return Gnt.ux.Dict.getDictLable('CS_LSBZ', value);
	    				}
				 },{
						header: "准迁证编号",
						dataIndex: "zqzbh",
						sortable: true,
						width: 80
				},{
						header: "有效截止日期",
						dataIndex: "yxqjzrq",
						sortable: true,
						hidden: true,
						width: 40
				},{
					    header: "受理日期",
					    dataIndex: "slsj",
					    sortable: true,
					    width: 120
				 },{
					header: "创建时间",
					dataIndex: "cjsj",
					sortable: true,
					width: 120
				},{
					header: "迁出地省市县区",
					dataIndex: "qcd_ssxqdm",
					sortable: true,
					width: 150,
					renderer:function(value){
						return Gnt.ux.Dict.getDictLableXzqh('searchXzqh','',value,'eq');
					}
				},{
					header: "迁出地机构代码",
					dataIndex: "qcd_hkdjjg_gajgjgdm",
					sortable: true,
					hidden: true,
					width: 120,
					renderer:function(value){
						return Gnt.ux.Dict.getDictLableXzqh("searchXxb",'DWXXB',value,"eq");
					}
				},{
					header: "迁出地机构名称",
					dataIndex: "qcd_hkdjjg_gajgmc",
					sortable: true,
					width: 120
				},{
					header: "迁出地详细详址",
					dataIndex: "qcd_qhnxxdz",
					sortable: true,
					hidden: true,
					width: 120
				},{
					header: "迁出地单位电话",
					dataIndex: "sldw_lxdh",
					sortable: true,
					hidden: true,
					width: 120
				},{
					header: "迁入地省市县区",
					dataIndex: "qrd_ssxqdm",
					sortable: true,
					width: 120,
					renderer:function(value){
						return Gnt.ux.Dict.getDictLableXzqh('searchXzqh','',value,'eq');
					}
				},{
					header: "迁入地机构代码",
					dataIndex: "qrd_hkdjjg_gajgjgdm",
					sortable: true,
					hidden: true,
					width: 120,
					renderer:function(value){
						return Gnt.ux.Dict.getDictLableXzqh("searchXxb",'DWXXB',value,"eq");
					}
				},{
					header: "迁入地机构名称",
					dataIndex: "qrd_hkdjjg_gajgmc",
					sortable: true,
					width: 120
				},{
					header: "迁入地省市县区",
					dataIndex: "qrd_ssxqdm",
					sortable: true,
					hidden: true,
					width: 120,
					renderer:function(value){
						return Gnt.ux.Dict.getDictLableXzqh('searchXzqh','',value,'eq');
					}
				},{
				    header: "迁入地详址",
				    dataIndex: "qrd_qhnxxdz",
				    sortable: true,
				    hidden: true,
				    width: 120
				 },{
					header: "备注",
					dataIndex: "zxyy",
					sortable: true,
					width: 120
				}
			 ]);
		}
		
		if(this.showPaging==undefined || this.showPaging==true){
			this.bbar=new Ext.PagingToolbar({
				pageSize: this.pagesize,
				store: this.store,
				displayInfo: true
			});
		}
		
		//这个必须放store定义后，否则不可预料
		if(!this.view){
			this.view = new Ext.grid.GridView({
				forceFit:false,
				autoFill:false/*,
				enableRowBody:true*/
				
//				forceFit:true,
//				autoFill:true,
				/*enableRowBody:true*/
		    });
		}
		
		Gnt.ux.KdqHjspywGrid.superclass.initComponent.call(this);
	}
});
Ext.reg('hjspyw_grid', Gnt.ux.KdqHjspywGrid);
