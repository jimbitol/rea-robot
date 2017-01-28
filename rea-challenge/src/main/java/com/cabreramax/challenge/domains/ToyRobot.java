package com.cabreramax.challenge.domains;

import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidNumberException;
import com.cabreramax.challenge.utils.ValidationUtils;

public class ToyRobot {
	
	private Position position;
	private Orientation orientation;

	public boolean isPlaced() {
		return (getPosition() != null) && (getOrientation() != null);
	}

	public void place(Position position, Orientation orientation) {
		
		if ( ValidationUtils.isPositionInsideBounds(position) && 
				ValidationUtils.isValidOrientation(orientation) ) {
			
			setPosition(position);
			setOrientation(orientation);
		}
	}

	public void move() {
		
		if ( isPlaced() ) {
			
			Position nextPosition = null;
			
			try {
				nextPosition = getOrientation().getNextPositionOf( getPosition() );
			} catch (InvalidNumberException e) {
				// TODO
			}
			
			if ( ValidationUtils.isPositionInsideBounds(nextPosition) ) setPosition(nextPosition);
		}
	}

	public void left() {
		
		if ( isPlaced() ) {
			setOrientation(getOrientation().getLeftOrientation());
		}
	}

	public void right() {
		
		if ( isPlaced() ) {
			setOrientation(getOrientation().getRightOrientation());
		}
	}

	public void report() {
		
		if ( isPlaced() ) {
			System.out.println(getPosition().toString() + "," + getOrientation().toString());
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
