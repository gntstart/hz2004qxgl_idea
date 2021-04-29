//html页面种通过调用这个函数显示上传窗体
//其他窗体需要进行上传文件只需要调用这个函数就可以
function btnUpload_click(winTitle, applyno,blFile,callback1) {
    win.setTitle(winTitle);
    win.applyno = applyno;
//    win.zpType = zpType;
    win.callback1 = callback1;
   // if(blFile != null){
   //     //转换字符串
   //     var str12 = arrayBufferToBase64(blFile);
   //     win.image = 'data:image/jpg;base64,'+hzzpid;
   // }
    win.doLayout();
    win.show();
    document.getElementById("logoPic").src = win.image;
}

var formpanel = new Ext.form.FormPanel({
    title: '无刷新文件上传',
    width: '95%',
    height: '95%',
    x: 5,
    y: 5,
    layout: "form",
    bodyPadding: "5",
    defaultType: "textfield",
    allowBlank:false,
    fileUpload: true,
    fieldDefaults: {labelAlign: "left", labelWidth: 55},
    items: [
        {
            xtype: 'textfield',
            id: 'logoFile',
            name: 'logoFile',
            inputType: 'file',
            fieldLabel: '照片文件',
            width: 280,
            listeners: {
                'render': function () {
                    var logoFileCmp = Ext.get('logoFile');
                    logoFileCmp.on('change',
                        function (field, newValue, oldValue) {
                        var picPath = logoFileCmp.getValue();
                        if(picPath == ""){
                            return;
                        }
                        var url = 'file:///' + picPath;
                        var arr = url.split('.');
                        if (!((arr[arr.length - 1] == 'jpg') || (arr[arr.length - 1] == 'png') || (arr[arr.length - 1] == 'bmp'))) {
                            alert('文件不合法，请上传后缀为*.jpg;*.png;*.bmp的照片文件!');
                            return;
                        }
                        if (Ext.isIE) {
                            var image = Ext.get('logoPic').dom;
                            image.src = Ext.BLANK_IMAGE_URL;
                            image.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = url;
                        } else {
                            //支持FF
                            var oFReader = new FileReader();
                            oFReader.readAsDataURL(document.getElementById("logoFile").files[0]);
                            oFReader.onload = function (oFREvent) {
                                document.getElementById("logoPic").src = oFREvent.target.result;
                            }
                        }
                    }, this);
                }
            }
        },
        {
            xtype: 'box',
            id: 'logoPic',
            width: 150,
            height: 200,
            autoEl: {
                tag: 'img',
                src: '',
                style: 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);'
            }
        }
    ],
    buttons: [
        {
            text: "上传",
            handler: function () {
                var photoName = document.getElementById("logoFile").value;
                if (photoName) {
                    formpanel.getForm().submit({
                        url: 'util/upfile',
                        method:'get',
                        params: {
                        	applyno: win.applyno,
                            type: 'ywtbfj',
                            method: 'saveYwtbfj',
                            className: 'ywtbService'
                        },
                        success: function (form, action) {
                            showInfo("照片上传成功！");
                            win.hide();
                            if(win.callback1){
                                win.callback1();
                            }else{
                                showInfo("回调函数不存在!");
                            }
                        },
                        failure: function (form, action) {
                        	var responseArray = Ext.util.JSON.decode(action.response.responseText);
                            showInfo(responseArray.messages[0]+"照片上传失败！");
                        }
                    });
                } else {
                    showInfo("必须先上传有效照片后才能提交!");
                    return;
                }

            }
        }, {
            text: '关闭',
            handler: function () {
                win.hide();
            }
        }
    ]

});
//窗体
var win = new Ext.Window({
    title: '上传文件窗口',
    width: 476,
    height: 374,
    resizable: false,
    modal: false,
    closable: false,
    closeAction: 'hide',
    items: [formpanel]
});


