package com.raise.core.exception;

public class FieldValidateException extends ValidateException{
	private static final long serialVersionUID = 1L;
	
	protected String field;
	
	public FieldValidateException(String message) {
		super(message);
	}
	public FieldValidateException(String errorCode,String message) {
		super(errorCode,message);
	}
	
	public FieldValidateException(Throwable e) {
		super(e);
	}
	
	public FieldValidateException(String message,Throwable e) {
		super(message,e);
	}
	
	public FieldValidateException(String errorCode,String message,Throwable e) {
		super(errorCode,message,e);
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
}
