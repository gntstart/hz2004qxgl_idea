package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ������ݺ������������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@mail.com
 * @version 1.0
 */
public class VoGmsfhmfpsqxx
    extends DefaultVO {

  private Long ryid; //��ԱID
  private String xm; //����
  private String xb; //�Ա�
  private String csrq; //��������
  private String xzqh; //��������
  private String pcs; //�ɳ���
  private String xzjd; //����ֵ�

  public Long getRyid() {
    return ryid;
  }

  public String getXb() {
    return xb;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public String getXzqh() {
    return xzqh;
  }

  public void setXzqh(String xzqh) {
    this.xzqh = xzqh;
  }

  public String getCsrq() {
    return csrq;
  }

  public void setCsrq(String csrq) {
    this.csrq = csrq;
  }

  public String getXzjd() {
    return xzjd;
  }

  public void setXzjd(String xzjd) {
    this.xzjd = xzjd;
  }

  public String getPcs() {
    return pcs;
  }

  public void setPcs(String pcs) {
    this.pcs = pcs;
  }

}