package com.hzjc.hz2004.po;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class PoTJ_CXJGBCRZB implements com.hzjc.wsstruts.po.PO{
  private Long cxrzid;//查询日志ID
  private String gnbh;//功能编号
  private String cxyj;//查询语句
  private String bcsj;//保存时间
  private Long czrid;//操作人ID
  private String czrdw;//操作人单位

  public void setCxrzid(Long cxrzid) {
    this.cxrzid = cxrzid;
  }

  public Long getCxrzid() {
    return cxrzid;
  }

  public void setGnbh(String gnbh) {
    this.gnbh = gnbh;
  }

  public String getGnbh() {
    return gnbh;
  }

  public void setCxyj(String cxyj) {
    this.cxyj = cxyj;
  }

  public String getCxyj() {
    return cxyj;
  }

  public void setBcsj(String bcsj) {
    this.bcsj = bcsj;
  }

  public String getBcsj() {
    return bcsj;
  }

  public void setCzrid(Long czrid) {
    this.czrid = czrid;
  }

  public Long getCzrid() {
    return czrid;
  }

  public void setCzrdw(String czrdw) {
    this.czrdw = czrdw;
  }

  public String getCzrdw() {
    return czrdw;
  }

}
