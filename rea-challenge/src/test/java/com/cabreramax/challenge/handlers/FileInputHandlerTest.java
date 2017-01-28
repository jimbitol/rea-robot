package com.cabreramax.challenge.handlers;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FileInputHandlerTest {

	private final String COMMANDS_INPUT_FILE_PATH = getClass().getResource("/commands_inputs.txt").getPath();

    @Test
    public void testWhenValidFileProvidedThenReadWithoutException() {
        
        try {
        	
        	(new FileInputHandler()).handleInput(COMMANDS_INPUT_FILE_PATH);

        	assertTrue( true );
        
        } catch ( Exception e ) {
        	fail("Should read File");
        }
    }

    @Test
    public void testWhenValidFileProvidedThenReturnArrayWithStringInputs() {
        
        try {
        	
        	List<String[]> inputsListExpected = buildInputListExpected();
        	
        	assertArrayEquals( inputsListExpected.toArray(), (new FileInputHandler()).handleInput(COMMANDS_INPUT_FILE_PATH).toArray() );
        
        } catch ( Exception e ) {
        	fail("Should read File");
        }
    }

	@Test
    public void testWhenInvalidFileProvidedThenThrowException() {
        
        try {
        	
        	(new FileInputHandler()).handleInput("//invalid/file/path");

        	fail("Should not read File");
        
        } catch ( Exception e ) {
        	
        	assertEquals(e.getMessage(), "Invalid Path");	
        }
    }
    
    private List<String[]> buildInputListExpected() {
		
		return Arrays.asList(
    					new String[] {"MOVE"},
    					new String[] {"LEFT"},
    					new String[] {"JOE"},
    					new String[] {"RIGHT"},
    					new String[] {"REPORT"},
    					new String[] {"PLACE", "0,0,NORTH"},
    					new String[] {"REPORT"},
    					new String[] {"MOVE"},
    					new String[] {"LOL"},
    					new String[] {"LEFT"},
    					new String[] {"MOVE"},
    					new String[] {"LEFT"},
    					new String[] {"MOVE"},
    					new String[] {"REPORT"},
    					new String[] {"PLACE", "10,9,NORTH"},
    					new String[] {"REPORT"},
    					new String[] {"PLACE", "3,4,JOHN"},
    					new String[] {"REPORT"},
    					new String[] {"PLACE", "4,3,EAST"},
    					new String[] {"MOVE"},
    					new String[] {"REPORT"}
    			);
	}
}