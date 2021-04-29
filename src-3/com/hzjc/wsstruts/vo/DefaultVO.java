package com.hzjc.wsstruts.vo;

import java.io.*;
import java.sql.*;
import org.apache.commons.beanutils.*;
import org.apache.commons.logging.*;

import com.gnt.qxgl.base.encoders.Base64;
import com.hzjc.wsstruts.common.db.DbUtils;
import com.hzjc.wsstruts.po.PO;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.*;
import java.util.Map;

/**
 *
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author Kansan Ku(kgb_hz@126.com)
 * @version 1.0
 */
public class DefaultVO implements VO,java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	protected static Log _log = LogFactory.getLog(DefaultVO.class);

  /**
   *
   */
  public DefaultVO() {

  }

  /**
   * У�����ݵ���Ч��
   * @return
   */
  public boolean validateDTD() {
    return true;
  }

  public DefaultVO(PO entity) {
    try {
      BeanUtils.copyProperties(this, entity);
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  /**
   * װ��ת������VO-->PO(����������ظ÷���)
   * ע��:����Bean����Blob,Clob�������ǳ������͵�����,����������⴦��
   *     BeanUtils.copyProperties(this, entity)�����׳��쳣,��ʱӦ
   *     ��������,��ÿ�����Խ����ֹ�����.
   * @param entity
   * @return
   */
  public PO toEntity(PO entity) {
    try {
      BeanUtils.copyProperties(entity, this);
      return entity;
    }
    catch (Exception ex) {
      throw new RuntimeException("ת��ֵVO-->ʵ��PO��������", ex);
    }
  }

  /**
   * ��Blob�ֶε�Byte�ֽ���ת��ΪBASE64����.
   * @param aBlob
   * @return
   */
  public String encodeBlob(Blob aBlob) {
    byte[] byteBlob = DbUtils.parseBlobToBytes(aBlob);
    //String strEnCodeBloab = new String(Base64.encodeBase64Chunked(byteBlob));
    //���Base64�л��еĻ������ظ�Delphi�ͻ��˿����д���
    //������ClientDataSet.xmldata����û�д���ã���Base64�Ľ���û�жԻ��н��д�����
    String strEnCodeBloab = new String(Base64.encode(byteBlob));
    //_log.info("ת��BlobΪBase64=" + strEnCodeBloab);
    return strEnCodeBloab;
  }

  /**
    public String decodeStr(String strBase64Blob) {
      String strDecode = null;
      if (strBase64Blob == null) {
        return strDecode;
      }
      strDecode = new String(decodeBytes(strBase64Blob.getBytes()));
      return strDecode;
    }
   **/

  /**
   *
   * @param aBytes
   * @return
   */
  public byte[] decodeBytes(byte[] aBytes) {
    byte[] byteDecode = null;
    if (aBytes == null) {
      return byteDecode;
    }
    byteDecode = Base64.decode(aBytes);
    return byteDecode;
  }

  /**
   *
   * @param aBytes
   * @return
   */
  public byte[] encodeBytes(byte[] aBytes) {
    byte[] byteEncode = null;
    if (aBytes == null) {
      return byteEncode;
    }
    byteEncode = Base64.encode(aBytes);
    return byteEncode;
  }


  /**
   * �����������ƣ��õ���ǰVO�����Ե�ֵ
   * @param strPropertyName:��ֵ���������
   * @return�����ظ����Ե�ֵ
   * @throws VOException
   */
  public String queryProperty(String strPropertyName){
    String strPropValue = null;
    if (strPropertyName == null) {
      return strPropValue;
    }
    try {
      strPropValue = BeanUtils.getProperty(this, strPropertyName);
    }
    catch (Exception ex) {
      throw new java.lang.RuntimeException("�õ�VOֵ�����" + strPropertyName + "���Է����쳣��", ex);
    }
    return strPropValue;
  }

  /**
   * �õ���ǰVO����������ɢ��
   * @return�����ظ�ֵ���������ɢ��
   * @throws VOException
   */
  public java.util.Map queryProperties(){
    Map mapPropValue = null;
    try {
      mapPropValue = BeanUtils.describe(this);
    }
    catch (Exception ex) {
      throw new RuntimeException("�õ�VOֵ��������Լ�-ֵӳ��Map�����쳣��", ex);
    }
    return mapPropValue;
  }

  /**
   *
   * @param strFldName
   * @return
   * @throws VOException
   */
  public boolean hasProperty(String strFldName){
    boolean bHas = false;
    Map mapFlds = queryProperties();
    bHas = mapFlds.containsKey(strFldName);
    return bHas;
  }

  public static void main(String[] args) {
    String strEncode = new String(Base64.encode("123".getBytes()));
    _log.info(strEncode);
    String strDecode = new String(Base64.decode(strEncode.getBytes()));
    _log.info(strDecode);
  }

}
