package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ��������������ҵ�񷵻���Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHbbgspspywfhxx
    extends DefaultVO {

  private VoHbbgspspfhxx voHbbgspspfhxx[]; //����ɾ����������������Ϣ

  public void setVoHbbgspspfhxx(VoHbbgspspfhxx[] voHbbgspspfhxx) {
    this.voHbbgspspfhxx = voHbbgspspfhxx;
  }

  public VoHbbgspspfhxx[] getVoHbbgspspfhxx() {
    return voHbbgspspfhxx;
  }

}
