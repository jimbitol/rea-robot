package com.cabreramax.challenge.domains.commands;

import com.cabreramax.challenge.exceptions.InvalidParameterException;

public interface Command {

	void setParams(String[] params) throws InvalidParameterException;

}
