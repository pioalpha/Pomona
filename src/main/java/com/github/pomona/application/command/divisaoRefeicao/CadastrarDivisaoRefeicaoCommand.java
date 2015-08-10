package com.github.pomona.application.command.divisaoRefeicao;

import com.github.common.service.command.Command;

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
