package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.DefaultVO;

/**
 * ϵͳ�û�������־��VO
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڹ���ϵͳHz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: �㽭����Ԫ�¼������޹�˾</p>
 * @author kgb_hz@126.com,kgb@primetech.com.cn
 * @version 1.0
 */

public class VoCzrzxx
    extends DefaultVO {
  private String ywbz; //ҵ��ID
  private String khdip; //�û�IP
  private String czkssj; //��ʼʱ��
  private String czjssj; //����ʱ��
  private String rzlx; //��־����
  private String rznr;//��־����
  private Long czyid;//�û�ID
  private Long zxsj; //ִ��ʱ��
  private String organization;// ORGANIZATION;
  private String organizationId;//ORGANIZATION_ID;
  private String operateType;//OPERATE_TYPE;
  private String operateResult;//OPERATE_RESULT;
  private String errorCode;//ERROR_CODE;
  private String operateName;//OPERATE_NAME;
  private String resourceType;//RESOURCE_TYPE;
  private String resourceName;//RESOURCE_NAME;
  private String czyxm;

  public void setCzyxm(String czyxm) {
        this.czyxm = czyxm;
    }

    public String getCzyxm() {
        return czyxm;
    }


  public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceType() {
        return resourceType;
    }


    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
      }

    public String getErrorCode() {
        return errorCode;
    }

    public void setOperateResult(String operateResult) {
      this.operateResult = operateResult;
    }

    public String getOperateResult() {
      return operateResult;
    }

    public void setOperateType(String operateType) {
      this.operateType = operateType;
    }

    public String getOperateType() {
      return operateType;
    }

    public String getOrganizationId() {
      return organizationId;
    }

    public void setOrganizationId(String organizationId) {
      this.organizationId = organizationId;
    }

    public String getOrganization() {
      return organization;
    }
    public void setOrganization(String organization) {
      this.organization = organization;
  }

  public VoCzrzxx() {
  }

  public Long getCzyid() {
    return czyid;
  }

  public void setCzyid(Long czyid) {
    this.czyid = czyid;
  }

  public String getYwbz() {
    return ywbz;
  }

  public void setYwbz(String ywbz) {
    this.ywbz = ywbz;
  }

  public String getKhdip() {
    return khdip;
  }

  public void setKhdip(String khdip) {
    this.khdip = khdip;
  }

  public String getCzkssj() {
    return czkssj;
  }

  public void setCzkssj(String czkssj) {
    this.czkssj = czkssj;
  }

  public String getCzjssj() {
    return czjssj;
  }

  public void setCzjssj(String czjssj) {
    this.czjssj = czjssj;
  }

  public String getRzlx() {
    return rzlx;
  }

  public void setRzlx(String rzlx) {
    this.rzlx = rzlx;
  }

  public String getRznr() {
    return rznr;
  }

  public void setRznr(String rznr) {
    this.rznr = rznr;
  }
  public Long getZxsj() {
    return zxsj;
  }
  public void setZxsj(Long zxsj) {
    this.zxsj = zxsj;
  }

}
