//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjgsywfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤����ʧҵ�񷵻���Ϣ
 */
public class VoZjgsywfhxx
    extends DefaultVO {

  /**
   * ֤��ҵ��ID
   */
  private Long zjywid;

  /**
   * ֤����ʧ������Ϣ
   */
  private VoZjgsfhxx voZjgsfhxx[];

  public VoZjgsfhxx[] getVoZjgsfhxx() {
    return voZjgsfhxx;
  }

  public Long getZjywid() {
    return zjywid;
  }

  public void setVoZjgsfhxx(VoZjgsfhxx[] voZjgsfhxx) {
    this.voZjgsfhxx = voZjgsfhxx;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }

}
