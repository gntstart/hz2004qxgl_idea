package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ȫ�����ҵ�񷵻���ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQhbgywfhxx
    extends DefaultVO {

  private Long hjywid; //����ҵ��ID
  private VoQhbgfhxx voQhbgfhxx[]; //ȫ�����������Ϣ

  public VoQhbgywfhxx() {
  }

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoQhbgfhxx[] getVoQhbgfhxx() {
    return voQhbgfhxx;
  }

  public void setVoQhbgfhxx(VoQhbgfhxx[] voQhbgfhxx) {
    this.voQhbgfhxx = voQhbgfhxx;
  }

}