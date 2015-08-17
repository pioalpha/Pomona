package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.cardapio.AtualizarPreparoItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.AtualizarQuantidadeItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.CadastrarItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.ExcluirItemDoCardapioCommand;

public interface CardapioCommandHandler {
	public CommandResult handle(AtualizarPreparoItemNoCardapioCommand command);
	public CommandResult handle(AtualizarQuantidadeItemNoCardapioCommand command);
	public CommandResult handle(CadastrarItemNoCardapioCommand command);
	public CommandResult handle(ExcluirItemDoCardapioCommand command);
}
