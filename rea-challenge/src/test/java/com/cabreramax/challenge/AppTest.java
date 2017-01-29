package com.cabreramax.challenge;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cabreramax.challenge.domains.Table;
import com.cabreramax.challenge.domains.Robot;
import com.cabreramax.challenge.domains.ToyRobot;

public class AppTest {
	
	final String COMMANDS_INPUT_FILE_PATH = getClass().getResource("/commands_inputs.txt").getPath();
	final String INVALID_FILE_PATH = "//invalid/file/path.txt";
	final String STRAIGHT_COMMANDS_INPUT_FILE_PATH = getClass().getResource("/straight_commands_inputs.txt").getPath();
	final String SQUARE_RALLY_COMMANDS_INPUT_FILE_PATH = getClass().getResource("/square_rally_commands_inputs.txt").getPath();
	final String RESPAWN_COMMANDS_INPUT_FILE_PATH = getClass().getResource("/respawn_commands_inputs.txt").getPath();
		
	Robot bb8;
	ByteArrayOutputStream printOut = new ByteArrayOutputStream();
	PrintStream stdout;
	
	@Before
	public void setUp() {
		
    	bb8 = new ToyRobot();
    	
    	Table.getInstance().init(5,5);
		
    	// Configure to test prints
		stdout = System.out;
	    System.setOut(new PrintStream(printOut));
	}

	@After
	public void tearDown() {
		
		// Rollback stdout
	    System.setOut(stdout);
	}
	
	@Test
	public void testWhenAppIsCalledWithCommandsFilePathThenExecuteThem() {

		System.out.println("0,0,NORTH");
		System.out.println("0,0,SOUTH");
		System.out.println("0,0,SOUTH");
		System.out.println("0,0,SOUTH");
		System.out.println("4,3,EAST");
		
		String expectedOutput = printOut.toString();
		
		printOut.reset();
		
		String[] args = { COMMANDS_INPUT_FILE_PATH };
		
		App.main( args );
		
		assertEquals( expectedOutput, printOut.toString() );
	}
	
	@Test
	public void testWhenAppIsCalledWithInvalidFilePathThenDoNothing() {
		
		String[] args = { INVALID_FILE_PATH };
		
		App.main( args );
		
		assertTrue( printOut.toString().isEmpty() );
	}
	
	@Test
	public void testWhenRobotCommandsGoStraightThenRobotDoNotFallOffTheTable() {

		System.out.println("0,0,NORTH");
		System.out.println("0,1,NORTH");
		System.out.println("0,2,NORTH");
		System.out.println("0,3,NORTH");
		System.out.println("0,4,NORTH");
		System.out.println("0,4,NORTH");
		System.out.println("0,4,NORTH");
		
		String expectedOutput = printOut.toString();
		
		printOut.reset();
		
		String[] args = { STRAIGHT_COMMANDS_INPUT_FILE_PATH };
		
		App.main( args );
		
		assertEquals( expectedOutput, printOut.toString() );
	}
	
	@Test
	public void testWhenRobotMakesRallyOnTableThenRobotWillNotFall() {

		System.out.println("0,0,EAST"); // Start rally to east
		System.out.println("1,0,EAST");
		System.out.println("2,0,EAST");
		System.out.println("3,0,EAST");
		System.out.println("4,0,EAST");
		System.out.println("4,0,EAST"); // Reach border, can not go further
		System.out.println("4,0,EAST"); // Is in border, can not go further
		System.out.println("4,0,NORTH"); // Turns left to continue
		System.out.println("4,1,NORTH");
		System.out.println("4,2,NORTH");
		System.out.println("4,3,NORTH");
		System.out.println("4,4,NORTH");
		System.out.println("4,4,NORTH"); // Reach border, could not go on
		System.out.println("4,4,NORTH"); // Is in border, could not go on
		System.out.println("4,4,EAST"); // Turn right to go on
		System.out.println("4,4,EAST"); // Is a border too, can not go further
		System.out.println("4,4,NORTH"); // In desperation the robot turns left to find a way out
		System.out.println("4,4,NORTH"); // It is still trapped!
		System.out.println("4,4,NORTH"); // What the robot could do?
		System.out.println("4,4,WEST"); // Turn left again
		System.out.println("3,4,WEST"); // Robot found a way out
		System.out.println("2,4,WEST");
		System.out.println("1,4,WEST");
		System.out.println("0,4,WEST");
		System.out.println("0,4,WEST"); // Robot reached the edge again
		System.out.println("0,4,WEST"); // It is really an edge
		System.out.println("0,4,SOUTH"); // Turns left to go back and charge battery
		System.out.println("0,3,SOUTH");
		System.out.println("0,2,SOUTH");
		System.out.println("0,1,SOUTH");
		System.out.println("0,0,SOUTH"); // After an exhaustive day the robot recharges
		
		String expectedOutput = printOut.toString();
		
		printOut.reset();
		
		String[] args = { SQUARE_RALLY_COMMANDS_INPUT_FILE_PATH };
		
		App.main( args );
		
		assertEquals( expectedOutput, printOut.toString() );
	}
	
	@Test
	public void testWhenRobotReachEdgeThenReplaceWithCommandAndRobotWillNotFall() {

		System.out.println("0,0,NORTH"); // Start race
		System.out.println("0,1,NORTH");
		System.out.println("0,2,NORTH");
		System.out.println("0,2,EAST"); // Turns right
		System.out.println("1,2,EAST"); // Go straight to edge
		System.out.println("2,2,EAST"); 
		System.out.println("3,2,EAST");
		System.out.println("4,2,EAST"); // Robot has reached the edge, it seems it is about to crash
		System.out.println("0,2,EAST"); // Wow, the robot seems to has founded a secret respawning door
		System.out.println("1,2,EAST"); // Goes again
		System.out.println("2,2,EAST"); 
		System.out.println("3,2,EAST");
		System.out.println("4,2,EAST");
		System.out.println("0,2,EAST"); // The robot was respawned again
		System.out.println("1,2,EAST");
		System.out.println("2,2,EAST"); 
		System.out.println("3,2,EAST");
		System.out.println("4,2,EAST");
		System.out.println("0,2,EAST"); // Ok, the robot needs to recharge
		System.out.println("0,2,SOUTH");
		System.out.println("0,1,SOUTH");
		System.out.println("0,0,SOUTH"); // After an exhaustive day the robot recharges
		
		String expectedOutput = printOut.toString();
		
		printOut.reset();
		
		String[] args = { RESPAWN_COMMANDS_INPUT_FILE_PATH };
		
		App.main( args );
		
		assertEquals( expectedOutput, printOut.toString() );
	}
}