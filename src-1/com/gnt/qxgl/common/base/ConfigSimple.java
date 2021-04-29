package com.gnt.qxgl.common.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.util.CommonUtil;

/**
 * 单文件配置，
<?xml version="1.0" encoding="UTF-8"?>
<sql>
  <config>
  	配置内容
  </config>
</sql>
 * @author ting_it
 *
 */
public class ConfigSimple {	
	static private Map<String,XMLConfiguration> mapConfig = new HashMap<String,XMLConfiguration>();
	
	static {
		XMLConfiguration.setDefaultListDelimiter('~');
	}
	
	public static String getSqlConfiguration(String configName,String optype){
		XMLConfiguration sqlconf = mapConfig.get(configName);
		if(sqlconf == null){
			String filename = "/conf/sql/template/" + configName;
			try{
				sqlconf = new XMLConfiguration(ConfigSimple.class.getResource(filename));
				sqlconf.setReloadingStrategy(new FileChangedReloadingStrategy());
				mapConfig.put(configName, sqlconf);
			}catch(Exception e){
				throw new ActionException("加载" + filename + "文件出现错误！",e);
			}
		}
		
		if(sqlconf!=null)
			return sqlconf.getString(optype);
		
		return "";
	}
	
	
	public static void main(String[] args){
		String hql = getSqlConfiguration("simple.xml","config");
		SqlParam param = new SqlParse(hql).bind("ajjzid", "value : ajjzid").parse();
		System.out.println(param.getSql());
		
		for (Object obj : param.getParams()) {
			System.out.println(obj.toString());
		}
	}
}
