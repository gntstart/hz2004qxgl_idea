package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * 长三角户口跨省网上迁移信息
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoCsjKsWsQyxx
    extends DefaultVO {

  private String ds; //地市代码或单位代码
  private String dsmc; //地市名称或单位名称
  private String qyzybyb; //迁移证已办已报
  private String qyzybwb; //迁移证已办未报
  private String qyzwb; //迁移证未报
  private String zqzyb; //准迁证已办
  private String zqzwb; //准迁证未办
  private String heji; //合计

  public String getDs() {
    return ds;
  }

  public void setDs(String ds) {
    this.ds = ds;
  }

  public String getDsmc() {
    return dsmc;
  }

  public void setDsmc(String dsmc) {
    this.dsmc = dsmc;
  }

  public String getQyzybyb() {
    return qyzybyb;
  }

  public void setQyzybyb(String qyzybyb) {
    this.qyzybyb = qyzybyb;
  }

  public String getQyzybwb() {
    return qyzybwb;
  }

  public void setQyzybwb(String qyzybwb) {
    this.qyzybwb = qyzybwb;
  }

  public String getQyzwb() {
    return qyzwb;
  }

  public void setQyzwb(String qyzwb) {
    this.qyzwb = qyzwb;
  }

  public String getZqzyb() {
    return zqzyb;
  }

  public void setZqzyb(String zqzyb) {
    this.zqzyb = zqzyb;
  }

  public String getZqzwb() {
    return zqzwb;
  }

  public void setZqzwb(String zqzwb) {
    this.zqzwb = zqzwb;
  }

  public String getHeji() {
    return heji;
  }

  public void setHeji(String heji) {
    this.heji = heji;
  }
}
