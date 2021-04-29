package com.gnt.qxgl.service.impl;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.hz2004.entity.QG_RKPC;
import com.gnt.qxgl.service.CsjHkKsWsQyService;
import com.hzjc.hz2004.vo.VoCsjKsWsQyxx;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <功能概述>
 * 安徽长三角户口跨省网上迁移情况实现业务逻辑类
 *
 * @author: zjm
 * @className: CsjHkKsWsQyServiceImpl
 * @package: com.gnt.qxgl.service.impl
 * @description: 介绍
 * @date: 20210308
 */
public class CsjHkKsWsQyServiceImpl extends ServiceImpl implements CsjHkKsWsQyService {

    public QG_RKPC getQgRkpc(String rkpcId) {
        return (QG_RKPC) super.getObject("from QG_RKPC where rkpcId='" + rkpcId + "' ", null);
    }

    @Override
    public Page queryCsjhkkswsxx(Map<String, Object> map, int pageIndex, int pageSize) {
        String gsdw = (String) map.get("gsdwmc");
        String begintime = (String) map.get("begintime");
        String endtime = (String) map.get("endtime");
        String begintimeSql = "";
        String endSql = "";
        if(StringUtils.isNotEmpty(begintime)){
            begintimeSql = " and slsj>='"+begintime+"000000' ";
        }
        if(StringUtils.isNotEmpty(endtime)){
            endSql = " and slsj<='"+endtime+"235959' ";
        }
        StringBuffer sqlBf = new StringBuffer();
        //组装属性
        sqlBf.append(" select s.ds,s.dsmc,nvl(t1.sl,0) qyzybyb,nvl(t2.sl,0) qyzybwb,nvl(t3.sl,0) qyzwb,nvl(t4.sl,0) zqzyb,nvl(t5.sl,0) zqzwb," +
                "(nvl(t1.sl,0)+nvl(t2.sl,0)+nvl(t3.sl,0)+nvl(t4.sl,0)+nvl(t5.sl,0)) heji from  ");
        String ssdwjgdm = "";
        if (StringUtils.isEmpty(gsdw)) {
            BaseUser baseUser = BaseContext.getBaseUser();
            String ssdw = baseUser.getUser().getSsdwjgdm();
            ssdwjgdm = ssdw.substring(0, 9);
        }else{
            ssdwjgdm = gsdw.substring(0, 9);
        }
//        ssdwjgdm = "340000000";//模拟省厅用户
//        ssdwjgdm = "340700000";//模拟市局用户
//        ssdwjgdm = "340702000";//模拟分局用户
//        ssdwjgdm = "340702001";//模拟派出所用户
        //判断是不是省厅用户查询
        if ("340000000".equals(ssdwjgdm)) {
            //链接各数据源
            sqlBf.append(" sjy s")
                    .append(",(select substr(qcd_HKDJJG_GAJGJGDM, 1, 4) ds, count(1) sl from ZJYW_ZQZXX where isstatus = '1' and sfbj = '1'"+begintimeSql+endSql+" group by sfbj, isstatus, substr(qcd_HKDJJG_GAJGJGDM, 1, 4)) t1 ")
                    .append(",(select substr(qcd_HKDJJG_GAJGJGDM, 1, 4) ds, count(1) sl from ZJYW_ZQZXX where isstatus = '0' and sfbj = '1'"+begintimeSql+endSql+" group by sfbj, isstatus, substr(qcd_HKDJJG_GAJGJGDM, 1, 4)) t2 ")
                    .append(",(select substr(qcd_HKDJJG_GAJGJGDM, 1, 4) ds, count(1) sl from ZJYW_ZQZXX where isstatus = '0' and sfbj = '0'"+begintimeSql+endSql+" group by sfbj, isstatus, substr(qcd_HKDJJG_GAJGJGDM, 1, 4)) t3 ")
                    .append(",(select substr(HKDJPCS, 1, 4) ds, count(1) sl from ZJYW_QYZXX where sfbj = '1' "+begintimeSql+endSql+"group by sfbj, isstatus,substr(HKDJPCS, 1, 4)) t4 ")
                    .append(",(select substr(HKDJPCS, 1, 4) ds, count(1) sl from ZJYW_QYZXX where sfbj = '0' "+begintimeSql+endSql+"group by sfbj, isstatus,substr(HKDJPCS, 1, 4)) t5 ")
                    //数据源关联
                    .append(" where s.ds = t1.ds(+) and s.ds = t2.ds(+) and s.ds = t3.ds(+) and s.ds = t4.ds(+) and s.ds = t5.ds(+) and s.sjylx = 'hz2004' ")
                    .append(" order by s.ds ");
        }else if(ssdwjgdm.endsWith("00000")) {//五个0为市局用户
            //链接各数据源
            sqlBf.append(" （select dm ds,mc dsmc,qhdm from xt_dwxxb where qhdm like '"+ssdwjgdm.substring(0,4)+"%' and dwjb ='1'） s")
                    .append(",(select substr(qcd_HKDJJG_GAJGJGDM, 1, 6) ds, count(1) sl from ZJYW_ZQZXX where isstatus = '1' and sfbj = '1' "+begintimeSql+endSql+"and qcd_ssxqdm like '"+ssdwjgdm.substring(0,4)+"%' group by sfbj, isstatus, substr(qcd_HKDJJG_GAJGJGDM, 1, 6)) t1 ")
                    .append(",(select substr(qcd_HKDJJG_GAJGJGDM, 1, 6) ds, count(1) sl from ZJYW_ZQZXX where isstatus = '0' and sfbj = '1' "+begintimeSql+endSql+"and qcd_ssxqdm like '"+ssdwjgdm.substring(0,4)+"%' group by sfbj, isstatus, substr(qcd_HKDJJG_GAJGJGDM, 1, 6)) t2 ")
                    .append(",(select substr(qcd_HKDJJG_GAJGJGDM, 1, 6) ds, count(1) sl from ZJYW_ZQZXX where isstatus = '0' and sfbj = '0' "+begintimeSql+endSql+"and qcd_ssxqdm like '"+ssdwjgdm.substring(0,4)+"%' group by sfbj, isstatus, substr(qcd_HKDJJG_GAJGJGDM, 1, 6)) t3 ")
                    .append(",(select substr(HKDJPCS, 1, 6) ds, count(1) sl from ZJYW_QYZXX where sfbj = '1' "+begintimeSql+endSql+"and HKDJPCS like '"+ssdwjgdm.substring(0,4)+"%' group by sfbj, isstatus,substr(HKDJPCS, 1, 6)) t4 ")
                    .append(",(select substr(HKDJPCS, 1, 6) ds, count(1) sl from ZJYW_QYZXX where sfbj = '0' "+begintimeSql+endSql+"and HKDJPCS like '"+ssdwjgdm.substring(0,4)+"%' group by sfbj, isstatus,substr(HKDJPCS, 1, 6)) t5 ")
                    //数据源关联
                    .append(" where s.qhdm = t1.ds(+) and s.qhdm = t2.ds(+) and s.qhdm = t3.ds(+) and s.qhdm = t4.ds(+) and s.qhdm = t5.ds(+) ")
                    .append(" order by s.ds ");
        }else if(ssdwjgdm.endsWith("000")) {//三个0为分局用户
            //链接各数据源
            sqlBf.append(" （select dm ds,mc dsmc from xt_dwxxb where qhdm = '"+ssdwjgdm.substring(0,6)+"' and dwjb ='0'） s")
                    .append(",(select qcd_HKDJJG_GAJGJGDM ds, count(1) sl from ZJYW_ZQZXX where isstatus = '1' and sfbj = '1' "+begintimeSql+endSql+"and qcd_ssxqdm like '"+ssdwjgdm.substring(0,6)+"%' group by sfbj, isstatus, qcd_HKDJJG_GAJGJGDM) t1 ")
                    .append(",(select qcd_HKDJJG_GAJGJGDM ds, count(1) sl from ZJYW_ZQZXX where isstatus = '0' and sfbj = '1' "+begintimeSql+endSql+"and qcd_ssxqdm like '"+ssdwjgdm.substring(0,6)+"%' group by sfbj, isstatus, qcd_HKDJJG_GAJGJGDM) t2 ")
                    .append(",(select qcd_HKDJJG_GAJGJGDM ds, count(1) sl from ZJYW_ZQZXX where isstatus = '0' and sfbj = '0' "+begintimeSql+endSql+"and qcd_ssxqdm like '"+ssdwjgdm.substring(0,6)+"%' group by sfbj, isstatus, qcd_HKDJJG_GAJGJGDM) t3 ")
                    .append(",(select HKDJPCS ds, count(1) sl from ZJYW_QYZXX where sfbj = '1' "+begintimeSql+endSql+"and HKDJPCS like '"+ssdwjgdm.substring(0,6)+"%' group by sfbj, isstatus,HKDJPCS) t4 ")
                    .append(",(select HKDJPCS ds, count(1) sl from ZJYW_QYZXX where sfbj = '0' "+begintimeSql+endSql+"and HKDJPCS like '"+ssdwjgdm.substring(0,6)+"%' group by sfbj, isstatus,HKDJPCS) t5 ")
                    //数据源关联
                    .append(" where s.ds = t1.ds(+) and s.ds = t2.ds(+) and s.ds = t3.ds(+) and s.ds = t4.ds(+) and s.ds = t5.ds(+) ")
                    .append(" order by s.ds ");
        }else {//派出所用户
            //链接各数据源
            sqlBf.append(" （select dm ds,mc dsmc from xt_dwxxb where dm = '"+ssdwjgdm+"' and dwjb ='0'） s")
                    .append(",(select qcd_HKDJJG_GAJGJGDM ds, count(1) sl from ZJYW_ZQZXX where isstatus = '1' and sfbj = '1' "+begintimeSql+endSql+"and qcd_HKDJJG_GAJGJGDM = '"+ssdwjgdm+"' group by sfbj, isstatus, qcd_HKDJJG_GAJGJGDM) t1 ")
                    .append(",(select qcd_HKDJJG_GAJGJGDM ds, count(1) sl from ZJYW_ZQZXX where isstatus = '0' and sfbj = '1' "+begintimeSql+endSql+"and qcd_HKDJJG_GAJGJGDM = '"+ssdwjgdm+"' group by sfbj, isstatus, qcd_HKDJJG_GAJGJGDM) t2 ")
                    .append(",(select qcd_HKDJJG_GAJGJGDM ds, count(1) sl from ZJYW_ZQZXX where isstatus = '0' and sfbj = '0' "+begintimeSql+endSql+"and qcd_HKDJJG_GAJGJGDM = '"+ssdwjgdm+"' group by sfbj, isstatus, qcd_HKDJJG_GAJGJGDM) t3 ")
                    .append(",(select HKDJPCS ds, count(1) sl from ZJYW_QYZXX where sfbj = '1' "+begintimeSql+endSql+"and HKDJPCS = '"+ssdwjgdm+"' group by sfbj, isstatus,HKDJPCS) t4 ")
                    .append(",(select HKDJPCS ds, count(1) sl from ZJYW_QYZXX where sfbj = '0' "+begintimeSql+endSql+"and HKDJPCS = '"+ssdwjgdm+"' group by sfbj, isstatus,HKDJPCS) t5 ")
                    //数据源关联
                    .append(" where s.ds = t1.ds(+) and s.ds = t2.ds(+) and s.ds = t3.ds(+) and s.ds = t4.ds(+) and s.ds = t5.ds(+) ")
                    .append(" order by s.ds ");
        }
        Page page = new Page();
        List list = new ArrayList<>();
        List llist  = (List<VoCsjKsWsQyxx>)super.getObjectListBySql(sqlBf.toString(),null,null,null,null,null);
        for (Object obj:
             llist) {
            Object[] objs = (Object[])obj;
            VoCsjKsWsQyxx vocsjkswsqyxx = new VoCsjKsWsQyxx();
            vocsjkswsqyxx.setDs(objs[0].toString());
            vocsjkswsqyxx.setDsmc(objs[1].toString());
            vocsjkswsqyxx.setQyzybyb(objs[2].toString());
            vocsjkswsqyxx.setQyzybwb(objs[3].toString());
            vocsjkswsqyxx.setQyzwb(objs[4].toString());
            vocsjkswsqyxx.setZqzyb(objs[5].toString());
            vocsjkswsqyxx.setZqzwb(objs[6].toString());
            vocsjkswsqyxx.setHeji(objs[7].toString());
            list.add(vocsjkswsqyxx);
        }
		page.setList(list);//取分页所需的数据
		page.setTotalCount(list.size());
        return page;
    }

