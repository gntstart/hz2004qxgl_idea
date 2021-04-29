package com.gnt.qxgl.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.bean.QuerySysOrganizeInfo;
import com.gnt.qxgl.bean.QuerySysUserInfo;
import com.gnt.qxgl.bean.SimpleJson;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.common.dict.bean.Code;
import com.gnt.qxgl.common.dict.bean.SysOrganizeInfo;
import com.gnt.qxgl.common.dict.bean.TreeNode;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.XtSpdzb;
import com.gnt.qxgl.hz2004.entity.XtYh;
import com.gnt.qxgl.hz2004.entity.XtYhdtqxb;
import com.gnt.qxgl.hz2004.entity.XtYhdzqxb;
import com.gnt.qxgl.hz2004.entity.XtYhipyxxxb;
import com.gnt.qxgl.hz2004.entity.XtYhksjg;
import com.gnt.qxgl.hz2004.entity.XtYhsjfwb;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;
import com.gnt.qxgl.service.UpFile;
import com.gnt.qxgl.service.ZzjyManagerService;

public class ZzjyManagerServiceImpl extends ServiceImpl implements ZzjyManagerService{
	/**
	 * 单位信息字典：KEY=4位区划，VALUE=[KEY=单位代码，NAME=单位名称]
	 */
	static public final Map<String,Map<String,String>> dwMap = new HashMap<String,Map<String,String>>();
	
