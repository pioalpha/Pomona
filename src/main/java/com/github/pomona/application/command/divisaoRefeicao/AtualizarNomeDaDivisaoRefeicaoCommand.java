package com.github.pomona.application.command.divisaoRefeicao;

import com.github.common.service.command.Command;

public class AtualizarNomeDaDivisaoRefeicaoCommand implements Command {
	private String idDivisaoRefeicao;
	private String nome;
	
	public AtualizarNomeDaDivisaoRefeicaoCommand(String idDivisaoRefeicao, String nome) {
		super();
		this.idDivisaoRefeicao = idDivisaoRefeicao;
		this.nome = nome;
	}
	
	public String getIdDivisaoRefeicao() {
		return idDivisaoRefeicao;
	}
	
	public String getNome() {
		return nome;
	}
	
}
