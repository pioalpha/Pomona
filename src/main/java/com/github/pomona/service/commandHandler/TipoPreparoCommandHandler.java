package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.alimento.AtualizarNomeDoTipoPreparoCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoPreparoDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirTipoPreparoDoAlimentoGranelCommand;

public interface TipoPreparoCommandHandler {
	public CommandResult handle(AtualizarNomeDoTipoPreparoCommand command);
	public CommandResult handle(CadastrarTipoPreparoDoAlimentoGranelCommand command);
	public CommandResult handle(ExcluirTipoPreparoDoAlimentoGranelCommand command);
}
