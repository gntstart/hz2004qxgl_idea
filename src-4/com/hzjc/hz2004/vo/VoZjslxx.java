package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤��������Ϣ
 */
public class VoZjslxx
    extends DefaultVO {
  private Long nbslid; //�ڲ�����ID
  //������Ϣ
  private Long rynbid; //��Ա�ڲ�ID
  private String yxqxqsrq; //��Ч������ʼ��
  private String yxqxjzrq; //��Ч���޽�ֹ��
  private String slyy; //����ԭ��
  private String zzlx; //��֤����
  private String lqfs; //��֤��ʽ
  private String sflx; //�շ�����
  private Float sfje; //�շѽ��
  private Long zpid; //��ƬID
  //Ͷ����Ϣ
  private String sjrxm; //�ռ�������
  private String sjrlxdh; //�ռ�����ϵ�绰
  private String sjryb; //�ռ����ʱ�
  private String sjrtxdz; //�ռ���ͨѶ��ַ

  private String zplylx;//��Ƭ��Դ����(0-��Դ����Ա��Ƭ�� / 1-��Դ����Ƭ��ʱ�� / ����-����Ƭ)
  private String bwbhb;

  public String getLqfs() {
    return lqfs;
  }

  public void setLqfs(String lqfs) {
    this.lqfs = lqfs;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public Float getSfje() {
    return sfje;
  }

  public String getSflx() {
    return sflx;
  }

  public String getSlyy() {
    return slyy;
  }

  public String getYxqxjzrq() {
    return yxqxjzrq;
  }

  public String getYxqxqsrq() {
    return yxqxqsrq;
  }

  public Long getZpid() {
    return zpid;
  }

  public String getZzlx() {
    return zzlx;
  }

  public void setZzlx(String zzlx) {
    this.zzlx = zzlx;
  }

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public void setYxqxqsrq(String yxqxqsrq) {
    this.yxqxqsrq = yxqxqsrq;
  }

  public void setYxqxjzrq(String yxqxjzrq) {
    this.yxqxjzrq = yxqxjzrq;
  }

  public void setSlyy(String slyy) {
    this.slyy = slyy;
  }

  public void setSflx(String sflx) {
    this.sflx = sflx;
  }

  public void setSfje(Float sfje) {
    this.sfje = sfje;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getNbslid() {
    return nbslid;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }

  public String getZplylx() {
    return zplylx;
  }

  public void setZplylx(String zplylx) {
    this.zplylx = zplylx;
  }

  public String getSjrlxdh() {
    return sjrlxdh;
  }

  public void setSjrlxdh(String sjrlxdh) {
    this.sjrlxdh = sjrlxdh;
  }

  public String getSjrtxdz() {
    return sjrtxdz;
  }

  public void setSjrtxdz(String sjrtxdz) {
    this.sjrtxdz = sjrtxdz;
  }

  public String getSjrxm() {
    return sjrxm;
  }

  public void setSjrxm(String sjrxm) {
    this.sjrxm = sjrxm;
  }

  public String getSjryb() {
    return sjryb;
  }

  public void setSjryb(String sjryb) {
    this.sjryb = sjryb;
  }
  public String getBwbhb() {
    return bwbhb;
  }
  public void setBwbhb(String bwbhb) {
    this.bwbhb = bwbhb;
  }

}
