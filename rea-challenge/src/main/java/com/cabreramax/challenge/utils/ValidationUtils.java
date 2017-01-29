package com.cabreramax.challenge.utils;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.domains.Table;
import com.cabreramax.challenge.domains.orientations.InvalidOrientation;
import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidNumberException;
import com.cabreramax.challenge.exceptions.InvalidOrientationException;
import com.cabreramax.challenge.exceptions.InvalidPositionException;

/**
 * Validations in One Place
 */
public class ValidationUtils {
	
	public static void validatePositive(int n) throws InvalidNumberException {
		if ( n <= 0 ) throw new InvalidNumberException("Number has to be positive");
	}
	
	public static void validateZeroOrPositive(int n) throws InvalidNumberException {
		if ( n < 0 ) throw new InvalidNumberException("Number has to be zero or positive");
	}
	
	public static void validateOrientation( Orientation orientation ) throws InvalidOrientationException {
		if ( orientation instanceof InvalidOrientation ) throw new InvalidOrientationException("Has to be a valid Orientation");
	}
	
	public static void validatePosition( Position position ) throws InvalidPositionException {
		if ( !(Table.getInstance().isPositionInsideBounds(position)) ) throw new InvalidPositionException("Position has to be inside Table bounds");
	}
}
