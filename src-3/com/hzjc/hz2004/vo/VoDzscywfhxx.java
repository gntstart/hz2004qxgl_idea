package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ַɾ��ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoDzscywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * ��ַɾ��������Ϣ
   */
  private VoDzscfhxx voDzscfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public void setVoDzscfhxx(VoDzscfhxx[] voDzscfhxx) {
    this.voDzscfhxx = voDzscfhxx;
  }

  public VoDzscfhxx[] getVoDzscfhxx() {
    return voDzscfhxx;
  }
}
