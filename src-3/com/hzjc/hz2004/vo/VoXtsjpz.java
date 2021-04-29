package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoXT_YHXXB;
import com.hzjc.hz2004.po.PoXT_SPDZB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * <p>Title: HZ2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��
 *                 �������ò���VO</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author huhua(hh_hz@126.com)
 * @version 1.0
 */

public class VoXtsjpz
    extends DefaultVO {

  //��������
  private String pzlb;
  private String pzmc;
  private String bdsj;
  public VoXtsjpz() {
  }

  public VoXtsjpz(String sPzlb, String sPzmc, String sBdsj) {
    this.pzlb = sPzlb;
    this.pzmc = sPzmc;
    this.bdsj = sBdsj;
  }

  //��������
  public void setPzlb(String pzlb) {
    this.pzlb = pzlb;
  }

  public String getPzlb() {
    return this.pzlb;
  }

  public void setPzmc(String pzmc) {
    this.pzmc = pzmc;
  }

  public String getPzmc() {
    return this.pzmc;
  }

  public void setBdsj(String bdsj) {
    this.bdsj = bdsj;
  }

  public String getBdsj() {
    return bdsj;
  }

}
