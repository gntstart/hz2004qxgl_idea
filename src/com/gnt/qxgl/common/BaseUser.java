package com.gnt.qxgl.common;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.LoginFilter;
import com.gnt.qxgl.bean.SysFunctionInfo;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.XtJsxxb;
import com.gnt.qxgl.hz2004.entity.XtYh;

public class BaseUser implements Serializable{
	/**
	 * 获取当前用户
	 * @return
	 */
	public static BaseUser getCurrent(){
		BaseUser user = (BaseUser)BaseContext.getContext().getRequest().getAttribute(Constants.USER_ATTRNAME);
		if(user!=null)
			return user;
		
		String COOKIE_SID = LoginFilter.getSID(BaseContext.getContext().getRequest(), BaseContext.getContext().getResponse());
		user = HSession.getBaseUser(COOKIE_SID);
		if(user!=null)
			BaseContext.getContext().getRequest().setAttribute(Constants.USER_ATTRNAME, user);
		
		return user;
	}
	
	private static final long serialVersionUID = 1L;

	private Date loginTime = new Date();
	
	// 其它特殊内容，如果需要传递的话
	private Map<String, java.io.Serializable> sessionMap = new HashMap<String, Serializable>();
	private String 							authToken;	//登录字符串，和C/S通用
	private XtYh 								user;				//用户
	private XtDwxxb 						organize;		//单位
	private List<XtJsxxb> 					roles;			//角色列表
	private Map<String,XtJsxxb> 		rolesMap;		//角色编码和角色对应
	private List<XtDwxxb> 			otherorgs;		//兼职单位列表
	private String 										pcslb;			//逗号分隔的派出所编码列表
	private Map<String,SysFunctionInfo> 	funcs;			//权限列表:key=权限编码
	private Set<String>								urls;				//不带参数的URL权限
	private String 										sid;				//会话ID, 非session有效
	private ExtMap<String,Object>		otherParams;
	private String ywdq;		//业务地区编码
	private String dqyhid;
	private String sjfw;	//数据范围
	
	public void setSjfw(String sjfw) {
		this.sjfw = sjfw;
	}

	private boolean admin=false;
	
