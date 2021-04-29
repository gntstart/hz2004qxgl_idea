package com.gnt.qxgl.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.common.BaseUser;

public interface LocationLogin {
	/**
	 * 本地登陆接口，当过滤器用户验证通过以后，调用该方法做本地登陆操作。
	 * 如果需做本地登陆，那么必须在/conf/system-conf.prooperties中配置一个
	 * 实现了本接口的类。
	 * @param request
	 * @param response
	 * @param dao
	 * @param loginUser
	 * @param loginOrg
	 * @return	如果登陆成功，那么必须返回null,如果登陆失败，那么返回失败说明
	 */
	public String Login(HttpServletRequest request, HttpServletResponse response, BaseUser user);
}
