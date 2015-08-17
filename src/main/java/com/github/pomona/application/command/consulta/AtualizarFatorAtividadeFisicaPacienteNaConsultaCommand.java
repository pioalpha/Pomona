package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;
import com.github.pomona.domain.model.FatorAtividadeFisica;

public class AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand implements Command {
	private String consultaId;
	private FatorAtividadeFisica fatorAtividadeFisica;
	
	public AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand(String consultaId,
			FatorAtividadeFisica fatorAtividadeFisica) {
		super();
		this.consultaId = consultaId;
		this.fatorAtividadeFisica = fatorAtividadeFisica;
	}
	
	public String getConsultaId() {
		return consultaId;
	}
	
	public FatorAtividadeFisica getFatorAtividadeFisica() {
		return fatorAtividadeFisica;
	}
	
}
