package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;

public class ExcluirPerfilAlimentarDoPacienteCommand implements Command {

	private String idPerfilAlimentarPaciente;

	public ExcluirPerfilAlimentarDoPacienteCommand(String idPerfilAlimentarPaciente) {
		super();
		this.idPerfilAlimentarPaciente = idPerfilAlimentarPaciente;
	}

	public String getIdPerfilAlimentarPaciente() {
		return idPerfilAlimentarPaciente;
	}
}
