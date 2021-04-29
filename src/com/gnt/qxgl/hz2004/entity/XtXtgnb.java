package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*绯荤粺鍔熻兘琛�
*/
public class XtXtgnb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*鍔熻兘ID
	*/
	private String	gnid;
	/*
	*鍔熻兘缂栧彿
	*/
	private String	gnbh;
	/*
	*鍔熻兘鍚嶇О
	*/
	private String	gnmc;
	/*
	*鍔熻兘绫诲瀷
	*/
	private String	gnlx;
	/*
	*鍚敤鏍囧織
	*/
	private String	qybz;

	private String dqbm;
	
	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getGnid(){
		return this.gnid;
	}

	public void setGnid(String gnid){
		this.gnid=gnid;
	}

	public String getGnbh(){
		return this.gnbh;
	}

	public void setGnbh(String gnbh){
		this.gnbh=gnbh;
	}

	public String getGnmc(){
		return this.gnmc;
	}

	public void setGnmc(String gnmc){
		this.gnmc=gnmc;
	}

	public String getGnlx(){
		return this.gnlx;
	}

	public void setGnlx(String gnlx){
		this.gnlx=gnlx;
	}

	public String getQybz(){
		return this.qybz;
	}

	public void setQybz(String qybz){
		this.qybz=qybz;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}