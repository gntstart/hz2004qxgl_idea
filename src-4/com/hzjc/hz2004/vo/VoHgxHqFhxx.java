package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import com.hzjc.hz2004.po.PoHJXX_HGLGXB;
import com.hzjc.hz2004.po.PoHJXX_HXXB;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

public class VoHgxHqFhxx
    extends DefaultVO {

  //��������ϵ��Ϣ
  private Long glid; //����ID
  private Long hhid; //����ID
  private Long glhhid; //��������ID
  private String glgx; //������ϵ
  private String jljlsj; //��¼����ʱ��
  private Long jljlrid; //��¼������ID
  private String zt; //״̬

  //�������Ļ���Ϣ
  private Long hhnbid; //�����ڲ�ID
  private Long mlpnbid; //��¥���ڲ�ID
  private String hh; //����
  private String hlx; //������
  private String jhlb; //�������
  private String chlb; //�������
  private String jhsj; //����ʱ��
  private String chsj; //����ʱ��
  private Long cjhjywid; //��������ҵ��ID
  private Long cchjywid; //��������ҵ��ID
  private String bdfw; //�䶯��Χ
  private String bdyy; //�䶯ԭ��
  private String hhzt; //����״̬
  private Long lxdbid; //����DBID
  private String jlbz; //��¼��־
  private String qysj; //����ʱ��
  private String jssj; //����ʱ��
  private String cxbz; //������־

  public VoHgxHqFhxx() {
  }

  public VoHgxHqFhxx(PoHJXX_HGLGXB poHglgx, PoHJXX_HXXB poHxx) {
    try {
      BeanUtils.copyProperties(this, poHglgx);
      BeanUtils.copyProperties(this, poHxx);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }
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

  public Long getCchjywid() {
    return cchjywid;
  }

  public void setCchjywid(Long cchjywid) {
    this.cchjywid = cchjywid;
  }

  public String getChlb() {
    return chlb;
  }

  public void setChlb(String chlb) {
    this.chlb = chlb;
  }

  public String getChsj() {
    return chsj;
  }

  public void setChsj(String chsj) {
    this.chsj = chsj;
  }

  public Long getCjhjywid() {
    return cjhjywid;
  }

  public void setCjhjywid(Long cjhjywid) {
    this.cjhjywid = cjhjywid;
  }

  public String getCxbz() {
    return cxbz;
  }

  public void setCxbz(String cxbz) {
    this.cxbz = cxbz;
  }

  public String getGlgx() {
    return glgx;
  }

  public void setGlgx(String glgx) {
    this.glgx = glgx;
  }

  public Long getGlhhid() {
    return glhhid;
  }

  public void setGlhhid(Long glhhid) {
    this.glhhid = glhhid;
  }

  public Long getGlid() {
    return glid;
  }

  public void setGlid(Long glid) {
    this.glid = glid;
  }

  public String getHh() {
    return hh;
  }

  public void setHh(String hh) {
    this.hh = hh;
  }

  public Long getHhid() {
    return hhid;
  }

  public void setHhid(Long hhid) {
    this.hhid = hhid;
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public String getHhzt() {
    return hhzt;
  }

  public void setHhzt(String hhzt) {
    this.hhzt = hhzt;
  }

  public String getHlx() {
    return hlx;
  }

  public void setHlx(String hlx) {
    this.hlx = hlx;
  }

  public String getJhlb() {
    return jhlb;
  }

  public void setJhlb(String jhlb) {
    this.jhlb = jhlb;
  }

  public String getJhsj() {
    return jhsj;
  }

  public void setJhsj(String jhsj) {
    this.jhsj = jhsj;
  }

  public String getJlbz() {
    return jlbz;
  }

  public void setJlbz(String jlbz) {
    this.jlbz = jlbz;
  }

  public Long getJljlrid() {
    return jljlrid;
  }

  public void setJljlrid(Long jljlrid) {
    this.jljlrid = jljlrid;
  }

  public String getJljlsj() {
    return jljlsj;
  }

  public void setJljlsj(String jljlsj) {
    this.jljlsj = jljlsj;
  }

  public String getJssj() {
    return jssj;
  }

  public void setJssj(String jssj) {
    this.jssj = jssj;
  }

  public Long getLxdbid() {
    return lxdbid;
  }

  public void setLxdbid(Long lxdbid) {
    this.lxdbid = lxdbid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public String getQysj() {
    return qysj;
  }

  public void setQysj(String qysj) {
    this.qysj = qysj;
  }

  public String getZt() {
    return zt;
  }

  public void setZt(String zt) {
    this.zt = zt;
  }

}