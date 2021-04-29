package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import com.hzjc.hz2004.po.PoHJXX_PZRZB;
import com.hzjc.hz2004.po.PoZJYW_SLXXB;
import org.apache.commons.beanutils.*;
import java.lang.reflect.*;

/**
 * ������־��Ϣ��ȡ������ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoPzrzxxHqFhxx
    extends DefaultVO {

  //������־��Ϣ
  private Long pzrzid; //������־ID
  private Long zplsid; //��Ƭ��ˮID
  private Long nbslid; //�ڲ�����ID
  private Long yhid; //�û�ID
  private String ipdz; //IP��ַ
  private String yhdlm; //�û���¼��
  private String yhdw; //�û���λ
  private String yhxm; //�û�����
  private String bcsj; //����ʱ��
  private String rksj; //���ʱ��
  private String gmsfhm; //������ݺ���
  private String slh; //�����
  private String pzxlh; //�������к�
  //֤��������Ϣ
  //private Long nbslid;
  //private String slh;
  private Long ryid; //��ԱID
  private Long rynbid; //��Ա�ڲ�ID
  private Long zpid; //��ƬID
  private String qfjg; //ǩ������
  private String yxqxqsrq; //��Ч������ʼ����
  private String yxqxjzrq; //��Ч���޽�ֹ����
  private String zz; //סַ
  private String slyy; //����ԭ��
  private String zzlx; //��֤����
  private String lqfs; //��ȡ��ʽ
  private String sflx; //�շ�����
  private String sjblsh; //���ݰ���ˮ��
  private String slzt; //����״̬
  private Long zjywid; //֤��ҵ��ID
  private String cxbz; //������־
  private String cxsj; //����ʱ��
  private Long cxrid; //������ID
  private Long cxzjywid; //����֤��ҵ��ID
  private Float sfje; //�շѽ��

  public VoPzrzxxHqFhxx() {
  }

  public VoPzrzxxHqFhxx(PoHJXX_PZRZB poPzrzxx, PoZJYW_SLXXB poSlxx) {
    try {
      BeanUtils.copyProperties(this, poPzrzxx);
      BeanUtils.copyProperties(this, poSlxx);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

    return;
  }

  public String getBcsj() {
    return bcsj;
  }

  public void setBcsj(String bcsj) {
    this.bcsj = bcsj;
  }

  public String getCxbz() {
    return cxbz;
  }

  public void setCxbz(String cxbz) {
    this.cxbz = cxbz;
  }

  public Long getCxrid() {
    return cxrid;
  }

  public void setCxrid(Long cxrid) {
    this.cxrid = cxrid;
  }

  public String getCxsj() {
    return cxsj;
  }

  public void setCxsj(String cxsj) {
    this.cxsj = cxsj;
  }

  public Long getCxzjywid() {
    return cxzjywid;
  }

  public void setCxzjywid(Long cxzjywid) {
    this.cxzjywid = cxzjywid;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getIpdz() {
    return ipdz;
  }

  public void setIpdz(String ipdz) {
    this.ipdz = ipdz;
  }

  public String getLqfs() {
    return lqfs;
  }

  public void setLqfs(String lqfs) {
    this.lqfs = lqfs;
  }

  public Long getNbslid() {
    return nbslid;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }

  public Long getPzrzid() {
    return pzrzid;
  }

  public void setPzrzid(Long pzrzid) {
    this.pzrzid = pzrzid;
  }

  public String getPzxlh() {
    return pzxlh;
  }

  public void setPzxlh(String pzxlh) {
    this.pzxlh = pzxlh;
  }

  public String getQfjg() {
    return qfjg;
  }

  public void setQfjg(String qfjg) {
    this.qfjg = qfjg;
  }

  public String getRksj() {
    return rksj;
  }

  public void setRksj(String rksj) {
    this.rksj = rksj;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Float getSfje() {
    return sfje;
  }

  public void setSfje(Float sfje) {
    this.sfje = sfje;
  }

  public String getSflx() {
    return sflx;
  }

  public void setSflx(String sflx) {
    this.sflx = sflx;
  }

  public String getSjblsh() {
    return sjblsh;
  }

  public void setSjblsh(String sjblsh) {
    this.sjblsh = sjblsh;
  }

  public String getSlh() {
    return slh;
  }

  public void setSlh(String slh) {
    this.slh = slh;
  }

  public String getSlyy() {
    return slyy;
  }

  public void setSlyy(String slyy) {
    this.slyy = slyy;
  }

  public String getSlzt() {
    return slzt;
  }

  public void setSlzt(String slzt) {
    this.slzt = slzt;
  }

  public String getYhdlm() {
    return yhdlm;
  }

  public void setYhdlm(String yhdlm) {
    this.yhdlm = yhdlm;
  }

  public String getYhdw() {
    return yhdw;
  }

  public void setYhdw(String yhdw) {
    this.yhdw = yhdw;
  }

  public Long getYhid() {
    return yhid;
  }

  public void setYhid(Long yhid) {
    this.yhid = yhid;
  }

  public String getYhxm() {
    return yhxm;
  }

  public void setYhxm(String yhxm) {
    this.yhxm = yhxm;
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

  public Long getZjywid() {
    return zjywid;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }

  public Long getZpid() {
    return zpid;
  }

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public Long getZplsid() {
    return zplsid;
  }

  public void setZplsid(Long zplsid) {
    this.zplsid = zplsid;
  }

  public String getZz() {
    return zz;
  }

  public void setZz(String zz) {
    this.zz = zz;
  }

  public String getZzlx() {
    return zzlx;
  }

  public void setZzlx(String zzlx) {
    this.zzlx = zzlx;
  }

}