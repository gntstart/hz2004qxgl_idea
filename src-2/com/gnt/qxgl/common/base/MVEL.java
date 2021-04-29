package com.gnt.qxgl.common.base;

import java.util.Map;

import org.mvel2.MVELInterpretedRuntime;
import org.mvel2.MVELRuntime;

public class MVEL {
	public static Object eval(String expression,Map<String,Object> vars){
		return new MVELInterpretedRuntime(expression, vars, MVELRuntime.IMMUTABLE_DEFAULT_FACTORY).parse();
	}
	
}
