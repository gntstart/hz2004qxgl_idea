package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڹ���ϵͳHz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: �㽭�����¼������޹�˾</p>
 * @author kgb_hz@126.com,kgb@primetech.com.cn
 * @version 1.0
 */

public class VoJmsfzxxHqFhxx {
  /**
   *
   */
  public VoJmsfzxxHqFhxx() {
  }

  /**
   *
   * @param poZJXX_JMSFZXXB
   * @param poHJXX_MLPXXXXB
   */
  public VoJmsfzxxHqFhxx(PoZJXX_JMSFZXXB poZJXX_JMSFZXXB,
                         PoHJXX_MLPXXXXB poHJXX_MLPXXXXB, Long lZpid) {
    try {
      if(poZJXX_JMSFZXXB != null){
        BeanUtils.copyProperties(this, poZJXX_JMSFZXXB);
      }
      if(poHJXX_MLPXXXXB != null){
        BeanUtils.copyProperties(this, poHJXX_MLPXXXXB);
      }
      this.setZpid(lZpid);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }
  }

  //�������֤��ϢPO
  private Long nbsfzid; //�ڲ����֤ID
  private Long ryid; //	��ԱID
  private Long zpid; //	��ƬID
  private String gmsfhm; //������ݺ���
  private String xm; //	����
  private String xb; //	�Ա�
  private String mz; //	����
  private String csrq; //��������
  private String qfjg; //ǩ������
  private String qfrq; //ǩ������
  private String yxqx; //��Ч����
  private String yxqxqsrq; //��Ч������ʼ����
  private String yxqxjzrq; //��Ч���޽�ֹ����
  private String slyy; //����ԭ��
  private String bzyy; //��֤ԭ��
  private String sjyy; //�ս�ԭ��
  private String zz; //	סַ
  private String zz1; //סַ1
  private String zz2; //סַ2
  private String zz3; //סַ3
  private String zz4; //סַ4
  private String ktglh; //��������
  private String zjlb; //֤�����
  private String zjzt; //֤��״̬

  //��¥����ϢPO
  private Long mlpnbid; //�ţ�¥�����ڲ�ID
  private Long mlpid; //�ţ�¥����ID
  private String ssxq; //ʡ���أ�����
  private String jlx; //��·��
  private String mlph; //�ţ�¥���ƺ�
  private String mlxz; //�ţ�¥����ַ
  private String pcs; //�ɳ���
  private String zrq; //������
  private String xzjd; //���򣨽ֵ���
  private String jcwh; //�ӣ��壩ί��
  private String jlrq; //��������
  private String jllb; //�������
  private Long jlrid; //������ID
  private Long cjhjywid; //��������ҵ��ID
  private String ccrq; //��������
  private String cxlb; //�������
  private Long cdrid; //������ID
  private Long cchjywid; //��������ҵ��ID
  private String mlpzt; //�ţ�¥����״̬
  private Long lxdbid; //����DBID
  private String jlbz; //��¼��־
  private String qysj; //����ʱ��
  private String jssj; //����ʱ��
  private String pxh; //�����

  public String getBzyy() {
    return bzyy;
  }

  public Long getCchjywid() {
    return cchjywid;
  }

  public String getCcrq() {
    return ccrq;
  }

  public Long getCdrid() {
    return cdrid;
  }

  public Long getCjhjywid() {
    return cjhjywid;
  }

  public String getCsrq() {
    return csrq;
  }

