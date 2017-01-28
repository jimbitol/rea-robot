package com.cabreramax.challenge.utils;

import com.cabreramax.challenge.exceptions.InvalidNumberException;

public class ValidationUtils {
	
	public static void validatePositive(int n) throws InvalidNumberException {
		if ( n <= 0 ) throw new InvalidNumberException("Number has to be positive");
	}
	
	public static void validateZeroOrPositive(int n) throws InvalidNumberException {
		if ( n < 0 ) throw new InvalidNumberException("Number has to be zero or positive");
	}
}
