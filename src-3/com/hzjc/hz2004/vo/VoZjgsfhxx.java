//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjgsfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤����ʧ������Ϣ
 */
public class VoZjgsfhxx
    extends DefaultVO {

  /**
   *
   */
  public VoZjgsfhxx() {

  }

  /**
   *
   * @param lGsslid
   * @param lNbsfzid
   */
  public VoZjgsfhxx(Long lGsslid, Long lNbsfzid) {
    setGsslid(lGsslid);
    setNbsfzid(lNbsfzid);
  }

  /**
   * ��ʧ����ID
   */
  private Long gsslid;

  /**
   * �ڲ����֤ID
   */
  private Long nbsfzid;

  public Long getGsslid() {
    return gsslid;
  }

  public Long getNbsfzid() {
    return nbsfzid;
  }

  public void setGsslid(Long gsslid) {
    this.gsslid = gsslid;
  }

  public void setNbsfzid(Long nbsfzid) {
    this.nbsfzid = nbsfzid;
  }

}
