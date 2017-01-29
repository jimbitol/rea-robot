package com.cabreramax.challenge.domains.orientations;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.exceptions.InvalidNumberException;

public class SouthOrientation extends Orientation {

	@Override
	public String getOrientationName() {
		return "SOUTH";
	}

	@Override
	public Position getNextPositionOf(Position position) throws InvalidNumberException {
		return new Position( position.getX(), position.getY() - 1 );
	}

	@Override
	public Orientation getLeftOrientation() {
		return new EastOrientation();
	}

	@Override
	public Orientation getRightOrientation() {
		return new WestOrientation();
	}

}
