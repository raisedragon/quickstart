package com.raise.spi.exception;

public class SPIException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	protected String errorCode;
	
	public SPIException() {
		super();
	}
	
	public SPIException(String errorCode, String message) {
		super(message);
	}
	
	public SPIException(Throwable cause) {
		super(cause);
	}
	
	public SPIException(String errorCode, String message, Throwable cause) {
		super(message, cause);
	}
}
