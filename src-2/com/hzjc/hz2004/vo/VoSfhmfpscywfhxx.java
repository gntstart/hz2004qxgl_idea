package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ݺ������ɾ��ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSfhmfpscywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * ��ݺ�����䲹¼������Ϣ
   */
  private VoSfhmfpscfhxx voSfhmfpscfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoSfhmfpscfhxx[] getVoSfhmfpscfhxx() {
    return voSfhmfpscfhxx;
  }

  public void setVoSfhmfpscfhxx(VoSfhmfpscfhxx[] voSfhmfpscfhxx) {
    this.voSfhmfpscfhxx = voSfhmfpscfhxx;
  }

}