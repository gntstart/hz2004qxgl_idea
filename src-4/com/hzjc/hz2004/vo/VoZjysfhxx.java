package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤�����շ�����Ϣ
 */
public class VoZjysfhxx
    extends DefaultVO {

  private Long ysslid; //��������ID
  private Long nbslid; //�ڲ�����ID

  public Long getNbslid() {
    return nbslid;
  }

  public Long getYsslid() {
    return ysslid;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }

  public void setYsslid(Long ysslid) {
    this.ysslid = ysslid;
  }

}
