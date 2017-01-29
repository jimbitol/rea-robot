package com.cabreramax.challenge.factories;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.cabreramax.challenge.domains.commands.*;
import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.domains.orientations.*;
import com.cabreramax.challenge.exceptions.InvalidNumberException;
import com.cabreramax.challenge.factories.CommandsFactory;

public class CommandsFactoryTest {

    @Test
    public void testWhenValidMoveInputThenTranslateToMoveCommand() {
        
        String[] input = {"MOVE"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof MoveCommand );
    }

    @Test
    public void testWhenValidLeftInputThenTranslateToLeftCommand() {
        
    	String[] input = {"LEFT"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof LeftCommand );
    }

    @Test
    public void testWhenValidRightInputThenTranslateToRightCommand() {
        
    	String[] input = {"RIGHT"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof RightCommand );
    }

    @Test
    public void testWhenValidReportInputThenTranslateToReportCommand() {
        
    	String[] input = {"REPORT"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof ReportCommand );
    }

    @Test
    public void testWhenValidPlaceInputThenTranslateToPlaceCommand() {
        
    	String[] input = {"PLACE", "0,0,NORTH"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof PlaceCommand );
    }
    
    @Test
    public void testWhenInvalidInputThenTranslateToInvalidCommand() {
        
    	String[] input = {"JUMP"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof InvalidCommand );
    }

    @Test
    public void testWhenValidPlaceInputThenPlaceCommandHasParameterizedPosition() {
        
    	String[] input = {"PLACE", "0,0,NORTH"};
    	
    	Position placePosition = null;
		
    	try { placePosition = new Position(0,0); } catch (InvalidNumberException e) { fail("Should create position succesfully"); }
    	
    	PlaceCommand placeCommand = (PlaceCommand) CommandsFactory.getInstance().getCommand(input);
    	
        assertEquals( placePosition, placeCommand.getPosition() );
    }

    @Test
    public void testWhenValidPlaceInputThenPlaceCommandHasParameterizedOrientation() {
        
    	String[] input = {"PLACE", "0,0,NORTH"};
    	
    	Orientation placeOrientation = new NorthOrientation();
    	
    	PlaceCommand placeCommand = (PlaceCommand) CommandsFactory.getInstance().getCommand(input);
    	
        assertEquals( placeOrientation, placeCommand.getOrientation() );
    }

    @Test
    public void testWhenNegativePositionPlaceInputThenTranslatesInvalidCommand() {
        
    	String[] input = {"PLACE", "-1,1,NORTH"};
    	
    	assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof InvalidCommand );
    }

    @Test
    public void testWhenInvalidLetterPositionPlaceInputThenTranslatesInvalidCommand() {
        
    	String[] input = {"PLACE", "1,A,NORTH"};
    	
    	assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof InvalidCommand );
    }

    @Test
    public void testWhenInvalidOrientationPlaceInputThenTranslatesInvalidCommand() {
        
    	String[] input = {"PLACE", "2,1,SOUTHWEST"};
    	
    	assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof InvalidCommand );
    }

    @Test
    public void testWhenValidLowerCaseMoveInputThenTranslateToMoveCommand() {
        
        String[] input = {"move"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof MoveCommand );
    }

    @Test
    public void testWhenValidLowerCaseLeftInputThenTranslateToLeftCommand() {
        
    	String[] input = {"left"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof LeftCommand );
    }

    @Test
    public void testWhenValidLowerCaseRightInputThenTranslateToRightCommand() {
        
    	String[] input = {"right"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof RightCommand );
    }

    @Test
    public void testWhenValidLowerCaseReportInputThenTranslateToReportCommand() {
        
    	String[] input = {"report"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof ReportCommand );
    }

    @Test
    public void testWhenValidLowerCasePlaceInputThenTranslateToPlaceCommand() {
        
    	String[] input = {"place", "0,0,NORTH"};
        
        assertTrue( CommandsFactory.getInstance().getCommand(input) instanceof PlaceCommand );
    }
    
    @Test
    public void testWhenInputsListIsProvidedThenTranslateToCommandsList() {
    	
    	List<String[]> inputsReceived = buildInputsList();
    	
    	assertArrayEquals( buildExpectedCommandsList() , CommandsFactory.getInstance().getCommands(inputsReceived).toArray() );
    }
    
    private List<String[]> buildInputsList() {
		
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
    					new String[] {"PLACE", "-1,9,NORTH"},
    					new String[] {"REPORT"},
    					new String[] {"PLACE", "3,4,JOHN"},
    					new String[] {"REPORT"},
    					new String[] {"PLACE", "4,3,EAST"},
    					new String[] {"MOVE"},
    					new String[] {"REPORT"}
    			);
	}
    
    private Command[] buildExpectedCommandsList() {
    	
    	Command[] expectedCommands = {
		    			new MoveCommand(),
						new LeftCommand(),
						new InvalidCommand(),
						new RightCommand(),
						new ReportCommand(),
						new PlaceCommand(),
						new ReportCommand(),
						new MoveCommand(),
						new InvalidCommand(),
						new LeftCommand(),
						new MoveCommand(),
						new LeftCommand(),
						new MoveCommand(),
						new ReportCommand(),
						new InvalidCommand(),
						new ReportCommand(),
						new InvalidCommand(),
						new ReportCommand(),
						new PlaceCommand(),
						new MoveCommand(),
						new ReportCommand()
		    	};
		
		return expectedCommands;
	}
}