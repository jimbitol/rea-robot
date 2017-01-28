package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidParameterException;

public class PlaceCommand implements Command {
	
	private Position placePosition;
	
	@Override
	public void setParams( String[] params ) throws InvalidParameterException {
		
		try {
			
			setPosition(new Position( Integer.parseInt(params[0]), Integer.parseInt(params[1]) ));
			
		} catch ( Exception e ) {
			throw new InvalidParameterException(e.getMessage());
		}
	}

	public Position getPosition() {
		return placePosition;
	}

	public void setPosition( Position position ) {
		this.placePosition = position;
	}

	public Orientation getOrientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
