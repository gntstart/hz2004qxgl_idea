package com.gnt.qxgl.service;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.QG_RKPC;

import java.util.Map;

/**
 * <功能概述>
 *  全国人口普查功能接口类
 * @author: 杨冬冬
 * @className: QgRkpc
 * @package: com.gnt.qxgl.service
 * @description: 介绍
 * @date: 2020-06-28 13:11
 */
public interface QgRkpcService {

    Page queryQgRkpcxx(Map<String, Object> map, int pageIndex, int pageSize);

    QG_RKPC saveQgRkpcxx(Map<String, Object> map);
}
