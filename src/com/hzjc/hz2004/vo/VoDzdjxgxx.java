package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ַ�����޸���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoDzdjxgxx
    extends DefaultVO {

  private Long mlpdjid; //�ţ�¥���ƶ���ID
  private String djfs; //���᷽ʽ
  private String djlx; //��������
  private String ssxq; //ʡ���أ�����
  private String jlx; //��·��
  private String jcwh; //�ӣ��壩ί��
  private String mlph; //�ţ�¥���ƺ�
  private String mlxz; //�ţ�¥����ַ
  private String qyrq; //��������
  private String jzrq; //��ֹ����
  public String getDjfs() {
    return djfs;
  }

  public void setDjfs(String djfs) {
    this.djfs = djfs;
  }

  public String getDjlx() {
    return djlx;
  }

  public void setDjlx(String djlx) {
    this.djlx = djlx;
  }

  public String getJcwh() {
    return jcwh;
  }

  public void setJcwh(String jcwh) {
    this.jcwh = jcwh;
  }

  public String getJlx() {
    return jlx;
  }

  public void setJlx(String jlx) {
    this.jlx = jlx;
  }

  public String getJzrq() {
    return jzrq;
  }

  public void setJzrq(String jzrq) {
    this.jzrq = jzrq;
  }

  public Long getMlpdjid() {
    return mlpdjid;
  }

  public void setMlpdjid(Long mlpdjid) {
    this.mlpdjid = mlpdjid;
  }

  public String getMlph() {
    return mlph;
  }

  public void setMlph(String mlph) {
    this.mlph = mlph;
  }

  public String getMlxz() {
    return mlxz;
  }

  public void setMlxz(String mlxz) {
    this.mlxz = mlxz;
  }

  public String getQyrq() {
    return qyrq;
  }

  public void setQyrq(String qyrq) {
    this.qyrq = qyrq;
  }

  public String getSsxq() {
    return ssxq;
  }

  public void setSsxq(String ssxq) {
    this.ssxq = ssxq;
  }

}
