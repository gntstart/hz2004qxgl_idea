var rhWindow = null;
var rhData = null;
var dzData = null;
var bzdzWindow = null;
var initJsonData = null;

Ext.onReady(function(){
	//10030 迁入审批信息
	//10031 迁入审批子信息
	Gnt.ux.Dict.loadDict(['CS_HLX','CS_XB','CS_JTGX','CS_MZ','CS_HYZK','CS_XX','CS_NYZYRKLHCZYY','CS_HJSPCL'],function(){

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
		width:200,
		title:'主迁人',
		pk:"ryid",
		showPaging:false,
		pzlb:'10030'
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
        		//查询异地迁入
        		Ext.getCmp("btn1").setDisabled(false); 
        		Ext.getCmp("btn2").setDisabled(false); 
        		Ext.getCmp("btn3").setDisabled(false); 
        		Ext.getCmp("btn4").setDisabled(false); 
        		Ext.getCmp("btn5").setDisabled(false); 
        		Ext.getCmp("btn6").setDisabled(false); 
        		Ext.getCmp("btn7").setDisabled(false); 
        		
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
        			var pk = "1";
        			var zqrData = res[0].data;
        			zqrData.hb = res[0].data.hkxz;
        			zqrData.zzssxq = initJsonData.list[0].ssxq;
        			//showInfo(Ext.encode(initJsonData));
        			var r = new zqryGrid.store.reader.recordType(zqrData, "1");
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
				text:'设为主迁人',
				minWidth:75,
				id:'btn5',
				disabled:true,
				handler:function(){
					if(sqryGrid.store.getCount()<=0){
						showErr("没有随迁入！");
						return;
					}
					
					var res = sqryGrid.getSelectionModel().getSelected();
					if(!res){
						showErr("请先选择随迁人员！");
						return;
					}
					
				}
			}),
			new Ext.Button({
				text:'保存',
				minWidth:75,
				id:'btn4',
				disabled:true,
				handler:function(){
					bggzWin.hide();
				}
			}),
			new Ext.Button({
				text:'关闭',
				minWidth:75,
				handler:function(){
					//关闭当前窗口
					if(parent.closeActiveWorkSpace)
						parent.closeActiveWorkSpace();
				}
			})
		]
	});
	
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
										
										if(zqryGrid.store.getCount()<=0){
											showErr("没有主迁人");
											return;
										}
										
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
										res.set("qrdhlx",data.hlx);
										res.set("qrdxzjd",data.xzjddm);
										res.set("qrdqx",data.xzjddm.substring(0,6));
										res.set("qrdpcs",data.dwdm);
										res.set("qrdjlx",data.jlx);
										res.set("qrdmlph",data.mlph);
										res.set("qrdz",data.mlxz);
										res.set("qrdjwh",data.jcwh);
										
										form10030.getForm().loadRecord(res);
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