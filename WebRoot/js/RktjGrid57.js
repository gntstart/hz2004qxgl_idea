/**
 * 统计store，必须先加载commFrames.js,RktjStore.js
 */
Gnt.ux.Rktj57Grid = Ext.extend(Ext.grid.GridPanel, {
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
		this.store=new Gnt.store.Rktj57Store({
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
				        	 dataIndex: "a1",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 120
				         },{
				        	 header: "数（户）",
				        	 dataIndex: "a2Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         },{
				        	 header: "计",
				        	 dataIndex: "a3Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				        	 
				         }
				         ,{
				        	 header: "人&nbsp;&nbsp;&nbsp;&nbsp;口",
				        	 dataIndex: "a4Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "人&nbsp;&nbsp;&nbsp;&nbsp;口",
				        	 dataIndex: "a5Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "男",
				        	 dataIndex: "a6Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "女",
				        	 dataIndex: "a7Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "0-17岁",
				        	 dataIndex: "a8Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "18-34岁",
				        	 dataIndex: "a9Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "35-59岁",
				        	 dataIndex: "a10Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "60岁及以上",
				        	 dataIndex: "a11Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 65
				         }
				         ,{
				        	 header: "合计",
				        	 dataIndex: "a12Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "男",
				        	 dataIndex: "a13Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "女",
				        	 dataIndex: "a14Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "合计",
				        	 dataIndex: "a15Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "男",
				        	 dataIndex: "a16Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "女",
				        	 dataIndex: "a17Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "省内迁入",
				        	 dataIndex: "a18Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "省外迁入",
				        	 dataIndex: "a19Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "迁往省内",
				        	 dataIndex: "a20Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "迁往省外",
				        	 dataIndex: "a21Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ]
				,rows: [
				        [{
				        	header: "填&nbsp;&nbsp;&nbsp;&nbsp;报",
				        	align: "center",
				        	colspan: 1
				        }, {
				        	header: "年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;末",
				        	align: "center",
				        	colspan: 1
				        }, {
				            header: "年&nbsp;&nbsp;&nbsp;&nbsp;末&nbsp;&nbsp;&nbsp;&nbsp;总&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;口",
				            align: "center",
				            colspan: 9
				        }, {
				            header: "本&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;度&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;口&nbsp;&nbsp;&nbsp;&nbsp;变&nbsp;&nbsp;&nbsp;&nbsp;动",
				            align: "center",
				            colspan: 10
				        }]
				        ,[{
				        	
				        },{
				        	header: "总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户",
				        	align: "center",
				        	colspan: 1
				        	
				        },{
				        	header: "合",
				        	align: "center",
				        	colspan: 1
				        },{
				        	
				        	header: "城&nbsp;&nbsp;&nbsp;&nbsp;镇",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "乡&nbsp;&nbsp;&nbsp;&nbsp;村",
				        	align: "center",
				        	colspan: 1
				        	
				        },{
				        	header: "性&nbsp;&nbsp;&nbsp;&nbsp;别",
				        	align: "center",
				        	colspan: 2
				        },{
				        	header: "年&nbsp;&nbsp;&nbsp;&nbsp;龄",
				        	align: "center",
				        	colspan: 4
				        },{
				        	header: "出&nbsp;&nbsp;&nbsp;&nbsp;生",
				        	align: "center",
				        	colspan: 3
				        },{
				        	header: "死&nbsp;&nbsp;&nbsp;&nbsp;亡",
				        	align: "center",
				        	colspan: 3
				        },{
				        	header: "迁&nbsp;&nbsp;&nbsp;&nbsp;入",
				        	align: "center",
				        	colspan: 2
				        },{
				        	header: "迁&nbsp;&nbsp;&nbsp;&nbsp;出",
				        	align: "center",
				        	colspan: 2
				        }]
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
		
		Gnt.ux.Rktj57Grid.superclass.initComponent.call(this);
	}
});
Ext.reg('rktj_grid', Gnt.ux.Rktj57Grid);
