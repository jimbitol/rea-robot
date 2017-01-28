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
		commandDictionary.put("PLACE", new ReportCommand());
		
		setDictionary(commandDictionary);
	}
	
	public Command translate(String input) {
		return getDictionary().get(input);
	}

	public Map<String,Command> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String,Command> dictionary) {
		this.dictionary = dictionary;
	}

}
