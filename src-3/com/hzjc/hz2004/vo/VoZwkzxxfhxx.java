package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

public class VoZwkzxxfhxx  extends DefaultVO {
  public VoZwkzxxfhxx() {
  }

  private Long zwbh;//��ԱID
  private String zwtx;//ָ��ͼ��
  private float txzlz;//ͼ������ֵ


  public void setZwbh(Long zwbh) {
    this.zwbh = zwbh;
  }

  public Long getZwbh() {
    return zwbh;
  }

  public void setZwtx(String zwtx) {
    this.zwtx = zwtx;
  }

  public String getZwtx() {
    return zwtx;
  }

  public void setTxzlz(float txzlz) {
    this.txzlz = txzlz;
  }

  public float getTxzlz() {
    return txzlz;
  }

}
