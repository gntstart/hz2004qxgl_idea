package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ݺ�����䲹¼ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSfhmfpblywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * ��ݺ�����䲹¼������Ϣ
   */
  private VoSfhmfpblfhxx voSfhmfpblfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoSfhmfpblfhxx[] getVoSfhmfpblfhxx() {
    return voSfhmfpblfhxx;
  }

  public void setVoSfhmfpblfhxx(VoSfhmfpblfhxx[] voSfhmfpblfhxx) {
    this.voSfhmfpblfhxx = voSfhmfpblfhxx;
  }
}
