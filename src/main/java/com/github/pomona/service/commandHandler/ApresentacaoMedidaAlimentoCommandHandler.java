package com.github.pomona.service.commandHandler;

import java.io.Serializable;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.alimento.AtualizarPorcaoApresentacaoMedidaDoAlimentoCommand;
import com.github.pomona.application.command.alimento.CadastrarApresentacaoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirApresentacaoMedidaDoAlimentoGranelCommand;

public interface ApresentacaoMedidaAlimentoCommandHandler extends TipoMedidaCommandHandler, TipoApresentacaoCommandHandler, Serializable {
	public CommandResult handle(AtualizarPorcaoApresentacaoMedidaDoAlimentoCommand command);
	public CommandResult handle(CadastrarApresentacaoMedidaDoAlimentoGranelCommand command);
	public CommandResult handle(ExcluirApresentacaoMedidaDoAlimentoGranelCommand command);

}
