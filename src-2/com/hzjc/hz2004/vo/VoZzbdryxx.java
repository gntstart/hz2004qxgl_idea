package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import com.hzjc.hz2004.po.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * סַ�䶯��Ա��Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoZzbdryxx
    extends DefaultVO {

  public VoZzbdryxx() {
  }

  public VoZzbdryxx(PoHJXX_CZRKJBXXB poRyxx, PoHJXX_MLPXXXXB x_poDxx,
                    PoHJXX_MLPXXXXB y_poDxx,
                    PoHJYW_ZZBDXXB poZzbdxx) {

    try {
      BeanUtils.copyProperties(this, poZzbdxx);
      BeanUtils.copyProperties(this, x_poDxx);
      BeanUtils.copyProperties(this, poRyxx);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

    //ԭ����Ϣ
    this.setY_mlpid(y_poDxx.getMlpid()); //�ţ�¥����ID
    this.setY_ssxq(y_poDxx.getSsxq()); //ʡ���أ�����
    this.setY_jlx(y_poDxx.getJlx()); //��·��
    this.setY_mlph(y_poDxx.getMlph()); //�ţ�¥���ƺ�
    this.setY_mlxz(y_poDxx.getMlxz()); //�ţ�¥����ַ
    this.setY_pcs(y_poDxx.getPcs()); //�ɳ���
    this.setY_zrq(y_poDxx.getZrq()); //������
    this.setY_xzjd(y_poDxx.getXzjd()); //���򣨽ֵ���
    this.setY_jcwh(y_poDxx.getJcwh()); //�ӣ��壩ί��
    this.setY_mlpzt(y_poDxx.getMlpzt()); //�ţ�¥����״̬
    this.setY_pxh(y_poDxx.getPxh()); //�����

  }

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

  //סַ�䶯��Ϣ
  private Long zzbdid; //סַ�䶯ID
  private Long yhhnbid; //ԭ�����ڲ�ID
  private Long xhhnbid; //�ֻ����ڲ�ID
  private String zzbdlb; //סַ�䶯���
  private String qyzbh; //Ǩ��֤���
  private String bdfw; //�䶯��Χ
  private Long hjywid; //����ҵ��ID

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

  //ԭ����Ϣ
  private Long y_mlpid; //�ţ�¥����ID
  private String y_ssxq; //ʡ���أ�����
  private String y_jlx; //��·��
  private String y_mlph; //�ţ�¥���ƺ�
  private String y_mlxz; //�ţ�¥����ַ
  private String y_pcs; //�ɳ���
  private String y_zrq; //������
  private String y_xzjd; //���򣨽ֵ���
  private String y_jcwh; //�ӣ��壩ί��
  private String y_jlrq; //��������
  private String y_ccrq; //��������
  private Long y_cdrid; //������ID
  private String y_mlpzt; //�ţ�¥����״̬
  private String y_pxh; //�����

  public String getBdfw() {
    return bdfw;
  }

  public void setBdfw(String bdfw) {
    this.bdfw = bdfw;
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

  public String getBz() {
    return bz;
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

  public String getCym() {
    return cym;
  }

  public void setCym(String cym) {
    this.cym = cym;
  }

  public String getCympy() {
    return cympy;
  }

  public void setCympy(String cympy) {
    this.cympy = cympy;
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

  public Long getHhnbid() {
    return hhnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
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

  public String getJcwh() {
    return jcwh;
  }

  public void setJcwh(String jcwh) {
    this.jcwh = jcwh;
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

  public void setJssj(String jssj) {
    this.jssj = jssj;
  }

  public Long getLxdbid() {
    return lxdbid;
  }

  public void setLxdbid(Long lxdbid) {
    this.lxdbid = lxdbid;
  }

  public String getMlph() {
    return mlph;
  }

  public void setMlph(String mlph) {
    this.mlph = mlph;
  }

  public Long getMlpid() {
    return mlpid;
  }

  public void setMlpid(Long mlpid) {
    this.mlpid = mlpid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public String getMlpzt() {
    return mlpzt;
  }

  public void setMlpzt(String mlpzt) {
    this.mlpzt = mlpzt;
  }

  public String getMlxz() {
    return mlxz;
  }

  public void setMlxz(String mlxz) {
    this.mlxz = mlxz;
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

  public String getPcs() {
    return pcs;
  }

  public void setPcs(String pcs) {
    this.pcs = pcs;
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

  public String getPxh() {
    return pxh;
  }

  public void setPxh(String pxh) {
    this.pxh = pxh;
  }

  public String getQysj() {
    return qysj;
  }

  public String getQyzbh() {
    return qyzbh;
  }

  public void setQyzbh(String qyzbh) {
    this.qyzbh = qyzbh;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public String getRylb() {
    return rylb;
  }

  public void setRylb(String rylb) {
    this.rylb = rylb;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public String getRyzt() {
    return ryzt;
  }

  public void setRyzt(String ryzt) {
    this.ryzt = ryzt;
  }

  public String getSg() {
    return sg;
  }

  public void setSg(String sg) {
    this.sg = sg;
  }

  public String getSsxq() {
    return ssxq;
  }

  public void setSsxq(String ssxq) {
    this.ssxq = ssxq;
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

  public Long getXhhnbid() {
    return xhhnbid;
  }

  public void setXhhnbid(Long xhhnbid) {
    this.xhhnbid = xhhnbid;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public String getXmpy() {
    return xmpy;
  }

  public void setXmpy(String xmpy) {
    this.xmpy = xmpy;
  }

  public String getXx() {
    return xx;
  }

  public void setXx(String xx) {
    this.xx = xx;
  }

  public String getXxjb() {
    return xxjb;
  }

  public void setXxjb(String xxjb) {
    this.xxjb = xxjb;
  }

  public String getXzjd() {
    return xzjd;
  }

  public void setXzjd(String xzjd) {
    this.xzjd = xzjd;
  }

  public Long getY_cdrid() {
    return y_cdrid;
  }

  public void setY_cdrid(Long y_cdrid) {
    this.y_cdrid = y_cdrid;
  }

  public String getY_ccrq() {
    return y_ccrq;
  }

  public void setY_ccrq(String y_ccrq) {
    this.y_ccrq = y_ccrq;
  }

  public String getY_jcwh() {
    return y_jcwh;
  }

  public void setY_jcwh(String y_jcwh) {
    this.y_jcwh = y_jcwh;
  }

  public String getY_jlrq() {
    return y_jlrq;
  }

  public void setY_jlrq(String y_jlrq) {
    this.y_jlrq = y_jlrq;
  }

  public String getY_jlx() {
    return y_jlx;
  }

  public void setY_mlph(String y_mlph) {
    this.y_mlph = y_mlph;
  }

  public String getY_mlph() {
    return y_mlph;
  }

  public Long getY_mlpid() {
    return y_mlpid;
  }

  public void setY_mlpid(Long y_mlpid) {
    this.y_mlpid = y_mlpid;
  }

  public void setY_jlx(String y_jlx) {
    this.y_jlx = y_jlx;
  }

  public String getY_mlpzt() {
    return y_mlpzt;
  }

  public void setY_mlpzt(String y_mlpzt) {
    this.y_mlpzt = y_mlpzt;
  }

  public String getY_mlxz() {
    return y_mlxz;
  }

  public void setY_pcs(String y_pcs) {
    this.y_pcs = y_pcs;
  }

  public String getY_pcs() {
    return y_pcs;
  }

  public void setY_mlxz(String y_mlxz) {
    this.y_mlxz = y_mlxz;
  }

  public String getY_pxh() {
    return y_pxh;
  }

  public void setY_pxh(String y_pxh) {
    this.y_pxh = y_pxh;
  }

  public void setY_ssxq(String y_ssxq) {
    this.y_ssxq = y_ssxq;
  }

  public String getY_ssxq() {
    return y_ssxq;
  }

  public String getY_xzjd() {
    return y_xzjd;
  }

  public void setY_xzjd(String y_xzjd) {
    this.y_xzjd = y_xzjd;
  }

  public String getY_zrq() {
    return y_zrq;
  }

  public void setY_zrq(String y_zrq) {
    this.y_zrq = y_zrq;
  }

  public Long getYhhnbid() {
    return yhhnbid;
  }

  public void setYhhnbid(Long yhhnbid) {
    this.yhhnbid = yhhnbid;
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

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public Long getZpid() {
    return zpid;
  }

  public void setZjxy(String zjxy) {
    this.zjxy = zjxy;
  }

  public String getZrq() {
    return zrq;
  }

  public void setZrq(String zrq) {
    this.zrq = zrq;
  }

  public String getZy() {
    return zy;
  }

  public void setZy(String zy) {
    this.zy = zy;
  }

  public String getZylb() {
    return zylb;
  }

  public void setZylb(String zylb) {
    this.zylb = zylb;
  }

  public Long getZzbdid() {
    return zzbdid;
  }

  public void setZzbdid(Long zzbdid) {
    this.zzbdid = zzbdid;
  }

  public String getZzbdlb() {
    return zzbdlb;
  }

  public void setZzbdlb(String zzbdlb) {
    this.zzbdlb = zzbdlb;
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

  public String getCxbz() {
    return cxbz;
  }

  public void setCxbz(String cxbz) {
    this.cxbz = cxbz;
  }

  public String getDhhm() {
    return dhhm;
  }

  public void setDhhm(String dhhm) {
    this.dhhm = dhhm;
  }

  public String getHgjdqlbz() {
    return hgjdqlbz;
  }

  public void setHgjdqlbz(String hgjdqlbz) {
    this.hgjdqlbz = hgjdqlbz;
  }

  public String getHgjdqql() {
    return hgjdqql;
  }

  public void setHgjdqql(String hgjdqql) {
    this.hgjdqql = hgjdqql;
  }

  public String getHslbz() {
    return hslbz;
  }

  public void setHslbz(String hslbz) {
    this.hslbz = hslbz;
  }

  public String getHsql() {
    return hsql;
  }

  public void setHsql(String hsql) {
    this.hsql = hsql;
  }

  public String getHsssqlbz() {
    return hsssqlbz;
  }

  public String getHssxqql() {
    return hssxqql;
  }

  public void setHssxqql(String hssxqql) {
    this.hssxqql = hssxqql;
  }

  public String getHxzlbz() {
    return hxzlbz;
  }

  public void setHxzlbz(String hxzlbz) {
    this.hxzlbz = hxzlbz;
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

  public String getHylbz() {
    return hylbz;
  }

  public void setHylbz(String hylbz) {
    this.hylbz = hylbz;
  }

  public String getHyql() {
    return hyql;
  }

  public void setHyql(String hyql) {
    this.hyql = hyql;
  }

  public Long getNbsfzid() {
    return nbsfzid;
  }

  public void setNbsfzid(Long nbsfzid) {
    this.nbsfzid = nbsfzid;
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

  public String getQfjg() {
    return qfjg;
  }

  public void setQfjg(String qfjg) {
    this.qfjg = qfjg;
  }

  public String getQtssxq() {
    return qtssxq;
  }

  public void setQtssxq(String qtssxq) {
    this.qtssxq = qtssxq;
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

  public String getSwzxrq() {
    return swzxrq;
  }

  public void setSwzxrq(String swzxrq) {
    this.swzxrq = swzxrq;
  }

  public String getYwnr() {
    return ywnr;
  }

  public void setYwnr(String ywnr) {
    this.ywnr = ywnr;
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

  public void setQysj(String qysj) {
    this.qysj = qysj;
  }

}