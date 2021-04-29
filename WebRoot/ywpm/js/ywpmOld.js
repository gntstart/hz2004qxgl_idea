var pagesize=100;
var selRes = null;
var tabs = null;
var ywpmGrid = null;

function closeActiveWorkSpace(jsonData, tab_key){
	
}

Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	ywpmGrid = new Gnt.ux.YwpmGrid({
    	//region:'center'
    	id:'ywpmGrid'
    	,title: ''//全省派出所户籍业务量排名信息
//    	,flex: 1
    	,height:393
//    	,height:'100%'
//    	,width:'50%'
    	,width:1000
    	,showPaging:false
    	,pagesize:pagesize
    	,listeners:{
    		rowclick:function(g, rowIndex, e){
    			
    		},
    		rowdblclick:function(g, rowIndex, e){
    			selRes = g.store.getAt(rowIndex);
    			gotoMx("ywpm/mx.jsp?dsdm=" + selRes.data.dsdm,selRes.data.dsmc);
    		}
    	},
    	url:'ywpm.do?method=queryYwpmDs'
    });

	Ext.EventManager.onWindowResize(function(){   
		ywpmGrid.getView().refresh()
	})  
	
	//定义分页面板
	tabs = new Ext.TabPanel({
		id:'tabs',
        activeTab: 0,
        autoWidth:true, 
		listeners:{
			//在关闭分页的时候，调用函数释放iframe占用资源
			beforeremove:fixIFrame.createDelegate(this)
		}
		,defaults:{
			autoScroll: true,
			frame: false,
			shim: true,
			xtype: 'panel'
		} 
		,items:[{
				closable: false,
				title: '全省派出所户籍业务量排名信息',
				tabTip:'',
				items:[
				    	{
				    		id:'topId',
				    		html: '<iframe src="ywpm/dr.jsp" width="100%" height="78%" ' +
					    		+ 'id="weekIFrame" frameborder="0" marginheight="0" ' + 
					    		' scrolling="no" allowtransparency="yes"></iframe>'
				    	},ywpmGrid
				]
			}
		]
	});
	
	new Ext.Viewport({
		layout:'fit',
		id:'vp',
		items:[
			tabs
		]
		
		
    });
	
	ywpmGrid.loadData();
	
});

/**
	跳转至明细
 */
function gotoMx(url,dsmc){
	openWorkSpaceBeforeClose(tabs, true, url, dsmc+"派出所户籍业务量排名详细信息", "ywpmmx");
}

/**
 * 跳转至统计报表
 * @param url
 */
function gotoPR(url,pcsmc){
	openWorkSpaceBeforeClose(tabs, true, url, pcsmc+"统计报表", "pcsReport");
}


