package com.github.pomona.application.divisaoRefeicao.command;

import com.github.common.application.command.Command;

public class CadastrarDivisaoRefeicaoCommand implements Command {
	private String nome;

	public CadastrarDivisaoRefeicaoCommand(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
