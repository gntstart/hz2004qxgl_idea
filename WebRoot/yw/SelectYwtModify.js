/**
 */
Gnt.ux.SelectYwtModify = Ext.extend(Ext.Window, {
    title: '',
    closeAction: 'hide',
    // closable: false,
    resizable: false,
    modal: true,
    width: 740,
    height: 475,
    margins: '5',
    layout: 'border',
    pageSize: 30,
//	autoScroll:true,
    show: function () {
        Gnt.ux.SelectYwtModify.superclass.show.call(this);
    },
    resetData: function () {

    },
    initComponent: function () {
        var returnTitleText = this.returnTitleText;
        if (!returnTitleText || returnTitleText == "") returnTitleText = "一网通数据  先保存资料、后证明打印、再上传附件";

        this.returnTitleText = returnTitleText;

        this.setTitle(returnTitleText);
        var data = this.data;
        this.data = data;
        var win = this;
        zpCount = 0;

        this.ywtPanel = new Ext.form.FormPanel({
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
                    name: 'applyno',
                    value: '唯一id',
                    xtype: 'hidden'
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'xm',
                        allowBlank: false,
                        disabled: true,
                        fieldLabel: '姓名'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'csrq',
                        allowBlank: false,
                        disabled: true,
                        fieldLabel: '出生日期'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        hiddenName: 'xb',
                        anchor: '100%',
                        xtype: 'dict_combox',
                        dict: 'VisionType=CS_XB',
                        disabled: true,
                        fieldLabel: '性别'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        allowBlank: false,
                        name: 'gmsfhm',
                        disabled: true,
                        fieldLabel: '身份证号<span style="color:red">*</span>',
                        listeners: {}
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        hiddenName: 'kjfw',
                        anchor: '100%',
                        xtype: 'dict_combox',
                        dict: 'VisionType=CS_KJFW',
                        disabled: true,
                        fieldLabel: '开具范围'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        hiddenName: 'lqfs',
                        anchor: '100%',
                        xtype: 'dict_combox',
                        dict: 'VisionType=CS_LQFS',
                        disabled: true,
                        fieldLabel: '领取方式'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sjrusername',
                        allowBlank: false,
                        disabled: true,
                        fieldLabel: '收件人'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sjraddress',
                        allowBlank: false,
                        disabled: true,
                        fieldLabel: '收件地址'
                    }]
                }, {
                    columnWidth: .5,
                    layout: 'form',
                    bodyStyle: 'padding:5 15 0 0',
                    items: [{
                        xtype: 'textfield',
                        anchor: '100%',
                        name: 'sjrmobile',
                        allowBlank: false,
                        disabled: true,
                        fieldLabel: '收件人电话'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:5 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 100,
                        anchor: '100%',
                        name: 'content',
                        allowBlank: false,
                        fieldLabel: '申请描述'
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:5 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 100,
                        anchor: '100%',
                        name: 'bggzxx',
                        allowBlank: false,
                        fieldLabel: '证明详细'
                    }]
                }, {
                    columnWidth: .5,
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
                        store: new Ext.data.SimpleStore({
                            id: 0,
                            fields: [{
                                name: 'code',
                                mapping: 0
                            }, {
                                name: 'name',
                                mapping: 1
                            }],
                            data: [['0', '通过'], ['1', '不通过']]
                        }),
                        listeners:{
                            select:function(combo, res, eOpts ){
                                if (res.data.code==1){
                                    Ext.getCmp("wczsx").setDisabled(false);
                                }else{
                                    Ext.getCmp("wczsx").setDisabled(true);
                                }
                            }
                        }
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    id:'wczsx',
                    // hidden:true,
                    bodyStyle: 'padding:5 5 0 0 ',
                    items: [{
                        title: '未查证事项',
//					columnWidth: 3,
                        xtype: 'fieldset',
                        autoHeight: true,
                        layout:'column',
                        defaults:{
                            columnWidth: .5,
                            fieldLabel: '',
                            name: 'wczsx'
                        },
                        items: [{
                            id:'btgsx_one',
                            xtype:'checkbox',
                            boxLabel: '居民户口薄、居民身份证、护照等法定身份证件能够证明的事项',
                            name:'btgsx_one'
                        },{
                            id:'btgsx_two',
                            xtype:'checkbox',
                            boxLabel: '其他单位或部门依法定职责证明的事项',
                            name:'btgsx_two'
                        },{
                            id:'btgsx_three',
                            columnWidth : 0.3,
                            xtype:'checkbox',
                            boxLabel: '其他事项',
                            name:'btgsx_three'
                        },{
                            columnWidth : 0.2,
                            bodyStyle:'margin:0 0 10 0',
                            items: [{
                                id:'btgsx_three_info',
                                hiddenName:'btgsx_three_info',
                                anchor:'100%',
                                xtype:'textfield'

                            }]
                        },{
                            id:'btgsx_four',
                            xtype:'checkbox',
                            boxLabel: '未查证相关事项',
                            name:'btgsx_four'
                        }]
                    }]
                }, {
                    columnWidth: 1,
                    layout: 'form',
                    bodyStyle: 'padding:5 0 0 0',
                    items: [{
                        xtype: 'textarea',
                        height: 100,
                        anchor: '100%',
                        name: 'blyj',
                        allowBlank: false,
                        fieldLabel: '办理意见'
                    }]
                }
                ]
            }],
            buttons: [
                new Ext.Button({
                    text: '保存',
                    minWidth: 75,
                    id: 'saveBtn_xj',
                    handler: function () {
                        var rootWin = this.findParentByType("ywtModify_window");
                        var form = rootWin.ywtPanel;
                        if (!form.getForm().isValid()) {
                            Ext.Msg.alert("提示", "数据校验没有通过，请检查！");
                            return;
                        }
                        var xgzl = form.getForm().getValues();
                        if (xgzl.bljg==1){
                            if(Ext.getCmp('btgsx_one').getValue()){
                                xgzl.btgsx_one = '1';
                            }
                            if(Ext.getCmp('btgsx_two').getValue()){
                                xgzl.btgsx_two = '1';
                            }
                            if(Ext.getCmp('btgsx_three').getValue()){
                                xgzl.btgsx_three = '1';
                            }
                            if(Ext.getCmp('btgsx_three_info').getValue()){
                                xgzl.btgsx_three_info = Ext.getCmp('btgsx_three_info').getValue();
                            }
                            if(Ext.getCmp('btgsx_four').getValue()){
                                xgzl.btgsx_four = '1';
                            }

                        }
                        if (rootWin.callback) {
                            rootWin.callback('xgzl', xgzl);
                        }
                    }
                }),

                new Ext.Button({
                    text: '户籍证明打印',
                    minWidth: 75,
                    id: 'printBtn',
                    handler: function () {
                        var rootWin1 = this.findParentByType("ywtModify_window");
                        var rootWin = rootWin1.ywtPanel.getForm().getValues();
                        LODOP = getLodop();
                        LODOP.PRINT_INITA(0,0,801,950,"csjywtv1.1");
                        LODOP.SET_PRINT_PAGESIZE(1,0,0,"A4");
                        LODOP.SET_PRINT_STYLE("FontName","方正宋体-人口信息");
                        LODOP.ADD_PRINT_TEXT(73,305,116,32,"户籍事项证明");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
                        LODOP.SET_PRINT_STYLEA(0,"Bold",1);
                        LODOP.ADD_PRINT_LINE(710,70,150,71,0,1);
                        LODOP.ADD_PRINT_TEXT(73,305,116,32,"户籍事项证明");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
                        LODOP.SET_PRINT_STYLEA(0,"FontColor","#080100");
                        LODOP.SET_PRINT_STYLEA(0,"Bold",1);
                        LODOP.ADD_PRINT_LINE(750,70,150,71,0,1);
                        LODOP.ADD_PRINT_LINE(152,70,151,670,0,1);
                        LODOP.ADD_PRINT_LINE(150,670,750,671,0,1);
                        LODOP.ADD_PRINT_LINE(750,70,751,670,0,1);
                        LODOP.ADD_PRINT_LINE(200,70,201,670,0,1);
                        LODOP.ADD_PRINT_LINE(250,70,251,670,0,1);
                        LODOP.ADD_PRINT_LINE(150,250,250,251,0,1);
                        LODOP.ADD_PRINT_TEXT(165,105,100,20,"姓名");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(207,105,100,20,"公民身份号码");
                        LODOP.ADD_PRINT_TEXT(228,104,100,20,"(出生日期)");
                        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
                        LODOP.ADD_PRINT_TEXT(165,286,100,20,rootWin1.data.username);
                        LODOP.ADD_PRINT_TEXT(217,279,219,20,rootWin1.data.licenseno);
                        LODOP.ADD_PRINT_TEXT(263,97,79,20,"证明事项：");
                        LODOP.SET_PRINT_STYLEA(0,"Bold",1);
                        if(rootWin1.data.kjfw == "1"){
                            LODOP.ADD_PRINT_IMAGE(263,204,24,20,"<img border='0' src='"+basePath+"images/ygx.png' />");
                        }else{
                            LODOP.ADD_PRINT_IMAGE(263,204,24,20,"<img border='0' src='"+basePath+"images/wgx.png' />");
                        }
                        // LODOP.ADD_PRINT_TEXT(263,204,24,20,"口");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
                        LODOP.ADD_PRINT_TEXT(265,233,223,20,"户口登记项目内容变更更正");
                        if(rootWin1.data.kjfw == "2"){
                            LODOP.ADD_PRINT_IMAGE(288,204,24,20,"<img border='0' src='"+basePath+"images/ygx.png' />");
                        }else{
                            LODOP.ADD_PRINT_IMAGE(288,204,24,20,"<img border='0' src='"+basePath+"images/wgx.png' />");
                        }
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
                        LODOP.ADD_PRINT_TEXT(290,233,62,20,"注销户口");
                        if(rootWin1.data.kjfw == "3"){
                            LODOP.ADD_PRINT_IMAGE(313,204,24,20,"<img border='0' src='"+basePath+"images/ygx.png' />");
                        }else{
                            LODOP.ADD_PRINT_IMAGE(313,204,24,20,"<img border='0' src='"+basePath+"images/wgx.png' />");
                        }
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
                        LODOP.ADD_PRINT_TEXT(315,233,169,20,"曾经同户人员亲属关系");
                        if(rootWin1.data.kjfw == "4"){
                            LODOP.ADD_PRINT_IMAGE(338,204,24,20,"<img border='0' src='"+basePath+"images/ygx.png' />");
                        }else{
                            LODOP.ADD_PRINT_IMAGE(338,204,24,20,"<img border='0' src='"+basePath+"images/wgx.png' />");
                        }
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
                        LODOP.ADD_PRINT_TEXT(340,233,37,20,"其他");
                        LODOP.ADD_PRINT_TEXT(339,266,269,20,"________________________________");
                        LODOP.ADD_PRINT_TEXT(380,97,79,20,"证明内容：");
                        LODOP.SET_PRINT_STYLEA(0,"Bold",1);
                        LODOP.ADD_PRINT_TEXT(408,121,447,147,rootWin.bggzxx);
                        LODOP.ADD_PRINT_LINE(650,70,651,670,0,1);
                        LODOP.ADD_PRINT_TEXT(677,89,563,59,"注：1、长三角地区（上海市、江苏省、浙江省、安徽省）才用统一证明格式，可向长三角“一网通办”平台（网站）申请开具；\r\n2、此证明仅证明户籍登记情况，如有疑问，由证明出具单位对出具内容进行解释。");
                        LODOP.ADD_PRINT_TEXT(770,400,72,20,"出具单位：");
                        LODOP.ADD_PRINT_TEXT(770,473,146,20,rootWin1.data.sldwname);
                        LODOP.ADD_PRINT_TEXT(800,401,74,20,"签发日期：");
                        LODOP.ADD_PRINT_TEXT(800,478,100,20,(new Date()).format('yy-m-d'));
                        LODOP.PRINT_DESIGN();
                    }
                }),
                new Ext.Button({
                    text: '不予出具证明打印',
                    minWidth: 75,
                    id: 'bycjprintBtn',
                    handler: function () {
                        var rootWin1 = this.findParentByType("ywtModify_window");
                        var rootWin = rootWin1.ywtPanel.getForm().getValues();
                        LODOP = getLodop();
                        LODOP.PRINT_INITA(0,0,801,950,"csjywtbycjzmgzsv1.1");
                        LODOP.SET_PRINT_PAGESIZE(1,0,0,"A4");
                        LODOP.SET_PRINT_STYLE("FontName","方正宋体-人口信息");
                        LODOP.ADD_PRINT_TEXT(49,251,165,27,"不予出具证明告知书");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(100,123,61,20,"申请人");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(100,184,85,20,rootWin1.data.username);
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(100,272,27,20,"，");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(100,289,100,20,"公民身份号码：");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(100,388,150,20,rootWin1.data.licenseno);
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(125,60,25,20,"于");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        var cjsj = rootWin1.data.cjsj;
                        var sqsj = "";
                        if(cjsj){
                            var cjsjTemp = cjsj.replace("-","").replace("-","").substr(0,8);
                            sqsj =  cjsjTemp.substr(0,4)+'年'+cjsjTemp.substr(4,2)+'月'+cjsjTemp.substr(6,2)+'日';
                        }
                        LODOP.ADD_PRINT_TEXT(125,83,100,20,sqsj);
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(125,192,85,20,"申请开具");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(125,277,100,20,Gnt.ux.Dict.getDictLable("CS_KJFW", rootWin1.data.kjfw));
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(125,371,100,20,"（类别）");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(150,62,206,20,"户籍事项证明，经核查：");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(163,83,35,20,"□");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",21);
                        LODOP.ADD_PRINT_TEXT(171,107,412,20,"根据公安部等12部委《关于改进和规范公安派出所出具");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(195,57,268,20,"证明工作的意见》规定，该申请属于");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(185,322,23,20,"□");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",21);
                        LODOP.ADD_PRINT_TEXT(195,344,171,20,"居民户口薄、居民身份");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(221,55,308,20,"证、护照等法定身份证件能够证明的事项/");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(211,361,32,20,"□");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",21);
                        LODOP.ADD_PRINT_TEXT(219,382,140,20,"其他单位或部门依");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(247,53,163,20,"法定职责证明的事项/");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(237,213,24,20,"□");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",21);
                        LODOP.ADD_PRINT_TEXT(248,239,194,20,"其他事项_____________;");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(286,81,37,20,"□");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",21);
                        LODOP.ADD_PRINT_TEXT(294,104,145,20,"未查证相关事项。\r\n");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        LODOP.ADD_PRINT_TEXT(315,81,193,20,"据此，不予出具相关证明。\r\n");
                        LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
                        var da = new Date();
                        var year = da.getFullYear()+'年';
                        var month = da.getMonth()+1+'月';
                        var day = da.getDate()+'日';
                        LODOP.ADD_PRINT_TEXT(356,331,150,20,year+month+day);
                        LODOP.ADD_PRINT_TEXT(383,330,116,20,"（核查单位公章）\r\n");
                        LODOP.PRINT_DESIGN();
                    }
                }),
                new Ext.Button({
                    text: '上传附件',
                    minWidth: 75,
                    id: 'uploadBtn_xj',
                    handler: function () {
                        var rootWin = this.findParentByType("ywtModify_window");
                        btnUpload_click('上传附件', rootWin.applyno, rootWin.blFile, function callback() {
                            rootWin.hide();
                        });
                    }
                }),/*
                new Ext.Button({
                    text: '撤回申请',
                    minWidth: 75,
                    id: 'cancelBtn_xj',
                    handler: function () {
                        var rootWin = this.findParentByType("ywtModify_window");
                        var subdata = {
                            applyno: rootWin.applyno
                        };
                        Gnt.submit(
                            subdata,
                            "yw/ywtb.do?method=sendPostYwtb",
                            "正在处理，请稍后...",
                            function (jsonData) {
                                Ext.Msg.hide();
                                showError(jsonData.messages[0]);
                            },
                            function (jsonData) {
                                Ext.Msg.hide();
                                showError(jsonData.messages[0]);
                            });
                    }
                }),
                new Ext.Button({
                    text: '推送数据',
                    minWidth: 75,
                    id: 'cancelBtn_xj',
                    handler: function () {
                        var rootWin = this.findParentByType("ywtModify_window");
                        var subdata = {
                            applyno: rootWin.applyno
                        };
                        Gnt.submit(
                            subdata,
                            "yw/ywtb.do?method=sendPostYwtb",
                            "正在处理，请稍后...",
                            function (jsonData) {
                                Ext.Msg.hide();
                                showError(jsonData.messages[0]);
                            },
                            function (jsonData) {
                                Ext.Msg.hide();
                                showError(jsonData.messages[0]);
                        });
                    }
                }),*/
                new Ext.Button({
                    text: '关闭',
                    minWidth: 75,
                    handler: function () {
                        win.hide();
                    }
                })
            ]
        });
        /**
         * 查询出照片后动态加载代码
         * @param id
         * @returns
         */
        var applyno = this.applyno;
        if (!applyno || applyno == "") {

        }
        this.applyno = applyno;

        var myStoreCzrkxx = new Ext.data.JsonStore({
            url: 'yw/ywtb.do?method=queryCzrkxx',
            root: 'list',
            id: 'yhid',
            totalProperty: 'totalCount',
            fields: [
                "xm", "csrq", "xb", "gmsfhm"
            ],
            listeners: {
                load: function (mystore, res) {
                    myMask.hide();
                    if (res.length > 0) {
                        Ext.getCmp("saveBtn_xj").setDisabled(false);
                        win.ywtPanel.getForm().setValues(res[0].data);
                        if (win.data) {
                            win.ywtPanel.getForm().setValues(win.data);
                        }
                    } else {
                        alert("本市库查询不到该群众！")
                        win.ywtPanel.getForm().setValues(win.data);
                        win.ywtPanel.getForm().setValues({
                            xm:win.data.username,
                            csrq:win.data.licenseno.substr(6, 8),
                            xb:win.data.licenseno.substr(16, 1)% 2 == 1?"1":"2",
                            gmsfhm:win.data.licenseno
                        });
                    }
                },
                loadexception: function (mystore, options, response, error) {
                    myMask.hide();
                    if (error) {
                        var json = Ext.decode(response.responseText);
                        Ext.Msg.alert("提示", json.messages[0]);
                    } else {
                        Ext.Msg.alert("提示", response.responseText);
                    }
                }
            }
        });
        myStoreCzrkxx.load({params: {start: 0, limit: 20, dwdm: user.dwdm, gmsfhm: this.data.licenseno}})

        if (this.data.kjfw == "1") {
            var myStoreBggzxx = new Ext.data.JsonStore({
                url: 'yw/ywtb.do?method=queryBggzxxb',
                root: 'list',
                id: 'yhid',
                totalProperty: 'totalCount',
                fields: [
                    "xm", "bggzxm", "bggzqnr", "bggzhnr", "bggzrq"
                ],
                listeners: {
                    load: function (mystore, res) {
                        myMask.hide();
                        var bggzxxres = '';
                        if (res.length > 0) {
                            Ext.getCmp("saveBtn_xj").setDisabled(false);
                            for (var i = 0; i < res.length; i++) {
                                var bggzxx = res[i].data;
                                if (bggzxx.bggzxm == "照片") {
                                    bggzxxres += bggzxx.bggzrq + bggzxx.bggzxm + "进行了变更\n";
                                } else {
                                    var a = bggzxx.bggzrq + bggzxx.bggzxm + "从" + (bggzxx.bggzqnr != null ? bggzxx.bggzqnr : "无") + "变更到" + (bggzxx.bggzhnr != null ? bggzxx.bggzhnr : "无") + "\n";
                                    bggzxxres += a;
                                }
                            }
                        } else {
                            bggzxxres += "无变更更正事项";
                            alert("本市库查询不到该群众的变更更正项目证明！")
                        }
                        win.ywtPanel.getForm().setValues({bggzxx: bggzxxres});
                    },
                    loadexception: function (mystore, options, response, error) {
                        myMask.hide();
                        if (error) {
                            var json = Ext.decode(response.responseText);
                            Ext.Msg.alert("提示", json.messages[0]);
                        } else {
                            Ext.Msg.alert("提示", response.responseText);
                        }
                    }
                }
            });
            myStoreBggzxx.load({params: {start: 0, limit: 20, dwdm: user.dwdm, gmsfhm: this.data.licenseno}})
        }

        if (this.data.kjfw == "2") {
            var bggzxxres = '';

            var myStoreSwzxzm = new Ext.data.JsonStore({
                url: 'yw/ywtb.do?method=querySwzxZm',
                root: 'list',
                id: 'yhid',
                totalProperty: 'totalCount',
                fields: [
                    "xm", "gmsfhm", "swrq", "swzxlb"
                ],
                listeners: {
                    load: function (mystore, res) {
                        myMask.hide();
                        if (res.length > 0) {
                            Ext.getCmp("saveBtn_xj").setDisabled(false);

                            for (var i = 0; i < res.length; i++) {
                                var bggzxx = res[i].data;
                                var data = bggzxx.swrq;
                                var year = data.substr(0, 4);
                                var month = data.substr(4, 2);
                                var day = data.substr(6, 2);
                                bggzxxres += "姓名：" + bggzxx.xm + ", 公民身份证号码：" + bggzxx.gmsfhm
                                    + ", 于" + year + "年" + month + "月" + day + "日, 因" + Gnt.ux.Dict.getDictLable("CS_SWZXLB", bggzxx.swzxlb);
                            }

                        } else {
                            //alert("本市库查询不到该群众的死亡注销项目证明！")
                        }
                    },
                    loadexception: function (mystore, options, response, error) {
                        myMask.hide();
                        if (error) {
                            var json = Ext.decode(response.responseText);
                            Ext.Msg.alert("提示", json.messages[0]);
                        } else {
                            Ext.Msg.alert("提示", response.responseText);
                        }
                    }
                }
            });
            myStoreSwzxzm.load({params: {start: 0, limit: 20, dwdm: user.dwdm, gmsfhm: this.data.licenseno}})


            var myStoreQczxzm = new Ext.data.JsonStore({
                url: 'yw/ywtb.do?method=queryQczxZm',
                root: 'list',
                id: 'yhid',
                totalProperty: 'totalCount',
                fields: [
                    "xm", "xb", "csrq", "gmsfhm", "ssxq", "mlxz", "qclb", "xzjd", "jlx", "mlxz",'qcrq'
                ],
                listeners: {
                    load: function (mystore, res) {
                        myMask.hide();
                        if (res.length > 0) {
                            Ext.getCmp("saveBtn_xj").setDisabled(false);
                            for (var i = 0; i < res.length; i++) {
                                var bggzxx = res[i].data;
                                var data = bggzxx.csrq;
                                var year = data.substr(0, 4);
                                var month = data.substr(4, 2);
                                var day = data.substr(6, 2);

                                var qcrqData = bggzxx.qcrq;
                                var qcrqyear = qcrqData.substr(0, 4);
                                var qcrqmonth = qcrqData.substr(4, 2);
                                var qcrqday = qcrqData.substr(6, 2);
                                bggzxxres += "原我辖区居民: " + bggzxx.xm
                                    + ", 性别：" + Gnt.ux.Dict.getDictLable("CS_XB", bggzxx.xb)
                                    + " ,于 " + year + " 年 " + month + " 月 " + day + " 日出生\n"
                                    + "公民身份证号码: " + bggzxx.gmsfhm + "\n"
                                    + "原户口在: " + Gnt.ux.Dict.getDictLableXzqh("searchXzqh",'',bggzxx.ssxq,"eq")
                                    + Gnt.ux.Dict.getDictLableXzqh("searchXxb",'XZJDXXB',bggzxx.xzjd,"eq")
                                    + Gnt.ux.Dict.getDictLableXzqh("searchXxb",'JLXXXB',bggzxx.jlx,"eq")
                                    + bggzxx.mlxz + "\n"
                                    + + qcrqyear + "年" + qcrqmonth + "月" + qcrqday + "日 现因: " + Gnt.ux.Dict.getDictLable("CS_QCZXLB", bggzxx.qclb) + ", 户口已注销。";
                            }
                            win.ywtPanel.getForm().setValues({bggzxx: bggzxxres});
                        } else {
                            //alert("本市库查询不到该群众的迁出注销项目证明！")
                        }
                    },
                    loadexception: function (mystore, options, response, error) {
                        myMask.hide();
                        if (error) {
                            var json = Ext.decode(response.responseText);
                            Ext.Msg.alert("提示", json.messages[0]);
                        } else {
                            Ext.Msg.alert("提示", response.responseText);
                        }
                    }
                }
            });
            myStoreQczxzm.load({params: {start: 0, limit: 20, dwdm: user.dwdm, gmsfhm: this.data.licenseno}})


        }
        var subdata = {
            applyno: this.applyno
        };
        Gnt.submit(
            subdata,
            "yw/ywtb.do?method=queryYwtbFjcl",
            "正在处理，请稍后...",
            function (jsonData) {
                if (jsonData && jsonData.list && jsonData.list.length > 0) {
                    var items13 = win.ywtPanel.items.items[0]/*.items.items[13]*/;
                    var items = win.ywtPanel.items.items[0].items.items[12].items;
                    for (var i = 0; i < jsonData.list.length; i++) {
                        var rec = jsonData.list[i];
                        var obj = {
                            columnWidth: .33,
                            layout: 'form',
                            bodyStyle: 'padding:5 0 0 0',
                            items: [{
                                title: '',
                                height: 200,
                                bodyStyle: 'padding:50px',
                                html: '<font style="font-size:9pt;">' + rec.filename + '</FONT><img src="data:image/jpg;base64,' + rec.stufffile + '"   width=150 height=150></img>',
                                listeners: {
                                    render: function (c) {
                                        c.body.on('click', function () {
                                            //TODO 添加点击事件功能
                                            var jwhZpWindow = new Gnt.ux.SelectJwhZpAll({
                                                //jwhzpid:selectedSelRes.data.hzzpid
                                            });
                                            var ownerCt = c.ownerCt.function_rec;
                                            jwhZpWindow.setData(ownerCt);
                                            jwhZpWindow.show();
                                        });
                                        // c.body.on('contextmenu',function(e){
                                        // 	e.preventDefault();//阻止浏览器默认右键菜单
                                        // 	customMenu.showAt(e.getXY());//展示自定义菜单
                                        // });
                                    },
                                    scope: this
                                }
                            }]
                        };
                        obj['function_rec'] = rec;
                        items13.add(
                            obj
                        );
                    }
                    win.ywtPanel.doLayout();
                }
            }
        );
        if (this.data.bljg==1){
            // Ext.getCmp("wczsx").show();
            Ext.getCmp("wczsx").setDisabled(false);
        }else{
            // Ext.getCmp("wczsx").hide();
            Ext.getCmp("wczsx").setDisabled(true);
        }
        // if(data.blyj){
        //     Ext.getCmp("bycjprintBtn").setDisabled(true);
        // }else{
        //     Ext.getCmp("bycjprintBtn").setDisabled(false);
        // }
        this.items = [this.ywtPanel];

        Gnt.ux.SelectYwtModify.superclass.initComponent.call(this);


    }
});

Ext.reg('ywtModify_window', Gnt.ux.SelectYwtModify);

function savexj(ywtPanel) {
    if (!ywtPanel.getForm().isValid()) {
        Ext.Msg.alert("提示", "数据校验没有通过，请检查！");
        return;
    }
    var data = ywtPanel.getForm().getValues();

    Ext.Msg.wait("正在保存，请稍后...");

    ywtPanel.form.submit({
        url: "yw/ywtb.do?method=updateYwtbXx",
        method: 'POST',
        //waitMsg: '正在执行操作，请等待...',
        success: function (form, action) {
            Ext.Msg.hide();
        },
        failure: function (form, action) {

            Ext.Msg.hide();
            showError(action.result.message);
        }
    });

}
