package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*灞呭浼氫俊鎭〃
*/
public class XtJwhxxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*浠ｇ爜
	*/
	private String	dm;
	/*
	*鍚嶇О
	*/
	private String	mc;
	/*
	*涓枃鎷奸煶
	*/
	private String	zwpy;
	/*
	*浜旂瑪鎷奸煶
	*/
	private String	wbpy;
	/*
	*鍗曚綅浠ｇ爜
	*/
	private String	dwdm;
	/*
	*涔￠晣琛楅亾浠ｇ爜
	*/
	private String	xzjddm;
	/*
	*澶囨敞
	*/
	private String	bz;
	/*
	*鍚敤鏍囧織
	*/
	private String	qybz;
	/*
	*鍙樺姩绫诲瀷
	*/
	private String	bdlx;
	/*
	*鍙樺姩鏃堕棿
	*/
	private String	bdsj;

	public XtJwhxxb(){}


	public XtJwhxxb(String dm,
			String mc,
			String zwpy,
			String wbpy,
			String dwdm,
			String xzjddm,
			String bz,
			String qybz,
			String bdlx,
			String bdsj)
	{
		this.dm=dm;
		this.mc=mc;
		this.zwpy=zwpy;
		this.wbpy=wbpy;
		this.dwdm=dwdm;
		this.xzjddm=xzjddm;
		this.bz=bz;
		this.qybz=qybz;
		this.bdlx=bdlx;
		this.bdsj=bdsj;
	}

	public String getDm(){
		return this.dm;
	}

	public void setDm(String dm){
		this.dm=dm;
	}

	public String getMc(){
		return this.mc;
	}

	public void setMc(String mc){
		this.mc=mc;
	}

	public String getZwpy(){
		return this.zwpy;
	}

	public void setZwpy(String zwpy){
		this.zwpy=zwpy;
	}

	public String getWbpy(){
		return this.wbpy;
	}

	public void setWbpy(String wbpy){
		this.wbpy=wbpy;
	}

	public String getDwdm(){
		return this.dwdm;
	}

	public void setDwdm(String dwdm){
		this.dwdm=dwdm;
	}

	public String getXzjddm(){
		return this.xzjddm;
	}

	public void setXzjddm(String xzjddm){
		this.xzjddm=xzjddm;
	}

	public String getBz(){
		return this.bz;
	}

	public void setBz(String bz){
		this.bz=bz;
	}

	public String getQybz(){
		return this.qybz;
	}

	public void setQybz(String qybz){
		this.qybz=qybz;
	}

	public String getBdlx(){
		return this.bdlx;
	}

	public void setBdlx(String bdlx){
		this.bdlx=bdlx;
	}

	public String getBdsj(){
		return this.bdsj;
	}

	public void setBdsj(String bdsj){
		this.bdsj=bdsj;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}