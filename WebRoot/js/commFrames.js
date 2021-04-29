var _userinfo = null;
//本地字典加载
var _dictKey = "_dict_";
var _dictTempKey = "_dictTmp_";
var _sjpzKey = "_sjpz_";
//下列字段都必须二次加载
var _nodict = ",DWXXB,XZJDXXB,JWZRQXXB,JWHXXB,JLXXXB,YHXXB,_BLANK,JTCY,";

//缓存类型：mem 无缓存，sessionStorage 缓存到会话，localStorage 缓存到本地
var _cacheType = "mem";
if (window.sessionStorage) {
    _cacheType = "sessionStorage";
}
if (window.localStorage) {
    _cacheType = "localStorage";
}

_sys_catch_dictLocalData = {};
_sys_catch_sjpzData = {};
_sys_dictTempData = {};

//利用H5存储localStorage

//下拉字典
Gnt = {};
Gnt.Constants = {};
Gnt.ux = {};
Gnt.ux.Dict = {};
Gnt.ux.Dict.IgnoreLabel = "请从列表中选择";

Gnt.store = {};

/**
 * 提交数据
 */
Gnt.submit = function (data, url, waitmsg, success_callback, error_callback) {
    if (waitmsg != undefined && waitmsg != null && waitmsg != "")
        Ext.Msg.wait(waitmsg, "等待");
    else
        Ext.Msg.wait("操作正在执行中，请稍后...", "等待");

    Ext.Ajax.request({
        url: url,
        method: 'POST',
        params: data,
        success: function (result, request) {
            Ext.Msg.hide();
            var jsonData = Ext.util.JSON.decode(result.responseText);
            //alert(result.responseText);
            if (jsonData.success) {
                if (success_callback) {
                    success_callback(jsonData, data);
                } else {
                    if (jsonData.messages && jsonData.messages.length > 0) {
                        Ext.Msg.alert("提示", jsonData.messages[0]);
                    } else {
                        Ext.Msg.alert("提示", "操作执行成功！");
                    }
                }
            } else {
                if (error_callback) {
                    error_callback(jsonData, data);
                } else {
                    if (jsonData.messages && jsonData.messages.length > 0) {
                        showErr(jsonData.messages[0]);
                    } else {
                        showErr("操作执行失败！");
                    }
                }
            }
        },
        failure: function (result, request) {
            Ext.Msg.hide();
            showError(result.responseText);
        }
    });
}


Gnt.initCellWeb = function(id1,id2) {//区域外部id，区域内部控件id
    //alert(1);
    cell = document.getElementById(id2);
    var dom = document.getElementById(id1);
    if (cell) {
        if('GetSheetIndex' in cell){
            return;
        }else{
            html = ' <a href="zptest" target="_blank">下载报表控件</a>';
            dom.innerHTML = html;
            return;
        }
    }
};

Gnt.loadSjpzb = function (pzlb, error) {
    var su = false;
    var ary = pzlb.split(",");
    var list = new Array();

    for (var i = 0; i < ary.length; i++) {
        if (!Gnt.ux.Dict.existsPzlbData(ary[i])) {
            list[list.length] = ary[i];
        }
    }

    if (list.length == 0)
        return true;

    pzlb = list.join(",");

    Gnt.noAsyncAjax({
        url: "yw/dqdict.do?method=querySjpzb&pzlb=" + pzlb
    }, function (json) {
        su = true;
        if (json.list && json.list.length > 0) {
            var data = json.list[0];
            if (data.dictMap) {
                Gnt.ux.Dict.saveDictData(data.dictMap);
            }
            if (data.pzMap) {
                Gnt.ux.Dict.saveSjpzData(data.pzMap);
            }
        }
    }, error);

    return su;
}

//同步AJAX
Gnt.noAsyncAjax = function (config, success, error) {
    var conn = Ext.lib.Ajax.getConnectionObject().conn;
    conn.open("POST", config.url, false);
    conn.send(null);
    Ext.Msg.hide();

    var dict = {};

    var json = Ext.decode(conn.responseText);
    if (!json.success) {
        if (json.messages) {
            err = json.messages[0];
        } else {
            err = "操作失败！";
        }

        alert(err);

        if (error) error(err);
    } else {
        if (success) {
            success(json, config.me);
        }
    }
}

//从本地加载字典
Gnt.ux.Dict.getDictLocalData = function (visiontype) {
    var key = _dictKey + visiontype;
    if (_cacheType == "localStorage") {
        var str = localStorage.getItem(key);
        if (str)
            return Ext.decode(str);
        else
            return;
    } else if (_cacheType == "sessionStorage") {
        var str = sessionStorage.getItem(key);
        if (str)
            return Ext.decode(str);
        else
            return;
    } else {
        return _sys_catch_dictLocalData[key]
    }
}

//判断字典是否存在
Gnt.ux.Dict.existsDictLocalData = function (visiontype) {
    var key = _dictKey + visiontype;
    if (_cacheType == "localStorage") {
        if (localStorage.getItem(key))
            return true;
    } else if (_cacheType == "sessionStorage") {
        if (sessionStorage.getItem(key))
            return true;
    } else {
        if (_sys_catch_dictLocalData[key])
            return true;
    }

    return false;
}

//保存远程字典数据
Gnt.ux.Dict.saveDictData = function (dictData) {
    for (o in dictData) {
        var key = _dictKey + o;
        if (_cacheType == "sessionStorage")
            sessionStorage.setItem(key, Ext.encode(dictData[o]));
        else if (_cacheType == "localStorage")
            localStorage.setItem(key, Ext.encode(dictData[o]));
        else
            _sys_catch_dictLocalData[key] = dictData[o];
    }
}

/**
 * 缓存数据配置
 */
Gnt.ux.Dict.saveSjpzData = function (pzData) {
    for (o in pzData) {
        var key = _sjpzKey + o;

        if (_cacheType == "sessionStorage")
            sessionStorage.setItem(key, Ext.encode(pzData[o]));
        else if (_cacheType == "localStorage")
            localStorage.setItem(key, Ext.encode(pzData[o]));
        else
            _sys_catch_sjpzData[key] = pzData[o];
    }
}

Gnt.ux.Dict.existsPzlbData = function (pzlb) {
    var key = _sjpzKey + pzlb;

    if (_cacheType == "sessionStorage") {
        if (sessionStorage.getItem(key)) {
            return true;
        }
    } else if (_cacheType == "localStorage") {
        if (localStorage.getItem(key))
            return true;
    } else {
        if (_sys_catch_sjpzData[key])
            return true;
    }

    return false;
}

/**
 * 依据配置类别，获取配置数组
 */
Gnt.ux.Dict.getSjpzData = function (pzlb) {
    var key = _sjpzKey + pzlb;

    if (_cacheType == "sessionStorage") {
        var str = sessionStorage.getItem(key)
        if (str)
            return Ext.decode(str);
    } else if (_cacheType == "localStorage") {
        var str = localStorage.getItem(key)
        if (str)
            return Ext.decode(str);
    } else {
        return _sys_catch_sjpzData[key]
    }

    return;
}

//保存字典临时翻译
Gnt.ux.Dict.saveDictLable = function (visiontype, code, codename) {
    var key = _dictTempKey + visiontype + "_" + code;

    if (_cacheType == "sessionStorage") {
        sessionStorage.setItem(key, codename);
    } else if (_cacheType == "localStorage")
        localStorage.setItem(key, codename);
    else
        _sys_dictTempData[key] = codename;
}

//判断字典临时翻译是否存在
Gnt.ux.Dict.existsDictLable = function (visiontype, code) {
    var key = _dictTempKey + visiontype + "_" + code;
    if (_cacheType == "sessionStorage") {
        if (sessionStorage.getItem(key))
            return true;
    } else if (_cacheType == "localStorage") {
        if (localStorage.getItem(key))
            return true;
    } else {
        if (_sys_dictTempData[key])
            return true;
    }

    return false;
}

