package com.github.pomona.application.command.consulta;

public class ExcluirConsultaDoPacienteCommand {
	private String idConsulta;

	public ExcluirConsultaDoPacienteCommand(String idConsulta) {
		super();
		this.idConsulta = idConsulta;
	}

	public String getIdConsulta() {
		return idConsulta;
	}
	
}
