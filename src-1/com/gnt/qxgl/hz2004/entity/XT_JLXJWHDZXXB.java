package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

public class XT_JLXJWHDZXXB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String czid;//	number(19)	n			参照id
	private String jlxdm;//	char(12)	n			街路巷代码
	private String jwhdm;//	char(12)	n			居委会代码
	private String jlxhlx;//	char(1)	n			街路巷号类型
	private String jlxh;//	varchar2(50)	y			街路巷号
	private String qybz;//	char(1)	n			启用标志
	private String bdlx;//	char(1)	y			变动类型
	private String bdsj;//	char(14)	y			变动时间
	public String getCzid() {
		return czid;
	}
	public void setCzid(String czid) {
		this.czid = czid;
	}
	public String getJlxdm() {
		return jlxdm;
	}
	public void setJlxdm(String jlxdm) {
		this.jlxdm = jlxdm;
	}
	public String getJwhdm() {
		return jwhdm;
	}
	public void setJwhdm(String jwhdm) {
		this.jwhdm = jwhdm;
	}
	public String getJlxhlx() {
		return jlxhlx;
	}
	public void setJlxhlx(String jlxhlx) {
		this.jlxhlx = jlxhlx;
	}
	public String getJlxh() {
		return jlxh;
	}
	public void setJlxh(String jlxh) {
		this.jlxh = jlxh;
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
}
