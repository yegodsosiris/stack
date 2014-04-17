package com.stack.util;

public class ErrorData {
	
	boolean error=true;
	String message;
	
	public boolean isError() {
		return error;
	}

	public ErrorData(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
}