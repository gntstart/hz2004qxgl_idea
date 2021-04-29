package com.gnt.qxgl.common.base;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.util.CommonUtil;

public class Config {
	private static final Logger logger = LoggerFactory.getLogger(Config.class); 
	
	static XMLConfiguration sqlconf;
	
	static {
		XMLConfiguration.setDefaultListDelimiter('~');
		sqlconf = null;
	}
	
	public static Configuration getSqlConfiguration(){
		if(sqlconf == null){
			try{
				sqlconf = new XMLConfiguration(Config.class.getResource("/conf/sql-segment.xml"));
				sqlconf.setReloadingStrategy(new FileChangedReloadingStrategy());
			}catch(Exception e){
				logger.error("/conf/sql-segment.xml文件出现错误！",e);
			}
		}
		return sqlconf;
	}
	
	public static String getSql(String key){
		assert CommonUtil.isNotEmpty(key);
		return Config.getSqlConfiguration().getString(key);
	}
	
	public static void main(String[] args){
		System.out.println("----d--");
		String hql = getSqlConfiguration().getString("queryRyzl");
		SqlParam param = new SqlParse(hql).bind("ajjzid", "value : ajjzid").parse();
		System.out.println(param.getSql());
		for (Object obj : param.getParams()) {
			System.out.println(obj.toString());
		}
	}
}
