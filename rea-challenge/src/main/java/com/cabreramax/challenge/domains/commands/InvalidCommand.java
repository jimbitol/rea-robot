package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.domains.Robot;

/**
 * Default command does nothing
 */
public class InvalidCommand extends Command {

	@Override
	public void setParams(String[] params) {
		// Invalid command does not use parameters because it does nothing
	}

	@Override
	public void execute(Robot robot) {
		// Invalid command does nothing
	}

}
