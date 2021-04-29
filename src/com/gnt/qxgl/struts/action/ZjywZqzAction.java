package com.gnt.qxgl.struts.action;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_ZQZXXB;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzxx;
import com.gnt.qxgl.service.Hz2004Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ZjywZqzAction extends ExtCommonAction {

    private Hz2004Service hz2004Service;

    public Hz2004Service getHz2004Service() {
        return hz2004Service;
    }

    public void setHz2004Service(Hz2004Service hz2004Service) {
        this.hz2004Service = hz2004Service;
    }

    public void queryZqzXx(BaseUser user, ExtCommonForm cform,
                           HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
//            map.put("sfbj","0");
            //qcd_hkdjjg_gajgjgdm
            map.put("sjfw", 1);
            /*
             * add by zjm 20210305
             * 增加限制，登录名为HZADMIN3400查询全部单独处理
             */
            if(user.getUser().getDlm().equals("HZADMIN3400")) {
            	System.out.println("用户名为HZADMIN3400查询全部数据！");
                 cform.setEntity(hz2004Service.queryZqzXx(map, pageIndex, pageSize));
            }else {
            	if (user.getOtherParams() == null) {
                    String dwdmStr = " qcd_hkdjjg_gajgjgdm like '" + user.getUser().getSsdwjgdm().substring(0, 4) + "%'";
                    map.put("dwdmStr", dwdmStr);
                    System.out.println("根据数据范围查询zjyw_zqzxx"+ dwdmStr);
                    cform.setEntity(hz2004Service.queryZqzXx(map, pageIndex, pageSize));
                } else {
                    String sjfw = user.getSjfw();
                    if (CommonUtil.isNotEmpty(sjfw)) {
                        System.out.println("数据范围"+ sjfw);
                        String[] sjfwStr = sjfw.split("\\|");
                        String dwdmStr = " (";
                        int i = 0;
                        for (String sjfw1 : sjfwStr) {
                            if (sjfw1 == null || sjfw1.equals(""))
                                continue;
                            if (i != 0) dwdmStr += " or ";
                            dwdmStr += " qcd_hkdjjg_gajgjgdm like '" + sjfw1 + "%'";
                            i++;
                        }
                        dwdmStr += ") ";
                        map.put("dwdmStr", dwdmStr);

                        cform.setEntity(hz2004Service.queryZqzXx(map, pageIndex, pageSize));
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


    public void updateZqzXx(BaseUser user, ExtCommonForm cform,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);
            Map<String, Object> map = ExtUtils.getRequestParames(request);
            Page page = hz2004Service.queryZqzXx(map, 1, 10);
            List<ZjywZqzxx> list = page.getList();
            if (list.size() > 0) {
                ZjywZqzxx zjywZqzxx = list.get(0);
                String status = (String) map.get("status");
                if (CommonUtil.isNotEmpty(status)) {
                    zjywZqzxx.setIsstatus(status);
                }
                String zxyy = (String) map.get("zxyy");
                if (CommonUtil.isNotEmpty(zxyy)) {
                    zjywZqzxx.setZxyy(zxyy);
                }
                String issfbj = (String) map.get("issfbj");
                if (CommonUtil.isNotEmpty(issfbj)) {
                    zjywZqzxx.setSfbj(issfbj);
                }

                hz2004Service.updateZjywZqzxx(zjywZqzxx);
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }


    public void querySjHjspZqzxx(BaseUser user, ExtCommonForm cform,
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
                 cform.setEntity(hz2004Service.querySjHjspZqzxx(map, pageIndex, pageSize));
            }else {
            	 if (user.getOtherParams() == null) {
                     String dwdmStr = " a.qrdhkdjjg like '" + user.getUser().getSsdwjgdm().substring(0, 4) + "%'";
                     map.put("dwdmStr", dwdmStr);
                     cform.setEntity(hz2004Service.querySjHjspZqzxx(map, pageIndex, pageSize));
                 } else {
                     String sjfw = user.getSjfw();
                     if (CommonUtil.isNotEmpty(sjfw)) {
                         String[] sjfwStr = sjfw.split("\\|");
                         String dwdmStr = " (";
                         int i = 0;
                         for (String sjfw1 : sjfwStr) {
                             if (sjfw1 == null || sjfw1.equals(""))
                                 continue;
                             if (i != 0) dwdmStr += " or ";
                             dwdmStr += " a.qrdhkdjjg like '" + sjfw1 + "%'";
                             i++;
                         }
                         dwdmStr += ") ";
                         map.put("dwdmStr", dwdmStr);
                         String zqzQzsj = SystemConfig.getSystemConfig("zqzQzsj");
                         map.put("dsgxsj", zqzQzsj);
                         cform.setEntity(hz2004Service.querySjHjspZqzxx(map, pageIndex, pageSize));
                     } else {
                         cform.setEntity(new Page());
                     }
                 }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }

    }

    public void updateSjHjspZqzxx(BaseUser user, ExtCommonForm cform,
                                  HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);
            Map<String, Object> map = ExtUtils.getRequestParames(request);
            Page page = hz2004Service.querySjHjspZqzxx(map, 1, 10);
            List<SJ_HJSP_ZQZXXB> list = page.getList();
            if (list.size() > 0) {
                SJ_HJSP_ZQZXXB sjHjspZqzxxb = list.get(0);

                String status = (String) map.get("status");
                if (CommonUtil.isNotEmpty(status)) {
                    sjHjspZqzxxb.setIsstatus(status);
                }

                String issfcsjtb = (String) map.get("issfcsjtb");
                if (CommonUtil.isNotEmpty(issfcsjtb)) {
                    sjHjspZqzxxb.setSfcsjtb(issfcsjtb);
                }

                String isqyyy = (String) map.get("isqyyy");
                if (CommonUtil.isNotEmpty(isqyyy)) {
                    sjHjspZqzxxb.setQyyy(isqyyy);
                }
                //手动推送修改值
                hz2004Service.updateSJ_HJSP_ZQZXXB(sjHjspZqzxxb);
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void queryDzyxSjHjspZqzxx(BaseUser user, ExtCommonForm cform,
                                 HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            map.put("sjfw", 1);
            map.put("dqbm",user.getYwdq());
            /*
             * add by zjm 20210305
             * 增加限制，登录名为HZADMIN3400查询全部单独处理
             */
            if(user.getUser().getDlm().equals("HZADMIN3400")) {
                System.out.println("用户名为HZADMIN3400查询全部数据！");
                cform.setEntity(hz2004Service.queryDzyxSjHjspZqzxx(map, pageIndex, pageSize));
            }else {
                if (user.getOtherParams() == null) {
                    String dwdmStr = " a.qrdhkdjjg like '" + user.getUser().getSsdwjgdm().substring(0, 4) + "%'";
                    map.put("dwdmStr", dwdmStr);
                    cform.setEntity(hz2004Service.queryDzyxSjHjspZqzxx(map, pageIndex, pageSize));
                } else {
                    String sjfw = user.getSjfw();
                    if (CommonUtil.isNotEmpty(sjfw)) {
                        String[] sjfwStr = sjfw.split("\\|");
                        String dwdmStr = " (";
                        int i = 0;
                        for (String sjfw1 : sjfwStr) {
                            if (sjfw1 == null || sjfw1.equals(""))
                                continue;
                            if (i != 0) dwdmStr += " or ";
                            dwdmStr += " a.qrdhkdjjg like '" + sjfw1 + "%'";
                            i++;
                        }
                        dwdmStr += ") ";
                        map.put("dwdmStr", dwdmStr);
                        String zqzQzsj = SystemConfig.getSystemConfig("zqzQzsj");
                        map.put("dsgxsj", zqzQzsj);
                        cform.setEntity(hz2004Service.queryDzyxSjHjspZqzxx(map, pageIndex, pageSize));
                    } else {
                        cform.setEntity(new Page());
                    }
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }

    }

    public void insertDzyxQr(BaseUser user, ExtCommonForm cform,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);
            Map<String, Object> map = ExtUtils.getRequestParames(request);
            hz2004Service.insertDzyxQr(map, 1, 10,user);

        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void deleteZqzXx(BaseUser user, ExtCommonForm cform,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);
            Map<String, Object> map = ExtUtils.getRequestParames(request);
            String status = (String) map.get("status");
            String zqid = (String) map.get("zqid");
            hz2004Service.deleteZqzXx(status,zqid);

        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void modifyDzyxQr(BaseUser user, ExtCommonForm cform,
                             HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);
            Map<String, Object> map = ExtUtils.getRequestParames(request);

            hz2004Service.modifyDzyxQr(map);

        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }
}
