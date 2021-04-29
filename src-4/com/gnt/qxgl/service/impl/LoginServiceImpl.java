package com.gnt.qxgl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.bean.SysFunctionInfo;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.HSession;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.base.TemplateUtil;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.hz2004.entity.XtJsxxb;
import com.gnt.qxgl.hz2004.entity.XtYh;
import com.gnt.qxgl.service.LoginService;

public class LoginServiceImpl extends ServiceImpl implements LoginService{
	public void changePwd(Map<String, Object> params) {
		BaseUser u = BaseContext.getBaseUser();
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

	public BaseUser loginByYhm(String yhm, ExtMap<String,Object> params) {
		String hql = "from XtYh where dlm=?";
		Object obj = super.getObject(hql, new Object[]{yhm});
		if(obj==null)
			throw new ServiceException("用户名不存在！");
		
		XtYh yh = (XtYh)obj;

		return login(yh.getDlm(), yh.getDlkl(), params);
	}

	private BaseUser loginBYSID(String yhm, String sid, ExtMap<String,Object> params) {
		String hql = "from XtYh where dlm=?";
		Object obj = super.getObject(hql, new Object[]{yhm});
		if(obj==null)
			throw new ServiceException("用户名不存在！");
		
		XtYh yh = (XtYh)obj;
		if(!yh.getDlsid().equals(sid))
			throw new ServiceException("已过期！");
		
		if(!DateHelper.formateDate(yh.getDlsidsj(), "yyyyMMdd").equals(DateHelper.formateDate("yyyyMMdd")))
			throw new ServiceException("已过期！");
		
		return login(yh.getDlm(), yh.getDlkl(), params);
	}
	
	public BaseUser loginBYSID(String yhm, String sid) {
		return loginBYSID(yhm, sid, null);
	}

	public BaseUser login(String uid, String pwd){
		return login(uid,pwd,null);
	}
	
	private BaseUser login(String uid, String pwd, ExtMap<String,Object> params) {
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
		u.setOtherParams(params);
		
		if(u.getOtherParams()!=null 
				&& u.getOtherParams().containsKey("authToken") 
				&& CommonUtil.isNotEmpty(u.getOtherParams().getString("yhid")))
		{
			String dqbm = u.getOtherParams().getString("dwdm");
			if(CommonUtil.isEmpty(dqbm))
				throw new ServiceException("未知地区信息！");
			
			dqbm = dqbm.substring(0,4);
			u.setYwdq(dqbm);
			u.setDqyhid(u.getOtherParams().getString("yhid"));
			
			//读取角色
			Session session = null;
			try{
				session = HibernateUtil.getSystemSessionFactory(u.getYwdq()).openSession();
				hql = "select a from XtJsxxb a,XtYhxxb b,XtYhjsxxb c where a.jsid=c.jsid and b.yhid=c.yhid and b.yhid=?";
				List<?> list = HibernateUtil.getObjectList(session, hql, new Object[]{u.getDqyhid()});
				for(Object o:list){
					XtJsxxb js = (XtJsxxb)o;
					if(js.getJsmc().equals("超级用户")){
						u.setAdmin(true);
						break;
					}
				}
				u.setRoles((List<XtJsxxb>)list);
				
				if(!u.isAdmin()){
					hql = "select sjfw from XtYhsjfwb a where xqlx='1' and yhid=?";
					List<?> sjfwlist = HibernateUtil.getObjectList(session, hql, new Object[]{u.getDqyhid()});
					String sjfw = "";
					for(Object o:sjfwlist){
						String[] str = o.toString().split("\\|");
						if(str.length>0)
							sjfw += str[str.length-1] + "|";
					}
					u.setSjfw(sjfw);
				}
			}catch(Exception e){
				e.printStackTrace();

				throw new ServiceException(e);
			}finally{
				if(session!=null)
					session.close();
			}
		}
		
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
		
		if(!HSession.saveUser(u))
			throw new ServiceException("验证通过，但是缓存异常，无法保存登录信息！");
		
		return u;
	}
}
