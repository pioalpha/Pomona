package com.github.pomona.application.divisaoRefeicao.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface DivisaoRefeicaoCommandHandler extends Serializable {
	public CommandResult handle(AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand command);
	public CommandResult handle(AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand command);
	public CommandResult handle(AtualizarNomeDaDivisaoRefeicaoCommand command);
	public CommandResult handle(CadastrarDivisaoRefeicaoCommand command);
	public CommandResult handle(ExcluirDivisaoRefeicaoCommand command);
	public CommandResult handle(ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand command);
}
