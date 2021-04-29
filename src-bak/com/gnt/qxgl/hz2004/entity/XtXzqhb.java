package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*琛屾斂鍖哄垝琛�
*/
public class XtXzqhb implements Serializable{
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

	public XtXzqhb(){}


	public XtXzqhb(String dm,
			String mc,
			String zwpy,
			String wbpy,
			String bz,
			String qybz,
			String bdlx,
			String bdsj)
	{
		this.dm=dm;
		this.mc=mc;
		this.zwpy=zwpy;
		this.wbpy=wbpy;
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