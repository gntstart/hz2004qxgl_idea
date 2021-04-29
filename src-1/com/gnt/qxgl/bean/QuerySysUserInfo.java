package com.gnt.qxgl.bean;


import com.gnt.qxgl.hz2004.entity.XtYhxxb;

public class QuerySysUserInfo extends XtYhxxb {
	private static final long serialVersionUID = 1L;
	private String jzOrganizeInfoName; // 兼职单位名称
	private String jzOrganizeInfoBm; 	// 兼职单位编码
	private String sjfwname = null; // 扩展数据范围名称
	private String dwmc = null;

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		super.setDwmc(dwmc);
		this.dwmc = dwmc;
	}

	public String getJzOrganizeInfoName() {
		return jzOrganizeInfoName;
	}

	public void setJzOrganizeInfoName(String jzOrganizeInfoName) {
		this.jzOrganizeInfoName = jzOrganizeInfoName;
	}

	public String getJzOrganizeInfoBm() {
		return jzOrganizeInfoBm;
	}

	public void setJzOrganizeInfoBm(String jzOrganizeInfoBm) {
		this.jzOrganizeInfoBm = jzOrganizeInfoBm;
	}

	public String getSjfwname() {
		return sjfwname;
	}

	public void setSjfwname(String sjfwname) {
		this.sjfwname = sjfwname;
	}
}
