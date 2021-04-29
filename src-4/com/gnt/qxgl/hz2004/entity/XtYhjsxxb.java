package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*鐢ㄦ埛瑙掕壊淇℃伅琛�
*/
public class XtYhjsxxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*鐢ㄦ埛瑙掕壊ID
	*/
	private String	yhjsid;
	/*
	*鐢ㄦ埛ID
	*/
	private String	yhid;
	/*
	*瑙掕壊ID
	*/
	private String	jsid;

	private String dqbm;
	
	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getYhjsid(){
		return this.yhjsid;
	}

	public void setYhjsid(String yhjsid){
		this.yhjsid=yhjsid;
	}

	public String getYhid(){
		return this.yhid;
	}

	public void setYhid(String yhid){
		this.yhid=yhid;
	}

	public String getJsid(){
		return this.jsid;
	}

	public void setJsid(String jsid){
		this.jsid=jsid;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}