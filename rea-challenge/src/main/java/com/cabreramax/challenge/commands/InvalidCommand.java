package com.cabreramax.challenge.commands;

public class InvalidCommand implements Command {

	@Override
	public void setParams(String[] params) {
		// Invalid command does not use parameters because it does nothing
	}

}
