//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjgsxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤����ʧ��Ϣ
 */
public class VoZjgsxx
    extends DefaultVO {
  private Long nbsfzid; //�ڲ����֤ID
  private String ysdd; //��ʧ�ص�
  private String ysrq; //��ʧ����
  private String gsrxm; //��ʧ������
  private String gsrgmsfhm; //��ʧ�˹�����ݺ���

  public String getGsrgmsfhm() {
    return gsrgmsfhm;
  }

  public String getGsrxm() {
    return gsrxm;
  }

  public Long getNbsfzid() {
    return nbsfzid;
  }

  public String getYsdd() {
    return ysdd;
  }

  public String getYsrq() {
    return ysrq;
  }

  public void setYsrq(String ysrq) {
    this.ysrq = ysrq;
  }

  public void setYsdd(String ysdd) {
    this.ysdd = ysdd;
  }

  public void setNbsfzid(Long nbsfzid) {
    this.nbsfzid = nbsfzid;
  }

  public void setGsrxm(String gsrxm) {
    this.gsrxm = gsrxm;
  }

  public void setGsrgmsfhm(String gsrgmsfhm) {
    this.gsrgmsfhm = gsrgmsfhm;
  }

}
