var selRes = null;

Ext.onReady(function(){
	Ext.QuickTips.init();
	
	if(formdq==""){
		showErr("数据错误，没有迁出地区！");
		return;
	}
	if(todq==""){
		showErr("数据错误，没有迁入地区！");
		return;
	}
	if(spywid==""){
		showErr("数据错误，没有迁入审批业务ID！");
		return;
	}
	
	//首先以AJAX同步的方式获取页面需要的配置，然后从本地进行渲染界面
	if(!Gnt.loadSjpzb("10019,10002,10024",function(){}))
		return;
	
	/**
	 * 户成员，跨地市查询
	 */
	var hcyGrid = new Gnt.ux.CzrkGrid({
		region:'west',
    	title: '户成员列表',
    	width:250,
    	showPaging:false,
    	url:'yw/kdqqy.do?method=queryKDQCzrkjbxx',
    	cm: new Ext.grid.ColumnModel([
    	       new Ext.grid.CheckboxSelectionModel(),
    	       new Ext.grid.RowNumberer(),
    	       {
			    header: "姓名",
			    dataIndex: "xm",	
			    sortable: true,
			    width: 80,
			    renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			    	if(record.data.qcflag=="1"){
			    		cellmeta.css='changeplus';
                	}
                    return value;
				 }
			 },{
			     header: "与户主关系",
			     dataIndex: "yhzgx",	
			     sortable: true,
			     width: 120,
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					if(record.data.qcflag=="1"){
			    		cellmeta.css='changeplus';
                	}
					return Gnt.ux.Dict.getDictLable('CS_JTGX', value);
				}
			},{
			     header: "性别",
			     dataIndex: "xb",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			    	 	if(record.data.qcflag=="1"){
				    		cellmeta.css='changeplus';
	                	}
						return Gnt.ux.Dict.getDictLable('CS_XB', value);
				 }
			 },{
				    header: "公民身份号码",
				    dataIndex: "gmsfhm",	
				    sortable: true,
				    width: 100,
				    renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			    	 	if(record.data.qcflag=="1"){
				    		cellmeta.css='changeplus';
	                	}
						return value;
				 }
			 },{
			     header: "民族",
			     dataIndex: "mz",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			    	 	if(record.data.qcflag=="1"){
				    		cellmeta.css='changeplus';
	                	}
						return Gnt.ux.Dict.getDictLable('CS_MZ', value);
				 }
			 },{
			     header: "婚姻状况",
			     dataIndex: "hyzk",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			    	 	if(record.data.qcflag=="1"){
				    		cellmeta.css='changeplus';
	                	}
			    	 
						return Gnt.ux.Dict.getDictLable('CS_HYZK', value);
				 }
			 },{
			     header: "血型",
			     dataIndex: "xx",	
			     sortable: true,
			     width: 60,
			     renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			    	 	if(record.data.qcflag=="1"){
				    		cellmeta.css='changeplus';
	                	}
			    	 
						return Gnt.ux.Dict.getDictLable('CS_XX', value);
				 }
			 },{
				    header: "联系电话",
				    dataIndex: "dhhm",	
				    sortable: true,
				    width: 80,
				    renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			    	 	if(record.data.qcflag=="1"){
				    		cellmeta.css='changeplus';
	                	}
			    	 
						return value;
				    }
			 }
		 ]),
		 view: new Ext.grid.GridView({
				forceFit:false,
				autoFill:false,
				enableRowBody:true
		 }),
    	listeners:{
    		rowclick:function(g, rowIndex, e){
    			selRes = g.store.getAt(rowIndex);
    			
    			form10019.getForm().reset();
    			form10019.getForm().loadRecord(selRes);
    			
    			form10024.getForm().reset();
    			if(selRes.data.qcflag=="1"){
    				//为迁出登记form赋值
    				form10024.setVisible(true);
    				var pkvalue = selRes.data[form10024.bindStore.pkname];
    				var re = form10024.bindStore.getById(pkvalue);
    				if(re){
    					form10024.getForm().loadRecord(re);
    				}else{
    					alert("警告：迁出登记信息" + pkvalue + "不存在！");
    				}
    			}else{
    				form10024.setVisible(false);
    			}
    		},
    		rowdblclick:function(g, rowIndex, e){

    		}
    	}
    });

	var form10019 = new Gnt.ux.GntForm({
		closable: false,
		region:'north',
		height:330,
		id:'form10019',
		pzlb: '10019',
		labelWidth :  120,
		bindStore:hcyGrid.store,
		bindViewGrid:hcyGrid,
		getDictCust:function(cmb,visiontype){
			if(visiontype=="JTCY"){
				return getSelectRy();
			}
			return;
		},
		changeDictCust:function(cmb,res){
			if(cmb.name=="fqxm"){
				this.getForm().setValues({fqgmsfhm:res.data.data});
				selRes.set("fqgmsfhm",res.data.data);
			}
			if(cmb.name=="mqxm"){
				this.getForm().setValues({mqgmsfhm:res.data.data});
				selRes.set("mqgmsfhm",res.data.data);
			}
			if(cmb.name=="jhryxm"){
				this.getForm().setValues({jhrygmsfhm:res.data.data});
				selRes.set("jhrygmsfhm",res.data.data);
			}
			if(cmb.name=="jhrexm"){
				this.getForm().setValues({jhregmsfhm:res.data.data});
				selRes.set("jhregmsfhm",res.data.data);
			}
			if(cmb.name=="poxm"){
				this.getForm().setValues({pogmsfhm:res.data.data});
				selRes.set("pogmsfhm",res.data.data);
			}
			
			return;
		},
        title: '户成员信息'
	});
	
	var form10002 = new Gnt.ux.GntForm({
		closable: false,
		region:'north',
		height:60,
		id:'form10002',
		pzlb: '10002',
		labelWidth :  120,
		getDictCust:function(cmb,visiontype){
			if(visiontype=="JTCY"){
				return getSelectRy();
			}
			return;
		},
		changeDictCust:function(cmb,res){
			this.getForm().setValues({sbrgmsfhm:res.data.data});
			return;
		},
        title: '申报人信息'
	});
	
	//迁出登记store
	var qcdjStore = new Gnt.store.SjpzStore({
		pzlb:'10024',
		pkname:'rynbid'
	});
	
	var form10024 = new Gnt.ux.GntForm({
		closable: false,
		region:'center',
		height:60,
		id:'form10024',
		pzlb: '10024',
		labelWidth :  120,
		//绑定到store，输入域改动的时候，自动赋值
		bindStore:qcdjStore,
		bindViewGrid:hcyGrid,
		getDictCust:function(cmb,visiontype){
			if(visiontype=="JTCY"){
				return getSelectRy();
			}
			return;
		},
		changeDictCust:function(cmb,res){
			return;
		},
        title: '迁出登记信息'
	});
	
	new Ext.Viewport({
        layout:'border',
        id:'vp',
        items:[hcyGrid,{
            region:'center',
            //禁止横向滚动条
            layout:'border',
            border:false,
            frame:false,
            items:[form10019,{
            	 layout:'border',
            	 region:'center',
                 border:false,
                 frame:false,
                 items:[form10002,form10024]
            }]
        },{
        	 region:'east',
        	 width:100,
      	   	html:'<table border=0 width=100% height=100%><tr><td style="text-align:center;padding:10px">' +
      	   		'<span id="b1"></span><br/>' +
      	   		'<span id="b2"></span>' +
      	   		'<span id="b3"></span>' +
      	   		'<span id="b4"></span>' +
		   		'</td></tr></table>'
        }]
    });
	
	/**
	 * 人员选择方法
	 */
	function getSelectRy(){
		var rylist = new Array();
		hcyGrid.store.each(
			function(rec){
				var len = rylist.length;
				rylist[len] = new Array();
				rylist[len][0] = rec.data.xm;
				rylist[len][1] = rec.data.xm;
				rylist[len][2] = rec.data.gmsfhm;
			},	hcyGrid
		);

		return rylist;
	}
	
	new Ext.Button({
			renderTo:'b1',
			text:'确定迁出',
			minWidth:75,
			handler:function(){
				if(!form10019.checkInput())
					return;
				
				if(!form10024.checkInput())
					return;
				
				if(!form10002.getForm().isValid()){
					showErr("申报人信息必须填写！");
					return;
				}
			
				//判断非迁出户必须存在户主
				var exists = false;
				var icount = 0;
				for(var index=0;index<res.length;index++){
					var data = res[index].data;
					if(data.qcflag=="1"){
						
					}else{
						icount++;
						//if(data.yhzgx)
						if(data.yhzgx=="01" || data.yhzgx=="02" || data.yhzgx=="03")
							exists = true;
					}
				}
				if(!exists && icount>0){
					showErr("非迁出成员没有户主！");
					return;
				}
				
				var rs = hcyGrid.store.getModifiedRecords();
				var store = bggzGrid.store;
				store.removeAll();
				
				if(rs!=null){
						str = "";
						for(var i=0;i<rs.length;i++){
							var obj = rs[i].getChanges();
							//str += "记录ID:" + rs[i].id + ":<BR>";
							//"tmpid", "rynbid","xm","bggzxm_mc","bggzxm", "bggzqnr","bggzhnr","bggzlb"
							for(f in obj){
								var data = {
										rynbid: rs[i].data.rynbid,
										xm: rs[i].data.xm,
										bggzxm:f,
										bggzxm_mc:form10019.getFieldLabel(f),
										bggzqnr: rs[i].modified[f],
										bggzhnr:obj[f],
										bggzlb:'91'
									};
								var r = new store.reader.recordType(data);
								store.add([r]);
							}
						}
						if(store.getCount()>0){
							bggzWin.show();
						}else{
							submitData();
						}
						
						return;
				}
			}
	});
		
	new Ext.Button({
			renderTo:'b2',
			text:'关闭',
			minWidth:75,
			handler:function(){
				//关闭当前窗口
				if(parent.closeActiveWorkSpace)
					parent.closeActiveWorkSpace();
			}
	});
	
	var bggzGrid = new Gnt.ux.BggzGrid({title:''});
	var bggzWin = new Ext.Window({
		title:'确认变更更正项目',
		closeAction:'hide',
		modal:true,
		width:600,
		height:300,
		margins:'5',
		layout:'fit',
		items:bggzGrid,
		buttons:[
					new Ext.Button({
							text:'确定',
							minWidth:75,
							handler:function(){
								submitData();
							}
					}),
					new Ext.Button({
						text:'取消',
						minWidth:75,
						handler:function(){
							bggzWin.hide();
						}
				})
			]
	});

	//提交数据
	function submitData(){
		var subdata = {
				spywid: spywid,
				todq: todq,
				formdq: getQueryParam("formdq"),
				bggzxx:new Array(),
				sbjbxx:{},
				ryList:new Array(),
				qczxxx:new Array()
		};
		
		//人员内部id和上笔户籍业务的关系
		var map = {};
		hcyGrid.store.each(
				function(rec){
					map[rec.data.rynbid] = rec.data.cjhjywid;
				},	hcyGrid
		);
		
		//变更更正信息
		var bggzmap = {};
		var store = bggzGrid.store;
		if(store.getCount()>0){
			for(var index=0;index<store.getCount();index++){
				var bggzdata = store.getAt(index).data;
				bggzdata.sbhjywid = map[bggzdata.rynbid];
				
				if(!bggzmap[bggzdata.rynbid]){
					bggzmap[bggzdata.rynbid] = {
							rynbid: bggzdata.rynbid,
							sbhjywid: bggzdata.sbhjywid,
							bggzxxList:new Array()
					}
				}
				bggzmap[bggzdata.rynbid].bggzxxList.push(bggzdata);
			}
			
			for(rynbid in bggzmap){
				subdata.bggzxx.push(bggzmap[rynbid]);
			}
		}
		
		//申报人信息
		subdata.sbjbxx = form10002.getForm().getValues();
		
		//迁出注销信息
		for(var index=0;index<qcdjStore.getCount();index++){
			var data = qcdjStore.getAt(index).data;
			data.sbhjywid = map[data.rynbid];
			
			subdata.qczxxx.push(data);
		}
		
		subdata.sbjbxx = Ext.encode(subdata.sbjbxx);
		subdata.bggzxx = Ext.encode(subdata.bggzxx);
		subdata.qczxxx = Ext.encode(subdata.qczxxx);
		
		Gnt.submit(
			subdata, 
			"yw/kdqqy.do?method=saveKdsQc", 
			"正在处理迁出信息，请稍后...", 
			function(jsonData,params){
				showInfo("跨地市迁出成功！",function(){
					//关闭当前窗口
					if(parent.closeActiveWorkSpace)
						parent.closeActiveWorkSpace(jsonData);
				});
			}
		);
	}
	
	//初始化迁出登记store
	var newres = new Array();
	var res = [];
	Ext.Msg.wait("正在加载数据...", "请稍后");
	hcyGrid.loadData({
		formdq:formdq,
		todq:todq,
		spywid:spywid
	},function(st, r){
		Ext.Msg.hide();
		res = r;
		
		for(var index=0;index<res.length;index++){
			var data = res[index].data;
			if(data.qcflag=="1"){
				var pk = data[qcdjStore.pkname];
				var r = new qcdjStore.reader.recordType({}, pk);
				r.set(qcdjStore.pkname, pk);
				//"kdqqy_zqz","kdqqy_qrdz","kdqqy_qyldyy","kdqqy_qczxlb"
				r.set("zqzbh",data.kdqqy_zqz);
				r.set("qwdxz",data.kdqqy_qrdz);
				r.set("qwdssxq",data.kdqqy_qrdqh);
				r.set("qyldyy",data.kdqqy_qyldyy);
				r.set("qclb",data.kdqqy_qczxlb);
				//r.set("qcrq",new Date());
				
				newres.push(r);
			}
		}
		if(newres.length>0)
			qcdjStore.add(newres);
		
		(function(){
			hcyGrid.fireEvent("rowclick",hcyGrid,0);
			hcyGrid.getSelectionModel().selectRange(0,0);
		}).defer(200);
	},function(st, err){
		
	});
});