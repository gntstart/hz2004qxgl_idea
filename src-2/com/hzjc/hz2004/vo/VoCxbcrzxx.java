package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class VoCxbcrzxx extends DefaultVO {
  private String gnbh;//¹¦ÄÜ±àºÅ
  private String cxyj;//²éÑ¯Óï¾ä

  public void setGnbh(String gnbh) {
    this.gnbh = gnbh;
  }

  public String getGnbh() {
    return gnbh;
  }

  public void setCxyj(String cxyj) {
    this.cxyj = cxyj;
  }

  public String getCxyj() {
    return cxyj;
  }
}
