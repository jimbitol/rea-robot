package com.cabreramax.challenge.domains;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabreramax.challenge.exceptions.InvalidNumberException;

public class TableTest {

	@Test
    public void testWhenCheckPositionInsideBoundsReturnTrue() {
        
    	Position position = null;
		
    	try { position = new Position(1,1); } catch (InvalidNumberException e) { fail("Should create position succesfully"); }
    	
    	Table.getInstance().init(5, 5);
    	
        assertTrue( Table.getInstance().isPositionInsideBounds( position ) );
    }

    @Test
    public void testWhenCheckPositionInsideBoundsDefaultTableReturnTrue() {
        
    	Position position = null;
		
    	try { position = new Position(0,0); } catch (InvalidNumberException e) { fail("Should create position succesfully"); }    	
    	
        assertTrue( Table.getInstance().isPositionInsideBounds( position ) );
    }

	@Test
    public void testWhenCheckPositionOutsideBoundsReturnFalse() {
        
    	Position position = null;
		
    	try { position = new Position(5,5); } catch (InvalidNumberException e) { fail("Should create position succesfully"); }
    	
    	Table.getInstance().init(5, 5);
    	
        assertFalse( Table.getInstance().isPositionInsideBounds( position ) );
    }
}