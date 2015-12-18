package com.raise.core.exception;

public class ValidateException extends RuntimeException{
	
	protected String errorCode;
	public ValidateException(String message) {
		super(message);
	}
	public ValidateException(String errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public ValidateException(Throwable e) {
		super(e);
	}
	
	public ValidateException(String message,Throwable e) {
		super(message,e);
	}
	
	public ValidateException(String errorCode,String message,Throwable e) {
		super(message,e);
		this.setErrorCode(errorCode);
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	
}
