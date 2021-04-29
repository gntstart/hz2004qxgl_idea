package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoXT_JSYWBBQXB;
import com.hzjc.hz2004.po.PoXT_YWBBMBXXB;
import com.hzjc.hz2004.po.PoXT_JSXXB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * <p>Title: HZ2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��
 *                 �û���ɫҵ�񱨱�Ȩ�޲���VO</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author huhua(hh_hz@126.com)
 * @version 1.0
 */

public class VoXtjsywbb
    extends DefaultVO {
  /**
   *
   * @param poXT_MBLCXXB
   * @param poXT_SPDZB
   * @param poXT_SPMBXXB
   */
  public VoXtjsywbb() {
  }

  public VoXtjsywbb(PoXT_JSYWBBQXB poXT_JSYWBBQXB, PoXT_JSXXB poXT_JSXXB,
                    PoXT_YWBBMBXXB poXT_YWBBMBXXB) {

    try {
      BeanUtils.copyProperties(this, poXT_JSYWBBQXB);
      BeanUtils.copyProperties(this, poXT_JSXXB);
      BeanUtils.copyProperties(this, poXT_YWBBMBXXB);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

  }

  //��ɫҵ�񱨱�
  private Long ywbbqxid;
  private Long jsid;
  private Long ywbbid;
  //�û���ɫ��Ϣ
  private Long yhjsid;
  private Long yhid;
  //private Long jsid;

  //ҵ�񱨱�ģ����Ϣ
  //private Long ywbbid;
  private String ywbblb;
  private String bbmc;
  private String jlsj;
  private Long jlrid;
  private String xgsj;
  private Long xgrid;
//��ɫҵ�񱨱�
  public void setYwbbqxid(Long ywbbqxid) {
    this.ywbbqxid = ywbbqxid;
  }

  public Long getYwbbqxid() {
    return ywbbqxid;
  }

  public void setJsid(Long jsid) {
    this.jsid = jsid;
  }

  public Long getJsid() {
    return jsid;
  }

  public void setYwbbid(Long ywbbid) {
    this.ywbbid = ywbbid;
  }

  public Long getYwbbid() {
    return ywbbid;
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

  //�û�ҵ�񱨱���Ϣ
  public void setYwbblb(String ywbblb) {
    this.ywbblb = ywbblb;
  }

  public String getYwbblb() {
    return ywbblb;
  }

  public void setBbmc(String bbmc) {
    this.bbmc = bbmc;
  }

  public String getBbmc() {
    return bbmc;
  }

  public void setJlsj(String jlsj) {
    this.jlsj = jlsj;
  }

  public String getJlsj() {
    return jlsj;
  }

  public void setJlrid(Long jlrid) {
    this.jlrid = jlrid;
  }

  public Long getJlrid() {
    return jlrid;
  }

  public void setXgsj(String xgsj) {
    this.xgsj = xgsj;
  }

  public String getXgsj() {
    return xgsj;
  }

  public void setXgrid(Long xgrid) {
    this.xgrid = xgrid;
  }

  public Long getXgrid() {
    return xgrid;
  }

}
