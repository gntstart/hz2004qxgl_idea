package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ݺ�����䲹¼��Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSfhmfpblxx
    extends DefaultVO {

  //������ݺ���
  private String gmsfhm;

  //�Ա�
  private String xb;

  //����
  private String xm;

  //��λ����
  private String dwdm;

  public String getDwdm() {
    return dwdm;
  }

  public void setDwdm(String dwdm) {
    this.dwdm = dwdm;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getXb() {
    return xb;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

}
