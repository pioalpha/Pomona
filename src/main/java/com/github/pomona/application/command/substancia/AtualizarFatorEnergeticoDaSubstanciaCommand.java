package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;

public class AtualizarFatorEnergeticoDaSubstanciaCommand implements Command {
	private String idSubstancia;
	private float fatorEnergetico;
	
	public AtualizarFatorEnergeticoDaSubstanciaCommand(String idSubstancia, float fatorEnergetico) {
		super();
		this.idSubstancia = idSubstancia;
		this.fatorEnergetico = fatorEnergetico;
	}
	
	public String getIdSubstancia() {
		return idSubstancia;
	}
	
	public float getFatorEnergetico() {
		return fatorEnergetico;
	}
	
}
