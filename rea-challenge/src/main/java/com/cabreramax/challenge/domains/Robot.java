package com.cabreramax.challenge.domains;

import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidOrientationException;
import com.cabreramax.challenge.exceptions.InvalidPositionException;
import com.cabreramax.challenge.utils.ValidationUtils;

/**
 * Could extends various types of robots that moves, turns or do things differently
 */
public abstract class Robot {
	
	private Position position;
	private Orientation orientation;

	public boolean isPlaced() {
		return (getPosition() != null) && (getOrientation() != null);
	}

	public Position getPosition() {
		return position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setPosition(Position position) throws InvalidPositionException {
		ValidationUtils.validatePosition(position);
		this.position = position;
	}

	public void setOrientation(Orientation orientation) throws InvalidOrientationException {
		ValidationUtils.validateOrientation(orientation);
		this.orientation = orientation;
	}

	public abstract void place(Position position, Orientation orientation) throws InvalidOrientationException, InvalidPositionException;

	public abstract void move();

	public abstract void left();

	public abstract void right();

	public abstract void report();

}
