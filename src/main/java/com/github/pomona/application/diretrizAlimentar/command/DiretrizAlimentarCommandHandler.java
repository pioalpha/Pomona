package com.github.pomona.application.diretrizAlimentar.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface DiretrizAlimentarCommandHandler extends Serializable {
	public CommandResult handle(AdicionarNormaADiretrizAlimentarCommand command);
	public CommandResult handle(AtualizarNomeDaDiretrizAlimentarCommand command);
	public CommandResult handle(AtualizarNormaDaDiretrizAlimentarCommand command);
	public CommandResult handle(CadastrarDiretrizAlimentarCommand command);
	public CommandResult handle(DesativarDiretrizAlimentarCommand command);
	public CommandResult handle(ExcluirDiretrizAlimentarCommand command);
	public CommandResult handle(ExcluirNormaDaDiretrizAlimentarCommand command);
}
