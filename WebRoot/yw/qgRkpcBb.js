var mbcontent = null;
var bbscData = null;
var name = null;
var pname = null;
var day = null;
var date = new Date();
var startDate = null;
var endDate = null;
var mc = user.dwmc;
var save_type = 1;//保存方式
var firstDay = Ext.util.Format.date(new Date(date.getFullYear(), date.getMonth(), 1), 'Ymd');
var lastDay = Ext.util.Format.date(new Date(date.getFullYear(), date.getMonth() + 1, 0), 'Ymd');

Ext.onReady(function () {

    var tabs = new Ext.TabPanel({
        id: 'parentTab',
        region: 'center',
        deferredRender: false,
        activeTab: 0,
        defaults: {
            autoScroll: false
        },
        items: [{
            title: '报表条件',
            id: 'bbtj',
            border: false,
            frame: false,
            width: 300,
            anchor: '100% 100%',
            margins: '0 0 0 0',
            cmargins: '0 0 0 0',
            html: "<OBJECT id=\"Cellin\"  WIDTH=100% HEIGHT=100%    classid=\"clsid:3F166327-8030-4881-8BD2-EA25350E574A\"  />"
        }, {
            title: '报表输出',
            id: 'bbsc',
            border: false,
            frame: false,
            width: 300,
            anchor: '100% 100%',
            margins: '0 0 0 0',
            cmargins: '0 0 0 0',
            html: "<OBJECT id=\"Cellout\"  WIDTH=100% HEIGHT=100%    classid=\"clsid:3F166327-8030-4881-8BD2-EA25350E574A\"  />"
        }
        ],
        listeners: {
            'tabchange': function (t, n) {
                // alert(n.getId());
                if (n.getId() == "bbsc") {
                    var cellout = document.getElementById("Cellout");
                    if (mbcontent != null) {
                        cellout.ReadFromBase64Str(mbcontent);
                        cellout.DeleteSheet(0, 1);
                        cellout.DeleteSheet(1, 1);
                    }

                    //this.hideTabStripItem(2);

                }

            }
        }
    });

    var borderPanel = new Ext.Panel({
        layout: 'border',
        defaults: {
            collapsible: true,
            split: false,
            bodyStyle: 'padding:15px'
        },
        items: [{
            region: 'north',
            height: 40,
            margins: '0px',
            cmargins: '0px',
            bodyStyle: 'padding:0px',
            frame: false,
            border: false,
            layout: 'fit',
            buttons: [
                new Ext.Button({
                    id: 'savebb',
                    text: '报表生成',
                    disabled: true,
                    minWidth: 60,
                    handler: function () {
                        //Ext.Msg.wait("正在执行查询，请稍后...");
                        var cellin = document.getElementById("Cellin");
                        var pulic_date = Ext.util.Format.date(new Date(), 'Y-m-d');
                        pulic_date = pulic_date.split("-");
                        var p_year = pulic_date[0];
                        var p_month = pulic_date[1];
                        var p_day = pulic_date[2];

                        //获取到查询的时间段
                        var begintime = cellin.GetCellString(2, 1, 0);
                        var endtime = cellin.GetCellString(2, 2, 0);

                        //Ext.Msg.wait("正在执行查询，请稍后...");
                        Gnt.submit(
                            {begintime: begintime, endtime: endtime},
                            "rkpc.do?method=queryQgRkpcxx",
                            "正在加载，请稍后...",
                            function (jsonData, params) {
                                //showInfo("加载成功!");
                                if (jsonData.list && jsonData.list.length > 0) {
                                    var list = jsonData.list;
                                    bbscData = list;
                                    tabs.setActiveTab(1);
                                    //获取到渲染数据tabs页
                                    var cellout = document.getElementById("Cellout");
                                    //将Base64字符串读入Cell 表中
                                    cellout.ReadFromBase64Str(mbcontent);
                                    //删除表页
                                    cellout.DeleteSheet(0, 1);
                                    cellout.DeleteSheet(1, 1);
                                    cellout.SetCurSheetEx("输出区");//指定当前的表页,根据页签名
                                    var index = cellout.GetSheetIndex("输出区");

                                    //设置填表人
                                    //cellout.SetCellString(12, 14, index, user.glyxm);
                                    //设置审核人
                                    //cellout.SetCellString(12, 2, index, user.glyxm);

                                    //设置末尾填表时间
                                    cellout.SetCellString(20, 16, index, p_year + "年" + p_month + "月" + p_day + "日填");
                                    if (list.length > 1) {
                                        var len = cellout.GetRows(index);
                                        if (len > 17) {
                                            cellout.DeleteRow(13, len - 17, index);//删除原始数据
                                        }

                                        cellout.InsertRow(13, list.length - 1, index);
                                    }
                                    var zdKeyArray = new Array("rkpcZhs", "rkpcZrs", "rkpcXcrks", "rkpcRhfls", "czhj", "rkpcCzwlf",
                                        "rkpcCzwlfJjs", "rkpcCswbhk", "rkpcCswbhkJjs", "rkpcCzhkQt", "rkpcCzhkQtJjs", "czhjjj",
                                        "zzhj", "rkpcZzrkJzbnys", "rkpcZzrkXdzzrks", "rkpcHkdjCdhkrs", "rkpcHkdjYxwxhks", "rkpcHkdjSwwx", "rkpcHkdjHkbgxms");
                                    var rkpcPaxs = Number('0');
                                    var rkpcXsaj = Number('0');
                                    var rkpcZaaj = Number('0');
                                    var rkpcZhtf = Number('0');
                                    var rkpcBgmfnet = Number('0');
                                    var rkpcJzgmsfzhmcch = Number('0');
                                    var rkpcZdmlp = Number('0');
                                    var rkpcQlfqdz = Number('0');
                                    var rkpcCdry = Number('0');
                                    var rkpcCdmj = Number('0');
                                    var rkpcGzhypx = Number('0');
                                    var rkpcCcjf = Number('0');

                                    for (var i = 0; i < list.length; i++) {
                                        var data = list[i];
                                        rkpcPaxs = rkpcPaxs + parseInt(data.rkpcPaxs == null || data.rkpcPaxs == '' ? 0 : data.rkpcPaxs);
                                        rkpcXsaj = rkpcXsaj + parseInt(data.rkpcXsaj == null || data.rkpcXsaj == '' ? 0 : data.rkpcXsaj);
                                        rkpcZaaj = rkpcZaaj + parseInt(data.rkpcZaaj == null || data.rkpcZaaj == '' ? 0 : data.rkpcZaaj);
                                        rkpcZhtf = rkpcZhtf + parseInt(data.rkpcZhtf == null || data.rkpcZhtf == '' ? 0 : data.rkpcZhtf);
                                        rkpcBgmfnet = rkpcBgmfnet + parseInt(data.rkpcBgmfnet == null || data.rkpcBgmfnet == '' ? 0 : data.rkpcBgmfnet);
                                        rkpcJzgmsfzhmcch = rkpcJzgmsfzhmcch + parseInt(data.rkpcJzgmsfzhmcch == null || data.rkpcJzgmsfzhmcch == '' ? 0 : data.rkpcJzgmsfzhmcch);
                                        rkpcZdmlp = rkpcZdmlp + parseInt(data.rkpcZdmlp == null || data.rkpcZdmlp == '' ? 0 : data.rkpcZdmlp);
                                        rkpcQlfqdz = rkpcQlfqdz + parseInt(data.rkpcQlfqdz == null || data.rkpcQlfqdz == '' ? 0 : data.rkpcQlfqdz);
                                        rkpcCdry = rkpcCdry + parseInt(data.rkpcCdry == null || data.rkpcCdry == '' ? 0 : data.rkpcCdry);
                                        rkpcCdmj = rkpcCdmj + parseInt(data.rkpcCdmj == null || data.rkpcCdmj == '' ? 0 : data.rkpcCdmj);
                                        rkpcGzhypx = rkpcGzhypx + parseInt(data.rkpcGzhypx == null || data.rkpcGzhypx == '' ? 0 : data.rkpcGzhypx);
                                        rkpcCcjf = rkpcCcjf + parseInt(data.rkpcCcjf == null || data.rkpcCcjf == '' ? 0 : data.rkpcCcjf);

                                        //设置序列
                                        cellout.D(2, 13 + i, index, i + 2);
                                        //设置单位
                                        cellout.SetCellString(1, 13 + i, index, Gnt.ux.Dict.getDictLable("DW", data.gsdw));
                                        for (var j = 0; j <= zdKeyArray.length; j++) {
                                            var str = zdKeyArray[j];
                                            //判断是否是合计
                                            if (str == "czhj") {
                                                var czhj1 = data.rkpcCzwlf == null ? 0 : data.rkpcCzwlf;
                                                var czhj2 = data.rkpcCswbhk == null ? 0 : data.rkpcCswbhk;
                                                var czhj3 = data.rkpcCzhkQt == null ? 0 : data.rkpcCzhkQt;
                                                cell.D(7, 13 + i, index, parseInt(czhj1) + parseInt(czhj2) + parseInt(czhj3));
                                            }

                                            //判断是否是合计
                                            if (str == "czhjjj") {
                                                var czhjjj1 = data.rkpcCzwlfJjs == null ? 0 : data.rkpcCzwlfJjs;
                                                var czhjjj2 = data.rkpcCswbhkJjs == null ? 0 : data.rkpcCswbhkJjs;
                                                var czhjjj3 = data.rkpcCzhkQtJjs == null ? 0 : data.rkpcCzhkQtJjs;
                                                cell.D(14, 13 + i, index, parseInt(czhjjj1) + parseInt(czhjjj2) + parseInt(czhjjj3));
                                            }
                                            //判断是否是合计
                                            if (str == "zzhj") {
                                                var zzhj1 = data.rkpcZzrkJzbnys == null ? 0 : data.rkpcZzrkJzbnys;
                                                var zzhj2 = data.rkpcZzrkXdzzrks == null ? 0 : data.rkpcZzrkXdzzrks;
                                                cell.D(15, 13 + i, index, parseInt(zzhj1) + parseInt(zzhj2));
                                            }
                                            //根据行数，列数进行数据填充
                                            if (data[str] != null && "" != data[str]) {
                                                cell.D(j + 3, 13 + i, index, data[str]);
                                            }
                                        }

                                    }
                                    //附记添加
                                    var fj = '附记：户口整顿工作期间提供破案线索 ' + rkpcPaxs + ' 条,';
                                    fj = fj + ' 破获刑事案件 ' + rkpcXsaj + ' 起,';
                                    fj = fj + ' 查处治安案件 ' + rkpcZaaj + ' 起,';
                                    fj = fj + ' 抓获逃犯 ' + rkpcZhtf + ' 人,';
                                    fj = fj + ' 解救被拐卖妇女儿童 ' + rkpcBgmfnet + ' 人,';
                                    fj = fj + ' 纠正公民身份证号码重错号 ' + rkpcJzgmsfzhmcch + ' 个,';
                                    fj = fj + ' 装订门楼牌 ' + rkpcZdmlp + ' 个,';
                                    fj = fj + ' 清理废弃地址 ' + rkpcQlfqdz + ' 个,';
                                    fj = fj + ' 组织实施过程中,抽调人员 ' + rkpcCdry + ' 人,';
                                    fj = fj + ' 其中民警 ' + rkpcCdmj + ' 人,';
                                    fj = fj + ' 组织工作会议培训 ' + rkpcGzhypx + ' 次,';
                                    fj = fj + ' 筹措经费 ' + rkpcCcjf + ' 万元。';

                                    cellout.SetCellString(1, 13 + list.length, index, fj);
                                    //设置截止统计日期
                                    var jz_year = endtime.substr(0, 4);
                                    var jz_month = endtime.substr(4, 2);
                                    var jz_day = endtime.substr(6, 2);
                                    cellout.SetCellString(1, 2, index, "(截止日期 " + jz_year + "年" + jz_month + "月" + jz_day + "日)");
                                    //末尾合计
                                    var num = 13 + list.length - 1;
                                    var sumCount = new Array("C","D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U");
                                    for (var i = 0; i <= sumCount.length; i++) {
                                        var str = sumCount[i];
                                        cellout.SetFormula(3 + i, 12, index, 'SUM(' + str + '13:' + str + num + ')');
                                    }


                                } else {
                                    showInfo("没有查到数据!");
                                }
                            }
                        );

                    }
                }),
                new Ext.Button({
                    id: 'add',
                    text: '报表保存',
                    minWidth: 60,
                    handler: function () {
                        var cellin = document.getElementById("Cellout");
                        cellin.Login("浙江金铖华元信息技术有限公司自定义报表-WEB版", "", "13040351", "1340-1275-0110-0004");
                        var index = cellin.GetSheetIndex("输出区");
                        if (index == -1) {
                            index = cellin.GetSheetIndex("输出页");
                        }
                        cellin.SaveFile();
                    }
                }),
                new Ext.Button({
                    id: 'dy',
                    text: '打印预览',
                    minWidth: 60,
                    handler: function () {
                        var cellin = document.getElementById("Cellout");
                        cellin.Login("浙江金铖华元信息技术有限公司自定义报表-WEB版", "", "13040351", "1340-1275-0110-0004");
                        var index = cellin.GetSheetIndex("输出区");
                        if (index == -1) {
                            index = cellin.GetSheetIndex("输出页");
                        }
                        cellin.PrintPreview(1, index);
                    }
                }),
                new Ext.Button({
                    id: 'bbprint',
                    text: '报表打印',
                    minWidth: 60,
                    handler: function () {
                        var cellin = document.getElementById("Cellout");
                        cellin.Login("浙江金铖华元信息技术有限公司自定义报表-WEB版", "", "13040351", "1340-1275-0110-0004");
                        //cellin.PrintSetCustomPaper(800,500,1);
                        var index = cellin.GetSheetIndex("输出区");
                        if (index == -1) {
                            index = cellin.GetSheetIndex("输出页");
                        }
                        cellin.PrintSheet(1, 0);
                    }
                }),
                new Ext.Button({
                    id: 'close',
                    text: '关闭',
                    minWidth: 60,
                    handler: function () {

                        window.parent.closeWorkSpace();
                    }
                })]
        }, {
            region: 'center',
            layout: 'border',
            collapsible: false,
            border: false,
            frame: false,
            //bodyStyle:'overflow:scroll;overflow-x:hidden',
            margins: '0',
            items: [tabs]

        }]

    });


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
            items: [borderPanel]
        }
    });

    //报表控件初始化工作
    onLoad();
});