//翻译字典
Gnt.ux.Dict.getDictLable = function (visiontype, code) {
    var key = _dictTempKey + visiontype + "_" + code;
    if (_cacheType == "sessionStorage") {
        var name = sessionStorage.getItem(key);
        if (name)
            return name;
    } else if (_cacheType == "localStorage") {
        var name = localStorage.getItem(key);
        if (name)
            return name;
    } else {
        if (_sys_dictTempData[key])
            return _sys_dictTempData[key];
    }

    var codelist = Gnt.ux.Dict.getDictLocalData(visiontype);
    if (codelist && codelist.length > 0) {
        for (var i = 0; i < codelist.length; i++) {
            if (code == codelist[i].code) {
                Gnt.ux.Dict.saveDictLable(visiontype, code, codelist[i].codename);
                return codelist[i].codename;
            }
        }
    } else {
        return code;
    }
}

//翻译XZQH
Gnt.ux.Dict.getDictLableXzqh = function (queryName,visiontype, search_code, optype) {
    var key = _dictTempKey + search_code + "_" + optype;
    var name = "";
    if (_cacheType == "sessionStorage") {
        name = sessionStorage.getItem(key);
        if (name)
            return name;
    } else if (_cacheType == "localStorage") {
        name = localStorage.getItem(key);
        if (name)
            return name;
    } else {
        if (_sys_dictTempData[key])
            return _sys_dictTempData[key];
    }
    Gnt.noAsyncAjax({
        url: 'yw/dqdict.do?method=' + queryName + '&search_code=' + search_code + '&optype=' + optype+'&visiontype='+visiontype
    }, function (json) {
        if (json.list) {
            Gnt.ux.Dict.saveDictData(json.list);
        }
        var code = json.list[0];
        name = code.name;
    });
    return name;
}

