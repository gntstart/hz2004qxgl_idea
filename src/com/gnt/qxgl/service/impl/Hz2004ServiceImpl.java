package com.gnt.qxgl.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.common.*;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_HJSPSQB;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_ZQZXXB;
import com.gnt.qxgl.hz2004.entity.SJ_HJYW_QCZXXXB;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXkzApi;
import com.gnt.qxgl.hz2004.entity.zjyw.*;
import com.gnt.qxgl.service.Hz2004Service;
import com.hzjc.hz2004.YWUtils;
import com.hzjc.hz2004.constant.HjConstant;
import com.hzjc.hz2004.po.PoHJSP_HJSPSQB;
import com.hzjc.hz2004.po.PoHJXX_RYZPXXB;
import com.hzjc.hz2004.po.PoXT_JWHXXB;
import com.hzjc.hz2004.vo.VoQrspdjxx;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hz2004ServiceImpl extends ServiceImpl implements Hz2004Service {
    @Override
    public List queryByHQL(String hql) {
        return super.getObjectListByHql(hql);
    }


    @Override
    public void saveLog2(LgApiLog log) {
        super.create(log);
    }

    @Override
    public ApiYs getApiYsByPostid(String lgbm, String type, String postid) {
        return (ApiYs) super.getObject(" from ApiYs a where a.postid=? and a.nwbbz=? and a.lg=?", new Object[]{postid, type, lgbm});
    }

    @Override
    public YwtbXkzApi getXkzApi(String pcsbm, String sbh) {
        return (YwtbXkzApi) super.getObject("from YwtbXkzApi where lgbm='" + pcsbm + "' ", null);//;get(XkzApi.class, pcsbm);//.getObjectListByHql(hsql, values);
    }


    @Override
    public XtDwxxb queryXtDwxxb(String mc, String fjjgdm) {
        List<XtDwxxb> XtDwxxbList = (List<XtDwxxb>) super.getObjectListByHql(" from XtDwxxb a where a.mc like'%" + mc + "%' and a.qhdm = '" + fjjgdm + "'", null);
        return XtDwxxbList.get(0);
    }

    @Override
    public XtDwxxb queryXtDwxxbDm(String mc, String fjjgdm) {
        List<XtDwxxb> XtDwxxbList = (List<XtDwxxb>) super.getObjectListByHql(" from XtDwxxb a where a.dm like'%" + mc + "%' and a.qhdm = '" + fjjgdm + "'", null);
        return XtDwxxbList.get(0);
    }

    @Override
    public SJ_HJSP_HJSPSQB querySJ_HJSP_HJSPSQB(String spywid) {
        return (SJ_HJSP_HJSPSQB) super.getObject("from SJ_HJSP_HJSPSQB where spywid='" + spywid + "' ", null);//;get(XkzApi.class, pcsbm);//.getObjectListByHql(hsql, values);
    }

    @Override
    public void saveZjywZqzqyzresult(ZjywZqzqyzresult zjywZqzqyzresult) {
        super.create(zjywZqzqyzresult);
    }

    @Override
    public Page queryDzyxSjHjspZqzxx(Map<String, Object> map, int pageIndex, int pageSize) {
        String dqbm = (String)map.get("dqbm");

        SqlParse sqlParse = new SqlParse(Config.getSql("/conf/segment/dq/default", "queryDzyxSjHjspZqzxx"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
//        Transaction tran = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
//            tran = session.beginTransaction();
            List list  = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
            Page page = HibernateUtil.getPageRecords(session, sqlParam.getSql(), sqlParam.getParams(), pageIndex,
                    pageSize);
            return page;
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void insertDzyxQr(Map<String, Object> map, int pageIndex, int pageSize, BaseUser user) {
//        super.getObject()；
        //this.requestXLH("", year, "qyz");
        //spywid  ywlsh  zqid  qyrs（写死1）  zqzjlx（写死1）   dsgxsj
//        String zqzQyzbh = "";
//        KdqqyService kdqqyService = (KdqqyService) SpringContainer.getObject("kdqqyService");
//        XT_ZQZ_QYZ_XLH xlhzqz =  kdqqyService.requestXLH("", "34", "zqz");
//
//        String zqzbhSer = xlhzqz.getZjbh().toString();
//        if (zqzbhSer.length() < 17)
//            zqzbhSer = "00000000000000000".substring(0, 17 - zqzbhSer.length()) + zqzbhSer;
//        zqzbhSer = "34"+zqzbhSer+"";
//        System.out.println("迁移证编号为：" + zqzbhSer);
//
//        XT_ZQZ_QYZ_XLH xlhqyz = kdqqyService.requestXLH("", "6", "qyz");
//        String qyzbhSer = xlhqyz.getZjbh().toString();
//        if (qyzbhSer.length() < 7)
//            qyzbhSer = "0000000".substring(0, 7 - qyzbhSer.length()) + qyzbhSer;
//        zqzQyzbh = "皖" +"6"+qyzbhSer+"";
//        System.out.println("大专院校准迁证迁移证编号为：" + zqzQyzbh);
//
//        String s3 = (String)map.get("addDzyxQrInfo");
//
//        SJ_HJSP_ZQZXXB  sj_hjsp_zqzxxb = new SJ_HJSP_ZQZXXB();
//        sj_hjsp_zqzxxb =JSONObject.parseObject(s3, SJ_HJSP_ZQZXXB.class);
//        sj_hjsp_zqzxxb.setZqid(zqzbhSer);
//        sj_hjsp_zqzxxb.setYwlsh(zqzbhSer);
//        sj_hjsp_zqzxxb.setSpywid(zqzbhSer);
//        sj_hjsp_zqzxxb.setQyrs("1");
//        sj_hjsp_zqzxxb.setZqzjlx("1");
//        sj_hjsp_zqzxxb.setDsgxsj(DateHelper.formateDate("yyyyMMddHHmmss"));
//        sj_hjsp_zqzxxb.setQyzbh(zqzQyzbh);
//        sj_hjsp_zqzxxb.setZjbh(zqzQyzbh);
//        super.create(sj_hjsp_zqzxxb);
        Session session = null;
        Transaction tran = null;
        String qcdqbm = (String)map.get("qcdqbm");
        session = HibernateUtil.getSystemSessionFactory(qcdqbm).openSession();

        if (session == null)
            throw new ServiceException("数据库不支持此地区！");

        tran = session.beginTransaction();
        Long spywid = (Long) YWUtils.getId(session, "SID_HJSP_HJSPSQB");
        String now = YWUtils.getServiceTime(session);
        String s3 = (String)map.get("addDzyxQrInfo");
        ExtMap<String,Object> extMap = user.getOtherParams();
        VoQrspdjxx voQrspdjxx = JSONObject.parseObject(s3, VoQrspdjxx.class);
        //保存主迁人员信息
        PoHJSP_HJSPSQB poHjspsqxx = new PoHJSP_HJSPSQB();
        BeanUtils.copyProperties(poHjspsqxx, voQrspdjxx);
        poHjspsqxx.setSpywid(spywid);
        poHjspsqxx.setLsbz(HjConstant.LSBZ_WLS);
        poHjspsqxx.setDjrid(extMap.getLong("yhid"));
        poHjspsqxx.setDjsj(now);
        poHjspsqxx.setSpjg(HjConstant.SPJG_TY ); //操作员自审批
        //受理日期
        poHjspsqxx.setSlrq(now.substring(0,8));
        PoXT_JWHXXB poXT_JWHXXB  = HibernateUtil.get(session, PoXT_JWHXXB.class,
                poHjspsqxx.getQrdjwh());//通过居委会代码得到乡镇街道代码
        poHjspsqxx.setCxfldm(poXT_JWHXXB.getCxfldm());
        if(poHjspsqxx.getKdqqy_qcdqbm()!=null && !"".equals(poHjspsqxx.getKdqqy_qcdqbm())){
            //跨地区迁入
            //AuthToken auth = BaseContext.getUser();
            //if (auth != null) {
                //poHjspsqxx.setKdqqy_czydw(this.getUserInfo().getDwdm());
                //poHjspsqxx.setKdqqy_czyxm(this.getUserInfo().getYhxm());
                poHjspsqxx.setKdqqy_fkzt("0");
            //}
        }else{
            //外省迁入
            poHjspsqxx.setKdqqy_czydw(null);
            poHjspsqxx.setKdqqy_czyxm(null);
            poHjspsqxx.setKdqqy_fknr(null);
            poHjspsqxx.setKdqqy_fkzt(null);
            poHjspsqxx.setKdqqy_qcdqbm(null);
            poHjspsqxx.setKdqqy_qyzbh(null);
        }
    }

    @Override
    public void deleteZqzXx(String status, String zqid) {
        SJ_HJSP_ZQZXXB sj_hjsp_zqzxxb =super.get(SJ_HJSP_ZQZXXB.class,zqid);
        if (sj_hjsp_zqzxxb==null){
            throw new ServiceException("不存在满足改条件zqid："+zqid+"数据！");
        }else {
              sj_hjsp_zqzxxb.setIsstatus(status);
              super.update(sj_hjsp_zqzxxb);
        }
    }

    @Override
    public void modifyDzyxQr(Map<String, Object> map) {
        String s3 = (String)map.get("modifyDzyxQr");
        SJ_HJSP_ZQZXXB  sj_hjsp_zqzxxbOld = new SJ_HJSP_ZQZXXB();
        sj_hjsp_zqzxxbOld =JSONObject.parseObject(s3, SJ_HJSP_ZQZXXB.class);
        if (sj_hjsp_zqzxxbOld.getZqid()==null){
             throw new ServiceException("数据可能被修改，不存在!");
        }
        SJ_HJSP_ZQZXXB  sj_hjsp_zqzxxbNew = super.get(SJ_HJSP_ZQZXXB.class,sj_hjsp_zqzxxbOld.getZqid());;
        if (sj_hjsp_zqzxxbNew==null){
            throw new ServiceException("不存在满足改条件的数据！");
        }
        sj_hjsp_zqzxxbOld =JSONObject.parseObject(s3, SJ_HJSP_ZQZXXB.class);
        BeanUtils.copyProperties(sj_hjsp_zqzxxbOld,sj_hjsp_zqzxxbNew);
        super.update(sj_hjsp_zqzxxbNew);
    }

    /**
     * 获取业务流水号编码
     */
    @Override
    public String updateLkbm(String lgbm) {
        String rq = DateHelper.formateDate("yyyyMMdd");
        String lgbm2 = lgbm;
        Lkbmgr gr = (Lkbmgr) super.getObject("from Lkbmgr t where t.lgbm='" + lgbm + "' and rq='" + rq + "'", null);//.getObjectListByHql("from Lkbmgr t where t.lgbm='"+lgbm+"' and rq='"+rq+"'");//.get("com.gnt.rest.entity.Lkbmgr",lgbm2, org.hibernate.LockMode.UPGRADE_NOWAIT);
        if (gr == null) {
            gr = new Lkbmgr();
            gr.setLgbm(lgbm2);
            gr.setRq(rq);
            gr.setXh(new Long(1));
            super.create(gr);
        } else {
            if (!rq.equals(gr.getRq())) {
                gr.setRq(rq);
                gr.setXh(new Long(0));
            }
            gr.setXh(gr.getXh() + 1);
            super.update(gr);
        }

        return (add0(gr.getXh().intValue(), 4).insert(0, lgbm2 + rq)).toString();

    }


    @Override
    public void saveZjywZqzxx(ZjywZqzxx zqzxx, String pcsbm) {
        super.create(zqzxx);
        // 记录POSTID和入住流水号的关系
        /*ApiYs ys = new ApiYs();
        ys.setCjsj(new Date());
        ys.setLg(pcsbm);
        ys.setNwbbz("1");
        ys.setPostid(zqzxx.getYwlsh());
        ys.setLkbm(zqzxx.getPostid());
        super.create(ys);*/
    }

    @Override
    public ZjywZqzxx queryZjywZqzxxByPostid(String postid) {
        ZjywZqzxx nb = null;
        nb = super.get(ZjywZqzxx.class, postid);
        return nb;
    }

    @Override
    public void updateZjywZqzxx(ZjywZqzxx zqzxx) {
        super.saveOrUpdate(zqzxx);
    }

    @Override
    public void updateSjHjspZqzxx(SJ_HJSP_ZQZXXB sjHjspZqzxxb) {
        super.saveOrUpdate(sjHjspZqzxxb);
    }


    @Override
    public void saveZjywZqzQyrxx(ZjywZqzQyrxx zqzQyrxx) {
        super.create(zqzQyrxx);
    }

    @Override
    public void saveZjywQyzxx(ZjywQyzxx qyzxx, String pcsbm) {
        super.create(qyzxx);
        // 记录POSTID和入住流水号的关系
       /* ApiYs ys = new ApiYs();
        ys.setCjsj(new Date());
        ys.setLg(pcsbm);
        ys.setNwbbz("1");
        ys.setPostid(qyzxx.getQyzbh());
        ys.setLkbm(qyzxx.getYwlsh());
        super.create(ys);*/
    }

    @Override
    public void updateZjywQyzxx(ZjywQyzxx qyzxx) {
        super.saveOrUpdate(qyzxx);
    }

    @Override
    public void saveZjywQyzQyrxx(ZjywQyzxxQyrxx zqzQyrxx) {
        super.saveOrUpdate(zqzQyrxx);
    }

    @Override
    public ZjywQyzxx queryZjywQyzxxByPostid(String qyzbh) {
        ZjywQyzxx nb = null;
        nb = super.get(ZjywQyzxx.class, qyzbh);
        return nb;
    }

    @Override
    public Page queryZqzXx(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("queryZqzXx"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        return pageRecords;
    }

    @Override
    public Page querySjHjspZqzxx(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("querySjHjspZqzxx"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        return pageRecords;
    }

    @Override
    public Page queryQyzXx(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("queryQyzXx"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        return pageRecords;
    }

    @Override
    public Page queryZqzQyrxx(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("queryZqzQyrxx"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        return pageRecords;
    }

    @Override
    public Page querySJ_HJSP_QYZXXB(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("SJ_HJSP_QYZXXB"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        return pageRecords;
    }

    @Override
    public List querySJ_HJSP_ZQZXXB(String isStatus, String dqbm, int pageIndex, int pageSize) {//2,,31
        String[] split = dqbm.split(",");
        String w1 = "";
        for (String s : split) {
            if (!w1.equals("")) {
                w1 += " or ";
            }
            w1 += " a.qyrzzssxq like '" + s + "%'";
            //字段用错了，应该是qyrzzssxq   kqt 
        }
        String zqzQzsj = SystemConfig.getSystemConfig("zqzQzsj");

        String zqzBsds = SystemConfig.getSystemConfig("zqzBsds");

        String[] splitZqzBsds = zqzBsds.split(",");
        String w2 = "";
        for (String s : splitZqzBsds) {
            if (!w2.equals("")) {
                w2 += " or ";
            }
            w2 += " a.qrdssxq like '" + s + "%'";
            //字段用错了，应该是qyrzzssxq   kqt
        }

        String qcrSQL = "from SJ_HJSP_ZQZXXB a "
                + " where a.isstatus = " + isStatus + "  and (" + w1 + ") and (" + w2 + ") and a.qyyy is not null and a.zjbh is not null and a.dsgxsj>=" + zqzQzsj;
        // 20210307 kqt 增加zjbh 不为空的逻辑
        List objectListByHql = super.getObjectListByHql(qcrSQL, pageIndex, pageSize);
        return objectListByHql;
    }

    @Override
    public SJ_HJSP_ZQZXXB querySJ_HJSP_ZQZXXB(String zqzbh) {
        String qcrSQL = "from SJ_HJSP_ZQZXXB a "
                + " where a.zjbh like '%" + zqzbh + "%' order by dsgxsj desc ";
        SJ_HJSP_ZQZXXB object = (SJ_HJSP_ZQZXXB) super.getObject(qcrSQL, null);
        return object;
    }

    @Override
    public SJ_HJYW_QCZXXXB queryQczxxxb(String gmsfhm, String qyzbh, String zqzbh) {
        String sql = "";
        if (StringUtils.isNotEmpty(gmsfhm)) {
            sql += "and gmsfhm = '" + gmsfhm + "'";
        }
        String qyzbh1 = "";
        if (StringUtils.isNotEmpty(qyzbh)) {
            sql += "and qyzbh like '%" + qyzbh + "%'";
        }
        String zqzbh1 = "";
        if (StringUtils.isNotEmpty(zqzbh)) {
            sql += "and zqzbh like '%" + zqzbh + "%'";
        }
        String qcrSQL = "from SJ_HJYW_QCZXXXB "
                + " where 1=1  " + sql + " and cxbz = '0'  and rownum=1";

        SJ_HJYW_QCZXXXB object = (SJ_HJYW_QCZXXXB) super.getObject(qcrSQL, null);
        return object;
    }

    @Override
    public void updateSJ_HJSP_ZQZXXB(SJ_HJSP_ZQZXXB sj_hjsp_zqzxxb) {
        super.saveOrUpdate(sj_hjsp_zqzxxb);
    }

    @Override
    public Boolean postUpdateZp(String name, String gmsfhm, String dqbm) {
        //必须
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xm", name);
        map.put("gmsfhm", gmsfhm);

        SqlParse sqlParse = new SqlParse(Config.getSql("postUpdateZp"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
        List objectList = null;
        Transaction tran = null;
        boolean sfcg = false;
        try {
            session = HibernateUtil.getSystemSessionFactory(dqbm.substring(0, 4)).openSession();
            tran = session.beginTransaction();
            objectList = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
            Object o = objectList.get(0);
            if (null != o) {
                PoHJXX_RYZPXXB poHJXX_ryzpxxb = (PoHJXX_RYZPXXB) o;

                PoHJXX_RYZPXXB u = HibernateUtil.get(session, PoHJXX_RYZPXXB.class, poHJXX_ryzpxxb.getZpid());

                Calendar cal = Calendar.getInstance();
                int y = cal.get(Calendar.YEAR);
                int m = cal.get((Calendar.MONTH) + 1);
                int d = cal.get(Calendar.DAY_OF_MONTH);
                int h = cal.get(Calendar.HOUR_OF_DAY);
                int mi = cal.get(Calendar.MINUTE);
                int s = cal.get(Calendar.SECOND);
                String lrrq = y + "" + m + "" + d + "" + h + "" + mi + "" + s;
                u.setLrrq(lrrq);
                HibernateUtil.update(session, u);
                sfcg = true;
                tran.commit();
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return sfcg;
    }

    @Override
    public PoHJXX_RYZPXXB queryZp(Map<String, Object> map) {
        //必须
        SqlParse sqlParse = new SqlParse(Config.getSql("queryZp"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
        List objectList = null;
        PoHJXX_RYZPXXB poHJXX_ryzpxxb = null;
        try {
            String dqbm = (String) map.get("dqbm");
            session = HibernateUtil.getSystemSessionFactory(dqbm.substring(0, 4)).openSession();
            objectList = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
            if (objectList.size() > 0) {
                Object o = objectList.get(0);
                if (null != o) {
                    poHJXX_ryzpxxb = (PoHJXX_RYZPXXB) o;
                }
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return poHJXX_ryzpxxb;
    }


    private StringBuffer add0(int n, int size) {
        StringBuffer sb = new StringBuffer();
        sb.append(n);
        int m = size - sb.length();
        for (int i = 0; i < m; i++) {
            sb.insert(0, '0');
        }
        return sb;
    }


}
