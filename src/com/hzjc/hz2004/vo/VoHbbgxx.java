package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHbbgxx
    extends DefaultVO {

  //��������Ϣ
  private Long rynbid; //��Ա�ڲ�ID
  private String bghhb; //����󻧱�
  private String hbbglb; //���������
  private String bdfw; //�䶯��Χ
  private String hbbgrq; //����������
  private Long sbhjywid; //�ϱʻ���ҵ��ID

  //������Ϣ
  private Long spywid; //����ҵ��ID

  public String getBdfw() {
    return bdfw;
  }

  public void setBdfw(String bdfw) {
    this.bdfw = bdfw;
  }

  public void setBghhb(String bghhb) {
    this.bghhb = bghhb;
  }

  public String getBghhb() {
    return bghhb;
  }

  public String getHbbglb() {
    return hbbglb;
  }

  public void setHbbglb(String hbbglb) {
    this.hbbglb = hbbglb;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public Long getSbhjywid() {
    return sbhjywid;
  }

  public void setSbhjywid(Long sbhjywid) {
    this.sbhjywid = sbhjywid;
  }

  public String getHbbgrq() {
    return hbbgrq;
  }

  public void setHbbgrq(String hbbgrq) {
    this.hbbgrq = hbbgrq;
  }

  public Long getSpywid() {
    return spywid;
  }

  public void setSpywid(Long spywid) {
    this.spywid = spywid;
  }

}
