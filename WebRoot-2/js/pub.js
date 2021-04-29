/*
	VisionType	必须，字典类型，特殊字典有：RY 人员，DW 单位，CCM 单位层次码
	RootCode	可选，更节点名称，默认使用VisionType的值
	vid			可选，字典选择值的赋值目标组件ID，默认使用组件ID
	tid			可选，字典选择文本的赋值目标组件ID，event=ajax必须
	def			可选，组件缺省值，多个使用逗号分隔
	exclude		可选，排除值，多个逗号分隔
	ignore		可选，下拉列表是否包含忽略项，true|false
	mselect		可选，是否允许多选，true|false
	eevent		可选，选择项发生的事件名称，当字典选择完成时触发该事件，function(dict,values)
	event		可选，字典类型：openwindow	普通弹出字典，ajax	普通搜索字典
	sp			可选，字典名字空间
*/
var _rootArray = new Array();
var _treeArray = new Array();
var _winArray = new Array();
var _q = Ext.DomQuery;
var _map = new Ext.util.MixedCollection();
//重要：存放store的数组，以达到共用store的目的
var _storeArray = new Array();
var _smap = null;
var _curTree = null;
var _mask = new Ext.LoadMask(Ext.getBody(), {msg:"正在加载字典，请稍候..."});
var _sp = "";						//名字空间，默认没有：表示系统名字空间
var _grid_store = new Array();
var _grid_span_count = 0;
var _grid_count = 0;
var ignoreLabel = "　";

//非常重要：存放AJAX方式的最终选择值
var _ajaxDefCodeList = new Array();
var _ajaxSelectOld = null;

/**AJAX通用选择窗口*/
var _searchStore = new Ext.data.JsonStore({
        url: 'util/dict?method=searchCode',
        root: 'list',
        id:'code',
        totalProperty:'totalCount',
        fields: [
        	{name:'code'},
        	{name:'name'}
        ],
        listeners:{
        	load:function(m,res,options){
        		_enableSearch();
        		//如果是查询
        		if(options && options.params){
	        		valueList = _ajaxDefCodeList[_smap.vid];
					if(valueList && valueList.length && valueList.length>0){
						for(var i=0;i<valueList.length;i++){
							var r = new m.reader.recordType(valueList[i],valueList[i].code);
							m.insert(0,[r]);
						}
					}
					if(_ajaxSelectOld && _ajaxSelectOld.length && _ajaxSelectOld.length>0){
							(function(){
								for(var i=0;i<_ajaxSelectOld.length;i++){
									_searchCsm.selectRecords([m.getById(_ajaxSelectOld[i].data.code)],true);
									Ext.getCmp("_serachText").focus(true);
								}
							}).defer(100);
					}
				}
        	},
			loadexception:function(mystore,options,response,error){
				_enableSearch();
				if(error){
					var json = Ext.decode(response.responseText);
					Ext.Msg.alert("提示",json.messages[0]);
				}else{
					Ext.Msg.alert("提示",response.responseText);
				}
			}
        }
});

function _bindAjaxSelectCode(){
	_smap = Ext.urlDecode(this.dict);
	//默认名字空间
	if(!_smap.sp) _smap.sp = _sp;
	if(_smap.ronly){
		this.disabled = _smap.ronly;
		return;
	}
	
	if(!_smap.tid || !_smap.vid){
		alert("AJAX弹出模式，必须提供vid,tid参数！");
		return;
	}
	
	//删除原来所有值
	_searchStore.removeAll();
	
	//控制单选和多选
	if(_smap.mselect && _smap.mselect=="true"){
		_searchCsm.singleSelect = false;
	}else{
		_searchCsm.singleSelect = true;
	}
	
	//读取默认值
	var valueList = new Array();
	if(_ajaxDefCodeList[_smap.vid]){
		valueList = _ajaxDefCodeList[_smap.vid];
		if(valueList && valueList.length && valueList.length>0){
			var data = new Object();
			data.list = valueList;
			data.totalCount = 50;
			data.success = true;
			_searchStore.loadData(data);
		}
	}

	Ext.getCmp("_serachText").setValue("");
	_ajax_codeSelectWindow.show(Ext.body,function(){
		(function(){
		    _searchCsm.selectAll();
		    _searchAjax();
		}).defer(100);
	});
	_ajax_codeSelectWindow.el.center();
}

