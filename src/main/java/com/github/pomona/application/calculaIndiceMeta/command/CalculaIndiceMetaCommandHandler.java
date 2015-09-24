package com.github.pomona.application.calculaIndiceMeta.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface CalculaIndiceMetaCommandHandler extends Serializable {
	public CommandResult handle(AtualizarClassificacaoIMCCommand command);
	public CommandResult handle(AtualizarFatorAtividadeFisicaCommand command);
	public CommandResult handle(AtualizarFatorMetabolicoCommand command);
	public CommandResult handle(CadastrarClassificacaoIMCCommand command);
	public CommandResult handle(CadastrarFatorAtividadeFisicaCommand command);
	public CommandResult handle(CadastrarFatorMetabolicoCommand command);
}
