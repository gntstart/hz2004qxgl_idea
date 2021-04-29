package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoHJSP_HJBLSPSQB;
import com.hzjc.hz2004.po.PoHJSP_HJSPLSB;
import com.hzjc.hz2004.po.PoXT_SPDZB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * ������¼����������Ϣ��ȡ������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */

public class VoHjblspspxxHqFhxx {

  //������¼������Ϣ
  private Long spywid; //����ҵ��ID
  private String gmsfhm; //������ݺ���
  private String xm; //����
  private String cym; //������
  private String xb; //�Ա�
  private String mz; //����
  private String csrq; //��������
  private String cssj; //����ʱ��
  private String csdgjdq; //�����ع��ң�������
  private String csdssxq; //������ʡ���أ�����
  private String csdxz; //��������ַ
  private String jggjdq; //������ң�������
  private String jgssxq; //����ʡ���أ�����
  private String jhryxm; //�໤��һ����
  private String jhrygmsfhm; //�໤��һ������ݺ���
  private String jhryjhgx; //�໤��һ�໤��ϵ
  private String jhrexm; //�໤�˶�����
  private String jhregmsfhm; //�໤�˶�������ݺ���
  private String jhrejhgx; //�໤�˶��໤��ϵ
  private String fqgmsfhm; //���׹�����ݺ���
  private String fqxm; //��������
  private String mqgmsfhm; //ĸ�׹�����ݺ���
  private String mqxm; //ĸ������
  private String pogmsfhm; //��ż������ݺ���
  private String poxm; //��ż����
  private String zjxy; //�ڽ�����
  private String whcd; //�Ļ��̶�
  private String hyzk; //����״��
  private String byzk; //����״��
  private String sg; //���
  private String xx; //Ѫ��
  private String zy; //ְҵ
  private String zylb; //ְҵ���
  private String fwcs; //������
  private String xxjb; //��Ϣ����
  private String hb; //����
  private String cszmbh; //����֤�����
  private String ssssxq; //����ʡ������
  private String sspcs; //�����ɳ���
  private String ssjwh; //������ί��
  private String ssjlx; //������·��
  private String ssxzjd; //��������ֵ�
  private String ssjwzrq; //��������������
  private String ssmlph; //������¥�ƺ�
  private String ssxz; //������ַ
  private Long sshhid; //��������ID
  private String sshh; //��������
  private String sshlx; //����������
  private String yhzgx; //�뻧����ϵ
  private String rlhbz; //��������־
  private String blyy; //��¼ԭ��
  private Long djrid; //�Ǽ���ID
  private String djsj; //�Ǽ�ʱ��
  private Long xydzid; //��һ����ID
  private Long spmbid; //����ģ��ID
  private String spjg; //�������
  private String lsbz; //��ʵ��־
  private Long rynbid; //��Ա�ڲ�ID
  private Long hjywid; //����ҵ��ID
  private String spsm; //����˵��
  private Long ywxl; //ҵ������

  //������ˮ��Ϣ
  private Long splsid; //������ˮID
  //private Long spywid; //����ҵ��ID
  //private String splx;//��������
  private Long dzid; //����ID
  private String czjg; //�������
  private String czyj; //�������
  private Long czrid; //������ID
  private String czsj; //����ʱ��

  //����������Ϣ
  //private Long dzid; //����ID
  private String dzmc; //��������
  private String ms; //����
  private String qybz; //���ñ�־

  //��һ����_����������Ϣ
  private String xydz_dzmc; //��������
  private String xydz_ms; //����
  private String xydz_qybz; //���ñ�־

  public VoHjblspspxxHqFhxx() {
  }

