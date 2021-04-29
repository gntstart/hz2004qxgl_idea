package com.hzjc.hz2004.po;

import java.util.Date;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2013</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class CzrkDyls {
  private Date dysj;
  private String dyyh;
  private Long hhnbid;//»§ºÅÄÚ²¿ID
  private String lsid;

  public CzrkDyls() {
  }

  public void setLsid(String lsid) {
    this.lsid = lsid;
  }

  public void setDyyh(String dyyh) {
    this.dyyh = dyyh;
  }

  public void setDysj(Date dysj) {
    this.dysj = dysj;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public String getLsid() {
    return lsid;
  }

  public String getDyyh() {
    return dyyh;
  }

  public Date getDysj() {
    return dysj;
  }

  public Long getHhnbid() {
    return hhnbid;
  }
}