var _searchCsm = new Ext.grid.CheckboxSelectionModel({
	singleSelect:false,
	listeners:{
		beforerowselect:function(sm,index,r){
			if(_smap.mselect && _smap.mselect=="true"){
				;
			}else{
				;//
				//sm.selectRow(index,false);
			}
		}
	}
});
var _searchColModel = new Ext.grid.ColumnModel([
		_searchCsm,
		{
	        header: "字典编码",
	        dataIndex: "code",	
	        sortable: true,
			width: "40%"
	    },{
	        header: "中文名称",
	        dataIndex: "name",
	        sortable: true,
			width: "40%"
	    }
]);
var _searchGrid = new Ext.grid.GridPanel({
        store: _searchStore,
        region: 'center',
        view:new Ext.grid.GridView({
				forceFit:true,
				autoFill:true,
				enableRowBody:true
		}),
		stripeRows: true,
		id:'searchGrid',
        cm: _searchColModel,
        sm:_searchCsm,
		loadMask: {msg:'正在加载数据，请稍侯……'},
		bodyStyle:'width:100%',
        border:true,
        anchor:'100% 100%',
	    margins: '0 0 0 0',
		cmargins: '0 0 0 0',        
        frame:false,
		listeners:{
			rowclick:function(g, rowIndex, e){
				
			}
		},
        title:''
});
var _searchfs = new Ext.form.FormPanel({
	id:'_searchfs',
    title:'',
    height:40,
    region: 'north',
    anchor:'100% 100%',
    buttonAlign:'right',
    labelAlign:'right',
    frame:true,
    border:false,
    layout:'form',
    labelWidth:45,
    items:[{
        		layout:'column',
    			frame:false,
    			border:false,
        		defaults:{
        			border:false,
        			frame:false
        		},
            	items:[{
	                columnWidth:.75,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 5',
        	       	items: [{
						xtype:'textfield',
						anchor:'100%',
						id:'_serachText',
						name:'query',
						fieldLabel:'搜索',
						enableKeyEvents:true,
						listeners:{
							keydown:function(obj,event){
								var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
								if(keyCode==13){
									_searchAjax();
								}
							}
						}
					}]
				},{
	                columnWidth:.25,
    	           	layout: 'form',
    	           	bodyStyle:'padding:0 0 0 0',
        	       	items: [
        	       		new Ext.Button({
							text:'查询',
							id:'_searchButton',
							minWidth:75,
							handler:function(){
								_searchAjax();
							}
						})
					]
				}
			]
		}]
});

function _searchAjax(){
	var cmp1 = Ext.getCmp("_searchButton");
	var cmp2 = Ext.getCmp("_serachText");
	cmp1.disable();
	cmp2.disable();
	var p = {};
	
	//保持原来的选择状态
	_ajaxSelectOld = _searchCsm.getSelections();

	//查询
	_smap.value = Ext.getCmp(_smap.vid).getValue();
	_smap.query = Ext.getCmp("_serachText").getValue();

	_searchStore.baseParams = _smap;
	_searchStore.load({params:{start:0, limit:50}})
}

function _enableSearch(){
	var cmp1 = Ext.getCmp("_searchButton");
	var cmp2 = Ext.getCmp("_serachText");
	cmp1.enable();
	cmp2.enable();
}

var _ajax_codeSelectWindow = new Ext.Window({
	title:'代码搜索窗口',
	closeAction:'hide',
	modal:true,
	width:420,
	closeAction:'hide',
	height:400,
	layout:'border',
	items:[_searchfs,_searchGrid],
	listeners:{
		
	},
	bbar:[
		'->', 
		{
			text    : '确定',
			handler : function(){
				var res = _searchCsm.getSelections();
				var list = new Array();
				var v = "",t = "";
				for(var i=0;i<res.length;i++){
					if(i>0){
						v += ",";
						t += ",";
					}
					v += res[i].data.code;
					t += res[i].data.name;
					
					list[i] = res[i].data;
				}
				Ext.getCmp(_smap.tid).setValue(t);
				Ext.getCmp(_smap.vid).setValue(v);
				
				_ajaxDefCodeList[_smap.vid] = list;
				_ajax_codeSelectWindow.hide();
			}
		},'-',{
			text    : '取消所有选择',
			handler : function(){
				_searchCsm.clearSelections();
			}
		},'-',{
			text    : '关闭',
			handler : function() {
				_ajax_codeSelectWindow.hide();
			}
		}
	]
});

/**AJAX通用选择窗口*/

var _myTreeLoader = new Ext.tree.TreeLoader({
	dataUrl: 'util/dict?method=queryTree',
	listeners:{
		loadexception:function(tree,node,response){
			Ext.Msg.alert("加载失败",response.responseText);
		}
	}
});

/**
 * 关键修正，postDetailOnlyOne用于指示第一次初始化的时候加载postDetail指定的节点，二次展开的时候忽略.
 * 
 * @type 
 */
