//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjslywfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤������ҵ�񷵻���Ϣ
 */
public class VoZjslywfhxx
    extends DefaultVO {

  private Long zjywid; //֤��ҵ��ID
  private VoZjslfhxx voZjslfhxx[]; //֤����������Ϣ

  public VoZjslfhxx[] getVoZjslfhxx() {
    return voZjslfhxx;
  }

  public void setVoZjslfhxx(VoZjslfhxx[] voZjslfhxx) {
    this.voZjslfhxx = voZjslfhxx;
  }

  public Long getZjywid() {
    return zjywid;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }

}
