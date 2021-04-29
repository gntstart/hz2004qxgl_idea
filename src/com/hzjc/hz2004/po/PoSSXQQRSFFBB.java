package com.hzjc.hz2004.po;



/**
*省市县区迁入身份分布表
*/

public class PoSSXQQRSFFBB implements com.hzjc.wsstruts.po.PO, java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private long sffbbId;//id
	private String	qhdm;//区划代码
	private String	qcdsdm;//迁出地省代码
	private String  qcdsmc;//迁出地省名称
	private Integer  count;//迁出人数
	
	
	
	public PoSSXQQRSFFBB() {
		super();
	}

	public PoSSXQQRSFFBB(long sffbbId, String qhdm, String qcdsdm, String qcdsmc, Integer count) {
		super();
		this.sffbbId = sffbbId;
		this.qhdm = qhdm;
		this.qcdsdm = qcdsdm;
		this.qcdsmc = qcdsmc;
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public long getSffbbId() {
		return sffbbId;
	}

	public void setSffbbId(long sffbbId) {
		this.sffbbId = sffbbId;
	}

	public String getQhdm() {
		return qhdm;
	}

	public void setQhdm(String qhdm) {
		this.qhdm = qhdm;
	}

	public String getQcdsdm() {
		return qcdsdm;
	}

	public void setQcdsdm(String qcdsdm) {
		this.qcdsdm = qcdsdm;
	}

	public String getQcdsmc() {
		return qcdsmc;
	}

	public void setQcdsmc(String qcdsmc) {
		this.qcdsmc = qcdsmc;
	}

	public static long getSerialversionuid() {			return serialVersionUID;	}}