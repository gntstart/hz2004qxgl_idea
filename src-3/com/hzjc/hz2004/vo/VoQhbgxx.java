package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ȫ�������ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQhbgxx
    extends DefaultVO {

  private Long hhnbid; //�����ڲ�ID
  private String jlx; //��·��
  private String mlph; //��¥�ƺ�
  private String mlxz; //��¥��ַ
  private String hlx; //������

  public VoQhbgxx() {
  }

  public Long getHhnbid() {
    return hhnbid;
  }

  public void setHhnbid(Long hhnbid) {
    this.hhnbid = hhnbid;
  }

  public String getHlx() {
    return hlx;
  }

  public void setHlx(String hlx) {
    this.hlx = hlx != null ? hlx.trim() : hlx;
  }

  public String getMlph() {
    return mlph;
  }

  public void setMlph(String mlph) {
    this.mlph = mlph != null ? mlph.trim() : mlph;
  }

  public String getMlxz() {
    return mlxz;
  }

  public void setMlxz(String mlxz) {
    this.mlxz = mlxz != null ? mlxz.trim() : mlxz;
  }

  public String getJlx() {
    return jlx;
  }

  public void setJlx(String jlx) {
    this.jlx = jlx != null ? jlx.trim() : jlx;
  }

}