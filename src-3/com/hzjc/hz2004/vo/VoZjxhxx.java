//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjxhxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤��������Ϣ
 */
public class VoZjxhxx
    extends DefaultVO {
  private Long nbsfzid; //�ڲ����֤ID
  private String xhrq; //��������
  private String xhr; //������
  private String xhdw; //���ٵ�λ

  public Long getNbsfzid() {
    return nbsfzid;
  }

  public String getXhdw() {
    return xhdw;
  }

  public String getXhr() {
    return xhr;
  }

  public String getXhrq() {
    return xhrq;
  }

  public void setXhrq(String xhrq) {
    this.xhrq = xhrq;
  }

  public void setXhr(String xhr) {
    this.xhr = xhr;
  }

  public void setXhdw(String xhdw) {
    this.xhdw = xhdw;
  }

  public void setNbsfzid(Long nbsfzid) {
    this.nbsfzid = nbsfzid;
  }

}
