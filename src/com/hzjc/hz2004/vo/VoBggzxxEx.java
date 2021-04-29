package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import java.util.List;

/**
 * ���������Ϣ��ǿVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoBggzxxEx
    extends DefaultVO {

  private int flag = 1; //
  private Long rynbid; //
  private Long sbhjywid; //
  private List<VoBggzxx> bggzxxList; //list(VoBggzxx List)

  public List<VoBggzxx> getBggzxxList() {
    return bggzxxList;
  }

  public void setBggzxxList(List<VoBggzxx> bggzxxList) {
    this.bggzxxList = bggzxxList;
  }

  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  public Long getRynbid() {
    return rynbid;
  }

  public void setRynbid(Long rynbid) {
    this.rynbid = rynbid;
  }

  public Long getSbhjywid() {
    return sbhjywid;
  }

  public void setSbhjywid(Long sbhjywid) {
    this.sbhjywid = sbhjywid;
  }

}