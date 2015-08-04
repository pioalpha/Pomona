package com.github.pomona.application.command.substancia;

import com.github.pomona.domain.reference.UnidadeSubstancia;

public class CadastrarSubstanciaEnergeticaCommand {
	private String idSubstancia;
	private String nome;
	private UnidadeSubstancia unidadeSubstancia;
	private float fatorEnergetico;
	
	public CadastrarSubstanciaEnergeticaCommand(String idSubstancia, String nome, UnidadeSubstancia unidadeSubstancia,
			float fatorEnergetico) {
		super();
		this.idSubstancia = idSubstancia;
		this.nome = nome;
		this.unidadeSubstancia = unidadeSubstancia;
		this.fatorEnergetico = fatorEnergetico;
	}
	
	public String getIdSubstancia() {
		return idSubstancia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}
	
	public float getFatorEnergetico() {
		return fatorEnergetico;
	}
	
}
