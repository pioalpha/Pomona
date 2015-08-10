package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.alimento.AtualizarNomeDoTipoMedidaCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirTipoMedidaDoAlimentoGranelCommand;

public interface TipoMedidaCommandHandler {
	public CommandResult handle(AtualizarNomeDoTipoMedidaCommand command);
	public CommandResult handle(CadastrarTipoMedidaDoAlimentoGranelCommand command);
	public CommandResult handle(ExcluirTipoMedidaDoAlimentoGranelCommand command);
}
