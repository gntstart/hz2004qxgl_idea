package com.hzjc.hz2004.vo;

import com.hzjc.hz2004.po.PoV_HJ_HBBGXXB;
import com.hzjc.wsstruts.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.*;

/**
 * ��������Ϣ��ȡ������Ϣ
 * <p>Title: hz2004</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) GNT 2004</p>
 * <p>Company: </p>
 * @author bini_min@hotmail.com
 * @version 1.0
 */
public class VoHbbgxxHqFhxx
    extends PoV_HJ_HBBGXXB {

  public VoHbbgxxHqFhxx() {
  }

  public VoHbbgxxHqFhxx(Object poView) {
    try {
      BeanUtils.copyProperties(this, poView);
    }
    catch (InvocationTargetException ex) {
    }
    catch (IllegalAccessException ex) {
    }
  }

}