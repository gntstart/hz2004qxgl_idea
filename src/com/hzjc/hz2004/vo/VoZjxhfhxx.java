//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjxhfhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤�����ٷ�����Ϣ
 */
public class VoZjxhfhxx
    extends DefaultVO {

  /**
   *
   */
  public VoZjxhfhxx() {

  }

  /**
   *
   * @param lXhxxid
   * @param lNbsfzid
   */
  public VoZjxhfhxx(Long lXhxxid, Long lNbsfzid) {
    setXhxxid(lXhxxid);
    setNbsfzid(lNbsfzid);
  }

  /**
   * ������ϢID
   */
  private Long xhxxid;

  /**
   * �ڲ����֤ID
   */
  private Long nbsfzid;
  public Long getNbsfzid() {
    return nbsfzid;
  }

  public Long getXhxxid() {
    return xhxxid;
  }

  public void setNbsfzid(Long nbsfzid) {
    this.nbsfzid = nbsfzid;
  }

  public void setXhxxid(Long xhxxid) {
    this.xhxxid = xhxxid;
  }

}
