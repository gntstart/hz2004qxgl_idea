package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

public class VoBgspspxx
    extends DefaultVO {

  private Long spywid; //����ҵ��ID
  private Long dzid; //����ID
  private String czjg; //�������
  private String czyj; //�������

  public String getCzjg() {
    return czjg;
  }

  public void setCzjg(String czjg) {
    this.czjg = czjg;
  }

  public String getCzyj() {
    return czyj;
  }

  public void setCzyj(String czyj) {
    this.czyj = czyj;
  }

  public Long getSpywid() {
    return spywid;
  }

  public void setSpywid(Long spywid) {
    this.spywid = spywid;
  }

  public Long getDzid() {
    return dzid;
  }

  public void setDzid(Long dzid) {
    this.dzid = dzid;
  }

}