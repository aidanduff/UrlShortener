package com.neueda.urlshortener.exception;

public class BlankUrlException extends ValidationException {
	String errorMessage = "No URL entered";

	public BlankUrlException(String errorMessage) {
		super(errorMessage);
		// TODO Auto-generated constructor stub
	}

}
