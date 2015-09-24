package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

public class AtualizarAntropometriaPesoAlturaNaConsultaCommand implements Command {
	private String consultaId;
	private float peso;
	private float altura;

	public AtualizarAntropometriaPesoAlturaNaConsultaCommand(String consultaId, float peso, float altura) {
		super();
		this.consultaId = consultaId;
		this.peso = peso;
		this.altura = altura;
	}

	public String getConsultaId() {
		return consultaId;
	}

	public float getPeso() {
		return peso;
	}

	public float getAltura() {
		return altura;
	}

}
