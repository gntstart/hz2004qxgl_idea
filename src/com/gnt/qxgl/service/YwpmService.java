package com.gnt.qxgl.service;

import java.util.List;
import java.util.Map;

import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.SjYwpm;
import com.gnt.qxgl.hz2004.entity.XtHzck;

/**
 * 
 * @author 刁杰
 * @since	2018.01.19
 */
public interface YwpmService {
	
	/**
	 * 查询主界面信息
	 * 包含：
	 * ID/地市代码/地市名称/派出所代码/派出所名称/业务数量/业务分类/统计时间
	 * @return
	 */
	public List<SjYwpm> queryYwpmDs();
	
	/**
	 * 分页查询业务排名
	 * 包含：
	 * 
	 * @param map			查询条件
	 * @return
	 */
	public Page queryYwpm(ExtMap<String, Object> params);
	
	/**
	 * 查询派出所统计报表
	 * @param params
	 * @return
	 */
	public List<SjYwpm> queryPr(ExtMap<String, Object> params);
	
}
