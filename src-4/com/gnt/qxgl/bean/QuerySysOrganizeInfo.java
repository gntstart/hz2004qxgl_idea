package com.gnt.qxgl.bean;

import com.gnt.qxgl.hz2004.entity.XtDwxxb;


public class QuerySysOrganizeInfo extends XtDwxxb{
	private String adminlbname;		//单位管理员名称
	private String ssqhname;		//区划名称
	
	public String getAdminlbname() {
		return adminlbname;
	}
	public void setAdminlbname(String adminlbname) {
		this.adminlbname = adminlbname;
	}
	public String getSsqhname() {
		return ssqhname;
	}
	public void setSsqhname(String ssqhname) {
		this.ssqhname = ssqhname;
	}
}
