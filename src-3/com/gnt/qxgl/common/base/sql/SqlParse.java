package com.gnt.qxgl.common.base.sql;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gnt.qxgl.common.base.MVEL;
import com.gnt.qxgl.common.base.TemplateUtil;

public class SqlParse 
{
	private static Logger logger = LoggerFactory.getLogger(SqlParse.class);
	
	private String osql;
	private Map<String, Object> oparams = new HashMap<String, Object>();

	public SqlParse(String sql){
		this.osql = sql;
	}

	public SqlParse bind(String key, Object param) {
		this.oparams.put(key, param);
		return this;
	}

	public SqlParse bind(Map<String,Object> paramMap) {
		if(paramMap==null)
			paramMap = new HashMap<String,Object>();
		
		this.oparams.putAll(paramMap);
		return this;
	}
	
	public SqlParam parse() {
		try {
			VelocityContext velocityContext = new VelocityContext(oparams);
			velocityContext.put("ut", new TemplateUtil());
			StringWriter sw = new StringWriter();
			Velocity.evaluate(velocityContext, sw, "LOG", osql);
			SqlParam sq = parseParam(sw.toString());
			
			System.out.println(sq.getSql());
			int i = 0;
			for(Object o:sq.getParams()){
				System.out.println(i + ":" + o);
				i++;
			}
			
			return sq;
		} catch (Exception e) {
			logger.error("解析sql[{}]发生错误", osql, e);
			throw new RuntimeException("解析sql发生错误");
		}		
	}
	
	private SqlParam parseParam(String str)
	{
		List<Object> po = new ArrayList<Object>();
		Pattern pattern = Pattern.compile(":([a-z_0-9A-Z\\.\\[\\]%]+)");
		logger.debug(str);
		Matcher m = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while(m.find())
		{
			po.add(getParmenterValue(m.group(1)));
			m.appendReplacement(sb, "?");
		}
		m.appendTail(sb);		
		return new SqlParam(sb.toString(), po);
	}

	private Object getParmenterValue(String parmenterName){
		Object value = null;
		if (parmenterName.matches("^(?:(?:%\\w+)|(?:\\w+%)|(?:%\\w+%))$")) {
			Matcher parmenterKeyMatcher = Pattern.compile("^%*(\\w+)%*$").matcher(parmenterName);
			if (parmenterKeyMatcher.matches()) {
				String parmenterKey = parmenterKeyMatcher.group(1);
				//System.out.println("getParmenterValue() : " + parmenterKey);
				value = parmenterName.replace(parmenterKey, MVEL.eval(parmenterKey, oparams).toString());
			}
		} else {
			value = MVEL.eval(parmenterName, oparams);
		}
		logger.debug(parmenterName+"\t:\t"+value);
		return value;
	}
	
}

