//利用IFRAME填充容器
Ext.ux.IFrameComponent = Ext.extend(Ext.BoxComponent, {
	onRender:function(ct, position){
		Ext.getCmp("word-status").showBusy('正在加载功能页面[' + this.title + ']，请等待...');
		//注意：页面文件必须遵循本书规范，否则就可能发生页面不能打开的错误
		var id = 'iframe-'+ this.id;
        this.el = ct.createChild({
        	tag: 'iframe', 
        	id: id, 
        	frameBorder: 0, 
        	src:this.url
        });
        Ext.fly(id).on("load",function(){
        	(function(){
				Ext.getCmp("word-status").clearStatus({useDefaults:true,anim:true});
        	}).defer(500);
        })
    }
});

//打开指定工作区
function openWorkSpace(url,name,key,desc,parm){
	if(url.indexOf("FunctionBm")==0){
		var FunctionBm = url.split("\t")[1];
		
		//本地字典重载			
		if(FunctionBm=="QXGLZDCZ"){
			Ext.Msg.wait("正在重载字典，请稍后...", "等待");	
			Ext.Ajax.request({
				url:'util/dict?method=reLoadAllData',
				method:'POST', 
				success:function(request,action){ 
					Ext.Msg.hide();
					var f = Ext.decode(request.responseText);
					if(f && f.success){
						Ext.Msg.alert("提示",f.message);
					}else{
		    			Ext.Msg.alert("提示","操作执行成功");
		    		}
				}, 
				failure: function ( result, request) {
					Ext.Msg.hide();
					Ext.Msg.alert("错误",result.responseText); 
				}
			});
		}else if(FunctionBm=="QXGLJCCODECZ"){
			//JCCODE重载
			if(jccode!="")
				window.open(jccode);
			else
				Ext.Msg.alert("提示","请通过jccodeAppURL配置JCCODE的重载地址");
		}else if(FunctionBm=="QXGLXTBASJCZ"){
			//XTBA缓存重载
			Ext.Msg.wait("正在XTBA字典，请稍后...", "等待");	
			Ext.Ajax.request({
				url:'util/dict?method=reLoadXtbaData',
				method:'POST', 
				success:function(request,action){ 
					Ext.Msg.hide();
					var f = Ext.decode(request.responseText);
					Ext.Msg.alert("提示",f.message);
				}, 
				failure: function ( result, request) {
					Ext.Msg.hide();
					Ext.Msg.alert("错误",result.responseText); 
				}
			});
		}
		
		return;
	}
	
	var tabs = Ext.getCmp("tabs");
	//alert(key);
	
	//如果文件已经打开，那么设置为活动分页，并返回
   	if(!tabs.findById(key)){
	   	 var p = null;
	   	 //利用iframe显示页面
	   	 p = new Ext.ux.IFrameComponent({
	   	 		xtype:'panel',
	   	 		id:key,
	   	 		url:url,
	   	 		frame:false,
	   	 		iconCls:'otherfile',
		   		title: name,
			    tabTip: desc?desc:name
		});
	   	//添加分页，并且设置为活动分页
	    tabs.add(p);
   	}else{
   		var id = 'iframe-'+ key;
   		var el = Ext.get(id);
   	}
   	
    //推荐使用key，而不是使用p来激活页面，否则很可能发生脚本错误
    tabs.setActiveTab(key);
}

