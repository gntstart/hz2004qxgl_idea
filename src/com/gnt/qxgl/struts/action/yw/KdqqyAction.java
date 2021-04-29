package com.gnt.qxgl.struts.action.yw;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.hz2004.entity.XT_ZQZ_QYZ_XLH;
import com.gnt.qxgl.hz2004.entity.XX_CZRK;
import com.gnt.qxgl.service.tj.RktjService;
import com.gnt.qxgl.service.yw.KdqqyService;
import com.google.gson.reflect.TypeToken;
import com.hzjc.hz2004.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KdqqyAction extends ExtCommonAction{
	private KdqqyService kdqqyService;
	
	private RktjService rktjService;

	public KdqqyService getKdqqyService() {
		return kdqqyService;
	}

	public void setKdqqyService(KdqqyService kdqqyService) {
		this.kdqqyService = kdqqyService;
	}
	
	public RktjService getRktjService() {
		return rktjService;
	}

	public void setRktjService(RktjService rktjService) {
		this.rktjService = rktjService;
	}

	public void queryKdqqy(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		Page p = kdqqyService.queryKdqqy(user, params);
		
		cform.setEntity(p);
	}
	
	public void queryHjywById(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		cform.setEntity(kdqqyService.queryHjywById(user, params));
	}
	
	/**
	 * 跨地区迁入登记，查询异地人员
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryYdqrdjRyxx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		cform.setEntity(kdqqyService.queryYdqrdjRyxx(user, params));
	}
	
	/**
	 * 查询常住人口基本信息
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryCzrkjbxx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		Page p = kdqqyService.queryCzrkjbxx(user, params);
		
		cform.setEntity(p);
	}
	
	public void queryRktj(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		Page p = rktjService.queryRktj(user,params);
		
		cform.setEntity(p);
	}
	
	public void queryRktjMx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		Page p = rktjService.queryRktjMx(user,params);
		
		cform.setEntity(p);
	}
	
	public void exportRktj(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		rktjService.exportRktj(user,params,response);
		
	}
	
	
	public void queryKDQCzrkjbxx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		Page p = kdqqyService.queryKDQCzrkjbxx(user, params);
		cform.setEntity(p);
	}


	public void queryKDQCzrkjbxxQxgl(BaseUser user, ExtCommonForm cform,
								 HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		Page p = kdqqyService.queryKDQCzrkjbxxQxgl(user, params);
		cform.setEntity(p);
	}
	/**
	 * 垮地市迁出
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void saveKdsQc(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		String qcdqbm = params.getString("formdq");

		String sbjbxx = params.getString("sbjbxx");
		String bggzxx = params.getString("bggzxx");
		String qczxxx = params.getString("qczxxx");
		
		List<VoBggzxxEx> voBggzxxEx = new ArrayList<VoBggzxxEx>();
		List<VoQczxxx> voQczxxx = new ArrayList<VoQczxxx>();
		VoSbjbxx voSbjbxx = null;
		
		if(CommonUtil.isNotEmpty(sbjbxx)){
			voSbjbxx = ExtCommonForm.getJsonData(sbjbxx, "yyyyMMdd", VoSbjbxx.class);
		}
		
		if(CommonUtil.isNotEmpty(qczxxx)){
			TypeToken<List<VoQczxxx>> typeToken = new TypeToken<List<VoQczxxx>>(){};
			voQczxxx = ExtCommonForm.getJsonData(typeToken, qczxxx);
		}
		
		if(CommonUtil.isNotEmpty(bggzxx)){
			TypeToken<List<VoBggzxxEx>> typeToken = new TypeToken<List<VoBggzxxEx>>(){};
			voBggzxxEx = ExtCommonForm.getJsonData(typeToken, bggzxx);
		}
		
		
		
		cform.setEntity(kdqqyService.saveKdsQc(user, qcdqbm, voBggzxxEx, voQczxxx, voSbjbxx,  params));
	}


	/**
	 * 垮省迁出
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void saveKdsQcQxgl(BaseUser user, ExtCommonForm cform,
						  HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);

		String qcdqbm = params.getString("formdq").substring(0,4);

		String sbjbxx = params.getString("sbjbxx");
		String bggzxx = params.getString("bggzxx");
		String qczxxx = params.getString("qczxxx");

		List<VoBggzxxEx> voBggzxxEx = new ArrayList<VoBggzxxEx>();
		List<VoQczxxx> voQczxxx = new ArrayList<VoQczxxx>();
		VoSbjbxx voSbjbxx = null;

		if(CommonUtil.isNotEmpty(sbjbxx)){
			voSbjbxx = ExtCommonForm.getJsonData(sbjbxx, "yyyyMMdd", VoSbjbxx.class);
		}

		if(CommonUtil.isNotEmpty(qczxxx)){
			TypeToken<List<VoQczxxx>> typeToken = new TypeToken<List<VoQczxxx>>(){};
			voQczxxx = ExtCommonForm.getJsonData(typeToken, qczxxx);
		}

		if(CommonUtil.isNotEmpty(bggzxx)){
			TypeToken<List<VoBggzxxEx>> typeToken = new TypeToken<List<VoBggzxxEx>>(){};
			voBggzxxEx = ExtCommonForm.getJsonData(typeToken, bggzxx);
		}



		cform.setEntity(kdqqyService.saveKdsQcQxgl(user, qcdqbm, voBggzxxEx, voQczxxx, voSbjbxx,  params));
	}
	
	/**
	 * 迁出注销信息查询
	 * @param user
	 * @param params
	 * @return
	 */
	public void queryKdsQczxxx(BaseUser user, ExtCommonForm cform,
				HttpServletRequest request, HttpServletResponse response) {
			ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
			
			cform.setEntity(kdqqyService.queryKdsQczxxx(user, params));
	}
	
	public void queryKDQHjspyw(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		cform.setEntity(kdqqyService.queryKDQHjspyw(user, params));
	}
	
	public void saveKdsQcEnd(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		String hjywid = params.getString("hjywid");	//对应迁出户籍业务ID
		String qcdq = params.getString("qcdq");		//对应迁出地区
		String spsm = params.getString("spsm");		//审批说明
		String cllx = params.getString("cllx").replaceAll("\\[", "").replaceAll("\\]", "");				//材料类型

		String VoQrspdjxx_str = params.getString("voQrspdjxx");
		VoQrspdjxx voQrspdjxx = ExtCommonForm.getJsonData(VoQrspdjxx_str, "yyyyMMdd", VoQrspdjxx.class);
		
		List<VoQrspdjzxx> voQrspdjzxx = new ArrayList<VoQrspdjzxx>();
		String voQrspdjzxx_str = params.getString("voQrspdjzxx");
		if(CommonUtil.isNotEmpty(voQrspdjzxx_str)){
			TypeToken<List<VoQrspdjzxx>> typeToken = new TypeToken<List<VoQrspdjzxx>>(){};
			voQrspdjzxx = ExtCommonForm.getJsonData(typeToken, voQrspdjzxx_str);
		}
		
		List<VoSpfdclxx> voSpfdclxx = new ArrayList<VoSpfdclxx>();
		if(CommonUtil.isNotEmpty(cllx)){
			String strs[] = cllx.split(",");
			for(String str:strs){
				int seek = str.indexOf("=");
				if(seek>0){
					String code = str.substring(0,seek).trim();
					//String codename = str.substring(seek+1).trim();
					VoSpfdclxx cl = new VoSpfdclxx();
					cl.setClbh(code);
					voSpfdclxx.add(cl);
				}
			}
		}
		
		cform.setEntity(kdqqyService.saveKdsQcEnd(user, hjywid,  qcdq,  spsm,  voQrspdjxx,  voQrspdjzxx.toArray(new VoQrspdjzxx[]{}), voSpfdclxx.toArray(new VoSpfdclxx[]{})));
	}
	
	/**
	 * 获取指定序列号
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void requestXLH(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		String year = params.getString("year");			//对应迁出户籍业务ID
		if(CommonUtil.isEmpty(year) || year.equalsIgnoreCase("null"))
			year = DateHelper.formateDate("yyyy");
		
		String zjlx = params.getString("zjlx");				//对应迁出地区
		String dqbm = params.getString("dqbm");	//审批说明
		
		XT_ZQZ_QYZ_XLH xlh = kdqqyService.requestXLH(dqbm, year, zjlx);
		String str = xlh.getZjbh().toString();
		if(str.length()<5)
			str = "00000".substring(0, 5-str.length()) + str;
		
		str = "皖" + year.substring(year.length()-1, year.length()) + DateHelper.formateDate("MM") + str;
		
		cform.setOther(str);
	}
	
	/**
	 * 获取指定身份证人所在地区（跨地区迁移用）
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void requestDqbm(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);

		String str = kdqqyService.requestDqbm(params);
		cform.setOther(str);
	}

	/**
	 * 获取指定人信息（跨地区迁移用）
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void requestDqbmAndCzrkjbxx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);

		List<XX_CZRK> list = kdqqyService.requestDqbmAndCzrkjbxx(params);
		cform.setEntity(list);
	}
	/**
	 * 根据业务流水号ywlsh查询准迁证随迁人信息
	 * add by zjm  20210301
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryKdsQcSqrxx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		cform.setEntity(kdqqyService.queryKdsQcSqrxx(user, params));
	}
	/**
	 * 根据业务流水号ywlsh查询迁移证随迁人信息
	 * add by zjm 20210302
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryKdsQrSqrxx(BaseUser user, ExtCommonForm cform,
			HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		
		cform.setEntity(kdqqyService.queryKdsQrSqrxx(user, params));
	}

	/**
	 * 查询常住人口地址信息信息
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void getDzxz(BaseUser user, ExtCommonForm cform,
							  HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		if (user == null)
			throw new ServiceException("已超时，请重新进入此功能！");

		// 添加登录用户
		if (user.getOtherParams() != null)
			params.putAll(user.getOtherParams());
		String dqbm = user.getYwdq();
		if (CommonUtil.isNotEmpty((String) params.get("dqbm"))) {
			dqbm = params.getString("dqbm");
		}
		params.put("dqbm",dqbm);
		Object p = kdqqyService.getDzxz(params);

		cform.setEntity(p);
	}
	/**
	 * 大专你院校迁入新增
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void processQrspdjyw(BaseUser user, ExtCommonForm cform,
						HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);

		String dqbm = params.getString("dqbm");
		String s_voQrspdjxx = params.getString("voQrspdjxx");
		String s_voQrspdjzxx = params.getString("voQrspdjzxx");
		String s_voSpfdclxx = params.getString("voSpfdclxx");

		VoQrspdjxx voQrspdjxx = ExtCommonForm.getJsonData(s_voQrspdjxx, "yyyyMMdd", VoQrspdjxx.class);
		List<VoQrspdjzxx> voQrspdjzxx = new ArrayList<VoQrspdjzxx>();
		List<VoSpfdclxx> voSpfdclxx = new ArrayList<VoSpfdclxx>();

		if(CommonUtil.isNotEmpty(s_voQrspdjzxx)){
			TypeToken<List<VoQrspdjzxx>> typeToken = new TypeToken<List<VoQrspdjzxx>>(){};
			voQrspdjzxx = ExtCommonForm.getJsonData(typeToken, s_voQrspdjzxx);
		}

		if(CommonUtil.isNotEmpty(s_voSpfdclxx)){
			TypeToken<List<VoSpfdclxx>> typeToken = new TypeToken<List<VoSpfdclxx>>(){};
			voSpfdclxx = ExtCommonForm.getJsonData(typeToken, s_voSpfdclxx);
		}

		String sfzString = "";
		if(CommonUtil.isNotEmpty(voQrspdjxx.getGmsfhm())) {
			sfzString = voQrspdjxx.getGmsfhm();
		}
		for(int i=0;i<voQrspdjzxx.size();i++) {
			VoQrspdjzxx vo = voQrspdjzxx.get(i);
			if(CommonUtil.isNotEmpty(vo.getGmsfhm()))
				sfzString += "," + vo.getGmsfhm();
		}

		VoQrspdjywfhxx fk = kdqqyService.processQrspdjyw(user,dqbm, voQrspdjxx, voQrspdjzxx.toArray(new VoQrspdjzxx[]{}), voSpfdclxx.toArray(new VoSpfdclxx[]{}));
		cform.setEntity(fk);
	}

	/**
	 * 查询常住 户地信息
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void queryHdxx(BaseUser user, ExtCommonForm cform,
						  HttpServletRequest request, HttpServletResponse response) {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);
		Long hhnbid = params.getLong("hhnbid");
		String dqbm = params.getString("dqbm");
		List list = kdqqyService.queryHdxx(hhnbid,dqbm);
		if(list.size()>0){
			VoHdxxHqFhxx  fh = (VoHdxxHqFhxx)list.get(0);
			ExtMap<String, Object> p = new ExtMap<String, Object>();
			p.put("ssxq", fh.getSsxq());
			p.put("jlx", fh.getJlx());
			p.put("mlph", fh.getMlph());
			p.put("mlxz", fh.getMlxz());
			p.put("pcs", fh.getPcs());
			p.put("zrq", fh.getZrq());
			p.put("xzjd", fh.getXzjd());
			p.put("jcwh", fh.getJcwh());

			Object obj = kdqqyService.getDzxz(p);
			list.add(obj);
		}else{
			throw new ServiceException("没有找到户地信息！");
		}
		cform.setEntity(list);
	}

	public void queryDzyxSjHjspZqzxx(BaseUser user, ExtCommonForm cform,
									 HttpServletRequest request, HttpServletResponse response) {
		try {
			if (user == null)
				throw new ActionException(LOGINOUT_MSG);

			Map<String, Object> map = ExtUtils.getRequestParames(request);
			int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
			int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
			map.put("sjfw", 1);
			map.put("dqbm",user.getYwdq());
			/*
			 * add by zjm 20210305
			 * 增加限制，登录名为HZADMIN3400查询全部单独处理
			 */
			if(user.getUser().getDlm().equals("HZADMIN3400")) {
				System.out.println("用户名为HZADMIN3400查询全部数据！");
				cform.setEntity(kdqqyService.queryDzyxSjHjspZqzxx(map, pageIndex, pageSize));
			}else {
				if (user.getOtherParams() == null) {
					String dwdmStr = " a.qrdhkdjjg like '" + user.getUser().getSsdwjgdm().substring(0, 4) + "%'";
					map.put("dwdmStr", dwdmStr);
					cform.setEntity(kdqqyService.queryDzyxSjHjspZqzxx(map, pageIndex, pageSize));
				} else {
					String sjfw = user.getSjfw();
					if (CommonUtil.isNotEmpty(sjfw)) {
						String[] sjfwStr = sjfw.split("\\|");
						String dwdmStr = " (";
						int i = 0;
						for (String sjfw1 : sjfwStr) {
							if (sjfw1 == null || sjfw1.equals(""))
								continue;
							if (i != 0) dwdmStr += " or ";
							dwdmStr += " a.qrdhkdjjg like '" + sjfw1 + "%'";
							i++;
						}
						dwdmStr += ") ";
						map.put("dwdmStr", dwdmStr);
						String zqzQzsj = SystemConfig.getSystemConfig("zqzQzsj");
						map.put("dsgxsj", zqzQzsj);
						cform.setEntity(kdqqyService.queryDzyxSjHjspZqzxx(map, pageIndex, pageSize));
					} else {
						cform.setEntity(new Page());
					}
				}
			}
		} catch (
				Exception e) {
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}

	}

	/**
	 * 大专你院校准迁证作废
	 * @param user
	 * @param cform
	 * @param request
	 * @param response
	 */
	public void dzyxZqzZf(BaseUser user, ExtCommonForm cform,
								HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
		ExtMap<String, Object> params = CommonUtil.getRequestParamesObject(request);

		String dqbm = params.getString("dqbm");
		Long spywid = params.getLong("spywid");
		kdqqyService.dzyxZqzZf(user,dqbm, spywid);
	}
}