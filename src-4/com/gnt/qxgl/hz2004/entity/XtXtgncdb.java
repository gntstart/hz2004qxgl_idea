package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*绯荤粺鍔熻兘鑿滃崟琛�
*/
public class XtXtgncdb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*鍔熻兘鑿滃崟ID
	*/
	private String	gncdid;
	/*
	*鑿滃崟灞傛
	*/
	private String	cdcc;
	/*
	*鑿滃崟鏍囧織
	*/
	private String	cdbz;
	/*
	*鑿滃崟绫诲瀷
	*/
	private String	cdlx;
	/*
	*缁堢绫诲埆
	*/
	private String	zdlb;
	/*
	*鑿滃崟鍚嶇О
	*/
	private String	cdmc;

	private String dqbm;
	
	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getGncdid(){
		return this.gncdid;
	}

	public void setGncdid(String gncdid){
		this.gncdid=gncdid;
	}

	public String getCdcc(){
		return this.cdcc;
	}

	public void setCdcc(String cdcc){
		this.cdcc=cdcc;
	}

	public String getCdbz(){
		return this.cdbz;
	}

	public void setCdbz(String cdbz){
		this.cdbz=cdbz;
	}

	public String getCdlx(){
		return this.cdlx;
	}

	public void setCdlx(String cdlx){
		this.cdlx=cdlx;
	}

	public String getZdlb(){
		return this.zdlb;
	}

	public void setZdlb(String zdlb){
		this.zdlb=zdlb;
	}

	public String getCdmc(){
		return this.cdmc;
	}

	public void setCdmc(String cdmc){
		this.cdmc=cdmc;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}