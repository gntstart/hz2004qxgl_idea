package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * �˻�����ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoRhflywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * �˻����뷵����Ϣ
   */
  private VoRhflfhxx voRhflfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoRhflfhxx[] getVoRhflfhxx() {
    return voRhflfhxx;
  }

  public void setVoRhflfhxx(VoRhflfhxx[] voRhflfhxx) {
    this.voRhflfhxx = voRhflfhxx;
  }

}
