package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*瑙掕壊淇℃伅琛�
*/
public class XtJsxxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*瑙掕壊ID
	*/
	private String	jsid;
	/*
	*瑙掕壊鍚嶇О
	*/
	private String	jsmc;
	/*
	*鎻忚堪
	*/
	private String	ms;

	private String dqbm;
	
	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getJsid(){
		return this.jsid;
	}

	public void setJsid(String jsid){
		this.jsid=jsid;
	}

	public String getJsmc(){
		return this.jsmc;
	}

	public void setJsmc(String jsmc){
		this.jsmc=jsmc;
	}

	public String getMs(){
		return this.ms;
	}

	public void setMs(String ms){
		this.ms=ms;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}