  public String getCxlb() {
    return cxlb;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public String getJcwh() {
    return jcwh;
  }

  public String getJlbz() {
    return jlbz;
  }

  public String getJllb() {
    return jllb;
  }

  public Long getJlrid() {
    return jlrid;
  }

  public String getJlrq() {
    return jlrq;
  }

  public String getJlx() {
    return jlx;
  }

  public String getJssj() {
    return jssj;
  }

  public String getKtglh() {
    return ktglh;
  }

  public Long getLxdbid() {
    return lxdbid;
  }

  public String getMlph() {
    return mlph;
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

  public String getMlxz() {
    return mlxz;
  }

  public String getMz() {
    return mz;
  }

  public Long getNbsfzid() {
    return nbsfzid;
  }

  public String getPcs() {
    return pcs;
  }

  public String getPxh() {
    return pxh;
  }

  public String getQfjg() {
    return qfjg;
  }

  public String getQfrq() {
    return qfrq;
  }

  public String getQysj() {
    return qysj;
  }

  public Long getRyid() {
    return ryid;
  }

  public String getSjyy() {
    return sjyy;
  }

  public String getSlyy() {
    return slyy;
  }

  public String getSsxq() {
    return ssxq;
  }

  public String getXb() {
    return xb;
  }

  public String getXm() {
    return xm;
  }

  public String getXzjd() {
    return xzjd;
  }

  public String getYxqx() {
    return yxqx;
  }

  public String getYxqxjzrq() {
    return yxqxjzrq;
  }

  public String getYxqxqsrq() {
    return yxqxqsrq;
  }

  public String getZjlb() {
    return zjlb;
  }

  public String getZjzt() {
    return zjzt;
  }

  public Long getZpid() {
    return zpid;
  }

  public String getZrq() {
    return zrq;
  }

  public String getZz() {
    return zz;
  }

  public String getZz1() {
    return zz1;
  }

  public String getZz2() {
    return zz2;
  }

  public String getZz3() {
    return zz3;
  }

  public String getZz4() {
    return zz4;
  }

  public void setZz4(String zz4) {
    this.zz4 = zz4;
  }

  public void setZz3(String zz3) {
    this.zz3 = zz3;
  }

  public void setZz2(String zz2) {
    this.zz2 = zz2;
  }

  public void setZz1(String zz1) {
    this.zz1 = zz1;
  }

  public void setZz(String zz) {
    this.zz = zz;
  }

  public void setZrq(String zrq) {
    this.zrq = zrq;
  }

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public void setZjzt(String zjzt) {
    this.zjzt = zjzt;
  }

  public void setZjlb(String zjlb) {
    this.zjlb = zjlb;
  }

  public void setYxqxqsrq(String yxqxqsrq) {
    this.yxqxqsrq = yxqxqsrq;
  }

  public void setYxqxjzrq(String yxqxjzrq) {
    this.yxqxjzrq = yxqxjzrq;
  }

  public void setYxqx(String yxqx) {
    this.yxqx = yxqx;
  }

  public void setXzjd(String xzjd) {
    this.xzjd = xzjd;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public void setSsxq(String ssxq) {
    this.ssxq = ssxq;
  }

  public void setSlyy(String slyy) {
    this.slyy = slyy;
  }

  public void setSjyy(String sjyy) {
    this.sjyy = sjyy;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public void setQysj(String qysj) {
    this.qysj = qysj;
  }

  public void setQfrq(String qfrq) {
    this.qfrq = qfrq;
  }

  public void setQfjg(String qfjg) {
    this.qfjg = qfjg;
  }

  public void setPxh(String pxh) {
    this.pxh = pxh;
  }

  public void setPcs(String pcs) {
    this.pcs = pcs;
  }

  public void setNbsfzid(Long nbsfzid) {
    this.nbsfzid = nbsfzid;
  }

  public void setMz(String mz) {
    this.mz = mz;
  }

  public void setMlxz(String mlxz) {
    this.mlxz = mlxz;
  }

  public void setMlpzt(String mlpzt) {
    this.mlpzt = mlpzt;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public void setMlpid(Long mlpid) {
    this.mlpid = mlpid;
  }

  public void setMlph(String mlph) {
    this.mlph = mlph;
  }

  public void setLxdbid(Long lxdbid) {
    this.lxdbid = lxdbid;
  }

  public void setKtglh(String ktglh) {
    this.ktglh = ktglh;
  }

  public void setJssj(String jssj) {
    this.jssj = jssj;
  }

  public void setJlx(String jlx) {
    this.jlx = jlx;
  }

  public void setJlrq(String jlrq) {
    this.jlrq = jlrq;
  }

  public void setJlrid(Long jlrid) {
    this.jlrid = jlrid;
  }

  public void setJllb(String jllb) {
    this.jllb = jllb;
  }

  public void setJlbz(String jlbz) {
    this.jlbz = jlbz;
  }

  public void setJcwh(String jcwh) {
    this.jcwh = jcwh;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public void setCxlb(String cxlb) {
    this.cxlb = cxlb;
  }

  public void setCsrq(String csrq) {
    this.csrq = csrq;
  }

  public void setCjhjywid(Long cjhjywid) {
    this.cjhjywid = cjhjywid;
  }

  public void setCdrid(Long cdrid) {
    this.cdrid = cdrid;
  }

  public void setCcrq(String ccrq) {
    this.ccrq = ccrq;
  }

  public void setCchjywid(Long cchjywid) {
    this.cchjywid = cchjywid;
  }

  public void setBzyy(String bzyy) {
    this.bzyy = bzyy;
  }

}