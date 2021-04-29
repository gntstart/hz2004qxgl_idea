package com.gnt.qxgl.service;

import com.gnt.qxgl.common.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <功能概述>
 *  安徽长三角户口跨省网上迁移情况接口类
 * @author: zjm
 * @className: CsjHkKsWsQyService
 * @package: com.gnt.qxgl.service
 * @description: 介绍
 * @date: 20210308
 */
public interface CsjHkKsWsQyService {

    Page queryCsjhkkswsxx(Map<String, Object> map, int pageIndex, int pageSize);

    void ExportqueryCsjhkkswsxx(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response);
}
