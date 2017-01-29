package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.domains.Robot;
import com.cabreramax.challenge.domains.orientations.InvalidOrientation;
import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidOrientationException;
import com.cabreramax.challenge.exceptions.InvalidParameterException;
import com.cabreramax.challenge.exceptions.InvalidPositionException;
import com.cabreramax.challenge.factories.OrientationsFactory;
import com.cabreramax.challenge.utils.ValidationUtils;

/**
 * Place needs a position and orientation
 */
public class PlaceCommand extends Command {
	
	private Position position;
	private Orientation orientation;
	
	
	@Override
	public void setParams( String[] params ) throws InvalidParameterException {
		
		try {
			
			// assuming that the parameters has an order so respecting that is mandatory to be a valid command
			
			setPosition(new Position( Integer.parseInt(params[0]) , Integer.parseInt(params[1]) ));
			
			setOrientation( OrientationsFactory.getInstance().getOrientation(params[2]) );
			
		} catch ( Exception e ) {
			throw new InvalidParameterException(e.getMessage());
		}
	}
	
	@Override
	public void execute(Robot robot) {
		
		try {
			
			robot.place(getPosition(), getOrientation());
			
		} catch (Exception e) {
			System.err.println(e); // it should not fail
		}
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition( Position position ) throws InvalidPositionException {
		ValidationUtils.validatePosition(position);
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation( Orientation orientation ) throws InvalidOrientationException {
		
		ValidationUtils.validateOrientation(orientation);
		this.orientation = orientation;
	}
}