//EXT3.0之后被AJAX被干掉同步配置async: false,4.0之后又放开
Ext.lib.Ajax.getConnectionObject = function () {
    var activeX = ['MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];

    function createXhrObject(transactionId) {
        var http;
        try {
            http = new XMLHttpRequest();
        } catch (e) {
            for (var i = 0; i < activeX.length; ++i) {
                try {
                    http = new ActiveXObject(activeX[i]);
                    break;
                } catch (e) {
                }
            }
        } finally {
            return {
                conn: http,
                tId: transactionId
            };
        }
    }

    var o;
    try {
        if (o = createXhrObject(Ext.lib.Ajax.transactionId)) {
            Ext.lib.Ajax.transactionId++;
        }
    } catch (e) {
    } finally {
        return o;
    }
};

//定义ajax，简化操作
var ajax_lastconfig = {};
var ajax = function (config) {
    ajax_lastconfig = config;

    Ext.Msg.wait(config.wait_msg ? config.wait_msg : "操作正在执行中，请稍后...", config.wait_title ? config.wait_title : "请稍后");

    Ext.Ajax.request({
        async: false,
        url: config.url, // 请求地址
        params: config.params, // 请求参数
        method: 'POST',
        callback: function (options, success, response) {
            // 调用回调函数
            Ext.MessageBox.hide();
            var json = response.responseText;

            if (success) {
                var json = Ext.decode(response.responseText);

                if (config.success && json.success) {
                    if (json.messages) {
                        showInfo(json.messages[0]);
                    }
                    return config.success(response, options, json)
                } else {
                    if (json.messages) {
                        err = json.messages[0];
                    } else {
                        err = "操作失败！";
                    }

                    if (json.success) {
                        showInfo(err);
                        return;
                    }
                }
            }

            if (config.error) {
                config.error(json);
            }
            showErr(err);
        }
    });
    return false;
};

//加载字典
Gnt.ux.Dict.loadDict = function (visiontypes, callback) {
    var dicts = new Array();

    if (Ext.isArray(visiontypes)) {
        for (var i = 0; i < visiontypes.length; i++) {
            if (!Gnt.ux.Dict.existsDictLocalData(visiontypes[i]))
                dicts.push(visiontypes[i]);
        }
    } else {
        for (name in visiontypes) {
            if (!Gnt.ux.Dict.existsDictLocalData(name))
                dicts.push(name);
        }
    }

    if (dicts.length <= 0) {
        if (callback)
            callback();
        return;
    }

    Gnt.noAsyncAjax({
        url: 'yw/dqdict.do?method=loadDcit&visiontypes=' + dicts.join(",")
    }, function (json) {
        if (json.dictMap) {
            Gnt.ux.Dict.saveDictData(json.dictMap);
        }

        if (callback)
            callback(json.dictMap);
    });
}

Gnt.isAllowBlank = function (pz, config) {
    //隐藏的不能作为必须录入
    if (pz.visibletype && pz.visibletype.indexOf("000") == 0)
        return true;

    //显示
    if (pz.displayname && pz.displayname != "")
        return pz.displayname.charAt(0) == "*" ? false : true;

    return true;
}

/**
 * 依据数据配置表记录获取Ext对象
 */
Gnt.getExtField = function (pz, config) {
    var f = {};
    f.name = pz.fieldname;
    f.fieldLabel = pz.displayname;
    f.columnWidth = (config.cols ? (1 / config.cols) : 0.25);
    f.anchor = "100%";
    f.xtype = "textfield";
    f.labelWidth = 120;
    if (pz.readonly == "1") {
        f.readOnly = true;
        f.disabled = true;
        f.bodyStyle = 'background-color:#F0F0F0';
    }

    if (pz.displayname && pz.displayname != "")
        f.allowBlank = Gnt.isAllowBlank(pz, config);

    if (!pz.visibletype || (pz.visibletype && pz.visibletype.indexOf("00") == 0)) {
        f.xtype = "hidden";
    } else {
        if (!pz.fieldtypename || pz.fieldtypename == null) {
            ;
        } else if (pz.fieldtypename == "dateedit") {
            //日期
            f.xtype = "datefield";
            f.altFormats = "Ymd|Y-m-d|Y/m/d";
            f.format = "Ymd";
        } else if (pz.fieldtypename == "codeedit") {
            f.dsname = pz.dsname.toUpperCase();
            f.xtype = "dict_combox";
            f.dict = "VisionType=" + f.dsname;

            //行政区划
            if (f.dsname.indexOf("XZQHB") == 0) {
                f.xtype = "tree_comboBox";
                f.searchUrl = "yw/dqdict.do?method=searchXzqh";
                f.treeUrl = "yw/dqdict.do?method=searchTreeXzqh";
            } else if ("DWXXB,XZJDXXB,JWZRQXXB,JWHXXB,JLXXXB,YHXXB".indexOf(f.dsname) >= 0) {
                f.xtype = "search_combox";
                f.searchUrl = "yw/dqdict.do?method=searchXxb&visiontype=" + f.dsname;
                f.valueField = "code";
                f.displayField = "name";
            } else if (f.dsname.indexOf("CS_") != 0) {
                //可选可输入
                f.forceSelection = false;
                f.selectOnFocus = false;
                f.xtype = "dict_combox_cust";
            } else {
                ;
            }
            if (pz.allowselfinput == '1') {
                //辅助录入
                f.editable = true;
                f.allowselfinput = '1';
                f.forceSelection = false;
                f.selectOnFocus = false;
            }

            if (f.dsname == "JTCY") {
                //家庭成员，特殊
                f.forceSelection = false;
                f.typeAhead = false;
            }
        }
    }

    //监视器
    f.listeners = {};
    f.listeners.change = config.fieldValueChange ? config.fieldValueChange : function () {
    };

    return f;
}

/**
 * 依据数据配置表记录获取Store的cols对象
 */
Gnt.getRecordField = function (pz, config) {
    var types = Ext.data.Types;

    var f = {
        name: pz.fieldname,
        type: "string"
    };

    if (pz.visibletype && pz.visibletype.indexOf("000") == 0) {
    } else {
        if (!pz.fieldtypename || pz.fieldtypename == null) {
        } else if (pz.fieldtypename == "dateedit") {
        } else if (pz.fieldtypename == "codeedit") {
        }
    }

    return f;
}

/**
 * 依据数据配置表获取form的items
 */
Gnt.getFormItems = function (config) {
    //Ext.Msg.wait("操作正在执行中，请稍后...", "请稍后");
    var pzlb = config.pzlb;
    var ary = Gnt.ux.Dict.getSjpzData(pzlb);
    var items = new Array();

    if (ary instanceof Array) {
        for (var i = 0; i < ary.length; i++) {
            var data = Gnt.getExtField(ary[i], config);
            if (data.xtype == "hidden") {
                ;//continue;
            }

            items.push(data);
        }
    } else {
        alert("配置" + pzlb + "本地缓存不存在！");
        items.push({
            xtype: 'hidden'
        });
    }

    return items;
}

Gnt.ux.Dict.getStoreList = function (smap, json) {
    var i = 0;
    var list = new Array();

    if (smap && smap.ignore != undefined && (smap.ignore == "true" || smap.ignore == true)) {
        list[0] = new Array();
        if (smap.ignoretext)
            list[0][1] = smap.ignoretext;
        else
            list[0][1] = Gnt.ux.Dict.IgnoreLabel;

        list[0][0] = "";
        i++;
    }

    if (smap.exclude)
        smap.exclude = "," + smap.exclude + ",";

    if (json && json.list) {
        var codelist = json.list;
        if (codelist && codelist.length > 0) {
            for (var i = 0; i < codelist.length; i++) {
                if (smap.exclude)
                    if (smap.exclude.indexOf("," + codelist[i].code + ",") >= 0)
                        continue;

                var len = list.length;
                list[len] = new Array();
                list[len][1] = codelist[i].code + " " + codelist[i].codename;
                list[len][0] = codelist[i].code;
            }
        }
    } else {
        var codelist = Gnt.ux.Dict.getDictLocalData(smap.VisionType);

        if (codelist && codelist.length > 0) {
            for (var i = 0; i < codelist.length; i++) {
                if (smap.exclude)
                    if (smap.exclude.indexOf("," + codelist[i].code + ",") >= 0)
                        continue;

                var len = list.length;
                list[len] = new Array();
                list[len][1] = codelist[i].code + " " + codelist[i].codename;
                list[len][0] = codelist[i].code;
            }
        } else {
            if (smap.VisionType != 'JTCY') {
                Gnt.ux.Dict.loadDict([smap.VisionType], function (dictmap) {
                    if (dictmap && dictmap[smap.VisionType]) {
                        var jsondata = {
                            list: dictmap[smap.VisionType]
                        };
                        return Gnt.ux.Dict.getStoreList(smap, jsondata);
                    } else {
                        //DWXXB,XZJDXXB,JWZRQXXB,JWHXXB,JLXXXB,YHXXB,
                        if (smap.VisionType != "_BLANK" && smap.VisionType.indexOf("CS_") == 0)
                            ;//alert("字典[" + smap.VisionType + "]数据未加载！");
                    }
                });
            }
        }
    }

    return list;
}

//普通下拉字典
//dict:"VisionType=CS_XB&def=4&ignore=false",
//dict:"methodName=listYwDqbm&def=4&ignore=false",
Gnt.ux.DictComboBox = Ext.extend(Ext.form.ComboBox, {
    fieldLabel: '处理状态',
    mode: 'local',
    triggerAction: 'all',
    valueField: "code",
    displayField: "name",
    emptyText: '请选择',
    typeAhead: true,
    selectOnFocus: true,
    editable: true,
    forceSelection: true,
    blankText: '请选择',
    lazyRender: true,
    constructor: function (c) {
        if (!c.listeners)
            c.listeners = {};

        c.listeners.render = function (cmp, eOpts) {
            if (!cmp.editable) {
                new Ext.KeyMap(cmp.el.dom, [{
                    key: Ext.EventObject.BACKSPACE,
                    fn: function (key, e) {
                        e.stopEvent();
                    }
                }]);
            }
        };

        Ext.apply(this, c);

        Gnt.ux.DictComboBox.superclass.constructor.call(this, c);
    },
    reloadDict: function () {
        this.store.removeAll();
        if (this.dict.methodName) {
            var url = 'yw/dqdict.do?method=' + this.dict.methodName + "&" + Ext.urlEncode(this.dict);
            //如果是调用方法，那么每次都动态请求
            Gnt.noAsyncAjax({
                url: url,
                me: this
            }, function (json, me) {
                var data = Gnt.ux.Dict.getStoreList(me.dict, json);
                me.store.loadData(data);
            });
        } else {
            this.store.loadData(Gnt.ux.Dict.getStoreList(this.dict));
        }
    },
    initComponent: function () {
        if (typeof this.dict == "string") {
            this.dict = Ext.urlDecode(this.dict);
        }

        var clbsStore = new Ext.data.SimpleStore({
            id: 0,
            fields: [{name: 'code', mapping: 0}, {name: 'name', mapping: 1}, {name: 'data', mapping: 2}],
            data: []
        });
        this.store = clbsStore;

        //特殊字典不需要二次加载
        if (_nodict.indexOf("," + this.dict.visionType + ",") < 0) {
            this.reloadDict();
        }

        Gnt.ux.DictComboBox.superclass.initComponent.call(this);
    }
});
Ext.reg('dict_combox', Gnt.ux.DictComboBox);

//自定义可编辑下拉框
Gnt.ux.DictComboBoxCust = Ext.extend(Gnt.ux.DictComboBox, {
    selectOnFocus: false,
    editable: true,
    forceSelection: true,
    constructor: function (c) {
        if (!c.listeners)
            c.listeners = {};

        c.listeners.select = function (combo, record, index) {
            var f = this.findParentByType("gnt_form");
            if (f && f.changeDictCust) {
                f.changeDictCust(combo, record);
            }
        };

        c.listeners.focus = function (event) {
            var f = this.findParentByType("gnt_form");
            if (f && f.getDictCust) {
                var list = f.getDictCust(this, this.dsname);
                if (list) {
                    this.store.removeAll();
                    this.store.loadData(list);
                }

                (function () {

                }).defer(100, this);
            } else {
                this.expand();
            }
        };

        Ext.apply(this, c);
        Gnt.ux.DictComboBoxCust.superclass.constructor.call(this, c);
    },
    initComponent: function (config) {
        Gnt.ux.DictComboBoxCust.superclass.initComponent.call(this);
    }
});
Ext.reg('dict_combox_cust', Gnt.ux.DictComboBoxCust);

//检索字典
Gnt.ux.SearchComboBox = Ext.extend(Ext.form.ComboBox, {
    fieldLabel: '检索',
    typeAhead: false,
    hideTrigger: false,
    queryParam: 'search_code',
    displayField: 'name',
    valueField: 'code',
    minChars: 2,
    forceSelection: true, //必须从搜索出来的下拉列表里面选择数据,不能自己随意输
    queryDelay: 600,
    matchFieldWidth: true,
    emptyText: "请输入检索关键字",
    storeLoad: function (res, setFlag) {
        var v = this.getValue();

        this.suspendEvents();
        this.setValue(v, setFlag);
        this.resumeEvents();

        //缓存
        for (var i = 0; i < res.length; i++) {
            Gnt.ux.Dict.saveDictLable(this.dsname, res[i].data[this.valueField], res[i].data[this.displayField]);
        }
    },
    setValue: function (v, setFlag) {
        if (v && v != "") {
            if (!this.store.getById(v)) {
                //判断缓存是否存在
                if (Gnt.ux.Dict.existsDictLable(this.dsname, v)) {
                    var label = Gnt.ux.Dict.getDictLable(this.dsname, v);
                    var data = {};
                    data[this.valueField] = v;
                    data[this.displayField] = label;

                    var data = {
                        "totalCount": 1,
                        "success": true,
                        "list": [
                            data
                        ]
                    };
                    this.store.suspendEvents();
                    this.store.loadData(data);
                    this.store.resumeEvents();
                } else {
                    //如果后台查询没有返回数据，进行二次加载的时候，防止循环调用
                    if (setFlag == "1")
                        ;
                    else
                        this.store.load({params: {search_code: v, optype: 'eq'}});
                }
            }
        }
        return Gnt.ux.SearchComboBox.superclass.setValue.call(this, v);
    },
    initComponent: function () {
        this.store = new Ext.data.JsonStore({
            url: this.searchUrl,
            combox: this,
            root: 'list',
            id: this.valueField,
            totalProperty: 'totalCount',
            fields: this.fields ? this.fields : [this.valueField, this.displayField],
            listeners: {
                beforeload: function (store, operation, eOpts) {
                    store.removeAll();
                    store.combox.setValue("");
                    if (store.combox && store.combox.getPostParams) {
                        var params = store.combox.getPostParams();
                        for (name in params)
                            store.baseParams[name] = params[name];
                    }
                    return true;
                },
                loadexception: function (mystore, options, response, error) {
                    if (error) {
                        var json = Ext.decode(response.responseText);
                        if (json.messages)
                            Ext.Msg.alert("提示", json.messages[0]);
                        else
                            Ext.Msg.alert("提示", error.message);
                    } else {
                        Ext.Msg.alert("提示", response.responseText);
                    }
                },
                load: function (store, res) {
                    if (store.combox && store.combox.storeLoad) {
                        //第二次加载，防止后台没有返回数据进入死循环
                        store.combox.storeLoad(res, "1");
                    }
                }
            }
        });
        Gnt.ux.SearchComboBox.superclass.initComponent.call(this);
    }
});
Ext.reg('search_combox', Gnt.ux.SearchComboBox);

//地区树结构
Gnt.ux.TreeComboBox = Ext.extend(Gnt.ux.SearchComboBox, {
    onTriggerClick: function (event) {
        if (!this.treeUrl)
            return;

        if (this.disabled || this.readOnly)
            return;

        if (!this.tree) {
            var root = new Ext.tree.AsyncTreeNode({
                text: '全国'
            });
            //定义树加载器，当点击leaf为false，但是又没有提供children
            //属性的节点时，将利用该树加载器查询节点信息
            var myTreeLoader = new Ext.tree.TreeLoader({
                dataUrl: this.treeUrl,
                listeners: {
                    loadexception: function (tree, node, response) {
                        Ext.Msg.alert("加载失败", response.responseText);
                    }
                }
            });

            myTreeLoader.on("beforeload", function (treeLoader, node) {
                //在beforeload事件中每次动态传递点击的节点的value属性作为参数
                if (node.attributes.xzqh && node.attributes.xzqh.dm)
                    this.baseParams.pid = node.attributes.xzqh.dm;
                else
                    this.baseParams.pflid = "";
            }, myTreeLoader);

            var tree = new Ext.tree.TreePanel({
                autoScroll: true,
                rootVisible: false,
                field: this,
                region: 'west',
                loader: myTreeLoader,
                width: 300,
                height: 400,
                setCheck: function (node, checked) {
                    var tree = node.getOwnerTree();
                    var field = tree.field;
                    if (checked) {
                        //如果选择，那么判断
                        if (field.selMode == undefined || field.selMode == 'single') {
                            //单选
                            var nodes = tree.getChecked();
                            for (var i = 0; i < nodes.length; i++) {
                                if (nodes[i] != node) {
                                    //取消之前的选择
                                    var ui = nodes[i].getUI();
                                    if (ui.isChecked()) {
                                        ui.toggleCheck(false);
                                    }
                                }
                            }
                        }
                    }
                },
                listeners: {
                    click: function (node, e) {
                        var tree = node.getOwnerTree();
                        var ui = node.getUI();
                        ui.toggleCheck(!ui.isChecked());

                        tree.setCheck(node, ui.isChecked());
                    },
                    checkchange: function (node, checked) {
                        var tree = node.getOwnerTree();
                        tree.setCheck(node, checked);
                    }
                }
            });

            tree.setRootNode(root);
            tree.getRootNode().expand();

            this.tree = tree;

            var treeWindow = new Ext.Window({
                title: '选择地区',
                closeAction: 'hide',
                modal: true,
                width: 420,
                height: 400,
                layout: 'fit',
                items: tree,
                buttons: [{
                    text: '确定',
                    handler: function (b, e) {
                        var win = b.findParentByType("window");
                        var tree = win.items.get(0);
                        var field = tree.field;

                        var nodes = tree.getChecked();
                        if (!field.allowBlank) {
                            if (nodes.length == 0) {
                                showInfo(field.fieldLabel + "不能为空！");
                                return;
                            }
                        }

                        var text = "", value = "";
                        for (var i = 0; i < nodes.length; i++) {
                            if (text != "") {
                                text += ",";
                                value += ",";
                            }
                            text += nodes[i].attributes.text;
                            value += nodes[i].attributes.codevalue;
                        }
                        var store = field.store;
                        store.removeAll();

                        var data = {};
                        data[field.valueField] = value;
                        data[field.displayField] = text;

                        var res = {"totalCount": 1, "success": true, "list": [data]};
                        store.loadData(res);
                        var oldvalue = field.getValue();

                        field.setValue(value);
                        field.fireEvent("change", field, value, oldvalue);

                        win.hide();
                    }
                }, {
                    text: '取消',
                    handler: function (b, e) {
                        var win = b.findParentByType("window");
                        win.hide();
                    }
                }]
            });

            this.win = treeWindow;
        }
        this.win.show();
    }
});
Ext.reg('tree_comboBox', Gnt.ux.TreeComboBox);

/**
 * 通用grid
 */
Gnt.ux.GntGrid = Ext.extend(Ext.grid.GridPanel, {
    region: 'center',
    autoScroll: true,
    title: '',
    stripeRows: true,
    loadMask: {msg: '正在加载数据，请稍侯……'},
    bodyStyle: 'width:100%',
    border: false,
    anchor: '100% 100%',
    margins: '5 0 0 0',
    frame: false,
    loadData: function (data) {
        delete this.store.isinit;

        this.store.baseParams = data;
        this.store.load({params: {start: 0, limit: this.pageSize}});
    },
    //iconCls:'icon-grid',
    initComponent: function () {
        if (!this.pzlb) {
            alert("必须提供pzlb参数！");
            return;
        }

        var pzlist = Gnt.ux.Dict.getSjpzData(this.pzlb);
        if (!pzlist || pzlist.length < 1) {
            alert("配置" + this.pzlb + "没有找到！")
            return;
        }

        //store的fields参数
        var fields = new Array();
        //grid的columns参数
        var columns = new Array();
        var csm = new Ext.grid.CheckboxSelectionModel({singleSelect: true});
        //columns.push(csm);

        var ispkname = false;
        if (this.pk && this.pk != "") {
            this.pkname = this.pk;
        }

        if (this.pkname && this.pkname != "" && !this.pk) {
            this.pk = this.pkname;
        }

        for (var i = 0; i < pzlist.length; i++) {
            var item = pzlist[i];

            //是否存在指定的主键
            if (item.fieldname == this.pkname) {
                ispkname = true;
            }

            fields.push(item.fieldname);
            if (item.visibletype && item.visibletype.indexOf("00") != 0) {
                //Gnt.ux.Dict.getDictLable=function(visiontype,code)
                //dsname
                if (item.dsname) {
                    var col = {
                        header: item.displayname,
                        dataIndex: item.fieldname,
                        sortable: true,
                        width: 100
                    };

                    var renderer = "col.renderer=function(value, cellmeta, record, rowIndex,columnIndex, store){"
                        + "	return Gnt.ux.Dict.getDictLable('" + item.dsname.toUpperCase() + "',value);"
                        + "}";
                    eval(renderer);

                    columns.push(col);
                } else {
                    var col = {
                        header: item.displayname,
                        dataIndex: item.fieldname,
                        sortable: true,
                        renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
                            return value;
                        },
                        width: 100
                    };
                    columns.push(col);
                }
            }
        }

        if (!ispkname) {
            //不存在指定的主键
            if (this.pk && this.pk != "") {
                fields.push(this.pk);
            } else {
                this.pk = pzlist[0].fieldname;
                this.pkname = this.pk;
            }
        }

        var store = new Ext.data.JsonStore({
            url: this.url,
            root: 'list',
            isinit: '0',
            loadCallback: this.loadCallback ? this.loadCallback : function () {
            },
            id: (this.pk ? this.pk : fields[0]),
            totalProperty: 'totalCount',
            fields: fields,
            listeners: {
                beforeload: function (store, options) {
                    if (store.isinit) {
                        Ext.Msg.alert("提示", "请先执行查询！");
                        return false;
                    }
                    return true;
                },
                load: function (store, res) {
                    Ext.Msg.hide();
                    if (store.loadCallback)
                        store.loadCallback(store, res);
                },
                loadexception: function (mystore, options, response, error) {
                    if (error) {
                        var json = Ext.decode(response.responseText);
                        if (json.messages)
                            Ext.Msg.alert("提示", json.messages[0]);
                        else
                            Ext.Msg.alert("提示", error.message);
                    } else {
                        Ext.Msg.alert("提示", response.responseText);
                    }
                }
            }
        });

        var pageSize = this.pageSize ? this.pageSize : 20;

        var model = new Ext.grid.ColumnModel(columns);
        if (this.showPaging) {
            this.bbar = new Ext.PagingToolbar({
                pageSize: pageSize,
                store: store,
                displayInfo: true
            });
        }
        this.view = new Ext.grid.GridView({
            forceFit: false,
            autoFill: false,
            enableRowBody: true
        });
        this.store = store;
        this.colModel = model;
        this.sm = csm;
        this.pageSize = pageSize;

        Gnt.ux.GntGrid.superclass.initComponent.call(this);
    }
});
Ext.reg('gnt_grid', Gnt.ux.GntGrid);

