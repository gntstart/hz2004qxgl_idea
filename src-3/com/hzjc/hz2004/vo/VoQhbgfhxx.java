package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ȫ�����������ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQhbgfhxx
    extends DefaultVO {

  private Long hhnbid; //�����ڲ�ID
  private Long old_hhnbid; //�ϵĻ����ڲ�ID
  private Long mlpnbid; //��¥���ڲ�ID
  private Long old_mlpnbid; //�ϵ���¥���ڲ�ID

  public VoQhbgfhxx() {
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public Long getOld_hhnbid() {
    return old_hhnbid;
  }

  public void setOld_hhnbid(Long old_hhnbid) {
    this.old_hhnbid = old_hhnbid;
  }

  public Long getOld_mlpnbid() {
    return old_mlpnbid;
  }

  public void setOld_mlpnbid(Long old_mlpnbid) {
    this.old_mlpnbid = old_mlpnbid;
  }

}