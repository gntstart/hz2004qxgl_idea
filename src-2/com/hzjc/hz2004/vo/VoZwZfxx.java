package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

public class VoZwZfxx  extends DefaultVO {
  public VoZwZfxx() {
  }

  private Long zwbh;//ָ�Ʊ��
  private Long ryid;//��ԱID
  private Long rynbid;//��ԱID
  private String zfyy;//����ԭ��

  public void setZwbh(Long zwbh) {
    this.zwbh = zwbh;
  }

  public Long getZwbh() {
    return zwbh;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setZfyy(String zfyy) {
    this.zfyy = zfyy;
  }

  public String getZfyy() {
    return zfyy;
  }

}
