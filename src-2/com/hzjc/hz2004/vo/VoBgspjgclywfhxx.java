package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

public class VoBgspjgclywfhxx
    extends DefaultVO {

  private Long hjywid; //����ҵ��ID
  private VoBggzfhxx voBggzfhxx[]; //�������������Ϣ
  private VoHcygxtzfhxx voHcygxtzfhxx[]; //����Ա��ϵ����������Ϣ
  private VoBgspjgclfhxx voBgspjgclfhxx[]; //������������������Ϣ

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoBggzfhxx[] getVoBggzfhxx() {
    return voBggzfhxx;
  }

  public void setVoBggzfhxx(VoBggzfhxx[] voBggzfhxx) {
    this.voBggzfhxx = voBggzfhxx;
  }

  public VoHcygxtzfhxx[] getVoHcygxtzfhxx() {
    return voHcygxtzfhxx;
  }

  public void setVoHcygxtzfhxx(VoHcygxtzfhxx[] voHcygxtzfhxx) {
    this.voHcygxtzfhxx = voHcygxtzfhxx;
  }

  public VoBgspjgclfhxx[] getVoBgspjgclfhxx() {
    return voBgspjgclfhxx;
  }

  public void setVoBgspjgclfhxx(VoBgspjgclfhxx[] voBgspjgclfhxx) {
    this.voBgspjgclfhxx = voBgspjgclfhxx;
  }

}