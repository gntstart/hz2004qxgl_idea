package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SjYwpm implements Serializable{
	
	/**
	 * 主键ID
	 */
	private String id;
	
	/**
	 * 地市代码
	 */
	private String dsdm;
	
	/**
	 * 地市名称
	 */
	private String dsmc;
	
	/**
	 * 派出所代码
	 */
	private String pcsdm;
	
	/**
	 * 派出所名称
	 */
	private String pcsmc;
	
	/**
	 * 业务数量
	 */
	private Long ywsl;
	
	/**
	 * 业务分类
	 * 备用
	 */
	private String ywfl;
	
	/**
	 * 统计时间
	 */
	private Date tjsj;
	
	/**
	 * 县区
	 */
	private String xq;
	
	private String tjsjStr;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDsdm() {
		return dsdm;
	}

	public void setDsdm(String dsdm) {
		this.dsdm = dsdm;
	}

	public String getDsmc() {
		return dsmc;
	}

	public void setDsmc(String dsmc) {
		this.dsmc = dsmc;
	}

	public String getPcsdm() {
		return pcsdm;
	}

	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}

	public String getPcsmc() {
		return pcsmc;
	}

	public void setPcsmc(String pcsmc) {
		this.pcsmc = pcsmc;
	}

	public Long getYwsl() {
		return ywsl;
	}

	public void setYwsl(Long ywsl) {
		this.ywsl = ywsl;
	}

	public String getYwfl() {
		return ywfl;
	}

	public void setYwfl(String ywfl) {
		this.ywfl = ywfl;
	}

	public Date getTjsj() {
		return tjsj;
	}

	public void setTjsj(Date tjsj) {
		this.tjsj = tjsj;
	}

	public String getXq() {
		return xq;
	}

	public void setXq(String xq) {
		this.xq = xq;
	}

	public String getTjsjStr() {
		return tjsjStr;
	}

	public void setTjsjStr(String tjsjStr) {
		this.tjsjStr = tjsjStr;
	}

	public SjYwpm() {
		super();
	}

	public SjYwpm(String dsdm, String dsmc, Long ywsl, Date tjsj) {
		super();
		this.dsdm = dsdm;
		this.dsmc = dsmc;
		this.ywsl = ywsl;
		this.tjsj = tjsj;
	}
	
}
