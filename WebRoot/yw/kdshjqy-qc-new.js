var pagesize=20;
var selRes = null;
var _postParams = null;
var qcryGrid = null;
var fnQueryFs = null;
var czrkGrid = null;
var jtcyGrid = null;
var tabs = null;

function closeActiveWorkSpace(jsonData, tab_key){
	var tab = tab_key?tabs.getItem(tab_key):tabs.getActiveTab();
	if(tab)
		tabs.remove( tab );
	
	/*
	if(jsonData && jsonData.list){
		var data = jsonData.list[0];
		var url = "yw/qcnext.jsp?hjywid=" + data.hjywid  + "&qwdq=" + data.qwdq + "&qcdq=" + data.qcdq;
		
		openWorkSpaceBeforeClose(tabs, true, url, "跨地市迁入审批", "kdsqccl_next");
	}else if(jsonData){
		var url = "yw/qcnext.jsp?hjywid=" + jsonData.hjywid + "&qcdq=" + jsonData.qcdq;
		openWorkSpaceBeforeClose(tabs, true, url, "跨地市迁入审批", "kdsqccl_next");
	}
	*/
}

Ext.onReady(function(){
	Ext.QuickTips.init();
	
	Gnt.ux.Dict.loadDict(['CS_HLX','CS_XB','CS_JTGX','CS_MZ','CS_HYZK','CS_XX'],function(){

	});
	
	var hjspGrid = new Gnt.ux.HjspywGrid({
    	region:'center',
    	id:'czrkGrid',
    	title: '待处理跨地区迁出业务',
    	height:200,
    	showPaging:true,
    	pagesize:pagesize,
    	listeners:{
    		rowclick:function(g, rowIndex, e){

    		},
    		rowdblclick:function(g, rowIndex, e){
    			selRes = g.store.getAt(rowIndex);
    			var url = "yw/qc_new.jsp?formdq=" + selRes.data.kdqqy_qcdqbm + "&todq=" + dqbm + "&spywid=" + selRes.data.spywid;
    			openWorkSpaceBeforeClose(tabs, true, url, "跨地市迁出处理", "kdsqccl");
    		}
    	},
    	url:'yw/kdqqy.do?method=queryKDQHjspyw'
    });
	
	//定义分页面板
    tabs = new Ext.TabPanel({
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
        defaults:{
        	autoScroll: false,
        	frame: false,
        	shim: false,
        	xtype: 'panel'
        },
        items:[{
        	//本页不允许关闭
        	closable: false,
            title: '跨地区迁出',
            layout:'fit',
            tabTip:'',
            items:[
                   hjspGrid
            ]
        }, {
			id: "kdqswqc",
			title: "跨地区省外迁入迁出",
			listeners: {// 添加监听器，点击此页面的tab时候要重新加载（刷新功能）
				activate: function () {
					var params = "authToken=" + getQueryParam("authToken") + "&yhid=" + getQueryParam("yhid") + "&dwdm=" + getQueryParam("dwdm") ;
					var url = contextPath + "/yw/yzsydqc.jsp?" + params;
					var htmlStr = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';
					Ext.getCmp('kdqswqc').body.update(htmlStr);
				}
			}
		}, {
			id: "csjhjzm",
			title: "长三角户籍证明",
			listeners: {// 添加监听器，点击此页面的tab时候要重新加载（刷新功能）
				activate: function () {
					var params = "authToken=" + getQueryParam("authToken") + "&yhid=" + getQueryParam("yhid") + "&dwdm=" + getQueryParam("dwdm") ;
					var url = contextPath + "/yw/ywtbxx.jsp?" + params;
					var htmlStr = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';
					Ext.getCmp('csjhjzm').body.update(htmlStr);
				}
			}
		}, {
			id: "csjhkkswsqyqk",
			title: "长三角户口跨省网上迁移情况",
			listeners: {// 添加监听器，点击此页面的tab时候要重新加载（刷新功能）
				activate: function () {
					var params = "authToken=" + getQueryParam("authToken") + "&yhid=" + getQueryParam("yhid") + "&dwdm=" + getQueryParam("dwdm") ;
					var url = contextPath+ "/yw/csjhkkswsqyqk.jsp?" + params;
					var htmlStr = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';
					Ext.getCmp('csjhkkswsqyqk').body.update(htmlStr);

				}
			}
		}]
    });
	
	new Ext.Viewport({
        layout:'fit',
        id:'vp',
        items:[
               tabs
        ]
    });
	
	hjspGrid.store.load({params:{start:0, limit:20}});
});
