package com.misys.exception;


public class ServiceException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException() {
		super();
	}

}