/**
 * 通用form
 */
Gnt.ux.GntForm = Ext.extend(Ext.form.FormPanel, {
    margins: '5px 5px 5px 5px',
    region: 'center',
    autoScroll: true,
    title: '查询条件',
    buttonAlign: 'bouth',
    labelAlign: 'right',
    frame: false,
    border: false,
    defaults: {
        frame: false,
        border: false
    },
    loadData: function (data) {
        this.store.baseParams = data;
        this.store.load({params: {start: 0, limit: this.pagesize}});
    },
    getDictCust: function (cmbo, versiontype) {
        //为可编辑下拉框提供数据
        return;
    },
    changeDictCust: function () {
        //可编辑下拉框改变值的
    },
    listeners: {
        render: function (f) {
            /*
            (function(){
                var all = this.el.query('input[type!=hidden]');
                Ext.each(all, function(o, i, all) {
                    Ext.fly(o).addKeyMap({
                        key : 13,
                        fn : function(){
                            event.keyCode = 9;
                            return true;
                        }
                    })
                });
            }).defer(500, this);
            */
        }
    },
    buttonAlign: 'right',
    //判断关联store输入是否满足
    checkInput: function () {
        /**
         * 判断比较复杂，this.bindStore不一定具有GRID，所以这里还必须通过this.bindViewGrid来绑定
         * 一个GRID, this.bindStore和this.bindViewGrid，必须具有相同的pk值
         */
        if (!this.pzlb) {
            alert("没有通过pzlb参数指定配置类别！")
            return false;
        }

        if (!this.bindViewGrid) {
            //bindViewGrid.store和this.bindStore必须具有相同的字段作为pk
            alert("没有通过bindViewGrid参数指定绑定的GRID！")
            return false;
        }

        //获取配置
        var ary = Gnt.ux.Dict.getSjpzData(this.pzlb);

        if (this.bindStore) {
            var count = this.bindStore.getCount();
            for (var index = 0; index < count; index++) {
                //遍历绑定store的记录
                var r = this.bindStore.getAt(index);
                var data = r.data;

                for (var i = 0; i < ary.length; i++) {
                    //遍历配置，判断当前配置是否必须录入
                    var isAllowBlank = Gnt.isAllowBlank(ary[i], ary);
                    if (isAllowBlank)
                        continue;

                    var name = ary[i].fieldname;

                    //必须录入，判断是否为空
                    if (data[name] == undefined || data[name] == "") {
                        //获取主键值
                        var pkvalue = data[this.bindStore.id];
                        //获取绑定grid对应store的记录
                        var bindGridRecord = this.bindViewGrid.store.getById(pkvalue);
                        if (bindGridRecord) {
                            //找到对应grid记录，选择，并且触发rowclick动作
                            var selindex = this.bindViewGrid.store.indexOf(bindGridRecord);
                            this.bindViewGrid.getSelectionModel().selectRange(selindex, selindex);
                            this.bindViewGrid.fireEvent("rowclick", this.bindViewGrid, selindex);
                        } else {
                            continue;
                        }

                        //当前form初始化
                        this.getForm().reset();
                        this.getForm().loadRecord(r);
                        this.getForm().isValid();

                        //提示，确定后设置焦点
                        var field = this.getForm().findField(name);
                        var msg = this.title + "【" + ary[i].displayname + "】不能为空！"

                        Ext.MessageBox.show({
                            title: "提示",
                            msg: msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.Msg.ERROR,
                            fn: function () {
                                field.focus(true, 100);
                            }
                        });

                        //返回
                        return false;
                    }
                }
            }
        } else {
            return true;
        }

        return true;
    },
    //值改变的时候给store赋值
    fieldValueChange: function (field, newValue, oldValue) {
        var f = field.findParentByType("gnt_form");
        var store = f.bindStore;
        if (store) {
            //编辑事件，自动填充store
            var pkvalue = f.getForm().findField(store.pkname ? store.pkname : store.id).getValue();
            var re = store.getById(pkvalue);
            if (!re) {
                re = new store.reader.recordType({}, pkvalue);
                store.add([re]);
            }

            if (Ext.isDate(newValue)) {
                newValue = Ext.util.Format.date(newValue, "Ymd");
            }

            re.set(field.name, newValue);
        }
    },
    initComponent: function () {
        var me = this;
        var cols = me.cols;

        if (me.pzlb) {
            me.fields = Gnt.getFormItems(me);
        }

        var fieldMap = {};

        if (me.fields && !me.items) {
            var items = [{
                layout: 'column',
                //xtype : 'fieldset',
                title: '',
                margins: '0',
                bodyStyle: 'padding:5px 20px 0px 0px',
                defaults: {
                    frame: false,
                    border: false,
                    labelWidth: me.labelWidth ? me.labelWidth : 100,
                    bodyStyle: 'padding:0px 0px 0px 0px'
                },
                items: []
            }];

            for (var i = 0; i < me.fields.length; i++) {
                var item = me.fields[i];

                fieldMap[item.name] = item.fieldLabel;

                if (item.title != undefined) {
                    if (i != 0) {
                        items.push({
                            layout: 'column',
                            xtype: 'fieldset',
                            title: item.groupTitle,
                            checkboxToggle: true,
                            bodyStyle: 'padding:5px 20px 0px 0px',
                            defaults: {
                                frame: false,
                                border: false,
                                labelWidth: me.labelWidth ? me.labelWidth : 100,
                                bodyStyle: 'padding:1px 1px 1px 1px'
                            },
                            items: []
                        });
                    }

                    item.checkboxToggle = true;
                    item.title = '<span style="color:blue">' + item.title + '<span>'

                    Ext.apply(items[items.length - 1], item);

                    continue;
                }

                //只读
                if (item.readOnly != undefined && item.readOnly) {
                    if (!item.listeners) {
                        item.listeners = {};
                    }
                }

                //隐藏
                if (item.xtype == 'hidden') {
                    items[items.length - 1].items.push(item);
                    continue;
                }
                //anchor:'100%',
                if (!item.anchor) item.anchor = "100%";
                if (!item.xtype) item.xtype = 'textfield';

                if (item.labelWidth)
                    ;
                else
                    item.labelWidth = me.labelWidth ? me.labelWidth : 100;

                if (item.allowBlank != undefined && !item.allowBlank && item.fieldLabel) {
                    item.fieldLabel = '<span style="color:red">' + item.fieldLabel + "</span>";
                }

                items[items.length - 1].items.push({
                    layout: 'form',
                    //bodyStyle:'padding:0 0 0 0',
                    columnWidth: me.fields[i].columnWidth,
                    items: [item]
                });
            }

            this.items = items;
        }

        this.fieldMap = fieldMap;
        Gnt.ux.GntForm.superclass.initComponent.call(this);
    },
    //获取指定域中文名称
    getFieldLabel: function (field) {
        if (this.fieldMap && this.fieldMap[field])
            return this.fieldMap[field];
        return field;
    }
});
Ext.reg('gnt_form', Gnt.ux.GntForm);

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

