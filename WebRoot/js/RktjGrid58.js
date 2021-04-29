/**
 * 统计store，必须先加载commFrames.js,RktjStore.js
 */
Gnt.ux.Rktj58Grid = Ext.extend(Ext.grid.GridPanel, {
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
		this.store=new Gnt.store.Rktj58Store({
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
				        	 header: "位 ",
				        	 dataIndex: "a1",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 120
				         },{
				        	 header: "数",
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
				        	 header: "生",
				        	 dataIndex: "a4Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "现&nbsp;&nbsp;役",
				        	 dataIndex: "a5Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "外国人、无国籍人入籍",
				        	 dataIndex: "a6Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "迁&nbsp;&nbsp;&nbsp;&nbsp;入",
				        	 dataIndex: "a7Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "迁&nbsp;&nbsp;&nbsp;&nbsp;入",
				        	 dataIndex: "a8Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "计",
				        	 dataIndex: "a9Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "本市(地)",
				        	 dataIndex: "a10Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "本省外市 (地)",
				        	 dataIndex: "a11Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 65
				         }
				         ,{
				        	 header: "外省",
				        	 dataIndex: "a12Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "大中专院校招生",
				        	 dataIndex: "a13Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "录(聘)用",
				        	 dataIndex: "a14Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "务工经商",
				        	 dataIndex: "a15Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "投资 (创业)",
				        	 dataIndex: "a16Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "购(租)房",
				        	 dataIndex: "a17Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "投靠亲属",
				        	 dataIndex: "a18Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "移民搬迁",
				        	 dataIndex: "a19Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "城中村改造",
				        	 dataIndex: "a20Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "城乡属性调整",
				        	 dataIndex: "a21Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "其他",
				        	 dataIndex: "a22Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "他",
				        	 dataIndex: "a23Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "计",
				        	 dataIndex: "a24Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "亡",
				        	 dataIndex: "a25Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "役",
				        	 dataIndex: "a26Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "加入外国籍",
				        	 dataIndex: "a27Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "迁出",
				        	 dataIndex: "a28Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ,{
				        	 header: "他",
				        	 dataIndex: "a29Str",	
				        	 sortable: true,
				        	 align: "center",
				        	 width: 60
				         }
				         ]
				,rows: [
				        [{
				        	header: "填",
				        	align: "center",
				        	colspan: 1
				        }, {
				        	header: "年&nbsp;&nbsp;末",
				        	align: "center",
				        	colspan: 1
				        }, {
				            header: "增&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;加&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;况",
				            align: "center",
				            colspan: 21
				        }, {
				            header: "减&nbsp;&nbsp;&nbsp;&nbsp;少&nbsp;&nbsp;&nbsp;&nbsp;情&nbsp;&nbsp;&nbsp;&nbsp;况",
				            align: "center",
				            colspan: 6
				        }]
				        ,[{
				        	header: "报",
				        	align: "center",
				        	colspan: 1
				        	
				        },{
				        	header: "城&nbsp;&nbsp;镇",
				        	align: "center",
				        	colspan: 1
				        	
				        },{
				        	header: "合",
				        	align: "center",
				        	colspan: 1
				        },{
				        	
				        	header: "出",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "退&nbsp;&nbsp;出",
				        	align: "center",
				        	colspan: 1
				        	
				        },{
				        	header: "港澳台人员和华侨",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "城镇人口迁入",
				        	align: "center",
				        	colspan: 2
				        },{
				        	header: "农&nbsp;&nbsp;&nbsp;&nbsp;业&nbsp;&nbsp;&nbsp;&nbsp;转&nbsp;&nbsp;&nbsp;&nbsp;移&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;口&nbsp;&nbsp;&nbsp;&nbsp;落&nbsp;&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;&nbsp;城&nbsp;&nbsp;&nbsp;&nbsp;镇",
				        	align: "center",
				        	colspan: 14
				        },{
				        	header: "其",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "合",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "死",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "服",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "赴港澳台和",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "城镇",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "其",
				        	align: "center",
				        	colspan: 1
				        }]
				        ,[{
				        	header: "单",
				        	align: "center",
				        	colspan: 1
				        	
				        },{
				        	header: "人&nbsp;&nbsp;口",
				        	align: "center",
				        	colspan: 1
				        	
				        },{
				        	header: "",
				        	align: "center",
				        	colspan: 1
				        },{
				        	
				        	header: "",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "",
				        	align: "center",
				        	colspan: 1
				        	
				        },{
				        	header: "回内地（回国）定居及",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "省&nbsp;&nbsp;&nbsp;&nbsp;内",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "省&nbsp;&nbsp;&nbsp;&nbsp;外",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "小",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "来&nbsp;&nbsp;&nbsp;&nbsp;自&nbsp;&nbsp;&nbsp;&nbsp;地&nbsp;&nbsp;&nbsp;&nbsp;区",
				        	align: "center",
				        	colspan: 3
				        },{
				        	header: "增&nbsp;&nbsp;&nbsp;&nbsp;加&nbsp;&nbsp;&nbsp;&nbsp;原&nbsp;&nbsp;&nbsp;&nbsp;因",
				        	align: "center",
				        	colspan: 10
				        },{
				        	header: "",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "现",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "国外定居及",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "人口",
				        	align: "center",
				        	colspan: 1
				        },{
				        	header: "",
				        	align: "center",
				        	colspan: 1
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
		
		Gnt.ux.Rktj58Grid.superclass.initComponent.call(this);
	}
});
Ext.reg('rktj_grid', Gnt.ux.Rktj58Grid);
