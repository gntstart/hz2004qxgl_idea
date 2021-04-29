package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*瑙掕壊鍒跺紡鎶ヨ〃鏉冮檺琛�
*/
public class XtJszsbbqxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*鍒跺紡鎶ヨ〃鏉冮檺ID
	*/
	private String	zsbbqxid;
	/*
	*瑙掕壊ID
	*/
	private String	jsid;
	/*
	*鍒跺紡鎶ヨ〃妯℃澘ID
	*/
	private String	zsbbmbid;

	private String dqbm;
	
	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getZsbbqxid(){
		return this.zsbbqxid;
	}

	public void setZsbbqxid(String zsbbqxid){
		this.zsbbqxid=zsbbqxid;
	}

	public String getJsid(){
		return this.jsid;
	}

	public void setJsid(String jsid){
		this.jsid=jsid;
	}

	public String getZsbbmbid(){
		return this.zsbbmbid;
	}

	public void setZsbbmbid(String zsbbmbid){
		this.zsbbmbid=zsbbmbid;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}