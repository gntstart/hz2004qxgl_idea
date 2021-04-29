var selRes = null;

Ext.onReady(function () {
    Ext.QuickTips.init();

    if (Ext.isChrome == true) {
        var chromeDatePickerCSS = ".x-date-picker {border-color: #1b376c;background-color:#fff;position: relative;width: 185px;}";
        Ext.util.CSS.createStyleSheet(chromeDatePickerCSS, 'chromeDatePickerStyle');
    }

    if (qyzDbJump != "") {
        var qyzbh = getQueryParam("qyzDbQyzbh");
        var url = rkurl + "yw/hjyw/qryw?qyzDbJump=" + qyzDbJump + "&qyzDbGmsfhm=" + qyzDbGmsfhm + "&qyzDbQyzbh=" + encodeURI(qyzbh);
        parent.location.href = url;
    }

    var qrd_ssxqdm = getQueryParam("qrd_ssxqdm");

    if (formdq == "") {
        showErr("数据错误，没有迁出地区！");
        return;
    }
    if (todq == "") {
        showErr("数据错误，没有迁入地区！");
        return;
    }
    if (ywlsh == "") {
        showErr("数据错误，没有ywlsh！");
        return;
    }


    //首先以AJAX同步的方式获取页面需要的配置，然后从本地进行渲染界面
    if (!Gnt.loadSjpzb("10019,10002,10024", function () {
    }))
        return;

    /**
     * 户成员，跨地市查询
     */
    var hcyGrid = new Gnt.ux.CzrkGrid({
        region: 'west',
        title: '户成员列表',
        width: 200,
        showPaging: false,
        url: 'yw/kdqqy.do?method=queryKDQCzrkjbxxQxgl',
        cm: new Ext.grid.ColumnModel([
            new Ext.grid.CheckboxSelectionModel(),
            new Ext.grid.RowNumberer(),
            {
                header: "姓名",
                dataIndex: "xm",
                sortable: true,
                width: 80,
                renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                    if (record.data.qcflag == "1") {
                        cellmeta.css = 'changeplus';
                    }
                    return value;
                }
            }, {
                header: "与户主关系",
                dataIndex: "yhzgx",
                sortable: true,
                width: 120,
                renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                    if (record.data.qcflag == "1") {
                        cellmeta.css = 'changeplus';
                    }
                    return Gnt.ux.Dict.getDictLable('CS_JTGX', value);
                }
            }, {
                header: "性别",
                dataIndex: "xb",
                sortable: true,
                width: 60,
                renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                    if (record.data.qcflag == "1") {
                        cellmeta.css = 'changeplus';
                    }
                    return Gnt.ux.Dict.getDictLable('CS_XB', value);
                }
            }, {
                header: "公民身份号码",
                dataIndex: "gmsfhm",
                sortable: true,
                width: 100,
                renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                    if (record.data.qcflag == "1") {
                        cellmeta.css = 'changeplus';
                    }
                    return value;
                }
            }, {
                header: "民族",
                dataIndex: "mz",
                sortable: true,
                width: 60,
                renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                    if (record.data.qcflag == "1") {
                        cellmeta.css = 'changeplus';
                    }
                    return Gnt.ux.Dict.getDictLable('CS_MZ', value);
                }
            }, {
                header: "婚姻状况",
                dataIndex: "hyzk",
                sortable: true,
                width: 60,
                renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                    if (record.data.qcflag == "1") {
                        cellmeta.css = 'changeplus';
                    }

                    return Gnt.ux.Dict.getDictLable('CS_HYZK', value);
                }
            }, {
                header: "血型",
                dataIndex: "xx",
                sortable: true,
                width: 60,
                renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                    if (record.data.qcflag == "1") {
                        cellmeta.css = 'changeplus';
                    }

                    return Gnt.ux.Dict.getDictLable('CS_XX', value);
                }
            }, {
                header: "联系电话",
                dataIndex: "dhhm",
                sortable: true,
                width: 80,
                renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                    if (record.data.qcflag == "1") {
                        cellmeta.css = 'changeplus';
                    }

                    return value;
                }
            }
        ]),
        view: new Ext.grid.GridView({
            forceFit: false,
            autoFill: false,
            enableRowBody: true
        }),
        listeners: {
            rowclick: function (g, rowIndex, e) {
                selRes = g.store.getAt(rowIndex);

                form10019.getForm().reset();
                form10019.getForm().loadRecord(selRes);

                form10024.getForm().reset();
                if (selRes.data.qcflag == "1") {
                    //为迁出登记form赋值
                    form10024.setVisible(true);
                    var pkvalue = selRes.data[form10024.bindStore.pkname];
                    var re = form10024.bindStore.getById(pkvalue);
                    if (re) {
                        form10024.getForm().loadRecord(re);
                    } else {
                        alert("警告：迁出登记信息" + pkvalue + "不存在！");
                    }
                } else {
                    form10024.setVisible(false);
                }
            },
            rowdblclick: function (g, rowIndex, e) {

            }
        }
    });

    var form10019 = new Gnt.ux.GntForm({
        closable: false,
        region: 'north',
        height: 330,
        id: 'form10019',
        pzlb: '10019',
        cols: 2,
        labelWidth: 120,
        bindStore: hcyGrid.store,
        bindViewGrid: hcyGrid,
        getDictCust: function (cmb, visiontype) {
            if (visiontype == "JTCY") {
                return getSelectRy();
            }
            return;
        },
        changeDictCust: function (cmb, res) {
            if (cmb.name == "fqxm") {
                this.getForm().setValues({fqgmsfhm: res.data.data});
                selRes.set("fqgmsfhm", res.data.data);
            }
            if (cmb.name == "mqxm") {
                this.getForm().setValues({mqgmsfhm: res.data.data});
                selRes.set("mqgmsfhm", res.data.data);
            }
            if (cmb.name == "jhryxm") {
                this.getForm().setValues({jhrygmsfhm: res.data.data});
                selRes.set("jhrygmsfhm", res.data.data);
            }
            if (cmb.name == "jhrexm") {
                this.getForm().setValues({jhregmsfhm: res.data.data});
                selRes.set("jhregmsfhm", res.data.data);
            }
            if (cmb.name == "poxm") {
                this.getForm().setValues({pogmsfhm: res.data.data});
                selRes.set("pogmsfhm", res.data.data);
            }

            return;
        },
        title: '户成员信息',
        listeners: {
            resize: function (f) {
                if (typeof (f.layout.layout) == 'function') {
                    f.doLayout();
                }
            }
        }
    });

    var form10002 = new Gnt.ux.GntForm({
        closable: false,
        region: 'north',
        height: 60,
        id: 'form10002',
        pzlb: '10002',
        cols: 2,
        labelWidth: 120,
        getDictCust: function (cmb, visiontype) {
            if (visiontype == "JTCY") {
                return getSelectRy();
            }
            return;
        },
        changeDictCust: function (cmb, res) {
            this.getForm().setValues({sbrgmsfhm: res.data.data});
            return;
        },
        title: '申报人信息',
        listeners: {
            resize: function (f) {
                if (typeof (f.layout.layout) == 'function') {
                    f.doLayout();
                }
            }
        }
    });

    //迁出登记store
    var qcdjStore = new Gnt.store.SjpzStore({
        pzlb: '10024',
        pkname: 'rynbid'
    });

    var form10024 = new Gnt.ux.GntForm({
        closable: false,
        region: 'center',
        height: 60,
        id: 'form10024',
        pzlb: '10024',
        cols: 2,
        labelWidth: 120,
        //绑定到store，输入域改动的时候，自动赋值
        bindStore: qcdjStore,
        bindViewGrid: hcyGrid,
        getDictCust: function (cmb, visiontype) {
            if (visiontype == "JTCY") {
                return getSelectRy();
            }
            return;
        },
        changeDictCust: function (cmb, res) {
            return;
        },
        title: '迁出登记信息',
        listeners: {
            resize: function (f) {
                if (typeof (f.layout.layout) == 'function') {
                    f.doLayout();
                }
            }
        }

    });

    new Ext.Viewport({
        layout: 'border',
        id: 'vp',
        items: [hcyGrid, {
            region: 'center',
            //禁止横向滚动条
            layout: 'border',
            border: false,
            frame: false,
            items: [form10019, {
                layout: 'border',
                region: 'center',
                border: false,
                frame: false,
                items: [form10002, form10024]
            }]
        }, {
            region: 'east',
            width: 100,
            html: '<table border=0 width=100% height=100%><tr><td style="text-align:center;padding:10px">' +
                '<span id="b5"></span><br/>' +
                '<span id="b1"></span><br/>' +
                '<span id="b2"></span>' +
                '<span id="b3"></span>' +
                '<span id="b4"></span>' +
                '</td></tr></table>'
        }]
    });

    /**
     * 人员选择方法
     */
    function getSelectRy() {
        var rylist = new Array();
        hcyGrid.store.each(
            function (rec) {
                var len = rylist.length;
                rylist[len] = new Array();
                rylist[len][0] = rec.data.xm;
                rylist[len][1] = rec.data.xm;
                rylist[len][2] = rec.data.gmsfhm;
            }, hcyGrid
        );

        return rylist;
    }

    var b1 = new Ext.Button({
        renderTo: 'b1',
        text: '确定迁出',
        minWidth: 75,
        handler: function () {
            if (!form10019.checkInput())
                return;

            //var is10024form = form10024.getForm().getValues();
            //var qyzbh = is10024form.qyzbh;
            //if(qyzbh == ""){
            //    alert("迁移证编码不能为空！")
            //    return;
            //}

            if (!form10024.checkInput())
                return;

            if (!form10002.getForm().isValid()) {
                showErr("申报人信息必须填写！");
                return;
            }

            //判断非迁出户必须存在户主
            var exists = false;
            var icount = 0;
            for (var index = 0; index < res.length; index++) {
                var data = res[index].data;
                if (data.qcflag == "1") {

                } else {
                    icount++;
                    //if(data.yhzgx)
                    if (data.yhzgx == "01" || data.yhzgx == "02" || data.yhzgx == "03")
                        exists = true;
                }
            }
            if (!exists && icount > 0) {
                showErr("户主已迁出，请选择新户主！");
                return;
            }

            var rs = hcyGrid.store.getModifiedRecords();
            var store = bggzGrid.store;
            store.removeAll();

            if (rs != null) {
                str = "";
                for (var i = 0; i < rs.length; i++) {
                    var obj = rs[i].getChanges();
                    //str += "记录ID:" + rs[i].id + ":<BR>";
                    //"tmpid", "rynbid","xm","bggzxm_mc","bggzxm", "bggzqnr","bggzhnr","bggzlb"
                    for (f in obj) {
                        var data = {
                            rynbid: rs[i].data.rynbid,
                            xm: rs[i].data.xm,
                            bggzxm: f,
                            bggzxm_mc: form10019.getFieldLabel(f),
                            bggzqnr: rs[i].modified[f],
                            bggzhnr: obj[f],
                            bggzlb: '91'
                        };
                        var r = new store.reader.recordType(data);
                        store.add([r]);
                    }
                }
                if (store.getCount() > 0) {
                    bggzWin.show();
                } else {
                    submitData();
                }

                return;
            }
        }
    });

    var b2 = new Ext.Button({
        renderTo: 'b2',
        text: '关闭',
        minWidth: 75,
        handler: function () {
            //关闭当前窗口
            if (parent.closeActiveWorkSpace)
                parent.closeActiveWorkSpace();
            else
                window.close();
        }
    });

    var b5 = new Ext.Button({
        renderTo: 'b5',
        text: '准迁证核验',
        minWidth: 75,
        handler: function () {
            var data = form10024.getForm().getValues();
            if (!sqr_gmsfhm || sqr_gmsfhm == "") {
                showInfo("公民身份号码不能为空！");
                return null;
            }
            if ((data.qclb && data.qclb.substring(0, 3) != "048") && (!data.zqzbh || data.zqzbh == "")) {
                showInfo("准迁证编号不能为空！");
                return null;
            }
            var params = {
                gmsfzh: sqr_gmsfhm,
                zqzbh: data.zqzbh,
                sjgsdwdm: data.qwdssxq
            };
            url = zqzhyUrl;
            if (url.indexOf("?") < 0)
                url += "?";
            url = url + '&gmsfzh=' + sqr_gmsfhm + '&zqzbh=' + encodeURI(encodeURI(data.zqzbh)) + '&sjgsdwdm=' + qrd_ssxqdm + '&version=2';
            /*for(o in params){
                if(params[o] && params[o]!=""){
                    var val = params[o];
                    if(val.indexOf("user.")==0){
                        val = user[val.substring(5)];
                        url += '&' + o + "=" + encodeURI(encodeURI(val))+"&version=2";
                    }else{
                        url += '&' + o + "=" + encodeURI(encodeURI(params[o]))+"&version=2";
                    }
                }
            }*/
            var w = new Gnt.ux.URLDialog({
                title: '准迁证核验',
                width: 900,
                height: 500,
                url: url
            });
            w.show();
        }
    });

    var bggzGrid = new Gnt.ux.BggzGrid({title: ''});
    var bggzWin = new Ext.Window({
        title: '确认变更更正项目',
        closeAction: 'hide',
        modal: true,
        width: 600,
        height: 300,
        margins: '5',
        layout: 'fit',
        items: bggzGrid,
        buttons: [
            new Ext.Button({
                text: '确定',
                minWidth: 75,
                handler: function () {
                    submitData();
                }
            }),
            new Ext.Button({
                text: '取消',
                minWidth: 75,
                handler: function () {
                    bggzWin.hide();
                }
            })
        ]
    });

    //提交数据
    function submitData() {
        var subdata = {
            sqr_gmsfhm: sqr_gmsfhm,
            ywlsh: getQueryParam("ywlsh"),
            todq: todq,
            formdq: getQueryParam("formdq"),
            bggzxx: new Array(),
            sbjbxx: {},
            ryList: new Array(),
            qczxxx: new Array()
        };

        //人员内部id和上笔户籍业务的关系
        var map = {};
        hcyGrid.store.each(
            function (rec) {
                map[rec.data.rynbid] = rec.data.cjhjywid;
            }, hcyGrid
        );

        //变更更正信息
        var bggzmap = {};
        var store = bggzGrid.store;
        if (store.getCount() > 0) {
            for (var index = 0; index < store.getCount(); index++) {
                var bggzdata = store.getAt(index).data;
                bggzdata.sbhjywid = map[bggzdata.rynbid];
                bggzdata.flag = '1';

                if (!bggzmap[bggzdata.rynbid]) {
                    bggzmap[bggzdata.rynbid] = {
                        rynbid: bggzdata.rynbid,
                        sbhjywid: bggzdata.sbhjywid,
                        bggzxxList: new Array()
                    }
                }
                bggzmap[bggzdata.rynbid].bggzxxList.push(bggzdata);
            }

            for (rynbid in bggzmap) {
                subdata.bggzxx.push(bggzmap[rynbid]);
            }
        }

        //申报人信息
        subdata.sbjbxx = form10002.getForm().getValues();
        
        var zqzbhTemp = qcdjStore.getAt(0).data.zqzbh;
    	if (!zqzbhTemp || zqzbhTemp == "") {
            showInfo("准迁证编号不能为空！");
            return;
        }
        //迁出注销信息
        for (var index = 0; index < qcdjStore.getCount(); index++) {
            var data = qcdjStore.getAt(index).data;
            data.sbhjywid = map[data.rynbid];

            subdata.qczxxx.push(data);
        }

        subdata.sbjbxx = Ext.encode(subdata.sbjbxx);
        subdata.bggzxx = Ext.encode(subdata.bggzxx);
        subdata.qczxxx = Ext.encode(subdata.qczxxx);

        Gnt.submit(
            subdata,
            "yw/kdqqy.do?method=saveKdsQcQxgl",
            "正在处理迁出信息，请稍后...",
            function (jsonData, params) {
                showInfo("跨省迁出成功！", function () {
                    //关闭当前窗口 parent.closeActiveWorkSpace(jsonData);
                    if (parent.closeActiveWorkSpace)

                        var list = jsonData.list[0];
                    var qczxid = list.voQczxfhxx[0].qczxid;
                    var ryid = list.voQczxfhxx[0].ryid;
                    var gmsfhm = list.voQczxfhxx[0].gmsfhm;

                    //var url = rkurl + "yw/hjyw/qccl?gmsfhm=" + gmsfhm
                    var url = rkurl + "cx/hjywxx/qczxcx?jumpToQczx=000&qczxid=" + qczxid + "&ryid=" + ryid
                    parent.location.href = url;
                });
            }
        );
    }

    //初始化迁出登记store
    var newres = new Array();
    var res = [];
    Ext.Msg.wait("正在加载数据...", "请稍后");
    hcyGrid.loadData({
        formdq: formdq,
        todq: todq,
        sqr_gmsfhm: sqr_gmsfhm,
        ywlsh: ywlsh
    }, function (st, r) {
        Ext.Msg.hide();
        res = r;
        if (res.length == 0) {
            b1.disable();
            showWarn("没有找到迁出人信息，可能已经被迁出！");
        } else {
            var qcdbdfw = "";
            for (var index = 0; index < res.length; index++) {
                var data = res[index].data;
                if (data.qcflag == "1") {
                    if (qcdbdfw == "" && data.qcdbdfw) {
                        qcdbdfw = data.qcdbdfw;
                    }

                    var pk = data[qcdjStore.pkname];
                    var r = new qcdjStore.reader.recordType({}, pk);
                    r.set(qcdjStore.pkname, pk);
                    //"kdqqy_zqz","kdqqy_qrdz","kdqqy_qyldyy","kdqqy_qczxlb"
                    if (data.kdqqy_zqz) r.set("zqzbh", data.kdqqy_zqz);
                    if (data.kdqqy_qrdz) r.set("qwdxz", data.kdqqy_qrdz);
                    if (data.kdqqy_qrdqh) r.set("qwdssxq", data.kdqqy_qrdqh);
                    if (data.kdqqy_qyldyy) r.set("qyldyy", data.kdqqy_qyldyy);
                    if (data.kdqqy_qczxlb) r.set("qclb", data.kdqqy_qczxlb);
                    if (data.bdfw) r.set("bdfw", data.bdfw);
                    r.set("qcrq", Ext.util.Format.date(new Date(), 'Ymd'));
                    if (qcdbdfw != "") {
                        r.set("bdfw", qcdbdfw);
                    }

                    newres.push(r);
                }
            }
            if (newres.length > 0)
                qcdjStore.add(newres);

            (function () {
                hcyGrid.fireEvent("rowclick", hcyGrid, 0);
                hcyGrid.getSelectionModel().selectRange(0, 0);
            }).defer(200);

            form10024.getForm().findField("qcrq").setMinValue(Ext.util.Format.date(new Date(), 'Ymd'));
        }
    }, function (st, err) {

    });
});