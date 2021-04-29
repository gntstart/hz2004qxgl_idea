package  com.hzjc.hz2004.po;

import java.util.Date;

public class PoXT_YHXXB implements com.hzjc.wsstruts.po.PO
{
  private Long yhid;
  private String yhdlm;
  private String jyh;
  private String dwdm;
  private String yhxm;
  private String yhxb;
  private String yhzw;
  private String dlkl;
  private String yhmj;
  private String czmj;
  private String yhzt;
  private String gmsfhm;
  private String khmsg;
  private Date khgxsj;

  private String txnr;

  public String getTxnr(){
    return txnr;
  }

  public void setTxnr(String txnr){
    this.txnr = txnr;
  }

  public void setKhgxsj(Date khgxsj) {
    this.khgxsj = khgxsj;
  }

  public Date getKhgxsj() {
    return khgxsj;
  }

  public void setKhmsg(String khmsg) {
    this.khmsg = khmsg;
  }

  public String getKhmsg() {
    return khmsg;
  }

  public void setYhid(Long yhid) {
    this.yhid = yhid;
  }

  public Long getYhid() {
    return yhid;
  }

  public void setYhdlm(String yhdlm) {
    this.yhdlm = yhdlm;
  }

  public String getYhdlm() {
    return yhdlm;
  }

  public void setJyh(String jyh) {
    this.jyh = jyh;
  }

  public String getJyh() {
    return jyh;
  }

  public void setDwdm(String dwdm) {
    this.dwdm = dwdm;
  }

  public String getDwdm() {
    return dwdm;
  }

  public void setYhxm(String yhxm) {
    this.yhxm = yhxm;
  }

  public String getYhxm() {
    return yhxm;
  }

  public void setYhxb(String yhxb) {
    this.yhxb = yhxb;
  }

  public String getYhxb() {
    return yhxb;
  }

  public void setYhzw(String yhzw) {
    this.yhzw = yhzw;
  }

  public String getYhzw() {
    return yhzw;
  }

  public void setDlkl(String dlkl) {
    this.dlkl = dlkl;
  }

  public String getDlkl() {
    return dlkl;
  }

  public void setYhmj(String yhmj) {
    this.yhmj = yhmj;
  }

  public String getYhmj() {
    return yhmj;
  }

  public void setCzmj(String czmj) {
    this.czmj = czmj;
  }

  public String getCzmj() {
    return czmj;
  }

  public void setYhzt(String yhzt) {
    this.yhzt = yhzt;
  }

  public String getYhzt() {
    return yhzt;
  }
  public String getGmsfhm() {
    return gmsfhm;
  }
  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

}
