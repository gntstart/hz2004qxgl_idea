package com.hzjc.wsstruts.common;

import javax.servlet.http.*;
import org.apache.axis.*;
import org.apache.axis.transport.http.*;
import org.apache.commons.logging.*;

/**
 * Axis SOAP���湫����
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڹ���ϵͳHz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: �㽭����Ԫ�¼������޹�˾</p>
 * @author kgb_hz@126.com,kgb@primetech.com.cn
 * @version 1.0
 */

public class AxisUtils {
  //��־����
  private static Log _log = LogFactory.getLog(AxisUtils.class);

  private AxisUtils() {
  }

  /**
   * �õ�SOAPԶ�̵��õ�����Request
   * @return
   */
  public static HttpServletRequest getRequest() {
    MessageContext mc = MessageContext.getCurrentContext();
    HttpServletRequest request = (HttpServletRequest) mc.getProperty(
        HTTPConstants.MC_HTTP_SERVLETREQUEST);
    return request;
  }

  /**
   * �õ���ǰ�û���HttpSession
   * @return
   */
  public static HttpSession getHttpSession() {
    HttpSession session = null;
    HttpServletRequest request = getRequest();
    if (request != null) {
      session = request.getSession();
    }
    return session;
  }

  /**
   * �õ�Զ�̿ͻ���IP
   * @return
   */
  public static String getRemoteIP() {
    String strIp = null;
    HttpServletRequest request = getRequest();
    if (request != null) {
      strIp = getRequest().getRemoteAddr();
      _log.info("�����Զ��IP��ַ��" + strIp);
    }
    return strIp;
  }

}