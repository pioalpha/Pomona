package com.github.pomona.application.paciente.command;

import com.github.common.application.command.Command;

public class ExcluirPerfilAlimentarDoPacienteCommand implements Command {

	private String perfilAlimentarPacienteId;

	public ExcluirPerfilAlimentarDoPacienteCommand(String perfilAlimentarPacienteId) {
		super();
		this.perfilAlimentarPacienteId = perfilAlimentarPacienteId;
	}

	public String getPerfilAlimentarPacienteId() {
		return perfilAlimentarPacienteId;
	}
}
