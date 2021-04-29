package com.gnt.qxgl.common.dict;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.common.Constants;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.dict.bean.TreeNode;
import com.gnt.qxgl.common.dict.util.QxglUtils;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.ObjectUtil;
import com.gnt.qxgl.hz2004.entity.XT_XTKZCSB;
import com.gnt.qxgl.hz2004.entity.XT_XZJDXXB;
import com.gnt.qxgl.hz2004.entity.XT_XZQHB;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;

/**
 * 地区数据共享
 * @author Administrator
 *
 */
public class DQDictDataShare {
	//key=dqbm,Map<key=xzjdbm，value=obj>>
	//地区乡镇街道
	static public final Map<String,Map<String,XT_XZJDXXB>> xzjdMap = new HashMap<String,Map<String,XT_XZJDXXB>>();
	//地区单位
	static public final Map<String,Map<String,XtDwxxb>> dwMap = new HashMap<String,Map<String,XtDwxxb>>();
	//地区控制参数
	static public final Map<String,Map<String,XT_XTKZCSB>> kzcsMap = new HashMap<String,Map<String,XT_XTKZCSB>>();
	
	//行政区划，省库获取
	static public final Map<String,XT_XZQHB> xzqhMap = new HashMap<String,XT_XZQHB>();
	//行政区划树结构，省库获取
	static public final Map<String,List<XT_XZQHB>> xzqhTreeData = new HashMap<String,List<XT_XZQHB>>();
	
	/**
	 * 重载行政区划
	 */
	static public void realoadXzqh(){
		if(xzqhMap.size()==0){
			synchronized(xzqhMap){
				if(xzqhMap.size()==0){
						Connection conn = null;
						Statement stmt = null;
						ResultSet res = null;
						
						try{
							conn = QxglUtils.getQxxtConnection();
							if(conn==null)
								throw new Exception("字典库连接异常：" + DictServlet.url);
							
							stmt = conn.createStatement();
							res = stmt.executeQuery("select * from XT_XZQHB order by dm");
							//1	110000	北京市	BJS			1		
							//2	110100	北京市市辖区	BJSSXQ			1		
							//3	110101	北京市东城区	BJSDCQ			1		
							Map<String,List<XT_XZQHB>> xzqhTreeData_tmp = new HashMap<String,List<XT_XZQHB>>();
							while(res.next()){
								XT_XZQHB qh = ObjectUtil.copyInfo(XT_XZQHB.class, null, res);
								xzqhMap.put(qh.getDm(), qh);
								
								String parentKey = qh.getDm();
								if(parentKey.endsWith("0000")){
									parentKey = Constants.ROOT_XZQH;
								}else{
									if(parentKey.endsWith("00"))
										parentKey = parentKey.substring(0, 2) + "0000";
									else
										parentKey = parentKey.substring(0, 4) + "00";
								}
								
								List<XT_XZQHB> list = xzqhTreeData_tmp.get(parentKey);
								if(list==null){
									list = new ArrayList<XT_XZQHB>();
									xzqhTreeData_tmp.put(parentKey,list);
								}
								
								list.add(qh);
							}
							
							xzqhTreeData.clear();
							xzqhTreeData.putAll(xzqhTreeData_tmp);
							xzqhTreeData_tmp.clear();
						}catch(Exception ex){
							ex.printStackTrace();
							throw new ServiceException(ex);
						}finally{
							if(res!=null) try{res.close();}catch(Exception e){;}
							res = null;
							
							if(stmt!=null) try{stmt.close();}catch(Exception e){;}
							stmt = null;
							
							if(conn!=null) try{conn.close();}catch(Exception e){;}
							conn = null;
						}
				}
			}
		}
	}
	
	/**
	 * 获取所有行政区划
	 * @return
	 */
	static public java.util.Collection<XT_XZQHB> getAllXzqh(){
		if(xzqhMap.size()==0){
			realoadXzqh();
		}
		
		return DQDictDataShare.xzqhMap.values();
	}
	
	/**
	 * 依据编码，获取行政区划
	 * @param dm
	 * @return
	 */
	static public XT_XZQHB getXzqh(String dm){
		if(xzqhMap.size()==0){
			realoadXzqh();
		}
		
		XT_XZQHB qh = xzqhMap.get(dm);
		if(qh==null)
			;//throw new ServiceException("行政区划[" + dm + "]不存在！");
		
		return qh;
	}
	
	static public List<TreeNode> getTreeXzqh(String parent_dm){
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(xzqhMap.size()==0){
			realoadXzqh();
		}
		
		if(CommonUtil.isEmpty(parent_dm))
			parent_dm = Constants.ROOT_XZQH;
		else
			parent_dm = parent_dm.trim();
		
		List<XT_XZQHB> childs = xzqhTreeData.get(parent_dm);
		for(XT_XZQHB child:childs){
			TreeNode node = new TreeNode();
			node.setChecked(false);
			node.setText(child.getMc());
			node.setLeaf(!child.getDm().endsWith("00"));
			node.setXzqh(child);
			node.setCodevalue(child.getDm());
			
			list.add(node);
		}
		
		return list;
	}
	
	static public XT_XTKZCSB getKzcs(String kzlb){
		return getKzcs(BaseContext.getBaseUser().getYwdq(),kzlb);
	}
	
