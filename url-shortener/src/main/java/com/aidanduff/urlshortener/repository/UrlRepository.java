package com.aidanduff.urlshortener.repository;

import org.springframework.data.repository.CrudRepository;

import com.aidanduff.urlshortener.model.Url;

public interface UrlRepository extends CrudRepository<Url, String> {

	Url findByOriginalUrl(String originalUrl); 
	
	String findOriginalUrlById(int id);

	Url findById(int id);

}
