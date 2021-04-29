package com.gnt.qxgl.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.hz2004.entity.QG_RKPC;
import com.gnt.qxgl.service.QgRkpcService;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <功能概述>
 * 全国人口普查 功能实现业务逻辑类
 *
 * @author: 杨冬冬
 * @className: QgRkpcServiceImpl
 * @package: com.gnt.qxgl.service.impl
 * @description: 介绍
 * @date: 2020-06-28 13:12
 */
public class QgRkpcServiceImpl extends ServiceImpl implements QgRkpcService {

    public QG_RKPC getQgRkpc(String rkpcId) {
        return (QG_RKPC) super.getObject("from QG_RKPC where rkpcId='" + rkpcId + "' ", null);
    }

    @Override
    public Page queryQgRkpcxx(Map<String, Object> map, int pageIndex, int pageSize) {
        String gsdw = (String) map.get("gsdw");
        if (StringUtils.isEmpty(gsdw)) {
            BaseUser baseUser = BaseContext.getBaseUser();
            String ssdw = baseUser.getUser().getSsdwjgdm();
            
            String ssdwjgdm = ssdw.substring(0, 9);
            //判断是不是省厅用户查询
            if (!"340000000".equals(ssdwjgdm)) {
                map.put("gsdw", ssdwjgdm);
            }
        }else{
            String ssdwjgdm = gsdw.substring(0, 9);
            //判断是不是省厅用户查询
            if ("340000000".equals(ssdwjgdm)) {
                map.put("gsdw", ssdwjgdm);
            }
        }
        SqlParse sqlParse = new SqlParse(Config.getSql("queryQgRkpcxx"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        return pageRecords;
    }

    @Override
    public QG_RKPC saveQgRkpcxx(Map<String, Object> map) {
        QG_RKPC qg_rkpc = null;
        BaseUser baseUser = BaseContext.getBaseUser();
        String ssdw = baseUser.getUser().getSsdwjgdm();
        String ssdwjgdm = ssdw.substring(0, 9);
        qg_rkpc = JSONObject.parseObject(JSONObject.toJSONString(map), QG_RKPC.class);

        //查询全国总人口信息
        String rkpcZrs = getHjxxCzrkjbxxb(ssdw, "HJXX_CZRKJBXXB");
        //查询全国总户数信息
        String rkpcZhs = getHjxxCzrkjbxxb(ssdw, "PoHJXX_HXXB");
        qg_rkpc.setRkpcZrs(rkpcZrs);
        qg_rkpc.setRkpcZhs(rkpcZhs);

        if (!CommonUtil.isNotEmpty(qg_rkpc.getRkpcId())) {
            qg_rkpc.setGsdw(ssdwjgdm);
            qg_rkpc.setRkpcCreateDate(new Date());
            super.create(qg_rkpc);
        } else {
            qg_rkpc.setGsdw(ssdwjgdm);
            qg_rkpc.setRkpcUpdateDate(new Date());
            super.saveOrUpdate(qg_rkpc);
        }
        return qg_rkpc;
    }

    public String getHjxxCzrkjbxxb(String ssdw, String table) {
        SqlParse sqlParse = new SqlParse("select count(*) from " + table + " t");
        SqlParam sqlParam = sqlParse.parse();
        Session session = null;
        List objectList = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(ssdw.substring(0, 4)).openSession();
            objectList = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return String.valueOf(objectList.get(0));
    }
}
