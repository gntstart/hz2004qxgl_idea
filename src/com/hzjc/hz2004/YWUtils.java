package com.hzjc.hz2004;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.exception.ServiceException;
import com.hzjc.hz2004.constant.HjConstant;
import com.hzjc.hz2004.constant.PublicConstant;
import com.hzjc.hz2004.constant.ZjConstant;
import com.hzjc.hz2004.po.*;
import com.hzjc.hz2004.vo.*;
import com.hzjc.wsstruts.vo.DefaultVO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.LockMode;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.*;

/**
 * com.hzjc.hz2004.common.HjCommon 对应
 * 
 * @author Administrator
 *
 */
public class YWUtils {
	// 系统数据字典--系统控制参数--系统参数
	public final static String SYS_XT_SJZDB = "XT_SJZDB";
	public final static String SYS_XT_XTKZCSB = "XT_XTKZCSB";
	public final static String SYS_XT_XTCSB = "XT_XTCSB";

	static public String getXTKZCS(Session session, String kzlb) {
		String kzz = null;
		String strHQL = null;
		strHQL = "from PoXT_XTKZCSB where kzlb='" + kzlb + "' ";
		try {
			List<?> lst = HibernateUtil.getObjectList(session, strHQL, new Object[] {});
			if (lst != null && lst.size() > 0) {
				PoXT_XTKZCSB poXT_XTKZCSB = (PoXT_XTKZCSB) lst.get(0);
				kzz = poXT_XTKZCSB.getKzz();
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return kzz != null ? kzz.trim() : "";
	}

	/**
	 * 获取指定session指定seq，参见hz2004服务的/conf/hz2004.id.xml配置DAOFactory.create***DAO(
	 * )的时候指定
	 * 
	 * @param session
	 * @param seq
	 * @return
	 */
	static public Serializable getId(Session session, String seq) {
		return getIdBySequence(session, seq);
	}

	//static private Map<String, VoXT_XTKZCSB> kzMap = new HashMap<String, VoXT_XTKZCSB>();

	public static VoXT_XTKZCSB getXt_xtkzcsb(Session session, String strKzlb) throws ServiceException {
		//if (kzMap.containsKey(strKzlb))
		//	return kzMap.get(strKzlb);

		// ==========================================================
		// 传入的控制类别为空，则返回空VO
		// ==========================================================
		if (strKzlb == null || strKzlb.equals("")) {
			return null;
		}

		// ==========================================================
		// 判断并初始化系统内存中的系统控制参数，得到系统控制该控制类别VO
		// ==========================================================
		String hql = "from PoXT_XTKZCSB a where a.kzlb='" + strKzlb + "'";
		PoXT_XTKZCSB kz = (PoXT_XTKZCSB) HibernateUtil.getObject(session, hql, null);
		VoXT_XTKZCSB vokz = new VoXT_XTKZCSB(kz);
		//if (kz != null)
		//	kzMap.put(strKzlb, vokz);

		return vokz;
	}

	/**
	 * 生成规则：ParseLong[DBID(前3位) + DBID(后6位)] * 10000000000L + SequenceID
	 * 规则修改：ParseLong[DBID(后6位) + DBID(前3位)] * 10000000000L + SequenceID
	 * history: since 2004-06-04
	 *
	 * select SID_HJHIS_LSBGSPZB.nextval from dual;
	 * 
	 * @param name
	 * @return
	 */
	static public Serializable getIdBySequence(Session session, String seq) {
		Serializable ser = null;
		// 组织HQL查询语句
		StringBuffer strBufHQL = new StringBuffer();
		strBufHQL.append("select ").append(seq).append(".nextval from dual");
		try {
			List<?> list = HibernateUtil.executeSqlQuery(session, strBufHQL.toString(), null);
			ser = (Serializable) list.get(0);
			System.out.println("获取序列号：" + seq + "，值为：" + ser);
			/////////////////////////////////////////////////////////////////
			// 取SequenceID的Value
			///////////////////////////////////////////////////////////////////
			long lSeqid = Long.parseLong(ser.toString());
			/////////////////////////////////////////////////////////////////
			// 根据系统控制参数表得到DBID的前3位和DBID的后6位
			/////////////////////////////////////////////////////////////////
			VoXT_XTKZCSB voBefore3 = null;
			VoXT_XTKZCSB voAfter6 = null;
			try {
				voBefore3 = getXt_xtkzcsb(session, PublicConstant.XTKZCS_DBID_BEFORE_3);
				voAfter6 = getXt_xtkzcsb(session, PublicConstant.XTKZCS_DBID_AFTER_6);
			} catch (ServiceException ex) {
				// 从内存中取不到系统控制参数,然后,可以从数据库中取.
			}
			/////////////////////////////////////////////////////////////////
			// 如果为空，则从数据库中取数据
			/////////////////////////////////////////////////////////////////
			if (voBefore3 == null || voAfter6 == null) {
				String strBefore3 = "from PoXT_XTKZCSB  where kzlb='" + PublicConstant.XTKZCS_DBID_BEFORE_3 + "'";
				String strAfter6 = "from PoXT_XTKZCSB  where kzlb='" + PublicConstant.XTKZCS_DBID_AFTER_6 + "'";
				List lstPo3 = HibernateUtil.getObjectList(session, strBefore3, null);// .findAllXT_XTKZCSBs(strBefore3);
				List lstPo6 = HibernateUtil.getObjectList(session, strAfter6, null);
				if (lstPo3 != null && !lstPo3.isEmpty()) {
					voBefore3 = new VoXT_XTKZCSB((PoXT_XTKZCSB) lstPo3.get(0));
				}
				if (lstPo6 != null && !lstPo6.isEmpty()) {
					voAfter6 = new VoXT_XTKZCSB((PoXT_XTKZCSB) lstPo6.get(0));
				}
			}
			////////////////////////////////////////////////////////////////
			// 得到前9位
			/////////////////////////////////////////////////////////////////
			long lID = 0;
			if (voBefore3 != null && voAfter6 != null) {
				if (voBefore3.getKzz() != null && voAfter6.getKzz() != null) {
					// lID =
					// Long.parseLong(voBefore3.getKzz().trim().concat(voAfter6.
					// getKzz().trim()));
					// edit by kgb 2004-06-04
					lID = Long.parseLong(voAfter6.getKzz().trim().concat(voBefore3.getKzz().trim()));

				} else {
					throw new ServiceException("系统控制参数表中，控制参数代码为（9000和9001）对应的数据值没有设置。", null);
				}
			} else {
				throw new ServiceException("系统控制参数表中，控制参数代码为（9000和9001）对应的数据值没有设置。", null);
			}
			/////////////////////////////////////////////////////////////
			// 返回最后取得的ID
			///////////////////////////////////////////////////////////////
			lID = lID * 10000000000L + lSeqid;
			ser = new Long(lID);

			System.out.println("voAfter6=" + voAfter6 + ",voBefore3=" + voBefore3 + "，主键编号：" + ser);
			
			return ser;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	static private void refresh(Session session, Object object, LockMode lockMode) {
		try {
			session.refresh(object, lockMode);
		} catch (Exception ex) {
			throw new ServiceException(ex);
		} finally {
		}
	}

	static public void checkRXX(Session session, PoHJXX_CZRKJBXXB poRyxx, String ywmc) {
		refresh(session, poRyxx, LockMode.UPGRADE); // 锁记录
		if (!(PublicConstant.JLBZ_ZX.equals(poRyxx.getJlbz()) && PublicConstant.CXBZ_FCX.equals(poRyxx.getCxbz()))) {
			throw new ServiceException(
					"时效性错误，" + poRyxx.getXm() + "(" + poRyxx.getGmsfhm() + ")的最新记录可能在操作过程中被其他用户操作过，" + ywmc + "业务无法完成。",
					null);
		}
	}

	static public Long getCount(Session session, String sql) {
		Object obj = HibernateUtil.getObject(session, sql, new Object[] {});
		return (Long) obj;
	}

	static public boolean checkZZBD(Session session, String qrXzqh, String qcXzqh) {
		StringBuffer strHQL = new StringBuffer();
		try {
			strHQL.append("select count(*) from PoXT_BSSQB ").append("where qhdm in ('").append(qrXzqh).append("' ")
					.append(",'").append(qcXzqh).append("') ").append("and qybz='" + PublicConstant.QYBZ_QY + "' ");

			// 迁出地和迁入地都是本市
			long count = getCount(session, strHQL.toString());
			if (count == 2 || qrXzqh.equals(qcXzqh) && count == 1) {
				strHQL = new StringBuffer();
				strHQL.append("select count(*) from PoXT_QYSZB ")
						.append("where qhdma='" + qrXzqh + "' and qhdmb='" + qcXzqh + "' ")
						.append("or qhdma='" + qcXzqh + "' and qhdmb='" + qrXzqh + "' ")
						.append("and qybz='" + PublicConstant.QYBZ_QY + "' ");
				// 迁出地和迁入地不在迁移设置表中
				if (getCount(session, strHQL.toString()) <= 0) {
					return true;
				}
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return false;
	}

	public static String getServiceTime(Session session) {
		String serviceTime = null;
		try {
			String strSQL = "select to_char(sysdate,'yyyymmddhh24miss') from dual ";
			serviceTime = (String) HibernateUtil.executeSqlQuery(session, strSQL, new Object[] {}).get(0);
			if (serviceTime == null) {
				throw new ServiceException("得不到数据库时间，业务失败。", null);
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		// 返回时间
		return serviceTime;
	}

	static public boolean isKeyField(String key) {
		return PublicConstant.HZ2004_SYS_KEY_FIELDS_MAP.containsKey(key);
	}

	static public long countCHRYXX(Session session, String gmsfhm) {
		long count = 0;
		String strHQL = new String();
		if (gmsfhm == null) {
			return 0;
		}
		strHQL = "select count(*) from PoHJXX_CZRKJBXXB where gmsfhm='" + gmsfhm + "' and jlbz='"
				+ PublicConstant.JLBZ_ZX + "' and cxbz='" + PublicConstant.CXBZ_FCX + "' and ryzt='"
				+ HjConstant.RYZT_ZC + "' ";
		count = getCount(session, strHQL);
		return count;
	}

	static public List getRYXX(Session session, String gmsfhm) {
		StringBuffer strHQL = new StringBuffer();
		List ryxxList = null;
		strHQL.append("from PoHJXX_CZRKJBXXB ").append("where gmsfhm='" + gmsfhm + "' ")
				.append("and jlbz='" + PublicConstant.JLBZ_ZX + "' ");
		// .append("and cxbz='" + PublicConstant.CXBZ_FCX + "' ");
		try {
			ryxxList = HibernateUtil.getObjectList(session, strHQL.toString(), null);
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		return ryxxList;
	}

	/**
	 * 根据详信息分配公民身份号码
	 * 
	 * @param hjywid
	 *            - 户籍业务ID
	 * @param strKsd
	 *            - 开始段
	 * @param strJsd
	 *            - 结束段
	 * @param sfhm6xzqh
	 *            - 身份号码前的6位行政区划
	 * @param voGmsfhmfpsqxx
	 *            - 公民身份号码分配申请信息
	 * @return VoGmsfhmfpfhxx - 公民身份号码分配返回信息(如果返回null则表示尾数段用光)
	 */
	static public VoGmsfhmfpfhxx assignGMSFHM(Session session, Long hjywid, String strKsd, String strJsd,
			String sfhm6xzqh, VoGmsfhmfpsqxx voGmsfhmfpsqxx, String psNow) {
		String errInfo;
		VoGmsfhmfpfhxx voGmsfhmfpfhxx = null;
		StringBuffer strHQL = new StringBuffer();
		List yfpdwsxxList = null; // 已分配的尾数信息
		String now = psNow;
		if (psNow == null || "".equals(psNow)) {
			now = getServiceTime(session);
		}

		try {
			// strKsd补零(格式化成三位的,前加0)
			String strZero = new String();
			for (int i = 0; i < (3 - strKsd.length()); i++) {
				strZero = strZero + "0";
			}
			strKsd = strZero.concat(strKsd);

			// strJsd补零(格式化成三位的,前加0)
			strZero = new String();
			for (int i = 0; i < (3 - strJsd.length()); i++) {
				strZero = strZero + "0";
			}
			strJsd = strZero.concat(strJsd);

			//////////////////////////////////////////////////
			// 得到身份号码前6位相同且同一天出生并且性别相同的已分配的尾数信息
			strHQL.append("from PoHJYW_GMSFHMSXMFPXXB ")
					.append("where gmsfhm like '" + sfhm6xzqh + voGmsfhmfpsqxx.getCsrq() + "%' ")
					.append("and xb='" + voGmsfhmfpsqxx.getXb() + "' ")
					.append("and sxh >= '" + strKsd + "' and sxh <='" + strJsd + "' ").append("order by sxh desc");
			yfpdwsxxList = HibernateUtil.getPageRecords(session, strHQL.toString(), null, 0, 1).getList();
			int nKsd = Integer.valueOf(strKsd).intValue();
			int nJsd = Integer.valueOf(strJsd).intValue();
			int nSXH = nKsd;

			// 按最大值分配(2005/05/25 11:55:00 By MHB)
			boolean bYFPWS = false;
			if (yfpdwsxxList != null && yfpdwsxxList.size() > 0) {
				PoHJYW_GMSFHMSXMFPXXB po = (PoHJYW_GMSFHMSXMFPXXB) yfpdwsxxList.get(0);
				nSXH = Integer.parseInt(po.getSxh());
				bYFPWS = true;
			}

			// 调整男女奇偶数
			// 男
			if (voGmsfhmfpsqxx.getXb().equalsIgnoreCase(HjConstant.RYXB_NA)) {
				// 取奇数
				if ((nSXH % 2) == 0) {
					nSXH = nSXH + 1;
				} else if (bYFPWS) {
					nSXH += 2;
				}
			}
			// 女
			else if (voGmsfhmfpsqxx.getXb().equalsIgnoreCase(HjConstant.RYXB_NV)) {
				// 取偶数
				if ((nSXH % 2) == 1) {
					nSXH = nSXH + 1;
				} else if (bYFPWS) {
					nSXH += 2;
				}
			}
			// 性别不确定，无法分配身份号码
			else {
				throw new ServiceException("性别错误，无法分配身份号码。", null);
			}

			// 尾数段计算
			while (nSXH <= nJsd) {

				String strSXH = String.valueOf(nSXH);
				strZero = new String();
				for (int i = 0; i < (3 - strSXH.length()); i++) {
					strZero = strZero + "0";
				}
				// 生成18位的公民身份号码
				StringBuffer sfhm17 = new StringBuffer();
				sfhm17.append(sfhm6xzqh).append(voGmsfhmfpsqxx.getCsrq()).append(strZero).append(strSXH);
				String sfhm18 = PID.IDConver(sfhm17.toString());
				// 检查该公民身份号码是否是已分配的，如果是已分配的则保存尾数分配信息
				List ryxxList = getRYXX(session, sfhm18);
				if (ryxxList != null && ryxxList.size() > 0) {
					// 保存尾数分配信息
					for (int i = 0; i < ryxxList.size(); i++) {
						PoHJXX_CZRKJBXXB poRxx = (PoHJXX_CZRKJBXXB) ryxxList.get(i);
						// 处理重号只填其一的尾数(2005/05/24 17:00:00 By MHB)
						strHQL = new StringBuffer(512);
						strHQL.append("select count(*) from PoHJYW_GMSFHMSXMFPXXB where gmsfhm='")
								.append(poRxx.getGmsfhm()).append("'");
						if (getCount(session, strHQL.toString()) > 0) {
							continue;
						}
						// 保存尾数分配信息
						PoHJXX_MLPXXXXB poDxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poRxx.getMlpnbid());
						PoHJYW_GMSFHMSXMFPXXB poFpxx = new PoHJYW_GMSFHMSXMFPXXB();
						poFpxx.setFpid((Long) getId(session, "SID_HJYW_GMSFHMSXMFPXXB"));
						poFpxx.setRyid(poRxx.getRyid());
						poFpxx.setCsrq(poRxx.getCsrq());
						poFpxx.setXm(poRxx.getXm());
						poFpxx.setGmsfhm(poRxx.getGmsfhm());
						poFpxx.setXb(voGmsfhmfpsqxx.getXb());
						poFpxx.setDwdm(poDxx.getPcs());
						poFpxx.setSxh(strZero + strSXH);
						poFpxx.setCzlb(HjConstant.GMSFHMFPWS_CZLB_QT);
						poFpxx.setHjywid(hjywid);
						HibernateUtil.create(session, poFpxx);
					}
				}
				// 分配成功
				else {
					// 保存尾数分配信息
					PoHJYW_GMSFHMSXMFPXXB poFpxx = new PoHJYW_GMSFHMSXMFPXXB();
					poFpxx.setFpid((Long) getId(session, "SID_HJYW_GMSFHMSXMFPXXB"));
					poFpxx.setRyid(voGmsfhmfpsqxx.getRyid());
					poFpxx.setCsrq(voGmsfhmfpsqxx.getCsrq());
					poFpxx.setXm(voGmsfhmfpsqxx.getXm());
					poFpxx.setGmsfhm(sfhm18);
					poFpxx.setXb(voGmsfhmfpsqxx.getXb());
					poFpxx.setDwdm(voGmsfhmfpsqxx.getPcs());
					poFpxx.setSxh(strZero + strSXH);
					poFpxx.setCzlb(HjConstant.GMSFHMFPWS_CZLB_FP);
					poFpxx.setHjywid(hjywid);
					HibernateUtil.create(session, poFpxx);

					voGmsfhmfpfhxx = new VoGmsfhmfpfhxx();
					voGmsfhmfpfhxx.setFpid(poFpxx.getFpid());
					voGmsfhmfpfhxx.setGmsfhm(poFpxx.getGmsfhm());

					break;
				} // 分配成功

				// 取下一个顺序号
				nSXH += 2;
			}

		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return voGmsfhmfpfhxx;
	}

	/**
	 * 分配公民身份号码
	 * 
	 * @param hjywid
	 *            - 户籍业务ID
	 * @param voGmsfhmfpsqxx
	 *            - 公民身份号码分配申请信息
	 * @return VoGmsfhmfpfhxx - 公民身份号码分配返回信息
	 * @throws ServiceException
	 * @throws DAOException
	 */
	static public synchronized VoGmsfhmfpfhxx assignGMSFHM(Session session, Long hjywid, VoGmsfhmfpsqxx voGmsfhmfpsqxx,
			String psNow) {
		String errInfo;
		VoGmsfhmfpfhxx voGmsfhmfpfhxx = null;
		StringBuffer strHQL = new StringBuffer();
		List lnwsdList = null; // 历年尾数段List
		int nWsdCount = 0;
		String now = psNow;
		if (psNow == null || "".equals(psNow)) {
			now = getServiceTime(session);
			// 数据校验
		}
		if (hjywid == null || voGmsfhmfpsqxx == null || voGmsfhmfpsqxx.getCsrq() == null
				|| voGmsfhmfpsqxx.getPcs() == null || voGmsfhmfpsqxx.getRyid() == null || voGmsfhmfpsqxx.getXb() == null
				|| voGmsfhmfpsqxx.getXzqh() == null) {
			return null;
		}

		try {
			///////////////////////////////////////////////////
			// 得到该单位(出生日期)的尾数段分配信息
			// 按乡镇街道分配尾数(2005/05/09 10:10:00 By MHB)
			strHQL.append("from PoXT_LNWSDB ").append("where xzjd='" + voGmsfhmfpsqxx.getXzjd() + "' ")
					.append("and qyrq <='" + voGmsfhmfpsqxx.getCsrq() + "' ").append("order by qyrq desc");
			lnwsdList = HibernateUtil.getObjectList(session, strHQL.toString(), null);
			// 如果按乡镇街道分配尾数没有设置则按派出所分配尾数
			if (lnwsdList == null || (lnwsdList != null && lnwsdList.size() <= 0)) {
				strHQL = new StringBuffer();
				strHQL.append("from PoXT_LNWSDB ").append("where dwdm='" + voGmsfhmfpsqxx.getPcs() + "' ")
						.append("and qyrq <='" + voGmsfhmfpsqxx.getCsrq() + "' ").append("order by qyrq desc");
				lnwsdList = HibernateUtil.getObjectList(session, strHQL.toString(), null);
			}
			// 有设置尾数
			if (lnwsdList != null && lnwsdList.size() > 0) {
				String qyrq = ((PoXT_LNWSDB) lnwsdList.get(0)).getQyrq();
				nWsdCount = 1;
				// 统计与第一个“启用日期”相同的个数
				for (int i = 1; i < lnwsdList.size(); i++) {
					PoXT_LNWSDB po = (PoXT_LNWSDB) lnwsdList.get(i);
					if (!qyrq.equals(po.getQyrq())) {
						break;
					}
					nWsdCount++;
				} // for
			}
			// 没有设置尾数段
			else {
				errInfo = "该单位（" + voGmsfhmfpsqxx.getPcs() + "）出生日期为" + voGmsfhmfpsqxx.getCsrq()
						+ "的身份号码历年尾数段没有设置，无法分配身份号码。";
				throw new ServiceException(errInfo, null);
			}

			/////////////////////////////////////////////////////////////
			// 分配身份号码
			for (int i = 0; i < nWsdCount; i++) {
				PoXT_LNWSDB po = (PoXT_LNWSDB) lnwsdList.get(i);
				// assignGMSFHM
				voGmsfhmfpfhxx = assignGMSFHM(session, hjywid, po.getKsd().trim(), po.getJsd().trim(), po.getQhdm(),
						voGmsfhmfpsqxx, now);
				// 分配成功
				if (voGmsfhmfpfhxx != null) {
					break;
				}
			}

			// 尾数用完
			if (voGmsfhmfpfhxx == null) {
				errInfo = "该单位（" + voGmsfhmfpsqxx.getPcs() + "）出生日期为" + voGmsfhmfpsqxx.getCsrq()
						+ "的身份号码历年尾数用完，无法分配身份号码。";
				throw new ServiceException(errInfo, null);
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return voGmsfhmfpfhxx;
	}

	/**
	 * 保存证件业务流水信息
	 * 
	 * @param ywbz
	 *            - 业务标志
	 * @param czsj
	 *            - 操作时间
	 * @throws ServiceException
	 * @throws DAOException
	 */
	static public void saveZJYWLSXX(Session session, String ywbz, String slzt, String slh, String czsj) {
		try {
			BaseUser user = BaseUser.getCurrent();

			PoZJLS_SFZYWCZB poSfzywczxx = new PoZJLS_SFZYWCZB();
			poSfzywczxx.setZjywid((Long) getId(session, "SID_ZJLS_SFZYWCZB"));
			poSfzywczxx.setYwbz(ywbz);
			poSfzywczxx.setCzyid(user.getOtherParams().getLong("yhid"));
			poSfzywczxx.setSlzt(slzt);
			poSfzywczxx.setSlh(slh);
			poSfzywczxx.setCzyxm(user.getOtherParams().getString("yhxm"));
			poSfzywczxx.setCzsj(czsj);
			poSfzywczxx.setCzip(BaseContext.getContext().getRequest().getRemoteAddr());
			HibernateUtil.create(session, poSfzywczxx);
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return;
	}

	/**
	 * 判断变更更正控制标志(判断变更更正项目是否需要保存变更更正信息)
	 * 
	 * @param xm
	 *            - 项目
	 * @return
	 */
	static public boolean checkBGGZ_DYKZBZ(Session session, String xm) {
		String strHQL = null;
		boolean bRET = true;
		try {
			strHQL = "from PoHJXZ_BGDYZDKZB where kzbz='" + HjConstant.BGGZ_KZBZ_BYX + "' and zdmc='" + xm + "'";
			List lst = HibernateUtil.getObjectList(session, strHQL, null);
			if (lst != null && lst.size() > 0) {
				bRET = false;
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		return bRET;
	}

	static public PoXT_XTCSB getXTCSB(Session session, String cslb, String dm) {
		PoXT_XTCSB poXtcsb = null;
		String strHQL = null;
		try {
			strHQL = "from PoXT_XTCSB where cslb='" + cslb + "' and trim(dm)='" + dm + "' ";
			List xtcsbList = HibernateUtil.getObjectList(session, strHQL, null);
			if (xtcsbList != null && xtcsbList.size() > 0) {
				poXtcsb = (PoXT_XTCSB) xtcsbList.get(0);
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return poXtcsb;
	}

	/**
	 * 翻译变更更正项目
	 * 
	 * @param xm
	 * @param dm
	 * @return
	 * @throws ServiceException
	 * @throws DAOException
	 */
	static public String[] transBGGZXM(Session session, String xm, String dm) {
		String strRET[] = new String[2];
		String strHQL = null;
		try {
			PoXT_XTCSB poXtcsb = getXTCSB(session, PublicConstant.XTKZCS_BGGZXM, xm);
			if (poXtcsb != null) {
				strRET[0] = poXtcsb.getMc();
				// 系统参数表
				if ("XT_XTCSB".equalsIgnoreCase(poXtcsb.getKzbzc())) {
					strHQL = "from PoXT_XTCSB where cslb='" + poXtcsb.getKzbzd() + "' and trim(dm)='" + dm + "' ";
					List xtcsbList = HibernateUtil.getObjectList(session, strHQL, null);
					if (xtcsbList != null && xtcsbList.size() > 0) {
						PoXT_XTCSB po = (PoXT_XTCSB) xtcsbList.get(0);
						strRET[1] = po.getMc();
					}
				} else if ("XT_XZQHB".equalsIgnoreCase(poXtcsb.getKzbzc())) {
					strHQL = "from PoXT_XZQHB where dm='" + dm + "' ";
					List xzqhList = HibernateUtil.getObjectList(session, strHQL, null);
					if (xzqhList != null && xzqhList.size() > 0) {
						PoXT_XZQHB po = (PoXT_XZQHB) xzqhList.get(0);
						strRET[1] = po.getMc();
					}
				}
				// 胡斌 20060530 非代码类也填写入bgqdm,bghdm
				else if (poXtcsb.getKzbzc() == null) {
					strRET[1] = dm;
				}
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return strRET;
	}

	/**
	 * 处理变更更正信息
	 * 
	 * @param hjywid
	 *            - 户籍业务ID
	 * @param voSbjbxx
	 *            - 申报基本信息
	 * @param voBggzxxEx
	 *            - 变更更正信息
	 * @param poRyxxNew
	 *            - 需要变更更正的人员信息Po(rynbid是新分配的id)
	 * @param gnbh
	 *            - 功能编号
	 * @return
	 * @throws DAOException
	 * @throws ServiceException
	 */
	// modi by hh 20060322 增加参数psNow,使每个业务的操作时间一致
	static public VoBggzfhxxEx disposalBggzxx(Session session, Long hjywid, VoSbjbxx voSbjbxx, VoBggzxxEx voBggzxxEx,
			PoHJXX_CZRKJBXXB poRyxxNew, String gnbh, String psNow) {
		BaseUser user = BaseUser.getCurrent();

		VoBggzfhxxEx voBggzfhxxEx = null;
		List yhzgxList = new ArrayList();
		VoHcygxtzfhxx voHcygxtzfhxx[] = null;
		List bggzfhxxList = new ArrayList();
		String now = psNow;
		if (psNow == null || "".equals(psNow)) {
			now = getServiceTime(session);
		}

		if (voBggzxxEx == null || poRyxxNew == null || (voBggzxxEx != null && voBggzxxEx.getBggzxxList() != null
				&& voBggzxxEx.getBggzxxList().size() < 1)) {
			return null;
		}

		String bgqxm = poRyxxNew.getXm();
		String bgqgmsfhm = poRyxxNew.getGmsfhm();

		try {
			/////////////////////////////////////////////
			// 得到户信息
			PoHJXX_HXXB poHxx = HibernateUtil.get(session, PoHJXX_HXXB.class, poRyxxNew.getHhnbid());
			if (poHxx == null) {
				throw new ServiceException("数据库中没有找到变更更正人员对应的户信息，变更更正业务无法完成。", null);
			}

			////////////////////////////////////////////
			// 得到地信息
			PoHJXX_MLPXXXXB poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poRyxxNew.getMlpnbid());
			if (poMlpxxxx == null) {
				throw new ServiceException("数据库中没有找到变更更正人员对应的地信息，变更更正业务无法完成。", null);
			}

			///////////////////////////////////////
			// 数据范围限制, 跨地市迁出，数据范围忽略
			/*
			 * if (!PublicConstant.GNBH_HJ_ZZBDYW.equals(gnbh) &&
			 * !PublicConstant.GNBH_CX_HJZXYW.equals(gnbh) &&
			 * !PublicConstant.GNBH_CX_HJHFYW.equals(gnbh)) { List sjfwList =
			 * new ArrayList(); VoXtsjfw voXtsjfw = new VoXtsjfw();
			 * voXtsjfw.setSjfw(poMlpxxxx.getJcwh());
			 * voXtsjfw.setSjfwbz(PublicConstant.XT_QX_JWH);
			 * sjfwList.add(voXtsjfw); boolean bLimit = false; bLimit =
			 * XtywqxServiceImpl.VerifyDataRange(this.getUserInfo().getYhid().
			 * toString(), PublicConstant.GNBH_HJ_BGGZYW, sjfwList); if
			 * (!bLimit) { throw new
			 * ServiceException(WSErrCode.ERR_SERVICE_BUSSINESSLIMIT,
			 * "数据范围被限制，变更更正业务无法完成。", null); } }
			 */

			/*
			 * //非"变更审批结果处理业务"才判断审批是否受限 if
			 * (!PublicConstant.GNBH_SP_BGSPJGCLYW.equals(gnbh)) { //变更审批限制处理
			 * VoRhdxx voRhdxxSP = new VoRhdxx(poRyxxNew, poHxx, poMlpxxxx,
			 * this.getUserInfo()); VoXtywxz voLimitSP =
			 * XtywqxServiceImpl.VerifyBggzSpLimit(PublicConstant.
			 * GNBH_HJ_BGGZYW, voRhdxxSP, voBggzxxEx.getBggzxxList()); if
			 * (voLimitSP.getLimitflag()) { throw new
			 * ServiceException(WSErrCode.ERR_SERVICE_BGGZSXYSP,
			 * "变更更正业务审批受限，受限信息：" + voLimitSP.getLimitinfo() + ";对应的审批模板ID：" +
			 * voLimitSP.getSpmbid(), null); } voRhdxxSP = null; }
			 */

			/*
			 * 变更更正公民身份号码时依赖人信息中的出生日期(csrq)、性别(xb)、
			 * 姓名(xm)、省市县区(ssxq)、派出所(pcs)五项目信息，而在变更更
			 * 正中有可能变更其中的项目，分配新公民身份号码时要用到上述变更后 的信息，所以将变更更正公民身份号码放置到最后进行变更处理。
			 */
			// 将变更更正项目公民身份号码放置到最后
			int max = voBggzxxEx.getBggzxxList().size() - 1;
			for (int i = 0; i < max; i++) {
				VoBggzxx vo = (VoBggzxx) voBggzxxEx.getBggzxxList().get(i);
				if ("gmsfhm".equalsIgnoreCase(vo.getBggzxm())) {
					VoBggzxx last_vo = (VoBggzxx) voBggzxxEx.getBggzxxList().get(max);
					voBggzxxEx.getBggzxxList().set(i, last_vo);
					voBggzxxEx.getBggzxxList().set(max, vo);
					break;
				}
			}

			/////////////////////////////////////////////////////////
			// 处理变更更正项目s
			for (int i = 0; i < voBggzxxEx.getBggzxxList().size(); i++) {
				VoBggzxx voBggzxx = (VoBggzxx) voBggzxxEx.getBggzxxList().get(i);
				VoHcygxtzxxEx voHcygxtzxxEx = null;
				String bggzqnr = null; // 变更更正前内容
				String bggzhnr = null; // 变更更正后内容
				String bggzxm = null; // 变更更正项目

				// 校验
				if (voBggzxx == null || (voBggzxx != null && voBggzxx.getBggzxm() == null) || (voBggzxx != null
						&& voBggzxx.getBggzxm() != null && isKeyField(voBggzxx.getBggzxm().toUpperCase()))) {
					continue;
				}

				// 得到变更更正项目
				bggzxm = voBggzxx.getBggzxm();
				// 得到变更更正后内容
				bggzhnr = voBggzxx.getBggzhnr();

				// 变更:公民身份号码
				if (bggzxm != null && bggzxm.equalsIgnoreCase("gmsfhm")) {
					// 得到变更更正前内容
					bggzqnr = poRyxxNew.getGmsfhm();

					// 重号信息消除
					String strHQL = "from PoHJYW_CHCLXXB as HJYW_CHCLXXB where clfs='" + HjConstant.CHCLFS_WCL
							+ "' and chsfhm='" + bggzqnr + "' and cxbz='" + PublicConstant.CXBZ_FCX + "' ";
					List chxxList = HibernateUtil.getObjectList(session, strHQL, null);
					if (chxxList != null) {
						for (int j = 0; j < chxxList.size(); j++) {
							PoHJYW_CHCLXXB poChclxx = (PoHJYW_CHCLXXB) chxxList.get(j);
							// 与别人重
							if (poRyxxNew.getRyid().equals(poChclxx.getRyid())) {
								poChclxx.setClfs(HjConstant.CHCLFS_BRZHXG);
								poChclxx.setClhjywid(hjywid);
								HibernateUtil.update(session, poChclxx);
							}
							// 别人与自己重
							if (poRyxxNew.getRyid().equals(poChclxx.getBchryid())) {
								poChclxx.setClfs(HjConstant.CHCLFS_DFZHXG);
								poChclxx.setClhjywid(hjywid);
								HibernateUtil.update(session, poChclxx);
							}
						} // for (int j = 0; j < chxxList.size(); j++)
					}

					// 校验身份号码、重号判断及保存身份号码尾数
					if (bggzhnr != null && bggzhnr.length() > 0) {
						// 身份号码校验
						if (!PID.IDCheck(bggzhnr)) {
							throw new ServiceException("公民身份号码(" + bggzhnr + ")有误，变更更正业务无法完成。", null);
						}

						// 重号判断
						if (countCHRYXX(session, bggzhnr) > 0) {
							throw new ServiceException("公民身份号码(" + bggzhnr + ")重号，变更更正业务无法完成。", null);
						}

						// 保存身份号码尾数信息
						strHQL = "select count(*) from PoHJYW_GMSFHMSXMFPXXB where gmsfhm='" + bggzhnr + "'";
						if (getCount(session, strHQL) <= 0) {
							PoHJYW_GMSFHMSXMFPXXB poFpxx = new PoHJYW_GMSFHMSXMFPXXB();
							Long fpid = (Long) getId(session, "SID_HJYW_GMSFHMSXMFPXXB");
							poFpxx.setFpid(fpid);
							poFpxx.setRyid(poRyxxNew.getRyid());
							poFpxx.setCsrq(poRyxxNew.getCsrq());
							poFpxx.setXm(poRyxxNew.getXm());
							poFpxx.setGmsfhm(bggzhnr);
							poFpxx.setXb(poRyxxNew.getXb());
							poFpxx.setDwdm(poMlpxxxx.getPcs());
							poFpxx.setSxh(bggzhnr.substring(14, 17));
							poFpxx.setCzlb(HjConstant.GMSFHMFPWS_CZLB_LR);
							poFpxx.setHjywid(hjywid);
							HibernateUtil.create(session, poFpxx);
						}

						poRyxxNew.setGmsfhm(bggzhnr);
					}
					// 没有身份号码，分配新的身份号码
					else {
						VoGmsfhmfpfhxx voGmsfhmfpfhxx = null;
						VoGmsfhmfpsqxx voGmsfhmfpsqxx = new VoGmsfhmfpsqxx();

						// 设置公民身份号码分配申请信息
						voGmsfhmfpsqxx.setCsrq(poRyxxNew.getCsrq());
						voGmsfhmfpsqxx.setRyid(poRyxxNew.getRyid());
						voGmsfhmfpsqxx.setXb(poRyxxNew.getXb());
						voGmsfhmfpsqxx.setXm(poRyxxNew.getXm());
						voGmsfhmfpsqxx.setXzqh(poMlpxxxx.getSsxq());
						voGmsfhmfpsqxx.setPcs(poMlpxxxx.getPcs());
						voGmsfhmfpsqxx.setXzjd(poMlpxxxx.getXzjd());

						// 调用公民身份号码分配功能
						voGmsfhmfpfhxx = assignGMSFHM(session, hjywid, voGmsfhmfpsqxx, now);
						if (voGmsfhmfpfhxx == null || (voGmsfhmfpfhxx != null && voGmsfhmfpfhxx.getGmsfhm() == null)
								|| (voGmsfhmfpfhxx != null && voGmsfhmfpfhxx.getGmsfhm() != null
										&& voGmsfhmfpfhxx.getGmsfhm().length() != 18)) {
							throw new ServiceException("分配公民身份号码失败，变更更正业务无法完成。", null);
						}

						bggzhnr = voGmsfhmfpfhxx.getGmsfhm();
						poRyxxNew.setGmsfhm(bggzhnr);
					}
				}
				//////////////////////////////////////////////////
				// 变更:照片
				else if (bggzxm != null && bggzxm.equalsIgnoreCase("zp")) {
					VoHJXX_RYZPXXB voRyzpxx = null;
					// 得到变更更正前内容
					bggzqnr = null; // BeanUtils.getProperty(poRyxxNew, "zpid");

					// 非"变更审批结果处理业务"的照片处理
					if (!PublicConstant.GNBH_SP_BGSPJGCLYW.equalsIgnoreCase(gnbh)) {
						if (voBggzxx.getZp() != null && voBggzxx.getZp().length() > 0) {
							// 保存照片数据
							Long zpid = (Long) getId(session, "SID_HJXX_RYZPXXB");
							voRyzpxx = new VoHJXX_RYZPXXB();
							voRyzpxx.setZpid(zpid);
							voRyzpxx.setLrrq(now);
							voRyzpxx.setRyid(poRyxxNew.getRyid());
							voRyzpxx.setXm(poRyxxNew.getXm());
							voRyzpxx.setGmsfhm(poRyxxNew.getGmsfhm());
							// voRyzpxx.setZp(bggzhnr);
							voRyzpxx.setZp(voBggzxx.getZp());
							HibernateUtil.create(session, voRyzpxx.toPoHJXX_RYZPXXB());

							bggzhnr = null; // zpid.toString();
							poRyxxNew.setZpid(zpid);
						} else {
							throw new ServiceException("变更更正项目为照片却没发送照片数据，变更更正业务无法完成。", null);
						}
					}
					// "变更审批结果处理业务"的照片处理
					else {
						poRyxxNew.setZpid(Long.valueOf(voBggzxx.getBggzhnr()));
					}

					// 修改证件受理信息
					String strHQL = "from PoZJYW_SLXXB where ryid=" + poRyxxNew.getRyid() + " and (slzt='"
							+ ZjConstant.ZJ_BLBZ_2ID_CS + "' or slzt='" + ZjConstant.ZJ_BLBZ_2ID_SJWZ + "') ";
					List slxxList = HibernateUtil.getObjectList(session, strHQL, null);// .findAllZJYW_SLXXBs(strHQL);
					if (slxxList != null) {
						for (int a = 0; a < slxxList.size(); a++) {
							PoZJYW_SLXXB poSlxx = (PoZJYW_SLXXB) slxxList.get(a);
							poSlxx.setZpid(poRyxxNew.getZpid());
							poSlxx.setSlzt(ZjConstant.ZJ_BLBZ_2ID_SJWZ);
							HibernateUtil.update(session, poSlxx);

							// 保存照片到拍照临时表(2005/04/25 17:40:00 By MHB)
							if (voBggzxx.isSfbczpdzplsb()) {
								VoHJXX_ZPLSB voZplsxx = new VoHJXX_ZPLSB();
								voZplsxx.setZplsid((Long) getId(session, "SID_HJXX_ZPLSB"));
								voZplsxx.setSlh(poSlxx.getSlh());
								voZplsxx.setGmsfhm(poRyxxNew.getGmsfhm());
								voZplsxx.setRyid(poSlxx.getRyid());
								voZplsxx.setRynbid(poSlxx.getRynbid());
								voZplsxx.setZp(voRyzpxx != null ? voRyzpxx.getZp() : null);
								voZplsxx.setZpid(voRyzpxx != null ? voRyzpxx.getZpid() : null);
								voZplsxx.setCzrid(user.getOtherParams().getLong("yhid"));
								voZplsxx.setBcsj(now);
								HibernateUtil.create(session, voZplsxx.toPoHJXX_ZPLSB());
							}

							// 保存证件业务流水信息
							saveZJYWLSXX(session, PublicConstant.GNBH_HJ_BGGZYW, poSlxx.getSlzt(), poSlxx.getSlh(),
									now);
						} // for (int a = 0; a < slxxList.size(); a++) {
					} // if (slxxList != null) {

					bggzhnr = null;
				}
				////////////////////////////////////////////////////////////
				// 变更:与户主关系
				else if (bggzxm != null && bggzxm.equalsIgnoreCase("yhzgx")) {
					// 得到变更更正前内容
					bggzqnr = poRyxxNew.getYhzgx();

					// 生成变更更正人员信息的户关系调整信息
					voHcygxtzxxEx = new VoHcygxtzxxEx();
					if (voBggzxxEx.getFlag() == 1 || voBggzxxEx.getFlag() == -1) {
						voHcygxtzxxEx.setFlag(0); // 是否需要修改常住人口信息表中的对应记录(0-不修改/1-修改)
						voHcygxtzxxEx.setHcybdlx(HjConstant.HCYBDLX_JTGXBD);
						voHcygxtzxxEx.setHcybdlb(voBggzxx.getBggzlb());
						voHcygxtzxxEx.setOld_yhzgx(bggzqnr); // 变更前
						voHcygxtzxxEx.setYhzgx(bggzhnr); // 变更后
						voHcygxtzxxEx.setRynbid(voBggzxx.getRynbid());
						voHcygxtzxxEx.setRyid(poRyxxNew.getRyid());
						voHcygxtzxxEx.setHhnbid(poRyxxNew.getHhnbid());
						voHcygxtzxxEx.setNew_rynbid(poRyxxNew.getRynbid());
						voHcygxtzxxEx.setGmsfhm(poRyxxNew.getGmsfhm());
						voHcygxtzxxEx.setXm(poRyxxNew.getXm());
						voHcygxtzxxEx.setSbhjywid(null);
						yhzgxList.add(voHcygxtzxxEx);
					}

					poRyxxNew.setYhzgx(bggzhnr);
				}
				////////////////////////////////////////////////////////////
				// 变更:其它项目
				else {
					// 得到变更更正前内容
					bggzqnr = BeanUtils.getProperty(poRyxxNew, bggzxm);
					BeanUtils.setProperty(poRyxxNew, bggzxm, bggzhnr);
				}

				// 变更"与户主关系"不允许生成变更更正信息(不允许打印的不需保存变更更正信息)
				if (voHcygxtzxxEx == null && checkBGGZ_DYKZBZ(session, bggzxm.toUpperCase())) {
					// 保存变更更正信息
					PoHJYW_BGGZXXB poBggzxx = new PoHJYW_BGGZXXB();
					if (voSbjbxx != null) {
						BeanUtils.copyProperties(poBggzxx, voSbjbxx);
					}
					poBggzxx.setBggzid((Long) getId(session, "SID_HJYW_BGGZXXB"));
					poBggzxx.setRynbid(poRyxxNew.getRynbid());
					poBggzxx.setRyid(poRyxxNew.getRyid());
					poBggzxx.setBgqxm(bgqxm);
					poBggzxx.setBgqgmsfhm(bgqgmsfhm);
					// add by mhb 2005/06/27 15:21:00
					String qnr = bggzqnr == null ? "" : bggzqnr;
					String hnr = bggzhnr == null ? "" : bggzhnr;
					String bgxm = bggzxm == null ? "" : bggzxm;
					if (!bgxm.toUpperCase().equals("ZP") && hnr.equals(qnr)) {
						throw new ServiceException("不允许变更前后内容相同，变更更正业务无法完成。", null);
					}

					// poBggzxx.setBggzlb(this.converBGGZLB(bggzxm,
					// voBggzxx.getBggzlb()));
					poBggzxx.setBggzlb(voBggzxx.getBggzlb());
					poBggzxx.setBggzrq(voBggzxx.getBggzrq() != null ? voBggzxx.getBggzrq() : now.substring(0, 8));
					// 变更前内容
					String st[] = transBGGZXM(session, bggzxm.toUpperCase(), bggzqnr);
					if (st != null) {
						poBggzxx.setBggzxm(st[0] != null ? st[0] : bggzxm.toUpperCase());
						poBggzxx.setBggzqnr(st[1] != null ? st[1] : bggzqnr);
						// add by hh20051220 变更更正表中增加变更前,后代码
						poBggzxx.setBggzqdm(st[1] != null ? bggzqnr : null);
					}
					// 变更后内容
					st = transBGGZXM(session, bggzxm.toUpperCase(), bggzhnr);
					if (st != null) {
						poBggzxx.setBggzhnr(st[1] != null ? st[1] : bggzhnr);
						// add by hh20051220 变更更正表中增加变更前,后代码
						poBggzxx.setBggzhdm(st[1] != null ? bggzhnr : null);
					}
					// add by hh20051220 如果变更后的省市县区的代码为0开头(外国),则清空
					// 胡斌 20110919 判断变更省市县是否是变更成国家，如果是,且变更前不为空，BGGZ表中增加记录
					if (bggzxm.trim().toUpperCase().indexOf("SSXQ") > 0) {
						if (bggzhnr != null && bggzhnr.trim().charAt(0) == '0' && bggzqnr != null) {
							// CDSSSXQ,JGDSSXQ，由省市县变更为国家代码，则清空变更更正后内容
							poBggzxx.setBggzhdm(null);
							poBggzxx.setBggzhnr(null);
						} else if (bggzqnr != null && bggzqnr.trim().charAt(0) == '0' && bggzhnr != null) {
							// CDSSSXQ,JGDSSXQ，由国家代码变更为省市县，则清空变更更正前内容
							poBggzxx.setBggzqdm(null);
							poBggzxx.setBggzqnr(null);
						}
					}

					// add by hh 20051017 在变更更正业务表中增加人员的部分信息
					BeanUtils.copyProperties(poBggzxx, poRyxxNew);

					poBggzxx.setDybz(HjConstant.DYBZ_WDY);
					poBggzxx.setHjywid(hjywid);
					// poBggzxx.setSldw(this.getUserInfo().getDwdm());
					// poBggzxx.setSlrid(this.getUserInfo().getYhid());
					poBggzxx.setSldw(user.getSldw());
					poBggzxx.setSlrid(user.getOtherParams().getLong("yhid"));
					poBggzxx.setSlsj(now);
					// 胡斌 20060530 增加判断变更省市县是否是变更成国家，如果是，变更SSXQ的记录不往BGGZ表中增加记录
					// 胡斌 20110929
					// 变更项目包含SSXQ的，变更由（国家到国家）或者（空到国家）的变更更正信息不进行insert
					if (!(bggzxm.trim().toUpperCase().indexOf("SSXQ") > 0 && ((bggzqnr != null
							&& bggzqnr.trim().charAt(0) == '0' && bggzhnr != null && bggzhnr.trim().charAt(0) == '0')
							|| (bggzqnr == null && bggzhnr != null && bggzhnr.trim().charAt(0) == '0')))) {
						HibernateUtil.create(session, poBggzxx);
					}
					// 胡斌 20110919 注释
					// hjyw_bggzxxbDAO.insertHJYW_BGGZXXB(poBggzxx);

					// 生成返回信息
					VoBggzfhxx voBggzfhxx = new VoBggzfhxx();
					voBggzfhxx.setBggzid(poBggzxx.getBggzid());
					voBggzfhxx.setOld_rynbid(voBggzxx.getRynbid());
					voBggzfhxx.setRynbid(poRyxxNew.getRynbid());
					voBggzfhxx.setRyid(poRyxxNew.getRyid());
					voBggzfhxx.setGmsfhm(poRyxxNew.getGmsfhm());
					voBggzfhxx.setXm(poRyxxNew.getXm());
					voBggzfhxx.setHhnbid(poRyxxNew.getHhnbid());
					voBggzfhxx.setYhzgx(poRyxxNew.getYhzgx());
					voBggzfhxx.setBggzxm(bggzxm);
					bggzfhxxList.add(voBggzfhxx);
				} // if(voHcygxtzxxEx==null){
			} // for (Iterator iter = bggzxmMap.entrySet().iterator();
				// iter.hasNext(); )

			// 业务限制处理
			/*
			 * VoRhdxx voRhdxx = new VoRhdxx(poRyxxNew, poHxx, poMlpxxxx,
			 * this.getUserInfo()); // VoXtywxz voLimit = //
			 * XtywqxServiceImpl.VerifyBusinessLimit(PublicConstant.
			 * GNBH_HJ_BGGZYW, // voRhdxx); VoXtywxz voLimit =
			 * XtywqxServiceImpl.VerifyBggzLimit(PublicConstant.GNBH_HJ_BGGZYW,
			 * voRhdxx, voBggzxxEx.getBggzxxList()); if (voLimit.getLimitflag())
			 * { throw new
			 * ServiceException(WSErrCode.ERR_SERVICE_BUSSINESSLIMIT,
			 * "变更更正业务受限，受限信息：" + voLimit.getLimitinfo(), null); }
			 * 
			 * voRhdxx = null;
			 */
			/////////////////////////////////////////////////////////
			// 调整变更更正中的户成员关系
			if (yhzgxList.size() > 0) {
				voHcygxtzfhxx = adjustHCYGX(session, hjywid, voSbjbxx,
						(VoHcygxtzxxEx[]) yhzgxList.toArray(new VoHcygxtzxxEx[yhzgxList.size()]), now);
			}

			// 生成返回信息
			voBggzfhxxEx = new VoBggzfhxxEx();
			voBggzfhxxEx.setVoBggzfhxx((VoBggzfhxx[]) bggzfhxxList.toArray(new VoBggzfhxx[bggzfhxxList.size()]));
			voBggzfhxxEx.setVoHcygxtzfhxx(voHcygxtzfhxx);
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		return voBggzfhxxEx;
	}

	/**
	 * 调整户成员关系
	 * 
	 * @param hjywid
	 *            - 户籍业务ID
	 * @param voSbjbxx
	 *            - 申报基本信息
	 * @param voHcygxtzxx
	 *            - 户成员关系调整信息
	 * @return
	 * @throws ServiceException
	 * @throws DAOException
	 */
	static public VoHcygxtzfhxx[] adjustHCYGX(Session session, Long hjywid, VoSbjbxx voSbjbxx,
			VoHcygxtzxxEx voHcygxtzxxEx[], String psNow) {
		BaseUser user = BaseUser.getCurrent();

		VoHcygxtzfhxx voHcygxtzfhxx[] = null;
		String now = psNow;
		if (psNow == null || "".equals(psNow)) {
			now = getServiceTime(session);
		}

		if (hjywid == null || voHcygxtzxxEx == null || (voHcygxtzxxEx != null && voHcygxtzxxEx.length <= 0)) {
			return null;
		}

		try {
			voHcygxtzfhxx = new VoHcygxtzfhxx[voHcygxtzxxEx.length];
			for (int i = 0; i < voHcygxtzxxEx.length; i++) {
				Long hhnbid = null;
				Long ryid = null;
				Long old_rynbid = null;
				Long new_rynbid = null;
				String oldYhzgx = null;
				String gmsfhm = null;
				String xm = null;
				// 是否需要修改常住人口信息表中的对应记录(0-不修改/1-修改)
				if (voHcygxtzxxEx[i].getFlag() == 1) {
					if (voHcygxtzxxEx[i].getRynbid() == null) {
						throw new ServiceException("人员内部ID为空，户成员关系调整无法完成。", null);
					}
					// 得到人员信息
					PoHJXX_CZRKJBXXB poRyxx = HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class,
							voHcygxtzxxEx[i].getRynbid());
					// 校验人信息的时效性
					checkRXX(session, poRyxx, "户成员关系调整业务");
					// 将原记录置为历史记录
					poRyxx.setJssj(now);
					poRyxx.setJlbz(PublicConstant.JLBZ_LS);
					HibernateUtil.update(session, poRyxx);
					// 得到原与户主关系
					oldYhzgx = poRyxx.getYhzgx();
					// 生成新记录
					PoHJXX_CZRKJBXXB poRyxxNew = new PoHJXX_CZRKJBXXB();
					BeanUtils.copyProperties(poRyxxNew, poRyxx);

					poRyxxNew.setRynbid((Long) getId(session, "SID_HJXX_CZRKJBXXB"));
					poRyxxNew.setYhzgx(voHcygxtzxxEx[i].getYhzgx()); // 修改关系
					poRyxxNew.setQysj(now);
					poRyxxNew.setJssj(null);
					poRyxxNew.setXxqysj(now);// add by hb 20061027
					poRyxxNew.setJlbz(PublicConstant.JLBZ_ZX);
					HibernateUtil.create(session, poRyxxNew);

					hhnbid = poRyxx.getHhnbid();
					old_rynbid = poRyxx.getRynbid();
					new_rynbid = poRyxxNew.getRynbid();
					xm = poRyxxNew.getXm();
					gmsfhm = poRyxxNew.getGmsfhm();
					ryid = poRyxxNew.getRyid();
				} else {
					hhnbid = voHcygxtzxxEx[i].getHhnbid();
					old_rynbid = voHcygxtzxxEx[i].getRynbid();
					new_rynbid = voHcygxtzxxEx[i].getNew_rynbid();
					oldYhzgx = voHcygxtzxxEx[i].getOld_yhzgx();
					xm = voHcygxtzxxEx[i].getXm();
					gmsfhm = voHcygxtzxxEx[i].getGmsfhm();

					// ryid = voHcygxtzxxEx[i].getRyid();
					ryid = voHcygxtzxxEx[i].getRyid();
				}

				// add hb 20061027 查询最新人信息
				PoHJXX_CZRKJBXXB poRyxxZx = HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class, new_rynbid);
				// add hb 20061204 如果是新建RYNBID会查不到人，因此用老的RYNBID查询
				if (poRyxxZx == null) {
					poRyxxZx = HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class, old_rynbid);
				}

				// 生成户成员变动信息
				PoHJYW_HCYBDXXB poHcybdxx = new PoHJYW_HCYBDXXB();
				if (voSbjbxx != null) {
					BeanUtils.copyProperties(poHcybdxx, voSbjbxx);
				}
				poHcybdxx.setCxbz(PublicConstant.CXBZ_FCX);
				poHcybdxx.setHcybdid((Long) getId(session, "SID_HJYW_HCYBDXXB"));
				poHcybdxx.setRynbid(new_rynbid);
				poHcybdxx.setRyid(ryid);
				poHcybdxx.setYgx(oldYhzgx);
				poHcybdxx.setXgx(voHcygxtzxxEx[i].getYhzgx());
				poHcybdxx.setHcybdlx(voHcygxtzxxEx[i].getHcybdlx());
				poHcybdxx.setHcybdlb(voHcygxtzxxEx[i].getHcybdlb());
				poHcybdxx.setHcybdrq(now.substring(0, 8));
				poHcybdxx.setHjywid(hjywid);
				// poHcybdxx.setSldw(this.getUserInfo().getDwdm());
				// poHcybdxx.setSlrid(this.getUserInfo().getYhid());
				poHcybdxx.setSldw(user.getSldw());
				poHcybdxx.setSlrid(user.getOtherParams().getLong("yhid"));

				poHcybdxx.setSlsj(now);
				// 户成员变动信息表中增加人、地信息
				poHcybdxx.setGmsfhm(gmsfhm);
				poHcybdxx.setXm(xm);
				poHcybdxx.setXb(poRyxxZx.getXb());
				poHcybdxx.setMz(poRyxxZx.getMz());
				poHcybdxx.setCsrq(poRyxxZx.getCsrq());
				poHcybdxx.setCssj(poRyxxZx.getCssj());
				poHcybdxx.setCsdssxq(poRyxxZx.getCsdssxq());
				poHcybdxx.setZpid(poRyxxZx.getZpid());
				poHcybdxx.setMlpid(poRyxxZx.getMlpid());
				poHcybdxx.setSsxq(poRyxxZx.getSsxq());
				poHcybdxx.setJlx(poRyxxZx.getJlx());
				poHcybdxx.setMlph(poRyxxZx.getMlph());
				poHcybdxx.setMlxz(poRyxxZx.getMlxz());
				poHcybdxx.setPcs(poRyxxZx.getPcs());
				poHcybdxx.setZrq(poRyxxZx.getZrq());
				poHcybdxx.setXzjd(poRyxxZx.getXzjd());
				poHcybdxx.setJcwh(poRyxxZx.getJcwh());
				poHcybdxx.setPxh(poRyxxZx.getPxh());
				poHcybdxx.setMlpid(poRyxxZx.getMlpid());
				poHcybdxx.setHhid(poRyxxZx.getHhid());
				poHcybdxx.setHhnbid(poRyxxZx.getHhnbid());
				poHcybdxx.setHh(poRyxxZx.getHh());

				// lzh add here 20070214 添加户类型赋值
				poHcybdxx.setHlx(poRyxxZx.getHlx());
				HibernateUtil.create(session, poHcybdxx);

				// 生成户成员关系调整返回信息
				voHcygxtzfhxx[i] = new VoHcygxtzfhxx();
				voHcygxtzfhxx[i].setHhnbid(hhnbid);
				voHcygxtzfhxx[i].setRynbid(new_rynbid);
				voHcygxtzfhxx[i].setRyid(ryid);
				voHcygxtzfhxx[i].setXm(xm);
				voHcygxtzfhxx[i].setGmsfhm(gmsfhm);
				voHcygxtzfhxx[i].setHcybdid(poHcybdxx.getHcybdid());
				voHcygxtzfhxx[i].setOld_rynbid(old_rynbid);
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return voHcygxtzfhxx;
	}

	/**
	 * 保存变更更正信息
	 * 
	 * @param hjywid
	 *            - 户籍业务ID
	 * @param voSbjbxx
	 *            - 申报基本信息
	 * @param voBggzxxEx
	 *            - 变更更正信息
	 * @param gnbh
	 *            - 功能编号
	 * @return VoBggzfhxxEx - 变更更正返回信息
	 * @throws ServiceException
	 * @throws DAOException
	 */
	// modi by hh 20060322 增加参数psNow
	static public VoBggzfhxxEx saveBGGZXX(Session session, Long hjywid, VoSbjbxx voSbjbxx, VoBggzxxEx voBggzxxEx[],
			String gnbh, String psNow) {
		VoBggzfhxxEx voBggzfhxxEx = null;
		List bgryfhxxList = new ArrayList();
		List bggzfhxxList = new ArrayList();
		List hcygxtzfhxxList = new ArrayList();
		String now = psNow;
		if (psNow == null || "".equals(psNow)) {
			now = getServiceTime(session);
		}
		if (voBggzxxEx == null || (voBggzxxEx != null && voBggzxxEx.length <= 0)) {
			return null;
		}

		try {
			/////////////////////////////////////////////////
			// 保存变更更正信息
			for (int i = 0; i < voBggzxxEx.length; i++) {
				// 是否需要修改常住人口信息表中的对应记录(-1-不修改但处理户成员关系调整)/0-不修改/1-修改)
				if (voBggzxxEx[i].getFlag() != 1) {
					continue;
				}

				// 得到人员信息
				PoHJXX_CZRKJBXXB poRyxx = HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class, voBggzxxEx[i].getRynbid());
				if (poRyxx == null) {
					throw new ServiceException("找不到需要变更更正的人员信息，变更更正业务无法完成。", null);
				}
				// 校验人信息的时效性
				checkRXX(session, poRyxx, "变更更正业务");
				// 历史记录不允许操作
				if (PublicConstant.JLBZ_LS.equals(poRyxx.getJlbz())) {
					throw new ServiceException("不允许对历史记录操作(该记录可能在操作过程中被其他用户操作过)，变更更正业务无法完成。", null);
				}
				// 人员锁定状态
				if (!HjConstant.RYSDZT_ZC.equals(poRyxx.getRysdzt())) {
					throw new ServiceException("人员锁定状态为非正常(被锁定)，变更更正业务无法完成。", null);
				}
				if (!PublicConstant.CXBZ_FCX.equals(poRyxx.getCxbz())) {
					throw new ServiceException("人员信息为冲销记录，变更更正业务无法完成。", null);
				}

				// 处理变更更正信息
				VoBggzfhxxEx vo = disposalBggzxx(session, hjywid, voSbjbxx, voBggzxxEx[i], poRyxx, gnbh, now);
				if (vo != null) {
					VoBggzfhxx vob[] = vo.getVoBggzfhxx();
					VoHcygxtzfhxx voh[] = vo.getVoHcygxtzfhxx();
					if (vob != null) {
						for (int k = 0; k < vob.length; k++) {
							bggzfhxxList.add(vob[k]);
						}
					}
					if (voh != null) {
						for (int k = 0; k < voh.length; k++) {
							hcygxtzfhxxList.add(voh[k]);
						}
					}
				} // for (int i = 0; i < voBggzxx.length; i++)

				// 保存变更后的人员信息成新记录
				HibernateUtil.update(session, poRyxx);

				// 生成返回信息
				VoBgryfhxx voBgryfhxx = new VoBgryfhxx();
				voBgryfhxx.setHhnbid(poRyxx.getHhnbid());
				voBgryfhxx.setRynbid(poRyxx.getRynbid());
				voBgryfhxx.setRyid(poRyxx.getRyid());
				voBgryfhxx.setOld_rynbid(poRyxx.getRynbid());
				voBgryfhxx.setXm(poRyxx.getXm());
				voBgryfhxx.setGmsfhm(poRyxx.getGmsfhm());
				bgryfhxxList.add(voBgryfhxx);
			}

			///////////////////////////////////////////
			// 生成返回信息
			voBggzfhxxEx = new VoBggzfhxxEx();
			voBggzfhxxEx.setVoBgryfhxx((VoBgryfhxx[]) bgryfhxxList.toArray(new VoBgryfhxx[bgryfhxxList.size()]));
			voBggzfhxxEx.setVoBggzfhxx((VoBggzfhxx[]) bggzfhxxList.toArray(new VoBggzfhxx[bggzfhxxList.size()]));
			voBggzfhxxEx.setVoHcygxtzfhxx(
					(VoHcygxtzfhxx[]) hcygxtzfhxxList.toArray(new VoHcygxtzfhxx[hcygxtzfhxxList.size()]));
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return voBggzfhxxEx;
	}

	/**
	 * 注销户
	 * 
	 * @param hjywid
	 *            - 户籍业务ID
	 * @param voZxhxx
	 *            - 注销户信息
	 * @return 注销的户(hhnbid)List
	 * @throws ServiceException
	 * @throws DAOException
	 */
	static public List logoutH(Session session, Long hjywid, VoZxhxx voZxhxx[], String bdfw, String bdyy, String ywnr,
			String czsj) {
		List hhnbidList = new ArrayList();
		StringBuffer strHQL = new StringBuffer();
		Map zxhxxMap = new HashMap();

		if (voZxhxx == null) {
			return null;
		}

		// 得到所需要判断注销的户
		for (int i = 0; i < voZxhxx.length; i++) {
			zxhxxMap.put(voZxhxx[i].getOld_hhnbid(), "");
		}
		for (int i = 0; i < voZxhxx.length; i++) {
			zxhxxMap.remove(voZxhxx[i].getNew_hhnbid());
		}

		if (zxhxxMap.size() <= 0) {
			return null;
		}

		try {
			// 判断户是否可以注销
			for (Iterator iter = zxhxxMap.keySet().iterator(); iter.hasNext();) {
				Long hhnbid = (Long) iter.next();

				strHQL.append("select count (*) from PoHJXX_CZRKJBXXB as HJXX_CZRKJBXXB ")
						.append("where hhnbid=" + hhnbid.toString() + " ")
						.append("and ryzt ='" + HjConstant.RYZT_ZC + "' ")
						.append("and jlbz='" + PublicConstant.JLBZ_ZX + "' ")
						.append("and cxbz='" + PublicConstant.CXBZ_FCX + "'");

				// 空户,将户号状态置为注销状态
				if (YWUtils.getCount(session, strHQL.toString()) <= 0) {
					PoHJXX_HXXB poHxx = HibernateUtil.get(session, PoHJXX_HXXB.class, hhnbid);
					if (poHxx == null) {
						throw new ServiceException("找不到要注销的户信息，系统逻辑错误。", null);
					}
					// 校验户信息的时效性
					checkHXX(session, poHxx, "注销户");
					// 将记录设为历史记录
					poHxx.setChlb(HjConstant.CHLB_YWZX);
					poHxx.setCchjywid(hjywid);
					poHxx.setJssj(czsj);
					poHxx.setJlbz(PublicConstant.JLBZ_LS);
					HibernateUtil.update(session, poHxx);

					// 生成户注销记录
					PoHJXX_HXXB poHxxNew = new PoHJXX_HXXB();
					BeanUtils.copyProperties(poHxxNew, poHxx);
					poHxxNew.setHhnbid((Long) getId(session, "SID_HJXX_HXXB"));
					poHxxNew.setChsj(czsj);
					poHxxNew.setHhzt(HjConstant.HHZT_ZX);
					poHxxNew.setBdfw(bdfw);
					poHxxNew.setBdyy(bdyy);
					poHxxNew.setQysj(czsj);
					poHxxNew.setJssj(null);
					poHxxNew.setChlb(null);
					poHxxNew.setJhlb(HjConstant.JHLB_YWSC);
					poHxxNew.setCchjywid(null);
					poHxxNew.setCjhjywid(hjywid);
					poHxxNew.setJlbz(PublicConstant.JLBZ_ZX);
					HibernateUtil.create(session, poHxxNew);

					// 保存户变动信息
					PoHJTJ_HBDXXB poHbdxx = new PoHJTJ_HBDXXB();
					poHbdxx.setHbdid((Long) getId(session, "SID_HJTJ_HBDXXB"));
					poHbdxx.setBdfw(bdfw);
					poHbdxx.setBdsj(czsj);
					poHbdxx.setBdyy(bdyy);
					poHbdxx.setHhnbid(poHxxNew.getHhnbid());
					poHbdxx.setHzjs(new Long(-1));
					poHbdxx.setYwnr(ywnr);
					poHbdxx.setCxbz(PublicConstant.CXBZ_FCX);
					poHbdxx.setCxhjywid(null);
					poHbdxx.setHjywid(hjywid);
					HibernateUtil.create(session, poHbdxx);

					// 生成返回信息
					hhnbidList.add(hhnbid);
				}
			} // for (Iterator iter = zxhxxMap.keySet().iterator();
				// iter.hasNext(); )
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return hhnbidList != null && hhnbidList.size() == 0 ? null : hhnbidList;
	}

	/**
	 * 校验户信息的时效性
	 * 
	 * @param poHxx
	 *            - 户信息Po
	 * @param hjxx_hxxbDAO
	 *            - HJXX_HXXB表的DAO
	 * @param ywmc
	 *            - 业务名称
	 * @throws DAOException
	 * @throws ServiceException
	 */
	static public void checkHXX(Session session, PoHJXX_HXXB poHxx, String ywmc) {
		if (poHxx == null) {
			return;
		}
		try {
			// 时效性校验
			refresh(session, poHxx, LockMode.UPGRADE); // 锁记录
			if (!(PublicConstant.JLBZ_ZX.equals(poHxx.getJlbz()) && PublicConstant.CXBZ_FCX.equals(poHxx.getCxbz()))) {
				throw new ServiceException("时效性错误，户号为" + poHxx.getHh() + "的最新记录可能在操作过程中被其他用户操作过，" + ywmc + "无法完成。",
						null);
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return;
	}

	/**
	 * 校验地信息的时效性
	 * 
	 * @param poMlpxxxx
	 *            - 人信息Po
	 * @param hjxx_mlpxxxxbDAO
	 *            - HJXX_MLPXXXXB表的DAO
	 * @param ywmc
	 *            - 业务名称
	 * @throws DAOException
	 * @throws ServiceException
	 */
	static public void checkDXX(Session session, PoHJXX_MLPXXXXB poMlpxxxx, String ywmc) {
		if (poMlpxxxx == null) {
			return;
		}

		try {
			refresh(session, poMlpxxxx, LockMode.UPGRADE); // 锁记录
			if (!PublicConstant.JLBZ_ZX.equals(poMlpxxxx.getJlbz())) {
				throw new ServiceException(
						"时效性错误，该地(" + poMlpxxxx.getMlpid() + ")的最新记录可能在操作过程中被其他用户操作过，" + ywmc + "无法完成。", null);
			}
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		return;
	}

	/**
	 * 校验户成员信息(户主和配偶)
	 * 
	 * @param hhnbid
	 * @throws ServiceException
	 * @throws DAOException
	 */
	static public void checkHCYXX(Session session, Long hhnbid) {
		StringBuffer strHQL = null;
		if (hhnbid == null) {
			return;
		}
		try {
			// 得到户成员数
			strHQL = new StringBuffer();
			strHQL.append("select count(*) from PoHJXX_CZRKJBXXB ").append("where ryzt ='" + HjConstant.RYZT_ZC + "' ")
					.append("and jlbz ='" + PublicConstant.JLBZ_ZX + "' ")
					.append("and cxbz = '" + PublicConstant.CXBZ_FCX + "' ").append("and hhnbid =" + hhnbid);
			long nCount = getCount(session, strHQL.toString());
			// 没有户成员
			if (nCount <= 0) {
				return;
			}

			// 户主
			strHQL = new StringBuffer();
			strHQL.append("select count(*) from PoHJXX_CZRKJBXXB ").append("where yhzgx < '10' ")
					.append("and ryzt ='" + HjConstant.RYZT_ZC + "' ")
					.append("and jlbz ='" + PublicConstant.JLBZ_ZX + "' ")
					.append("and cxbz = '" + PublicConstant.CXBZ_FCX + "' ").append("and hhnbid =" + hhnbid);
			nCount = getCount(session, strHQL.toString());
			if (nCount > 1) {
				throw new ServiceException("一个户有且仅有一个户主，系统检测到该户有 " + String.valueOf(nCount) + " 个户主，业务不能办理。", null);
			} else if (nCount < 1) {
				throw new ServiceException("检测到该户没有户主，业务不能办理。", null);
			}

			// 配偶
			strHQL = new StringBuffer();
			strHQL.append("select count(*) from PoHJXX_CZRKJBXXB ").append("where substr(yhzgx,1,1) = '1' ")
					.append("and ryzt ='" + HjConstant.RYZT_ZC + "' ")
					.append("and jlbz ='" + PublicConstant.JLBZ_ZX + "' ")
					.append("and cxbz ='" + PublicConstant.CXBZ_FCX + "' ").append("and hhnbid =" + hhnbid.toString());
			nCount = getCount(session, strHQL.toString());
			if (nCount > 1) {
				throw new ServiceException("一个户有且仅有一个配偶，系统检测到该户有 " + String.valueOf(nCount) + " 个配偶，业务不能办理。", null);
			}

		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		return;
	}

	/**
	 * 保存户籍业务流水信息
	 * 
	 * @param hjywid
	 *            - 户籍业务ID
	 * @param ywbz
	 *            - 业务标志
	 * @param ywlx
	 *            - 业务类型
	 * @param czsm
	 *            - 操作数日
	 * @param voSbjbxx
	 *            - 申报基本信息
	 * @param slsj
	 *            - 受理时间
	 * @throws ServiceException
	 * @throws DAOException
	 */
	static public PoHJLS_HJYWLSB saveHJYWLSXX(Session session, Long hjywid, String ywbz, String ywlx, int czsm,
			VoSbjbxx voSbjbxx, String slsj) {
		BaseUser user = BaseUser.getCurrent();
		PoHJLS_HJYWLSB poHJLS_HJYWLSB = null;
		try {
			poHJLS_HJYWLSB = new PoHJLS_HJYWLSB();
			poHJLS_HJYWLSB.setHjywid(hjywid);
			poHJLS_HJYWLSB.setYwbz(ywbz);
			poHJLS_HJYWLSB.setYwlx(ywlx);
			poHJLS_HJYWLSB.setCzsm(new Long(czsm));
			if (voSbjbxx != null) {
				poHJLS_HJYWLSB.setSbryxm(voSbjbxx.getSbryxm());
				poHJLS_HJYWLSB.setSbrgmsfhm(voSbjbxx.getSbrgmsfhm());
				poHJLS_HJYWLSB.setSbsj(voSbjbxx.getSbsj());
			}
			poHJLS_HJYWLSB.setSldw(user.getSldw());
			poHJLS_HJYWLSB.setSlrid(user.getOtherParams().getLong("yhid"));
			poHJLS_HJYWLSB.setSlsj(slsj);
			poHJLS_HJYWLSB.setCzip(BaseContext.getContext().getRequest().getRemoteAddr());
			HibernateUtil.create(session, poHJLS_HJYWLSB);
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return poHJLS_HJYWLSB;
	}

	/**
	 * 保存人员变动信息(四变)
	 * 
	 * @param rybdxxList
	 *            - 人员变动信息Vo List
	 * @param poHjywlsxx
	 *            - 户籍业务流水信息Po
	 * @throws ServiceException
	 * @throws DAOException
	 */
	static public void saveRYBDXX(Session session, List rybdxxList, PoHJLS_HJYWLSB poHjywlsxx) {
		String strHQL = null;
		// 数据校验
		if (rybdxxList == null || poHjywlsxx == null || (rybdxxList != null && rybdxxList.size() <= 0)) {
			return;
		}
		try {
			for (int i = 0; i < rybdxxList.size(); i++) {
				PoHJXX_CZRKJBXXB poRyxx = null;
				PoHJXX_HXXB bdq_poHxx = null;
				PoHJXX_MLPXXXXB bdq_poMlpxxxx = null;
				PoHJXX_HXXB bdh_poHxx = null;
				PoHJXX_MLPXXXXB bdh_poMlpxxxx = null;

				VoRybdxx voRybdxx = (VoRybdxx) rybdxxList.get(i);
				// 得到人信息
				poRyxx = HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class, voRybdxx.getRynbid());
				// 得到变动前户地信息
				if (voRybdxx.getBdq_hhnbid() != null) {
					bdq_poHxx = HibernateUtil.get(session, PoHJXX_HXXB.class, voRybdxx.getBdq_hhnbid());
					bdq_poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, bdq_poHxx.getMlpnbid());
				}
				// 得到变动后户地信息
				if (voRybdxx.getBdh_hhnbid() != null) {
					bdh_poHxx = HibernateUtil.get(session, PoHJXX_HXXB.class, voRybdxx.getBdh_hhnbid());
					bdh_poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, bdh_poHxx.getMlpnbid());
				}

				// 错误数据判断(2005/04/25 10:00:00 By MHB)
				if ("0000".equals(voRybdxx.getBdyy())) {
					throw new ServiceException("变动原因代码不能为'0000'，业务无法完成。", null);
				}

				// 保存人员变动信息
				PoHJTJ_RYBDXXB poHJTJ_RYBDXXB = new PoHJTJ_RYBDXXB();
				BeanUtils.copyProperties(poHJTJ_RYBDXXB, voRybdxx); // 拷贝人员变动信息(变动表ID、变动原因、变动范围、变动日期、变动前户别)
				BeanUtils.copyProperties(poHJTJ_RYBDXXB, poRyxx); // 拷贝人信息 +
																	// 业务内容
				BeanUtils.copyProperties(poHJTJ_RYBDXXB, poHjywlsxx); // 拷贝业务流水信息
				// add by hh 20051220 区划调整的业务内容应该为区划调整
				if (poHjywlsxx.getYwlx() == PublicConstant.HJYWLS_YWLX_QHTZ) {
					poHJTJ_RYBDXXB.setYwnr(HjConstant.YWNR_QHTZ);
				}
				// 保存变动前户地信息
				if (bdq_poHxx != null && bdq_poMlpxxxx != null) {
					// 变动前户信息
					poHJTJ_RYBDXXB.setBdqhhnbid(bdq_poHxx.getHhnbid());
					poHJTJ_RYBDXXB.setBdqhlx(bdq_poHxx.getHlx());
					poHJTJ_RYBDXXB.setBdqhh(bdq_poHxx.getHh());
					// 变动前地信息
					poHJTJ_RYBDXXB.setBdqmlpnbid(bdq_poMlpxxxx.getMlpnbid());
					poHJTJ_RYBDXXB.setBdqssxq(bdq_poMlpxxxx.getSsxq());
					poHJTJ_RYBDXXB.setBdqjlx(bdq_poMlpxxxx.getJlx());
					poHJTJ_RYBDXXB.setBdqmlph(bdq_poMlpxxxx.getMlph());
					poHJTJ_RYBDXXB.setBdqmlxz(bdq_poMlpxxxx.getMlxz());
					poHJTJ_RYBDXXB.setBdqpcs(bdq_poMlpxxxx.getPcs());
					poHJTJ_RYBDXXB.setBdqzrq(bdq_poMlpxxxx.getZrq());
					poHJTJ_RYBDXXB.setBdqxzjd(bdq_poMlpxxxx.getXzjd());
					poHJTJ_RYBDXXB.setBdqjcwh(bdq_poMlpxxxx.getJcwh());
				}
				// 保存变动后户地信息
				if (bdh_poHxx != null && bdh_poMlpxxxx != null) {
					// 变动后户信息
					poHJTJ_RYBDXXB.setBdhhhnbid(bdh_poHxx.getHhnbid());
					poHJTJ_RYBDXXB.setBdhhlx(bdh_poHxx.getHlx());
					poHJTJ_RYBDXXB.setBdhhh(bdh_poHxx.getHh());
					// 变动后地信息
					poHJTJ_RYBDXXB.setBdhmlpnbid(bdh_poMlpxxxx.getMlpnbid());
					poHJTJ_RYBDXXB.setBdhssxq(bdh_poMlpxxxx.getSsxq());
					poHJTJ_RYBDXXB.setBdhjlx(bdh_poMlpxxxx.getJlx());
					poHJTJ_RYBDXXB.setBdhmlph(bdh_poMlpxxxx.getMlph());
					poHJTJ_RYBDXXB.setBdhmlxz(bdh_poMlpxxxx.getMlxz());
					poHJTJ_RYBDXXB.setBdhpcs(bdh_poMlpxxxx.getPcs());
					poHJTJ_RYBDXXB.setBdhzrq(bdh_poMlpxxxx.getZrq());
					poHJTJ_RYBDXXB.setBdhxzjd(bdh_poMlpxxxx.getXzjd());
					poHJTJ_RYBDXXB.setBdhjcwh(bdh_poMlpxxxx.getJcwh());
				}
				// 迁出注销业务
				if (PublicConstant.GNBH_HJ_QCZXYW.equals(poHjywlsxx.getYwbz())) {
					poHJTJ_RYBDXXB.setBdhssxq(voRybdxx.getQwdssxq());
					poHJTJ_RYBDXXB.setBdhmlxz(voRybdxx.getQwdxz());
				}
				// 迁入登记业务
				else if (PublicConstant.GNBH_HJ_QRDJYW.equals(poHjywlsxx.getYwbz())) {
					poHJTJ_RYBDXXB.setBdqssxq(voRybdxx.getQcdssxq());
					poHJTJ_RYBDXXB.setBdqmlxz(voRybdxx.getQcdxz());
				}

				// 冲销标志
				if (HjConstant.YWNR_HFHK.equals(poRyxx.getYwnr())) {
					poHJTJ_RYBDXXB.setCxbz(PublicConstant.CXBZ_PDCX);
				}

				// 户主信息
				PoHJXX_CZRKJBXXB poHzxx = null;
				if (PublicConstant.JLBZ_ZX.equals(poRyxx.getJlbz()) && HjConstant.RYZT_ZC.equals(poRyxx.getRyzt())) {
					strHQL = "from PoHJXX_CZRKJBXXB where yhzgx < '10' and ryzt='" + HjConstant.RYZT_ZC + "' and jlbz='"
							+ PublicConstant.JLBZ_ZX + "' and cxbz='" + PublicConstant.CXBZ_FCX + "' and hhnbid ="
							+ poRyxx.getHhnbid();
				} else {
					strHQL = "from PoHJXX_CZRKJBXXB where yhzgx < '10' and hhnbid =" + poRyxx.getHhnbid()
							+ " and qysj <= '" + poRyxx.getQysj() + "' and cxbz='" + PublicConstant.CXBZ_FCX
							+ "' order by qysj desc";
				}
				List hzxxList = HibernateUtil.getObjectList(session, strHQL, null);
				if (hzxxList != null && hzxxList.size() > 0) {
					poHzxx = (PoHJXX_CZRKJBXXB) hzxxList.get(0);
					// 填充户主信息
					poHJTJ_RYBDXXB.setHzgmsfhm(poHzxx.getGmsfhm());
					poHJTJ_RYBDXXB.setHzxm(poHzxx.getXm());
				}

				// 保存
				poHJTJ_RYBDXXB.setRybdid((Long) getId(session, "SID_HJTJ_RYBDXXB"));
				HibernateUtil.create(session, poHJTJ_RYBDXXB);
			} // for (int i = 0; i < rybdxxList.size(); i++)

		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		return;
	}

	static public PoHJXX_CZRKJBXXB findHZXX(Session session, List hcyxxList) {
		PoHJXX_CZRKJBXXB poHzxx = null;
		if (hcyxxList != null) {
			for (int i = 0; i < hcyxxList.size(); i++) {
				PoHJXX_CZRKJBXXB po = (PoHJXX_CZRKJBXXB) hcyxxList.get(i);
				if (PublicConstant.CXBZ_FCX.equals(po.getCxbz()) && PublicConstant.JLBZ_ZX.equals(po.getJlbz())
						&& "10".compareTo(po.getYhzgx()) >= 0) {
					poHzxx = po;
					if (HjConstant.RYZT_ZC.equals(poHzxx.getRyzt())) {
						break;
					}
				}
			}
		}

		return poHzxx;
	}

	static public String generateZZ(Session session, PoHJXX_MLPXXXXB poMlpxxxx, String cslb, String dm){
		String zz = null;
		int zz_len = 0;
		try {
			// 得到地址组成方式设置参数
			PoXT_XTCSB poXtcsb = getXTCSB(session, cslb, dm);
			if (poXtcsb != null) {
				zz = poXtcsb.getZwpy();
			}
			if (poXtcsb == null || zz == null || (zz != null && zz.length() <= 0)) {
				throw new ServiceException("地址组成方式没有设置，生成地址失败。", null);
			}

			// 分离住址表达式和住址长度，如: [[mlph]][[mlxz]],80 分解成：Stirng
			// zz=[[mlph]][[mlxz]] ,int zz_len=80
			int offset = zz.indexOf(",");
			if (offset >= 0) {
				zz_len = Integer.valueOf(zz.substring(offset + 1, zz.length())).intValue();
				zz = zz.substring(0, offset);
			}

			// 字符串替换
			// 省市省区[[SSXQ]]
			String ssxq = poMlpxxxx.getSsxq() != null ? poMlpxxxx.getSsxq() : "";
			if (ssxq.length() > 0) {
				PoXT_XZQHB poXzqhxx = (PoXT_XZQHB) HibernateUtil.get(session, PoXT_XZQHB.class, ssxq);
				ssxq = (poXzqhxx != null && poXzqhxx.getMc() != null) ? poXzqhxx.getMc() : "";
			}
			
			zz = StringUtils.replace(zz, "[[SSXQ]]", ssxq.trim());
			// 街路巷[[JLX]]
			String jlx = poMlpxxxx.getJlx() != null ? poMlpxxxx.getJlx() : "";
			if (jlx.length() > 0) {
				PoXT_JLXXXB poJlxxx = (PoXT_JLXXXB) HibernateUtil.get(session,PoXT_JLXXXB.class, jlx);
				jlx = (poJlxxx != null && poJlxxx.getMc() != null) ? poJlxxx.getMc() : "";
			}
			zz = StringUtils.replace(zz, "[[JLX]]", jlx.trim());
			// 门楼牌号[[MLPH]]
			String mlph = poMlpxxxx.getMlph() != null ? poMlpxxxx.getMlph() : "";
			zz = StringUtils.replace(zz, "[[MLPH]]", mlph.trim());
			// 门楼详址[[MLXZ]]
			String mlxz = poMlpxxxx.getMlxz() != null ? poMlpxxxx.getMlxz() : "";
			zz = StringUtils.replace(zz, "[[MLXZ]]", mlxz.trim());
			// 派出所[[PCS]]
			String pcs = poMlpxxxx.getPcs() != null ? poMlpxxxx.getPcs() : "";
			if (pcs.length() > 0) {
				PoXT_DWXXB poDwxx = (PoXT_DWXXB) HibernateUtil.get(session, PoXT_DWXXB.class, pcs);
				// modi by hh 20060301 派出所取备注
				// pcs = (poDwxx != null && poDwxx.getMc() != null) ?
				// poDwxx.getMc() :
				pcs = (poDwxx != null && poDwxx.getBz() != null) ? poDwxx.getBz() : "";
			}
			zz = StringUtils.replace(zz, "[[PCS]]", pcs.trim());
			// 责任区[[ZRQ]]
			String zrq = poMlpxxxx.getZrq() != null ? poMlpxxxx.getZrq() : "";
			if (zrq.length() > 0) {
				System.out.printf("责任区ID"+zrq);
				PoXT_JWZRQXXB poZrqxx = (PoXT_JWZRQXXB) HibernateUtil.get(session,PoXT_JWZRQXXB.class,zrq);
				zrq = (poZrqxx != null && poZrqxx.getMc() != null) ? poZrqxx.getMc() : "";
			}
			zz = StringUtils.replace(zz, "[[ZRQ]]", zrq.trim());
			// 乡镇街道[[XZJD]]
			String xzjd = poMlpxxxx.getXzjd() != null ? poMlpxxxx.getXzjd() : "";
			if (xzjd.length() > 0) {
				PoXT_XZJDXXB poXzjdxx = (PoXT_XZJDXXB) HibernateUtil.get(session,PoXT_XZJDXXB.class,xzjd);
				// xzjd = (poXzjdxx != null && poXzjdxx.getMc() != null) ?
				// poXzjdxx.getMc() : "";
				xzjd = (poXzjdxx != null && poXzjdxx.getBz() != null) ? poXzjdxx.getBz() : "";
			}
			zz = StringUtils.replace(zz, "[[XZJD]]", xzjd.trim());
			// 居村委会[[JCWH]]
			String jcwh = poMlpxxxx.getJcwh() != null ? poMlpxxxx.getJcwh() : "";
			if (jcwh.length() > 0) {
				PoXT_JWHXXB poJwhxx = (PoXT_JWHXXB) HibernateUtil.get(session,PoXT_JWHXXB.class,jcwh);
				// jcwh = (poJwhxx != null && poJwhxx.getMc() != null) ?
				// poJwhxx.getMc() : "";
				jcwh = (poJwhxx != null && poJwhxx.getBz() != null) ? poJwhxx.getBz() : "";
			}
			zz = StringUtils.replace(zz, "[[JCWH]]", jcwh.trim());
			// 长度控制
			if (zz_len > 0 && zz.length() > zz_len) {
				zz = zz.substring(0, zz_len);
			}

		} catch (Exception ex) {
			throw new ServiceException(ex);
		}

		return zz;
	}
	
	/**
	   * 翻译单位代码
	   * @param dm
	   * @return
	   * @throws DAOException
	   */
	  static public String transDWDM(Session session, String dm){
	    String mc = null;

	    if (dm == null) {
	      return null;
	    }

	    try {
	      PoXT_DWXXB po = (PoXT_DWXXB) HibernateUtil.get(session, PoXT_DWXXB.class, dm);
	      if (po != null) {
	        mc = po.getMc();
	      }
	    }catch (Exception ex) {
	      throw new ServiceException(ex);
	    }

	    return mc;
	  }
	  
	  /**
	   * 审批模板当前使用数增加1
	   * @param spmbid - 审批模板ID
	   * @throws DAOException
	   * @throws ServiceException
	   */
	 static public void incSPMBDQSYS(Session session, Long spmbid){
	    if (spmbid == null) {
	      return;
	    }
	    
	    try {
	      PoXT_SPMBXXB poSpmbxx = HibernateUtil.get(session,PoXT_SPMBXXB.class,spmbid);
	      if (poSpmbxx != null) {
	        long sys = 0;
	        if (poSpmbxx.getDqsys() != null &&
	            poSpmbxx.getDqsys().trim().length() > 0) {
	          sys = Long.parseLong(poSpmbxx.getDqsys().trim());
	        }
	        sys++;
	        if (sys > 999) {
	          sys = 999;
	        }
	        poSpmbxx.setDqsys(String.valueOf(sys));
	        HibernateUtil.update(session, poSpmbxx);
	      } //if(poSpmbxx!=null){
	    }catch (Exception ex) {
	      throw new ServiceException( ex);
	    }

	    return;
	  }
	 
	  public static VoXtywxz VerifyBusinessLimit(Session session,String sYwid, DefaultVO dv) throws Exception {
		  return SpywUtils.VerifyBusinessLimit(session, sYwid, dv, "1");
	  }
  
	 /**
	  * 迁移证业务
	  * @param session
	  * @param voQyzbhhtxx
	  * @return
	  */
	 public static VoQyzbhhtywfhxx processQyzbhhtyw(BaseUser user, Session session, VoQyzbhhtxx voQyzbhhtxx[]) throws Exception{
		    VoQyzbhhtywfhxx voQyzbhhtywfhxx = null;
		    List qyzbhhtfhxxList = new ArrayList();
		    String sjc = null; //省简称
		    List qyzxxList = new ArrayList(); //迁移证信息List

		    if (voQyzbhhtxx == null ||
		        (voQyzbhhtxx != null && voQyzbhhtxx.length <= 0)) {
		      return null;
		    }
		      //////////////////////////////////
		      //业务限制
		      for (int i = 0; i < voQyzbhhtxx.length; i++) {
		        VoXtywxz voLimit = VerifyBusinessLimit(session,
		            PublicConstant.
		            GNBH_HJ_QYZBHHTYW, voQyzbhhtxx[i]);
		        //业务受限
		        if (voLimit.getLimitflag()) {
		          throw new ServiceException("迁移证编号回填业务受限，受限信息：" + voLimit.getLimitinfo(), null);
		        }
		      }

		      /////////////////////////////////////////
		      //得到省简称
		      sjc = getXTKZCS(session, PublicConstant.XTKZCS_XTSYSJC);
		      if (sjc == null) {
		        sjc = "";
		      }

		      ////////////////////////////////////////////
		      //保存迁移证编号回填信息
		      for (int i = 0; i < voQyzbhhtxx.length; i++) {
		        String qyyy = null; //迁移原因
		        String qwdssxq = null; //迁往地省市县区
		        String qwdxz = null; //迁往地详址
		        String yzzssxq = null; //原住址省市县区
		        String yzzxz = null; //原住址详址
		        String cbr = null; //承办人

		        //得到户籍业务流水信息
		        PoHJLS_HJYWLSB poHjywlsxx = HibernateUtil.get(session, PoHJLS_HJYWLSB.class, voQyzbhhtxx[i].getHjywid());
		        if (poHjywlsxx == null) {
		          throw new ServiceException("找不到户籍业务流水信息。", null);
		        }

		        //翻译承办人
		        /*
		        if (voQyzbhhtxx[i].getDysx() != null
		            && voQyzbhhtxx[i].getDysx().longValue() == 1
		            && poHjywlsxx.getSlrid() != null) {
		          PoXT_YHXXB poYhxx = HibernateUtil.get(session, PoXT_YHXXB.class, poHjywlsxx.getSlrid());
		          if (poYhxx != null) {
		            cbr = poYhxx.getYhxm();
		          }
		        }
				*/
		        cbr = user.getOtherParams().getString("yhxm");
		        		
		        //得到人员信息
		        PoHJXX_CZRKJBXXB poRyxx =HibernateUtil.get(session, PoHJXX_CZRKJBXXB.class, voQyzbhhtxx[i].getRynbid());
		        if (poRyxx == null) {
		          throw new ServiceException("找不到对应的人员信息。", null);
		        }

		        //迁出注销
		        if (PublicConstant.GNBH_HJ_QCZXYW.equals(poHjywlsxx.getYwbz())) {
		          String strHQL = "from PoHJYW_QCZXXXB HJYW_QCZXXXB where hjywid=" +
		              voQyzbhhtxx[i].getHjywid() + " and rynbid=" +
		              voQyzbhhtxx[i].getRynbid();
		          List qczxxxList = HibernateUtil.getObjectList(session, strHQL, new Object[]{});
		          if (qczxxxList != null && qczxxxList.size() > 0) {
		            for (int k = 0; k < qczxxxList.size(); k++) {
		              PoHJYW_QCZXXXB poQczxxx = (PoHJYW_QCZXXXB) qczxxxList.get(k);
		              poQczxxx.setQyzbh(sjc + voQyzbhhtxx[i].getQyzbh());
		              HibernateUtil.update(session, poQczxxx);

		              qyyy = poQczxxx.getQclb();
		              //填空(TMD无聊代码)
		              if (voQyzbhhtxx[i].getDysx() != null
		                  && voQyzbhhtxx[i].getDysx().longValue() == 1) {
		                qwdssxq = poQczxxx.getQwdssxq();
		                PoHJXX_MLPXXXXB poMlpxxxx = new PoHJXX_MLPXXXXB();
		                poMlpxxxx.setSsxq(poQczxxx.getQwdssxq());
		                poMlpxxxx.setPcs(poQczxxx.getQwdpcs());
		                poMlpxxxx.setXzjd(poQczxxx.getQwdxzjd());
		                poMlpxxxx.setJcwh(poQczxxx.getQwdjwh());
		                poMlpxxxx.setJlx(poQczxxx.getQwdjlx());
		                poMlpxxxx.setMlph(poQczxxx.getQwdmlph());
		                poMlpxxxx.setMlxz(poQczxxx.getQwdxz());
		                qwdxz = generateZZ(session,poMlpxxxx,
		                                        PublicConstant.XTKZCS_DZPZFS,
		                                        PublicConstant.XTKZCS_DZPZFS_EDZSLXX);
		                poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poRyxx.getMlpnbid());
		                System.out.println("门楼牌内部ID：" + poRyxx.getMlpnbid());
		                //hjxx_mlpxxxxbDAO.findHJXX_MLPXXXXBById(poRyxx.getMlpnbid());
		                if (poMlpxxxx != null) {
		                  yzzssxq = poMlpxxxx.getSsxq(); //原住址省市县区
		                  yzzxz = generateZZ(session, poMlpxxxx,
		                                          PublicConstant.XTKZCS_DZPZFS,
		                                          PublicConstant.XTKZCS_DZPZFS_EDZSLXX); //原住址详址
		                }
		              }

		              //生成返回信息
		              VoQyzbhhtfhxx vo = new VoQyzbhhtfhxx();
		              vo.setRynbid(poQczxxx.getRynbid());
		              vo.setQczxid(poQczxxx.getQczxid());
		              qyzbhhtfhxxList.add(vo); ;
		            }
		          } //if(qczxxxList != null && qczxxxList.size() > 0)
		        }
		        //住址变动
		        else if (PublicConstant.GNBH_HJ_ZZBDYW.equals(poHjywlsxx.getYwbz())) {
		          String strHQL = "from PoHJYW_ZZBDXXB HJYW_ZZBDXXB where hjywid=" +
		              voQyzbhhtxx[i].getHjywid() + " and rynbid=" +
		              voQyzbhhtxx[i].getRynbid();
		          List zzbdxxList = HibernateUtil.getObjectList(session, strHQL, new Object[]{});
		        		  //hjyw_zzbdxxbDAO.findAllHJYW_ZZBDXXBs(strHQL);
		          if (zzbdxxList != null && zzbdxxList.size() > 0) {
		            for (int k = 0; k < zzbdxxList.size(); k++) {
		              PoHJYW_ZZBDXXB poZzbdxx = (PoHJYW_ZZBDXXB) zzbdxxList.get(k);
		              poZzbdxx.setQyzbh(sjc + voQyzbhhtxx[i].getQyzbh());
		              HibernateUtil.update(session, poZzbdxx);
		              
		              qyyy = poZzbdxx.getZzbdlb();
		              //填空(TMD无聊代码)
		              if (voQyzbhhtxx[i].getDysx() != null
		                  && voQyzbhhtxx[i].getDysx().longValue() == 1) {
		                PoHJXX_MLPXXXXB poMlpxxxx =HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poRyxx.getMlpnbid());
		                		//hjxx_mlpxxxxbDAO. findHJXX_MLPXXXXBById(poRyxx.getMlpnbid());
		                if (poMlpxxxx != null) {
		                  qwdssxq = poMlpxxxx.getSsxq();
		                  qwdxz = generateZZ(session, poMlpxxxx,
		                                          PublicConstant.XTKZCS_DZPZFS,
		                                          PublicConstant.XTKZCS_DZPZFS_EDZSLXX);
		                }
		                PoHJXX_HXXB poHxx =HibernateUtil.get(session, PoHJXX_HXXB.class, poZzbdxx.getYhhnbid());
		                if (poHxx != null) {
		                  poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poHxx.getMlpnbid());
		                  if (poMlpxxxx != null) {
		                    yzzssxq = poMlpxxxx.getSsxq(); //原住址省市县区
		                    yzzxz = generateZZ(session, poMlpxxxx,
		                                            PublicConstant.XTKZCS_DZPZFS,
		                                            PublicConstant.
		                                            XTKZCS_DZPZFS_EDZSLXX); //原住址详址
		                  } //if(poMlpxxxx!=null){
		                } //if(poHxx!=null){
		              }

		              //生成返回信息
		              VoQyzbhhtfhxx vo = new VoQyzbhhtfhxx();
		              vo.setRynbid(poZzbdxx.getRynbid());
		              vo.setZzbdid(poZzbdxx.getZzbdid());
		              qyzbhhtfhxxList.add(vo); ;
		            }
		          } //if(qczxxxList != null && qczxxxList.size() > 0)
		        }
		        else {
		          throw new ServiceException(
		                                     "户籍业务ID对应的不是迁出注销和住址变动业务，迁移证编号回填业务无法完成。", null);
		        }

		        //生成迁移证信息_begin
		        PoHJSP_QYZXXB poQyzxx = null;
		        for (int n = 0; n < qyzxxList.size(); n++) {
		          PoHJSP_QYZXXB po = (PoHJSP_QYZXXB) qyzxxList.get(n);
		          if (voQyzbhhtxx[i].getQyzbh() != null &&
		              voQyzbhhtxx[i].getQyzbh().equals(po.getQyzbh())) {
		            poQyzxx = po;
		            break;
		          }
		        }
		        if (poQyzxx == null) {
		          poQyzxx = new PoHJSP_QYZXXB();
		          poQyzxx.setQyid((Long) getId(session, "SID_HJSP_QYZXXB"));
		          poQyzxx.setQyzbh(voQyzbhhtxx[i].getQyzbh());
		          qyzxxList.add(poQyzxx);
		        }
		        if (voQyzbhhtxx[i].getDysx() != null &&
		            voQyzbhhtxx[i].getDysx().longValue() == 1) {
		          poQyzxx.setCzrgmsfhm(poRyxx.getGmsfhm());
		          poQyzxx.setXm(poRyxx.getXm());
		          poQyzxx.setCym(poRyxx.getCym());
		          poQyzxx.setXb(poRyxx.getXb());
		          poQyzxx.setMz(poRyxx.getMz());
		          poQyzxx.setCsrq(poRyxx.getCsrq());
		          poQyzxx.setCsdgjdq(poRyxx.getCsdgjdq());
		          poQyzxx.setCsdssxq(poRyxx.getCsdssxq());
		          poQyzxx.setCsdxz(poRyxx.getCsdxz());
		          poQyzxx.setJggjdq(poRyxx.getJggjdq());
		          poQyzxx.setJgssxq(poRyxx.getJgssxq());
		          poQyzxx.setWhcd(poRyxx.getWhcd());
		          poQyzxx.setZy(poRyxx.getZy());
		          poQyzxx.setHyzk(poRyxx.getHyzk());
		          poQyzxx.setQyyy(qyyy);
		          poQyzxx.setQfrq(voQyzbhhtxx[i].getQfrq());
		          poQyzxx.setYxqxjzrq(voQyzbhhtxx[i].getYxqxjzrq());
		          poQyzxx.setYzzssxq(yzzssxq);
		          poQyzxx.setYzzxz(yzzxz);
		          poQyzxx.setQwdssxq(qwdssxq);
		          poQyzxx.setQwdxz(qwdxz);
		          poQyzxx.setCbr(cbr);
		          poQyzxx.setYznf(voQyzbhhtxx[i].getYznf());//add hb 20060828 印制年份
		          //Begin_得到主迁人的地信息_2005/01/19 10:35
		          String pcsmc = "";
		          String jwhmc = "";
		          PoHJXX_MLPXXXXB poMlpxxxx = HibernateUtil.get(session, PoHJXX_MLPXXXXB.class, poRyxx.getMlpnbid());
		          if (poMlpxxxx != null) {
		            pcsmc = transDWDM(session, poMlpxxxx.getPcs());
		            PoXT_JWHXXB poJwhxx = HibernateUtil.get(session, PoXT_JWHXXB.class, poMlpxxxx.getJcwh());
		            jwhmc = (poJwhxx != null ? poJwhxx.getMc() : "");
		          }
		          poQyzxx.setBz(pcsmc + jwhmc);
		          //End_得到主迁人的地信息_2005/01/19 10:35
		        }
		        else
		        if (voQyzbhhtxx[i].getDysx() != null &&
		            voQyzbhhtxx[i].getDysx().longValue() == 2) {
		          poQyzxx.setSqryczrgx1(voQyzbhhtxx[i].getYczrgx());
		          poQyzxx.setGmsfhm1(poRyxx.getGmsfhm());
		          poQyzxx.setXm1(poRyxx.getXm());
		          poQyzxx.setCym1(poRyxx.getCym());
		          poQyzxx.setXb1(poRyxx.getXb());
		          poQyzxx.setMz1(poRyxx.getMz());
		          poQyzxx.setCsrq1(poRyxx.getCsrq());
		          poQyzxx.setCsdgjdq1(poRyxx.getCsdgjdq());
		          poQyzxx.setCsdssxq1(poRyxx.getCsdssxq());
		          poQyzxx.setCsdxz1(poRyxx.getCsdxz());
		          poQyzxx.setJggjdq1(poRyxx.getJggjdq());
		          poQyzxx.setJgssxq1(poRyxx.getJgssxq());
		          poQyzxx.setWhcd1(poRyxx.getWhcd());
		          poQyzxx.setZy1(poRyxx.getZy());
		          poQyzxx.setHyzk1(poRyxx.getHyzk());
		          poQyzxx.setQyyy1(qyyy);
		          poQyzxx.setYznf(voQyzbhhtxx[i].getYznf());//add hb 20060828 印制年份
		        }
		        else
		        if (voQyzbhhtxx[i].getDysx() != null &&
		            voQyzbhhtxx[i].getDysx().longValue() == 3) {
		          poQyzxx.setSqryczrgx2(voQyzbhhtxx[i].getYczrgx());
		          poQyzxx.setGmsfhm2(poRyxx.getGmsfhm());
		          poQyzxx.setXm2(poRyxx.getXm());
		          poQyzxx.setCym2(poRyxx.getCym());
		          poQyzxx.setXb2(poRyxx.getXb());
		          poQyzxx.setMz2(poRyxx.getMz());
		          poQyzxx.setCsrq2(poRyxx.getCsrq());
		          poQyzxx.setCsdgjdq2(poRyxx.getCsdgjdq());
		          poQyzxx.setCsdssxq2(poRyxx.getCsdssxq());
		          poQyzxx.setCsdxz2(poRyxx.getCsdxz());
		          poQyzxx.setJggjdq2(poRyxx.getJggjdq());
		          poQyzxx.setJgssxq2(poRyxx.getJgssxq());
		          poQyzxx.setWhcd2(poRyxx.getWhcd());
		          poQyzxx.setZy2(poRyxx.getZy());
		          poQyzxx.setHyzk2(poRyxx.getHyzk());
		          poQyzxx.setQyyy2(qyyy);
		          poQyzxx.setYznf(voQyzbhhtxx[i].getYznf());//add hb 20060828 印制年份
		        }
		        else
		        if (voQyzbhhtxx[i].getDysx() != null &&
		            voQyzbhhtxx[i].getDysx().longValue() == 4) {
		          poQyzxx.setSqryczrgx3(voQyzbhhtxx[i].getYczrgx());
		          poQyzxx.setGmsfhm3(poRyxx.getGmsfhm());
		          poQyzxx.setXm3(poRyxx.getXm());
		          poQyzxx.setCym3(poRyxx.getCym());
		          poQyzxx.setXb3(poRyxx.getXb());
		          poQyzxx.setMz3(poRyxx.getMz());
		          poQyzxx.setCsrq3(poRyxx.getCsrq());
		          poQyzxx.setCsdgjdq3(poRyxx.getCsdgjdq());
		          poQyzxx.setCsdssxq3(poRyxx.getCsdssxq());
		          poQyzxx.setCsdxz3(poRyxx.getCsdxz());
		          poQyzxx.setJggjdq3(poRyxx.getJggjdq());
		          poQyzxx.setJgssxq3(poRyxx.getJgssxq());
		          poQyzxx.setWhcd3(poRyxx.getWhcd());
		          poQyzxx.setZy3(poRyxx.getZy());
		          poQyzxx.setHyzk3(poRyxx.getHyzk());
		          poQyzxx.setQyyy3(qyyy);
		          poQyzxx.setYznf(voQyzbhhtxx[i].getYznf());//add hb 20060828 印制年份
		        }
		        //生成迁移证信息_end
		      } //for (int i = 0; i < voQyzbhhtxx.length; i++)

		      //保存迁移证信息
		      for (int i = 0; i < qyzxxList.size(); i++) {
		        PoHJSP_QYZXXB poQyzxx = (PoHJSP_QYZXXB) qyzxxList.get(i);
		        HibernateUtil.create(session, poQyzxx);
		      }

		      ///////////////////////////////////////////
		      //事务提交

		      /////////////////////////////////////////////
		      //生成业务返回信息
		      voQyzbhhtywfhxx = new VoQyzbhhtywfhxx();
		      voQyzbhhtywfhxx.setVoQyzbhhtfhxx( (VoQyzbhhtfhxx[]) qyzbhhtfhxxList.
		                                       toArray(new VoQyzbhhtfhxx[
		                                               qyzbhhtfhxxList.size()]));

		    return voQyzbhhtywfhxx;
	 }
}
