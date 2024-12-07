package com.foodapp.security;

public class Encrypt {
	
	public static String encrypt(String str) {
		String newStr = "";
		for(int i=0; i<str.length(); i++) {
			newStr += (char)(str.charAt(i)+Secret.getKey());
		}
		return newStr;
	}
}
