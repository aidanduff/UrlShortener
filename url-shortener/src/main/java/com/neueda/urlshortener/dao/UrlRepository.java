package com.neueda.urlshortener.dao;

import org.springframework.data.repository.CrudRepository;

import com.neueda.urlshortener.entity.Url;

public interface UrlRepository extends CrudRepository<Url, String> {
	
	Url findTopByLongUrl(String longUrl);	//Use findTop to avoid SQL Exception thrown by duplicate DB entries
	
	Url findTopByShortUrl(String shortUrl);

}