var _initDict_obj = {};
_myTreeLoader.on("beforeload", function(treeLoader, node) {
		var dict = Ext.urlDecode(this.baseParams.dict);
		if(_initDict_obj[dict.tid]){
			delete dict.postDetailOnlyOne;
		}else{
			_initDict_obj[dict.tid] = '0';
		}
		
		//在beforeload事件中每次动态传递点击的节点的value属性作为参数
		if(node.attributes.zzjg){
			dict.postDetail = node.attributes.zzjg.ccm;
	       		//this.baseParams.dict = this.baseParams.dict + "&postDetail=" + node.attributes.zzjg.ccm;
	       	}else if(node.attributes.js){
	       		dict.postDetail =node.attributes.js.xmbm;
	       		//this.baseParams.dict = this.baseParams.dict + "&postDetail=" + node.attributes.js.xmbm; 
	       	}else if(node.attributes.code){
	       		dict.postDetail = node.attributes.code.code;
	       		//this.baseParams.dict = this.baseParams.dict + "&postDetail=" + node.attributes.code.code;
	       	}else{
	       		;
	       	}
	       	
	       	this.baseParams.dict = Ext.urlEncode(dict);
	},
	_myTreeLoader
);

_myTreeLoader.on("load", function(treeLoader, node, response) {
		//在beforeload事件中每次动态传递点击的节点的value属性作为参数
		//alert("load="+response.responseText);
		var o = Ext.decode(response.responseText);
		if(o.messages && o.messages.length>0){
			alert(o.messages[0]);
		}
		
		//if(node.attributes.zzjg){
       	//	this.baseParams.dict = this.baseParams.dict + "&postDetail=" + node.attributes.zzjg.organizeDetailCode;
		//}else if(node.attributes.code){
		//alert(node.attributes.code);
       	//	this.baseParams.dict = this.baseParams.dict + "&postDetail=" + node.attributes.code.code;
       	//}
	}, 
	_myTreeLoader
);

_myTreeLoader.on("loadexception", function(treeLoader, node, response) {
		alert(response.innerHTML);
	}, 
	_myTreeLoader
);

function _selectCodeChange(node,checked){
	var selTree = _treeArray[_smap.tid];
	selTree.suspendEvents();
	if(_smap.mselect && (_smap.mselect=="1" || _smap.mselect=="true")){
		//多选
		node.getUI().toggleCheck(checked);
	}else{
		//单选
	    Ext.each(selTree.getChecked(),function(item){
	    	item.getUI().toggleCheck(false);
	    });
	    node.getUI().toggleCheck(checked);
	}
	selTree.resumeEvents();
}

function _clearSelectCodeEnd(){
	var selTree = _treeArray[_smap.tid];
	Ext.each(selTree.getChecked(),function(item){
		item.getUI().toggleCheck(false);
	});
}

function _selectCodeEnd(){
	var selTree = _treeArray[_smap.tid];
	var txtStr = "",valStr = "";
	var list = new Array();
	Ext.each(selTree.getChecked(),function(item){
		if(item.getUI().isChecked()){
			var t = "";
			var s = "";
	    	if(_smap.VisionType=="DW"){
	    		t = item.attributes.zzjg.organizeName;
	    		v = item.attributes.zzjg.organizeBm;
	    		list[list.length] = item.attributes.zzjg;
	    	}else if(_smap.VisionType=="DW2" || _smap.VisionType=="CCM"){
	    		t = item.attributes.zzjg.organizeName;
	    		v = item.attributes.zzjg.ccm;
	    		list[list.length] = item.attributes.zzjg;
	    	}else if(_smap.VisionType=="RY"){
	    		t = item.attributes.zzjy.xm;
	    		v = item.attributes.zzjy.loginName;
	    		list[list.length] = item.attributes.zzjy; 
	    	}else if(_smap.VisionType=="JS"){
	    		t = item.attributes.js.roleName;
	    		v = item.attributes.js.roleBm;	    		
	    		list[list.length] = item.attributes.js;
	    	}else{
	    		t = item.attributes.code.name;
	    		v = item.attributes.code.code;
	    		list[list.length] = item.attributes.code;
	    	}
	    	
	    	if(txtStr=="") txtStr = t;
	    	else txtStr += "," + t;
	    					
	    	if(valStr=="") valStr = v;
	    	else valStr += "," + v;
	    }
	});
	var dom = document.getElementById(_smap.tid);					
	dom.value = txtStr;
	
	if(_smap.vid){
		dom = document.getElementById(_smap.vid);
		if(dom){
			dom.value = valStr;
		}else{
			alert("没有找到一个id值为" + _smap.vid + "对象！");
		}
	}
	_winArray[_smap.tid].hide();
	if(_smap.eevent){
		var cmd = _smap.eevent + "(_smap,list)";
		eval(cmd);
	}
}

