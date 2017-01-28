package com.cabreramax.challenge.domains;

import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.utils.ValidationUtils;

public class ToyRobot {
	
	private Position position;
	private Orientation orientation;

	public boolean isPlaced() {
		return (getPosition() != null) && (getOrientation() != null);
	}

	public void place(Position position, Orientation orientation) {
		
		if ( ValidationUtils.isValidPosition(position) && 
				ValidationUtils.isValidOrientation(orientation) ) {
			
			setPosition(position);
			setOrientation(orientation);
		}
	}

	public Position getPosition() {
		return position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}
