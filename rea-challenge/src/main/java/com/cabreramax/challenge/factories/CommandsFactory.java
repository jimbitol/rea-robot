package com.cabreramax.challenge.factories;

import java.util.ArrayList;
import java.util.List;

import com.cabreramax.challenge.domains.commands.*;
import com.cabreramax.challenge.exceptions.InvalidParameterException;
import com.cabreramax.challenge.utils.ParseUtils;

public class CommandsFactory {
	
	private static CommandsFactory instance;
	
	private CommandsFactory() { }
	
	public static CommandsFactory getInstance() {
		if ( instance == null ) instance = new CommandsFactory();
		return instance;
	}

	private Command getCommand(String input) {
		
		Command command = null;
		
		if ( "MOVE".equals(input.toUpperCase()) ) {
			command = new MoveCommand();
		} else if ( "LEFT".equals(input.toUpperCase()) ) {
			command = new LeftCommand();
		} else if ( "RIGHT".equals(input.toUpperCase()) ) {
			command = new RightCommand();
		} else if ( "REPORT".equals(input.toUpperCase()) ) {
			command = new ReportCommand();
		} else if ( "PLACE".equals(input.toUpperCase()) ) {
			command = new PlaceCommand();
		} else {
			command = new InvalidCommand();
		}
		
		return command;
	}
	
	public Command getCommand(String[] input) {
		
		Command command = getCommand(input[0]);
		
		if ( input.length > 1 ) { // If we receive parameters for the command, we assign them
			
			try {
				
				command.setParams( input[1].split(ParseUtils.INNER_PARAMETERS_SEPARATOR) );
			
			} catch (InvalidParameterException e) {
				command = new InvalidCommand();
			}
		}
	
		return command;
	}

	public List<Command> getCommands( List<String[]> inputs ) {
		
		List<Command> translatedCommands = new ArrayList<Command>();
		
		for ( String[] input : inputs ){
			Command command = getCommand(input);
			translatedCommands.add(command);
		}
		
		return translatedCommands;
	}

}
