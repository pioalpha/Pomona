package com.github.pomona.application.command.divisaoRefeicao;

import com.github.common.service.command.Command;

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
