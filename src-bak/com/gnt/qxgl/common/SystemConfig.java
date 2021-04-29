package com.gnt.qxgl.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;
import org.apache.log4j.Logger;

public class SystemConfig {
	/**
	 * 存储conf/system-conf配置值对
	*/
	private static Map hSysteConfig = new HashMap();
	
	public static Set exclude_url = new HashSet();
	private static Map hMimeType = new HashMap();
	static Logger logger = Logger.getLogger (SystemConfig.class);
	private static Map<String,String> hJdbcConfig = new HashMap<String,String>();

	private static PropertyResourceBundle prb = null;
	public static String CharSet = getSystemConfig("filterCharacterEncoding");
	
	/**
	 * 将map里面的键值对加入到系统配置
	 * @param map
	 */
	static public void loadMap(Map map){
		hSysteConfig.putAll(map);
		initExcludeURL();
	}
	
	static public void initExcludeURL(){
		//初始化不需要用户登陆的URL
		String temp = getSystemConfig("exclude_url");
		if(temp!=null){
			String[] _exclude_url = temp.split(",");
			for(int i=0;i<_exclude_url.length;i++){
				if(_exclude_url[i]!=null || !"".equals(_exclude_url[i]))
					exclude_url.add(_exclude_url[i]);
			}
		}
	}
	
	static {		
		try{
			//将配置文件缓存
			prb = (PropertyResourceBundle)ResourceBundle.getBundle("conf/system-conf");
			for(Enumeration e=prb.getKeys();e.hasMoreElements();){
				String key = (String)e.nextElement();
				hSysteConfig.put(key, prb.getObject(key));
			}
			
			prb = (PropertyResourceBundle) ResourceBundle.getBundle("conf/jdbc");
			for (Enumeration<?> e = prb.getKeys(); e.hasMoreElements();) {
				String key = (String) e.nextElement();
				hJdbcConfig.put(key, (String)prb.getObject(key));
			}
			
			//初始化不需要用户登陆的URL
			initExcludeURL();
			
			String charset = getSystemConfig("filterCharacterEncoding");
			if(charset==null || "".equals(charset))
				CharSet = "UTF-8";
			else
				CharSet = charset;
			
			logger.info(getSystemConfig("sso-project-name") + "读取字符集设置:" + CharSet);
		}catch(Exception ex){
			logger.fatal("严重错误，加载系统关键配置失败：", ex);
		}
	}
	
	public static String getMimeType(String ext){
		return (String)hMimeType.get(ext);
	}
	
	/**
	 * 从/conf/system-conf配置文件中获取一个指定的键值key
	 * @param key	配置文件/conf/system-conf.properties中定义的key名称
	 * @return		返回key对应得值
	 */
	public static String getSystemConfig(String key){
		if(hSysteConfig.containsKey(key))
			return (String)hSysteConfig.get(key);
		
		return null;
	}
	
	public static String getSystemConfig(String key,String def){
		if(hSysteConfig.containsKey(key))
			return (String)hSysteConfig.get(key);
		
		return def;
	}
	
	public static String getJdbcConfig(String key) {
		if (hJdbcConfig.containsKey(key))
			return (String) hJdbcConfig.get(key);

		return null;
	}
}