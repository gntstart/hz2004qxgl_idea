Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');

Ext.onReady(function () {
	
    var tjStore = new Ext.data.JsonStore({
		
		fields: ['dsdm','dsmc','ywsl','tjsj','bm'],
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
     
//演示数据
  //  
	 var store1 = new Ext.data.JsonStore({
        fields: ['name', 'total','bm'],
        data: [{
            name: '16岁以下',
            total: 55,
            bm: 1
        },{
            name: '16到18岁',
            total: 245,
            bm: 1
        },{
            name: '18到35岁',
            total: 117,
            bm: 1
        },{
            name: '35岁到49岁',
            total: 184,
            bm: 1
        }
        ,{
            name: '49岁以上',
            total: 200,
            bm: 1
        }]
    });
  //

    //饼形图
     /* var donut = false,
        panel1 = Ext.create('widget.panel', {
        width: 780,
        height: 450,
        title: '地市办理业务统计',
        renderTo: Ext.getBody(),
        layout: 'fit',
        tbar: [{
            enableToggle: true,
            pressed: false,
            text: '饼状图',
            toggleHandler: function(btn, pressed) {
                var chart = Ext.getCmp('chartCmp');
                chart.series.first().donut = pressed ? 35 : false;
                chart.refresh();
            }
        }],

        items: {
            xtype: 'chart',
            id: 'chartCmp',
            animate: true,
            store: tjStore,
            shadow: true,
            legend: {
                position: 'right'
            },
            insetPadding: 60,
            theme: 'Base:gradients',
            series: [{
                type: 'pie',
                field: 'total',
                showInLegend: true,
                donut: donut,
                tips: {
                  trackMouse: true,
                  width: 140,
                  height: 28,
                  renderer: function(storeItem, item) {
                    //calculate percentage.
                    var total = 0;
                    tjStore.each(function(rec) {
                        total += rec.get('total');
                          
                    });
          
                    this.setTitle(storeItem.get('name') + ': ' + Math.round(storeItem.get('total') / total * 100) + '%');
                  }
                },
                highlight: {
                  segment: {
                    margin: 20
                  }
                },
                label: {
                    field: 'name',
                    display: 'rotate',
                    contrast: true,
                    font: '18px Arial'
                    
                }
            }]
        }
    });*/
    //柱形图
    var panel1 = Ext.create('widget.panel', {
        width: 780,
        height: 400,
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
                        degrees: 320
                    }
                }
            }],
            series: [{
            	type: 'column',//柱状图
                //type: 'line',//line ,线形图
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
                },
                style: {
                    fill: '#D98200'	//柱状图样式 - 颜色
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
        height: 250,
        width: 780,
        title: '统计报表',
        renderTo: Ext.getBody(),
        //renderTo: 'grid-example',
        viewConfig: {
            stripeRows: true
        }
		,listeners:{
			itemdblclick:function(dataview, record, item, index, e){
				selRes = record.store.getAt(index);
    			gotoMx("ywpm/mx.jsp?dsdm=" + record.data.dsdm);
			}
		}
    }); 
    

	//定义分页面板
	var tabs = new Ext.TabPanel({
		id:'tabs',
        activeTab: 0,
		listeners:{
			//在关闭分页的时候，调用函数释放iframe占用资源
		},
		defaults:{
			autoScroll: true,
			frame: false,
			shim: true,
			xtype: 'panel'
		} 
		,items:[{
			closable: false,
			title: '全省派出所户籍业务量排名信息',
			layout:'border',
			tabTip:'',
			items:[
			       
grid
			]
		}]
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
