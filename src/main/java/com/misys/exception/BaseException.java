package com.misys.exception;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseException(Exception e) {
		super(e);
	}

	public BaseException() {
	}

}
