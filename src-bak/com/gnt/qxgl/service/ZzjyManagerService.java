package com.gnt.qxgl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gnt.qxgl.bean.QuerySysUserInfo;
import com.gnt.qxgl.bean.SimpleJson;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.dict.bean.TreeNode;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;

public interface ZzjyManagerService {
	public long getMaxSeq(String pojoname,String pname,String dwdm);
	
	/**
	 * 查询警员
	 * @param map
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Page queryZzjy(Map<String,Object> map,int pageIndex,int pageSize);
	
	/**
	 * 依据ID查询警员
	 * @param map
	 * @return
	 */
	public QuerySysUserInfo queryZzjyById(Map<String,Object> map);
	
	/**
	 * 查询指定警员的签名
	 * @param usid
	 * @return
	 */
	public byte[] getZzjyTx(String usid);
	
	/**
	 * 读取机构的印章或者局长印章
	 * @param type
	 * @param usid
	 * @return
	 */
	public byte[] getZzjgImg(String type,String oraid);
	
	/**
	 * 初始化指定警员的密码
	 * @param usid
	 */
	public void initPassword(String usid);
	
	/**
	 * 删除警员
	 * @param ids
	 */
	public void changeZzjyZt(String dqbm, String ids,String yhzt);
	public void deleteZzjg(String ids);
	
	/**
	 * 查询组织机构
	 * @param map
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Page queryZzjg(Map<String,Object> map,int pageIndex,int pageSize);
	public Page querySearchZzjg(Map<String,Object> map,int pageIndex,int pageSize);
	public void saveJzZzjg(Map<String,Object> map);
	
	/**
	 * 保存修改组织机构
	 * @param parm
	 * @param req
	 * @return
	 */
	public SimpleJson saveZzjg(Map parm,HttpServletRequest req);
	
	/**
	 * 修改组织警员
	 * @param parm
	 * @param req
	 * @return
	 */
	public XtYhxxb saveZzjy(Map parm,HttpServletRequest req);
	
	/**
	 * 移动警员
	 * @param usid
	 * @param oldorg
	 * @param neworg
	 */
	public void moveZzjy(String usid,String oldorg,String neworg);
	
	/**
	 * IP设置和删除
	 * @param parm
	 * @return
	 */
	public List createIPXZ(Map parm);
	public void deleteIPXZ(Map parm);
	public Page getIPXZ(Map parm,int pageIndex,int pageSize);
	
	/**
	 * 数据范围相关
	 * @param parm
	 * @return
	 */
	public List createSJFW(Map parm);
	public void deleteSJFW(Map parm);
	public Page getSJFW(Map parm,int pageIndex,int pageSize);
	
	
	/**
	 * 等同权限
	 * @param parm
	 * @return
	 */
	public List createDTQX(Map parm);
	public void deleteDTQX(Map parm);
	public Page getDTQX(Map parm,int pageIndex,int pageSize);
	
	/**
	 * 动作权限
	 * @param parm
	 * @return
	 */
	public List createDZQX(Map parm);
	public void deleteDZQX(Map parm);
	public Page getDZQX(Map parm,int pageIndex,int pageSize);
	
	public List<TreeNode> getDDTree(HttpServletRequest req);
	
	/*
	 * 查询单位信息
	 */
	public List<TreeNode> queryDwxxTree(HttpServletRequest req);
	
	//查询单位和人员接口信息
	public List<TreeNode> queryDwxxRyTree(HttpServletRequest req);
}
