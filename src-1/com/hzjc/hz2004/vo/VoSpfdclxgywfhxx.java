package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * �������������޸�ҵ�񷵻���ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSpfdclxgywfhxx
    extends DefaultVO {

  private Long spywid; //����ҵ��ID
  private String splx; //��������
  private VoSpfdclxgfhxx voSpfdclxgfhxx[]; //�������������޸ķ�����Ϣ

  public VoSpfdclxgywfhxx() {
  }

  public String getSplx() {
    return splx;
  }

  public void setSplx(String splx) {
    this.splx = splx;
  }

  public Long getSpywid() {
    return spywid;
  }

  public void setSpywid(Long spywid) {
    this.spywid = spywid;
  }

  public VoSpfdclxgfhxx[] getVoSpfdclxgfhxx() {
    return voSpfdclxgfhxx;
  }

  public void setVoSpfdclxgfhxx(VoSpfdclxgfhxx[] voSpfdclxgfhxx) {
    this.voSpfdclxgfhxx = voSpfdclxgfhxx;
  }

}