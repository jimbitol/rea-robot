package com.cabreramax.challenge.translators;

import java.util.HashMap;
import java.util.Map;

import com.cabreramax.challenge.commands.*;

public class CommandsTranslator {
	
	private static CommandsTranslator instance;
	
	private Map<String,Command> dictionary;
	
	
	private CommandsTranslator() {
		initializeDictionary();
	}
	
	public static CommandsTranslator getInstance() {
		if ( instance == null ) instance = new CommandsTranslator();
		return instance;
	}

	private void initializeDictionary() {
		
		Map <String,Command> commandDictionary = new HashMap<String,Command>();

		commandDictionary.put("MOVE", new MoveCommand());
		commandDictionary.put("LEFT", new LeftCommand());
		commandDictionary.put("RIGHT", new RightCommand());
		commandDictionary.put("REPORT", new ReportCommand());
		commandDictionary.put("PLACE", new PlaceCommand());
		
		setDictionary(commandDictionary);
	}
	
	public Command translate(String[] input) {
		
		Command translatedCommand = getDictionary().get(input[0]);
		
		if ( translatedCommand == null ) {
			
			translatedCommand = new InvalidCommand();
		
		} else if ( input.length > 1 ) { // If is valid command and we receive parameters for it, we assign them
			
			translatedCommand.setParams(input[1]);
		}
	
		return translatedCommand;
	}

	public Map<String,Command> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String,Command> dictionary) {
		this.dictionary = dictionary;
	}

}
