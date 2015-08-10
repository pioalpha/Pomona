package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;

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
