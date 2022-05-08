package com.quintrix.java.quintrixspring.exception;

public class CarNotFoundException extends RuntimeException {

	String displayMessage;
	String detailedMessage;
	public CarNotFoundException(String displayMessage, String detailedMessage) {
		super();
		this.displayMessage = displayMessage;
		this.detailedMessage = detailedMessage;
	}
	public CarNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public CarNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public CarNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public CarNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