function _bindSelectCode(){
	_smap = Ext.urlDecode(this.dict);

	//默认名字空间
	if(!_smap.sp) _smap.sp = _sp;
		
	if(_smap.ronly){
		this.disabled = _smap.ronly;
		return;
	}
	
	if(!_smap.tid){
		alert("弹出模式，必须提供tid参数！");
		return;
	}
		
	if(!_rootArray[_smap.tid]){
		//计算默认值
		var tdom = document.getElementById(_smap.tid);
		if(!tdom){
			alert("不存在一个id为" + _smap.tid + "的数据对象！");
			return;
		}else{
			if(tdom.requestcode){
				_smap.def = tdom.requestcode;
			}else{
				var vdom = document.getElementById(_smap.vid);
				if(vdom && vdom.value){
					_smap.def = vdom.value;
				}
			} 
		}
		
		var root = new Ext.tree.AsyncTreeNode({
			text:'根'
		});
		_rootArray[_smap.tid] = root;
		
		var CodeSelectTree = new Ext.tree.TreePanel({
	    	autoScroll:true,
	    	root			:root,
	    	rootVisible 	:false,
	    	region          :'west',
	    	loader			:_myTreeLoader,
	    	width			:300,
	    	height			:400,
	    	listeners		:{
	    		checkchange:function(node,checked){
					_selectCodeChange(node,checked);
	    		}, 
	    		dblclick:function(node,e){
					node.getUI().toggleCheck(true);
					_selectCodeEnd();
	    		},
	    		click:function(node,e){
	    			node.getUI().toggleCheck();
	    		}
	    	}
		});
		_treeArray[_smap.tid] = CodeSelectTree;
		
		var codeSelectTreeWindow = new Ext.Window({
			title:'代码选择窗口',
			closeAction:'hide',
			modal:true,
			width:420,
			closeAction:'hide',
			height:400,
			layout:'fit',
			items:CodeSelectTree,
			bbar:[
					'->', 
					{
						text    : '确定',
						handler : function(){
							_selectCodeEnd();
						}
					},'-',{
						text    : '取消所有选择',
						handler : function(){
							_clearSelectCodeEnd();
						}
					},'-',{
						text    : '关闭',
						handler : function() {
							codeSelectTreeWindow.hide();
						}
					}
				]
		});
		
		_winArray[_smap.tid] = codeSelectTreeWindow;		
		_myTreeLoader.baseParams = {dict:Ext.urlEncode(_smap)};
		
		codeSelectTreeWindow.expand(); 
	}
	
	if(_smap.title)
		_winArray[_smap.tid].setTitle(_smap.title);
		
	_winArray[_smap.tid].show();
	_myTreeLoader.baseParams = {dict:Ext.urlEncode(_smap)};
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	Ext.namespace("gnt.com.ux");
	Ext.namespace("gnt.com.ux.plugin");
	Ext.namespace("gnt.com.util");
	
	//定义字典工具对象
	gnt.com.util.Dict = function(){};
	gnt.com.util.Tool = function(){};
	gnt.com.util.Dict.IgnoreLabel = ignoreLabel;
	
	//是否为所有下拉列表项，添加忽略项
	gnt.com.util.Dict.AllIgnore = false;
	gnt.com.util.Dict.DictOpenEventTip = "双击选择字典值！";
	
	//打印对象信息
	gnt.com.util.Tool.Print = function(obj){
		var str = "";
		
		if(typeof obj != "object")
			str = obj;
		else	
			for(o in obj)
				str += o + "=" + obj[o] + ";<BR>\n";
		
		Ext.Msg.alert("提示",str);
	};
	
	//private 初始化数据提供控件
	gnt.com.util.Dict.init = function(config){
		if(config==undefined){
			alert("必须指定字典配置参数！");
			return false;
		}
		
		if(!config.VisionType){
			alert("字典配置必须指定VisionType属性！");
			return null;
		}
		
		return true;
	}
	
	//计算store的唯一标示
	gnt.com.util.Dict.getDictKey = function(dict){
		/*
		var storeKey = dict.ignore && dict.ignore == 'true'?"true":"false";
		
		storeKey += "_" + dict.VisionType;
		
		if(!dict.sp) storeKey += "_" + _sp;
		else storeKey += "_" + dict.sp;
		
		if(!dict.exclude) storeKey += "_";
		else storeKey += "_" + dict.exclude;
		*/
		var key = "_store_";
		if(dict.vid)
			key += dict.vid;
		else
			key += Ext.encode(dict);
			
		return key;
	}
	
	//翻译字典
	gnt.com.util.Dict.getDictName=function(value,dictstr){
		var dict = Ext.decode(dictstr);
		var store = gnt.com.util.Dict.getStore(dict);
		var r = store.getById(value);
		if(r){
			return r.data.name;
		}
		return value;
	}
	
	//获取Store
	gnt.com.util.Dict.getStore = function(dict){
		//计算store的唯一识别
		var storeKey = gnt.com.util.Dict.getDictKey(dict);
		
		//默认为空store
		if(_storeArray[storeKey]){
			 store = _storeArray[storeKey];
			 return store;
		}else{
			var tmpStore = new Ext.data.SimpleStore({
				id:1,
				fields:[{name: 'name', mapping: 0},{name:'code',mapping:1}],
	    		data:[]
	    	});	
	    	_storeArray[storeKey] = tmpStore;
	    	return _storeArray[storeKey];
	    }
	}

	//将数组转换为Store的二维数组
	gnt.com.util.Dict.getStoreList = function(codelist,smap){
		var i = 0;			
		var list = new Array();

		if(gnt.com.util.Dict.AllIgnore==true || (smap.ignore && (smap.ignore=="true" || smap.ignore==true))){			
			list[0] = new Array();
			if(smap.ignoretext)
				list[0][0]= smap.ignoretext;
			else							
				list[0][0]= gnt.com.util.Dict.IgnoreLabel;
			list[0][1]="";
			i++;
		}
						
		if(smap.exclude)
			smap.exclude = "," + smap.exclude + ",";
		for (var i=0; i < codelist.length; i++) {
			if(smap.exclude)
				if(smap.exclude.indexOf("," + codelist[i].code + ",")>=0)
					continue;

			var len = list.length;
			list[len] = new Array();
			list[len][0] = codelist[i].name;
			list[len][1] = codelist[i].code;		
		}
		
		return list;
	}
	
	//定义字典插件，用于获取下列列表数据
	gnt.com.ux.plugin.DictComboBoxPlugin = function(){};
	gnt.com.ux.plugin.DictComboBoxPlugin.prototype.init = function(comp){
		//如果以字符串方式提供dict参数，那么转为为JSON
		if(typeof comp.dict == "string")
			comp.dict = Ext.urlDecode(comp.dict);
		
		//计算store的唯一识别
		var _store = gnt.com.util.Dict.getStore(comp.dict);
		comp.store = _store;
	}
	
	//定义字段下列列表项，从基本Ext.form.ComboBox继承
	gnt.com.ux.DictComboBox = Ext.extend(
		Ext.form.ComboBox,
		{
			mode: 'local',
            triggerAction: 'all',
			valueField:"code",
      		displayField:"name",
			selectOnFocus:true,
			//emptyText : '请选择',
			typeAhead: true,  
			forceSelection: true,
			//disable:true,
 			//editable: false,//是否允许输入 
    		forceSelection: true,//必须选择一个选项 
    		blankText:'请选择',//该项如果没有选择，则提示错误信息 			
            lazyRender:true,
            listClass: 'x-combo-list-small',
			plugins:[new gnt.com.ux.plugin.DictComboBoxPlugin()],
			//组件初始化
			initComponent:function(){
				gnt.com.ux.DictComboBox.superclass.initComponent.call(this);
			}
        }
	);
	
	Ext.reg("DictComboBox",gnt.com.ux.DictComboBox);
	
	gnt.com.ux.DictColumnModel = function(config){
		gnt.com.ux.DictColumnModel.superclass.constructor.call(this,config);
		_grid_count	++;
		
		var cols = this.getColumnsBy(function(){return true});
		for(var i=0;i<cols.length;i++){
			var ocx = null;
			var dictRenderer = "";
			var dict = null;
			
			if (cols[i].dict) {
				//如果字段指定了dict参数
				if(typeof cols[i].dict == "string")
					cols[i].dict = Ext.urlDecode(cols[i].dict);

				if(cols[i].dict.dictRenderer) dictRenderer = cols[i].dict.dictRenderer;
				dict = cols[i].dict;
			}else{
				if(cols[i].editor && cols[i].editor.field.dict){
					//如果是字典组合框
					if (cols[i].editor.field.getXTypes().indexOf("/DictComboBox") > 0) {
						//如果字段的editor指定了dict
						if (typeof cols[i].editor.field.dict == "string") 
							cols[i].editor.field.dict = Ext.urlDecode(cols[i].editor.field.dict);
						
						dict = cols[i].editor.field.dict;
						
						if (cols[i].editor.field.dict.dictRenderer) 
							dictRenderer = cols[i].editor.field.dict.dictRenderer;
					}else{
						continue;
					}
					
					//cols[i].editor.field  为最终的编辑对象，这个非常重要
				}
			}
		
			//如果存在字典，那么渲染显示renderer
			if(dict){
				dict.isgrid = true;
				dict.gridindex =_grid_count;
				var cmap = new Ext.util.MixedCollection();
				_map.add(dict.gridindex,cmap);
				//必须这么动态创建数据解析方法
				var renderer = "";
				if(dictRenderer!=""){
					renderer = "cols['" + i + "'].renderer=function(value, cellmeta, record, rowIndex, columnIndex, store){ return "
								+ dictRenderer + "(value, cellmeta, record, rowIndex, columnIndex, store,'" + Ext.encode(dict) + "');}";
					
				}else{
					//重要：单元格ID值总是唯一，即使排序发生变化都不变。	
				 	renderer = "cols['" + i + "'].renderer=function(" +
						"value, cellmeta, record, rowIndex, columnIndex, store){" +
						"_grid_span_count++;" +
						" var domid = '" + _grid_count + "_span_' + record.id + '_" + cols[i].id + "' + '_' + value;" +
						"var lname = '" +dict.VisionType + "';" +
						//"lname = gnt.com.util.Dict.getDictName(value, '" + Ext.encode(dict) + "');" +
						//"return lname;}";
						"return \"<span id=\" + domid + \" dict='" + Ext.urlEncode(dict) + "'>\" + _readMap('" + dict.gridindex + "',domid,value) + \"</span>\";}";
				}
				eval(renderer);
				//_grid_store.push(Ext.urlEncode(dict));
			}
		}		
	};
	
	Ext.extend(
		gnt.com.ux.DictColumnModel,
		Ext.grid.ColumnModel,
		{}
	);
	
	Ext.reg("DictColumnModel",gnt.com.ux.DictColumnModel);
	
	//字典输入域
	gnt.com.ux.plugin.DictTextFieldPlugin = function(){
		var dblFn=null,comp=null;
		function regEvent(){
			var comp = this;
			gnt.com.util.Dict.init(this.initialConfig.dict);
		}
					
		this.init = function(comp){
			this.comp = comp;
			//设置为只读
			comp.readOnly = true;
		}
	}

	gnt.com.ux.DictTextField = function(config){
		gnt.com.ux.DictTextField.superclass.constructor.call(this, config);
		
		//分析构造参数dict
		if(typeof config.dict == "string")
			config.dict = Ext.urlDecode(config.dict);
		
		if(!config.dict){
			alert("构造DictTextField，必须指定dict参数！");
			return;	
		}
		
		if(!config.dict.VisionType){			
			alert("构造DictTextField，必须指定dict配置的VisionType参数！");
			return;	
		}			
	}
	
	Ext.extend(
		gnt.com.ux.DictTextField,
		Ext.form.TextField,
		{
			style: 'background-image: url("");background-color: #F0F0F0;',
			plugins:[new gnt.com.ux.plugin.DictTextFieldPlugin()]
		}
	);
	Ext.reg("DictTextField",gnt.com.ux.DictTextField);
	
	gnt.com.ux.DictTextArea = Ext.extend(
		Ext.form.TextArea,
		{
			style: 'background-image: url("");background-color: #F0F0F0;',
			plugins:[new gnt.com.ux.plugin.DictTextFieldPlugin()]
		}
	);
	Ext.reg("DictTextArea",gnt.com.ux.DictTextArea);

	//定义字段下列列表项，从基本Ext.form.ComboBox继承
	gnt.com.ux.DictTree = Ext.extend(Ext.tree.TreePanel, {
		buttons : [
			new Ext.Button({
						text:'确定',
						minWidth:75,
						handler:function(){
							var item = this.ownerCt;
							var tree = null;
							var win = null;
							var ids = "";
							
							while(true){
								if(item.getXType){
									if(item.getXType()=="DictTree"){
										tree = item;
									}
									
									if(item.getXType()=="window"){
										win = item;
										break;
									}
									
									item = item.ownerCt;
								}else{
									break;
								}
							}
							
							var list = new Array();
							if(tree){
								Ext.each(tree.getChecked(),function(item){
									if(ids!="") ids += ",";
									
									if(item.attributes.zzjy){
										ids += item.attributes.zzjy.yhid;
										list.push(item.attributes.zzjy);
									}else if(item.attributes.code){
										ids += item.attributes.code.code;
										list.push(item.attributes.code);
									}else if(item.attributes.dw){
										ids += item.attributes.dw.dm;
										list.push(item.attributes.dw);
									}
								});
							}
							if(ids==""){
								Ext.Msg.alert("提示",tree.noSelectText);
								return;
							}
							
							if(win){
								win.hide();
							}
							
							if(tree.callback)
								tree.callback(ids,list);
						}
					}),
					new Ext.Button({
						text:'取消',
						minWidth:75,
						handler:function(){
							var item = this.ownerCt;
							while(true){
								if(item.getXType){
									if(item.getXType()=="window"){
										item.hide();
										break;
									}
									item = item.ownerCt;
								}else{
									break;
								}
							}
						}
					})
		],
		autoScroll : true,
		root : new Ext.tree.AsyncTreeNode({
				text: "根"
		}),
		callback :  function(ids){},
		noSelectText:  "选择不能为空！",
		rootVisible: false,
		width:	 300,
		height:	 400,
		loader: new Ext.tree.TreeLoader({
			dataUrl		: 'util/dict?method=queryTree',
			baseParams	:{},
			listeners	:{
				loadexception:function(tree,node,response){
					Ext.Msg.alert("加载失败",response.responseText);
				},
				beforeload:  function(treeLoader, node) {
						//在beforeload事件中每次动态传递点击的节点的value属性作为参数
						if(node.attributes.dw){
					       		this.baseParams.dict = this.baseParams.dict + "&postDetail=" + node.attributes.dw.dm;
					       	}else if(node.attributes.js){
					       		this.baseParams.dict = this.baseParams.dict + "&postDetail=" + node.attributes.js.xmbm; 
					       	}else if(node.attributes.code){
					       		this.baseParams.dict = this.baseParams.dict + "&postDetail=" + node.attributes.code.code;
					       	}else{
					       		;
					       	}
					       	
					       	return this.isStart=="1"?true:false;
				},
				load: function(treeLoader, node, response) {
						//在beforeload事件中每次动态传递点击的节点的value属性作为参数
						var o = Ext.decode(response.responseText);
						if(o.messages && o.messages.length>0){
							alert(o.messages[0]);
						}
				},
				loadexception:function(treeLoader, node, response) {
						alert(response.innerHTML);
				}
			}
		}),
		listeners: {
	    		'checkchange':function(o,c){
	    			var dict = o.getOwnerTree().getLoader().baseParams.dict;
	    			
	    			if(o.disabled){
	    				o.getUI().checkbox.checked=!(o.getUI().checkbox.checked);
	    			}else{
	    				if(dict.indexOf("mselect=false")>=0){
	    					//单选
	    					o.getOwnerTree().suspendEvents();
	    					Ext.each(o.getOwnerTree().getChecked(),function(item){
						    	item.getUI().toggleCheck(false);
						});
						o.getUI().toggleCheck(c);
	    					o.getOwnerTree().resumeEvents();
	    				}
	    			}
	    		} 
		},
	   	initComponent : function(){
	        	gnt.com.ux.DictTree.superclass.initComponent.call(this);
	    	},
	   	loadData:  function(dict, callback){
			   //指定加载数据
			 this.loader.baseParams = {dict:dict};
			 this.loader.isStart = "1";
			this.root.reload();
			this.callback = callback;
		}
	});
	Ext.reg("DictTree",gnt.com.ux.DictTree);
	
	
//重新加载指定DOM节点下的字典
function _initReloadDict(pid){
	var jsonArray = new Array();
	var comp = Ext.getCmp(pid);
	if(comp){
		var list = comp.findBy(
			function(item){
				if(item.getXType()=="DictTextField" || item.getXType()=="DictTextArea"){
					var o = Ext.urlDecode(item.dict);
					if(!o.event)
						o.event = "openwindow";
					
					if(o.event == "ajax"){
						item.getEl().un("dblclick",_bindAjaxSelectCode);
						item.getEl().on("dblclick",_bindAjaxSelectCode,item);
					}else{	
						item.getEl().un("dblclick",_bindSelectCode);
						item.getEl().on("dblclick",_bindSelectCode,item);
					}
					
					var vdom = Ext.getCmp(o.vid);
					if(vdom){
						o.def = vdom.getValue();
					}
					//默认名字空间
					if(!o.sp) o.sp = _sp;				
					jsonArray.push(Ext.urlEncode(o));		
						
					return false;
				}
				return false;
			}
		);		
	}
	
	var els = _q.select("span[dict]",document.getElementById(pid));
	for(var i=0;i<els.length;i++){
		var o = Ext.urlDecode(els[i].dict);
		o.event = "openwindow";
		if(els[i].requestcode)
			o.def = els[i].requestcode;
		if(!o.def){
			o.def = els[i].innerText;
		}
		if(!o.vid && !o.tid){
			o.vid = els[i].id;
			o.tid = els[i].id;
		}
		if(!o.tid)
			o.tid = o.vid;
		o.isspan = true;
		jsonArray.push(Ext.urlEncode(o));
		if(o.gridindex){
			//清除内存，否则越积越多
			_map.get(o.gridindex).clear();
		}
	}
	
	_load(jsonArray);
	if(comp){
		;//comp.doLayout();
	}
}

function _readMap(gridindex,id,value){
	var cmap = _map.get(gridindex);
	var v = cmap.get(id);
	if(!v)
		v = value;		
	return v;
}

//初始化字典
function initDict(){
	var jsonArray = new Array();
	
	//遍历所有组件，为弹出字段设置默认值，为下拉字段填充下拉数据
	Ext.ComponentMgr.all.each(function(item){
		if(item.getXType()=="DictTextField"
		 || item.getXType()=="DictTextArea" 
		 || item.getXType()=="DictComboBox"){
			if(item.getXType()=="DictTextField" || item.getXType()=="DictTextArea"){
				if(item.getEl()) {
					var o = Ext.urlDecode(item.dict);
					if(!o.event)
						o.event = "openwindow";
					
					if(o.event == "ajax"){
						item.getEl().un("dblclick",_bindAjaxSelectCode);
						item.getEl().on("dblclick",_bindAjaxSelectCode,item);
					}else{	
						item.getEl().un("dblclick",_bindSelectCode);
						item.getEl().on("dblclick",_bindSelectCode,item);
					}
					
					//o.event = "ajax";	//支持搜索
						
					//默认名字空间
					if(!o.sp) o.sp = _sp;
					
					jsonArray.push(Ext.urlEncode(o));
				}
			}else{
				if(typeof item.dict == "string")
					item.dict = Ext.urlDecode(item.dict);
				if(!item.dict.vid)
					item.dict.vid = item.id;
					
				//默认名字空间
				if(!item.dict.sp)
					item.dict.sp = _sp;
				
				//下拉列表
				jsonArray.push(Ext.urlEncode(item.dict));
			}
		}
	});
	
	for(var i=0;i<_grid_store.length;i++)
		jsonArray.push(_grid_store[i]);
	
	//支持span标签翻译
	var els = _q.select("span[dict]");
	for(var i=0;i<els.length;i++){
		var o = Ext.urlDecode(els[i].dict);
		o.event = "openwindow";
		if(els[i].requestcode)
			o.def = els[i].requestcode;
		if(!o.def){
			o.def = els[i].innerText;
		}
		if(!o.vid && !o.tid){
			o.vid = els[i].id;
			o.tid = els[i].id;
		}
		if(!o.tid)
			o.tid = o.vid;
		o.isspan = true;
		jsonArray.push(Ext.urlEncode(o));
	}
	
	_load(jsonArray);
}

function _load(jsonArray){
	if(jsonArray.length>0){
		_mask.show();
		Ext.Ajax.request({
			url:'util/dict?method=queryCode',
			method:'POST', 
			params:{data:Ext.encode(jsonArray)},			
			success:function(result,request){
				_mask.hide();
				var jsonData = Ext.util.JSON.decode(result.responseText);
				var j = 0;
				
				if(jsonData.success){
					var data = Ext.util.JSON.decode(jsonData.data);

					for(vid in data){
						if(!data[vid].codelist)
							continue;
						
						var codelist = data[vid].codelist;
						var smap = data[vid].smap;
						var comp = null;
						
						//弹出树结构选择字典
						if(smap.event && (smap.event=="openwindow" || smap.event=="ajax")){
							if(!smap.def)
								continue;
							
							//AJAX方式，保持初始选择值
							if(smap && smap.event=="ajax"){
								_ajaxDefCodeList[vid] = codelist;
							}
							
							var varStr="",txtStr="";
							for(var i=0;i<codelist.length;i++){
								if(varStr=="") varStr = codelist[i].code;
								else varStr += "," + codelist[i].code;
								
								if(txtStr=="") txtStr = codelist[i].name;
								else txtStr += "," + codelist[i].name;							
							}
							
							//如果是标签
							if(smap.isspan){
								var dom = document.getElementById(smap.tid);								
								if(dom && dom.tagName.toUpperCase()=='SPAN'){
									if(txtStr==""){
										dom.innerHTML = smap.def;
										if(smap.gridindex){
											var cmap = _map.get(smap.gridindex);
											cmap.add(smap.tid,smap.def);
										}
									}else{				
										dom.innerHTML = txtStr;
										if(smap.gridindex){
											var cmap = _map.get(smap.gridindex);
											cmap.add(smap.tid,txtStr);
										}
									}
									continue;
								}
							}
							
							comp = Ext.getCmp(smap.tid);
							if(!comp)
								continue;
								
							if(comp && smap.ronly){
								//如果含只读属性，那么只读			
								comp.setDisabled(smap.ronly);
							}
							comp.setValue(txtStr);
							
							if(smap.vid){
								comp = Ext.getCmp(smap.vid);
								if(comp)
									comp.setValue(varStr);
							}
							
							continue;
						}
						
						//下拉方式填充数据
						var storelist = gnt.com.util.Dict.getStoreList(codelist,smap);
						if(smap.isgrid){
							var store = gnt.com.util.Dict.getStore(smap);
							if(store.getCount()==0){
								store.loadData(storelist);
							}							
							continue;
						}
						
						comp = Ext.getCmp(smap.vid);
						if(codelist.length==0){
							//Ext.Msg.alert("提示","字典[" + smap.VisionType + "]没有找到数据！");
							continue;
						}

						if(smap.def)
							comp.setValue(smap.def);
						
						if(comp.store.getCount()>0){
							continue;
						}
						
						comp.store.loadData(storelist);

						if(smap.def){
							comp.setValue(smap.def);
						}
					}
				}else{
					alert(jsonData.message);
				}
				
				if(window.onReadyDict){
					window.onReadyDict();
				}
			}, 
			failure: function ( result, request) {
				_mask.hide();
				Ext.MessageBox.alert('获取字典发生意外错误',result.responseText); 
			}
		});
	}
}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
function showError(msg,title){
	Ext.MessageBox.show({
		title: title?title:"操作失败",
		msg: msg,
		buttons:Ext.Msg.OK,
		icon:Ext.Msg.ERROR
	});
}