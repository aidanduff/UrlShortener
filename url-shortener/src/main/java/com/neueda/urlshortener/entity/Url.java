package com.neueda.urlshortener.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Url {
		@Id
		@GeneratedValue
		private int id;
		private String longUrl;
		private String shortUrl;
		private Instant creationTime;
		
		public Url(String longUrl, String shortUrl) {
			super();
			this.longUrl = longUrl;
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
		
		public String getLongUrl() {
			return longUrl;
		}
		
		public void setLongUrl(String longUrl) {
			this.longUrl = longUrl;
		}		
}


