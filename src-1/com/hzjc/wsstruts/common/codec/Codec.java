package com.hzjc.wsstruts.common.codec;

/**
 * This class provides an interface for building encoding methods.
     * Following the interface allows for the easy building of 'plugin' type methods.
 * �����ӿڣ���ͬ�����㷨ʵ�ָýӿ�
 * �����˲������ģʽStrategy����װ��ͬ���㷨���ⲿ�������
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author kansan ku <a href="mailto:kgb_hz@126.com"><kgb_hz@126.com></a>
 * @version 1.0
 */
public interface Codec {

  /**
   *
   * @param aBytes
   * @return
   */
  byte[] encode(byte[] aBytes);

  /**
   * This method encodes the string passed in and returns
   * the encoded string.
   * @param chars The plain text string that should be encode
   * @return The encoded version of the string passed in.
   */
  String encode(String chars);

  /**
   * This method encodes the character array passed in and
   * returns an encoded character array.
   * @param chars The plain text character array that should be encode
   * @return The encoded version of the character array passed in.
   */
  char[] encode(char[] chars);

  /**
   * This method decodes the character array passed in and returns
   * a decoded version of the character array.
   * @param chars The plain text character array that should be encode
   * @return The encoded version of the character array passed in.
   */
  String decode(String chars);

  /**
   *
   * @param aBytes
   * @return
   */
  byte[] decode(byte[] aBytes);

  /**
   * This method decodes the string passed in and returns
   * a decoded version of the string.
   * @param chars The plain text string that should be encode
   * @return The encoded version of the string passed in.
   */
  char[] decode(char[] chars);
}
