package com.hzjc.hz2004.vo;

import java.lang.reflect.*;

import org.apache.commons.beanutils.*;
import com.hzjc.hz2004.po.*;
import com.hzjc.wsstruts.vo.*;

/**
 * ����Ա��Ϣ��ȡ������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHcyxxHqFhxx
    extends DefaultVO {

  //����Ϣ
  private Long rynbid; //��Ա�ڲ�ID
  private Long ryid; //��ԱID
  private Long hhnbid; //�����ڲ�ID
  private Long mlpnbid; //�ţ�¥�����ڲ�ID
  private Long zpid; //��ƬID
  private String gmsfhm; //������ݺ���
  private String xm; //����
  private String cym; //������
  private String xmpy; //����ƴ��
  private String cympy; //������ƴ��
  private String xb; //�Ա�
  private String mz; //����
  private String csrq; //��������
  private String cssj; //����ʱ��
  private String csdgjdq; //�����ع��ң�������
  private String csdssxq; //������ʡ���أ�����
  private String csdxz; //��������ַ
  private String dhhm; //�绰����
  private String dhhm2;//�绰����2
  private String jhryxm; //�໤��һ����
  private String jhrygmsfhm; //�໤��һ������ݺ���
  private String jhryjhgx; //�໤��һ�໤��ϵ
  private String jhrexm; //�໤�˶�����
  private String jhregmsfhm; //�໤�˶�������ݺ���
  private String jhrejhgx; //�໤�˶��໤��ϵ
  private String fqxm; //��������
  private String fqgmsfhm; //���׹�����ݺ���
  private String mqxm; //ĸ������
  private String mqgmsfhm; //ĸ�׹�����ݺ���
  private String poxm; //��ż����
  private String pogmsfhm; //��ż������ݺ���
  private String jggjdq; //������ң�������
  private String jgssxq; //����ʡ���أ�����
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
  private String hsql; //��ʱǨ��
  private String hyql; //����Ǩ��
  private String hgjdqql; //�ι��ң�������Ǩ��
  private String hssxqql; //��ʡ���أ�����Ǩ��
  private String hxzql; //����ַǨ��
  private String hslbz; //��ʱ����ַ
  private String hylbz; //��������ַ
  private String hgjdqlbz; //�ι��ң�����������ַ
  private String hsssqlbz; //��ʡ���أ���������ַ
  private String hxzlbz; //����ַ����ַ
  private String swrq; //��������
  private String swzxlb; //����ע�����
  private String qcrq; //Ǩ������
  private String qczxlb; //Ǩ��ע�����
  private String qwdgjdq; //Ǩ���ع��ң�������
  private String qwdssxq; //Ǩ����ʡ���أ�����
  private String qwdxz; //Ǩ������ַ
  private String cszmbh; //����֤�����
  private String cszqfrq; //����֤ǩ������
  private String hylb; //��ҵ���
  private String qtssxq; //����ʡ���أ�����
  private String qtzz; //����סַ
  private String rylb; //��Ա���
  private String hb; //����
  private String yhzgx; //�뻧����ϵ
  private String ryzt; //��Ա״̬
  private String rysdzt; //��Ա����״̬
  private Long lxdbid; //����DBID
  private String bz; //��ע
  private String jlbz; //��¼��־
  private String ywnr; //ҵ������
  private Long cjhjywid; //��������ҵ��ID
  private Long cchjywid; //��������ҵ��ID
  private String qysj; //����ʱ��
  private String jssj; //����ʱ��
  private String cxbz; //������־

  private Long nbsfzid; //�ڲ����֤ID
  private String qfjg; //ǩ������
  private String yxqxqsrq; //��Ч������ʼ����
  private String yxqxjzrq; //��Ч���޽�ֹ����
  private String swzxrq; //����ע������
  private String zjlb;//֤�����

  private String zp; //��Ƭ(��ֵ)

  //ҵ��ͳ����Ϣ
  private Long sbhjywid; //�ϱʻ���ҵ��ID
  private String cxfldm;

  public VoHcyxxHqFhxx() {

  }

  public VoHcyxxHqFhxx(PoHJXX_CZRKJBXXB poHJXX_CZRKJBXXB) {

    try {
      BeanUtils.copyProperties(this, poHJXX_CZRKJBXXB);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

    this.setSbhjywid(this.getCjhjywid());
  }

  public String getByzk() {
    return byzk;
  }

  public String getBz() {
    return bz;
  }

  public String getCsdgjdq() {
    return csdgjdq;
  }

  public void setByzk(String byzk) {
    this.byzk = byzk;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public void setCsdgjdq(String csdgjdq) {
    this.csdgjdq = csdgjdq;
  }

  public void setCsdssxq(String csdssxq) {
    this.csdssxq = csdssxq;
  }

  public void setCsdxz(String csdxz) {
    this.csdxz = csdxz;
  }

  public String getCsdxz() {
    return csdxz;
  }

  public String getCsdssxq() {
    return csdssxq;
  }

  public String getCsrq() {
    return csrq;
  }

  public String getCssj() {
    return cssj;
  }

  public String getCym() {
    return cym;
  }

  public String getCympy() {
    return cympy;
  }

  public void setCsrq(String csrq) {
    this.csrq = csrq;
  }

  public void setCssj(String cssj) {
    this.cssj = cssj;
  }

  public void setCym(String cym) {
    this.cym = cym;
  }

  public void setCympy(String cympy) {
    this.cympy = cympy;
  }

  public void setFqgmsfhm(String fqgmsfhm) {
    this.fqgmsfhm = fqgmsfhm;
  }

  public void setFqxm(String fqxm) {
    this.fqxm = fqxm;
  }

  public void setFwcs(String fwcs) {
    this.fwcs = fwcs;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getFqgmsfhm() {
    return fqgmsfhm;
  }

  public String getFqxm() {
    return fqxm;
  }

  public String getFwcs() {
    return fwcs;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public String getHb() {
    return hb;
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public String getHyzk() {
    return hyzk;
  }

  public String getJggjdq() {
    return jggjdq;
  }

  public String getJgssxq() {
    return jgssxq;
  }

  public String getJhregmsfhm() {
    return jhregmsfhm;
  }

  public void setHb(String hb) {
    this.hb = hb;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public void setHyzk(String hyzk) {
    this.hyzk = hyzk;
  }

  public void setJggjdq(String jggjdq) {
    this.jggjdq = jggjdq;
  }

  public void setJgssxq(String jgssxq) {
    this.jgssxq = jgssxq;
  }

  public void setJhregmsfhm(String jhregmsfhm) {
    this.jhregmsfhm = jhregmsfhm;
  }

  public void setJhrejhgx(String jhrejhgx) {
    this.jhrejhgx = jhrejhgx;
  }

  public void setJhrexm(String jhrexm) {
    this.jhrexm = jhrexm;
  }

  public void setJhrygmsfhm(String jhrygmsfhm) {
    this.jhrygmsfhm = jhrygmsfhm;
  }

  public void setJhryjhgx(String jhryjhgx) {
    this.jhryjhgx = jhryjhgx;
  }

  public void setJhryxm(String jhryxm) {
    this.jhryxm = jhryxm;
  }

  public String getJhryxm() {
    return jhryxm;
  }

  public String getJhryjhgx() {
    return jhryjhgx;
  }

  public String getJhrygmsfhm() {
    return jhrygmsfhm;
  }

  public String getJhrexm() {
    return jhrexm;
  }

  public String getJhrejhgx() {
    return jhrejhgx;
  }

  public String getJlbz() {
    return jlbz;
  }

  public void setJlbz(String jlbz) {
    this.jlbz = jlbz;
  }

  public String getJssj() {
    return jssj;
  }

  public Long getLxdbid() {
    return lxdbid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public void setJssj(String jssj) {
    this.jssj = jssj;
  }

  public void setLxdbid(Long lxdbid) {
    this.lxdbid = lxdbid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public void setMqxm(String mqxm) {
    this.mqxm = mqxm;
  }

  public void setMqgmsfhm(String mqgmsfhm) {
    this.mqgmsfhm = mqgmsfhm;
  }

  public void setMz(String mz) {
    this.mz = mz;
  }

  public void setPogmsfhm(String pogmsfhm) {
    this.pogmsfhm = pogmsfhm;
  }

  public void setPoxm(String poxm) {
    this.poxm = poxm;
  }

  public String getPoxm() {
    return poxm;
  }

  public String getPogmsfhm() {
    return pogmsfhm;
  }

  public String getMz() {
    return mz;
  }

  public String getMqxm() {
    return mqxm;
  }

  public String getMqgmsfhm() {
    return mqgmsfhm;
  }

  public String getQysj() {
    return qysj;
  }

  public Long getRyid() {
    return ryid;
  }

  public String getRylb() {
    return rylb;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public String getRyzt() {
    return ryzt;
  }

  public String getSg() {
    return sg;
  }

  public String getWhcd() {
    return whcd;
  }

  public String getXb() {
    return xb;
  }

  public void setQysj(String qysj) {
    this.qysj = qysj;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public void setRylb(String rylb) {
    this.rylb = rylb;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public void setRyzt(String ryzt) {
    this.ryzt = ryzt;
  }

  public void setSg(String sg) {
    this.sg = sg;
  }

  public void setWhcd(String whcd) {
    this.whcd = whcd;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public void setXmpy(String xmpy) {
    this.xmpy = xmpy;
  }

  public void setXx(String xx) {
    this.xx = xx;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

  public void setXxjb(String xxjb) {
    this.xxjb = xxjb;
  }

  public void setZjxy(String zjxy) {
    this.zjxy = zjxy;
  }

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public void setZy(String zy) {
    this.zy = zy;
  }

  public void setZylb(String zylb) {
    this.zylb = zylb;
  }

  public String getZylb() {
    return zylb;
  }

  public String getZy() {
    return zy;
  }

  public Long getZpid() {
    return zpid;
  }

  public String getZjxy() {
    return zjxy;
  }

  public String getYhzgx() {
    return yhzgx;
  }

  public String getXxjb() {
    return xxjb;
  }

  public String getXx() {
    return xx;
  }

  public String getXmpy() {
    return xmpy;
  }

  public String getXm() {
    return xm;
  }

  public Long getSbhjywid() {
    return sbhjywid;
  }

  public void setSbhjywid(Long sbhjywid) {
    this.sbhjywid = sbhjywid;
  }

  public String getZp() {
    return zp;
  }

  public void setZp(String zp) {
    this.zp = zp;
  }

  public Long getCchjywid() {
    return cchjywid;
  }

  public void setCchjywid(Long cchjywid) {
    this.cchjywid = cchjywid;
  }

  public Long getCjhjywid() {
    return cjhjywid;
  }

  public void setCjhjywid(Long cjhjywid) {
    this.cjhjywid = cjhjywid;
  }

  public String getCszmbh() {
    return cszmbh;
  }

  public void setCszmbh(String cszmbh) {
    this.cszmbh = cszmbh;
  }

  public String getCszqfrq() {
    return cszqfrq;
  }

  public void setCszqfrq(String cszqfrq) {
    this.cszqfrq = cszqfrq;
  }

  public String getDhhm() {
    return dhhm;
  }

  public void setDhhm(String dhhm) {
    this.dhhm = dhhm;
  }

  public String getHgjdqql() {
    return hgjdqql;
  }

  public void setHgjdqql(String hgjdqql) {
    this.hgjdqql = hgjdqql;
  }

  public String getHsql() {
    return hsql;
  }

  public void setHsql(String hsql) {
    this.hsql = hsql;
  }

  public String getHssxqql() {
    return hssxqql;
  }

  public void setHssxqql(String hssxqql) {
    this.hssxqql = hssxqql;
  }

  public String getHxzql() {
    return hxzql;
  }

  public void setHxzql(String hxzql) {
    this.hxzql = hxzql;
  }

  public String getHylb() {
    return hylb;
  }

  public void setHylb(String hylb) {
    this.hylb = hylb;
  }

  public String getHyql() {
    return hyql;
  }

  public void setHyql(String hyql) {
    this.hyql = hyql;
  }

  public String getQcrq() {
    return qcrq;
  }

  public void setQcrq(String qcrq) {
    this.qcrq = qcrq;
  }

  public String getQczxlb() {
    return qczxlb;
  }

  public void setQczxlb(String qczxlb) {
    this.qczxlb = qczxlb;
  }

  public String getQtzz() {
    return qtzz;
  }

  public void setQtzz(String qtzz) {
    this.qtzz = qtzz;
  }

  public String getQwdgjdq() {
    return qwdgjdq;
  }

  public void setQwdgjdq(String qwdgjdq) {
    this.qwdgjdq = qwdgjdq;
  }

  public String getQwdssxq() {
    return qwdssxq;
  }

  public void setQwdssxq(String qwdssxq) {
    this.qwdssxq = qwdssxq;
  }

  public String getQwdxz() {
    return qwdxz;
  }

  public void setQwdxz(String qwdxz) {
    this.qwdxz = qwdxz;
  }

  public String getRysdzt() {
    return rysdzt;
  }

  public void setRysdzt(String rysdzt) {
    this.rysdzt = rysdzt;
  }

  public String getSwrq() {
    return swrq;
  }

  public void setSwrq(String swrq) {
    this.swrq = swrq;
  }

  public String getSwzxlb() {
    return swzxlb;
  }

  public void setSwzxlb(String swzxlb) {
    this.swzxlb = swzxlb;
  }

  public String getQtssxq() {
    return qtssxq;
  }

  public void setQtssxq(String qtssxq) {
    this.qtssxq = qtssxq;
  }

  public String getYwnr() {
    return ywnr;
  }

  public void setYwnr(String ywnr) {
    this.ywnr = ywnr;
  }

  public String getCxbz() {
    return cxbz;
  }

  public void setCxbz(String cxbz) {
    this.cxbz = cxbz;
  }

  public String getHgjdqlbz() {
    return hgjdqlbz;
  }

  public void setHgjdqlbz(String hgjdqlbz) {
    this.hgjdqlbz = hgjdqlbz;
  }

  public String getHslbz() {
    return hslbz;
  }

  public void setHslbz(String hslbz) {
    this.hslbz = hslbz;
  }

  public String getHsssqlbz() {
    return hsssqlbz;
  }

  public void setHsssqlbz(String hsssqlbz) {
    this.hsssqlbz = hsssqlbz;
  }

  public String getHxzlbz() {
    return hxzlbz;
  }

  public void setHxzlbz(String hxzlbz) {
    this.hxzlbz = hxzlbz;
  }

  public String getHylbz() {
    return hylbz;
  }

  public void setHylbz(String hylbz) {
    this.hylbz = hylbz;
  }

  public Long getNbsfzid() {
    return nbsfzid;
  }

  public void setNbsfzid(Long nbsfzid) {
    this.nbsfzid = nbsfzid;
  }

  public String getQfjg() {
    return qfjg;
  }

  public void setQfjg(String qfjg) {
    this.qfjg = qfjg;
  }

  public String getSwzxrq() {
    return swzxrq;
  }

  public void setSwzxrq(String swzxrq) {
    this.swzxrq = swzxrq;
  }

  public String getYxqxjzrq() {
    return yxqxjzrq;
  }

  public void setYxqxjzrq(String yxqxjzrq) {
    this.yxqxjzrq = yxqxjzrq;
  }

  public String getYxqxqsrq() {
    return yxqxqsrq;
  }

  public void setYxqxqsrq(String yxqxqsrq) {
    this.yxqxqsrq = yxqxqsrq;
  }

  public String getZjlb() {
    return zjlb;
  }

  public void setZjlb(String zjlb) {
    this.zjlb = zjlb;
  }

  public String getDhhm2() {
    return dhhm2;
  }

  public String getCxfldm() {
    return cxfldm;
  }

  public void setDhhm2(String dhhm2) {
    this.dhhm2 = dhhm2;
  }

  public void setCxfldm(String cxfldm) {
    this.cxfldm = cxfldm;
  }

}
