package com.neueda.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neueda.urlshortener.dao.UrlRepository;
import com.neueda.urlshortener.entity.Url;

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
	
	public Url getUrl(String longUrl) {
		return urlRepository.findTopByLongUrl(longUrl);	
	}
	
	public void updateUrl(Url url) {
		urlRepository.save(url);		
	}
}
