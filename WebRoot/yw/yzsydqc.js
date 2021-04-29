var pagesize = 20;
var selRes = null;
var selRe = null;
var qrselRes = null;
var zyqrselRes = null;
var dzyxqrselRes = null;
var _postParams = null;
var qcryGrid = null;
var fnQueryFs = null;
var czrkGrid = null;
var jtcyGrid = null;
var tabs = null;

//利用IFRAME填充容器
Ext.ux.IFrameComponent = Ext.extend(Ext.BoxComponent, {
    initComponent: function () {
        Ext.BoxComponent.superclass.initComponent.call(this);
    },
    onRender: function (ct, position) {
        //注意：页面文件必须遵循本书规范，否则就可能发生页面不能打开的错误
        var id = 'iframe-' + this.id;
        this.el = ct.createChild({
            tag: 'iframe',
            closable: true,
            id: id,
            frameBorder: 0,
            src: this.url
        });
        Ext.fly(id).on("load", function () {
            (function () {

            }).defer(500);
        })
    }
});

//打开指定工作区
function createWorkSpace(isclose, url, name, key, desc, parm) {
    p = new Ext.ux.IFrameComponent({
        xtype: 'panel',
        id: key,
        url: url,
        closable: isclose,
        frame: false,
        iconCls: 'otherfile',
        title: name,
        tabTip: desc ? desc : name
    });

    return p;
}

function openWorkSpaceBeforeClose(tabs, isclose, url, name, key, desc, parm) {
    //var tabs = Ext.getCmp("tabs");
    //如果文件已经打开，那么设置为活动分页，并返回
    if (tabs.findById(key)) {
        tabs.remove(tabs.findById(key));
    }

    var p = createWorkSpace(isclose, url, name, key, desc, parm);
    //添加分页，并且设置为活动分页
    tabs.add(p);
    tabs.setActiveTab(p);
    return;
}

function closeActiveWorkSpace(jsonData, tab_key) {
    var tab = tab_key ? tabs.getItem(tab_key) : tabs.getActiveTab();
    if (tab)
        tabs.remove(tab);
}

//释放iframe占用资源
function fixIFrame(o, p) {
    var iFrame = p.getEl().dom;
    if (iFrame.src) {
        iFrame.src = "javascript:false";
    }
}

