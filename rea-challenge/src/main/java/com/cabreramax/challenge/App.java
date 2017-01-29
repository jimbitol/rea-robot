package com.cabreramax.challenge;

import java.io.FileNotFoundException;
import java.util.List;

import com.cabreramax.challenge.domains.Table;
import com.cabreramax.challenge.domains.ToyRobot;
import com.cabreramax.challenge.domains.commands.Command;
import com.cabreramax.challenge.factories.CommandsFactory;
import com.cabreramax.challenge.handlers.FileInputHandler;

public class App {
    
    public static void main( String[] args ) {
    	
    	// Initialize Table
    	initializeTable(5,5);
    	
    	// Create bb8
    	ToyRobot bb8 = new ToyRobot();
    	
        // Read command inputs from file
    	FileInputHandler handler = new FileInputHandler();
    	
    	List<String[]> inputs = null;
		
    	try {
		
    		inputs = handler.handleInput(args[0]);
		
    	} catch (FileNotFoundException e) {
			
		}
    	
    	// Execute commands
    	for ( Command command : CommandsFactory.getInstance().getCommands(inputs) ) {
    		command.execute(bb8);
    	}
    }
	
	private static void initializeTable(int x, int y) {
		try { 
	    	Table.getInstance().setxUnits(x);
	    	Table.getInstance().setyUnits(y);
		} catch ( Exception e ) {
			
		}
	}
}
