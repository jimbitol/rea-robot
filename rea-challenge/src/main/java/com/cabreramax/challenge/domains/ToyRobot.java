package com.cabreramax.challenge.domains;

import com.cabreramax.challenge.domains.orientations.Orientation;
import com.cabreramax.challenge.exceptions.InvalidOrientationException;
import com.cabreramax.challenge.exceptions.InvalidPositionException;

public class ToyRobot extends Robot {
	
	/**
	 * Only place if position is inside bounds and orientation is valid
	 * @throws InvalidOrientationException 
	 * @throws InvalidPositionException 
	 */
	public void place(Position position, Orientation orientation) throws InvalidOrientationException, InvalidPositionException {
		
		setPosition(position);
		setOrientation(orientation);
	}
	
	/**
	 * Only move if robot is placed and next position is inside bounds
	 */
	public void move() {
		
		if ( isPlaced() ) {
			
			try {
				
				Position nextPosition = getOrientation().getNextPositionOf( getPosition() );
				
				setPosition(nextPosition);
				
			} catch ( Exception e ) {
				System.err.println(e);
			}
		}
	}
	
	/**
	 * Only turns if robot is placed
	 */
	public void left() {
		
		if ( isPlaced() ) {
			try {
				setOrientation(getOrientation().getLeftOrientation());
			} catch (InvalidOrientationException e) {
				System.err.println(e); // it should not fail
			}
		}
	}
	
	/**
	 * Only turns if robot is placed
	 */
	public void right() {
		
		if ( isPlaced() ) {
			try {
				setOrientation(getOrientation().getRightOrientation());
			} catch (InvalidOrientationException e) {
				System.err.println(e); // it should not fail
			}
		}
	}
	
	/**
	 * Only reports if robot is placed
	 */
	public void report() {
		
		if ( isPlaced() ) {
			System.out.println(getPosition().toString() + "," + getOrientation().toString());
		}
	}
}
