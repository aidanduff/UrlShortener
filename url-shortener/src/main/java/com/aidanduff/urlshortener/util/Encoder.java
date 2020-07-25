package com.aidanduff.urlshortener.util;

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
		return sb.reverse().toString();
	}

	public int convertBase62ToDecimal(String str) {
		int id = 0;
		for (int i = 0; i < str.length(); i++) {
			if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				id = id * 62 + str.charAt(i) - 'a';
			}
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				id = id * 62 + str.charAt(i) - 'A' + 26;
			}
			if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
				id = id * 62 + str.charAt(i) - '0' + 52;
			}
		}
		return id;

	}

}
