package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����Ա��ϵ������Ϣ_��ǿ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHcygxtzxxEx
    extends DefaultVO {

  private int flag; //�Ƿ���Ҫ�޸ĳ�ס�˿���Ϣ���еĶ�Ӧ��¼(0-���޸�/1-�޸�)
  private Long hhnbid; //�����ڲ�ID
  private Long ryid; //��ԱID
  private String old_yhzgx; //ԭ�뻧����ϵ
  private String hcybdlx; //����Ա�䶯����
  private String hcybdlb; //����Ա�䶯���
  private Long rynbid; //��Ա�ڲ�ID
  private String yhzgx; //�뻧����ϵ
  private Long sbhjywid; //�ϱʻ���ҵ��ID
  private String xm; //����
  private String gmsfhm; //������ݺ���
  private Long new_rynbid; //�µ���Ա�ڲ�ID

  public String getHcybdlx() {
    return hcybdlx;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public String getYhzgx() {
    return yhzgx;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

  public void setHcybdlx(String hcybdlx) {
    this.hcybdlx = hcybdlx;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  public String getOld_yhzgx() {
    return old_yhzgx;
  }

  public void setOld_yhzgx(String old_yhzgx) {
    this.old_yhzgx = old_yhzgx;
  }

  public Long getSbhjywid() {
    return sbhjywid;
  }

  public void setSbhjywid(Long sbhjywid) {
    this.sbhjywid = sbhjywid;
  }

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

  public Long getNew_rynbid() {
    return new_rynbid;
  }

  public void setNew_rynbid(Long new_rynbid) {
    this.new_rynbid = new_rynbid;
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public String getHcybdlb() {
    return hcybdlb;
  }

  public void setHcybdlb(String hcybdlb) {
    this.hcybdlb = hcybdlb;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

}
