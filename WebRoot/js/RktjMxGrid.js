/**
 * 统计store，必须先加载commFrames.js,RktjStore.js
 */
Gnt.ux.RktjMxGrid = Ext.extend(Ext.grid.GridPanel, {
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
		this.store=new Gnt.store.RktjMxStore({
			error_callback:function(){
			},
			success_callback:function(){
				
			},
			url:this.url
	    });
		
		if(!this.cm){
			this.cm=new Ext.grid.ColumnModel({
				columns:[
				         {
				        	 header: "单&nbsp;&nbsp;&nbsp;&nbsp;位 ",
				        	 dataIndex: "ryid",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 120
				         }
				         ,{
				        	 header: "身份证号",
				        	 dataIndex: "gmsfhm",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 120
				         }
				         ,{
				        	 header: "姓&nbsp;&nbsp;&nbsp;&nbsp;名",
				        	 dataIndex: "xm",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 120
				         }
				         ]
				
			});
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
		
		Gnt.ux.RktjMxGrid.superclass.initComponent.call(this);
	}
});
Ext.reg('rktj_grid', Gnt.ux.RktjMxGrid);
