/**
 * Dataset分页对象
 */
package com.gnt.qxgl.common;

import java.util.List;

public class Page implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	private List list;
	private int totalCount;
	private String other;
	
	public Page() {
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 根据实体列表，构造分页信息类
	 *@param list
	 *实体列表
	 */
	@SuppressWarnings("unchecked")
	public Page(List list) {
		this.list = list;
	}

	/**
	 * 返回当前页实体列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}

	/**
	 * 获取总记录数，并不是getList().size()的值
	 * @return
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 设置列表
	 * @param list 
	 * 列表。
	 */
	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}

	/**
	 * 设置总记录数据
	 * @param totalCount 记录数
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
