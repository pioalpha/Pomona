package com.github.pomona.application.divisaoRefeicao.command;

import com.github.common.application.command.Command;

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
