package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * Ǩ��֤��Ż�����Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQyzbhhtxx
    extends DefaultVO {
  public VoQyzbhhtxx() {
  }

  private Long dysx; //��ӡ˳��(1�ǳ�֤��)
  private Long hjywid; //����ҵ��ID
  private Long rynbid; //��Ա�ڲ�ID
  private String qyzbh; //Ǩ��֤���
  private String yczrgx; //���֤�˹�ϵ
  private String qfrq; //ǩ������(Ǩ��֤��ǩ������)(��֤����)
  private String yxqxjzrq; //��Ч���޽�ֹ����(��֤����)
  //add hb 20060828
  private String yznf;//ӡ�����

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public String getQyzbh() {
    return qyzbh;
  }

  public void setQyzbh(String qyzbh) {
    this.qyzbh = qyzbh;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getDysx() {
    return dysx;
  }

  public void setDysx(Long dysx) {
    this.dysx = dysx;
  }

  public String getYczrgx() {
    return yczrgx;
  }

  public void setYczrgx(String yczrgx) {
    this.yczrgx = yczrgx;
  }

  public String getQfrq() {
    return qfrq;
  }

  public void setQfrq(String qfrq) {
    this.qfrq = qfrq;
  }

  public String getYxqxjzrq() {
    return yxqxjzrq;
  }

  public void setYxqxjzrq(String yxqxjzrq) {
    this.yxqxjzrq = yxqxjzrq;
  }

  public String getYznf() {
    return yznf;
  }

  public void setYznf(String yznf) {
    this.yznf = yznf;
  }

}
