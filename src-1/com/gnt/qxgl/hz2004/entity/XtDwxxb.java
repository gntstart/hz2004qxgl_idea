package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*鍗曚綅淇℃伅琛�
*/
public class XtDwxxb implements Serializable{
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
	*鍗曚綅鏈烘瀯浠ｇ爜
	*/
	private String	dwjgdm;
	/*
	*鍖哄垝浠ｇ爜
	*/
	private String	qhdm;
	/*
	*鍗曚綅绾у埆
	*/
	private String	dwjb;
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
	/*
	*鍒嗗眬鏈烘瀯浠ｇ爜
	*/
	private String	fjjgdm;
	/*
	*鍒嗗眬鏈烘瀯鍚嶇О
	*/
	private String	fjjgmc;

	public XtDwxxb(){}


	public XtDwxxb(String dm,
			String mc,
			String zwpy,
			String wbpy,
			String dwjgdm,
			String qhdm,
			String dwjb,
			String bz,
			String qybz,
			String bdlx,
			String bdsj,
			String fjjgdm,
			String fjjgmc)
	{
		this.dm=dm;
		this.mc=mc;
		this.zwpy=zwpy;
		this.wbpy=wbpy;
		this.dwjgdm=dwjgdm;
		this.qhdm=qhdm;
		this.dwjb=dwjb;
		this.bz=bz;
		this.qybz=qybz;
		this.bdlx=bdlx;
		this.bdsj=bdsj;
		this.fjjgdm=fjjgdm;
		this.fjjgmc=fjjgmc;
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

	public String getDwjgdm(){
		return this.dwjgdm;
	}

	public void setDwjgdm(String dwjgdm){
		this.dwjgdm=dwjgdm;
	}

	public String getQhdm(){
		return this.qhdm;
	}

	public void setQhdm(String qhdm){
		this.qhdm=qhdm;
	}

	public String getDwjb(){
		return this.dwjb;
	}

	public void setDwjb(String dwjb){
		this.dwjb=dwjb;
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

	public String getFjjgdm(){
		return this.fjjgdm;
	}

	public void setFjjgdm(String fjjgdm){
		this.fjjgdm=fjjgdm;
	}

	public String getFjjgmc(){
		return this.fjjgmc;
	}

	public void setFjjgmc(String fjjgmc){
		this.fjjgmc=fjjgmc;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}