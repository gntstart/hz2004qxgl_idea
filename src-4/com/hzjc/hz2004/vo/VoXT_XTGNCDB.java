package  com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.*;
import com.hzjc.hz2004.po.PoXT_XTGNCDB;

/**
 * <p>Title: HZ2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��
 *                 ϵͳ���������������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author huhua(hh_hz@126.com)
 * @version 1.0
 */

public class VoXT_XTGNCDB
    extends DefaultVO{

  private long gncdid;
  private String cdcc;
  private String cdbz;
  private String cdlx;
  private String zdlb;
  private String cdmc;

  public void setGncdid(long gncdid) {
    this.gncdid = gncdid;
  }

  public long getGncdid() {
    return gncdid;
  }

  public void setCdcc(String cdcc) {
    this.cdcc = cdcc;
  }

  public String getCdcc() {
    return cdcc;
  }

  public void setCdbz(String cdbz) {
    this.cdbz = cdbz;
  }

  public String getCdbz() {
    return cdbz;
  }

  public void setCdlx(String cdlx) {
    this.cdlx = cdlx;
  }

  public String getCdlx() {
    return cdlx;
  }

  public void setZdlb(String zdlb) {
    this.zdlb = zdlb;
  }

  public String getZdlb() {
    return zdlb;
  }

  public void setCdmc(String cdmc) {
    this.cdmc = cdmc;
  }

  public String getCdmc() {
    return cdmc;
  }

}
