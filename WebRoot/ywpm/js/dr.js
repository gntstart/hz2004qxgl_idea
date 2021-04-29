Ext.require('Ext.chart.*');
Ext.require('Ext.layout.container.Fit');

Ext.onReady(function () {
	
    var tjStore = new Ext.data.JsonStore({
		
		fields: ['dsdm','dsmc','ywsl','tjsj'],
		proxy: {
	        type: 'ajax',
	        url: 'ywpm.do?method=queryYwpmDs',
//	        url: 'ywpm.do?method=queryPr&pcsdm=340101',
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
        width: '100%',	//报表宽度
        height: '95%',	//报表宽度
//        title: '全省派出所户籍业务量排名信息统计',
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
                ,fields: ['dsmc']
//            	,title: '地市'
                ,label: {
                    rotate: {
                        degrees: 360
                    }
                }
            }],
            chartStyle: {
                padding: 10,
                animationEnabled: true,
                font: {
                    name: 'Tahoma',
                    color: 0x444444,
                    size: 11
                },
                dataTip: {
                    padding: 5,
                    border: {
                        color: 0x99bbe8,
                        size:1
                    },
                    background: {
                        color: 0xDAE7F6,
                        alpha: .9    // 透明度
                    },
                    font: {
                        name: 'Tahoma',
                        color: 0x15428B,
                        size: 10,
                        bold: true
                    }
                },
                xAxis: {
                    color: 0x69aBc8,
                    majorTicks: {color: 0x69aBc8, length: 4},
                    minorTicks: {color: 0x69aBc8, length: 2},
                    majorGridLines: {size: 1, color: 0xeeeeee}
                },
                yAxis: {
                    color: 0x69aBc8,
                    majorTicks: {color: 0x69aBc8, length: 4},
                    minorTicks: {color: 0x69aBc8, length: 2},
                    majorGridLines: {size: 1, color: 0xdfe8f6}
                }
            },
            series: [{
            	type: 'column',//柱状图
                //type: 'line',//line ,线形图
                axis: 'left',
                gutter: 20,	//间距
                xField: 'name',
                yField: 'ywsl'
                ,listeners : {
                	itemmouseup : function(o) {
//                		alert(o.storeItem.data.dsdm);
                		parent.window.gotoPR('ywpm/mx.jsp?dsdm='+ o.storeItem.data.dsdm,o.storeItem.data.dsmc);
                	}
                }/*,label : {  
                    field : ['name'],//标签字段名  
                    display : 'outside',//标签显现方式  
                    font : '19px "Lucida Grande"'//,//字体  
                   // renderer : function(v){//自定义标签渲染函数  
                    //    return v + '次';  
                   // }  
                } */

                ,tips: {
                    trackMouse: true,
                    width: 100,	//
                    height: 50,
                    renderer: function(storeItem, item) {
                        this.setTitle(storeItem.get('dsmc') + '<br />' + storeItem.get('ywsl'));
                    }
                },
                style: {
                    fill: '#D98200'
                }
            }]
        }
    });
    
    
});

function getUrlParam(param) {
    var params = Ext.urlDecode(location.search.substring(1));
    return param ? params[param] : params;
}

