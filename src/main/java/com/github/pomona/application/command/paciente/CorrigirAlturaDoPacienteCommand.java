package com.github.pomona.application.command.paciente;

public class CorrigirAlturaDoPacienteCommand {
	private String idPlanoAlimentar;
	private float altura;
	
	public CorrigirAlturaDoPacienteCommand(String idPlanoAlimentar, float altura) {
		super();
		this.idPlanoAlimentar = idPlanoAlimentar;
		this.altura = altura;
	}
	
	public String getIdPlanoAlimentar() {
		return idPlanoAlimentar;
	}

	public float getAltura() {
		return altura;
	}
}
