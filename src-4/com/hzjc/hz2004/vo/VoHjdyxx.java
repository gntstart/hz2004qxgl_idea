package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;


/**
 * ������ӡ��ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT Corp. 2004</p>
 * <p>Company: </p>
 * @author hb
 * @version 1.0
 */

public class VoHjdyxx extends DefaultVO{

//  public VoHjdyxx(Object poView) {
//    try {
//      BeanUtils.copyProperties(this, poView);
//    }
//    catch (InvocationTargetException ex) {
//    }
//    catch (IllegalAccessException ex) {
//    }
//  }

  private Long dyid;//��ӡID
  private Long ryid;//��ԱID
  private Long rynbid;//��Ա�ڲ�ID
  private String gmsfhm;//������ݺ���
  private String xm;//����
  private String pcs;//�ɳ���
  private String ssxq;//ʡ������
  private String dylb;//��ӡ���
  private String zjbh;//֤�����
  private String yznf;//ӡ�����
  private String slsj;//����ʱ��
  private String sldw;//����λ
  private Long slrid;//������ID
  private String czip;//����IP
  private Long mlpnbid;//��¥���ڲ�ID
  private String jlx;//��·��
  private String mlph;//��¥�ƺ�
  private String mlxz;//��¥��ַ
  private String zrq;//������
  private String xzjd;//����ֵ�
  private String jcwh;//�Ӵ�ί��

  public void setDyid(Long dyid) {
    this.dyid = dyid;
  }

  public Long getDyid() {
    return dyid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public String getXm() {
    return xm;
  }

  public void setPcs(String pcs) {
    this.pcs = pcs;
  }

  public String getPcs() {
    return pcs;
  }

  public void setSsxq(String ssxq) {
    this.ssxq = ssxq;
  }

  public String getSsxq() {
    return ssxq;
  }

  public void setDylb(String dylb) {
    this.dylb = dylb;
  }

  public String getDylb() {
    return dylb;
  }

  public void setZjbh(String zjbh) {
    this.zjbh = zjbh;
  }

  public String getZjbh() {
    return zjbh;
  }

  public void setYznf(String yznf) {
    this.yznf = yznf;
  }

  public String getYznf() {
    return yznf;
  }

  public void setSlsj(String slsj) {
    this.slsj = slsj;
  }

  public String getSlsj() {
    return slsj;
  }

  public void setSldw(String sldw) {
    this.sldw = sldw;
  }

  public String getSldw() {
    return sldw;
  }

  public void setSlrid(Long slrid) {
    this.slrid = slrid;
  }

  public Long getSlrid() {
    return slrid;
  }

  public void setCzip(String czip) {
    this.czip = czip;
  }

  public String getCzip() {
    return czip;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public void setJlx(String jlx) {
    this.jlx = jlx;
  }

  public String getJlx() {
    return jlx;
  }

  public void setMlph(String mlph) {
    this.mlph = mlph;
  }

  public String getMlph() {
    return mlph;
  }

  public void setMlxz(String mlxz) {
    this.mlxz = mlxz;
  }

  public String getMlxz() {
    return mlxz;
  }

  public void setZrq(String zrq) {
    this.zrq = zrq;
  }

  public String getZrq() {
    return zrq;
  }

  public void setXzjd(String xzjd) {
    this.xzjd = xzjd;
  }

  public String getXzjd() {
    return xzjd;
  }

  public void setJcwh(String jcwh) {
    this.jcwh = jcwh;
  }

  public String getJcwh() {
    return jcwh;
  }


}
