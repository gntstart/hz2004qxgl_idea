/**
 * 统计store，必须先加载commFrames.js,RktjStore.js
 */
Gnt.ux.RktjGrid = Ext.extend(Ext.grid.GridPanel, {
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
		this.store=new Gnt.store.RktjStore({
			error_callback:function(){
			},
			success_callback:function(){
				
			},
			url:this.url
	    });
		
		if(!this.cm){
			this.cm=new Ext.grid.ColumnModel([
			     
			    /* {
			    	[
			    	 ,{
			    		 header: "姓名",
			    		 dataIndex: "xm",	
			    		 sortable: true,
			    		 width: 80
			    	 }
			    	]
			     }*/
			    {
			    		header: "填报单位 ",
			    		dataIndex: "a1",	
			    		sortable: true,
			    		width: 120
				 },{
				     header: "年末总户数（户）",
				     dataIndex: "a2",	
				     sortable: true,
				     width: 60,
				     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
							return Gnt.ux.Dict.getDictLable('CS_XB', value);
					 }
				 },{
					    header: "年末总人口（合计）",
					    dataIndex: "a3",	
					    sortable: true,
					    width: 60
					    
				 }
				 ,{
					 header: "城镇人口",
					 dataIndex: "jlx_text",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "乡村人口",
					 dataIndex: "jlx_text",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "性别：男",
					 dataIndex: "a6",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "性别：女",
					 dataIndex: "a7",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "0-17岁",
					 dataIndex: "a8",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "18-34岁",
					 dataIndex: "a9",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "60岁及以上",
					 dataIndex: "a11",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "35-59岁",
					 dataIndex: "a10",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "本年度人口变动（出生合计）",
					 dataIndex: "jlx_text",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "出生：男",
					 dataIndex: "a13",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "出生：女",
					 dataIndex: "a14",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "死亡：男",
					 dataIndex: "a16",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "死亡：女",
					 dataIndex: "a17",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "省内迁入",
					 dataIndex: "a18",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "省外迁入",
					 dataIndex: "a19",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					 header: "迁往省内",
					 dataIndex: "a20",	
					 sortable: true,
					 width: 60
				 }
				 ,{
					    header: "迁往省外",
					    dataIndex: "a21",	
					    sortable: true,
					    width: 60
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
		
		Gnt.ux.RktjGrid.superclass.initComponent.call(this);
	}
});
Ext.reg('rktj_grid', Gnt.ux.RktjGrid);
