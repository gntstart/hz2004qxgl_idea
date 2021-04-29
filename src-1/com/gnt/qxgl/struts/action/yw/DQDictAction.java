package com.gnt.qxgl.struts.action.yw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.gnt.qxgl.bean.ExtField;
import com.gnt.qxgl.bean.SjpzBean;
import com.gnt.qxgl.bean.SysCode;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Constants;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.dict.DQDictDataShare;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.common.dict.bean.TreeNode;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.MemcachedUtils;
import com.gnt.qxgl.service.yw.DQDictService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class DQDictAction extends ExtCommonAction{
	private DQDictService dQDictService;
	
	public DQDictService getdQDictService() {
		return dQDictService;
	}

	public void setdQDictService(DQDictService dQDictService) {
		this.dQDictService = dQDictService;
	}

	/**
	 * 自定义字典，获取业务地区列表
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void listYwDqbm(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		String str = SystemConfig.getSystemConfig("dqlist");
		List<SysCode> list = new ArrayList<SysCode>();
		if(str!=null){
			if(str.startsWith("\"")) str = str.substring(1);
			if(str.endsWith("\"")) str = str.substring(0, str.length()-1);
			
			String[] s = str.split("&");
			for(String tmp:s){
				String[] dict = tmp.split("=");
				if(dict.length==2){
					SysCode code = new SysCode();
					code.setCode(dict[0]);
					code.setCodename(dict[1]);
					code.setVisiontype(request.getParameter("versionType"));
					list.add(code);
				}
			}
		}
		cform.setEntity(list);
	}
	
	/**
	 * 加载地区字典
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void loadDcit(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		Map<String,List<SysCode>> map = new HashMap<String,List<SysCode>>();
		
		String str = params.getString("visiontypes");
		for(String visiontype:str.split(",")){
			List<SysCode> list = DictData.getSysCodeList(visiontype.trim().toUpperCase());
			map.put(visiontype.trim(), list);
		}
		
		cform.setDictMap(map);
	}
	
	public void querySjpzb(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		SjpzBean  bean = dQDictService.querySjpzb(user, params);
		cform.setEntity(bean);
	}
	
	/**
	 * 街路项检索
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void searchJlx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		cform.setEntity(dQDictService.searchJlx(user, params));
	}
	
	/**
	 * 行政区划检索
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void searchXzqh(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		cform.setEntity(dQDictService.searchXzqh(user, params));
	}
	
	public void searchXxb(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		cform.setEntity(dQDictService.searchXxb(user, params));
	}
	
	/**
	 * 树节点加载
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void searchTreeXzqh(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		List<TreeNode> list  = DQDictDataShare.getTreeXzqh(pid);
		
		Gson gson = new GsonBuilder().create();
		String msg = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
		request.setAttribute(ExtCommonAction.JSON, msg);
	}
	
	/**
	 * 获取指定配置
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryYsjpzbJS(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		String pzlb = params.getString("pzlb");
		String returnKey = Constants.MEMCACHED_ATTR.DICT_SJPZB_ATTR + user.getYwdq() + "_" + pzlb;
		Object obj = MemcachedUtils.getValue(returnKey);
		if(obj!=null){
			cform.setEntity(obj);
		}else{
			cform.setEntity(dQDictService.queryYsjpzbJS(user, params));
		}
		//request.setAttribute(ExtCommonAction.JSON, str);
		System.out.println("ok");
	}
}
