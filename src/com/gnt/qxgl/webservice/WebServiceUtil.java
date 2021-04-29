package com.gnt.qxgl.webservice;

import com.gnt.qxgl.base.encoders.Hex;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXkzApi;
import com.gnt.qxgl.hz2004.entity.zjyw.XkzApi;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxx;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzxx;
import com.gnt.qxgl.service.Hz2004Service;
import com.gnt.qxgl.service.YwtbService;
import com.gnt.qxgl.webservice.bean.ZjywQyzQyryxxBean;
import com.gnt.qxgl.webservice.bean.ZjywZqzQyryxxBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Date;

public class WebServiceUtil {


    /**
     * 将API的bean转换为内宾对象
     *
     * @param nwbService
     * @param bean
     * @return private String    postid;	//第三方记录ID, 用于返回对应
     * private String	    lhsfz;	//落户身份证
     * private String	xm; 	//姓名，不超过40个字节
     * private String	xb;	//性别
     * private String	mz;	//民族
     * private String	csrq; //出生日期，格式：yyyyMMdd
     * private String  	ywlsh;	//业务流水号
     * private Date	cjsj;//创建时间
     * private String	csdssxq;	//出生地省市县/区
     * private String	cdsxz;	//出生地详细地址
     * private String	jgssxq;	//籍贯省市县/区
     * private String	hb;	//户别默认和户主一致
     * private String	jthzl;	//集体户种类（户别为集体户时必填）
     * private String	csdjlb;//出生登记类别
     * private String	cszmbh;//出生证明编号
     * private String	jhryxm;	//监护人一姓名
     * private String	jhrygmsfhm;//监护人一身份号码
     * private String	jhrylxdh;		//监护人一联系电话
     * private String	jhryjhgx;		//监护人一关系
     * private String	jhrexm;		//监护人二姓名
     * private String	jhregmsfhm;//监护人二身份号码
     * private String	jhrelxdh;		//监护人二联系电话
     * private String	jhrejhgx;		//监护人二关系
     * private String	fqxm;	//父亲姓名（父亲母亲信息两组必须填一组）
     * private String	Fqgmsfhm;	//父亲身份号码（父亲母亲信息两组必须填一组）
     * private String	Mqxm;		//母亲姓名（父亲母亲信息两组必须填一组）
     * private String	Mqgmsfhm;	//母亲身份号码（父亲母亲信息两组必须填一组）
     * private String	    Sbrxm;	//申报人姓名
     * private String	Sbrsfz;	//申报人身份证
     */



    static public ZjywZqzxx getZqzxx(Hz2004Service nwbService, String ip, String pcsbm, ZjywZqzQyryxxBean b) {
        ZjywZqzxx zq = new ZjywZqzxx();
        zq.setYwlsh(b.getYwlsh());
        zq.setZqzbh(b.getZqzbh());
        zq.setSqr_gmsfhm(b.getSqr_gmsfhm());
        zq.setSqr_xm(b.getSqr_xm());
        zq.setSqr_zz_ssxqdm(b.getSqr_zz_ssxqdm());
        zq.setSqr_zz_qhnxxdz(b.getSqr_zz_qhnxxdz());
        zq.setSqr_hkdjjg_gajgjgdm(b.getSqr_hkdjjg_gajgjgdm());
        zq.setSqr_hkdjjg_gajgmc(b.getSqr_hkdjjg_gajgmc());
        zq.setQcd_ssxqdm(b.getQcd_ssxqdm());
        zq.setQcd_qhnxxdz(b.getQcd_qhnxxdz());
        zq.setQcd_hkdjjg_gajgjgdm(b.getQcd_hkdjjg_gajgjgdm());
        /*
         * Modify by zjm 
         * 20210218
         * 修改取值逻辑，将qcd_hkdjjg_gajgjgdm qcd_hkdjjg_gajgmc 取hjxx_czrk  czrkpcsmc czrkpcsjgdm  条件是sqr_gmsfhm  =  czrkgmsfhm
         */
//        zq.setQcd_hkdjjg_gajgmc(b.getQcd_hkdjjg_gajgmc());
//        zq.setQrd_ssxqdm(b.getQrd_ssxqdm());
        zq.setQrd_qhnxxdz(b.getQrd_qhnxxdz());
        zq.setQrd_hkdjjg_gajgjgdm(b.getQrd_hkdjjg_gajgjgdm());
        zq.setQrd_hkdjjg_gajgmc(b.getQrd_hkdjjg_gajgmc());
        zq.setQfjg_gajgjgdm(b.getQfjg_gajgjgdm());
        zq.setQfjg_gajgmc(b.getQfjg_gajgmc());
        zq.setCbr_xm(b.getCbr_xm());
        zq.setQfrq(b.getQfrq());
        zq.setBz(b.getBz());
        zq.setQyldyydm(b.getQyldyydm());
        zq.setYxqjzrq(b.getYxqjzrq());
        zq.setQyfwdm(b.getQyfwdm());
        zq.setSldw_gajgjgdm(b.getSldw_gajgjgdm());
        zq.setSldw_gajgmc(b.getSldw_gajgmc());
        zq.setSlr_xm(b.getSlr_xm());
        zq.setSlsj(b.getSlsj());
        zq.setSjgsdwdm(b.getSjgsdwdm());
        zq.setSjgsdwmc(b.getSjgsdwmc());
        if (CommonUtil.isEmpty(b.getPostid())) {
            zq.setPostid(nwbService.updateLkbm(pcsbm));
        } else {
            zq.setPostid(b.getPostid());
        }
        return zq;
    }


