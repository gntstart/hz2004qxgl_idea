package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڹ���ϵͳHz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: �㽭����Ԫ�¼������޹�˾</p>
 * @author kgb_hz@126.com,kgb@primetech.com.cn
 * @version 1.0
 */

public class VoZjshfhxx
    extends DefaultVO {

  private Long nbslid; //�ڲ�����ID
  private Long shqfid; //���ǩ��ID

  public Long getNbslid() {
    return nbslid;
  }

  public Long getShqfid() {
    return shqfid;
  }

  public void setNbslid(Long nbslid) {
    this.nbslid = nbslid;
  }

  public void setShqfid(Long shqfid) {
    this.shqfid = shqfid;
  }

}