	public boolean isAdmin() {
		return admin ||  (("," + SystemConfig.getSystemConfig("admin", "admin,root") + ",").indexOf("," + this.getUser().getDlm() + ",")>=0?true:false);
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getDqyhid() {
		return dqyhid;
	}

	public void setDqyhid(String dqyhid) {
		this.dqyhid = dqyhid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, java.io.Serializable> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, java.io.Serializable> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getYwdq() {
		return ywdq;
	}

	public void setYwdq(String ywdq) {
		this.ywdq = ywdq;
	}

	public ExtMap<String, Object> getOtherParams() {
		return otherParams;
	}

	public void setOtherParams(ExtMap<String, Object> otherParams) {
		this.otherParams = otherParams;
	}

	/**
	 * 新增一个方法，获取用户的数据范围，一遍分配权限的时候，不超过此数据范围
	 * @return
	 */
	public String getSjfw(){
		return sjfw;
	}
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Set<String> getUrls() {
		return urls;
	}

	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}

	public Map<String, XtJsxxb> getRolesMap() {
		return rolesMap;
	}

	public void setRolesMap(Map<String, XtJsxxb> rolesMap) {
		this.rolesMap = rolesMap;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * 判断是否具有某个功能点权限
	 * @param funcBm
	 * @return
	 */
	public boolean existFunc(String funcBm){
		if(funcs==null)
			return false;
		
		return funcs.containsKey(funcBm);
	}
	
	public boolean existRole(String roleBm){
		if(roles==null)
			return false;
		
		for(XtJsxxb r:roles)
			if(r.getJsid().equals(roleBm))
				return true;
		
		return false;
	}
	
	/**
	 * 获取用户对象
	 * @return
	 */
	public XtYh getUser() {
		return user;
	}
	public void setUser(XtYh user) {
		this.user = user;
	}
	
	/**
	 * 获取用户的角色列表
	 * @return
	 */
	public List<XtJsxxb> getRoles() {
		return roles;
	}
	
	public void setRoles(List<XtJsxxb> roles) {
		this.roles = roles;
	}
	
	/**
	 * 获取当前用户的兼职单位列表
	 * @return
	 */
	public List<XtDwxxb> getOtherorgs() {
		return otherorgs;
	}
	public void setOtherorgs(List<XtDwxxb> otherorgs) {
		this.otherorgs = otherorgs;
	}
	
	/**
	 * 获取当前用户数据范围内的派出所代码列表（旅馆业使用）
	 * @return
	 */
	public String getPcslb() {
		return pcslb;
	}
	public void setPcslb(String pcslb) {
		this.pcslb = pcslb;
	}

	/*
	 * 获取用户主单位
	 */
	public XtDwxxb getOrganize() {
		return organize;
	}

	public void setOrganize(XtDwxxb organize) {
		this.organize = organize;
	}
	
	public String getLoginTime(){
		return DateHelper.formateDate(loginTime, DateHelper.PRINT_DATETIME_STYLE2);
	}

	/**
	 * 获取用户的当前项目所有功能点列表
	 * @return
	 */
	public Map<String, SysFunctionInfo> getFuncs() {
		return funcs;
	}

	public void setFuncs(Map<String, SysFunctionInfo> funcs) {
		this.funcs = funcs;
	}

	/**
	 * 检查用户是否拥有某权限之一
	 * @param func
	 * @return
	 */
	public boolean checkFuncs(String flist){
		String f[] = flist.split(",");
		for(int i=0;i<f.length;i++)
			if(funcs.containsKey(f[i]))
				return true;
		
		return false;
	}
	
	/**
	 * 检查是否具有指定的所有功能点
	 * @param funcs
	 * @return
	 */
	public boolean checkFuncsAll(String flist){
		String f[] = flist.split(",");
		for(int i=0;i<f.length;i++)
			if(!funcs.containsKey(f[i]))
				return false;
		
		return true;
	}

	/**
	 * 返回一个EXT树菜单结构，如果没有哪么返回空值Null
	 * @param fmap		功能点映射表
	 * @param ptext		父亲菜单名称
	 * @param expanded	是否展开
	 * @param funcs		子菜单功能点列表，多个逗号分隔
	 * @param map		功能点url后缀参数，KEY=功能点编码
	 * @return	返回格式如下：
		{text:'旅馆管理',leaf:false,
			expanded:true,
			children:[
				{text:'旅馆信息查询',leaf:true,data:{url:'lg/lgxxcx.jsp',code:'lgxxcx'},func:'33',disabled:chkfunc('33')},
				{text:'旅馆处罚管理',leaf:true,data:{url:'lg/lgcfcx.jsp',code:'lgcfcx'},func:'27',disabled:chkfunc('27')},
				{text:'旅馆发案管理',leaf:true,data:{url:'lg/lgfagl.jsp',code:'lgfagl'},func:'28',disabled:chkfunc('28')},
				{text:'旅馆房态查询',leaf:true,data:{url:'lg/lgftcx.jsp',code:'lgftcx'},func:'11',disabled:chkfunc('11')}
			]
		}
	 */
	public static String getExtTreeMenus(Map<String, SysFunctionInfo> fmap,String ptext,boolean expanded,String keys,Map<String,String> map){
		if(CommonUtil.isEmpty(keys))
			return null;
		
		if(map==null)
			map = new HashMap<String,String>();
		
		String[] bm = keys.split(",");
		int count = 0;
		String str = "";
		for(int i=0;i<bm.length;i++){
			if(!fmap.containsKey(bm[i]))
				continue;
			
			if(count>0)
				str += ",";
			
			SysFunctionInfo r = fmap.get(bm[i]);
			String url = r.getFunctionUrl();
			if(map.containsKey(bm[i])){
				if(url.indexOf("?")>0)
					url += "&" + map.get(bm[i]);
				else
					url += "?" + map.get(bm[i]);
			}
			
			str += "{text:'" + r.getFunctionName() + "',leaf:true,data:{url:'" + url + "',code:'" + r.getFunctionBm() + "'}}";
			
			count++;
		}
		
		if(CommonUtil.isEmpty(str))
			return null;
		
		return "{text:'" + ptext + "',leaf:false,expanded:" + expanded + ",children:[" + str + "]}";
	}
	
	/**
	 * 返回Toolbar类型菜单下拉项
	 * @param fmap
	 * @param ptext
	 * @param expanded
	 * @param keys
	 * @param map
	 * @return	返回字符串如下
        	 		{
        	 			text: '机构人员管理',
        	 			id:'jgrygl',
			            handler: function(){
			            	openWorkSpace('ry/jgrygl.jsp',this.text,this.id);
			            }
			        },'-',{
					    text:'组织和用户恢复',
					    menu:{items: [{
					            handler: function(){
					            },
					            text: '用户恢复',
					            id:'yhhf',
					            handler: function(){
					            	openWorkSpace('ry/ryhf.jsp',this.text,this.id);
					            }
					        },{
					            handler: function(){
					            },
					            text: '组织恢复',
					            id:'dwhf',
					            handler: function(){
					            	openWorkSpace('ry/dwhf.jsp',this.text,this.id);
					            }
					        }
					    ]}
					},'-'
	 */
	public static String getExtToolbarMenus(Map<String, SysFunctionInfo> fmap,String ptext,boolean expanded,String keys,Map<String,String> map){
		if(CommonUtil.isEmpty(keys))
			return null;
		
		if(map==null)
			map = new HashMap<String,String>();
		
		String[] bm = keys.split(",");
		
		int count = 0;
		String str = "";
		for(int i=0;i<bm.length;i++){
			if(!fmap.containsKey(bm[i]))
				continue;
			
			if(count>0)
				str += ",";
			
			SysFunctionInfo r = fmap.get(bm[i]);
			String url = r.getFunctionUrl();
			if(CommonUtil.isEmpty(url)){
				url = "FunctionBm\t" + r.getFunctionBm();
			}
			
			if(map.containsKey(bm[i])){
				if(url.indexOf("?")>0)
					url += "&" + map.get(bm[i]);
				else
					url += "?" + map.get(bm[i]);
			}
			
			str += "{text:'" + r.getFunctionName() + "',"
					+ "id:'" + r.getFunctionBm() + "',"
					+ "handler:function(){" +
							"openWorkSpace('" + url + "',this.text,this.id);" +
					"}" 
					+ "}";
			
			count++;
		}
		
		if(CommonUtil.isEmpty(str))
			return null;
		
		if(bm.length==1)
			return str;
		
		return "{text:'" + ptext + "',menu:{items: [" + str + "]}}";
	}
	
	public String getSldw(){
		String str = this.getUser().getSsdwjgdm();
		if(str.length()>9)
			str = str.substring(0,9);
		
		return str;
	}
}
