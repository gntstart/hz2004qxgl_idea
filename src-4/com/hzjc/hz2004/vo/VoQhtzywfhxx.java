package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��������ҵ�񷵻���ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQhtzywfhxx
    extends DefaultVO {

  private Long hjywid; //����ҵ��ID
  private VoQhtzfhxx voQhtzfhxx[]; //��ַ�޸ķ�����Ϣ

  public Long getHjywid() {
    return hjywid;
  }

  public void setHjywid(Long hjywid) {
    this.hjywid = hjywid;
  }

  public VoQhtzfhxx[] getVoQhtzfhxx() {
    return voQhtzfhxx;
  }

  public void setVoQhtzfhxx(VoQhtzfhxx[] voQhtzfhxx) {
    this.voQhtzfhxx = voQhtzfhxx;
  }

}