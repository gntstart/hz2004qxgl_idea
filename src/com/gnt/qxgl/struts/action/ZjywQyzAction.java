package com.gnt.qxgl.struts.action;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.service.Hz2004Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZjywQyzAction extends ExtCommonAction {

    private Hz2004Service hz2004Service;

    public Hz2004Service getHz2004Service() {
        return hz2004Service;
    }

    public void setHz2004Service(Hz2004Service hz2004Service) {
        this.hz2004Service = hz2004Service;
    }

    public void queryQyzXx(BaseUser user, ExtCommonForm cform,
                           HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            map.put("sjfw", 1);
            /*
             * add by zjm 20210305
             * 增加限制，登录名为HZADMIN3400查询全部单独处理
             */
            if(user.getUser().getDlm().equals("HZADMIN3400")) {
            	System.out.println("用户名为HZADMIN3400查询全部数据！");
                 cform.setEntity(hz2004Service.queryQyzXx(map, pageIndex, pageSize));
            }else {
            	if(user.getOtherParams() == null){
                    String dwdmStr = " hkdjpcs like '" + user.getUser().getSsdwjgdm().substring(0, 4) + "%'";
                    map.put("dwdmStr2", dwdmStr);
                    cform.setEntity(hz2004Service.queryQyzXx(map, pageIndex, pageSize));
                }else {
                    String sjfw = user.getSjfw();
                    if (CommonUtil.isNotEmpty(sjfw)) {
                        String[] sjfwStr = sjfw.split("\\|");
                        String dwdmStr = " (";
                        int i = 0;
                        for (String sjfw1 : sjfwStr) {
                            if (sjfw1 == null || sjfw1.equals(""))
                                continue;
                            if (i != 0) dwdmStr += " or ";
                            dwdmStr += " hkdjpcs like '" + sjfw1 + "%'";
                            i++;
                        }
                        dwdmStr += ") ";
                        map.put("dwdmStr2", dwdmStr);

                        cform.setEntity(hz2004Service.queryQyzXx(map, pageIndex, pageSize));
                    } else {
                        cform.setEntity(new Page());
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }
}
