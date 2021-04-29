package com.gnt.qxgl.common.dict;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Node;

import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.bean.SysCode;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.dict.bean.Code;
import com.gnt.qxgl.common.dict.bean.Dictcode;
import com.gnt.qxgl.common.dict.bean.SimpleJson;
import com.gnt.qxgl.common.dict.bean.SysCodetype;
import com.gnt.qxgl.common.dict.bean.SysOrganizeInfo;
import com.gnt.qxgl.common.dict.bean.TreeNode;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.struts.form.CommonForm;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;
import com.gnt.qxgl.service.SqService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 字典
*/
@SuppressWarnings("unchecked")
public class DictServlet extends HttpServlet{
	/**
	 * WEB根 
	 */
	static public String WebRootPath = null;
	static public String WebAppName = null;
	
	//实例
	static private DictServlet context = null;
	
	static public final String DQBM = (SystemConfig.getSystemConfig("dqbm")==null?"":SystemConfig.getSystemConfig("dqbm").toUpperCase());//地区
	static public final String XMBM = (SystemConfig.getSystemConfig("xmbm")==null?"":SystemConfig.getSystemConfig("xmbm").toUpperCase());//项目		
	
	private static final long serialVersionUID = 1L;
	
	static public String url = null;
	static public String uid = null;
	static public String pwd = null;
	
	static private String baseURL = null;
	
	static private List<AutoService> listservice = new ArrayList<AutoService>();
	
	static {
		try {
			Class.forName(SystemConfig.getJdbcConfig("qxgl.jdbc.driverClass"));
		} catch (java.lang.ClassNotFoundException ex) {
			System.out.println("字典库数据库配置驱动程序没有找到！");
			System.exit(0);
		}
		
		url = SystemConfig.getJdbcConfig("qxgl.jdbc.url");
		uid = SystemConfig.getJdbcConfig("qxgl.jdbc.user");
		pwd = SystemConfig.getJdbcConfig("qxgl.jdbc.password");
	}
	
	/**
	 * 检查许可证
	 * @return
	 */
	static private boolean checkLicense(){
		return true;
	} 
	
