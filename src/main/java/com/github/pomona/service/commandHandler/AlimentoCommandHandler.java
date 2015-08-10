package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.alimento.AdicionarComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.AtualizarNomeDoAlimentoCommand;
import com.github.pomona.application.command.alimento.AtualizarPorcaoDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.AtualizarQuantidadeComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.AtualizarUnidadeDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarAlimentoUnitarioCommand;
import com.github.pomona.application.command.alimento.ExcluirAlimentoCommand;
import com.github.pomona.application.command.alimento.ExcluirComponenteAlimentarCommand;

public interface AlimentoCommandHandler extends PreparoMedidaAlimentoCommandHandler{
	public CommandResult handle(AdicionarComponenteAlimentarCommand command);
	public CommandResult handle(AtualizarNomeDoAlimentoCommand command);
	public CommandResult handle(AtualizarPorcaoDoAlimentoGranelCommand command);
	public CommandResult handle(AtualizarQuantidadeComponenteAlimentarCommand command);
	public CommandResult handle(AtualizarUnidadeDoAlimentoGranelCommand command);
	public CommandResult handle(CadastrarAlimentoGranelCommand command);
	public CommandResult handle(CadastrarAlimentoUnitarioCommand command);
	public CommandResult handle(ExcluirAlimentoCommand command);
	public CommandResult handle(ExcluirComponenteAlimentarCommand command);
}
