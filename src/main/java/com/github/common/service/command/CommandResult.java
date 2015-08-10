package com.github.common.service.command;

public class CommandResult {
	public boolean succes;
	public String message;
	public String id;
	
	public CommandResult(boolean succes, String message, String id) {
		super();
		this.succes = succes;
		this.message = message;
		this.id = id;
	}
}
