package com.gnt.qxgl.service;

import java.util.Map;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;

public interface LoginService {
	/**
	 * 普通登录
	 * @param uid
	 * @param pwd
	 * @return
	 */
	public BaseUser login(String uid,String pwd);
	
	/**
	 * 自动登录
	 * @param yhm
	 * @param sid
	 * @return
	 */
	public BaseUser loginBYSID(String yhm,String sid);
	
	/**
	 * 以特定用户自动登录
	 * @param yhm
	 * @return
	 */
	public BaseUser loginByYhm(String yhm, ExtMap<String,Object> params);
	
	public void changePwd(Map<String,Object> params);
}
