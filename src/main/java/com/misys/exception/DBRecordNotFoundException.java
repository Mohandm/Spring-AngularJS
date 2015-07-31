package com.misys.exception;

public class DBRecordNotFoundException extends DAOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBRecordNotFoundException(Exception e) {
		super(e);
	}

}
