package com.cabreramax.challenge.domains;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cabreramax.challenge.domains.orientations.*;
import com.cabreramax.challenge.exceptions.InvalidNumberException;
import com.cabreramax.challenge.exceptions.InvalidOrientationException;
import com.cabreramax.challenge.exceptions.InvalidPositionException;
import com.cabreramax.challenge.factories.OrientationsFactory;

public class ToyRobotTest {
	
	Robot bb8;
	ByteArrayOutputStream printOut = new ByteArrayOutputStream();
	PrintStream stdout;
	
	@Before
	public void setUp() {
		
    	bb8 = new ToyRobot();
    	
    	Table.getInstance().init(5,5);
    	
    	// configure system out to test prints
		stdout = System.out;
	    System.setOut(new PrintStream(printOut));
	}
	
	@After
	public void tearDown() {
		
		// Rollback stdout
	    System.setOut(stdout);
	}
	
	@Test
	public void testWhenValidPlaceRobotThenRobotIsPlacedReturnsTrue() {
        
    	assertFalse(bb8.isPlaced()); // not placed
    	
    	try { bb8.place(getPosition(0,0), getOrientation("NORTH")); } catch (Exception e) { fail("Should place successfuly"); }
    	
    	assertTrue(bb8.isPlaced()); // placed
    }

	@Test
	public void testWhenPlaceOutOfBoundsPositionThenRobotIsPlacedReturnsFalse() {
        
    	assertFalse(bb8.isPlaced()); // not placed
    	
    	try { 
    		
    		bb8.place(getPosition(10,10), getOrientation("NORTH")); 

    		fail("The robot should not be placed in outbound position"); 
    		
    	} catch (Exception e) { 
    		
    		assertFalse(bb8.isPlaced()); // not placed
    	}
    }

	@Test
	public void testWhenMoveWithoutPlaceThenRobotIgnoreCommand() {
        
    	assertNull(bb8.getPosition()); // because it is not placed
    	
    	bb8.move();
    	
    	assertNull(bb8.getPosition()); // It did not move
    }

	@Test
	public void testWhenLeftWithoutPlaceThenRobotIgnoreCommand() {
        
    	assertNull(bb8.getOrientation()); // because it is not placed
    	
    	bb8.left();
    	
    	assertNull(bb8.getOrientation()); // It did not turn left
    }

	@Test
	public void testWhenRightWithoutPlaceThenRobotIgnoreCommand() {
        
    	assertNull(bb8.getOrientation()); // because it is not placed
    	
    	bb8.right();
    	
    	assertNull(bb8.getOrientation()); // It did not turn right
    }

	@Test
	public void testWhenReportWithoutPlaceThenRobotIgnoreCommand() {
        
		bb8.report();
    	
		assertTrue( printOut.toString().isEmpty() );
    }

	@Test
	public void testWhenMoveNorthInsideBoundsThenRobotHasNewPositionAndSameOrientation() {
        
		try { bb8.place(getPosition(0,0), getOrientation("NORTH")); } catch (Exception e) { fail("Should place successfuly"); }

    	validatePosition(0,0);
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    	
    	bb8.move();

    	validatePosition(0,1);
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    }

	@Test
	public void testWhenMoveWestInsideBoundsThenRobotHasNewPositionAndSameOrientation() {
        
		try { bb8.place(getPosition(1,1), getOrientation("WEST")); } catch (Exception e) { fail("Should place successfuly"); }

    	validatePosition(1,1);
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    	
    	bb8.move();

    	validatePosition(0,1);
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    }

	@Test
	public void testWhenMoveSouthInsideBoundsThenRobotHasNewPositionAndSameOrientation() {
        
		try { bb8.place(getPosition(1,1), getOrientation("SOUTH")); } catch (Exception e) { fail("Should place successfuly"); }

    	validatePosition(1,1);
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    	
    	bb8.move();

    	validatePosition(1,0);
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation  );
    }

	@Test
	public void testWhenMoveEastInsideBoundsThenRobotHasNewPositionAndSameOrientation() {
        
		try { bb8.place(getPosition(1,1), getOrientation("EAST")); } catch (Exception e) { fail("Should place successfuly"); }

    	validatePosition(1,1);
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    	
    	bb8.move();

    	validatePosition(2,1);
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    }

	@Test
	public void testWhenLeftFromNorthThenRobotTurnsToWest() {
        
		try { bb8.place(getPosition(1,1), getOrientation("NORTH")); } catch (Exception e) { fail("Should place successfuly"); }

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    	
    	bb8.left();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    }

	@Test
	public void testWhenLeftFromWestThenRobotTurnsToSouth() {
        
		try { bb8.place(getPosition(1,1), getOrientation("WEST")); } catch (Exception e) { fail("Should place successfuly"); }

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    	
    	bb8.left();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    }

	@Test
	public void testWhenLeftFromSouthThenRobotTurnsToEast() {
        
		try { bb8.place(getPosition(1,1), getOrientation("SOUTH")); } catch (Exception e) { fail("Should place successfuly"); }

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    	
    	bb8.left();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    }

	@Test
	public void testWhenLeftFromEastThenRobotTurnsToNorth() {
        
		try { bb8.place(getPosition(1,1), getOrientation("EAST")); } catch (Exception e) { fail("Should place successfuly"); }

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    	
    	bb8.left();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    }

	@Test
	public void testWhenRightFromWestThenRobotTurnsToNorth() {
        
		try { bb8.place(getPosition(1,1), getOrientation("WEST")); } catch (Exception e) { fail("Should place successfuly"); }

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    	
    	bb8.right();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    }

	@Test
	public void testWhenRightFromNorthThenRobotTurnsToEast() {
        
		try { bb8.place(getPosition(1,1), getOrientation("NORTH")); } catch (Exception e) { fail("Should place successfuly"); }

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    	
    	bb8.right();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    }

	@Test
	public void testWhenRightFromEastThenRobotTurnsToSouth() {
        
		try { bb8.place(getPosition(1,1), getOrientation("EAST")); } catch (Exception e) { fail("Should place successfuly"); }

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    	
    	bb8.right();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    }

	@Test
	public void testWhenRightFromSouthThenRobotTurnsToWest() {
        
		try { bb8.place(getPosition(1,1), getOrientation("SOUTH")); } catch (Exception e) { fail("Should place successfuly"); }

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    	
    	bb8.right();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    }

	@Test
	public void testWhenReportThenPrintOutPositionAndDirection() {
        
		// Expected output
		System.out.println("3,2,SOUTH");
		
		String expectedOutput = printOut.toString();
		
		printOut.reset();
		
		
		// place and report bb8
		try { bb8.place(getPosition(3,2), getOrientation("SOUTH")); } catch (Exception e) { fail("Should place successfuly"); }
		
		bb8.report();
    	
		
		assertEquals( expectedOutput, printOut.toString() );
    }
	
	private void validatePosition( int x, int y ) {
		assertNotNull( bb8.getPosition() );
    	assertEquals(  x, bb8.getPosition().getX() );
    	assertEquals( y, bb8.getPosition().getY() );
	}
	
	private Position getPosition(int x, int y) {
		
		Position position = null;
    	
		try { position = new Position(x,y); } catch (InvalidNumberException e) { fail("Should create position succesfully"); }
    	
		return position;
	}
	
	private Orientation getOrientation(String orientation) {
		return OrientationsFactory.getInstance().getOrientation(orientation);
	}

}
