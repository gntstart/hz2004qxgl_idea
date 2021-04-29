package com.gnt.qxgl.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.type.Type;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gnt.qxgl.common.Page;

public abstract class ServiceImpl extends HibernateDaoSupport {
	// flush data
	protected void flush() throws DataAccessException {
		getHibernateTemplate().flush();
	}
	
	protected void clear() throws DataAccessException {
		getHibernateTemplate().clear();
	}
	
	// Add one entity
	protected void create(final Object obj) throws DataAccessException {
		setModified(obj);
		getHibernateTemplate().save(obj);
	}

	// Delete one entity
	protected void delete(final Object obj) throws DataAccessException {
		getHibernateTemplate().delete(obj);
	}

	// Update one entity
	protected void update(final Object obj) throws DataAccessException {
		setModified(obj);
		getHibernateTemplate().update(obj);
	}

	// Add many entitys
	protected void saveOrUpdate(final Object obj) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	// update add Lock
	protected void update(final Object obj, final LockMode lockmode)
			throws DataAccessException {
		setModified(obj);
		getHibernateTemplate().update(obj, lockmode);
	}

	// 批量维护
	protected void saveOrUpdateAll(final Collection objects)
			throws DataAccessException {
		if (objects != null) {
			getHibernateTemplate().saveOrUpdateAll(objects);
		}
	}

	// add mang entitys
	protected void createAll(final Collection objects)
			throws DataAccessException {
		if (objects != null) {
			for (Iterator iter = objects.iterator(); iter.hasNext();) {
				Object obj = (Object) iter.next();
				setModified(obj);
				
				create(obj);
			}
		}
	}

	// Delete many entitys
	protected void deleteAll(final Collection objects)
			throws DataAccessException {
		if (objects != null) {
			getHibernateTemplate().deleteAll(objects);
		}
	}

	// Update many entitys
	protected void updateAll(final Collection objects)
			throws DataAccessException {
		if (objects != null) {
			for (Iterator iter = objects.iterator(); iter.hasNext();) {
				Object obj = (Object) iter.next();
				setModified(obj);
				update(obj);
			}
		}

	}

	// refresh
	protected void refresh(Object entity) throws DataAccessException {
		getHibernateTemplate().refresh(entity);
	}

	protected void refresh(Object entity, LockMode lockmode)
			throws DataAccessException {
		getHibernateTemplate().refresh(entity, lockmode);
	}

	/**
	 * 延迟的意思是等到你用的时候与数据库发生交互，加载所需要的东西。但是，当这个session已经close的话，你使用延迟加载就会出错。
	 * 一般来说立即加载比较可靠稳妥，但性能比延迟加载低。各有利弊！
	 */
	public <T> T get(final Class<T> entityClass, final Serializable id)
			throws DataAccessException {
		return (T)getHibernateTemplate().get(entityClass, id);
	}

	protected Object get(final Class entityClass, final Serializable id,
			final LockMode lockmode) throws DataAccessException {
		return getHibernateTemplate().get(entityClass, lockmode);
	}

	protected Object get(final String entityName, final Serializable id)
			throws DataAccessException {
		return getHibernateTemplate().get(entityName, id);
	}

	protected Object get(final String entityName, final Serializable id,
			final LockMode lockmode) throws DataAccessException {
		return getHibernateTemplate().get(entityName, id, lockmode);
	}

	/**
	 * 使用，需要将相对应的.hbm.xml文件 <class 的lazy=false
	 * 当session已经close的话，你使用延迟加载就会出错,由于load方法在检索不到对象时会抛出异常, 在Hibernate映射文件中，通过在<class>上配置lazy属性来确定检索策略。对于Session的检索方式，类级别检索策略仅适用于load方法；也就说，对于get、qurey检索，持久化对象都会被立即加载而不管lazy是false还是true.
	 */
	protected Object load(final Class entityClass, final Serializable id)
			throws DataAccessException {
		return getHibernateTemplate().load(entityClass, id);
	}

