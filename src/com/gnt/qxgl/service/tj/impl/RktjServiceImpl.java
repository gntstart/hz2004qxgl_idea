package com.gnt.qxgl.service.tj.impl;

//import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.gnt.lgy.base.util.ExceExportUtil;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.hz2004.entity.RPT_HJBDYWXXTJB;
import com.gnt.qxgl.hz2004.entity.XT_XZQHB;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.service.tj.RktjService;

public class RktjServiceImpl extends ServiceImpl implements RktjService {

    String driver=SystemConfig.getJdbcConfig("qxgl.jdbc.driverClass");
    String url=SystemConfig.getJdbcConfig("qxgl.jdbc.url");
    String userName = SystemConfig.getJdbcConfig("qxgl.jdbc.user");
    String passWord = SystemConfig.getJdbcConfig("qxgl.jdbc.password");
    Connection conn=null;
    CallableStatement cs=null;//PreparedStatement,Statement
    ResultSet rs;
    
    public Page queryRktj(BaseUser user, ExtMap<String, Object> params) {
    	
    	getConn();
    	
    	Page page = callProcForResult(user,params);
    	
    	closeConn();
    	
    	return page;
    	
    }
    
	public void exportRktj(BaseUser user, ExtMap<String, Object> params, HttpServletResponse response) {
		
		getConn();
		
		Page page = callProcForResult(user,params);
		
		Exp(page, response);
		
		closeConn();
		
	}
	
	private void Exp(Page page, HttpServletResponse response){
		
		String title = "学生表";  
        String[] rowsName = new String[]{"序号","学生ID","姓名","年龄","电话号码","家庭地址"};  
        List<Object[]>  dataList = new ArrayList<Object[]>();  
//        Object[] objs = null;  
        
        int columnLength = 22;
        if(page != null && page.getList() != null){
        	for (int i = 0; i < page.getList().size(); i++) {
        		RPT_HJBDYWXXTJB tjb = (RPT_HJBDYWXXTJB) page.getList().get(i);
				
        		for (int j = 1; j <= columnLength; j++) {
        			System.out.println(tjb.getValue(tjb, "getA"+j));
				}
        		
			}
        }
        
        ExceExportUtil ex = new ExceExportUtil(title, rowsName, dataList);  
        try {
            ex.export(response);
        } catch (Exception e) {
            e.printStackTrace();
        }  
		
        /*
        //创建一个新的Excel  
        HSSFWorkbook workBook = new HSSFWorkbook();  
        //创建sheet页  
        HSSFSheet sheet = workBook.createSheet();  
        //sheet页名称  
        workBook.setSheetName(0, "人 口 及 其 变 动 情 况 统 计 年 报 表");  
        //创建header页  
        HSSFHeader header = sheet.getHeader();  
        //设置标题居中  
        header.setCenter("人 口 及 其 变 动 情 况 统 计 年 报 表");  
          
        //设置第一行为Header  
        HSSFRow row = sheet.createRow(0);  
        
//        row.
        
        
        HSSFCell cell0 = row.createCell(Short.valueOf("0"));  
        HSSFCell cell1 = row.createCell(Short.valueOf("1"));  
        HSSFCell cell2 = row.createCell(Short.valueOf("2"));  
   
          
        // 设置字符集  
//        cell0.setEncoding(HSSFCell.ENCODING_UTF_16);  
//        cell1.setEncoding(HSSFCell.ENCODING_UTF_16);  
//        cell2.setEncoding(HSSFCell.ENCODING_UTF_16);  
  
          
        cell0.setCellValue("问题标题");  
        cell1.setCellValue("问题描述");  
        cell2.setCellValue("反馈时间");  
      
          
        if(page != null && page.getList() != null ) {  
            for(int i = 0; i < page.getList().size(); i++) {  
            	RPT_HJBDYWXXTJB tjbObj = (RPT_HJBDYWXXTJB) page.getList().get(i);  
                row = sheet.createRow(i + 1);
                cell0 = row.createCell(Short.valueOf("0"));  
                cell1 = row.createCell(Short.valueOf("1"));  
                cell2 = row.createCell(Short.valueOf("2"));  
                
                // 设置字符集  
//                cell0.setEncoding(HSSFCell.ENCODING_UTF_16);  
//                cell1.setEncoding(HSSFCell.ENCODING_UTF_16);  
//                cell2.setEncoding(HSSFCell.ENCODING_UTF_16);  
                
                cell0.setCellValue(tjbObj.getA1());  
                cell1.setCellValue(tjbObj.getA1());  
                cell2.setCellValue(tjbObj.getA1());  
                
                sheet.setColumnWidth((short) 0, (short) 4000);  
                sheet.setColumnWidth((short) 1, (short) 4000);  
                sheet.setColumnWidth((short) 2, (short) 4000);  
            }  
        }  
          
        //通过Response把数据以Excel格式保存  
        response.reset();  
        response.setContentType("application/msexcel;charset=UTF-8");  
        try {  
            response.addHeader("Content-Disposition", "attachment;filename=\""  
                    + new String(("57表" + ".xls").getBytes("GBK"),  
                            "ISO8859_1") + "\"");  
            OutputStream out = response.getOutputStream();  
            workBook.write(out);  
            out.flush();  
            out.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  */
	}
	
