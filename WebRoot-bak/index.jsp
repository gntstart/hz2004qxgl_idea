<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file = "config.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	BaseUser u = BaseContext.getBaseUser();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>常住人口统一用户管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/report_style.css">
    <link rel="stylesheet" type="text/css" href="js/ext/css/ext-all.css">
    <link rel="stylesheet" type="text/css" href="<%=SystemConfig.getSystemConfig("default_css")%>">
	<style type="text/css">
	.imgfile {
	    background-image:url(images/i1.gif) !important;
	}
	.icon-exit {
	    background-image:url(images/exit.gif) !important;
	}
	.otherfile {
	    background-image:url(images/3.gif) !important;
	}
	.icon-expand-all {
	    background-image: url(images/expand-all.gif) !important;
	}
	.icon-collapse-all {
	    background-image: url(images/collapse-all.gif) !important;
	}
	.icon-expand-members {
	    background-image: url(images/expand-members.gif) !important;
	}
	.icon-hide-inherited {
	    background-image: url(images/vty16.gif) !important;
	}
	.icon-home {
	    background-image: url(images/dq.gif) !important;
	}
	
	#word-status .x-status-text {
	    color: #777;
	}
	#word-status .x-status-text-panel .spacer {
	    width: 60px;
	    font-size:0;
	    line-height:0;
	}
	</style>
  </head>
  <body>
   	<!-- Include Ext and app-specific scripts: -->
   	<Script Lanaguage="JavaScript">
   		var cfWin = null;
   		
   		var user = {
			usercode:'<%=u.getUser().getDlm()%>',
			glyxm:'<%=u.getUser().getXm()%>',
			dlsj:'<%=u.getLoginTime()%>'
		}
	
		var jccode = '<%=SystemConfig.getSystemConfig("jccodeAppURL","")%>';
		
		var funcs = [
        	 		<%
    				Map<String,String> p = new HashMap<String,String>();

    				int menucount = 0;
    				String menu = com.gnt.qxgl.common.BaseUser.getExtToolbarMenus(u.getFuncs(),"用户管理",true,"JGRYGL",p);
    				if(menu!=null){
    					if(menucount>0) out.println(",'-',");
    					
    					out.println(menu);
    					menucount++;
    				}
    				
    				menu = com.gnt.qxgl.common.BaseUser.getExtToolbarMenus(u.getFuncs(),"角色管理",true,"QXGLJSGL",p);
    				if(menu!=null){
    					if(menucount>0) out.println(",'-',");
    					
    					out.println(menu);
    					menucount++;
    				}
    				
    				if(menucount>0) out.println(",'-',");
        	 		%>
        	 		'->', 
					<%if(u.checkFuncsAll("QXGLXGMM")){%>
					{
		                tooltip:'修改密码',
		                iconCls: 'icon-hide-inherited',
		                handler : function(b, pressed){
		                   cfWin.show();
		                }
		            },'-',
		            <%}%>
		            {
		                tooltip:'隐藏/显示状态栏',
		                iconCls: 'icon-expand-members',
		                enableToggle: true,
		                toggleHandler : function(b, pressed){
		                    var st = Ext.get("word-status");
		                    if(pressed){
			                    st.setVisibilityMode(Ext.Element.DISPLAY);
			                    st.hide({
			                    	duration:1,
			                    	callback:function(){
			                    		 Ext.getCmp("vp").doLayout();
			                    	}
			                    });
		                    }else{
		                    	st.show(true);
		                    	Ext.getCmp("vp").doLayout();
		                    }
		                }
		            },'-',{
		                tooltip:'退出系统',
		                iconCls: 'icon-exit',
		                handler: function(b, pressed){
		                	Ext.Msg.show({
							   title:'退出系统',
							   msg: '确定要退出系统吗？',
							   buttons: Ext.Msg.YESNO,
							   fn: function(btn, text){
							   		if(btn=="yes"){
							   			document.location.href = "login.jsp?op=logout"
							   		}
							   },
							   animEl: Ext.getBody(),
							   icon: Ext.MessageBox.QUESTION
							});
		                }
		            }
        	 	];
   	</Script>
    <script type="text/javascript" src="js/ext/ext.js"></script>
    <script type="text/javascript" src="index.js"></script>	
  </body>
</html>