	static public XT_XTKZCSB getKzcs(String dqbm,String kzlb){
		if(!kzcsMap.containsKey(dqbm)){
			synchronized(kzcsMap){
				if(!kzcsMap.containsKey(dqbm)){
					Session session = null;
					try{
						session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
						@SuppressWarnings("unchecked")
						List<XT_XTKZCSB> list = HibernateUtil.getObjectList(session, "from XT_XTKZCSB", new Object[]{});
						Map<String,XT_XTKZCSB> map = new HashMap<String,XT_XTKZCSB>();
						for(XT_XTKZCSB xz:list){
							map.put(xz.getKzlb(), xz);
						}
						kzcsMap.put(dqbm, map);
					}catch(Exception e){
						e.printStackTrace();
						throw new ServiceException(e);
					}finally{
						if(session!=null)
							session.close();
					}	
				}
			}
		}
		
		Map<String,XT_XTKZCSB> map = kzcsMap.get(dqbm);
		if(!map.containsKey(kzlb)){
			synchronized(kzcsMap){
				Session session = null;
				try{
					session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
					@SuppressWarnings("unchecked")
					List<XT_XTKZCSB> list = HibernateUtil.getObjectList(session, "from XT_XTKZCSB where kzlb=?", new Object[]{kzlb});
					for(XT_XTKZCSB xz:list){
						map.put(xz.getKzlb(), xz);
					}
				}catch(Exception e){
					e.printStackTrace();
					throw new ServiceException(e);
				}finally{
					if(session!=null)
						session.close();
				}
			}
		}
		
		XT_XTKZCSB xzjd = map.get(kzlb);
		if(xzjd==null)
			throw new ServiceException("控制参数[" + kzlb + "]不存在！");
		
		return xzjd;
	}
	
	static public XT_XZJDXXB getXzjd(String dqbm,String xzjdbm){
		if(!xzjdMap.containsKey(dqbm)){
			synchronized(xzjdMap){
				if(!xzjdMap.containsKey(dqbm)){
					Session session = null;
					try{
						session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
						@SuppressWarnings("unchecked")
						List<XT_XZJDXXB> list = HibernateUtil.getObjectList(session, "from XT_XZJDXXB", new Object[]{});
						Map<String,XT_XZJDXXB> map = new HashMap<String,XT_XZJDXXB>();
						for(XT_XZJDXXB xz:list){
							map.put(xz.getDm(), xz);
						}
						xzjdMap.put(dqbm, map);
					}catch(Exception e){
						e.printStackTrace();
						throw new ServiceException(e);
					}finally{
						if(session!=null)
							session.close();
					}	
				}
			}
		}
		
		Map<String,XT_XZJDXXB> map = xzjdMap.get(dqbm);
		if(!map.containsKey(xzjdbm)){
			synchronized(xzjdMap){
				Session session = null;
				try{
					session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
					@SuppressWarnings("unchecked")
					List<XT_XZJDXXB> list = HibernateUtil.getObjectList(session, "from XT_XZJDXXB where dm=?", new Object[]{xzjdbm});
					for(XT_XZJDXXB xz:list){
						map.put(xz.getDm(), xz);
					}
				}catch(Exception e){
					e.printStackTrace();
					throw new ServiceException(e);
				}finally{
					if(session!=null)
						session.close();
				}
			}
		}
		
		XT_XZJDXXB xzjd = map.get(xzjdbm);
		if(xzjd==null)
			throw new ServiceException("乡镇街道编码[" + xzjdbm + "]不存在！");
		
		return xzjd;
	}
	
	static public XtDwxxb getDwxx(String dqbm,String dwdm){
		if(!dwMap.containsKey(dqbm)){
			synchronized(dwMap){
				if(!dwMap.containsKey(dqbm)){
					Session session = null;
					try{
						session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
						@SuppressWarnings("unchecked")
						List<XtDwxxb> list = HibernateUtil.getObjectList(session, "from XtDwxxb", new Object[]{});
						Map<String,XtDwxxb> map = new HashMap<String,XtDwxxb>();
						for(XtDwxxb xz:list){
							map.put(xz.getDm(), xz);
						}
						dwMap.put(dqbm, map);
					}catch(Exception e){
						e.printStackTrace();
						throw new ServiceException(e);
					}finally{
						if(session!=null)
							session.close();
					}	
				}
			}
		}
		
		Map<String,XtDwxxb> map = dwMap.get(dqbm);
		if(!map.containsKey(dwdm)){
			synchronized(dwMap){
				Session session = null;
				try{
					session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
					@SuppressWarnings("unchecked")
					List<XtDwxxb> list = HibernateUtil.getObjectList(session, "from XtDwxxb where dm=?", new Object[]{dwdm});
					for(XtDwxxb xz:list){
						map.put(xz.getDm(), xz);
					}
				}catch(Exception e){
					e.printStackTrace();
					throw new ServiceException(e);
				}finally{
					if(session!=null)
						session.close();
				}
			}
		}
		
		XtDwxxb dw = map.get(dwdm);
		if(dw==null)
			throw new ServiceException("单位编码[" + dwdm + "]不存在！");
		
		return dw;
	}
}
