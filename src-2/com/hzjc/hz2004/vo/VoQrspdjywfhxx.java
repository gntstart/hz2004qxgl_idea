package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * Ǩ�������Ǽ�ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQrspdjywfhxx
    extends DefaultVO {

  private Long splsid; //������ˮID
  private Long spywid; //����ҵ��ID
  private String xm; //����
  private String gmsfhm; //������ݺ���
  private Long zqid; //׼ǨID
  private VoQrspdjzfhxx voQrspdjzfhxx[]; //Ǩ�������Ǽ��ӷ�����Ϣ(��Ǩ��Ա�ǼǷ�����Ϣ)

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public Long getSpywid() {
    return spywid;
  }

  public void setSpywid(Long spywid) {
    this.spywid = spywid;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public Long getSplsid() {
    return splsid;
  }

  public void setSplsid(Long splsid) {
    this.splsid = splsid;
  }

  public VoQrspdjzfhxx[] getVoQrspdjzfhxx() {
    return voQrspdjzfhxx;
  }

  public void setVoQrspdjzfhxx(VoQrspdjzfhxx[] voQrspdjzfhxx) {
    this.voQrspdjzfhxx = voQrspdjzfhxx;
  }

  public Long getZqid() {
    return zqid;
  }

  public void setZqid(Long zqid) {
    this.zqid = zqid;
  }

}