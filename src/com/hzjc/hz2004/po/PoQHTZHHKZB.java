package com.hzjc.hz2004.po;

public class PoQHTZHHKZB
    implements com.hzjc.wsstruts.po.PO {

  private Long tzqhhid;//区划调整前户号ID
  private Long tzhhhid;//区划调整后户号ID
  private Long tzqhhnbid;//区划调整前户号内部ID
  private Long tzhhhnbid;//区划调整后户号内部ID
  private String tzsj;//调整时间

  public void setTzqhhid(Long tzqhhid) {
    this.tzqhhid = tzqhhid;
  }

  public Long getTzqhhid() {
    return tzqhhid;
  }

  public void setTzhhhid(Long tzhhhid) {
    this.tzhhhid = tzhhhid;
  }

  public Long getTzhhhid() {
    return tzhhhid;
  }

  public void setTzqhhnbid(Long tzqhhnbid) {
    this.tzqhhnbid = tzqhhnbid;
  }

  public Long getTzqhhnbid() {
    return tzqhhnbid;
  }

  public void setTzhhhnbid(Long tzhhhnbid) {
    this.tzhhhnbid = tzhhhnbid;
  }

  public Long getTzhhhnbid() {
    return tzhhhnbid;
  }

  public void setTzsj(String tzsj) {
    this.tzsj = tzsj;
  }

  public String getTzsj() {
    return tzsj;
  }

}
