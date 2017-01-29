package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.domains.Robot;

public class RightCommand extends Command {

	@Override
	public void setParams(String[] params) {
		// TODO This command does not receive parameters yet
	}

	@Override
	public void execute(Robot robot) {
		robot.right();
	}

}
