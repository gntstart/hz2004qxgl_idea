package com.gnt.qxgl.service.yw;

import java.util.List;
import com.gnt.qxgl.bean.ExtField;
import com.gnt.qxgl.bean.SjpzBean;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;

public interface DQDictService {
	public java.io.Serializable loadDict(BaseUser user, ExtMap<String,Object> params);
	
	
	/**
	 * 街路项检索
	 * @param user
	 * @param params
	 * @return
	 */
	public Page searchJlx(BaseUser user, ExtMap<String,Object> params);
	
	/**
	 * 地区编码检索
	 * @param user
	 * @param params
	 * @return
	 */
	public Page searchXzqh(BaseUser user, ExtMap<String,Object> params);
	
	public Page searchXxb(BaseUser user, ExtMap<String,Object> params);
	
	/**
	 * 获取数据配置为extjs
	 * @param user
	 * @param params
	 * @return
	 */
	public List<ExtField> queryYsjpzbJS(BaseUser user, ExtMap<String,Object> params);
	
	/**
	 * 一次获取多个系统配置表
	 * @param user
	 * @param params
	 * @return
	 */
	public SjpzBean querySjpzb(BaseUser user, ExtMap<String,Object> params);
}
