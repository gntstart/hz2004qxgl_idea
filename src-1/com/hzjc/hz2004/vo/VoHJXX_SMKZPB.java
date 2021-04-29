package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import com.hzjc.hz2004.po.PoHJXX_SMKZPB;

public class VoHJXX_SMKZPB
    extends DefaultVO {

  public VoHJXX_SMKZPB() {

  }

  public VoHJXX_SMKZPB(PoHJXX_SMKZPB po) {
    //�̳л��ദ��
    super(po);
    //////////////////////////////////////////////////////////////////
    //byte[]-->String(����byte[]�ֽ������ֶ�Ҫ���⴦��:Base64����󸳸�VO)
    ///////////////////////////////////////////////////////////////////
    if (po.getZp() != null) {
      this.setZp(new String(encodeBytes(po.getZp())));
    }
  }

  public PoHJXX_SMKZPB toPoHJXX_SMKZPB(PoHJXX_SMKZPB po) {
    if (po == null) {
      po = new PoHJXX_SMKZPB();
    }
    po.setZplsid(this.getZplsid());
    po.setSlh(this.getSlh());
    po.setGmsfhm(this.getGmsfhm());
    po.setBcsj(this.getBcsj());
    po.setZp(decodeBytes(this.getZp() == null ? null :
                         this.getZp().getBytes()));

    return po;
  }

  public PoHJXX_SMKZPB toPoHJXX_SMKZPB() {
    return this.toPoHJXX_SMKZPB(null);
  }

  private Long zplsid;
  private String slh;
  private String gmsfhm;
  private String zp; //����BASE64���б�����ַ�������
  private String bcsj;
  private Long yhid;
  private String ipdz;
  private String yhdlm;
  private String yhdw;
  private String yhxm;

  public String getBcsj() {
    return bcsj;
  }

  public void setBcsj(String bcsj) {
    this.bcsj = bcsj;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getSlh() {
    return slh;
  }

  public void setSlh(String slh) {
    this.slh = slh;
  }

  public String getZp() {
    return zp;
  }

  public void setZp(String zp) {
    this.zp = zp;
  }

  public Long getZplsid() {
    return zplsid;
  }

  public void setZplsid(Long zplsid) {
    this.zplsid = zplsid;
  }

  public String getIpdz() {
    return ipdz;
  }

  public void setIpdz(String ipdz) {
    this.ipdz = ipdz;
  }

  public String getYhdlm() {
    return yhdlm;
  }

  public void setYhdlm(String yhdlm) {
    this.yhdlm = yhdlm;
  }

  public String getYhdw() {
    return yhdw;
  }

  public void setYhdw(String yhdw) {
    this.yhdw = yhdw;
  }

  public Long getYhid() {
    return yhid;
  }

  public void setYhid(Long yhid) {
    this.yhid = yhid;
  }

  public String getYhxm() {
    return yhxm;
  }

  public void setYhxm(String yhxm) {
    this.yhxm = yhxm;
  }

}
