/**
 * 常住人口store，必须先加载commFrames.js,CzrkStore.js
 */
Gnt.ux.KdqqrHjspywGrid = Ext.extend(Ext.grid.GridPanel, {
    title: '人员基本信息',
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
        this.store = new Gnt.store.KdqqrHjspywStore({
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
                    header: "持证人姓名",
                    dataIndex: "czr_xm",
                    sortable: true,
                    width: 80
                }, {
                    header: "公民身份号码",
                    dataIndex: "czr_gmsfhm",
                    sortable: true,
                    width: 120
                }, {
                    header: "去往地",
                    dataIndex: "qwd_ssxqdm",
                    sortable: true,
                    width: 150,
                    renderer:function(value){
                        return Gnt.ux.Dict.getDictLableXzqh('searchXzqh','',value,'eq');
                    }
                }, {
                    header: "去往地详细地址",
                    dataIndex: "qwd_qhnxxdz",
                    sortable: true,
                    width: 400,
                },{
                    header: "创建时间",
                    dataIndex: "cjsj",
                    sortable: true,
                    width: 120
                }, {
                    header: "户口登记派出所",
                    dataIndex: "hkdjpcs",
                    sortable: true,
                    width: 150,
                    renderer:function(value){
                        return Gnt.ux.Dict.getDictLableXzqh("searchXxb",'DWXXB',value,"eq");
                    }
                }, {
                    header: "是否办结",
                    dataIndex: "sfbj",
                    sortable: true,
                    width: 60,
    				renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
    					return Gnt.ux.Dict.getDictLable('CS_LSBZ', value);
    				}
                }, {
                    header: "迁移证编号",
                    dataIndex: "qyzbh",
                    sortable: true,
                    width: 80
                }, {
                    header: "准迁证编号",
                    dataIndex: "zqzbh",
                    sortable: true,
                    width: 80
                }, {
                    header: "有效截止日期",
                    dataIndex: "yxqjzrq",
                    sortable: true,
                    hidden: true,
                    width: 60
                }, {
                    header: "受理人",
                    dataIndex: "slr_xm",
                    sortable: true,
                    hidden: true,
                    width: 60
                }, {
                    header: "受理单位",
                    dataIndex: "sldw_gajgmc",
                    sortable: true,
                    width: 150
                }, {
                    header: "受理日期",
                    dataIndex: "slsj",
                    sortable: true,
                    hidden: true,
                    width: 60
                }, {
                    header: "签发日期",
                    dataIndex: "qfrq",
                    sortable: true,
                    hidden: true,
                    width: 60
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

        Gnt.ux.KdqqrHjspywGrid.superclass.initComponent.call(this);
    }
});
Ext.reg('hjspyw_grid', Gnt.ux.KdqqrHjspywGrid);
