package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;

public class AtualizarFatorEnergeticoDaSubstanciaCommand implements Command {
	private String substanciaId;
	private Float fatorEnergetico;
	
	public AtualizarFatorEnergeticoDaSubstanciaCommand(String substanciaId, Float fatorEnergetico) {
		super();
		
		this.substanciaId = substanciaId;
		this.fatorEnergetico = fatorEnergetico;
	}
	
	public String getSubstanciaId() {
		return substanciaId;
	}
	
	public Float getFatorEnergetico() {
		return fatorEnergetico;
	}
	
}
