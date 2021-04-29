package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;
import com.hzjc.hz2004.po.PoHJXX_RYZPXXB;

/**
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author Kansan Ku(kgb_hz@126.com)
 * @version 1.0
 */

public class VoHJXX_RYZPXXB
    extends DefaultVO {

  public VoHJXX_RYZPXXB() {
  }

  /**
   * PO-->VO(��PO��ֵת��װ�ص�VO��)
   * @param po
   */
  public VoHJXX_RYZPXXB(PoHJXX_RYZPXXB po) {
    //�̳л��ദ��
    super(po);
    //////////////////////////////////////////////////////////////////
    //byte[]-->String(����byte[]�ֽ������ֶ�Ҫ���⴦��:Base64����󸳸�VO)
    ///////////////////////////////////////////////////////////////////
    if (po.getZp() != null) {
      this.setZp(new String(encodeBytes(po.getZp())));
    }
  }

  /**
   *
   * @return
   */
  public PoHJXX_RYZPXXB toPoHJXX_RYZPXXB() {
    return toPoHJXX_RYZPXXB(null);
  }

  /**
   *
   * @param poRyzp
   * @return
   */
  public PoHJXX_RYZPXXB toPoHJXX_RYZPXXB(PoHJXX_RYZPXXB poRyzp) {
    if (poRyzp == null) {
      poRyzp = new PoHJXX_RYZPXXB();
    }
    poRyzp.setGmsfhm(this.getGmsfhm());
    poRyzp.setLrrq(this.getLrrq());
    poRyzp.setXm(this.getXm());
    poRyzp.setZpid(this.getZpid());
    poRyzp.setRyid(this.getRyid());
    poRyzp.setZp(decodeBytes(this.getZp() == null ? null :
                             this.getZp().getBytes()));
    ////////////////////////////////////////////////////////////////////
    return poRyzp;
  }

  private Long zpid;
  private String gmsfhm;
  private String xm;
  private String lrrq;
  private String zp; //����BASE64���б�����ַ�������
  private Long ryid;

  public String getGmsfhm() {
    return gmsfhm;
  }

  public String getLrrq() {
    return lrrq;
  }

  public String getXm() {
    return xm;
  }

  public String getZp() {
    return zp;
  }

  public Long getZpid() {
    return zpid;
  }

  public void setZpid(Long zpid) {
    this.zpid = zpid;
  }

  public void setZp(String zp) {
    this.zp = zp;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public void setLrrq(String lrrq) {
    this.lrrq = lrrq;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public Long getRyid() {
    return ryid;
  }

  public void setRyid(Long ryid) {
    this.ryid = ryid;
  }

}