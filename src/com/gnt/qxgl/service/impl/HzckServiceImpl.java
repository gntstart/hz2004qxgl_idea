package com.gnt.qxgl.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.hz2004.entity.XtHzck;
import com.gnt.qxgl.hz2004.entity.XtHzckMx;
import com.gnt.qxgl.service.HzckService;
import com.hzjc.hz2004.po.PoECHARTSDATA;
import com.hzjc.hz2004.po.PoSSXQQRSFFBB;

public class HzckServiceImpl extends ServiceImpl implements HzckService {

	@SuppressWarnings("unchecked")
	public List<XtHzck> getHzckInfo() {
		
		//optype.equals("QX")?"queryUserJs":"queryUserJsFP"
//		SqlParse sqlParse = new SqlParse(Config.getSql("queryHzck"));
		SqlParse sqlParse = new SqlParse(Config.getSql("queryHzckView"));
		
		List<XtHzck> result = super.getObjectListByHql(sqlParse.parse().getSql());
		for(XtHzck vo :result){
			int hzdtzs = vo.getHbzs();
			int hzdtzx = vo.getHbzx();
			int pcszs = vo.getPcszs();
			int pcszx = vo.getPcszx();
			
			String hbdt = hzdtzs + " 其中 " + hzdtzx;
			vo.setHbdt(hbdt);
			String pcs = pcszs + " 其中 " + pcszx;
			vo.setPcsck(pcs);
//			double zxl = (double) ((hzdtzx + pcszx)/(hzdtzs + pcszs)) * 100;
			/**
			 	2017.04.24
			 	修改	刁杰
			 	在线率修改为派出所的在线率
			 */
//			int zxl = (int) (((double)(hzdtzx + pcszx)/(double)(hzdtzs + pcszs)) * 100);
			int zxl = (int) (((double)(pcszx)/(double)(pcszs)) * 100);
			vo.setZxl(zxl + "%");
			/*
			if(vo.getGxsjStr() != null){
				System.out.println("转换值：" + vo.getGxsjStr());
				try {
					vo.setGxsj(DateHelper.toDate(vo.getGxsjStr().trim(), "yyyyMMddHHmmssss"));
				} catch (Exception e) {
					System.out.println("日期转换错误！");
				}
			}
			*/
		}
		
		return result;
		
	}
	
	/**
	 * 测试用模拟数据
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<XtHzck> test(List<XtHzck> result){
		
		for (int i = 1; i <= 16; i++) {
			XtHzck vo = new XtHzck();
			if(i < 10){
				vo.setDqbm("340" + i);
			}else{
				vo.setDqbm("34" + i);
			}
			
			double hbdtzs = Math.random() * i * 100;
			double hbdtzx = Math.random() * i * 50;
			double pcszs = Math.random() * i * 100;
			double pcszx = Math.random() * i * 50;
			
			vo.setTitle(i + "");
			String hbdt = (int)hbdtzs + "/" + (int)hbdtzx;
			vo.setHbdt(hbdt);
			String pcs = (int)pcszs + "/" + (int)pcszx;
			vo.setPcsck(pcs);
//			double zxl = (double) ((hzdtzx + pcszx)/(hzdtzs + pcszs)) * 100;
			int zxl = (int) (((hbdtzx + pcszx)/(hbdtzs + pcszs)) * 100);
			vo.setZxl(zxl + "%");
			
			result.add(vo);
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Page queryYhxx(Map<String, Object> map, int pageIndex, int pageSize) {
		
		SqlParse sqlParse = new SqlParse(Config.getSql("queryHzckYhxx"));
		sqlParse.bind(map);
		SqlParam sqlParam = sqlParse.parse();
		
		Page p = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
		
		for (Iterator<XtHzckMx> it = p.getList().iterator(); it.hasNext();) {
			XtHzckMx mx = it.next();
			
			if(mx.getDlsj() == null){
				mx.setYhzt("离线");
			}else{
				mx.setYhzt("在线");
			}
			
		}
		
		return p;
	}

	@Override
	public List queryEchartsData(Map<String, Object> params) {
		SqlParse sqlParse = new SqlParse(Config.getSql("queryEchartsData"));
		
		
		//SqlParse sqlParse2 = new SqlParse(Config.getSql("querySSXQQRSFFBB"));
		
		
		List list = super.getObjectListByHql(sqlParse.parse().getSql());
//		for(Object obj:list){
//			PoECHARTSDATA poECHARTSDATA = (PoECHARTSDATA) obj;
//			Map<String, Object> map =new HashMap();
//			
//			map.put("qhdm", poECHARTSDATA.getQhdm());
//			sqlParse2.bind(map);
//			SqlParam sqlParam = sqlParse2.parse();
//			List<PoSSXQQRSFFBB> list2= super.getObjectListByHql(sqlParam.getSql(),sqlParam.getParams().toArray());
//			poECHARTSDATA.setXzqhList(list2);
//		}
		return list;

	}

	@Override
	public List querySsxqqrsffbbData(Map<String, Object> map) {
		SqlParse sqlParse2 = new SqlParse(Config.getSql("querySSXQQRSFFBB"));
		//List list = super.getObjectListBySql(sqlParse2.parse().getSql(), null,sqlParse2.parse().getParams().toArray() , null, null, null);
		//super.getObjectListByHql(sqlParse2.parse().getSql());
		List list =super.executeSqlQuery(sqlParse2.parse().getSql(), null);
		return list;
	}
	
}
