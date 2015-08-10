package com.github.common.service.commandHandler;

import com.github.common.service.command.Command;
import com.github.common.service.command.CommandResult;

public interface CommandHandler<T extends Command> {
	CommandResult handle(T command);
}
