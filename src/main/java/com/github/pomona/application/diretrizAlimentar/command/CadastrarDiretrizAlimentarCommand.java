package com.github.pomona.application.diretrizAlimentar.command;

import com.github.common.application.command.Command;

public class CadastrarDiretrizAlimentarCommand implements Command {
	private String nome;

	public CadastrarDiretrizAlimentarCommand(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
