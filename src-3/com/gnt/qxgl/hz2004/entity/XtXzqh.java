package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

/**
*省行政区划
*/
@SuppressWarnings("serial")
public class XtXzqh implements Serializable{
	
	/**
	 	区划代码ID
	 */
	private String qhdmId;
	
	/**
	 	区划代码
	 */
	private String qhdm;
	
	/**
	 	区划名称
	 */
	private String qhmc;
	
	/**
	 	区划简称
	 */
	private String qhjc;
	
	/**
	 	中文拼音
	 */
	private String zwpy;
	
	/**
	 	启用标志
	 */
	private String qybz;
	
	/**
	 	变动时间
	 */
	private String bdsj;
	
	
	public String getQhdmId() {
		return qhdmId;
	}

	public void setQhdmId(String qhdmId) {
		this.qhdmId = qhdmId;
	}

	public String getQhdm() {
		return qhdm;
	}

	public void setQhdm(String qhdm) {
		this.qhdm = qhdm;
	}

	public String getQhmc() {
		return qhmc;
	}

	public void setQhmc(String qhmc) {
		this.qhmc = qhmc;
	}

	public String getQhjc() {
		return qhjc;
	}

	public void setQhjc(String qhjc) {
		this.qhjc = qhjc;
	}

	public String getZwpy() {
		return zwpy;
	}

	public void setZwpy(String zwpy) {
		this.zwpy = zwpy;
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