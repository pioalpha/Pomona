package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;

public class CorrigirAlturaDoPacienteCommand implements Command {
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
