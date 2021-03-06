package com.gnt.qxgl.service.yw.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

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
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.hz2004.entity.HJXX_CZRKJBXXB;
import com.gnt.qxgl.hz2004.entity.HZ_ZJ_SB;
import com.gnt.qxgl.hz2004.entity.XT_JLXXXB;
import com.gnt.qxgl.hz2004.entity.XT_JWHXXB;
import com.gnt.qxgl.service.yw.KdqqyService;
import com.hzjc.hz2004.SpywUtils;
import com.hzjc.hz2004.YWUtils;
import com.hzjc.hz2004.constant.HjConstant;
import com.hzjc.hz2004.constant.PublicConstant;
import com.hzjc.hz2004.po.HzZjSb;
import com.hzjc.hz2004.po.PoHJLS_HJYWLSB;
import com.hzjc.hz2004.po.PoHJSP_HJSPFDCLB;
import com.hzjc.hz2004.po.PoHJSP_HJSPLSB;
import com.hzjc.hz2004.po.PoHJSP_HJSPSQB;
import com.hzjc.hz2004.po.PoHJSP_HJSPZB;
import com.hzjc.hz2004.po.PoHJSP_ZQZXXB;
import com.hzjc.hz2004.po.PoHJXX_CXSXBGB;
import com.hzjc.hz2004.po.PoHJXX_CZRKJBXXB;
import com.hzjc.hz2004.po.PoHJXX_HXXB;
import com.hzjc.hz2004.po.PoHJXX_MLPXXXXB;
import com.hzjc.hz2004.po.PoHJXX_RHFLXXB;
import com.hzjc.hz2004.po.PoHJYW_CHCLXXB;
import com.hzjc.hz2004.po.PoHJYW_QCZXXXB;
import com.hzjc.hz2004.po.PoXT_JWHXXB;
import com.hzjc.hz2004.po.PoXT_MBLCXXB;
import com.hzjc.hz2004.vo.VoBggzfhxx;
import com.hzjc.hz2004.vo.VoBggzfhxxEx;
import com.hzjc.hz2004.vo.VoBggzxxEx;
import com.hzjc.hz2004.vo.VoHcygxtzfhxx;
import com.hzjc.hz2004.vo.VoHcygxtzxxEx;
import com.hzjc.hz2004.vo.VoQczxfhxx;
import com.hzjc.hz2004.vo.VoQczxxx;
import com.hzjc.hz2004.vo.VoQczxywfhxx;
import com.hzjc.hz2004.vo.VoQrspdjxx;
import com.hzjc.hz2004.vo.VoQrspdjywfhxx;
import com.hzjc.hz2004.vo.VoQrspdjzfhxx;
import com.hzjc.hz2004.vo.VoQrspdjzxx;
import com.hzjc.hz2004.vo.VoRybdxx;
import com.hzjc.hz2004.vo.VoSbjbxx;
import com.hzjc.hz2004.vo.VoSpfdclxx;
import com.hzjc.hz2004.vo.VoXtywxz;
import com.hzjc.hz2004.vo.VoZxhxx;

