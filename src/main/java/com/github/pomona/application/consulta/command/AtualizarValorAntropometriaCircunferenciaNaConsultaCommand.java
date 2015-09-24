package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

public class AtualizarValorAntropometriaCircunferenciaNaConsultaCommand implements Command {
	private String antropometriaCircunferenciaId;
	private float valor;
	
	public AtualizarValorAntropometriaCircunferenciaNaConsultaCommand(String antropometriaCircunferenciaId,
			float valor) {
		super();
		this.antropometriaCircunferenciaId = antropometriaCircunferenciaId;
		this.valor = valor;
	}
	
	public String getAntropometriaCircunferenciaId() {
		return antropometriaCircunferenciaId;
	}
	
	public float getValor() {
		return valor;
	}
	
}
