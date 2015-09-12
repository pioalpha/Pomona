package com.github.pomona.service.commandHandler;

import java.io.Serializable;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.alimento.AtualizarNomeDoTipoApresentacaoCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoApresentacaoDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirTipoApresentacaoDoAlimentoGranelCommand;

public interface TipoApresentacaoCommandHandler extends Serializable {
	public CommandResult handle(AtualizarNomeDoTipoApresentacaoCommand command);
	public CommandResult handle(CadastrarTipoApresentacaoDoAlimentoGranelCommand command);
	public CommandResult handle(ExcluirTipoApresentacaoDoAlimentoGranelCommand command);
}
