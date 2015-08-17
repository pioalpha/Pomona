package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;

public class CorrigirAlturaDoPacienteCommand implements Command {
	private String planoAlimentarId;
	private float altura;
	
	public CorrigirAlturaDoPacienteCommand(String planoAlimentarId, float altura) {
		super();
		this.planoAlimentarId = planoAlimentarId;
		this.altura = altura;
	}
	
	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}

	public float getAltura() {
		return altura;
	}
}
