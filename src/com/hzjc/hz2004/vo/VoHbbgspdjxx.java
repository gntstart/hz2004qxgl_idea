package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * �����������Ǽ���ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHbbgspdjxx
    extends DefaultVO {

  private Long rynbid; //��Ա�ڲ�ID
  private String hbbglb; //���������
  private String bghhb; //����󻧱�
  private String sbsj; //�걨ʱ��
  private String sbryxm; //�걨��Ա����
  private String sbrgmsfhm; //�걨�˹�����ݺ���

  public String getBghhb() {
    return bghhb;
  }

  public void setBghhb(String bghhb) {
    this.bghhb = bghhb;
  }

  public String getSbrgmsfhm() {
    return sbrgmsfhm;
  }

  public void setSbrgmsfhm(String sbrgmsfhm) {
    this.sbrgmsfhm = sbrgmsfhm;
  }

  public String getSbryxm() {
    return sbryxm;
  }

  public void setSbryxm(String sbryxm) {
    this.sbryxm = sbryxm;
  }

  public String getSbsj() {
    return sbsj;
  }

  public void setSbsj(String sbsj) {
    this.sbsj = sbsj;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public String getHbbglb() {
    return hbbglb;
  }

  public void setHbbglb(String hbbglb) {
    this.hbbglb = hbbglb;
  }

}