var u = null;
Ext.onReady(function () {
    Ext.QuickTips.init();

    Gnt.ux.Dict.loadDict(['CS_HLX', 'CS_XB', 'CS_JTGX', 'CS_MZ', 'CS_HYZK', 'CS_XX','CS_LSBZ', 'CS_QYLDYY'], function () {
    });

    // 办结状态
    var bjzt = new Ext.data.SimpleStore({
        id: 0,
        fields: [{
            name: 'code',
            mapping: 0
        }, {
            name: 'name',
            mapping: 1
        }],
        data: [['0', '未办结'], ['1', '已办结']]
    });
    // 办结状态1
    var bjzt1 = new Ext.data.SimpleStore({
        id: 0,
        fields: [{
            name: 'code',
            mapping: 0
        }, {
            name: 'name',
            mapping: 1
        }],
        data: [['3', '请选择'],['0', '未办结'], ['1', '已办结']]
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
        data: [['0', '1-待办结 '], ['3', '2-待报送'], ['5', '3-报送中'], ['1', '4-已报送'], ['2', '已注销'], ['4', '异常待处理']]
    });


    // 准迁证是否长三角一网通办
    var sfcsjtb = new Ext.data.SimpleStore({
        id: 0,
        fields: [{
            name: 'code',
            mapping: 0
        }, {
            name: 'name',
            mapping: 1
        }],
        data: [['0', '否'], ['1', '是']]
    });


    // 准迁证推送到第三方状态
    var isStatus = new Ext.data.SimpleStore({
        id: 0,
        fields: [{
            name: 'code',
            mapping: 0
        }, {
            name: 'name',
            mapping: 1
        }],
        data: [['0', '不报送'], ['1', '已报送'], ['2', '待报送'], ['4', '未打印准迁证']]
    });


    //查询form表单
    var ryQueryFs = new Gnt.ux.GntForm({
        title: '',
        height: 90,
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
                    name: 'sqr_xm',
                    fieldLabel: '姓名'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0',
                items: [{
                    xtype: 'textfield',
                    anchor: '100%',
                    name: 'sqr_gmsfhm',
                    fieldLabel: '身份证号码'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'isstatus',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '是否推送',
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
                    store: tszt
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'sfbj',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '是否办结',
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
                    store: bjzt
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
                text: '查看详情',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    var res = selRe;
                    if (res == null) {
                        Ext.Msg.alert("提示", "必须选择需要查看的！");
                        return;
                    } else {
                        var ZjywZqzxx_Modify_window = new Gnt.ux.SelectZjywZqzxxModify({
                            returnTitleText: ''
                        });
                        ZjywZqzxx_Modify_window.show();
                        ZjywZqzxx_Modify_window.setSelRes(selRe.data)
                    }


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
            }),
            new Ext.Button({
                text: '老常口已办结',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    var res = selRe;
                    if (res == null) {
                        Ext.Msg.alert("提示", "必须选择需要修改的！");
                        return;
                    }
                    var data = res.data;
                    var subdata = {
                        ywlsh: data.ywlsh,
                        issfbj: '1'
                    }
                    if (window.confirm("您确定老常口已经办结了吗？")) {
                        Gnt.submit(
                            subdata,
                            "yw/zqz.do?method=updateZqzXx",
                            "请稍后...",
                            function (jsonData, params) {
                                showInfo("老常口已办结成功！", function () {
                                    //关闭当前窗口 parent.closeActiveWorkSpace(jsonData);
                                    queryry();
                                });
                            }
                        );
                    }
                }
            }),
            new Ext.Button({
                text: '注销',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    var res = selRe;
                    if (res == null) {
                        Ext.Msg.alert("提示", "必须选择需要注销的！");
                        return;
                    }
                    var data = res.data;

                    showInput("确定注销选择信息，请输入注销原因！", "", function (value) {
                        if (value == "") {
                            Ext.Msg.alert("提示", "必须填写注销原因！");
                            return;
                        }
                        Gnt.submit(
                            {
                                ywlsh: data.ywlsh,
                                status: '2',
                                zxyy: value
                            },
                            "yw/zqz.do?method=updateZqzXx",
                            "正在注销已办理信息，请稍后...",
                            function (jsonData, params) {
                                showInfo("注销成功！", function () {
                                    //关闭当前窗口 parent.closeActiveWorkSpace(jsonData);
                                    Ext.each(res, function (r) {
                                        grid.store.remove(r);
                                    });
                                });
                            }
                        );
                    });
                }
            }),
            new Ext.Button({
                text: '重新推送',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    updateIsStatus("updateZqzXx",selRe);
                }
            })
        ]
    });

    //查询form表单
    ryQRQueryFs = new Gnt.ux.GntForm({
        title: '',
        height: 120,
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
                    name: 'czr_xm',
                    fieldLabel: '姓名'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0',
                items: [{
                    xtype: 'textfield',
                    anchor: '100%',
                    name: 'czr_gmsfhm',
                    fieldLabel: '身份证号码'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'sfbj',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '是否办结',
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
                    store: bjzt1
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    anchor: '100%',
                    xtype:'datefield',
                    format: 'Ymd',
                    anchor: '100%',
                    name: 'slsjStart',
                    fieldLabel: '受理时间起：'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    anchor: '100%',
                    xtype:'datefield',
                    format: 'Ymd',
                    anchor: '100%',
                    name: 'slsjEnd',
                    fieldLabel: '受理时间止：'
                }]
            }]
        }],
        buttons: [
            new Ext.Button({
                text: '查询数据',
                minWidth: 75,
                //id: 'queryBtn1',
                handler: function () {
                    queryryQr();
                }
            }), new Ext.Button({
                text: '查看详情',
                minWidth: 75,
                handler: function () {
                    var res = qrselRes;
                    if (res == null) {
                        Ext.Msg.alert("提示", "必须选择需要查看的！");
                        return;
                    } else {
                        var ZjywQyzxx_Modify_window = new Gnt.ux.SelectZjywQyzxxModify({
                            returnTitleText: ''
                        });
                        ZjywQyzxx_Modify_window.show();
                        ZjywQyzxx_Modify_window.setSelRes(qrselRes.data)
                    }


                }
            }),
            new Ext.Button({
                text: '重置表单',
                minWidth: 75,
                //id: 'queryBtn1',
                id: 'queryBtn',
                handler: function () {
                    ryQRQueryFs.form.reset();
                    queryryQr();
                }
            })
        ]
    });


    //查询form表单
    zyqrQueryFs = new Gnt.ux.GntForm({
        title: '',
        height: 120,
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
                    name: 'sqrxm',
                    fieldLabel: '姓名'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0',
                items: [{
                    xtype: 'textfield',
                    anchor: '100%',
                    name: 'sqrgmsfhm',
                    fieldLabel: '身份证号码'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'isstatus',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '是否报送',
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
                    store: isStatus
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'sfcsjtb',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '是否长三角通办',
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
                    value: '1',
                    store: sfcsjtb
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'sfqyz',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '是否迁移证',
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
                    store: sfcsjtb
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'sfbj',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '是否办结',
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
                    store: bjzt
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    anchor:'100%',
                    xtype:'dict_combox',
                    dict:'VisionType=CS_QYLDYY',
                    value:"",
                    name:'qyyy',
                    maxLength:40,
                    hiddenName:'qyyy',
                    fieldLabel:'迁移（流动）原因'
                }]
            }]
        }],
        buttons: [
            new Ext.Button({
                text: '查询数据',
                minWidth: 75,
                //id: 'queryBtn1',
                handler: function () {
                    queryZqyr();
                }
            }),new Ext.Button({
                text: '查看详情',
                minWidth: 75,
                //id: 'queryBtn1',
                handler: function () {
                    var res = zyqrselRes;
                    if (res == null) {
                        Ext.Msg.alert("提示", "必须选择需要查看的！");
                        return;
                    } else {
                        var KjZqzxx_Modify = new Gnt.ux.SelectKjZqzxxModify({
                            returnTitleText: ''
                        });
                        KjZqzxx_Modify.show();
                        KjZqzxx_Modify.setSelRes(zyqrselRes.data)
                    }
                }
            }),
            new Ext.Button({
                text: '重置表单',
                minWidth: 75,
                //id: 'queryBtn1',
                id: 'queryBtn',
                handler: function () {
                    zyqrQueryFs.form.reset();
                    queryZqyr();
                }
            }),
            new Ext.Button({
                text: '老常口数据补录',
                minWidth: 75,
                //id: 'queryBtn1',
                id: 'queryBtn',
                handler: function () {
                    var res = zyqrselRes;
                    if (res == null) {
                        Ext.Msg.alert("提示", "必须选择需要查看的！");
                        return;
                    } else {
                        sjZqzxxModify_window.show();
                        sjZqzxxModify_window.setSelRes(zyqrselRes.data)
                    }
                }
            }),
            new Ext.Button({
                text: '手动推送',
                minWidth: 75,
                id: 'queryBtn',
                handler: function () {
                    updateIsStatus("updateSjHjspZqzxx",zyqrselRes);
                }
            })
        ]
    });

    //查询form表单
    dzyxqrQueryFs = new Gnt.ux.GntForm({
        title: '',
        height: 120,
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
                    name: 'sqrxm',
                    fieldLabel: '姓名'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:0 0 0 0',
                items: [{
                    xtype: 'textfield',
                    anchor: '100%',
                    name: 'sqrgmsfhm',
                    fieldLabel: '身份证号码'
                }]
            }, {
                columnWidth: .25,
                layout: 'form',
                bodyStyle: 'padding:5 5 0 0 ',
                items: [{
                    hiddenName: 'sfcsjtb',
                    anchor: '100%',
                    xtype: 'combo',
                    fieldLabel: '是否长三角通办',
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
                    value: '1',
                    store: sfcsjtb
                }]
            }]
        }],
        buttons: [
            new Ext.Button({
                text: '查询数据',
                minWidth: 75,
                handler: function () {
                    querydzyxqr();
                }
            }),new Ext.Button({
                text: '查看详情',
                minWidth: 75,
                handler: function () {
                    var res = dzyxqrselRes;
                    if (res == null) {
                        Ext.Msg.alert("提示", "必须选择需要查看的！");
                        return;
                    } else {
                        var dzyxqrZqzxx_Info = new Gnt.ux.SelectDzyxqrZqzxxInfo({
                            returnTitleText: ''
                        });
                        dzyxqrZqzxx_Info.show();
                        dzyxqrZqzxx_Info.setSelRes(dzyxqrselRes.data);
                    }
                }
            }),
            new Ext.Button({
                text: '重置表单',
                minWidth: 75,
                handler: function () {
                    dzyxqrQueryFs.form.reset();
                    querydzyxqr();
                }
            }),
            new Ext.Button({
                text: '新增',
                minWidth: 75,
                handler: function () {
                    // selRes = g.store.getAt(rowIndex);
                    // var url = "yw/qc_new1.jsp?formdq="
                    //     + selRes.data.qcd_hkdjjg_gajgjgdm + "&todq=" + selRes.data.qcd_ssxqdm + "&qrd_ssxqdm=" + selRes.data.qrd_ssxqdm + "&sqr_gmsfhm=" + selRes.data.sqr_gmsfhm + "&ywlsh=" + selRes.data.ywlsh + "&rkurl=" + rkurl;
                    var url = "yw/qrsp.jsp?formdq="+qcdqbm+"&todq="+qcdqbm;
                    openWorkSpaceBeforeClose(tabs, true, url, "大专院校迁入新增", "kdsqccl");
                    // var dzyxqrZqzxx_Modify = new Gnt.ux.SelectDzyxqrZqzxxAdd({
                    //     returnTitleText: '',
                    //     callback: function (optype, data) {
                    //         var that = this;
                    //         if (optype == 'add') {
                    //             Gnt.submit(
                    //                 {
                    //                     'addDzyxQrInfo':Ext.encode(data),
                    //                     'qcdqbm':qcdqbm
                    //                 },
                    //                 "yw/zqz.do?method=insertDzyxQr",
                    //                 "正在保存，请稍后...",
                    //                 function (jsonData) {
                    //                     Ext.Msg.hide();
                    //                     alert("新增数据成功！");
                    //                 },
                    //                 function (jsonData) {
                    //                     Ext.Msg.hide();
                    //                     alert("新增数据失败！");
                    //                 });
                    //
                    //         }
                    //     }
                    // });
                    // dzyxqrZqzxx_Modify.show();
                }
            }),
            new Ext.Button({
                text: '注销',
                minWidth: 75,
                handler: function () {
                    //删除大专院校迁入
                    updateIsStatus("deleteZqzXx",dzyxqrselRes);
                }
            }),
            new Ext.Button({
                text: '打印存根',
                minWidth: 75,
                handler: function () {
                    //updateIsStatus("updateSjHjspZqzxx",dzyxqrselRes);
                    var res = dzyxqrselRes;
                    if (res == null) {
                        Ext.Msg.alert("提示", "必须选择需要打印的数据！");
                        return;
                    } else{
                        LODOP = getLodop();
                        LODOP.PRINT_INITA(0,0,801,800,"qyzcgv1.1");
                        LODOP.SET_PRINT_PAGESIZE(0,0,0,"A4");
                        LODOP.SET_PRINT_STYLE("FontName","方正宋体-人口信息");
                        LODOP.ADD_PRINT_TEXT(37,193,310,31,"大中专学生户口准迁证存根");
                        LODOP.SET_PRINT_STYLEA(0,"FontName","宋体");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",17);
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.SET_PRINT_STYLEA(0,"Bold",1);
                        LODOP.ADD_PRINT_TEXT(95,423,68,20,"业务编号");
                        LODOP.ADD_PRINT_TEXT(95,497,131,20,res.data.zqid);
                        LODOP.ADD_PRINT_TEXT(130,130,70,20,"姓      名");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(130,250,60,20,"性别");
                        LODOP.ADD_PRINT_TEXT(130,411,140,20,"公民身份证件编号");
                        LODOP.ADD_PRINT_TEXT(170,130,70,20,res.data.qyrxm1);
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(170,250,60,20,Gnt.ux.Dict.getDictLable('CS_XB', res.data.qyrxb1));
                        LODOP.ADD_PRINT_TEXT(170,411,140,20,res.data.qyrgmsfhm1);
                        LODOP.ADD_PRINT_TEXT(227,128,70,20,"准迁原因");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(215,244,320,40,Gnt.ux.Dict.getDictLable('CS_QYLDYY', res.data.qyyy));
                        LODOP.ADD_PRINT_TEXT(303,132,70,20,"原住址");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(295,234,373,66,res.data.qyrzzxz);
                        LODOP.ADD_PRINT_TEXT(406,131,70,20,"迁入地址");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(399,238,369,57,res.data.qrdxz);
                        LODOP.ADD_PRINT_TEXT(484,131,70,20,"迁入单位");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(484,240,320,20,res.data.qyrhkdjjg);
                        LODOP.ADD_PRINT_TEXT(537,129,70,20,"准迁证编号");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(534,238,320,20,res.data.zjbh);
                        LODOP.ADD_PRINT_TEXT(580,129,70,20,"签发日期");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(579,239,320,20,res.data.qfrq);
                        LODOP.ADD_PRINT_LINE(120,100,620,101,0,1);
                        LODOP.ADD_PRINT_LINE(120,100,121,630,0,1);
                        LODOP.ADD_PRINT_LINE(121,630,621,631,0,1);
                        LODOP.ADD_PRINT_LINE(160,100,161,630,0,1);
                        LODOP.ADD_PRINT_LINE(200,100,201,630,0,1);
                        LODOP.ADD_PRINT_LINE(273,100,274,630,0,1);
                        LODOP.ADD_PRINT_LINE(378,100,379,630,0,1);
                        LODOP.ADD_PRINT_LINE(468,100,469,630,0,1);
                        LODOP.ADD_PRINT_LINE(525,100,526,630,0,1);
                        LODOP.ADD_PRINT_LINE(565,100,566,630,0,1);
                        LODOP.ADD_PRINT_LINE(620,100,621,630,0,1);
                        LODOP.ADD_PRINT_LINE(120,220,620,221,0,1);
                        LODOP.ADD_PRINT_LINE(120,330,199,331,0,1);
                        LODOP.PRINT_DESIGN();
                    }
                }
            })
        ]
    });

    var hjspGrid = new Gnt.ux.KdqHjspywGrid({
        region: 'center',
        id: 'hjspGrid',
        title: '',
        height: 200,
        border:false,
        margins:'0 0 0 5',
    	frame:false,
        border:true,
        frame:true,
//        viewConfig : {
//        	enableRowBody : false,
//        	showPreview : false
//    	},
        pagesize: 20,
        listeners: {
            rowclick: function (g, rowIndex, e) {
                selRe = g.store.getAt(rowIndex);
            },
            rowdblclick: function (g, rowIndex, e) {
                selRes = g.store.getAt(rowIndex);
                var url = "yw/qc_new1.jsp?formdq="
                    + selRes.data.qcd_hkdjjg_gajgjgdm + "&todq=" + selRes.data.qcd_ssxqdm + "&qrd_ssxqdm=" + selRes.data.qrd_ssxqdm + "&sqr_gmsfhm=" + selRes.data.sqr_gmsfhm + "&ywlsh=" + selRes.data.ywlsh + "&rkurl=" + rkurl;
                openWorkSpaceBeforeClose(tabs, true, url, "省外迁出处理", "kdsqccl");
            }
        },
        url: 'yw/zqz.do?method=queryZqzXx',
        buttons: [
            new Ext.Button({
                text: '刷新',
                minWidth: 75,
                handler: function () {
                    hjspGrid.store.load({params: {start: 0, limit: 20}});
                }
            })
        ]
    });


    var hjspQrGrid = new Gnt.ux.KdqqrHjspywGrid({
        region: 'center',
        id: 'hjspQrGrid',
        title: '',
        height: 200,
        showPaging: true,
        pagesize: 20,
        listeners: {
            rowclick: function (g, rowIndex, e) {
                qrselRes = g.store.getAt(rowIndex);
            },
            rowdblclick: function (g, rowIndex, e) {
                qrselRes = g.store.getAt(rowIndex);
                var gmsfhm = qrselRes.data.czr_gmsfhm;
                var qyzbh = encodeURI(qrselRes.data.qyzbh);
                var url = "yw/qc_new1.jsp?qyzDbJump=000&qyzDbGmsfhm=" + gmsfhm + "&qyzDbQyzbh=" + qyzbh + "&rkurl=" + rkurl;
                openWorkSpaceBeforeClose(tabs, true, url, "跨地市迁出处理", "kdsqccl");
            }
        },
        url: 'yw/qyz.do?method=queryQyzXx',
        buttons: [
            new Ext.Button({
                text: '刷新',
                minWidth: 75,
                handler: function () {
                    hjspQrGrid.store.load({params: {start: 0, limit: 20}});
                }
            })
        ]
    });

    var zyqrHjspywGrid = new Gnt.ux.ZyqrHjspywGrid({
        region: 'center',
        id: 'hjspZyQrGrid',
        title: '',
        height: 200,
        showPaging: true,
        pagesize: 20,
        listeners: {
            rowclick: function (g, rowIndex, e) {
            	zyqrselRes = g.store.getAt(rowIndex);
            },
            rowdblclick: function (g, rowIndex, e) {
            	zyqrselRes = g.store.getAt(rowIndex);
            }
        },
        url: 'yw/zqz.do?method=querySjHjspZqzxx',
        buttons: [
            new Ext.Button({
                text: '刷新',
                minWidth: 75,
                handler: function () {
                    zyqrHjspywGrid.store.load({params: {start: 0, limit: 20}});
                }
            })
        ]
    });

    var dzyxqrGrid = new Gnt.ux.DzyxqrHjspywGrid({
        region: 'center',
        title: '',
        height: 200,
        showPaging: true,
        pagesize: 20,
        listeners: {
            rowclick: function (g, rowIndex, e) {
                dzyxqrselRes = g.store.getAt(rowIndex);
            },
            rowdblclick: function (g, rowIndex, e) {
                dzyxqrselRes = g.store.getAt(rowIndex);
            }
        },
        url: 'yw/kdqqy.do?method=queryDzyxSjHjspZqzxx',
        buttons: [
            new Ext.Button({
                text: '刷新',
                minWidth: 75,
                handler: function () {
                    zyqrHjspywGrid.store.load({params: {start: 0, limit: 20}});
                }
            })
        ]
    });

    var p1 = new Ext.Panel({
        layout: 'border',
        items: [
            ryQueryFs,
            hjspGrid
        ]
    });

    var p2 = new Ext.Panel({
        layout: 'border',
        items: [
            ryQRQueryFs,
            hjspQrGrid
        ]
    });

    var p3 = new Ext.Panel({
        layout: 'border',
        items: [
            zyqrQueryFs,
            zyqrHjspywGrid
        ]
    });

    var p4 = new Ext.Panel({
        layout: 'border',
        items: [
            dzyxqrQueryFs,
            dzyxqrGrid
        ]
    });


    //定义分页面板
    tabs = new Ext.TabPanel({
        id: 'tabs',
        activeTab: 0,
        width: 500,
        height: 250,
        layoutOnTabChange: true,
        resizeTabs: false,
        enableTabScroll: true,
        plain: false,
        listeners: {
            //在关闭分页的时候，调用函数释放iframe占用资源
            beforeremove: fixIFrame.createDelegate(this)
        },
        defaults: {
            autoScroll: false,
            frame: false,
            shim: false,
            xtype: 'panel'
        },
        items: [{
            //本页不允许关闭
            closable: false,
            title: '迁往省外',
            layout: 'fit',
            tabTip: '',
            items: [p1],
            listeners: {// 添加监听器，点击此页面的tab时候要重新加载（刷新功能）
                activate: function () {
                    var p = ryQueryFs.getForm().getValues();
                    hjspGrid.store.baseParams = p;
                    hjspGrid.store.load({params: {start: 0, limit: 20}});
                }
            }
        }, {
            //本页不允许关闭
            closable: false,
            title: '省外迁入',
            layout: 'fit',
            tabTip: '',
            items: [p2],
            listeners: {// 添加监听器，点击此页面的tab时候要重新加载（刷新功能）
                activate: function () {
                    var p1 = ryQRQueryFs.getForm().getValues();
                    hjspQrGrid.store.baseParams = p1;
                    hjspQrGrid.store.load({params: {start: 0, limit: 20}});
                }
            }
        }, {
            //本页不允许关闭
            closable: false,
            title: '安徽开具准迁证查询',
            layout: 'fit',
            tabTip: '',
            items: [p3],
            listeners: {// 添加监听器，点击此页面的tab时候要重新加载（刷新功能）
                activate: function () {
                    var p1 = zyqrQueryFs.getForm().getValues();
                    zyqrHjspywGrid.store.baseParams = p1;
                    zyqrHjspywGrid.store.load({params: {start: 0, limit: 20}});
                }
            }
        }, {
            //本页不允许关闭
            closable: false,
            title: '大专院校迁入查询',
            layout: 'fit',
            tabTip: '',
            items: [p4],
            listeners: {// 添加监听器，点击此页面的tab时候要重新加载（刷新功能）
                activate: function () {
                    var p1 = dzyxqrQueryFs.getForm().getValues();
                    dzyxqrGrid.store.baseParams = p1;
                    dzyxqrGrid.store.load({params: {start: 0, limit: 20}});
                }
            }
        }]
    });

    new Ext.Viewport({
        layout: 'fit',
        id: 'vp',
        items: [
            tabs
        ]
    });

    var kds_config = null;

    hjspGrid.store.baseParams = {
        spywid: getQueryParam("spywid")
    };


    if (getQueryParam("jumpyzsydqc") == 1) {
        var store = hjspGrid.store;
        //add By zjm 20210208
        //从后台默认查询是否办结字段，移到前台用于常口跳转过来查询  
        store.baseParams.sfbj = 0;
//        store.baseParams.isstatus = 0;
        store.on("load", function (store) {
            if (store.data.length > 0) {
                for (var i = 0; i < store.data.length; i++) {
                    var res = store.getAt(i);
                    var spywidTemp = res.data.spywid;
                    if (spywidTemp == getQueryParam("spywid")) {
                        hjspGrid.fireEvent("rowdblclick", hjspGrid, i);//rowdblclick
                    }
                }

            }
        }, hjspGrid);
    }

    function queryry() {
        var p = ryQueryFs.getForm().getValues();
        hjspGrid.store.baseParams = p;
        hjspGrid.store.load({params: {start: 0, limit: 20}})
    }

    function queryryQr() {
        var p = ryQRQueryFs.getForm().getValues();
        hjspQrGrid.store.baseParams = p;
        hjspQrGrid.store.load({params: {start: 0, limit: 20}})
    }

    function queryZqyr() {
        var p = zyqrQueryFs.getForm().getValues();
        zyqrHjspywGrid.store.baseParams = p;
        zyqrHjspywGrid.store.load({params: {start: 0, limit: 20}})
    }

    function querydzyxqr() {
        var p = dzyxqrQueryFs.getForm().getValues();
        dzyxqrGrid.store.baseParams = p;
        dzyxqrGrid.store.load({params: {start: 0, limit: 20}})
    }

    function updateIsStatus(method,selRe) {
        var res = selRe;
        var subdata = null;
        if (res == null) {
            Ext.Msg.alert("提示", "必须选择需要修改的！");
            return;
        }
        var data = res.data;
        if (method == "updateZqzXx") {
            subdata = {
                ywlsh: data.ywlsh,
                status: '0'
            }
            var isstatus = data.isstatus;
            if (isstatus == 1) {
                Ext.Msg.alert("提示", "该数据已推送过，不需要手动推送！");
                return;
            }
            Gnt.submit(
                subdata,
                "yw/zqz.do?method=" + method,
                "正在初始化推送状态，请稍后...",
                function (jsonData, params) {
                    showInfo("初始化推送状态成功！", function () {
                        //关闭当前窗口 parent.closeActiveWorkSpace(jsonData);
                        queryry();
                    });
                }
            );
        }else if (method == "deleteZqzXx") {
            subdata = {
                spywid: data.spywid,
                dqbm:qcdqbm,
                status: '2'
            }
            // var isstatus = data.isstatus;
            // if (isstatus == 1) {
            //     Ext.Msg.alert("提示", "该数据已推送过，不需要手动推送！");
            //     return;
            // }
            Gnt.submit(
                subdata,
                "yw/kdqqy.do?method=dzyxZqzZf",
                "正在更新状态，请稍后...",
                function (jsonData, params) {
                    showInfo("状态更新成功！", function () {
                        //关闭当前窗口 parent.closeActiveWorkSpace(jsonData);
                        querydzyxqr();
                    });
                }
            );

        } else {
            subdata = {
                zqid: data.zqid,
                status: '2',
                issfcsjtb: '1'
            }
            var isstatus = data.isstatus;
            if (isstatus == 1) {
                Ext.Msg.alert("提示", "该数据已推送过，不需要手动推送！");
                return;
            }
            Gnt.submit(
                subdata,
                "yw/zqz.do?method=" + method,
                "正在初始化推送状态，请稍后...",
                function (jsonData, params) {
                    showInfo("初始化推送状态成功！", function () {
                        //关闭当前窗口 parent.closeActiveWorkSpace(jsonData);
                        queryry();
                    });
                }
            );

        }
        // Gnt.submit(
        //     subdata,
        //     "yw/zqz.do?method=" + method,
        //     "正在初始化推送状态，请稍后...",
        //     function (jsonData, params) {
        //         showInfo("初始化推送状态成功！", function () {
        //             //关闭当前窗口 parent.closeActiveWorkSpace(jsonData);
        //             queryry();
        //         });
        //     }
        // );
    }

    var sjZqzxxModify_window = new Gnt.ux.SelectSjZqzxxUpdateModify({
        returnTitleText: '',
        callback: function (optype, data) {
            var that = this;
            if (optype == 'xgzl') {
                Ext.Msg.wait("正在保存，请稍后...");
                that.sjZqzPanel.form.submit({
                    url: "yw/zqz.do?method=updateSjHjspZqzxx",
                    method: 'POST',
                    params: data,
                    //waitMsg: '正在执行操作，请等待...',
                    success: function (form, action) {
                        Ext.Msg.hide();
                        alert("数据保存成功！");
                        queryZqyr();
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

            }
        }
    });
});
