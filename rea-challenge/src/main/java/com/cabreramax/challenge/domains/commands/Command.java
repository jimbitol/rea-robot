package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.domains.Robot;
import com.cabreramax.challenge.exceptions.InvalidParameterException;

public abstract class Command {
	
	/**
	 * Assign parameters to command
	 */
	public abstract void setParams(String[] params) throws InvalidParameterException;
	
	/**
	 * Executes command on assigned robot
	 */
	public abstract void execute(Robot robot);
	
	
	// this helps with tests
	public boolean equals( Object obj ) {
		
		return ( obj != null ) && (getClass() == obj.getClass());
	}

}
