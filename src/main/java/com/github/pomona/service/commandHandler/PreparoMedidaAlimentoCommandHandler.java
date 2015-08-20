package com.github.pomona.service.commandHandler;

import java.io.Serializable;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.alimento.AtualizarPorcaoPreparoMedidaDoAlimentoCommand;
import com.github.pomona.application.command.alimento.CadastrarPreparoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirPreparoMedidaDoAlimentoGranelCommand;

public interface PreparoMedidaAlimentoCommandHandler extends TipoMedidaCommandHandler, TipoPreparoCommandHandler, Serializable {
	public CommandResult handle(AtualizarPorcaoPreparoMedidaDoAlimentoCommand command);
	public CommandResult handle(CadastrarPreparoMedidaDoAlimentoGranelCommand command);
	public CommandResult handle(ExcluirPreparoMedidaDoAlimentoGranelCommand command);

}
