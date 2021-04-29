package com.hzjc.wsstruts.common.codec;

import java.io.*;

/**
 * Codec接口的抽象实现，缺省的实现接口
 * 运用了缺省适配模式Default Adapter和模版方法Template
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author kansan ku
 * @version 1.0
 */
abstract public class AbstractCodec
    implements Codec {

  /**
   *
   * Does the actual encoding process.
   * @param chars The String to encode to Base64
   * @return The Base64 encoded string.
   */
  public String encode(String chars) {
    return new String(encode(chars.toCharArray()));
  }

  /**
   *
   * @param chars
   * @return
   */
  public abstract char[] encode(char[] chars);

  /**
   *
   * Decode the String from base64
   * @param chars  Description of Parameter
   * @return Decoded string
   */
  public String decode(String chars) {
    return new String(decode(chars.toCharArray()));
  }

  /**
   *
   * @param chars
   * @return
   */
  public abstract char[] decode(char[] chars);

  /**
   *
   * @param aBytes
   * @return
   */
  public byte[] encode(byte[] aBytes) {
    return encode(new String(aBytes)).getBytes();
  }

  /**
   *
   * @param aBytes
   * @return
   */
  public byte[] decode(byte[] aBytes) {
    return decode(new String(aBytes)).getBytes();
    /*
           try {
      return decode(new String(aBytes)).getBytes("ISO8859_1");
           }
           catch (UnsupportedEncodingException ex) {
      return null;
           }
     */
  }

}
