package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����Ա��ϵ������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHcygxtzxx
    extends DefaultVO {

  /**
   * ��Ա�ڲ�ID
   */
  private Long rynbid;

  /**
   * �뻧����ϵ
   */
  private String yhzgx;

  /*
   * �ϱʻ���ҵ��ID
   */
  private Long sbhjywid;

  private String hcybdlb; //����Ա�䶯���

  public Long getRynbid() {
    return rynbid;
  }

  public String getYhzgx() {
    return yhzgx;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getSbhjywid() {
    return sbhjywid;
  }

  public void setSbhjywid(Long sbhjywid) {
    this.sbhjywid = sbhjywid;
  }

  public String getHcybdlb() {
    return hcybdlb;
  }

  public void setHcybdlb(String hcybdlb) {
    this.hcybdlb = hcybdlb;
  }

}
