//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjlqfffhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤����ȡ���ŷ�����Ϣ
 */
public class VoZjlqfffhxx
    extends DefaultVO {

  /**
   *
   * @param lNbslid
   * @param lLqffid
   */
  public VoZjlqfffhxx(Long lNbslid, Long lLqffid) {
    setNbslid(lNbslid);
    setLqffid(lLqffid);
  }

  /**
   *
   * @return
   */
  public VoZjlqfffhxx() {

  }

  /**
   * ��ȡ����ID
   */
  private Long lqffid;

  /**
   * �ڲ�����ID
   */
  private Long nbslid;

  public Long getLqffid() {
    return lqffid;
  }

  public Long getNbslid() {
    return nbslid;
  }

  public void setLqffid(Long lqffid) {
    this.lqffid = lqffid;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }
}
