//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjlqffxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤����ȡ������Ϣ
 */
public class VoZjlqffxx
    extends DefaultVO {
  private Long nbslid; //�ڲ�����ID
  private String lqfs; //��ȡ�������
  private String lqrq; //��ȡ����
  private String lqrxm; //��ȡ������
  private String lqrsfhm; //��ȡ����ݺ���
  private String zjddrq;//֤����������

  public String getLqrq() {
    return lqrq;
  }

  public String getLqrsfhm() {
    return lqrsfhm;
  }

  public String getLqrxm() {
    return lqrxm;
  }

  public String getZjddrq() {
    return zjddrq;
  }

  public Long getNbslid() {
    return nbslid;
  }

  public void setZjddrq(String zjddrq) {
    this.zjddrq = zjddrq;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }

  public void setLqrxm(String lqrxm) {
    this.lqrxm = lqrxm;
  }

  public void setLqrsfhm(String lqrsfhm) {
    this.lqrsfhm = lqrsfhm;
  }

  public void setLqrq(String lqrq) {
    this.lqrq = lqrq;
  }

  public void setLqfs(String lqfs) {
    this.lqfs = lqfs;
  }

  public String getLqfs() {
    return lqfs;
  }

}
