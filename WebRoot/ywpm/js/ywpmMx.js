var pagesize=20;
var selRes = null;
var ywpmMxGrid = null;

function closeActiveWorkSpace(jsonData, tab_key){
	
}

Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	ywpmMxGrid = new Gnt.ux.YwpmMxGrid({
    	region:'center',
    	id:'ywpmMxGrid',
    	title: '',
    	showPaging:true,
    	pagesize:pagesize,
    	listeners:{
    		rowclick:function(g, rowIndex, e){
    			
    		}
			,rowdblclick:function(g, rowIndex, e){
    			selRes = g.store.getAt(rowIndex);
    			parent.window.gotoPR('ywpm/pr.jsp?pcsdm='+ selRes.data.pcsdm,selRes.data.pcsmc);
    		}
    		,beforeload:function(store,records,options){
    			//dsdm:"<%=request%>"
    		}
    	},
    	url:'ywpm.do?method=queryMx&dsdm=' + getUrlParam("dsdm")
    });
	
	new Ext.Viewport({
		layout:'fit',
		id:'vp',
		items:[
			ywpmMxGrid
		]
		
		
    });
	
	ywpmMxGrid.loadData();
	
});

function getUrlParam(param) {
    var params = Ext.urlDecode(location.search.substring(1));
    return param ? params[param] : params;
}

