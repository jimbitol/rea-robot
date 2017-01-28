package com.cabreramax.challenge.translators;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabreramax.challenge.domains.commands.*;
import com.cabreramax.challenge.domains.Position;
import com.cabreramax.challenge.domains.orientations.*;
import com.cabreramax.challenge.exceptions.InvalidPositionException;
import com.cabreramax.challenge.orientations.SouthOrientation;

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
}