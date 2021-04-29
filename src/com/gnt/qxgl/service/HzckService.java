package com.gnt.qxgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.XtHzck;

public interface HzckService {
	
	/**
	 * 查询主界面信息
	 * 包含：
	 * 地市名称/区县及窗口数/补办大厅总数及在线数/派出所总数及在线数/在线率（派出所）/更新时间
	 * @return
	 */
	public List<XtHzck> getHzckInfo();
	
	/**
	 * 分页查询用户信息
	 * 包含：
	 * 用户名/所在区县/所在派出所/身份证号码/登录时间/用户状态/登录IP
	 * @param map			查询条件
	 * @param pageIndex		页码
	 * @param pageSize		每页显示数量
	 * @return
	 */
	public Page queryYhxx(Map<String,Object> map,int pageIndex,int pageSize);
	
	public List queryEchartsData(Map<String,Object> map);
	public List querySsxqqrsffbbData(Map<String,Object> map);
}
