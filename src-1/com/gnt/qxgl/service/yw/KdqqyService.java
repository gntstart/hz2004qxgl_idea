package com.gnt.qxgl.service.yw;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.HZ_ZJ_SB;
import com.hzjc.hz2004.vo.VoBggzxxEx;
import com.hzjc.hz2004.vo.VoQczxxx;
import com.hzjc.hz2004.vo.VoQczxywfhxx;
import com.hzjc.hz2004.vo.VoQrspdjxx;
import com.hzjc.hz2004.vo.VoQrspdjywfhxx;
import com.hzjc.hz2004.vo.VoQrspdjzxx;
import com.hzjc.hz2004.vo.VoSbjbxx;
import com.hzjc.hz2004.vo.VoSpfdclxx;

public interface KdqqyService {
	public Page queryKdqqy(BaseUser user, ExtMap<String,Object> params);
	
	public HZ_ZJ_SB queryHjywById(BaseUser user, ExtMap<String,Object> params);
	
	/**
	 * 获取异地人员信息
	 * @param user
	 * @param params
	 * @return
	 */
	public Page queryYdqrdjRyxx(BaseUser user, ExtMap<String,Object> params);
	
	/**
	 * 获取常住人口基本信息
	 * @param user
	 * @param params
	 * @return
	 */
	public Page queryCzrkjbxx(BaseUser user, ExtMap<String,Object> params);
	
	/**
	 * 垮地市迁出
	 * @param user				当前用户
	 * @param qcdqbm			迁出地
	 * @param voBggzxxEx		变更更正信息
	 * @param voQczxxx		迁出注销信息
	 * @param voSbjbxx			申报基本信息
	 * @return
	 */
	public VoQczxywfhxx saveKdsQc(BaseUser user,String qcdqbm, List<VoBggzxxEx> voBggzxxEx,List<VoQczxxx> voQczxxx, VoSbjbxx voSbjbxx);
	
	/**
	 * 迁出注销信息查询
	 * @param user
	 * @param params
	 * @return
	 */
	public Page queryKdsQczxxx(BaseUser user, ExtMap<String,Object> params);
	
	/**
	 * 迁入审批登记业务 processQrspdjyw
	 * @param spsm
	 * @param voQrspdjxx
	 * @param voQrspdjzxx
	 * @param voSpfdclxx
	 * @return 
	 */
	public VoQrspdjywfhxx saveKdsQcEnd(BaseUser user,String hjywid, String qcdq, String spsm, VoQrspdjxx voQrspdjxx, VoQrspdjzxx voQrspdjzxx[], VoSpfdclxx voSpfdclxx[]);
}
