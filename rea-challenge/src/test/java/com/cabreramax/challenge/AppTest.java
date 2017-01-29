package com.cabreramax.challenge;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cabreramax.challenge.domains.Table;
import com.cabreramax.challenge.domains.ToyRobot;

public class AppTest {
	
	private final String COMMANDS_INPUT_FILE_PATH = getClass().getResource("/commands_inputs.txt").getPath();
	private final String INVALID_FILE_PATH = "//invalid/file/path.txt";
		
	private ToyRobot bb8;
	private ByteArrayOutputStream printOut = new ByteArrayOutputStream();
	private PrintStream stdout;
	
	@Before
	public void setUp() {
		
    	bb8 = new ToyRobot();
    	
    	initializeTable(5,5);
		
		stdout = System.out;
	    System.setOut(new PrintStream(printOut));
	}

	@After
	public void tearDown() {
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
	
	private void initializeTable(int x, int y) {
		try { 
	    	Table.getInstance().setxUnits(x);
	    	Table.getInstance().setyUnits(y);
		} catch ( Exception e ) {
			fail("Should initialize table with success");
		}
	}
}