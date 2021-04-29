package com.gnt.qxgl.common.exception;

/**
 * 功能描述:action异常
 * 
 * @author guodongz
 * 
 */
public class ActionException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ActionException() {
		super();
	}

	public ActionException(String message) {
		super(message);
	}

	public ActionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActionException(Throwable cause) {
		super(cause);
	}
}
