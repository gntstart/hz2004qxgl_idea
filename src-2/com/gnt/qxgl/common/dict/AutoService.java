package com.gnt.qxgl.common.dict;

import javax.servlet.ServletConfig;

/**
 * 自动服务加载器，可通过web.xml配置设置加载
 * @author sh
 *
 */
public interface AutoService{
	/**
	 * 初始化方法
	 * @param config
	 */
	public void init(ServletConfig config);
	
	/**
	 * 开始方法
	 */
	public void start();
	
	/**
	 * 结束方法
	 */
	public void stop();
}
