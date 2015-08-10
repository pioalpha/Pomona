package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoCircunferencia;

public class RegistrarAntropometriaCircunferenciaNaConsultaCommand implements Command {
	private String idConsulta;
	private TipoCircunferencia tipoCircunferencia;
	private float valor;
	
	public RegistrarAntropometriaCircunferenciaNaConsultaCommand(String idConsulta, TipoCircunferencia tipoCircunferencia,
			float valor) {
		super();
		this.idConsulta = idConsulta;
		this.tipoCircunferencia = tipoCircunferencia;
		this.valor = valor;
	}
	
	public String getIdConsulta() {
		return idConsulta;
	}
	
	public TipoCircunferencia getTipoCircunferencia() {
		return tipoCircunferencia;
	}
	
	public float getValor() {
		return valor;
	}
	
}
