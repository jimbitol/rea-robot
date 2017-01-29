package com.cabreramax.challenge.factories;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabreramax.challenge.domains.orientations.*;
import com.cabreramax.challenge.factories.OrientationsFactory;

public class OrientationsFactoryTest {

    @Test
    public void testWhenValidNorthInputThenTranslateToNorthOrientation() {
        
        String input = "NORTH";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof NorthOrientation );
    }

    @Test
    public void testWhenValidSouthInputThenTranslateToSouthOrientation() {
        
        String input = "SOUTH";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof SouthOrientation );
    }

    @Test
    public void testWhenValidEastInputThenTranslateToEastOrientation() {
        
        String input = "EAST";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof EastOrientation );
    }

    @Test
    public void testWhenValidWestInputThenTranslateToWestOrientation() {
        
        String input = "WEST";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof WestOrientation );
    }

    @Test
    public void testWhenInvalidInputThenTranslateToInvalidOrientation() {
        
        String input = "SOUTHEAST";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof InvalidOrientation );
    }

    @Test
    public void testWhenValidLowerCaseNorthInputThenTranslateToNorthOrientation() {
        
        String input = "north";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof NorthOrientation );
    }

    @Test
    public void testWhenValidLowerCaseSouthInputThenTranslateToSouthOrientation() {
        
        String input = "south";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof SouthOrientation );
    }

    @Test
    public void testWhenValidLowerCaseEastInputThenTranslateToEastOrientation() {
        
        String input = "east";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof EastOrientation );
    }

    @Test
    public void testWhenValidLowerCaseWestInputThenTranslateToWestOrientation() {
        
        String input = "west";
        
        assertTrue( OrientationsFactory.getInstance().getOrientation(input) instanceof WestOrientation );
    }
}