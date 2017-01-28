package com.cabreramax.challenge.domains;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cabreramax.challenge.domains.orientations.*;
import com.cabreramax.challenge.exceptions.InvalidNumberException;
import com.cabreramax.challenge.translators.OrientationsTranslator;

public class ToyRobotTest {
	
	ToyRobot bb8;
	ByteArrayOutputStream printOut = new ByteArrayOutputStream();
	PrintStream stdout;
	
	@Before
	public void setUp() {
		
    	bb8 = new ToyRobot();
    	
    	initializeTable(5,5);
    	
    	// configure system out to test print
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
    	
    	bb8.place(getPosition(0,0), getOrientation("NORTH"));
    	
    	assertTrue(bb8.isPlaced()); // placed
    }

	@Test
	public void testWhenPlaceOutOfBoundsPositionThenRobotIsPlacedReturnsFalse() {
        
    	assertFalse(bb8.isPlaced()); // not placed
    	
    	bb8.place(getPosition(10,10), getOrientation("NORTH"));
    	
    	assertFalse(bb8.isPlaced()); // not placed
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
        
    	bb8.place(getPosition(0,0), getOrientation("NORTH"));

    	assertNotNull( bb8.getPosition() );
    	assertEquals(  0, bb8.getPosition().getX() );
    	assertEquals( 0, bb8.getPosition().getY() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    	
    	bb8.move();

    	assertNotNull( bb8.getPosition() );
    	assertEquals(  0, bb8.getPosition().getX() );
    	assertEquals( 1, bb8.getPosition().getY() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    }

	@Test
	public void testWhenMoveWestInsideBoundsThenRobotHasNewPositionAndSameOrientation() {
        
    	bb8.place(getPosition(1,1), getOrientation("WEST"));

    	assertNotNull( bb8.getPosition() );
    	assertEquals(  1, bb8.getPosition().getX() );
    	assertEquals( 1, bb8.getPosition().getY() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    	
    	bb8.move();

    	assertNotNull( bb8.getPosition() );
    	assertEquals(  0, bb8.getPosition().getX() );
    	assertEquals( 1, bb8.getPosition().getY() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    }

	@Test
	public void testWhenMoveSouthInsideBoundsThenRobotHasNewPositionAndSameOrientation() {
        
    	bb8.place(getPosition(1,1), getOrientation("SOUTH"));

    	assertNotNull( bb8.getPosition() );
    	assertEquals(  1, bb8.getPosition().getX() );
    	assertEquals( 1, bb8.getPosition().getY() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    	
    	bb8.move();

    	assertNotNull( bb8.getPosition() );
    	assertEquals(  1, bb8.getPosition().getX() );
    	assertEquals( 0, bb8.getPosition().getY() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation  );
    }

	@Test
	public void testWhenMoveEastInsideBoundsThenRobotHasNewPositionAndSameOrientation() {
        
    	bb8.place(getPosition(1,1), getOrientation("EAST"));

    	assertNotNull( bb8.getPosition() );
    	assertEquals(  1, bb8.getPosition().getX() );
    	assertEquals( 1, bb8.getPosition().getY() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    	
    	bb8.move();

    	assertNotNull( bb8.getPosition() );
    	assertEquals(  2, bb8.getPosition().getX() );
    	assertEquals( 1, bb8.getPosition().getY() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    }

	@Test
	public void testWhenLeftFromNorthThenRobotTurnsToWest() {
        
    	bb8.place(getPosition(1,1), getOrientation("NORTH"));

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    	
    	bb8.left();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    }

	@Test
	public void testWhenLeftFromWestThenRobotTurnsToSouth() {
        
    	bb8.place(getPosition(1,1), getOrientation("WEST"));

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    	
    	bb8.left();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    }

	@Test
	public void testWhenLeftFromSouthThenRobotTurnsToEast() {
        
    	bb8.place(getPosition(1,1), getOrientation("SOUTH"));

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    	
    	bb8.left();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    }

	@Test
	public void testWhenLeftFromEastThenRobotTurnsToNorth() {
        
    	bb8.place(getPosition(1,1), getOrientation("EAST"));

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    	
    	bb8.left();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    }

	@Test
	public void testWhenRightFromWestThenRobotTurnsToNorth() {
        
    	bb8.place(getPosition(1,1), getOrientation("WEST"));

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof WestOrientation );
    	
    	bb8.right();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    }

	@Test
	public void testWhenRightFromNorthThenRobotTurnsToEast() {
        
    	bb8.place(getPosition(1,1), getOrientation("NORTH"));

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof NorthOrientation );
    	
    	bb8.right();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    }

	@Test
	public void testWhenRightFromEastThenRobotTurnsToSouth() {
        
    	bb8.place(getPosition(1,1), getOrientation("EAST"));

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof EastOrientation );
    	
    	bb8.right();

    	assertNotNull( bb8.getOrientation() );
    	assertTrue( bb8.getOrientation() instanceof SouthOrientation );
    }

	@Test
	public void testWhenRightFromSouthThenRobotTurnsToWest() {
        
    	bb8.place(getPosition(1,1), getOrientation("SOUTH"));

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
    	bb8.place(getPosition(3,2), getOrientation("SOUTH"));
		
		bb8.report();
    	
		
		assertEquals( expectedOutput, printOut.toString() );
    }
	
	private Position getPosition(int x, int y) {
		
		Position position = null;
    	
		try { position = new Position(x,y); } catch (InvalidNumberException e) { fail("Should create position succesfully"); }
    	
		return position;
	}
	
	private Orientation getOrientation(String orientation) {
		return OrientationsTranslator.getInstance().translate(orientation);
	}
	
	private void initializeTable(int x, int y) {
		try { 
	    	Table.getInstance().setxUnits(x);
	    	Table.getInstance().setyUnits(y);
		} catch ( Exception e ) {
			fail("Should initialize table with success");
		}
	}

}
