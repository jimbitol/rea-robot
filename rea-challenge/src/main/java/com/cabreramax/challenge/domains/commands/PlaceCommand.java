package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.domains.ToyRobot;
import com.cabreramax.challenge.domains.orientations.InvalidOrientation;
import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidOrientationException;
import com.cabreramax.challenge.exceptions.InvalidParameterException;
import com.cabreramax.challenge.factories.OrientationsFactory;

public class PlaceCommand extends Command {
	
	private Position position;
	private Orientation orientation;
	
	@Override
	public void setParams( String[] params ) throws InvalidParameterException {
		
		// assume that the parameters has an order so respecting that is mandatory
		try {

			setPosition(new Position( Integer.parseInt(params[0]) , Integer.parseInt(params[1]) ));
			
			setOrientation( OrientationsFactory.getInstance().getOrientation(params[2]) );
			
		} catch ( Exception e ) {
			throw new InvalidParameterException(e.getMessage());
		}
	}
	
	@Override
	public void execute(ToyRobot robot) {
		robot.place(getPosition(), getOrientation());
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition( Position position ) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation( Orientation orientation ) throws InvalidOrientationException {
		validateOrientation(orientation);
		this.orientation = orientation;
	}
	
	public void validateOrientation( Orientation orientation ) throws InvalidOrientationException {
		if ( orientation instanceof InvalidOrientation ) throw new InvalidOrientationException("Has to be a valid Orientation");
	}


}
