package com.cabreramax.challenge.utils;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.domains.Table;
import com.cabreramax.challenge.domains.orientations.InvalidOrientation;
import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidNumberException;

public class ValidationUtils {
	
	public static void validatePositive(int n) throws InvalidNumberException {
		if ( n <= 0 ) throw new InvalidNumberException("Number has to be positive");
	}
	
	public static void validateZeroOrPositive(int n) throws InvalidNumberException {
		if ( n < 0 ) throw new InvalidNumberException("Number has to be zero or positive");
	}
	
	public static boolean isValidPosition ( Position position ) {
		return Table.getInstance().isPositionInsideBounds(position);
	}
	
	public static boolean isValidOrientation ( Orientation orientation ) {
		return !(orientation instanceof InvalidOrientation);
	}
}
