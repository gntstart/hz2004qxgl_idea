/**
 * 常住人口store，必须先加载commFrames.js,CzrkStore.js
 */
Gnt.ux.CzrkGrid = Ext.extend(Ext.grid.GridPanel, {
	title:'人员基本信息',
	height:200,
	stripeRows: true,
    loadMask: {msg:'正在加载数据，请稍侯……'},
    border:false,
    margins:'0 0 0 5',
	frame:false,
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
		this.store=new Gnt.store.CzrkStore({
			error_callback:function(){
			},
			success_callback:function(){
				
			},
			url:this.url
	    });
		
		if(!this.cm){
			this.cm=new Ext.grid.ColumnModel([{
				    header: "姓名",
				    dataIndex: "xm",	
				    sortable: true,
				    width: 80
				 },{
				     header: "性别",
				     dataIndex: "xb",	
				     sortable: true,
				     width: 40,
				     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
							return Gnt.ux.Dict.getDictLable('CS_XB', value);
					 }
				 },{
					    header: "居（村）委会",
					    dataIndex: "jwh_text",	
					    sortable: true,
					    width: 120
				 },{
					    header: "街路巷",
					    dataIndex: "jlx_text",	
					    sortable: true,
					    width: 120
				 },{
					    header: "门楼牌号",
					    dataIndex: "mlph",	
					    sortable: true,
					    width: 80
				 },{
					    header: "门楼详址",
					    dataIndex: "mlxz",	
					    sortable: true,
					    width: 120
				 },{
					    header: "户号",
					    dataIndex: "hh",	
					    sortable: true,
					    width: 80
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
				forceFit:true,
				autoFill:false,
				enableRowBody:true
		    });
		}
		
		Gnt.ux.CzrkGrid.superclass.initComponent.call(this);
	}
});
Ext.reg('czrk_grid', Gnt.ux.CzrkGrid);
