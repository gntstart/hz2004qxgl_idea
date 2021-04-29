Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');

Ext.onReady(function () {
	
    var tjStore = new Ext.data.JsonStore({
		
		fields: ['id','dsdm','dsmc','ywsl','tjsj','bm'],
		proxy: {
	        type: 'ajax',
	        url: 'ywpm.do?method=queryYwpmDs',
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
        width: 1000,
        height: 300,
        title: '地市办理业务统计',
        renderTo: Ext.getBody(),
        layout: 'fit',
        
        items: {
            xtype: 'chart',
            animate: true,
            id:'chartbmp',
            shadow: true,
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
                type: 'Category',
                position: 'bottom',
                fields: ['dsmc'],
                title: '地市',
                label: {
                    rotate: {
                        degrees: 30
                    }
                }
            }],
            series: [{
                type: 'column',
                axis: 'left',
                gutter: 80,
                xField: 'name',
                yField: ['ywsl'],
                tips: {
                    trackMouse: true,
                    width: 74,
                    height: 38,
                    renderer: function(storeItem, item) {
                        this.setTitle(storeItem.get('dsmc') + '<br />' + storeItem.get('ywsl'));
                    }
                }
                /*,listeners:{
                	rowdblclick:function(dataview, record, item, index, e){
        				alert(1);
        				selRes = record.store.getAt(index);
            			gotoMx("ywpm/mx.jsp?dsdm=" + record.data.dsdm);
        			}
        		}*/
                ,style: {
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
            },
            {
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
                dataIndex: 'tjsj'
          
            }
        ],
        height: 200,
        width: 780,
        title: '统计报表',
        renderTo: Ext.getBody(),
        //renderTo: 'grid-example',
        viewConfig: {
            stripeRows: true
        }
		,listeners:{
			itemdblclick:function(dataview, record, item, index, e){
				
    			//gotoMx("ywpm/mx.jsp?dsdm=" + record.data.dsdm);
			}
		}
    }); 
    

});


function gotoMx(url){
	/**
		跳转至明细
		参数设置在RktjServiceImpl中
	 */
	
	//alert(url);
	
	openWorkSpaceBeforeClose(tabs, true, url, "全省派出所户籍业务量排名详细信息", "ywpmmx");
	
}
