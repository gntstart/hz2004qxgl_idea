/**
 * 全国人口普查 弹窗新增修改数据
 *
 */
Gnt.ux.SelectSjZqzxxUpdateModify = Ext.extend(Ext.Window, {
    title: '',
    closeAction: 'hide',
    // closable: false,
    resizable: false,
    modal: true,
    width: 400,
    height: 300,
    margins: '5',
    layout: 'border',
    pageSize: 30,
//	autoScroll:true,
    show: function () {
        this.sjZqzPanel.getForm().reset();
        Gnt.ux.SelectSjZqzxxUpdateModify.superclass.show.call(this);
    },
    resetData: function () {

    },
    setSelRes: function (data) {
        this.sjZqzPanel.getForm().setValues(data);
    },
    initComponent: function () {
        var returnTitleText = this.returnTitleText;
        if (!returnTitleText || returnTitleText == "") returnTitleText = "二次修改数据";

        this.returnTitleText = returnTitleText;

        this.setTitle(returnTitleText);
        var data = this.data;
        this.data = data;
        var win = this;

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


        this.sjZqzPanel = new Ext.form.FormPanel({
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
                    name: 'zqid',
                    xtype: 'hidden'
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        hiddenName:'isqyyy',
                        anchor:'100%',
                        allowBlank: false,
                        xtype:'dict_combox',
                        dict:"VisionType=CS_QYLDYY&def=1&ignore=true",
                        fieldLabel:'迁移流动原因'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:5 5 0 0 ',
                    items: [{
                        hiddenName: 'issfcsjtb',
                        anchor: '100%',
                        xtype: 'combo',
                        fieldLabel: '是否长三角通办',
                        mode: 'local',
                        triggerAction: 'all',
                        valueField: "code",
                        displayField: "name",
                        selectOnFocus: true,
                        allowBlank: true,
                        emptyText: '请选择',
                        typeAhead: true,
                        forceSelection: true,
                        blankText: '请选择',
                        lazyRender: true,
                        value: '1',
                        store: sfcsjtb
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
                        var rootWin = this.findParentByType("sjZqzxxModify_window");
                        var form = rootWin.sjZqzPanel;
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
                        var rootWin = this.findParentByType("sjZqzxxModify_window");
                        if (rootWin.callback) {
                            rootWin.callback('gb', null);
                        }
                    }
                })
            ]
        });

        this.items = [this.sjZqzPanel];
        Gnt.ux.SelectSjZqzxxUpdateModify.superclass.initComponent.call(this);
    }
});
Ext.reg('sjZqzxxModify_window', Gnt.ux.SelectSjZqzxxUpdateModify);