Ext.onReady(function(){
	Ext.QuickTips.init();
	
	//释放iframe占用资源
	function fixIFrame(o, p){
		var iFrame = p.getEl().dom; 
		if (iFrame.src) {
			iFrame.src = "javascript:false"; 
		}
	}

	//定义TabPanel的控制菜单
	Ext.ux.TabCloseMenu = function(){
	    var menu, ctxItem;
	    this.init = function(tabs){
	        tabs.on('contextmenu', onContextMenu);
	    }
	    function onContextMenu(tabs, item, e){
	        if(!menu){
	            menu = new Ext.menu.Menu([{
	                id: tabs.id + '-close',
	                text: '关闭当前页',
	                handler : function(){
	                    tabs.remove(ctxItem);
	                }
	            },{
	                id: tabs.id + '-close-others',
	                text: '关闭其它页',
	                handler : function(){
	                    tabs.items.each(function(item){
	                    	if(item.closable && item != ctxItem){
	                            tabs.remove(item);
	                        }
	                    });
	                }
	            }]);
	        }
	        ctxItem = item;
	        var items = menu.items;
	        
	        //设置【关闭当前页】菜单是否有效和当前页的closable属性一致
	        items.get(tabs.id + '-close').setDisabled(!item.closable);
	        
	        var disableOthers = true; 
	       	//遍历分页面板所有分页，查看除了自己，是否还有能够关闭的分页
	        tabs.items.each(function(){
	            if(this != item && this.closable){
	                disableOthers = false;
	                return false;
	            }
	        });
	        
	        //设置【关闭其它页】菜单是否有效
	        items.get(tabs.id + '-close-others').setDisabled(disableOthers);
	        
	        //在鼠标右击处显示菜单
	        menu.showAt(e.getPoint());
	    }
	};
	
	//定义分页面板
    var tabs = new Ext.TabPanel({
    	id:'tabs',
        activeTab: 0,
        width:500,
        height:250,
        resizeTabs:false, 
        enableTabScroll:true,
        plain:false,
        listeners:{
        	//在关闭分页的时候，调用函数释放iframe占用资源
        	beforeremove:fixIFrame.createDelegate(this)
        },
        plugins: new Ext.ux.TabCloseMenu(),
        defaults:{
        	closable:true,
        	autoScroll: false,
        	frame: false,
        	shim: false,
        	xtype: 'panel'
        },
        items:[{
        	//本页不允许关闭
        	closable: false,
            title: '欢迎使用',
            tabTip:'欢迎使用',
            html: '<font style="font-size:9pt"></font>'
        }]
    });
  
	var wordCount = new Ext.Toolbar.TextItem('登陆人：' + user.glyxm);
    var charCount = new Ext.Toolbar.TextItem('登陆时间: '+ user.dlsj);
    var clock = new Ext.Toolbar.TextItem('');

	new Ext.Viewport({
        layout:'border',
        id:'vp',
        items:[{
        	 region:'north',
        	 height:30,
        	 margins:'0px',
           	 cmargins:'0px',
           	 bodyStyle:'padding:0px',
        	 frame:false,
        	 border:false,
        	 layout:'fit',
        	// title:'<table border=0 with="100%""><TR with="100%"><TD with="100%"><img src="images/top-left.gif" height=80></img></td></tr></table>',
        	 iconCls:'icon-home',
        	 items:[new Ext.Toolbar({
        	 	frame:false,
        	 	 border:false,
        	 	items:funcs
        	 })]
        },{
            region:'center',
            id:'portal_home',
            //禁止横向滚动条
            layout:'fit',
            border:false,
            frame:false,
           	bodyStyle:'overflow:scroll;overflow-x:hidden',
            margins:'0',
            autoScroll:true,
            items:[tabs]
        }, new Ext.StatusBar({
            id: 'word-status',
            region:'south',
            defaultText:'就绪',
            items: [wordCount, ' ', charCount, ' ', clock, ' ']
        })]
    });
    
	Ext.fly(wordCount.getEl().parentNode).addClass('x-status-text-panel').createChild({cls:'spacer'});
	Ext.fly(charCount.getEl().parentNode).addClass('x-status-text-panel').createChild({cls:'spacer'});
	Ext.fly(clock.getEl().parentNode).addClass('x-status-text-panel').createChild({cls:'spacer'});
	
	Ext.TaskMgr.start({
		run: function(){
			Ext.fly(clock.getEl()).update(new Date().format('当前时间：g:i:s A'));
		},
		interval: 1000
	});
	
	var mxfs = new Ext.form.FormPanel({
		id:'formmx',
    	title:'',
    	anchor:'100% 100%',
    	buttonAlign:'center',
    	labelAlign:'right',
    	frame:true,
    	height:'100%',
    	fileUpload: true, 
    	border:true,
        layout:'form',
       	items:[{
        		layout:'column',
    			frame:false,
    			labelWidth:100,
    			border:false,
        		defaults:{
        			border:false,
        			frame:false
        		},
            	items:[{
					layout: 'form',
		            columnWidth: 1,
		            defaultType: 'textfield',
					bodyStyle:'width:100%',	             
		            items: [ {
		                name: 'oldpwd',
						anchor:'90%',
						inputType:'password',
						allowBlank: false,
		                xtype: 'textfield',
		                fieldLabel: '<font color=red>*</font>原密码'                
		            }]
				},{
					layout: 'form',
		            columnWidth: 1,
		            defaultType: 'textfield',
					bodyStyle:'width:100%',	             
		            items: [ {
		                name: 'pwd1',
						anchor:'90%',
						allowBlank: false,
						inputType:'password',
		                xtype: 'textfield',
		                fieldLabel: '<font color=red>*</font>新密码'                
		            }]
				},{
					layout: 'form',
		            columnWidth: 1,
		            defaultType: 'textfield',
					bodyStyle:'width:100%',	             
		            items: [ {
		                name: 'pwd2',
						anchor:'90%',
						inputType:'password',
						allowBlank: false,
		                xtype: 'textfield',
		                fieldLabel: '<font color=red>*</font>重复输入密码'                
		            }]
				}
			]
		}],
		buttons:[{
				text:'修改密码',
				handler:function(){
	            	if(!mxfs.getForm().isValid()){
						return;
					}
					
					var data = mxfs.getForm().getValues();
					if(data.pwd1!=data.pwd2){
						Ext.Msg.alert("提示","两次输入的密码不一致，请确认");
						return;
					}
					
					save(data);
				}
			},{
				text:'取消',
				handler:function(){
					cfWin.hide();
				}
			}
		]
	});
	
	var mask = new Ext.LoadMask(Ext.getBody(), {msg:"操作正在执行中，请等待..."});
	
	function save(param){
		mask.show();
		Ext.Ajax.request({
			url:'login.do?method=changePwd',
			method:'POST', 
			params:param,
			success:function(result,request){ 
				mask.hide();
				var jsonData = Ext.util.JSON.decode(result.responseText);
				if(jsonData.messages && jsonData.messages.length>0)
					Ext.Msg.alert("提示",jsonData.messages[0]);
			}, 
			failure: function ( result, request) {
				mask.hide();
				Ext.MessageBox.alert('发生意外错误',result.responseText); 
			} 
		}); 
	}
	
	cfWin = new Ext.Window({
		title:'修改个人密码',
		closeAction:'hide',
		modal:true,
		width:350,
		height:170,
		layout:'fit',
		items:mxfs,
		listeners:{
			show:function(){
				mxfs.getForm().reset();
			}
		}
	});
});
