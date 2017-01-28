package com.cabreramax.challenge.translators;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabreramax.challenge.commands.InvalidCommand;
import com.cabreramax.challenge.commands.LeftCommand;
import com.cabreramax.challenge.commands.MoveCommand;
import com.cabreramax.challenge.commands.PlaceCommand;
import com.cabreramax.challenge.commands.ReportCommand;
import com.cabreramax.challenge.commands.RightCommand;
import com.cabreramax.challenge.domains.Position;

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
    	
    	Position placePosition = new Position(0,0);
    	
    	PlaceCommand placeCommand = (PlaceCommand) CommandsTranslator.getInstance().translate(input);
    	
        assertEquals( placePosition, placeCommand.getPosition() );
    }
}