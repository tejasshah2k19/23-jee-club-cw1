package com.google.util;

public class Validator {

	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static boolean isAlpha(String str) {
		String alpha = "[a-zA-Z]+";
		return str.matches(alpha);
	}

	public static boolean isValidLength(String str, int minLength) {
		return str.length() >= minLength;
	}
}
