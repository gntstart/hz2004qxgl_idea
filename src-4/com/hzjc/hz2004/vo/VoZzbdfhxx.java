package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * סַ�䶯������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoZzbdfhxx
    extends DefaultVO {

  private Long zzbdid; //סַ�䶯ID
  private Long rynbid; //��Ա�ڲ�ID
  private Long ryid; //��ԱID
  private Long old_rynbid;
  private Long hhnbid; //�����ڲ�ID
  private Long old_hhnbid;
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

  public Long getZzbdid() {
    return zzbdid;
  }

  public void setZzbdid(Long zzbdid) {
    this.zzbdid = zzbdid;
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public Long getOld_hhnbid() {
    return old_hhnbid;
  }

  public void setOld_hhnbid(Long old_hhnbid) {
    this.old_hhnbid = old_hhnbid;
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

  public String getYhzgx() {
    return yhzgx;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

}
