package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ַע��ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoDzzxywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * ��ַע��������Ϣ
   */
  private VoDzzxfhxx voDzzxfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoDzzxfhxx[] getVoDzzxfhxx() {
    return voDzzxfhxx;
  }

  public void setVoDzzxfhxx(VoDzzxfhxx[] voDzzxfhxx) {
    this.voDzzxfhxx = voDzzxfhxx;
  }

}
