package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����ϵɾ����ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHgxscxx
    extends DefaultVO {

  private Long glid; //����ID
  private Long hhid; //����ID
  private Long glhhid; //��������ID

  public Long getGlhhid() {
    return glhhid;
  }

  public void setGlhhid(Long glhhid) {
    this.glhhid = glhhid;
  }

  public Long getGlid() {
    return glid;
  }

  public void setGlid(Long glid) {
    this.glid = glid;
  }

  public Long getHhid() {
    return hhid;
  }

  public void setHhid(Long hhid) {
    this.hhid = hhid;
  }

}