function onLoad() {
    Gnt.initCellWeb('bbtj', 'Cellin');
    Gnt.initCellWeb('bbsc', 'Cellout');

    //初始化条件区
    var cellin = document.getElementById("Cellin");
    cellin.Login("浙江金铖华元信息技术有限公司自定义报表-WEB版", "", "13040351", "1340-1275-0110-0004");
    Gnt.submit(
        {},
        "ywbb.do?method=XtYwbbmbxxb",
        "正在加载，请稍后...",
        function (jsonData) {
            //showInfo("加载成功!");
            if (jsonData.success) {
                //获取报表模板内容
                Ext.getCmp("savebb").setDisabled(false);
                var ywbbmbxx = jsonData.list[0];
                cellin.ReadFromBase64Str(ywbbmbxx.resBbmb);

                mbcontent = ywbbmbxx.resBbmb;
                //查找条件区
                var tj_index = cellin.GetSheetIndex("条件区");

                cellin.SetSheetVisible(1, false);
                //隐藏第三sheet
                cellin.SetSheetVisible(2, false);
                //cellin.SetCurSheet(0);指定当前的表页,根据页签下标
                //指定当前的表页,根据页签名
                var isok = cellin.SetCurSheetEx("条件区");
                if (isok == "undefined") {
                    cellin.SetCurSheetEx("条件页");
                }
                cellin.SetCellDouble(2, 1, tj_index, getWeekStartDate());
                cellin.SetCellDouble(2, 2, tj_index, getWeekEndDate());
            }
        }
    );

    var now = new Date(); //当前日期
    var nowDayOfWeek = now.getDay(); //今天本周的第几天
    var nowDay = now.getDate(); //当前日
    var nowMonth = now.getMonth(); //当前月
    var nowYear = now.getYear(); //当前年
//获得本周的开始日期
    function getWeekStartDate() {
        var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
        return formatDate(weekStartDate);
    }

//获得本周的结束日期
    function getWeekEndDate() {
        var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
        return formatDate(weekEndDate);
    }

//格式化日期：yyyy-MM-dd
    function formatDate(date) {
        var myyear = date.getFullYear();
        var mymonth = date.getMonth() + 1;
        var myweekday = date.getDate();

        if (mymonth < 10) {
            mymonth = "0" + mymonth;
        }
        if (myweekday < 10) {
            myweekday = "0" + myweekday;
        }
        return (myyear + mymonth + myweekday);
    }

}



