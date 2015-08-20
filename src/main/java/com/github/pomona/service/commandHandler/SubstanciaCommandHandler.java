package com.github.pomona.service.commandHandler;

import java.io.Serializable;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.substancia.AtualizarFatorEnergeticoDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.AtualizarNomeDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.AtualizarUnidadeDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaComumCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaEnergeticaCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaOrdenadaCommand;
import com.github.pomona.application.command.substancia.ExcluirSubstanciaCommand;
import com.github.pomona.application.command.substancia.PriorizarOrdemDaSubstanciaCommand;

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
