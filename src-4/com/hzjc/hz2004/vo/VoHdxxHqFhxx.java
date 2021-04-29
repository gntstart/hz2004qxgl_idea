package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoHJXX_HXXB;
import com.hzjc.hz2004.po.PoHJXX_MLPXXXXB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * ������Ϣ��ȡ������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHdxxHqFhxx
    extends DefaultVO {

  //����Ϣ
  private Long hhnbid; //�����ڲ�ID
  private Long hhid; //����ID
  private Long mlpnbid; //�ţ�¥�����ڲ�ID
  private String hh; //����
  private String hlx; //������
  private Long cjhjywid; //��������ҵ��ID
  private Long cchjywid; //��������ҵ��ID
  private String hhzt; //����״̬
  private Long lxdbid; //����DBID
  private String jlbz; //��¼��־
  private String qysj; //����ʱ��
  private String jssj; //����ʱ��
  private String bdfw; //�䶯��Χ
  private String bdyy; //�䶯ԭ��
  private String chlb; //�������
  private String jhlb; //�������
  private String jhsj; //����ʱ��
  private String chsj; //����ʱ��
  private String cxbz; //������־

  //����Ϣ
  private Long mlpid; //�ţ�¥����ID
  private String ssxq; //ʡ���أ�����
  private String jlx; //��·��
  private String mlph; //�ţ�¥���ƺ�
  private String mlxz; //�ţ�¥����ַ
  private String pcs; //�ɳ���
  private String zrq; //������
  private String xzjd; //���򣨽ֵ���
  private String jcwh; //�ӣ��壩ί��
  private String mlpzt; //�ţ�¥����״̬
  private String pxh; //�����
  private String cdlb; //�������
  private String jdlb; //�������
  private String jdsj; //����ʱ��
  private String cdsj; //����ʱ��

  public VoHdxxHqFhxx(PoHJXX_HXXB poHJXX_HXXB, PoHJXX_MLPXXXXB poHJXX_MLPXXXXB) {

    try {
      BeanUtils.copyProperties(this, poHJXX_MLPXXXXB);
      BeanUtils.copyProperties(this, poHJXX_HXXB);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

  }

  public Long getCjhjywid() {
    return cjhjywid;
  }

  public Long getCchjywid() {
    return cchjywid;
  }

  public String getHh() {
    return hh;
  }

  public Long getHhid() {
    return hhid;
  }

  public void setCjhjywid(Long cjhjywid) {
    this.cjhjywid = cjhjywid;
  }

  public void setCchjywid(Long cchjywid) {
    this.cchjywid = cchjywid;
  }

  public void setHh(String hh) {
    this.hh = hh;
  }

  public void setHhid(Long hhid) {
    this.hhid = hhid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public void setHhzt(String hhzt) {
    this.hhzt = hhzt;
  }

  public void setHlx(String hlx) {
    this.hlx = hlx;
  }

  public void setJcwh(String jcwh) {
    this.jcwh = jcwh;
  }

  public String getJcwh() {
    return jcwh;
  }

  public String getHlx() {
    return hlx;
  }

  public String getHhzt() {
    return hhzt;
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public String getJlbz() {
    return jlbz;
  }

  public void setJlbz(String jlbz) {
    this.jlbz = jlbz;
  }

  public String getJlx() {
    return jlx;
  }

  public void setJlx(String jlx) {
    this.jlx = jlx;
  }

  public String getJssj() {
    return jssj;
  }

  public Long getLxdbid() {
    return lxdbid;
  }

  public String getMlph() {
    return mlph;
  }

  public void setJssj(String jssj) {
    this.jssj = jssj;
  }

  public void setLxdbid(Long lxdbid) {
    this.lxdbid = lxdbid;
  }

  public void setMlph(String mlph) {
    this.mlph = mlph;
  }

  public Long getMlpid() {
    return mlpid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public String getMlpzt() {
    return mlpzt;
  }

  public void setMlpid(Long mlpid) {
    this.mlpid = mlpid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public void setMlpzt(String mlpzt) {
    this.mlpzt = mlpzt;
  }

  public String getMlxz() {
    return mlxz;
  }

  public String getPcs() {
    return pcs;
  }

  public String getPxh() {
    return pxh;
  }

  public void setMlxz(String mlxz) {
    this.mlxz = mlxz;
  }

  public void setPcs(String pcs) {
    this.pcs = pcs;
  }

  public void setPxh(String pxh) {
    this.pxh = pxh;
  }

  public String getQysj() {
    return qysj;
  }

  public String getSsxq() {
    return ssxq;
  }

  public String getXzjd() {
    return xzjd;
  }

  public String getZrq() {
    return zrq;
  }

  public void setZrq(String zrq) {
    this.zrq = zrq;
  }

  public void setXzjd(String xzjd) {
    this.xzjd = xzjd;
  }

  public void setSsxq(String ssxq) {
    this.ssxq = ssxq;
  }

  public void setQysj(String qysj) {
    this.qysj = qysj;
  }

  public String getCdlb() {
    return cdlb;
  }

  public void setCdlb(String cdlb) {
    this.cdlb = cdlb;
  }

  public String getChlb() {
    return chlb;
  }

  public void setChlb(String chlb) {
    this.chlb = chlb;
  }

  public String getJdlb() {
    return jdlb;
  }

  public void setJdlb(String jdlb) {
    this.jdlb = jdlb;
  }

  public String getJhlb() {
    return jhlb;
  }

  public void setJhlb(String jhlb) {
    this.jhlb = jhlb;
  }

  public String getCdsj() {
    return cdsj;
  }

  public void setCdsj(String cdsj) {
    this.cdsj = cdsj;
  }

  public String getChsj() {
    return chsj;
  }

  public void setChsj(String chsj) {
    this.chsj = chsj;
  }

  public String getJdsj() {
    return jdsj;
  }

  public void setJdsj(String jdsj) {
    this.jdsj = jdsj;
  }

  public String getJhsj() {
    return jhsj;
  }

  public void setJhsj(String jhsj) {
    this.jhsj = jhsj;
  }

  public String getCxbz() {
    return cxbz;
  }

  public void setCxbz(String cxbz) {
    this.cxbz = cxbz;
  }

  public String getBdfw() {
    return bdfw;
  }

  public void setBdfw(String bdfw) {
    this.bdfw = bdfw;
  }

  public String getBdyy() {
    return bdyy;
  }

  public void setBdyy(String bdyy) {
    this.bdyy = bdyy;
  }

}