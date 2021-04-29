var myMask = new Ext.LoadMask(Ext.getBody(), {msg: "操作执行中，请等待..."});
var selectApplyno = null;
var selRes = null;
Ext.onReady(function () {
    Gnt.ux.Dict.loadDict(['DW'],function(){});
    Ext.QuickTips.init();

    var ryCommonStore = new Ext.data.JsonStore({
        url: 'yw/csjhkkswsqy.do?method=queryCsjhkkswsxx',
        root: 'list',
        id: 'rkpcId',
        totalProperty: 'totalCount',
        fields: ["ds","dsmc", "qyzybyb", "qyzybwb", "qyzwb","zqzyb", "zqzwb","heji"],
        listeners: {
            loadexception: function (mystore, options, response, error) {
                if (error) {
                    var json = Ext.decode(response.responseText);
                    Ext.Msg.alert("提示", json.messages[0]);
                } else {
                    Ext.Msg.alert("提示", response.responseText);
                }
            }
        }
    });

    var ryCsm = new Ext.grid.CheckboxSelectionModel({singleSelect: true});
    var ryColModel = new Ext.grid.ColumnModel([
        ryCsm, {
            header: "单位代码",
            dataIndex: "ds",
            sortable: true,
            hidden:true,
            width: 80
        },{
            header: "单位",
            dataIndex: "dsmc",
            sortable: true,
            width: 100
        }, {
            header: "迁移证已办已报",
            dataIndex: "qyzybyb",
            sortable: true,
            width: 100
        }, {
            header: "迁移证已办未报",
            dataIndex: "qyzybwb",
            sortable: true,
            width: 100
        }, {
            header: "迁移证未办",
            dataIndex: "qyzwb",
            sortable: true,
            width: 120
        }, {
            header: "准迁证已办",
            dataIndex: "zqzyb",
            sortable: true,
            width: 120
        }, {
            header: "准迁证未办",
            dataIndex: "zqzwb",
            sortable: true,
            width: 120
        }, {
            header: "合计",
            dataIndex: "heji",
            sortable: true,
            width: 150,
            renderer : function(v, meta, record){
                return parseInt(record.get("qyzybyb")) + parseInt(record.get("qyzybwb"))
                    + parseInt(record.get("qyzwb"))+ parseInt(record.get("zqzyb"))+ parseInt(record.get("zqzwb"));
            }
        }
    ]);

    var ryGrid = new Ext.grid.GridPanel({
        store: ryCommonStore,
        region: 'center',
        view: new Ext.grid.GridView({
            enableRowBody: true
        }),
        stripeRows: true,
        cm: ryColModel,
        sm: ryCsm,
        loadMask: {msg: '正在加载数据，请稍侯……'},
        bodyStyle: 'width:80%',
        border: true,
        anchor: '100% 100%',
        margins: '0 0 0 0',
        cmargins: '0 0 0 0',
        frame: false,
        iconCls: 'icon-grid',
        title: '',
        listeners: {
            rowclick: function (g, rowIndex, e) {
                selRes = g.store.getAt(rowIndex);
            },
            rowdblclick: function (g, rowIndex, e) {
                selRes = g.store.getAt(rowIndex);
            }
        },
        bbar: new Ext.PagingToolbar({
            pageSize: 20,
            store: ryCommonStore,
            displayInfo: true
        })
    });

    //查询form表单
    ryQueryFs =  new Gnt.ux.GntForm({
        title: '人口普查列表',
        height: 130,
        region: 'north',
        anchor: '100% 100%',
        buttonAlign: 'right',
        labelAlign: 'right',
        frame: true,
        border: false,
        margins: '0',
        layout: 'form',
        labelWidth: 100,
        items: [{
            layout: 'column',
            frame: false,
            border: false,
            defaults: {
                border: false,
                frame: false
            },
            items: [{
                items: [{
                    xtype:'hidden',
                    name: 'gsdw',
                }]
            },{
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0',
                items: [{
                    xtype: 'textfield',
                    anchor: '100%',
                    name: 'gsdwmc',
                    fieldLabel: '归属单位名称',
                    listeners: {
                        render: function (p) {
                            p.getEl().on('dblclick', function (p) {
                                selectDw();
                                //处理点击事件代码
                            });

                        }
                    }
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0 ',
                items: [{
                    xtype:'datefield',
                    anchor:'100%',
                    format:'Ymd',
                    name:'begintime',
                    fieldLabel:'开始时间起',
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0 ',
                items: [{
                    xtype: 'datefield',
                    anchor: '100%',
                    name: 'endtime',
                    format: 'Ymd',
                    fieldLabel: '开始时间至'
                }]
            }
            ]
        }],
        buttons: [
            new Ext.Button({
                text: '查询长三角数据',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    queryry();
                }
            }),
            new Ext.Button({
                text: '生成报表',
                minWidth: 75,
                id: 'genBtn',
                handler: function () {
                    urlLink = "csjhkkswsqy.do?method=ExportqueryCsjhkkswsxx";
                    Ext.Msg.wait("正在查询导出信息，请稍后...");
                    var elemIF = document.createElement("iframe");
                    elemIF.src = urlLink;//"yw/common/downZp?dcParams="+Ext.encode('111');
                    elemIF.style.display = "none";
                    elemIF.setAttribute('async', false);
                    document.body.appendChild(elemIF);
                    var timer = setInterval(function () {
                        var iframeDoc = elemIF.contentDocument || elemIF.contentWindow.document;
                        // Check if loading is complete
                        if (iframeDoc.readyState == 'complete' || iframeDoc.readyState == 'interactive') {
                            // do something
                            Ext.Msg.hide();
                            clearInterval(timer);
                            return;
                        }
                    }, 500);
                }
            }),
            new Ext.Button({
                text: '重置表单',
                minWidth: 75,
                id: 'resBtn',
                handler: function () {
                    ryQueryFs.form.reset();
                    queryry();
                }
            })
        ]
    });

    var p1 = new Ext.Panel({
        layout: 'border',
        items: [
            ryQueryFs,
            ryGrid
        ]
    });
    //定义分页面板

    var v = new Ext.Viewport({
        layout: 'fit',
        id: 'vp',
        border: false,
        items: {
            layout: 'card',
            border: false,
            id: 'card',
            frame: false,
            activeItem: 0,
            xtype: 'panel',
            items: [p1]
        }
    });
    ryGrid.store.load({params: {start: 0, limit: 20}});

    function queryry() {
        var p = ryQueryFs.getForm().getValues();
        ryCommonStore.baseParams = p;
        ryCommonStore.load({params: {start: 0, limit: 20}})
    }


    var treeSelectWin = new Ext.Window({
        title:'选择等同',
        closeAction:'hide',
        modal:true,
        width:400,
        height:400,
        margins:'5',
        layout:'fit',
        items:new gnt.com.ux.DictTree({
            xtype:'DictTree',
            id:'dttree',
            dict:'VisionType=DW&mselect=false&showchecked=false&serviceName=zzjyManagerService&serviceMethod=queryDwxxTreeWin'
        }),
        listeners:{
            show:function(){

            }
        }
    });

    function selectDw(){
        treeSelectWin.setTitle("选择变动单位");
        treeSelectWin.show();
        treeSelectWin.items.first().loadData(
            "VisionType=DW&mselect=false&showchecked=true&serviceName=zzjyManagerService&serviceMethod=queryDwxxTreeWin",
            function(idlist,list){
                if(list.length==1){
                    //alert(Ext.encode(list[0]));
                    ryQueryFs.getForm().setValues({gsdw:list[0].dm,gsdwmc:list[0].mc});
                }
            }
        );
    }
});
