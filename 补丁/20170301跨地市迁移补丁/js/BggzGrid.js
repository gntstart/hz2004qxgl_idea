/**
 * 常住人口store，必须先加载commFrames.js,BggzStore.js
 */
Gnt.ux.BggzGrid = Ext.extend(Ext.grid.EditorGridPanel, {
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
    loadData:function(data){
    	this.store.baseParams = data;
		this.store.load({params:{start:0, limit:this.pagesize}});
    },
    listeners:{
    	rowclick:function(g, rowIndex, e){
    		g.startEditing(rowIndex,4);
		}
    },
	initComponent: function() {
		this.store=new Gnt.store.BggzStore({
			url:this.url
	    });
		
		this.clicksToEdit = 1;
		this.sm = new Ext.grid.CheckboxSelectionModel();
		this.bggzlxEditor = new Gnt.ux.DictComboBox({
	    	dict:"VisionType=CS_BGGZLB"
	    });
		
		if(!this.cm){
			this.cm=new Ext.grid.ColumnModel([{
				    header: "姓名",
				    dataIndex: "xm",	
				    sortable: true,
				    width: 80
				 },{
				     header: "变更更正项目",
				     dataIndex: "bggzxm_mc",	
				     sortable: true,
				     width: 80
				 },{
					    header: "变更前内容",
					    dataIndex: "bggzqnr",	
					    sortable: true,
					    width: 120
				 },{
					    header: "变更后内容",
					    dataIndex: "bggzhnr",	
					    sortable: true,
					    width: 120
				 },{
					    header: "变更更正类别",
					    dataIndex: "bggzlb",	
					    sortable: true,
					    width: 140,
					    editor:this.bggzlxEditor,
					    renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
							return Gnt.ux.Dict.getDictLable('CS_BGGZLB', value);
					    }
				 }
			 ]);
		}
		
		//这个必须放store定义后，否则不可预料
		if(!this.view){
			this.view = new Ext.grid.GridView({
				forceFit:true,
				autoFill:false,
				enableRowBody:true
		    });
		}
		
		Gnt.ux.BggzGrid.superclass.initComponent.call(this);
	}
});
Ext.reg('BggzGrid', Gnt.ux.BggzGrid);
