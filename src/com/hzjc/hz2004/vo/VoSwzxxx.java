package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����ע����Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSwzxxx
    extends DefaultVO {

  private Long rynbid; //��Ա�ڲ�ID
  private String swrq; //��������
  private String swzmbh; //����֤�����
  private String swzxlb; //����ע�����
  private String bdfw; //�䶯��Χ
  private Long sbhjywid; //�ϱʻ���ҵ��ID
  private String  sbrjtgx;

  public String getBdfw() {
    return bdfw;
  }

  public void setBdfw(String bdfw) {
    this.bdfw = bdfw;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public String getSwrq() {
    return swrq;
  }

  public void setSwrq(String swrq) {
    this.swrq = swrq;
  }

  public String getSwzmbh() {
    return swzmbh;
  }

  public void setSwzmbh(String swzmbh) {
    this.swzmbh = swzmbh;
  }

  public String getSwzxlb() {
    return swzxlb;
  }

  public void setSwzxlb(String swzxlb) {
    this.swzxlb = swzxlb;
  }

  public Long getSbhjywid() {
    return sbhjywid;
  }

  public void setSbhjywid(Long sbhjywid) {
    this.sbhjywid = sbhjywid;
  }
  public String getSbrjtgx() {
          return sbrjtgx;
  }
  public void setSbrjtgx(String sbrjtgx) {
          this.sbrjtgx = sbrjtgx;
  }


}
