package com.neueda.urlshortener.util;

public class Encoder {

	public String encode(String longUrl, int id) {

		return "" + convertDecimalToBase62(id * 3844); // multiply by 3844 to make the URL three digits or longer
	}

	public String convertDecimalToBase62(int n) {
		char[] BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			sb.append(BASE62[n % 62]);
			n /= 62;
		}
		return sb.toString();
	}

}
