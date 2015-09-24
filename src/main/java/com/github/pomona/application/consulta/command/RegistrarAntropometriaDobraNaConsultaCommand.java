package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;
import com.github.pomona.domain.reference.TipoDobra;

public class RegistrarAntropometriaDobraNaConsultaCommand implements Command {
	private String consultaId;
	private TipoDobra tipoDobra;
	private float valor;
	
	public RegistrarAntropometriaDobraNaConsultaCommand(String consultaId, TipoDobra tipoDobra, float valor) {
		super();
		this.consultaId = consultaId;
		this.tipoDobra = tipoDobra;
		this.valor = valor;
	}
	
	public String getConsultaId() {
		return consultaId;
	}
	
	public TipoDobra getTipoDobra() {
		return tipoDobra;
	}
	
	public float getValor() {
		return valor;
	}
	
}
