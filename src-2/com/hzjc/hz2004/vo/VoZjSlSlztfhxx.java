package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.po.PO;

/**
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڹ���ϵͳHz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: �㽭����Ԫ�¼������޹�˾</p>
 * @author kgb_hz@126.com,kgb@primetech.com.cn
 * @version 1.0
 */

public class VoZjSlSlztfhxx
    implements PO {
  private String slzt;
  private int count;

  public VoZjSlSlztfhxx() {
  }

  /**
   *
   * @param strSlzt
   * @param iCount
   */
  public VoZjSlSlztfhxx(String strSlzt, int iCount) {
    this.slzt = strSlzt;
    this.count = iCount;
  }

  public String getSlzt() {
    return slzt;
  }

  public void setSlzt(String slzt) {
    this.slzt = slzt;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

}