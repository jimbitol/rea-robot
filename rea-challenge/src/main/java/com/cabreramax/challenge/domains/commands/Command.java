package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.exceptions.InvalidParameterException;

public abstract class Command {

	public abstract void setParams(String[] params) throws InvalidParameterException;
	
	// this helps with tests
	public boolean equals( Object obj ) {
		
		return ( obj != null ) && (getClass() == obj.getClass());
	}

}
