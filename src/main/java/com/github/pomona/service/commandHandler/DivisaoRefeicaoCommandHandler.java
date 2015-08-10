package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.divisaoRefeicao.AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.AtualizarNomeDaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.CadastrarDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.ExcluirDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand;

public interface DivisaoRefeicaoCommandHandler {
	public CommandResult handle(AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand command);
	public CommandResult handle(AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand command);
	public CommandResult handle(AtualizarNomeDaDivisaoRefeicaoCommand command);
	public CommandResult handle(CadastrarDivisaoRefeicaoCommand command);
	public CommandResult handle(ExcluirDivisaoRefeicaoCommand command);
	public CommandResult handle(ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand command);
}
