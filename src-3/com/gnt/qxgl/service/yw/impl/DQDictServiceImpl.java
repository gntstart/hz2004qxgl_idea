package com.gnt.qxgl.service.yw.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.bean.ExtField;
import com.gnt.qxgl.bean.SjpzBean;
import com.gnt.qxgl.bean.SysCode;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Constants;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.dict.DQDictDataShare;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.common.dict.bean.Code;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.JsonFormatTool;
import com.gnt.qxgl.common.util.MemcachedUtils;
import com.gnt.qxgl.hz2004.entity.XT_JLXXXB;
import com.gnt.qxgl.hz2004.entity.XT_JWHXXB;
import com.gnt.qxgl.hz2004.entity.XT_SJPZB;
import com.gnt.qxgl.hz2004.entity.XT_XZQHB;
import com.gnt.qxgl.service.yw.DQDictService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hzjc.hz2004.po.PoXT_DWXXB;
import com.hzjc.hz2004.po.PoXT_JLXXXB;
import com.hzjc.hz2004.po.PoXT_JWHXXB;
import com.hzjc.hz2004.po.PoXT_XZJDXXB;

public class DQDictServiceImpl extends ServiceImpl implements DQDictService{
	public Serializable loadDict(BaseUser user, ExtMap<String, Object> params) {
		return null;
	}

