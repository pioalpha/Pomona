package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarClassificacaoIMCCommand;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarFatorAtividadeFisicaCommand;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarFatorMetabolicoCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarClassificacaoIMCCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarFatorAtividadeFisicaCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarFatorMetabolicoCommand;

public interface CalculaIndiceMetaCommandHandler {
	public CommandResult handle(AtualizarClassificacaoIMCCommand command);
	public CommandResult handle(AtualizarFatorAtividadeFisicaCommand command);
	public CommandResult handle(AtualizarFatorMetabolicoCommand command);
	public CommandResult handle(CadastrarClassificacaoIMCCommand command);
	public CommandResult handle(CadastrarFatorAtividadeFisicaCommand command);
	public CommandResult handle(CadastrarFatorMetabolicoCommand command);
}
