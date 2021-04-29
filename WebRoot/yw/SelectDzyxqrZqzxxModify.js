/**
 * 大专院校详情弹窗
 *
 */
Gnt.ux.SelectDzyxqrZqzxxModify = Ext.extend(Ext.Window, {
    title: '',
    closeAction: 'hide',
    // closable: false,
    resizable: false,
    modal: true,
    width: 1000,
    height: 500,
    margins: '5',
    layout: 'border',
    pageSize:.50,
//	autoScroll:true,
    show: function () {
        this.kjZqzxxPanel.getForm().reset();
        Gnt.ux.SelectDzyxqrZqzxxModify.superclass.show.call(this);
    },
    resetData: function () {

    },
    setSelRes: function (data) {
        this.kjZqzxxPanel.getForm().setValues(data);
    },
    initComponent: function () {
        var returnTitleText = this.returnTitleText;
        if (!returnTitleText || returnTitleText == "") returnTitleText = "大专院校迁入详情修改";
        this.returnTitleText = returnTitleText;
        this.setTitle(returnTitleText);
        var data = this.data;
        this.data = data;
        var win = this;
        this.kjZqzxxPanel = new Gnt.ux.GntForm({
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
            labelWidth: 120,
            items: [{
                layout: 'column',
                frame: false,
                border: false,
                defaults: {
                    border: false,
                    frame: false
                },
                items: [{
                    name: 'ywlsh',
                    xtype: 'hidden'
                }, {
                    name: 'zqid',
                    xtype: 'hidden'
                },{
                    name: 'spywid',
                    xtype: 'hidden'
                },{
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqrxm',
                        fieldLabel: '申请人姓名'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sqrgmsfhm',
                        fieldLabel: '申请人身份号码'
                    }]
                }, {
                    columnWidth: 0.33,
                    layout: 'form',
                    bodyStyle: 'padding:15 0 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'zjbh',
                        fieldLabel: '准迁证编号'
                    }]
                },
                    {
                        columnWidth: 1,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'sqrzzxz',
                            fieldLabel: '申请人详细地址'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype:'tree_comboBox',
                            dict:'VisionType=XZQHBNEW',
                            dsname:'XZQHBNEW',
                            anchor:'100%',
                            name:'sqrzzssxq',
                            id:'sqrzzssxqModify',
                            allowBlank:false,
                            fieldLabel:'去往地',
                            searchUrl:'tj/rktj.do?method=searchXzqh'
                        }]
                    }, {
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'sqrhkdjjg',
                            fieldLabel: '申请人户口登记机关'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype:'tree_comboBox',
                            dict:'VisionType=XZQHBNEW',
                            dsname:'XZQHBNEW',
                            anchor:'100%',
                            name:'qrdssxq',
                            id:'qrdssxqModify',
                            dm:'dm',
                            allowBlank:false,
                            fieldLabel:'迁入省市县区',
                            searchUrl:'tj/rktj.do?method=searchXzqh'
                        }]
                    },  {
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype:'tree_comboBox',
                            dict:'VisionType=DWXXB',
                            dsname:'DWXXB',
                            anchor:'100%',
                            name:'qrdhkdjjg',
                            id:'qrdhkdjjgModify',
                            allowBlank:false,
                            fieldLabel:'迁入户口登记机关',
                            searchUrl:'yw/dqdict.do?method=searchXxb&visiontype=DWXXB'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'pzjg',
                            fieldLabel: '批准机关'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'cbr',
                            fieldLabel: '承办人'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'qfrq',
                            fieldLabel: '签发日期'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            hiddenName:'isstatus',
                            anchor:'100%',
                            xtype:'combo',
                            fieldLabel:'是否报送',
                            mode: 'local',
                            triggerAction: 'all',
                            valueField:"code",
                            displayField:"name",
                            selectOnFocus:true,
                            emptyText : '请选择',
                            typeAhead: true,
                            editable:false,
                            forceSelection: true,
                            blankText:'请选择',
                            lazyRender:true,
                            value:'0',
                            store:new Ext.data.SimpleStore({
                                id:0,
                                fields:[{name: 'code', mapping: 0},{name: 'name', mapping: 1}],
                                data:[['0','未报送'],['1','已报送'],['3','注销']]
                            })
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'yxqjzrq',
                            fieldLabel: '有效截止日期'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            anchor:'100%',
                            xtype:'dict_combox',
                            dict:'VisionType=CS_QYLDYY',
                            value:"",
                            name:'qyyy',
                            maxLength:40,
                            value:'125',
                            hiddenName:'qyyy',
                            allowBlank:false,
                            fieldLabel:'迁移（流动）原因'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'qyrxm1',
                            fieldLabel: '迁移人姓名'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'qyrgmsfhm1',
                            fieldLabel: '迁移人身份证号码'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'qyrcsrq1',
                            fieldLabel: '迁移人出生日期'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            hiddenName: 'qyrxb1',
                            anchor: '100%',
                            xtype: 'dict_combox',
                            dict: 'VisionType=CS_XB',
                            name: 'qyrxb1',
                            fieldLabel: '迁移人性别'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            hiddenName: 'qyrysqrgx1',
                            anchor: '100%',
                            xtype: 'dict_combox',
                            dict: 'VisionType=CS_JTGX',
                            name: 'qyrysqrgx1',
                            fieldLabel: '迁移人与申请人关系'

                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype:'tree_comboBox',
                            dict:'VisionType=DWXXB',
                            dsname:'DWXXB',
                            anchor:'100%',
                            name:'qyrhkdjjg',
                            id:'qyrhkdjjgModify',
                            allowBlank:false,
                            fieldLabel:'迁移人户口登记机关',
                            searchUrl:'yw/dqdict.do?method=searchXxb&visiontype=DWXXB'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{

                            xtype:'tree_comboBox',
                            dict:'VisionType=XZQHBNEW',
                            dsname:'XZQHBNEW',
                            anchor:'100%',
                            name:'qyrzzssxq',
                            id:'qyrzzssxqModify',
                            allowBlank:false,
                            fieldLabel:'迁移人住址省市县区',
                            searchUrl:'tj/rktj.do?method=searchXzqh'
                        }]
                    }, {
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'qyzbh',
                            fieldLabel: '迁移证编号'
                        }]
                    },{
                        columnWidth: 1,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'qyrzzxz',
                            fieldLabel: '迁移人详细地址'
                        }]
                    },{
                        columnWidth: 1,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            xtype: 'textfield',
                            anchor: '100%',
                            name: 'qrdxz',
                            fieldLabel: '迁入地详细地址'
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            hiddenName: 'zqyy',
                            anchor: '100%',
                            xtype: 'dict_combox',
                            dict: 'VisionType=CS_QRLB',
                            name: 'zqyy',
                            fieldLabel: '准迁原因'

                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            hiddenName:'sfcsjtb',
                            anchor:'100%',
                            xtype:'combo',
                            fieldLabel:'是否长三角',
                            mode: 'local',
                            triggerAction: 'all',
                            valueField:"code",
                            displayField:"name",
                            selectOnFocus:true,
                            emptyText : '请选择',
                            typeAhead: true,
                            editable:false,
                            forceSelection: true,
                            blankText:'请选择',
                            lazyRender:true,
                            store:new Ext.data.SimpleStore({
                                id:0,
                                fields:[{name: 'code', mapping: 0},{name: 'name', mapping: 1}],
                                data:[['0', '否'], ['1', '是']]
                            })
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            hiddenName:'sfbj',
                            anchor:'100%',
                            xtype:'combo',
                            fieldLabel:'是否办结',
                            mode: 'local',
                            triggerAction: 'all',
                            valueField:"code",
                            displayField:"name",
                            selectOnFocus:true,
                            emptyText : '请选择',
                            typeAhead: true,
                            editable:false,
                            forceSelection: true,
                            blankText:'请选择',
                            lazyRender:true,
                            store:new Ext.data.SimpleStore({
                                id:0,
                                fields:[{name: 'code', mapping: 0},{name: 'name', mapping: 1}],
                                data:[['0', '否'], ['1', '是']]
                            })
                        }]
                    },{
                        columnWidth: 0.33,
                        layout: 'form',
                        bodyStyle: 'padding:15 0 0 0',
                        items: [{
                            hiddenName:'sfqyz',
                            anchor:'100%',
                            xtype:'combo',
                            fieldLabel:'是否迁移证',
                            mode: 'local',
                            triggerAction: 'all',
                            valueField:"code",
                            displayField:"name",
                            selectOnFocus:true,
                            emptyText : '请选择',
                            typeAhead: true,
                            editable:false,
                            forceSelection: true,
                            blankText:'请选择',
                            lazyRender:true,
                            store:new Ext.data.SimpleStore({
                                id:0,
                                fields:[{name: 'code', mapping: 0},{name: 'name', mapping: 1}],
                                data:[['0', '否'], ['1', '是']]
                            })
                        }]
                    }
                ]
            }],
            buttons: [
                new Ext.Button({
                    text: '保存',
                    minWidth: 75,
                    handler: function () {
                        var rootWin = this.findParentByType("dzyxqrZqzxx_Modify");
                        var form = rootWin.kjZqzxxPanel;
                        // if (!form.getForm().isValid()) {
                        //     Ext.Msg.alert("提示", "数据校验没有通过，请检查！");
                        //     return;
                        // }
                        var dzyxqrAdd = form.getForm().getValues();
                        dzyxqrAdd.sqrzzssxq = Ext.getCmp('sqrzzssxqModify').value;
                        dzyxqrAdd.qrdssxq = Ext.getCmp('qrdssxqModify').value;
                        dzyxqrAdd.qrdhkdjjg = Ext.getCmp('qrdhkdjjgModify').value;
                        dzyxqrAdd.qyrhkdjjg = Ext.getCmp('qyrhkdjjgModify').value;
                        dzyxqrAdd.qyrzzssxq = Ext.getCmp('qyrzzssxqModify').value;
                        if (rootWin.callback) {
                            rootWin.callback('modify', dzyxqrAdd);
                            win.hide();
                        }
                    }
                }),
                new Ext.Button({
                    text: '关闭',
                    minWidth: 75,
                    handler: function () {
                        win.hide();
                    }
                })
            ]
        });
        this.items = [this.kjZqzxxPanel];
        Gnt.ux.SelectDzyxqrZqzxxModify.superclass.initComponent.call(this);
    }
});
Ext.reg('dzyxqrZqzxx_Modify', Gnt.ux.SelectDzyxqrZqzxxModify);