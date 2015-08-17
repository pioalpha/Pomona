package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

public class ExcluirConsultaDoPacienteCommand implements Command {
	private String consultaId;

	public ExcluirConsultaDoPacienteCommand(String consultaId) {
		super();
		this.consultaId = consultaId;
	}

	public String getConsultaId() {
		return consultaId;
	}
	
}
