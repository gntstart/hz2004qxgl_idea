package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����ϵ����ҵ�񷵻���ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHgxzjywfhxx
    extends DefaultVO {

  private VoHgxzjfhxx voHgxzjfhxx[]; //����ϵ���ӷ�����Ϣ

  public VoHgxzjfhxx[] getVoHgxzjfhxx() {
    return voHgxzjfhxx;
  }

  public void setVoHgxzjfhxx(VoHgxzjfhxx[] voHgxzjfhxx) {
    this.voHgxzjfhxx = voHgxzjfhxx;
  }

}