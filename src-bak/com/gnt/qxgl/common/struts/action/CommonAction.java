package com.gnt.qxgl.common.struts.action;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.struts.form.CommonForm;
import com.gnt.qxgl.common.struts.form.ExtCommonForm;
import com.gnt.qxgl.common.util.MessageUtil;

/**
 * 
 * @author Administrator
 * 
 */
public abstract class CommonAction extends Action {
	private static Logger log = Logger.getLogger(CommonAction.class.getName());

	static public String SESSION_TYPE = SystemConfig.getSystemConfig("sessionType","session");
	
	public CommonAction() {
		super();
	}

	/**
	 * 子类的操作应用辑在该方法实现
	 * 
	 */
	private void performTask(BaseUser user, CommonForm cform,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.warn(request.getRequestURI() + "：子类没有重载performTask()方法，也未过参数设置其他业务方法");
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MessageUtil.reset();// 重置消息
		CommonForm cForm = null;
		if (form == null) {
			cForm = new CommonForm();
		} else {
			cForm = (CommonForm) form;
		}
		
		try {
			// 从request中获取要求转向的标志key，如果为空，则默认"error"
			if (cForm.getDestination() == null)
				cForm.setDestination("error");

			BaseUser currentUser = (BaseUser) BaseContext.getBaseUser();
				
			String actionParam = mapping.getParameter();
			// action配置中的parameter
			
			if( (actionParam != null && actionParam.length() > 0) && request.getParameter(actionParam) != null) {
				String methodName = request.getParameter(actionParam);
				// action声明的参数名的
				if (methodName == null || methodName.trim().length() == 0) {
					throw new Exception("缺少Action中声明的参数'" + actionParam + "'");
				}
				//Method[] methods = this.getClass().getDeclaredMethods();
				
				//直接而获取方法，防止遍历
				Method m = null;
				
				try{
					m = this.getClass().getDeclaredMethod(
								methodName,
								BaseUser.class,
								CommonForm.class,
								HttpServletRequest.class,
								HttpServletResponse.class);
				}catch(NoSuchMethodException e){
					try{
						m = this.getClass().getDeclaredMethod(
								methodName,
								BaseUser.class,
								ExtCommonForm.class,
								HttpServletRequest.class,
								HttpServletResponse.class);
						
						if(form==null)
							cForm = new ExtCommonForm();
						
						//if (currentUser == null)
						//	throw new ActionException(ExtCommonAction.LOGINOUT_MSG);
					}catch(NoSuchMethodException ex){
						;
					}
				}
				
				boolean isExecute = false;// 标志业务方法是否被执行到
				if(m!=null){
					isExecute = true;
					m.invoke(this, new Object[] { currentUser, cForm, request, response });
				}
				
				if (!isExecute) {
					throw new Exception("未找到名称为'" + methodName
							+ "'的业务方法，请确认方法参数是否一致。");
				}
			} else {
				performTask(currentUser, cForm, request, response);
			}
		} catch (Exception e) {
			//捕获来自业务层的异常，必须遍历错误，获取错误的根，否则无法获取多层抛出的异常行为
			Throwable cause = e;
	        while (cause.getCause() != null) {	        	
	        	cause = cause.getCause();
	        }
			MessageUtil.addErrorMsg(cause.getMessage() != null ? cause.getMessage() : "服务器出现错误，请重试！");
			log.error(cause.getMessage(), cause);
		}

		this.generateMsg(request);// 生成消息
		MessageUtil.reset();// 重置消息
		return mapping.findForward(cForm.getDestination());
	}

	/**
	 * 保存消息
	 * 
	 * @param request
	 */
	private void generateMsg(HttpServletRequest request) {
		this.generateMsg(request, false, false);
	}

	/**
	 * 保存消息
	 * 
	 * @param appendSuccess
	 *            当有成功标志时是否还生成成功消息
	 * @param appendError
	 *            当有出错标志时是否还生成出错消息
	 * @param request
	 */
	private void generateMsg(HttpServletRequest request, boolean appendSuccess,
			boolean appendError) {
		ActionMessages errors = new ActionMessages();
		ActionMessages messages = new ActionMessages();

		Collection errorMsgs = MessageUtil.getErrorMsg();
		Collection msgs = MessageUtil.getGeneralMsg();

		// 错误消息
		if (MessageUtil.isError()) {
			errors.add("errMsg", new ActionMessage("msg.error"));
		}
		if (errorMsgs.size() > 0 && (!MessageUtil.isError() || appendError)) {
			int i = 0;
			for (Iterator it = errorMsgs.iterator(); it.hasNext();) {
				String msg = String.valueOf(it.next());
				errors.add("errMsg" + i++, new ActionMessage("msg.arg", msg));
			}

			super.saveErrors(request, errors);
		}

		// 成功消息
		if (MessageUtil.isSuccess()) {
			messages.add("msg", new ActionMessage("msg.success"));
		}
		if (msgs.size() > 0 && (!MessageUtil.isSuccess() || appendSuccess)) {
			int i = 0;
			for (Iterator it = msgs.iterator(); it.hasNext();) {
				String msg = it.next().toString();
				messages.add("msg" + i++, new ActionMessage("msg.arg", msg));
			}

			super.saveMessages(request, messages);
		}
	}
}
