package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڹ���ϵͳHz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: �㽭����Ԫ�¼������޹�˾</p>
 * @author kgb_hz@126.com,kgb@primetech.com.cn
 * @version 1.0
 */

public class VoZjshxx
    extends DefaultVO {

  private Long nbslid; //�ڲ�����ID
  private String shqk; //������
  private String zzxxcwlb; //��֤��Ϣ�������
  private String cwms; //��������

  public Long getNbslid() {
    return nbslid;
  }

  public String getShqk() {
    return shqk;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }

  public void setShqk(String shqk) {
    this.shqk = shqk;
  }

  public String getCwms() {
    return cwms;
  }

  public void setCwms(String cwms) {
    this.cwms = cwms;
  }

  public String getZzxxcwlb() {
    return zzxxcwlb;
  }

  public void setZzxxcwlb(String zzxxcwlb) {
    this.zzxxcwlb = zzxxcwlb;
  }

}