	public Page callProcForResult(BaseUser user, ExtMap<String, Object> params){
		
		List<RPT_HJBDYWXXTJB> result = new ArrayList<RPT_HJBDYWXXTJB>();
		Map<String,RPT_HJBDYWXXTJB> totalMap = new HashMap<String, RPT_HJBDYWXXTJB>();
		
		Page page = new Page();
		
		String PROCEDURE = params.getString("PROCEDURE");
		String table = params.getString("table");
		
        try {
        	cs = conn.prepareCall("{call RPT."+PROCEDURE+"(?,?,?,?,?)}");
	    	/*
            cs.setString(1, "0");
            cs.setString(2, "20170101");
            cs.setString(3, "20170927");
            */
            
        	String fw = params.getString("fw");
//        	int tjfw = (Integer.parseInt(fw) + 1);
        	String startDate = params.getString("startDate").replaceAll("-", "");
        	String endDate = params.getString("endDate").replaceAll("-", "");
        	
            cs.setString(1, fw);
            cs.setString(2, startDate);
            cs.setString(3, endDate);
            
            /**
           		还需要通过用户选择的地市中文获取地市码
             */
            String dqdm = null;
            String pcsdm = null;
            if("3".equals(fw)){
            	String hql = "from " + XtDwxxb.class.getName() + "" +
            			" where mc = ? ";
            	
            	XtDwxxb pcs = (XtDwxxb) super.getObject(hql,new Object[]{params.getString("dq")});
            	if(pcs != null){
            		dqdm = pcs.getQhdm();
            		pcsdm = pcs.getDm();
            		cs.setString(4, pcs.getDm());
            		System.out.println("**************" + pcs.getDm());
            	}
            }else{
            	if(CommonUtil.isNotEmpty(params.getString("dq"))){
            		if((params.getString("dq").lastIndexOf("局") + 1) == params.getString("dq").length()){
            			/**
            				选择分局、局时等同区县
            			 */
            			String hql = "from " + XtDwxxb.class.getName() + "" +
            					" where mc = ? ";
            			
            			XtDwxxb ju = (XtDwxxb) super.getObject(hql,new Object[]{params.getString("dq")});
            			if(ju != null){
            				dqdm = ju.getQhdm();
            				pcsdm = ju.getDm();
            				cs.setString(4, ju.getQhdm());
            				System.out.println("*****************" + ju.getQhdm());
            			}
            		}else{
            			String hql = "from " + XT_XZQHB.class.getName() + "" +
            					" where mc = ? ";
            			
            			XT_XZQHB xzqh = (XT_XZQHB) super.getObject(hql,new Object[]{params.getString("dq")});
            			if(xzqh != null){
            				dqdm = xzqh.getDm();
            				cs.setString(4, dqdm);
            			}
            		}
            	}
            }
            /**
            Map<String ,Object> parmMap = new HashMap<String, Object>();
            parmMap.put("endDate", endDate);
            parmMap.put("queryDm", "34");
            Long s2t = (Long) getTotal(parmMap, "a2Total");
            System.out.println(s2t);
            */
            
			String[] srr = new String[]{table,fw,startDate,endDate,dqdm,"0",pcsdm,""};
			
            cs.registerOutParameter(5, oracle.jdbc.OracleTypes.CURSOR);
            
            cs.execute();
            
            ResultSet rs = (ResultSet)cs.getObject(5);
            
            int count = 0;
            if(rs != null){
            	ResultSetMetaData rsm = rs.getMetaData();
            	count = rsm.getColumnCount();
            	
            	page.setTotalCount(count);
            }
            
            while(rs != null && rs.next()){
//            	List<Object> list = new ArrayList<Object>();
            	RPT_HJBDYWXXTJB tjbObj = new RPT_HJBDYWXXTJB();
            	
            	for(int index=1;index<=count;index++){
            		Object obj = rs.getObject(index);
            		
            		if(obj instanceof String){
            			
//            			System.out.println("A" + index + ": " + rs.getString(index));
//            			list.add(rs.getString(index));
            			
            			if(index == 1){
            				tjbObj = tjbObj.setValue(tjbObj, "setCode", rs.getString("code").trim());
            			}else{
            				
            				/**
            					2017.10.26
            					注释	刁杰
            					统计表并不是由一张表的数据统计出来的，所以不同的列查询表（对象）不同
            					不能跳转到单一的页面
            				 */
            				String url = "'tj/";;
            				if("57".equals(table)){
            					if(index == 2){
            						url += "rktjDwMx.jsp?";
            					}else if(index == 3){
            						url += "rktjNmzhMx.jsp?";
            					}else if(index >= 4 && index <= 12){
            						url += "rktjNmzrkMx.jsp?";
            					}else if(index >= 13 && index <= 15){
            						url += "rktjBndbdCsMx.jsp?";
            					}else if(index >= 16 && index <= 18){
            						url += "rktjBndbdSwMx.jsp?";
            					}else if(index >= 19 && index <= 20){
            						url += "rktjBndbdQrMx.jsp?";
            					}else if(index >= 21 && index <= 22){
            						url += "rktjBndbdQcMx.jsp?";
            					}
            				}else if("58".equals(table)){
            					if(index == 2){
            						url += "rktjDwMx.jsp?";
            					}else if(index == 3){
            						url += "rktjNmzrkMx.jsp?";
            					}else if(index >= 4 && index <= 30){
            						url += "rktjZjjsqkMx.jsp?";
            					}
            				}
            				
            				String paramStr = "dsdm=" + rs.getString("code").trim() + "&table=" + table + "&column=A" + (index - 1) + 
            						"&fw=" + fw + "&startDate=" + startDate + "&endDate=" + endDate + "&dqdm=" + dqdm + "&tjfw=" + "&pcsdm=" + pcsdm + "";
            				paramStr += "'";
            				
            				/**
            					暂时不开发填报单位、户总数的明细
            				 */
            				if(index >=2 && index <= 3){
            					tjbObj = tjbObj.setValue(tjbObj, "setA" + (index - 1) , ""+rs.getString("a" + (index - 1))+"");
            				}else{
            					tjbObj = tjbObj.setValue(tjbObj, "setA" + (index - 1) , "<a href=\"javascript:void(0);\" onClick=\"javascript:gotoMx("+url+paramStr+");\" >"+rs.getString("a" + (index - 1))+"<a />");
            				}
            			}
            			
            		}else if(obj instanceof BigDecimal){
            			
//            			System.out.println("A" + index + ": " + rs.getInt(index));
//            			list.add(rs.getInt(index));
//            			list.add(rs.getInt("a"+index));
            			
            			String url = "'tj/";
        				if("57".equals(table)){
        					if(index == 2){
        						url += "rktjDwMx.jsp?";
        					}else if(index == 3){
        						url += "rktjNmzhMx.jsp?";
        					}else if(index >= 4 && index <= 12){
        						url += "rktjNmzrkMx.jsp?";
        					}else if(index >= 13 && index <= 15){
        						url += "rktjBndbdCsMx.jsp?";
        					}else if(index >= 16 && index <= 18){
        						url += "rktjBndbdSwMx.jsp?";
        					}else if(index >= 19 && index <= 20){
        						url += "rktjBndbdQrMx.jsp?";
        					}else if(index >= 21 && index <= 22){
        						url += "rktjBndbdQcMx.jsp?";
        					}
        				}else if("58".equals(table)){
        					if(index == 2){
        						url += "rktjDwMx.jsp?";
        					}else if(index == 3){
        						url += "rktjNmzrkMx.jsp?";
        					}else if(index >= 4 && index <= 30){
        						url += "rktjZjjsqkMx.jsp?";
        					}
        				}
        				
            			int i = rs.getInt("a"+(index - 1));
            			if(i > 0){
            				
            				String paramStr = "dsdm=" + rs.getString("code").trim() + "&table=" + table + "&column=A" + (index - 1) + 
            						"&fw=" + fw + "&startDate=" + startDate + "&endDate=" + endDate + "&dqdm=" + dqdm + "&tjfw=" + "&pcsdm=" + pcsdm + "";
            						paramStr += "'";
            				if(index >=2 && index <= 3){
            					tjbObj = tjbObj.setValue(tjbObj, "setA" + (index - 1) + "Str", ""+rs.getInt("a"+(index - 1))+"");
            				}else{
            					tjbObj = tjbObj.setValue(tjbObj, "setA" + (index - 1) + "Str", "<a href = \"javascript:void(0);\" onClick=\"javascript:gotoMx("+url+paramStr+");\" >"+rs.getInt("a"+(index - 1))+"<a />");
            				}
            			}else{
            				/**
            					没有值则不显示超链接
            				 */
            				tjbObj = tjbObj.setValue(tjbObj, "setA" + (index - 1) + "Str", ""+rs.getInt("a"+(index - 1))+"");
            			}
            			tjbObj = tjbObj.setValue(tjbObj, "setA" + (index - 1) , rs.getInt("a"+(index - 1)));
            			
            		}
            		
            	}
            	
//            	tjbObj = tjbObj.getValue(list);
            	
		        
            	if(tjbObj != null && CommonUtil.isNotEmpty(tjbObj.getCode())){
            		String code = tjbObj.getCode().trim();
            		
            		int colLength = params.getInteger("colLength");
            		/**
            			省
            			可是合计中不就是全省的么？
            			
            			2017.10.24
            			经过思考
            			合计中只是某一个地市、区县、派出所的总合计
            			需要省合计需另外进行一次统计
            			
            			2018.06.19
            			新增	刁杰
            			线上要求在原先地市统计的基础上增加市辖区统计
            			
            		 */

                	String qhHql = "from " + XT_XZQHB.class.getName() + "" +
    		        				" where dm = ? " +
    		        				" and qybz = ? ";
                	
            		if("0".equals(fw)){
            			String stCode = code.substring(0, 4) + "00";
            			
            			RPT_HJBDYWXXTJB tjbStObj = null;
            			
            			if(!totalMap.containsKey(stCode)){
            				XT_XZQHB dsQh = (XT_XZQHB) super.getObject(qhHql,new Object[]{stCode,"1"});
            				if(dsQh != null){
            					tjbStObj = new RPT_HJBDYWXXTJB();
            					tjbStObj.setCode(stCode);
            					/*
            					String paramStr = "'dsdm=" + stCode + "&table=" + table + "&column=A1" + 
            							"&fw=" + fw + "&startDate=" + startDate + "&endDate=" + endDate + "&dqdm=" + dqdm + "&pcsdm=" + pcsdm + "";
            							paramStr += "'";
            					tjbStObj.setA1("<a href = \"javascript:void(0);\" onClick=\"javascript:gotoMx("+paramStr+");\" >"+dsQh.getMc()+"<a />");
            					*/
            					tjbStObj.setCode(stCode);
            					tjbStObj.setA1(dsQh.getMc());
            					
            					srr[5] = "1";
            					tjbStObj.plusValue(tjbStObj, tjbObj, colLength,srr );
            					
            					totalMap.put(stCode, tjbStObj);
            					
            					/**
            						第一次创建对象的同时添加到结果集中
            					 */
            					result.add(tjbStObj);
            				}
            			}else{
            				
            				tjbStObj = totalMap.get(stCode);
            				
            				srr[5] = "1";
            				tjbStObj.plusValue(tjbStObj, tjbObj, colLength, srr);
            				
            				totalMap.put(stCode, tjbStObj);
            				
            			}
            			
            			
            			int qxInt = Integer.parseInt(code.substring(code.length() - 2, code.length()));
            			if(qxInt > 20){
            				
            			}else{
            				
            				String dsCode = code.substring(0, 4) + "00";
            				
            				RPT_HJBDYWXXTJB tjbDsObj = null;
            				
            				if(!totalMap.containsKey(dsCode+"sxq")){
            					XT_XZQHB dsQh = (XT_XZQHB) super.getObject(qhHql,new Object[]{dsCode,"1"});
            					if(dsQh != null){
            						tjbDsObj = new RPT_HJBDYWXXTJB();
            						tjbDsObj.setCode(dsCode);
            						/*
            						String paramStr = "'dsdm=" + dsCode + "&table=" + table + "&column=A1" + 
            								"&fw=" + fw + "&startDate=" + startDate + "&endDate=" + endDate + "&dqdm=" + "&pcsdm=" + pcsdm + "";
            							paramStr += "'";
            						tjbDsObj.setCode(dsCode);
            						tjbDsObj.setA1("<a href = \"javascript:void(0);\" onClick=\"javascript:gotoMx("+paramStr+");\" >"+dsQh.getMc().substring(dsQh.getMc().indexOf("省") + 1)+"<a />");
            						*/
            						
            						/**
            							2018.06.07
            							修改	刁杰
            							线上要求地市合计加入'市辖区'
            						 */
            						tjbDsObj.setA1(""+dsQh.getMc().substring(dsQh.getMc().indexOf("省") + 1)+"市辖区");
            						
            						srr[5] = "2";
            						srr[7] = "1";
            						tjbDsObj.plusValue(tjbDsObj, tjbObj, colLength, srr);
            						
            						totalMap.put(dsCode+"sxq", tjbDsObj);
            						
            						/**
            							第一次创建对象的同时添加到结果集中
            						 */
            						result.add(tjbDsObj);
            					}
            				}else{
            					
            					tjbDsObj = totalMap.get(dsCode+"sxq");
            					
            					srr[5] = "2";
            					srr[7] = "1";
            					tjbDsObj.plusValue(tjbDsObj, tjbObj, colLength, srr);
            					
            					totalMap.put(dsCode+"sxq", tjbDsObj);
            					
            				}
            				
            			}
            		
            			
            			
            			
            		}
            		
                	/**
                		有了code值之后就会比较容易按照线上的要求再次统计合计
                		尾号大于20 的 都不是市辖区
                		
                	 */
            		if("1".equals(fw)){
            			int qxInt = Integer.parseInt(code.substring(code.length() - 2, code.length()));
            			if(qxInt > 20){
            				
            			}else{
            				
            				/**
            					地市
            				 */
            				String dsCode = code.substring(0, 4) + "00";
            				
            				RPT_HJBDYWXXTJB tjbDsObj = null;
            				
            				if(!totalMap.containsKey(dsCode)){
            					XT_XZQHB dsQh = (XT_XZQHB) super.getObject(qhHql,new Object[]{dsCode,"1"});
            					if(dsQh != null){
            						tjbDsObj = new RPT_HJBDYWXXTJB();
            						tjbDsObj.setCode(dsCode);
            						/*
            						String paramStr = "'dsdm=" + dsCode + "&table=" + table + "&column=A1" + 
            								"&fw=" + fw + "&startDate=" + startDate + "&endDate=" + endDate + "&dqdm=" + "&pcsdm=" + pcsdm + "";
            							paramStr += "'";
            						tjbDsObj.setCode(dsCode);
            						*/
            						
//            						tjbDsObj.setA1("<a href = \"javascript:void(0);\" onClick=\"javascript:gotoMx("+paramStr+");\" >"+dsQh.getMc().substring(dsQh.getMc().indexOf("省") + 1)+"<a />");
            						/**
            							2018.06.07
            							修改	刁杰
            							线上要求地市合计加入'市辖区'
            						 */
            						tjbDsObj.setA1(""+dsQh.getMc().substring(dsQh.getMc().indexOf("省") + 1)+"市辖区");
            						
            						srr[5] = "2";
            						srr[7] = "1";
            						tjbDsObj.plusValue(tjbDsObj, tjbObj, colLength, srr);
            						
            						totalMap.put(dsCode, tjbDsObj);
            						
            						/**
            							第一次创建对象的同时添加到结果集中
            						 */
            						result.add(tjbDsObj);
            					}
            				}else{
            					
            					tjbDsObj = totalMap.get(dsCode);
            					
            					srr[5] = "2";
            					srr[7] = "1";
            					tjbDsObj.plusValue(tjbDsObj, tjbObj, colLength, srr);
            					
            					totalMap.put(dsCode, tjbDsObj);
            					
            				}
            				
            			}
            		}

        			/**
        				区县
        				
        				2017.10.25
        				实际上应该是派出所范围
        				
        			 */
            		/*if("2".equals(fw)){
            			RPT_HJBDYWXXTJB tjbQxObj = null;
            			
            			*//**
	        				2017.10.20
	        				修改	刁杰
	        				开发过程中发现
	        				按区县统计时不统计区县，仅统计区县下的派出所
	        				排查原因为派出所的地市代码与区县代码不符，需要处理
            			 *//*
            			if(code.length() > 6){
            				code = code.substring(0,6);
            			}
            			if(!totalMap.containsKey(code)){
            				XT_XZQHB dsQh = (XT_XZQHB) super.getObject(qhHql,new Object[]{code,"1"});
            				if(dsQh != null){
            					tjbQxObj = new RPT_HJBDYWXXTJB();
            					tjbQxObj.setCode(code);
            					*//**
	        						原本打算将省、市截取
	        						实际不是所有区县都使用xx省xx市xx山区
	        						也有xx省xx县导致名字不能统一
	        						现在仍然将省截取
            					 *//*
            					String paramStr = "'dsdm=" + code + "&table=" + table + "&column=A1" + 
            							"&fw=" + fw + "&startDate=" + startDate + "&endDate=" + endDate + "&dqdm=" + dqdm + "&pcsdm=" + pcsdm + "";
            							paramStr += "'";
            					
            					tjbQxObj.setCode(code);
//            					tjbQxObj.setA1("<a href = \"javascript:void(0);\" onClick=\"javascript:gotoMx("+paramStr+");\" >"+dsQh.getMc().substring(dsQh.getMc().indexOf("省") + 1)+"<a />");
            					tjbQxObj.setA1(""+dsQh.getMc().substring(dsQh.getMc().indexOf("省") + 1)+"");
            					
            					srr[5] = "3";
            					tjbQxObj.plusValue(tjbQxObj, tjbObj, colLength, srr);
            					
            					totalMap.put(code, tjbQxObj);
            					
            					*//**
        							第一次创建对象的同时添加到结果集中
            					 *//*
            					result.add(tjbQxObj);
            				}
            			}else{
            				
            				tjbQxObj = totalMap.get(code);
            				
            				srr[5] = "3";
            				tjbQxObj.plusValue(tjbQxObj, tjbObj, colLength, srr);
            				
            				totalMap.put(code, tjbQxObj);
            				
            			}
            		}
            		*/
            	}
            	
            	result.add(tjbObj);
            	
            }
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        page.setList(result);
        return page;
        
    }
	
	@SuppressWarnings("unused")
	private Object getTotal(Map<String, Object> params,String sqlKey){
		
		SqlParse sqlParse = new SqlParse(Config.getSql("/conf/segment/tj/default",sqlKey));
		sqlParse.bind(params);
		SqlParam sqlParam = sqlParse.parse();
		
		return super.getObject(sqlParam.getSql(), sqlParam.getParams().toArray());
	}
	
    public void getConn(){
    	
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url, userName, passWord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void closeConn(){
        try {
            if (cs!=null) cs.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public Page queryRktjMx(BaseUser user, ExtMap<String, Object> params) {
		
		int pageIndex = params.getInteger(ExtUtils.pageIndex);
		int pageSize = params.getInteger(ExtUtils.pageSize);
		
		String col = params.getString("column");
		String tab = params.getString("table");
		
		String s = col.toString() + tab;
		
		SqlParse sqlParse = new SqlParse(Config.getSql("/conf/segment/tj/default",s ));
		sqlParse.bind(params);
		SqlParam sqlParam = sqlParse.parse();
		SqlParse whereParse = new SqlParse(Config.getSql("/conf/segment/tj/default","whereSql"));
		whereParse.bind(params);
		SqlParam whereParam = whereParse.parse();
		
		List<Object> param = sqlParam.getParams();
		param.addAll(whereParam.getParams());
		
		
		Page page = new Page(); 
		
		page = super.getPageRecords(sqlParam.getSql()+whereParam.getSql(), param,pageIndex ,pageSize );
		
		/**
			
		if("58".equals(tab)){
			if("A18".equals(col) || "A21".equals(col)){
				
			}
		}
		SqlParse sqlParseB = new SqlParse(Config.getSql("/conf/segment/tj/default","B57" ));
		sqlParseB.bind(params);
		SqlParam sqlParamB = sqlParseB.parse();
		List<Object> paramB = sqlParamB.getParams();
		paramB.addAll(whereParam.getParams());
		Page pageB = super.getPageRecords(sqlParamB.getSql()+whereParam.getSql()+" group by c.ssxq ", paramB,pageIndex ,pageSize );
		 */
		
		
		
		return page;
		
	}
	
}
