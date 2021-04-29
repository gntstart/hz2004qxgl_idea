package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

public class XT_ZQZ_QYZ_XLH implements  Serializable{
	private static final long serialVersionUID = 1L;
	private String logid;
	private String dqbm;
	private String zjyear;
	private String zjlx;
	private Integer zjbh;
	
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getDqbm() {
		return dqbm;
	}
	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}
	public String getZjyear() {
		return zjyear;
	}
	public void setZjyear(String zjyear) {
		this.zjyear = zjyear;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public Integer getZjbh() {
		return zjbh;
	}
	public void setZjbh(Integer zjbh) {
		this.zjbh = zjbh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
