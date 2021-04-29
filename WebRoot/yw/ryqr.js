var ywdata = {};
var tabs = null;

Ext.onReady(function(){
	Ext.QuickTips.init();
	
	//首先以AJAX同步的方式获取页面需要的配置，然后从本地进行渲染界面
	if(!Gnt.loadSjpzb("10016,20016,10019,10023,10002",function(){}))
		return;
	
	var qcStore=new Ext.data.JsonStore({
		url:this.url,
        root: 'list',
        id:'rynbid',
        totalProperty:'totalCount',
        fields: ["rynbid","qcdssxq","qcdxz","qrqhb","qrrq","qrlb","qyzbh","zqzbh"]
    });
	
    function initLh(){
		var bzdzWindow = new Gnt.ux.SelectBzdz({
			callback:function(optype,data){
				
			}
		});
		bzdzWindow.show();
	}
    
    function initRh(){
    	var rhWindow = new Gnt.ux.SelectRh({
			callback:function(optype,data){
				
			}
		});
    	rhWindow.show();
    }
    
	function selectDz(){
		ajax({			url: 'yw/kdqqy.do?method=queryHjywById',
			wait_msg:'正在加载业务信息...',
			params:{
				ywid:ywid
			},
			success:function(response, options,  json){ 
				ywdata = json.list[0];
				
				Ext.getCmp("qrcyGrid").loadData();
				
				/*
				//落户标识 0-无落地信息 1-身份证 2-地址
				if(ywdata.lhbs=='1'){
					//迁入入户
					initRh();
				}else{
					//迁入立户
					initLh();
				}
				*/
				initRh();
			}, 
			error: function (json) {
			}
		});
	}
	
	function getSelectRy(){
		var grid = Ext.getCmp("yhcyGrid");
		var rylist = new Array();
		grid.store.each(
			function(rec){
				var len = rylist.length;
				rylist[len] = new Array();
				rylist[len][1] = rec.data.xm;
				rylist[len][0] = rec.data.gmsfhm;
			},	grid
		);
		
		var grid = Ext.getCmp("qrcyGrid");
		grid.store.each(
				function(rec){
					var len = rylist.length;
					rylist[len] = new Array();
					rylist[len][1] = rec.data.xm;
					rylist[len][0] = rec.data.gmsfhm;
				},	grid
		);
		
		return rylist;
	}
	
	//定义分页面板
    var tabs = new Ext.TabPanel({
    	id:'tabs',
    	hidden:true,
        activeTab: 0,
        width:500,
        resizeTabs:false, 
        enableTabScroll:true,
        plain:false,
        listeners:{
        	//在关闭分页的时候，调用函数释放iframe占用资源
        	beforeremove:fixIFrame.createDelegate(this)
        },
        defaults:{
        	autoScroll: true,
        	frame: false,
        	shim: false,
        	xtype: 'panel'
        }
    });
	
    function initTablsQrform(){
    	var panel = tabs.findById("qrInfoPanel");
    	if(!panel){
    		//初始化
    		var qrForm = new Gnt.ux.GntForm({
    			closable: false,
    			id:'qrForm',
    			pzlb: '10023',
    			labelWidth :  120,
    			getDictCust:function(cmb,visiontype){
    				if(visiontype=="JTCY"){
    					return getSelectRy();
    				}
    				return;
    			},
    			changeDictCust:function(cmb,res){
    				return;
    			},
    	        title: ''
    		});
    		
    		var sbrForm = new Gnt.ux.GntForm({
    			closable: false,
    			pzlb: '10002',
    			id:'sbrForm',
    			region : 'south',
    			height: 60,
    			labelWidth :  120,
    			getDictCust:function(cmb,visiontype){
    				if(visiontype=="JTCY"){
    					return getSelectRy();
    				}
    				return;
    			},
    			changeDictCust:function(cmb,res){
    				var f = this.getForm().findField("sbrgmsfhm");
    				if(f){
    					f.setValue(res.data.code);
    				}
    				return;
    			},
    	        title: '申报人员信息'
    		});
    		
    		panel = new Ext.Panel({
	        	//本页不允许关闭
    			id: 'qrInfoPanel',
	        	closable: false,
	            //title: '迁入成员信息',
	        	title: '迁入成员信息',
	            layout:'border',
	            items:[{
	                	 region : 'center',
	                	 layout:'border',
	                	 items:[qrForm,sbrForm] 
	                 },{
	                	 title: '',
	                	 region : 'east',
	                	 width:150,
	                	 html:'<table border=0 width="100%">'
		                		  + '<tr align="center">'
			                		  +'<td><br/>'
			                		  	+'<table border=1>'
			                		  		+'<tr>'
			                		  			+'<td>'
			                		  				+'<img id="img1" src="" height=150 border=1 width=100 />'
			                		  			+'</td>'
			                		  		+'</tr>'
			                		  	+'</table>'
			                		  +'</td>'
		                		  +'</tr>'
		                		  + '<tr align="center"><td><br/><br/><div id="b1"></div></td></tr>'
		                		  + '<tr align="center"><td><div id="b2"></div></td></tr>'
		                		  + '<tr align="center"><td><div id="b3"></div></td></tr>'
		                		  + '<tr align="center"><td><div id="b4"></div></td></tr>'
		                		  + '<tr align="center"><td><div id="b5"></div></td></tr>'
		                		  + '<tr align="center"><td><div id="b6"></div></td></tr>'
		                		  + '<tr align="center"><td><div id="b7"></div></td></tr>'
	                		  + '</table>'
	                 }
	            ]
    		});
    		
    		tabs.setVisible(true);
    		tabs.add(panel);
    		tabs.setActiveTab(panel);
    		//tabs.doLayout();
    		Ext.getCmp("mytabs").doLayout();
    	}else{
    		tabs.setActiveTab(panel);
    	}
    }
    
    var qrcyGrid = new Gnt.ux.HcyGrid({
    	region:'north',
    	id:'qrcyGrid',
    	title: '迁入成员列表',
    	height:200,
    	showPaging:false,
    	listeners:{
    		rowclick:function(g, rowIndex, e){
    			initTablsQrform();
    			
    			var r = g.store.getAt(rowIndex);
    			Ext.getCmp("qrForm").getForm().reset();
    			Ext.getCmp("qrForm").getForm().setValues(r.data);
    		},
    		rowdblclick:function(g, rowIndex, e){
    		}
    	},
    	url:'yw/kdqqy.do?method=queryYdqrdjRyxx',
    	getPostParams:function(){
    		return {
    			hjywid:ywid,
    			pch:ywdata.pch
    		};
    	}
    });
    
    var yhcyGrid = new Gnt.ux.HcyGrid({
    	region:'center',
    	id:'yhcyGrid',
    	title: '户成员列表',
    	url:'yw/kdqqy.do?method=queryRyxx',
    	getPostParams:function(){
    		return {
    			pch:ywdata.pch,
    			hjywid:ywid
    		};
    	}
    });
    
	new Ext.Viewport({
        layout:'border',
        id:'vp',
        items:[{
        	width:250,
        	region:'west',
        	title: '',
        	layout:'border',
        	margins: '0 0 0 0', 
        	bodyStyle:'padding:0px 0px',
        	bodyBorder: false,
            items: [
                qrcyGrid,yhcyGrid
             ]
        },{
            region:'center',
            id:'mytabs',
            //禁止横向滚动条
            layout:'fit',
            border:false,
            frame:false,
           	bodyStyle:'overflow:scroll;overflow-x:hidden',
            margins:'0',
            autoScroll:true,
            items:tabs
        }]
    });
	
	//字典加载
	Gnt.ux.Dict.loadDict(['CS_HLX','CS_JTGX','CS_HB','CS_JTGX'],function(){
		selectDz();
	});
});