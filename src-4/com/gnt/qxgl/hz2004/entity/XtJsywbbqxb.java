package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*瑙掕壊涓氬姟鎶ヨ〃鏉冮檺琛�
*/
public class XtJsywbbqxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*涓氬姟鎶ヨ〃鏉冮檺ID
	*/
	private String	ywbbqxid;
	/*
	*瑙掕壊ID
	*/
	private String	jsid;
	/*
	*涓氬姟鎶ヨ〃ID
	*/
	private String	ywbbid;

	private String dqbm;
	
	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}
	public String getYwbbqxid(){
		return this.ywbbqxid;
	}

	public void setYwbbqxid(String ywbbqxid){
		this.ywbbqxid=ywbbqxid;
	}

	public String getJsid(){
		return this.jsid;
	}

	public void setJsid(String jsid){
		this.jsid=jsid;
	}

	public String getYwbbid(){
		return this.ywbbid;
	}

	public void setYwbbid(String ywbbid){
		this.ywbbid=ywbbid;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}