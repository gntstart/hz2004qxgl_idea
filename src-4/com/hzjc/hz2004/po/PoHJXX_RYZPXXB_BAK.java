package  com.hzjc.hz2004.po;

public class PoHJXX_RYZPXXB_BAK implements com.hzjc.wsstruts.po.PO
{
  private String logid;
  private String scsj;
  private Long yhid;
  private Long zpid;
  private Long ryid;
  private String gmsfhm;
  private String xm;
  private byte[] zp;
  private String lrrq;

  public String getLogid() {
        return logid;
}

public void setLogid(String logid) {
        this.logid = logid;
}

public String getScsj() {
        return scsj;
}

public void setScsj(String scsj) {
        this.scsj = scsj;
}

public Long getYhid() {
        return yhid;
}

public void setYhid(Long yhid) {
        this.yhid = yhid;
}

public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public Long getZpid() {
    return zpid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public Long getRyid() {
    return ryid;
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

  public void setZp(byte[] zp) {
    this.zp = zp;
  }

  public byte[] getZp() {
    return zp;
  }

  public void setLrrq(String lrrq) {
    this.lrrq = lrrq;
  }

  public String getLrrq() {
    return lrrq;
  }

}
