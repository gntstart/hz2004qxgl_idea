package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * �����Ǽ�ҵ�񷵻���ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoCsdjywfhxx
    extends DefaultVO {

  private Long hjywid; //����ҵ��ID
  private Long mlpnbid; //�ţ�¥�����ڲ�ID
  private Long hhnbid; //�����ڲ�ID
  private VoCsdjfhxx voCsdjfhxx[]; //�����ǼǷ�����Ϣ
  private VoBggzfhxx voBggzfhxx[]; //�������������Ϣ
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

  public Long getHhnbid() {
    return hhnbid;
  }

  public Long getHjywid() {
    return hjywid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public VoCsdjfhxx[] getVoCsdjfhxx() {
    return voCsdjfhxx;
  }

  public void setVoCsdjfhxx(VoCsdjfhxx[] voCsdjfhxx) {
    this.voCsdjfhxx = voCsdjfhxx;
  }

}
