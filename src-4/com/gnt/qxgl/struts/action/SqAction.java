package com.gnt.qxgl.struts.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.dict.bean.TreeNode;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.service.SqService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class SqAction extends ExtCommonAction{
	private SqService sqService;

	public SqService getSqService() {
		return sqService;
	}

	public void setSqService(SqService sqService) {
		this.sqService = sqService;
	}
	
	/**
	 * 可分配权限管理
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryProjectJSTreeFP(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			
			List<TreeNode> list = sqService.queryProjectJSTreeFP(map);
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
			
			request.setAttribute(ExtCommonAction.JSON, jison);
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void queryProjectJSTree(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			
			List<TreeNode> list = sqService.queryProjectJSTree(map);
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
			
			request.setAttribute(ExtCommonAction.JSON, jison);
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void queryProjectTree(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			List<TreeNode> list = sqService.queryProjectTree();
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
			
			request.setAttribute(ExtCommonAction.JSON, jison);
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}

	public void queryProject(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			cform.setEntity(sqService.queryProject());
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	/**
	 * 
	 * 查询角色
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryJs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(sqService.queryJs(map, pageIndex, pageSize));
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	/**
	 * 
	 * 查询用户角色
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryUserJs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			map.put("opener",user.getUser().getDlm());
			cform.setEntity(sqService.queryUserJs(map, pageIndex, pageSize));
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	/**
	 * 查询角色功能点
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryFunc(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(sqService.queryFunc(map, pageIndex, pageSize));
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	/**
	 * 查询指定角色包含的警员
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryZzjyByJs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(sqService.queryZzjyByJs(map, pageIndex, pageSize));
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void saveJs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		if (user == null)
			throw new ActionException(LOGINOUT_MSG);
			
		Map<String, Object> map = ExtUtils.getRequestParames(request);	
		cform.setEntity(sqService.saveJs(map));

		MessageUtil.addGeneralMsg("操作执行成功！");
	}

	public void deleteJs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		if (user == null)
			throw new ActionException(LOGINOUT_MSG);
			
		Map<String, Object> map = ExtUtils.getRequestParames(request);
			
		sqService.deleteJs(map);
		MessageUtil.addGeneralMsg("操作执行成功！");
	}
	
	public void saveJsFunc(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		if (user == null)
			throw new ActionException(LOGINOUT_MSG);
			
		Map<String, Object> map = ExtUtils.getRequestParames(request);
			
		sqService.saveJsFunc(map);
		MessageUtil.addGeneralMsg("操作执行成功！");
	}
	
	public void saveZzjyJs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		if (user == null)
			throw new ActionException(LOGINOUT_MSG);
			
		Map<String, Object> map = ExtUtils.getRequestParames(request);
			
		sqService.saveZzjyJs(map);
		MessageUtil.addGeneralMsg("操作执行成功！");
	}
	
	public void updateZzjyJs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		if (user == null)
			throw new ActionException(LOGINOUT_MSG);
			
		Map<String, Object> map = ExtUtils.getRequestParames(request);
			
		sqService.updateZzjyJs(map);
		MessageUtil.addGeneralMsg("操作执行成功！");
	}

	public void saveProjectJs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		if (user == null)
			throw new ActionException(LOGINOUT_MSG);
		
		if(!user.checkFuncsAll("QXGLYHSQ"))
			throw new ActionException("错误，你无权执行该授权操作！");
		
		Map<String, Object> map = ExtUtils.getRequestParames(request);
			
		sqService.saveProjectJs(map);
		MessageUtil.addGeneralMsg("操作执行成功！");
	}
	
	public void queryYsqJSTree(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			List<TreeNode> list = sqService.queryYsqJSTree(map);
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
			
			request.setAttribute(ExtCommonAction.JSON, jison);
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void queryWsqJSTree(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			List<TreeNode> list = sqService.queryWsqJSTree(map);
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String jison = gson.toJson(list, new TypeToken<List<TreeNode>>() {}.getType());
			
			request.setAttribute(ExtCommonAction.JSON, jison);
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
}
