Ext.onReady( function() {
    Ext.QuickTips.init();
    
    function login(){
		mask.show();
       	fs.getForm().submit({
			url:'login.do?method=login', 
			params:fs.getForm().getValues(),
			success : function(form,action) {
				if(gotourl=="")
					document.location.href = 'index.jsp';
				else
					document.location.href = gotourl;
			},
			failure : function(form,action) {
				mask.hide();
				if(action.result){
					Ext.MessageBox.alert('登录失败', action.result.messages[0]);
					return;
				}
				if(action.response){
					Ext.MessageBox.alert('登录失败', action.response.responseText);
					return;
				}
				Ext.MessageBox.alert('登录失败', "登录失败，未知错误!");
				return;
			}
		});
	}
	function calogin(){
		mask.show();
		window.location='calogin.jsp'
       	//fs.getForm().submit({
		//	url:'calogin.jsp'
		//});
	}
    var fs = new Ext.FormPanel({
        id: 'login-form-panel',
        frame: true,
        labelAlign: 'right',
        bodyStyle:'padding:5px',
        border: true,
        width: 400,
        items: [{
            xtype: 'fieldset',
            defaultType: 'textfield',
            autoHeight: true,
        	title: '用户登录',            
            width: 350,
            border: true,
            items: [{
                name: 'uid',
                id:'uid',
                allowBlank: false,
                value:'HZADMIN3400',
                fieldLabel: '用户名'
            },{
                name: 'pwd',
                id:'pwd',
                fieldLabel: '密码',
                allowBlank: false,
                inputType: 'password',
                listeners:{
					specialkey:function(field,e){
						if (e.getKey()==Ext.EventObject.ENTER){   
							Ext.getCmp("btn-submit").fireEvent('click');
						}   
					}   
				}   
            }]
        }],
		buttons: [{
			id: 'btn-submit',
			name: 'btn-submit',
            text: '确定',
			handler:function(){
				calllogin();
			}
        },{
			id: 'btn-submit1',
			name: 'btn-submit1',
            text: 'PKI登录',
			handler:function(){
				calogin();
			}
        }],
        method: 'POST',        
		renderTo: 'gui'
    });
    
    new Ext.KeyMap(Ext.get("uid"), {
    	key:13,
    	fn:function(key,keyEvent){
    		Ext.get("pwd").dom.focus();
    	}
	});
    new Ext.KeyMap(Ext.get("pwd"), {
    	key:13,
    	fn:function(key,keyEvent){
    		calllogin();
    	}
	});
	
	function calllogin(){
		if(!fs.getForm().isValid()){
			return;
		}
		login();
	}
	
	Ext.get("uid").dom.focus();
    var mask = new Ext.LoadMask(fs.el, {msg:"正在验证身份，请等待..."});
});
