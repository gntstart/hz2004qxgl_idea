package com.gnt.qxgl.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.service.LoginService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginAction extends ExtCommonAction{
	private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public void login(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		loginService.login(request.getParameter("uid"), request.getParameter("pwd"));
		MessageUtil.addGeneralMsg("成功！");
	}
	
	public void changePwd(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		if(!user.checkFuncsAll("QXGLXGMM"))
			throw new ActionException("错误，你无权修改密码！");
		
		loginService.changePwd(ExtUtils.getRequestParames(request));
		MessageUtil.addGeneralMsg("密码修改成功！");
	}

	public void getUserInfo(BaseUser user, ExtCommonForm cform,
							HttpServletRequest request, HttpServletResponse response){
		cform.setEntity(getUserMap(user));
	}

	/**
	 * 对象---》字符串
	 * @param src
	 * @return
	 */
	static public String toJson(Object src){
		GsonBuilder build = new GsonBuilder();
		Gson gson = build.create();
		//net.sf.cglib.proxy.CallbackFilter a;
		return gson.toJson(src);
	}

	private Map<String,String> getUserMap(BaseUser user){
		if(user!=null){
			Map<String,String> p = new HashMap<String,String>();
			p.put("gmsfhm", user.getUser().getGmsfhm());
			p.put("yhdlm",  user.getUser().getDlm());
			p.put("yhid",  user.getUser().getYhid().toString());
			p.put("dwdm", user.getUser().getSsdwjgdm());
			p.put("xm", user.getUser().getXm());
			p.put("dwmc", user.getUser().getSsdwjgdm());
			p.put("authToken", user.getAuthToken());
			p.put("tokey", CommonUtil.getTokey());
			return p;
		}
		return null;
	}
}
