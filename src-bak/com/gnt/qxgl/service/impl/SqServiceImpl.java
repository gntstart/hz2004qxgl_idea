package com.gnt.qxgl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.bean.QuerySysUserRole;
import com.gnt.qxgl.bean.SysProjectInfo;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.TemplateUtil;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.common.dict.bean.Code;
import com.gnt.qxgl.common.dict.bean.TreeNode;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.XtJscdqxb;
import com.gnt.qxgl.hz2004.entity.XtJsgnqxb;
import com.gnt.qxgl.hz2004.entity.XtJsxxb;
import com.gnt.qxgl.hz2004.entity.XtJsywbbqxb;
import com.gnt.qxgl.hz2004.entity.XtJwhxxb;
import com.gnt.qxgl.hz2004.entity.XtSpdzb;
import com.gnt.qxgl.hz2004.entity.XtXtgnb;
import com.gnt.qxgl.hz2004.entity.XtXtgncdb;
import com.gnt.qxgl.hz2004.entity.XtXzqhb;
import com.gnt.qxgl.hz2004.entity.XtYh;
import com.gnt.qxgl.hz2004.entity.XtYhdtqxb;
import com.gnt.qxgl.hz2004.entity.XtYhdzqxb;
import com.gnt.qxgl.hz2004.entity.XtYhjsxxb;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;
import com.gnt.qxgl.hz2004.entity.XtYwbbmbxxb;
import com.gnt.qxgl.service.SqService;
import com.gnt.qxgl.service.ZzjyManagerService;

public class SqServiceImpl extends ServiceImpl implements SqService{
	private ZzjyManagerService zzjyManagerService;
	
	public ZzjyManagerService getZzjyManagerService() {
		return zzjyManagerService;
	}

	public void setZzjyManagerService(ZzjyManagerService zzjyManagerService) {
		this.zzjyManagerService = zzjyManagerService;
	}

