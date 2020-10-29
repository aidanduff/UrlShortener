package com.aidanduff.urlshortener.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aidanduff.urlshortener.model.Url;
import com.aidanduff.urlshortener.model.UrlResponseObject;
import com.aidanduff.urlshortener.service.UrlService;
import com.aidanduff.urlshortener.util.Decoder;
import com.aidanduff.urlshortener.util.Encoder;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class UrlController {

	@Autowired
	private UrlService urlService;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to skweez.it\n\nAdd your long link as plain text in the body and post it to squeezer\n\n"
				+ "Paste your short link in the address bar after squeezer/ to be redirected to your destination\n\n";
	}

	@PostMapping("/skweez.it")
	public ResponseEntity<UrlResponseObject> addAndEncode(@Validated @RequestBody String originalUrl) {		
		Url urlToAdd = new Url();
		
		if(urlService.getUrl(originalUrl) == null) {
			urlToAdd.setOriginalUrl(originalUrl);
			urlService.addUrl(urlToAdd);
		} else {
			urlToAdd = urlService.getUrl(originalUrl);
		}

		int uniqueId = urlService.getUrl(originalUrl).getId(); // Get the auto-generated ID for the database entry
		String shortenedUrl = new Encoder().encode(uniqueId);
		return new ResponseEntity<>(new UrlResponseObject(originalUrl, shortenedUrl), HttpStatus.CREATED);
	}

	@GetMapping("/skweez.it/{shortString}")
	public void getRedirect(HttpServletResponse httpServletResponse, @PathVariable String shortString)
			throws IOException {
		httpServletResponse.sendRedirect(urlService.getUrlById(new Decoder().decode(shortString)).getOriginalUrl());
	}
}
