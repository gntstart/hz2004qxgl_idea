package com.gnt.qxgl.struts.action;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.exception.ActionException;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.ExtUtils;
import com.gnt.qxgl.common.util.MessageUtil;
import com.gnt.qxgl.service.CsjHkKsWsQyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <功能概述>
 * 安徽长三角户口跨省网上迁移情况action 方法
 *
 * @author: zjm
 * @className: QgRkpcAction
 * @package: com.gnt.qxgl.struts.action
 * @description: 用于安徽长三角户口跨省网上迁移的Action方法类
 * @date: 20210308
 */
public class CsjHkKsWsQyAction extends ExtCommonAction {
    private CsjHkKsWsQyService csjhkkswsqyservice;

    public CsjHkKsWsQyService getCsjhkkswsqyservice() {
        return csjhkkswsqyservice;
    }

    public void setCsjhkkswsqyservice(CsjHkKsWsQyService csjhkkswsqyservice) {
        this.csjhkkswsqyservice = csjhkkswsqyservice;
    }

    public void queryCsjhkkswsxx(BaseUser user, ExtCommonForm cform,
                                 HttpServletRequest request, HttpServletResponse response) {
        try {
            if (user == null)
                throw new ActionException(LOGINOUT_MSG);

            Map<String, Object> map = ExtUtils.getRequestParames(request);
            int pageIndex = Integer.parseInt((String) map.get(ExtUtils.pageIndex));
            int pageSize = Integer.parseInt((String) map.get(ExtUtils.pageSize));
            /*
             * 将查询条件保存进session
             */
            BaseContext.getContext().getSession().setAttribute("queryCsjhkkswsxx", map);
            cform.setEntity(csjhkkswsqyservice.queryCsjhkkswsxx(map, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.addErrorMsg(e.getMessage());
        }
    }
    public void ExportqueryCsjhkkswsxx(BaseUser user, ExtCommonForm cform,
            HttpServletRequest request, HttpServletResponse response) {
		try {
			if (user == null)
			    throw new ActionException(LOGINOUT_MSG);
//			Map<String, Object> map = ExtUtils.getRequestParames(request);
            Map<String, Object> map  = (Map<String, Object>)BaseContext.getContext().getSession().getAttribute("queryCsjhkkswsxx");
			csjhkkswsqyservice.ExportqueryCsjhkkswsxx(map,request,response);
        } catch (Exception e) {
			e.printStackTrace();
			MessageUtil.addErrorMsg(e.getMessage());
		}
	}

}
