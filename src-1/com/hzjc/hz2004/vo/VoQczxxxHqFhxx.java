package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoV_HJ_QCZXXXB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * Ǩ��ע����Ϣ��ȡ������ϢVO
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoQczxxxHqFhxx
    extends PoV_HJ_QCZXXXB {

  public VoQczxxxHqFhxx() {
  }

  public VoQczxxxHqFhxx(Object poView) {
    try {
      BeanUtils.copyProperties(this, poView);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }
  }

}