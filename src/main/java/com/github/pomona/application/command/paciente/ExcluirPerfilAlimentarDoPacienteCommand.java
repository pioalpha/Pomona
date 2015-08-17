package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;

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
