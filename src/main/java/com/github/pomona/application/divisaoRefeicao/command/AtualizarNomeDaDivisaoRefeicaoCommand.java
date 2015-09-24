package com.github.pomona.application.divisaoRefeicao.command;

import com.github.common.application.command.Command;

public class AtualizarNomeDaDivisaoRefeicaoCommand implements Command {
	private String divisaoRefeicaoId;
	private String nome;
	
	public AtualizarNomeDaDivisaoRefeicaoCommand(String divisaoRefeicaoId, String nome) {
		super();
		this.divisaoRefeicaoId = divisaoRefeicaoId;
		this.nome = nome;
	}
	
	public String getDivisaoRefeicaoId() {
		return divisaoRefeicaoId;
	}
	
	public String getNome() {
		return nome;
	}
	
}
