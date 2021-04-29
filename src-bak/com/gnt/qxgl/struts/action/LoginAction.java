package com.gnt.qxgl.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.service.LoginService;

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
}
