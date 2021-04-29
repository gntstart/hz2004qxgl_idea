/**
 * 标准地址选择,必须先加载commFrames.js
 */
var bbClick = true;//用来控制连续点击触发多少单击事件  add by zjm 20200707
Gnt.ux.SelectRh = Ext.extend(Ext.Window, {
	title:'户信息查询',
	closeAction:'hide',
	modal:true,
	width:700,
	height:600,
	margins:'5',
	layout:'border',
	pageSize:30,
	resetData:function(){
		this.qrForm.getForm().reset();
		this.grid10019.store.removeAll();
		this.grid20016.store.removeAll();
		this.hxx = null;
	},
	initComponent : function(){
		if(!Gnt.loadSjpzb("10016,10019,20016",function(){}))
			return;
		
		var returnTitleText = this.returnTitleText;
		if(!returnTitleText || returnTitleText=="") returnTitleText = "户信息查询";
		
		this.returnTitleText = returnTitleText;
		
		this.setTitle(returnTitleText);

		this.qrForm = new Gnt.ux.SjpzForm({
			closable: false,
			region : 'north',
			pzlb: '10016',
			cols:2,
			height:100,
			formType:'query',
			labelWidth :  80,
	        title: '',
	        buttons:[{
	            text:'查询',
				minWidth:75,
				handler:function(){
					var win = this.findParentByType("rh_window");

					var form = win.qrForm;
					var gridHcy = win.grid10019;
					var grid = win.grid20016;
					
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
					
					gridHcy.store.removeAll();
					grid.store.removeAll();
					
					data.pzlb = grid.store.pzlb;
					//删除综合查询条件
					data.where = "";
					data.log_code = "F1025";
					data.dqbm = win.dqbm;
					grid.store.baseParams = data;
					grid.store.load({params:{start:0, limit:grid.store.pageSize}});
				}
	        }]
		});
		
		this.grid20016 = new Gnt.ux.SjpzGrid({
			title: '户信息列表',
			region : 'center',
			url: 'yw/kdqqy.do?method=queryCzrkjbxx',
			pzlb: '20016',
			pkname: 'rynbid',
			loadCallback:function(res, store, bind_grid){
					var win = bind_grid.findParentByType("rh_window");
					if(win.hzywjo){
						//如果存在户政业务，那么自动化处理
						if(res.length>0){
							bind_grid.fireEvent("rowclick",bind_grid,0);
						}else{
							showInfo("没有找到相关的人员资料，户政业务无法处理！");
						}
					}
			},
			listeners:{
	    		rowclick:function(g, rowIndex, e){
	    			if(bbClick){//fan
	    				var win = this.findParentByType("rh_window");
		    			
		    			var gridHcy = win.grid10019;
		    			
		    			var data = g.store.getAt(rowIndex).data;
		    			win.hxx = data;
						var store = gridHcy.store;
						store.baseParams = {
							pzlb: store.pzlb,
							hhnbid: data.hhnbid,
							dqbm : win.dqbm,
							log_code: 'F1004'
						};
						store.load({params:{start:0, limit:40}});
						/**
						 住址变动业务需要
						 */
						if(win.rowclickBack){
							win.rowclickBack('rh', data);
						}
	    			}
	    		}
	    	}
		});
		
		this.grid10019 = new Gnt.ux.SjpzGrid({
			title: '户成员列表',
			region : 'center',
			height:180,
			url: 'yw/kdqqy.do?method=queryCzrkjbxx',
			pzlb: '10019',
			pageSize:40,
			loadCallback:function(res, store, bind_grid){
				var win = bind_grid.findParentByType("rh_window");
				if(win.hzywjo){
					//如果存在户政业务，那么自动化处理
					if(res.length>0){
						(function(){
							win.buttons[0].handler();
						}).defer(200);
					}
				}
			},
			pkname: 'rynbid'
		});
		this.panel = new Ext.Panel({
			region : 'south',
			height:180,
			items:[this.grid10019,{
    	    	frame:false,
				border:false,
				id:'_READ_CARD_ID',
				xtype:'panel',
				html:'',
				width:10
			}]
		});
		this.items = [this.qrForm, this.grid20016, this.panel];
		
		Gnt.ux.SelectRh.superclass.initComponent.call(this);
	},
    buttons:[{
        text:'确定',
		minWidth:75,
		handler:function(){
			var win = this.findParentByType("rh_window");
			var grid = win.grid10019;
			
			//var grid = win.items.get(2);
			if(grid.store.getCount()<=0){
				showErr("请先查询户信息！");
				return;
			}
			win.hide();
			
			var selectHcy = null;
			
			var hcyList = new Array();
			grid.store.each(function(r){
				hcyList.push(r.data);
				
				//默认选择人员是户主
				if(r.data.yhzgx=="01" || r.data.yhzgx=="02" || r.data.yhzgx=="03"){
					selectHcy = r;
				}
			});
			
			if(win.select_type=='1'){
				//选择申报人时，可以寻找非户主
				selectHcy = grid.getSelectionModel().getSelected();
			}
			
			if(!selectHcy){
				selectHcy = grid.store.getAt(0);
			}
			win.hxx.dqbm = win.dqbm;
			//GetDzxz(TClientDataSet(wsCdsRyxx),'ssxq','jlx','mlph','mlxz','pcs','zrq','xzjd','jcwh','1009');
			Gnt.submit(
					win.hxx, 
					"yw/kdqqy.do?method=getDzxz",
					"请稍后...", 
					function(jsonData,params){
						if(win.callback && jsonData.list && jsonData.list.length>0){
							try{
								win.callback('rh', hcyList, selectHcy.data, win.hxx, jsonData.list[0],win.hzywjo);
							}catch(e){
								showInfo(e);
							}
						}
					}
			);
		}
    },{
        text:'关闭',
		minWidth:75,
		handler:function(){
			var win = this.findParentByType("rh_window");
			
			/**
				住址变动业务需要
				关闭后清空信息
			 */
			if(win.closeWin)
				win.closeWin('rh');
			
			win.hide();
		}
    }]
});
Ext.reg('rh_window', Gnt.ux.SelectRh);
