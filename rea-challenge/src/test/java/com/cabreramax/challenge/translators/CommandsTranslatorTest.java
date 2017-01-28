package com.cabreramax.challenge.translators;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabreramax.challenge.commands.LeftCommand;
import com.cabreramax.challenge.commands.MoveCommand;

public class CommandsTranslatorTest {

    @Test
    public void testWhenValidMoveInputThenTranslateToMoveCommand() {
        
        String input = "MOVE";
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof MoveCommand );
    }

    @Test
    public void testWhenValidLeftInputThenTranslateToLeftCommand() {
        
        String input = "LEFT";
        
        assertTrue( CommandsTranslator.getInstance().translate(input) instanceof LeftCommand );
    }
}