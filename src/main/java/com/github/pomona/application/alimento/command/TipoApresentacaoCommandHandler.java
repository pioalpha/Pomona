package com.github.pomona.application.alimento.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface TipoApresentacaoCommandHandler extends Serializable {
	public CommandResult handle(AtualizarNomeDoTipoApresentacaoCommand command);
	public CommandResult handle(CadastrarTipoApresentacaoDoAlimentoGranelCommand command);
	public CommandResult handle(ExcluirTipoApresentacaoDoAlimentoGranelCommand command);
}
