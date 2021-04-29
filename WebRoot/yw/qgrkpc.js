var myMask = new Ext.LoadMask(Ext.getBody(), {msg: "操作执行中，请等待..."});
var selectApplyno = null;
var selRes = null;
Ext.onReady(function () {
    Gnt.ux.Dict.loadDict(['DW'],function(){});
    Ext.QuickTips.init();

    var ryCommonStore = new Ext.data.JsonStore({
        url: 'rkpc.do?method=queryQgRkpcxx',
        root: 'list',
        id: 'rkpcId',
        totalProperty: 'totalCount',
        fields: ["rkpcId", "rkpcZhs", "rkpcZhsBz", "rkpcZrs","rkpcZrsBz", "rkpcXcrks", "rkpcXcrksBz", "rkpcRhfls",
            "rkpcRhflsBz", "rkpcCzwlf", "rkpcCzwlfBz", "rkpcCzwlfJjs","rkpcCswbhk", "rkpcCswbhkBz", "rkpcCswbhkJjs",
            "rkpcCzhkQt", "rkpcCzhkQtBz", "rkpcCzhkQtJjs","rkpcZzrkJzbnys", "rkpcZzrkJzbnysBz",
            "rkpcZzrkXdzzrks","rkpcZzrkXdzzrksBz","rkpcHkdjCdhkrs","rkpcHkdjCdhkrsBz","rkpcHkdjYxwxhks","rkpcHkdjYxwxhksBz",
            "rkpcHkdjSwwx","rkpcHkdjSwwxBz","rkpcHkdjHkbgxms","rkpcHkdjHkbgxmsBz","rkpcCreateDate","rkpcUpdateDate","gsdw",
            "rkpcPaxs","rkpcPaxsBz","rkpcXsaj","rkpcXsajBz","rkpcZaaj","rkpcZaajBz","rkpcZhtf","rkpcZhtfBz","rkpcBgmfnet","rkpcBgmfnetBz",
            "rkpcJzgmsfzhmcch","rkpcZdmlp","rkpcQlfqdz","rkpcCdry","rkpcCdmj","rkpcGzhypx","rkpcCcjf"],
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
            header: "rkpcId",
            dataIndex: "rkpcId",
            hidden: true,
            sortable: true,
            width: 80
        }, {
            header: "总户数",
            dataIndex: "rkpcZhs",
            sortable: true,
            width: 100
        }, {
            header: "总人数",
            dataIndex: "rkpcZrs",
            sortable: true,
            width: 100
        }, {
            header: "常驻户口待定合计",
            dataIndex: "czhkddhj",
            sortable: true,
            width: 150,
            renderer : function(v, meta, record){
                return parseInt(record.get("rkpcCzwlf")) + parseInt(record.get("rkpcCswbhk"))
                    + parseInt(record.get("rkpcCzhkQt"));
            }
        }, {
            header: "常驻户口待定解决合计",
            dataIndex: "czhkddjjhj",
            sortable: true,
            width: 150,
            renderer : function(v, meta, record){
                return parseInt(record.get("rkpcCzwlfJjs")) + parseInt(record.get("rkpcCswbhkJjs"))
                    + parseInt(record.get("rkpcCzhkQtJjs"));
            }
        }, {
            header: "暂住人口合计",
            dataIndex: "zzrkhj",
            sortable: true,
            width: 150,
            renderer : function(v, meta, record){
                return parseInt(record.get("rkpcZzrkJzbnys")) + parseInt(record.get("rkpcZzrkXdzzrks"));
            }
        }, {
            header: "数据单位",
            dataIndex: "gsdw",
            sortable: true,
            width: 150,
            renderer : function(value, meta, record){
                return Gnt.ux.Dict.getDictLable("DW", value);
            }
        }, {
            header: "创建时间",
            dataIndex: "rkpcCreateDate",
            sortable: true,
            width: 150
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
                selectApplyno = selRes.data.rkpcId;
            },
            rowdblclick: function (g, rowIndex, e) {
                var r = g.store.getAt(rowIndex);

                rkPcModify_window.show();
                rkPcModify_window.setSelRes(r.data)
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
                text: '新增普查',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    rkPcModify_window.show();
                    rkPcModify_window.setSelRes(null);
                }
            }),
            new Ext.Button({
                text: '查询普查数据',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    queryry();
                }
            }),
            new Ext.Button({
                text: '生成报表',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    parent.openWorkSpace('yw/qgRkpcBb.jsp',  "人口普查报表", "bb",null,null,true);
                }
            }),
            new Ext.Button({
                text: '重置表单',
                minWidth: 75,
                id: 'queryBtn',
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

    var rkPcModify_window = new Gnt.ux.SelectRkpcModify({
        returnTitleText: '',
        callback: function (optype, data) {
            var that = this;
            if (optype == 'xgzl') {
                Ext.Msg.wait("正在保存，请稍后...");
                that.rkpcPanel.form.submit({
                    url: "rkpc.do?method=saveQgRkpcxx",
                    method: 'POST',
                    params: data,
                    //waitMsg: '正在执行操作，请等待...',
                    success: function (form, action) {
                        Ext.Msg.hide();
                        alert("数据保存成功！");
                        ryCommonStore.reload();
                        that.hide();
                    },
                    failure: function (form, action) {
                        Ext.Msg.hide();
                        showError(action.result.message);
                        that.hide();
                    }
                });
            }
            if (optype == 'gb') {
                ryCommonStore.reload();
            }
        }
    });

});
