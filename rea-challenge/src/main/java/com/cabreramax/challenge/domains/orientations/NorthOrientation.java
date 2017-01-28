package com.cabreramax.challenge.domains.orientations;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.exceptions.InvalidNumberException;

public class NorthOrientation extends Orientation {
	
	@Override
	public String getOrientationName() {
		return "NORTH";
	}

	@Override
	public Position getNextPositionOf(Position position) throws InvalidNumberException {
		position.setY( position.getY() + 1 );
		return position;
	}

	@Override
	public Orientation getLeftOrientation() {
		return new WestOrientation();
	}

	@Override
	public Orientation getRightOrientation() {
		return new EastOrientation();
	}
}
