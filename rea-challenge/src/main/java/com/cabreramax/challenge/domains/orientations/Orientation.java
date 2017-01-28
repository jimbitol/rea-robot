package com.cabreramax.challenge.domains.orientations;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.exceptions.InvalidNumberException;

public abstract class Orientation {
	
	public String toString() {
		return getOrientationName();
	}
	
	public boolean equals( Object obj ) {
		
		boolean equals = false;
		
		if ( obj != null && (obj instanceof Orientation) ) {
			
			equals = this.toString().equals(obj.toString());
		}
		
		return equals;
	}

	public abstract String getOrientationName();

	public abstract Position getNextPositionOf(Position position) throws InvalidNumberException;

	public abstract Orientation getLeftOrientation();

	public abstract Orientation getRightOrientation();

}
