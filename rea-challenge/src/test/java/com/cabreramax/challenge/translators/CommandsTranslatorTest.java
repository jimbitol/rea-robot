package com.cabreramax.challenge.translators;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabreramax.challenge.domains.commands.*;
import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.domains.orientations.*;
import com.cabreramax.challenge.exceptions.InvalidPositionException;

public class CommandsTranslatorTest {

    @Test
    public void testWhenValidMoveInputThenTranslateToMoveCommand() {
        
        String[] input = {"MOVE"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof MoveCommand );
    }

    @Test
    public void testWhenValidLeftInputThenTranslateToLeftCommand() {
        
    	String[] input = {"LEFT"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof LeftCommand );
    }

    @Test
    public void testWhenValidRightInputThenTranslateToRightCommand() {
        
    	String[] input = {"RIGHT"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof RightCommand );
    }

    @Test
    public void testWhenValidReportInputThenTranslateToReportCommand() {
        
    	String[] input = {"REPORT"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof ReportCommand );
    }

    @Test
    public void testWhenValidPlaceInputThenTranslateToPlaceCommand() {
        
    	String[] input = {"PLACE", "0,0,NORTH"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof PlaceCommand );
    }
    
    @Test
    public void testWhenInvalidInputThenTranslateToInvalidCommand() {
        
    	String[] input = {"JUMP"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof InvalidCommand );
    }

    @Test
    public void testWhenValidPlaceInputThenPlaceCommandHasParameterizedPosition() {
        
    	String[] input = {"PLACE", "0,0,NORTH"};
    	
    	Position placePosition = null;
		
    	try { placePosition = new Position(0,0); } catch (InvalidPositionException e) { fail("Should create position succesfully"); }
    	
    	PlaceCommand placeCommand = (PlaceCommand) CommandsTranslator.getInstance().translate(input);
    	
        assertEquals( placePosition, placeCommand.getPosition() );
    }

    @Test
    public void testWhenValidPlaceInputThenPlaceCommandHasParameterizedOrientation() {
        
    	String[] input = {"PLACE", "0,0,NORTH"};
    	
    	Orientation placeOrientation = new NorthOrientation();
    	
    	PlaceCommand placeCommand = (PlaceCommand) CommandsTranslator.getInstance().translate(input);
    	
        assertEquals( placeOrientation, placeCommand.getOrientation() );
    }

    @Test
    public void testWhenNegativePositionPlaceInputThenTranslatesInvalidCommand() {
        
    	String[] input = {"PLACE", "-1,1,NORTH"};
    	
    	assertTrue( CommandsTranslator.getInstance().translate(input) instanceof InvalidCommand );
    }

    @Test
    public void testWhenInvalidLetterPositionPlaceInputThenTranslatesInvalidCommand() {
        
    	String[] input = {"PLACE", "1,A,NORTH"};
    	
    	assertTrue( CommandsTranslator.getInstance().translate(input) instanceof InvalidCommand );
    }

    @Test
    public void testWhenInvalidOrientationPlaceInputThenTranslatesInvalidCommand() {
        
    	String[] input = {"PLACE", "2,1,SOUTHWEST"};
    	
    	assertTrue( CommandsTranslator.getInstance().translate(input) instanceof InvalidCommand );
    }

    @Test
    public void testWhenValidLowerCaseMoveInputThenTranslateToMoveCommand() {
        
        String[] input = {"move"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof MoveCommand );
    }

    @Test
    public void testWhenValidLowerCaseLeftInputThenTranslateToLeftCommand() {
        
    	String[] input = {"left"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof LeftCommand );
    }

    @Test
    public void testWhenValidLowerCaseRightInputThenTranslateToRightCommand() {
        
    	String[] input = {"right"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof RightCommand );
    }

    @Test
    public void testWhenValidLowerCaseReportInputThenTranslateToReportCommand() {
        
    	String[] input = {"report"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof ReportCommand );
    }

    @Test
    public void testWhenValidLowerCasePlaceInputThenTranslateToPlaceCommand() {
        
    	String[] input = {"place", "0,0,NORTH"};
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof PlaceCommand );
    }
}