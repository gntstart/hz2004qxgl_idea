package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;
import java.util.Date;

public class YWLOG implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String logid;//	varchar2(32)	n			key
	private String dqbm;//	varchar2(6)	n			地区编码
	private String dqmc;//	varchar2(100)	n			地区名称
	private String dlyh;//	varchar2(40)	n			地区登陆用户
	private String sfzh;//	varchar2(20)	y			登录人员身份证号
	private String xm;//	varchar2(80)	y			姓名
	private Date czsj;//	date	n			操作时间
	private String ywlx;//	varchar2(20)	n			业务类型
	private String params;//	clob	y			业务参数
	private Long hs;//	number(10)	n			耗时
	private String cljg;//	varchar2(20)	n			处理结果：0 成功，1 失败
	private String cwyy;//	clob	y			错误原因
	private String ywlxmc;//	varchar2(100)	y			业务类型名称
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getDqbm() {
		return dqbm;
	}
	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}
	public String getDqmc() {
		return dqmc;
	}
	public void setDqmc(String dqmc) {
		this.dqmc = dqmc;
	}
	public String getDlyh() {
		return dlyh;
	}
	public void setDlyh(String dlyh) {
		this.dlyh = dlyh;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public Date getCzsj() {
		return czsj;
	}
	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}
	public String getYwlx() {
		return ywlx;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public Long getHs() {
		return hs;
	}
	public void setHs(Long hs) {
		this.hs = hs;
	}
	public String getCljg() {
		return cljg;
	}
	public void setCljg(String cljg) {
		this.cljg = cljg;
	}
	public String getCwyy() {
		return cwyy;
	}
	public void setCwyy(String cwyy) {
		this.cwyy = cwyy;
	}
	public String getYwlxmc() {
		return ywlxmc;
	}
	public void setYwlxmc(String ywlxmc) {
		this.ywlxmc = ywlxmc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
