package com.hzjc.wsstruts.common.codec;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * This class provides a URL Encoding functionality. It is useful for encoding
 * parameters before they are passed into URLs and the like.
 * URL网页访问参数转换成标准格式编码算法，JDK有已经实现的算法，适配调用即可
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author kansan ku
 * @version 1.0
 */
public class URLCodec
    extends AbstractCodec {
  /** Singleton instance */
  private static URLCodec codec = null;

  /**
   * Singleton, so we override the default so no one can get it
   */
  private URLCodec() {
  }

  /**
   * Returns an instance of the specific codec to be used. This is so they
   * can be singletons and reused.
   *
   * @return The Codec object to use.
   */
  public static URLCodec getInstance() {
    if (codec == null) {
      codec = new URLCodec();
    }
    return codec;
  }

  /**
   * This method is URL encodes the string passed in. It is a wrapper around
   * the JDK URLEncoder object.
   *
   * @param chars The plain text string that should be encode
   * @return The encoded version of the string passed in.
   */
  public final String encode(String chars) {
//        try {
//            // XXX Java 1.4 only
//            // return URLEncoder.encode(chars, "UTF-8");
//        } catch (UnsupportedEncodingException ex) {
//            return chars;
//        }
    //return URLEncoder.encode(chars);
    return null;
  }

  /**
   * This method is URL encodes the character array passed in. It is a
   * wrapper around the JDK URLEncoder object.
   *
   * @param chars The plain text string that should be encode
   * @return The encoded version of the string passed in.
   */
  public final char[] encode(char[] chars) {
//        try {
//            // XXX Java 1.4 only
//            // return URLEncoder.encode(new String(chars), "UTF-8").toCharArray();
//        } catch (UnsupportedEncodingException ex) {
//            return chars;
//        }
    //return URLEncoder.encode(new String(chars)).toCharArray();
    return null;
  }

  /**
   * This method is URL decodes the string passed in. It is a wrapper around
   * the JDK URLDecoder object.
   *
   * @param chars The plain text string that should be encode
   * @return The encoded version of the string passed in.
   */
  public final char[] decode(char[] chars) {
//        try {
//            // XXX Java 1.4 only
//            // return URLDecoder.decode(new String(chars), "UTF-8").toCharArray();
//        } catch (UnsupportedEncodingException ex) {
//            return chars;
//        }
    //return URLDecoder.decode(new String(chars)).toCharArray();
    return null;
  }

  /**
   * This method is URL decodes the string passed in. It is a wrapper around
   * the JDK URLDecoder object.
   *
   * @param chars The plain text string that should be encode
   * @return The encoded version of the string passed in.
   */
  public final String decode(String chars) {
//        try {
//            // XXX Java 1.4 only
//            // return URLDecoder.decode(chars, "UTF-8");
//        } catch (UnsupportedEncodingException ex) {
//            return chars;
//        }
    //return URLDecoder.decode(chars);
    return null;
  }

}
