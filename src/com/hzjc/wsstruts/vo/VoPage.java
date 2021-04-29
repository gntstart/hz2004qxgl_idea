package com.hzjc.wsstruts.vo;

public class VoPage
    implements VO {
  private int pageoffset = 0;
  private int pagesize = 20;
  private long recordcount = -1;

  public int getPageoffset() {
    return pageoffset;
  }

  public void setPageoffset(int pageoffset) {
    this.pageoffset = pageoffset;
  }

  public int getPagesize() {
    return pagesize;
  }

  public void setPagesize(int pagesize) {
    this.pagesize = pagesize;
  }

  public long getRecordcount() {
    return recordcount;
  }

  public void setRecordcount(long recordcount) {
    this.recordcount = recordcount;
  }

}
