package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��������������ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSpfdclxx
    extends DefaultVO {

  private String clbh; //���ϱ��

  //��֤ҵ��ID���ر���
  private String hzywid;


  public String getHzywid() {
    return hzywid;
  }

  public void setHzywid(String hzywid) {
    this.hzywid = hzywid;
  }


  public VoSpfdclxx() {
  }

  public String getClbh() {
    return clbh;
  }

  public void setClbh(String clbh) {
    this.clbh = clbh;
  }

}
