package com.github.pomona.application.substancia.command;

import com.github.common.application.command.Command;

public class AtualizarNomeDaSubstanciaCommand implements Command {
	private String substanciaId;
	private String nome;
	
	public AtualizarNomeDaSubstanciaCommand(String substanciaId, String nome) {
		super();
		this.substanciaId = substanciaId;
		this.nome = nome;
	}
	
	public String getSubstanciaId() {
		return substanciaId;
	}
	
	public String getNome() {
		return nome;
	}
	
}
