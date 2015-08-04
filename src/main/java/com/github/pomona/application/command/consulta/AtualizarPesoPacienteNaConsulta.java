package com.github.pomona.application.command.consulta;

public class AtualizarPesoPacienteNaConsulta {
	private String idConsulta;
	private float peso;
	
	public AtualizarPesoPacienteNaConsulta(String idConsulta, float peso) {
		super();
		this.idConsulta = idConsulta;
		this.peso = peso;
	}
	
	public String getIdConsulta() {
		return idConsulta;
	}
	
	public float getPeso() {
		return peso;
	}
	
}