    @Override
    public void ExportqueryCsjhkkswsxx(Map<String, Object> map, HttpServletRequest req, HttpServletResponse rep) {
    	Page p = queryCsjhkkswsxx(map,Integer.parseInt((String) map.get(ExtUtils.pageIndex)),Integer.parseInt((String) map.get(ExtUtils.pageSize)));
        System.out.printf(p.getList().size()+"shumu");
        String type = (String) map.get("method");
        String FileDate = DateHelper.formateDate("yyyyMMdd");
        String filename = type+FileDate+".xls.zip";
        String zipname = filename.substring(0,filename.length()-4);

        try{
            rep.setHeader("Content-Disposition", "attachment;filename=\"" +  new String(filename.getBytes("gb2312"), "ISO8859-1" ) + "\"");

            org.apache.tools.zip.ZipOutputStream out = new org.apache.tools.zip.ZipOutputStream(rep.getOutputStream());
            org.apache.tools.zip.ZipEntry zipEntry = new org.apache.tools.zip.ZipEntry(zipname);
            out.putNextEntry(zipEntry);
            out.setEncoding("GBK");
            out.setComment("人口数据导出，金铖科技有限公司。");

            String[] shuxing = new String[]{"dsmc","qyzybyb","qyzybwb","qyzwb","zqzyb","zqzwb","heji"};
            String[] header = new String[]{"单位","迁移证已办已报","迁移证已办未报","迁移证未办","准迁证已办","准迁证未办","合计"};

            jxl.WorkbookSettings a = new jxl.WorkbookSettings();
            InputStream is = null;
            is = FileUtils.class.getResourceAsStream("/conf/daochu.xls");
//            is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/conf/daochu.xls");
//            is = CsjHkKsWsQyServiceImpl.class.getClassLoader().getResourceAsStream("Singnet.properties");
//            new FileInputStream("/conf/daochu.xls")
            //ByteArrayOutputStream buffout = new ByteArrayOutputStream();
            Workbook rwb = Workbook.getWorkbook(is);
            WritableWorkbook wwb = Workbook.createWorkbook(out, rwb, a);
            WritableSheet ws = wwb.getSheet(0);
            //4：设置titles
            //5:单元格
            Label label=null;

            //6:给第一行设置列名
            for(int i=0;i<header.length;i++){
                //x,y,第一行的列名
                label=new Label(i,0,header[i]);
                //7：添加单元格
                ws.addCell(label);
            }
            int i =0;
            List l = p.getList();
            for(int j = 0;j<l.size();j++){
                Map<String, String> map1 = new HashMap<String,String>();
                Object u = l.get(j);
                Class c1= u.getClass();
                Field[] fields1  = c1.getDeclaredFields();
                for(Field f : fields1) {
                    // 获取原来的访问控制权限
                    boolean accessFlag = f.isAccessible();
                    // 修改访问控制权限
                    f.setAccessible(true);
                    map1.put(f.getName(),f.get(u)!=null?f.get(u).toString():"");
                }
                for(int k = 0;k<shuxing.length;k++) {
                    //无需字典翻译，直接从对象中取值
                    jxl.write.Label labelC = new Label(k,(j+1),map1.get(shuxing[k]));
                    ws.addCell(labelC);

                }
                //i++;
            }

            wwb.write();
            wwb.close();
            out.flush();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
