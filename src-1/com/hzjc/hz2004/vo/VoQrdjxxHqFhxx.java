package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoV_HJ_QRDJXXB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * Ǩ��Ǽ���Ϣ��ȡ������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQrdjxxHqFhxx
    extends PoV_HJ_QRDJXXB {

  public VoQrdjxxHqFhxx() {
  }

  public VoQrdjxxHqFhxx(Object poView) {
    try {
      BeanUtils.copyProperties(this, poView);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }
  }

}