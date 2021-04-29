package com.hzjc.wsstruts.common.codec;

import java.util.Map;

/**
 * This class provides an interface for building encryption methods.
 * The interface facillitates building a 'plugin' type architecture.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author kansan ku
 * @version 1.0
 */
public interface Crypt
    extends Codec {

  /**
   * Initialize the cryptographic functions.
   * @param key The key to use with this object.
   * @param map Any other parameters that are needed
   * to initialize everything.
   */
  public void init(String key, Map map);

  /**
   * This method encodes the string passed in and returns
   * the encrypted string.
   * @param chars The plain text string that should be encode
   * @return The encrypted version of the string passed in.
   */
  // public String encode(String chars);

  /**
   * This method encodes the character array passed in and
   * returns an encrypted character array.
   * @param chars The plain text character array that should be encode
   * @return The encrypted version of the character array passed in.
   */
  //public char[] encode(char[] chars);

  /**
   * This method decodes the character array passed in and returns
   * a decrypted version of the character array.
   * @param chars The plain text character array that should be encode
   * @return The encrypted version of the character array passed in.
   */
  //public char[] decode(char[] chars);

  /**
   * This method decodes the string passed in and returns
   * a decrypted version of the string.
   * @param chars The plain text string that should be encode
   * @return The encrypted version of the string passed in.
   */
  //public String decode(String chars);
}
