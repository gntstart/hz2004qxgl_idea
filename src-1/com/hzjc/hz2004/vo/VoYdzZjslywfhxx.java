//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoYdzZjslywfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * һ��֤֤������ҵ�񷵻���Ϣ
 */
public class VoYdzZjslywfhxx
    extends DefaultVO {

  /**
   * ֤��ҵ��ID
   */
  private Long zjywid;

  /**
   * һ��֤֤����������Ϣ
   */
  private VoYdzZjslfhxx voYdzZjslfhxx[];

  public VoYdzZjslfhxx[] getVoYdzZjslfhxx() {
    return voYdzZjslfhxx;
  }

  public Long getZjywid() {
    return zjywid;
  }

  public void setVoYdzZjslfhxx(VoYdzZjslfhxx[] voYdzZjslfhxx) {
    this.voYdzZjslfhxx = voYdzZjslfhxx;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }
}
