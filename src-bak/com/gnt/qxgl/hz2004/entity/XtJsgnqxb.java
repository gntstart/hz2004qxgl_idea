package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*瑙掕壊鍔熻兘鏉冮檺琛�
*/
public class XtJsgnqxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*瑙掕壊鍔熻兘ID
	*/
	private String	jsgnid;
	/*
	*瑙掕壊ID
	*/
	private String	jsid;
	/*
	*鍔熻兘ID
	*/
	private String	gnid;

	private String dqbm;
	
	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getJsgnid(){
		return this.jsgnid;
	}

	public void setJsgnid(String jsgnid){
		this.jsgnid=jsgnid;
	}

	public String getJsid(){
		return this.jsid;
	}

	public void setJsid(String jsid){
		this.jsid=jsid;
	}

	public String getGnid(){
		return this.gnid;
	}

	public void setGnid(String gnid){
		this.gnid=gnid;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}