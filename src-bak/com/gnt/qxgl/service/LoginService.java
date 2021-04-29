package com.gnt.qxgl.service;

import java.util.Map;

public interface LoginService {
	/**
	 * 普通登录
	 * @param uid
	 * @param pwd
	 * @return
	 */
	public boolean login(String uid,String pwd);
	
	public void changePwd(Map<String,Object> params);
}
