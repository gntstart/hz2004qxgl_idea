package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoXT_JSGNQXB;
import com.hzjc.hz2004.po.PoXT_XTGNB;
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

public class VoXtjsgnqx
    extends DefaultVO {
  /**
   *
   * @param poXT_MBLCXXB
   * @param poXT_SPDZB
   * @param poXT_SPMBXXB
   */
  public VoXtjsgnqx() {
  }

  public VoXtjsgnqx(PoXT_JSGNQXB poXT_JSGNQXB, PoXT_JSXXB poXT_JSXXB,
                    PoXT_XTGNB poXT_XTGNB) {

    try {
      BeanUtils.copyProperties(this, poXT_JSGNQXB);
      BeanUtils.copyProperties(this, poXT_JSXXB);
      BeanUtils.copyProperties(this, poXT_XTGNB);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }

  }

  //��ɫ����
  private Long jsgnid;
  private Long gnid;
  private Long jsid;
  //�û���ɫ��Ϣ
  private Long yhjsid;
  private Long yhid;
  //private Long jsid;

  //������Ϣ
  // private Long gnid;
  private String gnbh;
  private String gnmc;
  private String gnlx;
  private String qybz;
//��ɫ
  public void setJsgnid(Long jsgnid) {
    this.jsgnid = jsgnid;
  }

  public Long getJsgnid() {
    return jsgnid;
  }

  public void setGnid(Long gnid) {
    this.gnid = gnid;
  }

  public Long getGnid() {
    return gnid;
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

  //����
  public void setGnbh(String gnbh) {
    this.gnbh = gnbh;
  }

  public String getGnbh() {
    return gnbh;
  }

  public void setGnmc(String gnmc) {
    this.gnmc = gnmc;
  }

  public String getGnmc() {
    return gnmc;
  }

  public void setGnlx(String gnlx) {
    this.gnlx = gnlx;
  }

  public String getGnlx() {
    return gnlx;
  }

  public void setQybz(String qybz) {
    this.qybz = qybz;
  }

  public String getQybz() {
    return qybz;
  }

}
