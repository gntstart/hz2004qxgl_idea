var pagesize=20;
var selRes = null;
var _postParams = null;
var rktjMxGrid = null;
var tabs = null;
var dqbm = null;

function closeActiveWorkSpace(jsonData, tab_key){
	
}

Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	Gnt.ux.Dict.loadDict(['CS_HLX','CS_XB','CS_JTGX','CS_MZ','CS_HYZK','CS_XX'],function(){
			
	});
	
	rktjMxGrid = new Gnt.ux.RktjBndbdQcMxGrid({
    	region:'center',
    	id:'rktjGrid',
    	title: '查询结果信息',
    	height:200,
    	showPaging:true,
    	pagesize:pagesize,
    	listeners:{
    		rowclick:function(g, rowIndex, e){
    			
    		},
    		rowdblclick:function(g, rowIndex, e){
    			selRes = g.store.getAt(rowIndex);
    		}
    	},
    	url:'tj/rktj.do?method=queryRktjMx&table='+getUrlParam("table")+'&dsdm='+getUrlParam("dsdm")+'&column=' + getUrlParam("column") +
    		"&fw=" + getUrlParam("fw") + "&startDate=" + getUrlParam("startDate") + "&endDate=" + getUrlParam("endDate") + "&dqdm=" + getUrlParam("dqdm") +
    		"&tjfw=" + getUrlParam("tjfw") + "&pcsdm=" + getUrlParam("pcsdm") 
    });
	
	
	//定义分页面板
    tabs = new Ext.TabPanel({
    	id:'tabs',
        activeTab: 0,
        width:500,
        height:250,
        resizeTabs:true, 
        listeners:{
        	//在关闭分页的时候，调用函数释放iframe占用资源
        	beforeremove:fixIFrame.createDelegate(this)
        },
        sm: new Ext.grid.RowSelectionModel(),
        defaults:{
        	autoScroll: false,
        	frame: false,
        	shim: false,
        	xtype: 'panel'
        },
        items:[
               rktjMxGrid
        ]
    });
	
	new Ext.Viewport({
        layout:'fit',
        id:'vp',
        items:[
               tabs
        ]
    });
	
	/**
		自动加载数据
	 */
	rktjMxGrid.store.removeAll();
	rktjMxGrid.loadData();
	
});


function gotoMx(paramStr){
	/**
		跳转至明细
		参数设置在RktjServiceImpl中
	 */
	
	alert(paramStr);
	
	//openWorkSpaceBeforeClose(tabs, true, "yw/qc.jsp?" + param, "人口统计明细", "rktjmx");
	
}

/**
 * 获取url中指定参数
 * @param param
 * @returns
 */
function getUrlParam(param) {
    var params = Ext.urlDecode(location.search.substring(1));
    return param ? params[param] : params;
}


