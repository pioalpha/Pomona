package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.paciente.AdicionarPerfilAlimentarAoPacienteCommand;
import com.github.pomona.application.command.paciente.AdicionarPerfilCategoriaAlimentarAoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarCorPeleDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarNomeDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarPerfilAlimentarDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarSexoDoPacienteCommand;
import com.github.pomona.application.command.paciente.CorrigirDataNascimentoDoPacienteCommand;
import com.github.pomona.application.command.paciente.CriarPlanoAlimentarDoPacienteCommand;
import com.github.pomona.application.command.paciente.ExcluirPerfilAlimentarDoPacienteCommand;

public interface PacienteCommandHandler {
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
