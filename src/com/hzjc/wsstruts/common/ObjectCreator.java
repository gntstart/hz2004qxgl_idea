package com.hzjc.wsstruts.common;

import java.lang.reflect.*;

/**
 * ����������
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڶ���֤Hz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: HZJC</p>
 * @author Kansan Ku(kgb_hz@126.com)
 * @version 1.0
 */

public class ObjectCreator {

  /**
   *
   */
  private ObjectCreator() {
  }

  /**
   * ����Java��������������ö���
   * @param strClassName �����������
   * @return ���ظö���
   * @throws Exception
   */
  public static Object createObject(String strClassName) throws Exception {
    return createObject(Class.forName(strClassName));
  }

  /**
   * ����Java������ഴ���ö���
   * @param clazzObject Ҫ�������Class
   * @return ���ش����Ķ���
   * @throws Exception
   */
  public static Object createObject(Class clazzObject) throws Exception {
    return clazzObject.newInstance();
  }

  /**
   * ����Ҫ�����Ķ���������ƺ͹����Ӳ�����������
   * @param strClassName ������
   * @param params �����Ӳ�������
   * @return ���ش����Ķ���
   * @throws Exception
   */
  public static Object createObject(String strClassName, Object[] params) throws
      Exception {
    return createObject(Class.forName(strClassName), params);
  }

  /**
   * ����Ҫ���������class�͹����Ӳ���������
   * @param clazzObject ���Ӧ��Class
   * @param params �����Ӳ���
   * @return ���ش����Ķ���
   * @throws Exception
   */
  public static Object createObject(Class clazzObject, Object[] params) throws
      Exception {
    Constructor[] constructors = clazzObject.getConstructors();
    Object object = null;
    /**
     * ѭ���������й��췽�������ݲ��������������û�и��쳣ѭ��������һ�����췽��
     */
    for (int counter = 0; counter < constructors.length; counter++) {
      try {
        object = constructors[counter].newInstance(params);
      }
      catch (Exception ex) {
        if (ex instanceof InvocationTargetException) {
          ( (InvocationTargetException) ex).getTargetException().
              printStackTrace();
          //�������������һ��������
        }
      }
    }
    //���׳��쳣
    if (object == null) {
      throw new InstantiationException();
    }
    return object;
  }

}
