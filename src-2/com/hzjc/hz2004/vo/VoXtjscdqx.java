package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoXT_JSCDQXB;
import com.hzjc.hz2004.po.PoXT_XTGNCDB;
import com.hzjc.hz2004.po.PoXT_JSXXB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * <p>Title: HZ2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��
 *                 �û���ɫ����Ȩ�޲���VO</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author huhua(hh_hz@126.com)
 * @version 1.0
 */

public class VoXtjscdqx
    extends DefaultVO {
  /**
   *
   * @param poXT_MBLCXXB
   * @param poXT_SPDZB
   * @param poXT_SPMBXXB
   */
  public VoXtjscdqx() {
  }

  public VoXtjscdqx(PoXT_JSCDQXB poXT_JSCDQXB, PoXT_JSXXB poXT_JSXXB,
                    PoXT_XTGNCDB poXT_XTGNCDB) {

    try {
      BeanUtils.copyProperties(this, poXT_JSCDQXB);
      BeanUtils.copyProperties(this, poXT_JSXXB);
      BeanUtils.copyProperties(this, poXT_XTGNCDB);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

  }

  //��ɫ�˵�
  private Long jscdid;
  private Long gncdid;
  private Long jsid;
  //�û���ɫ��Ϣ
  private Long yhjsid;
  private Long yhid;
  //private Long jsid;

  //�˵���Ϣ
  // private Long gncdid;
  private String cdcc;
  private String cdbz;
  private String cdlx;
  private String zdlb;
  private String cdmc;
//��ɫ
  public void setJscdid(Long jscdid) {
    this.jscdid = jscdid;
  }

  public Long getJscdid() {
    return jscdid;
  }

  public void setGncdid(Long gncdid) {
    this.gncdid = gncdid;
  }

  public Long getGncdid() {
    return gncdid;
  }

  public void setJsid(Long jsid) {
    this.jsid = jsid;
  }

  public Long getJsid() {
    return jsid;
  }

  //�û���ɫ��Ϣ
  public void setYhjsid(Long yhjsid) {
    this.yhjsid = yhjsid;
  }

  public Long getYhjsid() {
    return yhjsid;
  }

  public void setYhid(Long yhid) {
    this.yhid = yhid;
  }

  public Long getYhid() {
    return yhid;
  }

  //���ܲ˵�

  public void setCdcc(String cdcc) {
    this.cdcc = cdcc;
  }

  public String getCdcc() {
    return cdcc;
  }

  public void setCdbz(String cdbz) {
    this.cdbz = cdbz;
  }

  public String getCdbz() {
    return cdbz;
  }

  public void setCdlx(String cdlx) {
    this.cdlx = cdlx;
  }

  public String getCdlx() {
    return cdlx;
  }

  public void setZdlb(String zdlb) {
    this.zdlb = zdlb;
  }

  public String getZdlb() {
    return zdlb;
  }

  public void setCdmc(String cdmc) {
    this.cdmc = cdmc;
  }

  public String getCdmc() {
    return cdmc;
  }

}
