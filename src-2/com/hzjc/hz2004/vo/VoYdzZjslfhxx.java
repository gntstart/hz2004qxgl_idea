//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoYdzZjslfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * һ��֤֤����������Ϣ
 */
public class VoYdzZjslfhxx
    extends DefaultVO {

  /**
   *
   */
  public VoYdzZjslfhxx() {

  }

  /**
   *
   * @param lBzslid
   * @param lRynbid
   */
  public VoYdzZjslfhxx(Long lBzslid, Long lRynbid) {
    setBzslid(lBzslid);
    setRynbid(lRynbid);
  }

  /**
   * ��֤����ID
   */
  private Long bzslid;

  /**
   * ��Ա�ڲ�ID
   */
  private Long rynbid;

  public Long getBzslid() {
    return bzslid;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setBzslid(Long bzslid) {
    this.bzslid = bzslid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }
}
