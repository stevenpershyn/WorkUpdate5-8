package com.quintrix.java.customer;

import java.util.List;

public class Validations {

	public static void main(String[] args) {
		
	}
	
	public static boolean validateEmail(String email) {
		
		if(email.contains("@")) {
			return true;
		}
		return false;
	}
	
	public static boolean validList(List <String> strList) {
		
		return false;
	}
}
