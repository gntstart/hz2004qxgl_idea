package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ַ�����޸�ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoDzdjxgywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * ��ַ�����޸ķ�����Ϣ
   */
  private VoDzdjxgfhxx voDzdjxgfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoDzdjxgfhxx[] getVoDzdjxgfhxx() {
    return voDzdjxgfhxx;
  }

  public void setVoDzdjxgfhxx(VoDzdjxgfhxx[] voDzdjxgfhxx) {
    this.voDzdjxgfhxx = voDzdjxgfhxx;
  }
}
