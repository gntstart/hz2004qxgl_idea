package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

public class XtYhdzqxb implements Serializable{
	private String	dzqxid;
	private String	yhid;
	private String	dzid;
	private String  dqbm;
	
	//冗余，动作名称和描述
	private String  dzmc;
	private String dzms;
	private String yhdlm;
	private String yhxm;
	
	public String getYhdlm() {
		return yhdlm;
	}
	public void setYhdlm(String yhdlm) {
		this.yhdlm = yhdlm;
	}
	public String getYhxm() {
		return yhxm;
	}
	public void setYhxm(String yhxm) {
		this.yhxm = yhxm;
	}
	public String getDzmc() {
		return dzmc;
	}
	public void setDzmc(String dzmc) {
		this.dzmc = dzmc;
	}
	public String getDzms() {
		return dzms;
	}
	public void setDzms(String dzms) {
		this.dzms = dzms;
	}
	public String getDqbm() {
		return dqbm;
	}
	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}
	public String getDzqxid() {
		return dzqxid;
	}
	public void setDzqxid(String dzqxid) {
		this.dzqxid = dzqxid;
	}
	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
	public String getDzid() {
		return dzid;
	}
	public void setDzid(String dzid) {
		this.dzid = dzid;
	}
}