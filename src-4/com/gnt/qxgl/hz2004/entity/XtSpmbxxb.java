package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*瀹℃壒妯℃澘淇℃伅琛�
*/
public class XtSpmbxxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*瀹℃壒妯℃澘ID
	*/
	private Long	spmbid;
	/*
	*妯℃澘鍚嶇О
	*/
	private String	mbmc;
	/*
	*妯℃澘绛夌骇
	*/
	private String	mbdj;
	/*
	*鍒涘缓浜篒D
	*/
	private Long	cjrid;
	/*
	*鍒涘缓鏃堕棿
	*/
	private String	cjsj;
	/*
	*淇敼浜篒D
	*/
	private Long	xgrid;
	/*
	*淇敼鏃堕棿
	*/
	private String	xgsj;
	/*
	*鍚敤鏍囧織
	*/
	private String	qybz;
	/*
	*浣跨敤鏍囧織
	*/
	private String	dqsys;

	public XtSpmbxxb(){}


	public XtSpmbxxb(Long spmbid,
			String mbmc,
			String mbdj,
			Long cjrid,
			String cjsj,
			Long xgrid,
			String xgsj,
			String qybz,
			String dqsys)
	{
		this.spmbid=spmbid;
		this.mbmc=mbmc;
		this.mbdj=mbdj;
		this.cjrid=cjrid;
		this.cjsj=cjsj;
		this.xgrid=xgrid;
		this.xgsj=xgsj;
		this.qybz=qybz;
		this.dqsys=dqsys;
	}

	public Long getSpmbid(){
		return this.spmbid;
	}

	public void setSpmbid(Long spmbid){
		this.spmbid=spmbid;
	}

	public String getMbmc(){
		return this.mbmc;
	}

	public void setMbmc(String mbmc){
		this.mbmc=mbmc;
	}

	public String getMbdj(){
		return this.mbdj;
	}

	public void setMbdj(String mbdj){
		this.mbdj=mbdj;
	}

	public Long getCjrid(){
		return this.cjrid;
	}

	public void setCjrid(Long cjrid){
		this.cjrid=cjrid;
	}

	public String getCjsj(){
		return this.cjsj;
	}

	public void setCjsj(String cjsj){
		this.cjsj=cjsj;
	}

	public Long getXgrid(){
		return this.xgrid;
	}

	public void setXgrid(Long xgrid){
		this.xgrid=xgrid;
	}

	public String getXgsj(){
		return this.xgsj;
	}

	public void setXgsj(String xgsj){
		this.xgsj=xgsj;
	}

	public String getQybz(){
		return this.qybz;
	}

	public void setQybz(String qybz){
		this.qybz=qybz;
	}

	public String getDqsys(){
		return this.dqsys;
	}

	public void setDqsys(String dqsys){
		this.dqsys=dqsys;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}