package com.github.pomona.application.command.substancia;

public class AtualizarFatorEnergeticoDaSubstanciaCommand {
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
