package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

public class AtualizarPesoPacienteNaConsulta implements Command {
	private String consultaId;
	private float peso;
	
	public AtualizarPesoPacienteNaConsulta(String consultaId, float peso) {
		super();
		this.consultaId = consultaId;
		this.peso = peso;
	}
	
	public String getConsultaId() {
		return consultaId;
	}
	
	public float getPeso() {
		return peso;
	}
	
}
