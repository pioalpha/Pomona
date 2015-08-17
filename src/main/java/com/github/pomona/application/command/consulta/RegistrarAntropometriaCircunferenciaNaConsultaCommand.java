package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoCircunferencia;

public class RegistrarAntropometriaCircunferenciaNaConsultaCommand implements Command {
	private String consultaId;
	private TipoCircunferencia tipoCircunferencia;
	private float valor;
	
	public RegistrarAntropometriaCircunferenciaNaConsultaCommand(String consultaId, TipoCircunferencia tipoCircunferencia,
			float valor) {
		super();
		this.consultaId = consultaId;
		this.tipoCircunferencia = tipoCircunferencia;
		this.valor = valor;
	}
	
	public String getConsultaId() {
		return consultaId;
	}
	
	public TipoCircunferencia getTipoCircunferencia() {
		return tipoCircunferencia;
	}
	
	public float getValor() {
		return valor;
	}
	
}