function openWorkSpace(tabs, isclose, url, name, key, desc, parm) {
    //var tabs = Ext.getCmp("tabs");
    //如果文件已经打开，那么设置为活动分页，并返回
    if (!tabs.findById(key)) {
        var p = createWorkSpace(isclose, url, name, key, desc, parm);

        //添加分页，并且设置为活动分页
        tabs.add(p);
        tabs.setActiveTab(p);
        return;
    } else {
        var id = 'iframe-' + key;
        var el = Ext.get(id);
    }

    //推荐使用key，而不是使用p来激活页面，否则很可能发生脚本错误
    tabs.setActiveTab(key);
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

function closeCurrentWorkSpace() {
    var p = tabs.getActiveTab();
    tabs.remove(p);
}

//释放iframe占用资源
function fixIFrame(o, p) {
    var iFrame = p.getEl().dom;
    if (iFrame.src) {
        iFrame.src = "javascript:false";
    }
}

function showErr(err, callback) {
    var obj = {
        msg: err, fn: callback ? callback : function () {
        }
    };

    (function () {
        Ext.MessageBox.show({
            title: '错误提示',
            msg: this.msg,
            buttons: Ext.MessageBox.OK,
            icon: Ext.MessageBox.ERROR,
            fn: this.fn
        });
    }).defer(100, obj);
}

//消息显示窗口
function showInfo(msg, callback) {
    var obj = {msg: msg, fn: callback};

    (function () {
        Ext.MessageBox.show({
            title: '提示',
            msg: this.msg,
            buttons: Ext.MessageBox.OK,
            icon: Ext.MessageBox.INFO,
            fn: this.fn
        });
    }).defer(100, obj);
}

//警告显示窗口
function showWarn(msg, callback) {
    var obj = {msg: msg, fn: callback};

    (function () {
        Ext.MessageBox.show({
            title: '警告',
            msg: this.msg,
            buttons: Ext.MessageBox.OK,
            icon: Ext.MessageBox.Warn,
            fn: this.fn
        });
    }).defer(100, obj);
}

function showQuestion(msg, callback) {
    var obj = {msg: msg, fn: callback};

    Ext.Msg.show({
        title: '确认?',
        msg: msg,
        buttons: Ext.Msg.YESNO,
        icon: Ext.Msg.QUESTION,
        fn: callback
    });
}

function showInput(msg, def, callback) {
    Ext.MessageBox.prompt('提示', msg, function(btnType, value) {
        if (btnType == "ok") {
            callback(value);
        }
    }, window, 100, def);
}

function showObject(obj) {
    var str = "";
    for (o in obj)
        str += "o=" + obj[o] + ";";

    showInfo(str);
}

function getQueryParam(name) {
    var regex = RegExp('[?&]' + name + '=([^&]*)');

    var match = regex.exec(location.search);
    return match && decodeURIComponent(match[1]);
}

// 获取用户信息
Gnt.ux.Dict.getUser = function (callback) {
    if (_userinfo) {
        if (callback)
            callback(_userinfo);

        return;
    }

    Gnt.submit({}, "login.do?method=getUserInfo", "获取用户信息，请稍后...", function (jsonData,
                                                                             params) {
        _userinfo = jsonData.list[0];
        if (!_userinfo) {
            showErr("用户已经过期！");
            return;
        }

        if (callback) {
            callback(_userinfo);
        }
    });
}

Gnt.ux.isEmpty = function(obj) {
    if (obj == undefined || obj == "" || Gnt.util.trim(obj) == "")
        return true;

    if (Ext.isArray(obj)) {
        if (obj.length == 0)
            return true;
    }

    var count = 0;
    for (o in obj) {
        if (obj[o] != "") {
            count++;
        }
    }
    if (count == 0)
        return true;

    return false;
}


function IdCard(UUserCard, num) {
    if (num == 1) {
        //获取出生日期
        birth = UUserCard.substring(6, 10) + "-" + UUserCard.substring(10, 12) + "-" + UUserCard.substring(12, 14);
        return birth;
    }
    if (num == 2) {
        //获取性别
        if (parseInt(UUserCard.substr(16, 1)) % 2 == 1) {
            //男
            return "男";
        } else {
            //女
            return "女";
        }
    }
    if (num == 3) {
        //获取年龄
        var myDate = new Date();
        var month = myDate.getMonth() + 1;
        var day = myDate.getDate();
        var age = myDate.getFullYear() - UUserCard.substring(6, 10) - 1;
        if (UUserCard.substring(10, 12) < month || UUserCard.substring(10, 12) == month && UUserCard.substring(12, 14) <= day) {
            age++;
        }
        return age;
    }
}
Gnt.ux.URLDialog = Ext.extend(Ext.Window, {
	title : '浏览器',
	closeAction : 'close',
	modal : true,
	width : 500,
	height : 320,
	margins : '5',
	layout : 'fit',
	buttons : [ {
		text : '关闭',
		xtype : "button",
		minWidth : 75,
		handler : function() {
			var win = this.findParentByType("url_dialog");
			if (win.callback) {
				var re = win.callback();
				if (re == false) {
					return;
				}

				win.hide();
			} else {
				win.hide();
			}
		}
	} /*
		 * , { text:'取消', xtype:"button", minWidth:75, handler:function(){ var
		 * win = this.findParentByType("url_dialog"); win.hide(); } }
		 */
	],
	openUrl : function(config) {
		var me = this;

		(function() {
			var mgr = new Ext.Updater(me.panel.body, true);
			mgr.loadScripts = true;
			mgr.update({
				url : config.url,
				text : "正在准备内容，请等待...",
				params : config.params,
				method : 'POST'
			});
		}).defer(200);
	},
	initComponent : function() {
		var p = new Ext.ux.IFrameComponent({
			id : new Date().getTime() + '_url_panel_',
			title : '',
			url : this.url
		});

		this.panel = p;
		this.items = [ p ];

		Gnt.ux.URLDialog.superclass.initComponent.call(this);
	}
});
Ext.reg('url_dialog', Gnt.ux.URLDialog);
function SetReadOnly(form, fieldname, isReadOnly) {
    var f = form.getForm().findField(fieldname);
    if (f) {
        if (isReadOnly) {
            //f.disable();
//			f.fieldClass="x-form-field x-item-readonly";
            f.addClass("x-item-readonly");
            f.el.dom.readOnly=true;
//			f.el.dom.typeAhead=false;
//			f.el.dom.editable=false;
            f.typeAhead=false;
            f.editable=false;
            f.disabled = true
        } else {
            f.el.dom.readOnly=false;
            f.enable();
        }
    } else {
        alert("字段" + fieldname + "没找到！")
    }
};
Gnt.yw = {};

// 通用：查询户地信息
Gnt.yw.queryHdxx = function(config) {
    Gnt.submit({
        hhnbid : config.hhnbid,
        dqbm:config.dqbm
    }, "yw/kdqqy.do?method=queryHdxx", "查询户地信息，请稍后...", function(jsonData, params) {
        if (config.callback) {
            config.callback(jsonData.list[0], jsonData.list[1]);
        }
    });
};
// 设置表单只读
Gnt.toFormReadyonly = function(form) {
    var ary = Gnt.ux.Dict.getSjpzData(form.pzlb);
    for (var i = 0; i < ary.length; i++) {
        var fname = ary[i].fieldname;
        SetReadOnly(form, fname, true);
    }
}

Gnt.date = {
    isIDCard : function(editorValue) {
        var num = editorValue;
        var len = num.length;
        var re = null;

        if (len == 15) {
            if (isNaN(num)) {
                return "输入的身份证号不是数字！";
            }
            re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
        } else if (len == 18) {
            if (isNaN(num)) {
                if (isNaN(num.substr(0, 17))) {
                    return "输入的身份证号不是数字！";
                }
            }
            re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
        } else {
            return "输入的身份证号数字位数不对！";
        }

        var a = num.match(re);
        if (a != null) {
            if (len == 15) {
                var D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]);
                var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4]
                    && D.getDate() == a[5];
            } else {
                var D = new Date(a[3] + "/" + a[4] + "/" + a[5]);
                var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4]
                    && D.getDate() == a[5];

            }
            if (!B) {
                return "输入的身份证号 " + a[0] + " 里出生日期不对！";
            }
        }

        if (len == 18) {
            if (!this.isCheckCode(num)) {
                return "输入的身份证号与校验码不符！ ";
            }
        }
        return true;
    },
    isCheckCode : function(num) {
        var checkCodes = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4",
            "3", "2");
        var mulFactors = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
            8, 4, 2, 1);
        var iPtr = null;

        var i = 0;

        for (i = 0; i < 17; i++) {
            iPtr = iPtr + parseInt(num.substr(i, 1)) * parseInt(mulFactors[i]);
        }
        iPtr = iPtr % 11;
        if (checkCodes[iPtr] != num.substr(17, 1)) {
            showInfo("身份证号码校验位错误！<br />应该是:" + checkCodes[iPtr] + " !");
            return false;
        }

        return true;
    },
    checkIDCardSex : function(IdCardNo, Sex) {
        var vSex = "";

        switch (IdCardNo.length) {
            case 15: {
                vSex = IdCardNo.substring(IdCardNo.length - 1);
                break;
            }
            case 18: {
                vSex = IdCardNo.substring(IdCardNo.length - 2, IdCardNo.length - 1);
                break;
            }
            default: {
                return "身份证号码格式不正确!";
            }
        }
        if ((vSex % 2) == 0)
            vSex = 2;
        else
            vSex = 1;

        if (vSex != Sex) {
            return "身份证号码与性别不匹配!"
        }

        return true;
    },
    checkIDCardBirth : function(IdCardNo, Birth) {
        var vBirth = "";

        var vDay = Birth.substring(6, 8);// 日
        var vMonth = Birth.substring(4, 6);
        var vYear = Birth.substring(0, 4);
        if (!this.isValidDate(vDay, vMonth, vYear)) {
            return "出生日期格式不正确!"
        }
        switch (IdCardNo.length) {
            case 15: {
                vBirth = "19" + IdCardNo.substring(6, 12);
                break;
            }
            case 18: {
                vBirth = IdCardNo.substring(6, 14);
                break;
            }
            default: {
                return "身份证号码长度不正确!"
            }
        }
        if (vBirth != Birth) {
            return "身份证号码与出生日期不匹配!";
        }

        return true;
    },
    isValidDate : function(day, month, year) {
        if (day.length < 1 && month.length < 1 && year.length < 1)
            return true;

        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11)
            && (day == 31)) {
            return false;
        }
        if (month == 2) {
            var leap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
            if (day > 29 || (day == 29 && !leap)) {
                return false;
            }
        }
        return true;
    },
    // 身份证校验
    validateCard : function(strIdCard, strSexCode, strBirthday) {
        tmp = this.isIDCard(strIdCard);
        if (tmp != true) {
            // 返回错误内容
            return tmp;
        }

        if (strSexCode && (strSexCode == "1" || strSexCode == "2")) {
            tmp = this.checkIDCardSex(strIdCard, strSexCode)
            if (tmp != true) {
                // 返回错误内容提示
                return tmp;
            }
        }

        if (strBirthday && strBirthday != null) {
            tmp = this.checkIDCardBirth(strIdCard, strBirthday);
            if (tmp != true) {
                // 返回错误提示
                return tmp;
            }
        }

        return true;
    },
    /* 根据出生日期算出年龄 */
    getNl : function(sfz, csrq) {
        var csrq2 = null;

        if (sfz && (sfz.length == 15 || sfz.length == 18)) {
            csrq2 = this.getBirth(sfz);
            return this.jsGetAge(csrq2);
        }

        if (csrq && csrq.length >= 8) {
            return this.jsGetAge(csrq);
        }

        return -1;
    },
    jsGetAge : function(strBirthday) {
        var returnAge;
        var birthYear = strBirthday.substring(0, 4);
        var birthMonth = strBirthday.substring(4, 6);
        var birthDay = strBirthday.substring(6, 8);

//		d = new Date();
//		var nowYear = d.getFullYear();
//		var nowMonth = d.getMonth() + 1;
//		var nowDay = d.getDate();
        var nowYear = sysDate.substr(0,4);
        var nowMonth = sysDate.substr(4,2);
        var nowDay = sysDate.substr(6,2);

        if (nowYear == birthYear) {
            returnAge = 0;// 同年 则为0岁
        } else {
            var ageDiff = nowYear - birthYear; // 年之差
            if (ageDiff > 0) {
                if (nowMonth == birthMonth) {
                    var dayDiff = nowDay - birthDay;// 日之差
                    if (dayDiff < 0) {
                        returnAge = ageDiff - 1;
                    } else {
                        returnAge = ageDiff;
                    }
                    // alert(returnAge);
                } else {
                    var monthDiff = nowMonth - birthMonth;// 月之差
                    if (monthDiff < 0) {
                        returnAge = ageDiff - 1;
                    } else {
                        returnAge = ageDiff;
                    }
                }
            } else {
                returnAge = -1;// 返回-1 表示出生日期输入错误 晚于今天
            }
        }
        return returnAge;// 返回周岁年龄
    },
    getNlc : function(starDate, endDate) {
        var returnAge;
        var birthYear = starDate.substring(0, 4);
        var birthMonth = starDate.substring(4, 6);
        var birthDay = starDate.substring(6, 8);

        var nowYear = endDate.substring(0, 4);
        var nowMonth = endDate.substring(4, 6);
        var nowDay = endDate.substring(6, 8);

        if (nowYear == birthYear) {
            returnAge = 0;// 同年 则为0岁
        } else {
            var ageDiff = nowYear - birthYear; // 年之差
            if (ageDiff > 0) {
                if (nowMonth == birthMonth) {
                    var dayDiff = nowDay - birthDay;// 日之差
                    if (dayDiff < 0) {
                        returnAge = ageDiff - 1;
                    } else {
                        returnAge = ageDiff;
                    }
                    // alert(returnAge);
                } else {
                    var monthDiff = nowMonth - birthMonth;// 月之差
                    if (monthDiff < 0) {
                        returnAge = ageDiff - 1;
                    } else {
                        returnAge = ageDiff;
                    }
                }
            } else {
                returnAge = -1;// 返回-1 表示出生日期输入错误 晚于今天
            }
        }
        return returnAge;// 返回周岁年龄
    },
    getBirth : function(sfz) {
        IdCardNo = sfz;
        vBirth = "";
        switch (IdCardNo.length) {
            case 15: {
                vBirth = "19" + IdCardNo.substring(6, 12);
                break;
            }
            case 18: {
                vBirth = IdCardNo.substring(6, 14);
                break;
            }
        }

        return vBirth;
    },
    getCheckCode : function(num) {

        if (num.length == 17) {

            var checkCodes = new Array("1", "0", "X", "9", "8", "7", "6", "5",
                "4", "3", "2");
            var mulFactors = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10,
                5, 8, 4, 2, 1);
            var iPtr = null;

            var i = 0;

            for (i = 0; i < 17; i++) {
                iPtr = iPtr + parseInt(num.substr(i, 1))
                    * parseInt(mulFactors[i]);
            }
            iPtr = iPtr % 11;
            // alert(checkCodes[iPtr]);

            return checkCodes[iPtr];

        }

    },
    getSexCode : function(IdCardNo) {
        var vSex = "";

        switch (IdCardNo.length) {
            case 15: {
                vSex = IdCardNo.substring(IdCardNo.length - 1);
                break;
            }
            case 18: {
                vSex = IdCardNo.substring(IdCardNo.length - 2, IdCardNo.length - 1);
                break;
            }
            default: {

            }
        }
        if ((vSex % 2) == 0)
            vSex = 2;
        else
            vSex = 1;

        return vSex;
    },
    compareDate : function(checkDateStartStr, checkDateEndStr, type) {
        /**
         * type:是否比较当前日期 sysDate来源:config.jsp
         */
        if (type) {
            if (checkDateEndStr && checkDateEndStr.length == 8
                && sysDate.length == 8) {
                var nowDate = new Date(sysDate.substr(0, 4), Number(sysDate
                    .substr(4, 2)) - 1, sysDate.substr(6, 2));
                var checkDate = new Date(checkDateEndStr.substr(0, 4),
                    Number(checkDateEndStr.substr(4, 2)) - 1,
                    checkDateEndStr.substr(6, 2));
                // alert("当前日期: " + sysDate.substr(0,4) + "年 " +
                // sysDate.substr(4,2) + "月 " + sysDate.substr(6,2) + "日");
                // alert("比较日期: " + checkDateEndStr.substr(0,4) + "年 " +
                // checkDateEndStr.substr(4,2) + "月 " +
                // checkDateEndStr.substr(6,2) + "日");
                return (checkDate > nowDate);
            } else {
                return false;
            }
        } else {
            if (checkDateStartStr && checkDateEndStr
                && checkDateStartStr.length == 8
                && checkDateEndStr.length == 8) {
                var startDate = new Date(checkDateStartStr.substr(0, 4),
                    Number(checkDateStartStr.substr(4, 2)) - 1,
                    checkDateStartStr.substr(6, 2));
                var checkDate = new Date(checkDateEndStr.substr(0, 4),
                    Number(checkDateEndStr.substr(4, 2)) - 1,
                    checkDateEndStr.substr(6, 2));
                // alert("当前日期: " + checkDateStartStr.substr(0,4) + "年 " +
                // checkDateStartStr.substr(4,2) + "月 " +
                // checkDateStartStr.substr(6,2) + "日");
                // alert("比较日期: " + checkDateEndStr.substr(0,4) + "年 " +
                // checkDateEndStr.substr(4,2) + "月 " +
                // checkDateEndStr.substr(6,2) + "日");
                return (checkDate >= startDate);
            } else {
                return false;
            }
        }
    },
    string2Date : function(DateStr, type) {
        if (type) {
            return new Date();
        } else {
            if (DateStr) {
                if (DateStr.length == 14) {
                    // 带时分秒
                    var date = new Date(DateStr.substr(0, 4), Number(DateStr
                        .substr(4, 2)) - 1, DateStr.substr(6, 2));
                    date.setHours(DateStr.substr(8, 2), DateStr.substr(10, 2),
                        DateStr.substr(12, 2));
                    return date;
                } else if (DateStr.length == 8) {
                    return new Date(DateStr.substr(0, 4), Number(DateStr
                        .substr(4, 2)) - 1, DateStr.substr(6, 2));
                }
            }
        }
    }
}

