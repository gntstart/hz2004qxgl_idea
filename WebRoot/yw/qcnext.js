var rhWindow = null;
var rhData = null;
var dzData = null;
var bzdzWindow = null;
var initJsonData = null;

Ext.onReady(function(){
	//10030 迁入审批信息
	//10031 迁入审批子信息//CS_HJSPCL
	Gnt.ux.Dict.loadDict(['CS_HJSPCL','CS_HLX','CS_XB','CS_JTGX','CS_MZ','CS_HYZK','CS_XX','CS_NYZYRKLHCZYY'],function(){

	});
	
	//首先以AJAX同步的方式获取页面需要的配置，然后从本地进行渲染界面
	if(!Gnt.loadSjpzb("10030,10031",function(){}))
		return;
	
	Ext.QuickTips.init();
	
	//提示hjywid=3401000001002274811&qwdq=3401
	var hjywid = getQueryParam("hjywid");
	var qcdq = getQueryParam("qcdq");
	
	var selSqryRes = null;
	
	var zqryGrid = new Gnt.ux.GntGrid({
		region:'west',
		region:'west',
		width:200,
		title:'主迁人',
		pk:"ryid",
		showPaging:false,
		pzlb:'10030'
		/**
			2017.09.25
			新增	刁杰
			原先的width为0，并且没有拖拽条
		,split:true	//Region的构造参数，要求实现BorderLayout.SplitRegion
        ,margins: '0'	//Region的构造参数，指定页边的空白
        ,collapseMode:'mini'//SplitRegion的构造参数
        ,useSplitTips:true	//SplitRegion的构造参数
        ,splitTip: "拖动来改变尺寸."//SplitRegion的构造参数
        ,collapsibleSplitTip:'拖动来改变尺寸. 双击隐藏'
		 */
	});
	
	var form10030 = new Gnt.ux.GntForm({
		closable: false,
		title:'主迁人员信息',
		region:'center',
		id:'form10030',
		pzlb: '10030',
		bindStore:zqryGrid.store,
		bindViewGrid:zqryGrid,
		labelWidth :  120
	});
	
	var sqryGrid = new Gnt.ux.GntGrid({
		region:'west',
		width:200,
		title:'随迁人员列表',
		pk:"ryid",
		showPaging:false,
		url: "yw/kdqqy.do?method=queryKdsQczxxx",
		pzlb:'10031',
		split:true,//Region的构造参数，要求实现BorderLayout.SplitRegion
        margins: '0',	//Region的构造参数，指定页边的空白
        collapseMode:'mini',//SplitRegion的构造参数
        useSplitTips:true,	//SplitRegion的构造参数
        splitTip: "拖动来改变尺寸.",//SplitRegion的构造参数
        collapsibleSplitTip:'拖动来改变尺寸. 双击隐藏',
        listeners:{
    		rowclick:function(g, rowIndex, e){
    			selSqryRes = g.store.getAt(rowIndex);
    			
    			form10031.getForm().reset();
    			form10031.getForm().loadRecord(selSqryRes);
    		}
        },
        loadCallback:function(store,res){
        	if(res.length>0){
        		//保存初始化数据
        		initJsonData = store.reader.meta.reader.jsonData;
        		
        		(function(){
            		for(var i=0;i<res.length;i++){
            			var r = res[i];
            			//r.set("hkxz",r.data.hb);
            			var data = store.reader.meta.reader.jsonData.list[i];
            			r.set("hkxz",data.hb);//迁入前户别
            			r.set("yhkqx",data.ssxq);//迁入前地区
            		}
        			
        			//添加一个主迁人
        			var zqrData = res[0].data;
        			zqrData.hb = res[0].data.hkxz;
        			zqrData.zzssxq = initJsonData.list[0].ssxq;
        			//showInfo(Ext.encode(initJsonData));
        			var r = new zqryGrid.store.reader.recordType(zqrData, zqrData.ryid);
        			//显示主迁人
        			zqryGrid.store.add([r]);
        			form10030.getForm().loadRecord(r);
        			
        			//从随迁人中删除主迁人
        			sqryGrid.store.remove(res[0]);
        			//如果记录多余一个，那么显示第一个随迁人，并进行编辑
        			if(res.length>1){
        				sqryGrid.fireEvent("rowclick",sqryGrid,0);
        				sqryGrid.getSelectionModel().selectRange(0,0);
        			}
        			
            		//查询异地迁入
            		Ext.getCmp("btn1").setDisabled(false); 
            		Ext.getCmp("btn2").setDisabled(false); 
            		Ext.getCmp("btn3").setDisabled(false); 
            		Ext.getCmp("btn4").setDisabled(false); 
            		Ext.getCmp("btn5").setDisabled(false); 
            		Ext.getCmp("btn6").setDisabled(false); 
            		Ext.getCmp("btn7").setDisabled(false); 
        		}).defer(200);
        	}else{
        		showErr("没有找到迁出人员信息！");
        	}
        }
	});
	
	var form10031 = new Gnt.ux.GntForm({
		closable: false,
		title:'随迁人员信息',
		region:'center',
		id:'form10031',
		pzlb: '10031',
		bindStore:sqryGrid.store,
		bindViewGrid:sqryGrid,
		labelWidth :  120,
		buttons:[
			new Ext.Button({
				text:'申请人同主迁人',
				id:'btn1',
				minWidth:75,
				disabled:true,
				handler:function(){
					var res = zqryGrid.store.getAt(0);
					res.set("sqrxm",res.data.xm);
					res.set("sqrgmsfhm",res.data.gmsfhm);
					res.set("sqrzzssxq",res.data.zzssxq);
					res.set("sqrzzxz",res.data.zzxz);
					res.set("sqrhkdjjg",res.data.hkszddjjg);
					res.set("ysqrgx","01");
					
					form10030.getForm().loadRecord(res);
				}
			}),
			new Ext.Button({
				text:'添加随迁人员',
				minWidth:75,
				id:'btn2',
				disabled:true,
				handler:function(){
					var id = new Date().getTime();
					var r = new sqryGrid.store.reader.recordType({ryid:id},id);
					sqryGrid.store.add([r]);
					
					if(sqryGrid.store.getCount()==1){
						sqryGrid.fireEvent("rowclick",sqryGrid,0);
        				sqryGrid.getSelectionModel().selectRange(0,0);
					}
				}
			}),
			new Ext.Button({
				text:'删除随迁人员',
				minWidth:75,
				id:'btn3',
				disabled:true,
				handler:function(){
					Ext.MessageBox.confirm(
							'提示', 
							'真的要删除选择的随迁人吗？ ',
							function(btnType){
								if(btnType=="yes"){
									var res = sqryGrid.getSelectionModel().getSelected();
									if(!res){
										showErr("必须先选择随迁人员！");
										return;
									}
									sqryGrid.store.remove(res);
									form10031.getForm().reset();
									if(sqryGrid.store.getCount()>0){
										sqryGrid.fireEvent("rowclick",sqryGrid,0);
				        				sqryGrid.getSelectionModel().selectRange(0,0);
									}
								}
								if(btnType=="no"){
									
								}
							},
							window
					);
				}
			}),
			new Ext.Button({
				text:'随迁人设为主迁人',
				minWidth:75,
				id:'btn5',
				disabled:true,
				handler:function(){
					if(sqryGrid.store.getCount()<=0){
						showErr("没有随迁入！");
						return;
					}
					
					//获取随迁人信息
					var sqrRes = sqryGrid.getSelectionModel().getSelected();
					if(!sqrRes){
						showErr("请先选择随迁人员！");
						return;
					}
					
					//获取当前主迁人信息
					var zqrRes = zqryGrid.store.getAt(0);
		
					//备份主迁人和随迁人信息
					var zqrData_bak = {};
					var sqrData_bak = {};
					Ext.apply(zqrData_bak, zqrRes.data);
					Ext.apply(sqrData_bak, sqrRes.data);
					
					//将随迁人拷贝到主迁人，并显示
					for(o in sqrData_bak){
						if(o=="ryid") continue;
						
						zqrRes.set(o, sqrData_bak[o]);
					}
					if(!initDz()){
						form10030.getForm().loadRecord(zqrRes);
					}
					
					//将主迁人拷贝到随迁人
					for(o in zqrData_bak){
						if(o=="ryid") continue;
						
						sqrRes.set(o, zqrData_bak[o]);
					}
					form10031.getForm().loadRecord(sqrRes);
				}
			}),
			new Ext.Button({
				text:'保存',
				minWidth:75,
				id:'btn4',
				disabled:true,
				handler:function(){
					if(!form10030.checkInput())
						return;
					
					if(!form10031.checkInput())
						return;
					
					selectSpcl();
				}
			}),
			new Ext.Button({
				text:'关闭',
				minWidth:75,
				handler:function(){
					Ext.MessageBox.confirm(
							'提示', 
							'真的要放弃迁入吗？ ',
							function(btnType){
								if(btnType=="yes"){
									if(parent.closeActiveWorkSpace)
										parent.closeActiveWorkSpace();
								}
								if(btnType=="no"){
									
								}
							},
							window
					);
				}
			})
		]
	});
	
	var spWin = null;
	function selectSpcl(){
		if(!spWin){
				var data = Gnt.ux.Dict.getDictLocalData('CS_HJSPCL');
				var chkItems = new Array();
				for(var i=0;i<data.length;i++){
					chkItems.push({boxLabel: data[i].codename, name: 'cllx', inputValue:data[i].code + "=" + data[i].codename});
				}
				
				var fs = new Ext.form.FormPanel({
			    	region: 'center',
			    	anchor:'100% 100%',
			    	buttonAlign:'right',
			    	labelAlign:'right',
			    	frame:true,
			    	border:false,
			    	fileUpload: true, 
			    	margins:'0',
			        layout:'form',
			        labelWidth:60,
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
								                columnWidth:1,
							    	           	layout: 'form',
							    	           	bodyStyle:'padding:0 0 0 0',
							        	       	items: [{
												    xtype: 'checkboxgroup',
												    fieldLabel: '审批材料',
												    columns: 1,
												    anchor:'100%',
												    layout:'auto', 
								                    defaults:{ 
								                        bodyStyle:'padding:0 0 0 0',
														height: 25
								                    },
												    items:chkItems
												}]
										},{
							                columnWidth:1,
						    	           	layout: 'form',
						    	           	bodyStyle:'padding:5 0 0 0',
						        	       	items: [{
												xtype:'textarea',
												anchor:'100%',
												height:60,
												name:'fy',
												fieldLabel:'附言'
											}]
										}
			        	       ]}
						]
					}]
				});
				
				spWin = new Ext.Window({
			   		id:"windowid",
				    title:'选择审批信息',
				    layout:'border',
				    items:[fs],
				    width:400,
				    height:300,
				    minHeight:200,			//resizable:true时，高度最小值为200像素
				 	minWidth:400,			//resizable:true时，宽度最小值为400像素
				    maximizable:false,		//是否有最大化按钮，默认为false
				    minimizable:false,		//是否有最小化按钮，默认为false
					expandOnShow:false,	//窗口显示的时候，保持原来的缩放状态，默认为show
				    draggable:true,		//是否可以拖动，默认为true
				    defaultButton:0,		//指定buttons的第0个按钮为默认按钮
				    constrain:true,		//窗口不会被拖放到看不到的区域
			   		modal:true,			//是否是模式窗口
				    closable:false, 		//是否有关闭按钮，默认true
				   	closeAction:"hide",	//窗口关闭模式：close|hide
				   	buttons:[{
							xtype:"button",
							pressed: true,
							enableToggle: true,
							text:"确定",
							handler:function(c){
								var fs = spWin.items.get(0);
								var spdata = fs.getForm().getValues();
								submitData(spdata);
							}
			            }, {
			            	text:"取消",
							xtype:"button",
			    			pressed: true,
			            	enableToggle: true,
							handler:function(c){
								spWin.hide();
							}
					}]
			});
		}
		spWin.show();

		return false;
	}
	
	function submitData(spData){
		var subdata = {
				cllx: spData.cllx,
				spsm: spData.fy,
				voQrspdjxx: zqryGrid.store.getAt(0).data
		};
		
		var count = sqryGrid.store.getCount();
		if(count>0){
			subdata.voQrspdjzxx = new Array();
			for(var index=0;index<count;index++){
				subdata.voQrspdjzxx.push(sqryGrid.store.getAt(index).data);
			}
		}
		
		for(o in subdata){
			subdata[o] = Ext.encode(subdata[o]);
		}
		
		//跨地区户籍业务信息，防止重复迁入
		subdata.hjywid = hjywid;
		subdata.qcdq = qcdq;
		
		Gnt.submit(
				subdata, 
				"yw/kdqqy.do?method=saveKdsQcEnd", 
				"正在处理迁入信息，请稍后...", 
				function(jsonData,params){
					showInfo("跨地市迁入成功！",function(){
						//关闭当前窗口
						if(parent.closeActiveWorkSpace)
							parent.closeActiveWorkSpace();
					});
				}
		);
	}
	
	//初始化立户/入户动作
	function initDz(){
		if(rhData){
			var res = zqryGrid.store.getAt(0);
			res.set("qrdhlx",rhData.hlx);
			res.set("qrdxzjd",rhData.xzjd);
			res.set("qrdqx",rhData.ssxq);
			res.set("qrdpcs",rhData.pcs);
			res.set("qrdjlx",rhData.jlx);
			res.set("qrdmlph",rhData.mlph);
			res.set("qrdz",rhData.mlxz);
			res.set("qrdjwh",rhData.jcwh);
			/*设置主迁人
			qrdhlx	*迁入地户类型
			qrdqx	*迁入地省市县区	
			qrdpcs	*迁入地派出所
			qrdxzjd	*迁入地乡镇街道
			qrdjwzrq	迁入地警务责
			qrdjwh	*迁入地居委员会
			qrdjlx	*迁入地街路巷
			qrdmlph	迁入地门楼牌号
			qrdz	迁入地址
			qrdhkdjjg	迁入地户口登记机关
			*/
			form10030.getForm().loadRecord(res);
			
			return true;
		}
		
		if(dzData){
			/*设置主迁人
			qrdhlx	*迁入地户类型
			qrdqx	*迁入地省市县区	
			qrdpcs	*迁入地派出所
			qrdxzjd	*迁入地乡镇街道
			qrdjwzrq	迁入地警务责
			qrdjwh	*迁入地居委员会
			qrdjlx	*迁入地街路巷
			qrdmlph	迁入地门楼牌号
			qrdz	迁入地址
			qrdhkdjjg	迁入地户口登记机关
			{"hlx":"2",	"jlx":"340702001031","mlph":"的萨芬萨",
			"mlxz":"范德萨范德萨分 的撒反对撒飞洒地方大师傅地方大师傅",
			"jcwh":"340702003098","zrq":"","dm":"340702003098","mc":"集体户",
			"zwpy":"JTH","dwdm":"340702003","xzjddm":"340702003","qybz":"1",
			"bdlx":"U","bdsj":"20161024000011","cxfldm":"210","cxflmc":"乡中心区",
			"dwdm_name":"石城路派出所","xzjddm_name":"石城路街道","dwdm_bz":"安徽省铜陵市铜官山区"}
			*/
			var res = zqryGrid.store.getAt(0);
			res.set("qrdhlx",dzData.hlx);
			res.set("qrdxzjd",dzData.xzjddm);
			res.set("qrdqx",dzData.xzjddm.substring(0,6));
			res.set("qrdpcs",dzData.dwdm);
			res.set("qrdjlx",dzData.jlx);
			res.set("qrdmlph",dzData.mlph);
			res.set("qrdz",dzData.mlxz);
			res.set("qrdjwh",dzData.jcwh);
			
			form10030.getForm().loadRecord(res);
			
			return true;
		}
		
		return false;
	}
	
	new Ext.Viewport({
        layout:'border',
        id:'vp',
        items:[{
				height: 40,
				region: 'north',
				title:'业务办理方式选择',
				buttonAlign : 'left',
				buttons:[
					new Ext.Button({
						text:'入户方式',
						minWidth:75,
						disabled:true,
						id:'btn6',
						handler:function(){
							if(!rhWindow){
								rhWindow = new Gnt.ux.SelectRh({
									callback:function(optype,data){
										dzData = null;
										rhData = data;
										Ext.getCmp("btn6").setDisabled(false); 
										Ext.getCmp("btn7").setDisabled(true); 
										initDz();
									}
								});
							}
					    	rhWindow.show();
						}
					}),
					new Ext.Button({
						text:'立户方式',
						minWidth:75,
						disabled:true,
						id:'btn7',
						handler:function(){
							if(!bzdzWindow){
								bzdzWindow = new Gnt.ux.SelectBzdz({
									callback:function(optype,data){
										dzData = data;
										rhData = null;
										Ext.getCmp("btn6").setDisabled(true); 
										Ext.getCmp("btn7").setDisabled(false); 
										initDz();
									}
								});
							}
							bzdzWindow.show();
						}
					})
				]
			},{
				region:'center',
		    	title: '',
		    	layout:'border',
		    	items:[
		    	       zqryGrid,
		    	       form10030,
		    	       {
		    	    	   region:'south',
		    	    	   height:250,
		    	    	   layout:'border',
		    	    	   items:[
		    	    	          sqryGrid,form10031
		    	    	   ]
		    	       }
		    	]
			}
        ]
    });

	Ext.Msg.wait("加载迁出人员，请稍后...");
	sqryGrid.loadData({hjywid:hjywid,qcdq:qcdq});
});