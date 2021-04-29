package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*瑙掕壊鑿滃崟鏉冮檺琛�
*/
public class XtJscdqxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*瑙掕壊鑿滃崟ID
	*/
	private String	jscdid;
	/*
	*瑙掕壊ID
	*/
	private String	jsid;
	/*
	*鍔熻兘鑿滃崟ID
	*/
	private String	gncdid;

	private String dqbm;
	
	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getJscdid(){
		return this.jscdid;
	}

	public void setJscdid(String jscdid){
		this.jscdid=jscdid;
	}

	public String getJsid(){
		return this.jsid;
	}

	public void setJsid(String jsid){
		this.jsid=jsid;
	}

	public String getGncdid(){
		return this.gncdid;
	}

	public void setGncdid(String gncdid){
		this.gncdid=gncdid;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}