package com.gnt.qxgl.common;

import java.util.UUID;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.LoginFilter;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.MemcachedUtils;

/**
 * 回话工具类，封装
 * @author ting_it
 *
 */
public class HSession {
	static public boolean saveUser(BaseUser user){
		String sid = getSID();
		user.setSid(sid);
		
		return MemcachedUtils.setSessionInfo(user);
	}
	
	static public String getSID(){
		String sid = (String)BaseContext.getContext().getRequest().getAttribute(Constants.COOKIE_SID);
		if(CommonUtil.isEmpty(sid)){
			sid = LoginFilter.getSID(BaseContext.getContext().getRequest(), BaseContext.getContext().getResponse());
		}
		return sid;
	}
	
	/**
	 * 创建一个会话随机数SID
	 * @return
	 */
	static public String createSID(){
		String sid = Constants.MEMCACHED_ATTR.SID_ATTR + UUID.randomUUID().toString() + "." + (System.currentTimeMillis()/1000);
		return sid;
	}
	
	/**
	 * 获取当前用户信息
	 * @param sid
	 * @return
	 */
	static public BaseUser getCurrentBaseUser(){
		BaseUser u = BaseContext.getBaseUser();
		if(u!=null)
			return u;

		return getBaseUser(null);
	}
	
	/**
	 * 获取指定用户信息
	 * @param sid
	 * @return
	 */
	static public BaseUser getBaseUser(String sid){
		if(CommonUtil.isEmpty(sid))
			sid = getSID();
		
		return MemcachedUtils.getSessionInfo(sid);
	}
}
