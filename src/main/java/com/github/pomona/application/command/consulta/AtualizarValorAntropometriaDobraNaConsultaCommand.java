package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

public class AtualizarValorAntropometriaDobraNaConsultaCommand implements Command {
	private String idAntropometriaDobra;
	private float valor;
	
	public AtualizarValorAntropometriaDobraNaConsultaCommand(String idAntropometriaDobra, float valor) {
		super();
		this.idAntropometriaDobra = idAntropometriaDobra;
		this.valor = valor;
	}
	
	public String getIdAntropometriaDobra() {
		return idAntropometriaDobra;
	}
	
	public float getValor() {
		return valor;
	}
	
}
