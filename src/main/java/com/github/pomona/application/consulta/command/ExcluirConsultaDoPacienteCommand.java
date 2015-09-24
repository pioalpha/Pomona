package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

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
