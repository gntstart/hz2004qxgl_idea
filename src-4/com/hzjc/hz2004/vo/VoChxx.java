package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * �غ���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoChxx
    extends DefaultVO {

  private String chsfhm; //�غ���ݺ���
  private String chxm; //�غ�����
  private Long bchryid; //���غ���ԱID

  public Long getBchryid() {
    return bchryid;
  }

  public void setBchryid(Long bchryid) {
    this.bchryid = bchryid;
  }

  public String getChsfhm() {
    return chsfhm;
  }

  public void setChsfhm(String chsfhm) {
    this.chsfhm = chsfhm;
  }

  public String getChxm() {
    return chxm;
  }

  public void setChxm(String chxm) {
    this.chxm = chxm;
  }

}