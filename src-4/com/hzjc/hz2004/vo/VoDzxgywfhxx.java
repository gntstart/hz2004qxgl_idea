package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��ַ�޸�ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoDzxgywfhxx
    extends DefaultVO {

  /**
   * ����ҵ��ID
   */
  private Long hjywid;

  /**
   * ��ַ�޸ķ�����Ϣ
   */
  private VoDzxgfhxx voDzxgfhxx[];

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoDzxgfhxx[] getVoDzxgfhxx() {
    return voDzxgfhxx;
  }

  public void setVoDzxgfhxx(VoDzxgfhxx[] voDzxgfhxx) {
    this.voDzxgfhxx = voDzxgfhxx;
  }

}
