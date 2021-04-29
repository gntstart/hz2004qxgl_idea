Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');

Ext.onReady(function () {
	
    var tjStore = new Ext.data.JsonStore({
		
		fields: ['dsdm','dsmc','pcsdm','pcsmc','ywsl','tjsj','tjsjStr','xq','bm'],
		proxy: {
	        type: 'ajax',
	        url: 'ywpm.do?method=queryPr&pcsdm=' + getUrlParam("pcsdm"),
	       	reader: {
	            type: 'json',
	            root: 'list',
	            idProperty: 'fwdzbm'
	        }
    	},
        
        listeners : {
			loadexception : function(mystore, options, response, error) {
				Ext.Msg.alert('信息', '没有查询到符合条件的记录！');
			},
      		load:function(){  
      			//loadGrid(data);
      			//alert(tjStore.getCount());
      			Ext.getCmp('chartbmp').redraw();
      		}
		}

    });
	
	tjStore.load();
	
    //柱形图
    var panel1 = Ext.create('widget.panel', {
        width: '100%',
        height: '30%',
        title: '派出所办理业务统计',
        renderTo: Ext.getBody(),
        layout: 'fit',
        
        items: {
            xtype: 'chart',
            animate: true,
            id:'chartbmp',
            shadow: true,
//            isStore: false,
            store: tjStore,
            axes: [{
                type: 'Numeric',
                position: 'left',
                fields: ['ywsl'],
                title: '数量',
                grid: true,
                minimum: 0
               // maximum: 900
            }, {
                type: 'Category'
                ,position: 'bottom'
                ,fields: ['tjsjStr']
//            	,title: '日期'
                ,label: {
                    rotate: {
                        degrees: 320
                    }
                }
            }],
            series: [{
            	type: 'column',//柱状图
                //type: 'line',//line ,线形图
                axis: 'left',
                gutter: 20,
                xField: 'name',
                yField: ['ywsl'],
                tips: {
                    trackMouse: true,
                    width: 74,
                    height: 38,
                    renderer: function(storeItem, item) {
                        this.setTitle(storeItem.get('tjsjStr') + '<br />' + storeItem.get('ywsl'));
                    }
                },
                style: {
                    fill: '#D98200'
                }
            }]
        }
    });
    
   //grid
     // create the Grid
    var grid = Ext.create('Ext.grid.Panel', {
        store: tjStore,
        stateful: true,
        stateId: 'stateGrid',
        width: '100%',
        height: '68%',
        columns: [
            {
				header: "序号",
				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
					return (rowIndex + 1) ;
				},
				sortable: true,
				align: "center",
				width: 50
			}
            ,{
            	text     : '地市名称',
            	flex     : 1,
            	width    : 200,
            	sortable : true,
            	dataIndex: 'dsmc'
            }
            ,{
            	text     : '区县名称',
            	flex     : 1,
            	width    : 200,
            	sortable : true,
            	dataIndex: 'xq'
            }
            ,{
                text     : '派出所名称',
                flex     : 1,
                width    : 200,
                sortable : true,
                dataIndex: 'pcsmc'
            }
            ,{
                text     : '业务数量',
                width    : 100,
                sortable : true,
                //renderer : 'usMoney',
                dataIndex: 'ywsl'
            },
            {
                text     : '统计时间',
                width    : 150,
                sortable : true,
               // renderer : change,
                dataIndex: 'tjsjStr'
          
            }
        ],
        title: '统计报表',
        renderTo: Ext.getBody(),
        //renderTo: 'grid-example',
        viewConfig: {
            stripeRows: true
        }
    }); 

	
	/*
	new Ext.Viewport({
		layout:'fit',
		id:'vp',
		items:[
			//ywpmGrid
			tabs
			//,fnQueryFs
		]
		
		
    });*/
	
    
});

function getUrlParam(param) {
    var params = Ext.urlDecode(location.search.substring(1));
    return param ? params[param] : params;
}

