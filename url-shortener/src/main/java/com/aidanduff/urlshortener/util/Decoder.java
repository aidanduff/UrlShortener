package com.aidanduff.urlshortener.util;

public class Decoder {
	
	public int decode(String str) {
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
