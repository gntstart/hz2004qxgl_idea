package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoHJSP_HJBLSPSQB;
import com.hzjc.hz2004.po.PoXT_SPDZB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

public class VoHjblspxxHqFhxx
    extends DefaultVO {

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

  //����������Ϣ
  private Long dzid; //����ID
  private String dzmc; //��������
  private String ms; //����
  private String qybz; //���ñ�־

  //ǰ̨��Ҫ
  private String hjbllb; //������¼���


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


  public VoHjblspxxHqFhxx() {
  }

  public VoHjblspxxHqFhxx(PoHJSP_HJBLSPSQB poHjblspxx, PoXT_SPDZB poSpdzxx) {
    try {
      BeanUtils.copyProperties(this, poHjblspxx);
      if (poSpdzxx != null) {
        BeanUtils.copyProperties(this, poSpdzxx);
      }
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

    this.setHjbllb(this.getBlyy());
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

  public String getMs() {
    return ms;
  }

  public void setMs(String ms) {
    this.ms = ms;
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

  public String getQybz() {
    return qybz;
  }

  public void setQybz(String qybz) {
    this.qybz = qybz;
  }

  public String getRlhbz() {
    return rlhbz;
  }

  public void setRlhbz(String rlhbz) {
    this.rlhbz = rlhbz;
  }

  public void setLsbz(String lsbz) {
    this.lsbz = lsbz;
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

  public void setSg(String sg) {
    this.sg = sg;
  }

  public String getSpjg() {
    return spjg;
  }

  public Long getSpmbid() {
    return spmbid;
  }

  public void setSpmbid(Long spmbid) {
    this.spmbid = spmbid;
  }

  public Long getSpywid() {
    return spywid;
  }

  public void setSpywid(Long spywid) {
    this.spywid = spywid;
  }

  public String getSshh() {
    return sshh;
  }

  public void setSshh(String sshh) {
    this.sshh = sshh;
  }

  public Long getSshhid() {
    return sshhid;
  }

  public void setSshhid(Long sshhid) {
    this.sshhid = sshhid;
  }

  public String getSshlx() {
    return sshlx;
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

  public void setSspcs(String sspcs) {
    this.sspcs = sspcs;
  }

  public String getSsssxq() {
    return ssssxq;
  }

  public void setSsssxq(String ssssxq) {
    this.ssssxq = ssssxq;
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

  public void setXx(String xx) {
    this.xx = xx;
  }

  public void setXxjb(String xxjb) {
    this.xxjb = xxjb;
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

  public String getZy() {
    return zy;
  }

  public void setZjxy(String zjxy) {
    this.zjxy = zjxy;
  }

  public void setZy(String zy) {
    this.zy = zy;
  }

  public String getZjxy() {
    return zjxy;
  }

  public String getZylb() {
    return zylb;
  }

  public void setZylb(String zylb) {
    this.zylb = zylb;
  }

  public String getXxjb() {
    return xxjb;
  }

  public void setSpjg(String spjg) {
    this.spjg = spjg;
  }

  public String getHjbllb() {
    return hjbllb;
  }

  public void setHjbllb(String hjbllb) {
    this.hjbllb = hjbllb;
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
  public void setSbrjtgx(String sbrjtgx) {
          this.sbrjtgx = sbrjtgx;
  }

}
