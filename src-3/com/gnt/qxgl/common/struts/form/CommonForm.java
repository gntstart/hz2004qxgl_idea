package com.gnt.qxgl.common.struts.form;

import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.gnt.qxgl.common.Page;

public class CommonForm extends ActionForm {
	private static final String SESSION_SUBMITID = "_SUBMIT_ID";
	private static final long serialVersionUID = 1L;
	
	private Random random = new Random();
	private String submitid = null;
	
	public String getSubmitid() {
		return submitid;
	}
	
	public void setSubmitid(String submitid) {
		this.submitid = submitid;
	}
	
	public void initSubmit(HttpServletRequest request){
		submitid = String.valueOf(random.nextLong());
		request.getSession().setAttribute(SESSION_SUBMITID, submitid);
	}
	
	/**
	 * 目标地址index 一般为指向JSP页面的标志struts-config.xml配置 转发方式一般为false
	 */
	private String destination = null;
	/**
	 * 来源地址 一般为指向action.do?para1=paravalue 转发方式一般为true,防止数据污染
	 */
	private String sourceURL;
	/**
	 * 前进标志
	 */
	private boolean forwardIndex = true;

	/**
	 * 分页对象 page属性和ext4的store冲突
	 */
	//protected Page page = new Page();

	public void reset(ActionMapping mapping, HttpServletRequest request) {

	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSourceURL() {
		return sourceURL;
	}
	
	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public boolean getForwardIndex() {
		return forwardIndex;
	}

	public void setForwardIndex(boolean forwardIndex) {
		this.forwardIndex = forwardIndex;
	}
}
