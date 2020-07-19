package com.aidanduff.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidanduff.urlshortener.model.Url;
import com.aidanduff.urlshortener.repository.UrlRepository;

@Service
public class UrlService {
	@Autowired
	private UrlRepository urlRepository;

	public String addUrl(Url url) {
		urlRepository.save(url);
		return url.getShortUrl();
	}

	public Url getLong(String shortUrl) {
		return urlRepository.findTopByShortUrl(shortUrl);
	}

	public Url getUrl(String originalUrl) {
		return urlRepository.findTopByOriginalUrl(originalUrl);
	}

	public void updateUrl(Url url) {
		urlRepository.save(url);
	}
}