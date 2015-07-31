package com.misys.exception;


public class UserServiceException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserServiceException(Exception e) {
		super(e);
	}

	public UserServiceException() {
		super();
	}
}