	protected void queryXZQHTree(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = ExtUtils.getRequestParamesString(request);
		
		SqService sqService = (SqService)SpringContainer.getObject("sqService");
		List<TreeNode> list = sqService.queryXZQHTreeNodes(map);
		 
		Gson gson = new GsonBuilder().serializeNulls().create();
		String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
		response.getOutputStream().print(jison);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		//当有用户请求的时候，启动心跳 
		if(baseURL!=null){
			baseURL = req.getScheme() + "://" + req.getServerName() +":" + req.getServerPort() + req.getContextPath() + "/";
		}
		
		Map<String,String> dictMap = CommonUtil.getParameterMap(req.getParameter("dict"));
		String serviceName = dictMap.get("serviceName");
		String serviceMethod = dictMap.get("serviceMethod");
		if(CommonUtil.isNotEmpty(serviceName) && CommonUtil.isNotEmpty(serviceMethod)){
			Object service = SpringContainer.getObject(serviceName);
			Method m = null;
			try{
				m = service.getClass().getDeclaredMethod(
							serviceMethod,
							HttpServletRequest.class);
				Object value = m.invoke(service, new Object[] {req });
				if(value!=null){
					List<TreeNode> list = (List<TreeNode>)value;
					 
					Gson gson = new GsonBuilder().serializeNulls().create();
					String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
					resp.getOutputStream().print(jison);
				}
			}catch(Exception e){
				SimpleJson s = new SimpleJson();
				s.setMessage(e.getMessage());
				s.setSuccess(false);
				Gson gson = new GsonBuilder().serializeNulls().create();
				resp.getOutputStream().print(gson.toJson(s));
			}
			
			return;
		}
		
		String method = req.getParameter("method");
		if (method != null) {
			try {
				if(method.equals("queryXZQHTree")){
					queryXZQHTree(req, resp);
				}else if (method.equals("queryTree")) {
					//二次加载树
					queryTree(req, resp);
				}else if(method.equals("queryCode")){
					//初始化一次性加载字典，以及翻译
					queryCode(req,resp);
				}else if(method.equals("queryMenu")){
					//菜单加载
					queryMenu(req,resp);
				}else if(method.equals("searchCode")){
					searchCode(req,resp);
				}else if(method.equals("reLoadAllData")){
					//重载所有缓存数据
					initShareData();
					String base = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/";
					SimpleJson s = new SimpleJson();
					s.setMessage("成功重载[" + base + "]的缓存数据！");
					s.setSuccess(true);
					Gson gson = new GsonBuilder().serializeNulls().create();
					resp.getOutputStream().print(gson.toJson(s));
				}else if(method.equals("reLoadXtbaData")){
					//重载协同办案
					String urls = SystemConfig.getSystemConfig("reloadURL");
					SimpleJson s = new SimpleJson();
					if (CommonUtil.isNotEmpty(urls)) {
						String[] urlArr = urls.split(",");
						for (int i = 0; i < urlArr.length; i++) {
							String urlStr = urlArr[i].trim();
							String urlName = urlStr;
							String url = urlStr;
							int index = urlStr.indexOf(";");
							if (index != -1) {
								urlName = urlStr.substring(0, index);
								url = urlStr.substring(index + 1);
							}

							String msg = "";
							try {
								HttpURLConnection conn = (HttpURLConnection) new URL(url)
										.openConnection();
								conn.setDoInput(true);
								conn.setRequestMethod("GET");
								conn.connect();
								conn.getInputStream();
								conn.disconnect();
								msg += urlName + "重载成功！\n\r";
							} catch (Exception e) {
								msg += urlName + "重载失败：" + e.getMessage() + "\n\r";
							}
							
							s.setMessage(msg);
							s.setSuccess(true);
						}
					}else{
						s.setSuccess(false);
						s.setMessage("请通过配置项reloadURL配置XTBA的缓存重载地址！");
					}
					
					Gson gson = new GsonBuilder().serializeNulls().create();
					resp.getOutputStream().print(gson.toJson(s));
				}else if(method.startsWith("reLoad")){
				    	String[] methods = method.split(",");
				    	boolean success = true;
				    	String msg = "";
				    	for(int i=0;i<methods.length;i++){
        					//重载指定数据
        					Method m = null;
        					try {
								m=DictData.class.getMethod(methods[i], Connection.class);
							} catch (NoSuchMethodException e) {
								//m = FuncData.class.getMethod(methods[i], Connection.class);
							}
        					
        					if(m!=null){
        						m.invoke(DictData.class,new Object[]{null});
    							msg += "成功重载[" + methods[i] + "]的缓存数据！";
        					}else{
        						msg += "加载方法[" + method + "]没有找到！";
        						success = false;
        					}
				    	}
				    	
					SimpleJson s = new SimpleJson();
					s.setSuccess(success);
					s.setMessage(msg);
					
					Gson gson = new GsonBuilder().serializeNulls().create();
					resp.getOutputStream().print(gson.toJson(s));
				}
			} catch (Exception e) {
				SimpleJson s = new SimpleJson();
				s.setMessage(e.getMessage());
				s.setSuccess(false);
				Gson gson = new GsonBuilder().serializeNulls().create();
				resp.getOutputStream().print(gson.toJson(s));
			}
		}
	}

	static public String getRealPath(String path){
		String temppath = context.getServletContext().getRealPath(path);
		if(!temppath.endsWith("/"))
			temppath += "/";
		
		return temppath;
	}
	
	static public String getWebRootPath(){
		return WebRootPath;
	}
	
	static public String getAppName(){
		return WebAppName;
	}
	