	public void changeZzjyZt(String dqbm, String ids,String yhzt) {
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			String[] id = ids.split(",");
			for(int i=0;i<id.length;i++){
				String usid = id[i];
				if(CommonUtil.isNotEmpty(usid)){
					XtYhxxb u = HibernateUtil.get(session, XtYhxxb.class, usid);
					if(u!=null){
						u.setYhzt(yhzt);
						super.update(u);
						HibernateUtil.update(session, u);
					}
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}

	public void deleteZzjg(String ids) {

	}

	public void initPassword(String usid) {
		String[] id = usid.split(",");
		for(int i=0;i<id.length;i++){
			if(CommonUtil.isEmpty(id[i]))
				continue;
			
			XtYhxxb u = super.get(XtYhxxb.class, id[i]);
			if(u==null){
				throw new ServiceException("该警员不存在，已经被物理删除！");
			}
			
			String initpwd = SystemConfig.getSystemConfig("initUserPWD","123456");
			u.setDlkl(initpwd);
			//u.setJmLoginPassword(Utils.getEncryptedString(initpwd));
			
			super.update(u);
		}
	}

	public byte[] getZzjgImg(String type, String oraid) {
		return new byte[]{};
	}

	public byte[] getZzjyTx(String usid) {
		return null;
	}

	public QuerySysUserInfo queryZzjyById(Map<String, Object> map) {
		String dwdm = (String)map.get("dwdm"); //必须
		
		SqlParse sqlParse = new SqlParse(Config.getSql("queryZzjy"));
		sqlParse.bind(map);
		SqlParam sqlParam = sqlParse.parse();
		
		List<?> list = null;
		
		Session session = null;
		//Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();
			//tran = session.beginTransaction();
			list = HibernateUtil.getObjectList(session,  sqlParam.getSql(),  sqlParam.getParams().toArray());
			//tran.commit();
			
			for(Object o:list){
				XtYhxxb u = (XtYhxxb)o;
				
				//计算一下数据范围
				QuerySysUserInfo q = new QuerySysUserInfo();
				CommonUtil.copyInfo(u, q, null);
				
				String dbm = q.getDwdm().substring(0,4);
				if(ZzjyManagerServiceImpl.dwMap.containsKey(dbm)){
					String mc = ZzjyManagerServiceImpl.dwMap.get(q.getDwdm().substring(0, 4)).get(q.getDwmc());
					q.setDwmc(mc);
				}
				
				return q;
			}
			
			throw new ServiceException("没有找到该警员！");
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
	}

	public Page queryZzjy(Map<String, Object> map, int pageIndex, int pageSize) {
		String ccm = (String)map.get("ccm");
		if(ccm.endsWith("0000000000")){
			ccm = ccm.substring(0,2);
		}else if(ccm.endsWith("00000")){
			ccm = ccm.substring(0,4);
			//341321000
		}else if(ccm.endsWith("000")){
			ccm = ccm.substring(0,6);
		}
		map.put("ccm", ccm);
		
		SqlParse sqlParse = new SqlParse(Config.getSql("queryZzjy"));
		sqlParse.bind(map);
		SqlParam sqlParam = sqlParse.parse();
		
		if(ccm.length()==2){
			//省厅，只能查看
			Page p = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
			for(Object obj:p.getList()){
				XtYhxxb yh = (XtYhxxb)obj;
				String dbm = yh.getDwdm().substring(0,4);
				
				String zwmc = DictData.getCodeName("CS_YHZW", yh.getYhzw());
				yh.setZwmc(zwmc);
				
				if(ZzjyManagerServiceImpl.dwMap.containsKey(dbm)){
					String mc = ZzjyManagerServiceImpl.dwMap.get(yh.getDwdm().substring(0, 4)).get(yh.getDwmc());
					yh.setDwmc(mc);
				}else{
					yh.setDwmc(yh.getDwdm());
				}
			}
			return p;
		}
		
		Session session = null;
		//Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(ccm.substring(0,4)).openSession();
			//tran = session.beginTransaction();
			
			Page p = HibernateUtil.getPageRecords(session, sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
			for(Object obj:p.getList()){
				XtYhxxb yh = (XtYhxxb)obj;
				String dbm = yh.getDwdm().substring(0,4);
				
				String zwmc = DictData.getCodeName("CS_YHZW", yh.getYhzw());
				yh.setZwmc(zwmc);
				
				if(ZzjyManagerServiceImpl.dwMap.containsKey(dbm)){
					String mc = ZzjyManagerServiceImpl.dwMap.get(yh.getDwdm().substring(0, 4)).get(yh.getDwmc());
					yh.setDwmc(mc);
				}else{
					yh.setDwmc(yh.getDwdm());
				}
			}
			//tran.commit();
			
			return p;
		}catch(Exception e){
			e.printStackTrace();
			//tran.rollback();
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}

	public String getCcm(SysOrganizeInfo p){
		String bm = null;
				
		//创建
		String hsql = "";
		hsql = "select max(a.ccm) from " + SysOrganizeInfo.class.getName() 
					+ " a where a.ccm like '" + p.getCcm() + "%' and length(a.ccm)=" + (p.getCcm().length() +6);
		Object obj = super.getObject(hsql,null);
		if(obj==null){				
			bm = p.getCcm() + "000001";
		}else{
			bm = (String)obj;
			java.text.DecimalFormat df=new java.text.DecimalFormat("000000");   
			bm = bm.substring(0,bm.length()-6) + df.format(Integer.parseInt(bm.substring(bm.length()-6))+1);
		}
		
		return bm;
	}
	
	public SimpleJson saveZzjg(Map parm,HttpServletRequest req){
		/*
		SysUserInfo loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		if(!BaseContext.getBaseUser().checkFuncsAll("JGRYGL"))
			throw new ActionException("错误，你无权执行该操作！");
		
		FileItem dwgz = (FileItem)parm.get("dwgz");
		FileItem jzy = (FileItem)parm.get("jzy");
		SysOrganizeInfo u=null,saveu = null;
		try{
			u = CommonUtil.copyInfo(SysOrganizeInfo.class, null, parm);
			
			String hsql = "select count(organizeBm) from SysOrganizeInfo where organizeBm=?"; 
			if(CommonUtil.isNotEmpty(u.getOrgid())){
				hsql += " and orgid<>'" + u.getOrgid() + "'";
			}
			
			Long l = (Long)super.getObject(hsql, new Object[]{u.getOrganizeBm()});
			if(l.intValue()>0){
				throw new ServiceException("错误，单位编码重复！");
			}
			
			if(CommonUtil.isEmpty(u.getOrgid())){
				saveu = new SysOrganizeInfo();
				saveu.setNewDate(new Date());
				saveu.setNewUserId(loginu.getUsid());
				saveu.setZxbz("0");
				
				//计算CCM
				String ParentOrganizeBm = (String)parm.get("ParentOrganizeBm");
				if(CommonUtil.isEmpty(ParentOrganizeBm))
					throw new ServiceException("错误，新建单位必须指定父亲单位编码参数！");
				
				SysOrganizeInfo p = DictData.getZzjg(ParentOrganizeBm);
				if(p==null)
					throw new ServiceException("错误，编码为" + ParentOrganizeBm + "的单位编码不存在！");
				
				saveu.setOrganizeBm(u.getOrganizeBm());
				saveu.setCcm(getCcm(p));
			}else{
				saveu = super.get(SysOrganizeInfo.class, u.getOrgid());
			}
			
			saveu.setOrganizeName(u.getOrganizeName());
			saveu.setDwjc(u.getDwjc());
			saveu.setGajjc(u.getGajjc());
			saveu.setJcgajjc(u.getJcgajjc());
			saveu.setPyt(u.getPyt());
			saveu.setPcsdm(u.getPcsdm());
			saveu.setDwdh(u.getDwdh());
			saveu.setSsqh(u.getSsqh());
			saveu.setDwjb(u.getDwjb());
			saveu.setYwxtfl(u.getYwxtfl());
			saveu.setDwlx(u.getDwlx());
			saveu.setOrganizeOrder(u.getOrganizeOrder());
			saveu.setBz(u.getBz());
			saveu.setAdminlb(u.getAdminlb());
			
			if(saveu.getCcm().length()==6){
				saveu.setOrganizePath(saveu.getOrganizeName());
			}else{
				SysOrganizeInfo p = DictData.getZzjgByCcm(saveu.getCcm().substring(0,saveu.getCcm().length() - 6));
				saveu.setOrganizePath(DictData.getOrganizePath(p.getOrganizeBm()) + "/" + saveu.getOrganizeName());
			}
			if(dwgz!=null && dwgz.getSize()>0){
				String fname = dwgz.getName();
				if(fname.indexOf(".")>0)
					fname = fname.substring(fname.lastIndexOf(".")+1);
				
				if("jpg,jpeg,gif,png,".indexOf(fname)<0)
					throw new ServiceException("单位公章必须为图片文件！");
				
				if(dwgz.getSize()>10240000)
					throw new ServiceException("错误，单位公章太大，最多不能超过1M！");
				
				saveu.setDwgz(dwgz.get());
			}
			
			if(jzy!=null && jzy.getSize()>0){
				String fname = jzy.getName();
				if(fname.indexOf(".")>0)
					fname = fname.substring(fname.lastIndexOf(".")+1);
				
				if("jpg,jpeg,gif,png,".indexOf(fname)<0)
					throw new ServiceException("局长印必须为图片文件！");
				
				if(jzy.getSize()>10240000)
					throw new ServiceException("错误，局长印文件太大，最多不能超过1M！");
				
				saveu.setJzy(jzy.get());
			}
			
			super.saveOrUpdate(saveu);
			
			//单位管理员
			List list = super.getObjectListByHql("from SysOrganizeInfoAdmin where organizeBm=?",new Object[]{saveu.getOrganizeBm()});
			if(list.size()>0)
				super.deleteAll(list);
			
			if(CommonUtil.isNotEmpty(saveu.getAdminlb())){
				String codes[] = saveu.getAdminlb().split(",");
				for(int i=0;i<codes.length;i++){
					if(CommonUtil.isEmpty(codes[i]))
						continue;
					
					SysOrganizeInfoAdmin gx = new SysOrganizeInfoAdmin();
					gx.setLoginName(codes[i]);
					gx.setOrganizeBm(saveu.getOrganizeBm());
					super.create(gx);
				}
			}
		}catch(Exception e){
			throw new ServiceException(e);
		}
		
		SimpleJson s = new SimpleJson();
		s.setSuccess(true);
		s.setMessage("组织机构保存成功！");
		
		u.setOrgid(saveu.getOrgid());
		u.setDwgz(null);
		u.setJzy(null);
		
		s.setResult(ExtUtils.getJsonData(u));
		
		return s;
		*/
		return null;
	}
	
	public void saveJzZzjg(Map<String, Object> map) {
		/*
		SysUserInfo loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		if(!BaseContext.getBaseUser().checkFuncsAll("JGRYGL"))
			throw new ActionException("错误，你无权执行该操作！");
		
		String loginName = (String)map.get("loginName");
		String jzOrganizeInfoBm = (String)map.get("jzOrganizeInfoBm");
		
		if(CommonUtil.isEmpty(loginName))
			throw new ServiceException("错误，必须指定用户！");

		List l = super.getObjectListByHql("select b from SysOrganizeInfo a,SysOrganizeInfoUser b where b.loginName='" 
				+ loginName + "' and b.organizeBm=a.organizeBm and b.gxlx='0'");
		if(CommonUtil.isEmpty(jzOrganizeInfoBm)){
			super.deleteAll(l);
			return;
		}
		
		Set<String> set = new HashSet<String>();
		String[] id = jzOrganizeInfoBm.split(",");
		for(int i=0;i<id.length;i++)
			if(CommonUtil.isNotEmpty(id[i]))
				set.add(id[i]);
		
		
		//删除原来有，但是现在没有的
		for(Object o:l){
			SysOrganizeInfoUser jz = (SysOrganizeInfoUser)o;
			if(!set.contains(jz.getOrganizeBm())){
				super.delete(jz);
			}else{
				set.remove(jz.getOrganizeBm());
			}
		}
		
		//保存新的
		for(String bm:set){
			SysOrganizeInfoUser jz = new SysOrganizeInfoUser();
			jz.setCjsj(new Date());
			jz.setLoginName(loginName);
			jz.setOrganizeBm(bm);
			jz.setGxlx("0");
			jz.setZxbz("0");
			jz.setNewUserId(loginu.getLoginName());
			
			super.create(jz);
		}
		*/
	}

	public XtYhxxb saveZzjy(Map parm, HttpServletRequest req) {
		//3413000001000000495
		//"yhid","uid","yhdlm","jyh","dwdm","yhxm","yhxb","yhzw","dlkl","yhmj","czmj","yhzt","gmsfhm","dwmc"
		String yhid = req.getParameter("yhid");
		String yhdlm = req.getParameter("yhdlm");
		String jyh = req.getParameter("jyh");
		String dwdm = req.getParameter("dwdm");
		String yhxb = req.getParameter("yhxb");
		String yhzw = req.getParameter("yhzw");
		String dlkl = req.getParameter("dlkl");
		String yhmj = req.getParameter("yhmj");
		String yhzt = req.getParameter("yhzt");
		String yhxm = req.getParameter("yhxm");
		String lxdh = req.getParameter("lxdh");
		
		if(CommonUtil.isEmpty(yhzt))
			yhzt = "0";
		
		String gmsfhm = req.getParameter("gmsfhm");
		String editpwd = req.getParameter("editpwd");
		
		String czmj = "";
		//czmj4
		for(int i=1;i<=4;i++){
			String key = "czmj" + i;
			if(CommonUtil.isEmpty(req.getParameter(key))){
				czmj += "0";
			}else{
				czmj += "1";
			}
		}
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		XtYhxxb yh = null;
		
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			//先到地市保存
			boolean isnew = true;
			if(CommonUtil.isEmpty(yhid)){
				String hql = "select count(a.yhid) from XtYhxxb a where yhdlm=?";
				Object obj = HibernateUtil.getObject(session, hql, new Object[]{yhdlm});
				if(obj!=null && Integer.parseInt(obj.toString())>0)
					throw new ServiceException("登录名重复，请确认！");

				hql = "select count(a.yhid) from XtYhxxb a where gmsfhm=?";
				obj = HibernateUtil.getObject(session, hql, new Object[]{gmsfhm});
				if(obj!=null && Integer.parseInt(obj.toString())>0)
					throw new ServiceException("身份证号码重复，请确认！");
				
				yh = new XtYhxxb();
				
				//新增，需要创建一个ID
				long seq = HibernateUtil.getMaxSeq(session, "XtYhxxb", "yhid", dwdm);
				yh.setYhid(String.valueOf(seq));
				yh.setDlkl(dlkl);
				yh.setYhdlm(yhdlm);
				yh.setYhzt(yhzt);
				yh.setDqbm(dwdm.substring(0,4));
				yh.setLxdh(lxdh);
			}else{
				isnew = false;
				
				String hql = "select count(a.yhid) from XtYhxxb a where yhdlm=? and yhid<>?";
				Object obj = HibernateUtil.getObject(session, hql, new Object[]{yhdlm,yhid});
				if(obj!=null && Integer.parseInt(obj.toString())>0)
					throw new ServiceException("登录名重复，请确认！");

				hql = "select count(a.yhid) from XtYhxxb a where gmsfhm=? and yhid<>?";
				obj = HibernateUtil.getObject(session, hql, new Object[]{gmsfhm,yhid});
				if(obj!=null && Integer.parseInt(obj.toString())>0)
					throw new ServiceException("身份证号码重复，请确认！");
				
				yh = HibernateUtil.get(session, XtYhxxb.class, yhid);
				if(CommonUtil.isNotEmpty(editpwd))
					yh.setDlkl(dlkl);
			}
		
			yh.setLxdh(lxdh);
			yh.setYhxm(yhxm);
			yh.setCzmj(czmj);
			yh.setDwdm(dwdm);
			yh.setGmsfhm(gmsfhm);
			yh.setJyh(jyh);
			yh.setYhmj(yhmj);
			yh.setYhxb(yhxb);
			yh.setYhzw(yhzw);
			yh.setYhzt("0");
			
			String dbm = yh.getDwdm().substring(0,4);
			if(ZzjyManagerServiceImpl.dwMap.containsKey(dbm)){
				String mc = ZzjyManagerServiceImpl.dwMap.get(yh.getDwdm().substring(0, 4)).get(yh.getDwmc());
				yh.setDwmc(mc);
			}
			
			if(isnew){
				HibernateUtil.create(session, yh);
			}else{
				HibernateUtil.update(session, yh);
			}
			
			//省厅查询考核指标
			String hql = "from XtYhksjg a where sfzh='" + yh.getGmsfhm() + "' and flag='1'";
			Object obj = super.getObject(hql, null);
			if(obj!=null){
				if(isnew){
					throw new ServiceException("对不起，该民警户籍民警考试未达标，不能添加此用户！");
				}else{
					yh.setYhzt("2");
					yh.setKhmsg(SystemConfig.getSystemConfig("kherrorMsg", "该民警户籍民警考试未达标，用户已经锁定！"));
					HibernateUtil.update(session, yh);
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		
		//地市已经保存，只需要到省厅保存下就好了
		super.saveOrUpdate(yh);
		
		return yh;
	}

	public Page querySearchZzjg(Map<String, Object> map, int pageIndex, int pageSize) {
		String key = (String)map.get("key");
		
		SqlParse sqlParse = new SqlParse(Config.getSql("queryZzjg"));
		sqlParse.bind(map);
		SqlParam sqlParam = sqlParse.parse();
		List list = super.getObjectListByHql(sqlParam.getSql(), sqlParam.getParams().toArray());
		Page p = new Page();
		p.setList(list);
		p.setTotalCount(list.size());
		
		return p;
	}

	public Page queryZzjg(Map<String, Object> map, int pageIndex, int pageSize) {
		SqlParse sqlParse = new SqlParse(Config.getSql("queryZzjg"));
		sqlParse.bind(map);
		SqlParam sqlParam = sqlParse.parse();
		
		Page p = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize); 
		
		return p;
	}

	public void moveZzjy(String usid, String oldorg, String neworg) {
		/*
		SysUserInfo loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		SysUserInfo u = super.get(SysUserInfo.class, usid);

		String moveUserCheck = SystemConfig.getSystemConfig("moveUserCheck");
		if(moveUserCheck==null) moveUserCheck = "false";
		
		Connection xtba_conn = null;
		Statement  xtba_stmt = null;
		ResultSet  xtba_res	 = null;
		
		try{
			if("true".equalsIgnoreCase(moveUserCheck)){
				//需要判断
				String loginuser = u.getLoginName();
				Class.forName(SystemConfig.getJdbcConfig("xtba.jdbc.driver"));
				
				xtba_conn = DriverManager.getConnection(
						SystemConfig.getJdbcConfig("xtba.jdbc.url"),
						SystemConfig.getJdbcConfig("xtba.jdbc.username"),
						SystemConfig.getJdbcConfig("xtba.jdbc.password"));
				xtba_stmt = xtba_conn.createStatement();
				//xtba_res = xtba_stmt.executeQuery("select count(*) from XTBA_ZRE WHERE zrr='" + loginuser + "' or cjr='" + loginuser + "'");
				xtba_res = xtba_stmt.executeQuery("select count(*) from XTBA_ZRE WHERE zrr='" + loginuser + "'");
				xtba_res.next();
				int i = xtba_res.getInt(1);
				if(i>0)
					throw new java.lang.RuntimeException("错误，该用户还具有" +  i + "个相关的代办事项！");
			}
		}catch(Exception e){
			throw new ServiceException(e);
		}finally{
			try{if(xtba_res!=null) 	xtba_res.close();}catch(Exception e){;}
			try{if(xtba_stmt!=null) xtba_stmt.close();}catch(Exception e){;}
			try{if(xtba_conn!=null) xtba_conn.close();}catch(Exception e){;}
		}
		
		//修改警员的单位和单位名称
		u.setOrganizeBm(neworg);
		u.setOrganizePath(DictData.getOrganizePath(u.getOrganizeBm()));
		
		//修改警员-单位关系（主单位）
		SysOrganizeInfoUser gx 
			= (SysOrganizeInfoUser)super.getObject(
					"from SysOrganizeInfoUser where loginName=? and gxlx='1'", new Object[]{u.getLoginName()});
		gx.setOrganizeBm(u.getOrganizeBm());
		gx.setEditUserId(loginu.getUsid());
		gx.setXgsj(new Date());
		
		super.update(u);
		super.update(gx);
		*/
	}

	
	public long getMaxSeq(String pojoname,String pname,String dwdm){
		String dqbm = dwdm.substring(0,4);
		
		String hql = null;
		
		hql = "select max(a." + pname + ") from " + pojoname + " a where dqbm=?";
		
		String tmpid = (String)super.getObject(hql, new Object[]{dqbm});
		if(tmpid==null){
			tmpid = dqbm + "900000000000000";
		}else{
			tmpid =String.valueOf(Long.parseLong(tmpid));
		}
		long yhjsid = Long.parseLong(tmpid);
		
		if(String.valueOf(yhjsid+10000).length()>19)
			throw new ServiceException(pojoname + "的" + pname + "在地区" + dwdm + "超出范围！");
		
		return yhjsid+1;
	}

	public List createIPXZ(Map parm) {
		XtYh loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		String yhid = (String)parm.get("yhid");
		String ipdzstart = (String)parm.get("startip");
		String ipdzend = (String)parm.get("endip");
		String ipdz = (String)parm.get("ipdz");
		String dwdm = (String)parm.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			XtYhxxb u = HibernateUtil.get(session, XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			long seq = HibernateUtil.getMaxSeq(session, "XtYhipyxxxb","ipyxid", u.getDwdm());
			
			if(CommonUtil.isNotEmpty(ipdz)){
				String[] dz = ipdz.split("\\.");
				if(dz.length!=4){
					throw new ServiceException("非法的IP地址");
				}
				
				String hql = "from XtYhipyxxxb a where yhid=? and ipdz=?";
				XtYhipyxxxb old = (XtYhipyxxxb)HibernateUtil.getObject(session, hql, new Object[]{yhid,ipdz});
				if(old!=null)
					throw new ServiceException("IP地址" +ipdz + "重复！");
				
				XtYhipyxxxb ip = new XtYhipyxxxb();
				ip.setCjrid(loginu.getYhid());
				ip.setCjsj(DateHelper.formateDate("yyyyMMddHHmmss"));
				ip.setDqbm(u.getDqbm());
				ip.setIpdz(ipdz);
				ip.setIpyxid(String.valueOf(seq));
				ip.setYhid(yhid);
				
				//保存到省厅
				super.create(ip);
				
				//保存到地市
				HibernateUtil.create(session, ip);
			}else{
				if(ipdzstart==null || ipdzend==null)
					throw new ServiceException("IP地址参数错误！");
				
				String s[] = ipdzstart.split("\\.");
				String e[] = ipdzend.split("\\.");
				if(s.length!=4 || e.length!=4)
					throw new ServiceException("IP地址非法！");
				
				if(!s[0].equals(e[0]) || !s[1].equals(e[1]) || !s[2].equals(e[2]))
					throw new ServiceException("仅支持最后位置IP范围段");
				
				int start = CommonUtil.getInteger(s[3]);
				int end = CommonUtil.getInteger(e[3]);
				if(end<start)
					throw new ServiceException("结束IP地址必须大于等于开始IP地址！");
				
				if(start<1 || end>254)
					throw new ServiceException("IP地址段必须位于1到255之间！");
				
				for(int ipx=start;ipx<=end;ipx++){
					XtYhipyxxxb ip = new XtYhipyxxxb();
					
					ipdz = s[0] + "." + s[1] + "." + s[2] + "." + ipx;
					
					String hql = "from XtYhipyxxxb a where yhid=? and ipdz=?";
					XtYhipyxxxb old = (XtYhipyxxxb)HibernateUtil.getObject(session, hql, new Object[]{yhid,ipdz});
					if(old!=null)
							throw new ServiceException("IP地址" +ipdz + "重复！");
					
					ip.setCjrid(loginu.getYhid());
					ip.setCjsj(DateHelper.formateDate("yyyyMMddHHmmss"));
					ip.setDqbm(u.getDqbm());
					ip.setIpdz(ipdz);
					ip.setIpyxid(String.valueOf(seq));
					ip.setYhid(yhid);
					super.create(ip);
					HibernateUtil.create(session, ip);
					
					seq++;
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		
		return null;
	}


	public void deleteIPXZ(Map parm) {
		String ids = (String)parm.get("ids");
		String dwdm = (String)parm.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			String[] id = ids.split(",");
			for(int i=0;i<id.length;i++){
				XtYhipyxxxb yh =super.get(XtYhipyxxxb.class, id[i]);
				if(yh!=null){
					super.delete(yh);
					
					HibernateUtil.delete(session, yh);
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}

	public Page getIPXZ(Map parm,int pageIndex,int pageSize) {
		String dwdm = (String)parm.get("dwdm");
		if(CommonUtil.isEmpty(dwdm))
			throw new ServiceException("地区参数不能为空！");
		
		String yhid = (String)parm.get("yhid");
		if(CommonUtil.isEmpty(yhid))
			throw new ServiceException("未知用户！");
		
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();
			tran = session.beginTransaction();
			
			XtYhxxb u = (XtYhxxb)session.get(XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			String hql = "from XtYhipyxxxb a where yhid='" + yhid + "' order by ipdz";
			
			Page p = HibernateUtil.getPageRecords(session, hql, null, pageIndex, pageSize);
			
			for(Object obj:p.getList()){
				XtYhipyxxxb yh = (XtYhipyxxxb)obj;
				yh.setYhdlm(u.getYhdlm());
				yh.setYhxm(u.getYhxm());
				XtYhxxb c = (XtYhxxb)session.get(XtYhxxb.class, yh.getCjrid());
				if(c!=null)
					yh.setCjrxm(c.getYhxm());
				else
					yh.setCjrxm(yh.getCjrid());
			}
			tran.commit();
			
			return p;
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public List createSJFW(Map parm){
		String sjfw = (String)parm.get("sjfw");
		String xqlx = (String)parm.get("xqlx");
	
		if(CommonUtil.isEmpty(sjfw))
			throw new ServiceException("未知数据范围！");
		
		if(CommonUtil.isEmpty(xqlx))
			throw new ServiceException("未知辖区类型！");
		
		String yhid = (String)parm.get("yhid");
		if(CommonUtil.isEmpty(yhid))
			throw new ServiceException("未知用户！");
		
		String dwdm = (String)parm.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			XtYhxxb u = HibernateUtil.get(session, XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			if(sjfw.length()>9){
				sjfw = sjfw.substring(0, 6) + "|" + sjfw.substring(0, 9) + "|" + sjfw + "|";
			}else if(sjfw.length()==9){
				sjfw = sjfw.substring(0,6) + "|" + sjfw + "||";
			}else{
				sjfw = sjfw + "|||";
			}
			
			long seq = HibernateUtil.getMaxSeq(session, "XtYhsjfwb","sjfwid", u.getDwdm());
			
			XtYhsjfwb fw = new XtYhsjfwb();
			fw.setDqbm(u.getDqbm());
			fw.setSjfw(sjfw);
			fw.setXqlx(xqlx);
			fw.setYhid(yhid);
			fw.setSjfwid(String.valueOf(seq));
			
			super.create(fw);
			HibernateUtil.create(session, fw);
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		return null;
	}
	
	public void deleteSJFW(Map parm){
		String ids = (String)parm.get("ids");
		String dwdm = (String)parm.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			String[] id = ids.split(",");
			for(int i=0;i<id.length;i++){
				XtYhsjfwb yh =super.get(XtYhsjfwb.class, id[i]);
				if(yh!=null){
					super.delete(yh);
					HibernateUtil.delete(session, yh);
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public Page getSJFW(Map parm,int pageIndex,int pageSize){
		String dwdm = (String)parm.get("dwdm");
		if(CommonUtil.isEmpty(dwdm))
			throw new ServiceException("地区参数不能为空！");
		
		String yhid = (String)parm.get("yhid");
		if(CommonUtil.isEmpty(yhid))
			throw new ServiceException("未知用户！");
		
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();
			tran = session.beginTransaction();
			
			XtYhxxb u = (XtYhxxb)session.get(XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			String hql = "from XtYhsjfwb a where yhid='" + yhid + "' order by sjfw";
			
			Page p = HibernateUtil.getPageRecords(session, hql, null, pageIndex, pageSize);
			
			for(Object obj:p.getList()){
				XtYhsjfwb yh = (XtYhsjfwb)obj;
				yh.setYhdlm(u.getYhdlm());
				yh.setYhxm(u.getYhxm());
			}

			return p;
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public List createDTQX(Map parm){
		String yhid = (String)parm.get("yhid");
		if(CommonUtil.isEmpty(yhid))
			throw new ServiceException("未知用户！");
		
		String dwdm = (String)parm.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			XtYhxxb u = HibernateUtil.get(session, XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			String str = (String)parm.get("ids");
			if(CommonUtil.isEmpty(str))
				throw new ServiceException("必须提供等同权限用户！");
			
			String ids[] = str.split(",");
			long seq = HibernateUtil.getMaxSeq(session, "XtYhdtqxb","dtqxid", u.getDwdm());
			for(String id:ids){
				XtYhdtqxb qx = (XtYhdtqxb)HibernateUtil.getObject(session, "from XtYhdtqxb where yhid=? and dtyhid=?", new Object[]{yhid,id});
				if(qx==null){
					qx = new XtYhdtqxb();
					qx.setDqbm(u.getDqbm());
					qx.setDtqxid(String.valueOf(seq));
					qx.setYhid(yhid);
					qx.setDtyhid(id);
					super.create(qx);
					HibernateUtil.create(session, qx);
					
					seq++;
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		
		return null;
	}
	public void deleteDTQX(Map parm){
		String ids = (String)parm.get("ids");
		String dwdm = (String)parm.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			String[] id = ids.split(",");
			for(int i=0;i<id.length;i++){
				XtYhdtqxb yh =super.get(XtYhdtqxb.class, id[i]);
				if(yh!=null){
					super.delete(yh);
					HibernateUtil.delete(session, yh);
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	public Page getDTQX(Map parm,int pageIndex,int pageSize){
		String dwdm = (String)parm.get("dwdm");
		if(CommonUtil.isEmpty(dwdm))
			throw new ServiceException("地区参数不能为空！");
		
		String yhid = (String)parm.get("yhid");
		if(CommonUtil.isEmpty(yhid))
			throw new ServiceException("未知用户！");
		
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();

			XtYhxxb u = (XtYhxxb)session.get(XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			String hql = "from XtYhdtqxb a where yhid='" + yhid + "'";
			
			Page p = HibernateUtil.getPageRecords(session, hql, null, pageIndex, pageSize);
			for(Object obj:p.getList()){
				XtYhdtqxb yh = (XtYhdtqxb)obj;
				yh.setYhdlm(u.getYhdlm());
				yh.setYhxm(u.getYhxm());
				
				XtYhxxb dtyh = (XtYhxxb)HibernateUtil.get(session, XtYhxxb.class, yh.getDtyhid());
				if(dtyh!=null){
					yh.setDtyhdlm(dtyh.getYhdlm());
					yh.setDtyhxm(dtyh.getYhxm());
				}
			}

			return p;
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	/**
	 * 动作权限
	 * @param parm
	 * @return
	 */
	public List createDZQX(Map parm){
		String yhid = (String)parm.get("yhid");
		if(CommonUtil.isEmpty(yhid))
			throw new ServiceException("未知用户！");
		
		String dwdm = (String)parm.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			XtYhxxb u = HibernateUtil.get(session, XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			String str = (String)parm.get("ids");
			if(CommonUtil.isEmpty(str))
				throw new ServiceException("必须提供等同权限用户！");
			
			String ids[] = str.split(",");
			long seq = getMaxSeq("XtYhdzqxb","dzqxid", u.getDwdm());
			for(String id:ids){
				XtYhdzqxb qx = (XtYhdzqxb)HibernateUtil.getObject(session, "from XtYhdzqxb where yhid=? and dzid=?", new Object[]{yhid,id});
				if(qx==null){
					qx = new XtYhdzqxb();
					qx.setDqbm(u.getDqbm());
					qx.setDzqxid(String.valueOf(seq));
					qx.setYhid(yhid);
					qx.setDzid(id);
					
					super.create(qx);
					HibernateUtil.create(session, qx);
					
					seq++;
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		return null;
	}
	
	public void deleteDZQX(Map parm){
		String ids = (String)parm.get("ids");
		String dwdm = (String)parm.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()<4){
			throw new ServiceException("未知单位，请确认！");
		}
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			String[] id = ids.split(",");
			for(int i=0;i<id.length;i++){
				XtYhdzqxb yh =super.get(XtYhdzqxb.class, id[i]);
				if(yh!=null){
					super.delete(yh);
					HibernateUtil.delete(session, yh);
				}
			}
			
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			
			if(e instanceof ServiceException)
				throw (ServiceException)e;
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public Page getDZQX(Map parm,int pageIndex,int pageSize){
		String dwdm = (String)parm.get("dwdm");
		if(CommonUtil.isEmpty(dwdm))
			throw new ServiceException("地区参数不能为空！");
		
		String yhid = (String)parm.get("yhid");
		if(CommonUtil.isEmpty(yhid))
			throw new ServiceException("未知用户！");
		
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();
			tran = session.beginTransaction();
			
			XtYhxxb u = (XtYhxxb)session.get(XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			String hql = "select a,b from XtYhdzqxb a,XtSpdzb b where a.yhid='" + yhid + "' and a.dzid=b.dzid";
			
			Page p = HibernateUtil.getPageRecords(session, hql, null, pageIndex, pageSize);
			List list = new ArrayList();
			for(Object obj:p.getList()){
				Object[] objs = (Object[])obj;
				
				XtYhdzqxb yh = (XtYhdzqxb)objs[0];
				XtSpdzb dz = (XtSpdzb)objs[1];
				
				yh.setYhdlm(u.getYhdlm());
				yh.setYhxm(u.getYhxm());
				yh.setDzmc(dz.getDzmc());
				yh.setDzms(dz.getMs());
				list.add(yh);
			}
			p.setList(list);
			
			tran.commit();
			
			return p;
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}

	public List<TreeNode> getDDTree(HttpServletRequest req) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		Map<String,String> params = CommonUtil.getParameterMap(req.getParameter("dict"));
		String yhid = params.get("yhid");
		String dwdm = params.get("dwdm");
		
		if(CommonUtil.isEmpty(yhid))
			throw new ServiceException("未知用户！");
		
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();
			
			XtYhxxb u = HibernateUtil.get(session, XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("用户不存在！");
			
			List list2 = HibernateUtil.getObjectList(session, "from XtYhdzqxb where yhid='" + yhid + "'",null);
			Set<String> set = new HashSet<String>();
			for(Object obj:list2){
				XtYhdzqxb fpdz = (XtYhdzqxb)obj;
				set.add(fpdz.getDzid());
			}
			
			String sql = "from XtSpdzb where qybz='1' and dqbm='" + u.getDqbm() + "'";
			List l = HibernateUtil.getObjectList(session, sql, null);
			for(Object obj:l){
				XtSpdzb dz = (XtSpdzb)obj;
	
				Code code = new Code();
				code.setCode(dz.getDzid());
				code.setName(dz.getDzmc());
				
				TreeNode node = new TreeNode();
				node.setCode(code);
				node.setChecked(new Boolean(set.contains(dz.getDzid())));
				node.setText(dz.getDzmc());
				node.setLeaf(true);
				
				list.add(node);
			}
			if(list.size()==0)
				throw new ServiceException("地区无动作权限配置！");
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		
		return list;
	}

	public List<TreeNode> queryDwxxRyTree(HttpServletRequest req) {
		List<TreeNode> nodelist = new ArrayList<TreeNode>();
		Map<String,String> params = CommonUtil.getParameterMap(req.getParameter("dict"));
		String VisionType = params.get("VisionType");	//RY/DW
		if(VisionType==null)
			VisionType = "RY";
		
		//单位机构代码
		String postDetail = params.get("postDetail");
		if(CommonUtil.isEmpty(postDetail))
			return nodelist;
		
		boolean isroot = false;
		if(postDetail.length()==4){
			isroot = true;
			postDetail =  postDetail + "00000";
		}
		
		String hql = "from XtDwxxb where ";
			
		//计算层次码
		String ccm = postDetail;
		//市局：前4位编码 + 00000000
		if(postDetail.endsWith("00000"))
			hql += " dm like '" + postDetail.substring(0,4) + "%000' and dm<>'" + postDetail.substring(0,4) + "00000'";
		else if(ccm.endsWith("000")){
			//县/区分局：4位市局编码 + 2位置分局编码 + 000
			hql += " dm like '" + postDetail.substring(0,6) + "%' and dm<>'" + postDetail.substring(0,6) + "000'";
		}else{
			hql += " 0=1 ";
		}
		hql += " order by dm asc";
		
		TreeNode rootnode = null;
		
		//地区编码
		String dqbm = postDetail.substring(0,4);
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			if(isroot){
				//查找根单位
				String hql2 = "from XtDwxxb where  dm='" + postDetail + "'";
				XtDwxxb rootdw = (XtDwxxb)HibernateUtil.getObject(session, hql2, null);
				
				rootnode = new TreeNode();
				rootnode.setText(rootdw.getMc());
				rootnode.setLeaf(false);
				rootnode.setDw(rootdw);
				rootnode.setExpanded(true);
				rootnode.setChildren(new ArrayList<TreeNode>());
				rootnode.setChecked(VisionType.equals("RY")?null:false);
				
				nodelist.add(rootnode);
			}
			
			List<?> list = session.createQuery(hql).list();
				
			for(Object o:list){
				XtDwxxb dw = (XtDwxxb)o;
				TreeNode node = new TreeNode();
				node.setText(dw.getMc());
				if(VisionType.equals("RY")){
					node.setLeaf(false);
				}else{
					if(dw.getDm().endsWith("000"))
						node.setLeaf(false);
					else
						node.setLeaf(true);
				}
				node.setDw(dw);
				node.setChecked(VisionType.equals("RY")?null:false);
				
				if(rootnode==null){
					nodelist.add(node);
				}else{
					rootnode.getChildren().add(node);
				}
			}
			
			//添加人员
			if(VisionType.equals("RY")){
				String hql2 = "from XtYhxxb a where a.dwdm='" + postDetail + "' and a.yhzt='0'";
				List<?> list2 = session.createQuery(hql2).list();
				for(Object o:list2){
					XtYhxxb yh = (XtYhxxb)o;
					
					String str = yh.getYhdlm();
					if(yh.getYhxm()!=null){
						//str += "(" + yh.getYhxm() + ")";
						str = yh.getYhxm();
					}
					
					TreeNode node = new TreeNode();
					node.setText(str);
					node.setLeaf(true);
					node.setZzjy(yh);
					node.setChecked(false);
					
					if(rootnode!=null)
						rootnode.getChildren().add(node);
					else
						nodelist.add(node);
				}
			}
		}catch(Exception e){
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		
		return nodelist;
	}

	public List<TreeNode> queryDwxxTree(HttpServletRequest req) {
		XtYh loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		List<TreeNode> nodelist = new ArrayList<TreeNode>();
		Map<String,String> params = CommonUtil.getParameterMap(req.getParameter("dict"));
		
		//单位机构代码
		String postDetail = params.get("postDetail");
		if(CommonUtil.isEmpty(postDetail)){
			if(loginu.getSsdwjgdm().startsWith("3400")){
				//省厅，看到所有节点
				TreeNode root = new TreeNode();
				root.setText("省厅");
				root.setLeaf(false);
				root.setChildren(new ArrayList<TreeNode>() );
				root.setExpanded(true);
				nodelist.add(root);
				
				XtDwxxb rootdw = new XtDwxxb();
				rootdw.setDm("340000000000");
				rootdw.setDwjgdm(rootdw.getDm());
				root.setDw(rootdw);
				
				String hql = "from XtDwxxb where dwjgdm like '%00000000' order by dwjgdm asc";
				List<?> list = super.getObjectListByHql(hql);
				for(Object o:list){
					XtDwxxb dw = (XtDwxxb)o;
					TreeNode node = new TreeNode();
					node.setText(dw.getBz());
					node.setLeaf(false);
					node.setDw(dw);
					
					root.getChildren().add(node);
				}
			}else{
				//地市，只能看到自己地市节点
				String hql = "from XtDwxxb where dwjgdm = '" + loginu.getSsdwjgdm().substring(0,4) + "00000000' order by dwjgdm asc";
				List<?> list = super.getObjectListByHql(hql);
				for(Object o:list){
					XtDwxxb dw = (XtDwxxb)o;
					TreeNode node = new TreeNode();
					node.setText(dw.getBz());
					node.setLeaf(false);
					node.setDw(dw);
					
					nodelist.add(node);
				}
			}
		}else{
			String hql = "from XtDwxxb where ";
			
			//计算层次码
			boolean isleaf = false;
			String ccm = postDetail;
			//市局：前4位编码 + 00000000
			if(postDetail.endsWith("00000000"))
				hql += " dwjgdm like '" + postDetail.substring(0,4) + "%000000' and dwjgdm<>'" + postDetail.substring(0,4) + "00000000'";
			else if(ccm.endsWith("000000")){
				isleaf = true;
				//县/区分局：4位市局编码 + 2位置分局编码 + 000000
				hql += " dwjgdm like '" + postDetail.substring(0,6) + "%' and dwjgdm<>'" + postDetail.substring(0,6) + "000000'";
			}
			
			hql += " order by dwjgdm asc";
			
			//地区编码
			String dqbm = postDetail.substring(0,4);
			Session session = null;
			try{
				session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
				List<?> list = session.createQuery(hql).list();
				
				for(Object o:list){
					XtDwxxb dw = (XtDwxxb)o;
					TreeNode node = new TreeNode();
					node.setText(dw.getMc());
					node.setLeaf(isleaf);
					node.setDw(dw);
					
					nodelist.add(node);
				}
			}catch(Exception e){
				throw new ServiceException(e);
			}finally{
				if(session!=null)
					session.close();
			}
		}
		
		return nodelist;
	}

	public XtYhksjg getXtYhksjg(HttpServletRequest req){
		SqlParse sqlParse = new SqlParse(Config.getSql("queryKhjg"));
		sqlParse.bind(ExtUtils.getRequestParames(req));
		SqlParam sqlParam = sqlParse.parse();
		
		Object obj = super.getObject(sqlParam.getSql(), sqlParam.getParams().toArray());
		if(obj!=null)
			return (XtYhksjg)obj;
		else
			return null;
	}
	
	public void SynchronizedKHZB(){
		String hql = "from XtYhksjg order by dwdm asc";
		List<?> list = super.getObjectListByHql(hql);
		
		Session session = null;
		Transaction tran = null;
		String olddqbm = null, dqbm = null;
		String errmsg = SystemConfig.getSystemConfig("kherrorMsg", "该民警户籍民警考试未达标，用户已经锁定！");
		
		hql = "from XtYhxxb where gmsfhm=?";
		for(Object obj:list){
			XtYhksjg jg = (XtYhksjg)obj;
			
			//单位不符合要求，或者身份证号码为空，那么忽略
			if(CommonUtil.isEmpty(jg.getDwdm()) || jg.getDwdm().length()<4 ||  CommonUtil.isEmpty(jg.getSfzh()))
				continue;
			
			dqbm = jg.getDwdm().substring(0,4);
			
			//如果地区改变，那么提交事务，并重新获取session
			if(olddqbm==null || !olddqbm.equals(dqbm)){
				olddqbm = dqbm;
				
				if(session!=null){
					try{
						tran.commit();
					}catch(Exception e){
						tran.rollback();
					}finally{
						if(session!=null)
							try{session.close();}catch(Exception ex){;}
						
						session = null;
						tran = null;
					}
				}
			}
			
			try{
				if(session==null) {
					session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
					tran = session.beginTransaction();
				}
				
				//同步地市数据库
				XtYhxxb yh = (XtYhxxb)HibernateUtil.getObject(session, hql, new Object[]{jg.getSfzh()});
				if(yh==null)
					continue;
				
				if(jg.getFlag().equals("1")){
					//考核没达标，如果上次是达标，那么设置不达标，否则忽略
					if(CommonUtil.isNotEmpty(yh.getKhmsg())){
						continue;
					}else{
						yh.setKhgxsj(new Date());
						yh.setKhmsg(errmsg);
						HibernateUtil.update(session, yh);
					}
				}else{
					//考核达标，如果上次达标，那么忽略。否则复位
					if(CommonUtil.isEmpty(yh.getKhmsg())){
						continue;
					}else{
						yh.setKhgxsj(null);
						yh.setKhmsg(null);
						HibernateUtil.update(session, yh);
					}
				}
			}catch(Exception exx){
				exx.printStackTrace();
			}finally{
				
			}
		}
		
		if(session!=null){
			try{
				tran.commit();
			}catch(Exception e){
				tran.rollback();
			}finally{
				if(session!=null)
					try{session.close();}catch(Exception ex){;}
				
				session = null;
				tran = null;
			}
		}
	}
	
	public Page queryKhjg(Map parm,int pageIndex,int pageSize){
		String dwdm = (String)parm.get("dwdm");
		if(CommonUtil.isEmpty(dwdm))
			throw new ServiceException("必须提供单位参数！");
		
		//dwdm=341600000
		if(dwdm.endsWith("00000"))
			dwdm = dwdm.substring(0,4);
		else if(dwdm.endsWith("000"))
			dwdm = dwdm.substring(0,6);
		
		parm.put("dwdm", dwdm);
		
		SqlParse sqlParse = new SqlParse(Config.getSql("queryKhjg"));
		sqlParse.bind(parm);
		SqlParam sqlParam = sqlParse.parse();
		
		return super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
	}
}
