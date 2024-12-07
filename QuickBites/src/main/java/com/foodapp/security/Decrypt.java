package com.foodapp.security;

public class Decrypt {

	public static String dycrypt(String str) {
		String newStr = "";
		for(int i=0; i<str.length(); i++) {
			newStr += (char)(str.charAt(i)-Secret.getKey());
		}
		return newStr;
	}
}
