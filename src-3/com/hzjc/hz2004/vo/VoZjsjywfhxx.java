//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjsjywfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤���ս�ҵ�񷵻���Ϣ
 */
public class VoZjsjywfhxx
    extends DefaultVO {

  /**
   * ֤��ҵ��ID
   */
  private Long zjywid;

  /**
   * ֤���ս�������Ϣ
   */
  private VoZjsjfhxx voZjsjfhxx[];

  public VoZjsjfhxx[] getVoZjsjfhxx() {
    return voZjsjfhxx;
  }

  public Long getZjywid() {
    return zjywid;
  }

  public void setVoZjsjfhxx(VoZjsjfhxx[] voZjsjfhxx) {
    this.voZjsjfhxx = voZjsjfhxx;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }

}
