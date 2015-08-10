package com.github.pomona.application.command.divisaoRefeicao;

import com.github.common.service.command.Command;

public class ExcluirDivisaoRefeicaoCommand implements Command {
	private String idDivisaoRefeicao;

	public ExcluirDivisaoRefeicaoCommand(String idDivisaoRefeicao) {
		super();
		this.idDivisaoRefeicao = idDivisaoRefeicao;
	}

	public String getIdDivisaoRefeicao() {
		return idDivisaoRefeicao;
	}
	
}
