package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

public class XtYhdtqxb implements Serializable{
	private String	dtqxid;
	private String	yhid;
	private String	dtyhid;
	private String  dqbm;
	
	//冗余数据
	private String dtyhxm;
	private String dtyhdlm;
	private String yhxm;
	private String yhdlm;
	
	public String getDtqxid() {
		return dtqxid;
	}
	public void setDtqxid(String dtqxid) {
		this.dtqxid = dtqxid;
	}
	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
	public String getDtyhid() {
		return dtyhid;
	}
	public void setDtyhid(String dtyhid) {
		this.dtyhid = dtyhid;
	}
	public String getDqbm() {
		return dqbm;
	}
	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}
	public String getDtyhxm() {
		return dtyhxm;
	}
	public void setDtyhxm(String dtyhxm) {
		this.dtyhxm = dtyhxm;
	}
	public String getDtyhdlm() {
		return dtyhdlm;
	}
	public void setDtyhdlm(String dtyhdlm) {
		this.dtyhdlm = dtyhdlm;
	}
	public String getYhxm() {
		return yhxm;
	}
	public void setYhxm(String yhxm) {
		this.yhxm = yhxm;
	}
	public String getYhdlm() {
		return yhdlm;
	}
	public void setYhdlm(String yhdlm) {
		this.yhdlm = yhdlm;
	}
}