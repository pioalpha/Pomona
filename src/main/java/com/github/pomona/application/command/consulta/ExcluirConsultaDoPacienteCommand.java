package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

public class ExcluirConsultaDoPacienteCommand implements Command {
	private String idConsulta;

	public ExcluirConsultaDoPacienteCommand(String idConsulta) {
		super();
		this.idConsulta = idConsulta;
	}

	public String getIdConsulta() {
		return idConsulta;
	}
	
}
