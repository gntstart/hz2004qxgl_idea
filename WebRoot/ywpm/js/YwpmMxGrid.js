/**
 * 统计store，必须先加载commFrames.js,YwpmStore.js
 */
Gnt.ux.YwpmMxGrid = Ext.extend(Ext.grid.GridPanel, {
	title:'业务排名统计信息',
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
		this.store=new Gnt.store.YwpmMxStore({
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
				        	 header: "序号",
				        	 renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
				        	        if(store.lastOptions.params!=null){
				        	            var pageindex=store.lastOptions.params.start;
				        	            var rowIndex = pageindex + rowIndex + 1;
				        	            if(rowIndex <= 10){
				        	            	cellmeta.css="red-font";
				        	            }
				        	            return rowIndex ;
				        	        } else {  
				        	        	if(rowIndex <= 10){
				        	        		cellmeta.css="red-font";
				        	            }
				        	        	return (rowIndex + 1) ;
				        	        }  
				        	    },
				        	 sortable: true,
				        	 align: "center",
				        	 width: 20
				         },{
				        	 header: "地市名称",
				        	 dataIndex: "dsmc",	
				        	 sortable: true,
				        	 align: "center",
				        	 renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
				        		 if(store.lastOptions.params!=null){
				        			 var pageindex=store.lastOptions.params.start;
				        			 var rowIndex = pageindex + rowIndex + 1;
				        			 if(rowIndex <= 10){
				        				 cellmeta.css="red-font";
				        			 }
				        			 return value ;
				        		 } else {  
				        			 if(rowIndex <= 10){
				        				 cellmeta.css="red-font";
				        			 }
				        			 return value ;
				        		 }  
				        	 },
				        	 width: 120
				         },{
				        	 header: "区县名称",
				        	 dataIndex: "xq",	
				        	 sortable: true,
				        	 align: "center",
				        	 renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
				        	        if(store.lastOptions.params!=null){
				        	            var pageindex=store.lastOptions.params.start;
				        	            var rowIndex = pageindex + rowIndex + 1;
				        	            if(rowIndex <= 10){
				        	            	cellmeta.css="red-font";
				        	            }
				        	            return value ;
				        	        } else {  
				        	        	if(rowIndex <= 10){
				        	        		cellmeta.css="red-font";
				        	            }
				        	        	return value ;
				        	        }  
				        	    },
				        	 width: 120
				         },{
				        	 header: "派出所名称",
				        	 dataIndex: "pcsmc",	
				        	 sortable: true,
				        	 align: "center",
				        	 renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
				        	        if(store.lastOptions.params!=null){
				        	            var pageindex=store.lastOptions.params.start;
				        	            var rowIndex = pageindex + rowIndex + 1;
				        	            if(rowIndex <= 10){
				        	            	cellmeta.css="red-font";
				        	            }
				        	            return value ;
				        	        } else {  
				        	        	if(rowIndex <= 10){
				        	        		cellmeta.css="red-font";
				        	            }
				        	        	return value ;
				        	        }  
				        	    },
				        	 width: 60
				         },{
				        	 header: "业务数量",
				        	 dataIndex: "ywsl",	
				        	 sortable: true,
				        	 align: "center",
				        	 renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
				        	        if(store.lastOptions.params!=null){
				        	            var pageindex=store.lastOptions.params.start;
				        	            var rowIndex = pageindex + rowIndex + 1;
				        	            if(rowIndex <= 10){
				        	            	cellmeta.css="red-font";
				        	            }
				        	            return value ;
				        	        } else {
				        	        	if(rowIndex <= 10){
				        	        		cellmeta.css="red-font";
				        	            }
				        	        	return value ;
				        	        }  
				        	    },
				        	 width: 60
				         }
				         ,{
				        	 header: "统计时间",
				        	 dataIndex: "tjsj",	
				        	 sortable: true,
				        	 align: "center",
				        	 renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
				        	        if(store.lastOptions.params!=null){
				        	            var pageindex=store.lastOptions.params.start;
				        	            var rowIndex = pageindex + rowIndex + 1;
				        	            if(rowIndex <= 10){
				        	            	cellmeta.css="red-font";
				        	            }
				        	            return value ;
				        	        } else {  
				        	        	if(rowIndex <= 10){
				        	        		cellmeta.css="red-font";
				        	            }
				        	        	return value ;
				        	        }  
				        	    },
				        	 width: 60
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
		
		Gnt.ux.YwpmMxGrid.superclass.initComponent.call(this);
	}
});

Ext.grid.PageRowNumberer = Ext.extend(Ext.grid.RowNumberer, {  
    width : 120,     
    renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){  
        if(store.lastOptions.params!=null){  
            var pageindex=store.lastOptions.params.start;  
            return pageindex + rowIndex + 1;  
        } else {  
            return rowIndex + 1;  
        }  
    }     
});

Ext.reg('rktj_grid', Gnt.ux.YwpmMxGrid);
