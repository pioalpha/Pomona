package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;

public class AtualizarFatorEnergeticoDaSubstanciaCommand implements Command {
	private String substanciaId;
	private float fatorEnergetico;
	
	public AtualizarFatorEnergeticoDaSubstanciaCommand(String substanciaId, float fatorEnergetico) {
		super();
		this.substanciaId = substanciaId;
		this.fatorEnergetico = fatorEnergetico;
	}
	
	public String getSubstanciaId() {
		return substanciaId;
	}
	
	public float getFatorEnergetico() {
		return fatorEnergetico;
	}
	
}
