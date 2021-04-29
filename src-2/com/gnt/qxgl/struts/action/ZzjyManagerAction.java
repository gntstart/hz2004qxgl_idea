package com.gnt.qxgl.struts.action;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.bean.QuerySysUserInfo;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;
import com.gnt.qxgl.service.ZzjyManagerService;

public class ZzjyManagerAction extends ExtCommonAction{
	private ZzjyManagerService zzjyManagerService;

	public ZzjyManagerService getZzjyManagerService() {
		return zzjyManagerService;
	}

	public void setZzjyManagerService(ZzjyManagerService zzjyManagerService) {
		this.zzjyManagerService = zzjyManagerService;
	}
	
	public void queryZzjyById(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			
			QuerySysUserInfo o = zzjyManagerService.queryZzjyById(map);
			cform.setEntity(o);
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			
			for(Object obj:cform.getList()){
				if(obj instanceof XtYhxxb){
					XtYhxxb yh = (XtYhxxb)obj;
					yh.setDlkl(null);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void queryZzjy(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(zzjyManagerService.queryZzjy(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			
			for(Object obj:cform.getList()){
				if(obj instanceof XtYhxxb){
					XtYhxxb yh = (XtYhxxb)obj;
					yh.setDlkl(null);
				}
			}
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void initPassword(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			zzjyManagerService.initPassword(request.getParameter("id"));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("初始化密码成功！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void moveZzjy(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			String usid = request.getParameter("usid");
			String moveto = request.getParameter("movetoOrgBm");
			String moveform = request.getParameter("oldOrgBm");
			
			zzjyManagerService.moveZzjy(usid,moveform,moveto);
			//DictData.reLoadZzjy(null);
			
			MessageUtil.addGeneralMsg("人员移动成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void changeZzjyZt(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			if(!user.checkFuncsAll("JGRYGL"))
				throw new ActionException("错误，你无权执行该授权操作！");
			
			zzjyManagerService.changeZzjyZt(request.getParameter("dwbm"), request.getParameter("ids"),request.getParameter("yhzt"));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void saveJzZzjg(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			if(!user.checkFuncsAll("JGRYGL"))
				throw new ActionException("错误，你无权执行该授权操作！");
			
			//saveJz({loginName:loginName,jzOrganizeInfoBm:jzOrganizeInfoBm});
			zzjyManagerService.saveJzZzjg(ExtUtils.getRequestParames(request));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("成功保存兼职单位信息！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void deleteZzjg(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			if(!user.checkFuncsAll("JGRYGL"))
				throw new ActionException("错误，你无权执行该授权操作！");
			
			zzjyManagerService.deleteZzjg(request.getParameter("ids"));
			try{
				//DictData.reLoadZzjg(null);
				//DictData.reLoadZzjy(null);
			}catch(Exception e){
				;
			}
			
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("成功删除选择的机构！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void saveZzjy(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			if(!user.checkFuncsAll("JGRYGL"))
				throw new ActionException("错误，你无权执行该授权操作！");
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			XtYhxxb yh = zzjyManagerService.saveZzjy(map,request);
			
			cform.setEntity(yh);
			try{
				//DictData.reLoadZzjg(null);
				//DictData.reLoadZzjy(null);
			}catch(Exception e){
				;
			}
			
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			if(CommonUtil.isNotEmpty(yh.getKhmsg()))
				MessageUtil.addGeneralMsg(yh.getKhmsg());
			else
				MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void querySearchZzjg(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(zzjyManagerService.querySearchZzjg(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void queryZzjg(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(zzjyManagerService.queryZzjg(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			
			
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void getIPXZ(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(zzjyManagerService.getIPXZ(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void createIPXZ(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);

			cform.setEntity(zzjyManagerService.createIPXZ(map));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void deleteIPXZ(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);

			zzjyManagerService.deleteIPXZ(map);
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void getSJFW(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(zzjyManagerService.getSJFW(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void createSJFW(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);

			cform.setEntity(zzjyManagerService.createSJFW(map));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void deleteSJFW(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);

			zzjyManagerService.deleteSJFW(map);
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void getDTQX(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(zzjyManagerService.getDTQX(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void createDTQX(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);

			cform.setEntity(zzjyManagerService.createDTQX(map));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void deleteDTQX(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);

			zzjyManagerService.deleteDTQX(map);
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void getDZQX(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(zzjyManagerService.getDZQX(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void createDZQX(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);

			cform.setEntity(zzjyManagerService.createDZQX(map));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void deleteDZQX(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);

			zzjyManagerService.deleteDZQX(map);
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	public void getXtYhksjg(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			cform.setEntity(zzjyManagerService.getXtYhksjg(request));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
	/**
	 * 查询考核结果
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryKhjg(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(zzjyManagerService.queryKhjg(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			MessageUtil.addGeneralMsg("操作执行成功！");
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
}
