package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;

public class AtualizarNomeDaSubstanciaCommand implements Command {
	private String idSubstancia;
	private String nome;
	
	public AtualizarNomeDaSubstanciaCommand(String idSubstancia, String nome) {
		super();
		this.idSubstancia = idSubstancia;
		this.nome = nome;
	}
	
	public String getIdSubstancia() {
		return idSubstancia;
	}
	
	public String getNome() {
		return nome;
	}
	
}
