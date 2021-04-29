package com.gnt.qxgl.struts.action;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.service.YwtbService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <功能概述>
 *
 * @author: 杨冬冬
 * @className: YwtbXxAction
 * @package: com.gnt.qxgl.struts.action
 * @description: 介绍
 * @date: 2020-05-20 14:07
 */
public class YwtbXxAction extends ExtCommonAction {

    private YwtbService ywtbService;

    public YwtbService getYwtbService() {
        return ywtbService;
    }

    public void setYwtbService(YwtbService ywtbService) {
        this.ywtbService = ywtbService;
    }

    public void queryYwtbXx(BaseUser user, ExtCommonForm cform,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            cform.setEntity(ywtbService.queryYwtbXx(map, pageIndex, pageSize,user));

        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void updateYwtbXx(BaseUser user, ExtCommonForm cform,
                             HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null) {
                throw new ActionException(LOGINOUT_MSG);
            }
            Map<String, Object> map = ExtUtils.getRequestParames(request);
            ywtbService.updateYwtbXx(map);
            MessageUtil.addGeneralMsg("数据修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void queryCzrkxx(BaseUser user, ExtCommonForm cform,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null) {
                throw new ActionException(LOGINOUT_MSG);
            }

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            cform.setEntity(ywtbService.queryCzrkxx(map, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void queryBggzxxb(BaseUser user, ExtCommonForm cform,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null) {
                throw new ActionException(LOGINOUT_MSG);
            }

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            cform.setEntity(ywtbService.queryBggzxxb(map, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void querySwzxZm(BaseUser user, ExtCommonForm cform,
                             HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null) {
                throw new ActionException(LOGINOUT_MSG);
            }

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            cform.setEntity(ywtbService.querySwzxZm(map, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void queryQczxZm(BaseUser user, ExtCommonForm cform,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null) {
                throw new ActionException(LOGINOUT_MSG);
            }

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            cform.setEntity(ywtbService.queryQczxZm(map, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void queryYwtbFjcl(BaseUser user, ExtCommonForm cform,
                              HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            cform.setEntity(ywtbService.queryYwtbFjcl(map, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void sendPostYwtb(BaseUser user, ExtCommonForm cform,
                             HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);

//            // 读取请求内容
//            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
//            String line = null;
//            StringBuilder sb = new StringBuilder();
//            while((line = br.readLine())!=null){
//                sb.append(line);
//            }
//            // 将资料解码
//            String decode = URLDecoder.decode(sb.toString(), HTTP.UTF_8);

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            ywtbService.sendPostYwtb(map,user);
            MessageUtil.addGeneralMsg("数据报送一网通办成功！");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }
}
