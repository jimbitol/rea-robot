package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.domains.ToyRobot;

public class ReportCommand extends Command {

	@Override
	public void setParams(String[] params) {
		// TODO This command does not receive parameters yet
	}

	@Override
	public void execute(ToyRobot robot) {
		robot.report();
	}

}