public class KdqqyServiceImpl extends ServiceImpl implements KdqqyService {
	/**
	 * ????????????????????????
	 * 
	 * @param user
	 * @param params
	 * @return
	 */
	public Page queryKdsQczxxx(BaseUser user, ExtMap<String, Object> params) {
		if(CommonUtil.isEmpty(user.getYwdq()))
			throw new ServiceException("?????????????????????");
		
		String qcdq = params.getString("qcdq");
		params.put("qwdq", user.getYwdq());
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
			
			if(params.containsKey("hjywid")){
				//???????????????????????????????????????????????????
				session2 = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
				String hql = "from PoHJSP_HJSPSQB a where a.kdqqy_qchjywid=? and a.kdqqy_qcdqbm=?";
				PoHJSP_HJSPSQB sp = (PoHJSP_HJSPSQB)HibernateUtil.getObject(session2, hql, new Object[]{params.getString("hjywid"),qcdq});
				if(sp!=null){
					saveQcSuccess(params.getString("hjywid"), qcdq);
					throw new ServiceException("??????????????????????????????????????????????????????");
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

		// ??????????????????????????????
		Session session = null;
		try {
			session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();

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
			throw new ServiceException("???" + user.getYwdq() + "?????????????????????", e);
		} finally {
			if (session != null)
				session.close();
		}

		Page p = new Page();
		session = null;
		try {
			// session =
			// HibernateUtil.getSystemSessionFactory("3402").openSession();
			session = HibernateUtil.getSystemSessionFactory(formdqbm.substring(0, 4)).openSession();
			@SuppressWarnings("unchecked")
			List<HJXX_CZRKJBXXB> list = HibernateUtil.getObjectList(session, hql, new Object[] {});
			p.setList(list);
			p.setTotalCount(list.size());
		} catch (Exception e) {
			e.printStackTrace();

			throw new ServiceException("???" + formdqbm.substring(0, 4) + "?????????????????????", e);
		} finally {
			if (session != null)
				session.close();
		}

		return p;
	}

	public HZ_ZJ_SB queryHjywById(BaseUser user, ExtMap<String, Object> params) {
		if (user == null)
			throw new ServiceException("???????????????????????????????????????");

		String ywid = params.getString("ywid");
		if (ywid == null)
			throw new ServiceException("???????????????");

		HZ_ZJ_SB yw = null;
		Session session = null;
		try {
			session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
			yw = HibernateUtil.get(session, HZ_ZJ_SB.class, ywid);
			if (yw == null)
				throw new ServiceException("??????????????????");
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
			throw new ServiceException("???????????????????????????????????????");

		// ??????????????????
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

	/**
	 * ??????????????????????????????
	 */
	public Page queryCzrkjbxx(BaseUser user, ExtMap<String, Object> params) {
		if (user == null)
			throw new ServiceException("???????????????????????????????????????");

		// ??????????????????
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
			VoSbjbxx voSbjbxx) {
		if (CommonUtil.isEmpty(qcdqbm))
			throw new ServiceException("????????????qcdqbm???????????????????????????");

		if (voSbjbxx == null)
			throw new ServiceException("????????????????????????");

		if (voQczxxx == null || voQczxxx.size() <= 0)
			throw new ServiceException("???????????????????????????");

		VoQczxywfhxx voQczxywfhxx = null;
		VoQczxfhxx voQczxfhxx[] = null;
		VoHcygxtzxxEx voHcygxtzxxEx[] = null;
		List bggzfhxxList = new ArrayList();
		List hcygxtzfhxxList = new ArrayList();
		List rybdxxList = new ArrayList();
		VoZxhxx voZxhxx[] = null;
		Long hjywid = null;
		PoXT_JWHXXB poJwhxxb = null;
		if (voQczxxx == null || (voQczxxx != null && voQczxxx.size() <= 0)) {
			return null;
		}

		Transaction tran = null;
		Session session = null;
		try {
			session = HibernateUtil.getSystemSessionFactory(qcdqbm).openSession();
			if (session == null)
				throw new ServiceException("??????????????????????????????");

			tran = session.beginTransaction();

			String now = YWUtils.getServiceTime(session);

			if (voSbjbxx != null && voSbjbxx.getHzywid() != null) {
				List list = HibernateUtil.getObjectList(session, "from HzZjSb a where a.id=" + voSbjbxx.getHzywid(),
						null);
				if (list.size() > 0) {
					HzZjSb sb = (HzZjSb) list.get(0);
					if (sb.getPch() != null && !sb.getPch().equals("")) {
						// ???????????????????????????
						System.out.println("???????????????????????????");
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
			// ??????????????????ID
			hjywid = (Long) YWUtils.getId(session, "SID_HJLS_HJYWLSB");
			System.out.println(hjywid);
			//////////////////////////////////////////
			// ????????????????????????
			voQczxfhxx = new VoQczxfhxx[voQczxxx.size()];
			voZxhxx = new VoZxhxx[voQczxxx.size()];
			voHcygxtzxxEx = new VoHcygxtzxxEx[voQczxxx.size()];
			for (int i = 0; i < voQczxxx.size(); i++) {
				// ??????????????????
				PoHJXX_CZRKJBXXB poRyxx = HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class,
						voQczxxx.get(i).getRynbid());
				if (poRyxx == null) {
					throw new ServiceException("???????????????????????????????????????????????????????????????");
				}

				// ???????????????????????????
				YWUtils.checkRXX(session, poRyxx, "??????????????????");
				// ??????????????????
				if (!HjConstant.RYSDZT_ZC.equals(poRyxx.getRysdzt())) {
					throw new ServiceException("??????????????????????????????(?????????)????????????????????????????????????", null);
				}
				// ????????????
				if (!HjConstant.RYZT_ZC.equals(poRyxx.getRyzt())) {
					throw new ServiceException("????????????????????????????????????????????????????????????", null);
				}

				// ???????????????
				PoHJXX_HXXB poHxx = HibernateUtil.get(session, PoHJXX_HXXB.class, poRyxx.getHhnbid());
				if (poHxx == null) {
					throw new ServiceException("?????????????????????????????????????????????????????????????????????????????????", null);
				}

				// ???????????????
				PoHJXX_MLPXXXXB poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poRyxx.getMlpnbid());
				if (poMlpxxxx == null) {
					throw new ServiceException("?????????????????????????????????????????????????????????????????????????????????", null);
				}

				poJwhxxb = (PoXT_JWHXXB) HibernateUtil.get(session, PoXT_JWHXXB.class, poMlpxxxx.getJcwh());
				if (poJwhxxb == null) {
					throw new ServiceException("??????????????????????????????????????????????????????", null);
				}

				// ????????????????????????
				if (PublicConstant.XTKZCS_QY.equals(YWUtils.getXTKZCS(session, PublicConstant.XTKZCS_SHQYZDQYPD))) {
					if (YWUtils.checkZZBD(session, voQczxxx.get(i).getQwdssxq(), poMlpxxxx.getSsxq())) {
						throw new ServiceException("??????????????????????????????????????????????????????????????????????????????????????????", null);
					}
				}

				// ??????????????????
				/*
				 * List sjfwList = new ArrayList(); VoXtsjfw voXtsjfw = new
				 * VoXtsjfw(); voXtsjfw.setSjfw(poMlpxxxx.getJcwh());
				 * voXtsjfw.setSjfwbz(PublicConstant.XT_QX_JWH);
				 * sjfwList.add(voXtsjfw); boolean bLimit = false; bLimit =
				 * XtywqxServiceImpl.VerifyDataRange(this.getUserInfo().getYhid(
				 * ). toString(), PublicConstant.GNBH_HJ_QCZXYW, sjfwList); if
				 * (!bLimit) { throw new
				 * ServiceException(WSErrCode.ERR_SERVICE_BUSSINESSLIMIT,
				 * "?????????????????????????????????????????????????????????", null); }
				 */

				// ?????????????????????????????????
				poRyxx.setJssj(now);
				poRyxx.setCchjywid(hjywid);
				poRyxx.setJlbz(PublicConstant.JLBZ_LS);
				HibernateUtil.update(session, poRyxx);

				// ??????????????????????????????
				PoHJXX_CZRKJBXXB poRyxxNew = new PoHJXX_CZRKJBXXB();
				BeanUtils.copyProperties(poRyxxNew, poRyxx);
				BeanUtils.copyProperties(poRyxxNew, voQczxxx.get(i));
				poRyxxNew.setQczxlb(voQczxxx.get(i).getQclb());
				// SID_HJXX_CZRKJBXXB
				Long rynbid = (Long) YWUtils.getId(session, "SID_HJXX_CZRKJBXXB");
				poRyxxNew.setRynbid(rynbid);
				// ??????poRyxxNew??????????????????begin
				if (voBggzxxEx != null) {
					for (int k = 0; k < voBggzxxEx.size(); k++) {
						if (voQczxxx.get(i).getRynbid().equals(voBggzxxEx.get(k).getRynbid())) {
							voBggzxxEx.get(k).setFlag(0); //// ?????????????????????????????????????????????????????????(0-?????????/1-??????)
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

				// ????????????_????????????
				if (HjConstant.QCZXLB_CGDJ.equals(voQczxxx.get(i).getQclb())
						|| HjConstant.QCZXLB_QWGA.equals(voQczxxx.get(i).getQclb())
						|| HjConstant.QCZXLB_QWTW.equals(voQczxxx.get(i).getQclb())) {
					poRyxxNew.setRyzt(HjConstant.RYZT_CGJDJ);
				}
				// ????????????_?????????
				else if (HjConstant.QCZXLB_CJFBY.equals(voQczxxx.get(i).getQclb())) {
					poRyxxNew.setRyzt(HjConstant.RYZT_FBY);
				}
				// ????????????_????????????
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
				/*
				 * //?????????????????? VoRhdxx voRhdxx = new VoRhdxx(poRyxxNew, poHxx,
				 * poMlpxxxx, this.getUserInfo()); VoXtywxz voLimit =
				 * XtywqxServiceImpl.VerifyBusinessLimit(PublicConstant.
				 * GNBH_HJ_QCZXYW, voRhdxx); if (voLimit.getLimitflag()) { throw
				 * new ServiceException(WSErrCode.ERR_SERVICE_BUSSINESSLIMIT,
				 * "??????????????????????????????????????????" + voLimit.getLimitinfo(), null); } voRhdxx =
				 * null;
				 */

				// ????????????????????????
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
				poQczxxx.setSldw(user.getSldw());
				poQczxxx.setSlrid(Long.parseLong(user.getUser().getYhid()));
				// poQczxxx.setSldw(this.getUserInfo().getDwdm());
				// poQczxxx.setSlrid(this.getUserInfo().getYhid());
				poQczxxx.setSlsj(now);
				poQczxxx.setKdqqy_dqbm(user.getYwdq());
				poQczxxx.setKdqqy_yhid(Long.parseLong(user.getUser().getYhid()));
				poQczxxx.setKdqqy_yhm(user.getUser().getDlm());
				poQczxxx.setKdqqy_cgbz("0");

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
				log.setBz("????????????");
				log.setRkbj("0");
				log.setSsxq(poQczxxx.getSsxq());
				log.setJwhdm(poJwhxxb.getDm());
				log.setRysl(new Long(1));
				HibernateUtil.create(session, log);

				// ??????????????????????????????????????????????????????
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

				// ?????????????????????
				voZxhxx[i] = new VoZxhxx();
				voZxhxx[i].setNew_hhnbid(null);
				voZxhxx[i].setOld_hhnbid(poRyxx.getHhnbid());

				// ????????????????????????
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

				// ??????????????????
				strHQL = "from PoHJYW_CHCLXXB as HJYW_CHCLXXB where clfs='" + HjConstant.CHCLFS_WCL + "' and chsfhm='"
						+ poRyxx.getGmsfhm() + "' and cxbz='" + PublicConstant.CXBZ_FCX + "' ";
				List chxxList = HibernateUtil.getObjectList(session, strHQL, null);
				if (chxxList != null) {
					for (int j = 0; j < chxxList.size(); j++) {
						PoHJYW_CHCLXXB poChclxx = (PoHJYW_CHCLXXB) chxxList.get(j);
						// ????????????
						if (poRyxx.getRyid().equals(poChclxx.getRyid())) {
							poChclxx.setCxbz(PublicConstant.CXBZ_FCX);
							poChclxx.setClfs(HjConstant.CHCLFS_BRQC);
							poChclxx.setClhjywid(hjywid);
							HibernateUtil.update(session, poChclxx);
						}
						// ??????????????????
						if (poRyxx.getRyid().equals(poChclxx.getBchryid())) {
							poChclxx.setClfs(HjConstant.CHCLFS_DFQC);
							poChclxx.setClhjywid(hjywid);

							HibernateUtil.update(session, poChclxx);
						}
					} // for (int j = 0; j < chxxList.size(); j++)
				}

				// ????????????????????????(??????)
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

				// ??????????????????????????????
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
			// ?????????????????????
			VoHcygxtzfhxx voh[] = YWUtils.adjustHCYGX(session, hjywid, voSbjbxx, voHcygxtzxxEx, now);
			if (voh != null) {
				for (int i = 0; i < voh.length; i++) {
					hcygxtzfhxxList.add(voh[i]);
				}
			}

			////////////////////////////////////////
			// ??????????????????
			if (voBggzxxEx != null) {
				VoBggzfhxxEx vobEx = YWUtils.saveBGGZXX(session, hjywid, voSbjbxx,
						voBggzxxEx.toArray(new VoBggzxxEx[] {}), PublicConstant.GNBH_HJ_QCZXYW, now);
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
			// ????????????????????????
			List zxhhnbidList = YWUtils.logoutH(session, hjywid, voZxhxx, voQczxxx.get(0).getBdfw(),
					voQczxxx.get(0).getQclb(), HjConstant.YWNR_QCZX, now);

			///////////////////////////////
			// ??????????????????
			Map hhnbidMap = new HashMap();
			for (int h = 0; h < hcygxtzfhxxList.size(); h++) {
				VoHcygxtzfhxx vo = (VoHcygxtzfhxx) hcygxtzfhxxList.get(h);
				hhnbidMap.put(vo.getHhnbid(), null);
			}
			// ???????????????????????????ID
			if (zxhhnbidList != null) {
				for (int h = 0; h < zxhhnbidList.size(); h++) {
					hhnbidMap.remove(zxhhnbidList.get(h));
				}
			}
			for (Iterator itr = hhnbidMap.keySet().iterator(); itr.hasNext();) {
				YWUtils.checkHCYXX(session, (Long) itr.next());
			}

			////////////////////////////////////////
			// ??????????????????????????????
			PoHJLS_HJYWLSB poHjywlsxx = YWUtils.saveHJYWLSXX(session, hjywid,
					PublicConstant.GNBH_HJ_QCZXYW, zxhhnbidList != null && zxhhnbidList.size() > 0
							? PublicConstant.HJYWLS_YWLX_QH : PublicConstant.HJYWLS_YWLX_GR,
					voQczxxx.size(), voSbjbxx, now);

			//////////////////////////////////////////
			// ????????????????????????(??????)
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
			// ??????????????????????????????????????????????????????????????????????????????
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

			// ??????????????????
			voQczxywfhxx = new VoQczxywfhxx();
			voQczxywfhxx.setHjywid(hjywid);
			voQczxywfhxx.setVoQczxfhxx(voQczxfhxx);
			voQczxywfhxx.setVoBggzfhxx((VoBggzfhxx[]) bggzfhxxList.toArray(new VoBggzfhxx[bggzfhxxList.size()]));
			voQczxywfhxx.setVoHcygxtzfhxx(
					(VoHcygxtzfhxx[]) hcygxtzfhxxList.toArray(new VoHcygxtzfhxx[hcygxtzfhxxList.size()]));
			voQczxywfhxx.setQwdq(qcdqbm);
			voQczxywfhxx.setQcdq(qcdqbm);

			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			throw new ServiceException(e);
		} finally {
			if (session != null)
				session.close();
		}

		return voQczxywfhxx;
	}

	/**
	 * ????????????????????????
	 * 
	 * @param spsm
	 *            - ????????????
	 * @param voQrspdjxx
	 *            - ????????????????????????(??????????????????)
	 * @param voQrspdjzxx
	 *            - ???????????????????????????(??????????????????)
	 * @param voSpfdclxx
	 *            - ????????????????????????
	 * @return - ????????????????????????????????????
	 * @throws DAOException
	 * @throws ServiceException
	 */
	public VoQrspdjywfhxx saveKdsQcEnd(BaseUser user,String hjywid, String qcdq, String spsm, VoQrspdjxx voQrspdjxx, VoQrspdjzxx voQrspdjzxx[],
			VoSpfdclxx voSpfdclxx[]) {

		VoQrspdjywfhxx voQrspdjywfhxx = null;
		VoQrspdjzfhxx voQrspdjzfhxx[] = null; // ?????????????????????????????????(??????????????????????????????)
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
				throw new ServiceException("??????????????????????????????");

			tran = session.beginTransaction();
			String now = YWUtils.getServiceTime(session);

			/////////////////////////////////////////////
			// ????????????
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
			// ??????????????????
			VoXtywxz voLimit = SpywUtils.VerifyCheckLimit(session, PublicConstant.GNBH_SP_QRSPDJYW, voQrspdjxx);
			if (voLimit.getLimitflag()) {
				spmbid = voLimit.getSpmbid();
			}

			///////////////////////////////////////////////
			// ????????????????????????
			PoXT_MBLCXXB poMblcxx = null;
			if (spmbid != null) {
				strHQL = "from PoXT_MBLCXXB where (dzbz='" + HjConstant.DZBZ_DYB + "' or dzbz='" + HjConstant.DZBZ_QSB
						+ "') and spmbid=" + spmbid;
				List mblcxxList = HibernateUtil.getObjectList(session,strHQL,null);
				if (mblcxxList != null && mblcxxList.size() > 0) {
					poMblcxx = (PoXT_MBLCXXB) mblcxxList.get(0);
				}
				if (poMblcxx == null) {
					throw new ServiceException("???????????????????????????????????????,????????????????????????????????????.",
							null);
				}
			} // if (spmbid != null) {

			////////////////////////////////////////////////
			// ????????????????????????
			PoHJSP_HJSPSQB poHjspsqxx = null;		
			poHjspsqxx = new PoHJSP_HJSPSQB();
			BeanUtils.copyProperties(poHjspsqxx, voQrspdjxx);
			poHjspsqxx.setSpywid((Long) YWUtils.getId(session,"SID_HJSP_HJSPSQB"));
			poHjspsqxx.setLsbz(HjConstant.LSBZ_WLS);
			poHjspsqxx.setDjrid(user.getOtherParams().getLong("yhid"));
			poHjspsqxx.setDjsj(now);
			poHjspsqxx.setSpmbid(spmbid);
			poHjspsqxx.setXydzid(poMblcxx != null ? poMblcxx.getDzid() : null); // ??????????????????
			poHjspsqxx.setSpjg(spmbid == null ? HjConstant.SPJG_TY : null); // ??????????????????
			poHjspsqxx.setSpsm(spsm);
			poHjspsqxx.setSlrq(now.substring(0, 8));
			poHjspsqxx.setKdqqy_qcdqbm(qcdq);
			poHjspsqxx.setKdqqy_qchjywid(hjywid);
			
			PoXT_JWHXXB poXT_JWHXXB = (PoXT_JWHXXB) HibernateUtil.get(session, PoXT_JWHXXB.class, poHjspsqxx.getQrdjwh()); // ?????????????????????????????????????????????
			poHjspsqxx.setCxfldm(poXT_JWHXXB.getCxfldm());
			HibernateUtil.create(session, poHjspsqxx);
			
			// ????????????????????????????????????????????????
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
			poHjspzxx.setSpsqzid((Long) YWUtils.getId(session,"SID_HJSP_HJSPZB"));
			poHjspzxx.setSpywid(poHjspsqxx.getSpywid());
			HibernateUtil.create(session, poHjspzxx);
			
			///////////////////////////////////////////////
			// ????????????????????????
			if (voQrspdjzxx != null && voQrspdjzxx.length > 0) {
				voQrspdjzfhxx = new VoQrspdjzfhxx[voQrspdjzxx.length];
				for (int i = 0; i < voQrspdjzxx.length; i++) {
					poHjspzxx = new PoHJSP_HJSPZB();
					BeanUtils.copyProperties(poHjspzxx, voQrspdjzxx[i]);
					poHjspzxx.setSpsqzid((Long) YWUtils.getId(session,"SID_HJSP_HJSPZB"));
					poHjspzxx.setSpywid(poHjspsqxx.getSpywid());
					HibernateUtil.create(session, poHjspzxx);
					
					// ??????????????????????????????
					voQrspdjzfhxx[i] = new VoQrspdjzfhxx();
					voQrspdjzfhxx[i].setGmsfhm(poHjspzxx.getGmsfhm());
					voQrspdjzfhxx[i].setXm(poHjspzxx.getXm());
					voQrspdjzfhxx[i].setSpsqzid(poHjspzxx.getSpsqzid());
				}
			}

			// ????????????????????????
			if (voSpfdclxx != null && voSpfdclxx.length > 0) {
				for (int i = 0; i < voSpfdclxx.length; i++) {
					PoHJSP_HJSPFDCLB poSpfdclxx = new PoHJSP_HJSPFDCLB();
					poSpfdclxx.setSpclid((Long)YWUtils.getId(session,"SID_HJSP_HJSPFDCLB"));
					poSpfdclxx.setSpywid(poHjspsqxx.getSpywid());
					poSpfdclxx.setSplx(poHjspsqxx.getSplx());
					poSpfdclxx.setClbh(voSpfdclxx[i].getClbh());
					HibernateUtil.create(session, poSpfdclxx);
				}
			}

			// ??????????????????
			Long zqid = null;
			if (spmbid == null) {
				zqid = saveZQZXX(user, session, poHjspsqxx);
			}

			///////////////////////////////////////////////////////
			// ??????????????????????????????
			Long splsid = null;
			if (spmbid == null) { // ??????????????????
				splsid = this.saveHJSPLSXX(user, session, poHjspsqxx.getSpywid(), poHjspsqxx.getSplx(), null, HjConstant.CZJG_TY, null,now);
			}

			// ?????????????????????????????????1
			YWUtils.incSPMBDQSYS(session, spmbid);

			//////////////////////////////////////////////
			// ????????????????????????
			voQrspdjywfhxx = new VoQrspdjywfhxx();
			voQrspdjywfhxx.setSplsid(splsid);
			voQrspdjywfhxx.setGmsfhm(poHjspsqxx.getGmsfhm());
			voQrspdjywfhxx.setSpywid(poHjspsqxx.getSpywid());
			voQrspdjywfhxx.setXm(poHjspsqxx.getXm());
			voQrspdjywfhxx.setZqid(zqid);
			voQrspdjywfhxx.setVoQrspdjzfhxx(voQrspdjzfhxx);

			//////////////////////////////////////////////
			// ????????????
			tran.commit();
			
			try{
				saveQcSuccess(hjywid, qcdq);
			}catch(Exception e){
				throw new ServiceException("?????????????????????????????????????????????");
			}
		} catch (Exception ex) {
			// ????????????
			tran.rollback();
			throw new ServiceException( ex);
		}

		return voQrspdjywfhxx;
	}
	
	/**
	 * ?????????????????????
	 * @param hjywid
	 * @param qcdq
	 * @return
	 */
	private boolean saveQcSuccess(String hjywid,String qcdq){
		Transaction tran = null;
		Session session = null;
		try {
			session = HibernateUtil.getSystemSessionFactory(qcdq).openSession();
			if (session == null)
				throw new ServiceException("??????????????????????????????");

			tran = session.beginTransaction();

			/////////////////////////////////////////////
			// ????????????
			tran.begin();
			
			String hql = "from PoHJYW_QCZXXXB a where a.hjywid=?";
			List list = HibernateUtil.getObjectList(session, hql, new Object[]{Long.parseLong(hjywid)});
			for(Object o:list){
				PoHJYW_QCZXXXB zx = (PoHJYW_QCZXXXB)o;
				zx.setKdqqy_cgbz("1");
				HibernateUtil.update(session, zx);
			}
			
			tran.commit();
			
			return true;
		} catch (Exception ex) {
			// ????????????
			tran.rollback();
			throw new ServiceException( "?????????????????????????????????");
		}
	}
	
	  /**
	   * ?????????????????????
	   * @param poHjspsqxx - ????????????????????????PO
	   * @return - ??????ID
	   * @throws DAOException
	   */
	  private Long saveZQZXX(BaseUser user, Session session, PoHJSP_HJSPSQB poHjspsqxx) {
	    String strHQL = null;
	    PoHJSP_ZQZXXB poZqzxx = null;
	    try {
	      //?????????????????????(2005/01/17 15:40:00)
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
	      //?????????????????????(????????????)
	      strHQL = "from PoHJSP_HJSPZB where spywid=" + poHjspsqxx.getSpywid();
	      List hjspzxxList = HibernateUtil.getObjectList(session,strHQL,null);
	      if (hjspzxxList != null) {
	        while (hjspzxxList.size() > 0) {
	          //?????????????????????
	          poZqzxx = new PoHJSP_ZQZXXB();
	          poZqzxx.setZqid( (Long) YWUtils.getId(session, "SID_HJSP_ZQZXXB"));
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

	    }
	    catch (Exception ex) {
	      throw new ServiceException(ex);
	    }

	    return poZqzxx != null ? poZqzxx.getZqid() : null;
	  }
	  
	  /**
	   * ??????????????????????????????
	   * @param spywid - ????????????ID
	   * @param splx - ????????????
	   * @param dzid - ??????ID
	   * @param czjg - ????????????
	   * @param czyj - ????????????
	   * @param czsj - ????????????
	   * @return - ????????????ID
	   * @throws DAOException
	   * @throws ServiceException
	   */
	  private Long saveHJSPLSXX(BaseUser user, Session session , Long spywid, String splx, Long dzid, String czjg, String czyj, String czsj){
	    Long splsid = null;
	    try {
	      //??????????????????ID
	      splsid = (Long) YWUtils.getId(session, "SID_HJSP_HJSPLSB");
	      //??????????????????????????????
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
	    }catch (Exception ex) {
	      throw new ServiceException( ex);
	    }

	    return splsid;
	  }
}
