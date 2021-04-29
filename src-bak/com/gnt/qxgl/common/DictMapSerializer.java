package com.gnt.qxgl.common;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.gnt.qxgl.common.dict.bean.Code;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DictMapSerializer implements JsonSerializer<List<Map<String,List<Code>>>>{
	public JsonElement serialize(List<Map<String, List<Code>>> value, Type type,
			JsonSerializationContext context) {
		
		return new JsonPrimitive(value.toString());
	}
}
