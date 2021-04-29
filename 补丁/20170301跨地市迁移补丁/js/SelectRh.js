/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.ux.SelectRh = Ext.extend(Ext.Window, {
	title:'户信息查询',
	closeAction:'hide',
	modal:true,
	width:700,
	height:500,
	margins:'5',
	layout:'border',
	pageSize:30,
	initComponent : function(){
		if(!Gnt.loadSjpzb("10016,10019,20016",function(){}))
			return;
		
		var qrForm = new Gnt.ux.GntForm({
			closable: false,
			region : 'north',
			pzlb: '10016',
			cols:2,
			height:100,
			labelWidth :  80,
			getDictCust:function(cmb,visiontype){
				return;
			},
			changeDictCust:function(cmb,res){
				return;
			},
	        title: '',
	        buttons:[{
	            text:'查询',
				minWidth:75,
				handler:function(){
					var win = this.findParentByType("rh_window");
					var grid = win.items.get(1);
					var form = win.items.get(0);
					var gridHcy = win.items.get(2);
					
					if(!form.getForm().isValid()){
						showInfo("数据校验没有通过，请检查！");
						return;
					}
					
					var data = form.getForm().getValues();
					var icount = 0;
					for(o in data)
						if(data[o]!='')
							icount++;
					
					if(icount==0){
						showErr("必须输入至少一个查询条件！");
						return;
					}
					
					delete grid.store.isinit;
					
					gridHcy.store.removeAll();
					grid.store.removeAll();
					
					grid.store.baseParams = data;
					grid.store.load({params:{start:0, limit:grid.store.pageSize}});
				}
	        }]
		});
		
		var grid = new Gnt.ux.GntGrid({
			title: '户信息列表',
			region : 'center',
			url:'yw/kdqqy.do?method=queryCzrkjbxx',
			pzlb: '20016',
			listeners:{
	    		rowclick:function(g, rowIndex, e){
	    			var win = this.findParentByType("rh_window");
	    			var gridHcy = win.items.get(2);
	    			
	    			var r = g.store.getAt(rowIndex);
	    			var p = {hh:r.data.hh}
	    			
	    			delete gridHcy.store.isinit;
	    			
	    			gridHcy.loadData(p);
	    		}
	    	}
		});
		
		var grid2 = new Gnt.ux.GntGrid({
			title: '户成员列表',
			region : 'south',
			height:180,
			url:'yw/kdqqy.do?method=queryCzrkjbxx',
			pzlb: '10019'
		});
		
		this.items = [qrForm, grid, grid2];
		
		Gnt.ux.SelectRh.superclass.initComponent.call(this);
	},
    buttons:[{
        text:'确定',
		minWidth:75,
		handler:function(){
			var win = this.findParentByType("rh_window");
			var grid = win.items.get(1);
			//var grid = win.items.get(2);
			if(grid.store.getCount()<=0){
				showErr("请先查询户信息！");
				return;
			}
			win.hide();
			
			var res = grid.getSelectionModel().getSelected();
			if(!res || res.length==0){
				showErr("必须先选择户信息！");
				return;
			}
			
			if(win.callback)
				win.callback("hxx", res.data);
		}
    },{
        text:'关闭',
		minWidth:75,
		handler:function(){
			var win = this.findParentByType("rh_window");
			win.hide();
		}
    }]
});
Ext.reg('rh_window', Gnt.ux.SelectRh);
