package com.gnt.qxgl.struts.action;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.hz2004.entity.XtHzck;
import com.gnt.qxgl.service.CsjHkKsWsQyService;
import com.gnt.qxgl.service.HzckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class HzckAction extends ExtCommonAction{
	
	private HzckService hzckService;
	private CsjHkKsWsQyService csjHkKsWsQyService;
	public List<XtHzck> queryHzck(){
		
		return hzckService.getHzckInfo();
	}
	
	public void queryEchartsData(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
//			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
//			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			cform.setEntity(hzckService.queryEchartsData(map));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
		
	}
	public void querySsxqqrsffbbData(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			//int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			//int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(hzckService.querySsxqqrsffbbData(map));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
		
	}	
	public void queryMx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);
			
			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			
			cform.setEntity(hzckService.queryYhxx(map, pageIndex, pageSize));
			cform.setDateStyle("yyyy/MM/dd HH:mm");
			
		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
		
	}
	
	public HzckService getHzckService() {
		return hzckService;
	}

	public void setHzckService(HzckService hzckService) {
		this.hzckService = hzckService;
	}

	public CsjHkKsWsQyService getCsjHkKsWsQyService() {
		return csjHkKsWsQyService;
	}

	public void setCsjHkKsWsQyService(CsjHkKsWsQyService csjHkKsWsQyService) {
		this.csjHkKsWsQyService = csjHkKsWsQyService;
	}

	public void queryYzsxx(BaseUser user, ExtCommonForm cform,
						   HttpServletRequest request, HttpServletResponse response){
		try{
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String)map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String)map.get(ExtUtils.pageSize));
			map.put("gsdwmc","340000000");
			cform.setEntity(csjHkKsWsQyService.queryCsjhkkswsxx(map,pageIndex,pageSize).getList());
			cform.setDateStyle("yyyy/MM/dd HH:mm");

		}catch(Exception e){
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}
	
}
