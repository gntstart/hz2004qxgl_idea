package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * Ǩ��������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQcclxx
    extends DefaultVO {

  private Long qcclid; //Ǩ������ID
  private String clbz; //�����־(0-δ����/1-�Ѵ���/2-�Ѵ���+��ӡ���)

  public Long getQcclid() {
    return qcclid;
  }

  public void setQcclid(Long qcclid) {
    this.qcclid = qcclid;
  }

  public String getClbz() {
    return clbz;
  }

  public void setClbz(String clbz) {
    this.clbz = clbz;
  }

}
