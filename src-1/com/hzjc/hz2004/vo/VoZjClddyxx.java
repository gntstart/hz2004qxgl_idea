package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ����֤���쵥��ӡVO
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڹ���ϵͳHz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: �㽭����Ԫ�¼������޹�˾</p>
 * @author kgb_hz@126.com,kgb@primetech.com.cn
 * @version 1.0
 */

public class VoZjClddyxx
    extends DefaultVO {

  /**
   *
   */
  public VoZjClddyxx() {

  }

  /**
   *
   * @param lNbslid
   */
  public VoZjClddyxx(Long lNbslid) {
    this.nbslid = lNbslid;
  }

  private Long nbslid; //�ڲ�����ID

  public Long getNbslid() {
    return nbslid;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }

}