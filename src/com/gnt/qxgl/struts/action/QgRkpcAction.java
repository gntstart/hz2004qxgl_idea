package com.gnt.qxgl.struts.action;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.service.QgRkpcService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <功能概述>
 * 人口普查action 方法
 *
 * @author: 杨冬冬
 * @className: QgRkpcAction
 * @package: com.gnt.qxgl.struts.action
 * @description: 用于人口普查的Action方法类
 * @date: 2020-06-24 16:53
 */
public class QgRkpcAction extends ExtCommonAction {
    private QgRkpcService qgRkpcService;

    public QgRkpcService getQgRkpcService() {
        return qgRkpcService;
    }

    public void setQgRkpcService(QgRkpcService qgRkpcService) {
        this.qgRkpcService = qgRkpcService;
    }

    public void queryQgRkpcxx(BaseUser user, ExtCommonForm cform,
                              HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            cform.setEntity(qgRkpcService.queryQgRkpcxx(map, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }

    public void saveQgRkpcxx(BaseUser user, ExtCommonForm cform,
                              HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);
            Map<String, Object> map = ExtUtils.getRequestParames(request);
            cform.setEntity(qgRkpcService.saveQgRkpcxx(map));
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }
}
