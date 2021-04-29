package com.gnt.qxgl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.BaseLogin;
import com.gnt.qxgl.base.LocationLogin;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.bean.SysFunctionInfo;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.base.TemplateUtil;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.hz2004.entity.XtYh;
import com.gnt.qxgl.hz2004.entity.XtYhdtqxb;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;
import com.gnt.qxgl.service.LoginService;

public class LoginServiceImpl extends ServiceImpl implements LoginService{
	public void changePwd(Map<String, Object> params) {
		BaseUser u = (BaseUser)BaseContext.getContext().getRequest().getSession().getAttribute(BaseUser.SESSION_USER);
		if(u==null)
			throw new ServiceException(ExtCommonAction.LOGINOUT_MSG);

		String pwd = (String)params.get("oldpwd");
		String pwd1 = (String)params.get("pwd1");
		String pwd2 = (String)params.get("pwd2");
		
		if(CommonUtil.isEmpty(pwd1) || CommonUtil.isEmpty(pwd2) || !pwd1.equals(pwd2))
			throw new ServiceException("必须输入新密码，并且两次输入的新密码必须一致！");
		
		XtYh newu = super.get(XtYh.class, u.getUser().getYhid());
		if(!newu.getDlkl().equals(pwd))
			throw new ServiceException("原口令不正确！");
		newu.setDlkl(pwd1);
		super.update(newu);

		return;
	}

	public boolean login(String uid, String pwd) {
		String hql = "from XtYh where dlm=?  and dlkl=?";
		Object obj = super.getObject(hql, new Object[]{uid,pwd});
		if(obj==null)
			throw new ServiceException("用户名或者密码错误！");
		
		XtYh yh = (XtYh)obj;
		if(yh.getZt().equals("1"))
			throw new ServiceException("此用户已经删除，禁止登录！");
		
		if(!yh.getSsdwjgdm().startsWith("3400")){
			;//throw new ServiceException("非省厅用户禁止登陆！");
		}
		
		BaseUser u = new BaseUser();
		u.setUser((XtYh)obj);
		Map<String, SysFunctionInfo> funcs = new HashMap<String, SysFunctionInfo>();
		u.setFuncs(funcs);
		BaseContext.getContext().setAttribute(BaseUser.SESSION_USER, u);
		if(TemplateUtil.isAdmin()){
			SysFunctionInfo f1 = new SysFunctionInfo();
			f1.setFunctionBm("JGRYGL");
			f1.setFunctionName("机构人员管理");
			f1.setFunctionUrl("ry/jgrygl.jsp");
			
			SysFunctionInfo f2 = new SysFunctionInfo();
			f2.setFunctionBm("QXGLJSGL");
			f2.setFunctionName("角色管理");
			f2.setFunctionUrl("sq/jsgl.jsp");
			
			SysFunctionInfo f3 = new SysFunctionInfo();
			f3.setFunctionBm("QXGLXGMM");
			f3.setFunctionName("修改密码");
			f3.setFunctionUrl("");
			
			SysFunctionInfo f4 = new SysFunctionInfo();
			f4.setFunctionBm("QXGLYHSQ");
			f4.setFunctionName("用户授权");
			f4.setFunctionUrl("sq/yhsq.jsp");
			
			
			funcs.put(f1.getFunctionBm(), f1);
			funcs.put(f2.getFunctionBm(), f2);
			funcs.put(f3.getFunctionBm(), f3);
			funcs.put(f4.getFunctionBm(), f4);
		}
		
		
		
		return true;
	}
}
