/**
 * 全国人口普查 弹窗新增修改数据
 *
 */
Gnt.ux.SelectRkpcModify = Ext.extend(Ext.Window, {
    title: '',
    closeAction: 'hide',
    // closable: false,
    resizable: false,
    modal: true,
    width: 900,
    height: 650,
    margins: '5',
    layout: 'border',
    pageSize: 30,
//	autoScroll:true,
    show: function () {
        this.rkpcPanel.getForm().reset();
        Gnt.ux.SelectRkpcModify.superclass.show.call(this);
    },
    resetData: function () {

    },
    setSelRes: function (data) {
        this.rkpcPanel.getForm().setValues(data);
    },
    initComponent: function () {
        var returnTitleText = this.returnTitleText;
        if (!returnTitleText || returnTitleText == "") returnTitleText = "人口普查数据";

        this.returnTitleText = returnTitleText;

        this.setTitle(returnTitleText);
        var data = this.data;
        this.data = data;
        var win = this;
        this.rkpcPanel = new Ext.form.FormPanel({
            closeAction: 'hide',
            modal: true,
            autoScroll: true,
//	        height: 100,
            region: 'center',
            anchor: '100% 100%',
            buttonAlign: 'right',
            labelAlign: 'right',
            title: '',
            frame: true,
            border: false,
            fileUpload: true,
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
                    name: 'rkpcId',
                    xtype: 'hidden'
                },{
                    name: 'rkpcZhs',
                    xtype: 'hidden'
                },{
                    name: 'rkpcZrs',
                    xtype: 'hidden'
                },{
                    name: 'rkpcCreateDate',
                    xtype: 'hidden'
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcXcrks',
                        fieldLabel: '乡村人数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcXcrksBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcRhfls',
                        fieldLabel: '人户分离数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcRhflsBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCzwlf',
                        fieldLabel: '持证未落户数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCzwlfJjs',
                        fieldLabel: '持证未落户解决数'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCzwlfBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCswbhk',
                        fieldLabel: '出生未报户口'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCswbhkJjs',
                        fieldLabel: '出生未报户口解决数'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCswbhkBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCzhkQt',
                        fieldLabel: '其他'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCzhkQtJjs',
                        fieldLabel: '其他解决数'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCzhkQtBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCzhkJjs',
                        fieldLabel: '待定人员解决数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCzhkJjsBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcZzrkJzbnys',
                        fieldLabel: '居住半年以上'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcZzrkJzbnysBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcZzrkXdzzrks',
                        fieldLabel: '新登暂住人口数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcZzrkXdzzrksBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcHkdjCdhkrs',
                        fieldLabel: '重登暂住人口数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcHkdjCdhkrsBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcHkdjYxwxhks',
                        fieldLabel: '应销未销户口数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcHkdjYxwxhksBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcHkdjSwwx',
                        fieldLabel: '死亡未销数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcHkdjSwwxBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcHkdjHkbgxms',
                        fieldLabel: '户口变更更正数'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcHkdjHkbgxmsBz',
                        fieldLabel: '备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcPaxs',
                        fieldLabel: '破案线索(条)'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 50,
                        anchor: '100%',
                        name: 'rkpcPaxsBz',
                        fieldLabel: '破案线索备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcXsaj',
                        fieldLabel: '破获刑事案件(起)'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 50,
                        anchor: '100%',
                        name: 'rkpcXsajBz',
                        fieldLabel: '破获刑事案件备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcZaaj',
                        fieldLabel: '治安案件(起)'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 50,
                        anchor: '100%',
                        name: 'rkpcZaajBz',
                        fieldLabel: '治安案件备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcZhtf',
                        fieldLabel: '抓获逃犯(人)'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 50,
                        anchor: '100%',
                        name: 'rkpcZhtfBz',
                        fieldLabel: '抓获逃犯备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcBgmfnet',
                        fieldLabel: '解救拐卖妇女儿童(人)'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 50,
                        anchor: '100%',
                        name: 'rkpcBgmfnetBz',
                        fieldLabel: '解救拐卖妇女儿童备注'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcJzgmsfzhmcch',
                        fieldLabel: '纠正身份证号码(个)'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcZdmlp',
                        fieldLabel: '装订门楼牌(个)'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcQlfqdz',
                        fieldLabel: '废弃地址(个)'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCdry',
                        fieldLabel: '抽调人员(人)'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCdmj',
                        fieldLabel: '其中民警(人)'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcGzhypx',
                        fieldLabel: '工作会议(次)'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'rkpcCcjf',
                        fieldLabel: '筹措经费(万元)'
                    }]
                }
                ]
            }],
            buttons: [
                new Ext.Button({
                    text: '保存修改',
                    minWidth: 75,
                    id: 'saveBtn_xj',
                    handler: function () {
                        var rootWin = this.findParentByType("rkpcModify_window");
                        var form = rootWin.rkpcPanel;
                        if (!form.getForm().isValid()) {
                            Ext.Msg.alert("提示", "数据校验没有通过，请检查！");
                            return;
                        }
                        var xgzl = form.getForm().getValues();
                        if (rootWin.callback) {
                            rootWin.callback('xgzl', xgzl);
                        }
                    }
                }),
                new Ext.Button({
                    text: '关闭',
                    minWidth: 75,
                    handler: function () {
                        win.hide();
                        var rootWin = this.findParentByType("rkpcModify_window");
                        if (rootWin.callback) {
                            rootWin.callback('gb', null);
                        }
                    }
                })
            ]
        });

        this.items = [this.rkpcPanel];
        Gnt.ux.SelectRkpcModify.superclass.initComponent.call(this);
    }
});
Ext.reg('rkpcModify_window', Gnt.ux.SelectRkpcModify);

