package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import com.hzjc.hz2004.po.*;

/**
 * �������ط�����Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoLhhdfhxx
    extends DefaultVO {

  //�����ڲ�ID
  private Long hhnbid;

  //��¥���ڲ�ID
  private Long mlpnbid;

  private PoHJXX_MLPXXXXB poHJXX_MLPXXXXB;
  private PoHJXX_HXXB poHJXX_HXXB;

  public Long getHhnbid() {
    return hhnbid;
  }

  public Long getMlpnbid() {
    return mlpnbid;
  }

  public void setMlpnbid(Long mlpnbid) {
    this.mlpnbid = mlpnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public PoHJXX_HXXB getPoHJXX_HXXB() {
    return poHJXX_HXXB;
  }

  public void setPoHJXX_HXXB(PoHJXX_HXXB poHJXX_HXXB) {
    this.poHJXX_HXXB = poHJXX_HXXB;
  }

  public PoHJXX_MLPXXXXB getPoHJXX_MLPXXXXB() {
    return poHJXX_MLPXXXXB;
  }

  public void setPoHJXX_MLPXXXXB(PoHJXX_MLPXXXXB poHJXX_MLPXXXXB) {
    this.poHJXX_MLPXXXXB = poHJXX_MLPXXXXB;
  }

}