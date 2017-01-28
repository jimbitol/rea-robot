package com.cabreramax.challenge.domains;

import com.cabreramax.challenge.exceptions.InvalidNumberException;
import com.cabreramax.challenge.utils.ValidationUtils;

public class Position {

	private int x;
	private int y;

	public Position(int x, int y) throws InvalidNumberException {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) throws InvalidNumberException {
		ValidationUtils.validateZeroOrPositive(x);
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws InvalidNumberException {
		ValidationUtils.validateZeroOrPositive(y);
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

}
