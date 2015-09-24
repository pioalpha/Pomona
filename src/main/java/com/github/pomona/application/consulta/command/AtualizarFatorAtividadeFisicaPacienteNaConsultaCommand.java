package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

public class AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand implements Command {
	private String consultaId;
	private String fatorAtividadeFisicaId;
	
	public AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand(String consultaId,
			String fatorAtividadeFisicaId) {
		super();
		this.consultaId = consultaId;
		this.fatorAtividadeFisicaId = fatorAtividadeFisicaId;
	}
	
	public String getConsultaId() {
		return consultaId;
	}
	
	public String getFatorAtividadeFisicaId() {
		return fatorAtividadeFisicaId;
	}
	
}
