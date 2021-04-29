package com.gnt.qxgl.hz2004.entity;

import java.util.Date;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * 用户纤细信息视图对象
 */
@SuppressWarnings("serial")
public class XtHzckMx extends DefaultVO {
	
	/**
	 	用户ID
	 */
	private String yhId;
	
	/**
	 	用户姓名
	 */
	private String yhxm;
	
	/**
	 	用户登录名
	 */
	private String yhdlm;
	
	/**
	 	警员号
	 */
	private String jyh;
	
	/**
	 	公民身份号码
	 */
	private String gmsfhm;
	
	/**
	 	用户类型
	 */
	private String yhlx;
	
	/**
	 	用户IP地址
	 */
	private String yhIP;
	
	/**
	 	单位代码
	 */
	private String dwdm;
	
	/**
	 	单位名称
	 */
	private String dwmc;
	
	/**
	 	区划代码
	 */
	private String qhdm;
	
	/**
	 	所在区县
	 */
	private String szqx;
	
	/**
	 	地区编码
	 */
	private String dqbm;
	
	/**
	 	登录时间
	 */
	private Date dlsj;
	
	/**
	 	用户状态
	 */
	private String yhzt;

	
	public String getYhId() {
		return yhId;
	}

	public void setYhId(String yhId) {
		this.yhId = yhId;
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

	public String getJyh() {
		return jyh;
	}

	public void setJyh(String jyh) {
		this.jyh = jyh;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	public String getYhlx() {
		return yhlx;
	}

	public void setYhlx(String yhlx) {
		this.yhlx = yhlx;
	}

	public String getYhIP() {
		return yhIP;
	}

	public void setYhIP(String yhIP) {
		this.yhIP = yhIP;
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

	public String getQhdm() {
		return qhdm;
	}

	public void setQhdm(String qhdm) {
		this.qhdm = qhdm;
	}

	public String getSzqx() {
		return szqx;
	}

	public void setSzqx(String szqx) {
		this.szqx = szqx;
	}

	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public Date getDlsj() {
		return dlsj;
	}

	public void setDlsj(Date dlsj) {
		this.dlsj = dlsj;
	}

	public String getYhzt() {
		return yhzt;
	}

	public void setYhzt(String yhzt) {
		this.yhzt = yhzt;
	}
	
}