	static List<LocationDictService> localList = new  ArrayList<LocationDictService>();
	public void init() throws ServletException {
		super.init();
		context = this;
		WebRootPath = getRealPath("");
		WebAppName = context.getServletContext().getRealPath("/").replaceFirst("/", "");
		
		String cname = getInitParameter("locationDict");
		if(CommonUtil.isNotEmpty(cname)){
			String c[] = cname.split(",");
			for(String className :c){
				try{
					LocationDictService local = (LocationDictService)Class.forName(className).newInstance();
					localList.add(local);
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("加载" + className + "失败：" + e.getMessage());
				}
			}
		}
		
		try{
			initShareData();
			
			/**
			 * 如果配置了listservice参数，那么启动服务
			 */
			String str = context.getServletConfig().getInitParameter("listservice");
			if(CommonUtil.isNotEmpty(str)){
				String[] n = str.split(",");
				for(int i=0;i<n.length;i++){
					String sname = n[i];
					if(sname==null || CommonUtil.isEmpty(sname.trim()))
						continue;
					
					Object o = Class.forName(sname).newInstance();
					if(o instanceof AutoService){
						AutoService a = (AutoService)o;
						listservice.add(a);
						a.init(context.getServletConfig());
						a.start();
					}
				}
			}			
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("初始化缓存服务发生异常！");
			System.exit(0);
		}
	}
	
