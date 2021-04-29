package com.gnt.qxgl.service.impl;

import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.service.XtYwbbmbxxbService;
import com.hzjc.hz2004.po.PoXT_YWBBMBXXB;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * <功能概述>
 * 业务报表 功能实现业务逻辑类
 *
 * @author: 杨冬冬
 * @className: QgRkpcServiceImpl
 * @package: com.gnt.qxgl.service.impl
 * @description: 介绍
 * @date: 2020-06-28 13:12
 */
public class XtYwbbmbxxbServiceImpl extends ServiceImpl implements XtYwbbmbxxbService {

    @Override
    public Page queryXtYwbbmbxxb(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("queryXtYwbbmbxxb"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        List<PoXT_YWBBMBXXB> list = pageRecords.getList();
        for (PoXT_YWBBMBXXB xt_ywbbmbxxb : list) {
            byte[] bbmb = xt_ywbbmbxxb.getBbmb();
            //对字节数组Base64编码
            String mbstr = null;
            try {
                mbstr = new String(bbmb,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            xt_ywbbmbxxb.setResBbmb(mbstr);
        }
        return pageRecords;
    }


}
