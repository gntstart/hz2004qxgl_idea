package com.gnt.qxgl.hz2004.entity;

public class HJYW_SWZXXXB  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String swzxid;	//SWZXID	NUMBER(19)	N			死亡注销ID
	private String rynbid;	//RYNBID	NUMBER(19)	N			人员内部ID
	private String swrq;	//SWRQ	CHAR(8)	Y			死亡日期
	private String swnl;	//SWNL	VARCHAR2(3)	Y			死亡年龄
	private String swzmbh;	//SWZMBH	VARCHAR2(20)	Y			死亡证明编号
	private String swzxlb;	//SWZXLB	CHAR(4)	N			死亡注销类别
	private String hjywid;	//HJYWID	NUMBER(19)	N			户籍业务ID
	private String cxbz;	//CXBZ	CHAR(1)	N	'0'		冲销标志
	private String cxsj;	//CXSJ	CHAR(14)	Y			冲销时间
	private String cxrid;	//CXRID	NUMBER(19)	Y			冲销人ID
	private String cxhjywid;	//CXHJYWID	NUMBER(19)	Y			冲销户籍业务ID
	private String tbbz;	//TBBZ	NUMBER(2)	N	0		同步标志
	private String bwbh;	//BWBH	VARCHAR2(35)	Y			包文编号
	private String sbsj;	//SBSJ	CHAR(14)	Y			申报时间
	private String sbryxm;	//SBRYXM	NVARCHAR2(20)	Y			申报人员姓名
	private String sbrgmsfhm;	//SBRGMSFHM	CHAR(18)	Y			申报人公民身份号码
	private String slsj;	//SLSJ	CHAR(14)	Y			受理时间
	private String sldw;	//SLDW	CHAR(9)	Y			受理单位
	private String slrid;	//SLRID	NUMBER(19)	Y			受理人ID
	private String ywlx;	//YWLX	CHAR(1)	Y			业务类型
	private String czsm;	//CZSM	NUMBER(5)	Y			操作数目
	private String xm;	//XM	NVARCHAR2(20)	Y			姓名
	private String gmsfhm;	//GMSFHM	CHAR(18)	Y			公民身份号码
	private String mz;	//MZ	CHAR(2)	Y			民族
	private String xb;	//XB	CHAR(1)	Y			性别
	private String csrq;	//CSRQ	CHAR(8)	Y			出生日期
	private String cssj;	//CSSJ	CHAR(6)	Y			出生时间
	private String csdssxq;	//CSDSSXQ	CHAR(6)	Y			出生地省市县（区）
	private String ryid;	//RYID	NUMBER(19)	Y			人员ID
	private String hhnbid;	//HHNBID	NUMBER(19)	Y			户号内部ID
	private String ssxq;	//SSXQ	CHAR(6)	Y			省市县（区）
	private String jlx;	//JLX	VARCHAR2(15)	Y			街路巷
	private String mlph;	//MLPH	NVARCHAR2(10)	Y			门（楼）牌号
	private String mlxz;	//MLXZ	NVARCHAR2(100)	Y			门（楼）详址
	private String pcs;	//PCS	CHAR(9)	Y			派出所
	private String zrq;	//ZRQ	VARCHAR2(20)	Y			责任区
	private String xzjd;	//XZJD	VARCHAR2(20)	Y			乡镇（街道）
	private String jcwh;	//JCWH	VARCHAR2(20)	Y			居（村）委会
	private String pxh;	//PXH	NVARCHAR2(100)	Y			排序号
	private String mlpnbid;	//MLPNBID	NUMBER(19)	Y			
	private String hb;	//HB	CHAR(1)	Y			户别
	private String yhzgx;	//YHZGX	CHAR(2)	Y			与户主关系
	private String hzxm;	//HZXM	NVARCHAR2(20)	Y			户主姓名
	private String hzgmsfhm;	//HZGMSFHM	CHAR(18)	Y			户主公民身份号码
	private String hhid;	//HHID	NUMBER(19)	Y			户号ID
	private String mlpid;	//MLPID	NUMBER(19)	Y			门楼牌ID
	private String sbrjtgx;	//SBRJTGX	VARCHAR2(2)	Y			申报人与销户人家庭关系
	private String swyy;	//SWYY	VARCHAR2(3)	Y			死亡原因
	
	
	public String getSwzxid() {
		return swzxid;
	}

	public void setSwzxid(String swzxid) {
		this.swzxid = swzxid;
	}

	public String getRynbid() {
		return rynbid;
	}

	public void setRynbid(String rynbid) {
		this.rynbid = rynbid;
	}

	public String getSwrq() {
		return swrq;
	}

	public void setSwrq(String swrq) {
		this.swrq = swrq;
	}

	public String getSwnl() {
		return swnl;
	}

	public void setSwnl(String swnl) {
		this.swnl = swnl;
	}

	public String getSwzmbh() {
		return swzmbh;
	}

	public void setSwzmbh(String swzmbh) {
		this.swzmbh = swzmbh;
	}

	public String getSwzxlb() {
		return swzxlb;
	}

	public void setSwzxlb(String swzxlb) {
		this.swzxlb = swzxlb;
	}

	public String getHjywid() {
		return hjywid;
	}

	public void setHjywid(String hjywid) {
		this.hjywid = hjywid;
	}

	public String getCxbz() {
		return cxbz;
	}

	public void setCxbz(String cxbz) {
		this.cxbz = cxbz;
	}

	public String getCxsj() {
		return cxsj;
	}

	public void setCxsj(String cxsj) {
		this.cxsj = cxsj;
	}

	public String getCxrid() {
		return cxrid;
	}

	public void setCxrid(String cxrid) {
		this.cxrid = cxrid;
	}

	public String getCxhjywid() {
		return cxhjywid;
	}

	public void setCxhjywid(String cxhjywid) {
		this.cxhjywid = cxhjywid;
	}

	public String getTbbz() {
		return tbbz;
	}

	public void setTbbz(String tbbz) {
		this.tbbz = tbbz;
	}

	public String getBwbh() {
		return bwbh;
	}

	public void setBwbh(String bwbh) {
		this.bwbh = bwbh;
	}

	public String getSbsj() {
		return sbsj;
	}

	public void setSbsj(String sbsj) {
		this.sbsj = sbsj;
	}

	public String getSbryxm() {
		return sbryxm;
	}

	public void setSbryxm(String sbryxm) {
		this.sbryxm = sbryxm;
	}

	public String getSbrgmsfhm() {
		return sbrgmsfhm;
	}

	public void setSbrgmsfhm(String sbrgmsfhm) {
		this.sbrgmsfhm = sbrgmsfhm;
	}

	public String getSlsj() {
		return slsj;
	}

	public void setSlsj(String slsj) {
		this.slsj = slsj;
	}

	public String getSldw() {
		return sldw;
	}

	public void setSldw(String sldw) {
		this.sldw = sldw;
	}

	public String getSlrid() {
		return slrid;
	}

	public void setSlrid(String slrid) {
		this.slrid = slrid;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public String getCzsm() {
		return czsm;
	}

	public void setCzsm(String czsm) {
		this.czsm = czsm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getCssj() {
		return cssj;
	}

	public void setCssj(String cssj) {
		this.cssj = cssj;
	}

	public String getCsdssxq() {
		return csdssxq;
	}

	public void setCsdssxq(String csdssxq) {
		this.csdssxq = csdssxq;
	}

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getHhnbid() {
		return hhnbid;
	}

	public void setHhnbid(String hhnbid) {
		this.hhnbid = hhnbid;
	}

	public String getSsxq() {
		return ssxq;
	}

	public void setSsxq(String ssxq) {
		this.ssxq = ssxq;
	}

	public String getJlx() {
		return jlx;
	}

	public void setJlx(String jlx) {
		this.jlx = jlx;
	}

	public String getMlph() {
		return mlph;
	}

	public void setMlph(String mlph) {
		this.mlph = mlph;
	}

	public String getMlxz() {
		return mlxz;
	}

	public void setMlxz(String mlxz) {
		this.mlxz = mlxz;
	}

	public String getPcs() {
		return pcs;
	}

	public void setPcs(String pcs) {
		this.pcs = pcs;
	}

	public String getZrq() {
		return zrq;
	}

	public void setZrq(String zrq) {
		this.zrq = zrq;
	}

	public String getXzjd() {
		return xzjd;
	}

	public void setXzjd(String xzjd) {
		this.xzjd = xzjd;
	}

	public String getJcwh() {
		return jcwh;
	}

	public void setJcwh(String jcwh) {
		this.jcwh = jcwh;
	}

	public String getPxh() {
		return pxh;
	}

	public void setPxh(String pxh) {
		this.pxh = pxh;
	}

	public String getMlpnbid() {
		return mlpnbid;
	}

	public void setMlpnbid(String mlpnbid) {
		this.mlpnbid = mlpnbid;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getYhzgx() {
		return yhzgx;
	}

	public void setYhzgx(String yhzgx) {
		this.yhzgx = yhzgx;
	}

	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	public String getHzgmsfhm() {
		return hzgmsfhm;
	}

	public void setHzgmsfhm(String hzgmsfhm) {
		this.hzgmsfhm = hzgmsfhm;
	}

	public String getHhid() {
		return hhid;
	}

	public void setHhid(String hhid) {
		this.hhid = hhid;
	}

	public String getMlpid() {
		return mlpid;
	}

	public void setMlpid(String mlpid) {
		this.mlpid = mlpid;
	}

	public String getSbrjtgx() {
		return sbrjtgx;
	}

	public void setSbrjtgx(String sbrjtgx) {
		this.sbrjtgx = sbrjtgx;
	}

	public String getSwyy() {
		return swyy;
	}

	public void setSwyy(String swyy) {
		this.swyy = swyy;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}