package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ֤����������ҵ�񷵻���ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoZjslzfywfhxx
    extends DefaultVO {

  private VoZjslzffhxx voZjslzffhxx[]; //֤���������Ϸ�����Ϣ

  public VoZjslzfywfhxx() {
  }

  public VoZjslzffhxx[] getVoZjslzffhxx() {
    return voZjslzffhxx;
  }

  public void setVoZjslzffhxx(VoZjslzffhxx[] voZjslzffhxx) {
    this.voZjslzffhxx = voZjslzffhxx;
  }

}