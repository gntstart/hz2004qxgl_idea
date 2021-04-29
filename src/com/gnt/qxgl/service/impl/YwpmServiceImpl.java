package com.gnt.qxgl.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.hz2004.entity.SjYwpm;
import com.gnt.qxgl.service.YwpmService;

public class YwpmServiceImpl extends ServiceImpl implements YwpmService {

	@SuppressWarnings("unchecked")
	public List<SjYwpm> queryYwpmDs() {
		
		List<SjYwpm> result = new ArrayList<SjYwpm>();
		
		SqlParse sqlParse = new SqlParse(Config.getSql("querySjYwpm"));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("datefomat", "yyyy-mm-dd hh24:mi:ss");
		map.put("sysdatefomat", "yyyy-mm-dd");
		sqlParse.bind(map);
		SqlParam sqlParam = sqlParse.parse();
		
		List<Object[]> list = super.getObjectListBySql(sqlParam.getSql(), null,sqlParam.getParams().toArray() , null, null, null);
//		List<Object[]> list = super.getObjectListBySql(sqlParam.getSql(), null,null , null, null, null);
		
//		List<Object[]> list = super.getObjectListByHql(sqlParam.getSql());
		if(list != null && list.size() > 0){
			for (Iterator<Object[]> iterator = list.iterator(); iterator.hasNext();) {
				Object[] orr = (Object[]) iterator.next();
				SjYwpm ywpm = new SjYwpm();
				ywpm.setDsdm((String) orr[0]);
				ywpm.setDsmc((String) orr[1]);
				BigDecimal bd = (BigDecimal) orr[2];
				ywpm.setYwsl(bd.longValue());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					ywpm.setTjsj(sdf.parse((String)orr[3]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				result.add(ywpm);
			}
		}
		
		return result;
		
	}

	@SuppressWarnings("unchecked")
	public Page queryYwpm(ExtMap<String, Object> params) {
		
		int pageIndex = params.getInteger(ExtUtils.pageIndex);
		int pageSize = params.getInteger(ExtUtils.pageSize);
		
		List<SjYwpm> result = new ArrayList<SjYwpm>();
		
		SqlParse sqlParse = new SqlParse(Config.getSql("querySjYwpmMx"));
		params.put("datefomat", "yyyy-mm-dd hh24:mi:ss");
		params.put("sysdatefomat", "yyyy-mm-dd");
		sqlParse.bind(params);
		SqlParam sqlParam = sqlParse.parse();
		
		List<Object[]> list = super.getObjectListBySql(sqlParam.getSql(), null,sqlParam.getParams().toArray() , null, null, null,pageIndex ,pageSize);
		
		if(list != null && list.size() > 0){
			for (Iterator<Object[]> iterator = list.iterator(); iterator.hasNext();) {
				Object[] orr = (Object[]) iterator.next();
				//distinct(s.pcsdm),t.pcsmc,t.dsdm,t.dsmc,s.ywsl,to_char(q.tjsj, :datefomat)
				SjYwpm ywpm = new SjYwpm();
				ywpm.setPcsdm((String) orr[0]);
				ywpm.setPcsmc((String) orr[1]);
				ywpm.setDsdm((String) orr[2]);
				ywpm.setDsmc((String) orr[3]);
				BigDecimal bd = (BigDecimal) orr[4];
				ywpm.setYwsl(bd.longValue());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					ywpm.setTjsj(sdf.parse((String)orr[5]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				ywpm.setXq((String) orr[6]);
				
				
				result.add(ywpm);
			}
		}
		
		Page page = new Page();
		page.setList(result);
		
		SqlParse sqlParseTotal = new SqlParse(Config.getSql("querySjYwpmMxTotal"));
		sqlParseTotal.bind(params);
		SqlParam sqlTotalParam = sqlParseTotal.parse();
		List<Object> totalList = super.getObjectListBySql(sqlTotalParam.getSql(), null,sqlTotalParam.getParams().toArray() , null, null, null);
		if(totalList != null && totalList.size() > 0){
			BigDecimal bd = (BigDecimal) totalList.get(0);
			page.setTotalCount(bd.intValue());
		}
		
		return page;
		
	}

	@SuppressWarnings("unchecked")
	public List<SjYwpm> queryPr(ExtMap<String, Object> params) {

		SqlParse sqlParse = new SqlParse(Config.getSql("querySjYwpmPr"));
		params.put("sysdatefomat", "yyyy-mm-dd");
		params.put("sysdatemonthfomat", "yyyy-mm");
		sqlParse.bind(params);
		SqlParam sqlParam = sqlParse.parse();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<SjYwpm> list = super.getObjectListByHql(sqlParam.getSql(), sqlParam.getParams().toArray());
		if(list != null && list.size() > 0){
			for (Iterator<SjYwpm> iterator = list.iterator(); iterator.hasNext();) {
				SjYwpm yw = iterator.next();
				yw.setTjsjStr(sdf.format(yw.getTjsj()));
			}
		}
		
		return list;
	}

	
}
