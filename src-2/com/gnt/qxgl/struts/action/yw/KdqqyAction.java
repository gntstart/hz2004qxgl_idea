package com.gnt.qxgl.struts.action.yw;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.service.yw.KdqqyService;
import com.google.gson.reflect.TypeToken;
import com.hzjc.hz2004.vo.VoBggzxxEx;
import com.hzjc.hz2004.vo.VoQczxxx;
import com.hzjc.hz2004.vo.VoQrspdjxx;
import com.hzjc.hz2004.vo.VoQrspdjzxx;
import com.hzjc.hz2004.vo.VoSbjbxx;
import com.hzjc.hz2004.vo.VoSpfdclxx;

public class KdqqyAction extends ExtCommonAction{
	private KdqqyService kdqqyService;

	public KdqqyService getKdqqyService() {
		return kdqqyService;
	}

	public void setKdqqyService(KdqqyService kdqqyService) {
		this.kdqqyService = kdqqyService;
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
		
		cform.setEntity(kdqqyService.saveKdsQc(user, qcdqbm, voBggzxxEx, voQczxxx, voSbjbxx));
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
}
