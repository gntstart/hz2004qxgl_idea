package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * �걨������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoSbjbxx
    extends DefaultVO {

  //�걨ʱ��
  private String sbsj;

  //�걨��Ա����
  private String sbryxm;

  //�걨�˹�����ݺ���
  private String sbrgmsfhm;

  private String sbrjtgx;

  //��֤ҵ��ID���ر���
  private String hzywid;

  public String getHzywid() {
    return hzywid;
  }

  public void setHzywid(String hzywid) {
    this.hzywid = hzywid;
  }


  public String getSbrgmsfhm() {
    return sbrgmsfhm;
  }

  public void setSbrgmsfhm(String sbrgmsfhm) {
    this.sbrgmsfhm = sbrgmsfhm;
  }

  public String getSbryxm() {
    return sbryxm;
  }

  public void setSbryxm(String sbryxm) {
    this.sbryxm = sbryxm;
  }

  public String getSbsj() {
    return sbsj;
  }

  public void setSbsj(String sbsj) {
    this.sbsj = sbsj;
  }

        public String getSbrjtgx() {
                return sbrjtgx;
        }
        public void setSbrjtgx(String sbrjtgx) {
                this.sbrjtgx = sbrjtgx;
        }


}
