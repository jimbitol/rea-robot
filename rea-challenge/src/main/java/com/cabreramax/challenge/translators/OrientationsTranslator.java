package com.cabreramax.challenge.translators;

import java.util.HashMap;
import java.util.Map;

import com.cabreramax.challenge.domains.orientations.*;

public class OrientationsTranslator {
	
	private static OrientationsTranslator instance;
	
	private Map<String,Orientation> dictionary;
	
	
	private OrientationsTranslator() {
		initializeDictionary();
	}
	
	public static OrientationsTranslator getInstance() {
		if ( instance == null ) instance = new OrientationsTranslator();
		return instance;
	}

	private void initializeDictionary() {
		
		Map <String,Orientation> orientationDictionary = new HashMap<String,Orientation>();

		orientationDictionary.put("NORTH", new NorthOrientation());
		orientationDictionary.put("SOUTH", new SouthOrientation());
		orientationDictionary.put("EAST", new EastOrientation());
		orientationDictionary.put("WEST", new WestOrientation());
		
		setDictionary(orientationDictionary);
	}
	
	public Orientation translate(String input) {
		
		Orientation translatedOrientation = getDictionary().get(input.toUpperCase());
		
		if ( translatedOrientation == null ) translatedOrientation = new InvalidOrientation();
	
		return translatedOrientation;
	}

	public Map<String,Orientation> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String,Orientation> dictionary) {
		this.dictionary = dictionary;
	}
}
