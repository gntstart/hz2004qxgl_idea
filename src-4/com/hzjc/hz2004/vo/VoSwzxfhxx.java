package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����ע��������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSwzxfhxx
    extends DefaultVO {

  private Long swzxid; //����ע��ID
  private Long rynbid; //��Ա�ڲ�ID
  private Long ryid; //��ԱID
  private Long old_rynbid;
  private Long hhnbid; //�����ڲ�ID
  private String xm; //����
  private String gmsfhm; //������ݺ���
  private String yhzgx; //�뻧����ϵ

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getSwzxid() {
    return swzxid;
  }

  public void setSwzxid(Long swzxid) {
    this.swzxid = swzxid;
  }

  public Long getOld_rynbid() {
    return old_rynbid;
  }

  public void setOld_rynbid(Long old_rynbid) {
    this.old_rynbid = old_rynbid;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public String getYhzgx() {
    return yhzgx;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

}
