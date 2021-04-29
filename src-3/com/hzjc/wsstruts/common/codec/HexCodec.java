package com.hzjc.wsstruts.common.codec;

import java.util.Arrays;

/**
 * This class provides a method of encoding a string to its Hexadecimal value
 * and decoding a Hex String to ASCII characters.
 * 二进制或字符串转换成16进制编码算法
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author kansan ku
 * @version 1.0
 */
public class HexCodec
    extends AbstractCodec {
  /** Singleton instance */
  private static HexCodec codec = null;

  /** The 'numerals' that make up Hex */
  private static final char[] DIGITS = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
      'e', 'f'
  };

  /**
   * Singleton so we override the default constructor.
   */
  private HexCodec() {
  }

  /**
   * Returns an instance of the specific codec to be used. This is so they
   * can be singletons and reused.
   *
   * @return The Codec object to use.
   */
  public static HexCodec getInstance() {
    if (codec == null) {
      codec = new HexCodec();
    }
    return codec;
  }

  /**
   * Encode a binary Character-array into an ASCII hex-string
   *
   * @param inChars The character array of the string to encode
   * @return The Hex-string
   */
  public final char[] encode(char[] inChars) {

    char[] chars = new char[inChars.length * 2];
    for (int i = 0; i < inChars.length; i++) {

      char b = inChars[i];
      chars[i * 2] = DIGITS[ (b & 0xF0) >> 4];
      chars[ (i * 2) + 1] = DIGITS[b & 0x0F];
    }
    return chars;
  }

  /**
   * Decode an ASCII hex-string back into a binary byte-array
   *
   * @param inChars The Hex-string
   * @return The plain text representation of the hex string
   */
  public final char[] decode(char[] inChars) {

    int numTuples = inChars.length / 2;
    char[] chars = new char[numTuples];

    // We can do a binary search because DIGITS is sorted
    // which should be a bit faster than a regular indexOf search
    for (int i = 0; i < numTuples; i++) {
      chars[i] = (char) (Arrays.binarySearch(DIGITS, inChars[i * 2]) << 4);
      chars[i] |= Arrays.binarySearch(DIGITS, inChars[ (i * 2) + 1]);
    }
    return chars;
  }

}
