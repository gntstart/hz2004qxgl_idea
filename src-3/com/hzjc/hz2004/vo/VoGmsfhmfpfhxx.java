package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ������ݺ�����䷵����Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoGmsfhmfpfhxx
    extends DefaultVO {

  //����ID
  private Long fpid;

  //������ݺ���
  private String gmsfhm;

  public Long getFpid() {
    return fpid;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public void setFpid(Long fpid) {
    this.fpid = fpid;
  }

}