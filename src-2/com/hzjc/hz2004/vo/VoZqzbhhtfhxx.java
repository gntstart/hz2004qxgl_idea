package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ׼Ǩ֤��Ż������ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoZqzbhhtfhxx
    extends DefaultVO {

  private Long zqid; //׼ǨID
  private String zqzjlx; //׼Ǩ֤������
  private String zjbh; //֤�����
  private String sqrgmsfhm; //�����˹������ݺ���
  private String sqrxm; //����������

  public String getSqrgmsfhm() {
    return sqrgmsfhm;
  }

  public void setSqrgmsfhm(String sqrgmsfhm) {
    this.sqrgmsfhm = sqrgmsfhm;
  }

  public String getSqrxm() {
    return sqrxm;
  }

  public void setSqrxm(String sqrxm) {
    this.sqrxm = sqrxm;
  }

  public Long getZqid() {
    return zqid;
  }

  public void setZqid(Long zqid) {
    this.zqid = zqid;
  }

  public String getZjbh() {
    return zjbh;
  }

  public void setZjbh(String zjbh) {
    this.zjbh = zjbh;
  }

  public String getZqzjlx() {
    return zqzjlx;
  }

  public void setZqzjlx(String zqzjlx) {
    this.zqzjlx = zqzjlx;
  }

}