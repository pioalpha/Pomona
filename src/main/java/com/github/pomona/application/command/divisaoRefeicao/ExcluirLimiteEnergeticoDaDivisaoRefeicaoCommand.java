package com.github.pomona.application.command.divisaoRefeicao;

import com.github.common.service.command.Command;

public class ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand implements Command {
	private String idLimiteEnergetico;

	public ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand(String idLimiteEnergetico) {
		super();
		this.idLimiteEnergetico = idLimiteEnergetico;
	}

	public String getIdLimiteEnergetico() {
		return idLimiteEnergetico;
	}
	
}
