package com.github.pomona.application.command.divisaoRefeicao;

import com.github.common.service.command.Command;

public class ExcluirDivisaoRefeicaoCommand implements Command {
	private String divisaoRefeicaoId;

	public ExcluirDivisaoRefeicaoCommand(String divisaoRefeicaoId) {
		super();
		this.divisaoRefeicaoId = divisaoRefeicaoId;
	}

	public String getDivisaoRefeicaoId() {
		return divisaoRefeicaoId;
	}
	
}
