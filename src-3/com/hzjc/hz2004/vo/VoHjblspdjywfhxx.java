package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ������¼�����Ǽ�ҵ�񷵻���ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: GNT Corp.</p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHjblspdjywfhxx
    extends DefaultVO {

  private VoHjblspdjfhxx voHjblspdjfhxx[]; //����¼�����ǼǷ�����Ϣ

  public VoHjblspdjfhxx[] getVoHjblspdjfhxx() {
    return voHjblspdjfhxx;
  }

  public void setVoHjblspdjfhxx(VoHjblspdjfhxx[] voHjblspdjfhxx) {
    this.voHjblspdjfhxx = voHjblspdjfhxx;
  }

}