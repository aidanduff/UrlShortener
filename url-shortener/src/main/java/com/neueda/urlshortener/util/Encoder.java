package com.neueda.urlshortener.util;

public class Encoder {
	
	public String encode(String longUrl, int id) {
		return  "" + convertDecimalToBase62(id * 100000000);		// multiply by 100000000 to avoid single or two-digit URLs
	}
	
	public String convertDecimalToBase62(int n){
        char[] BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); 
        StringBuilder sb = new StringBuilder();
        
		while(n > 0){
            sb.append(BASE62[n % 62]);
            n /= 62;
        }
//        return sb.reverse().toString();
        return sb.toString();
    }

}
