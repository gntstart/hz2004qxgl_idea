package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQhtzxx
    extends DefaultVO {

  private Long mlpnbid; //��¥���ڲ�ID
  private String ssxq; //ʡ���أ�����
  private String jlx; //��·��
  private String mlph; //�ţ�¥���ƺ�
  private String mlxz; //�ţ�¥����ַ
  private String pcs; //�ɳ���
  private String zrq; //������
  private String jcwh; //�ӣ��壩ί��

  public String getJcwh() {
    return jcwh;
  }

  public void setJcwh(String jcwh) {
    this.jcwh = (jcwh != null ? jcwh.trim() : jcwh);
  }

  public String getJlx() {
    return jlx;
  }

  public void setJlx(String jlx) {
    this.jlx = (jlx != null ? jlx.trim() : jlx);
  }

  public String getMlph() {
    return mlph;
  }

  public void setMlph(String mlph) {
    this.mlph = (mlph != null ? mlph.trim() : mlph);
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public String getMlxz() {
    return mlxz;
  }

  public void setMlxz(String mlxz) {
    this.mlxz = (mlxz != null ? mlxz.trim() : mlxz);
  }

  public String getPcs() {
    return pcs;
  }

  public void setPcs(String pcs) {
    this.pcs = (pcs != null ? pcs.trim() : pcs);
  }

  public String getSsxq() {
    return ssxq;
  }

  public void setSsxq(String ssxq) {
    this.ssxq = (ssxq != null ? ssxq.trim() : ssxq);
  }

  public String getZrq() {
    return zrq;
  }

  public void setZrq(String zrq) {
    this.zrq = (zrq != null ? zrq.trim() : zrq);
  }

}