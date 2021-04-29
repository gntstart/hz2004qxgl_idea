package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import com.hzjc.hz2004.po.PoHJSP_HJSPZB;

/**
 * 迁入审批登记子信息(随迁人员信息)
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQrspdjzxx
    extends DefaultVO {

  private String xm; //姓名
  private String xb; //性别
  private String csrq; //出生日期
  private String mz;//民族
  private String gmsfhm; //公民身份号码
  private String ysqrgx; //与申请人关系
  private String yhkqx; //原户口区县
  private String yhkszd; //原户口所在地
  private String hkxz; //户口性质(迁入前户别)
  private String qrhhb; //迁入后户别
  private String gzdw; //工作单位

  public void setXm(String xm) {
    this.xm = xm;
  }

  public String getXm() {
    return xm;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public String getXb() {
    return xb;
  }

  public void setCsrq(String csrq) {
    this.csrq = csrq;
  }

  public String getCsrq() {
    return csrq;
  }

  public void setMz(String mz) {
    this.mz = mz;
  }

  public String getMz() {
    return mz;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setYsqrgx(String ysqrgx) {
    this.ysqrgx = ysqrgx;
  }

  public String getYsqrgx() {
    return ysqrgx;
  }

  public void setYhkqx(String yhkqx) {
    this.yhkqx = yhkqx;
  }

  public String getYhkqx() {
    return yhkqx;
  }

  public void setYhkszd(String yhkszd) {
    this.yhkszd = yhkszd;
  }

  public String getYhkszd() {
    return yhkszd;
  }

  public void setHkxz(String hkxz) {
    this.hkxz = hkxz;
  }

  public String getHkxz() {
    return hkxz;
  }

  public void setGzdw(String gzdw) {
    this.gzdw = gzdw;
  }

  public String getGzdw() {
    return gzdw;
  }

  public String getQrhhb() {
    return qrhhb;
  }

  public void setQrhhb(String qrhhb) {
    this.qrhhb = qrhhb;
  }

}
