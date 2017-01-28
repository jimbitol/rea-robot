package com.cabreramax.challenge.domains;

import com.cabreramax.challenge.exceptions.InvalidPositionException;

public class Position {

	private int x;
	private int y;

	public Position(int x, int y) throws InvalidPositionException {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) throws InvalidPositionException {
		validatePositive(x);
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws InvalidPositionException {
		validatePositive(y);
		this.y = y;
	}
	
	public boolean equals( Object obj ) {
		
		boolean equals = false;
		
		if ( obj != null && (obj instanceof Position) ) {
			
			Position position = (Position) obj;
			
			equals = ( this.getX() == position.getX() ) && ( this.getY() == position.getY() );
		}
		
		return equals;
	}

	private void validatePositive(int n) throws InvalidPositionException {
		if ( n < 0 ) throw new InvalidPositionException("Positions has to be positive");
	}

}
