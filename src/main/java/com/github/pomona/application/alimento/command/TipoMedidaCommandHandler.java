package com.github.pomona.application.alimento.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface TipoMedidaCommandHandler extends Serializable {
	public CommandResult handle(AtualizarNomeDoTipoMedidaCommand command);
	public CommandResult handle(CadastrarTipoMedidaDoAlimentoGranelCommand command);
	public CommandResult handle(ExcluirTipoMedidaDoAlimentoGranelCommand command);
}
