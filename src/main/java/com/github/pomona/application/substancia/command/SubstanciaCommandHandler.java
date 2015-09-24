package com.github.pomona.application.substancia.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;
import com.github.pomona.application.diretrizAlimentar.command.DiretrizAlimentarCommandHandler;

public interface SubstanciaCommandHandler extends DiretrizAlimentarCommandHandler, Serializable {
	public CommandResult handle(AtualizarFatorEnergeticoDaSubstanciaCommand command);
	public CommandResult handle(AtualizarNomeDaSubstanciaCommand command);
	public CommandResult handle(AtualizarUnidadeDaSubstanciaCommand command);
	public CommandResult handle(CadastrarSubstanciaComumCommand command);
	public CommandResult handle(CadastrarSubstanciaOrdenadaCommand command);
	public CommandResult handle(CadastrarSubstanciaEnergeticaCommand command);
	public CommandResult handle(ExcluirSubstanciaCommand command);
	public CommandResult handle(PriorizarOrdemDaSubstanciaCommand command);
}
