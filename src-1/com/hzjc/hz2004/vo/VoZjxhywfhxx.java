//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjxhywfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤������ҵ�񷵻���Ϣ
 */
public class VoZjxhywfhxx
    extends DefaultVO {

  /**
   * ֤��ҵ��ID
   */
  private Long zjywid;

  /**
   * ֤�����ٷ�����Ϣ
   */
  private VoZjxhfhxx voZjxhfhxx[];

  public VoZjxhfhxx[] getVoZjxhfhxx() {
    return voZjxhfhxx;
  }

  public Long getZjywid() {
    return zjywid;
  }

  public void setVoZjxhfhxx(VoZjxhfhxx[] voZjxhfhxx) {
    this.voZjxhfhxx = voZjxhfhxx;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }

}
