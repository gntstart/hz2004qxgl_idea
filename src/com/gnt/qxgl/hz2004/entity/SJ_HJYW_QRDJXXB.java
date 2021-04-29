package com.gnt.qxgl.hz2004.entity;

public class SJ_HJYW_QRDJXXB  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String qrdjid;	//QRDJID	NUMBER(19)	N			迁入登记ID
	private String rynbid;	//RYNBID	NUMBER(19)	N			人员内部ID
	private String qrqhb;	//QRQHB	CHAR(1)	Y			迁入前户别
	private String qrlb;	//QRLB	CHAR(4)	N			迁入类别
	private String qrrq;	//QRRQ	CHAR(8)	N			迁入日期
	private String qcdgjdq;	//QCDGJDQ	CHAR(3)	Y			迁出地国家（地区）
	private String qcdssxq;	//QCDSSXQ	CHAR(6)	Y			迁出地省市县（地区）
	private String qcdpcs;	//QCDPCS	CHAR(9)	Y			迁出地派出所
	private String qcdxzjd;	//QCDXZJD	VARCHAR2(15)	Y			迁出地乡镇街道
	private String qcdjwh;	//QCDJWH	VARCHAR2(15)	Y			迁出地居委会
	private String qcdjlx;	//QCDJLX	VARCHAR2(15)	Y			迁出地街路巷
	private String qcdjwzrq;	//QCDJWZRQ	VARCHAR2(15)	Y			迁出地警务责任区
	private String qcdmlph;	//QCDMLPH	NVARCHAR2(10)	Y			迁出地门楼牌号
	private String qcdxz;	//QCDXZ	NVARCHAR2(100)	Y			迁出地详址
	private String qyzbh;	//QYZBH	VARCHAR2(20)	Y			迁移证编号
	private String zqzbh;	//ZQZBH	VARCHAR2(20)	Y			准迁证编号
	private String nbsfzid;	//NBSFZID	NUMBER(19)	Y			内部身份证ID
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
	private String hb;	//HB	CHAR(1)	Y			户别
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
	private String poxm;	//POXM	NVARCHAR2(20)	Y			配偶姓名
	private String pogmsfhm;	//POGMSFHM	CHAR(18)	Y			配偶公民身份号码
	private String jggjdq;	//JGGJDQ	CHAR(3)	Y			籍贯国家（地区）
	private String jgssxq;	//JGSSXQ	CHAR(6)	Y			籍贯省市县（区）
	private String zjxy;	//ZJXY	CHAR(2)	Y			宗教信仰
	private String whcd;	//WHCD	CHAR(2)	Y			文化程度
	private String hyzk;	//HYZK	CHAR(2)	Y			婚姻状况
	private String byzk;	//BYZK	CHAR(1)	Y			兵役状况
	private String sg;	//SG	VARCHAR2(3)	Y			身高
	private String xx;	//XX	CHAR(1)	Y			血型
	private String zy;	//ZY	NVARCHAR2(20)	Y			职业
	private String zylb;	//ZYLB	CHAR(3)	Y			职业类别
	private String fwcs;	//FWCS	NVARCHAR2(100)	Y			服务处所
	private String xxjb;	//XXJB	CHAR(1)	Y			信息级别
	private String zjlb;	//ZJLB	CHAR(1)	Y			证件类别
	private String qfjg;	//QFJG	NVARCHAR2(100)	Y			签发机关
	private String yxqxqsrq;	//YXQXQSRQ	CHAR(8)	Y			有效期限起始日期
	private String yxqxjzrq;	//YXQXJZRQ	CHAR(8)	Y			有效期限截止日期
	private String dhhm;	//DHHM	NVARCHAR2(100)	Y			电话号码
	private String qtssxq;	//QTSSXQ	CHAR(6)	Y			其他省市县（区）
	private String bz;	//BZ	NVARCHAR2(500)	Y			备注
	private String qtzz;	//QTZZ	NVARCHAR2(100)	Y			其他住址
	private String csdxz;	//CSDXZ	NVARCHAR2(100)	Y			出生地详址
	private String csdgjdq;	//CSDGJDQ	CHAR(3)	Y			出生地国家（地区）
	private String xm;	//XM	NVARCHAR2(20)	Y			姓名
	private String cym;	//CYM	NVARCHAR2(20)	Y			曾用名
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
	private String mlpnbid;	//MLPNBID	NUMBER(19)	Y			门（楼）牌内部ID
	private String yhzgx;	//YHZGX	CHAR(2)	Y			与户主关系
	private String hhid;	//HHID	NUMBER(19)	Y			户号ID
	private String mlpid;	//MLPID	NUMBER(19)	Y			门楼牌ID
	private String hzxm;	//HZXM	NVARCHAR2(20)	Y			户主姓名
	private String hzgmsfhm;	//HZGMSFHM	CHAR(18)	Y			户主公民身份号码
	private String ydblbs;	//YDBLBS	VARCHAR2(1)	Y			一地办理标识
	private String qhtzbs;	//QHTZBS	VARCHAR2(1)	Y			区划调整标识
	private String sbrjtgx;	//SBRJTGX	VARCHAR2(2)	Y			申报人与落户人家庭关系
	private String ycyzjzl;	//YCYZJZL	VARCHAR2(3)	Y			原持有证件种类
	private String ycyzjhm;	//YCYZJHM	NVARCHAR2(30)	Y			原持有证件号码
	private String qyzhyxx;	//QYZHYXX	VARCHAR2(1000)	Y			迁移证核验信息
	private String cxfldm;	//CXFLDM	VARCHAR2(20)	Y			历史城乡代码
	
	
	public String getQrdjid() {
		return qrdjid;
	}

	public void setQrdjid(String qrdjid) {
		this.qrdjid = qrdjid;
	}

	public String getRynbid() {
		return rynbid;
	}

	public void setRynbid(String rynbid) {
		this.rynbid = rynbid;
	}

	public String getQrqhb() {
		return qrqhb;
	}

	public void setQrqhb(String qrqhb) {
		this.qrqhb = qrqhb;
	}

	public String getQrlb() {
		return qrlb;
	}

	public void setQrlb(String qrlb) {
		this.qrlb = qrlb;
	}

	public String getQrrq() {
		return qrrq;
	}

	public void setQrrq(String qrrq) {
		this.qrrq = qrrq;
	}

	public String getQcdgjdq() {
		return qcdgjdq;
	}

	public void setQcdgjdq(String qcdgjdq) {
		this.qcdgjdq = qcdgjdq;
	}

	public String getQcdssxq() {
		return qcdssxq;
	}

	public void setQcdssxq(String qcdssxq) {
		this.qcdssxq = qcdssxq;
	}

	public String getQcdpcs() {
		return qcdpcs;
	}

	public void setQcdpcs(String qcdpcs) {
		this.qcdpcs = qcdpcs;
	}

	public String getQcdxzjd() {
		return qcdxzjd;
	}

	public void setQcdxzjd(String qcdxzjd) {
		this.qcdxzjd = qcdxzjd;
	}

	public String getQcdjwh() {
		return qcdjwh;
	}

	public void setQcdjwh(String qcdjwh) {
		this.qcdjwh = qcdjwh;
	}

	public String getQcdjlx() {
		return qcdjlx;
	}

	public void setQcdjlx(String qcdjlx) {
		this.qcdjlx = qcdjlx;
	}

	public String getQcdjwzrq() {
		return qcdjwzrq;
	}

	public void setQcdjwzrq(String qcdjwzrq) {
		this.qcdjwzrq = qcdjwzrq;
	}

	public String getQcdmlph() {
		return qcdmlph;
	}

	public void setQcdmlph(String qcdmlph) {
		this.qcdmlph = qcdmlph;
	}

	public String getQcdxz() {
		return qcdxz;
	}

	public void setQcdxz(String qcdxz) {
		this.qcdxz = qcdxz;
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

	public String getNbsfzid() {
		return nbsfzid;
	}

	public void setNbsfzid(String nbsfzid) {
		this.nbsfzid = nbsfzid;
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

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
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

	public String getPoxm() {
		return poxm;
	}

	public void setPoxm(String poxm) {
		this.poxm = poxm;
	}

	public String getPogmsfhm() {
		return pogmsfhm;
	}

	public void setPogmsfhm(String pogmsfhm) {
		this.pogmsfhm = pogmsfhm;
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

	public String getZjxy() {
		return zjxy;
	}

	public void setZjxy(String zjxy) {
		this.zjxy = zjxy;
	}

	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getHyzk() {
		return hyzk;
	}

	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}

	public String getByzk() {
		return byzk;
	}

	public void setByzk(String byzk) {
		this.byzk = byzk;
	}

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getXx() {
		return xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getZylb() {
		return zylb;
	}

	public void setZylb(String zylb) {
		this.zylb = zylb;
	}

	public String getFwcs() {
		return fwcs;
	}

	public void setFwcs(String fwcs) {
		this.fwcs = fwcs;
	}

	public String getXxjb() {
		return xxjb;
	}

	public void setXxjb(String xxjb) {
		this.xxjb = xxjb;
	}

	public String getZjlb() {
		return zjlb;
	}

	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}

	public String getQfjg() {
		return qfjg;
	}

	public void setQfjg(String qfjg) {
		this.qfjg = qfjg;
	}

	public String getYxqxqsrq() {
		return yxqxqsrq;
	}

	public void setYxqxqsrq(String yxqxqsrq) {
		this.yxqxqsrq = yxqxqsrq;
	}

	public String getYxqxjzrq() {
		return yxqxjzrq;
	}

	public void setYxqxjzrq(String yxqxjzrq) {
		this.yxqxjzrq = yxqxjzrq;
	}

	public String getDhhm() {
		return dhhm;
	}

	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}

	public String getQtssxq() {
		return qtssxq;
	}

	public void setQtssxq(String qtssxq) {
		this.qtssxq = qtssxq;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getQtzz() {
		return qtzz;
	}

	public void setQtzz(String qtzz) {
		this.qtzz = qtzz;
	}

	public String getCsdxz() {
		return csdxz;
	}

	public void setCsdxz(String csdxz) {
		this.csdxz = csdxz;
	}

	public String getCsdgjdq() {
		return csdgjdq;
	}

	public void setCsdgjdq(String csdgjdq) {
		this.csdgjdq = csdgjdq;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getCym() {
		return cym;
	}

	public void setCym(String cym) {
		this.cym = cym;
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

	public String getSbrjtgx() {
		return sbrjtgx;
	}

	public void setSbrjtgx(String sbrjtgx) {
		this.sbrjtgx = sbrjtgx;
	}

	public String getYcyzjzl() {
		return ycyzjzl;
	}

	public void setYcyzjzl(String ycyzjzl) {
		this.ycyzjzl = ycyzjzl;
	}

	public String getYcyzjhm() {
		return ycyzjhm;
	}

	public void setYcyzjhm(String ycyzjhm) {
		this.ycyzjhm = ycyzjhm;
	}

	public String getQyzhyxx() {
		return qyzhyxx;
	}

	public void setQyzhyxx(String qyzhyxx) {
		this.qyzhyxx = qyzhyxx;
	}

	public String getCxfldm() {
		return cxfldm;
	}

	public void setCxfldm(String cxfldm) {
		this.cxfldm = cxfldm;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}