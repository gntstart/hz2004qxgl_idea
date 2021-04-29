/**
 * 统计store，必须先加载commFrames.js,RktjNmzrkStore.js
 */
Gnt.ux.RktjNmzrkMxGrid = Ext.extend(Ext.grid.GridPanel, {
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
		this.store=new Gnt.store.RktjNmzrkMxStore({
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
							 header: "姓&nbsp;&nbsp;&nbsp;&nbsp;名",
							 dataIndex: "czrk.xm",	
							 sortable: true,
							 align: "center",
							 width: 120
						}
						,{
							header: "性&nbsp;&nbsp;&nbsp;&nbsp;别",
							dataIndex: "czrk.xb",	
							sortable: true,
							align: "center",
							width: 120,
							renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
								return Gnt.ux.Dict.getDictLable('CS_XB', value);
							}
						}
						,{
							header: "身份证号",
							dataIndex: "czrk.gmsfhm",	
							sortable: true,
							align: "center",
							width: 120
						}
						, {
							header: "单&nbsp;&nbsp;&nbsp;&nbsp;位 ",
							dataIndex: "dw.mc",	
							sortable: true,
							align: "center",
							width: 120
						}
						, {
							header: "居&nbsp;&nbsp;委&nbsp;&nbsp会 ",
							dataIndex: "jwh.mc",	
							sortable: true,
							align: "center",
							width: 120
						}
				        , {
				        	header: "户&nbsp;&nbsp;类&nbsp;&nbsp型 ",
				        	dataIndex: "czrk.hlx",	
				        	sortable: true,
				        	align: "center",
				        	width: 120,
							renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
								return Gnt.ux.Dict.getDictLable('CS_HLX', value);
							}
				         }
				        , {
				        	header: "城&nbsp;&nbsp;乡&nbsp;&nbsp类&nbsp;&nbsp型 ",
				        	dataIndex: "jwh.cxfldm",	
				        	sortable: true,
				        	align: "center",
				        	width: 120,
							renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
								return Gnt.ux.Dict.getDictLable('CS_CXFLDM', value);
							}
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
		
		Gnt.ux.RktjNmzrkMxGrid.superclass.initComponent.call(this);
	}
});
Ext.reg('rktj_grid', Gnt.ux.RktjNmzrkMxGrid);
