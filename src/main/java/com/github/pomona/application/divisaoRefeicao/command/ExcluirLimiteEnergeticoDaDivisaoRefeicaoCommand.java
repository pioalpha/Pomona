package com.github.pomona.application.divisaoRefeicao.command;

import com.github.common.application.command.Command;

public class ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand implements Command {
	private String limiteEnergeticoId;

	public ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand(String limiteEnergeticoId) {
		super();
		this.limiteEnergeticoId = limiteEnergeticoId;
	}

	public String getLimiteEnergeticoId() {
		return limiteEnergeticoId;
	}
	
}
