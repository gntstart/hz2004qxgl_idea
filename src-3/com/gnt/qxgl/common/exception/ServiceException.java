package com.gnt.qxgl.common.exception;

/**
 * 功能描述:service异常
 * 
 * @author
 * 
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	public ServiceException(ServiceException cause) {
		super(cause.getMessage());
	}
}
