package com.gnt.qxgl.base;

import com.alibaba.fastjson.JSONObject;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.hz2004.entity.XtYhsjfwb;
import com.gnt.qxgl.service.Hz2004Service;
import com.hzjc.hz2004.po.PoXT_YHXXB;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class QueryCsjDbController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post方式解决中文乱码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8"); 
        JSONObject json = new JSONObject();
        try {
        	 Map<String, Object> map = ExtUtils.getRequestParames(req);
//        	 LoginService loginService = (LoginService) SpringContainer.getObject("LoginService");
             int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
             int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
             Long yhid = Long.parseLong(map.get("yhid").toString());//url 传过来的yhid，查询地市 用户表和数据范围表
             String fromDq = (String) map.get("fromDq");
             Session session = HibernateUtil.getSystemSessionFactory(fromDq).openSession();
             String hqlyhxxb = "select a from PoXT_YHXXB a where a.yhid=?";
             String hqlyhsjfwb = "select sjfw from XtYhsjfwb a where xqlx='1' and yhid=?";
			 List<PoXT_YHXXB> list = HibernateUtil.getObjectList(session, hqlyhxxb, new Object[]{yhid});
			 PrintWriter out = resp.getWriter();
			 if(list.size()==0) {
				 //out.print("用户名不存在！");
				 json.put("code", "error");
				 json.put("message", "用户名不存在！");
				 out.print(json);
				 throw new ServiceException("用户名不存在！");
			 }else if(list.size()>1) {
				 json.put("code", "error");
				 json.put("message", "同一用户名存在多条记录！");
//				 out.print("同一用户名存在多条记录！");
				 out.print(json);
				 throw new ServiceException("同一用户名存在多条记录！");
			 }else {
				 PoXT_YHXXB yhxxb = list.get(0);
				 List<XtYhsjfwb> sjfwlist = HibernateUtil.getObjectList(session, hqlyhsjfwb, new Object[]{yhid+""});
				 List<String> qhdmList = new ArrayList<String>();
				 List<String> dwdmList = new ArrayList<String>();
				 for(Object o:sjfwlist){
					String[] str = o.toString().split("\\|");
					if(str.length>=2){
						dwdmList.add(str[1]);
					}else if(str.length==1){
						qhdmList.add(str[0]);
					}
//					for (int i = 0; i < str.length; i++) {
//	            		String sjfwTemp = str[i];
//	            		if(sjfwTemp.length()==6) {
//
//	            		}else if(sjfwTemp.length()==9) {
//	            			dwdmList.add(sjfwTemp);
//	            		}else{
//	            			continue;
//	            		}
//	            	}
						
				 }
            	map.put("sjfw",1);
				 if(qhdmList.size()>0){
					 String xzqhStr1=" (";
					 String xzqhStr2=" (";
					 int i = 0;
					 for (String qhdm : qhdmList) {
						 if (i != 0){
							 xzqhStr1 += " or ";
							 xzqhStr2 += " or ";
						 }
						 xzqhStr1 += " qcd_hkdjjg_gajgjgdm like '" + qhdm + "%'";
						 xzqhStr2 += " hkdjpcs like '" + qhdm + "%'";
						 i++;
					 }
					 xzqhStr1 += ") ";
					 xzqhStr2 += ") ";

					 map.put("xzqh1",xzqhStr1);
					 map.put("xzqh2",xzqhStr2);
				 }

//            	if(qhdmList.size()>dwdmList.size()) {
//            		map.put("xzqh",qhdmList.get(0));
//            	}else {
//
//            	}
				 if (dwdmList.size()>0){
					 String dwdmStr1=" (";
					 String dwdmStr2=" (";
					 int i = 0;
					 for (String dwdm : dwdmList) {
						 if (dwdm == null || dwdm.equals(""))
							 continue;
						 if (i != 0) {
							 dwdmStr1 += " or ";
							 dwdmStr2 += " or ";
						 }
						 dwdmStr1 += " qcd_hkdjjg_gajgjgdm = '" + dwdm + "'";
						 dwdmStr2 += " hkdjpcs = '" + dwdm + "'";
						 i++;
					 }
					 dwdmStr1 += ") ";
					 dwdmStr2 += ") ";
					 map.put("dwdmStr1",dwdmStr1);
					 map.put("dwdmStr2",dwdmStr2);
				 }

				 map.put("sfbj","0");
				 map.put("isstatuszx","2");
            	Hz2004Service hz2004Service = (Hz2004Service) SpringContainer.getObject("hz2004Service");
            	Page pZqz = hz2004Service.queryZqzXx(map, pageIndex, pageSize);

            	Page pQyz = hz2004Service.queryQyzXx(map, pageIndex, pageSize);
            	json.put("code", "success");
            	json.put("swqc", pZqz.getTotalCount());
            	json.put("swqr", pQyz.getTotalCount());
            	json.put("message", "你有"+(pZqz.getTotalCount()+pQyz.getTotalCount())+"条长三角业务通办任务。请进入“一站式迁移办理”。");
				 System.out.println("swqc:"+pZqz.getTotalCount()+"swqr:"+pQyz.getTotalCount());
//                out.print("你有"+(pZqz.getTotalCount()+pQyz.getTotalCount())+"条长三角业务通办任务。请进入“一站式迁移办理”。");
            	out.print(json);
			 }
			 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
