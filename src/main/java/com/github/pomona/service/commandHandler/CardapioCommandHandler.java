package com.github.pomona.service.commandHandler;

import java.io.Serializable;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.cardapio.AtualizarApresentacaoItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.AtualizarQuantidadeItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.CadastrarItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.ExcluirItemDoCardapioCommand;

public interface CardapioCommandHandler extends Serializable {
	public CommandResult handle(AtualizarApresentacaoItemNoCardapioCommand command);
	public CommandResult handle(AtualizarQuantidadeItemNoCardapioCommand command);
	public CommandResult handle(CadastrarItemNoCardapioCommand command);
	public CommandResult handle(ExcluirItemDoCardapioCommand command);
}
