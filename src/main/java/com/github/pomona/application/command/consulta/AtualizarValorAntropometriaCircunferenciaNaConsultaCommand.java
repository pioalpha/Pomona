package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

public class AtualizarValorAntropometriaCircunferenciaNaConsultaCommand implements Command {
	private String idAntropometriaCircunferencia;
	private float valor;
	
	public AtualizarValorAntropometriaCircunferenciaNaConsultaCommand(String idAntropometriaCircunferencia,
			float valor) {
		super();
		this.idAntropometriaCircunferencia = idAntropometriaCircunferencia;
		this.valor = valor;
	}
	
	public String getIdAntropometriaCircunferencia() {
		return idAntropometriaCircunferencia;
	}
	
	public float getValor() {
		return valor;
	}
	
}