    static public ZjywQyzxx getQyzxx(Hz2004Service nwbService, String ip, String pcsbm, ZjywQyzQyryxxBean b) {
        ZjywQyzxx zq = new ZjywQyzxx();
        zq.setQyzbh(b.getQyzbh());
        zq.setCzr_gmsfhm(b.getCzr_gmsfhm());
        zq.setCzr_xm(b.getCzr_xm());
        zq.setYzz_ssxqdm(b.getYzz_ssxqdm());
        zq.setYzz_qhnxxdz(b.getYzz_qhnxxdz());
        zq.setYzz_cxfldm(b.getYzz_cxfldm());
        zq.setQwd_ssxqdm(b.getQwd_ssxqdm());
        zq.setQwd_qhnxxdz(b.getQwd_qhnxxdz());
        zq.setQfjg_gajgjgdm(b.getQfjg_gajgjgdm());
        zq.setQfjg_gajgmc(b.getQfjg_gajgmc());
        zq.setQfrq(b.getQfrq());
        zq.setYxqjzrq(b.getYxqjzrq());
        zq.setCbr_xm(b.getCbr_xm());
        zq.setBz(b.getBz());
        zq.setZqzbh(b.getZqzbh());
        zq.setQyfwdm(b.getQyfwdm());
        zq.setSldw_gajgjgdm(b.getSldw_gajgjgdm());
        zq.setSldw_gajgmc(b.getSldw_gajgmc());
        zq.setSlr_xm(b.getSlr_xm());
        zq.setSlsj(b.getSlsj());
        zq.setSjgsdwdm(b.getSjgsdwdm());
        zq.setSjgsdwmc(b.getSjgsdwmc());

        if (CommonUtil.isEmpty(b.getYwlsh())) {
            zq.setYwlsh(nwbService.updateLkbm(pcsbm));
        } else {
            zq.setYwlsh(b.getYwlsh());
        }
        return zq;
    }


    /**
     * 对象---》字符串
     *
     * @param src
     * @return
     */
    static public String toJson(Object src) {
        GsonBuilder build = new GsonBuilder();
        Gson gson = build.create();
        return gson.toJson(src);
    }

    /**
     * 对象转换：字符串---》对象
     *
     * @param classOfT
     * @param data
     * @return
     */
    static public <T> T getJsonData(Class<T> classOfT, String data) {
        GsonBuilder build = new GsonBuilder();
        //if(this.dateStyle != null) {
        //	build.setDateFormat(this.dateStyle);
        //}
        Gson gson = build.create();
        return gson.fromJson(data, classOfT);
    }

    static public String MD5AndHex(String msginfo) {
        try {
            java.security.MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] buff = m.digest(msginfo.getBytes());
            return new String(Hex.encode(buff));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msginfo;
    }

    static public String array2ToString(String[][] obj) {
        if (obj == null)
            return "";

        String str = "";
        for (int i = 0; i < obj.length; i++) {
            if (i > 0) str += ",";

            str += "{";
            for (int j = 0; j < obj[i].length; j++) {
                if (j > 0) str += ",";

                str += "\"" + obj[i][j] + "\"";
            }
            str += "}\n";
        }

        return str;
    }

    static public String arrayToString(String[] obj) {
        if (obj == null)
            return "";

        String str = "";
        for (int i = 0; i < obj.length; i++)
            str += "re[" + i + "]=" + obj[i] + ";";
        return str;
    }

    static public boolean checkUser(String pcsbm, String sbh, String md5) throws Exception {

        Hz2004Service apiService = (Hz2004Service) SpringContainer.getObject("hz2004Service");
        YwtbXkzApi api = null;

        api = apiService.getXkzApi(pcsbm, sbh);
        if (api == null)
            throw new Exception("派出所编码[" + pcsbm + "]不是API开机用户！");

        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] buff = m.digest(api.getPwd().getBytes());
        String oldmd5 = new String(Hex.encode(buff));

        //检查MD5
        if (!oldmd5.equals(md5))
            throw new Exception("口令校验码错误！");
		
		/*if(CommonUtil.isNotEmpty(api.getIp())){
			String ip = getIpaddress();
			//检查IP
			if(api.getIp().indexOf(ip)<0)
				throw new Exception("错误，账号所在IP地址" + ip + "不符！");
		}*/

        if (api.getJzsj() != null && api.getJzsj().before(new Date()))
            throw new Exception("账号已经到期！");

        return true;

    }

    static public boolean ywtbCheckUser(String pcsbm, String sbh, String md5) throws Exception {

        YwtbService apiService = (YwtbService) SpringContainer.getObject("ywtbService");
        YwtbXkzApi api = null;

        api = apiService.getXkzApi(pcsbm, sbh);
        if (api == null)
            throw new Exception("编码[" + pcsbm + "]不是API授权用户！");

        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] buff = m.digest(api.getPwd().getBytes());
        String oldmd5 = new String(Hex.encode(buff));

        //检查MD5
        if (!oldmd5.equals(md5))
            throw new Exception("口令校验码错误！");

		/*if(CommonUtil.isNotEmpty(api.getIp())){
			String ip = getIpaddress();
			//检查IP
			if(api.getIp().indexOf(ip)<0)
				throw new Exception("错误，账号所在IP地址" + ip + "不符！");
		}*/

        if (api.getJzsj() != null && api.getJzsj().before(new Date()))
            throw new Exception("账号已经到期！");

        return true;

    }

    static public String getIpaddress() {
        MessageContext mc = MessageContext.getCurrentContext();
        HttpServletRequest request = (HttpServletRequest) mc
                .getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
        String ip = request.getRemoteAddr();

        return ip;
    }

}
