package com.hzjc.hz2004.po;

public class PoHJXX_ZPLSB
    implements com.hzjc.wsstruts.po.PO {

  private Long zplsid;
  private String slh;
  private String gmsfhm;
  private Long zpid;
  private Long ryid;
  private Long rynbid;
  private byte[] zp;
  private String bcsj;
  private Long czrid;
  private String jlbz;

  public byte[] getZp() {
    return zp;
  }

  public void setZp(byte[] zp) {
    this.zp = zp;
  }

  public Long getZpid() {
    return zpid;
  }

  public Long getZplsid() {
    return zplsid;
  }

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public void setZplsid(Long zplsid) {
    this.zplsid = zplsid;
  }

  public String getSlh() {
    return slh;
  }

  public void setSlh(String slh) {
    this.slh = slh;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public Long getCzrid() {
    return czrid;
  }

  public void setCzrid(Long czrid) {
    this.czrid = czrid;
  }

  public void setBcsj(String bcsj) {
    this.bcsj = bcsj;
  }

  public String getBcsj() {
    return bcsj;
  }

  public void setJlbz(String jlbz) {
    this.jlbz = jlbz;
  }

  public String getJlbz() {
    return jlbz;
  }
}
