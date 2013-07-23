package org.bigblue.j2eeservice.mangoweb.exception;

import java.util.Locale;

public class MangoFrameworkException extends Exception {

	private String message;

	public MangoFrameworkException() {
		super();
	}

	public MangoFrameworkException(String message) {
		super(message);
		this.message = message;
	}

	public MangoFrameworkException(String key, Locale locale) {
		// TO DO: Locale specific Message
	}

	public MangoFrameworkException(Throwable cause) {
		super(cause);
	}
	
	public MangoFrameworkException(Throwable cause,String message) {
		super(cause);
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
