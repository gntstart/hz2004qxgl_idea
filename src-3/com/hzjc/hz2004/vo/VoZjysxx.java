//Source file: C:\\hz2004\\com\\hzjc\\hz2004\\vo\\VoZjysxx.java

package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤��������Ϣ
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author Kansan Ku(kgb_hz@126.com)
 * @version 1.0
 */
public class VoZjysxx
    extends DefaultVO {

  private Long nbslid; //�ڲ�����ID
  private String zzxxcwlb; //��֤��Ϣ�������
  private String cwms; //��������

  public String getCwms() {
    return cwms;
  }

  public Long getNbslid() {
    return nbslid;
  }

  public String getZzxxcwlb() {
    return zzxxcwlb;
  }

  public void setCwms(String cwms) {
    this.cwms = cwms;
  }

  public void setZzxxcwlb(String zzxxcwlb) {
    this.zzxxcwlb = zzxxcwlb;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }

}
