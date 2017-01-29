package com.cabreramax.challenge;

import java.util.List;

import com.cabreramax.challenge.domains.*;
import com.cabreramax.challenge.domains.commands.Command;
import com.cabreramax.challenge.factories.CommandsFactory;
import com.cabreramax.challenge.handlers.FileInputHandler;

public class App {

    public static void main( String[] args ) {
    	
    	// Initialize Table
    	Table.getInstance().init(5,5);
    	
    	// Create bb8
    	Robot bb8 = new ToyRobot();
    	
    	FileInputHandler handler = new FileInputHandler();
    	
    	try {
    		
        	// Read command inputs from file
    		List<String[]> inputs = handler.handleInput(args);
		
    		
	    	// Execute commands
	    	for ( Command command : CommandsFactory.getInstance().getCommands(inputs) ) {
	    		command.execute(bb8);
	    	}
    	
    	} catch (Exception e) {
    		System.err.println(e); // Or we could use log4j
		}
    }
}
