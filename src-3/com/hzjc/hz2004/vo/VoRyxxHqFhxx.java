package com.hzjc.hz2004.vo;

import java.lang.reflect.*;

import org.apache.commons.beanutils.*;
import com.hzjc.hz2004.po.*;
import com.hzjc.wsstruts.vo.*;

/**
 * ��Ա��Ϣ��ȡ������ϢVO
 * <p>Title: hz2004</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoRyxxHqFhxx
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
  private String zjlb; //֤�����
  private String swzxrq; //����ע������

  private String zp; //��Ƭ(��ֵ)

  //����Ϣ
  private Long hhid; //����ID
  private String hh; //����
  private String hlx; //������
  private String hhzt; //����״̬
  private String chlb; //�������
  private String jhlb; //�������
  private String jhsj; //����ʱ��
  private String chsj; //����ʱ��

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

  //ҵ�����ͳ����Ϣ
  private Long sbhjywid; //�ϱʻ���ҵ��ID

  //������Ϣ
  private String hzxm; //��������
  private String hzgmsfhm; //����������ݺ���
  private String hzxb; //�����Ա�
  private Long hzryid; //��ԱID
  private Long hzrynbid; //��Ա�ڲ�ID

  //����Աͳ����Ϣ
  private Long nahcys; //�л���Ա��
  private Long nvhcys; //Ů����Ա��

  private String xmx;
  private String xmm;
  private String jgxz;
  private String jhryzjzl;
  private String jhryzjhm;
  private String jhrywwx;
  private String jhrywwm;
  private String jhrylxdh;
  private String jhrezjzl;
  private String jhrezjhm;
  private String jhrewwx;
  private String jhrewwm;
  private String jhrelxdh;
  private String fqzjzl;
  private String fqzjhm;
  private String fqwwx;
  private String fqwwm;
  private String mqzjzl;
  private String mqzjhm;
  private String mqwwx;
  private String mqwwm;
  private String pozjzl;
  private String pozjhm;
  private String powwx;
  private String powwm;
  private String qyldyy;
  private String  sbrjtgx;

  private String yhkxzmc;
  private String yhkxzsj;
  private String cxfldm;

  public void setYhkxzmc(String yhkxzmc) {
  this.yhkxzmc = yhkxzmc;
}

public String getYhkxzmc() {
  return yhkxzmc;
}

public void setYhkxzsj(String yhkxzsj) {
  this.yhkxzsj = yhkxzsj;
}

public String getYhkxzsj() {
  return yhkxzsj;
  }

  public VoRyxxHqFhxx() {

  }

  /**
   *
   * @param poHJXX_CZRKJBXXB
   * @param poHJXX_HXXB
   * @param poHJXX_MLPXXXXB
   * @param poHJTJ_RYYWBLTJXXB
   */
  public VoRyxxHqFhxx(PoHJXX_CZRKJBXXB poHJXX_CZRKJBXXB,
                      PoHJXX_HXXB poHJXX_HXXB,
                      PoHJXX_MLPXXXXB poHJXX_MLPXXXXB) {

    try {
      if (poHJXX_HXXB != null) {
        BeanUtils.copyProperties(this, poHJXX_HXXB);
      }
      if (poHJXX_MLPXXXXB != null) {
        BeanUtils.copyProperties(this, poHJXX_MLPXXXXB);
      }
      BeanUtils.copyProperties(this, poHJXX_CZRKJBXXB);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

    //�����ϱʻ���ҵ��ID
    this.setSbhjywid(this.getCjhjywid());
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getByzk() {
    return byzk;
  }

  public void setByzk(String byzk) {
    this.byzk = byzk;
  }

  public String getBz() {
    return bz;
  }

  public String getCsdgjdq() {
    return csdgjdq;
  }

  public void setBz(String bz) {
    this.bz = bz;
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

  public void setCsdxz(String csdxz) {
    this.csdxz = csdxz;
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

  public String getFqxm() {
    return fqxm;
  }

  public String getFqgmsfhm() {
    return fqgmsfhm;
  }

  public String getFwcs() {
    return fwcs;
  }

  public void setFwcs(String fwcs) {
    this.fwcs = fwcs;
  }

  public void setHb(String hb) {
    this.hb = hb;
  }

  public String getHb() {
    return hb;
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

  public void setJgssxq(String jgssxq) {
    this.jgssxq = jgssxq;
  }

  public String getJgssxq() {
    return jgssxq;
  }

  public String getJhregmsfhm() {
    return jhregmsfhm;
  }

  public String getJhrejhgx() {
    return jhrejhgx;
  }

  public String getJhrexm() {
    return jhrexm;
  }

  public String getJhrygmsfhm() {
    return jhrygmsfhm;
  }

  public String getJhryjhgx() {
    return jhryjhgx;
  }

  public String getJhryxm() {
    return jhryxm;
  }

  public String getJlbz() {
    return jlbz;
  }

  public String getJssj() {
    return jssj;
  }

  public Long getLxdbid() {
    return lxdbid;
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

  public void setJlbz(String jlbz) {
    this.jlbz = jlbz;
  }

  public void setJssj(String jssj) {
    this.jssj = jssj;
  }

  public void setLxdbid(Long lxdbid) {
    this.lxdbid = lxdbid;
  }

  public String getMqgmsfhm() {
    return mqgmsfhm;
  }

  public String getMqxm() {
    return mqxm;
  }

  public String getMz() {
    return mz;
  }

  public void setMqgmsfhm(String mqgmsfhm) {
    this.mqgmsfhm = mqgmsfhm;
  }

  public void setMqxm(String mqxm) {
    this.mqxm = mqxm;
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

  public void setQysj(String qysj) {
    this.qysj = qysj;
  }

  public String getQysj() {
    return qysj;
  }

  public String getPoxm() {
    return poxm;
  }

  public String getPogmsfhm() {
    return pogmsfhm;
  }

  public Long getRyid() {
    return ryid;
  }

  public String getRylb() {
    return rylb;
  }

  public void setRylb(String rylb) {
    this.rylb = rylb;
  }

  public void setRyzt(String ryzt) {
    this.ryzt = ryzt;
  }

  public String getRyzt() {
    return ryzt;
  }

  public String getSg() {
    return sg;
  }

  public void setSg(String sg) {
    this.sg = sg;
  }

  public void setWhcd(String whcd) {
    this.whcd = whcd;
  }

  public String getWhcd() {
    return whcd;
  }

  public String getXb() {
    return xb;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public String getXmpy() {
    return xmpy;
  }

  public void setXmpy(String xmpy) {
    this.xmpy = xmpy;
  }

  public void setXx(String xx) {
    this.xx = xx;
  }

  public String getXx() {
    return xx;
  }

  public String getXxjb() {
    return xxjb;
  }

  public void setXxjb(String xxjb) {
    this.xxjb = xxjb;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

  public String getYhzgx() {
    return yhzgx;
  }

  public String getZjxy() {
    return zjxy;
  }

  public void setZjxy(String zjxy) {
    this.zjxy = zjxy;
  }

  public String getZy() {
    return zy;
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

  public Long getCjhjywid() {
    return cjhjywid;
  }

  public void setCjhjywid(Long cjhjywid) {
    this.cjhjywid = cjhjywid;
  }

  public Long getCchjywid() {
    return cchjywid;
  }

  public void setCchjywid(Long cchjywid) {
    this.cchjywid = cchjywid;
  }

  public String getHh() {
    return hh;
  }

  public Long getHhid() {
    return hhid;
  }

  public void setHh(String hh) {
    this.hh = hh;
  }

  public void setHhid(Long hhid) {
    this.hhid = hhid;
  }

  public String getHhzt() {
    return hhzt;
  }

  public String getHlx() {
    return hlx;
  }

  public void setHhzt(String hhzt) {
    this.hhzt = hhzt;
  }

  public void setHlx(String hlx) {
    this.hlx = hlx;
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

  public String getMlph() {
    return mlph;
  }

  public Long getMlpid() {
    return mlpid;
  }

  public void setMlpid(Long mlpid) {
    this.mlpid = mlpid;
  }

  public void setMlph(String mlph) {
    this.mlph = mlph;
  }

  public String getMlpzt() {
    return mlpzt;
  }

  public String getMlxz() {
    return mlxz;
  }

  public void setMlxz(String mlxz) {
    this.mlxz = mlxz;
  }

  public void setMlpzt(String mlpzt) {
    this.mlpzt = mlpzt;
  }

  public String getPcs() {
    return pcs;
  }

  public void setPcs(String pcs) {
    this.pcs = pcs;
  }

  public String getPxh() {
    return pxh;
  }

  public void setPxh(String pxh) {
    this.pxh = pxh;
  }

  public String getSsxq() {
    return ssxq;
  }

  public void setSsxq(String ssxq) {
    this.ssxq = ssxq;
  }

  public String getXzjd() {
    return xzjd;
  }

  public void setXzjd(String xzjd) {
    this.xzjd = xzjd;
  }

  public String getZrq() {
    return zrq;
  }

  public void setZrq(String zrq) {
    this.zrq = zrq;
  }

  public Long getSbhjywid() {
    return sbhjywid;
  }

  public void setSbhjywid(Long sbhjywid) {
    this.sbhjywid = sbhjywid;
  }

  public Long getZpid() {
    return zpid;
  }

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public String getZp() {
    return zp;
  }

  public void setZp(String zp) {
    this.zp = zp;
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

  public String getYwnr() {
    return ywnr;
  }

  public void setYwnr(String ywnr) {
    this.ywnr = ywnr;
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

  public String getHzgmsfhm() {
    return hzgmsfhm;
  }

  public void setHzgmsfhm(String hzgmsfhm) {
    this.hzgmsfhm = hzgmsfhm;
  }

  public Long getHzryid() {
    return hzryid;
  }

  public void setHzryid(Long hzryid) {
    this.hzryid = hzryid;
  }

  public Long getHzrynbid() {
    return hzrynbid;
  }

  public void setHzrynbid(Long hzrynbid) {
    this.hzrynbid = hzrynbid;
  }

  public String getHzxb() {
    return hzxb;
  }

  public void setHzxb(String hzxb) {
    this.hzxb = hzxb;
  }

  public String getHzxm() {
    return hzxm;
  }

  public void setHzxm(String hzxm) {
    this.hzxm = hzxm;
  }

  public Long getNahcys() {
    return nahcys;
  }

  public void setNahcys(Long nahcys) {
    this.nahcys = nahcys;
  }

  public Long getNvhcys() {
    return nvhcys;
  }

  public void setNvhcys(Long nvhcys) {
    this.nvhcys = nvhcys;
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

  public void setDhhm2(String dhhm2) {
    this.dhhm2 = dhhm2;
  }

        public String getXmx() {
                return xmx;
        }
        public void setXmx(String xmx) {
                this.xmx = xmx;
        }
        public String getXmm() {
                return xmm;
        }
        public void setXmm(String xmm) {
                this.xmm = xmm;
        }
        public String getJgxz() {
                return jgxz;
        }
        public void setJgxz(String jgxz) {
                this.jgxz = jgxz;
        }
        public String getJhryzjzl() {
                return jhryzjzl;
        }
        public void setJhryzjzl(String jhryzjzl) {
                this.jhryzjzl = jhryzjzl;
        }
        public String getJhryzjhm() {
                return jhryzjhm;
        }
        public void setJhryzjhm(String jhryzjhm) {
                this.jhryzjhm = jhryzjhm;
        }
        public String getJhrywwx() {
                return jhrywwx;
        }
        public void setJhrywwx(String jhrywwx) {
                this.jhrywwx = jhrywwx;
        }
        public String getJhrywwm() {
                return jhrywwm;
        }
        public void setJhrywwm(String jhrywwm) {
                this.jhrywwm = jhrywwm;
        }
        public String getJhrylxdh() {
                return jhrylxdh;
        }
        public void setJhrylxdh(String jhrylxdh) {
                this.jhrylxdh = jhrylxdh;
        }
        public String getJhrezjzl() {
                return jhrezjzl;
        }
        public void setJhrezjzl(String jhrezjzl) {
                this.jhrezjzl = jhrezjzl;
        }
        public String getJhrezjhm() {
                return jhrezjhm;
        }
        public void setJhrezjhm(String jhrezjhm) {
                this.jhrezjhm = jhrezjhm;
        }
        public String getJhrewwx() {
                return jhrewwx;
        }
        public void setJhrewwx(String jhrewwx) {
                this.jhrewwx = jhrewwx;
        }
        public String getJhrewwm() {
                return jhrewwm;
        }
        public void setJhrewwm(String jhrewwm) {
                this.jhrewwm = jhrewwm;
        }
        public String getJhrelxdh() {
                return jhrelxdh;
        }
        public void setJhrelxdh(String jhrelxdh) {
                this.jhrelxdh = jhrelxdh;
        }
        public String getFqzjzl() {
                return fqzjzl;
        }
        public void setFqzjzl(String fqzjzl) {
                this.fqzjzl = fqzjzl;
        }
        public String getFqzjhm() {
                return fqzjhm;
        }
        public void setFqzjhm(String fqzjhm) {
                this.fqzjhm = fqzjhm;
        }
        public String getFqwwx() {
                return fqwwx;
        }
        public void setFqwwx(String fqwwx) {
                this.fqwwx = fqwwx;
        }
        public String getFqwwm() {
                return fqwwm;
        }
        public void setFqwwm(String fqwwm) {
                this.fqwwm = fqwwm;
        }
        public String getMqzjzl() {
                return mqzjzl;
        }
        public void setMqzjzl(String mqzjzl) {
                this.mqzjzl = mqzjzl;
        }
        public String getMqzjhm() {
                return mqzjhm;
        }
        public void setMqzjhm(String mqzjhm) {
                this.mqzjhm = mqzjhm;
        }
        public String getMqwwx() {
                return mqwwx;
        }
        public void setMqwwx(String mqwwx) {
                this.mqwwx = mqwwx;
        }
        public String getMqwwm() {
                return mqwwm;
        }
        public void setMqwwm(String mqwwm) {
                this.mqwwm = mqwwm;
        }
        public String getPozjzl() {
                return pozjzl;
        }
        public void setPozjzl(String pozjzl) {
                this.pozjzl = pozjzl;
        }
        public String getPozjhm() {
                return pozjhm;
        }
        public void setPozjhm(String pozjhm) {
                this.pozjhm = pozjhm;
        }
        public String getPowwx() {
                return powwx;
        }
        public void setPowwx(String powwx) {
                this.powwx = powwx;
        }
        public String getPowwm() {
                return powwm;
        }
        public void setPowwm(String powwm) {
                this.powwm = powwm;
        }
        public String getQyldyy() {
          return qyldyy;
        }
        public void setQyldyy(String qyldyy) {
          this.qyldyy = qyldyy;
        }
        public String getSbrjtgx() {
          return sbrjtgx;
        }

  public String getCxfldm() {
    return cxfldm;
  }

  public void setSbrjtgx(String sbrjtgx) {
          this.sbrjtgx = sbrjtgx;
        }

  public void setCxfldm(String cxfldm) {
    this.cxfldm = cxfldm;
  }

}
