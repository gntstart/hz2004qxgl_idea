package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ���֤����������ҵ�񷵻���ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoYdslzfywfhxx
    extends DefaultVO {

  private VoYdslzffhxx voYdslzffhxx[]; //֤���������Ϸ�����Ϣ

  public VoYdslzfywfhxx() {
  }

  public VoYdslzffhxx[] getVoYdslzffhxx() {
    return voYdslzffhxx;
  }

  public void setVoYdslzffhxx(VoYdslzffhxx[] voYdslzffhxx) {
    this.voYdslzffhxx = voYdslzffhxx;
  }

}