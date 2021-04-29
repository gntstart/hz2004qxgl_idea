package com.gnt.qxgl.service.yw;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.HZ_ZJ_SB;
import com.gnt.qxgl.hz2004.entity.XT_ZQZ_QYZ_XLH;
import com.gnt.qxgl.hz2004.entity.XX_CZRK;
import com.hzjc.hz2004.vo.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface KdqqyService {
	/**
	 * 获取地区编码
	 * @param params
	 * @return
	 */
	public String requestDqbm(ExtMap<String,Object> params);
	
	/**
	 * 获取常住人口基本信息
	 * @param params
	 * @return
	 */
	public List<XX_CZRK> requestDqbmAndCzrkjbxx(ExtMap<String,Object> params);
	
	/**
	 * 获取唯一证件编号
	 * @param dqbm
	 * @param year
	 * @param zjlx
	 * @return
	 */
	public XT_ZQZ_QYZ_XLH requestXLH(String dqbm,String year,String zjlx);
	
	public Page queryKdqqy(BaseUser user, ExtMap<String,Object> params);
	
	public Page queryKDQHjspyw(BaseUser user, ExtMap<String,Object> params);
	
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
	 * 获取常驻人口基本信息，初始化迁出（跨地区）
	 * @param user
	 * @param params
	 * @return
	 */
	public Page queryKDQCzrkjbxx(BaseUser user, ExtMap<String,Object> params);

	/**
	 * 获取常住人口基本信息
	 * @param user
	 * @param params
	 * @return
	 */
	public Page queryKDQCzrkjbxxQxgl(BaseUser user, ExtMap<String,Object> params);
	
	/**
	 * 垮地市迁出
	 * @param user				当前用户
	 * @param qcdqbm			迁出地
	 * @param voBggzxxEx		变更更正信息
	 * @param voQczxxx		迁出注销信息
	 * @param voSbjbxx			申报基本信息
	 * @return
	 */
	public VoQczxywfhxx saveKdsQc(BaseUser user,String qcdqbm, List<VoBggzxxEx> voBggzxxEx,List<VoQczxxx> voQczxxx, VoSbjbxx voSbjbxx, ExtMap<String, Object> params);

	/**
	 * 垮地市迁出
	 * @param user				当前用户
	 * @param qcdqbm			迁出地
	 * @param voBggzxxEx		变更更正信息
	 * @param voQczxxx		迁出注销信息
	 * @param voSbjbxx			申报基本信息
	 * @return
	 */
	public VoQczxywfhxx saveKdsQcQxgl(BaseUser user,String qcdqbm, List<VoBggzxxEx> voBggzxxEx,List<VoQczxxx> voQczxxx, VoSbjbxx voSbjbxx, ExtMap<String, Object> params);


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

	/**
	 * 根据业务流水号ywlsh查询准迁证随迁人信息
	 * add by zjm  20210301
	 * @param user
	 * @param params
	 * @return
	 */
	public Page queryKdsQcSqrxx(BaseUser user, ExtMap<String, Object> params);

	/**
	 * 根据业务流水号ywlsh查询迁移证随迁人信息
	 * add by zjm 20210302
	 * @param user
	 * @param params
	 * @return
	 */
	public Page queryKdsQrSqrxx(BaseUser user, ExtMap<String, Object> params);

	public Object getDzxz(ExtMap<String, Object> params);

	List queryHdxx(Long hhnbid,String dqbm);

	VoQrspdjywfhxx processQrspdjyw(BaseUser user, String dqbm, VoQrspdjxx voQrspdjxx, VoQrspdjzxx[] toArray, VoSpfdclxx[] toArray1) throws InvocationTargetException, IllegalAccessException;

	Page queryDzyxSjHjspZqzxx(Map<String, Object> map, int pageIndex, int pageSize);

	void dzyxZqzZf(BaseUser user, String dqbm, Long spywid);
}
