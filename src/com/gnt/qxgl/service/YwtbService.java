package com.gnt.qxgl.service;

import com.gnt.qxgl.bean.SimpleJson;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbFjcl;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbLgApiLog;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXkzApi;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXx;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <功能概述>
 * 长三角“一网通办”户籍事项证明服务Service
 * @author: 杨冬冬
 * @className: YwtbService
 * @package: com.gnt.qxgl.service.YwtbService
 * @description: 介绍
 * @date: 2020-05-19 10:15
 */
public interface YwtbService {
    //查询授权商户
    YwtbXkzApi getXkzApi(String pcsbm, String sbh);
    //保存日志
    void saveLog2(YwtbLgApiLog log);

    YwtbXx getYwtbXx(String applyno);

    void saveYwtbXx(YwtbXx ywtbXx);

    void updateYwtbXx(Map<String, Object> map);

    void updateYwtbXx(YwtbXx ywtbXx);

    void saveYwtbFjcl(YwtbFjcl ywtbFjcl);

    Page queryYwtbXx(Map<String, Object> map, int pageIndex, int pageSize,BaseUser user);

    Page queryYwtbXxJob(Map<String, Object> map, int pageIndex, int pageSize);

    Page queryCzrkxx(Map<String, Object> map, int pageIndex, int pageSize);

    Page queryBggzxxb(Map<String, Object> map, int pageIndex, int pageSize);

    Page querySwzxZm(Map<String, Object> map, int pageIndex, int pageSize);

    Page queryQczxZm(Map<String, Object> map, int pageIndex, int pageSize);

    Page queryYwtbFjcl(Map<String, Object> map, int pageIndex, int pageSize);

    Page queryYwtbFjclGa(Map<String, Object> map, int pageIndex, int pageSize);

    void sendPostYwtb(Map<String, Object> map, BaseUser user);

    SimpleJson saveYwtbfj(Map parm, HttpServletRequest req);
	YwtbXx getYwtbXx2(String applyno, String isstatus);

}
