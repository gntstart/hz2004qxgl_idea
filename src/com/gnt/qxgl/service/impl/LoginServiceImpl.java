package com.gnt.qxgl.service.impl;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.bean.SysFunctionInfo;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.HSession;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.hz2004.entity.XtJsxxb;
import com.gnt.qxgl.hz2004.entity.XtYh;
import com.gnt.qxgl.service.LoginService;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		/**
		 * 				params.put("authToken", authToken);
						params.put("sfzh", sfzh);
						params.put("yhxm", yhxm);
						params.put("yhid", yhid);
						params.put("dwdm", dwdm);
						params.put("yhdlm", yhdlm);
		 */



		BaseUser u = new BaseUser();
		u.setUser((XtYh)obj);
		Map<String, SysFunctionInfo> funcs = new HashMap<String, SysFunctionInfo>();
		u.setFuncs(funcs);
		u.setOtherParams(params);
		u.setAuthToken(yh.getYhid());
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
				
				/*//验证用户
				PoXT_YHXXB dqyh = (PoXT_YHXXB)HibernateUtil.getObject(session, "from PoXT_YHXXB where yhid=" + u.getOtherParams().getString("yhid"), null);
				if(dqyh==null)
					throw new ServiceException("地区用户不存在！");
				
				PoXT_YHHHXXB dqhh = (PoXT_YHHHXXB)HibernateUtil.getObject(session, "from PoXT_YHHHXXB where hhid='" + u.getOtherParams().getString("authToken") + "'", null);
				if(dqhh==null)
					//throw new ServiceException("身份信息无效！");
					throw new ServiceException("身份信息无效！".getBytes("UTF-8").toString());
				if(!dqhh.getYhid().toString().equals(u.getOtherParams().getString("yhid")))
					throw new ServiceException("身份信息不匹配！");*/

				/**
				 * 				params.put("authToken", authToken);
								params.put("sfzh", sfzh);
								params.put("yhxm", yhxm);
								params.put("yhid", yhid);
								params.put("dwdm", dwdm);
								params.put("yhdlm", yhdlm);
				 */
//				params.put("sfzh", dqyh.getGmsfhm());
//				params.put("yhxm", dqyh.getYhxm());
//				params.put("yhdlm", dqyh.getYhdlm());

//				params.put("sfzh", yh.getGmsfhm());
//				params.put("yhxm", yh.getXm());
//				params.put("yhdlm", yh.getDlm());

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


                String isAdmin = (String) params.get("isAdmin");
                if(null != isAdmin){
                    hql = "select sjfw from XtYhsjfwb a where xqlx='1' and yhid=?";
                    List<?> sjfwlist = HibernateUtil.getObjectList(session, hql, new Object[]{u.getDqyhid()});
                    String sjfw = "";
                    for(Object o:sjfwlist){
                        String[] str = o.toString().split("\\|");
                        if(str.length>0)
                        	if(str.length==1){
								sjfw += str[0] + "|";
							}else if(str.length>=2){
								sjfw += str[1] + "|";
							}
//                            for (String s : str) {
//                                sjfw += s + "|";
//                            }

                    }
                    u.setSjfw(sjfw);
                }

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


		//boolean isadmin =  ("," + SystemConfig.getSystemConfig("admin", "admin,root") + ",").indexOf("," + u.getUser().getDlm() + ",")>=0?true:false;
		if(u.isAdmin()){
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

			SysFunctionInfo f5 = new SysFunctionInfo();
			f5.setFunctionBm("RKZLT");
			f5.setFunctionName("人口总览图");
			f5.setFunctionUrl("echartsZl.jsp");

			SysFunctionInfo f6 = new SysFunctionInfo();
			f6.setFunctionBm("YZSYDQC");
			f6.setFunctionName("长三角跨省迁移");
			f6.setFunctionUrl("yw/yzsydqc.jsp");

			SysFunctionInfo f8 = new SysFunctionInfo();
			f8.setFunctionBm("YWTB");
			f8.setFunctionName("长三角户籍证明");
			f8.setFunctionUrl("yw/ywtbxx.jsp");

			SysFunctionInfo f9 = new SysFunctionInfo();
			f9.setFunctionBm("QGRKPC");
			f9.setFunctionName("全国人口普查");
			f9.setFunctionUrl("yw/qgrkpc.jsp");

			SysFunctionInfo f10 = new SysFunctionInfo();
			f10.setFunctionBm("CSJHKKSWSQYQK");
			f10.setFunctionName("长三角户口跨省网上迁移情况");
			f10.setFunctionUrl("yw/csjhkkswsqyqk.jsp");
			
			funcs.put(f1.getFunctionBm(), f1);
			funcs.put(f2.getFunctionBm(), f2);
			funcs.put(f3.getFunctionBm(), f3);
			funcs.put(f4.getFunctionBm(), f4);
			funcs.put(f6.getFunctionBm(), f6);
			funcs.put(f8.getFunctionBm(), f8);
			funcs.put(f9.getFunctionBm(), f9);
			funcs.put(f10.getFunctionBm(), f10);
		}

		if(!HSession.saveUser(u))
			throw new ServiceException("验证通过，但是缓存异常，无法保存登录信息！");

		return u;
	}
}
