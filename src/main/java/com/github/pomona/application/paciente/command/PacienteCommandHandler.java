package com.github.pomona.application.paciente.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;

public interface PacienteCommandHandler extends Serializable {
	public CommandResult handle(AdicionarPerfilAlimentarAoPacienteCommand command);
	public CommandResult handle(AdicionarPerfilCategoriaAlimentarAoPacienteCommand command);
	public CommandResult handle(AtualizarCorPeleDoPacienteCommand command);
	public CommandResult handle(AtualizarNomeDoPacienteCommand command);
	public CommandResult handle(AtualizarPerfilAlimentarDoPacienteCommand command);
	public CommandResult handle(AtualizarSexoDoPacienteCommand command);
	public CommandResult handle(CorrigirDataNascimentoDoPacienteCommand command);
	public CommandResult handle(CriarPlanoAlimentarDoPacienteCommand command);
	public CommandResult handle(ExcluirPerfilAlimentarDoPacienteCommand command);
}
