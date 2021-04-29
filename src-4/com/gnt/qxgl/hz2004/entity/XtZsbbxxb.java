package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*鍒跺紡鎶ヨ〃淇℃伅琛�
*/
public class XtZsbbxxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*鍒跺紡鎶ヨ〃ID
	*/
	private Long	zsbbid;
	/*
	*鍒跺紡鎶ヨ〃妯℃澘ID
	*/
	private Long	zsbbmbid;
	/*
	*鎶ヨ〃鍚嶇О
	*/
	private String	bbmc;
	/*
	*鎶ヨ〃鏁版嵁妯℃澘
	*/
	private String	bbsjmb;
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

	public XtZsbbxxb(){}


	public XtZsbbxxb(Long zsbbid,
			Long zsbbmbid,
			String bbmc,
			String bbsjmb,
			String jlsj,
			Long scrid,
			String xgsj,
			Long xgrid)
	{
		this.zsbbid=zsbbid;
		this.zsbbmbid=zsbbmbid;
		this.bbmc=bbmc;
		this.bbsjmb=bbsjmb;
		this.jlsj=jlsj;
		this.scrid=scrid;
		this.xgsj=xgsj;
		this.xgrid=xgrid;
	}

	public Long getZsbbid(){
		return this.zsbbid;
	}

	public void setZsbbid(Long zsbbid){
		this.zsbbid=zsbbid;
	}

	public Long getZsbbmbid(){
		return this.zsbbmbid;
	}

	public void setZsbbmbid(Long zsbbmbid){
		this.zsbbmbid=zsbbmbid;
	}

	public String getBbmc(){
		return this.bbmc;
	}

	public void setBbmc(String bbmc){
		this.bbmc=bbmc;
	}

	public String getBbsjmb(){
		return this.bbsjmb;
	}

	public void setBbsjmb(String bbsjmb){
		this.bbsjmb=bbsjmb;
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