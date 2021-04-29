package com.gnt.qxgl.service;

import java.util.List;
import java.util.Map;

import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.dict.bean.TreeNode;
import com.gnt.qxgl.hz2004.entity.XtJsxxb;

public interface SqService {
	public List<TreeNode> queryYsqJSTree(Map<String, Object> map);
	public List<TreeNode> queryWsqJSTree(Map<String, Object> map);
	
	public List<TreeNode> queryProjectTree();
	
	/**
	 * 获取项目/角色数，并且初始化loginName的选择节点
	 * @param loginName
	 * @return
	 */
	public List<TreeNode> queryProjectJSTree(Map<String, Object> map);
	
	/**
	 * 获取项目/角色数，并且初始化loginName的选择节点(可分配权限)
	 * @param map
	 * @return
	 */
	public List<TreeNode> queryProjectJSTreeFP(Map<String, Object> map);
	
	
	public List queryProject();
	
	/**
	 * 查询角色
	 * @param param
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Page queryJs(Map<String,Object> param,int pageIndex,int pageSize);
	
	
	/**
	 * 查询用户角色
	 * @param param
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Page queryUserJs(Map<String,Object> param,int pageIndex,int pageSize);
	
	/**
	 * 查询角色的功能点
	 * @param param
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Page queryFunc(Map<String,Object> param,int pageIndex,int pageSize);
	
	/**
	 * 查询角色分配的用户
	 * @param param
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Page queryZzjyByJs(Map<String,Object> param,int pageIndex,int pageSize);
	
	public XtJsxxb saveJs(Map<String,Object> param);
	public void deleteJs(Map<String,Object> param);
	public void saveJsFunc(Map<String,Object> param);
	public void saveZzjyJs(Map<String,Object> param);
	public void updateZzjyJs(Map<String,Object> param);
	
	/**
	 * 保存授权
	 * @param param
	 */
	public void saveProjectJs(Map<String,Object> param);
	
	/**
	 * 获取行政区划树字典
	 * @param param
	 * @return
	 */
	public List<TreeNode> queryXZQHTreeNodes(Map<String,String> param);
}
