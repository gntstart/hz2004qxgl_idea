package com.gnt.qxgl.common.base;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;

import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.util.CommonUtil;

public class Config {
	private static final Logger logger = Logger.getLogger(Config.class); 
	private static final String DEF_CONFNAME = "/conf/sql-segment.xml";
	
	static Map<String,XMLConfiguration> sqlconf = new HashMap<String,XMLConfiguration>();
	
	static {
		XMLConfiguration.setDefaultListDelimiter('~');
	}
	
	private static Configuration getSqlConfiguration(String config_name){
		if(CommonUtil.isEmpty(config_name))
			config_name = DEF_CONFNAME;
		
		if(!config_name.equals(DEF_CONFNAME)){
			if(!config_name.startsWith("/conf/segment")){
				config_name = "/conf/segment/" + config_name;
			}
		}
		
		if(!config_name.endsWith(".xml")){
			config_name = config_name  + ".xml";
		}
		
		XMLConfiguration conf = sqlconf.get(config_name);
		if(conf!=null)
			return conf;
		
		try{
			FileChangedReloadingStrategy f = new FileChangedReloadingStrategy();
			//f.setRefreshDelay(1000);
			conf = new XMLConfiguration(Config.class.getResource(config_name));
		    conf.setReloadingStrategy(f);
		    
		    sqlconf.put(config_name, conf);
		}catch(Exception e){
				logger.error("加载" + config_name + "文件出现错误！",e);
		}

		return conf;
	}
	
	public static String getSql(String configName, String key){
		Configuration config = Config.getSqlConfiguration(configName);
		if(config==null)
			return null;
		
		String sql = config.getString(key);
		return sql;
	}
	
	public static String getSql(String key){
		String sql = Config.getSqlConfiguration(null).getString(key);
		return sql;
	}
	
	public static void main(String[] args){
		System.out.println("----d--");
		String hql = getSqlConfiguration(null).getString("queryLgzhcs");
		SqlParam param = new SqlParse(hql).bind("lgbm", "value : ajjzid").parse();
		System.out.println(param.getSql());
		for (Object obj : param.getParams()) {
			System.out.println(obj.toString());
		}
	}
}
