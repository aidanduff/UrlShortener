package com.aidanduff.urlshortener.util;

public class Encoder {

	public String encode(int id) {
	
		return "http://localhost:8080/skweez.it/" + convertDecimalToBase62(id);
	}

	public String convertDecimalToBase62(int n) {
		char[] BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			sb.append(BASE62[n % 62]);
			n /= 62;
		}
		return sb.reverse().toString();
	}
}
