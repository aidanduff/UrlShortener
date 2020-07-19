package com.aidanduff.urlshortener.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Url {
		@Id
		@GeneratedValue
		private int id;
		@Column(name="original_url",columnDefinition="VARCHAR(3200)")
		private String originalUrl;
		private String shortUrl;
		private Instant creationTime;
		
		public Url(String longUrl, String shortUrl) {
			super();
			this.originalUrl = longUrl;
			this.shortUrl = shortUrl;
			this.creationTime = Instant.now();
		}
		
		public Url() {

		}
		
		public int getId() {
			return id;
		}
		
		public String getShortUrl() {
			return shortUrl;
		}

		public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}
		
		public String getOriginalUrl() {
			return originalUrl;
		}
		
		public void setOriginalUrl(String longUrl) {
			this.originalUrl = longUrl;
		}		
}


