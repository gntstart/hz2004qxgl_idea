package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ַ����ɾ��ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoDzdjscywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * ��ַ����ɾ��������Ϣ
   */
  private VoDzdjscfhxx voDzdjscfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoDzdjscfhxx[] getVoDzdjscfhxx() {
    return voDzdjscfhxx;
  }

  public void setVoDzdjscfhxx(VoDzdjscfhxx[] voDzdjscfhxx) {
    this.voDzdjscfhxx = voDzdjscfhxx;
  }
}
