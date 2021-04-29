package com.gnt.qxgl.service.yw.impl;

import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.hz2004.entity.*;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxxQyrxx;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzQyrxx;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzxx;
import com.gnt.qxgl.service.yw.KdqqyService;
import com.hzjc.hz2004.SpywUtils;
import com.hzjc.hz2004.YWUtils;
import com.hzjc.hz2004.constant.HjConstant;
import com.hzjc.hz2004.constant.PublicConstant;
import com.hzjc.hz2004.po.*;
import com.hzjc.hz2004.vo.*;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class KdqqyServiceImpl extends ServiceImpl implements KdqqyService {
    //查询跨地区迁移户籍审批业务
    public Page queryKDQHjspyw(BaseUser user, ExtMap<String, Object> params) {
        String dqbm = user.getYwdq();
        String hsql = "from PoHJSP_HJSPSQB a "
                + " where a.kdqqy_fkzt='0' and a.spjg='1' and a.kdqqy_qcdqbm is not null ";
//				if(user.getOtherParams() != null){
        hsql += " and a.djrid=" + user.getOtherParams().getString("yhid") + " ";
//				}
        hsql += " order by a.slrq asc";

        System.out.println("查询【" + dqbm + "】的跨地区迁移列表数据：" + hsql);

        Session session = null;
        int pageIndex = params.getInteger(ExtUtils.pageIndex);
        int pageSize = params.getInteger(ExtUtils.pageSize);
        try {
            session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
            Page page = HibernateUtil.getPageRecords(session, hsql, new ArrayList(), pageIndex, pageSize);
            return page;
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    /**
     * 迁出注销信息查询
     *
     * @param user
     * @param params
     * @return
     */
    public Page queryKdsQczxxx(BaseUser user, ExtMap<String, Object> params) {
        if (CommonUtil.isEmpty(user.getYwdq())) {
//			throw new ServiceException("未知用户地区！");
        }

        String qcdq = params.getString("qcdq");
//		String qcdq = "3407";
//		params.put("qwdq", user.getYwdq());
        params.put("qwdq", "3401");
        params.put("kdqqy_cgbz", "0");

        SqlParse sqlParse = new SqlParse(Config.getSql("/conf/segment/dq/default", "queryKdsQczxxx"));
        sqlParse.bind(params);
        SqlParam sqlParam = sqlParse.parse();
        Session session = null;
        Session session2 = null;

        try {
            session = HibernateUtil.getSystemSessionFactory(qcdq).openSession();

            List<?> list = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
            Page p = new Page();
            p.setList(list);

            if (params.containsKey("hjywid")) {
                //进行业务，先判断迁出地是否已经完成
                session2 = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
                String hql = "from PoHJSP_HJSPSQB a where a.kdqqy_qchjywid=? and a.kdqqy_qcdqbm=?";
                PoHJSP_HJSPSQB sp = (PoHJSP_HJSPSQB) HibernateUtil.getObject(session2, hql, new Object[]{params.getString("hjywid"), qcdq});
                if (sp != null) {
                    saveQcSuccess(params.getString("hjywid"), qcdq);
                    throw new ServiceException("此跨地区迁入业务已完成，请重新查询！");
                }
            }

            return p;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Page queryYdqrdjRyxx(BaseUser user, ExtMap<String, Object> params) {
        SqlParse sqlParse = new SqlParse(Config.getSql("/conf/segment/dq/default", "queryKdqqy"));
        sqlParse.bind(params);
        SqlParam sqlParam = sqlParse.parse();

        String hql = null;
        String formdqbm = "";

        // 通过原库获取查询条件
        Session session = null;
        try {
//			session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
            session = HibernateUtil.getSystemSessionFactory("3401").openSession();

            @SuppressWarnings("unchecked")
            List<HZ_ZJ_SB> list = HibernateUtil.getObjectList(session, sqlParam.getSql(),
                    sqlParam.getParams().toArray());
            String str = " (0=1 ";
            for (HZ_ZJ_SB hjyw : list) {
                str += " or a.gmsfhm='" + hjyw.getBsqrsfz() + "'";
                formdqbm = hjyw.getQcdbm();
            }
            str += ")";

            hql = "from HJXX_CZRKJBXXB a where " + str + " and a.jlbz='1' and a.ryzt='0' and a.cxbz='0'";
        } catch (Exception e) {
            throw new ServiceException("在" + user.getYwdq() + "执行查询异常！", e);
        } finally {
            if (session != null)
                session.close();
        }

        Page p = new Page();
        session = null;
        try {
            // session =
            // HibernateUtil.getSystemSessionFactory("3402").openSession();
//			session = HibernateUtil.getSystemSessionFactory(formdqbm.substring(0, 4)).openSession();
            session = HibernateUtil.getSystemSessionFactory("3401").openSession();
            @SuppressWarnings("unchecked")
            List<HJXX_CZRKJBXXB> list = HibernateUtil.getObjectList(session, hql, new Object[]{});
            p.setList(list);
            p.setTotalCount(list.size());
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException("在" + formdqbm.substring(0, 4) + "执行查询异常！", e);
        } finally {
            if (session != null)
                session.close();
        }

        return p;
    }

    public HZ_ZJ_SB queryHjywById(BaseUser user, ExtMap<String, Object> params) {
        if (user == null)
            throw new ServiceException("已超时，请重新进入此功能！");

        String ywid = params.getString("ywid");
        if (ywid == null)
            throw new ServiceException("参数错误！");

        HZ_ZJ_SB yw = null;
        Session session = null;
        try {
//			session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
            session = HibernateUtil.getSystemSessionFactory("3401").openSession();
            yw = HibernateUtil.get(session, HZ_ZJ_SB.class, ywid);
            if (yw == null)
                throw new ServiceException("业务不存在！");
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }

        return yw;
    }

    public Page queryKdqqy(BaseUser user, ExtMap<String, Object> params) {
        if (user == null)
            throw new ServiceException("已超时，请重新进入此功能！");

        // 添加登录用户
        if (user.getOtherParams() != null)
            params.putAll(user.getOtherParams());

        int pageIndex = params.getInteger(ExtUtils.pageIndex);
        int pageSize = params.getInteger(ExtUtils.pageSize);

        SqlParse sqlParse = new SqlParse(Config.getSql("/conf/segment/dq/default", "queryKdqqy"));
        sqlParse.bind(params);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
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

    public Page queryKDQCzrkjbxx(BaseUser user, ExtMap<String, Object> params) {
        String spywid = params.getString("spywid");
        String formdq = params.getString("formdq");
        String todq = params.getString("todq");

        if (user == null)
            throw new ServiceException("已超时，请重新进入此功能！");

        // 添加登录用户
        if (user.getOtherParams() != null)
            params.putAll(user.getOtherParams());

        //从迁入地区，查询迁出人
        //分两次查询，先查询迁出人，再查询非迁出人（不超过100人），合计不超过100人

        Session session_to = null;
        List<PoHJSP_HJSPZB> list_hjspzb = null;
        PoHJSP_HJSPSQB spyw = null;
        List<PoHJSP_ZQZXXB> zqzlist = null;
        Map<String, PoHJSP_HJSPZB> spMap = new HashMap<String, PoHJSP_HJSPZB>();
        PoXT_JWHXXB jwh = null;

        try {
            session_to = HibernateUtil.getSystemSessionFactory(todq).openSession();
            list_hjspzb = HibernateUtil.getObjectList(session_to, "from PoHJSP_HJSPZB a where a.spywid=" + spywid, new Object[]{});

            spyw = (PoHJSP_HJSPSQB) HibernateUtil.getObject(session_to, "from PoHJSP_HJSPSQB a where a.spywid=" + spywid, new Object[]{});
            if (spyw == null)
                throw new ServiceException("没有找到指定的迁入审批业务！");

            jwh = (PoXT_JWHXXB) HibernateUtil.getObject(session_to, "from PoXT_JWHXXB a where a.dm='" + spyw.getQrdjwh() + "'", new Object[]{});
            if (jwh == null)
                throw new ServiceException("没有找到迁入地居委会！");

            zqzlist = HibernateUtil.getObjectList(session_to, "from PoHJSP_ZQZXXB a where a.spywid=" + spywid, new Object[]{});

            for (PoHJSP_HJSPZB z : list_hjspzb) {
                spMap.put(z.getGmsfhm(), z);
            }
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session_to != null)
                session_to.close();
        }

        if (zqzlist == null || zqzlist.size() == 0)
            throw new ServiceException("没有找到电子准签证！");
        if (list_hjspzb.size() == 0) {
            throw new ServiceException("没有找到迁入人！");
        }
        if (spyw.getKdqqy_qcdqbm() == null || spyw.getKdqqy_qcdqbm().equals(""))
            throw new ServiceException("不是省内迁移业务！");

        if (!spyw.getKdqqy_fkzt().equals("0")) {
            throw new ServiceException("次业务已经被处理，请刷新列表！");
        }

        String w1 = "", w2 = "";
        for (PoHJSP_HJSPZB zb : list_hjspzb) {
            if (!w1.equals("")) {
                w1 += " or ";
                w2 += " and ";
            }

            w1 += " a.gmsfhm='" + zb.getGmsfhm() + "'";
            w2 += " a.gmsfhm<>'" + zb.getGmsfhm() + "'";
        }

        String qcrSQL = "from HJXX_CZRKJBXXB a "
                + " where a.ryzt = '0' and a.cxbz = '0' and a.jlbz = '1' and (" + w1 + ")";

        Map<String, String> zqzMap = new HashMap<String, String>();
        String kdqqy_qrdz = null;
        for (PoHJSP_ZQZXXB z : zqzlist) {
            if (CommonUtil.isNotEmpty(z.getQyrgmsfhm1())) zqzMap.put(z.getQyrgmsfhm1(), z.getZjbh());
            if (CommonUtil.isNotEmpty(z.getQyrgmsfhm2())) zqzMap.put(z.getQyrgmsfhm2(), z.getZjbh());
            if (CommonUtil.isNotEmpty(z.getQyrgmsfhm3())) zqzMap.put(z.getQyrgmsfhm3(), z.getZjbh());
            if (CommonUtil.isNotEmpty(z.getQyrgmsfhm4())) zqzMap.put(z.getQyrgmsfhm4(), z.getZjbh());

            kdqqy_qrdz = z.getQrdxz();
        }

        String qrd_ssxq = spyw.getQrdqx();
        String qrd_cxfldm = jwh.getCxfldm();
        String qcd_ssxq = null;

        List<HJXX_CZRKJBXXB> relist = new ArrayList<HJXX_CZRKJBXXB>();
        Session session_form = null;
        String hhnbid = null;
        boolean existsHz = false;
        try {
            session_form = HibernateUtil.getSystemSessionFactory(formdq).openSession();
            List<HJXX_CZRKJBXXB> qcrList = HibernateUtil.getObjectList(session_form, qcrSQL, new Object[]{});
            for (Object o : qcrList) {
                HJXX_CZRKJBXXB a = (HJXX_CZRKJBXXB) o;
                XT_JLXXXB b = (XT_JLXXXB) session_form.get(XT_JLXXXB.class, a.getJlx());
                XT_JWHXXB c = (XT_JWHXXB) session_form.get(XT_JWHXXB.class, a.getJcwh());

                if (b != null)
                    a.setJlx_text(b.getMc());
                if (c != null)
                    a.setJwh_text(c.getMc());

                if (hhnbid == null) {
                    hhnbid = a.getHhnbid();
                } else {
                    if (!hhnbid.equals(a.getHhnbid())) {
                        throw new ServiceException("数据错误，迁出不是同一户！");
                    }
                }

                a.setQcflag("1");
                a.setKdqqy_zqz(zqzMap.get(a.getGmsfhm()));
                a.setKdqqy_qrdz(kdqqy_qrdz);
                a.setKdqqy_qyldyy(spMap.get(a.getGmsfhm()).getKdqqy_qyldyy());
                a.setKdqqy_qczxlb(spMap.get(a.getGmsfhm()).getKdqqy_qclb());
                a.setKdqqy_qrdqh(spyw.getQrdqx());
                if (a.getYhzgx().equals("01") || a.getYhzgx().equals("02") || a.getYhzgx().equals("03"))
                    existsHz = true;

                qcd_ssxq = a.getSsxq();

                relist.add(a);
            }
            if (relist.size() <= 0)
                throw new ServiceException("没有找到迁出人！");

            String hcySQL = "from HJXX_CZRKJBXXB a "
                    + " where a.hhnbid=" + hhnbid + " and  a.ryzt = '0' and a.cxbz = '0' and a.jlbz = '1' and (" + w2 + ")";
            Page p = HibernateUtil.getPageRecords(session_form, hcySQL, new ArrayList(), 1, 20);
            for (Object o : p.getList()) {
                HJXX_CZRKJBXXB a = (HJXX_CZRKJBXXB) o;
                XT_JLXXXB b = (XT_JLXXXB) session_form.get(XT_JLXXXB.class, a.getJlx());
                XT_JWHXXB c = (XT_JWHXXB) session_form.get(XT_JWHXXB.class, a.getJcwh());

                if (b != null)
                    a.setJlx_text(b.getMc());
                if (c != null)
                    a.setJwh_text(c.getMc());

                if (hhnbid == null) {
                    hhnbid = a.getHhnbid();
                } else {
                    if (!hhnbid.equals(a.getHhnbid())) {
                        throw new ServiceException("数据错误，迁出不是同一户！");
                    }
                }

                a.setQcflag("0");
                if (a.getYhzgx().equals("01") || a.getYhzgx().equals("02") || a.getYhzgx().equals("03"))
                    existsHz = true;

                relist.add(a);
            }

            if (!existsHz) {
                String hzSQL = "from HJXX_CZRKJBXXB a "
                        + " where a.hhnbid=" + hhnbid + " and a.ryzt = '0' and a.cxbz = '0' and a.jlbz = '1'  and (a.yhzgx='01' or a.yhzgx='02' or a.yhzgx='03')";
                List<HJXX_CZRKJBXXB> hzList = HibernateUtil.getObjectList(session_form, hzSQL, new Object[]{});
                for (Object o : hzList) {
                    HJXX_CZRKJBXXB a = (HJXX_CZRKJBXXB) o;
                    a.setQcflag("0");
                    relist.add(a);
                }
            }

            Page page = new Page();
            page.setList(relist);
            page.setTotalCount(relist.size());

            String qcdbdfw = null;
            if (qrd_ssxq != null && qrd_ssxq.length() > 4 && qrd_cxfldm != null && qcd_ssxq != null && qcd_ssxq.length() > 4) {
                //String qrd_ssxq = spyw.getQrdqx();
                //String qrd_cxfldm = jwh.getCxfldm();
                //String qcd_ssxq = null;
                //迁出地SSXQ前4位=迁入地SSXQ前4位，并且迁入地行政区划后两位<'20'。且迁出地区划后两位<'20'	like '1%'	31	市内城镇
                if (qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("1")) {
                    String sub1 = qrd_ssxq.substring(qrd_ssxq.length() - 2);
                    String sub2 = qcd_ssxq.substring(qcd_ssxq.length() - 2);
                    if (Integer.parseInt(sub1) < 20 && Integer.parseInt(sub2) < 20) {
                        qcdbdfw = "31";
                    }
                }

                //迁出地SSXQ前4位=迁入地SSXQ前4位，并且(迁入地行政区划后两位>='21'。或迁出地行政区划后两位>='21'）	like '1%'	34	市外城镇
                if (qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("1")) {
                    String sub1 = qrd_ssxq.substring(qrd_ssxq.length() - 2);
                    String sub2 = qcd_ssxq.substring(qcd_ssxq.length() - 2);
                    if (Integer.parseInt(sub1) >= 21 || Integer.parseInt(sub2) >= 21) {
                        qcdbdfw = "34";
                    }
                }

                //迁出地SSXQ前4位!=迁入地SSXQ前4位	like '11%'	43	省内城市
                if (!qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("11")) {
                    qcdbdfw = "43";
                }

                //迁出地SSXQ前4位!=迁入地SSXQ前4位	like '12%'	42	省内城镇
                if (!qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("12")) {
                    qcdbdfw = "42";
                }

                //迁出地SSXQ前4位=迁入地SSXQ前4位，并且迁入地行政区划后两位<'20'。且迁出地区划后两位<'20'	like '2%'	32	市内郊区
                if (qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("2")) {
                    String sub1 = qrd_ssxq.substring(qrd_ssxq.length() - 2);
                    String sub2 = qcd_ssxq.substring(qcd_ssxq.length() - 2);
                    if (Integer.parseInt(sub1) < 20 && Integer.parseInt(sub2) < 20) {
                        qcdbdfw = "32";
                    }
                }

                //迁出地SSXQ前4位=迁入地SSXQ前4位，并且（迁入地行政区划后两位>='21'。或迁出地行政区划后两位>='21'）	like '2%'	33	市外乡村
                if (qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("2")) {
                    String sub1 = qrd_ssxq.substring(qrd_ssxq.length() - 2);
                    String sub2 = qcd_ssxq.substring(qcd_ssxq.length() - 2);
                    if (Integer.parseInt(sub1) >= 21 || Integer.parseInt(sub2) >= 21) {
                        qcdbdfw = "33";
                    }
                }

                //迁出地SSXQ前4位!=迁入地SSXQ前4位	like '2%'	41	省内乡村
                if (!qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("2")) {
                    qcdbdfw = "41";
                }
            }

            if (qcdbdfw != null) {
                relist.get(0).setQcdbdfw(qcdbdfw);
            }

            return page;
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session_form != null)
                session_form.close();
        }
    }

    public Page queryKDQCzrkjbxxQxgl(BaseUser user, ExtMap<String, Object> params) {
        String sqr_gmsfhm = params.getString("sqr_gmsfhm");
        String ywlsh = params.getString("ywlsh");
        String formdq = params.getString("formdq");
        String todq = params.getString("todq");

        if (user == null)
            throw new ServiceException("已超时，请重新进入此功能！");

        // 添加登录用户
        if (user.getOtherParams() != null)
            params.putAll(user.getOtherParams());

        //从迁入地区，查询迁出人
        //分两次查询，先查询迁出人，再查询非迁出人（不超过100人），合计不超过100人

        Session session_to = null;
        List<ZjywZqzQyrxx> list_hjspzb = null;
        ZjywZqzxx spyw = null;
        List<PoHJSP_ZQZXXB> zqzlist = null;
        PoXT_JWHXXB jwh = null;
        Map<String, ZjywZqzQyrxx> spMap = new HashMap<String, ZjywZqzQyrxx>();

        try {
            spyw = (ZjywZqzxx) super.getObject("from ZjywZqzxx a where a.sqr_gmsfhm='" + sqr_gmsfhm + "' and ywlsh='" + ywlsh+"'", null);

            list_hjspzb = super.getObjectListByHql("from ZjywZqzQyrxx a where a.ywlsh=" + "'" + spyw.getYwlsh() + "'", null);


            if (spyw == null)
                throw new ServiceException("没有找到指定的迁入审批业务！");

//			jwh = (PoXT_JWHXXB)HibernateUtil.getObject(session_to,  "from PoXT_JWHXXB a where a.dm='" + spyw.getQrdjwh() + "'", new Object[]{});
//			if(jwh==null)
//				throw new ServiceException("没有找到迁入地居委会！");

//			zqzlist = HibernateUtil.getObjectList(session_to,  "from PoHJSP_ZQZXXB a where a.spywid=" + spywid, new Object[]{});

            for (ZjywZqzQyrxx z : list_hjspzb) {
                spMap.put(z.getGmsfhm(), z);
            }
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session_to != null)
                session_to.close();
        }

//		if(zqzlist==null || zqzlist.size()==0)
//			throw new ServiceException("没有找到电子准签证！");
//		if(list_hjspzb.size()==0){
//			throw new ServiceException("没有找到迁入人！");
//		}
        String w1 = "", w2 = "";
        for (ZjywZqzQyrxx zb : list_hjspzb) {
            if (!w1.equals("")) {
                w1 += " or ";
                w2 += " and ";
            }

            w1 += " a.gmsfhm='" + zb.getGmsfhm() + "'";
            w2 += " a.gmsfhm<>'" + zb.getGmsfhm() + "'";
        }

        String qcrSQL = "from HJXX_CZRKJBXXB a "
                + " where a.ryzt = '0' and a.cxbz = '0' and a.jlbz = '1' and (" + w1 + ")";

        Map<String, String> zqzMap = new HashMap<String, String>();
        String kdqqy_qrdz = spyw.getSqr_zz_qhnxxdz();
//		for(PoHJSP_ZQZXXB z :zqzlist){
//			if(CommonUtil.isNotEmpty(z.getQyrgmsfhm1())) zqzMap.put(z.getQyrgmsfhm1(), z.getZjbh());
//			if(CommonUtil.isNotEmpty(z.getQyrgmsfhm2())) zqzMap.put(z.getQyrgmsfhm2(), z.getZjbh());
//			if(CommonUtil.isNotEmpty(z.getQyrgmsfhm3())) zqzMap.put(z.getQyrgmsfhm3(), z.getZjbh());
//			if(CommonUtil.isNotEmpty(z.getQyrgmsfhm4())) zqzMap.put(z.getQyrgmsfhm4(), z.getZjbh());
//
//			kdqqy_qrdz = z.getQrdxz();
//		}

        String qrd_ssxq = spyw.getQrd_ssxqdm();
        String qrd_cxfldm = "";
        String qcd_ssxq = null;

        List<HJXX_CZRKJBXXB> relist = new ArrayList<HJXX_CZRKJBXXB>();
        Session session_form = null;
        String hhnbid = null;
        boolean existsHz = false;
        try {
            session_form = HibernateUtil.getSystemSessionFactory(formdq).openSession();
            List<HJXX_CZRKJBXXB> qcrList = HibernateUtil.getObjectList(session_form, qcrSQL, new Object[]{});
            for (Object o : qcrList) {
                HJXX_CZRKJBXXB a = (HJXX_CZRKJBXXB) o;
                XT_JLXXXB b = (XT_JLXXXB) session_form.get(XT_JLXXXB.class, a.getJlx());
                XT_JWHXXB c = (XT_JWHXXB) session_form.get(XT_JWHXXB.class, a.getJcwh());

                if (b != null)
                    a.setJlx_text(b.getMc());
                if (c != null)
                    a.setJwh_text(c.getMc());

                if (hhnbid == null) {
                    hhnbid = a.getHhnbid();
                } else {
                    if (!hhnbid.equals(a.getHhnbid())) {
                        throw new ServiceException("数据错误，迁出不是同一户！");
                    }
                }

                a.setQcflag("1");
                a.setKdqqy_zqz(spyw.getZqzbh());
                a.setKdqqy_qrdz(spyw.getQrd_qhnxxdz());
                a.setKdqqy_qyldyy(spyw.getQyldyydm());
                a.setKdqqy_qczxlb("");
                a.setKdqqy_qrdqh(spyw.getQrd_ssxqdm());
                a.setBdfw(spyw.getQyfwdm());
                if (a.getYhzgx().equals("01") || a.getYhzgx().equals("02") || a.getYhzgx().equals("03"))
                    existsHz = true;

                qcd_ssxq = a.getSsxq();

                relist.add(a);
            }
            if (relist.size() <= 0)
                throw new ServiceException("没有找到迁出人！");

            String hcySQL = "from HJXX_CZRKJBXXB a "
                    + " where a.hhnbid=" + hhnbid + " and  a.ryzt = '0' and a.cxbz = '0' and a.jlbz = '1' and (" + w2 + ")";
            Page p = HibernateUtil.getPageRecords(session_form, hcySQL, new ArrayList(), 1, 20);
            for (Object o : p.getList()) {
                HJXX_CZRKJBXXB a = (HJXX_CZRKJBXXB) o;
                XT_JLXXXB b = (XT_JLXXXB) session_form.get(XT_JLXXXB.class, a.getJlx());
                XT_JWHXXB c = (XT_JWHXXB) session_form.get(XT_JWHXXB.class, a.getJcwh());

                if (b != null)
                    a.setJlx_text(b.getMc());
                if (c != null)
                    a.setJwh_text(c.getMc());

                if (hhnbid == null) {
                    hhnbid = a.getHhnbid();
                } else {
                    if (!hhnbid.equals(a.getHhnbid())) {
                        throw new ServiceException("数据错误，迁出不是同一户！");
                    }
                }

                a.setQcflag("0");
                if (a.getYhzgx().equals("01") || a.getYhzgx().equals("02") || a.getYhzgx().equals("03"))
                    existsHz = true;

                relist.add(a);
            }

            if (!existsHz) {
                String hzSQL = "from HJXX_CZRKJBXXB a "
                        + " where a.hhnbid=" + hhnbid + " and a.ryzt = '0' and a.cxbz = '0' and a.jlbz = '1'  and (a.yhzgx='01' or a.yhzgx='02' or a.yhzgx='03')";
                List<HJXX_CZRKJBXXB> hzList = HibernateUtil.getObjectList(session_form, hzSQL, new Object[]{});
                for (Object o : hzList) {
                    HJXX_CZRKJBXXB a = (HJXX_CZRKJBXXB) o;
                    a.setQcflag("0");
                    relist.add(a);
                }
            }

            Page page = new Page();
            page.setList(relist);
            page.setTotalCount(relist.size());

            String qcdbdfw = null;
            if (qrd_ssxq != null && qrd_ssxq.length() > 4 && qrd_cxfldm != null && qcd_ssxq != null && qcd_ssxq.length() > 4) {
                //String qrd_ssxq = spyw.getQrdqx();
                //String qrd_cxfldm = jwh.getCxfldm();
                //String qcd_ssxq = null;
                //迁出地SSXQ前4位=迁入地SSXQ前4位，并且迁入地行政区划后两位<'20'。且迁出地区划后两位<'20'	like '1%'	31	市内城镇
                if (qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("1")) {
                    String sub1 = qrd_ssxq.substring(qrd_ssxq.length() - 2);
                    String sub2 = qcd_ssxq.substring(qcd_ssxq.length() - 2);
                    if (Integer.parseInt(sub1) < 20 && Integer.parseInt(sub2) < 20) {
                        qcdbdfw = "31";
                    }
                }

                //迁出地SSXQ前4位=迁入地SSXQ前4位，并且(迁入地行政区划后两位>='21'。或迁出地行政区划后两位>='21'）	like '1%'	34	市外城镇
                if (qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("1")) {
                    String sub1 = qrd_ssxq.substring(qrd_ssxq.length() - 2);
                    String sub2 = qcd_ssxq.substring(qcd_ssxq.length() - 2);
                    if (Integer.parseInt(sub1) >= 21 || Integer.parseInt(sub2) >= 21) {
                        qcdbdfw = "34";
                    }
                }

                //迁出地SSXQ前4位!=迁入地SSXQ前4位	like '11%'	43	省内城市
                if (!qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("11")) {
                    qcdbdfw = "43";
                }

                //迁出地SSXQ前4位!=迁入地SSXQ前4位	like '12%'	42	省内城镇
                if (!qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("12")) {
                    qcdbdfw = "42";
                }

                //迁出地SSXQ前4位=迁入地SSXQ前4位，并且迁入地行政区划后两位<'20'。且迁出地区划后两位<'20'	like '2%'	32	市内郊区
                if (qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("2")) {
                    String sub1 = qrd_ssxq.substring(qrd_ssxq.length() - 2);
                    String sub2 = qcd_ssxq.substring(qcd_ssxq.length() - 2);
                    if (Integer.parseInt(sub1) < 20 && Integer.parseInt(sub2) < 20) {
                        qcdbdfw = "32";
                    }
                }

                //迁出地SSXQ前4位=迁入地SSXQ前4位，并且（迁入地行政区划后两位>='21'。或迁出地行政区划后两位>='21'）	like '2%'	33	市外乡村
                if (qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("2")) {
                    String sub1 = qrd_ssxq.substring(qrd_ssxq.length() - 2);
                    String sub2 = qcd_ssxq.substring(qcd_ssxq.length() - 2);
                    if (Integer.parseInt(sub1) >= 21 || Integer.parseInt(sub2) >= 21) {
                        qcdbdfw = "33";
                    }
                }

                //迁出地SSXQ前4位!=迁入地SSXQ前4位	like '2%'	41	省内乡村
                if (!qrd_ssxq.substring(0, 4).equals(qcd_ssxq.substring(0, 4)) && qrd_cxfldm.startsWith("2")) {
                    qcdbdfw = "41";
                }

            }

            if (qcdbdfw != null) {
                relist.get(0).setQcdbdfw(qcdbdfw);
            }

            return page;
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session_form != null)
                session_form.close();
        }
    }


    /**
     * 常住人口基本信息查询
     */
    public Page queryCzrkjbxx(BaseUser user, ExtMap<String, Object> params) {
        if (user == null)
            throw new ServiceException("已超时，请重新进入此功能！");

        // 添加登录用户
        if (user.getOtherParams() != null)
            params.putAll(user.getOtherParams());

        int pageIndex = params.getInteger(ExtUtils.pageIndex);
        int pageSize = params.getInteger(ExtUtils.pageSize);

        SqlParse sqlParse = new SqlParse(Config.getSql("/conf/segment/dq/default", "queryCzrkjbxx"));
        sqlParse.bind(params);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
        try {
            String dqbm = user.getYwdq();
            if (CommonUtil.isNotEmpty((String) params.get("dqbm"))) {
                dqbm = params.getString("dqbm");
            }
            /**
             2017.09.25
             注释	刁杰
             HibernateUtil.getSystemSessionFactory(dqbm).openSession();
             获取固定地市的数据库连接
             地市连接在conf\dq中配置
             */
            session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
            Page page = HibernateUtil.getPageRecords(session, sqlParam.getSql(), sqlParam.getParams(), pageIndex,
                    pageSize);

            List<HJXX_CZRKJBXXB> list = new ArrayList<HJXX_CZRKJBXXB>();
            for (Object o : page.getList()) {
                HJXX_CZRKJBXXB a = (HJXX_CZRKJBXXB) o;
                XT_JLXXXB b = (XT_JLXXXB) session.get(XT_JLXXXB.class, a.getJlx());
                XT_JWHXXB c = (XT_JWHXXB) session.get(XT_JWHXXB.class, a.getJcwh());

                if (b != null)
                    a.setJlx_text(b.getMc());
                if (c != null)
                    a.setJwh_text(c.getMc());

                list.add(a);
            }

            page.setList(list);

            return page;
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    public VoQczxywfhxx saveKdsQc(BaseUser user, String qcdqbm, List<VoBggzxxEx> voBggzxxEx, List<VoQczxxx> voQczxxx,
                                  VoSbjbxx voSbjbxx, ExtMap<String, Object> params) {
        String todq = params.getString("todq");
        String spywid = params.getString("spywid");

//		todq = "3402";
//		spywid = "3405000001000000015";

        if (CommonUtil.isEmpty(qcdqbm) || CommonUtil.isEmpty(todq) || CommonUtil.isEmpty(spywid))
            throw new ServiceException("必须提供参数qcdqbm,todq,spywid，指定迁出信息！");

        if (voSbjbxx == null)
            throw new ServiceException("申报人不能为空！");

        if (voQczxxx == null || voQczxxx.size() <= 0)
            throw new ServiceException("迁出人员不能为空！");

        VoQczxywfhxx voQczxywfhxx = null;
        VoQczxfhxx voQczxfhxx[] = null;
        VoHcygxtzxxEx voHcygxtzxxEx[] = null;
        List bggzfhxxList = new ArrayList();
        List hcygxtzfhxxList = new ArrayList();
        List rybdxxList = new ArrayList();
        VoQyzbhhtxx qyzdyxx = null;
        VoZxhxx voZxhxx[] = null;
        Long hjywid = null;
        String qyzdyxx_yhzgx = null;
        Long qyzdyxx_rynbid = null;
        PoXT_JWHXXB poJwhxxb = null;
        String qyzbh = null;
        String qyzbh_old = null;
        String cxfldm = null;
        //PoHJXX_MLPXXXXB poMlpxxxx_QR = null;

        if (voQczxxx == null || (voQczxxx != null && voQczxxx.size() <= 0)) {
            return null;
        }

        List<PoHJSP_HJSPZB> list_hjspzb = null;
        PoHJSP_HJSPSQB spyw = null;
        Map<String, String> map = new HashMap<String, String>();

        Transaction tran2 = null;
        Session session2 = null;
        try {
            session2 = HibernateUtil.getSystemSessionFactory(todq).openSession();
            if (session2 == null)
                throw new ServiceException("数据库不支持此地区！");

            list_hjspzb = HibernateUtil.getObjectList(session2, "from PoHJSP_HJSPZB a where a.spywid=" + spywid, new Object[]{});
            spyw = (PoHJSP_HJSPSQB) HibernateUtil.getObject(session2, "from PoHJSP_HJSPSQB a where a.spywid=" + spywid, new Object[]{});
            for (PoHJSP_HJSPZB z : list_hjspzb) {
                map.put(z.getGmsfhm(), z.getZjbh());
            }

            //poMlpxxxx_QR = HibernateUtil.get(session2, PoHJXX_MLPXXXXB.class, spyw.getQrdmlph());
            //if (poMlpxxxx_QR == null) {
            //	throw new ServiceException("找不到迁出注销人员所在的地信息，迁出注销业务无法完成。", null);
            //}
        } catch (Exception e) {
            if (session2 != null)
                session2.close();
            throw new ServiceException(e);
        } finally {
        }

        Transaction tran = null;
        Session session = null;
        List qyzryList = new ArrayList();
        try {
            //获取迁移证
            String year = DateHelper.formateDate("yyyy");
            XT_ZQZ_QYZ_XLH xlh = this.requestXLH("", year, "qyz");
            String str = xlh.getZjbh().toString();
            if (str.length() < 5)
                str = "00000".substring(0, 5 - str.length()) + str;

            qyzbh = "皖" + year.substring(year.length() - 1, year.length()) + DateHelper.formateDate("MM") + str;
            //获取迁移证
            qyzbh_old = qyzbh;

            session = HibernateUtil.getSystemSessionFactory(qcdqbm).openSession();
            if (session == null)
                throw new ServiceException("数据库不支持此地区！");

            tran = session.beginTransaction();

            String oldSQL = "from PoPOST_KDQCFKB a where a.spywid='" + spyw.getSpywid() + "' and a.qrdq='" + todq + "'";

            Object obj = HibernateUtil.getObject(session, oldSQL, new Object[]{});
            if (obj != null)
                throw new ServiceException("此迁入审批已经完成迁出，不能再次处理！");

            String now = YWUtils.getServiceTime(session);

            if (voSbjbxx != null && voSbjbxx.getHzywid() != null) {
                List list = HibernateUtil.getObjectList(session, "from HzZjSb a where a.id=" + voSbjbxx.getHzywid(),
                        null);
                if (list.size() > 0) {
                    HzZjSb sb = (HzZjSb) list.get(0);
                    if (sb.getPch() != null && !sb.getPch().equals("")) {
                        // 一个批次，统一处理
                        System.out.println("迁出注销批量处理！");
                        list = HibernateUtil.getObjectList(session, "from HzZjSb a where a.pch='" + sb.getPch() + "'",
                                null);
                        int pccount = list.size();
                        for (int index = 0; index < pccount; index++) {
                            HzZjSb sbx = (HzZjSb) list.get(index);
                            sbx.setClbs("1");
                            sbx.setClsj(new Date());
                            HibernateUtil.update(session, sbx);
                        }
                    } else {
                        sb.setClbs("1");
                        sb.setClsj(new Date());
                        HibernateUtil.update(session, sb);
                    }
                }
            }

            /////////////////////////////////////
            // 得到户籍业务ID
            hjywid = (Long) YWUtils.getId(session, "SID_HJLS_HJYWLSB");
            //////////////////////////////////////////
            // 保存迁出注销信息
            voQczxfhxx = new VoQczxfhxx[voQczxxx.size()];
            voZxhxx = new VoZxhxx[voQczxxx.size()];
            voHcygxtzxxEx = new VoHcygxtzxxEx[voQczxxx.size()];
            for (int i = 0; i < voQczxxx.size(); i++) {
                // 得到人员信息
                PoHJXX_CZRKJBXXB poRyxx = HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class,
                        voQczxxx.get(i).getRynbid());
                if (poRyxx == null) {
                    throw new ServiceException("找不到迁出人员信息，迁出注销业务无法完成。");
                }

                // 校验人信息的时效性
                YWUtils.checkRXX(session, poRyxx, "迁出注销业务");
                // 人员锁定状态
                if (!HjConstant.RYSDZT_ZC.equals(poRyxx.getRysdzt())) {
                    throw new ServiceException("人员锁定状态为非正常(被锁定)，迁出注销业务无法完成，此人可能已经完成迁出。", null);
                }
                // 人员状态
                if (!HjConstant.RYZT_ZC.equals(poRyxx.getRyzt())) {
                    throw new ServiceException("人员状态为非正常，迁出注销业务无法完成，此人可能已经完成迁出。", null);
                }

                // 得到户信息
                PoHJXX_HXXB poHxx = HibernateUtil.get(session, PoHJXX_HXXB.class, poRyxx.getHhnbid());
                if (poHxx == null) {
                    throw new ServiceException("找不到迁出注销人员所在的户信息，迁出注销业务无法完成。", null);
                }

                // 得到地信息
                PoHJXX_MLPXXXXB poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poRyxx.getMlpnbid());
                if (poMlpxxxx == null) {
                    throw new ServiceException("找不到迁出注销人员所在的地信息，迁出注销业务无法完成。", null);
                }

                poJwhxxb = (PoXT_JWHXXB) HibernateUtil.get(session, PoXT_JWHXXB.class, poMlpxxxx.getJcwh());
                if (poJwhxxb == null) {
                    throw new ServiceException("找不到所在的地居委会，业务无法完成。", null);
                }

                cxfldm = poJwhxxb.getCxfldm();

                // 迁出注销业务判断
                if (PublicConstant.XTKZCS_QY.equals(YWUtils.getXTKZCS(session, PublicConstant.XTKZCS_SHQYZDQYPD))) {
                    if (YWUtils.checkZZBD(session, voQczxxx.get(i).getQwdssxq(), poMlpxxxx.getSsxq())) {
                        throw new ServiceException("迁入地和迁出地范围不符合迁出注销业务，迁出注销业务无法完成。", null);
                    }
                }

                // 数据范围限制
                /*
                 * List sjfwList = new ArrayList(); VoXtsjfw voXtsjfw = new
                 * VoXtsjfw(); voXtsjfw.setSjfw(poMlpxxxx.getJcwh());
                 * voXtsjfw.setSjfwbz(PublicConstant.XT_QX_JWH);
                 * sjfwList.add(voXtsjfw); boolean bLimit = false; bLimit =
                 * XtywqxServiceImpl.VerifyDataRange(this.getUserInfo().getYhid(
                 * ). toString(), PublicConstant.GNBH_HJ_QCZXYW, sjfwList); if
                 * (!bLimit) { throw new
                 * ServiceException(WSErrCode.ERR_SERVICE_BUSSINESSLIMIT,
                 * "数据范围被限制，迁出注销业务无法完成。", null); }
                 */

                // 保存人员信息为历史记录
                poRyxx.setJssj(now);
                poRyxx.setCchjywid(hjywid);
                poRyxx.setJlbz(PublicConstant.JLBZ_LS);
                HibernateUtil.update(session, poRyxx);

                // 保存人员信息为新记录
                PoHJXX_CZRKJBXXB poRyxxNew = new PoHJXX_CZRKJBXXB();
                BeanUtils.copyProperties(poRyxxNew, poRyxx);
                BeanUtils.copyProperties(poRyxxNew, voQczxxx.get(i));
                poRyxxNew.setQczxlb(voQczxxx.get(i).getQclb());
                // SID_HJXX_CZRKJBXXB
                Long rynbid = (Long) YWUtils.getId(session, "SID_HJXX_CZRKJBXXB");
                poRyxxNew.setRynbid(rynbid);
                // 处理poRyxxNew变更更正信息begin
                if (voBggzxxEx != null) {
                    for (int k = 0; k < voBggzxxEx.size(); k++) {
                        if (voQczxxx.get(i).getRynbid().equals(voBggzxxEx.get(k).getRynbid())) {
                            voBggzxxEx.get(k).setFlag(0); //// 是否需要修改常住人口信息表中的对应记录(0-不修改/1-修改)
                            VoBggzfhxxEx vobEx = YWUtils.disposalBggzxx(session, hjywid, voSbjbxx, voBggzxxEx.get(k),
                                    poRyxxNew, PublicConstant.GNBH_HJ_QCZXYW, now);
                            if (vobEx != null) {
                                if (vobEx.getVoBggzfhxx() != null) {
                                    for (int a = 0; a < vobEx.getVoBggzfhxx().length; a++) {
                                        bggzfhxxList.add(vobEx.getVoBggzfhxx()[a]);
                                    }
                                } // if(vobEx!=null)
                                if (vobEx.getVoHcygxtzfhxx() != null) {
                                    for (int a = 0; a < vobEx.getVoHcygxtzfhxx().length; a++) {
                                        hcygxtzfhxxList.add(vobEx.getVoHcygxtzfhxx()[a]);
                                    }
                                }
                            } // if(vobEx!=null)
                        } // if(voHbbgxx[i].getRynbid().equals(voBggzxx[k].getRynbid()))
                    } // for(int k=0;k<voBggzxx.length;k++)
                }
                // end

                // 人员状态_出国定居
                if (HjConstant.QCZXLB_CGDJ.equals(voQczxxx.get(i).getQclb())
                        || HjConstant.QCZXLB_QWGA.equals(voQczxxx.get(i).getQclb())
                        || HjConstant.QCZXLB_QWTW.equals(voQczxxx.get(i).getQclb())) {
                    poRyxxNew.setRyzt(HjConstant.RYZT_CGJDJ);
                }
                // 人员状态_服兵役
                else if (HjConstant.QCZXLB_CJFBY.equals(voQczxxx.get(i).getQclb())) {
                    poRyxxNew.setRyzt(HjConstant.RYZT_FBY);
                }
                // 人员状态_迁出注销
                else {
                    poRyxxNew.setRyzt(HjConstant.RYZT_QC);
                }

                poRyxxNew.setQysj(now);
                poRyxxNew.setJssj(null);
                poRyxxNew.setXxqysj(now);// add by hb 20061027
                poRyxxNew.setYwnr(HjConstant.YWNR_QCZX);
                poRyxxNew.setCchjywid(null);
                poRyxxNew.setCjhjywid(hjywid);
                poRyxxNew.setJlbz(PublicConstant.JLBZ_ZX);
                HibernateUtil.create(session, poRyxxNew);


                qyzdyxx = new VoQyzbhhtxx();
                qyzdyxx.setDysx(new Long(qyzryList.size() + 1)); //1 一户一证
                qyzdyxx.setHjywid(hjywid);
                qyzdyxx.setQfrq(CommonUtil.formatDate("yyyyMMdd"));
                qyzdyxx.setRynbid(poRyxxNew.getRynbid());
                qyzdyxx.setYczrgx(poRyxxNew.getYhzgx());
                qyzdyxx.setYxqxjzrq("20300101");
                qyzdyxx.setYznf(CommonUtil.formatDate("yyyy"));
                if ("0123456789".indexOf(qyzbh.substring(0, 1)) < 0) {
                    qyzdyxx.setQyzbh(qyzbh.substring(1));
                }
                qyzryList.add(qyzdyxx);

                Long qcclid = (Long) YWUtils.getId(session, "SID_HJYW_QCCLXXB");
                PoHJYW_QCCLXXB poQcclxx = new PoHJYW_QCCLXXB();
                poQcclxx.setQcclid(qcclid);
                BeanUtils.copyProperties(poQcclxx, poRyxxNew);
                poQcclxx.setMlpnbid_q(poMlpxxxx.getMlpnbid());
                poQcclxx.setSsxq_q(poMlpxxxx.getSsxq());
                poQcclxx.setJlx_q(poMlpxxxx.getJlx());
                poQcclxx.setMlph_q(poMlpxxxx.getMlph());
                poQcclxx.setMlxz_q(poMlpxxxx.getMlxz());
                poQcclxx.setPcs_q(poMlpxxxx.getPcs());
                poQcclxx.setZrq_q(poMlpxxxx.getZrq());
                poQcclxx.setXzjd_q(poMlpxxxx.getXzjd());
                poQcclxx.setJcwh_q(poMlpxxxx.getJcwh());
                poQcclxx.setPxh_q(poMlpxxxx.getPxh());
                //poQcclxx.setMlpnbid_h(poMlpxxxx_QR.getMlpnbid());
                //poQcclxx.setPxh_h(spyw.getqrdp.getPxh());
                //poQcclxx.setZrq_h(spyw.getqrdzr.getZrq());

                //跨地市迁出，无法传值，就用迁出人
                poQcclxx.setMlpnbid_h(poMlpxxxx.getMlpnbid());
                poQcclxx.setPxh_h(poMlpxxxx.getPxh());
                poQcclxx.setZrq_h(poMlpxxxx.getZrq());

                poQcclxx.setSsxq_h(spyw.getQrdqx());
                poQcclxx.setJlx_h(spyw.getQrdjlx());
                poQcclxx.setMlph_h(spyw.getQrdmlph());
                poQcclxx.setMlxz_h(spyw.getQrdz());
                poQcclxx.setPcs_h(spyw.getQrdpcs());
                poQcclxx.setXzjd_h(spyw.getQrdxzjd());
                poQcclxx.setJcwh_h(spyw.getQrdjwh());
                poQcclxx.setCxbz(PublicConstant.CXBZ_FCX);
                poQcclxx.setQqrynbid(0l);
                poQcclxx.setQhrynbid(poRyxxNew.getRynbid());
                poQcclxx.setCzlx(HjConstant.QCCL_CZXL_KDS);
                poQcclxx.setClbz(HjConstant.QCCL_CLBZ_WCL);
                poQcclxx.setHjywid(hjywid);
                HibernateUtil.create(session, poQcclxx);

                /*
                 * //业务限制处理 VoRhdxx voRhdxx = new VoRhdxx(poRyxxNew, poHxx,
                 * poMlpxxxx, this.getUserInfo()); VoXtywxz voLimit =
                 * XtywqxServiceImpl.VerifyBusinessLimit(PublicConstant.
                 * GNBH_HJ_QCZXYW, voRhdxx); if (voLimit.getLimitflag()) { throw
                 * new ServiceException(WSErrCode.ERR_SERVICE_BUSSINESSLIMIT,
                 * "迁出注销业务受限，受限信息：" + voLimit.getLimitinfo(), null); } voRhdxx =
                 * null;
                 */

                // 保存迁出注销信息
                PoHJYW_QCZXXXB poQczxxx = new PoHJYW_QCZXXXB();
                if (voSbjbxx != null) {
                    BeanUtils.copyProperties(poQczxxx, voSbjbxx);
                }
                BeanUtils.copyProperties(poQczxxx, voQczxxx.get(i));
                BeanUtils.copyProperties(poQczxxx, poRyxxNew);
                poQczxxx.setHhid(poHxx.getHhid());
                poQczxxx.setMlpid(poMlpxxxx.getMlpid());
                poQczxxx.setQczxid((Long) YWUtils.getId(session, "SID_HJYW_QCZXXXB"));
                poQczxxx.setCxbz(PublicConstant.CXBZ_FCX);
                poQczxxx.setHjywid(hjywid);
                String dwdm = "";
                if (user.getOtherParams() != null) {
                    dwdm = user.getOtherParams().getString("dwdm");
                    if (dwdm == null || dwdm.length() < 4)
                        throw new ServiceException("未知迁入地区！");
                }
//				String dwdm = user.getOtherParams().getString("dwdm");
//				if(dwdm==null || dwdm.length()<4)
//					throw new ServiceException("未知迁入地区！");
//				poQczxxx.setSldw(user.getOtherParams().getString("dwdm"));
                poQczxxx.setSldw(dwdm);
                poQczxxx.setSlrid(user.getOtherParams().getLong("yhid"));
                // poQczxxx.setSldw(this.getUserInfo().getDwdm());
                // poQczxxx.setSlrid(this.getUserInfo().getYhid());
                poQczxxx.setSlsj(now);
                poQczxxx.setQcrq(now.substring(0, 8));

                poQczxxx.setKdqqy_dqbm(dwdm.substring(0, 4));
                poQczxxx.setKdqqy_yhid(user.getOtherParams().getLong("yhid"));
                poQczxxx.setKdqqy_yhm(user.getOtherParams().getString("yhxm"));
                poQczxxx.setKdqqy_cgbz("0");
                poQczxxx.setKdqqy_qrdqbm(dwdm);
                poQczxxx.setZqzbh(map.get(poQczxxx.getGmsfhm()));
                poQczxxx.setCxfldm(poJwhxxb.getCxfldm());
                poQczxxx.setQyzbh(qyzbh);

                HibernateUtil.create(session, poQczxxx);

                PoHJXX_CXSXBGB log = new PoHJXX_CXSXBGB();
                log.setBghcxsx(poQczxxx.getCxfldm());
                log.setBgqcxsx(poJwhxxb.getCxfldm());
                log.setCjsj(now);
                log.setSldw(poJwhxxb.getDwdm());
                log.setBgqdw(poJwhxxb.getDwdm());
                log.setRynbid(poQczxxx.getRynbid());
                log.setHjywid(poQczxxx.getHjywid());
                log.setBgyy(poQczxxx.getQclb());
                log.setYwlb("qwts");
                log.setBz("迁出注销");
                log.setRkbj("0");
                log.setSsxq(poQczxxx.getSsxq());
                log.setJwhdm(poJwhxxb.getDm());
                log.setRysl(new Long(1));
                HibernateUtil.create(session, log);

                // 生成迁出注销人员信息的户关系调整信息
                voHcygxtzxxEx[i] = new VoHcygxtzxxEx();
                voHcygxtzxxEx[i].setFlag(0);
                voHcygxtzxxEx[i].setHcybdlx(HjConstant.HCYBDLX_LH);
                voHcygxtzxxEx[i].setHcybdlb(voQczxxx.get(i).getQclb());
                voHcygxtzxxEx[i].setHhnbid(poRyxxNew.getHhnbid());
                voHcygxtzxxEx[i].setRynbid(poRyxx.getRynbid());
                voHcygxtzxxEx[i].setNew_rynbid(poRyxxNew.getRynbid());
                voHcygxtzxxEx[i].setRyid(poRyxxNew.getRyid());
                voHcygxtzxxEx[i].setGmsfhm(poRyxxNew.getGmsfhm());
                voHcygxtzxxEx[i].setXm(poRyxxNew.getXm());
                voHcygxtzxxEx[i].setOld_yhzgx(null);
                voHcygxtzxxEx[i].setYhzgx(poRyxxNew.getYhzgx());
                voHcygxtzxxEx[i].setSbhjywid(null);

                // 生成注销户信息
                voZxhxx[i] = new VoZxhxx();
                voZxhxx[i].setNew_hhnbid(null);
                voZxhxx[i].setOld_hhnbid(poRyxx.getHhnbid());

                // 人户分离信息消除
                String strHQL = new String();
                strHQL = "from PoHJXX_RHFLXXB as HJXX_RHFLXXB where rynbid=" + voQczxxx.get(i).getRynbid().toString();
                List rhflxxList = HibernateUtil.getObjectList(session, strHQL, null);
                if (rhflxxList != null) {
                    for (int j = 0; j < rhflxxList.size(); j++) {
                        PoHJXX_RHFLXXB poRhflxx = (PoHJXX_RHFLXXB) rhflxxList.get(j);
                        poRhflxx.setCchjywid(hjywid);
                        poRhflxx.setRhflzt(HjConstant.RHFLZT_HJQC);
                        HibernateUtil.update(session, poRhflxx);
                    }
                }

                // 重号信息消除
                strHQL = "from PoHJYW_CHCLXXB as HJYW_CHCLXXB where clfs='" + HjConstant.CHCLFS_WCL + "' and chsfhm='"
                        + poRyxx.getGmsfhm() + "' and cxbz='" + PublicConstant.CXBZ_FCX + "' ";
                List chxxList = HibernateUtil.getObjectList(session, strHQL, null);
                if (chxxList != null) {
                    for (int j = 0; j < chxxList.size(); j++) {
                        PoHJYW_CHCLXXB poChclxx = (PoHJYW_CHCLXXB) chxxList.get(j);
                        // 与别人重
                        if (poRyxx.getRyid().equals(poChclxx.getRyid())) {
                            poChclxx.setCxbz(PublicConstant.CXBZ_FCX);
                            poChclxx.setClfs(HjConstant.CHCLFS_BRQC);
                            poChclxx.setClhjywid(hjywid);
                            HibernateUtil.update(session, poChclxx);
                        }
                        // 别人与自己重
                        if (poRyxx.getRyid().equals(poChclxx.getBchryid())) {
                            poChclxx.setClfs(HjConstant.CHCLFS_DFQC);
                            poChclxx.setClhjywid(hjywid);

                            HibernateUtil.update(session, poChclxx);
                        }
                    } // for (int j = 0; j < chxxList.size(); j++)
                }

                // 生成人员变动信息(四变)
                VoRybdxx voRybdxx = new VoRybdxx();
                voRybdxx.setBdbid(poQczxxx.getQczxid());
                voRybdxx.setBdfw(poQczxxx.getBdfw());
                voRybdxx.setBdyy(poQczxxx.getQclb());
                voRybdxx.setQwdssxq(poQczxxx.getQwdssxq());
                voRybdxx.setQwdxz(poQczxxx.getQwdxz());
                voRybdxx.setBdrq(now.substring(0, 8)); // voRybdxx.setBdrq(poQczxxx.getQcrq());
                voRybdxx.setBdqhb(null);
                voRybdxx.setBdq_hhnbid(poRyxx.getHhnbid());
                voRybdxx.setBdh_hhnbid(null);
                voRybdxx.setRynbid(poRyxxNew.getRynbid());
                voRybdxx.setRzjs(new Long(-1));
                voRybdxx.setHzjs(new Long(0));
                rybdxxList.add(voRybdxx);

                // 组合迁出注销返回信息
                voQczxfhxx[i] = new VoQczxfhxx();
                voQczxfhxx[i].setRynbid(poRyxxNew.getRynbid());
                voQczxfhxx[i].setHhnbid(poRyxxNew.getHhnbid());
                voQczxfhxx[i].setRyid(poRyxxNew.getRyid());
                voQczxfhxx[i].setOld_rynbid(poRyxx.getRynbid());
                voQczxfhxx[i].setQczxid(poQczxxx.getQczxid());
                voQczxfhxx[i].setGmsfhm(poRyxxNew.getGmsfhm());
                voQczxfhxx[i].setXm(poRyxxNew.getXm());
                voQczxfhxx[i].setYhzgx(poRyxxNew.getYhzgx());
            }

            ////////////////////////////////////////
            // 调整户成员关系
            VoHcygxtzfhxx voh[] = YWUtils.adjustHCYGX(session, hjywid, voSbjbxx, voHcygxtzxxEx, now);
            if (voh != null) {
                for (int i = 0; i < voh.length; i++) {
                    hcygxtzfhxxList.add(voh[i]);
                }
            }

            ////////////////////////////////////////
            // 保存变更更正
            if (voBggzxxEx != null) {
                VoBggzfhxxEx vobEx = YWUtils.saveBGGZXX(session, hjywid, voSbjbxx,
                        voBggzxxEx.toArray(new VoBggzxxEx[]{}), PublicConstant.GNBH_HJ_QCZXYW, now);
                if (vobEx != null) {
                    if (vobEx.getVoBggzfhxx() != null) {
                        for (int a = 0; a < vobEx.getVoBggzfhxx().length; a++) {
                            bggzfhxxList.add(vobEx.getVoBggzfhxx()[a]);
                        }
                    } // if(vobEx!=null)
                    if (vobEx.getVoHcygxtzfhxx() != null) {
                        for (int a = 0; a < vobEx.getVoHcygxtzfhxx().length; a++) {
                            hcygxtzfhxxList.add(vobEx.getVoHcygxtzfhxx()[a]);
                        }
                    }
                } // if(vobEx!=null)
            }

            ///////////////////////////////////////////
            // 全户迁出则注销户
            List zxhhnbidList = YWUtils.logoutH(session, hjywid, voZxhxx, voQczxxx.get(0).getBdfw(),
                    voQczxxx.get(0).getQclb(), HjConstant.YWNR_QCZX, now);

            ///////////////////////////////
            // 校验户主数量
            Map hhnbidMap = new HashMap();
            for (int h = 0; h < hcygxtzfhxxList.size(); h++) {
                VoHcygxtzfhxx vo = (VoHcygxtzfhxx) hcygxtzfhxxList.get(h);
                hhnbidMap.put(vo.getHhnbid(), null);
            }
            // 排除注销的户号内部ID
            if (zxhhnbidList != null) {
                for (int h = 0; h < zxhhnbidList.size(); h++) {
                    hhnbidMap.remove(zxhhnbidList.get(h));
                }
            }
            for (Iterator itr = hhnbidMap.keySet().iterator(); itr.hasNext(); ) {
                YWUtils.checkHCYXX(session, (Long) itr.next());
            }

            ////////////////////////////////////////
            // 保存户籍业务流水信息
            PoHJLS_HJYWLSB poHjywlsxx = YWUtils.saveHJYWLSXX(session, hjywid,
                    PublicConstant.GNBH_HJ_QCZXYW, zxhhnbidList != null && zxhhnbidList.size() > 0
                            ? PublicConstant.HJYWLS_YWLX_QH : PublicConstant.HJYWLS_YWLX_GR,
                    voQczxxx.size(), voSbjbxx, now);

            //跨地市迁出注销，生成迁移证
            if (qyzbh != null && qyzryList.size() > 0) {
                VoQyzbhhtxx[] voQyzbhhtxx = new VoQyzbhhtxx[qyzryList.size()];
                for (int i = 0; i < qyzryList.size(); i++) {
                    voQyzbhhtxx[i] = (VoQyzbhhtxx) qyzryList.get(i);
                }
                YWUtils.processQyzbhhtyw(user, session, voQyzbhhtxx);
            }

            //////////////////////////////////////////
            // 保存人员变动信息(四变)
            if (zxhhnbidList != null && zxhhnbidList.size() > 0) {
                for (int a = 0; a < zxhhnbidList.size(); a++) {
                    Long hhnbid = (Long) zxhhnbidList.get(a);
                    for (int b = 0; b < rybdxxList.size(); b++) {
                        VoRybdxx vo = (VoRybdxx) rybdxxList.get(b);
                        if (hhnbid.equals(vo.getBdq_hhnbid())) {
                            vo.setHzjs(new Long(-1));
                            break;
                        }
                    }
                }
            }
            YWUtils.saveRYBDXX(session, rybdxxList, poHjywlsxx);

            ///////////////////////////////////////////
            // 回填迁出注销业务表的户主信息及业务类型、操作数目字段
            PoHJXX_CZRKJBXXB poHzxx = null;
            String strHQL = "from PoHJYW_QCZXXXB where hjywid=" + hjywid;
            List qczxxxList = HibernateUtil.getObjectList(session, strHQL, null);
            if (qczxxxList != null && qczxxxList.size() > 0) {
                for (int i = 0; i < qczxxxList.size(); i++) {
                    PoHJYW_QCZXXXB poQczxxx = (PoHJYW_QCZXXXB) qczxxxList.get(i);
                    if (poHzxx == null) {
                        strHQL = "from PoHJXX_CZRKJBXXB where yhzgx < '10' and jlbz='" + PublicConstant.JLBZ_ZX
                                + "' and cxbz='" + PublicConstant.CXBZ_FCX + "' and hhnbid =" + poQczxxx.getHhnbid();
                        List hzxxList = HibernateUtil.getObjectList(session, strHQL, null);
                        poHzxx = YWUtils.findHZXX(session, hzxxList);
                    }
                    poQczxxx.setHzgmsfhm(poHzxx != null ? poHzxx.getGmsfhm() : null);
                    poQczxxx.setHzxm(poHzxx != null ? poHzxx.getXm() : null);
                    poQczxxx.setYwlx(poHjywlsxx.getYwlx());
                    poQczxxx.setCzsm(poHjywlsxx.getCzsm());
                    HibernateUtil.update(session, poQczxxx);
                }
            }
            ////////////////////////////////////

            // 生成返回信息
            voQczxywfhxx = new VoQczxywfhxx();
            voQczxywfhxx.setHjywid(hjywid);
            voQczxywfhxx.setVoQczxfhxx(voQczxfhxx);
            voQczxywfhxx.setVoBggzfhxx((VoBggzfhxx[]) bggzfhxxList.toArray(new VoBggzfhxx[bggzfhxxList.size()]));
            voQczxywfhxx.setVoHcygxtzfhxx(
                    (VoHcygxtzfhxx[]) hcygxtzfhxxList.toArray(new VoHcygxtzfhxx[hcygxtzfhxxList.size()]));
            voQczxywfhxx.setQwdq(qcdqbm);
            voQczxywfhxx.setQcdq(qcdqbm);

            //创建反馈，防止迁出成功，但是迁入地没有同步
            PoPOST_KDQCFKB fk = new PoPOST_KDQCFKB();
            fk.setFkbz("0");
            fk.setQrdq(todq);
            fk.setSpywid(spyw.getSpywid().toString());
            fk.setCxfldm(cxfldm);
            fk.setQyzbh(qyzbh_old);
            HibernateUtil.create(session, fk);

            tran.commit();
        } catch (Exception e) {
            tran.rollback();

            if (session2 != null)
                session2.close();

            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }

        //处理迁入地审批业务
        try {
            session2 = HibernateUtil.getSystemSessionFactory(todq).openSession();
            if (session2 == null)
                throw new ServiceException("数据库不支持此地区！");

            tran2 = session2.beginTransaction();

            list_hjspzb = HibernateUtil.getObjectList(session2, "from PoHJSP_HJSPZB a where a.spywid=" + spywid, new Object[]{});
            spyw = (PoHJSP_HJSPSQB) HibernateUtil.getObject(session2, "from PoHJSP_HJSPSQB a where a.spywid=" + spywid, new Object[]{});
            spyw.setKdqqy_fksj(DateHelper.formateDate("yyyyMMddHHmmss"));
            spyw.setKdqqy_fkzt("2");
            spyw.setKdqqy_fknr("已迁出");
            spyw.setKdqqy_qyzbh(qyzbh_old);
            spyw.setKdqqy_lscxfldm(cxfldm);

            HibernateUtil.update(session2, spyw);

            for (PoHJSP_HJSPZB z : list_hjspzb) {
                z.setKdqqy_fksj(DateHelper.formateDate("yyyyMMddHHmmss"));
                z.setKdqqy_fkzt("2");
                z.setKdqqy_fknr("已迁出");
                z.setKdqqy_qyzbh(qyzbh_old);
                z.setKdqqy_lscxfldm(cxfldm);
                HibernateUtil.update(session2, z);
            }
            tran2.commit();
        } catch (Exception e) {
            tran2.rollback();
            throw new ServiceException(e);
        } finally {
            if (session2 != null)
                session2.close();
        }

        return voQczxywfhxx;
    }


    public VoQczxywfhxx saveKdsQcQxgl(BaseUser user, String qcdqbm, List<VoBggzxxEx> voBggzxxEx, List<VoQczxxx> voQczxxx,
                                      VoSbjbxx voSbjbxx, ExtMap<String, Object> params) {
        String todq = params.getString("todq");
        String sqr_gmsfhm = params.getString("sqr_gmsfhm");
        String ywlsh = params.getString("ywlsh");

//		todq = "3402";
//		spywid = "3405000001000000015";

        if (CommonUtil.isEmpty(qcdqbm) || CommonUtil.isEmpty(todq) || CommonUtil.isEmpty(sqr_gmsfhm))
            throw new ServiceException("必须提供参数qcdqbm,todq,sqr_gmsfhm，指定迁出信息！");

        if (voSbjbxx == null)
            throw new ServiceException("申报人不能为空！");

        if (voQczxxx == null || voQczxxx.size() <= 0)
            throw new ServiceException("迁出人员不能为空！");

        VoQczxywfhxx voQczxywfhxx = null;
        VoQczxfhxx voQczxfhxx[] = null;
        VoHcygxtzxxEx voHcygxtzxxEx[] = null;
        List bggzfhxxList = new ArrayList();
        List hcygxtzfhxxList = new ArrayList();
        List rybdxxList = new ArrayList();
        VoQyzbhhtxx qyzdyxx = null;
        VoZxhxx voZxhxx[] = null;
        Long hjywid = null;
        String qyzdyxx_yhzgx = null;
        Long qyzdyxx_rynbid = null;
        PoXT_JWHXXB poJwhxxb = null;
        String qyzbh = null;
        String qyzbh_old = null;
        String cxfldm = null;
        //PoHJXX_MLPXXXXB poMlpxxxx_QR = null;

        if (voQczxxx == null || (voQczxxx != null && voQczxxx.size() <= 0)) {
            return null;
        }

        List<ZjywZqzQyrxx> list_hjspzb = null;
        ZjywZqzxx spyw = null;
        Map<String, String> map = new HashMap<String, String>();

        Transaction tran2 = null;
        Session session2 = null;
        try {
            session2 = HibernateUtil.getSystemSessionFactory(todq).openSession();
            if (session2 == null)
                throw new ServiceException("数据库不支持此地区！");

            spyw = (ZjywZqzxx) super.getObject("from ZjywZqzxx a where a.ywlsh='" + ywlsh+"'", null);
            list_hjspzb = super.getObjectListByHql("from ZjywZqzQyrxx a where a.ywlsh=" + "'" + ywlsh + "'", null);

            for (ZjywZqzQyrxx z : list_hjspzb) {
                map.put(z.getGmsfhm(), z.getZqzbh());
            }
        } catch (Exception e) {
            if (session2 != null)
                session2.close();
            throw new ServiceException(e);
        } finally {
        }

        Transaction tran = null;
        Session session = null;
        List qyzryList = new ArrayList();
        try {
            //获取迁移证
            String year = DateHelper.formateDate("yyyy");
            XT_ZQZ_QYZ_XLH xlh = this.requestXLH("", year, "qyz");
            String str = xlh.getZjbh().toString();
            if (str.length() < 5)
                str = "00000".substring(0, 5 - str.length()) + str;


            //获取迁移证
            //qyzbh = "皖" + year.substring(year.length() - 1, year.length()) + DateHelper.formateDate("MM") + str;
            /*
             * add by zjm 
             * 20210305
             * 修改迁移证编号赋值规则，改为首字母固定写死，然后后七位从1000开始
             * 
             */
            XT_ZQZ_QYZ_XLH xlhqyz = this.requestXLH("", "6", "qyz");
            String qyzbhSer = xlhqyz.getZjbh().toString();
            if (qyzbhSer.length() < 7)
				qyzbhSer = "0000000".substring(0, 7 - qyzbhSer.length()) + qyzbhSer;
			qyzbh = "皖" +"6"+qyzbhSer+"";
			System.out.println("迁移证编号为：" + qyzbh);
			
            session = HibernateUtil.getSystemSessionFactory(qcdqbm).openSession();
			
            if (session == null)
                throw new ServiceException("数据库不支持此地区！");

            tran = session.beginTransaction();

//			String oldSQL = "from PoPOST_KDQCFKB a where a.spywid='" + spyw.getSpywid() + "' and a.qrdq='" + todq + "'";
//
//			Object obj = HibernateUtil.getObject(session, oldSQL, new Object[]{});
//			if(obj!=null)
//				throw new ServiceException("此迁入审批已经完成迁出，不能再次处理！");

            String now = YWUtils.getServiceTime(session);

            if (voSbjbxx != null && voSbjbxx.getHzywid() != null) {
                List list = HibernateUtil.getObjectList(session, "from HzZjSb a where a.id=" + voSbjbxx.getHzywid(),
                        null);
                if (list.size() > 0) {
                    HzZjSb sb = (HzZjSb) list.get(0);
                    if (sb.getPch() != null && !sb.getPch().equals("")) {
                        // 一个批次，统一处理
                        System.out.println("迁出注销批量处理！");
                        list = HibernateUtil.getObjectList(session, "from HzZjSb a where a.pch='" + sb.getPch() + "'",
                                null);
                        int pccount = list.size();
                        for (int index = 0; index < pccount; index++) {
                            HzZjSb sbx = (HzZjSb) list.get(index);
                            sbx.setClbs("1");
                            sbx.setClsj(new Date());
                            HibernateUtil.update(session, sbx);
                        }
                    } else {
                        sb.setClbs("1");
                        sb.setClsj(new Date());
                        HibernateUtil.update(session, sb);
                    }
                }
            }

            /////////////////////////////////////
            // 得到户籍业务ID
            hjywid = (Long) YWUtils.getId(session, "SID_HJLS_HJYWLSB");
            //////////////////////////////////////////
            // 保存迁出注销信息
            voQczxfhxx = new VoQczxfhxx[voQczxxx.size()];
            voZxhxx = new VoZxhxx[voQczxxx.size()];
            voHcygxtzxxEx = new VoHcygxtzxxEx[voQczxxx.size()];
            for (int i = 0; i < voQczxxx.size(); i++) {
                //qyzbh = voQczxxx.get(i).getQyzbh();
                //qyzbh_old = qyzbh;
                // 得到人员信息
                PoHJXX_CZRKJBXXB poRyxx = HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class,
                        voQczxxx.get(i).getRynbid());
                if (poRyxx == null) {
                    throw new ServiceException("找不到迁出人员信息，迁出注销业务无法完成。");
                }

                // 校验人信息的时效性
                YWUtils.checkRXX(session, poRyxx, "迁出注销业务");
                // 人员锁定状态
                if (!HjConstant.RYSDZT_ZC.equals(poRyxx.getRysdzt())) {
                    throw new ServiceException("人员锁定状态为非正常(被锁定)，迁出注销业务无法完成，此人可能已经完成迁出。", null);
                }
                // 人员状态
                if (!HjConstant.RYZT_ZC.equals(poRyxx.getRyzt())) {
                    throw new ServiceException("人员状态为非正常，迁出注销业务无法完成，此人可能已经完成迁出。", null);
                }

                // 得到户信息
                PoHJXX_HXXB poHxx = HibernateUtil.get(session, PoHJXX_HXXB.class, poRyxx.getHhnbid());
                if (poHxx == null) {
                    throw new ServiceException("找不到迁出注销人员所在的户信息，迁出注销业务无法完成。", null);
                }

                // 得到地信息
                PoHJXX_MLPXXXXB poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poRyxx.getMlpnbid());
                if (poMlpxxxx == null) {
                    throw new ServiceException("找不到迁出注销人员所在的地信息，迁出注销业务无法完成。", null);
                }

                poJwhxxb = (PoXT_JWHXXB) HibernateUtil.get(session, PoXT_JWHXXB.class, poMlpxxxx.getJcwh());
                if (poJwhxxb == null) {
                    throw new ServiceException("找不到所在的地居委会，业务无法完成。", null);
                }

                cxfldm = poJwhxxb.getCxfldm();

                // 迁出注销业务判断
                if (PublicConstant.XTKZCS_QY.equals(YWUtils.getXTKZCS(session, PublicConstant.XTKZCS_SHQYZDQYPD))) {
                    if (YWUtils.checkZZBD(session, voQczxxx.get(i).getQwdssxq(), poMlpxxxx.getSsxq())) {
                        throw new ServiceException("迁入地和迁出地范围不符合迁出注销业务，迁出注销业务无法完成。", null);
                    }
                }

                // 数据范围限制
                /*
                 * List sjfwList = new ArrayList(); VoXtsjfw voXtsjfw = new
                 * VoXtsjfw(); voXtsjfw.setSjfw(poMlpxxxx.getJcwh());
                 * voXtsjfw.setSjfwbz(PublicConstant.XT_QX_JWH);
                 * sjfwList.add(voXtsjfw); boolean bLimit = false; bLimit =
                 * XtywqxServiceImpl.VerifyDataRange(this.getUserInfo().getYhid(
                 * ). toString(), PublicConstant.GNBH_HJ_QCZXYW, sjfwList); if
                 * (!bLimit) { throw new
                 * ServiceException(WSErrCode.ERR_SERVICE_BUSSINESSLIMIT,
                 * "数据范围被限制，迁出注销业务无法完成。", null); }
                 */

                // 保存人员信息为历史记录
                poRyxx.setJssj(now);
                poRyxx.setCchjywid(hjywid);
                poRyxx.setJlbz(PublicConstant.JLBZ_LS);
                HibernateUtil.update(session, poRyxx);

                // 保存人员信息为新记录
                PoHJXX_CZRKJBXXB poRyxxNew = new PoHJXX_CZRKJBXXB();
                BeanUtils.copyProperties(poRyxxNew, poRyxx);
                BeanUtils.copyProperties(poRyxxNew, voQczxxx.get(i));
                poRyxxNew.setQczxlb(voQczxxx.get(i).getQclb());
                // SID_HJXX_CZRKJBXXB
                Long rynbid = (Long) YWUtils.getId(session, "SID_HJXX_CZRKJBXXB");
                poRyxxNew.setRynbid(rynbid);
                // 处理poRyxxNew变更更正信息begin
                if (voBggzxxEx != null) {
                    for (int k = 0; k < voBggzxxEx.size(); k++) {
                        if (voQczxxx.get(i).getRynbid().equals(voBggzxxEx.get(k).getRynbid())) {
                            voBggzxxEx.get(k).setFlag(0); //// 是否需要修改常住人口信息表中的对应记录(0-不修改/1-修改)
                            VoBggzfhxxEx vobEx = YWUtils.disposalBggzxx(session, hjywid, voSbjbxx, voBggzxxEx.get(k),
                                    poRyxxNew, PublicConstant.GNBH_HJ_QCZXYW, now);
                            if (vobEx != null) {
                                if (vobEx.getVoBggzfhxx() != null) {
                                    for (int a = 0; a < vobEx.getVoBggzfhxx().length; a++) {
                                        bggzfhxxList.add(vobEx.getVoBggzfhxx()[a]);
                                    }
                                } // if(vobEx!=null)
                                if (vobEx.getVoHcygxtzfhxx() != null) {
                                    for (int a = 0; a < vobEx.getVoHcygxtzfhxx().length; a++) {
                                        hcygxtzfhxxList.add(vobEx.getVoHcygxtzfhxx()[a]);
                                    }
                                }
                            } // if(vobEx!=null)
                        } // if(voHbbgxx[i].getRynbid().equals(voBggzxx[k].getRynbid()))
                    } // for(int k=0;k<voBggzxx.length;k++)
                }
                // end

                // 人员状态_出国定居
                if (HjConstant.QCZXLB_CGDJ.equals(voQczxxx.get(i).getQclb())
                        || HjConstant.QCZXLB_QWGA.equals(voQczxxx.get(i).getQclb())
                        || HjConstant.QCZXLB_QWTW.equals(voQczxxx.get(i).getQclb())) {
                    poRyxxNew.setRyzt(HjConstant.RYZT_CGJDJ);
                }
                // 人员状态_服兵役
                else if (HjConstant.QCZXLB_CJFBY.equals(voQczxxx.get(i).getQclb())) {
                    poRyxxNew.setRyzt(HjConstant.RYZT_FBY);
                }
                // 人员状态_迁出注销
                else {
                    poRyxxNew.setRyzt(HjConstant.RYZT_QC);
                }

                poRyxxNew.setQysj(now);
                poRyxxNew.setJssj(null);
                poRyxxNew.setXxqysj(now);// add by hb 20061027
                poRyxxNew.setYwnr(HjConstant.YWNR_QCZX);
                poRyxxNew.setCchjywid(null);
                poRyxxNew.setCjhjywid(hjywid);
                poRyxxNew.setJlbz(PublicConstant.JLBZ_ZX);
                HibernateUtil.create(session, poRyxxNew);


                qyzdyxx = new VoQyzbhhtxx();
                qyzdyxx.setDysx(new Long(qyzryList.size() + 1)); //1 一户一证
                qyzdyxx.setHjywid(hjywid);
                qyzdyxx.setQfrq(CommonUtil.formatDate("yyyyMMdd"));
                qyzdyxx.setRynbid(poRyxxNew.getRynbid());
                qyzdyxx.setYczrgx(voQczxxx.get(i).getSbrjtgx());
                qyzdyxx.setYxqxjzrq("20300101");
                qyzdyxx.setYznf(CommonUtil.formatDate("yyyy"));
                if ("0123456789".indexOf(qyzbh.substring(0, 1)) < 0) {
                    qyzdyxx.setQyzbh(qyzbh.substring(1));
                }
                qyzryList.add(qyzdyxx);

                Long qcclid = (Long) YWUtils.getId(session, "SID_HJYW_QCCLXXB");
                PoHJYW_QCCLXXB poQcclxx = new PoHJYW_QCCLXXB();
                poQcclxx.setQcclid(qcclid);
                BeanUtils.copyProperties(poQcclxx, poRyxxNew);
                poQcclxx.setMlpnbid_q(poMlpxxxx.getMlpnbid());
                poQcclxx.setSsxq_q(poMlpxxxx.getSsxq());
                poQcclxx.setJlx_q(poMlpxxxx.getJlx());
                poQcclxx.setMlph_q(poMlpxxxx.getMlph());
                poQcclxx.setMlxz_q(poMlpxxxx.getMlxz());
                poQcclxx.setPcs_q(poMlpxxxx.getPcs());
                poQcclxx.setZrq_q(poMlpxxxx.getZrq());
                poQcclxx.setXzjd_q(poMlpxxxx.getXzjd());
                poQcclxx.setJcwh_q(poMlpxxxx.getJcwh());
                poQcclxx.setPxh_q(poMlpxxxx.getPxh());
                //poQcclxx.setMlpnbid_h(poMlpxxxx_QR.getMlpnbid());
                //poQcclxx.setPxh_h(spyw.getqrdp.getPxh());
                //poQcclxx.setZrq_h(spyw.getqrdzr.getZrq());

                //跨地市迁出，无法传值，就用迁出人
                poQcclxx.setMlpnbid_h(poMlpxxxx.getMlpnbid());
                poQcclxx.setPxh_h(poMlpxxxx.getPxh());
                poQcclxx.setZrq_h(poMlpxxxx.getZrq());

                poQcclxx.setSsxq_h(spyw.getQrd_ssxqdm());
                poQcclxx.setJlx_h("");
                poQcclxx.setMlph_h("");
                poQcclxx.setMlxz_h("");
                poQcclxx.setPcs_h(spyw.getQfjg_gajgjgdm());
                poQcclxx.setXzjd_h("");
                poQcclxx.setJcwh_h("");
                poQcclxx.setCxbz(PublicConstant.CXBZ_FCX);
                poQcclxx.setQqrynbid(0l);
                poQcclxx.setQhrynbid(poRyxxNew.getRynbid());
                poQcclxx.setCzlx(HjConstant.QCCL_CZXL_KDS);
                poQcclxx.setClbz(HjConstant.QCCL_CLBZ_WCL);
                poQcclxx.setHjywid(hjywid);
                HibernateUtil.create(session, poQcclxx);

                /*
                 * //业务限制处理 VoRhdxx voRhdxx = new VoRhdxx(poRyxxNew, poHxx,
                 * poMlpxxxx, this.getUserInfo()); VoXtywxz voLimit =
                 * XtywqxServiceImpl.VerifyBusinessLimit(PublicConstant.
                 * GNBH_HJ_QCZXYW, voRhdxx); if (voLimit.getLimitflag()) { throw
                 * new ServiceException(WSErrCode.ERR_SERVICE_BUSSINESSLIMIT,
                 * "迁出注销业务受限，受限信息：" + voLimit.getLimitinfo(), null); } voRhdxx =
                 * null;
                 */

                // 保存迁出注销信息
                PoHJYW_QCZXXXB poQczxxx = new PoHJYW_QCZXXXB();
                if (voSbjbxx != null) {
                    BeanUtils.copyProperties(poQczxxx, voSbjbxx);
                }
                BeanUtils.copyProperties(poQczxxx, voQczxxx.get(i));
                BeanUtils.copyProperties(poQczxxx, poRyxxNew);
                poQczxxx.setHhid(poHxx.getHhid());
                poQczxxx.setMlpid(poMlpxxxx.getMlpid());
                poQczxxx.setQczxid((Long) YWUtils.getId(session, "SID_HJYW_QCZXXXB"));
                poQczxxx.setCxbz(PublicConstant.CXBZ_FCX);
                poQczxxx.setHjywid(hjywid);
                String dwdm = "";
                if (user.getOtherParams() != null) {
                    dwdm = user.getOtherParams().getString("dwdm");
                    if (dwdm == null || dwdm.length() < 4)
                        throw new ServiceException("未知迁入地区！");
                }
//				String dwdm = user.getOtherParams().getString("dwdm");
//				if(dwdm==null || dwdm.length()<4)
//					throw new ServiceException("未知迁入地区！");
//				poQczxxx.setSldw(user.getOtherParams().getString("dwdm"));
                poQczxxx.setSldw(poMlpxxxx.getPcs());//20210306 kqt 分局管理员办理迁出有bug 报越界dwdm.substring(0, 9)
                poQczxxx.setSlrid(user.getOtherParams().getLong("yhid"));
                // poQczxxx.setSldw(this.getUserInfo().getDwdm());
                // poQczxxx.setSlrid(this.getUserInfo().getYhid());
                poQczxxx.setSlsj(now);
                poQczxxx.setQcrq(now.substring(0, 8));

                poQczxxx.setKdqqy_dqbm(dwdm.substring(0, 4));
                poQczxxx.setKdqqy_yhid(user.getOtherParams().getLong("yhid"));
                poQczxxx.setKdqqy_yhm(user.getOtherParams().getString("yhxm"));
                poQczxxx.setKdqqy_cgbz("0");
                poQczxxx.setKdqqy_qrdqbm(dwdm);
                poQczxxx.setZqzbh(map.get(poQczxxx.getGmsfhm()));
                poQczxxx.setCxfldm(poJwhxxb.getCxfldm());
                poQczxxx.setQyzbh(qyzbh);
                poQczxxx.setBz("长三角通办迁出注销");
                HibernateUtil.create(session, poQczxxx);

                PoHJXX_CXSXBGB log = new PoHJXX_CXSXBGB();
                log.setBghcxsx(poQczxxx.getCxfldm());
                log.setBgqcxsx(poJwhxxb.getCxfldm());
                log.setCjsj(now);
                log.setSldw(poJwhxxb.getDwdm());
                log.setBgqdw(poJwhxxb.getDwdm());
                log.setRynbid(poQczxxx.getRynbid());
                log.setHjywid(poQczxxx.getHjywid());
                log.setBgyy(poQczxxx.getQclb());
                log.setYwlb("qwts");
                log.setBz("迁出注销");
                log.setRkbj("0");
                log.setSsxq(poQczxxx.getSsxq());
                log.setJwhdm(poJwhxxb.getDm());
                log.setRysl(new Long(1));
                HibernateUtil.create(session, log);

                // 生成迁出注销人员信息的户关系调整信息
                voHcygxtzxxEx[i] = new VoHcygxtzxxEx();
                voHcygxtzxxEx[i].setFlag(0);
                voHcygxtzxxEx[i].setHcybdlx(HjConstant.HCYBDLX_LH);
                voHcygxtzxxEx[i].setHcybdlb(voQczxxx.get(i).getQclb());
                voHcygxtzxxEx[i].setHhnbid(poRyxxNew.getHhnbid());
                voHcygxtzxxEx[i].setRynbid(poRyxx.getRynbid());
                voHcygxtzxxEx[i].setNew_rynbid(poRyxxNew.getRynbid());
                voHcygxtzxxEx[i].setRyid(poRyxxNew.getRyid());
                voHcygxtzxxEx[i].setGmsfhm(poRyxxNew.getGmsfhm());
                voHcygxtzxxEx[i].setXm(poRyxxNew.getXm());
                voHcygxtzxxEx[i].setOld_yhzgx(null);
                voHcygxtzxxEx[i].setYhzgx(poRyxxNew.getYhzgx());
                voHcygxtzxxEx[i].setSbhjywid(null);

                // 生成注销户信息
                voZxhxx[i] = new VoZxhxx();
                voZxhxx[i].setNew_hhnbid(null);
                voZxhxx[i].setOld_hhnbid(poRyxx.getHhnbid());

                // 人户分离信息消除
                String strHQL = new String();
                strHQL = "from PoHJXX_RHFLXXB as HJXX_RHFLXXB where rynbid=" + voQczxxx.get(i).getRynbid().toString();
                List rhflxxList = HibernateUtil.getObjectList(session, strHQL, null);
                if (rhflxxList != null) {
                    for (int j = 0; j < rhflxxList.size(); j++) {
                        PoHJXX_RHFLXXB poRhflxx = (PoHJXX_RHFLXXB) rhflxxList.get(j);
                        poRhflxx.setCchjywid(hjywid);
                        poRhflxx.setRhflzt(HjConstant.RHFLZT_HJQC);
                        HibernateUtil.update(session, poRhflxx);
                    }
                }

                // 重号信息消除
                strHQL = "from PoHJYW_CHCLXXB as HJYW_CHCLXXB where clfs='" + HjConstant.CHCLFS_WCL + "' and chsfhm='"
                        + poRyxx.getGmsfhm() + "' and cxbz='" + PublicConstant.CXBZ_FCX + "' ";
                List chxxList = HibernateUtil.getObjectList(session, strHQL, null);
                if (chxxList != null) {
                    for (int j = 0; j < chxxList.size(); j++) {
                        PoHJYW_CHCLXXB poChclxx = (PoHJYW_CHCLXXB) chxxList.get(j);
                        // 与别人重
                        if (poRyxx.getRyid().equals(poChclxx.getRyid())) {
                            poChclxx.setCxbz(PublicConstant.CXBZ_FCX);
                            poChclxx.setClfs(HjConstant.CHCLFS_BRQC);
                            poChclxx.setClhjywid(hjywid);
                            HibernateUtil.update(session, poChclxx);
                        }
                        // 别人与自己重
                        if (poRyxx.getRyid().equals(poChclxx.getBchryid())) {
                            poChclxx.setClfs(HjConstant.CHCLFS_DFQC);
                            poChclxx.setClhjywid(hjywid);

                            HibernateUtil.update(session, poChclxx);
                        }
                    } // for (int j = 0; j < chxxList.size(); j++)
                }

                // 生成人员变动信息(四变)
                VoRybdxx voRybdxx = new VoRybdxx();
                voRybdxx.setBdbid(poQczxxx.getQczxid());
                voRybdxx.setBdfw(poQczxxx.getBdfw());
                voRybdxx.setBdyy(poQczxxx.getQclb());
                voRybdxx.setQwdssxq(poQczxxx.getQwdssxq());
                voRybdxx.setQwdxz(poQczxxx.getQwdxz());
                voRybdxx.setBdrq(now.substring(0, 8)); // voRybdxx.setBdrq(poQczxxx.getQcrq());
                voRybdxx.setBdqhb(null);
                voRybdxx.setBdq_hhnbid(poRyxx.getHhnbid());
                voRybdxx.setBdh_hhnbid(null);
                voRybdxx.setRynbid(poRyxxNew.getRynbid());
                voRybdxx.setRzjs(new Long(-1));
                voRybdxx.setHzjs(new Long(0));
                rybdxxList.add(voRybdxx);

                // 组合迁出注销返回信息
                voQczxfhxx[i] = new VoQczxfhxx();
                voQczxfhxx[i].setRynbid(poRyxxNew.getRynbid());
                voQczxfhxx[i].setHhnbid(poRyxxNew.getHhnbid());
                voQczxfhxx[i].setRyid(poRyxxNew.getRyid());
                voQczxfhxx[i].setOld_rynbid(poRyxx.getRynbid());
                voQczxfhxx[i].setQczxid(poQczxxx.getQczxid());
                voQczxfhxx[i].setGmsfhm(poRyxxNew.getGmsfhm());
                voQczxfhxx[i].setXm(poRyxxNew.getXm());
                voQczxfhxx[i].setYhzgx(poRyxxNew.getYhzgx());
            }

            ////////////////////////////////////////
            // 调整户成员关系
            VoHcygxtzfhxx voh[] = YWUtils.adjustHCYGX(session, hjywid, voSbjbxx, voHcygxtzxxEx, now);
            if (voh != null) {
                for (int i = 0; i < voh.length; i++) {
                    hcygxtzfhxxList.add(voh[i]);
                }
            }

            ////////////////////////////////////////
            // 保存变更更正
            if (voBggzxxEx != null) {
                VoBggzfhxxEx vobEx = YWUtils.saveBGGZXX(session, hjywid, voSbjbxx,
                        voBggzxxEx.toArray(new VoBggzxxEx[]{}), PublicConstant.GNBH_HJ_QCZXYW, now);
                if (vobEx != null) {
                    if (vobEx.getVoBggzfhxx() != null) {
                        for (int a = 0; a < vobEx.getVoBggzfhxx().length; a++) {
                            bggzfhxxList.add(vobEx.getVoBggzfhxx()[a]);
                        }
                    } // if(vobEx!=null)
                    if (vobEx.getVoHcygxtzfhxx() != null) {
                        for (int a = 0; a < vobEx.getVoHcygxtzfhxx().length; a++) {
                            hcygxtzfhxxList.add(vobEx.getVoHcygxtzfhxx()[a]);
                        }
                    }
                } // if(vobEx!=null)
            }

            ///////////////////////////////////////////
            // 全户迁出则注销户
            List zxhhnbidList = YWUtils.logoutH(session, hjywid, voZxhxx, voQczxxx.get(0).getBdfw(),
                    voQczxxx.get(0).getQclb(), HjConstant.YWNR_QCZX, now);

            ///////////////////////////////
            // 校验户主数量
            Map hhnbidMap = new HashMap();
            for (int h = 0; h < hcygxtzfhxxList.size(); h++) {
                VoHcygxtzfhxx vo = (VoHcygxtzfhxx) hcygxtzfhxxList.get(h);
                hhnbidMap.put(vo.getHhnbid(), null);
            }
            // 排除注销的户号内部ID
            if (zxhhnbidList != null) {
                for (int h = 0; h < zxhhnbidList.size(); h++) {
                    hhnbidMap.remove(zxhhnbidList.get(h));
                }
            }
            for (Iterator itr = hhnbidMap.keySet().iterator(); itr.hasNext(); ) {
                YWUtils.checkHCYXX(session, (Long) itr.next());
            }

            ////////////////////////////////////////
            // 保存户籍业务流水信息
            PoHJLS_HJYWLSB poHjywlsxx = YWUtils.saveHJYWLSXX(session, hjywid,
                    PublicConstant.GNBH_HJ_QCZXYW, zxhhnbidList != null && zxhhnbidList.size() > 0
                            ? PublicConstant.HJYWLS_YWLX_QH : PublicConstant.HJYWLS_YWLX_GR,
                    voQczxxx.size(), voSbjbxx, now);

            //跨地市迁出注销，生成迁移证
            if (qyzbh != null && qyzryList.size() > 0) {
                VoQyzbhhtxx[] voQyzbhhtxx = new VoQyzbhhtxx[qyzryList.size()];
                for (int i = 0; i < qyzryList.size(); i++) {
                    voQyzbhhtxx[i] = (VoQyzbhhtxx) qyzryList.get(i);
                }
                YWUtils.processQyzbhhtyw(user, session, voQyzbhhtxx);
            }

            //////////////////////////////////////////
            // 保存人员变动信息(四变)
            if (zxhhnbidList != null && zxhhnbidList.size() > 0) {
                for (int a = 0; a < zxhhnbidList.size(); a++) {
                    Long hhnbid = (Long) zxhhnbidList.get(a);
                    for (int b = 0; b < rybdxxList.size(); b++) {
                        VoRybdxx vo = (VoRybdxx) rybdxxList.get(b);
                        if (hhnbid.equals(vo.getBdq_hhnbid())) {
                            vo.setHzjs(new Long(-1));
                            break;
                        }
                    }
                }
            }
            YWUtils.saveRYBDXX(session, rybdxxList, poHjywlsxx);

            ///////////////////////////////////////////
            // 回填迁出注销业务表的户主信息及业务类型、操作数目字段
            PoHJXX_CZRKJBXXB poHzxx = null;
            String strHQL = "from PoHJYW_QCZXXXB where hjywid=" + hjywid;
            List qczxxxList = HibernateUtil.getObjectList(session, strHQL, null);
            if (qczxxxList != null && qczxxxList.size() > 0) {
                for (int i = 0; i < qczxxxList.size(); i++) {
                    PoHJYW_QCZXXXB poQczxxx = (PoHJYW_QCZXXXB) qczxxxList.get(i);
                    if (poHzxx == null) {
                        strHQL = "from PoHJXX_CZRKJBXXB where yhzgx < '10' and jlbz='" + PublicConstant.JLBZ_ZX
                                + "' and cxbz='" + PublicConstant.CXBZ_FCX + "' and hhnbid =" + poQczxxx.getHhnbid();
                        List hzxxList = HibernateUtil.getObjectList(session, strHQL, null);
                        poHzxx = YWUtils.findHZXX(session, hzxxList);
                    }
                    poQczxxx.setHzgmsfhm(poHzxx != null ? poHzxx.getGmsfhm() : null);
                    poQczxxx.setHzxm(poHzxx != null ? poHzxx.getXm() : null);
                    poQczxxx.setYwlx(poHjywlsxx.getYwlx());
                    poQczxxx.setCzsm(poHjywlsxx.getCzsm());
                    HibernateUtil.update(session, poQczxxx);
                }
            }
            ////////////////////////////////////

            // 生成返回信息
            voQczxywfhxx = new VoQczxywfhxx();
            voQczxywfhxx.setHjywid(hjywid);
            voQczxywfhxx.setVoQczxfhxx(voQczxfhxx);
            voQczxywfhxx.setVoBggzfhxx((VoBggzfhxx[]) bggzfhxxList.toArray(new VoBggzfhxx[bggzfhxxList.size()]));
            voQczxywfhxx.setVoHcygxtzfhxx(
                    (VoHcygxtzfhxx[]) hcygxtzfhxxList.toArray(new VoHcygxtzfhxx[hcygxtzfhxxList.size()]));
            voQczxywfhxx.setQwdq(qcdqbm);
            voQczxywfhxx.setQcdq(qcdqbm);

			/*//创建反馈，防止迁出成功，但是迁入地没有同步
			PoPOST_KDQCFKB fk = new PoPOST_KDQCFKB();
			fk.setFkbz("0");
			fk.setQrdq(todq);
			fk.setSpywid("");
			fk.setCxfldm(cxfldm);
			fk.setQyzbh(qyzbh_old);
			HibernateUtil.create(session, fk);*/
            //迁出成功  将一网通准迁证信息表是否办结状态修改
            spyw.setSfbj("1");
            super.saveOrUpdate(spyw);

            tran.commit();
        } catch (Exception e) {
            tran.rollback();

            if (session2 != null)
                session2.close();

            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }

		/*//处理迁入地审批业务
		try {
			session2 = HibernateUtil.getSystemSessionFactory(todq).openSession();
			if (session2 == null)
				throw new ServiceException("数据库不支持此地区！");

			tran2 = session2.beginTransaction();

			list_hjspzb = HibernateUtil.getObjectList(session2, "from PoHJSP_HJSPZB a where a.spywid=" + spywid, new Object[]{});
			spyw = (PoHJSP_HJSPSQB)HibernateUtil.getObject(session2,  "from PoHJSP_HJSPSQB a where a.spywid=" + spywid, new Object[]{});
			spyw.setKdqqy_fksj( DateHelper.formateDate("yyyyMMddHHmmss"));
			spyw.setKdqqy_fkzt("2");
			spyw.setKdqqy_fknr("已迁出");
			spyw.setKdqqy_qyzbh(qyzbh_old);
			spyw.setKdqqy_lscxfldm(cxfldm);

			HibernateUtil.update(session2, spyw);

			for(PoHJSP_HJSPZB z:list_hjspzb){
				z.setKdqqy_fksj(DateHelper.formateDate("yyyyMMddHHmmss"));
				z.setKdqqy_fkzt("2");
				z.setKdqqy_fknr("已迁出");
				z.setKdqqy_qyzbh(qyzbh_old);
				z.setKdqqy_lscxfldm(cxfldm);
				HibernateUtil.update(session2, z);
			}
			tran2.commit();
		} catch (Exception e) {
			tran2.rollback();
			throw new ServiceException(e);
		} finally {
			if (session2 != null)
				session2.close();
		}*/

        return voQczxywfhxx;
    }

    /**
     * 迁入审批登记业务
     *
     * @param spsm        - 审批说明
     * @param voQrspdjxx  - 迁入审批登记信息(主迁人员信息)
     * @param voQrspdjzxx - 迁入审批登记子信息(随迁人员信息)
     * @param voSpfdclxx  - 审批附带材料信息
     * @return - 迁入审批登记业务返回信息
     * @throws DAOException
     * @throws ServiceException
     */
    public VoQrspdjywfhxx saveKdsQcEnd(BaseUser user, String hjywid, String qcdq, String spsm, VoQrspdjxx voQrspdjxx, VoQrspdjzxx voQrspdjzxx[],
                                       VoSpfdclxx voSpfdclxx[]) {

        VoQrspdjywfhxx voQrspdjywfhxx = null;
        VoQrspdjzfhxx voQrspdjzfhxx[] = null; // 迁入审批登记子返回信息(随迁人员登记返回信息)
        String strHQL = null;
        Long spmbid = null;

        if (voQrspdjxx == null) {
            return null;
        }

        Transaction tran = null;
        Session session = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
            if (session == null)
                throw new ServiceException("数据库不支持此地区！");

            tran = session.beginTransaction();
            String now = YWUtils.getServiceTime(session);

            /////////////////////////////////////////////
            // 事务开始
            tran.begin();

            if (voQrspdjxx != null && voQrspdjxx.getHzywid() != null && !voQrspdjxx.getHzywid().equals("")) {
                List list = HibernateUtil.getObjectList(session, "from HzZjSb a where a.id=" + voQrspdjxx.getHzywid(), null);
                if (list.size() > 0) {
                    HzZjSb sb = (HzZjSb) list.get(0);
                    sb.setClbs("1");
                    sb.setClsj(new Date());
                    HibernateUtil.update(session, sb);
                }
            }

            //////////////////////////////////////////////
            // 业务审批限制
            VoXtywxz voLimit = SpywUtils.VerifyCheckLimit(session, PublicConstant.GNBH_SP_QRSPDJYW, voQrspdjxx);
            if (voLimit.getLimitflag()) {
                spmbid = voLimit.getSpmbid();
            }

            ///////////////////////////////////////////////
            // 得到流程模板信息
            PoXT_MBLCXXB poMblcxx = null;
            if (spmbid != null) {
                strHQL = "from PoXT_MBLCXXB where (dzbz='" + HjConstant.DZBZ_DYB + "' or dzbz='" + HjConstant.DZBZ_QSB
                        + "') and spmbid=" + spmbid;
                List mblcxxList = HibernateUtil.getObjectList(session, strHQL, null);
                if (mblcxxList != null && mblcxxList.size() > 0) {
                    poMblcxx = (PoXT_MBLCXXB) mblcxxList.get(0);
                }
                if (poMblcxx == null) {
                    throw new ServiceException("找不到对应的人审批流程信息,迁入审批登记业务无法完成.",
                            null);
                }
            } // if (spmbid != null) {

            ////////////////////////////////////////////////
            // 保存主迁人员信息
            PoHJSP_HJSPSQB poHjspsqxx = null;
            poHjspsqxx = new PoHJSP_HJSPSQB();
            BeanUtils.copyProperties(poHjspsqxx, voQrspdjxx);
            poHjspsqxx.setSpywid((Long) YWUtils.getId(session, "SID_HJSP_HJSPSQB"));
            poHjspsqxx.setLsbz(HjConstant.LSBZ_WLS);
            poHjspsqxx.setDjrid(user.getOtherParams().getLong("yhid"));
            poHjspsqxx.setDjsj(now);
            poHjspsqxx.setSpmbid(spmbid);
            poHjspsqxx.setXydzid(poMblcxx != null ? poMblcxx.getDzid() : null); // 操作员自审批
            poHjspsqxx.setSpjg(spmbid == null ? HjConstant.SPJG_TY : null); // 操作员自审批
            poHjspsqxx.setSpsm(spsm);
            poHjspsqxx.setSlrq(now.substring(0, 8));
            poHjspsqxx.setKdqqy_qcdqbm(qcdq);
            poHjspsqxx.setKdqqy_qchjywid(hjywid);

            PoXT_JWHXXB poXT_JWHXXB = (PoXT_JWHXXB) HibernateUtil.get(session, PoXT_JWHXXB.class, poHjspsqxx.getQrdjwh()); // 通过居委会代码得到乡镇街道代码
            poHjspsqxx.setCxfldm(poXT_JWHXXB.getCxfldm());
            HibernateUtil.create(session, poHjspsqxx);

            // 保存主迁人信息到随迁人员信息表中
            PoHJSP_HJSPZB poHjspzxx = new PoHJSP_HJSPZB();
            poHjspzxx.setRyid(poHjspsqxx.getRyid());
            poHjspzxx.setXm(poHjspsqxx.getXm());
            poHjspzxx.setXb(poHjspsqxx.getXb());
            poHjspzxx.setCsrq(poHjspsqxx.getCsrq());
            poHjspzxx.setMz(poHjspsqxx.getMz());// add by hubin 20121018
            poHjspzxx.setGmsfhm(poHjspsqxx.getGmsfhm());
            poHjspzxx.setYsqrgx(poHjspsqxx.getYsqrgx());
            poHjspzxx.setYhkqx(poHjspsqxx.getZzssxq());
            poHjspzxx.setYhkszd(poHjspsqxx.getZzxz());
            poHjspzxx.setQrhhb(poHjspsqxx.getQrhhb()); // add by mhb 2004/12/24
            // 12:57:00
            poHjspzxx.setHkxz(poHjspsqxx.getHb());
            poHjspzxx.setGzdw(poHjspsqxx.getYrdwjcyrysj());
            poHjspzxx.setRynbid(poHjspsqxx.getRynbid());
            poHjspzxx.setSpsqzid((Long) YWUtils.getId(session, "SID_HJSP_HJSPZB"));
            poHjspzxx.setSpywid(poHjspsqxx.getSpywid());
            HibernateUtil.create(session, poHjspzxx);

            ///////////////////////////////////////////////
            // 保存随迁人员信息
            if (voQrspdjzxx != null && voQrspdjzxx.length > 0) {
                voQrspdjzfhxx = new VoQrspdjzfhxx[voQrspdjzxx.length];
                for (int i = 0; i < voQrspdjzxx.length; i++) {
                    poHjspzxx = new PoHJSP_HJSPZB();
                    BeanUtils.copyProperties(poHjspzxx, voQrspdjzxx[i]);
                    poHjspzxx.setSpsqzid((Long) YWUtils.getId(session, "SID_HJSP_HJSPZB"));
                    poHjspzxx.setSpywid(poHjspsqxx.getSpywid());
                    HibernateUtil.create(session, poHjspzxx);

                    // 生成随迁人员返回信息
                    voQrspdjzfhxx[i] = new VoQrspdjzfhxx();
                    voQrspdjzfhxx[i].setGmsfhm(poHjspzxx.getGmsfhm());
                    voQrspdjzfhxx[i].setXm(poHjspzxx.getXm());
                    voQrspdjzfhxx[i].setSpsqzid(poHjspzxx.getSpsqzid());
                }
            }

            // 保存审批附带材料
            if (voSpfdclxx != null && voSpfdclxx.length > 0) {
                for (int i = 0; i < voSpfdclxx.length; i++) {
                    PoHJSP_HJSPFDCLB poSpfdclxx = new PoHJSP_HJSPFDCLB();
                    poSpfdclxx.setSpclid((Long) YWUtils.getId(session, "SID_HJSP_HJSPFDCLB"));
                    poSpfdclxx.setSpywid(poHjspsqxx.getSpywid());
                    poSpfdclxx.setSplx(poHjspsqxx.getSplx());
                    poSpfdclxx.setClbh(voSpfdclxx[i].getClbh());
                    HibernateUtil.create(session, poSpfdclxx);
                }
            }

            // 操作员自审批
            Long zqid = null;
            if (spmbid == null) {
                zqid = saveZQZXX(user, session, poHjspsqxx);
            }

            ///////////////////////////////////////////////////////
            // 保存户籍审批流水信息
            Long splsid = null;
            if (spmbid == null) { // 操作员自审批
                splsid = this.saveHJSPLSXX(user, session, poHjspsqxx.getSpywid(), poHjspsqxx.getSplx(), null, HjConstant.CZJG_TY, null, now);
            }

            // 审批模板当前使用数增加1
            YWUtils.incSPMBDQSYS(session, spmbid);

            //////////////////////////////////////////////
            // 生成业务返回信息
            voQrspdjywfhxx = new VoQrspdjywfhxx();
            voQrspdjywfhxx.setSplsid(splsid);
            voQrspdjywfhxx.setGmsfhm(poHjspsqxx.getGmsfhm());
            voQrspdjywfhxx.setSpywid(poHjspsqxx.getSpywid());
            voQrspdjywfhxx.setXm(poHjspsqxx.getXm());
            voQrspdjywfhxx.setZqid(zqid);
            voQrspdjywfhxx.setVoQrspdjzfhxx(voQrspdjzfhxx);

            //////////////////////////////////////////////
            // 事务提交
            tran.commit();

            try {
                saveQcSuccess(hjywid, qcdq);
            } catch (Exception e) {
                throw new ServiceException("迁出成功，更新迁出地状态失败！");
            }
        } catch (Exception ex) {
            // 事务回滚
            tran.rollback();
            throw new ServiceException(ex);
        }

        return voQrspdjywfhxx;
    }

    /**
     * 更新迁出地状态
     *
     * @param hjywid
     * @param qcdq
     * @return
     */
    private boolean saveQcSuccess(String hjywid, String qcdq) {
        Transaction tran = null;
        Session session = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(qcdq).openSession();
            if (session == null)
                throw new ServiceException("数据库不支持此地区！");

            tran = session.beginTransaction();

            /////////////////////////////////////////////
            // 事务开始
            tran.begin();

            String hql = "from PoHJYW_QCZXXXB a where a.hjywid=?";
            List list = HibernateUtil.getObjectList(session, hql, new Object[]{Long.parseLong(hjywid)});
            for (Object o : list) {
                PoHJYW_QCZXXXB zx = (PoHJYW_QCZXXXB) o;
                zx.setKdqqy_cgbz("1");
                HibernateUtil.update(session, zx);
            }

            tran.commit();

            return true;
        } catch (Exception ex) {
            // 事务回滚
            tran.rollback();
            throw new ServiceException("更新迁出注销状态失败！");
        }
    }

    /**
     * 保存准迁证信息
     *
     * @param poHjspsqxx - 户籍审批申报信息PO
     * @return - 准迁ID
     * @throws DAOException
     */
    private Long saveZQZXX(BaseUser user, Session session, PoHJSP_HJSPSQB poHjspsqxx) {
        String strHQL = null;
        PoHJSP_ZQZXXB poZqzxx = null;
        try {
            //生成迁入地详址(2005/01/17 15:40:00)
            PoHJXX_MLPXXXXB poMlpxxxx = new PoHJXX_MLPXXXXB();
            poMlpxxxx.setSsxq(poHjspsqxx.getQrdqx());
            poMlpxxxx.setPcs(poHjspsqxx.getQrdpcs());
            poMlpxxxx.setXzjd(poHjspsqxx.getQrdxzjd());
            poMlpxxxx.setMlph(poHjspsqxx.getQrdmlph());
            poMlpxxxx.setJlx(poHjspsqxx.getQrdjlx());
            poMlpxxxx.setJcwh(poHjspsqxx.getQrdjwh());
            poMlpxxxx.setZrq(poHjspsqxx.getQrdjwzrq());
            poMlpxxxx.setMlxz(poHjspsqxx.getQrdz());
            String qrdxz = YWUtils.generateZZ(session, poMlpxxxx, PublicConstant.XTKZCS_DZPZFS,
                    PublicConstant.XTKZCS_DZPZFS_QCDXZ);
            //得到审批子信息(随迁人员)
            strHQL = "from PoHJSP_HJSPZB where spywid=" + poHjspsqxx.getSpywid();
            List hjspzxxList = HibernateUtil.getObjectList(session, strHQL, null);
            if (hjspzxxList != null) {
                while (hjspzxxList.size() > 0) {
                    //生成准迁证信息
                    poZqzxx = new PoHJSP_ZQZXXB();
                    poZqzxx.setZqid((Long) YWUtils.getId(session, "SID_HJSP_ZQZXXB"));
                    poZqzxx.setSpywid(poHjspsqxx.getSpywid());
                    poZqzxx.setSqrgmsfhm(poHjspsqxx.getSqrgmsfhm());
                    poZqzxx.setSqrxm(poHjspsqxx.getSqrxm());
                    poZqzxx.setSqrzzssxq(poHjspsqxx.getSqrzzssxq());
                    poZqzxx.setSqrzzxz(poHjspsqxx.getSqrzzxz());
                    poZqzxx.setSqrhkdjjg(poHjspsqxx.getSqrhkdjjg());
                    poZqzxx.setQyrhkdjjg(poHjspsqxx.getHkszddjjg());
                    poZqzxx.setQyrzzssxq(poHjspsqxx.getZzssxq());
                    poZqzxx.setQyrzzxz(poHjspsqxx.getZzxz());
                    poZqzxx.setQrdhkdjjg(poHjspsqxx.getQrdhkdjjg());
                    poZqzxx.setQrdssxq(poHjspsqxx.getQrdqx());
                    poZqzxx.setQrdxz(qrdxz);
                    poZqzxx.setZqyy(poHjspsqxx.getSqqrly());
                    poZqzxx.setPzjg(YWUtils.transDWDM(session, user.getOtherParams().getString("dwdm")));
                    poZqzxx.setBz(poHjspsqxx.getBz());
                    poZqzxx.setQyrs("0");
                    if (hjspzxxList.size() > 0) {
                        PoHJSP_HJSPZB po = (PoHJSP_HJSPZB) hjspzxxList.get(0);
                        poZqzxx.setQyrcsrq1(po.getCsrq());
                        poZqzxx.setQyrysqrgx1(po.getYsqrgx());
                        poZqzxx.setQyrxm1(po.getXm());
                        poZqzxx.setQyrxb1(po.getXb());
                        poZqzxx.setQyrgmsfhm1(po.getGmsfhm());
                        poZqzxx.setQyrs("1");
                        hjspzxxList.remove(0);
                    }
                    if (hjspzxxList.size() > 0) {
                        PoHJSP_HJSPZB po = (PoHJSP_HJSPZB) hjspzxxList.get(0);
                        poZqzxx.setQyrcsrq2(po.getCsrq());
                        poZqzxx.setQyrysqrgx2(po.getYsqrgx());
                        poZqzxx.setQyrxm2(po.getXm());
                        poZqzxx.setQyrxb2(po.getXb());
                        poZqzxx.setQyrgmsfhm2(po.getGmsfhm());
                        poZqzxx.setQyrs("2");
                        hjspzxxList.remove(0);
                    }
                    if (hjspzxxList.size() > 0) {
                        PoHJSP_HJSPZB po = (PoHJSP_HJSPZB) hjspzxxList.get(0);
                        poZqzxx.setQyrcsrq3(po.getCsrq());
                        poZqzxx.setQyrysqrgx3(po.getYsqrgx());
                        poZqzxx.setQyrxm3(po.getXm());
                        poZqzxx.setQyrxb3(po.getXb());
                        poZqzxx.setQyrgmsfhm3(po.getGmsfhm());
                        poZqzxx.setQyrs("3");
                        hjspzxxList.remove(0);
                    }
                    if (hjspzxxList.size() > 0) {
                        PoHJSP_HJSPZB po = (PoHJSP_HJSPZB) hjspzxxList.get(0);
                        poZqzxx.setQyrcsrq4(po.getCsrq());
                        poZqzxx.setQyrysqrgx4(po.getYsqrgx());
                        poZqzxx.setQyrxm4(po.getXm());
                        poZqzxx.setQyrxb4(po.getXb());
                        poZqzxx.setQyrgmsfhm4(po.getGmsfhm());
                        poZqzxx.setQyrs("4");
                        hjspzxxList.remove(0);
                    }
                    HibernateUtil.create(session, poZqzxx);
                } //while (hjspzxxList.size() > 0) {
            } //if (hjspzxxList != null) {

        } catch (Exception ex) {
            throw new ServiceException(ex);
        }

        return poZqzxx != null ? poZqzxx.getZqid() : null;
    }

    /**
     * 保存户籍审批流水信息
     *
     * @param spywid - 审批业务ID
     * @param splx   - 审批类型
     * @param dzid   - 动作ID
     * @param czjg   - 操作结果
     * @param czyj   - 操作意见
     * @param czsj   - 操作时间
     * @return - 审批流水ID
     * @throws DAOException
     * @throws ServiceException
     */
    private Long saveHJSPLSXX(BaseUser user, Session session, Long spywid, String splx, Long dzid, String czjg, String czyj, String czsj) {
        Long splsid = null;
        try {
            //得到审批流水ID
            splsid = (Long) YWUtils.getId(session, "SID_HJSP_HJSPLSB");
            //保存户籍审批流水信息
            PoHJSP_HJSPLSB poHjsplsxx = new PoHJSP_HJSPLSB();
            poHjsplsxx.setSplsid(splsid);
            poHjsplsxx.setCzrid(user.getOtherParams().getLong("yhid"));
            poHjsplsxx.setCzsj(czsj);
            poHjsplsxx.setSpywid(spywid);
            poHjsplsxx.setCzjg(czjg);
            poHjsplsxx.setCzyj(czyj);
            poHjsplsxx.setDzid(dzid != null ? dzid : new Long(0));
            poHjsplsxx.setSplx(splx);
            HibernateUtil.create(session, poHjsplsxx);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }

        return splsid;
    }

    public XT_ZQZ_QYZ_XLH requestXLH(String dqbm, String year, String zjlx) {
        String keyid = year + "-" + zjlx;
        keyid = keyid.toLowerCase();

        XT_ZQZ_QYZ_XLH xlh = (XT_ZQZ_QYZ_XLH) super.get(XT_ZQZ_QYZ_XLH.class.getName(), keyid, LockMode.UPGRADE);
        if (xlh == null) {
            xlh = new XT_ZQZ_QYZ_XLH();
            xlh.setLogid(keyid);
            xlh.setZjlx(zjlx);
            xlh.setZjyear(year);
            xlh.setZjbh(1);
            super.create(xlh);
        } else {
            xlh.setZjbh(xlh.getZjbh() + 1);
            if (xlh.getZjbh() > 99999)
                xlh.setZjbh(1);

            super.update(xlh);
        }

        return xlh;
    }

    public String requestDqbm(ExtMap<String, Object> params) {
        String sql = "from XX_CZRK a where a.czrkgmsfhm=? AND a.czrkzxbs is null";
        List list = super.getObjectListByHql(sql, new Object[]{params.getString("gmsfhm").split(",")[0]});
        if (list == null || list.size() <= 0)
            return null;

        XX_CZRK val = (XX_CZRK) list.get(0);
        if (val == null) {
            return null;
        }

        String str = val.getCzrkssssxq();
        if (str == null || str.length() < 4)
            throw new ServiceException("未知地区：" + str);

        return str.substring(0, 4);
    }

    public List<XX_CZRK> requestDqbmAndCzrkjbxx(ExtMap<String, Object> params) {
        String sql = "from XX_CZRK a where a.czrkzxbs is null";
        String str = params.getString("gmsfhm");
        if (str == null || str.equals(""))
            return null;

        String s[] = str.split(",");
        sql += " AND (";
        int i = 0;
        for (String sfz : s) {
            if (sfz == null || sfz.equals(""))
                continue;

            if (i != 0) sql += " or ";

            sql += " czrkgmsfhm = '" + sfz + "'";

            i++;
        }
        sql += ")";

        List<XX_CZRK> list = super.getObjectListByHql(sql, new Object[]{});
        /*String hhid = null;
        for (XX_CZRK rk : list) {
            if (hhid == null) {
                hhid = rk.getCzrkhh();
            }

            if (hhid != null && rk.getCzrkhh() != null && !hhid.equals(rk.getCzrkhh())) {
                return null;
            }
        }
*/
        //20210308 kqt 注释掉这个逻辑
        return list;
    }

    @Override
    public Page queryKdsQcSqrxx(BaseUser user, ExtMap<String, Object> params) {
        String ywlsh = params.getString("ywlsh");
        if (user == null)
            throw new ServiceException("已超时，请重新进入此功能！");
        List<ZjywZqzQyrxx> list_hjspzb = null;
        list_hjspzb = super.getObjectListByHql("from ZjywZqzQyrxx a where a.ywlsh=" + "'" + ywlsh + "'", null);
        Page p = new Page();
        p.setList(list_hjspzb);
        return p;

    }

    @Override
    public Page queryKdsQrSqrxx(BaseUser user, ExtMap<String, Object> params) {
        String ywlsh = params.getString("ywlsh");
        if (user == null)
            throw new ServiceException("已超时，请重新进入此功能！");
        List<ZjywQyzxxQyrxx> list_hjspzb = null;
        list_hjspzb = super.getObjectListByHql("from ZjywQyzxxQyrxx a where a.ywlsh=" + "'" + ywlsh + "'", null);
        Page p = new Page();
        p.setList(list_hjspzb);
        return p;

    }

    @Override
    public Object getDzxz(ExtMap<String, Object> params) {
        Session session = null;
        String dqbm =params.getString("dqbm");
        try {
            session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
            String ssxq = params.getString("ssxq");
            String jlx = params.getString("jlx");
            String mlph = params.getString("mlph");
            String mlxz = params.getString("mlxz");
            String pcs = params.getString("pcs");
            String xz = "";

            PoXT_XZQHB qh = HibernateUtil.get(session, PoXT_XZQHB.class, ssxq);
            if(qh!=null)
                xz = qh.getMc();

            if(CommonUtil.isNotEmpty(jlx)){
                PoXT_JLXXXB jlxxxb = HibernateUtil.get(session, PoXT_JLXXXB.class, jlx);
                if(jlxxxb!=null){
                    xz += jlxxxb.getMc();
                }
            }
            if(CommonUtil.isNotEmpty(mlph)){
                xz += mlph;
            }

            if(CommonUtil.isNotEmpty(mlxz)){
                xz += mlxz;
            }

            Map<String,String> data = new HashMap<String,String>();
            data.put("xxdz", xz);

            if(CommonUtil.isNotEmpty(pcs)){
                PoXT_DWXXB dw = HibernateUtil.get(session, PoXT_DWXXB.class, pcs);
                if(dw!=null){
                    data.put("pcsmc", dw.getMc());
                }
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List queryHdxx(Long hhnbid,String dqbm) {
        Session session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
        PoHJXX_HXXB poHJXX_HXXB = null;
        PoHJXX_MLPXXXXB poHJXX_MLPXXXXB = null;
        ArrayList HdxxList = null;
        poHJXX_HXXB = HibernateUtil.get(session, PoHJXX_HXXB.class, hhnbid);
        if (poHJXX_HXXB != null) {
            poHJXX_MLPXXXXB = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poHJXX_HXXB.getMlpnbid());
        }
        //转换成Vo
        if (poHJXX_HXXB != null && poHJXX_MLPXXXXB != null) {
            HdxxList = new ArrayList();
            VoHdxxHqFhxx voHdxx = new VoHdxxHqFhxx(poHJXX_HXXB, poHJXX_MLPXXXXB);
            HdxxList.add(voHdxx);
        }
        return HdxxList;
    }

    @Override
    public VoQrspdjywfhxx processQrspdjyw(BaseUser user, String dqbm, VoQrspdjxx voQrspdjxx, VoQrspdjzxx[] toArray, VoSpfdclxx[] toArray1) throws InvocationTargetException, IllegalAccessException {
        Transaction tran = null;
        Session session = null;
        VoQrspdjywfhxx voQrspdjywfhxx = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
            tran = session.beginTransaction();

            VoQrspdjzfhxx voQrspdjzfhxx[] = null; //迁入审批登记子返回信息(随迁人员登记返回信息)
            String strHQL = null;
            String zqzQyzbh = "";
            Long spmbid = null;
            String now = DateHelper.getMonthEndDate2();
            ExtMap<String,Object>  userMap = user.getOtherParams();
            PoXT_YHXXB jy = (PoXT_YHXXB) HibernateUtil.get(session, PoXT_YHXXB.class, userMap.getLong("yhid"));
            if (voQrspdjxx == null) {
                return null;
            }
            Long spywid = (Long) YWUtils.getId(session, "SID_HJSP_HJSPSQB");
            String Hhnbid_rh = voQrspdjxx.getHhnbid_rh();
            String hb = null;
            if(Hhnbid_rh!=null){
                //入户查找户主户别
                String hql = "from PoHJXX_CZRKJBXXB a where a.hhnbid=" + Hhnbid_rh + " and (yhzgx='01' or yhzgx='02' or yhzgx='03')";
                List list2 = HibernateUtil.getObjectList(session,hql,null);
                if(list2!=null && list2.size()>0){
                    PoHJXX_CZRKJBXXB hz = (PoHJXX_CZRKJBXXB)list2.get(0);
//          hb = hz.getHb();
                    /**
                     2018.10.05
                     修改	刁杰
                     暂时使用页面选择的入户后户别
                     */
                    hb = voQrspdjxx.getQrhhb();
                }
            }
            PoHJSP_HJSPSQB poHjspsqxx = new PoHJSP_HJSPSQB();
            BeanUtils.copyProperties(poHjspsqxx, voQrspdjxx);
            poHjspsqxx.setSpywid(spywid);
            poHjspsqxx.setLsbz(HjConstant.LSBZ_WLS);
            poHjspsqxx.setDjrid(jy.getYhid());
            poHjspsqxx.setDjsj(now);
            poHjspsqxx.setSpmbid(spmbid);
            poHjspsqxx.setSpjg(spmbid == null ? HjConstant.SPJG_TY : null); //操作员自审批

            //受理日期
            poHjspsqxx.setSlrq(now.substring(0,8));

            PoXT_JWHXXB poXT_JWHXXB = (PoXT_JWHXXB) HibernateUtil.get(session, PoXT_JWHXXB.class, poHjspsqxx.getQrdjwh()); // 通过居委会代码得到乡镇街道代码
            poHjspsqxx.setCxfldm(poXT_JWHXXB.getCxfldm());

            String new_xzd = null,new_xzd_qczxlb = null;
            if(poHjspsqxx.getKdqqy_qcdqbm()!=null && !"".equals(poHjspsqxx.getKdqqy_qcdqbm())){
                //跨地区迁入
                if (jy != null) {
                    poHjspsqxx.setKdqqy_czydw(jy.getDwdm());
                    poHjspsqxx.setKdqqy_czyxm(jy.getYhxm());
                    poHjspsqxx.setKdqqy_fkzt("0");

//                new_xzd = (String)qyldyyMap.get(poHjspsqxx.getSqqrly());
//                new_xzd_qczxlb = (String)qczxlbMap.get(poHjspsqxx.getSqqrly());
                }
            }else{
                //外省迁入
                poHjspsqxx.setKdqqy_czydw(null);
                poHjspsqxx.setKdqqy_czyxm(null);
                poHjspsqxx.setKdqqy_fknr(null);
                poHjspsqxx.setKdqqy_fkzt(null);
                poHjspsqxx.setKdqqy_qcdqbm(null);
                poHjspsqxx.setKdqqy_qyzbh(null);
            }

            if(hb!=null) poHjspsqxx.setQrhhb(hb);
            HibernateUtil.create(session,poHjspsqxx);

            XT_ZQZ_QYZ_XLH xlhqyz = requestXLH("", "6", "qyz");
            String qyzbhSer = xlhqyz.getZjbh().toString();
            if (qyzbhSer.length() < 7)
                qyzbhSer = "0000000".substring(0, 7 - qyzbhSer.length()) + qyzbhSer;
            zqzQyzbh = "皖" +"6"+qyzbhSer+"";
            System.out.println("大专院校准迁证迁移证编号为：" + zqzQyzbh);

            //保存主迁人信息到随迁人员信息表中
            PoHJSP_HJSPZB poHjspzxx = new PoHJSP_HJSPZB();
            poHjspzxx.setRyid(poHjspsqxx.getRyid());
            poHjspzxx.setXm(poHjspsqxx.getXm());
            poHjspzxx.setXb(poHjspsqxx.getXb());
            poHjspzxx.setCsrq(poHjspsqxx.getCsrq());
            poHjspzxx.setMz(poHjspsqxx.getMz());//add by hubin 20121018
            poHjspzxx.setGmsfhm(poHjspsqxx.getGmsfhm());
            poHjspzxx.setYsqrgx(poHjspsqxx.getYsqrgx());
            poHjspzxx.setYhkqx(poHjspsqxx.getZzssxq());
            poHjspzxx.setYhkszd(poHjspsqxx.getZzxz());
            poHjspzxx.setQrhhb(poHjspsqxx.getQrhhb()); //add by mhb 2004/12/24 12:57:00
            poHjspzxx.setHkxz(poHjspsqxx.getHb());
            poHjspzxx.setGzdw(poHjspsqxx.getYrdwjcyrysj());
            poHjspzxx.setRynbid(poHjspsqxx.getRynbid());
            poHjspzxx.setSpsqzid((Long) YWUtils.getId(session, "SID_HJSP_HJSPZB"));
            poHjspzxx.setSpywid(poHjspsqxx.getSpywid());
            poHjspzxx.setKdqqy_fkzt(poHjspsqxx.getKdqqy_fkzt());
            poHjspzxx.setKdqqy_qcdqbm(poHjspsqxx.getKdqqy_qcdqbm());
            poHjspzxx.setKdqqy_qyldyy(new_xzd);
            poHjspzxx.setKdqqy_qclb(new_xzd_qczxlb);
            poHjspzxx.setZjbh(zqzQyzbh);
            if(hb!=null) poHjspzxx.setQrhhb(hb);
            HibernateUtil.create(session,poHjspzxx);

            //操作员自审批
            Long zqid = null;
            boolean flag = true;
            if (spmbid == null) {
                zqid = saveZQZXXDzyx(user, session,poHjspsqxx,zqzQyzbh,jy);
                flag = false;
            }

            //生成业务返回信息
            voQrspdjywfhxx = new VoQrspdjywfhxx();
            voQrspdjywfhxx.setGmsfhm(poHjspsqxx.getGmsfhm());
            voQrspdjywfhxx.setSpywid(poHjspsqxx.getSpywid());
            voQrspdjywfhxx.setXm(poHjspsqxx.getXm());
            voQrspdjywfhxx.setZqid(zqid);
            voQrspdjywfhxx.setVoQrspdjzfhxx(voQrspdjzfhxx);
            tran.commit();

        } catch (Exception e) {
            tran.rollback();
            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }
        return voQrspdjywfhxx;

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
    public void dzyxZqzZf(BaseUser user, String dqbm, Long spywid) {
        Transaction tran = null;
        Session session = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
            tran = session.beginTransaction();
            PoHJSP_HJSPSQB hjsp_hjspsqb = (PoHJSP_HJSPSQB) HibernateUtil.get(session, PoHJSP_HJSPSQB.class, spywid);
            hjsp_hjspsqb.setSpjg(HjConstant.SPJG_WX);
            HibernateUtil.update(session,hjsp_hjspsqb);
            tran.commit();

        } catch (Exception e) {
            tran.rollback();
            throw new ServiceException(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    /**
     * 保存准迁证信息
     *
     * @param poHjspsqxx - 户籍审批申报信息PO
     * @return - 准迁ID
     * @throws DAOException
     */
    private Long saveZQZXXDzyx(BaseUser user, Session session, PoHJSP_HJSPSQB poHjspsqxx,String zqzQyzbh,PoXT_YHXXB jy) {
        String strHQL = null;
        PoHJSP_ZQZXXB poZqzxx = null;
        try {
            //生成迁入地详址(2005/01/17 15:40:00)
            PoHJXX_MLPXXXXB poMlpxxxx = new PoHJXX_MLPXXXXB();
            poMlpxxxx.setSsxq(poHjspsqxx.getQrdqx());
            poMlpxxxx.setPcs(poHjspsqxx.getQrdpcs());
            poMlpxxxx.setXzjd(poHjspsqxx.getQrdxzjd());
            poMlpxxxx.setMlph(poHjspsqxx.getQrdmlph());
            poMlpxxxx.setJlx(poHjspsqxx.getQrdjlx());
            poMlpxxxx.setJcwh(poHjspsqxx.getQrdjwh());
            poMlpxxxx.setZrq(poHjspsqxx.getQrdjwzrq());
            poMlpxxxx.setMlxz(poHjspsqxx.getQrdz());
            String qrdxz = YWUtils.generateZZ(session, poMlpxxxx, PublicConstant.XTKZCS_DZPZFS,
                    PublicConstant.XTKZCS_DZPZFS_QCDXZ);
            //得到审批子信息(随迁人员)
            strHQL = "from PoHJSP_HJSPZB where spywid=" + poHjspsqxx.getSpywid();
            List hjspzxxList = HibernateUtil.getObjectList(session, strHQL, null);
            boolean isKDQ = (poHjspsqxx.getKdqqy_qcdqbm()!=null && !poHjspsqxx.getKdqqy_qcdqbm().equals(""));
            if (hjspzxxList != null) {
                while (hjspzxxList.size() > 0) {
                    //生成准迁证信息
                    poZqzxx = new PoHJSP_ZQZXXB();
                    poZqzxx.setZqid((Long) YWUtils.getId(session, "SID_HJSP_ZQZXXB"));
                    poZqzxx.setSpywid(poHjspsqxx.getSpywid());
                    poZqzxx.setSqrgmsfhm(poHjspsqxx.getSqrgmsfhm());
                    poZqzxx.setSqrxm(poHjspsqxx.getSqrxm());
                    poZqzxx.setSqrzzssxq(poHjspsqxx.getSqrzzssxq());
                    poZqzxx.setSqrzzxz(poHjspsqxx.getSqrzzxz());
                    poZqzxx.setSqrhkdjjg(poHjspsqxx.getSqrhkdjjg());
                    poZqzxx.setQyrhkdjjg(poHjspsqxx.getHkszddjjg());
                    poZqzxx.setQyrzzssxq(poHjspsqxx.getZzssxq());
                    poZqzxx.setQyrzzxz(poHjspsqxx.getZzxz());
                    poZqzxx.setQrdhkdjjg(poHjspsqxx.getQrdhkdjjg());
                    poZqzxx.setQrdssxq(poHjspsqxx.getQrdqx());
                    poZqzxx.setQrdxz(qrdxz);
                    poZqzxx.setZqyy(poHjspsqxx.getSqqrly());
                    poZqzxx.setPzjg(YWUtils.transDWDM(session, user.getOtherParams().getString("dwdm")));
                    poZqzxx.setBz(poHjspsqxx.getBz());
                    poZqzxx.setZjbh(zqzQyzbh);
                    poZqzxx.setQyrs("0");
                    poZqzxx.setQyyy(poHjspsqxx.getQyyy());
                    poZqzxx.setSfcsjtb(poHjspsqxx.getSfcsjtb());
                    if (hjspzxxList.size() > 0) {
                        PoHJSP_HJSPZB po = (PoHJSP_HJSPZB) hjspzxxList.get(0);
                        poZqzxx.setQyrcsrq1(po.getCsrq());
                        poZqzxx.setQyrysqrgx1(po.getYsqrgx());
                        poZqzxx.setQyrxm1(po.getXm());
                        poZqzxx.setQyrxb1(po.getXb());
                        poZqzxx.setQyrgmsfhm1(po.getGmsfhm());
                        poZqzxx.setQyrs("1");
                        hjspzxxList.remove(0);
                        if(isKDQ){
                            po.setZjbh(zqzQyzbh);
                            po.setZqzjlx("1");
                            HibernateUtil.update(session,po);
                        }
                    }
                    if (hjspzxxList.size() > 0) {
                        PoHJSP_HJSPZB po = (PoHJSP_HJSPZB) hjspzxxList.get(0);
                        poZqzxx.setQyrcsrq2(po.getCsrq());
                        poZqzxx.setQyrysqrgx2(po.getYsqrgx());
                        poZqzxx.setQyrxm2(po.getXm());
                        poZqzxx.setQyrxb2(po.getXb());
                        poZqzxx.setQyrgmsfhm2(po.getGmsfhm());
                        poZqzxx.setQyrs("2");
                        hjspzxxList.remove(0);
                    }
                    if (hjspzxxList.size() > 0) {
                        PoHJSP_HJSPZB po = (PoHJSP_HJSPZB) hjspzxxList.get(0);
                        poZqzxx.setQyrcsrq3(po.getCsrq());
                        poZqzxx.setQyrysqrgx3(po.getYsqrgx());
                        poZqzxx.setQyrxm3(po.getXm());
                        poZqzxx.setQyrxb3(po.getXb());
                        poZqzxx.setQyrgmsfhm3(po.getGmsfhm());
                        poZqzxx.setQyrs("3");
                        hjspzxxList.remove(0);
                    }
                    if (hjspzxxList.size() > 0) {
                        PoHJSP_HJSPZB po = (PoHJSP_HJSPZB) hjspzxxList.get(0);
                        poZqzxx.setQyrcsrq4(po.getCsrq());
                        poZqzxx.setQyrysqrgx4(po.getYsqrgx());
                        poZqzxx.setQyrxm4(po.getXm());
                        poZqzxx.setQyrxb4(po.getXb());
                        poZqzxx.setQyrgmsfhm4(po.getGmsfhm());
                        poZqzxx.setQyrs("4");
                        hjspzxxList.remove(0);
                    }
                    if(isKDQ){
                        poZqzxx.setZjbh(zqzQyzbh);
                        poZqzxx.setZqzjlx("1");
                        poZqzxx.setQfrq(DateHelper.getMonthEndDate2());
                    }
                    poZqzxx.setCbr(jy.getYhxm());
                    HibernateUtil.create(session, poZqzxx);
                } //while (hjspzxxList.size() > 0) {
            } //if (hjspzxxList != null) {

        } catch (Exception ex) {
            throw new ServiceException(ex);
        }

        return poZqzxx != null ? poZqzxx.getZqid() : null;
    }
}