	public List<TreeNode> queryXZQHTreeNodes(Map<String,String> param){
		List<TreeNode> list = new ArrayList<TreeNode>();
		String xzqh = param.get("xzqh");
		String pcs = param.get("pcs");
		String dwdm = (String)param.get("dwdm");
		if(CommonUtil.isEmpty(dwdm))
			throw new ServiceException("地区参数不能为空！");

		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();
			
			if(CommonUtil.isNotEmpty(pcs)){
				String sql = "from XtJwhxxb where xzjddm='" + pcs + "' order by mc";
				List l = HibernateUtil.getObjectList(session, sql , null);
				for(Object obj:l){
					XtJwhxxb jwh = (XtJwhxxb)obj;
					TreeNode node = new TreeNode();
					node.setJwh(jwh);
					node.setChecked(new Boolean(false));
					node.setText(jwh.getDm() + " " + jwh.getMc());
					node.setLeaf(true);
					
					list.add(node);
				}
				return list;
			}
			
			if(CommonUtil.isEmpty(xzqh) && CommonUtil.isEmpty(pcs)){
				//为空，那么省级行政区划
				String sql = "from XtXzqhb where dm like '%0000' order by dm";
				List l = HibernateUtil.getObjectList(session, sql, null);
				for(Object obj:l){
					XtXzqhb qh = (XtXzqhb)obj;
					TreeNode node = new TreeNode();
					node.setXzqh(qh);
					node.setChecked(new Boolean(false));
					node.setText(qh.getDm() + " " + qh.getMc());
					node.setLeaf(false);
					
					list.add(node);
				}
				
				return list;
			}
			
			if(CommonUtil.isNotEmpty(xzqh)){
				if(xzqh.endsWith("0000") || xzqh.endsWith("00")){
					//2/3级行政区划
					String sql = null;
					if(xzqh.endsWith("0000")){
						sql = "from XtXzqhb where dm like '" + xzqh.substring(0,2) + "%00' and dm<>'" + xzqh + "' order by dm";
					}else{
						sql = "from XtXzqhb where dm like '" + xzqh.substring(0,4) + "%' and dm<>'" + xzqh + "' order by dm";
					}
					
					List l = HibernateUtil.getObjectList(session, sql, null);
					for(Object obj:l){
						XtXzqhb qh = (XtXzqhb)obj;
						TreeNode node = new TreeNode();
						node.setXzqh(qh);
						node.setChecked(new Boolean(false));
						node.setText(qh.getDm() + " " + qh.getMc());
						node.setLeaf(false);
						
						list.add(node);
					}
				}else{
					//最末一级行政区划，那么加载派出所
					String sql = "from XtDwxxb where qhdm='" + xzqh + "' and dwjb='0' order by dm";
					List l = HibernateUtil.getObjectList(session, sql, null);
					for(Object obj:l){
						XtDwxxb dw = (XtDwxxb)obj;
						TreeNode node = new TreeNode();
						node.setDw(dw);
						node.setChecked(new Boolean(false));
						node.setText(dw.getDm() + " " + dw.getMc());
						node.setLeaf(false);
						
						list.add(node);
					}
				}
			}
			return list;
		}catch(Exception e){
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public void saveProjectJs(Map<String, Object> param) {

	}

	public List queryProject() {
		return null;
	}

	public void deleteJs(Map<String, Object> param) {
		String ids = (String)param.get("ids");
		String[] id = ids.split(",");
		for(int i=0;i<id.length;i++){
			if(CommonUtil.isNotEmpty(id[i])){
				XtJsxxb r = super.get(XtJsxxb.class, id[i]);
				if(r!=null){
					String sql = "delete XtYhjsxxb where jsid=?";
					super.executeHql(sql, null, new Object[]{r.getJsid()});
					
					sql = "delete XtJscdqxb where jsid=?";
					super.executeHql(sql, null, new Object[]{r.getJsid()});
					
					sql = "delete XtJsgnqxb where jsid=?";
					super.executeHql(sql, null, new Object[]{r.getJsid()});
					
					sql = "delete XtJsywbbqxb where jsid=?";
					super.executeHql(sql, null, new Object[]{r.getJsid()});
					
					sql = "delete XtJszsbbqxb where jsid=?";
					super.executeHql(sql, null, new Object[]{r.getJsid()});
					
					super.delete(r);
				}
			}
		}
	}

	public XtJsxxb saveJs(Map<String, Object> param) {
		//{jsid=3407000001000000023, jsmc=市局审批dsadaf, ms=市局审批, pageSize=20, dqbm=3407, method=saveJs, pageIndex=1}
		String jsid = (String)param.get("jsid");
		String jsmc = (String)param.get("jsmc");
		String ms = (String)param.get("ms");
		String dqbm = (String)param.get("dqbm");
		
		XtJsxxb js = null;
	
		if(CommonUtil.isNotEmpty(jsid)){
			js = super.get(XtJsxxb.class, jsid);
			if(js==null)
				throw new ServiceException("此角色不存在！");
			
			js.setJsmc(jsmc);
			js.setMs(ms);
			super.update(js);
		}else{
			js = new XtJsxxb();
			js.setDqbm(dqbm.substring(0,4));
			js.setJsmc(jsmc);
			js.setMs(ms);
			
			long seq = zzjyManagerService.getMaxSeq("XtJsxxb", "jsid", dqbm);
			js.setJsid(String.valueOf(seq));
			super.create(js);
		}

		return js;
		/*
		//{jsid=A150D82FF9A749E5B261977899D23D5B, roleBm=12, pageSize=20, method=saveJs, roleName=法制科执法监督民警, xmbm=1200754, pageIndex=1}
		String jsid = (String)param.get("jsid");
		String roleBm = (String)param.get("roleBm");
		String xmbm = (String)param.get("xmbm");
		String roleName = (String)param.get("roleName");
		String oldRoleBm = null;
		
		String hsql = "select  count(jsid) from SysRoleInfo where xmbm=? and roleBm=?";
		if(CommonUtil.isNotEmpty(jsid)){
			hsql += " and jsid<>'" + jsid + "'";
		}
		Long l = (Long)super.getObject(hsql, new Object[]{xmbm,roleBm});
		if(l.intValue()>0){
			throw new ServiceException("保存失败，角色编码重复！");
		}
		
		SysUserInfo loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		SysRoleInfo r = new SysRoleInfo();
		if(CommonUtil.isNotEmpty(jsid)){
			r = super.get(SysRoleInfo.class, jsid);
			if(r==null)
				throw new ServiceException("保存失败，角色已经被删除！");
			
			oldRoleBm = r.getRoleBm();
		}else{
			r.setNewDate(new Date());
			r.setNewUserId(loginu.getUsid());
		}
		
		r.setRoleBm(roleBm);
		r.setRoleName(roleName);
		r.setXmbm(xmbm);
		r.setZxbz("0");
		
		super.saveOrUpdate(r);
		
		//如果角色编码有变化，哪么修改子表
		if(oldRoleBm!=null && !oldRoleBm.equals(roleBm)){
			String sql = "update SysFunctionInfoRole set roleBm=? where xmbm=? and roleBm=?";
			super.executeHql(sql, null, new Object[]{roleBm,xmbm,oldRoleBm});
			
			sql = "update SysUserRole set roleBm=? where xmbm=? and roleBm=?";
			super.executeHql(sql, null, new Object[]{roleBm,xmbm,oldRoleBm});
		}
		*/
	}

	public void saveJsFunc(Map<String, Object> param) {
		XtYh loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		String gncdid = (String)param.get("gncdid");	//XtJscdqxb
		String gnid = (String)param.get("gnid");		//XtJsgnqxb
		String ywbbid = (String)param.get("ywbbid");	//XtJsywbbqxb
		String jsid = (String)param.get("jsid");
		String dwdm = (String)param.get("dwdm");
		
		String dqbm = dwdm.substring(0,4);
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			tran = session.beginTransaction();
			
			XtJsxxb js = HibernateUtil.get(session, XtJsxxb.class, jsid);
			if(js==null)
				throw new ServiceException("角色不存在！");
			
			String optype =  (String)param.get("optype");	
			if(CommonUtil.isEmpty(gncdid) && CommonUtil.isEmpty(gnid) && CommonUtil.isEmpty(ywbbid))
				throw new ServiceException("未知功能！");
			
			String hsql  = null;
			Object[] params = null;
			
			long seg = 0;
			if(optype.equals("add")){
				if(CommonUtil.isNotEmpty(gncdid)){
					seg = HibernateUtil.getMaxSeq(session, "XtJscdqxb", "jscdid", js.getDqbm());
					XtJscdqxb gx = new XtJscdqxb();
					gx.setDqbm(js.getDqbm());
					gx.setGncdid(gncdid);
					gx.setJscdid(String.valueOf(seg));
					gx.setJsid(jsid);
					super.create(gx);
					HibernateUtil.create(session, gx);
				}else if(CommonUtil.isNotEmpty(gnid)){
					seg = HibernateUtil.getMaxSeq(session, "XtJsgnqxb", "jsgnid", js.getDqbm());
					XtJsgnqxb gx = new XtJsgnqxb();
					gx.setDqbm(js.getDqbm());
					gx.setGnid(gnid);
					gx.setJsgnid(String.valueOf(seg));
					gx.setJsid(jsid);
					super.create(gx);
					HibernateUtil.create(session, gx);
				}else{
					seg = HibernateUtil.getMaxSeq(session, "XtJsywbbqxb", "ywbbqxid", js.getDqbm());
					XtJsywbbqxb gx = new XtJsywbbqxb();
					gx.setDqbm(js.getDqbm());
					gx.setJsid(jsid);
					gx.setYwbbid(ywbbid);
					gx.setYwbbqxid(String.valueOf(seg));
					super.create(gx);
					HibernateUtil.create(session, gx);
				}
			}else{
				if(CommonUtil.isNotEmpty(gncdid)){
					hsql = "from XtJscdqxb where jsid=? and gncdid=?";
					params = new Object[]{jsid,gncdid};
				}else if(CommonUtil.isNotEmpty(gnid)){
					hsql = "from XtJsgnqxb where jsid=? and gnid=?";
					params = new Object[]{jsid,gnid};
				}else{
					hsql = "from XtJsywbbqxb where jsid=? and ywbbid=?";
					params = new Object[]{jsid,ywbbid};
				}
				
				Object obj = HibernateUtil.getObject(session, hsql, params);
				if(obj!=null){
					super.delete(obj);
					HibernateUtil.delete(session, obj);
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

	public void saveZzjyJs(Map<String, Object> param) {
		XtYh loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		String grant = (String)param.get("grant");
		if(CommonUtil.isEmpty(grant))
			throw new ServiceException("错误，用户和授权参数不完整。");
		
		String yhid = (String)param.get("yhid");
		String dwdm = (String)param.get("dwdm");
		
		if(CommonUtil.isEmpty(dwdm) || dwdm.length()==0)
			throw new ServiceException("错误，未知单位。");
		
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();
			tran = session.beginTransaction();
			
			XtYhxxb yh = HibernateUtil.get(session, XtYhxxb.class, yhid);
			if(yh==null)
				throw new ServiceException("地区" + dwdm.substring(0,4) + "不存在此用户！");
			
			String xmgrant[] = grant.split("\n");
			for(int i=0;i<xmgrant.length;i++){
				if(CommonUtil.isEmpty(xmgrant[i]))
					continue;
				
				int seek = xmgrant[i].indexOf(":");
				if(seek<=0)
					throw new ServiceException("错误，授权参数格式非法。");
				
				String xm = xmgrant[i].substring(0,seek).trim();
				String roles = xmgrant[i].substring(seek+1).trim();
		 
				//删除角色
				if(xm.equals("HZ2004")){
					String dhsql = "delete XT_YHJSXXB where yhid=?";
					
					//删除省厅
					super.executeSql(dhsql, new Object[]{yhid});
					
					//删除地市
					HibernateUtil.executeSql(session, dhsql, new Object[]{yhid});
					if(CommonUtil.isEmpty(roles))
						break;
					
					//获取一个和地区相关的最大的角色
					long yhjsid = HibernateUtil.getMaxSeq(session, "XtYhjsxxb", "yhjsid", dwdm.substring(0,4));
					
					String[] ids = roles.split(",");
					for(String jsid:ids){
						yhjsid += 1;
						
						XtYhjsxxb gx = new XtYhjsxxb();
						gx.setDqbm(dwdm.substring(0,4));
						gx.setJsid(jsid);
						gx.setYhid(yh.getYhid());
						gx.setYhjsid(String.valueOf(yhjsid));
						
						//省厅地市新建
						super.create(gx);
						HibernateUtil.create(session, gx);
					}
				}
			}
	
			tran.commit();
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
			
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public void updateZzjyJs(Map<String, Object> param) {
		/*
		String v_gxid_0 = (String)param.get("v_gxid_0");
		String v_gxid_1 = (String)param.get("v_gxid_1");
		
		SysUserInfo loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		if(CommonUtil.isNotEmpty(v_gxid_0)){
			String[] bm = v_gxid_0.split(",");
			for(int i=0;i<bm.length;i++){
				if(CommonUtil.isNotEmpty(bm[i])){
					String hsql = "update SysUserRole set zfpq='0' where gxid=?";
					super.executeHql(hsql, null, new Object[]{bm[i]});
				}
			}
		}
		if(CommonUtil.isNotEmpty(v_gxid_1)){
			String[] bm2 = v_gxid_1.split(",");
			for(int i=0;i<bm2.length;i++){
				if(CommonUtil.isNotEmpty(bm2[i])){
					String hsql = "update SysUserRole set zfpq='1' where gxid=?";
					super.executeHql(hsql, null, new Object[]{bm2[i]});
				}
			}
		}
		*/
	}

	public Page queryFunc(Map<String, Object> param, int pageIndex, int pageSize) {
		String dqbm = (String)param.get("dqbm");
		if(CommonUtil.isEmpty(dqbm))
			throw new ServiceException("错误，必须提供地区查询条件！");
		
		SqlParse sqlParse = new SqlParse(Config.getSql("queryFunc"));
		sqlParse.bind(param);
		SqlParam sqlParam = sqlParse.parse();
		
		Page p = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize); 
		
		return p;
	}

	public Page queryJs(Map<String, Object> param, int pageIndex, int pageSize) {
		String dm = (String)param.get("dm");
		if(CommonUtil.isEmpty(dm))
			throw new ServiceException("错误，必须提供地区查询条件！");
		
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dm.substring(0,4)).openSession();
			
			String sql = "from XtJsxxb";
			List list = HibernateUtil.getObjectList(session, sql, null);
			Page p = new Page();
			p.setList(list);
			
			return p;
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public Page queryUserJs(Map<String, Object> param, int pageIndex, int pageSize) {
		String xmbm = (String)param.get("xmbm");
		String opener = (String)param.get("opener");
		if(CommonUtil.isEmpty(xmbm))
			throw new ServiceException("错误，必须提供项目查询条件！");
		
		String optype = (String)param.get("optype");
		if(CommonUtil.isEmpty(optype))
			optype = "QX";
		
		SqlParse sqlParse = new SqlParse(Config.getSql(optype.equals("QX")?"queryUserJs":"queryUserJsFP"));
		sqlParse.bind(param);
		SqlParam sqlParam = sqlParse.parse();
		
		List list = super.getObjectListByHql(sqlParam.getSql(), sqlParam.getParams().toArray()); 
		
		param.put("loginName", opener);
		sqlParse.bind(param);
		sqlParam = sqlParse.parse();
		List list3 = super.getObjectListByHql(sqlParam.getSql(), sqlParam.getParams().toArray());
		
		List<QuerySysUserRole>list2 = new ArrayList<QuerySysUserRole>();
		for(Object o :list){
			Object[] objs = (Object[]) o;
			String gxid = (String) objs[0];
			String roleBm = (String) objs[1];
			String roleName = (String) objs[2];
			//String zfpq = (String) objs[3];
			
			QuerySysUserRole q = new QuerySysUserRole();
			//q.setGxid(gxid);
			//q.setRoleBm(roleBm);
			//q.setRoleName(roleName);
			//q.setZfpq(zfpq);
			
			/*
			for(Object o2:list3){
				Object[] objs3 = (Object[]) o2;
				String roleBm3 = (String) objs3[1];
				String zfpq3 = (String) objs3[3];
				if("1".equals(zfpq3) && roleBm3.equals(roleBm)){
					q.setZfpq_opener("1");
				}
			}
			*/
			
			list2.add(q);
		}

		Page p = new Page();
		p.setList(list2);
		p.setTotalCount(list.size());
		
		return p;
	}

	public Page queryZzjyByJs(Map<String, Object> param, int pageIndex,
			int pageSize) {
		String xmbm = (String)param.get("xmbm");
		if(CommonUtil.isEmpty(xmbm))
			throw new ServiceException("错误，必须提供项目查询条件！");
		
		SqlParse sqlParse = new SqlParse(Config.getSql("queryZzjy"));
		sqlParse.bind(param);
		SqlParam sqlParam = sqlParse.parse();
		
//		List list = super.getObjectListByHql(sqlParam.getSql(), sqlParam.getParams().toArray()); 
//		Page p = new Page();
//		p.setList(list);
//		p.setTotalCount(list.size());
		
		return super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
	}

	public List<TreeNode> queryProjectJSTreeFP(Map<String, Object> map) {
		/*
		String loginName = (String)map.get("loginName");
		String xmbm = (String)map.get("xmbm");
		
		SysUserInfo loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		//普通用户只能授权本用户的角色
		boolean isadmin = TemplateUtil.isAdmin();
		Set<String> selGrantJs = new HashSet<String>();
		if(CommonUtil.isNotEmpty(loginName)){
			List<SysUserRoleFpqx> list = super.getObjectListByHql("from SysUserRoleFpqx where loginName=? ",new Object[]{loginu.getLoginName()});
			for(SysUserRoleFpqx gx:list){
				String key = gx.getXmbm() + "_" + gx.getRoleBm();
				selGrantJs.add(key);
			}
		}
		
		Set<String> selJs = new HashSet<String>();
		if(CommonUtil.isNotEmpty(loginName)){
			List<SysUserRoleFpqx> list = super.getObjectListByHql("from SysUserRoleFpqx where loginName=? ",new Object[]{loginName});
			for(SysUserRoleFpqx gx:list){
				String key = gx.getXmbm() + "_" + gx.getRoleBm();
				selJs.add(key);
			}
		}
		
		//项目编码和角色的关系
		List<SysRoleInfo> rlist = super.getObjectListByHql("from SysRoleInfo");
		Map<String,List<SysRoleInfo>> pjMap = new HashMap<String,List<SysRoleInfo>>();
		for(SysRoleInfo r:rlist){
			String bm = r.getXmbm();
			List<SysRoleInfo> l = pjMap.get(bm);
			if(l==null){
				l = new ArrayList<SysRoleInfo>();
				pjMap.put(bm, l);
			}
			l.add(r);
		}
		
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		
		String hsql = "from SysProjectInfo where zxbz='0'";
		if(CommonUtil.isNotEmpty(xmbm)){
			hsql += " and (";
			String[] bm = xmbm.split(",");
			int count = 0;
			for(int i=0;i<bm.length;i++){
				if(CommonUtil.isEmpty(bm[i]))
					continue;
				
				if(count>0)
					hsql += " or ";
				
				hsql += " xmbm='" + bm[i] + "' ";
				count ++;
			}
			hsql += ")";
		}
		
		List xmlist = super.getObjectListByHql(hsql);
		
		Map<String,SysProjectInfo> m = new HashMap<String,SysProjectInfo>();
		for(Object o:xmlist){
			SysProjectInfo p = (SysProjectInfo)o;
			
			TreeNode node = new TreeNode();
			Code code = new Code();
			code.setCode(p.getXmbm());
			code.setName(p.getXmmc());
			
			node.setText(p.getXmmc());
			node.setLeaf(false);
			node.setCode(code);
			node.setExpanded(false);
			
			List<TreeNode> childList = new ArrayList<TreeNode>();
			List<SysRoleInfo> l = pjMap.get(p.getXmbm());
			if(l!=null){
				for(SysRoleInfo r:l){
					TreeNode child = new TreeNode();
					child.setText(r.getRoleName());
					child.setLeaf(true);
					child.setIcon("images/group.gif");
					child.setJs(r);
					
					String key = p.getXmbm() + "_" + r.getRoleBm();
					if(!isadmin){
						if(!selGrantJs.contains(key) && !selJs.contains(key))
							continue;
						if(!selGrantJs.contains(key))
							child.setDisabled(true);
					}
					
					child.setChecked(new Boolean(selJs.contains(key)));
					if(child.getChecked())
						node.setExpanded(true);
					
					childList.add(child);
				}
			}
			if(childList.size()>0){
				node.setChildren(childList);
				treeList.add(node);
			}
		}
		
		return treeList;
		*/
		return null;
	}

	public List<TreeNode> queryProjectJSTree(Map<String, Object> map) {
		XtYh loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		String yhid = (String)map.get("yhid");
		String dwdm = (String)map.get("dwdm");
		
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0,4)).openSession();

			XtYhxxb u = HibernateUtil.get(session, XtYhxxb.class, yhid);
			if(u==null)
				throw new ServiceException("地市" + dwdm.substring(0,4) + "不存在此用户！");
			
			//普通用户只能授权本用户的角色
			String hql = "from XtYhjsxxb a where a.yhid=?";
			
			//获取用户的已分配角色
			Set<String> selJs = new HashSet<String>();
			List<XtYhjsxxb> list = HibernateUtil.getObjectList(session, hql, new Object[]{yhid});
			for(XtYhjsxxb gx:list){
				String key = gx.getJsid();
				selJs.add(key);
			}
			
			//项目编码和角色的关系（获取本地角色）
			List<XtJsxxb> rlist = HibernateUtil.getObjectList(session, "from XtJsxxb a",new Object[]{});
			Map<String,List<XtJsxxb>> pjMap = new HashMap<String,List<XtJsxxb>>();
			for(XtJsxxb r:rlist){
				String bm = "HZ2004";
				List<XtJsxxb> l = pjMap.get(bm);
				if(l==null){
					l = new ArrayList<XtJsxxb>();
					pjMap.put(bm, l);
				}
				l.add(r);
			}
			
			SysProjectInfo p = new SysProjectInfo();
			p.setXmbm("HZ2004");
			p.setXmmc("人口管理");
				
			TreeNode node = new TreeNode();
			Code code = new Code();
			code.setCode(p.getXmbm());
			code.setName(p.getXmmc());
				
			node.setText(p.getXmmc());
			node.setLeaf(false);
			node.setCode(code);
			node.setExpanded(true);
				
			List<TreeNode> treeList = new ArrayList<TreeNode>();
			
			List<TreeNode> childList = new ArrayList<TreeNode>();
			List<XtJsxxb> l = pjMap.get(p.getXmbm());
			if(l!=null){
					for(XtJsxxb r:l){
						TreeNode child = new TreeNode();
						child.setText(r.getJsmc());
						child.setLeaf(true);
						child.setIcon("images/group.gif");
						child.setJs(r);
						
						String key =  r.getJsid();
						
						child.setChecked(new Boolean(selJs.contains(key)));
						if(child.getChecked())
							node.setExpanded(true);
						
						childList.add(child);
					}
			}
			
			if(childList.size()>0){
					node.setChildren(childList);
					treeList.add(node);
			}
			
			return treeList;
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public List<TreeNode> queryProjectTree() {
		XtYh loginu = BaseContext.getBaseUser().getUser();
		if(loginu==null)
			throw new ServiceException("错误，你的登录已经超时，请重新登陆！");
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		//项目就是市局单位
		List xmlist = null;
		
		if(loginu.getSsdwjgdm().startsWith("3400")){
			xmlist = super.getObjectListByHql("from XtDwxxb where dm like '%00000' order by dm asc");
		}else{
			xmlist = super.getObjectListByHql("from XtDwxxb where dm = '" + loginu.getSsdwjgdm().substring(0,4) + "00000' order by dm asc");
		}
		for(Object o:xmlist){
			XtDwxxb dw = (XtDwxxb)o;
			
			TreeNode child = new TreeNode();
			child.setDw(dw);
			child.setText(dw.getBz());
			child.setLeaf(true);
			child.setIcon("images/project.gif");
			
			list.add(child);
		}
		
		return list;
	}
	
	public List<TreeNode> queryYsqJSTree(Map<String, Object> map){
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		String dqbm = (String)map.get("dqbm");
		String jsid = (String)map.get("jsid");
		
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm.substring(0,4)).openSession();
			
			TreeNode gnd = new TreeNode();
			gnd.setText("功能点权限");
			gnd.setLeaf(false);
			gnd.setExpanded(true);
			gnd.setChecked(null);
			gnd.setChildren(new ArrayList<TreeNode>());
			gnd.setIcon("images/folder.gif");
			String hql = "select gnid from XtJsgnqxb where jsid=?";
			List existsList = HibernateUtil.getObjectList(session, hql, new Object[]{jsid});
			Set<String> set = new HashSet<String>();
			for(Object o:existsList){
				if(o==null) continue;
				
				set.add(o.toString());
			}
			
			hql = "from XtXtgnb t  order by gnbh";
			List alllist = HibernateUtil.getObjectList(session, hql, null);
			TreeNode parent = null;
			for(Object obj: alllist){
				XtXtgnb c = (XtXtgnb)obj;
				
				TreeNode child = new TreeNode();
				child.setChecked(set.contains(c.getGnid()));
				child.setText(c.getGnmc());
				child.setLeaf(true);
				child.setGnb(c);
				
				gnd.getChildren().add(child);
			}
			
			TreeNode cd = new TreeNode();
			cd.setText("菜单权限");
			cd.setLeaf(false);
			cd.setExpanded(true);
			cd.setChecked(null);
			cd.setChildren(new ArrayList<TreeNode>());
			cd.setIcon("images/folder.gif");
			
			hql = "select gncdid from XtJscdqxb t where jsid=?";
			existsList = HibernateUtil.getObjectList(session, hql, new Object[]{jsid});
			set = new HashSet<String>();
			for(Object o:existsList){
				set.add(o.toString());
			}
			
			hql = "from XtXtgncdb t order by gncdid";
			alllist = HibernateUtil.getObjectList(session, hql, null);
			parent = null;
			for(Object obj: alllist){
				XtXtgncdb c = (XtXtgncdb)obj;
	
				if("0".equals(c.getCdcc())){
					if(parent!=null){
						parent.setExpanded(true);
						if(parent.getGncdb().getCdbz().equals("1")){
							parent.setLeaf(true);
							parent.setChecked(false);
						}else{
							parent.setLeaf(false);
							parent.setChecked(null);
							parent.setIcon("images/folder.gif");
						}
						
						if(parent.isLeaf())
							parent.setChecked(set.contains(parent.getGncdb().getGncdid()));
						
						cd.getChildren().add(parent);
					}
					
					//根菜单
					parent = new TreeNode();
					parent.setChecked(null);
					parent.setChildren(new ArrayList<TreeNode>());
					parent.setText(c.getCdmc());
					parent.setGncdb(c);
				}else{
					//叶子菜单
					TreeNode child = new TreeNode();
					child.setChecked(set.contains(c.getGncdid()));
					child.setText(c.getCdmc());
					child.setLeaf(true);
					child.setGncdb(c);
					
					if(parent!=null)
						parent.getChildren().add(child);
					else
						cd.getChildren().add(child);
				}
			}
			
			if(parent!=null){
				parent.setExpanded(true);
				if(parent.getGncdb().getCdbz().equals("1")){
					parent.setLeaf(true);
					parent.setChecked(false);
				}else{
					parent.setLeaf(false);
					parent.setChecked(null);
					parent.setIcon("images/folder.gif");
				}
				
				if(parent.isLeaf())
					parent.setChecked(set.contains(parent.getGncdb().getGncdid()));
				
				cd.getChildren().add(parent);
			}
			
			TreeNode bb = new TreeNode();
			bb.setText("报表权限");
			bb.setLeaf(false);
			bb.setExpanded(true);
			bb.setChecked(null);
			bb.setChildren(new ArrayList<TreeNode>());
			bb.setIcon("images/folder.gif");
			
			//select * from xt_ywbbmbxxb t order by ywbblb
			//select * from xt_jsywbbqxb t
			
			TreeNode zsbb = new TreeNode();
			zsbb.setText("制式报表");
			zsbb.setLeaf(true);
			zsbb.setChecked(false);
			
			hql = "select ywbbid from XtJsywbbqxb  where jsid=?";
			existsList = HibernateUtil.getObjectList(session, hql, new Object[]{jsid});
			set = new HashSet<String>();
			for(Object o:existsList){
				set.add(o.toString());
			}
			
			hql = "from XtYwbbmbxxb t  order by ywbblb";
			alllist = HibernateUtil.getObjectList(session, hql, null);
			parent = null;
			for(Object obj: alllist){
				XtYwbbmbxxb c = (XtYwbbmbxxb)obj;
				
				TreeNode child = new TreeNode();
				child.setChecked(false);
				child.setText(c.getBbmc());
				child.setLeaf(true);
				child.setYwmb(c);
				
				if(set.contains(c.getYwbbid()))
					child.setChecked(true);
				
				bb.getChildren().add(child);
			}
			
			list.add(cd);
			list.add(gnd);
			list.add(bb);
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public List<TreeNode> queryWsqJSTree(Map<String, Object> map){
		List<TreeNode> list = new ArrayList<TreeNode>();
		return list;
	}
}
