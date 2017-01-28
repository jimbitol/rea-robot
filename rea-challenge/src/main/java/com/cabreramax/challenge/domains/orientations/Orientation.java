package com.cabreramax.challenge.domains.orientations;

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

}
