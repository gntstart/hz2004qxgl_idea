package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*绯荤粺鍙傛暟琛�
*/
public class XtXtcsb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*鍙傛暟ID
	*/
	private Long	csid;
	/*
	*鍙傛暟绫诲埆
	*/
	private String	cslb;
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
	*鎵╁睍鏍囧織B
	*/
	private String	kzbzb;
	/*
	*鎵╁睍鏍囧織C
	*/
	private String	kzbzc;
	/*
	*鎵╁睍鏍囧織D
	*/
	private String	kzbzd;
	/*
	*鎵╁睍鏍囧織E
	*/
	private String	kzbze;
	/*
	*鎵╁睍鏍囧織F
	*/
	private String	kzbzf;
	/*
	*鎵╁睍鏍囧織G
	*/
	private String	kzbzg;
	/*
	*淇敼鏍囧織
	*/
	private String	xgbz;
	/*
	*鍙樺姩绫诲瀷
	*/
	private String	bdlx;
	/*
	*鍙樺姩鏃堕棿
	*/
	private String	bdsj;

	public XtXtcsb(){}


	public XtXtcsb(Long csid,
			String cslb,
			String dm,
			String mc,
			String zwpy,
			String kzbzb,
			String kzbzc,
			String kzbzd,
			String kzbze,
			String kzbzf,
			String kzbzg,
			String xgbz,
			String bdlx,
			String bdsj)
	{
		this.csid=csid;
		this.cslb=cslb;
		this.dm=dm;
		this.mc=mc;
		this.zwpy=zwpy;
		this.kzbzb=kzbzb;
		this.kzbzc=kzbzc;
		this.kzbzd=kzbzd;
		this.kzbze=kzbze;
		this.kzbzf=kzbzf;
		this.kzbzg=kzbzg;
		this.xgbz=xgbz;
		this.bdlx=bdlx;
		this.bdsj=bdsj;
	}

	public Long getCsid(){
		return this.csid;
	}

	public void setCsid(Long csid){
		this.csid=csid;
	}

	public String getCslb(){
		return this.cslb;
	}

	public void setCslb(String cslb){
		this.cslb=cslb;
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

	public String getKzbzb(){
		return this.kzbzb;
	}

	public void setKzbzb(String kzbzb){
		this.kzbzb=kzbzb;
	}

	public String getKzbzc(){
		return this.kzbzc;
	}

	public void setKzbzc(String kzbzc){
		this.kzbzc=kzbzc;
	}

	public String getKzbzd(){
		return this.kzbzd;
	}

	public void setKzbzd(String kzbzd){
		this.kzbzd=kzbzd;
	}

	public String getKzbze(){
		return this.kzbze;
	}

	public void setKzbze(String kzbze){
		this.kzbze=kzbze;
	}

	public String getKzbzf(){
		return this.kzbzf;
	}

	public void setKzbzf(String kzbzf){
		this.kzbzf=kzbzf;
	}

	public String getKzbzg(){
		return this.kzbzg;
	}

	public void setKzbzg(String kzbzg){
		this.kzbzg=kzbzg;
	}

	public String getXgbz(){
		return this.xgbz;
	}

	public void setXgbz(String xgbz){
		this.xgbz=xgbz;
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