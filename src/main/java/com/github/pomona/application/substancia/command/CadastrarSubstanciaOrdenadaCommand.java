package com.github.pomona.application.substancia.command;

import com.github.common.application.command.Command;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class CadastrarSubstanciaOrdenadaCommand implements Command {
	private String nome;
	private UnidadeSubstancia unidadeSubstancia;
	private int ordem;
	
	public CadastrarSubstanciaOrdenadaCommand(String nome, UnidadeSubstancia unidadeSubstancia, int ordem) {
		super();
		this.nome = nome;
		this.unidadeSubstancia = unidadeSubstancia;
		this.ordem = ordem;
	}
	
	public String getNome() {
		return nome;
	}
	
	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}
	
	public int getOrdem() {
		return ordem;
	}

}
