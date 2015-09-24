package com.github.pomona.application.cardapio.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface CardapioCommandHandler extends Serializable {
	public CommandResult handle(AtualizarApresentacaoItemNoCardapioCommand command);
	public CommandResult handle(AtualizarQuantidadeItemNoCardapioCommand command);
	public CommandResult handle(CadastrarItemNoCardapioCommand command);
	public CommandResult handle(ExcluirItemDoCardapioCommand command);
}