	protected Object load(final Class entityClass, final Serializable id,
			final LockMode lockmode) throws DataAccessException {
		return getHibernateTemplate().load(entityClass, id, lockmode);
	}

	protected Object load(final String entityName, final Serializable id)
			throws DataAccessException {
		return getHibernateTemplate().load(entityName, id);
	}

	protected Object load(final String entityName, final Serializable id,
			final LockMode lockmode) throws DataAccessException {
		return getHibernateTemplate().load(entityName, id, lockmode);
	}

	protected List getAll(final Class entityClass) throws DataAccessException {
		String querystr = "from " + entityClass.getName();
		return getObjectListByHql(querystr);
	}

	protected List loadAll(final Class entityClass) throws DataAccessException {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/** ******************************************** */
	protected int getCount(final DetachedCriteria detachedCriteria)
			throws DataAccessException {
		DetachedCriteria detachedCriteria1 = detachedCriteria;
		detachedCriteria1.setProjection(Projections.rowCount());
		Integer count = (Integer) getHibernateTemplate().findByCriteria(
				detachedCriteria1).iterator().next();
		return count.intValue();
	}

	protected List getObjectListByCriteria(
			final DetachedCriteria detachedCriteria) throws DataAccessException {
		return getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	protected List getObjectListByCriteria(
			final DetachedCriteria detachedCriteria, final int pageIndex,
			final int pageSize) throws DataAccessException {
		return getHibernateTemplate().findByCriteria(detachedCriteria,
				(pageIndex - 1) * pageSize, pageSize);
	}

	/** ******************************************** */
	public List getObjectListByHql(final String querystr)
			throws DataAccessException {
		return getHibernateTemplate().find(querystr);
	}

	protected List getObjectListByHql(final String querystr, final Object value)
			throws DataAccessException {
		return getHibernateTemplate().find(querystr, value);
	}

	protected List getObjectListByHql(final String queryString,
			final int pageindex, final int pagesize) throws DataAccessException {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				queryObject.setFirstResult((pageindex - 1) * pagesize);
				queryObject.setMaxResults(pagesize);

				if (getHibernateTemplate().isCacheQueries()) {
					queryObject.setCacheable(true);
					if (getHibernateTemplate().getQueryCacheRegion() != null)
						queryObject.setCacheRegion(getHibernateTemplate()
								.getQueryCacheRegion());
				}
				if (getHibernateTemplate().getFetchSize() > 0)
					queryObject.setFetchSize(getHibernateTemplate()
							.getFetchSize());
				if (getHibernateTemplate().getMaxResults() > 0)
					queryObject.setMaxResults(getHibernateTemplate()
							.getMaxResults());
				SessionFactoryUtils.applyTransactionTimeout(queryObject,
						getHibernateTemplate().getSessionFactory());

				/*
				 * if(values != null) { for(int i = 0; i < values.length; i++)
				 * queryObject.setParameter(i, values[i]); }
				 */
				return queryObject.list();
			}

		}, true);
	}

	protected List getObjectListByHql(final String querystr,
			final Object[] values) throws DataAccessException {
		return getHibernateTemplate().find(querystr, values);
	}

	protected List getObjectListByHql(final String querystr,
			final String param, final Object value) throws DataAccessException {
		try{
		return getHibernateTemplate().findByNamedParam(querystr, param, value);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	protected List getObjectListByHql(final String querystr,
			final String[] params, final Object[] values)
			throws DataAccessException {
		return getHibernateTemplate().findByNamedParam(querystr, params, values);
	}

	/** ******************************************** */
	protected List getObjectListByQueryName(final String QueryName)
			throws DataAccessException {
		return getHibernateTemplate().findByNamedQuery(QueryName);
	}

	protected List getObjectListByQueryName(final String QueryName,
			final Object value) throws DataAccessException {
		return getHibernateTemplate().findByNamedQuery(QueryName, value);
	}

	protected List getObjectListByQueryName(final String QueryName,
			final Object[] values) throws DataAccessException {
		return getHibernateTemplate().findByNamedQuery(QueryName, values);
	}

	protected List getObjectListByQueryName(final String QueryName,
			final String[] params, final Object[] values)
			throws DataAccessException {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(QueryName,
				params, values);
	}

	/**
	 * 通过属性名对相关的类进行查询
	 * 
	 * @param pojoName
	 *            pojo类名
	 * @param proName
	 *            属性名称
	 * @param proValue
	 *            值
	 * @return 符合条件的集合
	 */
	protected List getObjectListByPropertyName(String pojoName, String proName,
			String proValue) {
		List list = null;
		String hsql = "from " + pojoName + " t where t." + proName + "='"
				+ proValue + "'";
		list = this.getObjectListByHql(hsql);
		return list;
	}

	/** ******************************************** */
	protected Page getPageRecords(final DetachedCriteria dc,
			final int pageIndex, final int pageSize) throws DataAccessException {
		Page page = new Page();
		dc.setProjection(Projections.rowCount());
		page.setTotalCount(Integer.parseInt(getHibernateTemplate()
				.findByCriteria(dc).get(0).toString()));
		dc.setProjection(null);
		page.setList(getHibernateTemplate().findByCriteria(dc,
				(pageIndex - 1) * pageSize, pageSize));
		
		return page;
	}

	protected Page getPageRecords(final String queryString,
			final int pageIndex, final int pageSize) throws DataAccessException {
		String queryStr = queryString;
		String queryCountStr = "select count(*) "
				+ queryStr.substring(queryStr.indexOf("from"));
		int seek = queryCountStr.indexOf("order by");
		if (seek > 0)
			queryCountStr = queryCountStr.substring(0, seek);

		Page page = new Page();
		page.setList(getObjectListByHql(queryString, pageIndex, pageSize));
		page.setTotalCount(Integer.parseInt(getObjectListByHql(queryCountStr)
				.get(0).toString()));
		return page;
	}

	/**
	 * 带参数的HSQL分页查询
	 * 
	 * @param queryString
	 * @param parmList
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	protected Page getPageRecords(final String queryString,
			final List parmList, final int pageIndex, final int pageSize)
			throws DataAccessException {
		return getPageRecords(queryString, null, parmList, pageIndex, pageSize);
	}

	/**
	 * 执行sql查询
	 * @param sql
	 * @param param 可不指定
	 * @return
	 */
	public List executeSqlQuery(final String sql, final Object[] param) {
		return (List)getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				
				if(param != null && param.length > 0) {
					for(int i = 0; i < param.length; i++) {
						query.setParameter(i, param[i]);
					}
				}
				
				return query.list();
			}
		});
	}
	
	public Integer executeSql(final String sql, final Object[] param) {
		return (Integer)getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				
				if(param != null && param.length > 0) {
					for(int i = 0; i < param.length; i++) {
						query.setParameter(i, param[i]);
					}
				}
				
				return query.executeUpdate();
			}
		});
	}
	
	/**
	 * 带参数的HSQL分页查询
	 * 
	 * @param queryString
	 * @param nameList
	 * @param parmList
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	protected Page getPageRecords(final String queryString,
			final List nameList, final List parmList, final int pageIndex,
			final int pageSize) throws DataAccessException {
		Object[] parms = parmList.toArray();
		String[] names = null;
		if(nameList != null) {
			names = new String[nameList.size()];
			nameList.toArray(names);
		}
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
		page.setList(getObjectListByHql(queryString, names, parms, pageIndex,
				pageSize));
		
		if(isHaving)
			return page;
		
		if (nameList != null)
			page.setTotalCount(Integer.parseInt(getObjectListByHql(
					queryCountStr, names, parms).get(0).toString()));
		else
			page.setTotalCount(Integer.parseInt(getObjectListByHql(
					queryCountStr,parms).get(0).toString()));
		
		return page;
	}

	/**
	 * 查询页，但是不执行COUNT
	 * @param queryString
	 * @param nameList
	 * @param parmList
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	protected Page getPageRecordsNoCount(final String queryString,final List parmList, final int pageIndex,
			final int pageSize) throws DataAccessException {
		Object[] parms = parmList.toArray();
	
		Page page = new Page();
		page.setList(getObjectListByHql(queryString, null, parms, pageIndex,pageSize));
		page.setTotalCount(page.getList().size());
		
		return page;
	}
	
	/**
	 * 提供参数的查询
	 * 
	 * @param queryString
	 * @param parms
	 * @param pageindex
	 * @param pagesize
	 * @return
	 * @throws DataAccessException
	 */
	protected List getObjectListByHql(final String queryString,
			final Object[] parms, final int pageindex, final int pagesize)
			throws DataAccessException {
		return getObjectListByHql(queryString, null, parms, pageindex, pagesize);
	}

	/**
	 * 
	 * @param queryString
	 * @param names
	 *            参数名称
	 * @param parms
	 * @param pageindex
	 * @param pagesize
	 * @return
	 * @throws DataAccessException
	 */
	protected List getObjectListByHql(final String queryString,
			final String[] names, final Object[] parms, final int pageindex,
			final int pagesize) throws DataAccessException {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				if (names == null) {
					for (int i = 0; i < parms.length; i++) {
						queryObject.setParameter(i, parms[i]);
					}
				} else {
					for (int i = 0; i < parms.length; i++) {
						if (parms[i] instanceof Collection)
							queryObject.setParameterList(names[i],
									(Collection) parms[i]);
						else if (parms[i] instanceof Object[])
							queryObject.setParameterList(names[i],
									(Object[]) parms[i]);
						else
							queryObject.setParameter(names[i], parms[i]);
					}
				}

				queryObject.setFirstResult((pageindex - 1) * pagesize);
				queryObject.setMaxResults(pagesize);

				if (getHibernateTemplate().isCacheQueries()) {
					queryObject.setCacheable(true);
					if (getHibernateTemplate().getQueryCacheRegion() != null)
						queryObject.setCacheRegion(getHibernateTemplate()
								.getQueryCacheRegion());
				}
				if (getHibernateTemplate().getFetchSize() > 0)
					queryObject.setFetchSize(getHibernateTemplate()
							.getFetchSize());
				if (getHibernateTemplate().getMaxResults() > 0)
					queryObject.setMaxResults(getHibernateTemplate()
							.getMaxResults());
				SessionFactoryUtils.applyTransactionTimeout(queryObject,
						getHibernateTemplate().getSessionFactory());

				return queryObject.list();
			}

		}, true);
	}

	/**
	 * 根据指定的HQL语句和参数获得记录集的第1个对象
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	protected Object getObject(String hql, Object param[]) {
		List tmp = getObjectListByHql(hql, param);
		if (tmp != null && tmp.size() > 0)
			return tmp.get(0);

		return null;
	}


	/**
	 * 查找并且初始化得到对象的指定属性
	 * 
	 * @param clazz
	 * @param id
	 * @param property
	 *            属性名称
	 * @return
	 */
	protected Object getAndInitProperty(Class clazz, Serializable id,
			String[] property) {
		Object entity = this.get(clazz, id);
		BeanWrapper bwp = new BeanWrapperImpl(entity);
		for (int i = 0; i < property.length; i++) {
			Hibernate.initialize(bwp.getPropertyValue(property[i]));
		}
		return entity;
	}

	/********************************************** */
	protected int getCount(final String hql)
			throws DataAccessException {
		Integer count = (Integer) getHibernateTemplate().find(hql).iterator().next();
		return count.intValue();
	}
	
	/**
	 * SQL查询
	 * @param queryString sql语句
	 * @param names	参数名
	 * @param parms 参数值
	 * @param entitys 指定返回对象
	 * @param scalars 指定返回标量
	 * @return
	 */
	protected List getObjectListBySql(final String queryString,
			final String[] names, final Object[] parms,final String[] entityAlias,
			final Class[] entitys,final Map scalars){
		
		return (List) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException {
				SQLQuery queryObject = session.createSQLQuery(queryString);
				assembleQuery(names,parms,queryObject);
				assembleSQLQuery(entityAlias, entitys, scalars, queryObject);
				enactmentQuery(queryObject);

				return queryObject.list();
			}



		}, true);
	}
	private void enactmentQuery(Query queryObject) {
		if (getHibernateTemplate().isCacheQueries()) {
			queryObject.setCacheable(true);
			if (getHibernateTemplate().getQueryCacheRegion() != null)
				queryObject.setCacheRegion(getHibernateTemplate()
						.getQueryCacheRegion());
		}
		if (getHibernateTemplate().getFetchSize() > 0)
			queryObject.setFetchSize(getHibernateTemplate()
					.getFetchSize());
		if (getHibernateTemplate().getMaxResults() > 0)
			queryObject.setMaxResults(getHibernateTemplate()
					.getMaxResults());
		SessionFactoryUtils.applyTransactionTimeout(queryObject,
				getHibernateTemplate().getSessionFactory());
	}
	/**
	 * SQL分页查询
	 * @param queryString sql语句
	 * @param names	参数名
	 * @param parms 参数值
	 * @param entitys 指定返回对象
	 * @param scalars 指定返回标量
	 * @param pageindex 开始页数
	 * @param pagesize  每页记录数
	 * @return
	 */
	protected List getObjectListBySql(final String queryString,
			final String[] names, final Object[] parms,final String[] entityAlias,
			final Class[] entitys,final Map scalars,
			final int pageindex,final int pagesize){
		
		return (List) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException {
				SQLQuery queryObject = session.createSQLQuery(queryString);
				assembleQuery(names,parms,queryObject);
				assembleSQLQuery(entityAlias, entitys, scalars, queryObject);
				queryObject.setFirstResult((pageindex - 1) * pagesize);
				queryObject.setMaxResults(pagesize);
				enactmentQuery(queryObject);
				return queryObject.list();
			}
		}, true);
	}

	private void assembleSQLQuery(final String[] entityAlias,
			final Class[] entitys, final Map scalars, SQLQuery queryObject) {
		// if(有指定的返回类型)
		if (entityAlias != null) {
			for (int i = 0; i < entitys.length; i++) {
				queryObject.addEntity(entityAlias[i], entitys[i]);
			}
		} else if (entitys != null) {
			for (int i = 0; i < entitys.length; i++) {
				queryObject.addEntity(entitys[i]);
			}
		}
		// 有指定的返回标量
		if (scalars != null && !scalars.isEmpty()) {
			Set scalarsNames = scalars.keySet();
			for (Iterator itr = scalarsNames.iterator(); itr.hasNext();) {
				String name = (String) itr.next();
				if (scalars.get(name) != null) {
					queryObject.addScalar(name, (Type) scalars.get(name));
				} else {
					queryObject.addScalar(name);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param queryString	SQL语句
	 * @param names	参数名字数组
	 * @param parms	参数数组
	 * @param entityNames	对象名数组
	 * @param entitys	对象数组
	 * @param pageindex	起始页
	 * @param pagesize	每页条数
	 * @return
	 */
	protected Page getPageRecords(final String queryString,
			final String[] names, final Object[] parms,
			final String[] entityNames,final Class[] entitys,
			final int pageindex,final int pagesize){
		return this.getPageRecords(queryString,names,parms,entityNames,entitys,null,pageindex,pagesize);
	}
	
	/**
	 * 
	 * @param queryString	SQL语句
	 * @param names	参数名字数组
	 * @param parms	参数数组
	 * @param scalars	标量
	 * @param pageindex	起始页
	 * @param pagesize	每页条数
	 * @return
	 */
	protected Page getPageRecords(final String queryString,
			final String[] names, final Object[] parms,
			final Map scalars,
			final int pageindex,final int pagesize){
		return this.getPageRecords(queryString,names,parms,null,null,scalars,pageindex,pagesize);
	}
	
	/**
	 * 
	 * @param queryString SQL语句
	 * @param names	参数名字数组
	 * @param parms	参数数组
	 * @param entityNames 对象名
	 * @param entitys 对象参数
	 * @param scalars	标量
	 * @param pageindex	起始页
	 * @param pagesize	每页条数
	 * @return
	 */
	protected Page getPageRecords(final String queryString,
			final String[] names, final Object[] parms,
			final String[] entityNames,final Class[] entitys,final Map scalars,
			final int pageindex,final int pagesize){
		
		String queryStr = queryString;
		
		String queryCountStr = "select count(*) "
				+ queryStr.substring(queryStr.indexOf("from"));
		int seek = queryCountStr.indexOf("order by");
		if (seek > 0)
			queryCountStr = queryCountStr.substring(0, seek);
		Page page = new Page();
		page.setList(this.getObjectListBySql(queryString, names, parms, 
				entityNames,entitys, scalars,pageindex,pagesize));
		page.setTotalCount(Integer.parseInt(this.getObjectListBySql(queryCountStr, names, parms,null , null, scalars).get(0).toString()));
		return page;
	}
	
	/**
	 * 执行HQL语句 UPDATE|DELETE|INSERT
	 * @param hql 	hql语句
	 * @param names	参数名|null
	 * @param parms	参数|null
	 * @return
	 */
	protected Integer executeHql(final String hql,final String[] names,final Object[] parms){
		return (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query queryObject = session.createQuery(hql);
				assembleQuery(names, parms, queryObject);
				return new Integer(queryObject.executeUpdate());
			}


		}, true);
	}
	
	private void assembleQuery(final String[] names,
			final Object[] parms, Query queryObject) {
		//if(参数名数组!=null)
		if(names != null){
			//按名字设置参数
			for (int i = 0; i < parms.length; i++) {
				if (parms[i] instanceof Collection)
					queryObject.setParameterList(names[i],
							(Collection) parms[i]);
				else if (parms[i] instanceof Object[])
					queryObject.setParameterList(names[i],
							(Object[]) parms[i]);
				else
					queryObject.setParameter(names[i], parms[i]);
			}
		}else if(parms != null){
//			按顺序设置参数
			for (int i = 0; i < parms.length; i++) {
				queryObject.setParameter(i, parms[i]);
			}
		}
	}
	
	private void setModified(Object entity) {
		BeanWrapper bw = new BeanWrapperImpl(entity);
		String cjr = null;

		if (bw.isReadableProperty("layerOooo")) {
			String layerOooo = (String) bw.getPropertyValue("layerOooo");
			if (layerOooo != null && !"".equals(layerOooo)) {
			}
		}

		// 如果没有创建人，那么直接返回
		if (bw.isWritableProperty("cjr"))
			cjr = (String) bw.getPropertyValue("cjr");
		else
			return;

		// 获取用户编码
		String usercode = (String)BaseContext.getUserCode();

		// 如果创建者为空，那么设置所有日志
		if (cjr == null) {
			setAddLog(entity, usercode, bw);
			return;
		}

		//否则只设置修改者日志
		setModifiedLog(entity, usercode, bw);
	}
	
	private void setModifiedLog(Object entry, String usercode, BeanWrapper bw) {
		try {
			if (bw.isWritableProperty("zxgxsj"))
				bw.setPropertyValue("zxgxsj", new Date());

			if (bw.isWritableProperty("zxgxr"))
				bw.setPropertyValue("zxgxr", usercode);
		} catch (Exception e) {
			;
		}
	}

	private void setAddLog(Object entry, String usercode, BeanWrapper bw) {
		setModifiedLog(entry, usercode, bw);
		try {
			if (bw.isWritableProperty("cjsj"))
				bw.setPropertyValue("cjsj", new Date());

			if (bw.isWritableProperty("cjr"))
				bw.setPropertyValue("cjr", usercode);
		} catch (Exception e) {
			;
		}
	}
}