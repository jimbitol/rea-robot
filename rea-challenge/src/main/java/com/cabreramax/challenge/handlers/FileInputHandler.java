package com.cabreramax.challenge.handlers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputHandler {

	public List<String> handleInput( String inputsPath ) throws FileNotFoundException {
			
		List<String> inputsList = new ArrayList<String>();
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			
			br = new BufferedReader( new FileReader( inputsPath ) );
			
            String line;
            
            while ( (line = br.readLine()) != null ) {
            	inputsList.add(line);
            }
            
        } catch (IOException e) {
            
        	throw new FileNotFoundException("Invalid Path");
            
        } finally {
        	
        	try { 
        		
        		if ( br != null ) br.close();
        		if ( fr != null ) fr.close();
        		
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
        }
		
		return inputsList;
	}

}