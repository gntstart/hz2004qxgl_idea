package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ݺ�����䲹¼������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSfhmfpblfhxx
    extends DefaultVO {

  /**
   * ����ID
   */
  private Long fpid;

  /**
   * ��ԱID
   */
  private Long ryid;

  /**
   * ������ݺ���
   */
  private String gmsfhm;

  public Long getFpid() {
    return fpid;
  }

  public void setFpid(Long fpid) {
    this.fpid = fpid;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }
}
