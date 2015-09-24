package com.github.pomona.application.alimento.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface ApresentacaoMedidaAlimentoCommandHandler extends TipoMedidaCommandHandler, TipoApresentacaoCommandHandler, Serializable {
	public CommandResult handle(AtualizarPorcaoApresentacaoMedidaDoAlimentoCommand command);
	public CommandResult handle(CadastrarApresentacaoMedidaDoAlimentoGranelCommand command);
	public CommandResult handle(ExcluirApresentacaoMedidaDoAlimentoGranelCommand command);

}
