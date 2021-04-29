package  com.hzjc.hz2004.po;


public class PoYDZJ_SDZP implements com.hzjc.wsstruts.po.PO
{
  private Long zpid;
  private String gmsfhm;
  private String xm;
  private byte[] sdzp;
  private String lrsj;

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public Long getZpid() {
    return zpid;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public String getXm() {
    return xm;
  }

  public void setSdzp(byte[] sdzp) {
    this.sdzp = sdzp;
  }

  public byte[] getSdzp() {
    return sdzp;
  }

  public void setLrsj(String lrsj) {
    this.lrsj = lrsj;
  }

  public String getLrsj() {
    return lrsj;
  }

}
