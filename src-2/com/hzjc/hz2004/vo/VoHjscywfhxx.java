package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����ɾ��ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHjscywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * ����ɾ��������Ϣ
   */
  private VoHjscfhxx voHjscfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  /**
   * �������������Ϣ
   */
  private VoBggzfhxx voBggzfhxx[];

  private VoHcygxtzfhxx voHcygxtzfhxx[]; //����Ա��ϵ����������Ϣ

  public VoHcygxtzfhxx[] getVoHcygxtzfhxx() {
    return voHcygxtzfhxx;
  }

  public void setVoHcygxtzfhxx(VoHcygxtzfhxx[] voHcygxtzfhxx) {
    this.voHcygxtzfhxx = voHcygxtzfhxx;
  }

  public VoBggzfhxx[] getVoBggzfhxx() {
    return voBggzfhxx;
  }

  public void setVoBggzfhxx(VoBggzfhxx[] voBggzfhxx) {
    this.voBggzfhxx = voBggzfhxx;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoHjscfhxx[] getVoHjscfhxx() {
    return voHjscfhxx;
  }

  public void setVoHjscfhxx(VoHjscfhxx[] voHjscfhxx) {
    this.voHjscfhxx = voHjscfhxx;
  }

}
