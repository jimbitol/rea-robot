package com.cabreramax.challenge.translators;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabreramax.challenge.domains.orientations.*;

public class OrientationsTranslatorTest {

    @Test
    public void testWhenValidNorthInputThenTranslateToNorthOrientation() {
        
        String input = "NORTH";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof NorthOrientation );
    }

    @Test
    public void testWhenValidSouthInputThenTranslateToSouthOrientation() {
        
        String input = "SOUTH";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof SouthOrientation );
    }

    @Test
    public void testWhenValidEastInputThenTranslateToEastOrientation() {
        
        String input = "EAST";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof EastOrientation );
    }

    @Test
    public void testWhenValidWestInputThenTranslateToWestOrientation() {
        
        String input = "WEST";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof WestOrientation );
    }

    @Test
    public void testWhenInvalidInputThenTranslateToInvalidOrientation() {
        
        String input = "SOUTHEAST";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof InvalidOrientation );
    }

    @Test
    public void testWhenValidLowerCaseNorthInputThenTranslateToNorthOrientation() {
        
        String input = "north";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof NorthOrientation );
    }

    @Test
    public void testWhenValidLowerCaseSouthInputThenTranslateToSouthOrientation() {
        
        String input = "south";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof SouthOrientation );
    }

    @Test
    public void testWhenValidLowerCaseEastInputThenTranslateToEastOrientation() {
        
        String input = "east";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof EastOrientation );
    }

    @Test
    public void testWhenValidLowerCaseWestInputThenTranslateToWestOrientation() {
        
        String input = "west";
        
        assertTrue( OrientationsTranslator.getInstance().translate(input) instanceof WestOrientation );
    }
}