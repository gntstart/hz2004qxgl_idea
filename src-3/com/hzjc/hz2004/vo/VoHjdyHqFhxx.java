package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoHJXX_DYXXB;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * ������ӡ������ϢVo
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT Corp. 2004</p>
 * <p>Company: </p>
 * @author hb
 * @version 1.0
 */

public class VoHjdyHqFhxx
    extends PoHJXX_DYXXB {

  public VoHjdyHqFhxx() {
  }

  public VoHjdyHqFhxx(Object poView) {
    try {
      BeanUtils.copyProperties(this, poView);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }
  }


}
