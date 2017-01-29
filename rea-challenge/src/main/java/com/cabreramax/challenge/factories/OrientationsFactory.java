package com.cabreramax.challenge.factories;

import com.cabreramax.challenge.domains.orientations.*;

public class OrientationsFactory {
	
	private static OrientationsFactory instance;
	
	private OrientationsFactory() { }
	
	public static OrientationsFactory getInstance() {
		if ( instance == null ) instance = new OrientationsFactory();
		return instance;
	}
	
	public Orientation getOrientation(String input) {
		
		Orientation orientation = null;
		
		if ( "NORTH".equals(input.toUpperCase()) ) {
			orientation = new NorthOrientation();
		} else if ( "SOUTH".equals(input.toUpperCase()) ) {
			orientation = new SouthOrientation();
		} else if ( "EAST".equals(input.toUpperCase()) ) {
			orientation = new EastOrientation();
		} else if ( "WEST".equals(input.toUpperCase()) ) {
			orientation = new WestOrientation();
		} else {
			orientation = new InvalidOrientation();
		}
		
		return orientation;
	}
}
