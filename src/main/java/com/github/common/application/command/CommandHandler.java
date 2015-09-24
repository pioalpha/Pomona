package com.github.common.application.command;

public interface CommandHandler<T extends Command> {
	CommandResult handle(T command);
}
