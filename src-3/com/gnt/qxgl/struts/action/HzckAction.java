package com.gnt.qxgl.struts.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.hz2004.entity.XtHzck;
import com.gnt.qxgl.service.HzckService;

public class HzckAction extends ExtCommonAction{
	
	private HzckService hzckService;
	
	public List<XtHzck> queryHzck(){
		
		return hzckService.getHzckInfo();
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
	
}
