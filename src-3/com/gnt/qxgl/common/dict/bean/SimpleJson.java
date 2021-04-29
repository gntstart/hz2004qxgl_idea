package com.gnt.qxgl.common.dict.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用的JSON对象
 * @author Administrator
 *
 */
public class SimpleJson  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private boolean success;
	private Map<String,String> errors = new HashMap<String,String>();
	private String result;
	private String message;
	private List<Map<String,String>> list = null;
	private int totalCount;
	public List<Map<String, String>> getList() {
		return list;
	}
	
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public void addValidation(String pname,String error){
		if(pname==null || error==null) return;
		if(errors==null) errors = new HashMap<String,String>();
		success = false;
		errors.put(pname, error);
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
