package com.github.pomona.application.command.substancia;

import com.github.pomona.domain.reference.UnidadeSubstancia;

public class CadastrarSubstanciaComumCommand {
	private String nome;
	private UnidadeSubstancia unidadeSubstanccia;
	
	public CadastrarSubstanciaComumCommand(String nome, UnidadeSubstancia unidadeSubstanccia, int ordem) {
		super();
		this.nome = nome;
		this.unidadeSubstanccia = unidadeSubstanccia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public UnidadeSubstancia getUnidadeSubstanccia() {
		return unidadeSubstanccia;
	}
	
}
