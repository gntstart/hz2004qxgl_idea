var myMask = new Ext.LoadMask(Ext.getBody(), {msg: "操作执行中，请等待..."});
var selectApplyno = null;
var selRes = null;
Ext.onReady(function () {
    Gnt.ux.Dict.loadDict(['CS_QCZXLB','CS_XB','CS_KJFW','CS_LQFS'],function(){});
    Ext.QuickTips.init();
    // 下拉状态
    var sfbz = new Ext.data.SimpleStore({
        id: 0,
        fields: [{
            name: 'code',
            mapping: 0
        }, {
            name: 'name',
            mapping: 1
        }],
        data: [['1', '待办理'], ['2', '已办结']]
    });

    // 审核状态
    var sljg = new Ext.data.SimpleStore({
        id: 0,
        fields: [{
            name: 'code',
            mapping: 0
        }, {
            name: 'name',
            mapping: 1
        }],
        data: [['0', '通过'], ['1', '不通过']]
    });

    // 推送到公安内网状态
    var tszt = new Ext.data.SimpleStore({
        id: 0,
        fields: [{
            name: 'code',
            mapping: 0
        }, {
            name: 'name',
            mapping: 1
        }],
        data: [['0', '通过'], ['1', '不通过']]
    });

    var ryCommonStore = new Ext.data.JsonStore({
        url: 'yw/ywtb.do?method=queryYwtbXx',
        root: 'list',
        id: 'applyno',
        totalProperty: 'totalCount',
        fields: ["applyno", "username", "licenseno", "mobile",
            "sldwcode", "sldwname", "content", "itemname",
            "begintime", "kjfw", "lqfs", "sjrusername",
            "sjraddress", "sjrmobile", "bljg", "blyj", "isstatus", "cjsj", "xgsj","blFile","btgsx_one","btgsx_two","btgsx_three","btgsx_four","btgsx_three_info"],
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
            header: "applyno",
            dataIndex: "applyno",
            hidden: true,
            sortable: true,
            width: 80
        }, {
            header: "姓名",
            dataIndex: "username",
            sortable: true,
            width: 80
        }, {
            header: "身份证",
            dataIndex: "licenseno",
            sortable: true,
            width: 150
        }, {
            header: "手机号",
            dataIndex: "mobile",
            sortable: true,
            width: 100
        }, {
            header: "受理单位",
            dataIndex: "sldwname",
            sortable: true,
            width: 100
        }, {
            header: "事项名称",
            dataIndex: "itemname",
            sortable: true,
        }, {
            header: "申请时间",
            dataIndex: "begintime",
            sortable: true,
            width: 150
        }, {
            header: "开具范围",
            dataIndex: "kjfw",
            sortable: true,
            renderer: function (value) {
                if (value==1){
                    return '户口登记项目内容变更更正证明';
                }else if (value==2){
                    return '注销户口证明';
                }else if (value==3){
                    return '曾经同户人员亲属关系证明';
                }else if (value==4){
                    return '法律法规规定的其他情形';
                }else{
                    return value;
                }
            }
        }, {
            header: "领取方式",
            dataIndex: "lqfs",
            sortable: true,
            renderer: function (value) {
                if (value==1){
                    return '网上下载';
                }else if (value==2){
                    return '物流快递';
                }else if (value==3){
                    return '线下自取';
                }else{
                    return value;
                }
            }
        }, {
            header: "审核状态",
            dataIndex: "bljg",
            sortable: true,
            renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                if (value == "0") return "通过";
                if (value == "1") return "不通过";
            }
        }, {
            header: "办理状态",
            dataIndex: "isstatus",
            sortable: true,
            renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
             
                if (value == "1") return "待办理";
                if (value == "2") return "已办结";
            }
        }
    ]);

    var ryGrid = new Ext.grid.GridPanel({
        store: ryCommonStore,
        region: 'center',
        view: new Ext.grid.GridView({
            //forceFit:true,
            //autoFill:true,
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
                selectApplyno = selRes.data.applyno;
            },
            rowdblclick: function (g, rowIndex, e) {
                var r = g.store.getAt(rowIndex);
                var ywtModify_window = new Gnt.ux.SelectYwtModify({
                    returnTitleText: '',
                    data: r.data,
                    applyno: r.data.applyno/*,
            		data:res[0].data*/,
                    callback: function (optype, data) {
                        var that = this;
                        if (optype == 'xgzl') {
                            Ext.Msg.wait("正在保存，请稍后...");
                            that.ywtPanel.form.submit({
                                url: "yw/ywtb.do?method=updateYwtbXx",
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

                        } else if (optype == 'chsq') {
                            Ext.Msg.wait("正在撤回申请，请稍后...");
                            that.ywtPanel.form.submit({
                                url: "yw/ywtb.do?method=updateYwtbXx",
                                method: 'POST',
                                params: data,
                                //waitMsg: '正在执行操作，请等待...',
                                success: function (form, action) {
                                    Ext.Msg.hide();
                                    alert("撤回申请成功！");
                                    ryCommonStore.reload();
                                    that.hide();
                                },
                                failure: function (form, action) {
                                    Ext.Msg.hide();
                                    that.hide();
                                    showError(action.result.message);
                                }
                            });
                        }
                    }
                });
                ywtModify_window.show();
            }
        },
        bbar: new Ext.PagingToolbar({
            pageSize: 20,
            store: ryCommonStore,
            displayInfo: true
        })
    });

    //查询form表单
    ryQueryFs = new Gnt.ux.GntForm({
        title: '一网通数据列表',
        height: 150,
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
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0',
                items: [{
                    xtype: 'textfield',
                    anchor: '100%',
                    name: 'username',
                    fieldLabel: '姓名'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0',
                items: [{
                    xtype: 'textfield',
                    anchor: '100%',
                    name: 'licenseno',
                    fieldLabel: '身份证'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0 ',
                items: [{
                    xtype: 'datefield',
                    anchor: '100%',
                    name: 'begintime',
                    format: 'Ymd',
                    fieldLabel: '申请时间开始'
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
                    fieldLabel: '申请时间结束'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'isstatus',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '办理状态',
                    mode: 'local',
                    triggerAction: 'all',
                    valueField: "code",
                    displayField: "name",
                    selectOnFocus: true,
                    emptyText: '请选择',
                    typeAhead: true,
                    forceSelection: true,
                    blankText: '请选择',
                    lazyRender: true,
                    value: '',
                    store: sfbz
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'bljg',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '审核状态',
                    mode: 'local',
                    triggerAction: 'all',
                    valueField: "code",
                    displayField: "name",
                    selectOnFocus: true,
                    emptyText: '请选择',
                    typeAhead: true,
                    forceSelection: true,
                    blankText: '请选择',
                    lazyRender: true,
                    value: '',
                    store: sljg
                }]
            }
            ]
        }],
        buttons: [
            new Ext.Button({
                text: '查询数据',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    queryry();
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
            // new Ext.Button({
            //     text: '上传附件',
            //     minWidth: 75,
            //     id: 'queryBtn',
            //     handler: function () {
            //         if (selectApplyno) {
            //             btnUpload_click('上传附件', selectApplyno, '',function callback() {
            //                 queryry();
            //             });
            //         } else {
            //             alert("请先选择一条有效的数据！");
            //         }
            //
            //     }
            // })
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
});