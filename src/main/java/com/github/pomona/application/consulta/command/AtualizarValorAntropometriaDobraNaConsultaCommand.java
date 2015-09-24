package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

public class AtualizarValorAntropometriaDobraNaConsultaCommand implements Command {
	private String antropometriaDobraId;
	private float valor;
	
	public AtualizarValorAntropometriaDobraNaConsultaCommand(String antropometriaDobraId, float valor) {
		super();
		this.antropometriaDobraId = antropometriaDobraId;
		this.valor = valor;
	}
	
	public String getAntropometriaDobraId() {
		return antropometriaDobraId;
	}
	
	public float getValor() {
		return valor;
	}
	
}
