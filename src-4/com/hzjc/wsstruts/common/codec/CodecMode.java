package com.hzjc.wsstruts.common.codec;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

/**
 * 编码算法类型类,提供安全枚举检查,防止用户输入非法的算法
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not kansan ku
 * @version 1.0
 */
final public class CodecMode
    implements Serializable {
  private final int level;
  private final String name;
  private final static Map INSTANCES = new HashMap();

  public final static CodecMode BASE64 = new CodecMode(0, "BASE64");
  public final static CodecMode HEX = new CodecMode(1, "HEX");
  public final static CodecMode URLHTTP = new CodecMode(2, "URLHTTP");

  /**
   * 静态类初始化
   */
  static {
    INSTANCES.put(new Integer(BASE64.level), BASE64);
    INSTANCES.put(new Integer(HEX.level), HEX);
    INSTANCES.put(new Integer(URLHTTP.level), URLHTTP);
  }

  /**
   *
   * @param level
   * @param name
   */
  private CodecMode(int level, String name) {
    this.level = level;
    this.name = name;
  }

  /**
   *
   * @return
   */
  public String toString() {
    return this.name;
  }

  /**
   *
   * @return
   */
  private Object readResolve() {
    return INSTANCES.get(new Integer(this.level));
  }

}
