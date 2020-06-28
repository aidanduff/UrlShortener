package com.neueda.urlshortener.exception;

public class ValidationException extends Exception{
	private String errorMessage;

	public ValidationException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
        return errorMessage;
    }
	
	
}
