package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class CadastrarAlimentoUnitarioCommand implements Command {
	private String nome;

	public CadastrarAlimentoUnitarioCommand(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
