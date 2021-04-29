package com.gnt.qxgl.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.gnt.qxgl.base.encoders.Base64;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.exception.ServiceException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectUtil {
	static private Map<String,ClassMetadata> metaMap = new HashMap<String,ClassMetadata>();
	
	protected static final Logger logger = Logger.getLogger(ObjectUtil.class);

	/**
	 * 自动装配对象统一的时间处理格式
	 */
	public static final String DateTimeStyle = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 内省:通过反射的方式操作JavaBean的属性
	 */
	private static Map<String, PropertyDescriptor> getPropertyDescriptors(Class<?> clazz) {
		Map<String, PropertyDescriptor> rs = new HashMap<String, PropertyDescriptor>();
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			
			for(PropertyDescriptor pd : pds) {
				if(pd.getReadMethod()==null || pd.getWriteMethod()==null)
					continue;
				
				rs.put(pd.getName(), pd);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	static private Map<String,String[]> objFieldsMap = new HashMap<String,String[]>();
	static private Map<String,Map<String,String>> resFieldsMap = new HashMap<String,Map<String,String>>();
	
	public static Map<String, String[]> getObjFieldsMap() {
		return objFieldsMap;
	}

	public static Map<String, Map<String, String>> getResFieldsMap() {
		return resFieldsMap;
	}

	/**
	 * 获取对象属性名称数组
	 * @param classObj
	 * @return
	 */
	public static String[] getFieldNames(Class<?> classObj){
		String className = classObj.getName();
		String fields[] = null;
		
		//缓存对象属性名称列表
		fields = objFieldsMap.get(className);
		if(fields==null){
				Map<String, PropertyDescriptor> pds = getPropertyDescriptors(classObj);
			
				fields = new String[pds.size()];
				int i = 0;
				for(PropertyDescriptor pd : pds.values()){
					if(pd.getReadMethod()==null || pd.getWriteMethod()==null)
						continue;
					
					fields[i] = pd.getName();
					i++;
				}
				objFieldsMap.put(className, fields);
		}
		
		return fields;
	}
	
	/**
	 * 获取对象逗号分隔的属性名
	 * @param classObj
	 * @return
	 */
	public static String getFieldNamesString(Class<?> classObj){
		String[] fields = getFieldNames(classObj);
		String str = "";
		for(String name:fields){
			if(!str.equals("")) str += ",";
			
			str += name;
		}
		
		return str;
	}
	
	public static <T> boolean copyInfo(T obj, String[] fields, ResultSet res){
		String className = obj.getClass().getName();
		Map<String, PropertyDescriptor> pds = getPropertyDescriptors(obj.getClass());
		
		boolean success = true;
		
		try {
			if(fields==null){
				//缓存对象属性名称列表
				fields = objFieldsMap.get(className);
				if(fields==null){
					fields = new String[pds.size()];
					int i = 0;
					for(PropertyDescriptor pd : pds.values()){
						if(pd.getReadMethod()==null || pd.getWriteMethod()==null)
							continue;
						
						fields[i] = pd.getName();
						i++;
					}
					objFieldsMap.put(className, fields);
				}			
			}
			
			Map<String,String> map = resFieldsMap.get(className);
			if(map==null){
				//缓存属性值和数据库字段名关系
				map = new HashMap<String,String>();
				ResultSetMetaData meta = res.getMetaData();
				for(int i=1;i<=meta.getColumnCount();i++){
					String colname = meta.getColumnName(i).toLowerCase();
					map.put(colname, colname);
				}
				resFieldsMap.put(className, map);
			}
				
			for(int i=0;i<fields.length;i++){
				String fname = fields[i];
				PropertyDescriptor pd = pds.get(fname);
				
				String colname = map.get(fname);
				if(colname==null)
					continue;
				
				//如果能写入，那么尝试赋值
				if(pd != null && pd.getWriteMethod() != null){
					Method writeMethod = pd.getWriteMethod();
					
					Class<?> type = pd.getPropertyType();
					if(type.equals(String.class)){
						String value = res.getString(colname);
						if(value!=null){
							writeMethod.invoke(obj, value);
						}
					}else if(type.equals(Integer.class)){
						String value = res.getString(colname);
						if(CommonUtil.isNotEmpty(value))
							writeMethod.invoke(obj, new Integer(value));
					}else if(type.equals(Long.class)){
						String value = res.getString(colname);
						if(CommonUtil.isNotEmpty(value))
							writeMethod.invoke(obj, new Long(value));
					}else if(type.equals(Double.class)){
						String value = res.getString(colname);
						if(CommonUtil.isNotEmpty(value))
							writeMethod.invoke(obj, Double.valueOf(value));					
					}else if(type.equals(Date.class)){
						Date date = res.getTimestamp(colname); 
						writeMethod.invoke(obj, date);
					}else if(type.equals(java.sql.Timestamp.class)){
						writeMethod.invoke(obj, res.getTimestamp(colname));
					}
				}				
			}
		}catch(Exception e) {
			success = false;
			logger.warn("复制属性出错：", e);
		}
		
		return success;
	}
	
	/**
	 * 将Map<String,Object>转换为指定对象
	 * @param cls
	 * @param data
	 * @return
	 */
	public static <T> T copyInfoByMap(Class<T> cls, Map<String,Object> data){
		String className = cls.getName();
		Map<String, PropertyDescriptor> pds = getPropertyDescriptors(cls);
		T obj = null;
		try {
			obj = cls.newInstance();
			
			//缓存对象属性名称列表
			String[] fields = objFieldsMap.get(className);
			if(fields==null){
					fields = new String[pds.size()];
					int i = 0;
					for(PropertyDescriptor pd : pds.values()){
						if(pd.getReadMethod()==null || pd.getWriteMethod()==null)
							continue;
						
						fields[i] = pd.getName();
						i++;
					}
					objFieldsMap.put(className, fields);
			}
			
			for(int i=0;i<fields.length;i++){
					String fname = fields[i];
					Object value = data.get(fname);
					
					if(value==null || value.toString().equals(""))
						continue;
					
					PropertyDescriptor pd = pds.get(fname);
					
					ObjectUtil.setPropertyValue(obj, pd, value, false);
				}
		}catch(Exception e) {
			throw new ServiceException("复制对象" + className + "出错！");
		}
		
		return obj;
	}
	
	public static <T> T copyInfo(Class<T> cls, Map<String,Object> data){
		return copyInfoByMap(cls,data);
	}
	
	public static <T> T copyInfo(Class<T> cls, String[] fields, ResultSet res){
		T obj = null;
		try {
			obj = cls.newInstance();
			if(!copyInfo(obj,fields,res)) {
				obj = null;
			}
		}catch(Exception e) {
			obj = null;
			logger.warn("复制属性出错：", e);
		}
		return obj;
	}
	
	/**
	 * 对象拷贝
	 * @param fromObj
	 * @param toObj
	 * @param fields
	 * @return
	 */
	public static Object copyInfo(Object fromObj, Object toObj, String[] fields) {
		if (fromObj == null || toObj == null) {
			return null;
		}
		
		BeanWrapper toBwp = new BeanWrapperImpl(toObj);
		BeanWrapper fromBwp = new BeanWrapperImpl(fromObj);
		if(fields!=null){
			for (int i = 0; i < fields.length; i++) {
				String field = fields[i];
				if (fromBwp.isReadableProperty(field)
						&& toBwp.isWritableProperty(field)) {
					toBwp.setPropertyValue(field, fromBwp.getPropertyValue(field));
				}
			}
		}else{
			PropertyDescriptor[] p = fromBwp.getPropertyDescriptors();
			for(int i=0;i<p.length;i++){
				String field = p[i].getName();
				if (fromBwp.isReadableProperty(field)
						&& toBwp.isWritableProperty(field)) {
					toBwp.setPropertyValue(field, fromBwp.getPropertyValue(field));
				}
			}
		}
		
		return toObj;
	}
	
	/**
	 * 将实体转换为MAP对象
	 * @param obj
	 * @return
	 */
	public  static Map<String,Object> entityToMap(Object obj){
		Map<String,Object> map = new HashMap<String,Object>();
		BeanWrapper fromBwp = new BeanWrapperImpl(obj);
		PropertyDescriptor[] p = fromBwp.getPropertyDescriptors();
		for(int i=0;i<p.length;i++){
			String field = p[i].getName();
			if (fromBwp.isReadableProperty(field) && fromBwp.isWritableProperty(field)) {
				Object val = fromBwp.getPropertyValue(field);
				if(val!=null && !val.toString().equals(""))
					map.put(field, val);
			}
		}
		
		return map;
	}
	
	/**
	 * 根据实体名获取类对象
	 * 
	 * @param entityName
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class<?> getEntityClass(String entityName)
			throws ClassNotFoundException {
		Class<?> clz = Class.forName( entityName);
		return clz;
	}

	/**
	 * 设置指定对象指定属性的值
	 * 
	 * @param clz
	 * @param o
	 * @param key
	 * @param value
	 * @throws NoSuchFieldException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void setObjectField(Class<?> clz, Object o, String key,
			String value) throws NoSuchFieldException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		Field field = clz.getDeclaredField(key);
		Class<?> type = field.getType();
		Method setMethod = clz.getDeclaredMethod(
				CommonUtil.getSetMethodByName(field.getName()), type);
		setMethod.invoke(o, getFieldSetValue(field, value));
	}

	/**
	 * 对象转换成json
	 * 
	 * @param dateStyle
	 * @param src
	 * @return
	 */
	public static String toJson(Object src) {
		GsonBuilder build = new GsonBuilder().serializeNulls();
		build.setDateFormat(DateTimeStyle);
		Gson gson = build.create();
		return gson.toJson(src);
	}

	/**
	 * json转换成对象
	 * 
	 * @param dateStyle
	 * @param src
	 * @return
	 */
	public static Object formJson(Class<?> clz, String json) {
		GsonBuilder build = new GsonBuilder().serializeNulls();
		// build.setDateFormat(DateTimeStyle);
		Gson gson = build.create();
		return gson.fromJson(json, clz);
	}

	/**
	 * 指定Field的类型转换value
	 * 
	 * @param field
	 * @param value
	 * @return
	 */
	public static Object getFieldSetValue(Field field, Object value) {
		if (value != null && field != null) {
			Class<?> type = field.getType();
			if (type.getName().equals("double") || type.equals(Double.class)) {
				Double d = -1.0d;
				d = Double.parseDouble((String) value);
				value = d;
			} else if (type.getName().equals("float")
					|| type.equals(Float.class)) {
				Float f = -1.0f;
				f = Float.parseFloat((String) value);
				value = f;
			} else if (type.equals(Integer.class)
					|| type.getName().equals("int")) {
				Integer i = -1;
				i = Integer.parseInt((String) value);
				value = i;
			} else if (type.equals(Date.class) || type.equals(Timestamp.class)) {
				value = DateHelper.toDate((String) value, DateTimeStyle);
			}
		}
		return value;
	}
	
	public static String getObjectToString(Object value) {
		if(value==null)
			return null;
		
		if(value instanceof String)
			return (String)value;
		
		if(value instanceof Date || value  instanceof Timestamp){
			String str = DateHelper.formateDate((Date)value, DateHelper.PRINT_DATETIME_STYLE2);
			return str.replaceAll(",",":");
		}
		
		if(value instanceof Integer || value instanceof Long)
			return value.toString();
		
		if(value instanceof Double || value instanceof Float){
			//DecimalFormat    df   = new DecimalFormat("######0.00");   
			//return df.format(value); 
			return value.toString();
		}

		if(value instanceof byte[])
			return new String(Base64.encode((byte[])value));
		
		return value.toString();
	}
	
	public static Long getObjectToLong(Object value) {
		if(value==null)
			return null;
		
		if(value instanceof String){
			try{
				return Long.parseLong((String)value);
			}catch(Exception e){
				throw new ActionException(value + "格式不正确！");
			}
		}
		
		if(value instanceof Date || value  instanceof Timestamp){
			return ((Date)value).getTime();
		}
		
		if(value instanceof Integer || value instanceof Long)
			return (Long)value;
		
		if(value instanceof Double || value instanceof Float){
			//DecimalFormat    df   = new DecimalFormat("######0.00");   
			//return df.format(value); 
			return Long.parseLong(value.toString());
		}

		throw new ActionException(value + "类型不支持！");
	}
	
	public static Integer getObjectToInteger(Object value) {
		if(value==null)
			return null;
		
		if(value instanceof String){
			try{
				return Integer.parseInt((String)value);
			}catch(Exception e){
				throw new ActionException(value + "格式不正确！");
			}
		}
		
		if(value instanceof Date || value  instanceof Timestamp){
			return Integer.parseInt(((Date)value).getTime() + "");
		}
		
		if(value instanceof Integer || value instanceof Long)
			return (Integer)value;
		
		if(value instanceof Double || value instanceof Float){
			//DecimalFormat    df   = new DecimalFormat("######0.00");   
			//return df.format(value); 
			return Integer.parseInt(value.toString());
		}

		throw new ActionException(value + "类型不支持！");
	}
	
	public static Double getObjectToDouble(Object value) {
		if(value==null)
			return null;
		
		if(value instanceof String){
			try{
				return Double.parseDouble((String)value);
			}catch(Exception e){
				throw new ActionException(value + "格式不正确！");
			}
		}
		
		if(value instanceof Date || value  instanceof Timestamp){
			return Double.parseDouble(((Date)value).getTime() + "");
		}
		
		if(value instanceof Integer || value instanceof Long)
			return Double.parseDouble(value.toString());
		
		if(value instanceof Double || value instanceof Float){
			return (Double)value;
		}

		throw new ActionException(value + "类型不支持！");
	}
	
	public static Date getObjectToDate(Object value) {
		if(value==null)
			return null;
		
		if(value instanceof Date)
			return (Date)value;
		
		return DateConverter.convertDate(value.toString());
	}
	
	public static Timestamp getObjectToTimestamp(Object value) {
		if(value==null)
			return null;
		
		if(value instanceof Timestamp)
			return (Timestamp)value;
		
		return new Timestamp(DateConverter.convertDate(value.toString()).getTime());
	}
	
	/**
	 * 数据copy
	 * 
	 * @param fromObj
	 *            源数据对象
	 * @param toObj
	 *            目标对象
	 * @param fields
	 *            需要copy的属性
	 * @return 目标对象(copy后的对象)
	 * @throws Exception
	 */
	public static Object copyInfo(Object fromObj, Object toObj, String[] fields,boolean notNull) {
		if (fromObj == null || toObj == null) {
			logger.debug(fromObj.getClass().getName() + " copy to "
					+ toObj.getClass().getName() + " is error!!!" + "("
					+ fromObj.getClass().getName() + "||"
					+ toObj.getClass().getName() + ") is Null");
			return null;
		}
		
		BeanWrapper toBwp = new BeanWrapperImpl(toObj);
		BeanWrapper fromBwp = new BeanWrapperImpl(fromObj);
		if(fields!=null){
			for (int i = 0; i < fields.length; i++) {
				String field = fields[i];
				if (fromBwp.isReadableProperty(field)
						&& toBwp.isWritableProperty(field)) {
					toBwp.setPropertyValue(field, fromBwp.getPropertyValue(field));
				}
			}
		}else{
			PropertyDescriptor[] p = fromBwp.getPropertyDescriptors();
			for(int i=0;i<p.length;i++){
				String field = p[i].getName();
				if (fromBwp.isReadableProperty(field)
						&& toBwp.isWritableProperty(field)) {
					//如果源为null不复制
					if(notNull&&fromBwp.getPropertyValue(field)==null)
						continue;
					toBwp.setPropertyValue(field, fromBwp.getPropertyValue(field));
				}
			}
		}
		
		return toObj;
	}
	
	/**
	 * 利用Map的数据，替换obj对象的属性值
	 * @param obj					要更新的对象
	 * @param valMap			可更新的内容
	 * @param fieldstr			以逗号分隔的obj对象属性值列表，为空表示更新所有属性，否则只更新指定属性
	 * @param filterFieldStr	以逗号分隔的需要忽略的属性列表，当fieldstr为空时起作用，表示这些属性之外的被赋值
	 * @param notNull	如果valMap不存在对应的值，怎么处理？ true 覆盖为null；false忽略,保留原值
	 * @return
	 * 
	   ObjectUtil.copyInfoByMap(obj, map, null, null, true);
		将map的内容，按照健值和属性名匹配的原则，对obj进行更新，map里不包含的内容，将被设置为null。
		
		ObjectUtil.copyInfoByMap(obj, map, null, null, false);
		将map的内容，按照健值和属性名匹配的原则，对obj进行更新，map里不包含的属性内容，将保留原来的值。
		
		ObjectUtil.copyInfoByMap(obj, map, "name,code,codetype,flag", null, true);
		将map的内容，按照健值和属性名匹配的原则，对obj的指定属性进行更新，map里不包含的内容，将被设置为null。
		
		ObjectUtil.copyInfoByMap(obj, map, "name,code,codetype,flag", null, false);
		将map的内容，按照健值和属性名匹配的原则，对obj的指定属性进行更新，map里不包含的内容，将保留原来的值。
		
		ObjectUtil.copyInfoByMap(obj, map, null, "name,code,codetype,flag", true);
		将map的内容，按照健值和属性名匹配的原则，对obj的指定之外的所有属性进行更新，map里不包含的内容，将被设置为null。
		
		ObjectUtil.copyInfoByMap(obj, map, null, "name,code,codetype,flag", false);
		将map的内容，按照健值和属性名匹配的原则，对obj的指定之外的所有属性进行更新，map里不包含的内容，将保留原来的值。
	 */
	public static Object copyInfoByMap(Object obj, Map<String,Object> valMap, String fieldstr, String filterFieldStr, boolean notNull){
		Map<String, PropertyDescriptor> pds = getPropertyDescriptors(obj.getClass());
		try {
			Set<String> filterFieldSet = new HashSet<String>();
			if(CommonUtil.isEmpty(fieldstr) && CommonUtil.isNotEmpty(filterFieldStr)){
				for(String name:filterFieldStr.split(","))
					if(CommonUtil.isNotEmpty(name)) filterFieldSet.add(name.trim());
			}
			
			//缓存对象属性名称列表
			String[] fields = null;
			if(CommonUtil.isEmpty(fieldstr)){
				fields = objFieldsMap.get(obj.getClass());
				if(fields==null){
						List<String> plist = new ArrayList<String>();
						for(PropertyDescriptor pd : pds.values()){
							if(pd.getReadMethod()==null || pd.getWriteMethod()==null)
								continue;
							
							plist.add(pd.getName());
						}
						
						fields = plist.toArray(new String[]{});
						objFieldsMap.put(obj.getClass().getName(), fields);
				}
			}else{
				fields = fieldstr.split(",");
			}
			
			for(int i=0;i<fields.length;i++){
					String fname = fields[i];
					Object value = valMap.get(fname);

					PropertyDescriptor pd = pds.get(fname);

					//如果能写入，那么尝试赋值
					if(pd != null && pd.getWriteMethod() != null)
						if(!filterFieldSet.contains(fname))
							ObjectUtil.setPropertyValue(obj, pd, value, notNull);
				}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		return obj;
	}
	
	/**
	 * 为对象的指定属性设置值
	 * @param toObj			要操作的对象
	 * @param pd				对象属性
	 * @param value			要设置的值
	 * @param nullWrite 	value==null，怎么处理？ true 覆盖为null；false忽略, 保留原值
	 * @throws Exception
	 */
	static private void setPropertyValue(Object toObj, PropertyDescriptor pd,  Object value, boolean nullWrite) throws Exception{
		Method writeMethod = pd.getWriteMethod();

		//处理空值
		if(value==null || CommonUtil.isEmpty(value.toString())){
			if(nullWrite)
				writeMethod.invoke(toObj,new Object[]{null});
			
			return;
		}
		
		Class<?> type = pd.getPropertyType();
		if(type.equals(String.class)){
			if(value instanceof String)
				writeMethod.invoke(toObj, (String)value);
			else
				writeMethod.invoke(toObj, ObjectUtil.getObjectToString(value));
		}else if(type.equals(Integer.class)){
			if(value instanceof Integer)
				writeMethod.invoke(toObj, (Integer)value);
			else
				writeMethod.invoke(toObj, Integer.parseInt(ObjectUtil.getObjectToString(value)));
		}else if(type.equals(Long.class)){
			if(value instanceof Long)
				writeMethod.invoke(toObj, (Long)value);
			else
				writeMethod.invoke(toObj, new Long(ObjectUtil.getObjectToString(value)));
		}else if(type.equals(Double.class)){
			if(value instanceof Double)
				writeMethod.invoke(toObj, (Double)value);
			else
				writeMethod.invoke(toObj, Double.valueOf(ObjectUtil.getObjectToString(value)));					
		}else if(type.equals(Float.class)){
			if(value instanceof Float)
				writeMethod.invoke(toObj, (Float)value);
			else
				writeMethod.invoke(toObj, Float.valueOf(ObjectUtil.getObjectToString(value)));					
		}else if(type.equals(Date.class)){
			if(value instanceof Date)
				writeMethod.invoke(toObj, (Date)value);
			else{
				Date date = DateConverter.convertDateByFormat(ObjectUtil.getObjectToString(value), DateHelper.PRINT_DATETIME_STYLE3);
				if(date==null)
					date = DateConverter.convertDateByFormat(ObjectUtil.getObjectToString(value), DateHelper.PRINT_DATETIME_STYLE2);
			
				if(date==null)
					throw new ServiceException("时间格式" + value + "不正确！");
			
				writeMethod.invoke(toObj, date);
			}
		}else if(type.equals(Timestamp.class)){
			if(value instanceof Timestamp)
				writeMethod.invoke(toObj, (Timestamp)value);
			else if(value instanceof Date)
				writeMethod.invoke(toObj, new java.sql.Timestamp(((Date)value).getTime()));
			else{
				Date date = DateConverter.convertDateByFormat(ObjectUtil.getObjectToString(value), DateHelper.PRINT_DATETIME_STYLE3);
				if(date==null)
					date = DateConverter.convertDateByFormat(ObjectUtil.getObjectToString(value), DateHelper.PRINT_DATETIME_STYLE2);
			
				if(date==null)
					throw new ServiceException("时间格式" + value + "不正确！");
			
				writeMethod.invoke(toObj, date);
			}
		}else{
			writeMethod.invoke(toObj, value);
		}
	}
	
	/**
	 * 依据对象，获取PK值
	 * @param sessionFactory
	 * @param obj
	 * @return
	 */
	static public String getPojoPK(Object obj){
		ClassMetadata meta = metaMap.get(obj.getClass().getName());
		if(meta==null){
			meta = SpringContainer.getSessionFactory().getClassMetadata(obj.getClass());  
			metaMap.put(obj.getClass().getName(), meta);
		}
		
		String entityName = meta.getEntityName();  
		String pkName = meta.getIdentifierPropertyName(); 
		
		BeanWrapper bwp = new BeanWrapperImpl(obj);
		String pkvalue = entityName + "_" + bwp.getPropertyValue(pkName).toString();
		
		return pkvalue;
	}
	
	static public Object getPojoPKValue(Object obj){
		ClassMetadata meta = metaMap.get(obj.getClass().getName());
		if(meta==null){
			meta = SpringContainer.getSessionFactory().getClassMetadata(obj.getClass());  
			metaMap.put(obj.getClass().getName(), meta);
		}
		
		String pkName = meta.getIdentifierPropertyName(); 
		BeanWrapper bwp = new BeanWrapperImpl(obj);
		Object pkvalue =  bwp.getPropertyValue(pkName);
		
		return pkvalue;
	}
	
	/**
	 * 依据对象类型，和主键值，获取PK值
	 * @param sessionFactory
	 * @param classObj
	 * @param id
	 * @return
	 */
	static public String getPojoPK( Class<?> classObj, final Serializable id){
		String entityName = classObj.getName();  
		String pkvalue = entityName + "_" + id;
		
		return pkvalue;
	}
	
	/**
	 * 获取对象的PK字段
	 * @param sessionFactory
	 * @param obj
	 * @return
	 */
	static public String getPojoPKName(Class<?> classobj){
		ClassMetadata meta = metaMap.get(classobj.getName());
		if(meta==null){
			SessionFactory sf =SpringContainer.getSessionFactory();
			meta = sf.getClassMetadata(classobj);  
			
			metaMap.put(classobj.getName(), meta);
		}
		
		String pkName = meta.getIdentifierPropertyName(); 
		
		return pkName;
	}

	/**
	 * 返回SQL查询的列
	 * @param sql
	 * @return
	 */
	static public String[] getColBySQL(String sql){
		//获取字段列表
		String str = sql.toLowerCase().trim().substring("select".length());
		int seek = str.indexOf("from ");
		if(seek<=0)	
			throw new ServiceException("功能配置有错误！");
		
		str = str.substring(0,seek);
		
		List<String> colsList = new ArrayList<String>();
		
		int seek2 = 0;
		//sql=select a,b,c,to_char(aaa,'yyyymmddd') as x,d,e,to_char(aaa,'yyyymmddd') as y from xxx";
		int count=0;
		while(true){
			count++;
			if(count>=100)
				throw new ServiceException(sql + "返回字段太多！");
			
			String colname = null;
			
			seek = str.indexOf(",");
			//查找函数
			seek2 = str.indexOf("(");
			if(seek2>=0 && seek>seek2){
				seek = str.indexOf(") ");
				if(seek>0){
					str = str.substring(seek+2);
					seek = str.indexOf(",");
				}else{
					break;
				}
			}
			
			if(seek<0){
				if(str.length()<=0){
					break;
				}
				
				colname = str;
				str = "";
			}else{
				colname = str.substring(0,seek);
				str = str.substring(seek+1);
			}
			
			colname = colname.trim();
	        seek = colname.indexOf(".");
	            if(seek>0)
	                colname = colname.substring(seek+1);
	            
			seek = colname.indexOf("as ");
			if(seek>=0)
				colname = colname.substring(3).trim();
			seek = colname.indexOf(" ");
			if(seek>=0)
				colname = colname.substring(seek).trim();
			
			colsList.add(colname);
		}
		
		return colsList.toArray(new String[]{});
	}
	
	/**
	 * 数字转换为字符串
	 * @param arry
	 * @return
	 */
	static public String arrayToString(String[] arry){
		String str = null;
		if(arry==null) return null;
		
		for(String c:arry){
			if(str==null)
				str = c;
			else
				str += "," + c;
		}
		
		return str;
	}

	/**
	 * @author sl
	 * @TODO 将查询的时间格式中的'@'符号替换成':'
	 * params 为时间格式字段所在list中的下标位置数组
	 * @date 2015-8-18 下午12:07:38
	 */
	static public List<?> changeTimeFormat(List<?> list, Object[] params){
		for (int i = 0; i < list.size(); i++){
			Object[] obj = (Object[]) list.get(i);
			for (int j = 0; j < params.length; j++){
				Integer mun = Integer.valueOf(params[j].toString());
				if (obj[mun] != null){
					obj[mun] = obj[mun].toString().replace("@", ":"); 
				}
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @param tablename
	 * @param sql	执行查询的	SQL语句，必须符合格式select+空格+返回列表+空格+from+空格+条件格式，以解析返回列，不支持别名
	 * @param list
	 * @return
	 */
	static public <T> List<T> makeReturnDataBySQLQuery(String sql, List<?> list,Class<T> cls){
		String cols[] = getColBySQL(sql);
		
		//将查询结果从数组转换为Map
		List<T> dataList = new ArrayList<T>();
		for(Object obj:list){
			Object[] objs = (Object[])obj;
			if(objs.length<cols.length){
				throw new ServiceException("配置解析有误，返回和配置字段不一致！");
			}
			
			Map<String,Object> mapData = new HashMap<String,Object>();
			for(int i=0;i<cols.length;i++){
				mapData.put(cols[i], ObjectUtil.getObjectToString(objs[i]));
			}
			T t=copyInfoByMap(cls, mapData);
			dataList.add(t);
		}
		
		return dataList;
	}
	
	/**
	 * 
	 * @param tablename
	 * @param sql	执行查询的	SQL语句，必须符合格式select+空格+返回列表+空格+from+空格+条件格式，以解析返回列，不支持别名
	 * @param list
	 * @return
	 */
	static public List<Map<String,String>> makeReturnDataBySQLQuery(String sql, List<?> list){
		String cols[] = getColBySQL(sql);
		
		//将查询结果从数组转换为Map
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		for(Object obj:list){
			Object[] objs = (Object[])obj;
			if(objs.length<cols.length)
				throw new ServiceException("配置解析有误，返回和配置字段不一致！");
			
			Map<String,String> mapData = new HashMap<String,String>();
			for(int i=0;i<cols.length;i++){
				mapData.put(cols[i], ObjectUtil.getObjectToString(objs[i]));
			}
			
			dataList.add(mapData);
		}
		
		return dataList;
	}
}
