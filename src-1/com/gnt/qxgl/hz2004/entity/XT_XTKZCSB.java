package com.gnt.qxgl.hz2004.entity;

public class XT_XTKZCSB  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String csid;// number(19) not null,
	private String  kzlb;// varchar2(20) not null,
	private String  kzmc;// nvarchar2(100) not null,
	private String  kzz;//  varchar2(40) not null,
	private String  mrz;//  varchar2(20) not null,
	private String  bz;//   nvarchar2(300),
	private String  xgbz;// char(1) not null,
	private String  bdlx;// char(1),
	private String bdsj;// char(14)
	public String getCsid() {
		return csid;
	}
	public void setCsid(String csid) {
		this.csid = csid;
	}
	public String getKzlb() {
		return kzlb;
	}
	public void setKzlb(String kzlb) {
		this.kzlb = kzlb;
	}
	public String getKzmc() {
		return kzmc;
	}
	public void setKzmc(String kzmc) {
		this.kzmc = kzmc;
	}
	public String getKzz() {
		return kzz;
	}
	public void setKzz(String kzz) {
		this.kzz = kzz;
	}
	public String getMrz() {
		return mrz;
	}
	public void setMrz(String mrz) {
		this.mrz = mrz;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXgbz() {
		return xgbz;
	}
	public void setXgbz(String xgbz) {
		this.xgbz = xgbz;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
