//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjysywfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤������ҵ�񷵻���Ϣ
 */
public class VoZjysywfhxx
    extends DefaultVO {

  /**
   * ֤��ҵ��ID
   */
  private Long zjywid;

  /**
   * ֤�����շ�����Ϣ
   */
  private VoZjysfhxx voZjysfhxx[];

  public VoZjysfhxx[] getVoZjysfhxx() {
    return voZjysfhxx;
  }

  public Long getZjywid() {
    return zjywid;
  }

  public void setVoZjysfhxx(VoZjysfhxx[] voZjysfhxx) {
    this.voZjysfhxx = voZjysfhxx;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }

}
