package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * <p>Title: HZ2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��
 *                 ���ݷ�Χ����VO</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author huhua(hh_hz@126.com)
 * @version 1.0
 */


public class VoXtsjfw
extends DefaultVO {
  //���ݷ�Χ
  private String xqlx; //Ͻ������
  private String sjfwbz; //���ݷ�Χ��־���������ɳ�������ί�� 0,1,2,3,9
  private String sjfw; //���ݷ�Χ

  public VoXtsjfw() {
  }

  public void setXqlx(String xqlx){
    this.xqlx = xqlx;
  }
  public String getXqlx(){
    return this.xqlx;
  }
  public void setSjfwbz(String sjfwbz){
    this.sjfwbz = sjfwbz;
  }
  public String getSjfwbz(){
    return this.sjfwbz;
  }
  public void setSjfw(String sjfw){
    this.sjfw = sjfw;
  }
  public String getSjfw(){
    return this.sjfw;
  }


}