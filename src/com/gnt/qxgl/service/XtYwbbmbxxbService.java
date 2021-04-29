package com.gnt.qxgl.service;

import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.QG_RKPC;

import java.util.Map;

/**
 * <功能概述>
 *  业务报表 功能接口类
 * @author: 杨冬冬
 * @className: QgRkpc
 * @package: com.gnt.qxgl.service
 * @description: 介绍
 * @date: 2020-06-28 13:11
 */
public interface XtYwbbmbxxbService {
    Page queryXtYwbbmbxxb(Map<String, Object> map, int pageIndex, int pageSize);
}
