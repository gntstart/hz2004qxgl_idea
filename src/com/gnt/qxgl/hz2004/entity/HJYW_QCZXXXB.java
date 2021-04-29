package com.gnt.qxgl.hz2004.entity;

public class HJYW_QCZXXXB  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String qczxid;	//QCZXID	NUMBER(19)	N			迁出注销ID
	private String rynbid;	//RYNBID	NUMBER(19)	N			人员内部ID
	private String qclb;	//QCLB	CHAR(4)	N			迁出注销类别
	private String qcrq;	//QCRQ	CHAR(8)	N			迁出日期
	private String qwdgjdq;	//QWDGJDQ	CHAR(3)	Y			迁往地国家（地区）
	private String qwdssxq;	//QWDSSXQ	CHAR(6)	Y			迁往地省市县（区）
	private String qwdpcs;	//QWDPCS	CHAR(9)	Y			迁往地派出所
	private String qwdxzjd;	//QWDXZJD	VARCHAR2(15)	Y			迁往地乡镇街道
	private String qwdjwh;	//QWDJWH	VARCHAR2(15)	Y			迁往地居委会
	private String qwdjlx;	//QWDJLX	VARCHAR2(15)	Y			迁往地街路巷
	private String qwdjwzrq;	//QWDJWZRQ	VARCHAR2(15)	Y			迁往地警务责任区
	private String qwdmlph;	//QWDMLPH	NVARCHAR2(10)	Y			迁往地门楼牌号
	private String qwdxz;	//QWDXZ	NVARCHAR2(100)	Y			迁往地详址
	private String qyzbh;	//QYZBH	VARCHAR2(20)	Y			迁移证编号
	private String zqzbh;	//ZQZBH	VARCHAR2(20)	Y			准迁证编号
	private String bdfw;	//BDFW	CHAR(2)	Y			变动范围
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
	private String hhid;	//HHID	NUMBER(19)	Y			户号ID
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
	private String mlpid;	//MLPID	NUMBER(19)	Y			门楼牌ID
	private String bz;	//BZ	NVARCHAR2(500)	Y			备注
	private String sbrjtgx;	//SBRJTGX	VARCHAR2(2)	Y			申报人与销户人家庭关系
	private String ydblbs;	//YDBLBS	VARCHAR2(1)	Y			一地办理标识
	private String qhtzbs;	//QHTZBS	VARCHAR2(1)	Y			区划调整标识
	private String zqzhyxx;	//ZQZHYXX	VARCHAR2(1000)	Y			准迁证核验信息
	private String cxfldm;	//CXFLDM	VARCHAR2(20)	Y			历史城乡代码
	private String kdqqy_cgbz;	//KDQQY_CGBZ	VARCHAR2(200)	Y			
	private String kdqqy_qrdqbm;	//KDQQY_QRDQBM	VARCHAR2(100)	Y			
	private String kdqqy_dqbm;	//KDQQY_DQBM	VARCHAR2(200)	Y			
	private String kdqqy_yhid;	//KDQQY_YHID	VARCHAR2(200)	Y			
	private String kdqqy_yhm;	//KDQQY_YHM	VARCHAR2(200)	Y			
	
	public String getQczxid() {
		return qczxid;
	}

	public void setQczxid(String qczxid) {
		this.qczxid = qczxid;
	}

	public String getRynbid() {
		return rynbid;
	}

	public void setRynbid(String rynbid) {
		this.rynbid = rynbid;
	}

	public String getQclb() {
		return qclb;
	}

	public void setQclb(String qclb) {
		this.qclb = qclb;
	}

	public String getQcrq() {
		return qcrq;
	}

	public void setQcrq(String qcrq) {
		this.qcrq = qcrq;
	}

	public String getQwdgjdq() {
		return qwdgjdq;
	}

	public void setQwdgjdq(String qwdgjdq) {
		this.qwdgjdq = qwdgjdq;
	}

	public String getQwdssxq() {
		return qwdssxq;
	}

	public void setQwdssxq(String qwdssxq) {
		this.qwdssxq = qwdssxq;
	}

	public String getQwdpcs() {
		return qwdpcs;
	}

	public void setQwdpcs(String qwdpcs) {
		this.qwdpcs = qwdpcs;
	}

	public String getQwdxzjd() {
		return qwdxzjd;
	}

	public void setQwdxzjd(String qwdxzjd) {
		this.qwdxzjd = qwdxzjd;
	}

	public String getQwdjwh() {
		return qwdjwh;
	}

	public void setQwdjwh(String qwdjwh) {
		this.qwdjwh = qwdjwh;
	}

	public String getQwdjlx() {
		return qwdjlx;
	}

	public void setQwdjlx(String qwdjlx) {
		this.qwdjlx = qwdjlx;
	}

	public String getQwdjwzrq() {
		return qwdjwzrq;
	}

	public void setQwdjwzrq(String qwdjwzrq) {
		this.qwdjwzrq = qwdjwzrq;
	}

	public String getQwdmlph() {
		return qwdmlph;
	}

	public void setQwdmlph(String qwdmlph) {
		this.qwdmlph = qwdmlph;
	}

	public String getQwdxz() {
		return qwdxz;
	}

	public void setQwdxz(String qwdxz) {
		this.qwdxz = qwdxz;
	}

	public String getQyzbh() {
		return qyzbh;
	}

	public void setQyzbh(String qyzbh) {
		this.qyzbh = qyzbh;
	}

	public String getZqzbh() {
		return zqzbh;
	}

	public void setZqzbh(String zqzbh) {
		this.zqzbh = zqzbh;
	}

	public String getBdfw() {
		return bdfw;
	}

	public void setBdfw(String bdfw) {
		this.bdfw = bdfw;
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

	public String getHhid() {
		return hhid;
	}

	public void setHhid(String hhid) {
		this.hhid = hhid;
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

	public String getMlpid() {
		return mlpid;
	}

	public void setMlpid(String mlpid) {
		this.mlpid = mlpid;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getSbrjtgx() {
		return sbrjtgx;
	}

	public void setSbrjtgx(String sbrjtgx) {
		this.sbrjtgx = sbrjtgx;
	}

	public String getYdblbs() {
		return ydblbs;
	}

	public void setYdblbs(String ydblbs) {
		this.ydblbs = ydblbs;
	}

	public String getQhtzbs() {
		return qhtzbs;
	}

	public void setQhtzbs(String qhtzbs) {
		this.qhtzbs = qhtzbs;
	}

	public String getZqzhyxx() {
		return zqzhyxx;
	}

	public void setZqzhyxx(String zqzhyxx) {
		this.zqzhyxx = zqzhyxx;
	}

	public String getCxfldm() {
		return cxfldm;
	}

	public void setCxfldm(String cxfldm) {
		this.cxfldm = cxfldm;
	}

	public String getKdqqy_cgbz() {
		return kdqqy_cgbz;
	}

	public void setKdqqy_cgbz(String kdqqy_cgbz) {
		this.kdqqy_cgbz = kdqqy_cgbz;
	}

	public String getKdqqy_qrdqbm() {
		return kdqqy_qrdqbm;
	}

	public void setKdqqy_qrdqbm(String kdqqy_qrdqbm) {
		this.kdqqy_qrdqbm = kdqqy_qrdqbm;
	}

	public String getKdqqy_dqbm() {
		return kdqqy_dqbm;
	}

	public void setKdqqy_dqbm(String kdqqy_dqbm) {
		this.kdqqy_dqbm = kdqqy_dqbm;
	}

	public String getKdqqy_yhid() {
		return kdqqy_yhid;
	}

	public void setKdqqy_yhid(String kdqqy_yhid) {
		this.kdqqy_yhid = kdqqy_yhid;
	}

	public String getKdqqy_yhm() {
		return kdqqy_yhm;
	}

	public void setKdqqy_yhm(String kdqqy_yhm) {
		this.kdqqy_yhm = kdqqy_yhm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}