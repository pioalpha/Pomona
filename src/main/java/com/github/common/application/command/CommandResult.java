package com.github.common.application.command;

public class CommandResult {
	public boolean success;
	public String message;
	public String id;
	
	public CommandResult(boolean success, String message, String id) {
		super();
		
		this.success = success;
		this.message = message;
		this.id = id;
	}
}
