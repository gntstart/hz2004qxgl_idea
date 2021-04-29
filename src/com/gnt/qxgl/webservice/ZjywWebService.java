package com.gnt.qxgl.webservice;


import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.HibernateUtil;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.hz2004.entity.HJXX_CZRKJBXXB;
import com.gnt.qxgl.hz2004.entity.XX_CZRK;
import com.gnt.qxgl.hz2004.entity.zjyw.*;
import com.gnt.qxgl.service.Hz2004Service;
import com.gnt.qxgl.service.yw.KdqqyService;
import com.gnt.qxgl.webservice.bean.ZjywQyzQyryxxBean;
import com.gnt.qxgl.webservice.bean.ZjywReturnBean;
import com.gnt.qxgl.webservice.bean.ZjywZqzQyryxxBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.Session;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ZjywWebService<nwbService> {


    static private void saveLog(LgApiLog log) {
        Hz2004Service apiService = (Hz2004Service) SpringContainer.getObject("hz2004Service");
        apiService.saveLog2(log);
    }

    /**
     * 准迁证信息接收
     * 准迁证迁移人信息接收
     *
     * @param pcsbm 派出所编码
     * @param sbh   设备号
     * @param md5   旅馆WEBSERVICE-API对应的口令MD5
     * @param type  入住记录类型：1 内宾，2 外宾
     * @param json  内/外宾入组记录的JSON编码，编码格式见文档说明。
     * @return 返回处理结果的JSON，格式如下： {
     * "success": "true|false之一，表示成功或者失败",
     * "message":"错误消息",
     * "postid":"json数据包含的用户第三方ID值，用于返回对应",
     * "lkbm":"如果成功，那么返回入住流水号，必须回填此流水号，退房或者修改入住信息必须使用此凭证"
     * }
     */
    public String postZqzxxRecrod(String pcsbm, String sbh, String md5, String type, String json) {
        LgApiLog log = new LgApiLog();
        log.setApiname("postZqzxxRecrod");
        log.setBz("type=" + type);
        log.setLgbm(pcsbm);
        log.setLogsj(new Date());

        ZjywReturnBean re = new ZjywReturnBean();
        try {
            WebServiceUtil.checkUser(pcsbm, sbh, md5);

            String ip = WebServiceUtil.getIpaddress();
            log.setIp(ip);
            Hz2004Service hz2004Service = (Hz2004Service) SpringContainer.getObject("hz2004Service");
            //NwbService nwbService = (NwbService)SpringContainer.getObject("nwbservice");

            ZjywZqzQyryxxBean obj = WebServiceUtil.getJsonData(ZjywZqzQyryxxBean.class, json);

            re = postZqzxxRecrods(ip, pcsbm, type, hz2004Service, obj);
        } catch (Exception e) {
            re.setMessage(e.getMessage());
            re.setSuccess(false);
        }

        log.setHs(new Date().getTime() - log.getLogsj().getTime());
        log.setSfcg(re.isSuccess() ? "1" : "0");
        try {
            saveLog(log);
        } catch (Exception e) {
            ;
        }

        return WebServiceUtil.toJson(re);
    }

    /**
     * 准迁证信息接收
     * 准迁证迁移人信息接收
     * 保存或者修改的通用方法
     *
     * @param ip
     * @param pcsbm
     * @param type
     * @param nwbService
     * @param bean
     * @return
     */
    private ZjywReturnBean postZqzxxRecrods(String ip, String pcsbm, String type, Hz2004Service nwbService, ZjywZqzQyryxxBean bean) {


        String ywlsh = null;
        ZjywReturnBean re = new ZjywReturnBean();
        String postid = null;
        try {

            postid = bean.getYwlsh();

            ywlsh = bean.getPostid();

            //下面模拟nwbaction里面的流程，保持nwbservice的业务流程不变
            boolean c_u = true;

            //如果第三方没有带业务流水号，那么默认为新增
            if (CommonUtil.isNotEmpty(ywlsh)) {
                c_u = false;
            } else {
                //判断数据库是否已经记录过此记录KEY
                ApiYs ys = nwbService.getApiYsByPostid(pcsbm, type, postid);
                if (ys != null) {
                    //如果有，那么修改原记录(用户不带，那么智能判断)
                    c_u = false;
                    bean.setYwlsh(ys.getLkbm());
                }
            }

            //将nbbean转换为lknb对象
            ZjywZqzxx lk = WebServiceUtil.getZqzxx(nwbService, ip, pcsbm, bean);
            KdqqyService kdqqyService = (KdqqyService) SpringContainer.getObject("SpringContainer");
            /*
             * add by zjm
             * 20210218
             * 取hjxx_czrk  czrkpcsmc czrkpcsjgdm赋值给ZjywZqzxx中qcd_hkdjjg_gajgjgdm qcd_hkdjjg_gajgmc
             */
            ExtMap<String, Object> params = new ExtMap<String, Object>();
            params.put("gmsfhm", lk.getSqr_gmsfhm());
            List<XX_CZRK> xx_czrklist = kdqqyService.requestDqbmAndCzrkjbxx(params);//lk.getSqr_gmsfhm()
            if(xx_czrklist.size()==0) {
            	throw new Exception("身份号码为：" + lk.getSqr_gmsfhm() + "人员不存在！");
            }else {
            	XX_CZRK xx_czrk = xx_czrklist.get(0);
            	if (CommonUtil.isNotEmpty(xx_czrk.getCzrkpcsmc())) {
            		lk.setQcd_hkdjjg_gajgmc(xx_czrk.getCzrkpcsmc());
            	}
            	if (CommonUtil.isNotEmpty(xx_czrk.getCzrkpcsjgdm())) {
            		lk.setQcd_hkdjjg_gajgjgdm(xx_czrk.getCzrkpcsjgdm());
            	}
            }
            
            List<ZjywZqzQyrxx> listQyrxx = bean.getQyrxx();
            if (c_u) {
                nwbService.saveZjywZqzxx(lk, pcsbm);//saveNb(nb,  postid);
                //执行for循环
                for (ZjywZqzQyrxx zqz : listQyrxx) {
                    zqz.setYwlsh(lk.getPostid());
                    nwbService.saveZjywZqzQyrxx(zqz);
                }
                //.saveNb(lk, null, postid);
            } else {
                ZjywZqzxx oldnb = nwbService.queryZjywZqzxxByPostid(postid);
                if (oldnb == null) {
                    throw new Exception("业务流水号[" + lk.getPostid() + "]不存在！");
                }

                nwbService.updateZjywZqzxx(lk);
            }
            ywlsh = lk.getPostid();
            re.setSuccess(true);
        } catch (Exception e) {
            re.setSuccess(false);
            re.setMessage(e.getMessage());
        }
        re.setPostid(postid);
        re.setYwlsh(ywlsh);

        return re;
    }


    /**
     * 迁移证信息接收
     * 迁移证迁移人信息接收
     *
     * @param pcsbm 派出所编码
     * @param sbh   设备号
     * @param md5   旅馆WEBSERVICE-API对应的口令MD5
     * @param type  入住记录类型：1 内宾，2 外宾
     * @param json  内/外宾入组记录的JSON编码，编码格式见文档说明。
     * @return 返回处理结果的JSON，格式如下： {
     * "success": "true|false之一，表示成功或者失败",
     * "message":"错误消息",
     * "postid":"json数据包含的用户第三方ID值，用于返回对应",
     * "lkbm":"如果成功，那么返回入住流水号，必须回填此流水号，退房或者修改入住信息必须使用此凭证"
     * }
     */
    public String postQyzxxRecrod(String pcsbm, String sbh, String md5, String type, String json) {
        LgApiLog log = new LgApiLog();
        log.setApiname("postQyzxxRecrod");
        log.setBz("type=" + type);
        log.setLgbm(pcsbm);
        log.setLogsj(new Date());

        ZjywReturnBean re = new ZjywReturnBean();
        try {
            WebServiceUtil.checkUser(pcsbm, sbh, md5);

            String ip = WebServiceUtil.getIpaddress();
            log.setIp(ip);
            Hz2004Service hz2004Service = (Hz2004Service) SpringContainer.getObject("hz2004Service");


            ZjywQyzQyryxxBean obj = WebServiceUtil.getJsonData(ZjywQyzQyryxxBean.class, json);

            re = postQyzxxRecrods(ip, pcsbm, type, hz2004Service, obj);
        } catch (Exception e) {
            re.setMessage(e.getMessage());
            re.setSuccess(false);
        }

        log.setHs(new Date().getTime() - log.getLogsj().getTime());
        log.setSfcg(re.isSuccess() ? "1" : "0");
        try {
            saveLog(log);
        } catch (Exception e) {
            ;
        }

        return WebServiceUtil.toJson(re);
    }


    /**
     * 迁移证信息接收
     * 迁移证迁移人信息接收
     * 保存或者修改的通用方法
     *
     * @param ip
     * @param pcsbm
     * @param type
     * @param nwbService
     * @param bean
     * @return
     */
    private ZjywReturnBean postQyzxxRecrods(String ip, String pcsbm, String type, Hz2004Service nwbService, ZjywQyzQyryxxBean bean) {


        String ywlsh = null;
        ZjywReturnBean re = new ZjywReturnBean();
        String postid = null;
        ZjywQyzxx lk = null;
        try {

            postid = bean.getQyzbh();

            ywlsh = bean.getYwlsh();

            //下面模拟nwbaction里面的流程，保持nwbservice的业务流程不变
            boolean c_u = true;

            //如果第三方没有带业务流水号，那么默认为新增
            if (CommonUtil.isNotEmpty(ywlsh)) {
                c_u = false;
            } else {
                //判断数据库是否已经记录过此记录KEY
                ApiYs ys = nwbService.getApiYsByPostid(pcsbm, type, postid);
                if (ys != null) {
                    //如果有，那么修改原记录(用户不带，那么智能判断)
                    c_u = false;
                    bean.setYwlsh(ys.getLkbm());
                }
            }

            //将nbbean转换为lknb对象

            lk = WebServiceUtil.getQyzxx(nwbService, ip, pcsbm, bean);
            List<ZjywQyzxxQyrxx> listQyrxx = bean.getQyrxx();
            if (c_u) {
                nwbService.saveZjywQyzxx(lk, pcsbm);//saveNb(nb,  postid);
                //执行for循环
                for (ZjywQyzxxQyrxx qyz : listQyrxx) {
                    qyz.setYwlsh(lk.getYwlsh());
                    nwbService.saveZjywQyzQyrxx(qyz);
                }
            } else {
                ZjywQyzxx oldnb = nwbService.queryZjywQyzxxByPostid(postid);
                if (oldnb == null) {
                    throw new Exception("业务流水号[" + lk.getYwlsh() + "]不存在！");
                }

                nwbService.updateZjywQyzxx(lk);
            }

            //返回设置流水号
            re.setPostid(postid);
            re.setSuccess(true);
            re.setYwlsh(lk.getYwlsh());
        } catch (Exception e) {
            re.setSuccess(false);
            re.setMessage(e.getMessage());
            re.setPostid(postid);
            //如果是修改，那么在异常之后，还需要添加上旅客编码
            if (CommonUtil.isEmpty(re.getPostid()) && CommonUtil.isNotEmpty(re.getYwlsh())) {
                re.setYwlsh(lk.getYwlsh());
            }
        }


        return re;
    }

    /**
     * 获取未来 第 past 天的日期
     *
     * @param past 传递int 为几  就加几天
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        System.out.println(result);
        return result;
    }
}
