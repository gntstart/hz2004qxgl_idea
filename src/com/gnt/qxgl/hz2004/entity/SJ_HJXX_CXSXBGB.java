package  com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;

public class SJ_HJXX_CXSXBGB implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private String logid;	//LOGID	VARCHAR2(32)	N			KEY
	private String rynbid;	//RYNBID	NUMBER(19)	N			人员内部ID
	private String hjywid;	//HJYWID	NUMBER(19)	N			户籍业务ID
	private String ywlb;	//YWLB	VARCHAR2(20)	Y			业务类别：字典2020
	private String cjsj;	//CJSJ	VARCHAR2(20)	Y			创建时间
	private String bgqcxsx;	//BGQCXSX	VARCHAR2(20)	Y			变更前城乡属性
	private String bghcxsx;	//BGHCXSX	VARCHAR2(20)	Y			变更后城乡属性
	private String bgyy;	//BGYY	VARCHAR2(20)	Y			变更原因
	private String sldw;	//SLDW	CHAR(9)	Y			受理单位
	private String bz;	//BZ	VARCHAR2(200)	Y			备注
	private String bgqdw;	//BGQDW	CHAR(9)	Y			变更前地市
	private String rkbj;	//RKBJ	CHAR(1)	Y			人口标记：0 减少，1 增加
	private String ssxq;	//SSXQ	VARCHAR2(6)	Y			省、市、县
	private String jwhdw;	//JWHDM	VARCHAR2(12)	Y			居委会代码
	private String rysl;	//RYSL	NUMBER(19)	Y			影响人员数量（默认1，主要用于居委会城乡属性调整业务）
	private String nyzyrklhczyydm;	//NYZYRKLHCZYYDM	VARCHAR2(200)	Y			
	
	
	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public String getRynbid() {
		return rynbid;
	}

	public void setRynbid(String rynbid) {
		this.rynbid = rynbid;
	}

	public String getHjywid() {
		return hjywid;
	}

	public void setHjywid(String hjywid) {
		this.hjywid = hjywid;
	}

	public String getYwlb() {
		return ywlb;
	}

	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}

	public String getCjsj() {
		return cjsj;
	}

	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}

	public String getBgqcxsx() {
		return bgqcxsx;
	}

	public void setBgqcxsx(String bgqcxsx) {
		this.bgqcxsx = bgqcxsx;
	}

	public String getBghcxsx() {
		return bghcxsx;
	}

	public void setBghcxsx(String bghcxsx) {
		this.bghcxsx = bghcxsx;
	}

	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

	public String getSldw() {
		return sldw;
	}

	public void setSldw(String sldw) {
		this.sldw = sldw;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getBgqdw() {
		return bgqdw;
	}

	public void setBgqdw(String bgqdw) {
		this.bgqdw = bgqdw;
	}

	public String getRkbj() {
		return rkbj;
	}

	public void setRkbj(String rkbj) {
		this.rkbj = rkbj;
	}

	public String getSsxq() {
		return ssxq;
	}

	public void setSsxq(String ssxq) {
		this.ssxq = ssxq;
	}

	public String getJwhdw() {
		return jwhdw;
	}

	public void setJwhdw(String jwhdw) {
		this.jwhdw = jwhdw;
	}

	public String getRysl() {
		return rysl;
	}

	public void setRysl(String rysl) {
		this.rysl = rysl;
	}

	public String getNyzyrklhczyydm() {
		return nyzyrklhczyydm;
	}

	public void setNyzyrklhczyydm(String nyzyrklhczyydm) {
		this.nyzyrklhczyydm = nyzyrklhczyydm;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