// VTYPE校验
Gnt.markInvalidVTYPE = function(data, markInvalid, form, pz) {
    var field = form.getForm().findField(pz.fieldname);

    // 文化程度
    if (field && !field.disabled) {
        if (field.vtype && field.vtype != "" && data[pz.fieldname]
            && data[pz.fieldname] != "") {
            if (!Ext.form.VTypes[field.vtype](data[pz.fieldname], field)) {
                var msg = Ext.form.VTypes[field.vtype + "Text"];
                if (!markInvalid) {
                    markInvalid = {};
                }
                markInvalid[pz.fieldname] = "【" + pz.displayname + "】" + msg;
            }
        }
    }

    return markInvalid;
}

// 小于某值，必须填写
Gnt.markInvalidBXTXY = function(data, markInvalid, nl, nlz, form, field,
                                fieldname) {
    var f = form.getForm().findField(field);
    // 文化程度
    if (f && !f.disabled) {
        if (nl <= nlz) {
            // 超过16岁以下字段必填，文化程度
            if (!data[field] || data[field] == "") {
                var txt = "小于" + (nlz + 1) + "周岁【" + fieldname + "】必须填写！";
                markInvalid = Gnt.markInvalid(markInvalid, field, txt);
            }
        }
    }

    return markInvalid;
}

