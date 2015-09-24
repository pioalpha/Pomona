package com.github.pomona.application.alimento.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface AlimentoCommandHandler extends ApresentacaoMedidaAlimentoCommandHandler, Serializable{
	public CommandResult handle(AdicionarComponenteAlimentarCommand command);
	public CommandResult handle(AtualizarCategoriaDoAlimentoCommand command);
	public CommandResult handle(AtualizarNomeDoAlimentoCommand command);
	public CommandResult handle(AtualizarPorcaoDoAlimentoGranelCommand command);
	public CommandResult handle(AtualizarQuantidadeComponenteAlimentarCommand command);
	public CommandResult handle(AtualizarUnidadeDoAlimentoGranelCommand command);
	public CommandResult handle(AtualizarCategoriaAlimentarCommand command);
	public CommandResult handle(CadastrarAlimentoGranelCommand command);
	public CommandResult handle(CadastrarAlimentoUnitarioCommand command);
	public CommandResult handle(CadastrarCategoriaAlimentarCommand command);
	public CommandResult handle(ExcluirAlimentoCommand command);
	public CommandResult handle(ExcluirComponenteAlimentarCommand command);
}
