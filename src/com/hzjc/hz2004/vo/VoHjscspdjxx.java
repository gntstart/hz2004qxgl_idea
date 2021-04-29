package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * 户籍删除审批登记信息VO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHjscspdjxx
    extends DefaultVO {

  private Long rynbid; //人员内部ID
  private String hjsclb; //户籍删除类别
  private String hjscsm;//户籍删除说明

  //户证业务ID，特别处理
    private String hzywid;

    public String getHzywid() {
      return hzywid;
    }

    public void setHzywid(String hzywid) {
      this.hzywid = hzywid;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public String getHjsclb() {
    return hjsclb;
  }

  public void setHjsclb(String hjsclb) {
    this.hjsclb = hjsclb;
  }

  public String getHjscsm() {
    return hjscsm;
  }

  public void setHjscsm(String hjscsm) {
    this.hjscsm = hjscsm;
  }

}
