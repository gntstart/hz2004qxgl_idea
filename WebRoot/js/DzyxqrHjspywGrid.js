/**
 * 常住人口store，必须先加载commFrames.js,CzrkStore.js
 */
Gnt.ux.DzyxqrHjspywGrid = Ext.extend(Ext.grid.GridPanel, {
    title: '准迁人员基本信息',
    height: 200,
    stripeRows: true,
    loadMask: {msg: '正在加载数据，请稍侯……'},
    border: false,
    margins: '0 0 0 5',
    frame: false,
    border: true,
    frame: true,
    getPostParams: function () {
        return {};
    },
    loadData: function (data, success_callback, error_callback) {
        this.store.success_callback = success_callback;
        this.store.error_callback = error_callback;

        this.store.baseParams = data;
        this.store.load({params: {start: 0, limit: this.pagesize}});
    },
    initComponent: function () {
        this.store = new Gnt.store.DzyxqrHjspywStore({
            error_callback: function () {
            },
            success_callback: function () {

            },
            url: this.url
        });

        if (!this.cm) {
            this.cm = new Ext.grid.ColumnModel([
                new Ext.grid.CheckboxSelectionModel(),
                new Ext.grid.RowNumberer(),
                {
                    header: "申请人姓名",
                    dataIndex: "sqrxm",
                    sortable: true,
                    width: 80
                }, {
                    header: "申请人身份号码",
                    dataIndex: "sqrgmsfhm",
                    sortable: true,
                    width: 120
                }, {
                    header: "准迁证编号",
                    dataIndex: "zjbh",
                    sortable: true,
                    width: 80
                }, {
                    header: "申请人省市县区",
                    dataIndex: "sqrzzssxq",
                    sortable: true,
                    hidden:true,
                    width: 120,
                    renderer:function(value){
                        return Gnt.ux.Dict.getDictLableXzqh('searchXzqh','',value,'eq');
                    }
                }, {
                    header: "申请人详细地址",
                    dataIndex: "sqrzzxz",
                    sortable: true,
                    hidden:true,
                    width: 400,
                }, {
                    header: "申请人户口登记机关",
                    dataIndex: "sqrhkdjjg",
                    sortable: true,
                    hidden:true,
                    width: 120
                }, {
                    header: "迁入省市县区",
                    dataIndex: "qrdssxq",
                    sortable: true,
                    width: 150,
                    renderer:function(value){
                        return Gnt.ux.Dict.getDictLableXzqh('searchXzqh','',value,'eq');
                    }
                }, {
                    header: "迁入户口登记机关",
                    dataIndex: "qrdhkdjjg",
                    sortable: true,
                    width: 120,
                    renderer:function(value){
                        return Gnt.ux.Dict.getDictLableXzqh("searchXxb",'DWXXB',value,"eq");
                    }
                }, {
                    header: "迁出地省市县区",
                    dataIndex: "qyrzzssxq",
                    sortable: true,
                    width: 150,
                    renderer:function(value){
                        return Gnt.ux.Dict.getDictLableXzqh('searchXzqh','',value,'eq');
                    }
                }, {
                    header: "迁出地派出所",
                    dataIndex: "qyrhkdjjg",
                    sortable: true,
                    width: 120
                }, {
                    header: "批准机关",
                    dataIndex: "pzjg",
                    sortable: true,
                    hidden:true,
                    width: 120
                }, {
                    header: "承办人",
                    dataIndex: "cbr",
                    sortable: true,
                    width: 80,
                }, {
                    header: "签发日期",
                    dataIndex: "qfrq",
                    sortable: true,
                    width: 80
                }, {
                    header: "长三角通办",
                    dataIndex: "sfcsjtb",
                    sortable: true,
                    width: 60,
                    renderer:function(value){
                        if(value == "0"){
                            return "否"
                        }
                        if(value == "1"){
                            return "是"
                        }
                    }
                }, {
                    header: "有效截止日期",
                    dataIndex: "yxqjzrq",
                    sortable: true,
                    hidden:true,
                    width: 120
                }, {
                    header: "是否有迁移证",
                    dataIndex: "sfqyz",
                    sortable: true,
                    width: 60,
                    renderer:function(value){
                        if(value == "0"){
                            return "否"
                        }
                        if(value == "1"){
                            return "是"
                        }
                    }
                }, {
                    header: "迁移证编号",
                    dataIndex: "qyzbh",
                    sortable: true,
                    width: 120
                }, {
                    header: "是否办结",
                    dataIndex: "sfbj",
                    sortable: true,
                    width: 60,
                    renderer:function(value){
                        if(value == "0"){
                            return "否"
                        }
                        if(value == "1"){
                            return "是"
                        }
                    }
                }, {
                    header: "迁移流动原因",
                    dataIndex: "qyyy",
                    sortable: true,
                    width: 60,
                    renderer:function(value){
                        return Gnt.ux.Dict.getDictLable('CS_QYLDYY', value);
                    }
                }
            ]);
        }

        if (this.showPaging == undefined || this.showPaging == true) {
            this.bbar = new Ext.PagingToolbar({
                pageSize: this.pagesize,
                store: this.store,
                displayInfo: true
            });
        }

        //这个必须放store定义后，否则不可预料
        if (!this.view) {
            this.view = new Ext.grid.GridView({
            	forceFit:false,
				autoFill:false
            });
        }

        Gnt.ux.DzyxqrHjspywGrid.superclass.initComponent.call(this);
    }
});
Ext.reg('hjspyw_grid', Gnt.ux.DzyxqrHjspywGrid);
