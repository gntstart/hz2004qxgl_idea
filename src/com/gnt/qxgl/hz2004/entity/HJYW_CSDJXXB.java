package com.gnt.qxgl.hz2004.entity;

public class HJYW_CSDJXXB  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String csdjid;	//CSDJID NUMBER(19)	N			出生登记ID
	private String rynbid;	//RYNBID	NUMBER(19)	N			人员内部ID
	private String cszmbh;	//CSZMBH	VARCHAR2(20)	Y			出生证明编号
	private String csdjlb;	//CSDJLB	CHAR(4)	N			出生登记类别
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
	private String hlx;	//HLX	CHAR(1)	Y			户类型
	private String hh;	//HH	CHAR(9)	Y			户号
	private String csdxz;	//CSDXZ	NVARCHAR2(100)	Y			出生地详址
	private String xx;	//XX	CHAR(1)	Y			血型
	private String hb;	//HB	CHAR(1)	Y			户别
	private String csdgjdq;	//CSDGJDQ	CHAR(3)	Y			出生地国家（地区）
	private String jhryxm;	//JHRYXM	NVARCHAR2(20)	Y			监护人一姓名
	private String jhrygmsfhm;	//JHRYGMSFHM	CHAR(18)	Y			监护人一公民身份号码
	private String jhryjhgx;	//JHRYJHGX	CHAR(2)	Y			监护人一监护关系
	private String jhrexm;	//JHREXM	NVARCHAR2(20)	Y			监护人二姓名
	private String jhregmsfhm;	//JHREGMSFHM	CHAR(18)	Y			监护人二公民身份号码
	private String jhrejhgx;	//JHREJHGX	CHAR(2)	Y			监护人二监护关系
	private String fqxm;	//FQXM	NVARCHAR2(20)	Y			父亲姓名
	private String fqgmsfhm;	//FQGMSFHM	CHAR(18)	Y			父亲公民身份号码
	private String mqxm;	//MQXM	NVARCHAR2(20)	Y			母亲姓名
	private String mqgmsfhm;	//MQGMSFHM	CHAR(18)	Y			母亲公民身份号码
	private String jggjdq;	//JGGJDQ	CHAR(3)	Y			籍贯国家（地区）
	private String jgssxq;	//JGSSXQ	CHAR(6)	Y			籍贯省市县（区）
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
	private String yhzgx;	//YHZGX	CHAR(2)	Y			与户主关系
	private String hzxm;	//HZXM	NVARCHAR2(20)	Y			户主姓名
	private String hzgmsfhm;	//HZGMSFHM	CHAR(18)	Y			户主公民身份号码
	private String hhid;	//HHID	NUMBER(19)	Y			户号ID
	private String mlpid;	//MLPID	NUMBER(19)	Y			门楼牌ID
	private String sbrjtgx;	//SBRJTGX	CHAR(2)	Y			申报人与出生人家庭关系
	
	
	public String getCsdjid() {
		return csdjid;
	}

	public void setCsdjid(String csdjid) {
		this.csdjid = csdjid;
	}

	public String getRynbid() {
		return rynbid;
	}

	public void setRynbid(String rynbid) {
		this.rynbid = rynbid;
	}

	public String getCszmbh() {
		return cszmbh;
	}

	public void setCszmbh(String cszmbh) {
		this.cszmbh = cszmbh;
	}

	public String getCsdjlb() {
		return csdjlb;
	}

	public void setCsdjlb(String csdjlb) {
		this.csdjlb = csdjlb;
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

	public String getHlx() {
		return hlx;
	}

	public void setHlx(String hlx) {
		this.hlx = hlx;
	}

	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}

	public String getCsdxz() {
		return csdxz;
	}

	public void setCsdxz(String csdxz) {
		this.csdxz = csdxz;
	}

	public String getXx() {
		return xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getCsdgjdq() {
		return csdgjdq;
	}

	public void setCsdgjdq(String csdgjdq) {
		this.csdgjdq = csdgjdq;
	}

	public String getJhryxm() {
		return jhryxm;
	}

	public void setJhryxm(String jhryxm) {
		this.jhryxm = jhryxm;
	}

	public String getJhrygmsfhm() {
		return jhrygmsfhm;
	}

	public void setJhrygmsfhm(String jhrygmsfhm) {
		this.jhrygmsfhm = jhrygmsfhm;
	}

	public String getJhryjhgx() {
		return jhryjhgx;
	}

	public void setJhryjhgx(String jhryjhgx) {
		this.jhryjhgx = jhryjhgx;
	}

	public String getJhrexm() {
		return jhrexm;
	}

	public void setJhrexm(String jhrexm) {
		this.jhrexm = jhrexm;
	}

	public String getJhregmsfhm() {
		return jhregmsfhm;
	}

	public void setJhregmsfhm(String jhregmsfhm) {
		this.jhregmsfhm = jhregmsfhm;
	}

	public String getJhrejhgx() {
		return jhrejhgx;
	}

	public void setJhrejhgx(String jhrejhgx) {
		this.jhrejhgx = jhrejhgx;
	}

	public String getFqxm() {
		return fqxm;
	}

	public void setFqxm(String fqxm) {
		this.fqxm = fqxm;
	}

	public String getFqgmsfhm() {
		return fqgmsfhm;
	}

	public void setFqgmsfhm(String fqgmsfhm) {
		this.fqgmsfhm = fqgmsfhm;
	}

	public String getMqxm() {
		return mqxm;
	}

	public void setMqxm(String mqxm) {
		this.mqxm = mqxm;
	}

	public String getMqgmsfhm() {
		return mqgmsfhm;
	}

	public void setMqgmsfhm(String mqgmsfhm) {
		this.mqgmsfhm = mqgmsfhm;
	}

	public String getJggjdq() {
		return jggjdq;
	}

	public void setJggjdq(String jggjdq) {
		this.jggjdq = jggjdq;
	}

	public String getJgssxq() {
		return jgssxq;
	}

	public void setJgssxq(String jgssxq) {
		this.jgssxq = jgssxq;
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

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}