// 大于某值，必须填写
Gnt.markInvalidBXT = function(data, markInvalid, nl, nlz, form, field,
                              fieldname) {
    var f = form.getForm().findField(field);
    // 文化程度
    if (f && !f.disabled) {
        if (nl >= nlz) {
            // 超过16岁以下字段必填，文化程度
            if (!data[field] || data[field] == "") {
                var txt = "超过" + nlz + "周岁【" + fieldname + "】必须填写！";
                markInvalid = Gnt.markInvalid(markInvalid, field, txt);
            }
        }
    }

    return markInvalid;
}
// 制作错误校验提示
Gnt.markInvalid = function(obj, fname, ferror, form) {
    if (form) {
        // 如果不为空，需要校验字段
        var f = form.getForm().findField(fname);
        // 如果字段不存在，或者字段
        if (!f/* || f.disabled */) {// 注释掉disabled属性，只读的也验证
            return obj;
        }
    }

    if (!obj) {
        obj = {}
    }

    obj[fname] = ferror;

    return obj;
}

// 小于某值，不能填写
Gnt.markInvalidBNT = function(data, markInvalid, nl, nlz, form, field,
                              fieldname) {
    var f = form.getForm().findField(field);
    // 婚姻状况
    if (f && !f.disabled) {
        if (nl <= nlz) {
            if (data[field] && data[field] != "") {
                var txt = (nlz + 1) + "周岁以及以下，【" + fieldname + "】不能填写！";
                markInvalid = Gnt.markInvalid(markInvalid, field, txt);
            }
        }
    }

    return markInvalid;
}

String.prototype.startWith = function(str) {
    if (str == null || str == "" || this.length == 0
        || str.length > this.length) {
        return false;
    }
    if (this.substr(0, str.length) == str) {
        return true;
    } else {
        return false;
    }
    return true;
}