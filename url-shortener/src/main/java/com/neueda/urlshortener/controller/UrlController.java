package com.neueda.urlshortener.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.urlshortener.model.Url;
import com.neueda.urlshortener.service.UrlService;
import com.neueda.urlshortener.util.Encoder;

@RestController
public class UrlController {

	@Autowired
	private UrlService urlService;
	
	@RequestMapping(method=RequestMethod.POST, value="/short")
	public ResponseEntity<Url> addAndEncode(@Validated@RequestBody String originalUrl) {		
		Url urlToAdd = new Url(originalUrl, "");								
		urlService.addUrl(urlToAdd);											//Add the long URL to the database
		int uniqueId = urlService.getUrl(originalUrl).getId();					//Get the auto-generated ID for the database entry
		urlToAdd.setShortUrl(new Encoder().encode(originalUrl, uniqueId));		//Use the ID as a seed to encode the long URL into a short URL
		urlService.updateUrl(urlToAdd);											//Update the database entry with the short URL
		return new ResponseEntity<Url>(urlToAdd, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{shortString}",method = RequestMethod.GET)
	public void getRedirect(HttpServletResponse httpServletResponse, @PathVariable String shortString) throws IOException {
		httpServletResponse.sendRedirect(urlService.getLong(shortString).getOriginalUrl());
	}	
}
