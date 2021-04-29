package com.gnt.qxgl.common;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.gnt.qxgl.common.exception.ServiceException;

public class HibernateUtil {
	private static HashMap<String,SessionFactory> sessionFactorys = new HashMap<String,SessionFactory>();

	public static Session openSession(String jndi) throws HibernateException {
		return getSystemSessionFactory(jndi).openSession();
	}

	public static void closeSession(Session session) throws HibernateException {
		if (session != null)
			session.close();
	}

	public static SessionFactory getSystemSessionFactory(String jndi)
			throws HibernateException {
		if (sessionFactorys.containsKey(jndi)) {
			return (SessionFactory) sessionFactorys.get(jndi);
		}
		
		String cfgFile = "/conf/dq/" + jndi + ".cfg.xml";
		SessionFactory sf = null;
		try {
			Configuration conf  = new Configuration().configure(cfgFile);
			sf = conf.buildSessionFactory();
			if (sf != null) {
				sessionFactorys.put(jndi, sf);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return sf;
	}
	
	public static List getObjectList(Session session, final String queryString, final Object[] parms) throws DataAccessException {
		Query queryObject = session.createQuery(queryString);
		if(parms!=null){
			for (int i = 0; i < parms.length; i++) {
				queryObject.setParameter(i, parms[i]);
			}
		}
		SessionFactoryUtils.applyTransactionTimeout(queryObject, session.getSessionFactory());
		List list = queryObject.list();
		
		return list;
	}
	
	public static Page getPageRecords(Session session, final String queryString, final List parmList, final int pageIndex,
			final int pageSize) throws DataAccessException {
		Object[] parms = (parmList==null?null: parmList.toArray());
		
		String queryCountStr = null;
		
		String queryStr = queryString;
		boolean isHaving = false;
		if(queryStr.indexOf("having")>=0){
			//having不支持统计
			isHaving = true;
		}else{
			queryCountStr = "select count(*) "
					+ queryStr.substring(queryStr.indexOf("from"));
			int seek = queryCountStr.indexOf("order by");
			if (seek > 0)
				queryCountStr = queryCountStr.substring(0, seek);
		}
		
		Page page = new Page();
		Query queryObject = session.createQuery(queryStr);
		if(parms!=null){
			for (int i = 0; i < parms.length; i++) {
				queryObject.setParameter(i, parms[i]);
			}
		}
		
		queryObject.setFirstResult((pageIndex - 1) * pageSize);
		queryObject.setMaxResults(pageSize);
		SessionFactoryUtils.applyTransactionTimeout(queryObject, session.getSessionFactory());
		
		List list = queryObject.list();
		page.setList(list);
		
		if(isHaving)
			return page;
		
		Query queryObject2 = session.createQuery(queryCountStr);
		SessionFactoryUtils.applyTransactionTimeout(queryObject2, session.getSessionFactory());
		if(parms!=null){
			for (int i = 0; i < parms.length; i++) {
				queryObject2.setParameter(i, parms[i]);
			}
		}
		page.setTotalCount(Integer.parseInt(queryObject2.list().get(0).toString()));

		return page;
	}
	
	static public Object getObject(Session session, final String queryString, final Object[] parms){
		List<?> list = HibernateUtil.getObjectList(session, queryString, parms);
		if(list==null || list.size()==0)
			return null;
		
		return list.get(0);
	}
	
	static public long getMaxSeq(Session session, String pojoname,String pname,String dwdm){
		String dqbm = dwdm.substring(0,4);
		
		String hql = null;
		
		hql = "select max(a." + pname + ") from " + pojoname + " a";
		
		String tmpid = (String)HibernateUtil.getObject(session, hql, new Object[]{});
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
	
	static public <T> T get(Session session, final Class<T> entityClass, final Serializable id)
			throws DataAccessException {
		@SuppressWarnings("unchecked")
		T t = (T)session.get(entityClass, id);
		return t;
	}
	
	static public void create(Session session,final Object obj) throws DataAccessException {
		session.save(obj);
	}

	static public void delete(Session session,final Object obj) throws DataAccessException {
		session.delete(obj);
	}

	static public void update(Session session,final Object obj) throws DataAccessException {
		session.update(obj);
	}
	
	static public Integer executeSql(Session session, final String sql, final Object[] param) {
			SQLQuery query = session.createSQLQuery(sql);
			if(param != null && param.length > 0) {
				for(int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			}
			return query.executeUpdate();
	}
}