package com.gnt.qxgl.common.struts.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.CommonUtil;

public abstract class ExtCommonAction extends CommonAction {
	static public final String LOGINOUT_MSG = "对不起，您已经超时，请重新登陆系统！";
	
	//如果上下问包含改参数（request.getAttribute），那么直接输出字符�?
	static public final String JSON = "_json_";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ExtCommonForm cForm = null;
		
		if (form == null) {
		    cForm = new ExtCommonForm();
		} else {
		    cForm = (ExtCommonForm) form;
		}
		
		//如果没有转向标志，那么使用公共的转向标志gson，打印当前表单的getJson数据
		if (cForm.getDestination() == null)
			cForm.setDestination("gson");
			
		//调用父亲方法
		ActionForward af = super.execute(mapping, form, request, response);
		generateExtMsg(request,cForm);
		
		return af;
	}

	/**
	 * 统一保存EXT格式的各种消息，以方便过统一的JS脚本进行分析
	 * @param request
	 * @param form
	 */
	private void generateExtMsg(HttpServletRequest request,ExtCommonForm form) {
		ActionMessages errors = this.getErrors(request);
		ActionMessages messages = this.getMessages(request);
		
		if(errors!=null){
			List<String> errlist = new ArrayList<String>();
			for(Iterator it = errors.get();it.hasNext();){
				ActionMessage msg = (ActionMessage)it.next();
				errlist.add((String)msg.getValues()[0]);
			}
			if(CommonUtil.isNotEmpty(errlist)){
				form.setMessages(errlist);
				form.setSuccess(false);
			}
		}
		
		if(messages!=null){
			List<String> successlist = new ArrayList<String>();
			for(Iterator it = messages.get();it.hasNext();){
				ActionMessage msg = (ActionMessage)it.next();
				successlist.add((String)msg.getValues()[0]);
			}
			if(CommonUtil.isNotEmpty(successlist)){
				form.setMessages(successlist);
				if(	(errors!=null && errors.size()>0)
						|| (form.getErrors()!=null && form.getErrors().size()>0)
				)
					form.setSuccess(false);
				else
					form.setSuccess(true);
				return;
			}
		}
	}
}
