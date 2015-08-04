package com.github.pomona.application.command.consulta;

import com.github.pomona.domain.model.FatorAtividadeFisica;

public class AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand {
	private String idConsulta;
	private FatorAtividadeFisica fatorAtividadeFisica;
	
	public AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand(String idConsulta,
			FatorAtividadeFisica fatorAtividadeFisica) {
		super();
		this.idConsulta = idConsulta;
		this.fatorAtividadeFisica = fatorAtividadeFisica;
	}
	
	public String getIdConsulta() {
		return idConsulta;
	}
	
	public FatorAtividadeFisica getFatorAtividadeFisica() {
		return fatorAtividadeFisica;
	}
	
}