	public SjpzBean querySjpzb(BaseUser user, ExtMap<String,Object> params){
		SjpzBean bean = new SjpzBean();
		
		String str = params.getString("pzlb");
		if(CommonUtil.isEmpty(str))
			throw new ServiceException("参数有错误！");
		
		Session session = null;
		try{
			Map<String,List<XT_SJPZB>> map = new HashMap<String,List<XT_SJPZB>>();
			
			String[] ids = str.split(",");
			for(String pzlb:ids){
				String returnKey = Constants.MEMCACHED_ATTR.DICT_SJPZB_ATTR + user.getYwdq() + "_" + pzlb;
				@SuppressWarnings("unchecked")
				List<XT_SJPZB> list = (List<XT_SJPZB>)MemcachedUtils.getValue(returnKey);
				if(list!=null){
					map.put(pzlb, list);
					continue;
				}
			
				if(session==null)
					session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
				
				String hql = "from XT_SJPZB t where pzlb=? order by id asc";
				
				@SuppressWarnings("unchecked")
				List<XT_SJPZB> list2 = (List<XT_SJPZB>)HibernateUtil.getObjectList(session, hql, new Object[]{pzlb});
				if(CommonUtil.isEmpty(list2))
					throw new ServiceException("配置" + pzlb + "没有找到!");
				
				map.put(pzlb, list2);
				
				MemcachedUtils.setValue(returnKey, list2);
			}
			
			Set<String> dictSet= new HashSet<String>();
			Map<String,List<SysCode>> dictmap = new HashMap<String,List<SysCode>>();
			for(List<XT_SJPZB> pzlist:map.values()){
				for(XT_SJPZB pz:pzlist){
					if(pz.getFieldtypename()!=null && pz.getFieldtypename().equals("codeedit")){
						if(CommonUtil.isEmpty(pz.getDsname()))
							continue;
						
						String dsname = pz.getDsname().trim().toUpperCase();
						if(dictSet.contains(dsname))
							continue;

						List<SysCode> list2 = DictData.getSysCodeList(dsname);
						if(list2!=null && list2.size()>0)
							dictmap.put(dsname, list2);
						
						dictSet.add(dsname);
					}
				}
			}
			
			bean.setPzMap(map);
			bean.setDictMap(dictmap);
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		
		return bean;
	}
	
	public List<ExtField> queryYsjpzbJS(BaseUser user, ExtMap<String, Object> params) {
		String pzlb = params.getString("pzlb");
		if(CommonUtil.isEmpty(pzlb))
			throw new ServiceException("配置有错误！");
		
		String returnKey = Constants.MEMCACHED_ATTR.DICT_SJPZB_ATTR + user.getYwdq() + "_" + pzlb;
		
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
			
			String hql = "from XT_SJPZB t where pzlb=? order by id asc";
			
			Set<String> dictSet= new HashSet<String>();
			
			@SuppressWarnings("unchecked")
			List<XT_SJPZB> list = HibernateUtil.getObjectList(session, hql, new Object[]{pzlb});
			List<ExtField> re = new ArrayList<ExtField>();
			for(XT_SJPZB pz :list){
				ExtField f = new ExtField(pz);
				if(f.getDsname()!=null)
					dictSet.add(f.getDsname());
				
				re.add(f);
			}
			
			//Gson gson = new GsonBuilder().create();
			//System.out.println(JsonFormatTool.formatJson(gson.toJson(re, new TypeToken<List<ExtField>>() {}.getType()),"\t"));
			
			MemcachedUtils.setValue(returnKey, re);

			return re;
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}

	public Page searchXxb(BaseUser user, ExtMap<String,Object> params){
		String dqbm = user.getYwdq();
		String optype = params.getString("optype");
		String search_code = params.getString("search_code");
		String visiontype = params.getString("visiontype");
		List<Code> list = new ArrayList<Code>();
		
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(dqbm).openSession();
			if(visiontype!=null && CommonUtil.isNotEmpty(search_code) && optype!=null && optype.equals("eq")){
				//必须返回值，否则前台会进入死循环，反复调用
				if(visiontype.equals("DWXXB")){
					PoXT_DWXXB dw = HibernateUtil.get(session, PoXT_DWXXB.class, search_code);
					Code code = new Code();
					if(dw==null){
						code.setCode(search_code);
						code.setName(search_code + "代码没找到！");
					}else{
						code.setCode(dw.getDm());
						code.setName(dw.getMc());
					}
					list.add(code);
				}
				
				if(visiontype.equals("JLXXXB")){
					PoXT_JLXXXB dw = HibernateUtil.get(session, PoXT_JLXXXB.class, search_code);
					Code code = new Code();
					if(dw==null){
						code.setCode(search_code);
						code.setName(search_code + "代码没找到！");
					}else{
						code.setCode(dw.getDm());
						code.setName(dw.getMc());
					}
					list.add(code);
				}
				
				if(visiontype.equals("JWHXXB")){
					PoXT_JWHXXB dw = HibernateUtil.get(session, PoXT_JWHXXB.class, search_code);
					Code code = new Code();
					if(dw==null){
						code.setCode(search_code);
						code.setName(search_code + "代码没找到！");
					}else{
						code.setCode(dw.getDm());
						code.setName(dw.getMc());
					}
					list.add(code);
				}
				
				if(visiontype.equals("XZJDXXB")){
					PoXT_XZJDXXB dw = HibernateUtil.get(session, PoXT_XZJDXXB.class, search_code);
					Code code = new Code();
					if(dw==null){
						code.setCode(search_code);
						code.setName(search_code + "代码没找到！");
					}else{
						code.setCode(dw.getDm());
						code.setName(dw.getMc());
					}
					list.add(code);
				}
			}
		}catch(Exception e){
			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
		
		Page p = new Page();
		p.setList(list);
		return p;
	}
	
	public Page serachJlx(List<XT_JLXXXB> list,String searchWord, String returnKey){
		List<XT_JLXXXB> listRet = new ArrayList<XT_JLXXXB>();
		for(XT_JLXXXB o:list){
			String str = o.getDm() + "," + o.getMc() + "," + o.getWbpy() + "," + o.getZwpy();
			if(str.indexOf(searchWord)>=0){
				listRet.add(o);
			}
		}
		Page p = new Page();
		p.setList(listRet);
		
		MemcachedUtils.setValue(searchWord, listRet, 60*30);
		
		return p;
	}
	
	public Page searchJlx(BaseUser user, ExtMap<String,Object> params){
		String search_code = params.getString("search_code");
		String uid = user.getUser().getYhid();
		String returnKey = Constants.MEMCACHED_ATTR.DICT_SEARCH_ATTR + uid + "_jlx_" + search_code;
		String jlxKey = Constants.MEMCACHED_ATTR.DICT_SEARCH_ALL_ATTR + uid + "_jlx_";
		
		//优先从缓存中搜索结果
		Object obj = MemcachedUtils.getValue(returnKey);
		if(obj!=null){
			Page p = new Page();
			p.setList((List)obj);
			return p;
		}
		
		List<XT_JLXXXB> jlxList = (List<XT_JLXXXB>)MemcachedUtils.getValue(jlxKey);
		if(jlxList!=null)
			return serachJlx(jlxList,search_code,returnKey);
		
		Session session = null;
		try{
			session = HibernateUtil.getSystemSessionFactory(user.getYwdq()).openSession();
			
			SqlParse sqlParse = new SqlParse(Config.getSql("/conf/segment/dq/default","queryJlxJwh"));
			sqlParse.bind(params);
			SqlParam sqlParam = sqlParse.parse();
			
			Map<String,XT_JLXXXB> jlxMap = new HashMap<String,XT_JLXXXB>();
			jlxList = new ArrayList<XT_JLXXXB>();
			List<?> list = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
			for(Object o:list){
				Object[] objs = (Object[])o;
				XT_JLXXXB  jlx = (XT_JLXXXB)objs[0];
				XT_JWHXXB jwh = (XT_JWHXXB)objs[1];
				
				if(!jlxMap.containsKey(jlx.getDm())){
					jlx.setJwhList(new ArrayList<XT_JWHXXB>());
					jlxMap.put(jlx.getDm(), jlx);
					jlxList.add(jlx);
				}
				
				//冗余乡镇街道和单位名称
				if(CommonUtil.isNotEmpty(jwh.getXzjddm()))
					jwh.setXzjddm_name(DQDictDataShare.getXzjd(user.getYwdq(), jwh.getXzjddm()).getMc());
				
				if(CommonUtil.isNotEmpty(jwh.getDwdm())){
					jwh.setDwdm_name(DQDictDataShare.getDwxx(user.getYwdq(), jwh.getDwdm()).getMc());
					jwh.setDwdm_bz(DQDictDataShare.getDwxx(user.getYwdq(), jwh.getDwdm()).getBz());
				}
				
				jlx.getJwhList().add(jwh);
			}
			
			MemcachedUtils.setValue(jlxKey, jlxList, 60*30);
			
			return serachJlx(jlxList,search_code,returnKey);
		}catch(Exception e){
			e.printStackTrace();

			throw new ServiceException(e);
		}finally{
			if(session!=null)
				session.close();
		}
	}
	
	public Page searchXzqh(BaseUser user, ExtMap<String,Object> params){
		String search_code = params.getString("search_code");
		String returnKey = Constants.MEMCACHED_ATTR.DICT_SEARCH_ATTR  + "_all_xzqh_" + search_code;
		String optype = params.getString("optype");
		
		List<Code> list = new ArrayList<Code>();
		
		if(CommonUtil.isNotEmpty(optype)){
			//翻译
			XT_XZQHB qh = DQDictDataShare.getXzqh(search_code);
			if(qh==null && optype!=null && optype.equals("eq")){
				qh = new XT_XZQHB();
				qh.setDm(search_code);
				qh.setMc(search_code + " 找不到！");
			}
			if(qh!=null){
				Code code = new Code();
				code.setCode(qh.getDm());
				code.setName(qh.getMc());
				list.add(code);
				
				Page p = new Page();
				p.setList(list);
				return p;
			}
		}
		
		//优先从缓存中搜索结果
		Object obj = MemcachedUtils.getValue(returnKey);
		if(obj!=null){
			Page p = new Page();
			p.setList((List)obj);
			return p;
		}
		
		for(XT_XZQHB qh:DQDictDataShare.getAllXzqh()){
			if((qh.getMc() + qh.getWbpy() + "," + qh.getZwpy() + "," + qh.getDm()).indexOf(search_code)<0)
				continue;
			
			Code code = new Code();
			code.setCode(qh.getDm());
			code.setName(qh.getMc());
			list.add(code);
			
			if(list.size()>100)
				break;
		}
		
		MemcachedUtils.setValue(returnKey, list, 24*3600);
		
		Page p = new Page();
		p.setList(list);
		
		return p;
	}
}
