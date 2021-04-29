package com.gnt.qxgl.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.DateHelper;



/**
 * 
 * @author liuqy 该类是工具类，用来定义一些公共的方法。
 * 
 */
public class CommonUtil {
	static Logger logger = Logger.getLogger(CommonUtil.class);
	
	public static String formatDate(String format){
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern(format);
		
		return df.format(new Date());
	}

	public static String getTokey(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String validTokey = "shjc!@" + sdf.format(new Date());
		String TokeyMD5 = CommonUtil.StringToMd5(validTokey);

		return TokeyMD5;
	}

	public static String StringToMd5(String psw) {
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				md5.update(psw.getBytes("UTF-8"));
				byte[] encryption = md5.digest();

				StringBuffer strBuf = new StringBuffer();
				for (int i = 0; i < encryption.length; i++) {
					if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
						strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
					} else {
						strBuf.append(Integer.toHexString(0xff & encryption[i]));
					}
				}

				return strBuf.toString();
			} catch (NoSuchAlgorithmException e) {
				return "";
			} catch (UnsupportedEncodingException e) {
				return "";
			}
	}

	public static Object getParamToObject(String key,String value){
		if(value==null)
			return null;
		
		if(CommonUtil.isEmpty(value.trim()))
			return null;
		
		if(key.startsWith("to_daysdate_") || key.startsWith("to_startdate_") || key.startsWith("to_enddate_") || key.startsWith("to_date_")){
			Date date = null;
			SimpleDateFormat df = new SimpleDateFormat();
			df.applyPattern("yyyy-MM-dd HH:mm:ss");
			try{
				if(key.startsWith("to_startdate_")){
					date = df.parse(value + " 00:00:00");
				}else if(key.startsWith("to_enddate_")){
					date = df.parse(value + " 23:59:59");
				}else if(key.startsWith("to_date_")){
					date = DateConverter.convertDate(value);
				}else{
					Calendar c = Calendar.getInstance();
					c.add(Calendar.DAY_OF_YEAR, 0-Integer.parseInt(value));
					c.set(Calendar.HOUR_OF_DAY, 0);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
					
					date = c.getTime();
				}
			}catch(Exception ex){
				throw new ActionException("转换日期条件[" + key + "=" + value + "]时发生错误，错误信息：" + ex.getMessage());
			}
			
			return date;
		}else if(key.startsWith("to_long_")){
			return new Long(value);
		}else if(key.startsWith("to_double_")){
			return new Double(value);
		}else if(key.startsWith("to_int_")){
			return new Integer(value);
		}
		
		return value;
	}
	
	static public ExtMap<String,Object> getRequestParamesObject(HttpServletRequest request){
		ExtMap<String,Object> map = new ExtMap<String,Object>();
		
		for(java.util.Enumeration<?> e = request.getParameterNames(); e.hasMoreElements();){
			String key = (String)e.nextElement();
			String value = request.getParameter(key);
			
			if(CommonUtil.isEmpty(value))
				continue;
			
			Object obj = CommonUtil.getParamToObject(key,value);
			if(obj==null)
				continue;
			
			map.put(key, obj);
		}
		
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		int size,index;
		if(CommonUtil.isNotEmpty(start)&& CommonUtil.isNotEmpty(limit) && !limit.equals("0")){
			size = Integer.parseInt(limit);
			index = Integer.parseInt(start)/size + 1;
		}else{
			size = 20;
			index = 1;
		}
		//不让它覆盖已经有参数 2014-8-8
		if(!map.containsKey(ExtUtils.pageSize))
			map.put(ExtUtils.pageSize,size+"");
		if(!map.containsKey(ExtUtils.pageIndex))
			map.put(ExtUtils.pageIndex,index+"");

		return map;
	}
	
	/**
	 * 判断是否是数字
	 * @param value
	 * @return
	 */
	 public static int getInteger(String value) { 
		 try {   
			 return Integer.parseInt(value);  
		} catch (NumberFormatException e) {  
			throw new ServiceException("非法数字！");
		}
	}
	 
	/**
	 * 判断项目是否处于修改状态
	 * @param user
	 * @return
	 */
	static public boolean isUpdateXm(BaseUser user){
		return true;
	}
	
	public static String str(String... strings){
		StringBuilder st = new StringBuilder();
		if(strings != null){
			for (String string : strings) {
				st.append(string);
			}
		}
		return st.toString();
	}
	
	static public String getExceptionMesssage(Throwable e){
		Throwable cause = e;
		if(e instanceof ServiceException || e instanceof ActionException){
		    while (cause.getCause() != null) {	        	
		    	cause = cause.getCause();
		    }
		}
	    return cause.getMessage();
	}
    
	//获取错误详细信息
	static public String getStackTrace(Throwable cause){
		StackTraceElement[] se = cause.getStackTrace();
		StringBuffer msg = new StringBuffer();
		msg.append(cause.getMessage());

		if(se!=null && se.length>0){
			for(int i=0;i<se.length;i++){
				StackTraceElement e=se[i];
				String classname = e.getClassName();
				String filename = e.getFileName();
				String linenumber = String.valueOf(e.getLineNumber());
				String methodname = e.getMethodName();
				String moreMsg="";
				if(filename!=null && !"-1".equals(linenumber))
					moreMsg = "(" + filename + "第" + linenumber + "行)";
				
				msg.append("\r\n").append(classname).append(".").append(methodname).append(" ").append(moreMsg);
			}
		}
	
		return msg.toString();
	}
	
	static public String getDateInfo(Date dDate1){
		Calendar cDate = Calendar.getInstance();
		
		//先计算指定日期dDate1所在月的最后一天
		
		// 将指定日期的天数设置为1，得到指定月份的第一天
		cDate.setTime(dDate1);
		cDate.set(Calendar.DATE,1);
		// 将指定月份的第一天的月份加1得到该月的下个月的第一天
		cDate.add(Calendar.MONTH, 1);
		// 再减一天，获得指定月份最后一天
		cDate.add(Calendar.DATE, -1);
		Date dDate2 = DateHelper.getEndDate(cDate.getTime());
		
		//然后计算当前日期和这台的相聚时间
		dDate1 = new Date();
		if(dDate1.after(dDate2))
			return "0天0小时0分0秒";;
		
		long   subTempTime   =   dDate2.getTime()-dDate1.getTime();       
		int   day   =   (int)(subTempTime/86400000);   
		int   hour   =   (int)((subTempTime%86400000)/3600000);   
		int   minute   =   (int)(((subTempTime%86400000)%3600000)/60000);   
		int   second   =   (int)   ((((subTempTime%86400000)%3600000)%24000)/1000);
		
		String currentTime = String.valueOf(day) + "天" + String.valueOf(hour) + "小时" + minute + "分" +  second + "秒";
		return currentTime;
	}
	
	//获取指定日期的月第一天和最后一天
	static public Date getLastMonthDate(Date date){
		Calendar cDate = Calendar.getInstance();

		// 将指定日期的天数设置为1，得到指定月份的第一天
		cDate.setTime(date);
		cDate.set(Calendar.DATE, 1);// 设为当前月的1号

		// 将指定月份的第一天的月份加1得到该月的下个月的第一天
		cDate.add(Calendar.MONTH, 1);
		// 再减一天，获得指定月份最后一天
		cDate.add(Calendar.DATE, -1);
		Date tjsj2 = DateHelper.getEndDate(cDate.getTime());
		
		return tjsj2;
	}
	
	//获得指定日期的第1天
	static public Date getFirstMonthDate(Date date){
		Calendar cDate = Calendar.getInstance();

		// 将指定日期的天数设置为1，得到指定月份的第一天
		cDate.setTime(date);
		cDate.set(Calendar.DATE, 1);// 设为当前月的1号
		Date tjsj2 = DateHelper.getStartDate(cDate.getTime());
		
		return tjsj2;
	}
	
	//获取指定日期的月第一天和最后一天
	static public String getMonthDateInfo(Date date,String spe){
		Calendar cDate = Calendar.getInstance();

		// 将指定日期的天数设置为1，得到指定月份的第一天
		cDate.setTime(date);
		cDate.set(Calendar.DATE, 1);// 设为当前月的1号
		Date tjsj1 = DateHelper.getStartDate(cDate.getTime());

		// 将指定月份的第一天的月份加1得到该月的下个月的第一天
		cDate.add(Calendar.MONTH, 1);
		// 再减一天，获得指定月份最后一天
		cDate.add(Calendar.DATE, -1);
		Date tjsj2 = DateHelper.getEndDate(cDate.getTime());
		
		return DateHelper.formateDate(tjsj1, "yyyy-MM-dd") +  spe + DateHelper.formateDate(tjsj2, "yyyy-MM-dd");
	}

	/**
	 * 对URL进行编码的方法，用于将URL作为参数进行传递。
	 * @param url	需要进行URL编码的字符串。
	 * @return		返回url的URL编码字符串。
	 */
	public static String getEncodeURL(String url) {
		try {
			return java.net.URLEncoder.encode(url, "UTF-8");
		} catch (Exception ex) {
			return url;
		}
	}

	/**
	 * 和getEncodeURL方法相反，这里对URL进行解码，以还原为真正的URL。
	 * @param url	编码的URL字符串。
	 * @return		对url进行URL解码，还原真正的URL字符串。
	 */
	public static String getDecodeURL(String url) {
		try {
			return java.net.URLDecoder.decode(url, "UTF-8");
		} catch (Exception ex) {
			return url;
		}
	}

	/**
	 * 将:v=p[&v2=p2]的格式解析成MAP。
	 * @param param		符合“v=p[&v2=p2]”格式的字符串，例如p1=a&p2=b&p3=c
	 * @return			返回Map对象，key包含了所有的参数名，对应的值为参数值。
	 */
	public static Map<String,String> getParameterMap(String param) {
		Map<String,String> parmMap = new HashMap<String,String>();
		if(CommonUtil.isEmpty(param))
			return parmMap;
		
		String[] temp = param.split("&");
		// 保存字典参数<String,String>
		for (int i = 0; i < temp.length; i++) {
			String[] parm = temp[i].split("=");
			if (parm.length == 2) {
				String parmName = parm[0];
				String parmValue = parm[1];
				parmMap.put(parmName, parmValue);
			}
		}

		return parmMap;
	}

	/**
	 * 更具指定的Class和属性名，获取属性数据类型。
	 * 
	 * @param c				要获取属性数据类型的对象c
	 * @param propertyName	对象c的属性名称
	 * @return				返回对象c的属性propertyName的数据类型名称，例如“java.lang.String”。
	 */
	public static String getPropertyTypeName(Class<?> c, String propertyName) {
		BeanWrapper bw = null;
		String pClass = null;

		try {
			bw = new BeanWrapperImpl(c);
			PropertyDescriptor pd = bw.getPropertyDescriptor(propertyName);
			if (pd == null)
				return null;

			pClass = pd.getPropertyType().getName();
		} catch (Exception e) {
			;
		}

		return pClass;
	}

	/**
	 * 取得系统时间的统一入口方法
	 * 
	 * @return	返回系统当前时间java.util.Date
	 */
	public static Date getSysDate() {
		// TODO 要修改成从同一个地方获取日期时间
		return new Date();
	}

	/**
	 * 
	 * @param beanProperty
	 * @return
	 */
	public static String getGetMethodByName(String beanProperty) {
		if (null == beanProperty || "".equals(beanProperty)) {
			throw new RuntimeException("根据属性名称得到该属性的GET方法名称时传入的属性名称参数不能为空");
		}
		return "get"
				+ beanProperty.replaceFirst(beanProperty.substring(0, 1),
						beanProperty.substring(0, 1).toUpperCase());
	}

	/**
	 * 根据属性名称得到其set方法全名
	 * @param beanProperty
	 * @return
	 */
	public static String getSetMethodByName(String beanProperty) {
		if (null == beanProperty || "".equals(beanProperty)) {
			throw new RuntimeException("根据属性名称得到该属性的SET方法名称时传入的属性名称参数不能为空");
		}
		return "set"
				+ beanProperty.replaceFirst(beanProperty.substring(0, 1),
						beanProperty.substring(0, 1).toUpperCase());
	}

	/**
	 * 判断字符串s是否不为空。
	 * @param s	需要判断空值的字符串。
	 * @return	
	 * false	字符串s为null或者长度为0<BR>
	 * true		字符串s不为null，并且长度大于0<BR>
	 */
	public static final boolean isNotEmpty(String s) {
		return s != null && s.length() > 0;
	}

	/**
	 * 判断集合collection不为空。
	 * @param collection	需要判断不为空的集合collection。
	 * @return
	 * true		集合不为null,并且长度大于0.<br>
	 * false	集合为nll，或者长度等于0。
	 */
	public static final boolean isNotEmpty(Collection<?> collection) {
		return collection != null && collection.size() > 0;
	}

	/**
	 * 判断某字符串s是否为空，和isNotEmpty(String s)相反。
	 * @param s
	 * @return
	 */
	public static final boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	/**
	 * 判断集合是否为空，和isNotEmpty(Collection collection)相反。
	 * @param collection
	 * @return
	 */
	public static final boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.size() == 0;
	}

	/**
	 * 取出集合中的第一个记录并且返回！
	 * 
	 * @param collection	需要操作的集合
	 * @return Object		如果集合不为空，那么返回第一个对象，否则返回null。
	 */
	public static final Object getPrimacyByCollection(Collection<?> collection) {
		if (isNotEmpty(collection)) {
			return collection.iterator().next();
		}
		return null;
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
	public static Object copyInfo(Object fromObj, Object toObj, String[] fields) {
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
					toBwp.setPropertyValue(field, fromBwp.getPropertyValue(field));
				}
			}
		}
		
		return toObj;
	}

	public static Object copyInfo(Object obj, String[] fields, Map map, HttpServletRequest request) throws Exception{
		BeanWrapper bwp = new BeanWrapperImpl(obj);		
		DateConverter dc = new DateConverter();
		if(fields!=null){
			for(int i=0;i<fields.length;i++){
				String value = null;
				if(map!=null)
					value = map.containsKey(fields[i])?map.get(fields[i]).toString():null;
				else
					value = request.getParameter(fields[i]);
				
				if(CommonUtil.isNotEmpty(value) && bwp.isWritableProperty(fields[i])){
					Class<?> type = bwp.getPropertyDescriptor(fields[i]).getPropertyType();
					
					if(type.equals(String.class))
						bwp.setPropertyValue(fields[i], value);
					else if(type.equals(Integer.class))
						bwp.setPropertyValue(fields[i], new Integer(value));
					else if(type.equals(Long.class))
						bwp.setPropertyValue(fields[i], new Long(value));
					else if(type.equals(Double.class))
						bwp.setPropertyValue(fields[i], Double.valueOf(value));					
					else if(type.equals(Date.class))
						bwp.setPropertyValue(fields[i], dc.convert(null, value));
				}
			}
		}else{
			PropertyDescriptor[] p = bwp.getPropertyDescriptors();
			for(int i=0;i<p.length;i++){
				String field = p[i].getName();
				String value = null;
				if(map!=null)
					value = map.containsKey(field)?map.get(field).toString():null;
				else
					value = request.getParameter(field);
				
				
				if(CommonUtil.isNotEmpty(value) && bwp.isWritableProperty(field)){
					Class<?> type  = p[i].getPropertyType();
					if(type.equals(String.class))
						bwp.setPropertyValue(field, value);
					else if(type.equals(Integer.class))
						bwp.setPropertyValue(field, new Integer(value));
					else if(type.equals(Long.class))
						bwp.setPropertyValue(field, new Long(value));
					else if(type.equals(Double.class))
						bwp.setPropertyValue(field, Double.valueOf(value));
					else if(type.equals(Date.class))
						bwp.setPropertyValue(field, dc.convert(null, value));
				}
			}
		}
		
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T copyInfo(Class<T> cls,  String[] fields, HttpServletRequest request) throws Exception{
		T obj = cls.newInstance();
		obj = (T)copyInfo(obj,fields,null,request);
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T copyInfo(Class<T> cls,  String[] fields, Map map) throws Exception{
		T obj = cls.newInstance();
		obj = (T)copyInfo(obj,fields,map,null);
		return obj;
	}

	/**
	 * 创建类型c的对象，并且将obj中相同的属性名拷贝到该对象中。
	 * 
	 * @param c
	 *            需要返回的对象类型
	 * @param obj
	 *            源对象
	 * @return 返回类型为c的对象
	 * @throws Exception
	 */
	static public Object copyObject(Class<?> c, Object obj) {
		try {
			Object dObj = c.newInstance();
			BeanUtils.copyProperties(dObj, obj);
			return dObj;
		} catch (Exception e) {
			throw new ServiceException("将对象" + obj.getClass().getName() + "拷贝为"
					+ c.getName() + "失败：" + e.toString());
		}
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
	
	private static Map<String, PropertyDescriptor> getPropertyDescriptors(Class<?> clazz) {
		Map<String, PropertyDescriptor> rs = new HashMap<String, PropertyDescriptor>();
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			
			for(PropertyDescriptor pd : pds) {
				rs.put(pd.getName(), pd);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	static private Map<String,String[]> objFieldsMap = new HashMap<String,String[]>();
	static private Map<String,Map<String,String>> resFieldsMap = new HashMap<String,Map<String,String>>();
	
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
					String colname = meta.getColumnName(i);
					map.put(HibernateTool.columnToPropertyName(colname), colname);
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
					if(type.equals(String.class))
						writeMethod.invoke(obj, res.getString(colname));
					else if(type.equals(Integer.class)){
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
					}
				}				
			}
		}catch(Exception e) {
			success = false;
			logger.warn("复制属性出错：", e);
		}
		
		return success;
	}
}
