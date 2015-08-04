package com.github.pomona.application.command.consulta;

import com.github.pomona.domain.reference.TipoDobra;

public class RegistrarAntropometriaDobraNaConsultaCommand {
	private String idConsulta;
	private TipoDobra tipoDobra;
	private float valor;
	
	public RegistrarAntropometriaDobraNaConsultaCommand(String idConsulta, TipoDobra tipoDobra, float valor) {
		super();
		this.idConsulta = idConsulta;
		this.tipoDobra = tipoDobra;
		this.valor = valor;
	}
	
	public String getIdConsulta() {
		return idConsulta;
	}
	
	public TipoDobra getTipoDobra() {
		return tipoDobra;
	}
	
	public float getValor() {
		return valor;
	}
	
}
