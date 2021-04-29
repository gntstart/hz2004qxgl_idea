/**
 * 标准地址选择,必须先加载commFrames.js
 */
Gnt.ux.SelectBzdz = Ext.extend(Ext.Window, {
	title:'地址信息输入',
	closeAction:'hide',
	modal:true,
	width:500,
	height:370,
	margins:'5',
	layout:'fit',
	html:'',
	initComponent : function(){
		var fs = new Ext.form.FormPanel({
	    	height: 100,
	    	region: 'north',
	    	anchor:'100% 100%',
	    	buttonAlign:'right',
	    	labelAlign:'right',
	    	frame:true,
	    	border:false,
	    	fileUpload: true, 
	    	margins:'0',
	        layout:'form',
	        labelWidth:100,
	        setMore:function(data){
	        	var win = this.findParentByType("bzdz_window");
	        	
	        	var f1 = this.getForm().findField("ssxq");
	        	var f2 = this.getForm().findField("xzjdmc");
	        	var f3 = this.getForm().findField("pcsmc");
	        	
	        	f1.setValue(data.dwdm_bz);
	        	f2.setValue(data.xzjddm_name);
	        	f3.setValue(data.dwdm_name);
	        	
	        	win.moreData = data;
	        },
	       	items:[{
	        		layout:'column',
	    			frame:false,
	    			border:false,
	        		defaults:{
	        			border:false,
	        			frame:false
	        		},
	            	items:[{
		                columnWidth:1,
	    	           	layout: 'form',
	    	           	bodyStyle:'padding:5 0 0 0',
	        	       	items: [{
	        	       					anchor:'100%',
										xtype:'dict_combox',
										dict:'VisionType=CS_HLX',
										value:"",
										name:'hlxmc',
										maxLength:40,
										hiddenName:'hlx',
										allowBlank:false,
										fieldLabel:'户类型'
									}]
								},{
					                columnWidth:1,
				    	           	layout: 'form',
				    	           	bodyStyle:'padding:5 0 0 0',
				        	       	items: [{
				        	       		anchor:'100%',
										xtype:'search_combox',
										searchUrl:'yw/dqdict.do?method=searchJlx',
										fields:["mc","dm","jwhList"],
										valueField: "dm",
										displayField: "mc",
										hiddenName:'jlx',
										listeners:{
											select:function(combo, res, eOpts ){
												var win = this.findParentByType("bzdz_window");
												
												//填充居委会数据
												var data = res.data;
												
												var f = combo.findParentByType("form").getForm().findField("jcwh");
												f.setValue("");
												f.store.removeAll();

												if(data.jwhList && data.jwhList.length>0){
													var list = new Array();
													for(var i=0;i<data.jwhList.length;i++){
														list[i] = new Array();
														list[i][0]=data.jwhList[i].dm;
														list[i][1]=data.jwhList[i].mc;
														list[i][2]=data.jwhList[i];
													}
													
													f.store.loadData(list);
													f.setValue(list[0][0]);
													combo.findParentByType("form").setMore(list[0][2]);
												}
											}
										},
										name:'jlxmc',
										maxLength:40,
										allowBlank:false,
										fieldLabel:'街路巷'
									}]
								},{
					                columnWidth:1,
				    	           	layout: 'form',
				    	           	bodyStyle:'padding:5 0 0 0',
				        	       	items: [{
										xtype:'textfield',
										anchor:'100%',
										name:'mlph',
										allowBlank:false,
										fieldLabel:'门牌楼号'
									}]
								},{
					                columnWidth:1,
				    	           	layout: 'form',
				    	           	bodyStyle:'padding:5 0 0 0',
				        	       	items: [{
										xtype:'textfield',
										anchor:'100%',
										name:'mlxz',
										allowBlank:false,
										fieldLabel:'门楼详址'
									}]
								},{
					                columnWidth:1,
				    	           	layout: 'form',
				    	           	bodyStyle:'padding:5 0 0 0',
				        	       	items: [{
				        	       		xtype:'dict_combox',
										dict:'VisionType=_BLANK',
										anchor:'100%',
										name:'jcwhmc',
										maxLength:40,
										fieldLabel:'居（村）委会',
										allowBlank:false,
										valueField: "code",
										displayField: "name",
										hiddenName:'jcwh',
										listeners:{
											select:function(combo, res, eOpts ){
												combo.findParentByType("form").setMore(res.data.data);
											}
										}
									}]
								},{
					                columnWidth:1,
				    	           	layout: 'form',
				    	           	bodyStyle:'padding:5 0 0 0',
				        	       	items: [{
										xtype:'textfield',
										anchor:'100%',
										name:'ssxq',
										allowBlank:false,
										disabled:true,
										fieldLabel:'省市县（区）'
									}]
								},{
					                columnWidth:1,
				    	           	layout: 'form',
				    	           	bodyStyle:'padding:5 0 0 0',
				        	       	items: [{
										xtype:'textfield',
										anchor:'100%',
										name:'xzjdmc',
										disabled:true,
										fieldLabel:'乡镇（街道）'
									}]
								},{
					                columnWidth:1,
				    	           	layout: 'form',
				    	           	bodyStyle:'padding:5 0 0 0',
				        	       	items: [{
										xtype:'textfield',
										anchor:'100%',
										name:'pcsmc',
										disabled:true,
										fieldLabel:'派出所'
									}]
								},{
					                columnWidth:1,
				    	           	layout: 'form',
				    	           	bodyStyle:'padding:5 0 0 0',
				        	       	items: [{
				        	       		xtype:'dict_combox',
										dict:'VisionType=_BLANK',
										anchor:'100%',
										name:'zrqmc',
										hiddenName:'zrq',
										fieldLabel:'责任区'
									}]
								}
				]
			}],
	    	buttons:[
	    	 		{
	    	 			text:'匹配地址',
	    	 			minWidth:75,
	    	 			handler:function(b){
	    	 				var win = this.findParentByType("bzdz_window");
	    	 				var data = win.items;
	    	 				var params = data.items[0].getForm().getValues(true);
	    	 			
	    	 				var bzdzWindow = new Ext.Window({
	    	 						title:'地址信息输入',
	    	 						closeAction:'close',
	    	 						modal:true,
	    	 						width:800,
	    	 						height:550,
	    	 						margins:'0',
	    	 						layout:'fit',
	    	 						html:'<iframe style="width:100%;height:100%" src="yw/bzdz.jsp?' + params + '" frameborder="0" border="0">',
	    	 						buttons:[
	    	 							{
	    	 								text:'确定',
	    	 								minWidth:75,
	    	 								handler:function(){
	    	 			    	 				var str1=window.clipboardData.getData("text");  
	    	 			    	 				if(str1==""){
	    	 			    	 					showErr("剪贴板没有可拷贝的内容！");
	    	 			    	 					return;
	    	 			    	 				}

	    	 			    	 				var bzdz = Ext.decode(str1);
	    	 			    	 				if(bzdz.uuid==undefined){
	    	 			    	 					bzdz.uuid = bzdz.id;
	    	 			    	 					bzdz.bzdz = bzdz.addr;
	    	 			    	 				}
	    	 			    	 				
	    	 			    	 				var rootWin = this.findParentByType("window").parentWindow;
	    	 			    	 				rootWin.bzdz = bzdz;
	    	 			    	 				
	    	 			    	 				bzdzWindow.hide();
	    	 								}
	    	 							},{
	    	 								text:'关闭',
	    	 								minWidth:75,
	    	 								handler:function(){
	    	 									bzdzWindow.hide();
	    	 								}
	    	 							}
	    	 						]
	    	 				});
	    	 				
	    	 				bzdzWindow.parentWindow = win;
	    	 				bzdzWindow.show();
	    	 			}
	    	 		},{
	    	 			text:'保存',
	    	 			minWidth:75,
	    	 			handler:function(){
	    	 				var rootWin = this.findParentByType("bzdz_window");
	    	 				var form = rootWin.items.get(0);
	    	 				
	    	 				if(!form.getForm().isValid()){
	    						showErr("地址信息必须填写！");
	    						return;
	    					}
	    	 				
	    	 				var lhdz = form.getForm().getValues();
	    	 				if(rootWin.bzdz){
	    	 					for(o in rootWin.bzdz)
	    	 						lhdz[o] = rootWin.bzdz[o];
	    	 				}
	    	 				
	    	 				if(rootWin.moreData){
	    	 					for(o in rootWin.moreData)
	    	 						lhdz[o] = rootWin.moreData[o];
	    	 				}

							if(rootWin.callback){
								rootWin.callback("lhdz", lhdz);
							}
							rootWin.hide();
	    	 			}
	    	 		},{
	    	 			text:'关闭',
	    	 			minWidth:75,
	    	 			handler:function(){
	    	 				var win = this.findParentByType("bzdz_window");
	    	 				
	    	 				win.hide();
	    	 			}
	    	 		}
	    	 	]
		});
		
		this.items = fs;
		
		Gnt.ux.SelectBzdz.superclass.initComponent.call(this);
	}
});
Ext.reg('bzdz_window', Gnt.ux.SelectBzdz);
