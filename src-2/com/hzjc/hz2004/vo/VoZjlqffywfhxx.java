//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjlqffywfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤����ȡ����ҵ�񷵻���Ϣ
 */
public class VoZjlqffywfhxx
    extends DefaultVO {

  /**
   * ֤��ҵ��ID
   */
  private Long zjywid;

  /**
   * ֤����ȡ������Ϣ����
   */
  private VoZjlqfffhxx voZjlqfffhxx[];

  public VoZjlqfffhxx[] getVoZjlqfffhxx() {
    return voZjlqfffhxx;
  }

  public void setVoZjlqfffhxx(VoZjlqfffhxx[] voZjlqfffhxx) {
    this.voZjlqfffhxx = voZjlqfffhxx;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }

  public Long getZjywid() {
    return zjywid;
  }
}
