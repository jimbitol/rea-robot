package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.domains.ToyRobot;

public class InvalidCommand extends Command {

	@Override
	public void setParams(String[] params) {
		// Invalid command does not use parameters because it does nothing
	}

	@Override
	public void execute(ToyRobot robot) {
		// Invalid command does nothing
	}

}