	/**
	 * 初始化字典
	 */
	static public void initShareData() throws Exception{
		Connection conn = null;
		try {
			conn = DictData.reLoad(null);
			//FuncData.reLoad(conn);
			
			if(checkLicense()){
				;
			}else{
				System.out.println("许可证校验失败！");
				System.exit(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if(conn!=null){
				try{conn.close();}catch(Exception e){;}
				conn = null;
			}
		}
	}
	
	private List<TreeNode> insertZzjy(SysOrganizeInfo childDw, String ryDef,boolean showchecked) {
		List<String> rylist = DictData.getZzjyList(childDw.getDm());
		if (rylist != null && rylist.size() > 0) {
			List<TreeNode> childRyList = new ArrayList<TreeNode>();
			for (String userCode : rylist) {
				TreeNode node = new TreeNode();
				node.setZzjg(childDw);
				XtYhxxb jy = DictData.getZzjy(userCode);

				node.setZzjy(jy);
				node.setChecked(ryDef == null ? false : ryDef.equals(jy.getYhdlm()));
				node.setLeaf(true);
				node.setText(jy.getYhxm());
				//node.setIcon("images/user.gif");
				node.setIconCls("nodeuser");
				
				if(!showchecked){
					node.setChecked(null);
					node.setIcon("images/user.gif");
				}
				
				childRyList.add(node);
			}
			return childRyList;
		}
		return null;
	}

	private List<TreeNode> getChildList(String dwccm, String selectDwccm,
			boolean isRy, String ryDef, TreeNode pnode,boolean showchecked) {
		
		Set<String> ccmset = new HashSet<String>();
		if(selectDwccm!=null){
			String[] s = selectDwccm.split(",");
			for(int i=0;i<s.length;i++)
				ccmset.add(s[i]);
		}
		
		List<String> list = DictData.getZzjgList(dwccm);
		List<TreeNode> childList = new ArrayList<TreeNode>();
		if (list == null || list.size() == 0)
			return childList;

		for (String c : list) {
			SysOrganizeInfo childDw = DictData.getZzjg(DictData.getZzjgBm(c));
			TreeNode child = new TreeNode();

			child.setText(childDw.getMc());
			child.setZzjg(childDw);
			child.setPathcode(childDw.getCcm());
			childList.add(child);

			// 选择默认单位
			if (CommonUtil.isNotEmpty(selectDwccm)
					&& ccmset.contains(childDw.getCcm()) ) {
				//当前单位，本身就是选择单位之一
				if (!isRy)
					child.setChecked(true);
				else
					child.setChecked(null);
				
				if(!showchecked) child.setChecked(null);
				
				child.setExpanded(true);
				child.setChildren(getChildList(childDw.getCcm(), selectDwccm,
						isRy, ryDef, child, showchecked));

				if (isRy) {
					List<TreeNode> listRy = insertZzjy(childDw, ryDef, showchecked);
					if (listRy != null)
						child.getChildren().addAll(listRy);
				}
			} else {
				if (!isRy)
					child.setChecked(false);
				else
					child.setChecked(null);

				if(!showchecked) child.setChecked(null);
				
				// 如果还没有选中，并且本单位是默认选择单位的上级，那么递归
				if (CommonUtil.isNotEmpty(selectDwccm)){
					boolean isparent = false;
					for(String str:ccmset){
						if(str.startsWith(childDw.getCcm())
								&& childDw.getCcm().length() < str.length()) {
							isparent = true;
							break;
						}
					}
				
					if(isparent){
						child.setExpanded(true);
						child.setChildren(getChildList(childDw.getCcm(),
								selectDwccm, isRy, ryDef, child, showchecked));
	
						if (isRy) {
							List<TreeNode> listRy = insertZzjy(childDw, ryDef, showchecked);
							if (listRy != null)
								child.getChildren().addAll(listRy);
						}
					}
				}
			}
			if (isRy)
				child.setLeaf(false);
			else
				child.setLeaf(CommonUtil.isEmpty(DictData.getZzjgList(childDw
						.getCcm())));
		}
		return childList;
	}

	private List getTreeNodeList(Map map) {
		//特殊参数，是否显示选择复选项（某些特殊情况不需要显示）
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		List<TreeNode> rootList = new ArrayList<TreeNode>();
		
		Map<String, String> dict = CommonUtil.getParameterMap((String) map.get("dict"));
		boolean showchecked = true;
		if(dict.containsKey("showchecked")){
			showchecked = ((dict.get("showchecked")).equals("true")?true:false);
		}
		
		String visionType = dict.get("VisionType");
		if(CommonUtil.isEmpty(visionType))
			visionType = dict.get("vtype");
		
		if (CommonUtil.isEmpty(visionType)) {
			throw new ActionException("字典[" + map.get("dict") + "]必须指定VisionType参数！");
		}

		//如果是搜索
		String key = (String)map.get("key");
		if(CommonUtil.isNotEmpty(key)){
			String spacename = dict.get("sp");
			if (CommonUtil.isEmpty(spacename))
				spacename = DictData.SYS_SPACENAME;
			
			List<SysCode> list = DictData.getSysCodeList(spacename, visionType);
			int i =0;
			for(SysCode code:list){
				if(code.getCode().indexOf(key)>=0
					|| code.getCodename().indexOf(key)>=0
					|| (code.getPyt()!=null && code.getPyt().indexOf(key)>=0)){
					
					Code c = new Code();
					
					TreeNode n = new TreeNode();
					n.setChecked(false);
					n.setCode(c);
					n.setText(code.getCodename());
					n.setLeaf(false);
					c.setCode(code.getCode());
					c.setName(code.getCodename());
					c.setPyt(code.getPyt());
					
					List<TreeNode> child = getCodeTypeChilds(spacename, visionType, code.getCode(), null, null,dict);
					if(child!=null && child.size()>0)
						n.setLeaf(false);
					else
						n.setLeaf(true);
					
					i++;
					
					//防止搜索内容过多
					if(i>=50)
						break;
					
					nodeList.add(n);
				}
			}
			
			return nodeList;
		}
		
		if (visionType.equals("RY") || visionType.equals("DW") || visionType.equals("DW2") || visionType.equals("CCM")) {
			boolean isJy = visionType.equals("RY");
			
			// 首先获取客户端提交的请求子单位的父亲
			String root = dict.get("postDetail");
			if (CommonUtil.isEmpty(root)) {
				// 如果客户端请求不带请求单位层次码，那么获取默认单位
				root = dict.get("RootCode");
				String sjfw = dict.get("sjfw");
				if (CommonUtil.isNotEmpty(root)) {
					root = DictData.getZzjg(root).getCcm();
				} else if(CommonUtil.isNotEmpty(sjfw) && !sjfw.equals("null")){
					root = sjfw;
				}else{
					root = DictData.getRootDwccm();
				}
			}
			
			List<String> list = DictData.getZzjgList(root);
			String defDwccm = null;

			// 如果是第一次请求，那么需要生成根单位和子单位，否则只需要子单位列表
			TreeNode n = null;
			String def = dict.get("def");

			//postDetailOnlyOne指示初始化的时候，获取postDetail代表的根（二次加载树必须删除此项，否则会存在重复父亲节点）
			if (!dict.containsKey("postDetail") || "1".equals(dict.get("postDetailOnlyOne"))) {
				SysOrganizeInfo dw = DictData.getZzjgByCcm(root);
				n = new TreeNode();
				if (isJy || !showchecked)
					n.setChecked(null);
				else
					n.setChecked(false);

				n.setExpanded(true);
				n.setLeaf(CommonUtil.isEmpty(list));
				n.setText(dw.getMc());
				n.setZzjg(dw);
				n.setPathcode(root);
				nodeList.add(n);

				if (CommonUtil.isNotEmpty(def)) {
					// 如果有默认值
					if (isJy) {
						defDwccm = DictData.getZzjgCcmsByZzjyBm(def);
					} else {
						if(visionType.equals("DW"))
							defDwccm = DictData.getZzjgCcmsByDwbm(def);
						else
							defDwccm = def;//本来就是层次码
					}

					// 如果是当前单位位于默认值之一
					if (("," + def + ",").indexOf("," + dw.getDwjgdm() + ",")>=0 && !isJy)
						n.setChecked(true);
				}
			}

			// 添加子单位
			List<TreeNode> childList = getChildList(root, defDwccm, isJy, def, n, showchecked);
			if (n != null) {
				n.setChildren(childList);
			} else {
				nodeList = childList;
			}

			if (isJy) {
				SysOrganizeInfo dw = DictData.getZzjgByCcm(root);
				List<TreeNode> listRy = insertZzjy(dw, def, showchecked);
				if (listRy != null && listRy.size() > 0) {
					if (n != null)
						n.getChildren().addAll(listRy);
					else
						nodeList.addAll(listRy);
				}
			}
		} else {
			// 普通字段树，获取当前节点的父亲PCODETYPE
			String root = dict.get("postDetail");
			boolean isroot = false;
			
			// 名字空间
			String spacename = dict.get("sp");
			if (CommonUtil.isEmpty(spacename))
				spacename = DictData.SYS_SPACENAME;

			// 如果没有，那么表示第一次提交
			if (CommonUtil.isEmpty(root)) {
				isroot = true;
				
				// 获取指定的PCODETYPE
				root = dict.get("RootCode");
				// 如果没有，那么以VISONTYPE作为PCODETYPE
				if (CommonUtil.isEmpty(root))
					root = visionType;
			}

			String def = dict.get("def");
			String[] s = null;
			if (CommonUtil.isNotEmpty(def)) {
				s = def.split(",");
			}
			Set<String> clist = new HashSet<String>();
			if (s != null) {
				for (int i = 0; i < s.length; i++) {
					if (CommonUtil.isNotEmpty(s[i])) {
						SysCode zd = DictData.getSysCode(spacename,visionType, s[i]);
						if (zd != null) {
							// 获得默认值的codetype
							String type = zd.getCodetype();
							SysCodetype rootZd = DictData.getSysCodetype(spacename, visionType, type);
							clist.add(rootZd.getCodetype());

							String str = getParentCodeType(clist, spacename,
									visionType, root, rootZd.getCodetype(),dict);
							while (str != null) {
								str = getParentCodeType(clist, spacename,
										visionType, root, str,dict);
							}
						}
					}
				}
			}

			List<TreeNode> l = getCodeTypeChilds(spacename, visionType, root, dict.get("def"), clist,dict);
			if (l != null){
				nodeList.addAll(l);
				if(isroot  && "false".equals(dict.get("checkRoot"))){
					//如果特别指定最顶级不允许复选，那么删除
					for(TreeNode n:l){
						n.setChecked(null);
					}
				}
			}
		}
		
		return nodeList;
	}

	private List<TreeNode> getCodeTypeChilds(String spacename,
			String visionType, String root, String def, Set<String> set,Map<String, String> dict) {
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		Map<String, List<SysCodetype>> m = DictData.getSysCodetypeMap(
				spacename, visionType);
		if (m == null || m.size() == 0)
			return null;///throw new ServiceException("指定的VisionType代码" + visionType + "不存在！");

		List<SysCodetype> list = m.get(root);
		String[] s = null;
		if (CommonUtil.isNotEmpty(def)) {
			s = def.split(",");
		}

		// 没有子节点，那么表示最终节点
		if (CommonUtil.isEmpty(list)) {
			List<SysCode> codelist = DictData.getCodeMap(spacename,
					visionType).get(root);
			if(codelist != null) {
				for (SysCode code : codelist) {
					Code c = new Code();
					TreeNode n = new TreeNode();
					n.setChecked(false);
					n.setCode(c);
					n.setText(code.getCodename());
					n.setLeaf(true);
					c.setCode(code.getCode());
					c.setName(code.getCodename());
					c.setPyt(code.getPyt());
					if (s != null) {
						for (int i = 0; i < s.length; i++) {
							if (CommonUtil.isNotEmpty(s[i])) {
								if (c.getCode().equals(s[i]))
									n.setChecked(true);
							}
						}
					}
					nodeList.add(n);
				}
			}
		} else {
			for (SysCodetype codetype : list) {
				Code code = new Code();
				TreeNode node = new TreeNode();
				node.setChecked("true".equals(dict.get("checkAll"))?false:null);
				node.setText(codetype.getCodetypename());
				node.setCode(code);
				code.setCode(codetype.getCodetype());
				code.setName(codetype.getCodetypename());
				code.setPyt(codetype.getPyt());
				node.setLeaf(false);
				nodeList.add(node);
				if (set != null && set.contains(codetype.getCodetype())) {
					List<TreeNode> r = getCodeTypeChilds(spacename, visionType,
							codetype.getCodetype(), def, set, dict);
					if (r != null && r.size() > 0) {
						node.setExpanded(true);
						node.setChildren(r);
					}
				}
			}
		}

		return nodeList;
	}

	// 查找code是不是root的下级
	private String getParentCodeType(Set<String> list, String spacename,
			String visionType, String root, String code,Map<String, String> dict) {
		Map<String, List<SysCodetype>> m = DictData.getSysCodetypeMap(
				spacename, visionType);
		if (m == null || m.size() == 0)
			return null;

		if (root.equals(code))
			return null;

		for (String codetype : m.keySet()) {
			for (SysCodetype l : m.get(codetype)) {
				if (l.getCodetype().equals(code)) {
					list.add(codetype);
					return codetype;
				}
			}
		}

		return null;
	}

	protected void queryTree(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = ExtUtils.getRequestParamesString(request);
		List list = null;
		try {
			list = getTreeNodeList(map);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
		response.getOutputStream().print(jison);
	}
	
	private void queryMenu(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<TreeNode> list = null;
		try {
			String cjcode = request.getParameter("cjcode");
			//TreeNode node = FuncData.getMapZyMenuList(cjcode);
			//list = node.getChildren();
			if(list==null){
				list = new ArrayList<TreeNode>();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
		response.getOutputStream().print(jison);
	}
	
	protected void searchCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Gson gson = new GsonBuilder().create();
		List<Code> list = new ArrayList<Code>();
		
		Map<String,String> smap = ExtUtils.getRequestParamesString(request);

		String key = smap.get("query");			//搜索关键字
		String value = smap.get("value");		//搜索内容
		String VisionType = smap.get("VisionType");		//字典类型
		if(CommonUtil.isEmpty(VisionType))
			VisionType = smap.get("vtype");
		
		String exclude = smap.get("exclude");	//排除内容
		
		if(CommonUtil.isEmpty(key))
			key = null;
		else
			key = key.toLowerCase();
		
		if(CommonUtil.isEmpty(exclude))
			exclude = null;
		else
			exclude = "," + exclude + ",";
		
		if(CommonUtil.isEmpty(value))
			value = null;
		else{
			if(exclude==null)
				exclude = "";
			
			exclude += "," + value + ",";
		}
		
		if(exclude!=null)
			exclude = exclude.toLowerCase();
		
		String spacename = smap.get("sp");
		if (CommonUtil.isEmpty(spacename))
			spacename = DictData.SYS_SPACENAME;
		
		int max = 50,i=0;
		String str = "";
		if(VisionType.equals("DW") || VisionType.equals("DW2") || VisionType.equals("CCM")){
			java.util.Collection<SysOrganizeInfo> c = DictData.getAllSysOrganizeInfo();
			for(SysOrganizeInfo z:c){
				if(VisionType.equals("CCM")){
					str = z.getCcm() + "," + z.getMc();
				}else{
					str = z.getDwjgdm().toLowerCase() + "," + z.getMc();
				}
				
				if(z.getZwpy()!=null)
					str += "," + z.getZwpy().toLowerCase();
				
				//如果搜索词不为空，并且不匹配
				if(key!=null && str.indexOf(key)<0){
					continue;
				}
				
				//需要排除的
				if(exclude!=null){
					if(VisionType.equals("CCM")){
						if(exclude.indexOf("," + z.getCcm() + ",")>=0)
							continue;
					}else{
						if(exclude.indexOf("," + z.getDwjgdm() + ",")>=0)
							continue;
					}
				}
				
				Code code = new Code();
				code.setCode(VisionType.equals("CCM")?z.getCcm():z.getDwjgdm());
				code.setName(z.getMc());
				list.add(code);
				
				i++;
				if(i>=max)
					break;
			}
		}else if(VisionType.equals("RY")){
			java.util.Collection<XtYhxxb> c = DictData.getAllSysUserInfo();
			for(XtYhxxb z:c){
				str = z.getYhdlm().toLowerCase() + "," + z.getYhxm();

				//如果搜索词不为空，并且不匹配
				if(key!=null && str.indexOf(key)<0){
					continue;
				}
				
				//需要排除的
				if(exclude!=null){
					if(exclude.indexOf("," + z.getYhdlm().toLowerCase() + ",")>=0)
						continue;
				}
				
				Code code = new Code();
				code.setCode(z.getYhdlm());
				code.setName(z.getYhxm());
				list.add(code);
				
				i++;
				if(i>=max)
					break;
			}
		}else{
			Map<String,List<SysCode>> m = DictData.getCodeMap(spacename,VisionType);
			for(List<SysCode> l:m.values()){
				for(SysCode z:l){
					str = z.getCode().toLowerCase() + "," + z.getCodename();
					if(z.getPyt()!=null)
						str += "," + z.getPyt().toLowerCase();
					
					//如果搜索词不为空，并且不匹配
					if(key!=null && str.indexOf(key)<0){
						continue;
					}
					
					//需要排除的
					if(exclude!=null){
						if(exclude.indexOf("," + z.getCode().toLowerCase() + ",")>=0)
							continue;
					}
					
					Code code = new Code();
					code.setCode(z.getCode());
					code.setName(z.getCodename());
					list.add(code);
					
					i++;
					if(i>=max)
						break;
				}
			}
		}
		
		Page p = new Page();
		p.setList(list);
		p.setTotalCount(max);
		
		String jison = gson.toJson(p);

		response.getOutputStream().print(jison);
	}
	
	protected void queryCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取请求数据，必须封装在data参数中
		String data = request.getParameter("data");
		Gson gson = new GsonBuilder().create();
		List<String> list = gson.fromJson(data, new TypeToken<List<String>>(){}.getType());		
		
		Map<String, Dictcode> map = new HashMap<String, Dictcode>();
		int count=0;
		for (String dict : list) {
			count++;
			Map<String, String> smap = ExtUtils.urlDecode(dict);
			String spacename = smap.get("sp");
			if (CommonUtil.isEmpty(spacename))
				spacename = DictData.SYS_SPACENAME;
			
			Dictcode d = new Dictcode();
			d.setSmap(smap);
			List<Code> l = new ArrayList<Code>();
			d.setCodelist(l);
			if (smap.containsKey("vid"))
				map.put(smap.get("vid"), d);
			else if (smap.containsKey("tid")) {
				map.put(smap.get("tid"), d);
			}else{
				//对于没有VID的特殊字典，比如GRID，那么使用零时值
				map.put("_grid_" + count, d);
			}
			
			/*else {
				throw new ActionException("字典[" + dict + "]必须指定vid或者tid参数！");
			}
			 */
			
			// 这里只是翻译字典
			if (smap.containsKey("event")
					&& (smap.get("event").equals("openwindow") || smap.get("event").equals("ajax"))) {
				if (!smap.containsKey("def"))
					continue;

				String def[] = smap.get("def").split(",");
				String VisionType = smap.get("VisionType");
				if(CommonUtil.isEmpty(VisionType))
					VisionType = smap.get("vtype");
				
				if (VisionType.equals("DW")) {
					for (int i = 0; i < def.length; i++) {
						if (CommonUtil.isNotEmpty(def[i])) {
							SysOrganizeInfo jg = DictData.getZzjg(def[i]);
							Code code = new Code();
							if (jg == null){
								code.setCode(def[i]);
								code.setName(def[i]);
								code.setPyt(def[i]);
							}else{
								code.setCode(jg.getDwjgdm());
								code.setName(jg.getMc());
								code.setPyt(jg.getZwpy());
							}
							l.add(code);
						}
					}
				} else if (VisionType.equals("CCM") || VisionType.equals("DW2")) {
					for (int i = 0; i < def.length; i++) {
						if (CommonUtil.isNotEmpty(def[i])) {
							Code code = new Code();
							SysOrganizeInfo jg = DictData.getZzjgByCcm(def[i]);
							if (jg == null){
								code.setCode(def[i]);
								code.setName(def[i]);
								code.setPyt(def[i]);
							}else{
								code.setCode(jg.getCcm());
								code.setName(jg.getMc());
								code.setPyt(jg.getZwpy());
							}
							l.add(code);
						}
					}
				} else if (VisionType.equals("RY")) {
					for (int i = 0; i < def.length; i++) {
						if (CommonUtil.isNotEmpty(def[i])) {
							XtYhxxb jg = DictData.getZzjy(def[i]);

							Code code = new Code();
							if (jg == null) {
								code.setCode(def[i]);
								code.setName(def[i]);
							} else {
								code.setCode(jg.getYhdlm());
								code.setName(jg.getYhxm());
								code.setPyt(jg.getYhdlm());
							}
							l.add(code);
						}
					}
				} else {
					for (int i = 0; i < def.length; i++) {
						if (CommonUtil.isNotEmpty(def[i])) {
							SysCode jg = DictData.getSysCode(spacename, VisionType, def[i]);
							Code code = new Code();
							if (jg != null) {
								code = new Code();
								code.setCode(jg.getCode());
								code.setName(jg.getCodename());
								code.setPyt(jg.getPyt());
							}else{
								code.setCode(def[i]);
								code.setName(def[i]);
							}
							l.add(code);
						}
					}
				}
				continue;
			}

			String VisionType = smap.get("VisionType");
			if(CommonUtil.isEmpty(VisionType))
				VisionType = smap.get("vtype");
			
			Map<String, List<SysCode>> codemap = DictData.getCodeMap(spacename, VisionType);
			if (codemap != null){
				//throw new Exception("字典[" + smap.get("VisionType") + "]没有找到！");

				//List<SysCode> lcode = new ArrayList<SysCode>();
				for (String key : codemap.keySet()) {
					for (SysCode scode : codemap.get(key)) {
						Code code = new Code();
						code.setCode(scode.getCode());
						code.setName(scode.getCodename());
						code.setPyt(scode.getPyt());
						l.add(code);
					}
				}
			}
		}
		
		ExtCommonForm form = new ExtCommonForm();		
		String jison = gson.toJson(map, new TypeToken<Map<String,Dictcode>>(){}.getType());
		form.setData(jison);
		response.getOutputStream().print(gson.toJson(form));
	}
	
	public void destroy() {
		for(AutoService a:listservice)
			a.stop();
		
		super.destroy();
	}
}
