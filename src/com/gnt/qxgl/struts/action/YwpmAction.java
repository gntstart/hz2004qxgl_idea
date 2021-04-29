package com.gnt.qxgl.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.service.YwpmService;

public class YwpmAction extends ExtCommonAction{
	
	private YwpmService ywpmService;
	
	public void queryYwpmDs(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response){
		
		cform.setEntity(ywpmService.queryYwpmDs());
	}
	
	public void queryMx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		cform.setEntity(ywpmService.queryYwpm(params));
		
	}
	
	public void queryPr(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		cform.setEntity(ywpmService.queryPr(params));
		
	}
	
	public YwpmService getYwpmService() {
		return ywpmService;
	}
	
	public void setYwpmService(YwpmService ywpmService) {
		this.ywpmService = ywpmService;
	}
	
}
