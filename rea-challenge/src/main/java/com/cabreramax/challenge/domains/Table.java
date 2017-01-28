package com.cabreramax.challenge.domains;

import com.cabreramax.challenge.exceptions.InvalidNumberException;
import com.cabreramax.challenge.utils.ValidationUtils;

public class Table {

	private int xUnits = 1; // default 1 unit
	
	private int yUnits = 1; // default 1 unit
	
	private static Table instance;
	
	private Table(){}
	
	public static Table getInstance() {
		if ( instance == null ) instance = new Table();
		return instance;
	}

	public int getxUnits() {
		return xUnits;
	}

	public void setxUnits(int xUnits) throws InvalidNumberException {
		ValidationUtils.validatePositive(xUnits);
		this.xUnits = xUnits;
	}

	public int getyUnits() {
		return yUnits;
	}

	public void setyUnits(int yUnits) throws InvalidNumberException {
		ValidationUtils.validatePositive(yUnits);
		this.yUnits = yUnits;
	}

	public boolean isPositionInsideBounds(Position position) {
		return ( position.getX() < getxUnits() ) && ( position.getY() < getyUnits() );
	}

}
