package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ������ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoPzxx
    extends DefaultVO {

  private String gmsfhm; //������ݺ���
  private String slh; //�����
  private String zp; //��Ƭ����
  private String pzxlh; //�������к�

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public void setSlh(String slh) {
    this.slh = slh;
  }

  public String getSlh() {
    return slh;
  }

  public String getZp() {
    return zp;
  }

  public void setZp(String zp) {
    this.zp = zp;
  }

  public String getPzxlh() {
    return pzxlh;
  }

  public void setPzxlh(String pzxlh) {
    this.pzxlh = pzxlh;
  }

}