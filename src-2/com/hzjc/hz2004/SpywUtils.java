package com.hzjc.hz2004;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;

import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.exception.ServiceException;
import com.hzjc.hz2004.constant.PublicConstant;
import com.hzjc.hz2004.po.PoHJXZ_YWBLXZXXB;
import com.hzjc.hz2004.vo.VoXtywxz;
import com.hzjc.wsstruts.vo.DefaultVO;

public class SpywUtils {
	public static String dateToAgeDay(String date) {
		if ((null == date) || ("".equals(date.trim()))) {
			return "";
		}
		// 胡斌 20060607 由于上面的取年龄方法有误，取不到正确的年龄，填加下面取年龄方法，和前台
		// 取年龄方法类似。
		long age = 0;
		long BYear = Long.parseLong(date.trim().substring(0, 4));// 取得出生年份
		long BMonth = Long.parseLong(date.trim().substring(4, 6));// 取得出生月份
		long BDay = Long.parseLong(date.trim().substring(6, 8));// 取得出生日

		SimpleDateFormat nowYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat nowMonth = new SimpleDateFormat("MM");
		SimpleDateFormat nowDay = new SimpleDateFormat("dd");
		long curYear = Long.parseLong(nowYear.format(new java.util.Date()));// 取当前年份
		long curMonth = Long.parseLong(nowMonth.format(new java.util.Date()));// 取当前月份
		long curDay = Long.parseLong(nowDay.format(new java.util.Date()));// 取当前日

		if (curDay < BDay) {
			curMonth = curMonth - 1;
		}
		if (curMonth < BMonth) {
			curYear = curYear - 1;
		}
		age = curYear - BYear;
		if (age < 0) {
			return "";
		}
		return String.valueOf(age);
	}

	public static VoXtywxz VerifyCheckLimit(Session session, String sYwid, DefaultVO dv) {
		return VerifyBusinessLimit(session, sYwid, dv, "2");
	}

	/**
	 * 根据业务ID和参数VO判断业务是否受限 不包含审批限制信息
	 * 
	 * @param sYwid
	 * @param dv
	 * @param sFlag
	 *            标志是否是审批限制 1:不判断审批限制，2：审批限制
	 * @return TRUE受限制，FALSE不受限制 sRtnXzmc:限制名称
	 */
	public static VoXtywxz VerifyBusinessLimit(Session session, String sYwid, DefaultVO dv, String sFlag) {
		boolean bFlag = false;
		VoXtywxz voXtywxz = new VoXtywxz();
		/**
		 * 首先根业务ID取得限制表达式
		 */
		List lstXtxzbds = null;
		List lstXtRtn = null;
		String sBds = "", sTransBds = "", sSpmbid = "";
		String sKey = "", sKeyData = "";
		int nKs = 0;
		int nJs = 0;
		try {
			StringBuffer strBufHql = new StringBuffer();
			strBufHql.append("select XT_YWBLXZXXB FROM PoHJXZ_YWBLXZXXB as XT_YWBLXZXXB where  ").append(" xzzt = '0'")
					.append(" and qybz ='").append(PublicConstant.QYBZ_QY).append("'").append(" and  xzywlx ='")
					.append(sYwid).append("'");

			lstXtxzbds = HibernateUtil.getObjectList(session, strBufHql.toString(), null);
			if (lstXtxzbds == null || lstXtxzbds.isEmpty()) {
				// 如果没找到表达式则表示不受限制
				voXtywxz.setLimitflag(false);
				voXtywxz.setLimitinfo("无限制表达式");
				return voXtywxz;
			}
			// 假如有多个表达式，循环判断表达式，如果有一个为TRUE，则返回TRUE；
			for (int i = 0; i < lstXtxzbds.size(); i++) {
				sBds = ((PoHJXZ_YWBLXZXXB) lstXtxzbds.get(i)).getXzbds(); // 取出限制表达式
				if (sBds != null && !"".equals(sBds)) { // 如果表达式存在，则判断表达式
					/**
					 * 根据参数VO替换表达式的参数
					 */
					// sTransBds = sBds;
					try {
						nKs = sBds.indexOf("[[");
						nJs = sBds.indexOf("]]");
						while (nKs >= 0) {
							sKey = sBds.substring(nKs + 2, nJs);
							if (dv.hasProperty(sKey)) {
								sKeyData = dv.queryProperty(sKey);
								sBds = sBds.substring(0, nKs) + sKeyData + sBds.substring(nJs + 2);
							} else if (sKey.equalsIgnoreCase("age")) {
								if (dv.hasProperty("csrq")) {
									sBds = sBds.substring(0, nKs) + dateToAgeDay(dv.queryProperty("csrq"))
											+ sBds.substring(nJs + 2);
								}
							}
							nKs = sBds.indexOf("[[", nJs + 2);
							nJs = sBds.indexOf("]]", nJs + 2);
						}
						/**
						 * 判断表达式是否为真 为真则表示受限制
						 */
						strBufHql.setLength(0);
						strBufHql.append("select XT_YWBLXZXXB FROM PoHJXZ_YWBLXZXXB as XT_YWBLXZXXB where ")
								.append(sBds);
						lstXtRtn = HibernateUtil.getObjectList(session,strBufHql.toString(),null);
						if (lstXtRtn != null && lstXtRtn.size() > 0) {
							sSpmbid = ((PoHJXZ_YWBLXZXXB) lstXtxzbds.get(i)).getSpmbid().toString().trim();
							// 如果找到信息且不是审批则表达式为tue（受限制）
							if ((sSpmbid == null || "".equals(sSpmbid) || "0".equals(sSpmbid)) && sFlag.equals("1")) {
								voXtywxz.setLimitinfo(((PoHJXZ_YWBLXZXXB) lstXtxzbds.get(i)).getXzmc()); // 取出限制名称
								voXtywxz.setLimitflag(true);
								return voXtywxz;
							} else if (sSpmbid != null && !"".equals(sSpmbid) && !"0".equals(sSpmbid)
									&& sFlag.equals("2")) {
								voXtywxz.setLimitinfo(((PoHJXZ_YWBLXZXXB) lstXtxzbds.get(i)).getXzmc()); // 取出限制名称
								voXtywxz.setSpmbid(Long.valueOf(sSpmbid));
								voXtywxz.setLimitflag(true);
								return voXtywxz;
							}
						}
					} catch (Exception ex) {
						voXtywxz.setLimitflag(false);
						voXtywxz.setLimitinfo("限制表达式中字段不正确");
						return voXtywxz;
					}
				} // if
			} // for
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		
		voXtywxz.setLimitinfo("条件存在且不受限制");
		voXtywxz.setLimitflag(false);
		
		return voXtywxz;
	}
}
