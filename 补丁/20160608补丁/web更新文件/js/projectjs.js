	//项目和角色公共类
	var _yhdlm = null;
	var _dwdm = null;
	var _yhid = null;
	var _initload = false;
	var _method = "";
	
	//打开对指定用户的授权窗口
	function _openSQ(yhid, yhdlm,dwdm,method){
		if(!yhdlm || !yhid || !dwdm){
			return;
		}

		if(!method || method=="queryProjectJSTree"){
			_method = "queryProjectJSTree";
			_ProjectJSWin.setTitle('对用户[' + yhdlm + ']进行授权');
		}else{
			_method = method;
			_ProjectJSWin.setTitle('对用户[' + yhdlm + ']进行可分配授权');
		}
		
		_ProjectJSTreeLoader.dataUrl = 'sq.do?method='  + _method;
		_yhdlm = yhdlm;
		_dwdm = dwdm;
		_yhid = yhid;
		
		_ProjectJSWin.show();
		
		_ProjectJSTreeLoaderRoot.reload();
	}

	var _ProjectJSTreeLoader = new Ext.tree.TreeLoader({
		dataUrl		: 'sq.do',
		listeners	:{
			loadexception:function(tree,node,response){
				Ext.Msg.alert("加载失败",response.responseText);
			}
		}
	});

	_ProjectJSTreeLoader.on("beforeload", function(treeLoader, node) {
			//在beforeload事件中每次动态传递点击的节点的value属性作为参数
	       		this.baseParams = {yhid:_yhid, yhdlm:_yhdlm,dwdm:_dwdm};
		}, 
		_ProjectJSTreeLoader
	);

	_ProjectJSTreeLoader.on("load", function(treeLoader, node, response) {
			_initload = true;
			
			var o = Ext.decode(response.responseText);
			if(o.messages && o.messages.length>0){
				Ext.Msg.alert("提示",o.messages[0]);
			}
		}, 
		_ProjectJSTreeLoader
	);
	
	var _ProjectJSTreeLoaderRoot = new Ext.tree.AsyncTreeNode({
		text:'根'
	});
	
	var __ProjectJSTree = new Ext.tree.TreePanel({
	   	autoScroll:true,
	   	root			:_ProjectJSTreeLoaderRoot,
	   	rootVisible 	:false,
	   	region          :'west',
	   	loader			:_ProjectJSTreeLoader,
	   	width			:300,
	   	height			:400,
	   	listeners:{
    		//'dblclick':function(node,e){
    		//	if(node.getUI().Checkbox){
    		//		node.getUI().checkbox.checked=!node.getUI().checkbox.checked;
    		//	}
    		//}
    		'checkchange':function(o,c){
    			if(o.disabled){
    				o.getUI().checkbox.checked=!(o.getUI().checkbox.checked);
    			}
    		} 
    	}

	});
	
	var _ProjectJSWin = new Ext.Window({
		title:'人员授权',
		closeAction:'hide',
		modal:true,
		width:400,
		height:400,
		margins:'5',
		layout:'fit',
		items:__ProjectJSTree,
		listeners:{
			show:function(){
				
			}
		},
		buttons:[
			new Ext.Button({
				text:'保存授权',
				minWidth:75,
				handler:function(){
					//授权
					var data = "";
					
					var root = _ProjectJSTreeLoaderRoot;
					for(i=0;i<root.childNodes.length;i++){
						var xmmc = root.childNodes[i].text;
						var xmbm = root.childNodes[i].attributes.code.code;
						var jslist = "";
						
						var child = root.childNodes[i].childNodes;
						if(child && child.length>0){
							for(j=0;j<child.length;j++){
								if(child[j].getUI().isChecked()){
									var js = child[j].attributes.js;
									if(jslist=="")
										jslist = js.jsid;
									else
										jslist += "," + js.jsid;
								}
							}
						}
						
						if(data=="")
							data = xmbm + ":" + jslist;
						else
							data += "\n\r" + xmbm + ":" + jslist;
					}
					
					//用户数据，提交到后台保存
					Ext.Msg.wait("操作正在执行中，请稍后...", "等待");
					
					Ext.Ajax.request({
						url:'sq.do?method=saveZzjyJs',
						method:'POST', 
						params:{grant:data, yhid:_yhid, dwdm:_dwdm, optype:_method},
						success:function(result,request){ 
							Ext.Msg.hide();
							var jsonData = Ext.util.JSON.decode(result.responseText);
							if(jsonData.success){
								if(jsonData.messages && jsonData.messages.length>0){
									Ext.Msg.alert("提示",jsonData.messages[0]);
								}else{
									Ext.Msg.alert("提示","操作执行成功！");
								}
								//if(after_userjs){
								//	after_userjs();
								//}
							}else{
								if(jsonData.messages && jsonData.messages.length>0){
									showError(jsonData.messages[0]);
								}else{
									showError("操作执行失败！");
								}
							}
						}, 
						failure: function ( result, request) {
							Ext.Msg.hide();
							showError(result.responseText); 
						} 
					}); 
				}
			}),
			new Ext.Button({
				text:'关闭',
				minWidth:75,
				handler:function(){
					_ProjectJSWin.hide();
				}
			})
		]
	});
	