  public VoHjblspspxxHqFhxx(PoHJSP_HJBLSPSQB poHjblspsqxx,
                            PoHJSP_HJSPLSB poHjsplsxx,
                            PoXT_SPDZB poSpdzxx, PoXT_SPDZB poXyspdzxx) {
    try {
      if (poHjblspsqxx != null) {
        BeanUtils.copyProperties(this, poHjblspsqxx);
      }
      if (poHjsplsxx != null) {
        BeanUtils.copyProperties(this, poHjsplsxx);
      }
      if (poSpdzxx != null) {
        BeanUtils.copyProperties(this, poSpdzxx);
      }
      if (poXyspdzxx != null) {
        this.setXydz_dzmc(poXyspdzxx.getDzmc());
        this.setXydz_ms(poXyspdzxx.getMs());
        this.setXydz_qybz(poXyspdzxx.getQybz());
      }
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

  }

  public String getCzjg() {
    return czjg;
  }

  public void setCzjg(String czjg) {
    this.czjg = czjg;
  }

  public Long getCzrid() {
    return czrid;
  }

  public void setCzrid(Long czrid) {
    this.czrid = czrid;
  }

  public String getCzsj() {
    return czsj;
  }

  public void setCzsj(String czsj) {
    this.czsj = czsj;
  }

  public String getCzyj() {
    return czyj;
  }

  public void setCzyj(String czyj) {
    this.czyj = czyj;
  }

  public Long getDzid() {
    return dzid;
  }

  public void setDzid(Long dzid) {
    this.dzid = dzid;
  }

  public String getDzmc() {
    return dzmc;
  }

  public void setDzmc(String dzmc) {
    this.dzmc = dzmc;
  }

  public String getMs() {
    return ms;
  }

  public void setMs(String ms) {
    this.ms = ms;
  }

  public String getQybz() {
    return qybz;
  }

  public void setQybz(String qybz) {
    this.qybz = qybz;
  }

  public Long getSplsid() {
    return splsid;
  }

  public void setSplsid(Long splsid) {
    this.splsid = splsid;
  }

  public void setXydz_dzmc(String xydz_dzmc) {
    this.xydz_dzmc = xydz_dzmc;
  }

  public String getXydz_dzmc() {
    return xydz_dzmc;
  }

  public String getXydz_ms() {
    return xydz_ms;
  }

  public void setXydz_ms(String xydz_ms) {
    this.xydz_ms = xydz_ms;
  }

  public String getXydz_qybz() {
    return xydz_qybz;
  }

  public void setXydz_qybz(String xydz_qybz) {
    this.xydz_qybz = xydz_qybz;
  }

  public String getBlyy() {
    return blyy;
  }

  public void setBlyy(String blyy) {
    this.blyy = blyy;
  }

  public String getByzk() {
    return byzk;
  }

  public void setByzk(String byzk) {
    this.byzk = byzk;
  }

  public String getCsdgjdq() {
    return csdgjdq;
  }

  public void setCsdgjdq(String csdgjdq) {
    this.csdgjdq = csdgjdq;
  }

  public String getCsdssxq() {
    return csdssxq;
  }

  public void setCsdssxq(String csdssxq) {
    this.csdssxq = csdssxq;
  }

  public String getCsdxz() {
    return csdxz;
  }

  public void setCsdxz(String csdxz) {
    this.csdxz = csdxz;
  }

  public String getCsrq() {
    return csrq;
  }

  public void setCsrq(String csrq) {
    this.csrq = csrq;
  }

  public String getCssj() {
    return cssj;
  }

  public void setCssj(String cssj) {
    this.cssj = cssj;
  }

  public String getCszmbh() {
    return cszmbh;
  }

  public void setCszmbh(String cszmbh) {
    this.cszmbh = cszmbh;
  }

  public String getCym() {
    return cym;
  }

  public void setCym(String cym) {
    this.cym = cym;
  }

  public Long getDjrid() {
    return djrid;
  }

  public void setDjrid(Long djrid) {
    this.djrid = djrid;
  }

  public String getDjsj() {
    return djsj;
  }

  public void setDjsj(String djsj) {
    this.djsj = djsj;
  }

  public String getFqgmsfhm() {
    return fqgmsfhm;
  }

  public void setFqgmsfhm(String fqgmsfhm) {
    this.fqgmsfhm = fqgmsfhm;
  }

  public String getFqxm() {
    return fqxm;
  }

  public void setFqxm(String fqxm) {
    this.fqxm = fqxm;
  }

  public String getFwcs() {
    return fwcs;
  }

  public void setFwcs(String fwcs) {
    this.fwcs = fwcs;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getHb() {
    return hb;
  }

  public void setHb(String hb) {
    this.hb = hb;
  }

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public String getHyzk() {
    return hyzk;
  }

  public void setHyzk(String hyzk) {
    this.hyzk = hyzk;
  }

  public String getJggjdq() {
    return jggjdq;
  }

  public void setJggjdq(String jggjdq) {
    this.jggjdq = jggjdq;
  }

  public String getJgssxq() {
    return jgssxq;
  }

  public void setJgssxq(String jgssxq) {
    this.jgssxq = jgssxq;
  }

  public String getJhregmsfhm() {
    return jhregmsfhm;
  }

  public void setJhregmsfhm(String jhregmsfhm) {
    this.jhregmsfhm = jhregmsfhm;
  }

  public String getJhrejhgx() {
    return jhrejhgx;
  }

  public void setJhrejhgx(String jhrejhgx) {
    this.jhrejhgx = jhrejhgx;
  }

  public String getJhrexm() {
    return jhrexm;
  }

  public void setJhrexm(String jhrexm) {
    this.jhrexm = jhrexm;
  }

  public String getJhrygmsfhm() {
    return jhrygmsfhm;
  }

  public void setJhrygmsfhm(String jhrygmsfhm) {
    this.jhrygmsfhm = jhrygmsfhm;
  }

  public String getJhryjhgx() {
    return jhryjhgx;
  }

  public void setJhryjhgx(String jhryjhgx) {
    this.jhryjhgx = jhryjhgx;
  }

  public String getJhryxm() {
    return jhryxm;
  }

  public void setJhryxm(String jhryxm) {
    this.jhryxm = jhryxm;
  }

  public String getLsbz() {
    return lsbz;
  }

  public void setLsbz(String lsbz) {
    this.lsbz = lsbz;
  }

  public String getMqgmsfhm() {
    return mqgmsfhm;
  }

  public void setMqgmsfhm(String mqgmsfhm) {
    this.mqgmsfhm = mqgmsfhm;
  }

  public String getMqxm() {
    return mqxm;
  }

  public void setMqxm(String mqxm) {
    this.mqxm = mqxm;
  }

  public String getMz() {
    return mz;
  }

  public void setMz(String mz) {
    this.mz = mz;
  }

  public String getPogmsfhm() {
    return pogmsfhm;
  }

  public void setPogmsfhm(String pogmsfhm) {
    this.pogmsfhm = pogmsfhm;
  }

  public String getPoxm() {
    return poxm;
  }

  public void setPoxm(String poxm) {
    this.poxm = poxm;
  }

  public String getRlhbz() {
    return rlhbz;
  }

  public void setRlhbz(String rlhbz) {
    this.rlhbz = rlhbz;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public String getSg() {
    return sg;
  }

  public void setSpjg(String spjg) {
    this.spjg = spjg;
  }

  public String getSpjg() {
    return spjg;
  }

  public void setSg(String sg) {
    this.sg = sg;
  }

  public void setSpmbid(Long spmbid) {
    this.spmbid = spmbid;
  }

  public Long getSpmbid() {
    return spmbid;
  }

  public Long getSpywid() {
    return spywid;
  }

  public void setSpywid(Long spywid) {
    this.spywid = spywid;
  }

  public void setSshh(String sshh) {
    this.sshh = sshh;
  }

  public String getSshh() {
    return sshh;
  }

  public Long getSshhid() {
    return sshhid;
  }

  public String getSshlx() {
    return sshlx;
  }

  public void setSshhid(Long sshhid) {
    this.sshhid = sshhid;
  }

  public void setSshlx(String sshlx) {
    this.sshlx = sshlx;
  }

  public String getSsjlx() {
    return ssjlx;
  }

  public void setSsjlx(String ssjlx) {
    this.ssjlx = ssjlx;
  }

  public String getSsjwh() {
    return ssjwh;
  }

  public void setSsjwh(String ssjwh) {
    this.ssjwh = ssjwh;
  }

  public String getSsjwzrq() {
    return ssjwzrq;
  }

  public void setSsjwzrq(String ssjwzrq) {
    this.ssjwzrq = ssjwzrq;
  }

  public String getSsmlph() {
    return ssmlph;
  }

  public void setSsmlph(String ssmlph) {
    this.ssmlph = ssmlph;
  }

  public String getSspcs() {
    return sspcs;
  }

  public void setSsssxq(String ssssxq) {
    this.ssssxq = ssssxq;
  }

  public String getSsssxq() {
    return ssssxq;
  }

  public void setSspcs(String sspcs) {
    this.sspcs = sspcs;
  }

  public String getSsxz() {
    return ssxz;
  }

  public void setSsxz(String ssxz) {
    this.ssxz = ssxz;
  }

  public String getSsxzjd() {
    return ssxzjd;
  }

  public void setSsxzjd(String ssxzjd) {
    this.ssxzjd = ssxzjd;
  }

  public String getWhcd() {
    return whcd;
  }

  public void setWhcd(String whcd) {
    this.whcd = whcd;
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

  public String getXx() {
    return xx;
  }

  public void setXxjb(String xxjb) {
    this.xxjb = xxjb;
  }

  public String getXxjb() {
    return xxjb;
  }

  public void setXx(String xx) {
    this.xx = xx;
  }

  public Long getXydzid() {
    return xydzid;
  }

  public void setXydzid(Long xydzid) {
    this.xydzid = xydzid;
  }

  public String getYhzgx() {
    return yhzgx;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

  public String getZjxy() {
    return zjxy;
  }

  public void setZjxy(String zjxy) {
    this.zjxy = zjxy;
  }

  public String getZylb() {
    return zylb;
  }

  public void setZy(String zy) {
    this.zy = zy;
  }

  public void setZylb(String zylb) {
    this.zylb = zylb;
  }

  public String getZy() {
    return zy;
  }

  public String getSpsm() {
    return spsm;
  }

  public void setSpsm(String spsm) {
    this.spsm = spsm;
  }

  public Long getYwxl() {
    return ywxl;
  }

  public void setYwxl(Long ywxl) {
    this.ywxl = ywxl;
  }

}
