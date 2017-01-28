package com.cabreramax.challenge.domains.orientations;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.exceptions.InvalidNumberException;

public class WestOrientation extends Orientation {

	@Override
	public String getOrientationName() {
		return "WEST";
	}

	@Override
	public Position getNextPositionOf(Position position) throws InvalidNumberException {
		position.setX( position.getX() - 1 );
		return position;
	}

	@Override
	public Orientation getLeftOrientation() {
		return new SouthOrientation();
	}

	@Override
	public Orientation getRightOrientation() {
		return new NorthOrientation();
	}

}
