package com.gnt.qxgl.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gnt.qxgl.hz2004.entity.XT_SJPZB;

public class SjpzBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Map<String,List<XT_SJPZB>> pzMap;
	private Map<String,List<SysCode>> dictMap;
	
	public Map<String, List<XT_SJPZB>> getPzMap() {
		return pzMap;
	}
	public void setPzMap(Map<String, List<XT_SJPZB>> pzMap) {
		this.pzMap = pzMap;
	}
	public Map<String, List<SysCode>> getDictMap() {
		return dictMap;
	}
	public void setDictMap(Map<String, List<SysCode>> dictMap) {
		this.dictMap = dictMap;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
