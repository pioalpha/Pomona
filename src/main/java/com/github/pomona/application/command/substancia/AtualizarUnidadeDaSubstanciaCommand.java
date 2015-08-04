package com.github.pomona.application.command.substancia;

import com.github.pomona.domain.reference.UnidadeSubstancia;

public class AtualizarUnidadeDaSubstanciaCommand {
	private String idSubstancia;
	private UnidadeSubstancia unidadeSubstancia;
	
	public AtualizarUnidadeDaSubstanciaCommand(String idSubstancia, UnidadeSubstancia unidadeSubstancia) {
		super();
		this.idSubstancia = idSubstancia;
		this.unidadeSubstancia = unidadeSubstancia;
	}
	
	public String getIdSubstancia() {
		return idSubstancia;
	}
	
	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}
	
}
