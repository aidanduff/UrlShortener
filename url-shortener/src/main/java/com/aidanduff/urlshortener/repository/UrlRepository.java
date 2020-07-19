package com.aidanduff.urlshortener.repository;

import org.springframework.data.repository.CrudRepository;

import com.aidanduff.urlshortener.model.Url;

public interface UrlRepository extends CrudRepository<Url, String> {

	Url findTopByOriginalUrl(String originalUrl); // Use findTop to avoid SQL Exception thrown by duplicate DB entries

	Url findTopByShortUrl(String shortUrl);

}
