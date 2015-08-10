package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.diretrizAlimentar.AdicionarNormaADiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.AtualizarNomeDaDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.AtualizarNormaDaDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.CadastrarDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.DesativarDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.ExcluirDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.ExcluirNormaDaDiretrizAlimentarCommand;

public interface DiretrizAlimentarCommandHandler {
	public CommandResult handle(AdicionarNormaADiretrizAlimentarCommand command);
	public CommandResult handle(AtualizarNomeDaDiretrizAlimentarCommand command);
	public CommandResult handle(AtualizarNormaDaDiretrizAlimentarCommand command);
	public CommandResult handle(CadastrarDiretrizAlimentarCommand command);
	public CommandResult handle(DesativarDiretrizAlimentarCommand command);
	public CommandResult handle(ExcluirDiretrizAlimentarCommand command);
	public CommandResult handle(ExcluirNormaDaDiretrizAlimentarCommand command);
}
