package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ������ӡ������ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT Corp. 2004</p>
 * <p>Company: </p>
 * @author hb
 * @version 1.0
 */

public class VoHjdyHqxx
    extends DefaultVO {
  private Long rynbid; //��Ա�ڲ�ID
  private String dylb; //��ӡ���
  private String zjbh; //֤�����
  private String yznf; //ӡ�����

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public String getDylb() {
    return dylb;
  }

  public void setDylb(String dylb) {
    this.dylb = dylb;
  }

  public String getZjbh() {
    return zjbh;
  }

  public void setZjbh(String zjbh) {
    this.zjbh = zjbh;
  }

  public String getYznf() {
    return yznf;
  }

  public void setYznf(String yznf) {
    this.yznf = yznf;
  }

}
