package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * �������ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoBggzywfhxx
    extends DefaultVO {

  private Long hjywid; //����ҵ��ID

  private VoBggzfhxx voBggzfhxx[]; //�������������Ϣ

  private VoHcygxtzfhxx voHcygxtzfhxx[]; //����Ա��ϵ����������Ϣ

  public VoHcygxtzfhxx[] getVoHcygxtzfhxx() {
    return voHcygxtzfhxx;
  }

  public void setVoHcygxtzfhxx(VoHcygxtzfhxx[] voHcygxtzfhxx) {
    this.voHcygxtzfhxx = voHcygxtzfhxx;
  }

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoBggzfhxx[] getVoBggzfhxx() {
    return voBggzfhxx;
  }

  public void setVoBggzfhxx(VoBggzfhxx[] voBggzfhxx) {
    this.voBggzfhxx = voBggzfhxx;
  }

}
