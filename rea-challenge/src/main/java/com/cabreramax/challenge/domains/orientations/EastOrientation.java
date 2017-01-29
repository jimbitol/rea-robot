package com.cabreramax.challenge.domains.orientations;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.exceptions.InvalidNumberException;

public class EastOrientation extends Orientation {

	@Override
	public String getOrientationName() {
		return "EAST";
	}

	@Override
	public Position getNextPositionOf(Position position) throws InvalidNumberException {
		return new Position( position.getX() + 1, position.getY() );
	}

	@Override
	public Orientation getLeftOrientation() {
		return new NorthOrientation();
	}

	@Override
	public Orientation getRightOrientation() {
		return new SouthOrientation();
	}

}
