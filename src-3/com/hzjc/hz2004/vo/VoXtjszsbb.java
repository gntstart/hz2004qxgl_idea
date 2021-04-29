package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoXT_JSZSBBQXB;
import com.hzjc.hz2004.po.PoXT_ZSBBMBXXB;
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

public class VoXtjszsbb
    extends DefaultVO {
  /**
   *
   * @param poXT_MBLCXXB
   * @param poXT_SPDZB
   * @param poXT_SPMBXXB
   */
  public VoXtjszsbb() {
  }

  public VoXtjszsbb(PoXT_JSZSBBQXB poXT_JSZSBBQXB, PoXT_JSXXB poXT_JSXXB,
                    PoXT_ZSBBMBXXB poXT_ZSBBMBXXB) {

    try {
      BeanUtils.copyProperties(this, poXT_JSZSBBQXB);
      BeanUtils.copyProperties(this, poXT_JSXXB);
      BeanUtils.copyProperties(this, poXT_ZSBBMBXXB);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

  }

  //��ɫ����
  private Long zsbbqxid;
  private Long jsid;
  private Long zsbbmbid;
  //�û���ɫ��Ϣ
  private Long yhjsid;
  private Long yhid;
  //private Long jsid;

  //����ģ����Ϣ
  private Long zsbbid;
  // private Long zsbbmbid;
  private String bbmbmc;
  private String jlsj;
  private Long scrid;
  private String xgsj;
  private Long xgrid;
//��ɫ����
  public void setZsbbqxid(Long zsbbqxid) {
    this.zsbbqxid = zsbbqxid;
  }

  public Long getZsbbqxid() {
    return zsbbqxid;
  }

  public void setJsid(Long jsid) {
    this.jsid = jsid;
  }

  public Long getJsid() {
    return jsid;
  }

  public void setZsbbid(Long zsbbid) {
    this.zsbbid = zsbbid;
  }

  public Long getZsbbid() {
    return zsbbid;
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

  //������Ϣ

  public void setZsbbmbid(Long zsbbmbid) {
    this.zsbbmbid = zsbbmbid;
  }

  public Long getZsbbmbid() {
    return zsbbmbid;
  }

  public void setBbmbmc(String bbmc) {
    this.bbmbmc = bbmc;
  }

  public String getBbmbmc() {
    return bbmbmc;
  }

  public void setJlsj(String jlsj) {
    this.jlsj = jlsj;
  }

  public String getJlsj() {
    return jlsj;
  }

  public void setScrid(Long scrid) {
    this.scrid = scrid;
  }

  public Long getScrid() {
    return scrid;
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
