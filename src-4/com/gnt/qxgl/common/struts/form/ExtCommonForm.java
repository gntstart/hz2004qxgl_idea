package com.gnt.qxgl.common.struts.form;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;

import com.gnt.qxgl.bean.SysCode;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.dict.bean.Code;
import com.gnt.qxgl.common.util.DateHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;
import com.hzjc.hz2004.po.PoHJYW_QCZXXXB;

/**
 * EXT专用的Form基类，EXT和后台action的交互默认都以该实体进行，前台提交的数据
 * 以data作为参数提交到后台的FORM。后台的数据将改对象本身的JSON字符串写入到输出
 * 流
 */
public class ExtCommonForm extends CommonForm {	
	static public final String JSON = "_json_";
	
	private static final long serialVersionUID = 1L;
	
	/**
	 *客户端提交的json数据 
	 */
	private String data = null;
	
	/**
	 * 错误校验集合：KEY=错误
	 */
	private Map<String,String> errors = new HashMap<String,String>();
	
	/**
	 * EXT通用的消息提示信
	 */
	private List<String> messages = new ArrayList<String>();
	
	/**
	 * EXT通用的远程调用成功标
	 */
	private boolean success = true;
	
	/**
	 * 格式化日期的时候的模式
	 */
	private String dateStyle = DateHelper.PRINT_DATETIME_STYLE2;
	
	/**
	 * EXT通用的Store的分页数据内
	 */
	@SuppressWarnings("unchecked")
	private List list;														//当前页的记录
	private List<Map<String,List<Code>>> dictList; 	//字典翻译记录和list对应，MAP[KEY=字段名，VALUE=选择值列表]
	private Map<String,List<SysCode>> dictMap = null;
	
	public Map<String, List<SysCode>> getDictMap() {
		return dictMap;
	}

	public void setDictMap(Map<String, List<SysCode>> dictMap) {
		this.dictMap = dictMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Map<String, List<Code>>> getDictList() {
		return dictList;
	}

	public void setDictList(List<Map<String, List<Code>>> dictList) {
		this.dictList = dictList;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	private int totalCount;			//总记录数
	private String other;				//其它数据
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		reset();
		super.reset(mapping, request);
	}
	
	public void reset(){
		list = null;
		errors = null;
		messages = null;
		totalCount = 0;
		data = null;
		success = true;
	}
	
	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 将data转换成指定的对象
	 * @param <E>
	 * @param e
	 * @return
	 */
	public <T> List<T> getJsonData(TypeToken<List<T>> toKen){
		if(data==null) return null;
		
		GsonBuilder build = new GsonBuilder().serializeNulls();
		build.setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
		
		Gson gson = build.create();
		
		List<T> ex = gson.fromJson(data, toKen.getType());
		return ex;
	}
	
	static public <T> List<T> getJsonData(TypeToken<List<T>> toKen,String postData){
		if(postData==null) return null;
		GsonBuilder build = new GsonBuilder().serializeNulls();
		build.setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
		
		Gson gson = build.create();
		
		List<T> ex = gson.fromJson(postData, toKen.getType());

		return ex;
	}
	
	public <T> T getJsonData(Class<T> classOfT){
		return getJsonData(data, this.dateStyle, classOfT);
	}
	
	static public <T> T getJsonData(String jsonString, String dateStyle, Class<T> classOfT){
		GsonBuilder build = new GsonBuilder().serializeNulls();
		build.setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
		if(dateStyle != null) {
			build.setDateFormat(dateStyle);
		}
		
		Gson gson = build.create();
		return gson.fromJson(jsonString, classOfT);
	}
	
	public <T> T getJsonData(String jsonString,Class<T> classOfT){
		GsonBuilder build = new GsonBuilder().serializeNulls();
		build.setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
		if(this.dateStyle != null) {
			build.setDateFormat(this.dateStyle);
		}
		
		Gson gson = build.create();
		return gson.fromJson(jsonString, classOfT);
	}
	
	/**
	 * 将对象转换为json字符
	 * @param src
	 * @return
	 */
	public String getJson(Object src){
		GsonBuilder build = new GsonBuilder().serializeNulls();
		build.setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
		if(this.dateStyle != null) {
			build.setDateFormat(this.dateStyle);
		}
		
		Gson gson = build.create();
		return gson.toJson(src);
	}
	
	static public String toJson(Object src){
		//GsonBuilder build = new GsonBuilder().serializeNulls();  //序列化null值
		GsonBuilder build = new GsonBuilder();
		build.setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
		Gson gson = build.create();
		return gson.toJson(src);
	}
	
	public String getJson(){
		GsonBuilder build = new GsonBuilder().serializeNulls();
		build.setLongSerializationPolicy(LongSerializationPolicy.STRING).create();

		if(this.dateStyle != null) {
			build.setDateFormat(this.dateStyle);
		}
		Gson gson = build.create();
		
		return gson.toJson(this);
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 非常重要，当保存的实体是分页的时候，将分页信息保存到form中，以统显示
	 * @param entity
	 */
	@SuppressWarnings("unchecked")
	public void setEntity(Object entity) {
		if(entity instanceof Page){
			Page  page = (Page)entity;
			list = page.getList();
			totalCount = 0;
			if(list!=null){
				totalCount = page.getTotalCount();
			}else{
				list = new ArrayList<Object>();
			}
			
			return;
		}
		
		if(entity instanceof List){
			list = (List)entity;
			totalCount = list.size();
			return;
		}
		
		list = new ArrayList();
		list.add(entity);
		totalCount = 1;
	}
	
	/**
	 * form方式提交的数据校验提
	 * @param pname	字段名，通常为属性名
	 * @param error	错误消息
	 */
	public void addValidation(String pname,String error){
		if(pname==null || error==null) return;
		if(errors==null) errors = new HashMap<String,String>();
		success = false;
		errors.put(pname, error);
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	public String getDateStyle() {
		return dateStyle;
	}

	public void setDateStyle(String dateStyle) {
		this.dateStyle = dateStyle;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String argc[]){
		ExtCommonForm f = new ExtCommonForm();
		f.setDictList(new ArrayList<Map<String,List<Code>>>());
		Map<String,List<Code>> m = new HashMap<String,List<Code>>();
		f.getDictList().add(m);
		List<Code> l = new ArrayList<Code>();
		Code c1 = new Code();
		Code c2 = new Code();
		c1.setCode("c1");
		c1.setName("name1");
		c2.setCode("c2");
		c2.setName( "name2");
		l.add(c1);
		l.add(c2);
		m.put("R", l);
		
		//3401000001002274815
		PoHJYW_QCZXXXB b = new PoHJYW_QCZXXXB();
		b.setHjywid(3401000001002274815l);
		
		GsonBuilder build = new GsonBuilder();
		build.setLongSerializationPolicy(LongSerializationPolicy.STRING).create();

		Gson gson = build.create();
		String str = gson.toJson(b);
		
		System.out.println(str);
		
		PoHJYW_QCZXXXB t = gson.fromJson(str, PoHJYW_QCZXXXB.class);
		System.out.println(t.getHjywid());
	}
}
