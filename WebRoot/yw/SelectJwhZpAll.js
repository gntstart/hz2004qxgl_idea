/**
 */
var changeFlag = false;
Gnt.ux.SelectJwhZpAll = Ext.extend(Ext.Window, {
    title: '照片',
    closeAction: 'hide',
    closable: false,
    resizable: false,
    modal: true,
    width: 450,
    height: 600,
    margins: '5',
    layout: 'border',
    pageSize: 30,
    show: function () {
        Gnt.ux.SelectJwhZpAll.superclass.show.call(this);
    },
    setData: function (rec) {
        this.zpPanel.items.get(0).items.get(0).items.get(0).html = "<img src='data:image/jpg;base64,"+ rec.stufffile+"'  width='100%' height='100%' />";
    },
    initComponent: function () {
        var win = this;
        var tb = new Ext.Toolbar({
            frame: false,
            border: false,
            region: 'north',
            items: [
                {
                    iconCls: 'icon-close',
                    tooltip: '关闭',
                    handler: function (dp, date) {
                        win.hide();
                    }
                }, "-"
                , {
                    iconCls: 'icon-change',
                    tooltip: '相片大小切换',
                    handler: function (dp, date) {

                        if (changeFlag) {

                            for (var i = 0; i < zpCount; i++) {
                                win.zpPanel.items.get(i).items.get(5).items.get(0).setHeight(480);
                                win.zpPanel.items.get(i).items.get(5).items.get(0).setWidth("100%");
                            }

                            changeFlag = false;
                        } else {

                            for (var i = 0; i < zpCount; i++) {
                                win.zpPanel.items.get(i).items.get(5).items.get(0).setHeight(150);
                                win.zpPanel.items.get(i).items.get(5).items.get(0).setWidth("30%");
                            }
                            win.doLayout();

                            changeFlag = true;
                        }
                    }
                }
            ]
        });

        this.zpPanel = new Ext.Panel({
            height: 80,
            region: 'center',
            anchor: '100% 100%',
            buttonAlign: 'right',
            labelAlign: 'right',
            frame: true,
            border: false,
            fileUpload: true,
            margins: '0',
            layout: 'form',
            labelWidth: 100,
            items: [{
                frame: false,
                border: false,
                layout: 'column',
                columnWidth: 1,
                defaults: {
                    frame: false,
                    border: false,
                    columnWidth: .5,
                    bodyStyle: 'padding:5px 5px 0px 5px'
                },
                items: [
                    {
                        layout: 'form',
                        columnWidth: .96,
                        items: [{
                            title: '',
                            height: 480//,
//							bodyStyle:'padding:10px 10px 10px 10px',
                            //html: '<div ><img src="data:image/jpg;base64,' + rec.zp + '" width="100%" /></DIV>'
                        }]
                    }
                ]
            }],
            buttons: [{
                text: '关闭',
                minWidth: 75,
                handler: function () {
                    var win = this.findParentByType("jwhZpWindow");
                    win.hide();
                }
            }
            ]
        });


        this.items = [this.zpPanel];

        Gnt.ux.SelectJwhZpAll.superclass.initComponent.call(this);


    }
});
Ext.reg('jwhZpWindow', Gnt.ux.SelectJwhZpAll);
