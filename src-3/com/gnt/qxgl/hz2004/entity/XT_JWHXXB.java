package com.gnt.qxgl.hz2004.entity;

public class XT_JWHXXB  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String dm;//    char(12) not null,
	private String  mc;//     nvarchar2(100) not null,
	private String  zwpy;//   varchar2(50),
	private String  wbpy;//   varchar2(20),
	private String  dwdm;//   char(9) not null,
	private String  xzjddm;// char(9) not null,
	private String  bz;//     nvarchar2(100),
	private String  qybz;//   char(1) not null,
	private String  bdlx;//   char(1),
	private String  bdsj;//   char(14),
	private String  cxfldm;// varchar2(20),
	private String  cxflmc;// varchar2(40),
	private String  tjdm;//   varchar2(100),
	private String  tjmc;//   varchar2(100)
	private String dwdm_name;		//冗余单位代码名称
	private String xzjddm_name;	//冗余乡镇街道名称
	private String dwdm_bz;
	
	
	public String getDwdm_bz() {
		return dwdm_bz;
	}
	public void setDwdm_bz(String dwdm_bz) {
		this.dwdm_bz = dwdm_bz;
	}
	public String getDwdm_name() {
		return dwdm_name;
	}
	public void setDwdm_name(String dwdm_name) {
		this.dwdm_name = dwdm_name;
	}
	public String getXzjddm_name() {
		return xzjddm_name;
	}
	public void setXzjddm_name(String xzjddm_name) {
		this.xzjddm_name = xzjddm_name;
	}
	public String getDm() {
		return dm;
	}
	public void setDm(String dm) {
		this.dm = dm;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getZwpy() {
		return zwpy;
	}
	public void setZwpy(String zwpy) {
		this.zwpy = zwpy;
	}
	public String getWbpy() {
		return wbpy;
	}
	public void setWbpy(String wbpy) {
		this.wbpy = wbpy;
	}
	public String getDwdm() {
		return dwdm;
	}
	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}
	public String getXzjddm() {
		return xzjddm;
	}
	public void setXzjddm(String xzjddm) {
		this.xzjddm = xzjddm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getQybz() {
		return qybz;
	}
	public void setQybz(String qybz) {
		this.qybz = qybz;
	}
	public String getBdlx() {
		return bdlx;
	}
	public void setBdlx(String bdlx) {
		this.bdlx = bdlx;
	}
	public String getBdsj() {
		return bdsj;
	}
	public void setBdsj(String bdsj) {
		this.bdsj = bdsj;
	}
	public String getCxfldm() {
		return cxfldm;
	}
	public void setCxfldm(String cxfldm) {
		this.cxfldm = cxfldm;
	}
	public String getCxflmc() {
		return cxflmc;
	}
	public void setCxflmc(String cxflmc) {
		this.cxflmc = cxflmc;
	}
	public String getTjdm() {
		return tjdm;
	}
	public void setTjdm(String tjdm) {
		this.tjdm = tjdm;
	}
	public String getTjmc() {
		return tjmc;
	}
	public void setTjmc(String tjmc) {
		this.tjmc = tjmc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
