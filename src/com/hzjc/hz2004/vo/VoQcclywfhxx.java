package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * Ǩ������ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQcclywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * Ǩ����������Ϣ
   */
  private VoQcclfhxx voQcclfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoQcclfhxx[] getVoQcclfhxx() {
    return voQcclfhxx;
  }

  public void setVoQcclfhxx(VoQcclfhxx[] voQcclfhxx) {
    this.voQcclfhxx = voQcclfhxx;
  }

}
