package com.aidanduff.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidanduff.urlshortener.model.Url;
import com.aidanduff.urlshortener.repository.UrlRepository;

@Service
public class UrlService {
	@Autowired
	private UrlRepository urlRepository;

	public void addUrl(Url url) {
		urlRepository.save(url);
	}
	
	public Url getUrlById(int id){
		return urlRepository.findById(id);
	}

	public Url getUrl(String originalUrl) {
		return urlRepository.findByOriginalUrl(originalUrl);
	}

	public void updateUrl(Url url) {
		urlRepository.save(url);
	}
}
