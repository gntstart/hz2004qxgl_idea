package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*鍒跺紡鎶ヨ〃妯℃澘淇℃伅琛�
*/
public class XtZsbbmbxxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*鍒跺紡鎶ヨ〃妯℃澘ID
	*/
	private Long	zsbbmbid;
	/*
	*鍒跺紡鎶ヨ〃绫诲埆
	*/
	private String	zsbblb;
	/*
	*鎶ヨ〃妯℃澘鍚嶇О
	*/
	private String	bbmbmc;
	/*
	*鎶ヨ〃妯℃澘
	*/
	private String	bbmb;
	/*
	*寤虹珛鏃堕棿
	*/
	private String	jlsj;
	/*
	*鐢熸垚浜篒D
	*/
	private Long	scrid;
	/*
	*淇敼鏃堕棿
	*/
	private String	xgsj;
	/*
	*淇敼浜篒D
	*/
	private Long	xgrid;

	public XtZsbbmbxxb(){}


	public XtZsbbmbxxb(Long zsbbmbid,
			String zsbblb,
			String bbmbmc,
			String bbmb,
			String jlsj,
			Long scrid,
			String xgsj,
			Long xgrid)
	{
		this.zsbbmbid=zsbbmbid;
		this.zsbblb=zsbblb;
		this.bbmbmc=bbmbmc;
		this.bbmb=bbmb;
		this.jlsj=jlsj;
		this.scrid=scrid;
		this.xgsj=xgsj;
		this.xgrid=xgrid;
	}

	public Long getZsbbmbid(){
		return this.zsbbmbid;
	}

	public void setZsbbmbid(Long zsbbmbid){
		this.zsbbmbid=zsbbmbid;
	}

	public String getZsbblb(){
		return this.zsbblb;
	}

	public void setZsbblb(String zsbblb){
		this.zsbblb=zsbblb;
	}

	public String getBbmbmc(){
		return this.bbmbmc;
	}

	public void setBbmbmc(String bbmbmc){
		this.bbmbmc=bbmbmc;
	}

	public String getBbmb(){
		return this.bbmb;
	}

	public void setBbmb(String bbmb){
		this.bbmb=bbmb;
	}

	public String getJlsj(){
		return this.jlsj;
	}

	public void setJlsj(String jlsj){
		this.jlsj=jlsj;
	}

	public Long getScrid(){
		return this.scrid;
	}

	public void setScrid(Long scrid){
		this.scrid=scrid;
	}

	public String getXgsj(){
		return this.xgsj;
	}

	public void setXgsj(String xgsj){
		this.xgsj=xgsj;
	}

	public Long getXgrid(){
		return this.xgrid;
	}

	public void setXgrid(Long xgrid){
		this.xgrid=xgrid;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}