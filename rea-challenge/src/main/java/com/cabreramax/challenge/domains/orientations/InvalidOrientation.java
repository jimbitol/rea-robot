package com.cabreramax.challenge.domains.orientations;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.exceptions.InvalidNumberException;

public class InvalidOrientation extends Orientation {

	@Override
	public String getOrientationName() {
		return "INVALID";
	}

	@Override
	public Position getNextPositionOf(Position position) throws InvalidNumberException {
		return null;
	}

	@Override
	public Orientation getLeftOrientation() {
		return this;
	}

	@Override
	public Orientation getRightOrientation() {
		return this;
	}
}
