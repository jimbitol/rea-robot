package com.cabreramax.challenge.domains;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidNumberException;
import com.cabreramax.challenge.translators.OrientationsTranslator;

public class ToyRobotTest {

	@Test
	public void testWhenValidPlaceRobotThenRobotIsPlacedReturnsTrue() {
        
    	ToyRobot bb8 = new ToyRobot();
    	
    	assertFalse(bb8.isPlaced()); // not placed
    	
    	// Table default (1x1)
    	bb8.place(getPosition(0,0), getOrientation("NORTH"));
    	
    	assertTrue(bb8.isPlaced()); // placed
    }

	@Test
	public void testWhenPlaceOutOfBoundsPositionThenRobotIsPlacedReturnsFalse() {
        
    	ToyRobot bb8 = new ToyRobot();
    	
    	assertFalse(bb8.isPlaced()); // not placed
    	
    	// Table default (1x1)
    	bb8.place(getPosition(10,10), getOrientation("NORTH"));
    	
    	assertFalse(bb8.isPlaced()); // not placed
    }
	
	private Position getPosition(int x, int y) {
		
		Position position = null;
    	
		try { position = new Position(x,y); } catch (InvalidNumberException e) { fail("Should create position succesfully"); }
    	
		return position;
	}
	
	private Orientation getOrientation(String orientation) {
		return OrientationsTranslator.getInstance().translate(orientation);
	}

}
