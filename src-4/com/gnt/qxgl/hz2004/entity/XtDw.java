package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*单位
*/
@SuppressWarnings("serial")
public class XtDw implements Serializable{
	
	/**
	 	单位代码ID
	 */
	private String dwdmId;
	
	/**
	 	单位代码
	 */
	private String dwdm;
	
	/**
	 	单位名称
	 */
	private String dwmc;
	
	/**
	 	中文拼音
	 */
	private String zwpy;
	
	/**
	 	区划代码
	 */
	private String qhdm;
	
	/**
	 	单位机构代码
	 */
	private String dwjgdm;
	
	/**
	 	单位级别
	 */
	private String dwjb;
	
	/**
	 	启用标志
	 */
	private String qybz;
	
	/**
	 	变动时间
	 */
	private String bdsj;
	

	public String getDwdmId() {
		return dwdmId;
	}

	public void setDwdmId(String dwdmId) {
		this.dwdmId = dwdmId;
	}

	public String getDwdm() {
		return dwdm;
	}

	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getZwpy() {
		return zwpy;
	}

	public void setZwpy(String zwpy) {
		this.zwpy = zwpy;
	}

	public String getQhdm() {
		return qhdm;
	}

	public void setQhdm(String qhdm) {
		this.qhdm = qhdm;
	}

	public String getDwjgdm() {
		return dwjgdm;
	}

	public void setDwjgdm(String dwjgdm) {
		this.dwjgdm = dwjgdm;
	}

	public String getDwjb() {
		return dwjb;
	}

	public void setDwjb(String dwjb) {
		this.dwjb = dwjb;
	}

	public String getQybz() {
		return qybz;
	}

	public void setQybz(String qybz) {
		this.qybz = qybz;
	}

	public String getBdsj() {
		return bdsj;
	}

	public void setBdsj(String bdsj) {
		this.bdsj = bdsj;
	}

	
	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}