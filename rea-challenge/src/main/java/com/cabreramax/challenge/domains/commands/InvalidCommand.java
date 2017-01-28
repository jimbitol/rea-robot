package com.cabreramax.challenge.domains.commands;

public class InvalidCommand extends Command {

	@Override
	public void setParams(String[] params) {
		// Invalid command does not use parameters because it does nothing
	}

}
