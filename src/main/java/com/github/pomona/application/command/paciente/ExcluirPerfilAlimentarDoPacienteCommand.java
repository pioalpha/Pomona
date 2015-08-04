package com.github.pomona.application.command.paciente;

public class ExcluirPerfilAlimentarDoPacienteCommand {

	private String idPerfilAlimentarPaciente;

	public ExcluirPerfilAlimentarDoPacienteCommand(String idPerfilAlimentarPaciente) {
		super();
		this.idPerfilAlimentarPaciente = idPerfilAlimentarPaciente;
	}

	public String getIdPerfilAlimentarPaciente() {
		return idPerfilAlimentarPaciente;
	}
}
