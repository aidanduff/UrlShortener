package com.aidanduff.urlshortener.model;

public class UrlResponseObject {
	private String originalURL;
	private String shortenedURL;
	
	public UrlResponseObject(String originalURL, String shortenedURL) {
		super();
		this.originalURL = originalURL;
		this.shortenedURL = shortenedURL;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getShortenedURL() {
		return shortenedURL;
	}

	public void setShortenedURL(String shortenedURL) {
		this.shortenedURL = shortenedURL;
	}
	
	
}
