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

public class VoZjshywfhxx
    extends DefaultVO {

  private Long zjywid; //֤��ҵ��ID
  private VoZjshfhxx[] voZjshfhxx; //֤����˷�����Ϣ

  public Long getZjywid() {
    return zjywid;
  }

  public void setZjywid(Long zjywid) {
    this.zjywid = zjywid;
  }

  public VoZjshfhxx[] getVoZjshfhxx() {
    return voZjshfhxx;
  }

  public void setVoZjshfhxx(VoZjshfhxx[] voZjshfhxx) {
    this.voZjshfhxx = voZjshfhxx;
  }
}